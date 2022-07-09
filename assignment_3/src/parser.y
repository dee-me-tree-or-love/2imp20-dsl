%{

#include <stdio.h>
#include <string.h>	
#include <stdlib.h>
// #include "../chicken-5.3.0/chicken.h"
#include "../lib/symbol_table.h"
#include "../lib/python_builder.h"

// Explicit defintions of the YY API
extern int yylex();
extern int yyparse();
extern void yyerror(const char *s);
extern FILE* yyin;



char tmp_collection[100];
char tmp_unitnumber[100];
char tmp_access[100];

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
    char istr[100];
}

/* FIXME: extend with the remaining "values" */
%type <istr> IDENTIFIER
%type <istr> SRC_IDENTIFIER
%type <ival> REAL_NUMBER
%type <ival> NATURAL_NUMBER
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
        // FIXME: id is undeclared
        // printf("Module name:%s\n", id);

        //Symbol
        addSymbol($4, module);
        // TODO: add to python skeleton
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
        //Symbol
        addSymbol($1, plant);
        attrCount = 0;
    }
    LEFT_DOUBLEANGLE
    plant_body
    RIGHT_DOUBLEANGLE{ownerCount++;}
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
        // FIXME: create a "debug" function and make it work right
        printf("Observer name: %s\n", $1);
        //Symbol
        addSymbol($1, observer);
    }
    LEFT_DOUBLEANGLE
    observer_body {addObserver($1, $4);}
    RIGHT_DOUBLEANGLE
    ;

/* FIXME: use tokenizer to specify different observer configs */
observer_body :
    STRING {
        printf("Observer body: %s\n", $1);
        sscanf($1, "%s", $$);
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
        // FIXME: create a "debug" function and make it work right
        printf("MONITOR Controller.\n");
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
        printf("Got regular attribute spec.\n");
    }
    ;

/* TODO: implement sensor spec */
asset_sensors_attribute_spec :
    SENSORS COLON LEFT_BRACKET
    sensor_configs
    /* FIXME: make sure to support multiple sensors */
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
        // FIXME: create a "debug" function and make it work right
        printf("Action name: %s\n", $1);
        //Symbol
        addSymbol($1, action);
    }
    LEFT_DOUBLEANGLE
    action_parameters
    RIGHT_DOUBLEANGLE
    LEFT_PARENTHESE
    action_body
    RIGHT_PARENTHESE
    ;

action_parameters :
    action_parameter COMMA action_parameters
    | action_parameter
    | /* empty attributes */
    ;

action_parameter :
    SRC_IDENTIFIER {
        // FIXME: create a "debug" function and make it work right
        printf("Action attributes as src: %s\n", $1);
    }
    | IDENTIFIER {
        // FIXME: create a "debug" function and make it work right
        printf("Action attributes as identifier: %s\n", $1);
    }
    /* TODO: add support for optional collection parameters */
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
    }
    |  template_statement_expression {
         printf("Got a template statement expression.\n");
    }
    | action_expression {
        printf("Got an action expression.\n");
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
        addAttr($1, $4);
    }
    ;

value_spec :
    | attribute_or_identifier_access {sscanf($1, "%s", $$);}
    | value {sscanf($1, "%s", $$);}
    ;

attribute_or_identifier_access :
    attribute_or_identifier_access_base 
    attribute_or_identifier_access_clause {
        strcpy(tmp_access, $1);
        strcat(tmp_access, $2);
        sscanf(tmp_access, "%s", $$);
    }
    ;

attribute_or_identifier_access_clause :
    DOT {strcat(tmp_access, ".");}
    IDENTIFIER {
        printf("Attribute access key: %s\n", $3);
        strcat(tmp_access, $3);
    }
    attribute_or_identifier_access_clause {
        strcat(tmp_access, $5);
        sscanf(tmp_access, "%s", $$);
    }
    | DOT {strcat(tmp_access,  ".");}
    IDENTIFIER {
        printf("Attribute access key: %s\n", $3);
        strcat(tmp_access, $3);
        sscanf(tmp_access, "%s", $$);
    }
    | /* empty access clause */{sscanf("", "%s", $$);}
    ;

attribute_or_identifier_access_base :
    IDENTIFIER {
        printf("Attribute identifier parent: %s\n", $1);
        sscanf($1, "%s", $$);
    }
    | SRC_IDENTIFIER {
        printf("Attribute src_identifier parent: %s\n", $1);
        sscanf($1, "%s", $$);
    }
    ;

value :
    NIL {
        printf("Got nil.\n");
        //  sscanf("", "%s", $$);
    }
    | BOOLEAN_TRUE {
        printf("Got true.\n");
        //  sscanf($1, "%s", $$);
    }
    | BOOLEAN_FALSE {
        printf("Got false.\n");
        //  sscanf($1, "%s", $$);
    }
    | UNIT {
        printf("Got unit.\n"); 
        // sscanf($1, "%s", $$);
    }
    | unitnumber {
        printf("Got unit number.\n");
        //  sscanf($1, "%s", $$);
    }
    | REAL_NUMBER {
        printf("Got real number.\n");
        //  sscanf($1, "%s", $$);
    }
    | NATURAL_NUMBER {
        printf("Got natural number.\n"); 
        // sscanf($1, "%s", $$);
    }
    | STRING {
        printf("Got string.\n"); 
        // sscanf($1, "%s", $$);
    }
    | collection {
        printf("Got collection.\n");
        //  sscanf($1, "%s", $$);
    }
    ;

unitnumber :
    REAL_NUMBER UNIT {
        // FIXME: this is the seg fault part
        // strcpy(tmp_unitnumber, $1);
        // strcat(tmp_unitnumber, $2); 
        // sscanf(tmp_unitnumber, "%s", $$);
    }
    | NATURAL_NUMBER UNIT {
        // FIXME: this is the seg fault part
        // strcpy(tmp_unitnumber, $1);
        // strcat(tmp_unitnumber, $2); 
        // sscanf(tmp_unitnumber, "%s", $$);
    }
    ;

collection :
    LEFT_SQUAREBRACKET
    collection_body {
        printf("\nGot collection body.\n");
        // sscanf($2, "%s", $$);
    }
    RIGHT_SQUAREBRACKET
    ;


collection_body :
    //todo:replace it with char[][]
    value_spec {
        // FIXME: remove the illegal instruction generating errors
        // strcpy(tmp_collection, $1);
    } COMMA {
        // FIXME: remove the illegal instruction generating errors
        // strcat(tmp_collection, ",");
    }
    collection_body {
        // FIXME: remove the illegal instruction generating errors
        // strcat(tmp_collection, $5);
        // sscanf(tmp_collection, "%s", $$);
    }
    | value_spec {
        // FIXME: remove the illegal instruction generating errors
        // sscanf($1, "%s", $$);
    }
    | /* empty body */
    ;

%%

// Additional C code
// ~~~~~~~~~~~~~~~~~

void yyerror(const char* s) {
    fprintf(stderr, "Parse error: %s\n", s);
    exit(1);
}

int main() {
    #ifdef YYDEBUG
        yydebug = 1;
    #endif

    /* yyin = stdin; */

    // TODO: remove this demo CHICKEN binding.
    /* C_word x; */
    /* CHICKEN_run(CHICKEN_default_toplevel); */
    /* CHICKEN_eval_string("(print \"hello from CHICKEN\")", &x); */

    // TODO: adjust this to use a file input in the future
    yyparse();

    // Done parsing.
}

