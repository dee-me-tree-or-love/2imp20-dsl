#include <stdio.h>
#include <string.h>
#include <stdlib.h>

// **************************************
// Helpful metadata stored during parsing
// **************************************

// TODO: make use of this in place of the global `lineCount`
// Struct storing parsing metadata.
typedef struct
{
    // Current lineNumber during parsing
    int lineNo;
    // TODO: add errors collection here
} ParsingMetadata;

// Global store
ParsingMetadata parsingMetadata = {0};

// Set current line number in the parsing metadata
void setLineNumber(int lineNo)
{
    parsingMetadata.lineNo = lineNo + 1;
}

// **************************************

// unitnumber and collection typedef
typedef struct unitnumber
{
    int intNum;
    float realNum;
    char unit[10];
} unitNumber;

typedef struct collection
{
    int intType;
    char charType[100];
    unitNumber unitnumberType;
    float floatType;
    struct collection *collectionType;
} Collection;

/* Observer table */
/*~~~~~~~~~~~~~~~~*/
typedef struct
{
    char label[100];
    char addr[100];
} obersverTuple;
typedef struct
{
    int observerCount;
    obersverTuple observers[200];
} ObserverTableStruct;

ObserverTableStruct observerTable = {0,  {}};

int lookupObserver(ObserverTableStruct observerTable, char compareString[])
{   
    int count = observerTable.observerCount;
    for (int i = 0; i < count; i++)
    {
        if (!strcmp(observerTable.observers[i].label, compareString))
            printf("\"%s\" Error:This observer label has been used:line %d\n", compareString, parsingMetadata.lineNo);
        return i;
    }
    return -1;
}

int lookupAddr(ObserverTableStruct observerTable,  char compareString[])
{
    int count = observerTable.observerCount;
    for (int i = 0; i < count; i++)
    {
        if (!strcmp(observerTable.observers[i].addr, compareString))
        {
            printf("\"%s\" Error:This observer addr has been used:line %d\n", compareString, parsingMetadata.lineNo);
            return i;
        }
    }
    return -1;
}
void dumpOTable(){
    int observerCount = observerTable.observerCount;
    for (int i = 0; i < observerCount; i++)
    {
        printf("%s dumpall#####################\n\n",observerTable.observers[i].label);
    }
}

void addObserver(char label[], char addr[])
{
    int i = observerTable.observerCount;
    // if ((lookupObserver(observerTable, label) == -1) && (lookupAddr(observerTable, addr) == -1))
    // {
        strcpy(observerTable.observers[i].label, label);
        strcpy(observerTable.observers[i].addr, addr);
        printf("%s      111111111wwwwwww\n\n", observerTable.observers[i].label);
        observerTable.observerCount += 1;
        printf("%d   observerCount  ----------------\n\n", observerTable.observerCount);
    // } else{
    //     printf("wrong\n\n\n\n\n\n\n\n");
    // }
    
}

// used in asset
void checkObserver(char label[])
{
    if (lookupObserver(observerTable, label) != -1)
        printf("\"%s\" Error:Unavailable observer: line%d\n", label, parsingMetadata.lineNo);
}
/* Observer table */

/* Attribute table */
/*~~~~~~~~~~~~~~~~*/

//vaue pair for one attribute
typedef struct
{
    char variable[100];
    char value[100];
} AttributeTuple;

typedef struct
{
    int ownerCount;
    // Amount of attributes per owner
    int ownerAttributeCount[200];
    // Owners
    // TODO: rename to "owners"
    char *owner[100];
    // Attributes per owner
    AttributeTuple ownerAttrs[200][200];
} OwnerAttributeStruct;

OwnerAttributeStruct ownerAttributeTable = {0, {}, {}, {}};

int lookupAttr(OwnerAttributeStruct ownerAttributeTable, char aVar[]) {
    int count = ownerAttributeTable.ownerCount;
    for (int i = 0; i < ownerAttributeTable.ownerAttributeCount[count]; i++) {
        if (!strcmp(ownerAttributeTable.ownerAttrs[count][i].variable, aVar))
        {
            printf("\"%s\" Error:This attribute label has been used:line %d\n", aVar, parsingMetadata.lineNo);
            return i;
        }
    }
    return -1;
}

int lookupOwner(OwnerAttributeStruct ownerAttributeTable, char owner[])
{
    int count = ownerAttributeTable.ownerCount;
    for (int j = 0; j < count; j++) {
        if (!strcmp(ownerAttributeTable.owner[j], owner))
        {
            printf("\"%s\" Error:This Label has been defined:line %d\n", owner, parsingMetadata.lineNo);
            return j;
        }
    }
    return -1;
}

void addOwnerAttribute(char aVar[], char aVal[])
{
    // printf("this is ownerattr count %d  &&&&&&&&&&&&&&&&\n", ownerAttributeTable.ownerAttributeCount[ownerAttributeTable.ownerCount]);
    int count = ownerAttributeTable.ownerCount;
    int attrCount = ownerAttributeTable.ownerAttributeCount[count];
    if (lookupAttr(ownerAttributeTable, aVar) == -1)
    {
        printf("Adding owner attribute.\n");
        strcpy(ownerAttributeTable.ownerAttrs[count][attrCount].variable, aVar);
        strcpy(ownerAttributeTable.ownerAttrs[count][attrCount].value, aVal);
        ownerAttributeTable.ownerAttributeCount[count] += 1;
    }
    // printf("this is ownerattr count %d  &&&&&&&&&&&&&&&&\n", ownerAttributeTable.ownerAttributeCount[ownerAttributeTable.ownerCount]);
}

void addOwner(char owner[])
{
    int count = ownerAttributeTable.ownerCount;
    int attibuteCount = ownerAttributeTable.ownerAttributeCount[count];
    // printf("this is ownercount %d  &&&&&&&&&&&&&&&&\n", count);
    // printf("this is owner attribute count %d  &&&&&&&&&&&&&&&&\n", attibuteCount);
    if (lookupOwner(ownerAttributeTable, owner) == -1)
    {
        printf("Adding owner.\n");
        ownerAttributeTable.owner[count] = strdup(owner);
        // printf("this is the new owner %s  &&&&&&&&&&&&&&&&\n", ownerAttributeTable.owner[count]);
        ownerAttributeTable.ownerCount += 1;
    }
    // printf("this is ownercount %d&&&&&&&&&&&&&&&&\n", ownerAttributeTable.ownerCount);
}


// used in asset&action
void checkAttr(char var[])
{
    if (lookupAttr(ownerAttributeTable, var) != -1)
        printf("\"%s\" Error:Unavailable Variable:line %d\n", var, parsingMetadata.lineNo);
}

/* Attribute table */


/* Basic Table */
/* ~~~~~~~~~~~~ */

// Scope
enum scopeEnum
{
    global,
    local
};
enum scopeEnum scope = global;
enum typeEnum
{
    action,
    module,
    asset,
    observer,
    plant,
    nil
};
struct SymbolTableStruct
{
    char label[100];
    enum typeEnum typeValue;
};
struct SymbolTableStruct symbolTable[200];
int symbolCount = 0;

// basic symbol look up function
int lookup(struct SymbolTableStruct symbolTable[], char compareString[], int symbolCount)
{
    for (int i = 0; i < symbolCount; i++)
    {
        if (!strcmp(symbolTable[i].label, compareString)) // if input string euqals symboltable
            return i;
    }
    return -1;
}
// get symbol type
enum typeEnum getSymbolType(char label[])
{
    int index = lookup(symbolTable, label, symbolCount);
    if (index != -1)
        return symbolTable[index].typeValue;
    return nil;
}

void addGlobalLabel(char label[], enum typeEnum typeValue)
{
    int error;
    if (!strcmp("", label))
        return;
    if (scope == global)
    {
        if (lookup(symbolTable, label, symbolCount) == -1)
        {
            sscanf(label, "%s", symbolTable[symbolCount].label);
            symbolTable[symbolCount].typeValue = typeValue;
            symbolCount++;
        }
        else
        {
            printf("\"%s\" Error: The label has been used:line%d\n", label, parsingMetadata.lineNo);
            error = 1;
        }
    }
}

// used in asset&action
void checkGlobalSymbol(char str[])
{
    if (lookup(symbolTable, str, symbolCount) == -1)
        printf("\"%s\" Error:This label has not been defined:line %d\n", str, parsingMetadata.lineNo);
}
/* Basic Table */

// void checkall(char label[])
// {
//     if (lookup(symbolTable, label, symbolCount) == -1 && lookup(symbolTable, label, symbolCount) == -1)
//         printf("\"%s\" Error:Undeclared variable:line%d\n", label, parsingMetadata.lineNo);
// }


void checkScope(char label[])
{
    if (lookup(symbolTable, label, symbolCount) == -1 && lookup(symbolTable, label, symbolCount) == -1)
        printf("\"%s\" Error:Undeclared variable:line%d\n", label, parsingMetadata.lineNo);
}



// TODO: add collection, unit number
// TODO: initialize
//  int _int;
//  float _real;
//  char _string[100];

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