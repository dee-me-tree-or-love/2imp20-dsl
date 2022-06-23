%{

#include <stdio.h>
#include <stdlib.h>
#include "../chicken-5.3.0/chicken.h"

extern int yylex();
extern int yyparse();
extern FILE* yyin;

void yyerror(const char* s);
%}

%union {
    int ival;
    char istr;
}

%token<ival> T_INT
%token T_GREET
%token T_QUIT
%token T_NEWLINE

// semantic type
/* %type<istr> greet_request */

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