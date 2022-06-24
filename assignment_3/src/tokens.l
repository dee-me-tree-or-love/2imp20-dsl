%option noyywrap

%{
#include <stdio.h>

#define YY_DECL int yylex()

#include "parser.tab.h"

// list datatype in .ail
enum symbolType
{
    string,boolean,real,integer
};
// build symboltable struct to store symbols and types;  

/* 
STATEMENT : I'm not sure if we should start from `highlighting` work, 
if we wanna show it is recognized, we not only need `return` tokens, 
but also print recognization and show codes, 
then this part(line: 24-30) is easiler and clear for hightlighting since it onlys records name&type, 
which is what a terminal wanna show about token-level syntax. 
*/
struct SymbolTable
{
    char _name[200];
    char _type[20];
};
struct SymbolTable allSymbolTable[200];
int allSymbolCount = 0;

int lineCount = 0;
char content[256];
//this function works to collect every token 
void newContent() {
    strcat(content,yytext); 
}

%}
// alias
letter	[A-Za-z]
number	[0-9]
numbers	{number}+
%x COMMENT //https://stackoverflow.com/a/2130124
%%

/*
[ \t]       { ; }  // ignore all whitespace
[0-9]+      {yylval.ival = atoi(yytext); return T_INT;}
\n          {return T_NEWLINE;}
"greet"     {return T_GREET;}
"exit"      {return T_QUIT;}
"quit"      {return T_QUIT;}
*/

\n	{lineCount++;content[0]='\0';}
[ \t]	{newContent();}
"//".*	{newContent();}// suppress whatever is in the comment 

//Multi comment
"/*"  {newContent(); BEGIN(COMMENT);}
<COMMENT>.	{newContent();}  
<COMMENT>\n	{ 
				lineCount++; 
				content[0]='\0'; //end a string, means null
 			}
<COMMENT>"*/"	{newContent();BEGIN(INITIAL);} //INITIAL is predefined

%%