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


// TODO : other rules

program returns [ASD.Program out]
    : e=expression* EOF { $out = new ASD.Program($e.out); } // TODO : change when you extend the language
    ;

expression returns [ASD.Expression out]
    : <assoc=left>
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


atome returns [ASD.Expression out]
    : INTEGER { $out = new ASD.IntegerExpression($INTEGER.int); }
    // TODO : that's all?
    ;
