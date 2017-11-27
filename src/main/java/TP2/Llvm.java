package TP2;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

public class Llvm {

	static int lvl = 0;

	public static class IR {
		LinkedList<Instruction> global;
		LinkedList<Instruction> code;
		LinkedList<Instruction> header;

		public IR(LinkedList<Instruction> global, LinkedList<Instruction> code, LinkedList<Instruction> header) {
			this.global = global;
			this.code = code;
			this.header = header;
		}

		public IR() {
			this(Llvm.empty(), Llvm.empty(), Llvm.empty());
		}
		
		public IR appendGlobal(Instruction inst) {
			this.global.add(inst);
			return this;
		}
		
		
		public IR append(IR other) {
			this.global.addAll(other.global);
			this.header.addAll(other.header);
			this.code.addAll(other.code);
			return this;
		}


		public void linkFonction() {
			LinkedList<Instruction> fonction = new LinkedList<Instruction>();
			fonction.addAll(this.header);
			fonction.addAll(this.code);
			
			Instruction parent = null;
			
			for(Instruction i : fonction) {
				i.setParent(parent);
				parent = i;
			}
			
			this.header.clear();
			this.code = fonction;
		}
		
		public IR appendCode(Instruction inst) {
//			if(this.code.isEmpty()) {
//				if(!this.header.isEmpty()) {
//					inst.setParent(this.header.getLast());
//				}
//			} else {
//				inst.setParent(this.code.getLast());
//			}
			this.code.add(inst);
			return this;
		}
		
		public IR appendHeader(Instruction inst) {
//			Instruction parent = null;
//			if(!this.header.isEmpty()) {
//				parent = this.header.getLast();
//			}
//			inst.setParent(parent);
//			Instruction soon = null;
//			if(!this.code.isEmpty()) {
//				soon = this.code.getFirst();
//			}
//			if(soon != null) {
//				soon.setParent(inst);
//			}
			this.header.add(inst);
			return this;
		}

		public String toString() {
			StringBuilder r = new StringBuilder("; Target\n" + "target triple = \"x86_64-apple-macosx10.12.0\"\n"
					+ "; External declaration of the printf function\n"
					+ "declare i32 @printf(i8* noalias nocapture, ...)\n"
					+ "declare i32 @scanf(i8* noalias nocapture, ...)\n" + "\n; Actual code begins\n\n");

			for (Instruction inst : this.global)
				r.append(inst);

			r.append("\n");
			
			

			for (Instruction inst : this.code)
				r.append(inst);

			return r.toString();
		}
	}

	public static LinkedList<Instruction> empty() {
		return new LinkedList<Instruction>();
	}
	
	public static abstract class Instruction {

		private Instruction pred = null;
		protected int level;
		int cpt;
		
		public Instruction(Variable result, int cpt) {
			this.level = Llvm.lvl;
			this.cpt = cpt;
			if(result != null) result.setParent(this);
		}
		
		public void setParent(Instruction parent) {
			this.pred = parent;
		}
		
		public int getCpt() {
			if(this.pred == null) {
				return -1;
			}
			return this.pred.getCpt() + this.cpt;
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
			super(result, 1);
			assert (variable.type instanceof PointerType);
			result.setParent(this);
			this.result = result;
			this.variable = variable;
			this.start = start;
			this.index = index;
		}

		@Override
		public String toString() {
			StringBuilder ret = new StringBuilder(Utils.indent(this.level) + this.result.getValue() + " = getelementptr inbounds "
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
			super(null, 1);
			this.fonction = fonction;
			this.args = args;
		}

		public String toString() {
			StringBuilder ret = new StringBuilder(
					Utils.indent(this.level) + "define " + this.fonction.type + " " + this.fonction.getValue() + "(");

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
			super(null, 0);
			Llvm.lvl++;
		}

		@Override
		public String toString() {
			return Utils.indent(this.level) + "{\n";
		}

	}

	public static class OpenLabelBlock extends Instruction {

		public OpenLabelBlock() {
			super(null, 0);
			Llvm.lvl++;
		}

		@Override
		public String toString() {
			return "";
		}

	}

	public static class CloseLabelBlock extends Instruction {

		public CloseLabelBlock() {
			super(null, 0);
			Llvm.lvl--;
		}

		@Override
		public String toString() {
			return "";
		}

	}

	public static class CloseBlock extends Instruction {

		public CloseBlock() {
			super(null, 0);
			this.level = --Llvm.lvl;
		}

		@Override
		public String toString() {
			return Utils.indent(this.level) + "}\n\n";
		}

	}

	public static class Argument extends Instruction {

		public Argument(Variable arg) {
			super(arg, 1);
		}
		
		@Override
		public String toString() {
			return ""; // nothing to print
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
			super(result, (result == null) ? 0 : 1);
			this.result = Optional.ofNullable(result);
			if(this.result.isPresent()) {
				this.result.get().setParent(this);
			}
			this.fonction = fonction;
			this.args = args;
			this.cast = cast;
		}

		@Override
		public String toString() {
			StringBuilder ret = new StringBuilder();
			ret.append(Utils.indent(this.level));
			
			this.result.ifPresent(r -> ret.append(r.getValue() + " = "));

			ret.append("call ");

			ret.append(this.fonction.type + " ");
			if(this.cast.length() > 0) {
				ret.append(this.cast + " ");
			}
			ret.append(this.fonction.getValue() + "(");

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
			super(null, 0);
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

		private Variable pointer, result;

		public Load(Variable pointer, Variable result) {
			super(result, 1);
			
			this.pointer = pointer;
			this.result = result;
			
		}

		@Override
		public String toString() {
			return Utils.indent(this.level) + this.result.getValue() + " = load " + this.result.type + ", " + this.pointer.type + " "+ this.pointer.getValue()
					+ "\n";
		}
	}

	// OK
	public static class StringConstant extends Instruction {

		Variable result;
		String value;

		public StringConstant(Variable result, String value) {
			super(result, 0);
			assert (result.type instanceof PointerType);
			this.result = result;
			this.value = value;
			
		}

		@Override
		public String toString() {
			return this.result.getValue() + " = private unnamed_addr constant " + ((PointerType) this.result.type).type
					+ "c" + this.value + ", align " + this.result.type.align + "\n";
		}
	}

	// OK
	public static class Variable extends Instruction {

		Type type;
//		String indent; // TODO
		private String value;
		private int scope;
		
		private static final String[] scope_token = { "%", "@", "" };
		
		public Variable(int scope, Type type, String value) {
			super(null, 0);
			this.type = type;
			this.scope = scope;
			if(value != null) { 
				this.value = Variable.scope_token[this.scope] + value;
			} else {
				this.value = value;
			}
		}
		
		public String getValue() {
			if(this.value == null) {
				this.value = Variable.scope_token[this.scope] + this.getCpt();
			}
			return this.value;
		}

		@Override
		public String toString() {
			return this.type + " " + ((this.value == null) ? "" : this.value);
		}
	}

	// OK
	public static class Affectation extends Instruction {

		Variable variable, value;

		public Affectation(Variable variable, Variable value) {
			//super(value, 1); // TODO
			super(null, 0);
			assert (variable.type instanceof PointerType);
			this.variable = variable;
			this.value = value;
		}
		
		@Override
		public String toString() {
			return Utils.indent(this.level) + "store " + this.value.type + " " + this.value.getValue() + ", " + this.variable.type + " " + this.variable.getValue() + "\n";
		}

	}

	// OK
	public static class Instanciation extends Instruction {

		private Variable variable;

		public Instanciation(Variable variable) {
			super(variable, 1);
			assert (variable.type instanceof PointerType);
			this.variable = variable;
		}

		@Override
		public String toString() {
			PointerType type = (PointerType) this.variable.type;
			return Utils.indent(this.level) + this.variable.getValue() + " = alloca " + type.type + "\n";
		}
	}

	/*
	 * LABEL - JUMP
	 */

	// OK
	public static class ICMP extends Instruction {

		private Variable result, left, right;
		private Cond op;

		public ICMP(Variable result, Variable left, Cond op, Variable right) {
			super(result, 1);
			assert (result.type instanceof BooleanType); // can accept boolean vector too : not implemented yet
			assert (left.type.equals(right.type));
			this.result = result;
			this.left = left;
			this.op = op;
			this.right = right;
		}

		@Override
		public String toString() {
			return Utils.indent(this.level) + this.result.getValue() + " = icmp " + this.op + " " + this.left.type + " " + this.left.getValue() + ", "
					+ this.right.getValue() + "\n";
		}
	}

	// OK
	public static class BR extends Instruction {

		Variable label;

		public BR(Variable label) {
			super(null, 0);
			assert (label.type instanceof LabelType);
			this.label = label;
		}

		@Override
		public String toString() {
			return Utils.indent(this.level) + "br " + this.label.type + " " + this.label.getValue() + "\n";
		}
	}

	// OK
	public static class Label extends Instruction {

		private Variable label;

		public Label(Variable label) {
			super(label, 1);
			assert (label.type instanceof LabelType);
			this.label = label;
		}

		@Override
		public String toString() {
			return Utils.indent(this.level - 1) + "; <"+this.label.type+">" + label.getValue().replaceFirst("%", ":") + "\n";
		}
	}

	// OK
	public static class BRCond extends Instruction {

		private Variable cond, labelTrue, labelFalse;

		public BRCond(Variable cond, Variable labelTrue, Variable labelFalse) {
			super(null, 0);
			assert (cond.type instanceof BooleanType);
			assert (labelTrue.type instanceof LabelType);
			assert (labelFalse.type instanceof LabelType);
			this.cond = cond;
			this.labelTrue = labelTrue;
			this.labelFalse = labelFalse;
		}

		@Override
		public String toString() {
			return Utils.indent(this.level) + "br " + this.cond + ", " + this.labelTrue.type + " " + this.labelTrue.getValue() + ", " + this.labelFalse.type + " " + this.labelFalse.getValue() + "\n";
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

		private Variable result;
		private Variable left, right;

		public Div(Variable result, Variable left, Variable right) {
			super(result, 1);
			this.result = result;
			this.left = left;
			this.right = right;
		}

		public String toString() {
			return Utils.indent(this.level) + this.result.getValue() + " = udiv " + this.result.type + " " + this.left.getValue()
					+ ", " + this.right.getValue() + "\n";
		}
	}

	// OK
	public static class Add extends Instruction {

		private Variable result;
		private Variable left, right;

		public Add(Variable result, Variable left, Variable right) {
			super(result, 1);
			this.result = result;
			this.left = left;
			this.right = right;
		}

		public String toString() {
			return Utils.indent(this.level) + this.result.getValue() + " = add " + this.result.type + " " + this.left.getValue()
					+ ", " + this.right.getValue()+ "\n";
		}
	}

	// OK
	public static class Mul extends Instruction {

		private Variable result;
		private Variable left, right;

		public Mul(Variable result, Variable left, Variable right) {
			super(result, 1);
			this.result = result;
			this.left = left;
			this.right = right;
		}

		public String toString() {
			return Utils.indent(this.level) + this.result.getValue() + " = mul " + this.result.type + " " + this.left.getValue()
					+ ", " + this.right.getValue() + "\n";
		}
	}

	// OK
	public static class Sub extends Instruction {

		private Variable result;
		private Variable left, right;

		public Sub(Variable result, Variable left, Variable right) {
			super(result, 1);
			this.result = result;
			this.left = left;
			this.right = right;
		}

		public String toString() {
			return Utils.indent(this.level) + this.result.getValue() + " = sub " + this.result.type + " " + this.left.getValue()
					+ ", " + this.right.getValue() + "\n";
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
		public int size;

		public ArrayType(Type type, int size) {
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