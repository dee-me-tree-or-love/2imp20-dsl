#include <stdio.h>
#include <string.h>
#include <stdlib.h>

// *********
// Utilities
// *********

// Value type
typedef enum
{
    unit_number,
    // Any value besides unit_number
    simple
} ValueType;

// Specifies a value spec from the parser
typedef struct
{
    ValueType type;
    char *values[2];
} ValueSpec;

// Specifies the attribute and it's assigned value
typedef struct
{
    char *identifer;
    ValueSpec value;
} AttributeSpec;

// *******************
// Python Skeleton API
// *******************

// MODULE
// ~~~~~~

// Stores information about the MODULE
typedef struct
{
    char moduleName[200];
} ModuleInfoSkeleton;

// Global store
ModuleInfoSkeleton moduleInfoSkeleton;

// API
void setSkeletonModuleName(char name[200])
{
    strcpy(moduleInfoSkeleton.moduleName, name);
}

// OBSERVERS
// ~~~~~~~~~

// Stores information about a single OBSERVER
typedef struct
{
    char *identifier;
    char *body;
} SingleObserverSkeleton;

// Stores information about the OBSERVERS
typedef struct
{
    int __observerCount;
    SingleObserverSkeleton observers[200];
} ObserversSkeleton;

// Global store
ObserversSkeleton observersSkeleton = {0, {}};

// API
void addObserverSkeleton(SingleObserverSkeleton observer)
{
    int count = observersSkeleton.__observerCount;
    observersSkeleton.observers[count] = observer;
    observersSkeleton.__observerCount += 1;
}

// Plants
// ~~~~~~

// Stores information about a single PLANT
typedef struct
{
    int __attributeCount;
    char *identifier;
    AttributeSpec *attributes;
} SinglePlantSkeleton;

// Stores information about a PLANTS
typedef struct
{
    int __plantsCount;
    SinglePlantSkeleton plants[200];
} PlantsSkeleton;

// Global store
PlantsSkeleton plantsSkeleton = {0, {}};

// Skeleton Operations
// ~~~~~~~~~~~~~~~~~~~

// Print out the full skeleton.
void dumpPythonSkeleton()
{
    char *prefix = "PYTHON SKELETON";
    printf("%s: Module name --> %s\n", prefix, moduleInfoSkeleton.moduleName);
};

// Construct the Python program from skeleton.
void enflatePythonSkeleton()
{
    char *prefix = "PYTHON SKELETON";
    printf("%s: enflating remains to be implemented...\n", prefix);
};