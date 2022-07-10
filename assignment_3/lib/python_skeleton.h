#include <stdio.h>
#include <string.h>
#include <stdlib.h>
#include <ctype.h>

#include "./python_skeleton_constants.h"

// *********
// Utilities
// *********

// Interface declaration
void dumpPythonSkeleton();

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
    int count = observersSkeleton.__observerCount;
    printf("ADDING OBSERVER: %d; %s; %s\n", count, observer.identifier, observer.body);
    observersSkeleton.observers[count] = observer;
    observersSkeleton.__observerCount += 1;

    printf("ADDED OBSERVER: %d; %s; %s\n", count, observer.identifier, observer.body);
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
// FIXME: attribute representation in Python is not supported yet.
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
    int count = plantsSkeleton.__plantsCount;
    printf("ADDING PLANT: %d\n", count);
    plantsSkeleton.plants[count] = plant;
    plantsSkeleton.__plantsCount += 1;
    printf("0th plant --> %s\n", plantsSkeleton.plants[0].identifier);
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

        // FIXME: add dump of the attributes
        // for (int k = 0; k < plant.__attributeCount; k += 1)
        // {
        //     // TODO: complete the value dump
        //     AttributeSpec attribute = plant.attributes[k];
        //     printf(
        //         "%s: Plant attribute id --> %s;\n",
        //         prefix,
        //         attribute.identifer);
        // }
    }
}

// CONTROLLERS
// ~~~~~~~~~~~

// Supported controller types
typedef enum
{
    __MONITOR
} ControllerType;

char *controllerTypeToString[1] = {"MONITOR"};

// Stores information about the OBSERVERS
typedef struct
{
    int __controllerCount;
    ControllerType controllers[200];
} ControllersSkeleton;

// Global store
ControllersSkeleton controllersSkeleton;

// API
void addControllerSkeleton(ControllerType controller)
{
    int count = controllersSkeleton.__controllerCount;
    printf("ADDING CONTROLLER: %d --> type: %d\n", count, controller);
    controllersSkeleton.controllers[count] = controller;
    controllersSkeleton.__controllerCount += 1;
}

void dumpControllersSkeleton()
{
    char *prefix = "PYTHON SKELETON";
    for (int i = 0; i < controllersSkeleton.__controllerCount; i += 1)
    {
        ControllerType controller = controllersSkeleton.controllers[i];
        char *controllerString = controllerTypeToString[controller];
        printf("%s: Controller --> %s;\n", prefix, controllerString);
    }
}

// TODO: add support for plants, actions and assets

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
    dumpControllersSkeleton();
};

// Code Generation
// ~~~~~~~~~~~~~~~

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

// Write all plants to the file
void writePlants()
{
    char *prefix = "WRITING PLANTS";
    printf("%s: Writing...\n", prefix);

    char *header =
        "\n"
        "# Plants\n"
        "# ~~~~~~~~~\n"
        "\n";
    fputs(header, fp);

    // Produces "class <identifier>(Plant): ..." for each observer
    for (int i = 0; i < plantsSkeleton.__plantsCount; i += 1)
    {
        char plant_init[200];
        SinglePlantSkeleton plant = plantsSkeleton.plants[i];
        sprintf(plant_init, "class %s(Plant):\n    pass\n", plant.identifier);
        fputs(plant_init, fp);
    }
    fputs("\n", fp);

    // Produces "PLANTS = [...]"
    fprintf(fp, "PLANTS = [");
    for (int i = 0; i < plantsSkeleton.__plantsCount; i += 1)
    {
        SinglePlantSkeleton plant = plantsSkeleton.plants[i];
        fprintf(fp, plant.identifier);
        fprintf(fp, ",");
    }
    fprintf(fp, "]\n");

    printf("%s: Done.\n", prefix);
};

// Write all observers to the file
void writeControllers()
{
    char *prefix = "WRITING CONTROLLERS";
    printf("%s: Writing...\n", prefix);

    char *header =
        "\n"
        "# Controllers\n"
        "# ~~~~~~~~~~~\n"
        "\n";
    fputs(header, fp);

    // Produces "<identifier> = Observer(<body>)" for each observer
    for (int i = 0; i < controllersSkeleton.__controllerCount; i += 1)
    {
        ControllerType controller = controllersSkeleton.controllers[i];
        switch (controller)
        {
        // Produces "MONITOR = MonitorController(ASSETS)""
        case __MONITOR:
            printf("%s: Writing MONITOR...\n", prefix);
            char monitor_init[200];
            sprintf(monitor_init, "%s = MonitorController(ASSETS)\n", controllerTypeToString[controller]);
            fputs(monitor_init, fp);
            break;
        // Unknown type.
        default:
            printf("%s: Unknown controller type...\n", prefix);
            break;
        }
    }
    fputs("\n", fp);

    // Produces "CONTOLLERS = [...]"
    fprintf(fp, "CONTOLLERS = [");
    for (int i = 0; i < controllersSkeleton.__controllerCount; i += 1)
    {
        ControllerType controller = controllersSkeleton.controllers[i];
        fprintf(fp, controllerTypeToString[controller]);
        fprintf(fp, ",");
    }
    fprintf(fp, "]\n");

    // Defined in the "python_skeleton_constants.h"
    fputs(SKELETON_DEFAULT_CONTROLLER_CLAUSE, fp);
    printf("%s: Done.\n", prefix);
};

// Write full Python program
void writePythonProgram()
{
    // TODO: order the Python output like this:
    // [x] 1. module & defaults
    // [x] 2. plants
    // [x] 3. observers
    // [ ] 4. actions
    // [ ] 5. assets
    // [x] 6. controllers
    openPythonFile();
    writePythonModuleAndDefaults();
    writeObservers();
    writePlants();
    // TODO: write actions, assets
    writeControllers();
    closePythonFile();
};

// Construct the Python program from skeleton.
void enflatePythonSkeleton()
{
    char *prefix = "PYTHON SKELETON";
    printf("%s: enflating remains to be implemented...\n", prefix);
    writePythonProgram();
};