%{

#include <stdio.h>
#include <string.h>	
#include <stdlib.h>
// #include "../chicken-5.3.0/chicken.h"
// #include "../api/symbol_table.h"
#include "../api/python_builder.h"

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
%token BOOLEAN
%token NATURAL_NUMBER
%token REAL_NUMBER
%token UNIT_NUMBER
%token STRING
%token COLLECTION

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

%token TRANSFER
%token AT
%token UNDERSCORE
%token LINE
%token DEEP_EQUAL 
%token NOT_EQUAL
%token APPROX_MATCH
%token AND 
%token OR

%token REDUCE
%token DOACTION
%token FILTER

%token ACTION_ALTERNATIVE
%token ACTION_FEED
%token ACTION_SEQUENCE
%token ACTION_PARALLEL

%token IF
%token MEETS 
%token THEN
%token ELSE

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
%type <ival> BOOLEAN
%type <istr> STRING
%type <ival> COLLECTION

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
        // FIXME: create a "debug" function and make it work right
        char id[10];
        sscanf($4,"%s",id);
        printf("Module name:%s\n", id);
        // printf($4);
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
        // FIXME: create a "debug" function and make it work right
        printf("Plant name: %s\n", $1);
    }
    DOUBLE_LANGLE
    plant_body
    DOUBLE_RANGLE
    ;

plant_body :
    attribute COMMA plant_body
    | attribute
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
    }
    DOUBLE_LANGLE
    observer_body
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
        printf("Observer email body.\n");
    }
    ;

observer_misc :
    IDENTIFIER DOT observer_misc
    | IDENTIFIER
    ;

observer_email :
    observer_misc AT observer_misc
    ;

observer_url :
    IDENTIFIER PROTOCOL observer_misc
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
    /* TODO: add support for optionally collection parameters */
    ;

action_body :
    /* TODO: fix and support the regular statement syntax */
    IDENTIFIER {
        // FIXME: create a "debug" function and make it work right
        printf("Action body: %s\n", $1);
    }
    ;

/* Generic attribute syntax */

attribute :
    IDENTIFIER  {
        // FIXME: create a "debug" function and make it work right
        printf("Attribute key: %s\n", $1);
    }
    COLON
    value_spec {
        printf("Attribute value.\n");
    }
    ;

value_spec :
    IDENTIFIER
    | value
    ;

value :
    NIL
    | UNIT
    | BOOLEAN
    /* FIXME: unit numbers seem not to be working yet */
    | UNIT_NUMBER
    | REAL_NUMBER
    | NATURAL_NUMBER
    | STRING
    | COLLECTION
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

