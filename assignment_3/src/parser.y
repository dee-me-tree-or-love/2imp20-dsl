%{

#include <stdio.h>
#include <string.h>	
#include <stdlib.h>
#include "../chicken-5.3.0/chicken.h"

extern int yylex();
extern int yyparse();
extern int lineCount;
extern FILE* yyin;


//unitnumber and collection typedef
typedef struct unitnumber{
    int intNum;
    float realNum;
    char unit[10];
} unitNumber;

typedef struct collection Collection{
    int intType;
    char charType;
    unitNumber unitnumberType;
    float floatType;
    const char* stringType;
    Collection *collectionType
};

//SymbolTable
enum typeEnum
{
    action, module, asset, channel, variable
};

struct SymbolTableStruct {
    char label[100];
    enum typeEnum type; 
    unitNumber unitnumberValue;
    int intValue;
    float realValue;
    char strValue;
    Collection collectionValue[100];
};
struct SymbolTableStruct globalSymbolTable[200];  
struct SymbolTableStruct localSymbolTable[200]; // size = %src.items @> {_ | + 1};
int globalSymbolCount=0;
int localSymbolCount=0;

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

//Cronjob table : used to stroe and check if cronjobs in assets exist
struct CronjobTableStruct {
    char label[100];
    char [100];// check or send(notify)
};
struct CronjobTableStruct cronjobTable[100];
int cronjobCount = 0;

int lookupCronjob(struct CronjobsTableStruct cronjobTable[],char compareString[],int cronjobCount) {
    for(int i = 0; i < cronjobCount; i++) {
        if(!strcmp(cronjobTable[i].label, compareString))
            return i;
    }
    return -1;
}

void addCronjob(char label[]) {
    if(lookupCronjob(cronjobTable, label, cronjobCount) == -1) {
        cronjobTable[cronjobCount].label[0]='\0';
        strcat(cronjobTable[cronjobCount].label, label);
        cronjobCount++;
    }
}

void checkCronjob(char label[]) {
    if(lookupCronjob(cronjobTable, label, cronjobCount) == -1)
        printf("\"%s\" Error: The cronjob is not defined:line%d\n", label, lineCount+1);
}

//Scope
enum scopeEnum
{
    global,local
};
enum scopeEnum scope=global;

void checkScope(char label[]) {
    if(lookup(localSymbolTable, label, localSymbolCount) == -1 && lookup(globalSymbolTable, label, globalSymbolCount) == -1)
        printf("\"%s\" Error:Undeclared variable:line%d\n", label, lineCount+1);
}

void checkall(char label[]) {
		if(lookup(localSymbolTable, label, localSymbolCount) == -1 && lookup(globalSymbolTable, label, globalSymbolCount) == -1 && lookupAction(actionTable, label, actionCount) == -1 && lookupCronjob(actionTable, label, actionCount) == -1)
			printf("\"%s\" Error:Undeclared variable:line%d\n",label,lineCount+1);
}


//basic symbol look up function 
int lookup(struct SymbolTableStruct symbolTable[],char compareString[],int symbolCount) { 
    for(int i=0; i<symbolCount; i++) {
        if(!strcmp(symbolTable[i].label,compareString))// if input string euqals symboltable
            return i;
    }
    return -1;
}

//get symbol type
char* getSymbolType(char label[]) {
    int index = lookup(localSymbolTable, label, localSymbolCount);
    if(index != -1) {
        return localSymbolTable[index].type;
    }
	index=lookup(globalSymbolTable,label,globalSymbolCount);
	if(index != -1)
		return globalSymbolTable[index].type;
    return strdup("null");
}

void addType(char type[],enum typeEnum type) {
    if(scope == global)
    {
        for(int i = globalSymbolCount-typeCount; i<globalSymbolCount; i++) {
            sscanf(type, "%s",globalSymbolTable[i].type);
            globalSymbolTable[i].type=type;
        }
    }
    else
    {
        for(int i = localSymbolCount - typeCount; i < localSymbolCount; i++)
        {
            sscanf(type,"%s",localSymbolTable[i].type);
            localSymbolTable[i].type = type;
        }
    }
    typeCount=0;
}

void addSymbol(char label[]) {
if(!strcmp("",label)) return;
    if(scope == global) {
        if(lookup(globalSymbolTable, label, globalSymbolCount) == -1) {
            sscanf(label,"%s", globalSymbolTable[globalSymbolCount].label);
            globalSymbolCount++;
        }
    }
    else {
        if(lookup(localSymbolTable,label,localSymbolCount) == -1) {
            sscanf(label, "%s", localSymbolTable[localSymbolCount].label);
            localSymbolCount++;
        }
    }	
//TODO: add collection, unit number
//TODO: initialize 
int _int;
float _real;
char _string[100];
void addValue(int intValue, char strValue[], float realValue) {
    if(scope == global) {
        globalSymbolTable[globalSymbolCount - 1].intValue = intValue;
        globalSymbolTable[globalSymbolCount - 1].realValue = realValue;
        strcpy(globalSymbolTable[globalSymbolCount-1].strValue, strValue);
    }
    else {
        localSymbolTable[localSymbolCount - 1].intValue=intValue;
        localSymbolTable[localSymbolCount - 1].realValue = realValue;
        strcpy(localSymbolTable[localSymbolCount-1].strValue,strValue);
    }	
}

//if label
int ifLabelCount = 0;

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

%token IDENTIFIER

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
%token DASH
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
%token ACTIONS
%token ASSETS
%token PLANTATION
%token WATERSOURCE
%token CHANNELS
%token CONTROLLERS
%token MONITOR

// Semantics
// ~~~~~~~~~

%union {
    int ival;
    char istr[100];
}

%type <istr> IDENTIFIER
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

program: 
MODULE COLON LEFT_BRACKET 
IDENTIFIER 
{
    //python
    yyin = fopen("ail2py.py", "w");
    fprintf(yyin, " '''\n ************Python Code************* \n''' ");
    fprintf(yyin, " #This is the python code for ail module %s. \n", $4);
}
RIGHT_BRACKET
// PLANTS COLON LEFTBRACKET plants_decs RIGHTBRACKET
// ACTIONS COLON LEFTBRACKET actions_decs RIGHTBRACKET
// ASSETS COLON LEFTBRACKET assets_decs RIGHTBRACKET
// CHANNELS COLON LEFTBRACKET channels_decs RIGHTBRACKET
// CONTROLLERS COLON LEFTBRACKET controllers_decs RIGHTBRACKET
//END IDENTIFIER
// {
//     if(strcmp($4,$33))
// 		printf("Error:Wrong label:line%d\n",lineCount+1);
// 	//javaa
// 	fprintf(fp,"return\n}\n}");
// }
;

// plants_decs:plant_config plants_decs 
// |
// ;

// plant_config:IDENTIFIER ;


// actions_decs:
// ;

// assets_decs:
// ;

// channels_decs:
// ;

// controllers_decs:
// ;

// //Expression
// expression:MINUS expression %prec UMINUS //disambiguate
// |expression MULTIPLY expression	
// |expression DIVIDE expression
// |expression PLUS expression	
// |expression MINUS expression
// |expression REMAINDER expression
// |LEFTPARENTHESES expression RIGHTPARENTHESES	
// |constant
// |IDENTIFIER
// //add more expression situations


%%

// Additional C code
// ~~~~~~~~~~~~~~~~~

void yyerror(const char* s) {
    fprintf(stderr, "Parse error: %s\n", s);
    exit(1);
}

int main() {
    yyin = stdin;

    C_word x;
    CHICKEN_run(CHICKEN_default_toplevel);
    CHICKEN_eval_string("(print \"hello from CHICKEN\")", &x);

    do {
        yyparse();
    } while(!feof(yyin));

    fclose(yyin);
    return 0;
}
