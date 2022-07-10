%{

#include <stdio.h>
#include <string.h>	
#include <stdlib.h>
// #include "../chicken-5.3.0/chicken.h"
#include "../lib/symbol_table.h"
#include "../lib/python_skeleton.h"

// Explicit defintions of the YY API
extern int yylineno; 
extern int yylex();
extern int yyparse();
extern void yyerror(const char *s);
extern FILE* yyin;

char tmp_collection[100];
char tmp_unitnumber[100];
char tmp_attr[100];
%}

// TOKENS
// ~~~~~~

%token COMMA
%token DOT
%token COLON
%token SEMICOLON
%token LEFT_PARENTHESE
%token RIGHT_PARENTHESE
%token LEFT_SQUAREBRACKET
%token RIGHT_SQUAREBRACKET
%token LEFT_BRACKET
%token RIGHT_BRACKET
%token LEFT_DOUBLEANGLE
%token RIGHT_DOUBLEANGLE
/* TODO: maybe delete the unused protocol token */
%token PROTOCOL
%token EXCLAMATION

%token IDENTIFIER
%token SRC_IDENTIFIER

%token NIL
%token UNIT
%token BOOLEAN_TRUE
%token BOOLEAN_FALSE
%token NATURAL_NUMBER
%token REAL_NUMBER
%token UNIT_NUMBER
%token STRING

%token EQUALS
%token PLUS
%token MINUS
%token MULTIPLY
%token DIVIDE
%token PERCENT
%token POWER
%token LESS
%token GREATER
%token LESS_EQUAL 
%token GREATER_EQUAL
%token CONCAT

%token TRANSLATE
%token AT
%token UNDERSCORE
%token VERTICAL_LINE
%token DEEP_EQUAL 
%token NOT_EQUAL
%token APPROX_MATCH
%token AND 
%token OR

%token REDUCE
%token MAP
%token FILTER

/* Action composition is not implemented yet. */
%token ACTION_ALTERNATIVE
%token ACTION_FEED
%token ACTION_SEQUENCE
%token ACTION_PARALLEL

%token IF
%token MEETS 
%token THEN_DO
%token ELSE_DO

%token MODULE
%token PLANTS
%token OBSERVERS
%token ACTIONS
%token ASSETS
%token PLANTATION
%token WATERSOURCE
%token SENSORS
%token SENSOR
%token CONTROLLERS
%token MONITOR

// Semantics
// ~~~~~~~~~

%union {
    int ival;
    float ifloat;
    char istr[100];
}

/* FIXME: extend with the remaining "values" */
%type <istr> IDENTIFIER
%type <istr> SRC_IDENTIFIER
%type <istr> REAL_NUMBER
%type <istr> NATURAL_NUMBER
%type <istr> UNIT
%type <ival> BOOLEAN_FALSE
%type <ival> BOOLEAN_TRUE
%type <istr> STRING

%type <istr> observer_body
%type <istr> value
%type <istr> value_spec
%type <istr> unitnumber
%type <istr> attribute_or_identifier_access
%type <istr> attribute_or_identifier_access_base
%type <istr> attribute_or_identifier_access_clause
%type <istr> collection
%type <istr> collection_body
%type <istr> unit_expression

/* FIXME: add precedence rules to other shift/reduce conflicts */
/* See: https://www.gnu.org/software/bison/manual/html_node/Shift_002fReduce.html */

%left OR
%left AND
%left LESS LESS_EQUAL DEEP_EQUAL GREATER_EQUAL GREATER NOT_EQUAL APPROX_MATCH
%left PLUS MINUS
%left MULTIPLY DIVIDE

// Grammars
// ~~~~~~~~

%start program

%%

/* Module start */

program :
    MODULE COLON LEFT_BRACKET
    IDENTIFIER {
        printf("Line: %d; Module name: %s\n", yylineno, $4);

        // Store global label for well-formedness checks
        setLineNumber(yylineno);
        addGlobalLabel($4, module);

        // Add to python skeleton
        setSkeletonModuleName($4);
    }
    RIGHT_BRACKET
    module_body
    ;

/* Contents of the module */

module_body :
    item_decl module_body
    | /* empty module */
    ;

item_decl :
    plants_decls 
    | observer_decls
    | controllers_decls
    | action_decls
    | asset_decls
    ;

/* Plants */

plants_decls :
    PLANTS COLON LEFT_BRACKET
    plant_configs
    RIGHT_BRACKET
    ;

plant_configs :
    plant_config COMMA plant_configs
    | plant_config /* single plant config */
    | /* empty body */
    ;

plant_config :
    IDENTIFIER {
        printf("Plant name: %s\n", $1);

        setLineNumber(yylineno);
        addGlobalLabel($1, plant); 
    }
    LEFT_DOUBLEANGLE
    plant_body {
        printf("Plant name: %s\n", $1);

        // Store in the Python Skeleton
        SinglePlantSkeleton sps = {strdup($1)};
        printf("Plant name: %s\n", sps.identifier);
        addPlantSkeleton(sps);
    }
    RIGHT_DOUBLEANGLE {
        // setLineNumber(yylineno);
        addOwner($1);
    }
    ;

plant_body :
    attribute_spec COMMA plant_body
    | attribute_spec
    | /* empty body */
    ;

/* Observers */

observer_decls :
    OBSERVERS COLON LEFT_BRACKET
    observer_configs
    RIGHT_BRACKET
    ;

observer_configs :
    observer_config COMMA observer_configs
    | observer_config /* single observer config */
    | /* empty body */
    ;

observer_config :
    IDENTIFIER {
        printf("Line: %d; Observer name: %s\n", yylineno, $1);
        // setLineNumber(yylineno);
        // addGlobalLabel($1, observer);
    }
    LEFT_DOUBLEANGLE
    observer_body {
        printf("Line: %d; Observer name: %s\n", yylineno, $1);
        // Add for well-formedness checks
        setLineNumber(yylineno);
        addObserver($1, $4);

        // Add to python skeleton
        SingleObserverSkeleton sos = {strdup($1), strdup($4)};
        addObserverSkeleton(sos);
    }
    RIGHT_DOUBLEANGLE
    ;

observer_body :
    STRING {
        printf("Observer body: %s\n", $1);
        // Pass the recognized observer body upstream
        strcpy($$, $1);
    }
    ;

/* Controllers */

controllers_decls :
    CONTROLLERS COLON LEFT_BRACKET
    controller_configs
    RIGHT_BRACKET
    ;

controller_configs :
    controller_config COMMA controller_configs
    | controller_config /* single plant config */
    | /* empty body */
    ;

controller_config :
    MONITOR {
        printf("MONITOR Controller.\n");

        // Record the Monitor controller in the Python skeleton
        addControllerSkeleton(__MONITOR);
    }
    ;

/* Assets */

asset_decls :
    ASSETS COLON LEFT_BRACKET
    asset_configs {
        printf("Got assets config.\n");
    }
    RIGHT_BRACKET
    ;

asset_configs :
    asset_config COMMA asset_configs
    | asset_config
    | /* empty body */
    ;

asset_config :
    IDENTIFIER {
        printf("Got asset identifier: %s.\n", $1);
    }
    COLON 
    asset_type COLON LEFT_BRACKET
    asset_attributes {
        printf("Got asset attributes.\n");
    }
    RIGHT_BRACKET
    ;

asset_type :
    WATERSOURCE
    | PLANTATION LEFT_DOUBLEANGLE
    IDENTIFIER {
        printf("Got plantation type identifier: %s.\n", $3);
    }
    RIGHT_DOUBLEANGLE
    ;

asset_attributes :
    asset_attribute_spec COMMA asset_attributes
    | asset_attribute_spec
    | /* empty body */
    ;

asset_attribute_spec :
    attribute_spec {
        printf("Got regular attribute spec.\n");
    }
    | asset_sensors_attribute_spec {
        printf("Got sensor attribute spec.\n");
    }
    ;

asset_sensors_attribute_spec :
    SENSORS COLON LEFT_BRACKET
    sensor_configs
    RIGHT_BRACKET
    ;

/* Sensors */

sensor_configs :
    sensor_config COMMA sensor_configs
    | sensor_config
    | /* empty body */
    ;

sensor_config :
    IDENTIFIER {
        printf("Got sensor identifier: %s", $1);
    }
    COLON
    sensor_type
    COLON
    LEFT_BRACKET
    sensor_attributes
    RIGHT_BRACKET
    ;

sensor_type :
    SENSOR {
        printf("Got base Sensor type.\n");
    }
    ;

sensor_attributes :
    STRING {
        printf("Got sensor trigger.\n");
    }
    COMMA
    action_expression {
        printf("Got sensor action.\n");
    }
    ;

/* Actions */

action_decls :
    ACTIONS COLON LEFT_BRACKET
    action_configs
    RIGHT_BRACKET
    ;

action_configs :
    action_config COMMA action_configs
    | action_config /* single config */
    | /* empty body */
    ;

action_config :
    IDENTIFIER {
        printf("Action name: %s\n", $1);
        //Symbol
        setLineNumber(yylineno);
        addGlobalLabel($1, action);
    }
    LEFT_DOUBLEANGLE
    action_parameters
    RIGHT_DOUBLEANGLE
    LEFT_PARENTHESE
    action_body 
    RIGHT_PARENTHESE 
    {
        setLineNumber(yylineno);
        char tmp[50];
        sscanf($1,"%s",tmp);
        // printf("%s  geeeeeeeeet it _______________________\n\n\n\n", tmp);
        // addOwner(tmp);
    }
    ;

action_parameters :
    action_parameter COMMA action_parameters
    | action_parameter
    | /* empty attributes */
    ;

action_parameter :
    SRC_IDENTIFIER {
        printf("Action attributes as src: %s\n", $1);
        setLineNumber(yylineno);
        addOwnerAttribute($1, "ACTION_SELF");
    }
    | IDENTIFIER {
        printf("Action attributes as identifier: %s\n", $1);
        setLineNumber(yylineno);
        addOwnerAttribute($1, "ACTION_PARAM");
    }
    ;

action_body :
    expressions
    ;

/* Expressions */

expressions :
    expression_line SEMICOLON expressions
    | expression_line
    | /* none */
    ;

expression_line :
    simple_expression
    | assignment_expression
    | if_then_else_expression
    | unit_expression 
    ;

simple_expression :
    LEFT_PARENTHESE expression_statement RIGHT_PARENTHESE
    | expression_statement
    ;

expression_statement :
    unit_expression operator simple_expression
    | unit_expression
    ;

assignment_expression :
    IDENTIFIER {
        printf("Got a new identifier: %s\n", $1);
        //symbol
        setLineNumber(yylineno);
        addOwnerAttribute($1, "ACTION_VAR");
    }
    EQUALS
    simple_expression
    ;

if_then_else_expression :
    IF simple_expression
    MEETS
    unit_expression
    THEN_DO
    expressions
    ELSE_DO
    expressions
    ;

unit_expression :
    value_spec {
        printf("Got a value spec.\n");
        // //Symbol
        // setLineNumber(yylineno);
        // checkAttr($1);
    }
    | template_statement_expression {
        printf("Got a template statement expression.\n");
    }
    | action_expression {
        printf("Got an action expression.\n");
    }
    | action_call_expression {
        printf("Got an action call expression.\n");
    }
    | mapper_expression {
        printf("Got a mapper expression.\n");
    }
    ;

template_statement_expression :
    MULTIPLY operator simple_expression
    ;

action_expression :
    IDENTIFIER {
        printf("Got a new identifier: %s\n", $1);
    }
    COLON LEFT_BRACKET
    action_expression_config
    RIGHT_BRACKET
    ;

action_expression_config :
    simple_expression COMMA action_expression_config
    | simple_expression
    ;

action_call_expression :
    EXCLAMATION action_expression
    ;

/* FIXME: this is bad, because we have left recursion. */
/* FIXME: the expression syntax needs to be reconsidered */
mapper_expression :
    unit_expression mapper_clause
    ;

mapper_clause :
    mapper
    LEFT_BRACKET
    mapper_parameters
    VERTICAL_LINE
    simple_expression
    RIGHT_BRACKET
    mapper_clause
    | mapper
    LEFT_BRACKET
    mapper_parameters
    VERTICAL_LINE
    simple_expression
    RIGHT_BRACKET
    ;

mapper_parameters :
    mapper_identifier COMMA mapper_parameters
    | mapper_identifier
    ;

mapper_identifier :
    IDENTIFIER
    | UNDERSCORE
    ;

mapper :
    MAP | REDUCE | FILTER
    ;

operator :
    PLUS | MINUS | MULTIPLY | DIVIDE | PERCENT | POWER | CONCAT
    | NOT_EQUAL | DEEP_EQUAL | APPROX_MATCH
    | LESS | GREATER | LESS_EQUAL | GREATER_EQUAL
    | AND | OR
    ;

/* Generic attribute syntax */

attribute_spec :
    IDENTIFIER {
        printf("Attribute key: %s\n", $1);
    }
    COLON
    value_spec {
        printf("Attribute value.\n");
        //Symbol
        // setLineNumber(yylineno);
        addOwnerAttribute($1, $4);
    }
    ;

value_spec :
    | attribute_or_identifier_access {
        // sscanf($1, "%s", $$);
    }
    | value {
        // FIXME: treat with real values when we can fully support recognizing all datatypes
        // TODO: we replace all values for now with placeholder value instead of full translation
        strcpy($$, "\"placeholder_constant_value\"");
        // printf("%s is $1 : VALUE    \5 mm    ^^^^^^^^^^^^^^^^^^^^^^\n\n", $1);
    }
    ;

attribute_or_identifier_access :
    attribute_or_identifier_access_base {
        strcpy(tmp_attr,"");
    }
    attribute_or_identifier_access_clause {
        // char tmp_access[100];
        // strcpy(tmp_access, $1);
        // printf("%s is $1^^^^^^^^^^^^^^^^^^^^^^\n\n", $1);
        // strcat(tmp_access, $3);
        // printf("%s is $3^^^^^^^^^^^^^^^^^^^^^^\n\n", $3);
        // sscanf(tmp_access, "%s", $$);
        // printf("%s is $$^^^^^^^^^^^^^^^^^^^^^^\n\n", $$);
    }
    ;

// TODO: fix the  wrong combination
attribute_or_identifier_access_clause :
    DOT {
        // strcat(tmp_attr, ".");
    }
    IDENTIFIER {
        printf("Attribute access key: %s\n", $3);
        // strcat(tmp_attr, $3);
    }
    attribute_or_identifier_access_clause
    | DOT {strcat(tmp_attr, ".");}
    IDENTIFIER {
        printf("Attribute access key: %s\n", $3);
        // strcat(tmp_attr, $3);
        // sscanf(tmp_attr, "%s", $$);
    }
    | /* empty access clause */{
        // sscanf(tmp_attr, "%s", $$);
    }
    ;

attribute_or_identifier_access_base :
    IDENTIFIER {
        printf("Attribute identifier parent: %s\n", $1);
        // sscanf($1, "%s", $$);
    }
    | SRC_IDENTIFIER {
        printf("Attribute src_identifier parent: %s\n", $1);
        // sscanf($1, "%s", $$);
    }
    ;

value :
    NIL {
        printf("Got nil.\n");
        // sscanf("", "%s", $$);
    }
    | BOOLEAN_TRUE {
        printf("Got true.\n");
        // sscanf($1, "%s", $$);
    }
    | BOOLEAN_FALSE {
        printf("Got false.\n");
        // sscanf($1, "%s", $$);
    }
    | UNIT {
        printf("Got unit.\n"); 
        // sscanf($1, "%s", $$);
    }
    | unitnumber {
        printf("Got unit number.\n");
        // sscanf($1, "%s", $$);
    }
    | REAL_NUMBER {
        printf("Got real number.\n");
        // sscanf($1, "%s", $$);
    }
    | NATURAL_NUMBER {
        printf("Got natural number.\n"); 
        // sscanf($1, "%s", $$);
    }
    | STRING {
        //todo:string fail to transfer
        printf("Got string.\n"); 
        // sscanf($1, "%s", $$);
        // printf("%s is $1 :STRING  \5 mm    ^^^^^^^^^^^^^^^^^^^^^^\n\n", $1);
    }
    | collection {
        printf("Got collection.\n");
        // sscanf($1, "%s", $$);
    }
    ;

unitnumber :
    REAL_NUMBER UNIT {
        // strcpy(tmp_unitnumber, $1);
        // strcat(tmp_unitnumber, $2); 
        // sscanf(tmp_unitnumber, "%s", $$);
    }
    | NATURAL_NUMBER UNIT {
        // strcpy(tmp_unitnumber, $1);
        // strcat(tmp_unitnumber, $2); 
        // sscanf(tmp_unitnumber, "%s", $$);
    }
    ;

collection :
    LEFT_SQUAREBRACKET {strcpy(tmp_collection,"");}
    collection_body {
        printf("\nGot collection body.\n");
        // sscanf($3, "%s", $$);
    }
    RIGHT_SQUAREBRACKET
    ;


collection_body :
    // FIXME: deal with collections separetely
    // TODO: replace it with char[][]
    value_spec {
        // strcat(tmp_collection, $1);
    } COMMA {
        // strcat(tmp_collection, ",");
    }
    collection_body {
        // strcat(tmp_collection, $5);
    }
    | value_spec {
        // strcat(tmp_collection, $1);
        // sscanf(tmp_collection, "%s", $$);
    }
    | /* empty body */ {
        // strcat(tmp_collection, "");
        // sscanf(tmp_collection, "%s", $$);
    }
    ;

%%

// Additional C code
// ~~~~~~~~~~~~~~~~~

// Set the debug flag if not in production mode.
#ifdef YYDEBUG
    extern int yydebug;
    int yydebug = 1;
#endif

// Catch parsing error.
void yyerror(const char* s) {
    fprintf(stderr, "On line: %d; Parse error: %s\n", yylineno, s);
    exit(1);
}

// Main parsing entrypoint
int main() {
    // Initialize the CHICKEN modules.
    // TODO: remove this demo CHICKEN binding since it's not used.
    /* C_word x;
    CHICKEN_run(CHICKEN_default_toplevel);
    CHICKEN_load("lib/python_builder.scm");
    CHICKEN_eval_string("(print (test-greet))", &x);
    CHICKEN_eval_string("(print \"hello from CHICKEN\")", &x); */

    // Start the parsing
    yyparse();

    // Output the collected info.
    dumpPythonSkeleton();
    enflatePythonSkeleton();

    // Done parsing.
}

