package TP2;

import java.util.List;

public class ASD {
  static public class Program {
    List<Fonction> listFonction;

    public Program(List<Fonction> listFonction) {
      this.listFonction = listFonction;
    }

    public String pp() {
      StringBuilder ret = new StringBuilder();

      for (Fonction f : this.listFonction) {
        ret.append(f.pp());
      }

      return ret.toString();
    }

    public Llvm.IR toIR() throws TypeException {
      Llvm.IR ir = new Llvm.IR(Llvm.empty(), Llvm.empty());

      for (Fonction f : this.listFonction) {
        ir.append(f.toIR().ir);
      }

      return ir;
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
    ID id;
    List<Expression> expressions;
    Llvm.IR ir;

    public Fonction(Type type, ID id, List<Expression> expressions) {
      this.type = type;
      this.id = id;
      this.expressions = expressions;
    }

    public String pp() {
      return "";
    }

    public RetExpression toIR() throws TypeException {
      this.ir = new Llvm.IR(Llvm.empty(), Llvm.empty());
      Llvm.Fonction f = new Llvm.Fonction(type.toLlvmType(), id.toLlvmID());
      this.ir.appendCode(f);
      this.ir.appendCode(new Llvm.OpenBlock());

      for (Expression s : this.expressions) {
        ir.append(s.toIR().ir);
      }
      
      this.ir.appendCode(new Llvm.CloseBlock());

      return new RetExpression(this.ir, this.type, "");
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

  static public abstract class ID {
    String identifiant = "";

    public ID(String identifiant) {
      this.identifiant = identifiant;
    }

    public abstract String pp();

    public abstract Llvm.ID toLlvmID();
  }

  static public class GlobalID extends ID {

    public GlobalID(String identifiant) {
      super(identifiant);
    }

    @Override
    public String pp() {
      // TODO Auto-generated method stub
      return null;
    }

    @Override
    public Llvm.ID toLlvmID() {
      return new Llvm.GlobalID(this.identifiant);
    }
  }

  static public abstract class Type {
    public abstract String pp();

    public abstract Llvm.Type toLlvmType();
  }
  
  static public class Affectation extends Expression {
    
    Variable variable;
    Expression expression;
    
    public Affectation(Variable variable, Expression expression) {
      this.variable = variable;
      this.expression = expression;
    }
    
    @Override
    public String pp() {
      return variable.pp() + expression.pp();
    }

    @Override
    public RetExpression toIR() throws TypeException {
      RetExpression ret = this.expression.toIR();
      
      ret.ir.appendCode(new Llvm.Affectation(this.variable.toIR().result, ret.result));
      
      return ret;
    }
    
  }
  
  static public class Instanciation extends Expression {

    Variable variable;
    
    public Instanciation(Variable variable) {
      this.variable = variable;
    }
    
    @Override
    public String pp() {
      return this.variable.pp() + "\n";
    }

    @Override
    public RetExpression toIR() throws TypeException {
      RetExpression ret = this.variable.toIR();
      ret.ir.appendCode(new Llvm.Allocation(ret.type.toLlvmType(), ret.result));
      return ret;
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
      return type.pp() + ident;
    }

    @Override
    public RetExpression toIR() throws TypeException {
      return new RetExpression(new Llvm.IR(Llvm.empty(), Llvm.empty()), type, ident);
    }
    
  }

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
      return new Llvm.IntType();
    }
  }
}