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
  }
    : (fonction { fonctions.add($fonction.out); })* EOF { $out = new ASD.Program(fonctions); } // TODO : change when you extend the language
    ;

fonction returns [ASD.Fonction out]
  : FUNC_TYPE type ident PO PF {
      $out = new ASD.Fonction($type.out, $ident.out, Llvm.empty());
    }
  ;

expression returns [ASD.Expression out]
    :
    PO expression PF {
      $out = $expression.out;
    }
    |
    <assoc=left>
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
    | <assoc=left>
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

type returns [ASD.Type out]
  : INT_TYPE {
      $out = new ASD.IntType();
    }
  |
    VOID_TYPE {
      $out = new ASD.VoidType();
    }
  ;

ident returns [ASD.ID out]
  : IDENT { $out = new ASD.GlobalID($IDENT.getText()); }
  ;

atome returns [ASD.Expression out]
    : INTEGER { $out = new ASD.IntegerExpression($INTEGER.int); }
    // TODO : that's all?
    ;
