package TP2;

import java.util.List;
import java.util.ArrayList;
import java.util.stream.Collectors;

import TP2.Llvm.Instruction;

public class ASD {
  static public class Program {
    List<Fonction> listFonction; // What a program contains. TODO : change when you extend the language
    
    public Program(List<Fonction> listFonction) {
      this.listFonction = listFonction;
    }

    // Pretty-printer
    public String pp() {
      StringBuilder ret = new StringBuilder();
      for(Fonction f : this.listFonction) {
        ret.append(f.pp());
      }
      return ret.toString();
    }

    // IR generation
    public Llvm.IR toIR() throws TypeException {
      // TODO : change when you extend the language

      Llvm.IR ir = new Llvm.IR(Llvm.empty(), Llvm.empty());
      // computes the IR of the expression
      for(Fonction f : this.listFonction) {
        ir.appendCode(f.toIR());
      }
      // add a return instruction

      return ir;
    }
  }

  // All toIR methods returns the IR, plus extra information (synthesized attributes)
  // They can take extra arguments (inherited attributes)

  static public class Fonction {
    
    Type type;
    ID id;
    List<Instruction> instructions = Llvm.empty();
    
    public Fonction(Type type, ID id, List<Instruction> instructions) {
      this.type = type;
        this.id = id;
        if(instructions != null) {
          this.instructions = instructions;
        }
    }
    
    public String pp() {
      return "";
    }
    
    public Llvm.Fonction toIR() {
      Llvm.Fonction f = new Llvm.Fonction(type.toLlvmType(), id.toLlvmID(), instructions);
      return f;
    }
  }
  
  static public abstract class Expression {
    public abstract String pp();
    public abstract RetExpression toIR() throws TypeException;

    // Object returned by toIR on expressions, with IR + synthesized attributes
    static public class RetExpression {
      // The LLVM IR:
      public Llvm.IR ir;
      // And additional stuff:
      public Type type; // The type of the expression
      public String result; // The name containing the expression's result
      // (either an identifier, or an immediate value)

      public RetExpression(Llvm.IR ir, Type type, String result) {
        this.ir = ir;
        this.type = type;
        this.result = result;
      }
    }
  }
  
  // Concrete class for Expression: add case
  static public class AddExpression extends Expression {
    Expression left;
    Expression right;

    public AddExpression(Expression left, Expression right) {
      this.left = left;
      this.right = right;
    }

    // Pretty-printer
    public String pp() {
      return "(" + left.pp() + " + " + right.pp() + ")";
    }

    // IR generation
    public RetExpression toIR() throws TypeException {
      RetExpression leftRet = left.toIR();
      RetExpression rightRet = right.toIR();

      // We check if the types mismatches
      if(!leftRet.type.equals(rightRet.type)) {
        throw new TypeException("type mismatch: have " + leftRet.type + " and " + rightRet.type);
      }

      // We base our build on the left generated IR:
      // append right code
      leftRet.ir.append(rightRet.ir);

      // allocate a new identifier for the result
      String result = Utils.newtmp();

      // new add instruction result = left + right
      Llvm.Instruction add = new Llvm.Add(leftRet.type.toLlvmType(), leftRet.result, rightRet.result, result);

      // append this instruction
      leftRet.ir.appendCode(add);

      // return the generated IR, plus the type of this expression
      // and where to find its result
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

    // Pretty-printer
    public String pp() {
      return "(" + left.pp() + " * " + right.pp() + ")";
    }

    // IR generation
    public RetExpression toIR() throws TypeException {
      RetExpression leftRet = left.toIR();
      RetExpression rightRet = right.toIR();

      // We check if the types mismatches
      if(!leftRet.type.equals(rightRet.type)) {
        throw new TypeException("type mismatch: have " + leftRet.type + " and " + rightRet.type);
      }

      // We base our build on the left generated IR:
      // append right code
      leftRet.ir.append(rightRet.ir);

      // allocate a new identifier for the result
      String result = Utils.newtmp();

      // new add instruction result = left + right
      Llvm.Instruction add = new Llvm.Mul(leftRet.type.toLlvmType(), leftRet.result, rightRet.result, result);

      // append this instruction
      leftRet.ir.appendCode(add);

      // return the generated IR, plus the type of this expression
      // and where to find its result
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

      if(!leftRet.type.equals(rightRet.type)) {
        throw new TypeException("type mismatch: have " + leftRet.type + " and " + rightRet.type);
      }

      leftRet.ir.append(rightRet.ir);

      String result = Utils.newtmp();

      Llvm.Instruction add = new Llvm.SignedDiv(leftRet.type.toLlvmType(), leftRet.result, rightRet.result, result);

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

    // Pretty-printer
    public String pp() {
      return "(" + left.pp() + " - " + right.pp() + ")";
    }

    // IR generation
    public RetExpression toIR() throws TypeException {
      RetExpression leftRet = left.toIR();
      RetExpression rightRet = right.toIR();

      // We check if the types mismatches
      if(!leftRet.type.equals(rightRet.type)) {
        throw new TypeException("type mismatch: have " + leftRet.type + " and " + rightRet.type);
      }

      // We base our build on the left generated IR:
      // append right code
      leftRet.ir.append(rightRet.ir);

      // allocate a new identifier for the result
      String result = Utils.newtmp();

      // new add instruction result = left + right
      Llvm.Instruction add = new Llvm.Sub(leftRet.type.toLlvmType(), leftRet.result, rightRet.result, result);

      // append this instruction
      leftRet.ir.appendCode(add);

      // return the generated IR, plus the type of this expression
      // and where to find its result
      return new RetExpression(leftRet.ir, leftRet.type, result);
    }
  }

  // Concrete class for Expression: constant (integer) case
  static public class IntegerExpression extends Expression {
    int value;
    public IntegerExpression(int value) {
      this.value = value;
    }

    public String pp() {
      return "" + value;
    }

    public RetExpression toIR() {
      // Here we simply return an empty IR
      // the `result' of this expression is the integer itself (as string)
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

  // Warning: this is the type from VSL+, not the LLVM types!
  static public abstract class Type {
    public abstract String pp();
    public abstract Llvm.Type toLlvmType();
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

    @Override public boolean equals(Object obj) {
      return obj instanceof IntType;
    }

    public Llvm.Type toLlvmType() {
      return new Llvm.IntType();
    }
  }
}
