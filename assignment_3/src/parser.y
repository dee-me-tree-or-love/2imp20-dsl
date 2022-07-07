%{

#include <stdio.h>
#include <string.h>	
#include <stdlib.h>
#include "../chicken-5.3.0/chicken.h"

extern int yylex();
extern int yyparse();
extern int lineCount;
extern FILE* yyin;

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
    Collection collectionValue[100];
};
struct SymbolTableStruct globalSymbolTable[200];  
struct SymbolTableStruct localSymbolTable[200]; // size = %src.items @> {_ | + 1};
int globalSymbolCount=0;
int localSymbolCount=0;

//Action table : used to check if called actions in assets exist
struct ActionTableStruct {
    char label[100];
    char type[100];
};
struct ActionTableStruct actionTable[100];
int actionCount = 0;

int lookupAction(struct ActionTableStruct actionTable[],char compareString[],int actionCount) {
    for(int i = 0; i < actionCount; i++) {
        if(!strcmp(actionTable[i].label, compareString))
            return i;
    }
    return -1;
}

void addAction(char label[]) {
    if(lookupAction(actionTable, label, actionCount) == -1) {
        actionTable[actionCount].label[0]='\0';
        strcat(actionTable[actionCount].label, label);
        actionCount++;
    }
}

void checkAction(char label[])
{
    if(lookupAction(actionTable, label, actionCount) == -1)
        printf("\"%s\" Error: The action is not defined:line%d\n", label, lineCount+1);
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
		if(lookup(localSymbolTable, label, localSymbolCount) == -1 && lookup(globalSymbolTable, label, globalSymbolCount) == -1 && lookupAction(actionTable, label, actionCount) == -1)
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

void addSymbol(char label[]) {
if(!strcmp("",label)) return;
    if(scope == global)
    {
        if(lookup(globalSymbolTable, label, globalSymbolCount) == -1)
        {
            sscanf(label,"%s", globalSymbolTable[globalSymbolCount].label);
            globalSymbolCount++;
        }
    }
    else
    {
        if(lookup(localSymbolTable,label,localSymbolCount) == -1)
        {
            sscanf(label, "%s", localSymbolTable[localSymbolCount].label);
            localSymbolCount++;
        }
    }	
}

//Constant Value: collection 
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



//if label
int ifLabelCount = 0;

%}

%token COMMA DOT COLON COLON SEMICOLON LEFTPARENTHESE RIGHTPARENTHESE LEFTSQUAREBRACKET RIGHTSQUAREBRACKET LEFTBRACKET RIGHTBRACKET LESS GREATER LEFTQUOTE RIGHTQUOTE
%token PLUS MINUS MULTIPLY DIVIDE PERCENT POWER TRANSFER AT DASH LINE
%token DEEPEQUAL NOTEQUAL APPROXMATCH AND OR DOACTION FILTER FEED PARALLEL
%token MODULE IMPORT PLANTS ACTIONS ASSETS PLANTATION WATERSOURCE CHANNELS CONTROLLERS MONITOR SRC ITEMS
%token WATERUSE...
%token CAPACITY...

%union {
    int ival;
    char istr[100];
}
// semantic type
/* %type<istr> greet_request */

%type <istr> IDENTIFIER
%type <ival> INTEGERCONSTANTS
%type <ival> BOOLEANCONSTANTS
%type <istr> STRINGCONSTANTS


%left OR
%left AND
%left LESS LESSEQUAL DEEPEQUAL GREATEREQUAL GREATER NOTEQUAL APPROXMATCH
%left PLUS MINUS
%left MULTIPLY DIVIDE
%nonassoc UMINUS

%start program

%%

program: 
MODULE COLON LEFTBRACKET IDENTIFIER RIGHTBRACKET
PLANTS COLON LEFTBRACKET plants_decs RIGHTBRACKET
ACTIONS COLON LEFTBRACKET actions_decs RIGHTBRACKET
ASSETS COLON LEFTBRACKET assets_decs RIGHTBRACKET
CHANNELS COLON LEFTBRACKET channels_decs RIGHTBRACKET
CONTROLLERS COLON LEFTBRACKET controllers_decs RIGHTBRACKET
;

plants_decs:
;

actions_decs:
;

assets_decs:
;

channels_decs:
;

controllers_decs:
;

//Expression
expression:MINUS expression %prec UMINUS //disambiguate
|expression MULTIPLY expression	
|expression DIVIDE expression
|expression PLUS expression	
|expression MINUS expression
|expression REMAINDER expression
|LEFTPARENTHESES expression RIGHTPARENTHESES	
|constant
|IDENTIFIER
//add more expression situations
%%
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
