%{

#include <stdio.h>
#include <string.h>	
#include <stdlib.h>
#include "../chicken-5.3.0/chicken.h"

// Explicit defintions of the YY API
extern int yylex();
extern int yyparse();
extern void yyerror(const char *s);
extern FILE* yyin;

// extern int lineCount;

// FIXME: temporarily commented it out, because it fails to compile
// //unitnumber and collection typedef
// typedef struct unitnumber{
//     int intNum;
//     float realNum;
//     char unit[10];
// } unitNumber;

// typedef struct collection Collection{
//     int intType;
//     char charType;
//     unitNumber unitnumberType;
//     float floatType;
//     const char* stringType;
//     Collection *collectionType
// };

// //SymbolTable
// enum typeEnum
// {
//     action, module, asset, channel, variable
// };

// struct SymbolTableStruct {
//     char label[100];
//     enum typeEnum type; 
//     unitNumber unitnumberValue;
//     int intValue;
//     float realValue;
//     char strValue;
//     Collection collectionValue[100];
// };
// struct SymbolTableStruct globalSymbolTable[200];  
// struct SymbolTableStruct localSymbolTable[200]; // size = %src.items @> {_ | + 1};
// int globalSymbolCount=0;
// int localSymbolCount=0;

// //Action table : used to check if called actions in assets exist
// struct ActionTableStruct {
//     char label[100];
//     char type[100];// check or send(notify)
// };
// struct ActionTableStruct actionTable[100];
// int actionCount = 0;

// int lookupAction(struct ActionTableStruct actionTable[],char compareString[],int actionCount) {
//     for(int i = 0; i < actionCount; i++) {
//         if(!strcmp(actionTable[i].label, compareString))
//             return i;
//     }
//     return -1;
// }

// void addAction(char label[]) {
//     if(lookupAction(actionTable, label, actionCount) == -1) {
//         actionTable[actionCount].label[0]='\0';
//         strcat(actionTable[actionCount].label, label);
//         actionCount++;
//     }
// }

// void checkAction(char label[]) {
//     if(lookupAction(actionTable, label, actionCount) == -1)
//         printf("\"%s\" Error: The action is not defined:line%d\n", label, lineCount+1);
// }

// TODO: move this to `symbol_table.h` file?
// FIXME: this produces errors and prevents compiling the code
// //Cronjob table : used to stroe and check if cronjobs in assets exist
// struct CronjobTableStruct {
//     char label[100];
//     char [100];// check or send(notify)
// };
// struct CronjobTableStruct cronjobTable[100];
// int cronjobCount = 0;

// int lookupCronjob(struct CronjobsTableStruct cronjobTable[],char compareString[],int cronjobCount) {
//     for(int i = 0; i < cronjobCount; i++) {
//         if(!strcmp(cronjobTable[i].label, compareString))
//             return i;
//     }
//     return -1;
// }

// void addCronjob(char label[]) {
//     if(lookupCronjob(cronjobTable, label, cronjobCount) == -1) {
//         cronjobTable[cronjobCount].label[0]='\0';
//         strcat(cronjobTable[cronjobCount].label, label);
//         cronjobCount++;
//     }
// }

// void checkCronjob(char label[]) {
//     if(lookupCronjob(cronjobTable, label, cronjobCount) == -1)
//         printf("\"%s\" Error: The cronjob is not defined:line%d\n", label, lineCount+1);
// }

// //Scope
// enum scopeEnum
// {
//     global,local
// };
// enum scopeEnum scope=global;

// void checkScope(char label[]) {
//     if(lookup(localSymbolTable, label, localSymbolCount) == -1 && lookup(globalSymbolTable, label, globalSymbolCount) == -1)
//         printf("\"%s\" Error:Undeclared variable:line%d\n", label, lineCount+1);
// }

// void checkall(char label[]) {
// 		if(lookup(localSymbolTable, label, localSymbolCount) == -1 && lookup(globalSymbolTable, label, globalSymbolCount) == -1 && lookupAction(actionTable, label, actionCount) == -1 && lookupCronjob(actionTable, label, actionCount) == -1)
// 			printf("\"%s\" Error:Undeclared variable:line%d\n",label,lineCount+1);
// }


// //basic symbol look up function 
// int lookup(struct SymbolTableStruct symbolTable[],char compareString[],int symbolCount) { 
//     for(int i=0; i<symbolCount; i++) {
//         if(!strcmp(symbolTable[i].label,compareString))// if input string euqals symboltable
//             return i;
//     }
//     return -1;
// }

// //get symbol type
// char* getSymbolType(char label[]) {
//     int index = lookup(localSymbolTable, label, localSymbolCount);
//     if(index != -1) {
//         return localSymbolTable[index].type;
//     }
// 	index=lookup(globalSymbolTable,label,globalSymbolCount);
// 	if(index != -1)
// 		return globalSymbolTable[index].type;
//     return strdup("null");
// }

// void addType(char type[],enum typeEnum type) {
//     if(scope == global)
//     {
//         for(int i = globalSymbolCount-typeCount; i<globalSymbolCount; i++) {
//             sscanf(type, "%s",globalSymbolTable[i].type);
//             globalSymbolTable[i].type=type;
//         }
//     }
//     else
//     {
//         for(int i = localSymbolCount - typeCount; i < localSymbolCount; i++)
//         {
//             sscanf(type,"%s",localSymbolTable[i].type);
//             localSymbolTable[i].type = type;
//         }
//     }
//     typeCount=0;
// }

// void addSymbol(char label[]) {
// if(!strcmp("",label)) return;
//     if(scope == global) {
//         if(lookup(globalSymbolTable, label, globalSymbolCount) == -1) {
//             sscanf(label,"%s", globalSymbolTable[globalSymbolCount].label);
//             globalSymbolCount++;
//         }
//     }
//     else {
//         if(lookup(localSymbolTable,label,localSymbolCount) == -1) {
//             sscanf(label, "%s", localSymbolTable[localSymbolCount].label);
//             localSymbolCount++;
//         }
//     }	
// //TODO: add collection, unit number
// //TODO: initialize 
// int _int;
// float _real;
// char _string[100];
// void addValue(int intValue, char strValue[], float realValue) {
//     if(scope == global) {
//         globalSymbolTable[globalSymbolCount - 1].intValue = intValue;
//         globalSymbolTable[globalSymbolCount - 1].realValue = realValue;
//         strcpy(globalSymbolTable[globalSymbolCount-1].strValue, strValue);
//     }
//     else {
//         localSymbolTable[localSymbolCount - 1].intValue=intValue;
//         localSymbolTable[localSymbolCount - 1].realValue = realValue;
//         strcpy(localSymbolTable[localSymbolCount-1].strValue,strValue);
//     }	
// }

// //if label
// int ifLabelCount = 0;

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
        printf("Module name: %s\n", $4);
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
    ;

action_body :
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
    C_word x;
    CHICKEN_run(CHICKEN_default_toplevel);
    CHICKEN_eval_string("(print \"hello from CHICKEN\")", &x);

    // TODO: adjust this to use a file input in the future
    yyparse();

    // Done parsing.
}

