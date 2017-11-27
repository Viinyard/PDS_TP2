package TP2;

import java.util.ArrayList;
import java.util.List;

import TP2.Utils.LLVMStringConstant;

public class ASD {
	public static class Program {
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
			Llvm.IR ir = new Llvm.IR();

			for (Expression e : this.listExpression) {
				ir.append(e.toIR().ir);
			}

			return ir;
		}
	}

	public static abstract class Expression {
		public abstract String pp();

		public abstract RetExpression toIR() throws TypeException;

		public static class RetExpression {
			public Llvm.IR ir;
			public Variable variable;

			public RetExpression(Llvm.IR ir, Variable variable) {
				this.ir = ir;
				this.variable = variable;
			}
		}
	}

	/*
	 * FONCTION
	 */

	public static class ReturnStatement extends Expression {
		Expression e;

		public ReturnStatement(Expression e) {
			this.e = e;
		}

		public String pp() {
			return "RETURN " + e.pp();
		}

		public RetExpression toIR() throws TypeException {
			RetExpression ret = e.toIR();
			ret.ir.appendCode(new Llvm.Return(ret.variable.toLlvm()));
			return ret;
		}
	}

	public static class Fonction extends Expression {

		private Variable fonction;
		List<Expression> expressions;
		List<Argument> args;
		Variable ret;

		public Fonction(Variable fonction, List<Argument> args, Variable ret, List<Expression> expressions) {
			this.fonction = fonction;
			this.expressions = expressions;
			this.args = args;
			this.ret = ret;
		}

		public String pp() {
			return "";
		}

		public RetExpression toIR() throws TypeException {
			RetExpression ret = new RetExpression(new Llvm.IR(), null);

			List<Llvm.Variable> llvmArgs = new ArrayList<Llvm.Variable>();
			for (Argument arg : this.args) {
				llvmArgs.add(arg.arg.toLlvm());
			}

			ret.ir.appendHeader(new Llvm.Fonction(this.fonction.toLlvm(), llvmArgs));

			ret.ir.appendHeader(new Llvm.OpenBlock());

			for (Argument arg : this.args) {
				ret.ir.append(arg.toIR().ir);
			}

			ret.ir.appendHeader(new Llvm.Label(new Variable(Variable.local_scope, new LabelType()).toLlvm()));

			for (Argument arg : this.args) {
				ret.ir.appendHeader(new Llvm.Instanciation(arg.ptr.toLlvm()));
				ret.ir.appendCode(new Llvm.Affectation(arg.ptr.toLlvm(), arg.arg.toLlvm()));
			}

			if (this.ret != null) {
				ret.ir.appendHeader(new Llvm.Instanciation(this.ret.toLlvm()));
				this.expressions.add(new ReturnStatement(new Value(this.ret)));
			}

			for (Expression s : this.expressions) {
				ret.ir.append(s.toIR().ir);
			}

			if (this.fonction.type.equals(new VoidType())) {
				ret.ir.appendCode(new Llvm.Return(new Variable(Variable.no_scope, new VoidType()).toLlvm()));
			}

			ret.ir.appendCode(new Llvm.CloseBlock());

			ret.ir.linkFonction();
			return ret;
		}
	}

	public static class ArrayElement extends Expression {

		private Variable array;
		private Expression index;

		public ArrayElement(Variable array, Expression index) {
			assert (array.type instanceof PointerType);
			assert (((PointerType) array.type).type instanceof ArrayType);

			this.array = array;
			this.index = index;
		}

		@Override
		public String pp() {
			StringBuilder ret = new StringBuilder();
			return ret.toString();
		}

		@Override
		public RetExpression toIR() throws TypeException {

			RetExpression ret = this.index.toIR();
			Variable result = null;
			if (((PointerType) this.array.type).type instanceof PointerType) {
				RetExpression arrayValue = new Value(this.array).toIR();
				ret.ir.append(arrayValue.ir);
				Variable array = arrayValue.variable;
				result = new Variable(arrayValue.variable.scope, arrayValue.variable.type);
				ret.ir.appendCode(new Llvm.ArrayElement(result.toLlvm(), array.toLlvm(), null, ret.variable.toLlvm()));
			} else {
				result = new Variable(Variable.local_scope, ((ArrayType) ((PointerType) this.array.type).type).type);
				ret.ir.appendCode(new Llvm.ArrayElement(result.toLlvm(), this.array.toLlvm(),
						new Variable(Variable.no_scope, new IntType(), "0").toLlvm(), ret.variable.toLlvm()));
			}

			return new RetExpression(ret.ir, result);
		}

	}

	// public static class ArrayValue extends Expression {
	//
	// private Variable result;
	// private ArrayElement ptr;
	//
	// public ArrayValue(ArrayElement ptr) {
	// this.result = new Variable(Variable.local_scope, ((PointerType)
	// ptr.getResult().type).type, Utils.newtmp());
	// this.ptr = ptr;
	// }
	//
	// public Variable getResult() {
	// return this.result;
	// }
	//
	// @Override
	// public String pp() {
	// return "todo"; // TODO
	// }
	//
	// @Override
	// public RetExpression toIR() throws TypeException {
	// RetExpression ptr = this.ptr.toIR();
	// RetExpression ret = new RetExpression(new Llvm.IR(Llvm.empty(),
	// Llvm.empty()), this.result.type,
	// this.result.ident);
	// ret.ir.append(ptr.ir);
	// ret.ir.appendCode(new Llvm.Load(new Variable(ptr.type, ptr.result).toLlvm(),
	// this.result.toLlvm()));
	//
	// return ret;
	// }
	//
	// }

	public static class Argument extends Expression {

		Variable arg;
		Variable ptr;
		String ident;

		public Argument(Variable arg, String ident) {
			this.arg = arg;
			this.ptr = new Variable(arg.scope, new PointerType(arg.type));
			this.ident = ident;
		}

		@Override
		public String pp() {
			return "";
		}

		@Override
		public RetExpression toIR() throws TypeException {
			RetExpression ret = new RetExpression(new Llvm.IR(), this.ptr);
			ret.ir.appendHeader(new Llvm.Argument(this.arg.toLlvm()));
			return ret;
		}

	}

	public static class CallFonction extends Expression {

		Variable fonction;
		List<Expression> args;
		String cast;

		public CallFonction(Variable fonction, List<Expression> args) {
			this(fonction, "", args);
		}

		public CallFonction(Variable fonction, String cast, List<Expression> args) {
			this.fonction = fonction;
			this.args = args;
			this.cast = cast;
		}

		@Override
		public String pp() {
			StringBuilder ret = new StringBuilder();
			return ret.toString();
		}

		@Override
		public RetExpression toIR() throws TypeException {
			Variable result = (this.fonction.type.equals(new VoidType())) ? null
					: new Variable(Variable.local_scope, this.fonction.type);

			RetExpression ret = new RetExpression(new Llvm.IR(), result);

			List<RetExpression> retargs = new ArrayList<RetExpression>();

			for (Expression e : this.args) {
				retargs.add(e.toIR());
			}

			retargs.forEach(p -> ret.ir.append(p.ir));

			List<Llvm.Variable> varArgs = new ArrayList<Llvm.Variable>();

			for (RetExpression r : retargs) {
				varArgs.add(r.variable.toLlvm());
			}
			ret.ir.appendCode(new Llvm.CallFonction(this.fonction.toLlvm(), this.cast,
					result == null ? null : result.toLlvm(), varArgs));

			return ret;
		}
	}

	public static class ProtoFonction extends Expression {

		Variable variable;

		public ProtoFonction(Variable variable) {
			this.variable = variable;
		}

		public String pp() {
			return "";
		}

		public RetExpression toIR() throws TypeException {
			return new RetExpression(new Llvm.IR(), this.variable);
		}
	}

	/*
	 * VARIABLES
	 */

	public static class BooleanExpression extends Expression {

		private Expression expression;

		public BooleanExpression(Expression expression) {
			this.expression = expression;

		}

		@Override
		public String pp() {
			return this.expression.pp();
		}

		@Override
		public RetExpression toIR() throws TypeException {
			return new Condition(this.expression, new DifferentCond(), new IntegerExpression(0)).toIR();
		}

	}

	// OK
	public static class StringConstant extends Expression {

		private String text;

		public StringConstant(String text) {
			this.text = text;
		}

		@Override
		public String pp() {
			return "";
		}

		@Override
		public RetExpression toIR() throws TypeException {
			LLVMStringConstant c = Utils.stringTransform(this.text);
			Variable string = new Variable(Variable.global_scope,
					new PointerType(new ArrayType(new PointerType(new CharType()), c.length)), Utils.newglob(".str"));
			Variable result = new Variable(Variable.local_scope, ((ArrayType) ((PointerType) string.type).type).type);
			RetExpression ret = new RetExpression(new Llvm.IR(), result);

			ret.ir.appendGlobal(new Llvm.StringConstant(string.toLlvm(), "\"" + c.str + "\""));

			ret.ir.appendCode(new Llvm.ArrayElement(result.toLlvm(), string.toLlvm(),
					new Variable(Variable.no_scope, new IntType(), "0").toLlvm(),
					new Variable(Variable.no_scope, new IntType(), "0").toLlvm()));

			return ret;
		}
	}

	public static class PrintFunction extends Expression {

		List<Expression> args;

		public PrintFunction(List<Expression> args) {
			this.args = args;
		}

		@Override
		public String pp() {
			StringBuilder ret = new StringBuilder("PRINT ");
			for (Expression e : this.args) {
				ret.append(e.pp());
			}
			ret.append("\n");
			return ret.toString();
		}

		@Override
		public RetExpression toIR() throws TypeException {

			List<RetExpression> retargs = new ArrayList<RetExpression>();

			for (Expression e : this.args) {
				retargs.add(e.toIR());
			}

			StringBuilder pattern_value = new StringBuilder();

			retargs.forEach(p -> {
				pattern_value.append(p.variable.type.toPrintPattern());
			});
			RetExpression patternExp = new StringConstant(pattern_value.toString()).toIR();

			Variable fonction = new Variable(Variable.global_scope, new IntType(), "printf");
			Variable result = new Variable(Variable.local_scope, fonction.type);

			RetExpression ret = new RetExpression(new Llvm.IR(), result);

			for (RetExpression r : retargs) {
				ret.ir.append(r.ir);
			}

			ret.ir.append(patternExp.ir);

			List<Llvm.Variable> varArgs = new ArrayList<Llvm.Variable>();
			varArgs.add(patternExp.variable.toLlvm());

			for (RetExpression r : retargs) {
				varArgs.add(r.variable.toLlvm());
			}

			ret.ir.appendCode(new Llvm.CallFonction(fonction.toLlvm(), "(i8*, ...)", result.toLlvm(), varArgs));

			return ret;
		}

	}

	// OK
	public static class Pointeur extends Variable {

		private Type type;

		public Type getType() {
			return this.type;
		}

		public Pointeur(int scope, Type type) {
			super(scope, new PointerType(type));
			this.type = type;
		}

	}

	public static class Variable extends Expression {

		public static final int local_scope = 0;
		public static final int global_scope = 1;
		public static final int no_scope = 2;

		private Llvm.Variable llvm_Variable;

		Type type;
		int scope;
		String value;

		public String toString() {
			return type + " " + scope;
		}

		public Variable(int scope, Type type) {
			this(scope, type, null);
		}

		@Override
		public boolean equals(Object other) {
			if (other == null)
				return false;
			if (other == this)
				return true;
			if (!(other instanceof Variable))
				return false;
			Variable o = (Variable) other;
			if (this.scope != o.scope)
				return false;
			if (this.value == null || o.value == null)
				return false;

			return this.type.equals(o.type) && this.value.equals(o.value);

		}

		public Variable(int scope, Type type, String value) {
			this.type = type;
			this.scope = scope;
			this.value = value;
		}

		public Llvm.Variable toLlvm() {
			if (this.llvm_Variable == null) {
				this.llvm_Variable = new Llvm.Variable(this.scope, type.toLlvmType(), this.value);
			}
			return this.llvm_Variable;
		}

		@Override
		public String pp() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public RetExpression toIR() throws TypeException {
			return new RetExpression(new Llvm.IR(), this);
		}

	}

	public static class ReadFunction extends Expression {

		private List<Expression> args;

		public ReadFunction(List<Expression> args) {
			this.args = args;
		}

		@Override
		public String pp() {
			return "READ " + "..." + "\n"; // TODO
		}

		@Override
		public RetExpression toIR() throws TypeException {
			List<RetExpression> retargs = new ArrayList<RetExpression>();
			this.args.forEach(p -> {
				try {
					retargs.add(p.toIR());
				} catch (TypeException e) {
					e.printStackTrace();
				}
			});
			StringBuilder pattern_value = new StringBuilder();
			List<Variable> vars = new ArrayList<Variable>();
			Variable fonction = new Variable(Variable.global_scope, new IntType(), "scanf");
			Variable result = new Variable(Variable.local_scope, fonction.type);
			RetExpression ret = new RetExpression(new Llvm.IR(), result);
			for (Expression r : this.args) {
				RetExpression ex = r.toIR();
				ret.ir.append(ex.ir);
				Variable v = ex.variable;
				vars.add(v);
				pattern_value.append(v.type.toPrintPattern());
			}
			RetExpression patternExp = new StringConstant(pattern_value.toString()).toIR();

			ret.ir.append(patternExp.ir);

			List<Llvm.Variable> varArgs = new ArrayList<Llvm.Variable>();
			varArgs.add(patternExp.variable.toLlvm());

			for (Variable v : vars) {
				varArgs.add(v.toLlvm());
			}

			ret.ir.appendCode(new Llvm.CallFonction(fonction.toLlvm(), "(i8*, ...)", result.toLlvm(), varArgs));

			return ret;
		}
	}

	// OK
	public static class Value extends Expression {

		private Expression variable;

		public Value(Expression variable) {
			this.variable = variable;
		}

		@Override
		public String pp() {
			return null;
		}

		@Override
		public RetExpression toIR() throws TypeException {
			RetExpression ret = this.variable.toIR();
			Variable result = new Variable(Variable.local_scope, ((PointerType) ret.variable.type).type);
			ret.ir.appendCode(new Llvm.Load(ret.variable.toLlvm(), result.toLlvm()));
			return new RetExpression(ret.ir, result);
		}
	}

	// OK
	public static class Affectation extends Expression {

		Expression variable;
		Expression expression;

		public Affectation(Expression variable, Expression expression) {
			this.variable = variable;
			this.expression = expression;
		}

		@Override
		public String pp() {
			return null; // TODO
		}

		@Override
		public RetExpression toIR() throws TypeException {
			RetExpression ret = new RetExpression(new Llvm.IR(), null);
			RetExpression variable = this.variable.toIR();
			RetExpression value = this.expression.toIR();

			if (!(variable.variable.type instanceof PointerType)
					|| !(((PointerType) variable.variable.type).type instanceof IntType)) {
				throw new IllegalArgumentException(variable.variable.type + " is not assignable !");
			}
			if (!((ASD.PointerType) variable.variable.type).type.equals(value.variable.type)) {
				throw new IllegalArgumentException("illegal type exception : found " + value.variable.type + " need "
						+ ((PointerType) variable.variable.type).type);
			}

			ret.ir.append(value.ir);
			ret.ir.append(variable.ir);
			ret.ir.appendCode(new Llvm.Affectation(variable.variable.toLlvm(), value.variable.toLlvm()));

			return ret;
		}
	}

	public static class ArrayInstanciation extends Expression {

		private Variable variable;
		private int size;

		public ArrayInstanciation(Variable variable, int size) {
			this.variable = variable;
		}

		@Override
		public String pp() {
			// TODO Auto-generated method stub
			return "todo";
		}

		@Override
		public RetExpression toIR() throws TypeException {
			RetExpression ret = new RetExpression(new Llvm.IR(), this.variable);

			Variable array = new Variable(Variable.local_scope,
					new PointerType(new ArrayType(this.variable.type, size)));

			ret.ir.appendHeader(new Llvm.Instanciation(array.toLlvm()));
			return ret;
		}

	}

	// OK
	public static class Instanciation extends Expression {

		private Variable variable;

		public Instanciation(Variable variable) {
			assert (variable.type instanceof PointerType);
			this.variable = variable;
		}

		@Override
		public String pp() {
			return "";
		}

		@Override
		public RetExpression toIR() throws TypeException {
			RetExpression ret = new RetExpression(new Llvm.IR(), this.variable);
			ret.ir.appendHeader(new Llvm.Instanciation(this.variable.toLlvm()));
			return ret;
		}
	}

	/*
	 * OPERAND
	 */

	// OK
	public static abstract class Cond {
		public abstract String pp();

		public abstract Llvm.Cond toLlvmCond();
	}

	// OK
	public static class EqualCond extends Cond {

		@Override
		public String pp() {
			return " = ";
		}

		@Override
		public Llvm.Cond toLlvmCond() {
			return new Llvm.EqualOperand();
		}
	}

	// OK
	public static class DifferentCond extends Cond {

		@Override
		public String pp() {
			return " = ";
		}

		@Override
		public Llvm.Cond toLlvmCond() {
			return new Llvm.DifferentOperand();
		}
	}

	// OK
	public static class GreaterThanCond extends Cond {

		@Override
		public String pp() {
			return " > ";
		}

		@Override
		public Llvm.Cond toLlvmCond() {
			return new Llvm.GreaterThanOperand();
		}
	}

	// OK
	public static class GreaterThanOrEqualCond extends Cond {

		@Override
		public String pp() {
			return " >= ";
		}

		@Override
		public Llvm.Cond toLlvmCond() {
			return new Llvm.GreaterThanOrEqualOperand();
		}
	}

	// OK
	public static class LessThanCond extends Cond {

		@Override
		public String pp() {
			return " < ";
		}

		@Override
		public Llvm.Cond toLlvmCond() {
			return new Llvm.LessThanOperand();
		}
	}

	// OK
	public static class LessThanOrEqualCond extends Cond {

		@Override
		public String pp() {
			return " <= ";
		}

		@Override
		public Llvm.Cond toLlvmCond() {
			return new Llvm.LessThanOrEqualOperand();
		}
	}

	/*
	 * BOUCLES
	 */

	// OK
	public static class Condition extends Expression {

		private Expression left, right;
		private Cond cond;

		public Condition(Expression left, Cond cond, Expression right) {
			this.left = left;
			this.cond = cond;
			this.right = right;
		}

		@Override
		public String pp() {
			return this.left.pp() + " " + this.cond.pp() + " " + this.right.pp();
		}

		@Override
		public RetExpression toIR() throws TypeException {
			RetExpression left = this.left.toIR(), right = this.right.toIR();

			if (!left.variable.type.equals(right.variable.type)) {
				throw new TypeException("type mismatch: have " + left.variable.type + " and " + right.variable.type);
			}

			Variable result = new Variable(Variable.local_scope, new BooleanType());
			left.ir.append(right.ir);

			left.ir.appendCode(new Llvm.ICMP(result.toLlvm(), left.variable.toLlvm(), this.cond.toLlvmCond(),
					right.variable.toLlvm()));

			return new RetExpression(left.ir, result);
		}

	}

	// OK
	public static class IfElse extends Expression {

		private Expression condition;
		private List<Expression> blockTrue, blockFalse;

		public IfElse(Expression condition, List<Expression> blockTrue, List<Expression> blockFalse) {
			this.condition = condition;
			this.blockTrue = blockTrue;
			this.blockFalse = blockFalse;
		}

		@Override
		public String pp() {
			StringBuilder ret = new StringBuilder("IF " + this.condition.pp() + " THEN \n");
			for (Expression e : this.blockTrue) {
				ret.append(e.pp());
			}
			ret.append("ELSE");
			return ret.toString();
		}

		@Override
		public RetExpression toIR() throws TypeException {
			RetExpression boucle = this.condition.toIR();
			Variable cond = boucle.variable;
			Variable labelThen = new Variable(Variable.local_scope, new LabelType()),
					labelElse = new Variable(Variable.local_scope, new LabelType()),
					labelFi = new Variable(Variable.local_scope, new LabelType());

			boucle.ir.appendCode(new Llvm.BRCond(cond.toLlvm(), labelThen.toLlvm(), labelElse.toLlvm()));

			boucle.ir.appendCode(new Llvm.Label(labelThen.toLlvm()));

			this.blockTrue.forEach(e -> {
				try {
					boucle.ir.append(e.toIR().ir);
				} catch (TypeException e2) {
					e2.printStackTrace();
				}
			});

			boucle.ir.appendCode(new Llvm.BR(labelFi.toLlvm()));

			boucle.ir.appendCode(new Llvm.Label(labelElse.toLlvm()));

			this.blockFalse.forEach(e -> {
				try {
					boucle.ir.append(e.toIR().ir);
				} catch (TypeException e1) {
					e1.printStackTrace();
				}
			});

			boucle.ir.appendCode(new Llvm.BR(labelFi.toLlvm()));

			boucle.ir.appendCode(new Llvm.Label(labelFi.toLlvm()));

			return new RetExpression(boucle.ir, null);
		}

	}

	// OK
	public static class While extends Expression {

		private Expression condition;
		private List<Expression> block;

		public While(Expression condition, List<Expression> block) {
			this.condition = condition;
			this.block = block;
		}

		@Override
		public String pp() {
			StringBuilder ret = new StringBuilder("WHILE " + this.condition.pp() + " DO \n");
			for (Expression e : this.block) {
				ret.append(e.pp());
			}
			ret.append("DONE\n");
			return ret.toString();
		}

		@Override
		public RetExpression toIR() throws TypeException {
			RetExpression boucle = new RetExpression(new Llvm.IR(), null);
			RetExpression condition = this.condition.toIR();
			Variable cond = condition.variable;
			Variable labelEntry = new Variable(Variable.local_scope, new LabelType()),
					labelDo = new Variable(Variable.local_scope, new LabelType()),
					labelDone = new Variable(Variable.local_scope, new LabelType());

			boucle.ir.appendCode(new Llvm.BR(labelEntry.toLlvm()));
			boucle.ir.appendCode(new Llvm.Label(labelEntry.toLlvm()));

			boucle.ir.append(condition.ir);

			boucle.ir.appendCode(new Llvm.BRCond(cond.toLlvm(), labelDo.toLlvm(), labelDone.toLlvm()));

			boucle.ir.appendCode(new Llvm.Label(labelDo.toLlvm()));

			for (Expression e : this.block) {
				boucle.ir.append(e.toIR().ir);
			}

			boucle.ir.appendCode(new Llvm.BR(labelEntry.toLlvm()));

			boucle.ir.appendCode(new Llvm.Label(labelDone.toLlvm()));

			return boucle;
		}

	}

	// OK
	public static class If extends Expression {

		private Expression condition;
		private List<Expression> blockThen;

		public If(Expression condition, List<Expression> blockThen) {
			this.condition = condition;
			this.blockThen = blockThen;
		}

		@Override
		public String pp() {
			StringBuilder ret = new StringBuilder("IF " + this.condition.pp() + " THEN \n");
			for (Expression e : this.blockThen) {
				ret.append(e.pp());
			}
			ret.append("FI\n");
			return ret.toString();
		}

		@Override
		public RetExpression toIR() throws TypeException {
			RetExpression boucle = new RetExpression(new Llvm.IR(), null);
			RetExpression condition = this.condition.toIR();
			boucle.ir.append(condition.ir);
			Variable cond = condition.variable;
			Variable labelThen = new Variable(Variable.local_scope, new LabelType()),
					labelFi = new Variable(Variable.local_scope, new LabelType());

			boucle.ir.appendCode(new Llvm.BRCond(cond.toLlvm(), labelThen.toLlvm(), labelFi.toLlvm()));

			boucle.ir.appendCode(new Llvm.Label(labelThen.toLlvm()));

			for (Expression e : this.blockThen) {
				boucle.ir.append(e.toIR().ir);
			}

			boucle.ir.appendCode(new Llvm.BR(labelFi.toLlvm()));

			boucle.ir.appendCode(new Llvm.Label(labelFi.toLlvm()));

			return boucle;
		}

	}

	/*
	 * Eval Expression
	 */

	// OK
	public static class IntegerExpression extends Expression {

		private int value;

		public IntegerExpression(int value) {
			this.value = value;
		}

		public String pp() {
			return String.valueOf(this.value);
		}

		public RetExpression toIR() {
			return new RetExpression(new Llvm.IR(),
					new Variable(Variable.no_scope, new IntType(), Integer.toString(this.value)));
		}
	}

	// OK
	public static class AddExpression extends Expression {

		private Expression left, right;

		public AddExpression(Expression left, Expression right) {
			this.left = left;
			this.right = right;
		}

		public String pp() {
			return "(" + this.left.pp() + " + " + this.right.pp() + ")";
		}

		public RetExpression toIR() throws TypeException {
			RetExpression left = this.left.toIR();
			RetExpression right = this.right.toIR();

			if (!left.variable.type.equals(right.variable.type)) {
				throw new TypeException("type mismatch: have " + left.variable.type + " and " + right.variable.type);
			}

			Variable result = new Variable(Variable.local_scope, left.variable.type);

			left.ir.append(right.ir);

			left.ir.appendCode(new Llvm.Add(result.toLlvm(), left.variable.toLlvm(), right.variable.toLlvm()));

			return new RetExpression(left.ir, result);
		}
	}

	// OK
	public static class MulExpression extends Expression {

		private Expression left, right;

		public MulExpression(Expression left, Expression right) {
			this.left = left;
			this.right = right;
		}

		public String pp() {
			return "(" + this.left.pp() + " * " + this.right.pp() + ")";
		}

		public RetExpression toIR() throws TypeException {
			RetExpression left = this.left.toIR();
			RetExpression right = this.right.toIR();

			if (!left.variable.type.equals(right.variable.type)) {
				throw new TypeException("type mismatch: have " + left.variable.type + " and " + right.variable.type);
			}

			Variable result = new Variable(Variable.local_scope, left.variable.type);

			left.ir.append(right.ir);

			left.ir.appendCode(new Llvm.Mul(result.toLlvm(), left.variable.toLlvm(), right.variable.toLlvm()));

			return new RetExpression(left.ir, result);
		}
	}

	// OK.
	public static class SignedDivExpression extends Expression {

		private Expression left, right;

		public SignedDivExpression(Expression left, Expression right) {
			this.left = left;
			this.right = right;
		}

		public String pp() {
			return "(" + this.left.pp() + " / " + this.right.pp() + ")";
		}

		public RetExpression toIR() throws TypeException {
			RetExpression left = this.left.toIR();
			RetExpression right = this.right.toIR();

			if (!left.variable.type.equals(right.variable.type)) {
				throw new TypeException("type mismatch: have " + left.variable.type + " and " + right.variable.type);
			}

			Variable result = new Variable(Variable.local_scope, left.variable.type);
			left.ir.append(right.ir);

			left.ir.appendCode(new Llvm.Div(result.toLlvm(), left.variable.toLlvm(), right.variable.toLlvm()));

			return new RetExpression(left.ir, result);
		}
	}

	// OK
	public static class SubExpression extends Expression {

		private Expression left, right;

		public SubExpression(Expression left, Expression right) {
			this.left = left;
			this.right = right;
		}

		public String pp() {
			return "(" + this.left.pp() + " - " + this.right.pp() + ")";
		}

		public RetExpression toIR() throws TypeException {
			RetExpression left = this.left.toIR();
			RetExpression right = this.right.toIR();

			if (!left.variable.type.equals(right.variable.type)) {
				throw new TypeException("type mismatch: have " + left.variable.type + " and " + right.variable.type);
			}

			Variable result = new Variable(Variable.local_scope, left.variable.type);

			left.ir.append(right.ir);

			left.ir.appendCode(new Llvm.Sub(result.toLlvm(), left.variable.toLlvm(), right.variable.toLlvm()));
			return new RetExpression(left.ir, result);
		}
	}

	/*
	 * TYPES
	 */

	// OK
	public static abstract class Type {

		public abstract String pp();

		public String toPrintPattern() {
			throw new IllegalArgumentException(this.pp() + " cannot be printed !");
		}

		public abstract Llvm.Type toLlvmType();

		public abstract String toString();

	}

	// OK
	static class PointerType extends Type {

		Type type;

		public PointerType(Type type) {
			this.type = type;
		}

		@Override
		public String pp() {
			return "";
		}

		@Override
		public boolean equals(Object obj) {
			return obj instanceof PointerType && ((PointerType) obj).type.equals(this.type);
		}

		@Override
		public String toPrintPattern() {
			return this.type.toPrintPattern();
		}

		@Override
		public Llvm.Type toLlvmType() {
			return new Llvm.PointerType(this.type.toLlvmType());
		}

		@Override
		public String toString() {
			return this.type + "*";
		}
	}

	// OK
	static class VoidType extends Type {

		@Override
		public String pp() {
			return "VOID";
		}

		@Override
		public boolean equals(Object obj) {
			return obj instanceof VoidType;
		}

		@Override
		public Llvm.Type toLlvmType() {
			return new Llvm.VoidType();
		}

		@Override
		public String toString() {
			return "void";
		}
	}

	// OK
	static class BooleanType extends Type {

		@Override
		public String pp() {
			return "";
		}

		@Override
		public boolean equals(Object obj) {
			return obj instanceof BooleanType;
		}

		@Override
		public Llvm.Type toLlvmType() {
			return new Llvm.BooleanType();
		}

		@Override
		public String toString() {
			return "boolean";
		}
	}

	// OK
	static class IntType extends Type {

		@Override
		public String pp() {
			return "INT";
		}

		@Override
		public boolean equals(Object obj) {
			return obj instanceof IntType;
		}

		@Override
		public String toPrintPattern() {
			return "%d";
		}

		@Override
		public Llvm.Type toLlvmType() {
			return new Llvm.IntType();
		}

		@Override
		public String toString() {
			return "int";
		}
	}

	// OK
	static class CharType extends Type {

		public String pp() {
			return "";
		}

		@Override
		public boolean equals(Object obj) {
			return obj instanceof CharType;
		}

		@Override
		public String toPrintPattern() {
			return "%s";
		}

		public Llvm.Type toLlvmType() {
			return new Llvm.CharType();
		}

		@Override
		public String toString() {
			return "char";
		}
	}

	// OK
	static class LabelType extends Type {

		@Override
		public String pp() {
			return "";
		}

		@Override
		public Llvm.Type toLlvmType() {
			return new Llvm.LabelType();
		}

		@Override
		public String toString() {
			return "label";
		}

	}

	static class ArrayType extends Type {

		Type type;
		int size;

		public ArrayType(Type type, int size) {
			assert (type instanceof PointerType);
			this.type = type;
			this.size = size;
		}

		public String toPrintPattern() {
			return this.type.toPrintPattern();
		}

		@Override
		public String pp() {
			return "[" + this.size + "]";
		}

		@Override
		public Llvm.Type toLlvmType() {
			return new Llvm.ArrayType(this.type.toLlvmType(), this.size);
		}

		@Override
		public String toString() {
			return "[" + this.size + " x " + this.type + "]";
		}
	}
}
