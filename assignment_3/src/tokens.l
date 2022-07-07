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

/* Aliases */
/* ^^^^^^^ */

nil             "{}"
word            (\w+)
unit_word       {word}("^")?{natural_number}
unit            {unit_word}|{nil}
digit           [0-9]
natural_number  {digit}+
real_number     ("-")?{natural_number}("."{natural_number})?
unit_number     {real_number}" "{unit}
string          "\"".*"\""
boolean         "True"|"False"
value           {nil}|{boolean}|{real_number}|{unit_number}|{string}
collection      '[' {value} ']'

/* Token Matching */
/* ^^^^^^^^^^^^^^ */

%%
    /* Basics */
    /* ~~~~~~ */

","     {return COMMA;}
"."     {return DOT;}
":"     {return COLON;}
";"     {return SEMICOLON;}
"("     {return LEFT_PARENTHESE;}
")"     {return RIGHT_PARENTHESE;}
"["     {return LEFT_SQUAREBRACKET;}
"]"     {return RIGHT_SQUAREBRACKET;}
"{"     {return LEFT_BRACKET;}
"}"     {return RIGHT_BRACKET;}
"<<"    {return DOUBLE_LANGLE;} 
">>"    {return DOUBLE_RANGLE;}

    /* Identifier */
    /* ~~~~~~~~~~ */

{word}  {return IDENTIFIER;}

    /* Values */
    /* ~~~~~~ */

{nil}               {return NIL;}
{unit}              {return UNIT;}
{boolean}           {return BOOLEAN;}
{natural_number}    {return NATURAL_NUMBER;}
{real_number}       {return REAL_NUMBER;}
{unit_number}       {return UNIT_NUMBER;}
{string}            {return STRING;}
{collection}        {return COLLECTION;}

    /* Language expressions */
    /* ~~~~~~~~~~~~~~~~~~~~ */

"+"         {return PLUS;}
"-"         {return MINUS;}
"*"         {return MULTIPLY;}
"/"         {return DIVIDE;}
"%"         {return PERCENT;}
"^"         {return POWER;}
"<"         {return LESS;}
">"         {return GREATER;}
"<="        {return LESS_EQUAL;} 
">="        {return GREATER_EQUAL;}

"$"         {return TRANSFER;} /* this is not supported yet */
"@"         {return AT;}
"_"         {return DASH;}
"|"         {return LINE;}
"=="        {return DEEP_EQUAL;} 
"!="        {return NOT_EQUAL;}
"~~"        {return APPROX_MATCH;}
"and"       {return AND;} 
"or"        {return OR;}

"$>"        {return REDUCE;}
"@>"        {return DOACTION;}
"#>"        {return FILTER;}

"||"        {return ACTION_ALTERNATIVE;} /* this is not yet supported */
"|>"        {return ACTION_FEED;} /* this is not yet supported */
"|&"        {return ACTION_SEQUENCE;} /* this is not yet supported */
"|*"        {return ACTION_PARALLEL;} /* this is not yet supported */

"if"        {return IF;}
"meets"     {return MEETS;} 
"then do"   {return THEN;}
"else do"   {return ELSE;}

    /* Language constructs */
    /* ~~~~~~~~~~~~~~~~~~~ */

Module      {return MODULE;}
Plants      {return PLANTS;}
Actions     {return ACTIONS;}
Assets      {return ASSETS;}
Plantation  {return PLANTATION;}
WaterSource {return WATERSOURCE;}
Channels    {return CHANNELS;}
Controllers {return CONTROLLERS;}
MONITOR     {return MONITOR;}
%%