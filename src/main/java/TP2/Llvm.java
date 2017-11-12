package TP2;

import java.util.ArrayList;
import java.util.List;

// This file contains a simple LLVM IR representation
// and methods to generate its string representation

public class Llvm {
  
  static int lvl = 0;
  
  public static String printLvl(int level) {
    StringBuilder str = new StringBuilder();
    for (int i = 0; i < level; i++) {
      str.append("\t");
    }
    return str.toString();
  }
  
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

  static public abstract class ID {
    
    String identifiant = "";
    protected int level;

    public ID(String identifiant) {
      this.identifiant = identifiant;
      this.level = Llvm.lvl;
    }

    public abstract String toString();
  }

  static public class GlobalID extends ID {
    
    public GlobalID(String identifiant) {
      super(identifiant);
    }

    @Override
    public String toString() {
      return Llvm.printLvl(this.level) + "@" + this.identifiant;
    }
  }
  
  static public abstract class Type {
    public abstract String toString();
  }

  static public class StringType extends Type {
    public String toString() {
      return "i8*";
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

  static public class Fonction extends Instruction {
    Type type;
    ID id;

    public Fonction(Type type, ID id) {
      super();
      this.type = type;
      this.id = id;
    }

    public String toString() {
      return Llvm.printLvl(this.level) + "define " + type + " " + id + "()";
    }
  }
  
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
      return Llvm.printLvl(this.level) + lvalue + " = udiv " + type + " " + left + ", " + right + "\n";
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
      return Llvm.printLvl(this.level) + lvalue + " = add " + type + " " + left + ", " + right + "\n";
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
      return Llvm.printLvl(this.level) + lvalue + " = mul " + type + " " + left + ", " + right + "\n";
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
      return Llvm.printLvl(this.level) + lvalue + " = sub " + type + " " + left + ", " + right + "\n";
    }
  }
  
  static public class Affectation extends Instruction {

    String var;
    String value;
    
    public Affectation(String var, String value) {
      this.var = var;
      this.value = value;
    }
    
    @Override
    public String toString() {
      return this.var + " = " + this.value;
    }
    
  }
  
  static public class Allocation extends Instruction {

    Type type;
    String var;
    
    public Allocation(Type type, String var) {
      this.type = type;
      this.var = var;
    }
    
    @Override
    public String toString() {
      return this.var + " =  alloca " + this.type + "\n";
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
      return Llvm.printLvl(this.level) +"ret " + type + " " + value + "\n";
    }
  }
}