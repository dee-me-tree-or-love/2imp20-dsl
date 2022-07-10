#include <stdio.h>
#include <string.h>
#include <stdlib.h>
#include <ctype.h>

#include "./python_skeleton_constants.h"

// *********
// Utilities
// *********

// Shared file output stream
FILE *fp;

// Value type
typedef enum
{
    // Any value besides unit_number
    __SIMPLE,
    __UNIT_NUMBER
} ValueType;

// Specifies a value spec from the parser
typedef struct
{
    ValueType type;
    char *values[2];
} ValueSpec;

// Telling how to represent things in Python
char *valueSpecToPython(ValueSpec value_spec, char *dest)
{
    if (value_spec.type == __SIMPLE)
    {
        strcpy(dest, value_spec.values[0]);
        return dest;
    }
    if (value_spec.type == __UNIT_NUMBER)
    {
        strcpy(dest, value_spec.values[0]);
        sprintf(dest, "UnitNumber(%s, \"%s\")", value_spec.values[0], value_spec.values[1]);
        return dest;
    }
    return dest;
};

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

void dumpSkeletonModuleInfo()
{
    char *prefix = "PYTHON SKELETON";
    printf("%s: Module name --> %s;\n", prefix, moduleInfoSkeleton.moduleName);
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
ObserversSkeleton observersSkeleton;

// API
void addObserverSkeleton(SingleObserverSkeleton observer)
{
    printf("ADDING OBSERVER\n");
    int count = observersSkeleton.__observerCount;
    observersSkeleton.observers[count] = observer;
    observersSkeleton.__observerCount += 1;
}

void dumpObserversSkeleton()
{
    char *prefix = "PYTHON SKELETON";
    for (int i = 0; i < observersSkeleton.__observerCount; i += 1)
    {
        printf(
            "%s: Observer id --> %s; Observer body --> %s;\n",
            prefix,
            observersSkeleton.observers[i].identifier,
            observersSkeleton.observers[i].body);
    }
}

// Plants
// ~~~~~~

// Stores information about a single PLANT
typedef struct
{
    char *identifier;
    AttributeSpec attributes[200];
    int __attributeCount;
} SinglePlantSkeleton;

// Stores information about a PLANTS
typedef struct
{
    int __plantsCount;
    SinglePlantSkeleton plants[200];
} PlantsSkeleton;

// Global store
PlantsSkeleton plantsSkeleton = {0, {}};

// API
void addPlantSkeleton(SinglePlantSkeleton plant)
{
    printf("ADDING PLANT\n");
    int count = plantsSkeleton.__plantsCount;
    plantsSkeleton.plants[count] = plant;
    plantsSkeleton.__plantsCount += 1;
}

void dumpPlantsSkeleton()
{
    char *prefix = "PYTHON SKELETON";
    for (int i = 0; i < plantsSkeleton.__plantsCount; i += 1)
    {
        SinglePlantSkeleton plant = plantsSkeleton.plants[i];
        printf(
            "%s: Plant id --> %s;\n",
            prefix,
            plant.identifier);
        // TODO: add dump of the attributes
        for (int k = 0; k < plant.__attributeCount; k += 1)
        {
            AttributeSpec attribute = plant.attributes[k];
            printf(
                "%s: Plant attribute id --> %s;\n",
                prefix,
                attribute.identifer,
                attribute.value);
            // TODO: add dump of the attributes
        }
    }
}

// TODO: add support for plants, actions, controllers and assets

// Skeleton Operations
// ~~~~~~~~~~~~~~~~~~~

// Print out the full skeleton.
void dumpPythonSkeleton()
{
    char *prefix = "PYTHON SKELETON";
    printf("\n%s: Dump:\n", prefix);
    dumpSkeletonModuleInfo();
    dumpObserversSkeleton();
    dumpPlantsSkeleton();
};

// Get the file path for the new file
void getPythonFileName(char dest[200])
{
    char dist_dir[200] = "./dist";
    // To avoid modifying the `moduleInfoSkeleton.moduleName`.
    char module_name_lowercase[200];
    strcpy(module_name_lowercase, moduleInfoSkeleton.moduleName);
    // Full string to lower
    //  See https://stackoverflow.com/questions/2661766/how-do-i-lowercase-a-string-in-c
    for (int i = 0; module_name_lowercase[i]; i++)
    {
        module_name_lowercase[i] = tolower(module_name_lowercase[i]);
    }
    sprintf(dest, "%s/%s.py", dist_dir, module_name_lowercase);
}

// Open Python file for writing
void openPythonFile()
{
    char *prefix = "WRITING PYTHON CODE";
    char path[200];
    getPythonFileName(path);
    printf("%s: Writing to: %s\n", prefix, path);
    fp = fopen(path, "w+");
}

// Close Python file
void closePythonFile()
{
    fclose(fp);
}

// Write the module and defaults of the Python module to the file
void writePythonModuleAndDefaults()
{
    char *prefix = "WRITING MODULE DEFAULTS";
    printf("%s: Writing...\n", prefix);
    fputs("# Automatically compiled Python module.\n", fp);
    char module_comment[200];
    sprintf(module_comment, "# Module: %s", moduleInfoSkeleton.moduleName);
    fputs(module_comment, fp);
    fputs("\n", fp);
    // Defined in the "python_skeleton_constants.h"
    fputs(SKELETON_DEFAULT_CONSTRUCTS, fp);
    printf("%s: Done.\n", prefix);
};

// Write all observers to the file
void writeObservers()
{
    char *prefix = "WRITING OBSERVERS";
    printf("%s: Writing...\n", prefix);

    char *header =
        "\n"
        "# Observers\n"
        "# ~~~~~~~~~\n"
        "\n";
    fputs(header, fp);

    // Produces "<identifier> = Observer(<body>)" for each observer
    for (int i = 0; i < observersSkeleton.__observerCount; i += 1)
    {
        char observer_init[200];
        SingleObserverSkeleton observer = observersSkeleton.observers[i];
        sprintf(observer_init, "%s = Observer(%s)\n", observer.identifier, observer.body);
        fputs(observer_init, fp);
    }
    fputs("\n", fp);

    // Produces "OBSERVERS = [...]"
    fprintf(fp, "OBSERVERS = [");
    for (int i = 0; i < observersSkeleton.__observerCount; i += 1)
    {
        SingleObserverSkeleton observer = observersSkeleton.observers[i];
        fprintf(fp, observer.identifier);
        fprintf(fp, ",");
    }
    fprintf(fp, "]\n");

    printf("%s: Done.\n", prefix);
};

// Write full Python program
void writePythonProgram()
{
    // TODO: order the Python output like this:
    // [x] 1. module & defaults
    // [x] 2. observers
    // [ ] 3. plants
    // [ ] 4. actions
    // [ ] 5. assets
    // [ ] 6. controllers
    openPythonFile();
    writePythonModuleAndDefaults();
    writeObservers();
    // TODO:
    closePythonFile();
};

// Construct the Python program from skeleton.
void enflatePythonSkeleton()
{
    char *prefix = "PYTHON SKELETON";
    printf("%s: enflating remains to be implemented...\n", prefix);
    writePythonProgram();
};