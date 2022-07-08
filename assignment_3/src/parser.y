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
%token DOUBLE_LANGLE 
%token DOUBLE_RANGLE
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
%token COLLECTION

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

%token TRANSFER
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
%type <ival> UNIT_NUMBER
%type <ival> BOOLEAN_FALSE
%type <ival> BOOLEAN_TRUE
%type <istr> STRING
%type <ival> COLLECTION

%type <istr> observer_body
%type <istr> observer_misc
%type <istr> observer_email
%type <istr> observer_url

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
    }
    DOUBLE_LANGLE
    plant_body
    DOUBLE_RANGLE
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
    DOUBLE_LANGLE
    observer_body {addObserver($1, $4);}
    DOUBLE_RANGLE
    ;

observer_body :
    observer_misc {
        printf("Observer misc body.\n");
    }
    | observer_email {
        printf("Observer email body.\n");
    }
    | observer_url {
        printf("Observer url body.\n");
    }
    ;

observer_misc :
    IDENTIFIER DOT observer_misc {
        char addr[100];
        strcpy(addr, $1);
        strcat(addr, ".");
        strcat(addr, $3);
        sscanf(addr, "%s", $$);
    }
    | IDENTIFIER {sscanf($1, "%s", $$);}
    ;

observer_email :
    observer_misc AT observer_misc {
        char addr[100];
        strcpy(addr, $1);
        strcat(addr, "@");
        strcat(addr, $3);
        sscanf(addr, "%s", $$);
    }
    ;

observer_url :
    IDENTIFIER PROTOCOL observer_misc {
        char addr[100];
        strcpy(addr, $1);
        strcat(addr, "://");
        strcat(addr, $3);
        sscanf(addr, "%s", $$);
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
    DOUBLE_LANGLE
    action_parameters
    DOUBLE_RANGLE
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
/* ~~~~~~~~~~~ */

expressions :
    expression_line SEMICOLON expressions
    | expression_line
    | /* none */
    ;

expression_line :
    expression
    | assignment_expression
    | if_then_else_expression
    | unit_expression
    ;

expression :
    LEFT_PARENTHESE expression_statement RIGHT_PARENTHESE
    | expression_statement
    ;

expression_statement :
    unit_expression operator expression
    | unit_expression
    ;

assignment_expression :
    IDENTIFIER {
        printf("Got a new identifier: %s\n", $1);
    }
    EQUALS
    expression
    ;

if_then_else_expression :
    IF expression
    MEETS
    template_statement_expression
    THEN_DO
    expression
    ELSE_DO
    expression
    ;

template_statement_expression :
    MULTIPLY operator unit_expression
    ;

unit_expression :
    value_spec {
        printf("Got a value spec.\n");
    }
    | action_expression {
        printf("Got an action expression.\n");
    }
    | mapper_expression {
        printf("Got a mapper expression.\n");
    }
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
    expression COMMA action_expression_config
    | expression
    ;

/* FIXME: this is bad, because we have left recursion. */
/* FIXME: the expression syntax needs to be reconsidered */
mapper_expression :
    unit_expression mapper mapper_clause
    ;

mapper_clause :
    LEFT_BRACKET
    mapper_parameters
    VERTICAL_LINE
    expression
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
        scope = local;
    }
    COLON
    value_spec {
        printf("Attribute value.\n");
    }
    ;

value_spec :
    | attribute_or_identifier_access
    | value
    ;

attribute_or_identifier_access :
    IDENTIFIER {
        printf("Attribute parent: %s\n", $1);
    }
    DOT
    attribute_or_identifier_access
    | IDENTIFIER {
        printf("Attribute or identifier access: %s\n", $1);
    }
    ;

value :
    NIL
    | UNIT
    | BOOLEAN_TRUE
    | BOOLEAN_FALSE
    /* FIXME: unit numbers seem not to be working yet */
    | unitnumber
    | REAL_NUMBER
    | NATURAL_NUMBER
    | STRING
    | COLLECTION
    ;

unitnumber : REAL_NUMBER UNIT 
           | NATURAL_NUMBER UNIT 


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

