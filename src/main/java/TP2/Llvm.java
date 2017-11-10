package TP2;

import java.util.List;
import java.util.ArrayList;

// This file contains a simple LLVM IR representation
// and methods to generate its string representation

public class Llvm {
  static public class IR {
    List<Instruction> header; // IR instructions to be placed before the code (global definitions)
    List<Instruction> code;   // main code

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
      StringBuilder r = new StringBuilder("; Target\n" +
        "target triple = \"x86_64-unknown-linux-gnu\"\n" +
        "; External declaration of the printf function\n" +
        "declare i32 @printf(i8* noalias nocapture, ...)\n" +
        "\n; Actual code begins\n\n");

      for(Instruction inst: header)
        r.append(inst);

      r.append("\n\n");

      // We create the function main
      // TODO : remove this when you extend the language
//      r.append("define i32 @main() {\n");


      for(Instruction inst: code)
        r.append(inst);

      // TODO : remove this when you extend the language
//      r.append("}\n");

      return r.toString();
    }
  }

  // Returns a new empty list of instruction, handy
  static public List<Instruction> empty() {
    return new ArrayList<Instruction>();
  }


  static public abstract class ID {
    String identifiant = "";
    public ID(String identifiant) {
      this.identifiant = identifiant;
    }
    public abstract String toString();
  }
  
  static public class GlobalID extends ID {

  public GlobalID(String identifiant) {
    super(identifiant);
  }

  @Override
  public String toString() {
    return "@"+this.identifiant;
  }
    
  }
  
  // LLVM Types
  static public abstract class Type {
    public abstract String toString();
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

  // TODO : other types


  // LLVM IR Instructions
  static public abstract class Instruction {
    public abstract String toString();
  }


  static public class Fonction extends Instruction {
    Type type;
    ID id;
    List<Instruction> instructions = Llvm.empty();

    public Fonction(Type type, ID id, List<Instruction> instructions) {
      this.type = type;
      this.id = id;
      if(instructions != null) {
        this.instructions = instructions;
        if(type instanceof VoidType) {
          this.instructions.add(new Return(type, ""));
        }
      }
    }

    public String toString() {
      StringBuilder ret = new StringBuilder("define " + type + " " +id+ "()" + " {\n");
      for(Instruction i : this.instructions) {
        ret.append(i);
      }
      ret.append("}\n");
      return ret.toString();
    }
  }

  static public class SignedDiv extends Instruction {
    Type type;
    String left;
    String right;
    String lvalue;

    public SignedDiv(Type type, String left, String right, String lvalue) {
      this.type = type;
      this.left = left;
      this.right = right;
      this.lvalue = lvalue;
    }

    public String toString() {
      return lvalue + " = sdiv " + type + " " + left + ", " + right +  "\n";
    }
  }

  static public class Add extends Instruction {
    Type type;
    String left;
    String right;
    String lvalue;

    public Add(Type type, String left, String right, String lvalue) {
      this.type = type;
      this.left = left;
      this.right = right;
      this.lvalue = lvalue;
    }

    public String toString() {
      return lvalue + " = add " + type + " " + left + ", " + right +  "\n";
    }
  }

  static public class Mul extends Instruction {
    Type type;
    String left;
    String right;
    String lvalue;

    public Mul(Type type, String left, String right, String lvalue) {
      this.type = type;
      this.left = left;
      this.right = right;
      this.lvalue = lvalue;
    }

    public String toString() {
      return lvalue + " = mul " + type + " " + left + ", " + right +  "\n";
    }
  }
  
  static public class Sub extends Instruction {
    Type type;
    String left;
    String right;
    String lvalue;

    public Sub(Type type, String left, String right, String lvalue) {
      this.type = type;
      this.left = left;
      this.right = right;
      this.lvalue = lvalue;
    }

    public String toString() {
      return lvalue + " = sub " + type + " " + left + ", " + right +  "\n";
    }
  }

  static public class Return extends Instruction {
    Type type;
    String value;

    public Return(Type type, String value) {
      this.type = type;
      this.value = value;
    }

    public String toString() {
      return "ret " + type + " " + value + "\n";
    }
  }

  // TODO : other instructions
}
