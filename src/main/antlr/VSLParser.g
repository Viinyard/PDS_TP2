parser grammar VSLParser;

options {
  language = Java;
  tokenVocab = VSLLexer;
}

@header {
  package TP2;

  import java.util.stream.Collectors;
  import java.util.Arrays;
  import java.util.HashMap;
}

program returns [ASD.Program out]
  @init {
    List<ASD.Expression> listExpression = new ArrayList<ASD.Expression>();
    SymbolTable table = new SymbolTable();
  }
  :
    (fonction[table] {
      listExpression.add($fonction.out);
    })* EOF {
      $out = new ASD.Program(listExpression);
    }
  ;

fonction [SymbolTable table] returns [ASD.Expression out]
  @init {
    SymbolTable funcTable = new SymbolTable(table);
  }
  : FUNC_TYPE type ident {
      ASD.Variable returnVariable = null;

      if(!($type.retType instanceof ASD.VoidType)) {
        returnVariable = new ASD.Variable(ASD.Variable.local_scope, new ASD.PointerType($type.retType));
        funcTable.add("RETURN", new SymbolTable.VariableSymbol(returnVariable));
      }
    } PO argsDecl[funcTable] PF block[funcTable] {
      SymbolTable.Symbol proto = funcTable.lookup($ident.text);
      if(proto != null && ((SymbolTable.FunctionSymbol) proto).defined) {
        throw new RedefinitionException($ident.text + " already defined !");
      }

      ASD.Variable func = new ASD.Variable(ASD.Variable.global_scope, $type.retType, $ident.text);
      SymbolTable.FunctionSymbol f = new SymbolTable.FunctionSymbol(func, $argsDecl.argTable, true);
      table.add($ident.text, f );
      if(proto != null && proto instanceof SymbolTable.FunctionSymbol) {
        if(!f.equals(proto)) {
          throw new IllegalArgumentException("Conflit type with " + $ident.text);
        }
      }



      $out = new ASD.Fonction(func, $argsDecl.out, returnVariable, $block.out);
    }
  |
    PROTO_TYPE type ident PO argsDecl[funcTable] PF {
      ASD.Variable func = new ASD.Variable(ASD.Variable.global_scope, $type.retType, $ident.text);
      table.add($ident.text, new SymbolTable.FunctionSymbol(func, $argsDecl.argTable, false));
      $out = new ASD.ProtoFonction(func);
    }
  ;

argsDecl [SymbolTable table] returns [List<ASD.Argument> out, List<ASD.Expression> initExpr, SymbolTable argTable]
  @init {
    List<ASD.Argument> args = new ArrayList<ASD.Argument>(); // arguments, pour definition de la fonction
    SymbolTable t = new SymbolTable(); // SymbolTable vierge, sans les variable globale, pour signature de la fonction
  }
  @after {
    $out = args;
    $argTable = t;
  }
  :
    (argDecl {
      ASD.Argument arg = $argDecl.out;
      args.add(arg);
      t.add(arg.ident, new SymbolTable.VariableSymbol(arg.arg));
      table.add(arg.ident, new SymbolTable.VariableSymbol(arg.ptr));
    } (SEP argDecl {
      arg = $argDecl.out;
      args.add(arg);
      t.add(arg.ident, new SymbolTable.VariableSymbol(arg.arg));
      table.add(arg.ident, new SymbolTable.VariableSymbol(arg.ptr));
    })*)?
  ;

argDecl  returns [ASD.Argument out]
  :
    ident {
      System.err.println("no type specified, default : int");
      $out = new ASD.Argument(new ASD.Variable(ASD.Variable.local_scope, new ASD.IntType()), $ident.text);
    }
  |
    type ident {
      $out = new ASD.Argument(new ASD.Variable(ASD.Variable.local_scope, $type.retType), $ident.text);
    }
  |
    ident TO TC {
      System.err.println("no type specified, default : int*");
      $out = new ASD.Argument(new ASD.Variable(ASD.Variable.local_scope, new ASD.PointerType(new ASD.IntType())), $ident.text);
    }
  |
    type ident TO TC {
      $out = new ASD.Argument(new ASD.Variable(ASD.Variable.local_scope, new ASD.PointerType($type.retType)), $ident.text);
    }
  ;

block [SymbolTable table] returns [List<ASD.Expression> out]
  @init {
    List<ASD.Expression> statements = new ArrayList<ASD.Expression>();
    SymbolTable newTable = new SymbolTable(table);
  }
  :
    BO (statement[newTable] {
      statements.addAll($statement.out);
    })* BF { $out = statements; }
  |
    statement[newTable] {
      statements.addAll($statement.out);
      $out = statements;
    }
  ;

innerBlock [SymbolTable table] returns [List<ASD.Expression> out]
  @init {
    List<ASD.Expression> statements = new ArrayList<ASD.Expression>();
    SymbolTable newTable = new SymbolTable(table);
  }
  :
    BO (statement[newTable] {
      statements.addAll($statement.out);
    })* BF { $out = statements; }
  ;

identExp [SymbolTable table] returns [ASD.Expression out]
  :
    ident {
      SymbolTable.VariableSymbol s = (SymbolTable.VariableSymbol) table.lookup($ident.text);
      if(s == null) { throw new SymbolException("Cannot find symbol " + $ident.text); }
      $out = s.variable;
    }
  |
    ident TO expression[table] TC {
      SymbolTable.VariableSymbol s = (SymbolTable.VariableSymbol) table.lookup($ident.text);
      if(s == null) { throw new SymbolException("Cannot find symbol " + $ident.text); }
      $out = new ASD.ArrayElement(s.variable, $expression.out);
    }
  ;

statement [SymbolTable table] returns [List<ASD.Expression> out]
  @init {
    List<ASD.Expression> expressions = new ArrayList<ASD.Expression>();
  }
  @after {
    $out = expressions;
  }
  :
     ident PO args[table] PF {
        SymbolTable.FunctionSymbol s = (SymbolTable.FunctionSymbol) table.lookup($ident.text);
        if(s == null) { throw new SymbolException("Cannot find symbol " + $ident.text); }
        if(!s.arguments.equals($args.arguments)) {
          throw new IllegalExpressionException("Invalid reference to function "+$ident.text+" with wrong type !");
        }
        expressions.add(new ASD.CallFonction(s.variable, $args.out));
      }
  |
    innerBlock[table] {
      expressions.addAll($innerBlock.out);
    }
  |
    RETURN_STMNT expression[table] {
      SymbolTable.Symbol s = table.lookup("RETURN");
      if(s == null) { throw new IllegalExpressionException("Cannot return with the type void"); }
      expressions.add(new ASD.Affectation(s.variable, $expression.out));
    }
  |
    PRINT args[table] {
      expressions.add(new ASD.PrintFunction($args.out));
    }
  |

    READ { ArrayList<ASD.Expression> idents = new ArrayList<ASD.Expression>(); } identExp[table] {
        idents.add($identExp.out);
      } (SEP identExp[table] {
          idents.add($identExp.out);
        })* {
        expressions.add(new ASD.ReadFunction(idents));
      }
  |
    localdeclaration[table] {
      expressions = $localdeclaration.out;
    }
  |
    affectation[table] {
      expressions.addAll($affectation.out);
    }
  |
    IF condition[table] THEN block[table] FI {
      expressions.add(new ASD.If($condition.out, $block.out));
    }
  |
    IF condition[table] THEN t=block[table] ELSE f=block[table] FI {
      expressions.add(new ASD.IfElse($condition.out, $t.out, $f.out));
      //$out = expressions;
    }
  |
    WHILE condition[table] DO block[table] DONE {
      expressions.add(new ASD.While($condition.out, $block.out));
      //$out = expressions;
    }
;

condition [SymbolTable table] returns [ASD.Expression out]
  :
    expression[table] {
      $out = new ASD.BooleanExpression($expression.out);
    }
  |
    l=expression[table] cond r=expression[table] {
      $out = new ASD.Condition($l.out, $cond.out, $r.out);
    }
  ;

cond returns [ASD.Cond out]
  :
    NE { $out = new ASD.DifferentCond(); }
  |
    EQ { $out = new ASD.EqualCond(); }
  |
    GT { $out = new ASD.GreaterThanCond(); }
  |
    LT { $out = new ASD.LessThanCond(); }
  |
    GTE { $out = new ASD.GreaterThanOrEqualCond(); }
  |
    LTE { $out = new ASD.LessThanOrEqualCond(); }
  ;

affectation [SymbolTable table] returns [List<ASD.Expression> out]
  @init {
    List<ASD.Expression> retExprs = new ArrayList<ASD.Expression>();
  }
  @after {
    $out = retExprs;
  }
  :
    ident EQUAL expression[table] {
      SymbolTable.Symbol s = table.lookup($ident.text);
      if(s == null) { throw new SymbolException("Cannot find symbol " + $ident.text); }
      retExprs.add(new ASD.Affectation(s.variable, $expression.out));
    }
  |
    ident TO i=expression[table] TC  {
      SymbolTable.Symbol s = table.lookup($ident.text);
      if(s == null) { throw new SymbolException("Cannot find symbol " + $ident.text); }
      ASD.ArrayElement arElem = new ASD.ArrayElement(s.variable, $i.out);
    }  EQUAL v=expression[table] {
      retExprs.add(new ASD.Affectation(arElem, $v.out));
    }
  ;

localdeclaration [SymbolTable table] returns [List<ASD.Expression> out]
  @init {
    List<ASD.Expression> decls = new ArrayList<ASD.Expression>();

  }
  :
    type identVar[table, new ASD.PointerType($type.retType)] {
        decls.add($identVar.out);
      } (SEP identVar[table, new ASD.PointerType($type.retType)] {
        decls.add($identVar.out);
      })* {
        $out = decls;
      }
  ;

identVar [SymbolTable table, ASD.Type t] returns [ASD.Expression out, String text]
  :
    ident {
      ASD.Variable var = new ASD.Variable(ASD.Variable.local_scope, $t);
      table.add($ident.text, new SymbolTable.VariableSymbol(var));
      $text = $ident.text;
      $out = new ASD.Instanciation(var);
    }
  |
    ident TO INTEGER TC {
      ASD.Variable array = new ASD.Variable(ASD.Variable.local_scope, new ASD.PointerType(new ASD.ArrayType($t, $INTEGER.int)));
      $out = new ASD.Instanciation(array);
      table.add($ident.text, new SymbolTable.VariableSymbol(array));
    }
  ;

expression [SymbolTable table] returns [ASD.Expression out, ASD.Type retType]
    :

      l=multExpr[table] {
        $out = $l.out;
        $retType = $l.retType;
      } (op=(ADD | SUB) r=multExpr[table] {
        switch($op.getType()) {
        case ADD :
          $out = new ASD.AddExpression($out, $r.out);
          break;
        case SUB :
          $out = new ASD.SubExpression($out, $r.out);
          break;
        }
      })*
    ;

multExpr [SymbolTable table] returns [ASD.Expression out, ASD.Type retType]
    :
    l=atome[table] {
        $out = $l.out;
        $retType = $l.retType;
      } (op=(MUL | SDIV) r=atome[table] {
        switch($op.getType()) {
        case MUL :
          $out = new ASD.MulExpression($out, $r.out);
          break;
        case SDIV :
          $out = new ASD.SignedDivExpression($out, $r.out);
          break;
        }
      })*

    ;

type returns [ASD.Type retType]
  : INT_TYPE {
      $retType = new ASD.IntType();
    }
  |
    VOID_TYPE {
      $retType = new ASD.VoidType();
    }
  ;

ident returns [String text]
  :
    IDENT { $text = $IDENT.getText(); }
  ;



args [SymbolTable table] returns [SymbolTable arguments, List<ASD.Expression> out]
  @init {
    ArrayList<ASD.Expression> exprs = new ArrayList<ASD.Expression>();
    SymbolTable t = new SymbolTable();
  }
  :
   (expression[table] {
      exprs.add($expression.out);
      int cpt = 0;
      t.add(cpt++ + "", new SymbolTable.VariableSymbol(new ASD.Variable(ASD.Variable.local_scope, $expression.retType)));
    } (SEP p=expression[table] {
      exprs.add($p.out);
      t.add(cpt++ + "", new SymbolTable.VariableSymbol(new ASD.Variable(ASD.Variable.local_scope, $expression.retType)));
    })*)? {
      $out = exprs;
      $arguments = t;
    }
  ;


atome [SymbolTable table] returns [ASD.Expression out, ASD.Type retType]
    :
      PO expression[table] PF {
        $out = $expression.out;
        $retType = $expression.retType;
      }
    |
      ident {
          SymbolTable.VariableSymbol s = (SymbolTable.VariableSymbol) table.lookup($ident.text);
          if(s == null) { throw new SymbolException("Cannot find symbol " + $ident.text); }
          if(((ASD.PointerType) s.variable.type).type instanceof ASD.ArrayType) {
            ASD.ArrayElement ptr = new ASD.ArrayElement(s.variable, new ASD.IntegerExpression(0));
            $out = ptr;
            $retType = ((ASD.ArrayType)((ASD.PointerType) s.variable.type).type).type;
          } else {
            ASD.Value v = new ASD.Value(s.variable);
            $out = v;
            $retType = ((ASD.PointerType) s.variable.type).type;
          }
      }
    |
      ident TO expression[table] TC {
        SymbolTable.VariableSymbol s = (SymbolTable.VariableSymbol) table.lookup($ident.text);
        if(s == null) { throw new SymbolException("Cannot find symbol " + $ident.text); }
        ASD.ArrayElement ptr = new ASD.ArrayElement(s.variable, $expression.out);
        $out = new ASD.Value(ptr);
        ASD.Type retT = ((ASD.PointerType) s.variable.type).type;
        if(retT instanceof ASD.ArrayType) {
          retT = ((ASD.ArrayType) retT).type;
        } else if(retT instanceof ASD.PointerType) {
          retT = ((ASD.PointerType) retT).type;
        }
        $retType = retT;
      }
    |
      ident PO args[table] PF {
        SymbolTable.FunctionSymbol s = (SymbolTable.FunctionSymbol) table.lookup($ident.text);
        if(s == null) { throw new SymbolException("Cannot find symbol " + $ident.text); }
        if(!s.arguments.equals($args.arguments)) {
          throw new IllegalExpressionException("Invalid reference to function "+$ident.text+" with wrong type !");
        }
        ASD.CallFonction r = new ASD.CallFonction(s.variable, $args.out);
        $retType = s.variable.type;
        $out = r;
      }
    |
      INTEGER {
        $retType = new ASD.IntType();
        $out = new ASD.IntegerExpression($INTEGER.int);
      }
    |
      TEXT {
        $retType = new ASD.CharType();
        $out = new ASD.StringConstant($TEXT.getText());
      }
    ;



/*
  Ancienne facon de faire, fonctionne tres bien, mais impossible d'ajouter des arguments
  en reflexivite gauche, apres suppresion de la reflexivite gauche cela donnc expression
  et multExpr, et pour simplifier les priority0expression sont deplace dans atome

expression  returns [ASD.Expression out]
    :
    PO expressio PF {
      $out = $expression.out;
    }
    |
      l=expression op=(MUL | SDIV) r=expression {
        switch($op.getType()) {
        case MUL :
          $out = new ASD.MulExpression($l.out, $r.out);
          break;
        case SDIV :
          $out = new ASD.SignedDivExpression($l.out, $r.out);
          break;
        }
      }
    |
      l=expression op=(ADD | SUB) r=expression {
        switch($op.getType()) {
        case ADD :
          $out = new ASD.AddExpression($l.out, $r.out);
          break;
        case SUB :
          $out = new ASD.SubExpression($l.out, $r.out);
          break;
        }
      }
    | c=atome {
        $out = $c.out;
      }
    ;
*/
