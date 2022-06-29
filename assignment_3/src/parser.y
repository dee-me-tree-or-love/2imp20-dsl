%{

#include <stdio.h>
#include <string.h>	
#include <stdlib.h>
#include "../chicken-5.3.0/chicken.h"

extern int yylex();
extern int yyparse();
extern int lineCount;
extern FILE* yyin;

void yyerror(const char* s);
%}

%token COMMA DOT COLON COLON SEMICOLON LEFTPARENTHESE RIGHTPARENTHESE LEFTSQUAREBRACKET RIGHTSQUAREBRACKET LEFTBRACKET RIGHTBRACKET LESS GREATER LEFTQUOTE RIGHTQUOTE
%token PLUS MINUS MULTIPLY DIVIDE PERCENT POWER TRANSFER AT DASH LINE
%token DEEPEQUAL NOTEQUAL APPROXMATCH AND OR DOACTION FILTER FEED PARALLEL
%token MODULE IMPORT PLANTS ACTIONS ASSETS PLANTATION WATERSOURCE CHANNELS CONTROLLERS MONITOR SRC ITEMS
%token WATERUSE...
%token CAPACITY...

%union {
    int ival;
    char istr[100];
}
// semantic type
/* %type<istr> greet_request */

%type <istr> IDENTIFIER
%type <istr> STRING


%left OR
%left AND

%start program

%%

program:
    | program statement

statement: 
    T_NEWLINE         { ; } // ignore new line
    | T_QUIT T_NEWLINE  { printf("bye!\n"); exit(0); }
    | greet_request     { printf("\tResult: greet request \n"); }

greet_request:
    T_GREET T_INT     { }

%%

int main() {
    yyin = stdin;

    C_word x;
    CHICKEN_run(CHICKEN_default_toplevel);
    CHICKEN_eval_string("(print \"hello from CHICKEN\")", &x);

    do {
        yyparse();
    } while(!feof(yyin));

    return 0;
}

void yyerror(const char* s) {
    fprintf(stderr, "Parse error: %s\n", s);
    exit(1);
}