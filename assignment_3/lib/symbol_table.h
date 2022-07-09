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
};
struct SymbolTableStruct symbolTable[200];  
int symbolCount=0;

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
    if(lookupObserver(observerTable, label, observerCount) == -1) {
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

/* Attribute table */
/*~~~~~~~~~~~~~~~~*/
struct attribute {
    char variable[100];
    char value[100];
};
struct AttrTableStruct {
    char owner[100];
    struct attribute attrs[100];
};
int ownerCount = 0;
int attrCount = 0;
struct AttrTableStruct AttrTable[100];

int lookupAttr(struct attribute attrs[], char aVar[], int attrCount) {
    for(int j = 0; j < attrCount; j++) {
        if(!strcmp(attrs[j].variable, aVar)) {
            printf("\"%s\" Error:This attr has been defined:line%d\n",  aVar, lineCount+1);
            return j;
        }
    }
    return -1;
}

int lookupOwner(struct AttrTableStruct AttrTable[], char owner[], int ownerCount) {
    for(int j = 0; j < ownerCount; j++) {
        if(!strcmp(AttrTable[j].owner, owner)) {
            printf("\"%s\" Error:This Plant has been defined:line%d\n",  owner, lineCount+1);
            return j;
        }
    }
    return -1;
}

void addAttr(char aVar[], char aVal[]) {
    if(lookupAttr(AttrTable[ownerCount].attrs, aVar, attrCount) == -1) {
        sscanf(aVar,"%s",AttrTable[ownerCount].attrs[attrCount].variable);
        if(!strcmp("",aVal)) {
            attrCount++;
            return;
        } else {
            sscanf(aVal,"%s", AttrTable[ownerCount].attrs[attrCount].value);
            attrCount++;//release after every plant defintion
        }
    }
}

void addOwner(char owner[], int ownerCount) {
    if(lookupOwner(AttrTable, owner, ownerCount) == -1) {
        sscanf(owner,"%s", AttrTable[ownerCount].owner);
        ownerCount++;//todo: release after every plant defintion
    }
}
/* Attribute table */

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
	int index=lookup(symbolTable,label,symbolCount);
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
    if(lookup(symbolTable, label, symbolCount) == -1 && lookup(symbolTable, label, symbolCount) == -1)
        printf("\"%s\" Error:Undeclared variable:line%d\n", label, lineCount+1);
}

void checkall(char label[]) {
		if(lookup(symbolTable, label, symbolCount) == -1 && lookup(symbolTable, label, symbolCount) == -1)
			printf("\"%s\" Error:Undeclared variable:line%d\n",label,lineCount+1);
}

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
}
//TODO: add collection, unit number
//TODO: initialize 
// int _int;
// float _real;
// char _string[100];

// void addValue(int intValue, char strValue[], float realValue) {
//     if(scope == global) {
//         symbolTable[symbolCount - 1].intValue = intValue;
//         symbolTable[symbolCount - 1].realValue = realValue;
//         strcpy(symbolTable[symbolCount - 1].strValue, strValue);
//     }
//     else {
//         localSymbolTable[localSymbolCount - 1].intValue=intValue;
//         localSymbolTable[localSymbolCount - 1].realValue = realValue;
//         strcpy(localSymbolTable[localSymbolCount-1].strValue, strValue);
//     }	
// }