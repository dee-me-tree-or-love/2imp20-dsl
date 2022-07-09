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

%type <istr> value
%type <istr> value_spec
%type <istr> unitnumber
%type <istr> attribute_or_identifier_access

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

/* FIXME: use tokenizer to specify different observer configs */
observer_body :
    observer_misc {
        // sscanf($$, "%s", $1);
        // printf("Observer misc body: %s.\n", $$);
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
        addAttr()
    }
    ;

value_spec :
    | attribute_or_identifier_access
    | value {sscanf($1, "%s", $$);}
    ;

attribute_or_identifier_access :
    IDENTIFIER {
        printf("Attribute parent: %s\n", $1);
    }
    DOT
    attribute_or_identifier_access
    | IDENTIFIER {
        printf("Attribute or identifier access: %s\n", $1);

        //Symbol
        {sscanf($1, "%s", $$);}
    }
    ;

value :
    NIL {sscanf($1, "%s", $$);}
    | BOOLEAN_TRUE  {sscanf($1, "%s", $$);}
    | BOOLEAN_FALSE {sscanf($1, "%s", $$);}
    | UNIT {sscanf($1, "%s", $$);}
    | unitnumber {sscanf($1, "%s", $$);}
    | REAL_NUMBER {sscanf($1, "%s", $$);}
    | NATURAL_NUMBER {sscanf($1, "%s", $$);}
    | STRING {sscanf($1, "%s", $$);}
    | COLLECTION {sscanf($1, "%s", $$);}
    ;

unitnumber : REAL_NUMBER UNIT {sscanf($1, "%s", $$);}
           | NATURAL_NUMBER UNIT {sscanf($1, "%s", $$);}


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

