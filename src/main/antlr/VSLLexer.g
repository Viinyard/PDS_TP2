lexer grammar VSLLexer;

options {
  language = Java;
}

@header {
  package TP2;
}

WS : (' '|'\n'|'\t') -> skip
   ;

COMMENT : '//' (~'\n')* -> skip
        ;

fragment LETTER : 'a'..'z' ;
fragment DIGIT  : '0'..'9' ;
fragment ASCII  : ~('\n'|'"');

// keywords
PO    : '(' ; // Left parenthesis
PF    : ')' ;

TO : '[';
TC : ']';

BO : '{';
BF : '}';
SEP : ',';
EQUAL : ':=';

PRINT : 'PRINT';
READ : 'READ';

NE : '!=' | '<>' ;
EQ : '=' ;
GT : '>' ;
LT : '<' ;
GTE : '>=' ;
LTE : '<=' ;

FUNC_TYPE : 'FUNC';
PROTO_TYPE : 'PROTO';

VOID_TYPE : 'VOID';
INT_TYPE : 'INT';

RETURN_STMNT : 'RETURN';

IF : 'IF';
THEN : 'THEN';
ELSE : 'ELSE';
FI : 'FI';

WHILE : 'WHILE';
DO : 'DO';
DONE : 'DONE';

ADD : '+' ;
SUB : '-' ;
MUL : '*' ;
SDIV : '/' ;

// TODO : other keywords

// other tokens (no conflict with keywords in VSL)
IDENT   : LETTER (LETTER|DIGIT)*;
TEXT    : '"' (ASCII)* '"' { setText(getText().substring(1, getText().length() - 1)); };
INTEGER : (DIGIT)+ ;
