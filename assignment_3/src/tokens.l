%option noyywrap

%{
#include <stdio.h>

#define YY_DECL int yylex()

#include "parser.tab.h"

%}

%%

[ \t]       { ; }  // ignore all whitespace
[0-9]+      {yylval.ival = atoi(yytext); return T_INT;}
\n          {return T_NEWLINE;}
"greet"     {return T_GREET;}
"exit"      {return T_QUIT;}
"quit"      {return T_QUIT;}

%%