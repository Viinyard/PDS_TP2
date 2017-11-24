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
			Llvm.IR ir = new Llvm.IR(Llvm.empty(), Llvm.empty());

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
			public Type type;
			public String result;

			public RetExpression(Llvm.IR ir, Type type, String result) {
				this.ir = ir;
				this.type = type;
				this.result = result;
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
			ret.ir.appendCode(new Llvm.Return(new Variable(ret.type, ret.result).toLlvm()));

			return new RetExpression(ret.ir, ret.type, ret.result);
		}
	}

	public static class Fonction extends Expression {

		private Variable fonction;
		List<Expression> expressions;
		List<Variable> args;

		public Fonction(Variable fonction, List<Variable> args, List<Expression> expressions) {
			this.fonction = fonction;
			this.expressions = expressions;
			this.args = args;
		}

		public String pp() {
			return "";
		}

		public RetExpression toIR() throws TypeException {
			Utils.resettmp();
			RetExpression ret = new RetExpression(new Llvm.IR(Llvm.empty(), Llvm.empty()), this.fonction.type,
					this.fonction.ident);

			List<Llvm.Variable> llvmArgs = new ArrayList<Llvm.Variable>();
			for (Variable arg : this.args) {
				llvmArgs.add(arg.toLlvm());
			}

			ret.ir.appendCode(new Llvm.Fonction(this.fonction.toLlvm(), llvmArgs));

			ret.ir.appendCode(new Llvm.OpenBlock()); // TODO
			ret.ir.appendCode(new Llvm.Label(new Variable(Variable.local_scope, new LabelType(), "entry").toLlvm()));
			for (Expression s : this.expressions) {
				ret.ir.append(s.toIR().ir);
			}

			if (this.fonction.type.equals(new VoidType())) {
				ret.ir.appendCode(new Llvm.Return(new Variable(Variable.default_scope, new VoidType(), "").toLlvm()));
			} else if (this.fonction.type.equals(new IntType())
					&& this.fonction.var_name.toLowerCase().equals("main")) {
				ret.ir.appendCode(new Llvm.Return(new Variable(Variable.default_scope, new IntType(), "0").toLlvm()));
			}

			ret.ir.appendCode(new Llvm.CloseBlock());

			return ret;
		}
	}
	
	public static class ArrayElement extends Expression {

		private Variable array, result;
		private Variable resultInter;
		private Expression index;

		public ArrayElement(Variable array, Expression index) {
			assert (array.type instanceof PointerType);
			assert (((PointerType) array.type).type instanceof ArrayType);
			
			this.array = array;
			this.index = index;
			
			if(((PointerType) array.type).type instanceof PointerType) {
				this.resultInter = new Variable(Variable.local_scope, ((PointerType) array.type).type, Utils.newtmp());
				this.result = new Variable(Variable.local_scope, ((PointerType) this.resultInter.type), Utils.newtmp());
			} else if(((PointerType) array.type).type instanceof ArrayType) {
				Type t = ((PointerType) this.array.type).type;
				Type t1 = t instanceof ArrayType ? ((ArrayType) t).type : ((PointerType) t).type;
				this.result = new Variable(Variable.local_scope, t1, Utils.newtmp());
			}
		}
		
		public Variable getResult() {
			return this.result;
		}

		@Override
		public String pp() {
			StringBuilder ret = new StringBuilder(this.array.pp());
				ret.append("[" + this.index.pp() + "]");
			return ret.toString();
		}

		@Override
		public RetExpression toIR() throws TypeException {
			RetExpression ret = new RetExpression(new Llvm.IR(Llvm.empty(), Llvm.empty()), this.array.type, "");

			RetExpression index = this.index.toIR();
			ret.ir.append(index.ir);
			if(this.resultInter != null) {
				ret.ir.appendCode(new Llvm.Load(this.array.toLlvm(), this.resultInter.toLlvm()));
				ret.ir.appendCode(new Llvm.ArrayElement(this.result.toLlvm(), this.resultInter.toLlvm(),
						null, new Variable(index.type, index.result).toLlvm()));
			} else {
				ret.ir.appendCode(new Llvm.ArrayElement(this.result.toLlvm(), this.array.toLlvm(),
						new Variable(new IntType(), "0").toLlvm(), new Variable(index.type, index.result).toLlvm()));
			}

			return new RetExpression(ret.ir, this.result.type, this.result.ident);
		}

	}
	
	public static class ArrayValue extends Expression {

		private Variable result;
		private ArrayElement ptr;

		public ArrayValue(ArrayElement ptr) {
			this.result = new Variable(Variable.local_scope, ((PointerType) ptr.getResult().type).type, Utils.newtmp());
			this.ptr = ptr;
		}
		
		public Variable getResult() {
			return this.result;
		}

		@Override
		public String pp() {
			return "todo"; // TODO
		}

		@Override
		public RetExpression toIR() throws TypeException {
			RetExpression ptr = this.ptr.toIR();
			RetExpression ret = new RetExpression(new Llvm.IR(Llvm.empty(), Llvm.empty()), this.result.type, this.result.ident);
			ret.ir.append(ptr.ir);
			ret.ir.appendCode(new Llvm.Load(new Variable(ptr.type, ptr.result).toLlvm(),
					this.result.toLlvm()));

			return ret;
		}

	}

	public static class CallFonction extends Expression {

		Variable fonction, result;
		List<Expression> args;
		String cast;

		public CallFonction(Variable fonction, List<Expression> args) {
			this(fonction, "", args);
		}

		public CallFonction(Variable fonction, String cast, List<Expression> args) {
			this.fonction = fonction;
			this.args = args;
			this.cast = cast;
			this.result = (this.fonction.type instanceof VoidType) ? null : new Variable(Variable.local_scope, fonction.type, Utils.newtmp());
		}
		
		public Variable getResult() {
			return this.result;
		}

		@Override
		public String pp() {
			StringBuilder ret = new StringBuilder(this.fonction.ident + "(");
			for (Expression e : this.args) {
				ret.append(e.pp());
			}
			ret.append(")");
			return ret.toString();
		}

		@Override
		public RetExpression toIR() throws TypeException {
			RetExpression ret = new RetExpression(new Llvm.IR(Llvm.empty(), Llvm.empty()), this.fonction.type, (this.result != null ? this.result.ident : ""));

			List<RetExpression> retargs = new ArrayList<RetExpression>();

			for (Expression e : this.args) {
				retargs.add(e.toIR());
			}

			retargs.forEach(p -> ret.ir.append(p.ir));

			List<Llvm.Variable> varArgs = new ArrayList<Llvm.Variable>();

			for (RetExpression r : retargs) {
				varArgs.add(new Variable(r.type, r.result).toLlvm());
			}
			ret.ir.appendCode(new Llvm.CallFonction(this.fonction.toLlvm(), this.cast, this.result == null ? null : this.result.toLlvm(), varArgs));

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
			RetExpression ret = new RetExpression(new Llvm.IR(Llvm.empty(), Llvm.empty()), this.variable.type, this.variable.ident);
			// ret.ir.appendCode(new Llvm.DeclareFonction(type.toLlvmType(), ident));

			return ret;
		}
	}

	/*
	 * VARIABLES
	 */

	public static class BooleanExpression extends Expression {

		private Expression expression;
		private Variable result;

		public BooleanExpression(Expression expression) {
			this.expression = expression;
			this.result = new Variable(Variable.local_scope, new BooleanType(), Utils.newtmp());
			
		}
		
		@Override
		public String pp() {
			return this.expression.pp();
		}

		@Override
		public RetExpression toIR() throws TypeException {
			RetExpression left = this.expression.toIR(), right = new IntegerExpression(0).toIR();

			if (!left.type.equals(right.type)) {
				throw new TypeException("type mismatch: have " + left.type + " and " + right.type);
			}

			left.ir.append(right.ir);

			left.ir.appendCode(new Llvm.ICMP(this.result.toLlvm(),
					new Llvm.Variable(Variable.local_scope, left.type.toLlvmType(), left.result),
					new DifferentCond().toLlvmCond(),
					new Llvm.Variable(Variable.local_scope, right.type.toLlvmType(), right.result)));

			return new RetExpression(left.ir, result.type, result.ident);
		}

	}

	// OK
	public static class StringConstant extends Expression {

		private Variable string, value;
		private String text;

		public StringConstant(String text) {
			LLVMStringConstant c = Utils.stringTransform(text);
			this.string = new Variable(Variable.global_scope,
					new PointerType(new ArrayType(new PointerType(new CharType()), String.valueOf(c.length))),
					Utils.newglob(".str"));
			this.value = new Variable(Variable.local_scope,((ArrayType) ((PointerType) this.string.type).type).type, Utils.newtmp());
			this.text = "\"" + c.str + "\"";
		}
		
		public StringConstant(Variable value, String text) {
			this(text);
			this.value = value;
		}

		@Override
		public String pp() {
			return this.text;
		}

		@Override
		public RetExpression toIR() throws TypeException {
			RetExpression ret = new RetExpression(new Llvm.IR(Llvm.empty(), Llvm.empty()), this.value.type, this.value.ident);

			ret.ir.appendHeader(new Llvm.StringConstant(this.string.toLlvm(), this.text));

			ret.ir.appendCode(new Llvm.ArrayElement(value.toLlvm(), string.toLlvm(),
					new Variable(new IntType(), "0").toLlvm(), new Variable(new IntType(), "0").toLlvm()));

			return ret;
		}
	}

	public static class PrintFunction extends Expression {

		private Variable fonction, result, pattern;
		List<Expression> args;

		public PrintFunction(List<Expression> args) {
			this.args = args;
			this.fonction = new Variable(Variable.global_scope, new IntType(), "printf");
			this.pattern = new Variable(Variable.local_scope, new PointerType(new CharType()), Utils.newtmp());
			this.result = new Variable(Variable.local_scope, this.fonction.type, Utils.newtmp());
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

			for(Expression e : this.args) {
				retargs.add(e.toIR());
			}

			StringBuilder pattern = new StringBuilder();

			retargs.forEach(p -> {
				pattern.append(p.type.toPrintPattern());
			});

			RetExpression patternExp = new StringConstant(this.pattern, pattern.toString()).toIR();

			RetExpression ret = new RetExpression(new Llvm.IR(Llvm.empty(), Llvm.empty()), this.result.type,
					this.result.ident);


			for(RetExpression r : retargs) {
				ret.ir.append(r.ir);
			}

			ret.ir.append(patternExp.ir);

			List<Llvm.Variable> varArgs = new ArrayList<Llvm.Variable>();
			varArgs.add(new Variable(patternExp.type, patternExp.result).toLlvm());

			for(RetExpression r : retargs) {
				varArgs.add(new Variable(r.type, r.result).toLlvm());
			}

			ret.ir.appendCode(new Llvm.CallFonction(this.fonction.toLlvm(), "(i8*, ...)", this.result.toLlvm(),
					varArgs));

			return ret;
		}

	}

	// OK
	public static class Variable extends Expression {

		public static final int local_scope = 0;
		public static final int global_scope = 1;
		public static final int default_scope = 2;

		private static final String[] scope_token = { "%", "@", "" };

		Type type;
		String var_name;
		String ident;
		int scope;

		public String toString() {
			return type + " " + ident + " " + scope + " " + var_name;
		}

		public Variable(Type type, String ident) {
			this(Variable.default_scope, type, ident);
		}

		public Variable(int scope, Type type, String ident) {
			//assert (type instanceof PointerType) : ident + " of type : " + type + " is not a pointer ";
			this.type = type;
			this.var_name = ident;
			this.ident = Variable.scope_token[scope] + ident;
			this.scope = scope;
		}

		@Override
		public boolean equals(Object obj) {
			if (obj == null)
				return false;
			if (obj == this)
				return true;
			if (!(obj instanceof Variable))
				return false;
			Variable o = (Variable) obj;
			return this.type.equals(o.type) && this.ident.equals(o.ident) && this.scope == o.scope;
		}

		@Override
		public String pp() {
			return this.ident;
		}

		public Llvm.Variable toLlvm() {
			return new Llvm.Variable(this.scope, this.type.toLlvmType(), this.ident);
		}

		@Override
		public RetExpression toIR() throws TypeException {
			return new RetExpression(new Llvm.IR(Llvm.empty(), Llvm.empty()), this.type, this.ident);
		}
	}

	public static class ReadFunction extends Expression {

		private List<Expression> args;
		private Variable fonction, result, pattern;

		public ReadFunction(List<Expression> args) {
			this.args = args;
			this.fonction = new Variable(Variable.global_scope, new IntType(), "scanf");
			this.pattern = new Variable(Variable.local_scope, new PointerType(new CharType()), Utils.newtmp());
			this.result = new Variable(Variable.local_scope, this.fonction.type, Utils.newtmp());
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
			StringBuilder pattern = new StringBuilder();
			List<Variable> vars = new ArrayList<Variable>();
			RetExpression ret = new RetExpression(new Llvm.IR(Llvm.empty(), Llvm.empty()), this.result.type,
					this.result.ident);
			for(Expression r : this.args) {
				RetExpression ex = r.toIR();
				ret.ir.append(ex.ir);
				Variable v = new Variable(ex.type, ex.result);
				vars.add(v);
				pattern.append(v.type.toPrintPattern());
			}

			RetExpression patternExp = new StringConstant(this.pattern, pattern.toString()).toIR();


			ret.ir.append(patternExp.ir);

			List<Llvm.Variable> varArgs = new ArrayList<Llvm.Variable>();
			varArgs.add(new Variable(patternExp.type, patternExp.result).toLlvm());

			for(Variable v : vars) {
				varArgs.add(v.toLlvm());
				ret.ir.append(v.toIR().ir);
			}

			ret.ir.appendCode(new Llvm.CallFonction(fonction.toLlvm(), "(i8*, ...)", this.result.toLlvm(), varArgs));

			return ret;
		}
	}

	// OK
	public static class Value extends Expression {

		private Variable variable;
		private Variable result;

		public Value(Variable variable) {
			assert (variable.type instanceof PointerType);
			this.variable = variable;
			this.result = new Variable(Variable.local_scope, ((PointerType) variable.type).type, Utils.newtmp());
		}
		
		public Variable getResult() {
			return this.result;
		}

		@Override
		public String pp() {
			return this.variable.ident;
		}

		@Override
		public RetExpression toIR() throws TypeException {
//			Variable value = new Variable(Variable.local_scope, ((PointerType) this.variable.type).type, Utils.newtmp());
			RetExpression ret = new RetExpression(new Llvm.IR(Llvm.empty(), Llvm.empty()),
					this.result.type, this.result.ident);
			ret.ir.appendCode(new Llvm.Load(this.variable.toLlvm(),
					this.result.toLlvm()));
			return ret;
		}
	}

	// OK
	public static class Affectation extends Expression {

		Variable variable;
		Expression expression;

		public Affectation(Variable variable, Expression expression) {
			assert(variable.type instanceof PointerType);
			this.variable = variable;
			this.expression = expression;
		}

		@Override
		public String pp() {
			return null; // TODO
		}

		@Override
		public RetExpression toIR() throws TypeException {
			RetExpression value = this.expression.toIR();
			RetExpression variable = this.variable.toIR();
			value.ir.append(variable.ir);
			value.ir.appendCode(new Llvm.Affectation(
					this.variable.toLlvm(),
					new Llvm.Variable(Variable.local_scope, value.type.toLlvmType(), value.result)));

			return value;
		}
	}

	public static class ArrayInstanciation extends Expression {

		private Variable variable;
		private Expression expression;
		
		public ArrayInstanciation(Variable variable, Expression expression) {
			this.variable = variable;
			this.expression = expression;
		}
		
		@Override
		public String pp() {
			// TODO Auto-generated method stub
			return "todo";
		}

		@Override
		public RetExpression toIR() throws TypeException {
			RetExpression ret = new RetExpression(new Llvm.IR(Llvm.empty(), Llvm.empty()), this.variable.type,
					this.variable.ident);
			RetExpression exp = this.expression.toIR();
			ret.ir.append(exp.ir);
			
			Variable array = new Variable(new PointerType(new ArrayType(this.variable.type, exp.result)), this.variable.ident);
			
			ret.ir.appendCode(new Llvm.Instanciation(
					array.toLlvm()));
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
			return this.variable.type.pp() + " " + this.variable.pp() + "\n";
		}

		@Override
		public RetExpression toIR() throws TypeException {
			RetExpression ret = new RetExpression(new Llvm.IR(Llvm.empty(), Llvm.empty()), this.variable.type,
					this.variable.ident);
			ret.ir.appendCode(new Llvm.Instanciation(
					new Llvm.Variable(this.variable.scope, this.variable.type.toLlvmType(), this.variable.ident)));
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
		private Variable result;

		public Condition(Expression left, Cond cond, Expression right) {
			this.result = new Variable(Variable.local_scope, new BooleanType(), Utils.newtmp());
			this.left = left;
			this.cond = cond;
			this.right = right;
		}
		
		public Variable getResult() {
			return this.result;
		}

		@Override
		public String pp() {
			return this.left.pp() + " " + this.cond.pp() + " " + this.right.pp();
		}

		@Override
		public RetExpression toIR() throws TypeException {
			RetExpression left = this.left.toIR(), right = this.right.toIR();

			if (!left.type.equals(right.type)) {
				throw new TypeException("type mismatch: have " + left.type + " and " + right.type);
			}

			left.ir.append(right.ir);

			left.ir.appendCode(new Llvm.ICMP(this.result.toLlvm(),
					new Llvm.Variable(Variable.local_scope, left.type.toLlvmType(), left.result),
					this.cond.toLlvmCond(),
					new Llvm.Variable(Variable.local_scope, right.type.toLlvmType(), right.result)));

			return new RetExpression(left.ir, result.type, result.ident);
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
			Variable cond = new Variable(boucle.type, boucle.result);
			Variable labelThen = new Variable(Variable.local_scope, new LabelType(), Utils.newlab("then")),
					labelElse = new Variable(Variable.local_scope, new LabelType(), Utils.newlab("else")),
					labelFi = new Variable(Variable.local_scope, new LabelType(), Utils.newlab("fi"));

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

			return new RetExpression(boucle.ir, new VoidType(), "");
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
			RetExpression boucle = new RetExpression(new Llvm.IR(Llvm.empty(), Llvm.empty()), new VoidType(), "");
			RetExpression condition = this.condition.toIR();
			Variable cond = new Variable(Variable.default_scope, condition.type, condition.result);
			Variable labelEntry = new Variable(Variable.local_scope, new LabelType(), Utils.newlab("entry")),
					labelDo = new Variable(Variable.local_scope, new LabelType(), Utils.newlab("do")),
					labelDone = new Variable(Variable.local_scope, new LabelType(), Utils.newlab("done"));

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
			RetExpression boucle = new RetExpression(new Llvm.IR(Llvm.empty(), Llvm.empty()), new VoidType(), "");
			RetExpression condition = this.condition.toIR();
			boucle.ir.append(condition.ir);
			Variable cond = new Variable(condition.type, condition.result);
			Variable labelThen = new Variable(Variable.local_scope, new LabelType(), Utils.newlab("then")),
					labelFi = new Variable(Variable.local_scope, new LabelType(), Utils.newlab("fi"));

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
			return new RetExpression(new Llvm.IR(Llvm.empty(), Llvm.empty()), new IntType(), "" + this.value);
		}
	}

	// OK
	public static class AddExpression extends Expression {

		private Expression left, right;
		private Variable result;

		public AddExpression(Variable result, Expression left, Expression right) {
			this.result = result;
			this.left = left;
			this.right = right;
		}

		public String pp() {
			return "(" + this.left.pp() + " + " + this.right.pp() + ")";
		}

		public RetExpression toIR() throws TypeException {
			RetExpression left = this.left.toIR();
			RetExpression right = this.right.toIR();

			if (!left.type.equals(right.type)) {
				throw new TypeException("type mismatch: have " + left.type + " and " + right.type);
			}

			left.ir.append(right.ir);

			left.ir.appendCode(new Llvm.Add(this.result.toLlvm(), left.result, right.result));

			return new RetExpression(left.ir, this.result.type, this.result.ident);
		}
	}

	// OK
	public static class MulExpression extends Expression {

		private Expression left, right;
		private Variable result;

		public MulExpression(Variable result, Expression left, Expression right) {
			this.result = result;
			this.left = left;
			this.right = right;
		}

		public String pp() {
			return "(" + this.left.pp() + " * " + this.right.pp() + ")";
		}

		public RetExpression toIR() throws TypeException {
			RetExpression left = this.left.toIR();
			RetExpression right = this.right.toIR();

			if (!left.type.equals(right.type)) {
				throw new TypeException("type mismatch: have " + left.type + " and " + right.type);
			}

			left.ir.append(right.ir);

			left.ir.appendCode(new Llvm.Mul(this.result.toLlvm(), left.result, right.result));

			return new RetExpression(left.ir, this.result.type, this.result.ident);
		}
	}

	// OK.
	public static class SignedDivExpression extends Expression {

		private Expression left, right;
		private Variable result;

		public SignedDivExpression(Variable result, Expression left, Expression right) {
			this.result = result;
			this.left = left;
			this.right = right;
		}

		public String pp() {
			return "(" + this.left.pp() + " / " + this.right.pp() + ")";
		}

		public RetExpression toIR() throws TypeException {
			RetExpression left = this.left.toIR();
			RetExpression right = this.right.toIR();

			if (!left.type.equals(right.type)) {
				throw new TypeException("type mismatch: have " + left.type + " and " + right.type);
			}

			left.ir.append(right.ir);

			left.ir.appendCode(new Llvm.Div(this.result.toLlvm(), left.result, right.result));

			return new RetExpression(left.ir, this.result.type, this.result.ident);
		}
	}

	// OK
	public static class SubExpression extends Expression {

		private Expression left, right;
		private Variable result;

 		public SubExpression(Variable result, Expression left, Expression right) {
			this.result = result;
 			this.left = left;
			this.right = right;
		}

		public String pp() {
			return "(" + this.left.pp() + " - " + this.right.pp() + ")";
		}

		public RetExpression toIR() throws TypeException {
			RetExpression left = this.left.toIR();
			RetExpression right = this.right.toIR();

			if (!left.type.equals(right.type)) {
				throw new TypeException("type mismatch: have " + left.type + " and " + right.type);
			}

			left.ir.append(right.ir);

			left.ir.appendCode(new Llvm.Sub(this.result.toLlvm(), left.result, right.result));
			return new RetExpression(left.ir, this.result.type, this.result.ident);
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
		String size;

		public ArrayType(Type type, String size) {
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
