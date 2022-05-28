module hcl::Check


import hcl::AST;
import Prelude;
import IO;
import Message;
import Map;
import util::Math;
/*
 * -Implement a well-formedness checker for the HCL language. For this you must use the AST. 
 * - Hint: Map regular CST arguments (e.g., *, +, ?) to lists 
 * - Hint: Map lexical nodes to Rascal primitive types (bool, int, str)
 * - Hint: Use switch to do case distinction with concrete patterns
 */

 /*
 * Create a function called checkHardwareConfiguration(...), which is responsible for calling all the required functions that check the computer's well-formedness as described in the PDF (Section 3.2.) 
 * This function takes as a parameter the computer's AST and returns true if the computer is well-formed or false otherwise.
 */
 
/*
* Define a function per each verification defined in the PDF (Section 3.2.)
*/

/*
 * ----- SIMPLIFIERS -----
 */

// Utility functions
// ~~~~~~~~~~~~~~~~~

// Log a string; change the println() to whatever is needed
void log(str msg) {
    println(msg);
}

// Method for logging errors
void error(str msg) {
    log("ERROR: " + msg + "!\n");
}

// log if all checks successful
bool success() {
    log("-- CHECK SUCCESSFUL --");
    return true;
}

void u_panic(str msg){
    throw msg;
}

// Constants
// ~~~~~~~~~

str CONFIG_DECL_TYPE = "config";
str REUSE_DECL_TYPE = "reuse";
str STORAGE_DECL_TYPE = "storage";
str DISPLAY_DECL_TYPE = "display";
str PROCESSING_DECL_TYPE = "processing";
str SPEED_DECL_TYPE = "speed";
str CORES_DECL_TYPE = "speed";
str L1_DECL_TYPE = "l1";
str L2_DECL_TYPE = "l2";
str L3_DECL_TYPE = "l3";
str MIB_UNIT = "MiB";

// Contains: 0: cache prop or not, 1: which cache type; 2: size, 3: unit
alias CACHE_TUPLE = tuple[bool, str, int, str];

/*
 * ----- MAIN -----
 */

//TODO:
//1. all components must have labels --> DONE; checkAllDeclarationsHaveLabels
//2. all component labels are unique --> DONE; checkAllComponentsHaveUniqueLabels
//2+. all reuse labels exist --> DONE; checkAllReuseLabelsExist
//3. total storage size is >0 and <=8192 GB --> DONE; checkTotalStorageIsInBounds
//4. max L1 size = 128 KiB --> DONE; checkAllCachesAreInBounds
//5. max L2 size = 8 MiB --> DONE; checkAllCachesAreInBounds
//6. max L3 size = 32 MiB --> DONE; checkAllCachesAreInBounds
//7. L1 < L2 < L3 --> DONE; checkAllCachesAreInOrder
//8. Display type is valid --> DONE; handled by Parsing
//9. No duplicate components with same configs but different labels --> 
//10. Language supports positive integers and reals --> Done; handled by parsing

bool checkHardwareConfiguration(A_COMPUTER computer) {
    log("-- CHECKING COMPUTER --");
    // TODO: technincal debt
    //         For more flexible error checking, we could
    //         decide to return a data structure containing the result and "potential" error
    //         say a tuple[bool, str].
    //         Then we could collect all the results and have more
    //         control over error message reporting.
    //         However, for the current scope we decided to go with
    //         a simpler solution.
    return checkAllDeclarationsHaveLabels(computer)
        && checkAllComponentsHaveUniqueLabels(computer)
        && checkAllReuseLabelsExist(computer)
        && checkTotalStorageIsInBounds(computer)
        && checkAllCachesAreInBounds(computer)
        && checkAllCachesAreInOrder(computer)
        && checkNoDuplicateComponents(computer)
        //&& checkReuseLabels(computer) 
        //&& checkPropertyNumAndType(computer) 
        //&& checkStoragesAndCaches(computer)
        //&& checkDuplicateComponents(computer)
        && success();
}

/*
 * ----- CHECKERS -----
 */
// TODO: we need to still add error reporting

bool checkAllDeclarationsHaveLabels(A_COMPUTER computer) {
    list[str] labels = [ getLabel(decl) | (decl <- computer.decls)];
    bool allLabelsOk = (true | it && (size(label) > 0) | str label <- labels);
    return allLabelsOk;
}

bool checkAllComponentsHaveUniqueLabels(A_COMPUTER computer) {
    list[str] labels = [ getLabel(decl) | decl <- computer.decls, getDeclType(decl) == CONFIG_DECL_TYPE];
    bool allLabelsOk = (true | it && (size(label) > 0) | str label <- labels);
    return allLabelsOk;
}

bool checkAllReuseLabelsExist(A_COMPUTER computer){
    set[str] componentLabels = toSet([ getLabel(decl) | decl <- computer.decls, getDeclType(decl) == CONFIG_DECL_TYPE]);
    set[str] reuseLabels = toSet([ getLabel(decl) | decl <- computer.decls, getDeclType(decl) == REUSE_DECL_TYPE]);
    // we take an intersection to compare
    set[str] labelsOfBoth = reuseLabels & componentLabels;
    // all the labels from reuse exist if they are all the labels appearing in both 
    bool allLabelsExist = labelsOfBoth == reuseLabels;
    return allLabelsExist;
}

bool checkTotalStorageIsInBounds(A_COMPUTER computer){
    // NB: Note that no unit conversion is done since only GiB's are supported.
    int SIZE_LOWER_BOUND = 0;
    int SIZE_UPPER_BOUND = 8192;
    list[A_COMPONENT_STORAGE] storages = [ getConfigItem(#A_COMPONENT_STORAGE, decl) | decl <- computer.decls, getConfigType(decl) == STORAGE_DECL_TYPE];

    bool allSizesInBounds = true;
    for (/A_COMPONENT_STORAGE storage := storages) {
        int totalSize = (0 | it + (prop.size) | prop <- storage.props);
        bool sizeInBounds = (totalSize > SIZE_LOWER_BOUND) && (totalSize <= SIZE_UPPER_BOUND);
        allSizesInBounds = allSizesInBounds && sizeInBounds;
    };

    return allSizesInBounds;
}

bool checkAllCachesAreInBounds(A_COMPUTER computer){
    // NB: Note that we need unit conversion since we support KiB and MiB
    // NB: We take 1 MiB == 1024 KiB
    int L1_UPPER_BOUND_KIB = 128;
    int L2_UPPER_BOUND_KIB = 8 * 1024;
    int L3_UPPER_BOUND_KIB = 32 * 1024;

    list[A_COMPONENT_PROCESSING] processings = [ getConfigItem(#A_COMPONENT_PROCESSING, decl) | decl <- computer.decls, getConfigType(decl) == PROCESSING_DECL_TYPE];

    bool allSizesInBounds = true;
    for (/A_COMPONENT_PROCESSING processing := processings) {
        list[CACHE_TUPLE] maybeCacheTuples = [getCacheTuple(prop) | prop <- processing.props];
        list[CACHE_TUPLE] validCacheTuples = [t | t <- maybeCacheTuples, t[0] == true];

        for (/CACHE_TUPLE t := validCacheTuples){
            int sizeInKb = getSizeInKb(t);
            bool sizeInBounds = false;
            // Depending on the type
            switch(t[1]){
                case L1_DECL_TYPE: sizeInBounds = sizeInKb <= L1_UPPER_BOUND_KIB;
                case L2_DECL_TYPE: sizeInBounds = sizeInKb <= L2_UPPER_BOUND_KIB;
                case L3_DECL_TYPE: sizeInBounds = sizeInKb <= L3_UPPER_BOUND_KIB;
            }
            allSizesInBounds = allSizesInBounds && sizeInBounds;
        }
    };

    return allSizesInBounds;
}

bool checkAllCachesAreInOrder(A_COMPUTER computer){
    list[A_COMPONENT_PROCESSING] processings = [ getConfigItem(#A_COMPONENT_PROCESSING, decl) | decl <- computer.decls, getConfigType(decl) == PROCESSING_DECL_TYPE];

    bool allCachesAreInOrder = true;
    for (/A_COMPONENT_PROCESSING processing := processings) {
        list[CACHE_TUPLE] maybeCacheTuples = [getCacheTuple(prop) | prop <- processing.props];
        list[CACHE_TUPLE] validCacheTuples = [t | t <- maybeCacheTuples, t[0] == true];
        
        // Construct a map of all caches using type as key, size as value
        map[str, int] cachesInKib = (t[1] : getSizeInKb(t) | CACHE_TUPLE t <- validCacheTuples);

        // Check cache pairs
        if ((L1_DECL_TYPE in cachesInKib) && (L2_DECL_TYPE in cachesInKib)) {
            bool cachePairInOrder = cachesInKib[L1_DECL_TYPE] < cachesInKib[L2_DECL_TYPE];
            allCachesAreInOrder = allCachesAreInOrder && cachePairInOrder;
        };
        if ((L1_DECL_TYPE in cachesInKib) && (L3_DECL_TYPE in cachesInKib)) {
            bool cachePairInOrder = cachesInKib[L1_DECL_TYPE] < cachesInKib[L3_DECL_TYPE];
            allCachesAreInOrder = allCachesAreInOrder && cachePairInOrder;
        };
        if ((L2_DECL_TYPE in cachesInKib) && (L3_DECL_TYPE in cachesInKib)) {
            bool cachePairInOrder = cachesInKib[L2_DECL_TYPE] < cachesInKib[L3_DECL_TYPE];
            allCachesAreInOrder = allCachesAreInOrder && cachePairInOrder;
        };
    };

    return allCachesAreInOrder;
}

bool checkNoDuplicateComponents(A_COMPUTER computer) {
    list[A_COMPONENT_CONFIG] configs = [ getAbstractConfigItem(decl) | decl <- computer.decls, getDeclType(decl) == CONFIG_DECL_TYPE];

    list[A_COMPONENT_STORAGE] allStorages = [ getConfigItem(#A_COMPONENT_STORAGE, decl) | decl <- computer.decls, getConfigType(decl) == STORAGE_DECL_TYPE];
    list[A_COMPONENT_DISPLAY] allDisplays = [ getConfigItem(#A_COMPONENT_DISPLAY, decl) | decl <- computer.decls, getConfigType(decl) == DISPLAY_DECL_TYPE];
    list[A_COMPONENT_PROCESSING] allProcessings = [ getConfigItem(#A_COMPONENT_PROCESSING, decl) | decl <- computer.decls, getConfigType(decl) == PROCESSING_DECL_TYPE];

    set[set[A_PROPERTY_STORAGE]] uniqueStorages = toSet([toSet(storage.props) | storage <- allStorages ]);
    set[set[A_PROPERTY_DISPLAY]] uniqueDisplays = toSet([toSet(display.props) | display <- allDisplays ]);
    set[set[A_PROPERTY_PROCESSING]] uniqueProcessings = toSet([toSet(processing.props) | processing <- allProcessings ]);

    bool zeroDupStorages = size(allStorages) == size(uniqueStorages);
    bool zeroDupDisplays = size(allDisplays) == size(uniqueDisplays);
    bool zeroDupProcessings = size(allProcessings) == size(uniqueProcessings);

    return zeroDupStorages && (zeroDupDisplays && zeroDupProcessings);
}

/*
 * ----- HELPERS -----
 */


// Attribute helpers
// ~~~~~~~~~~~~~~~~~

str getLabel(A_COMPONENT_DECL decl){
    switch(decl) {
        case config(configItem): return getLabel(configItem);
        case reuse(reuseItem): return reuseItem.label;
        default: u_panic("Failed to retrieve label from: <decl>");
    }
}

str getLabel(A_COMPONENT_CONFIG config){
    switch(config) {
        case storage(storageItem): return storageItem.label;
        case display(displayItem): return displayItem.label;
        case processing(processingItem): return processingItem.label;
        default: u_panic("Failed to retrieve label from: <config>");
    }
}

CACHE_TUPLE getCacheTuple(A_PROPERTY_PROCESSING prop){
    switch(prop) {
        case propCores(_): return <false, CORES_DECL_TYPE, -1, "">;
        case propSpeed(_): return <false, SPEED_DECL_TYPE, -1, "">;
        case propL1(size, unit): return <true, L1_DECL_TYPE, size, unit>;
        case propL2(size, unit): return <true, L2_DECL_TYPE, size, unit>;
        case propL3(size, unit): return <true, L3_DECL_TYPE, size, unit>;
        default: u_panic("Failed to cache tuple from: <prop>");
    }
}

int getSizeInKb(CACHE_TUPLE t){
    // Contains: 0: cache prop or not, 1: which cache type; 2: size, 3: unit
    if (t[0] && (t[3] == MIB_UNIT)){
        return t[2] * 1024;
    }
    return t[2];
}

tuple[str, set[A_PROPERTY_STORAGE]] getNamelessComponentTuple(A_COMPONENT_STORAGE storage){
    return <STORAGE_DECL_TYPE, toSet(storage.props)>;
}

tuple[str, set[A_PROPERTY_DISPLAY]] getNamelessComponentTuple(A_COMPONENT_DISPLAY display){
    return <DISPLAY_DECL_TYPE, toSet(display.props)>;
}

tuple[str, set[A_PROPERTY_PROCESSING]] getNamelessComponentTuple(A_COMPONENT_PROCESSING processing){
    return <PROCESSING_DECL_TYPE, toSet(processing.props)>;
}

// Meta helpers
// ~~~~~~~~~~~~

str getDeclType(A_COMPONENT_DECL decl){
    switch(decl) {
        case config(configItem): return CONFIG_DECL_TYPE;
        case reuse(reuseItem): return REUSE_DECL_TYPE;
        default: u_panic("Failed to retrieve decl type from: <decl>");
    }
}

str getConfigType(A_COMPONENT_DECL decl){
    switch(decl) {
        case config(configItem): return getConfigType(configItem);
        case reuse(reuseItem): return REUSE_DECL_TYPE;
        default: u_panic("Failed to retrieve config type from: <decl>");
    }
}

str getConfigType(A_COMPONENT_CONFIG config){
    switch(config) {
        case storage(storageItem): return STORAGE_DECL_TYPE;
        case display(displayItem): return DISPLAY_DECL_TYPE;
        case processing(processingItem): return PROCESSING_DECL_TYPE;
        default: u_panic("Failed to retrieve config type from: <config>");
    }
}

&T getConfigItem(type[&T] config_type, A_COMPONENT_DECL decl){
    switch(decl) {
        case config(configItem): return getConfigItem(config_type, configItem);
        default: u_panic("Failed to retrieve config item from: <decl>");
    }
}

&T getConfigItem(type[&T] config_type, A_COMPONENT_CONFIG config){
    switch(config) {
        case storage(storageItem): return storageItem;
        case display(displayItem): return displayItem;
        case processing(processingItem): return processingItem;
        default: u_panic("Failed to retrieve config item from: <config>");
    }
}

A_COMPONENT_CONFIG getAbstractConfigItem(A_COMPONENT_DECL decl){
    switch(decl) {
        case config(configItem): return configItem;
        default: u_panic("Failed to retrieve abstract config from: <decl>");
    }
}