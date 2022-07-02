%option noyywrap

%{
#include <stdio.h>

#define YY_DECL int yylex()

#include "parser.tab.h"

// list datatype in .ail
// enum symbolType
// {
//     number, boolean, unit, string
// };
// build symboltable struct to store symbols and types;  

/* 
STATEMENT : I'm not sure if we should start from `highlighting` work, 
if we wanna show it is recognized, we not only need `return` tokens, 
but also print recognization and show codes, 
then this part(line: 24-30) is easiler and clear for hightlighting since it onlys records name&type, 
which is what a terminal wanna show about token-level syntax. 
*/
// struct SymbolTable
// {
//     char _name[200];
//     char _type[20];
// };
// struct SymbolTable allSymbolTable[200];
// int allSymbolCount = 0;

// int lineCount = 0;
%}
// alias
letter	[A-Za-z]
number	[0-9]
numbers	{number}+
%x COMMENT 
%%
","	{return COMMA;}
"." {return DOT;}
":"	{return COLON;}
";"	{return SEMICOLON;}
"("	{return LEFTPARENTHESE;}
")"	{return RIGHTPARENTHESE;}
"["	{return LEFTSQUAREBRACKET;}
"]"	{return RIGHTSQUAREBRACKET;}
"{"	{return LEFTBRACKET;}
"}"	{return RIGHTBRACKET;} 
"<" {return LESS;} 
">" {return GREATER;}

"+"	{return PLUS;}
"-"	{return MINUS;}
"*"	{return MULTIPLY;}
"/"	{return DIVIDE;}
"%"	{return PERCENT;}
"^" {return POWER;}
"<=" {return LESSEQUAL;} 
">=" {return GREATEREQUAL;}

"$" {return TRANSFER;}
"@" {return AT;}
"_" {return DASH;}
"|" {return LINE;}
"=="  {return DEEPEQUAL;} 
"!="  {return NOTEQUAL;}
"~~"  {return APPROXMATCH;}
"and" {return AND;} 
"or"  {return OR;}

"@>" {return DOACTION;}
"#>" {return FILTER;}
"||"  {return ACTIONOR;} 
"|>" {return FEED;}
"|*" {return PARALLEL;}

Module      {return MODULE;}
Import      {return IMPORT;}
Plants      {return PLANTS;}
Actions     {return ACTIONS;}
Assets      {return ASSETS;}
Plantation  {return PLANTATION;}
WaterSource {return WATERSOURCE;}
Channels    {return CHANNELS;}
Controllers {return CONTROLLERS;}
MONITOR     {return MONITOR;}

%src {return SRC;}
items {return ITEMS;}

//change
water_use {return WATERUSE;}
min_temp  {return MINTEMP;}
max_temp  {return MAXTEMP;}
max_water {return MAXWATER;}
min_water {return MINWATER;}

//change
capacity          {return CAPACITY;}  
sensors           {return SENSORS;}
desc              {return DESC;}  //so how to define 'desc' 'area'? 
area              {return AREA;}
plantation_date   {return PDATE;}
installation_date {return IDATE;}


if    {return IF;}
meets {return MEETS;} 
then  {return THEN;}
do    {return DO;}
else  {return ELSE;} // need to specify 'if-else' criteria, waht do you think? or we can also add 'while-do'

l|kl|m|cm|mm|C|s|min|hour {return UNIT;} //or like below	 12 cm ; 100 mm;  UnitNumber
collection {return COLLECTION;}
number  {return NUMBER;} // do we really need to set UnitNumber Type? or just represent it in "real/integer unit"

true|false	{return BOOLEANCONSTANT;}
{digits}	{return INTEGERCONSTANT;}
{digits}"."{digits}([Ee][+-]?{digits})?	{return REALCONSTANT;}

\"[^\"]*\"	{
				char c=input();	
				if(c=='\"')
					yymore();	
				else
				{	
					for(int i=0;i<yyleng-1;i++)
						yytext[i]=yytext[i+1];
					yytext[yyleng-2]='\0';
					for(int i=0;i<yyleng-1;i++)
					{
						if(yytext[i]=='\"' && yytext[i+1]=='\"')
						{
							for(int j=i;j<yyleng-1;j++)
								yytext[j]=yytext[j+1];
						}
					}	
					unput(c);	
					strcpy(yylval.stringVal,yytext);
					return STRINGCONSTANT;
				}	
				unput(c);
			}

{letter}({letter}|{digit})*	{
								sscanf(yytext,"%s",&yylval);
								return IDENTIFIER;
							}

\n	{lineCount++;}
[ \t]	{}
"//".*	{}// suppress whatever is in the comment 

// "/*"  {BEGIN(COMMENT);} // Multi comment 
// <COMMENT>.	{}  
// <COMMENT>\n	{lineCount++;}
// <COMMENT>"*/"	{BEGIN(INITIAL);} //INITIAL is predefined

%%