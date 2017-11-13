package TP2;

import java.util.ArrayList;
import java.util.List;

// This file contains a simple LLVM IR representation
// and methods to generate its string representation

public class Llvm {

	static int lvl = 0;

	static public class IR {
		List<Instruction> header; // IR instructions to be placed before the
		// code (global definitions)
		List<Instruction> code; // main code

		public IR(List<Instruction> header, List<Instruction> code) {
			this.header = header;
			this.code = code;
		}

		// append an other IR
		public IR append(IR other) {
			header.addAll(other.header);
			code.addAll(other.code);
			return this;
		}

		// append a code instruction
		public IR appendCode(Instruction inst) {
			code.add(inst);
			return this;
		}

		// append a code header
		public IR appendHeader(Instruction inst) {
			header.add(inst);
			return this;
		}

		// Final string generation
		public String toString() {
			// This header describe to LLVM the target
			// and declare the external function printf
			StringBuilder r = new StringBuilder("; Target\n" + "target triple = \"x86_64-apple-macosx10.12.0\"\n"
					+ "; External declaration of the printf function\n"
					+ "declare i32 @printf(i8* noalias nocapture, ...)\n" + "\n; Actual code begins\n\n");

			for (Instruction inst : header)
				r.append(inst);

			r.append("\n\n");

			// We create the function main
			// TODO : remove this when you extend the language
			// r.append("define i32 @main() {\n");

			for (Instruction inst : code)
				r.append(inst);

			// TODO : remove this when you extend the language
			// r.append("}\n");

			return r.toString();
		}
	}

	static public List<Instruction> empty() {
		return new ArrayList<Instruction>();
	}

	static public abstract class Type {
		public abstract String toString();
	}
	
	static public abstract class Operand {
		public abstract String toString();
	}
	
	static public class DifferentOperand extends Operand {

		@Override
		public String toString() {
			return "ne";
		}
		
	}
	
	static public class EqualOperand extends Operand {

		@Override
		public String toString() {
			return "eq";
		}
		
	}
	
	static public class GreaterThanOperand extends Operand {

		@Override
		public String toString() {
			return "ugt";
		}
		
	}
	
	static public class LessThanOperand extends Operand {

		@Override
		public String toString() {
			return "ult";
		}
		
	}
	
	static public class GreaterThanOrEqualOperand extends Operand {

		@Override
		public String toString() {
			return "uge";
		}
		
	}
	
	static public class LessThanOrEqualOperand extends Operand {

		@Override
		public String toString() {
			return "ule";
		}
		
	}

	static public class StringType extends Type {
		public String toString() {
			return "i8*";
		}
	}
	
	static public class BooleenType extends Type {
		public String toString() {
			return "i1";
		}
	}

	static public class IntType extends Type {
		public String toString() {
			return "i32";
		}
	}

	static public class VoidType extends Type {
		public String toString() {
			return "void";
		}
	}

	static public abstract class Instruction {

		protected int level;
		

		public Instruction() {
			this.level = Llvm.lvl;
		}

		public abstract String toString();
	}
	
	
	
	static public class Pointer extends Instruction {

		Type type;
		String ident;
		String result;
		
		public Pointer(Type type, String ident, String result) {
			this.type = type;
			this.ident = ident;
			this.result = result;
		}
		
		@Override
		public String toString() {
			return Utils.indent(this.level) + this.result + " = load " + this.type + ", " + this.type + "* " + "%" + this.ident + "\n";
		}
		
	}

	static public class Fonction extends Instruction {
		Type type;
		String ident;

		public Fonction(Type type, String ident) {
			super();
			this.type = type;
			this.ident = ident;
		}

		public String toString() {
			return Utils.indent(this.level) + "define " + type + " @" + ident + "()";
		}
	}
	
//	static public class DeclareFonction extends Instruction {
//		Type type;
//		String ident;
//
//		public DeclareFonction(Type type, String ident) {
//			super();
//			this.type = type;
//			this.ident = ident;
//		}
//
//		public String toString() {
//			return Llvm.printLvl(this.level) + "declare " + type + " @" + ident + "() " + "#0" + "\n";
//		}
//	}

	static public class OpenBlock extends Instruction {

		public OpenBlock() {
			super();
			Llvm.lvl++;
		}

		@Override
		public String toString() {
			return " {\n";
		}

	}

	static public class CloseBlock extends Instruction {

		public CloseBlock() {
			super();
			Llvm.lvl--;
		}

		@Override
		public String toString() {
			return "}\n\n";
		}

	}

	static public class SignedDiv extends Instruction {

		Type type;
		String left;
		String right;
		String lvalue;

		public SignedDiv(Type type, String left, String right, String lvalue) {
			super();
			this.type = type;
			this.left = left;
			this.right = right;
			this.lvalue = lvalue;
		}

		public String toString() {
			return Utils.indent(this.level) + lvalue + " = udiv " + type + " " + left + ", " + right + "\n";
		}
	}

	static public class Add extends Instruction {

		Type type;
		String left;
		String right;
		String lvalue;

		public Add(Type type, String left, String right, String lvalue) {
			super();
			this.type = type;
			this.left = left;
			this.right = right;
			this.lvalue = lvalue;
		}

		public String toString() {
			return Utils.indent(this.level) + lvalue + " = add " + type + " " + left + ", " + right + "\n";
		}
	}

	static public class Mul extends Instruction {

		Type type;
		String left;
		String right;
		String lvalue;

		public Mul(Type type, String left, String right, String lvalue) {
			super();
			this.type = type;
			this.left = left;
			this.right = right;
			this.lvalue = lvalue;
		}

		public String toString() {
			return Utils.indent(this.level) + lvalue + " = mul " + type + " " + left + ", " + right + "\n";
		}
	}

	static public class Sub extends Instruction {

		Type type;
		String left;
		String right;
		String lvalue;

		public Sub(Type type, String left, String right, String lvalue) {
			super();
			this.type = type;
			this.left = left;
			this.right = right;
			this.lvalue = lvalue;
		}

		public String toString() {
			return Utils.indent(this.level) + lvalue + " = sub " + type + " " + left + ", " + right + "\n";
		}
	}

	static public class Affectation extends Instruction {

		Type type;
		String ident;
		String value;

		public Affectation(Type type, String ident, String value) {
			this.type = type;
			this.ident = ident;
			this.value = value;
		}

		@Override
		public String toString() {
			return Utils.indent(this.level) + "store " + this.type + " " + this.value + ", " + this.type + "* " + "%" +this.ident + "\n";
		}

	}
	
	static public class Booleen extends Instruction {

		Type type;
		String ident;
		String result;
		
		public Booleen(Type type, String ident, String result) {
			super();
			this.type = type;
			this.ident = ident;
			this.result = result;
		}
		
		@Override
		public String toString() {
			return Utils.indent(this.level) + this.result + " = icmp ne " + this.type + " %" + this.ident + ", " + 0 + "\n";
		}
		
	}
	
	static public class Condition extends Instruction {

		Type type;
		String left;
		Operand op;
		String right;
		String result;
		
		public Condition(Type type, String left, Operand op,  String right, String result) {
			super();
			this.type = type;
			this.left = left;
			this.op = op;
			this.right = right;
			this.result = result;
		}
		
		@Override
		public String toString() {
			return Utils.indent(this.level) + this.result + " = icmp " + this.op + " " + this.type + " " + this.left + ", " + this.right + "\n";
		}
	}
	
	static public class Jump extends Instruction {
		
		String ident;
		
		public Jump(String ident) {
			super();
			this.ident = ident;
		}

		@Override
		public String toString() {
			return Utils.indent(this.level) + "br label " + this.ident;
		}
		
	}
	
	static public class Label extends Instruction {

		String ident;
		
		public Label(String ident) {
			super();
			this.ident = ident;
		}
		
		@Override
		public String toString() {
			return Utils.indent(this.level) + this.ident + ":" + "\n";
		}
		
	}
	
	static public class JumpIf extends Instruction {

		Type type;
		String value, labelTrue, labelFalse;
		
		public JumpIf(Type type, String value, String labelTrue, String labelFalse) {
			super();
			this.type = type;
			this.value = value;
			this.labelTrue = labelTrue;
			this.labelFalse = labelFalse;
		}
		
		@Override
		public String toString() {
			return Utils.indent(this.level) + "br " + this.type + " " + this.value + " label " + this.labelTrue + ", " + this.labelFalse + "\n";
		}
		
	}

	static public class Instanciation extends Instruction {

		Type type;
		String var;

		public Instanciation(Type type, String var) {
			this.type = type;
			this.var = var;
		}

		@Override
		public String toString() {
			return Utils.indent(this.level) + "%" + this.var + " =  alloca " + this.type + "\n";
		}
	}

	static public class Return extends Instruction {

		Type type;
		String value;

		public Return(Type type, String value) {
			super();
			this.type = type;
			this.value = value;
		}

		public String toString() {
			return Utils.indent(this.level) + "ret " + type + " " + value + "\n";
		}
	}
}