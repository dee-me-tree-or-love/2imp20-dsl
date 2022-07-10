%option noyywrap
%option yylineno

%{
#include <stdio.h>
#include "parser.tab.h"

#define YY_DECL int yylex()
%}

/* Aliases */
/* ^^^^^^^ */

nil                 "{}"
letter              [[:alpha:]]
identifier          {letter}({letter}|"-"|"_"|[0-9])*
word                {letter}({letter}|[0-9])*
unit_word           ("\\"){word}(("^"){natural_number})?
unit                {unit_word}|{nil}
digit               [0-9]
natural_number      {digit}+
real_number         ("-")?{natural_number}("."{natural_number})?
/* supports strings with escaped quotes */
string              "\""([^\"]|"\\\"")*"\""
boolean_true        "True"
boolean_false       "False"
comment             "//".*

/* Token Matching */
/* ^^^^^^^^^^^^^^ */

%%
    /* Basics */
    /* ~~~~~~ */

","         {return COMMA;}
"."         {return DOT;}
":"         {return COLON;}
";"         {return SEMICOLON;}
"("         {return LEFT_PARENTHESE;}
")"         {return RIGHT_PARENTHESE;}
"["         {return LEFT_SQUAREBRACKET;}
"]"         {return RIGHT_SQUAREBRACKET;}
"{"         {return LEFT_BRACKET;}
"}"         {return RIGHT_BRACKET;}
"<<"        {return LEFT_DOUBLEANGLE;} 
">>"        {return RIGHT_DOUBLEANGLE;}
"://"       {return PROTOCOL;}

    /* Values */
    /* ~~~~~~ */
{nil}               {return NIL;}
{unit}              {sscanf(yytext,"%s",&yylval); return UNIT;}
{boolean_true}      {sscanf("1","%d",&yylval); return BOOLEAN_TRUE;}
{boolean_false}     {sscanf("0","%d",&yylval); return BOOLEAN_FALSE;}
{natural_number}    {sscanf(yytext,"%d",&yylval); return NATURAL_NUMBER;}
{real_number}       {sscanf(yytext,"%f",&yylval); return REAL_NUMBER;}
{string}            {sscanf(yytext,"%s",&yylval); return STRING;}

    /* Language expressions */
    /* ~~~~~~~~~~~~~~~~~~~~ */

"="         {return EQUALS;}
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
"++"        {return CONCAT;}

"$"         {return TRANSLATE;} /* this is not supported yet */
"@"         {return AT;}
"_"         {return UNDERSCORE;}
"|"         {return VERTICAL_LINE;}
"=="        {return DEEP_EQUAL;} 
"!="        {return NOT_EQUAL;}
"~~"        {return APPROX_MATCH;}
"and"       {return AND;} 
"or"        {return OR;}

"$>"        {return REDUCE;}
"@>"        {return MAP;}
"#>"        {return FILTER;}

"||"        {return ACTION_ALTERNATIVE;} /* this is not yet supported */
"|>"        {return ACTION_FEED;} /* this is not yet supported */
"|&"        {return ACTION_SEQUENCE;} /* this is not yet supported */
"|*"        {return ACTION_PARALLEL;} /* this is not yet supported */

"if"        {return IF;}
"meets"     {return MEETS;} 
"then do"   {return THEN_DO;}
"else do"   {return ELSE_DO;}

    /* Language constructs */
    /* ~~~~~~~~~~~~~~~~~~~ */

Module      {return MODULE;}
Plants      {return PLANTS;}
Observers   {return OBSERVERS;}
Actions     {return ACTIONS;}
Assets      {return ASSETS;}
Plantation  {return PLANTATION;}
WaterSource {return WATERSOURCE;}
Controllers {return CONTROLLERS;}
MONITOR     {return MONITOR;}
sensors     {return SENSORS;}
Sensor      {return SENSOR;}

    /* Identifier */
    /* ~~~~~~~~~~ */

{identifier}    {sscanf(yytext,"%s",&yylval); return IDENTIFIER;}

    /* Reserved identifiers */
    /* ~~~~~~~~~~~~~~~~~~~~ */

"%src"          {return SRC_IDENTIFIER;}

    /* Special characters */
    /* ~~~~~~~~~~~~~~~~~~ */

\n          { /* ignore newline */ }
{comment}   { /* ignore line comments */ }
%%