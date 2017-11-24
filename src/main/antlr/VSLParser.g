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
    Utils.resettmp();
    SymbolTable funcTable = new SymbolTable(table);
    List<ASD.Expression> expinit = new ArrayList<ASD.Expression>();
  }
  : FUNC_TYPE type  ident {
      SymbolTable.Symbol proto = funcTable.lookup($ident.text);
      if(proto != null && ((SymbolTable.FunctionSymbol) proto).defined) {
        throw new RedefinitionException($ident.text + " already defined !");
      }
    } PO argsDecl[funcTable] PF {
      expinit.addAll($argsDecl.initExpr);
      ASD.Variable v = null;
      if(!($type.retType instanceof ASD.VoidType)) {
        v = new ASD.Variable(ASD.Variable.local_scope, new ASD.PointerType($type.retType), Utils.newtmp());
        expinit.add(new ASD.Instanciation(v));
        funcTable.add("RETURN", new SymbolTable.VariableSymbol(v));
      }
    } block[funcTable] {
      ASD.Variable func = new ASD.Variable(ASD.Variable.global_scope, $type.retType, $ident.text);
      SymbolTable.FunctionSymbol f = new SymbolTable.FunctionSymbol(func, $argsDecl.argTable, true);
      table.add($ident.text, f );
      if(proto != null && proto instanceof SymbolTable.FunctionSymbol) {
        if(((SymbolTable.FunctionSymbol) proto).defined ) {
          throw new IllegalArgumentException("Error: " + $ident.text + " already defined !");
        }
        if(!f.equals(proto)) {
          throw new IllegalArgumentException("Conflit type with " + $ident.text);
        }
      }

      expinit.addAll($block.out);

      if(v != null) {
        ASD.Value retV = new ASD.Value(v);
        expinit.add(retV);
        expinit.add(new ASD.ReturnStatement(retV.getResult()));
      }

      $out = new ASD.Fonction(func, $argsDecl.out, expinit);
    }
  |
    PROTO_TYPE type ident PO argsDecl[funcTable] PF {
      ASD.Variable func = new ASD.Variable(ASD.Variable.global_scope, $type.retType, $ident.text);
      table.add(func.var_name, new SymbolTable.FunctionSymbol(func, $argsDecl.argTable, false));
      $out = new ASD.ProtoFonction(func);
    }
  ;

argsDecl [SymbolTable table] returns [List<ASD.Variable> out, List<ASD.Expression> initExpr, SymbolTable argTable]
  @init {
    List<ASD.Variable> args = new ArrayList<ASD.Variable>(); // arguments, pour definition de la fonction
    HashMap<String, ASD.Variable> hmPtr = new HashMap<String, ASD.Variable>(); // pour initialiser les variables au debut de la fonction
    SymbolTable t = new SymbolTable(); // SymbolTable vierge, sans les variable globale, pour signature de la fonction
  }
  @after {
    List<ASD.Variable> toPtr = new ArrayList<ASD.Variable>();
    List<ASD.Variable> val = new ArrayList<ASD.Variable>();
    for(String k : hmPtr.keySet()) {
      val.add(hmPtr.get(k));
      ASD.Variable v = new ASD.Variable(ASD.Variable.local_scope, new ASD.PointerType(hmPtr.get(k).type), Utils.newtmp());
      table.add(k, new SymbolTable.VariableSymbol(v));
      toPtr.add(v);
    }

    List<ASD.Expression> init = new ArrayList<ASD.Expression>(); // pour initialiser les variables, a retourner apres traitement avec la hashmap

    for(int i = 0; i < val.size(); i++) {
      init.add(new ASD.Instanciation(toPtr.get(i)));
    }

    for(int i = 0; i < val.size(); i++) {
      init.add(new ASD.Affectation(toPtr.get(i), val.get(i)));
    }

    $out = args;
    $argTable = t;
    $initExpr = init;

  }
  :
    (argDecl {
      ASD.Variable v = $argDecl.out;
      hmPtr.put($argDecl.idText, $argDecl.out);
      args.add(v);
      t.add($argDecl.idText, new SymbolTable.VariableSymbol(v));
    } (SEP argDecl {
      v = $argDecl.out;
      args.add(v);
      hmPtr.put($argDecl.idText, $argDecl.out);
      t.add(v.var_name, new SymbolTable.VariableSymbol(v));
    })*)?
  ;

argDecl  returns [ASD.Variable out, String idText]
  :
    ident {
      System.err.println("no type specified, default : int");
      $out = new ASD.Variable(ASD.Variable.local_scope, new ASD.IntType(), Utils.newtmp());
      $idText = $ident.text;
    }
  |
    type ident {
      $out = new ASD.Variable(ASD.Variable.local_scope, $type.retType, Utils.newtmp());
      $idText = $ident.text;
    }
  |
    ident TO TC {
      System.err.println("no type specified, default : int*");
      $out = new ASD.Variable(ASD.Variable.local_scope, new ASD.PointerType(new ASD.IntType()), Utils.newtmp());
      $idText = $ident.text;
    }
  |
    type ident TO TC {
      $out = new ASD.Variable(ASD.Variable.local_scope, new ASD.PointerType($type.retType), Utils.newtmp());
      $idText = $ident.text;
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
      if(!s.variable.type.equals($expression.retType)) { throw new TypeException("illegal type exception : found " + $expression.retType + " need " + s.variable.type);}
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
      if(!s.variable.type.equals($expression.retType)) {
         throw new TypeException("illegal type exception : found " + $expression.retType + " need " + s.variable.type);
      }
      retExprs.add(new ASD.Affectation(s.variable, $expression.out));
    }
  |
    ident TO i=expression[table] TC  {
      SymbolTable.Symbol s = table.lookup($ident.text);
      if(s == null) { throw new SymbolException("Cannot find symbol " + $ident.text); }
      ASD.ArrayElement arElem = new ASD.ArrayElement(s.variable, $i.out);
      retExprs.add(arElem);
    }  EQUAL v=expression[table] {
      retExprs.add(new ASD.Affectation(arElem.getResult(), $v.out));

      if(!s.variable.type.equals($v.retType)) {
         throw new TypeException("illegal type exception : found " + $v.retType + " need " + s.variable.type);
      }
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
      ASD.Variable var = new ASD.Variable(ASD.Variable.local_scope, $t, Utils.newtmp());
      table.add($ident.text, new SymbolTable.VariableSymbol(var));
      $text = $ident.text;
      $out = new ASD.Instanciation(var);
    }
  |
    ident TO INTEGER TC {
      ASD.Variable array = new ASD.Variable(ASD.Variable.local_scope, new ASD.PointerType(new ASD.ArrayType($t, $INTEGER.int + "")), Utils.newtmp());
      $out = new ASD.Instanciation(array);
      table.add($ident.text, new SymbolTable.VariableSymbol(array));
    }
  ;

expression [SymbolTable table] returns [ASD.Expression out, ASD.Type retType]
    :

      l=multExpr[table] {$out = $l.out; } (op=(ADD | SUB) r=multExpr[table] {
        $retType = $l.retType;
        ASD.Variable result = new ASD.Variable(ASD.Variable.local_scope, $retType, Utils.newtmp());
        switch($op.getType()) {
        case ADD :
          $out = new ASD.AddExpression(result, $out, $r.out);
          break;
        case SUB :
          $out = new ASD.SubExpression(result, $out, $r.out);
          break;
        }
      })*
    ;

multExpr [SymbolTable table] returns [ASD.Expression out, ASD.Type retType]
    :
    l=atome[table] {
        $out = $l.out; $retType = $l.retType;
      } (op=(MUL | SDIV) r=atome[table] {
        ASD.Variable result = new ASD.Variable(ASD.Variable.local_scope, $retType, Utils.newtmp());
        switch($op.getType()) {
        case MUL :
          $out = new ASD.MulExpression(result, $out, $r.out);
          break;
        case SDIV :
          $out = new ASD.SignedDivExpression(result, $out, $r.out);
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
    } (SEP p=expression[table] {
      exprs.add($p.out);
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
            $retType = ptr.getResult().type;
          } else {
            ASD.Value v = new ASD.Value(s.variable);
            $out = v;
            $retType = v.getResult().type;
          }
      }
    |
      ident TO expression[table] TC {
        SymbolTable.VariableSymbol s = (SymbolTable.VariableSymbol) table.lookup($ident.text);
        if(s == null) { throw new SymbolException("Cannot find symbol " + $ident.text); }
        ASD.ArrayElement ptr = new ASD.ArrayElement(s.variable, $expression.out);
        if(ptr.getResult().type instanceof ASD.PointerType) {
          ASD.ArrayValue v = new ASD.ArrayValue(ptr);
          $out = v;
          $retType = v.getResult().type;
        } else {
          $out = ptr;
          $retType = ptr.getResult().type;
        }
      }
    |
      ident PO args[table] PF {
        SymbolTable.FunctionSymbol s = (SymbolTable.FunctionSymbol) table.lookup($ident.text);
        if(s == null) { throw new SymbolException("Cannot find symbol " + $ident.text); }
        ASD.CallFonction r = new ASD.CallFonction(s.variable, $args.out);
        $retType = r.getResult().type;
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
