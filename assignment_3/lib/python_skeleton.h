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

// Stores information about the CONTROLLERS
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

// Actions
// ~~~~~~~

// FIXME: currently all actions are represented as "print(\"executing the action...\")"

// Stores information about a single Action
typedef struct
{
    char *identifier;
    char *body;
} SingleActionSkeleton;

// Stores information about the ACTION
typedef struct
{
    int __actionsCount;
    SingleActionSkeleton actions[200];
} ActionsSkeleton;

// Global store
ActionsSkeleton actionsSkeleton;

// API
void addActionSkeleton(SingleActionSkeleton action)
{
    int count = actionsSkeleton.__actionsCount;
    printf("ADDING ACTION: %d --> identifier: %s\n", count, action.identifier);
    actionsSkeleton.actions[count] = action;
    actionsSkeleton.__actionsCount += 1;
}

void dumpActionsSkeleton()
{
    char *prefix = "PYTHON SKELETON";
    for (int i = 0; i < actionsSkeleton.__actionsCount; i += 1)
    {
        SingleActionSkeleton action = actionsSkeleton.actions[i];
        printf("%s: Action --> %s;\n", prefix, action.identifier);
    }
}

// Assets
// ~~~~~~

// Stores information about a single Sensor
typedef struct
{
    // FIXME: currently parameters of the action are not supported, we simply ignore them.
    char *identifier;
    char *trigger;
    char *action_identifier;
} SingleSensorSkeleton;

// Stores information about a single Asset
typedef struct
{
    // FIXME: asset attributes are not yet supported.
    // FIXME: we also ignore asset type for now.
    char *identifier;
} SingleAssetSkeleton;

// Stores information about the ASSETS
typedef struct
{
    int __assetsCount;
    int __assetSensorsCount[200];
    SingleAssetSkeleton assets[200];
    SingleSensorSkeleton assetSensors[200][200];
} AssetsSkeleton;

// Global store
AssetsSkeleton assetsSkeleton;

// API
void addAssetSkeleton(SingleAssetSkeleton asset)
{
    int count = assetsSkeleton.__assetsCount;
    printf("ADDING ASSET: %d --> identifier: %s\n", count, asset.identifier);
    assetsSkeleton.assets[count] = asset;
    assetsSkeleton.__assetsCount += 1;
}

void addAssetSensorSkeleton(SingleSensorSkeleton sensor)
{
    int assetCount = assetsSkeleton.__assetsCount;
    int assetSensorsCount = assetsSkeleton.__assetSensorsCount[assetCount];
    printf("ADDING ASSET SENSOR: %d/%d --> identifier: %s\n", assetCount, assetSensorsCount, sensor.identifier);
    assetsSkeleton.assetSensors[assetCount][assetSensorsCount] = sensor;
    assetsSkeleton.__assetSensorsCount[assetCount] += 1;
}

void dumpAssetsSkeleton()
{
    char *prefix = "PYTHON SKELETON";
    for (int i = 0; i < assetsSkeleton.__assetsCount; i += 1)
    {
        int assetNumber = i;
        SingleAssetSkeleton asset = assetsSkeleton.assets[i];
        printf("%s: Asset --> %s;\n", prefix, asset.identifier);
        for (int k = 0; k < assetsSkeleton.__assetSensorsCount[assetNumber]; k += 1)
        {
            SingleSensorSkeleton sensor = assetsSkeleton.assetSensors[assetNumber][k];
            printf("%s: Asset sensor --> %s (t)--> %s (a)--> %s;\n", prefix, sensor.identifier, sensor.trigger, sensor.action_identifier);
        }
    }
}

// Skeleton Operations
// ~~~~~~~~~~~~~~~~~~~

// Print out the full skeleton.
void dumpPythonSkeleton()
{
    char *prefix = "PYTHON SKELETON";
    printf("\n%s: Dump:\n", prefix);
    dumpSkeletonModuleInfo();
    dumpPlantsSkeleton();
    dumpActionsSkeleton();
    dumpObserversSkeleton();
    dumpAssetsSkeleton();
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
        fprintf(fp, "%s", observer.identifier);
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

    // Produces "class <identifier>(Plant): ..." for each plant
    for (int i = 0; i < plantsSkeleton.__plantsCount; i += 1)
    {
        char plant_init[200];
        SinglePlantSkeleton plant = plantsSkeleton.plants[i];
        sprintf(plant_init, "class %s(Plant):\n    pass\n", plant.identifier);
        fputs(plant_init, fp);
        fputs("\n", fp);
    }

    // Produces "PLANTS = [...]"
    fprintf(fp, "PLANTS = [");
    for (int i = 0; i < plantsSkeleton.__plantsCount; i += 1)
    {
        SinglePlantSkeleton plant = plantsSkeleton.plants[i];
        fprintf(fp, "%s", plant.identifier);
        fprintf(fp, ",");
    }
    fprintf(fp, "]\n");

    printf("%s: Done.\n", prefix);
};

// Write all actions to the file
void writeActions()
{
    char *prefix = "WRITING ACTIONS";
    printf("%s: Writing...\n", prefix);

    char *header =
        "\n"
        "# Actions\n"
        "# ~~~~~~~~~\n"
        "\n";
    fputs(header, fp);

    // Produces "@dataclass class Action_<identifier>: ..." for each action
    for (int i = 0; i < actionsSkeleton.__actionsCount; i += 1)
    {
        char action_init[200];
        SingleActionSkeleton action = actionsSkeleton.actions[i];
        sprintf(action_init, "@dataclass\nclass Action_%s:\n", action.identifier);
        fputs(action_init, fp);
        fputs("    # FIXME: attributes are not yet supported...\n", fp);
        fputs("\n", fp);
        fputs("    # FIXME: call for now is mimicked...\n", fp);
        fputs("    def __call__(self):\n", fp);
        fputs("        print(f\"Executing action from {self.__class__.__name__}\")\n", fp);
        fputs("        # Send a message in any case... \n", fp);
        fputs("        Action_send_message(self.__class__.__name__, \"demo_call\")()\n", fp);
        fputs("\n", fp);
    }

    // Produces "ACTIONS = [...]"
    fprintf(fp, "ACTIONS = [");
    for (int i = 0; i < actionsSkeleton.__actionsCount; i += 1)
    {
        char action_init[200];
        SingleActionSkeleton action = actionsSkeleton.actions[i];
        sprintf(action_init, "Action_%s", action.identifier);
        fprintf(fp, "%s", action_init);
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

    // Produces "CONTROLLERS = [...]"
    fprintf(fp, "CONTROLLERS = [");
    for (int i = 0; i < controllersSkeleton.__controllerCount; i += 1)
    {
        ControllerType controller = controllersSkeleton.controllers[i];
        fprintf(fp, "%s", controllerTypeToString[controller]);
        fprintf(fp, ",");
    }
    fprintf(fp, "]\n");

    // Defined in the "python_skeleton_constants.h"
    fputs(SKELETON_DEFAULT_CONTROLLER_CLAUSE, fp);
    printf("%s: Done.\n", prefix);
};

// Write all assets to the file
void writeAssets()
{
    char *prefix = "WRITING ASSETS";
    printf("%s: Writing...\n", prefix);

    char *header =
        "\n"
        "# Assets\n"
        "# ~~~~~~\n"
        "\n";
    fputs(header, fp);

    // FIXME: add support for asset type specification
    // Produces "class Asset_<identifer>(Observable):" for each asset
    for (int i = 0; i < assetsSkeleton.__assetsCount; i += 1)
    {
        int assetNumber = i;
        char asset_init[200];
        SingleAssetSkeleton asset = assetsSkeleton.assets[i];
        sprintf(asset_init, "class Asset_%s(Observable):\n", asset.identifier);
        fputs(asset_init, fp);
        fputs("    def __init__(self):\n", fp);
        fputs("        # FIXME: attributes are not yet supported...\n", fp);

        // Start specifying sensors
        fputs("        self.sensors = {\n", fp);
        for (int k = 0; k < assetsSkeleton.__assetSensorsCount[assetNumber]; k += 1)
        {
            // FIXME: action parameters are not supported yet
            // Produces "<sensor identifier>": Sensor(<sensor trigger>, Action_<sensor action identifier>()),
            char sensor_init[200];
            SingleSensorSkeleton sensor = assetsSkeleton.assetSensors[assetNumber][k];
            sprintf(sensor_init, "            \"%s\": Sensor(%s, Action_%s()),\n", sensor.identifier, sensor.trigger, sensor.action_identifier);
            fputs(sensor_init, fp);
        }
        fputs("        }\n", fp);
        
        // Create the asset instance
        char asset_instance_init[200];
        sprintf(asset_init, "%s = Asset_%s()\n", asset.identifier, asset.identifier);
        fputs(asset_init, fp);
        fputs("\n", fp);
    }

    // Produces "ASSETS = [...]"
    fprintf(fp, "ASSETS = [");
    for (int i = 0; i < assetsSkeleton.__assetsCount; i += 1)
    {
        SingleAssetSkeleton asset = assetsSkeleton.assets[i];
        fprintf(fp, "%s", asset.identifier);
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
    // [x] 2. plants
    // [x] 3. observers
    // [x] 4. actions
    // [x] 5. assets
    // [x] 6. controllers
    openPythonFile();
    writePythonModuleAndDefaults();
    writeObservers();
    writePlants();
    writeActions();
    writeAssets();
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