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
    action, module, asset, channel, variable, collection
};
struct SymbolTableStruct {
    char label[100];
    enum typeEnum typeenum;
    int intValue;
    float realValue;
    char strValue[100];
};

struct SymbolTableStruct globalSymbolTable[200];  
struct SymbolTableStruct localSymbolTable[200]; // size = %src.items @> {_ | + 1};

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
    int index = lookup(symbolTable, label, symbolCount);
    if(index != -1) {
        return symbolTable[index].type;
    }
    return strdup("null");
}
void addSymbol(char label[])	{
    if(!strcmp("",label))return;
    if(lookup(symbolTable, label, symbolCount) == -1) {
        sscanf(label, "%s", symbolTable[symbolCount].label);
        symbolCount++;
    }
}

//Constant Value
int constInt;
float constReal;
char constString[100];
void addIntValue(int intValue, real realValue, char strValue[])
{
    symbolTable[symbolCount-1].intValue = intValue;
    symbolTable[symbolCount-1].realValue = realValue;
    strcpy(symbolTable[symbolCount-1].strValue,strValue);
}
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
