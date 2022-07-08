#include <stdio.h>
#include <string.h>	
#include <stdlib.h>

extern int lineCount;
int typeCount=0;
//unitnumber and collection typedef
typedef struct unitnumber {
    int intNum;
    float realNum;
    char unit[10];
} unitNumber;

typedef struct collection {
    int intType;
    char charType[100];
    unitNumber unitnumberType;
    float floatType;
    struct collection *collectionType;
}Collection;

//SymbolTable
enum typeEnum
{
    action, module, asset, observer, plant
};
enum varconstEnum
{
    constant, variable
};
struct SymbolTableStruct {
    char label[100];
    char type[10]; 
    enum typeEnum typeValue;
    // enum varconstEnum varconst;
    unitNumber unitnumberValue;
    int intValue;
    float realValue;
    char strValue[100];
    Collection collectionValue[100];
};
struct SymbolTableStruct globalSymbolTable[200];  
struct SymbolTableStruct localSymbolTable[200]; // size = %src.items @> {_ | + 1};
int globalSymbolCount=0;
int localSymbolCount=0;

//Action table : used to check if called actions in assets exist
struct ActionTableStruct {
    char label[100];
    char type[100];// check or send(notify)
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

void checkAction(char label[]) {
    if(lookupAction(actionTable, label, actionCount) == -1)
        printf("\"%s\" Error: The action is not defined:line%d\n", label, lineCount+1);
}
//Observer table
struct ObserverTableStruct {
    char label[100];
    char addr[100];
};
struct ObserverTableStruct observerTable[100];
int observerCount = 0;

int lookupObserver(struct ObserverTableStruct observerTable[],char compareString[],int observerCount) {
    for(int i = 0; i < observerCount; i++) {
        if(!strcmp(observerTable[i].label, compareString))
            return i;
    }
    return -1;
}

void addObserver(char label[], char addr[]) {
    if(lookupObserver(observerTable, label, observerCount) == -1) {
        sscanf(label,"%s", observerTable[observerCount].label);
        sscanf(addr,"%s", observerTable[observerCount].addr);
        observerCount++;
    }
}

void checkObserver(char label[]) {
    for(int i = 0; i < observerCount - 1; i++) {
        if(!strcmp(observerTable[i].addr, observerTable[i + 1].addr)) {
            //error msg
            return i;
        }
    }
    return -1;
}

//Cronjob table : used to stroe and check if cronjobs in assets exist
struct CronjobTableStruct {
    char label[100];
    // char [100];// check or send(notify)
};
struct CronjobTableStruct cronjobTable[100];
int cronjobCount = 0;

int lookupCronjob(struct CronjobTableStruct cronjobTable[],char compareString[],int cronjobCount) {
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
		if(lookup(localSymbolTable, label, localSymbolCount) == -1 && lookup(globalSymbolTable, label, globalSymbolCount) == -1 && lookupAction(actionTable, label, actionCount) == -1 && lookupCronjob(cronjobTable, label, actionCount) == -1)
			printf("\"%s\" Error:Undeclared variable:line%d\n",label,lineCount+1);
}

// void addType(char type[]) {
//     if(scope == global)
//     {
//         for(int i = globalSymbolCount-typeCount; i < globalSymbolCount; i++) {
//             sscanf(type, "%s", globalSymbolTable[i].type);
//             globalSymbolTable[i].varconst = varconst;            
//         }
//     }
//     else
//     {
//         for(int i = localSymbolCount - typeCount; i < localSymbolCount; i++)
//         {
//             sscanf(type,"%s",localSymbolTable[i].type);
//             localSymbolTable[i].varconst = varconst;
//         }
//     }
//     typeCount=0;
// }

void addSymbol(char label[], enum typeEnum typeValue) {
if(!strcmp("",label)) return;
    if(scope == global) {
        if(lookup(globalSymbolTable, label, globalSymbolCount) == -1) {
            sscanf(label,"%s", globalSymbolTable[globalSymbolCount].label);
            globalSymbolTable[globalSymbolCount].typeValue = typeValue; 
            globalSymbolCount++;
        } else {
            printf("\"%s\" Error: The label has been used:line%d\n", label, lineCount+1);
            error = 1;
        }
    }
    else {
        if(lookup(localSymbolTable,label,localSymbolCount) == -1) {
            sscanf(label, "%s", localSymbolTable[localSymbolCount].label);
            localSymbolCount++;
        } else {
            printf("\"%s\" Error: The label has been used:line%d\n", label, lineCount+1);
            error = 1;
        }
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
        strcpy(globalSymbolTable[globalSymbolCount - 1].strValue, strValue);
    }
    else {
        localSymbolTable[localSymbolCount - 1].intValue=intValue;
        localSymbolTable[localSymbolCount - 1].realValue = realValue;
        strcpy(localSymbolTable[localSymbolCount-1].strValue, strValue);
    }	
}