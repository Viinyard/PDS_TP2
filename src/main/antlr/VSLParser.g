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
    : e=expression { $out = new ASD.Program($e.out); } // TODO : change when you extend the language
    ;

expression returns [ASD.Expression out]
    : l=expression PLUS r=factor  { $out = new ASD.AddExpression($l.out, $r.out); }
    | l=expression MINUS r=factor { $out = new ASD.MinusExpression($l.out, $r.out); }
    ;
factor returns [ASD.Expression out]
    : p=primary { $out = $p.out; }
    | l=factor TIMES r=primary { /*$out = new ASD.TimesExpression($l.out, $r.out); */}
    | l=factor DIVIDES r=primary { /*$out = new ASD.DividesExpression($l.out, $r.out); */}
    ;

primary returns [ASD.Expression out]
    : INTEGER { $out = new ASD.IntegerExpression($INTEGER.int); }
    // TODO : that's all?
    ;
