package TP2;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import TP2.Utils.LLVMStringConstant;

public class ASD {
	static public class Program {
		List<Expression> listExpression;

		public Program(List<Expression> listExpression) {
			this.listExpression = listExpression;
		}

		public String pp() {
			StringBuilder ret = new StringBuilder();

			for (Expression f : this.listExpression) {
				ret.append(f.pp());
			}

			return ret.toString();
		}

		public Llvm.IR toIR() throws TypeException {
			Llvm.IR ir = new Llvm.IR(Llvm.empty(), Llvm.empty());

			for (Expression e : this.listExpression) {
				ir.append(e.toIR().ir);
			}

			return ir;
		}
	}
	
	static public class Booleen extends Expression {

		Expression e;
		
		public Booleen(Expression e) {
			this.e = e;
		}
		
		@Override
		public String pp() {
			return this.e.pp();
		}

		@Override
		public RetExpression toIR() throws TypeException {
			RetExpression ret = this.e.toIR();
			String result = Utils.newtmp();
			ret.ir.appendCode(new Llvm.Booleen(ret.type.toLlvmType(), ret.result, result));
			return new RetExpression(ret.ir, new BooleenType(), result);
		}
		
	}
	
	static public class Condition extends Expression {

		Expression left;
		Operand op;
		Expression right;
		
		public Condition(Expression left, Operand op, Expression right) {
			this.left = left;
			this.op = op;
			this.right = right;
		}
		
		@Override
		public String pp() {
			return this.left.pp() + " " + this.op.pp() + " " + this.right.pp();
		}

		@Override
		public RetExpression toIR() throws TypeException {
			String result = Utils.newtmp();
			RetExpression ret = new RetExpression(new Llvm.IR(Llvm.empty(), Llvm.empty()), new BooleenType(), result);
			RetExpression left = this.left.toIR(), right = this.right.toIR();
			
			ret.ir.append(left.ir);
			ret.ir.append(right.ir);
			
			ret.ir.appendCode(new Llvm.Condition(left.type.toLlvmType(), left.result, this.op.toLlvmOperand(), right.result, result));
			
			return ret;
		}
		
	}
	
	static public class IfElse extends Expression {

		public Expression condition;
		public List<Expression> blockTrue, blockFalse;
		
		public IfElse(Expression condition, List<Expression> blockTrue, List<Expression> blockFalse) {
			this.condition = condition;
			this.blockTrue = blockTrue;
			this.blockFalse = blockFalse;
		}
		
		@Override
		public String pp() {
			StringBuilder ret = new StringBuilder("IF " + this.condition.pp() + " THEN \n");
			for(Expression e : this.blockTrue) {
				ret.append(e.pp());
			}
			ret.append("ELSE");
			return ret.toString();
		}

		@Override
		public RetExpression toIR() throws TypeException {
			RetExpression ret = new RetExpression(new Llvm.IR(Llvm.empty(), Llvm.empty()), new VoidType(), ""), cond = this.condition.toIR();
			ret.ir.append(cond.ir);
			String labelTrue = Utils.newlab("then"), labelElse = Utils.newlab("else"), labelFi = Utils.newlab("fi");
			ret.ir.appendCode(new Llvm.JumpIf(cond.type.toLlvmType(), cond.result, labelTrue, labelElse));
			
			ret.ir.appendCode(new Llvm.Label(labelTrue));
			
//			ret.ir.appendCode(new Llvm.OpenLabelBlock());
			
			for(Expression e : this.blockTrue) {
				ret.ir.append(e.toIR().ir);
			}
			
			ret.ir.appendCode(new Llvm.Jump(labelFi));
			
//			ret.ir.appendCode(new Llvm.CloseLabelBlock());
			
			ret.ir.appendCode(new Llvm.Label(labelElse));
			
//			ret.ir.appendCode(new Llvm.OpenLabelBlock());
			
			for(Expression e : this.blockFalse) {
				ret.ir.append(e.toIR().ir);
			}
			
			ret.ir.appendCode(new Llvm.Jump(labelFi));
			
//			ret.ir.appendCode(new Llvm.CloseLabelBlock());
			
			ret.ir.appendCode(new Llvm.Label(labelFi));
			
			return ret;
		}
		
	}
	
	static public class While extends Expression {

		public Expression condition;
		public List<Expression> block;
		
		public While(Expression condition, List<Expression> block) {
			this.condition = condition;
			this.block = block;
		}
		
		@Override
		public String pp() {
			StringBuilder ret = new StringBuilder("WHILE " + this.condition.pp() + " DO \n");
			for(Expression e : this.block) {
				ret.append(e.pp());
			}
			ret.append("DONE\n");
			return ret.toString();
		}

		@Override
		public RetExpression toIR() throws TypeException {
			RetExpression ret = new RetExpression(new Llvm.IR(Llvm.empty(), Llvm.empty()), new VoidType(), ""), cond = this.condition.toIR();
			String labelEntry = Utils.newlab("entry"), labelTrue = Utils.newlab("do"), labelFalse = Utils.newlab("done");
			
			ret.ir.appendCode(new Llvm.Label(labelEntry));
			
			ret.ir.append(cond.ir);
			
			ret.ir.appendCode(new Llvm.JumpIf(cond.type.toLlvmType(), cond.result, labelTrue, labelFalse));
			
			ret.ir.appendCode(new Llvm.Label(labelTrue));
			
//			ret.ir.appendCode(new Llvm.OpenLabelBlock());
			
			for(Expression e : this.block) {
				ret.ir.append(e.toIR().ir);
			}
			
			ret.ir.appendCode(new Llvm.Jump(labelEntry));
			
//			ret.ir.appendCode(new Llvm.CloseLabelBlock());
			
			ret.ir.appendCode(new Llvm.Label(labelFalse));
			
			return ret;
		}
		
	}
	
	static public class If extends Expression {

		public Expression condition;
		public List<Expression> block;
		
		public If(Expression condition, List<Expression> block) {
			this.condition = condition;
			this.block = block;
		}
		
		@Override
		public String pp() {
			StringBuilder ret = new StringBuilder("IF " + this.condition.pp() + " THEN \n");
			for(Expression e : this.block) {
				ret.append(e.pp());
			}
			ret.append("FI\n");
			return ret.toString();
		}

		@Override
		public RetExpression toIR() throws TypeException {
			RetExpression ret = new RetExpression(new Llvm.IR(Llvm.empty(), Llvm.empty()), new VoidType(), ""), cond = this.condition.toIR();
			ret.ir.append(cond.ir);
			String labelTrue = Utils.newlab("then"), labelFalse = Utils.newlab("fi");
			ret.ir.appendCode(new Llvm.JumpIf(cond.type.toLlvmType(), cond.result, labelTrue, labelFalse));
			
			ret.ir.appendCode(new Llvm.Label(labelTrue));
			
//			ret.ir.appendCode(new Llvm.OpenLabelBlock());
			
			for(Expression e : this.block) {
				ret.ir.append(e.toIR().ir);
			}
			
//			ret.ir.appendCode(new Llvm.CloseLabelBlock());
			
			ret.ir.appendCode(new Llvm.Label(labelFalse));
			
			return ret;
		}
		
	}

	static public class ReturnStatement extends Expression {
		Expression e;

		public ReturnStatement(Expression e) {
			this.e = e;
		}

		public String pp() {
			return "RETURN " + e.pp();
		}

		public RetExpression toIR() throws TypeException {
			RetExpression ret = e.toIR();
			ret.ir.appendCode(new Llvm.Return(ret.type.toLlvmType(), ret.result));

			return new RetExpression(ret.ir, ret.type, ret.result);
		}
	}

	static public class Fonction extends Expression {

		Type type;
		String ident;
		List<Expression> expressions;

		public Fonction(Type type, String ident, List<Expression> expressions) {
			this.type = type;
			this.ident = ident;
			this.expressions = expressions;
		}

		public String pp() {
			return "";
		}

		public RetExpression toIR() throws TypeException {
			RetExpression ret = new RetExpression(new Llvm.IR(Llvm.empty(), Llvm.empty()), this.type, this.ident);
			ret.ir.appendCode(new Llvm.Fonction(type.toLlvmType(), ident));
			ret.ir.appendCode(new Llvm.OpenBlock());

			for (Expression s : this.expressions) {
				ret.ir.append(s.toIR().ir);
			}

			if(this.type.equals(new VoidType())) {
				ret.ir.appendCode(new Llvm.Return(this.type.toLlvmType(), ""));
			}
			ret.ir.appendCode(new Llvm.CloseBlock());

			return ret;
		}
	}
	
	static public class PrintFunction extends Expression {

		List<Expression> args;
		
		public PrintFunction(List<Expression> args) {
			this.args = args;
		}
		
		@Override
		public String pp() {
			StringBuilder ret = new StringBuilder("PRINT ");
			for(Expression e : this.args) {
				ret.append(e.pp());
			}
			ret.append("\n");
			return ret.toString();
		}

		@Override
		public RetExpression toIR() throws TypeException {
			return new CallFonction(new IntType(), new VArgsFonction(), "printf", this.args).toIR();
		}
		
	}
	
	static public class VArgsFonction extends Type {

		@Override
		public String pp() {
			return "";
		}

		@Override
		public TP2.Llvm.Type toLlvmType() {
			return new Llvm.VArgsCast();
		}
		
	}
	
	static public class CallFonction extends Expression {

		Type type;
		String ident;
		List<Expression> args;
		Optional<Type> cast;
		
		public CallFonction(Type type,  String ident, List<Expression> args) {
			this.type = type;
			this.ident = ident;
			this.args = args;
		}
		
		public CallFonction(Type type, Type cast, String ident, List<Expression> args) {
			this(type, ident, args);
			this.cast = Optional.ofNullable(cast);
		}
		
		@Override
		public String pp() {
			StringBuilder ret = new StringBuilder(this.ident + "(");
			for(Expression e : this.args) {
				ret.append(e.pp());
			}
			ret.append(")");
			return ret.toString();
		}

		@Override
		public RetExpression toIR() throws TypeException {
//			String result = Utils.newtmp();
			RetExpression ret = new RetExpression(new Llvm.IR(Llvm.empty(), Llvm.empty()), this.type, "");
			
			List<RetExpression> retargs = new ArrayList<RetExpression>();
			this.args.forEach(p -> {
				try {
					retargs.add(p.toIR());
				} catch (TypeException e) {
					e.printStackTrace();
				}
			});
			retargs.forEach(p -> ret.ir.append(p.ir));
			
			ret.ir.appendCode(new Llvm.CallFonction(this.type.toLlvmType(), this.cast.isPresent() ? this.cast.get().toLlvmType() : null, this.ident));
			ret.ir.appendCode(new Llvm.BeginArgs());
			retargs.forEach(p -> ret.ir.appendCode(new Llvm.Variable(p.type.toLlvmType(), p.result)));
			ret.ir.appendCode(new Llvm.EndArgs());
			
			return ret;
		}
	}
	
	static public class ProtoFonction extends Expression {

		Type type;
		String ident;

		public ProtoFonction(Type type, String ident) {
			this.type = type;
			this.ident = ident;
		}

		public String pp() {
			return "";
		}

		public RetExpression toIR() throws TypeException {
			RetExpression ret = new RetExpression(new Llvm.IR(Llvm.empty(), Llvm.empty()), this.type, this.ident);
//			ret.ir.appendCode(new Llvm.DeclareFonction(type.toLlvmType(), ident));

			return ret;
		}
	}

	static public abstract class Expression {
		public abstract String pp();

		public abstract RetExpression toIR() throws TypeException;

		static public class RetExpression {
			public Llvm.IR ir;
			public Type type;
			public String result;

			public RetExpression(Llvm.IR ir, Type type, String result) {
				this.ir = ir;
				this.type = type;
				this.result = result;
			}
		}
	}
	
	static public class StringExpression extends Expression {
		String text;
		
		public StringExpression(String text) {
			this.text = text;
			System.out.println("; text > "+text);
		}

		@Override
		public String pp() {
			return "\"" + this.text + "\"";
		}

		@Override
		public RetExpression toIR() throws TypeException {
			RetExpression ret = new RetExpression(new Llvm.IR(Llvm.empty(), Llvm.empty()), new StringType(), this.text );
			
			LLVMStringConstant strc = Utils.stringTransform(this.text);
			String ident = Utils.newglob(this.text);
			
			ret.ir.appendHeader(new Llvm.StringConstant(ret.type.toLlvmType(), strc.length, ident, strc.str));
			
			return ret;
		}
	}

	static public class AddExpression extends Expression {

		Expression left;
		Expression right;

		public AddExpression(Expression left, Expression right) {
			this.left = left;
			this.right = right;
		}

		public String pp() {
			return "(" + left.pp() + " + " + right.pp() + ")";
		}

		public RetExpression toIR() throws TypeException {
			RetExpression leftRet = left.toIR();
			RetExpression rightRet = right.toIR();

			if (!leftRet.type.equals(rightRet.type)) {
				throw new TypeException("type mismatch: have " + leftRet.type + " and " + rightRet.type);
			}

			leftRet.ir.append(rightRet.ir);
			String result = Utils.newtmp();
			Llvm.Instruction add = new Llvm.Add(leftRet.type.toLlvmType(), leftRet.result, rightRet.result, result);
			leftRet.ir.appendCode(add);

			return new RetExpression(leftRet.ir, leftRet.type, result);
		}
	}

	static public class MulExpression extends Expression {

		Expression left;
		Expression right;

		public MulExpression(Expression left, Expression right) {
			this.left = left;
			this.right = right;
		}

		public String pp() {
			return "(" + left.pp() + " * " + right.pp() + ")";
		}

		public RetExpression toIR() throws TypeException {
			RetExpression leftRet = left.toIR();
			RetExpression rightRet = right.toIR();

			if (!leftRet.type.equals(rightRet.type)) {
				throw new TypeException("type mismatch: have " + leftRet.type + " and " + rightRet.type);
			}

			leftRet.ir.append(rightRet.ir);
			String result = Utils.newtmp();
			Llvm.Instruction add = new Llvm.Mul(leftRet.type.toLlvmType(), leftRet.result, rightRet.result, result);
			leftRet.ir.appendCode(add);

			return new RetExpression(leftRet.ir, leftRet.type, result);
		}
	}
	
	static public class Variable extends Expression {

		Type type;
		String ident;
		
		public Variable(Type type, String ident) {
			this.type = type;
			this.ident = ident;
		}
		
		@Override
		public String pp() {
			return this.ident;
		}

		@Override
		public RetExpression toIR() throws TypeException {
			RetExpression ret = new RetExpression(new Llvm.IR(Llvm.empty(), Llvm.empty()), this.type, Utils.newtmp());
			ret.ir.appendCode(new Llvm.Pointer(this.type.toLlvmType(), this.ident, ret.result));
			return ret;
		}
		
	}

	static public class SignedDivExpression extends Expression {
		Expression left;
		Expression right;

		public SignedDivExpression(Expression left, Expression right) {
			this.left = left;
			this.right = right;
		}

		public String pp() {
			return "(" + left.pp() + " / " + right.pp() + ")";
		}

		public RetExpression toIR() throws TypeException {
			RetExpression leftRet = left.toIR();
			RetExpression rightRet = right.toIR();

			if (!leftRet.type.equals(rightRet.type)) {
				throw new TypeException("type mismatch: have " + leftRet.type + " and " + rightRet.type);
			}

			leftRet.ir.append(rightRet.ir);
			String result = Utils.newtmp();
			Llvm.Instruction add = new Llvm.SignedDiv(leftRet.type.toLlvmType(), leftRet.result, rightRet.result,
					result);
			leftRet.ir.appendCode(add);

			return new RetExpression(leftRet.ir, leftRet.type, result);
		}
	}

	static public class SubExpression extends Expression {
		Expression left;
		Expression right;

		public SubExpression(Expression left, Expression right) {
			this.left = left;
			this.right = right;
		}

		public String pp() {
			return "(" + left.pp() + " - " + right.pp() + ")";
		}

		public RetExpression toIR() throws TypeException {
			RetExpression leftRet = left.toIR();
			RetExpression rightRet = right.toIR();

			if (!leftRet.type.equals(rightRet.type)) {
				throw new TypeException("type mismatch: have " + leftRet.type + " and " + rightRet.type);
			}

			leftRet.ir.append(rightRet.ir);
			String result = Utils.newtmp();
			Llvm.Instruction add = new Llvm.Sub(leftRet.type.toLlvmType(), leftRet.result, rightRet.result, result);
			leftRet.ir.appendCode(add);

			return new RetExpression(leftRet.ir, leftRet.type, result);
		}
	}

	static public class IntegerExpression extends Expression {

		int value;

		public IntegerExpression(int value) {
			this.value = value;
		}

		public String pp() {
			return "" + value;
		}

		public RetExpression toIR() {
			return new RetExpression(new Llvm.IR(Llvm.empty(), Llvm.empty()), new IntType(), "" + value);
		}
	}
	
	static public abstract class Operand {
		public abstract String pp();
		
		public abstract Llvm.Operand toLlvmOperand();
	}
	
	static public class EqualOperand extends Operand {

		@Override
		public String pp() {
			return " = ";
		}

		@Override
		public Llvm.Operand toLlvmOperand() {
			return new Llvm.EqualOperand();
		}
	}
	
	static public class DifferentOperand extends Operand {

		@Override
		public String pp() {
			return " = ";
		}

		@Override
		public Llvm.Operand toLlvmOperand() {
			return new Llvm.DifferentOperand();
		}
	}
	
	static public class GreaterThanOperand extends Operand {

		@Override
		public String pp() {
			return " > ";
		}

		@Override
		public Llvm.Operand toLlvmOperand() {
			return new Llvm.GreaterThanOperand();
		}
	}
	
	static public class GreaterThanOrEqualOperand extends Operand {

		@Override
		public String pp() {
			return " >= ";
		}

		@Override
		public Llvm.Operand toLlvmOperand() {
			return new Llvm.GreaterThanOrEqualOperand();
		}
	}
	
	static public class LessThanOperand extends Operand {

		@Override
		public String pp() {
			return " < ";
		}

		@Override
		public Llvm.Operand toLlvmOperand() {
			return new Llvm.LessThanOperand();
		}
	}
	
	static public class LessThanOrEqualOperand extends Operand {

		@Override
		public String pp() {
			return " <= ";
		}

		@Override
		public Llvm.Operand toLlvmOperand() {
			return new Llvm.LessThanOrEqualOperand();
		}
	}

	static public abstract class Type {
		public abstract String pp();

		public abstract Llvm.Type toLlvmType();
	}

	static public class Affectation extends Expression {

		Type type;
		String ident;
		Expression expression;

		public Affectation(Type type, String ident, Expression expression) {
			this.type = type;
			this.ident = ident;
			this.expression = expression;
		}

		@Override
		public String pp() {
			return type.pp() + " " + ident + " " + expression.pp() + "\n";
		}

		@Override
		public RetExpression toIR() throws TypeException {
			RetExpression ret = this.expression.toIR();

			ret.ir.appendCode(new Llvm.Affectation(this.type.toLlvmType(), this.ident, ret.result));

			return ret;
		}
	}
	
	static public class Instanciation extends Expression {

		Type type;
		String ident;

		public Instanciation(Type type, String ident) {
			this.type = type;
			this.ident = ident;
		}

		@Override
		public String pp() {
			return this.type.pp() + " " + ident + "\n";
		}

		@Override
		public RetExpression toIR() throws TypeException {
			RetExpression ret = new RetExpression(new Llvm.IR(Llvm.empty(), Llvm.empty()), type, ident);
			ret.ir.appendCode(new Llvm.Instanciation(ret.type.toLlvmType(), ret.result));
			return ret;
		}
	}

	// static public class Variable extends Expression {
	//
	// Type type;
	// String ident;
	//
	// public Variable(Type type, String ident) {
	// this.type = type;
	// this.ident = ident;
	// }
	//
	// @Override
	// public String pp() {
	// return type.pp() + ident;
	// }
	//
	// @Override
	// public RetExpression toIR() throws TypeException {
	// return new RetExpression(new Llvm.IR(Llvm.empty(), Llvm.empty()), type,
	// ident);
	// }
	//
	// }

	static class VoidType extends Type {
		public String pp() {
			return "VOID";
		}

		@Override
		public boolean equals(Object obj) {
			return obj instanceof VoidType;
		}

		public Llvm.Type toLlvmType() {
			return new Llvm.VoidType();
		}
	}
	
	static class BooleenType extends Type {

		@Override
		public String pp() {
			return "";
		}
		
		@Override
		public boolean equals(Object obj) {
			return obj instanceof BooleenType;
		}

		@Override
		public Llvm.Type toLlvmType() {
			return new Llvm.BooleenType();
		}
		
	}

	static class IntType extends Type {
		public String pp() {
			return "INT";
		}

		@Override
		public boolean equals(Object obj) {
			return obj instanceof IntType;
		}

		public Llvm.Type toLlvmType() {
			return new Llvm.IntType();
		}
	}

	static class StringType extends Type {
		public String pp() {
			return "STRING";
		}

		@Override
		public boolean equals(Object obj) {
			return obj instanceof StringType;
		}

		public Llvm.Type toLlvmType() {
			return new Llvm.StringType();
		}
	}
}