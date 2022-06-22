/* This is the Bison parser entry file */

/* utilities, declarations and imports */
%{
#include <stdio.h>

// Explicit declarations of the parser errors
int yylex();
void yyerror();
%}

/* declare tokens */
%token NUMBER
%token GREET
%token EOL
%%

command : call EOL;
call : GREET term;
term : NUMBER;

%%
int main(int argc, char **argv){
    yyparse();
}
void yyerror(char *s){
    fprintf(stderr, "error: %s\n", s);
}