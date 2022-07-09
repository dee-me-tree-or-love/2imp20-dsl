#include <stdio.h>
#include <string.h>	
#include <stdlib.h>

// FIXME: this fails to compile
// extern int lineCount;
int lineCount;
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
    action, module, asset, observer, plant, nil
};
struct SymbolTableStruct {
    char label[100];
    enum typeEnum typeValue;
    unitNumber unitnumberValue;
    int intValue;
    float realValue;
    char strValue[100];
    Collection collectionValue[100];
};
struct SymbolTableStruct symbolTable[200];  
struct SymbolTableStruct localSymbolTable[200]; // size = %src.items @> {_ | + 1};
int symbolCount=0;
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

/* Observer table */
/*~~~~~~~~~~~~~~~~*/
struct ObserverTableStruct {
    char label[100];
    char addr[100];
};
struct ObserverTableStruct observerTable[100];
int observerCount = 0;

int lookupObserver(struct ObserverTableStruct observerTable[],char compareString[],int observerCount) {
    for(int i = 0; i < observerCount; i++) {
        if(!strcmp(observerTable[i].label, compareString))
            printf("\"%s\" Error:This observer label has been used:line%d\n", compareString, lineCount+1);
            return i;
    }
    return -1;
}
int lookupAddr(struct ObserverTableStruct observerTable[],char compareString[],int observerCount) {
    for(int i = 0; i < observerCount; i++) {
        if(!strcmp(observerTable[i].addr, compareString)) {
            printf("\"%s\" Error:This addr has been used:line%d\n", compareString, lineCount+1);
            return i;
        }
    }
    return -1;
}

void addObserver(char label[], char addr[]) {
    if((lookupObserver(observerTable, label, observerCount) == -1) && (lookupObserver(observerTable, addr, observerCount) == -1)) {
        sscanf(label,"%s", observerTable[observerCount].label);
        sscanf(addr,"%s", observerTable[observerCount].addr);
        observerCount++;
    }
}

// used in asset
void checkObservere(char label[])
{
    if(lookupObserver(observerTable, label,observerCount)==-1)
        printf("\"%s\" Error:Unavailable observer:line%d\n", label, lineCount+1);
}
/* Observer table */

/* Plant table */
/*~~~~~~~~~~~~~~~~*/
struct attribute {
    char variable[100];
    char value[100];
};
struct PlantTableStruct {
    char label[100];
    struct attribute allAttrs[100];
    int attrCount;
};
struct PlantTableStruct plantTable[100];
int plantCount = 0;

int lookupPlant(struct PlantTableStruct plantTable[],char compareString[],int plantCount) {
    for(int i = 0; i < plantCount; i++) {
        if(!strcmp(plantTable[i].label, compareString))
            printf("\"%s\" Error:This plant label has been used:line%d\n", compareString, lineCount+1);
            return i;
    }
    return -1;
}
int lookupParam(struct PlantTableStruct plantTable[], char pVar[], char pVal[]) {
    for(int i = 0; i < plantCount; i++) {
        for(int j = 0; j < plantTable[i].attrCount; j++) {
            // if(!strcmp(plantTable[i].allAttrs[j].variable, )) {
            //     printf("\"%s\" Error:This attr has been defined:line%d\n",  pVar, lineCount+1);
                return i;
            // }
        }
    }
    return -1;
}

void addPlant(char label[], struct attribute attrs[]) {
    if(lookupPlant(plantTable, label, plantCount) == -1) {
        sscanf(label,"%s", plantTable[plantCount].label);
        plantCount++;
    }
}

void addAttr(char var[], char val[]) {
    if(lookupParam(plantTable, var, val) == -1) {
        sscanf(var,"%s", plantTable[plantCount].allAttrs[plantCount].variable);
    }
}

// used in asset
void checkPlant(char label[])
{
    if(lookupPlant(plantTable, label,plantCount)==-1)
        printf("\"%s\" Error:Unavailable plant:line%d\n", label, lineCount+1);
}
/* Plant table */

//basic symbol look up function 
int lookup(struct SymbolTableStruct symbolTable[],char compareString[],int symbolCount) { 
    for(int i=0; i<symbolCount; i++) {
        if(!strcmp(symbolTable[i].label,compareString))// if input string euqals symboltable
            return i;
    }
    return -1;
}

//get symbol type
enum typeEnum getSymbolType(char label[]) {
    int index = lookup(localSymbolTable, label, localSymbolCount);
    if(index != -1) {
        return localSymbolTable[index].typeValue;
    }
	index=lookup(symbolTable,label,symbolCount);
	if(index != -1)
		return symbolTable[index].typeValue;
    return nil;
}

//Scope
enum scopeEnum
{
    global,local
};
enum scopeEnum scope=global;

void checkScope(char label[]) {
    if(lookup(localSymbolTable, label, localSymbolCount) == -1 && lookup(symbolTable, label, symbolCount) == -1)
        printf("\"%s\" Error:Undeclared variable:line%d\n", label, lineCount+1);
}

void checkall(char label[]) {
		if(lookup(localSymbolTable, label, localSymbolCount) == -1 && lookup(symbolTable, label, symbolCount) == -1 && lookupAction(actionTable, label, actionCount) == -1)
			printf("\"%s\" Error:Undeclared variable:line%d\n",label,lineCount+1);
}

// void addType(char type[]) {
//     if(scope == global)
//     {
//         for(int i = symbolCount-typeCount; i < symbolCount; i++) {
//             sscanf(type, "%s", symbolTable[i].type);
//             symbolTable[i].varconst = varconst;            
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
    int error;
    if(!strcmp("",label)) return;
        if(scope == global) {
            if(lookup(symbolTable, label, symbolCount) == -1) {
                sscanf(label,"%s", symbolTable[symbolCount].label);
                symbolTable[symbolCount].typeValue = typeValue; 
                symbolCount++;
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
        symbolTable[symbolCount - 1].intValue = intValue;
        symbolTable[symbolCount - 1].realValue = realValue;
        strcpy(symbolTable[symbolCount - 1].strValue, strValue);
    }
    else {
        localSymbolTable[localSymbolCount - 1].intValue=intValue;
        localSymbolTable[localSymbolCount - 1].realValue = realValue;
        strcpy(localSymbolTable[localSymbolCount-1].strValue, strValue);
    }	
}