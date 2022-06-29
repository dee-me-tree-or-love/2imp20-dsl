%{

#include <stdio.h>
#include <string.h>	
#include <stdlib.h>
#include "../chicken-5.3.0/chicken.h"

extern int yylex();
extern int yyparse();
extern int lineCount;
extern FILE* yyin;

//SymbolTable
enum varEnum {
    constant, unit, datatype
};
struct SymbolTableStruct {
    char name[100];
    char type[10];
    enum varEnum variables;
    int intValue;
    char strValue[100];
};

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
%type <ival> INTEGERCONSTANTS
%type <ival> BOOLEANCONSTANTS
%type <istr> STRINGCONSTANTS


%left OR
%left AND
// %new opeators
%left LESS LESSEQUAL EQUAL GREATEREQUAL GREATER NOTEQUAL
%left PLUS MINUS
%left MULTIPLY DIVIDE
%nonassoc UMINUS

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

    fclose(yyin);
    return 0;
}

void yyerror(const char* s) {
    fprintf(stderr, "Parse error: %s\n", s);
    exit(1);
}