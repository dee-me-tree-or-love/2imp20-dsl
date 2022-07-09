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
        } 
        sscanf(aVal,"%s", AttrTable[ownerCount].attrs[attrCount].value);
        attrCount++;//todo: release after every plant defintion
    }
}

// void addAttrs(struct AttrTableStruct AttrTable[], struct attribute attrs[], char owner[], int ownCount) {
//     if(lookupOwner(AttrTable, owner, ownerCount) == -1) {
//         sscanf(owner,"%s", AttrTable[ownerCount].owner);
//         for (int i = 0; i < attrCount; i++) {
//             sscanf(attrs[i].variable,"%s", AttrTable[ownerCount].attrs[i].variable);
//             if(!strcmp("",attrs[i].value)) return;
//             sscanf(attrs[i].value,"%s", AttrTable[ownerCount].attrs[i].value);
//         }
//         ownerCount++;//todo: release after every plant defintion
//     }
// }
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