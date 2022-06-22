/* This is a syntax definition file */

%{
# include "parser.tab.h"
%}

/* This is some basic trial */
%%
"greet"     { printf("GREET\n"); }
[0-9]+      { printf("NUMBER %s\n", yytext); }
[ \t]       { /* ignore white space */ }
\n          { printf("NEWLINE\n"); }
%%