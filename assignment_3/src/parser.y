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
    action, module, asset, channel, variable, collection, unit
};
struct SymbolTableStruct {
    char label[100];
    enum typeEnum typeenum;
    char unit[10];
    int intValue;
    float realValue;
    char strValue[100];
};
struct SymbolTableStruct globalSymbolTable[200];  
struct SymbolTableStruct localSymbolTable[200]; // size = %src.items @> {_ | + 1};
int globalSymbolCount=0;
int localSymbolCount=0;

//Scope
enum scopeEnum
{
    global,local
};
enum scopeEnum scope=global;
void checkScope(char label[]) {
    if(lookup(localSymbolTable, label, localSymbolCount)==-1 && lookup(globalSymbolTable,label,globalSymbolCount)==-1)
        printf("\"%s\" 未声明:line%d\n",label,lineCount+1);
}
void checkall(char label[])
{
    if(lookup(localSymbolTable,label,localSymbolCount)==-1 && lookup(globalSymbolTable,label,globalSymbolCount)==-1 && lookupProcedure(procedureTable,label,procedureCount)==-1)
        printf("\"%s\" 未声明:line%d\n",label,lineCount+1);
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
//Actions Name



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
// %new opeators
%left LESS LESSEQUAL EQUAL GREATEREQUAL GREATER NOTEQUAL
%left PLUS MINUS
%left MULTIPLY DIVIDE
%nonassoc UMINUS

%start program

%%

program:
    | program statement

statement: 
    T_NEWLINE         { ; } // ignore new line
    | T_QUIT T_NEWLINE  { printf("bye!\n"); exit(0); }
    | greet_request     { printf("\tResult: greet request \n"); }

greet_request:
    T_GREET T_INT     { }

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
