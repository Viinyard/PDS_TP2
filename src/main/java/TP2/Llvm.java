package TP2;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Llvm {

	static int lvl = 0;

	public static class IR {
		List<Instruction> header;
		List<Instruction> code;

		public IR(List<Instruction> header, List<Instruction> code) {
			this.header = header;
			this.code = code;
		}

		public IR append(IR other) {
			this.header.addAll(other.header);
			this.code.addAll(other.code);
			return this;
		}

		public IR appendOuter(IR other) {
			this.header.addAll(other.header);
			this.header.addAll(other.code);
			return this;
		}

		public IR appendCode(Instruction inst) {
			this.code.add(inst);
			return this;
		}

		public IR appendHeader(Instruction inst) {
			this.header.add(inst);
			return this;
		}

		public String toString() {
			StringBuilder r = new StringBuilder("; Target\n" + "target triple = \"x86_64-apple-macosx10.12.0\"\n"
					+ "; External declaration of the printf function\n"
					+ "declare i32 @printf(i8* noalias nocapture, ...)\n"
					+ "declare i32 @scanf(i8* noalias nocapture, ...)\n" + "\n; Actual code begins\n\n");

			for (Instruction inst : this.header)
				r.append(inst);

			r.append("\n");

			for (Instruction inst : this.code)
				r.append(inst);

			return r.toString();
		}
	}

	public static List<Instruction> empty() {
		return new ArrayList<Instruction>();
	}

	public static abstract class Instruction {

		protected int level;

		public Instruction() {
			this.level = Llvm.lvl;
		}

		public abstract String toString();
	}

	/*
	 * FONCTION
	 */

	// OK
	public static class ArrayElement extends Instruction {

		private Variable result, variable, start, index;

		public ArrayElement(Variable result, Variable variable, Variable start, Variable index) {
			super();
			assert (variable.type instanceof PointerType);
			this.result = result;
			this.variable = variable;
			this.start = start;
			this.index = index;
		}

		@Override
		public String toString() {
			StringBuilder ret = new StringBuilder(Utils.indent(this.level) + this.result.ident + " = getelementptr inbounds "
					+ ((PointerType) this.variable.type).type + ", " + this.variable);
			if(this.start != null)  {
				ret.append(", " + this.start); 
			}
			ret.append(", " + this.index + "\n");
			return ret.toString();
		}
	}

	public static class Fonction extends Instruction {

		private Variable fonction;
		private List<Variable> args;

		public Fonction(Variable fonction, List<Variable> args) {
			super();
			this.fonction = fonction;
			this.args = args;
		}

		public String toString() {
			StringBuilder ret = new StringBuilder(
					Utils.indent(this.level) + "define " + this.fonction.type + " " + this.fonction.ident + "(");

			for (int i = 0; i < this.args.size(); i++) {
				ret.append(this.args.get(i).type);
				if (i < this.args.size() - 1) {
					ret.append(", ");
				}
			}

			ret.append(") ");
			return ret.toString();
		}
	}

	public static class OpenBlock extends Instruction {

		public OpenBlock() {
			super();
			Llvm.lvl++;
		}

		@Override
		public String toString() {
			return Utils.indent(this.level) + "{\n";
		}

	}

	public static class OpenLabelBlock extends Instruction {

		public OpenLabelBlock() {
			super();
			Llvm.lvl++;
		}

		@Override
		public String toString() {
			return "";
		}

	}

	public static class CloseLabelBlock extends Instruction {

		public CloseLabelBlock() {
			super();
			Llvm.lvl--;
		}

		@Override
		public String toString() {
			return "";
		}

	}

	public static class CloseBlock extends Instruction {

		public CloseBlock() {
			this.level = --Llvm.lvl;
		}

		@Override
		public String toString() {
			return Utils.indent(this.level) + "}\n\n";
		}

	}

	// OK
	public static class CallFonction extends Instruction {

		Variable fonction;
		List<Variable> args;
		String cast;
		Optional<Variable> result;

		public CallFonction(Variable fonction, Variable result, List<Variable> args) {
			this(fonction, "", result, args);
		}

		public CallFonction(Variable fonction, String cast, Variable result, List<Variable> args) {
			super();
			this.result = Optional.ofNullable(result);
			if(this.result.isPresent()) {
				assert (this.fonction.type.equals(this.result.get().type));
			}
			this.fonction = fonction;
			this.args = args;
			this.cast = cast;
		}

		@Override
		public String toString() {
			StringBuilder ret = new StringBuilder();
			ret.append(Utils.indent(this.level));
			
			this.result.ifPresent(r -> ret.append(r.ident + " = "));

			ret.append("call ");

			ret.append(this.fonction.type + " ");
			if(this.cast.length() > 0) {
				ret.append(this.cast + " ");
			}
			ret.append(this.fonction.ident + "(");

			for (int i = 0; i < this.args.size(); i++) {
				ret.append(this.args.get(i));
				if (i < this.args.size() - 1) {
					ret.append(", ");
				}
			}

			ret.append(")\n");

			return ret.toString();
		}
	}

	// OK
	public static class Return extends Instruction {

		private Variable variable;

		public Return(Variable variable) {
			super();
			this.variable = variable;
		}

		public String toString() {
			return Utils.indent(this.level) + "ret " + this.variable + "\n";
		}
	}

	/*
	 * VARIABLES
	 */

	// OK
	public static class Load extends Instruction {

		private Variable pointer, value;

		public Load(Variable pointer, Variable value) {
			super();
			assert (pointer.type instanceof PointerType);
			this.pointer = pointer;
			this.value = value;
		}

		@Override
		public String toString() {
			return Utils.indent(this.level) + this.value.ident + " = load " + this.value.type + ", " + this.pointer
					+ "\n";
		}
	}

	// OK
	public static class StringConstant extends Instruction {

		Variable variable;
		String value;

		public StringConstant(Variable variable, String value) {
			super();
			assert (variable.type instanceof PointerType);
			this.variable = variable;
			this.value = value;
		}

		@Override
		public String toString() {
			return this.variable.ident + " = private unnamed_addr constant " + ((PointerType) this.variable.type).type
					+ "c" + this.value + ", align " + this.variable.type.align + "\n";
		}
	}

	// OK
	public static class Variable extends Instruction {

		Type type;
		String ident;

		public Variable(int scope, Type type, String ident) {
			super();
			this.type = type;
			this.ident = ident;
		}

		@Override
		public String toString() {
			return this.type + " " + this.ident;
		}
	}

	// OK
	public static class Affectation extends Instruction {

		Variable variable, value;

		public Affectation(Variable variable, Variable value) {
			super();
			assert (variable.type instanceof PointerType);
			this.variable = variable;
			this.value = value;
		}

		@Override
		public String toString() {
			return Utils.indent(this.level) + "store " + this.value + ", " + this.variable + "\n";
		}

	}

	// OK
	public static class Instanciation extends Instruction {

		private Variable variable;

		public Instanciation(Variable variable) {
			super();
			assert (variable.type instanceof PointerType);
			this.variable = variable;
		}

		@Override
		public String toString() {
			PointerType type = (PointerType) this.variable.type;
			return Utils.indent(this.level) + this.variable.ident + " = alloca " + type.type + "\n";
		}
	}

	/*
	 * LABEL - JUMP
	 */

	// OK
	public static class ICMP extends Instruction {

		private Variable value, left, right;
		private Cond op;

		public ICMP(Variable value, Variable left, Cond op, Variable right) {
			super();
			assert (value.type instanceof BooleanType); // can accept boolean vector too : not implemented yet
			assert (left.type.equals(right.type));
			this.value = value;
			this.left = left;
			this.op = op;
			this.right = right;
		}

		@Override
		public String toString() {
			return Utils.indent(this.level) + this.value.ident + " = icmp " + this.op + " " + this.left + ", "
					+ this.right.ident + "\n";
		}
	}

	// OK
	public static class BR extends Instruction {

		Variable label;

		public BR(Variable label) {
			super();
			assert (label.type instanceof LabelType);
			this.label = label;
		}

		@Override
		public String toString() {
			return Utils.indent(this.level) + "br " + this.label + "\n";
		}
	}

	// OK
	public static class Label extends Instruction {

		private Variable label;

		public Label(Variable label) {
			super();
			assert (label.type instanceof LabelType);
			this.label = label;
		}

		@Override
		public String toString() {
			return Utils.indent(this.level - 1) + this.label.ident.substring(1) + ":" + "\n";
		}
	}

	// OK
	public static class BRCond extends Instruction {

		private Variable cond, labelTrue, labelFalse;

		public BRCond(Variable cond, Variable labelTrue, Variable labelFalse) {
			super();
			assert (cond.type instanceof BooleanType);
			assert (labelTrue.type instanceof LabelType);
			assert (labelFalse.type instanceof LabelType);
			this.cond = cond;
			this.labelTrue = labelTrue;
			this.labelFalse = labelFalse;
		}

		@Override
		public String toString() {
			return Utils.indent(this.level) + "br " + this.cond + ", " + this.labelTrue + ", " + this.labelFalse + "\n";
		}
	}

	/*
	 * OPERAND
	 */

	// OK
	public static abstract class Cond {
		public abstract String toString();
	}

	// OK
	public static class DifferentOperand extends Cond {

		@Override
		public String toString() {
			return "ne";
		}
	}

	// OK
	public static class EqualOperand extends Cond {

		@Override
		public String toString() {
			return "eq";
		}
	}

	// OK
	public static class GreaterThanOperand extends Cond {

		@Override
		public String toString() {
			return "ugt";
		}
	}

	// OK
	public static class LessThanOperand extends Cond {

		@Override
		public String toString() {
			return "ult";
		}
	}

	// OK
	public static class GreaterThanOrEqualOperand extends Cond {

		@Override
		public String toString() {
			return "uge";
		}
	}

	// OK
	public static class LessThanOrEqualOperand extends Cond {

		@Override
		public String toString() {
			return "ule";
		}
	}

	/*
	 * Eval Expression
	 */

	// OK
	public static class Div extends Instruction {

		private Variable variable;
		private String left, right;

		public Div(Variable variable, String left, String right) {
			super();
			this.variable = variable;
			this.left = left;
			this.right = right;
		}

		public String toString() {
			return Utils.indent(this.level) + this.variable.ident + " = udiv " + this.variable.type + " " + this.left
					+ ", " + this.right + "\n";
		}
	}

	// OK
	public static class Add extends Instruction {

		private Variable variable;
		private String left, right;

		public Add(Variable variable, String left, String right) {
			super();
			this.variable = variable;
			this.left = left;
			this.right = right;
		}

		public String toString() {
			return Utils.indent(this.level) + this.variable.ident + " = add " + this.variable.type + " " + this.left
					+ ", " + this.right + "\n";
		}
	}

	// OK
	public static class Mul extends Instruction {

		private Variable variable;
		private String left, right;

		public Mul(Variable variable, String left, String right) {
			super();
			this.variable = variable;
			this.left = left;
			this.right = right;
		}

		public String toString() {
			return Utils.indent(this.level) + this.variable.ident + " = mul " + this.variable.type + " " + this.left
					+ ", " + this.right + "\n";
		}
	}

	// OK
	public static class Sub extends Instruction {

		private Variable variable;
		private String left, right;

		public Sub(Variable variable, String left, String right) {
			super();
			this.variable = variable;
			this.left = left;
			this.right = right;
		}

		public String toString() {
			return Utils.indent(this.level) + this.variable.ident + " = sub " + this.variable.type + " " + this.left
					+ ", " + this.right + "\n";
		}
	}

	/*
	 * TYPES
	 */

	// OK
	public static abstract class Type {

		int align;

		public Type(int align) {
			this.align = align;
		}

		public abstract String toString();
	}

	// OK
	public static class PointerType extends Type {

		Type type;

		public PointerType(Type type) {
			super(type.align);
			this.type = type;
		}

		@Override
		public String toString() {
			return this.type + "*";
		}
	}

	// OK
	public static class LabelType extends Type {

		public LabelType() {
			super(0);
		}

		@Override
		public String toString() {
			return "label";
		}

	}

	// OK
	public static class CharType extends Type {

		public CharType() {
			super(1);
		}

		@Override
		public String toString() {
			return "i8";
		}
	}

	// OK
	public static class BooleanType extends Type {

		public BooleanType() {
			super(1);
		}

		@Override
		public String toString() {
			return "i1";
		}
	}

	// OK
	public static class IntType extends Type {

		public IntType() {
			super(2);
		}

		@Override
		public String toString() {
			return "i32";
		}
	}

	// OK
	public static class VoidType extends Type {

		public VoidType() {
			super(0);
		}

		@Override
		public String toString() {
			return "void";
		}
	}

	// OK
	public static class ArrayType extends Type {

		public Type type;
		public String size;

		public ArrayType(Type type, String size) {
			super(type.align);
			assert (type instanceof PointerType);
			this.type = type;
			this.size = size;
		}

		@Override
		public String toString() {
			return "[" + this.size + " x " + ((PointerType) this.type).type + "]";
		}
	}
}