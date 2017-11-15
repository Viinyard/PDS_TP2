parser grammar VSLParser;

options {
  language = Java;
  tokenVocab = VSLLexer;
}

@header {
  package TP2;

  import java.util.stream.Collectors;
  import java.util.Arrays;
}

program returns [ASD.Program out]
  @init {
    List<ASD.Expression> listExpression = new ArrayList<ASD.Expression>();
    SymbolTable table = new SymbolTable();
  }
    : (fonction[table] { listExpression.add($fonction.out); })* EOF { $out = new ASD.Program(listExpression); } // TODO : change when you extend the language
    ;

fonction [SymbolTable table] returns [ASD.Expression out]
  @init {
    SymbolTable tableFunction = new SymbolTable(table);
  }
  : FUNC_TYPE type ident PO PF block[table] {
      table.add(new SymbolTable.FunctionSymbol($type.out, $ident.text, null, true));
      $out = new ASD.Fonction($type.out, $ident.text, $block.out);
    }
  |
    PROTO_TYPE type ident PO PF {
      table.add(new SymbolTable.FunctionSymbol($type.out, $ident.text, null, true));
      $out = new ASD.ProtoFonction($type.out, $ident.text);
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

statement [SymbolTable table] returns [List<ASD.Expression> out]
  @init {
    List<ASD.Expression> expressions = new ArrayList<ASD.Expression>();
  }
  @after {
    $out = expressions;
  }
  :
    RETURN_STMNT expression[table] {
      expressions.add(new ASD.ReturnStatement($expression.out));
    }
  |
    PRINT args[table] {
      expressions.add(new ASD.PrintFunction($args.out));
    }
  |
    localdeclaration[table] {
      expressions = $localdeclaration.out;
    }
  |
    affectation[table] {
      expressions.add($affectation.out);
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
    l=expression[table] { 
        $out = new ASD.Booleen($expression.out); 
      } (operand r=expression[table] { 
        $out = new ASD.Condition($l.out, $operand.out, $r.out); 
      })?
  ;

operand returns [ASD.Operand out] 
  :
    NE { $out = new ASD.DifferentOperand(); }
  |
    EQ { $out = new ASD.EqualOperand(); }
  |
    GT { $out = new ASD.GreaterThanOperand(); }
  |
    LT { $out = new ASD.LessThanOperand(); }
  |
    GTE { $out = new ASD.GreaterThanOrEqualOperand(); }
  |
    LTE { $out = new ASD.LessThanOrEqualOperand(); }
  ;

affectation [SymbolTable table] returns [ASD.Expression out]
  :
    ident EQUAL expression[table] {
      SymbolTable.Symbol s = table.lookup($ident.text);
      if(s == null) { throw new IllegalArgumentException("Cannot fin symbol " + $ident.text); }
      if(s instanceof SymbolTable.VariableSymbol) {
        $out = new ASD.Affectation(((SymbolTable.VariableSymbol) s).type, s.ident, $expression.out);
      }
    }
  ;

localdeclaration [SymbolTable table] returns [List<ASD.Expression> out]
  @init {
    List<ASD.Expression> decls = new ArrayList<ASD.Expression>();
  }    
  :
    type ident { 
        table.add(new SymbolTable.VariableSymbol($type.out, $ident.text));
        decls.add(new ASD.Instanciation($type.out, $ident.text));
        
      } (SEP ident { 
        table.add(new SymbolTable.VariableSymbol($type.out, $ident.text));
        decls.add(new ASD.Instanciation($type.out, $ident.text));
        
      })* {
        $out = decls;
      } 

  ;


expression [SymbolTable table] returns [ASD.Expression out, ASD.Type type]
    :   

      l=multExpr[table] {$out = $l.out; } (op=(ADD | SUB) r=multExpr[table] {
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

multExpr [SymbolTable table] returns [ASD.Expression out, ASD.Type type]
    : 
    l=atome[table] {$out = $l.out; } (op=(MUL | SDIV) r=atome[table] { 
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

type returns [ASD.Type out]
  : INT_TYPE {
      $out = new ASD.IntType();
    }
  |
    VOID_TYPE {
      $out = new ASD.VoidType();
    }
  ;

ident returns [String text]
  :
    IDENT { $text = $IDENT.getText(); }
  ;

args [SymbolTable table] returns [SymbolTable arguments, List<ASD.Expression> out]
  
  :
   expression[table] {
      $out = new ArrayList<ASD.Expression>();
      $out.add($expression.out);
    } (SEP p=expression[table] {
      $out.add($p.out);
    })*
  ;


atome [SymbolTable table] returns [ASD.Expression out, ASD.Type type]
    : 
      PO expression[table] PF {
        $out = $expression.out;
        $type = $expression.type;
      }
    |
      ident PO args[table] PF {
        SymbolTable.FunctionSymbol s = (SymbolTable.FunctionSymbol) table.lookup($ident.text);
        if(s == null) { throw new IllegalArgumentException("Cannot find symbol " + $ident.text); }
        SymbolTable.FunctionSymbol f = new SymbolTable.FunctionSymbol(s.returnType, $ident.text, $args.arguments, s.defined);
        if(!s.equals(f)) { throw new IllegalArgumentException("Cannot find function with these args for function : " + $ident.text);}
        
        $out = new ASD.CallFonction(s.returnType, $ident.text, $args.out);
      }
    |
      INTEGER { 
        $type = new ASD.IntType();
        $out = new ASD.IntegerExpression($INTEGER.int); 
      }
    |
      TEXT {
        $type = new ASD.StringType();
        $out = new ASD.StringExpression($TEXT.getText()); 
      }
    |
      ident {
        SymbolTable.VariableSymbol s = (SymbolTable.VariableSymbol) table.lookup($ident.text);
        if(s == null) { throw new IllegalArgumentException("Cannot find symbol " + $ident.text); }
        
        $out = new ASD.Variable(((SymbolTable.VariableSymbol) s).type, s.ident);
        $type = s.type;
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
