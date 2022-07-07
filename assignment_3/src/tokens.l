%option noyywrap

%{
#include <stdio.h>
#include "parser.tab.h"

#define YY_DECL int yylex()
%}

/* Aliases */
/* ^^^^^^^ */

nil             "{}"
letter          [[:alpha:]]
identifier      {letter}({letter}|"-"|"_"|[0-9])*
word            {letter}({letter}|[0-9])*
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
    /* Special characters */
    /* ~~~~~~~~~~~~~~~~~~ */

    /* <<EOF>> {return MODULE_END;} */

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
"_"         {return UNDERSCORE;}
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

    /* Identifier */
    /* ~~~~~~~~~~ */

{identifier}    {return IDENTIFIER;}
%%