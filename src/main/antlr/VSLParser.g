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
    List<ASD.Fonction> fonctions = new ArrayList<ASD.Fonction>();
    SymbolTable table = new SymbolTable();
  }
    : (fonction[table] { fonctions.add($fonction.out); })* EOF { $out = new ASD.Program(fonctions); } // TODO : change when you extend the language
    ;

fonction [SymbolTable table] returns [ASD.Fonction out]
  @init {
    SymbolTable tableFunction = new SymbolTable(table);
  }
  : FUNC_TYPE type ident PO PF block[table] {
      table.add(new SymbolTable.FunctionSymbol($type.out, $ident.text, null, true));
      $out = new ASD.Fonction($type.out, new ASD.GlobalID($ident.text), $block.out);
    }
  ;

block [SymbolTable table] returns [List<ASD.Expression> out]
  @init {
    List<ASD.Expression> statements = new ArrayList<ASD.Expression>();
  }
  : 
    BO (statement[table] {
      statements.addAll($statement.out);
      
    })* BF { $out = statements; }
  |
    statement[table] {
      statements.addAll($statement.out);
      $out = statements;
    }
  ;

statement [SymbolTable table] returns [List<ASD.Expression> out]
  @init {
    List<ASD.Expression> expressions = new ArrayList<ASD.Expression>();
  }
  :
    RETURN_STMNT expression[table] {
      expressions.add(new ASD.ReturnStatement($expression.out));
      $out = expressions;
    }
  |
    localdeclaration[table] {
      expressions = $localdeclaration.out;
      $out = expressions;
    }
;

localdeclaration [SymbolTable table] returns [List<ASD.Expression> out]
  @init {
    List<ASD.Expression> decls = new ArrayList<ASD.Expression>();
  }    
  :
    type ident { 
        table.add(new SymbolTable.VariableSymbol($type.out, $ident.text));
        decls.add(new ASD.Instanciation(new ASD.Variable($type.out, $ident.text)));
        
      } (SEP ident { 
        table.add(new SymbolTable.VariableSymbol($type.out, $ident.text));
        decls.add(new ASD.Instanciation(new ASD.Variable($type.out, $ident.text)));
        
      })* {
        $out = decls;
      } 

  ;


expression [SymbolTable table] returns [ASD.Expression out]
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

multExpr [SymbolTable table] returns [ASD.Expression out]
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

/*
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

atome [SymbolTable table] returns [ASD.Expression out]
    : 
      PO l=expression[table] PF {
        $out = $l.out;
      }
    |
      INTEGER { $out = new ASD.IntegerExpression($INTEGER.int); }
    |
      TEXT { /*$out = new ASD.StringExpression($TEXT.getText());*/ }
    ;
