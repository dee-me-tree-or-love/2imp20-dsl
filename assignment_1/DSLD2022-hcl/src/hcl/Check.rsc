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

/*
 * ----- MAIN -----
 */

//TODO:
//1. all components must have labels --> DONE; checkAllDeclarationsHaveLabels
//2. all component labels are unique --> DONE; checkAllComponentsHaveUniqueLabels
//2+. all reuse labels exist --> DONE; checkAllReuseLabelsExist
//3. total storage size is >0 and <=8192 GB
//4. max L1 size = 128 KiB
//5. max L2 size = 8 MiB
//6. max L3 size = 32 MiB
//7. L1 < L2 < L3
//8. Display type is valid --> DONE; handled by Parsing
//9. Language supports positive integers and reals

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
    // TODO: note that no unit conversion is done since only GiB's are supported.
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

int getSize(A_PROPERTY_STORAGE prop){
    return prop.size;
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
        default: u_panic("Failed to retrieve decl type from: <decl>");
    }
}

&T getConfigItem(type[&T] config_type, A_COMPONENT_CONFIG config){
    switch(config) {
        case storage(storageItem): return storageItem;
        case display(displayItem): return displayItem;
        case processing(processingItem): return processingItem;
        default: u_panic("Failed to retrieve label from: <config>");
    }
}

//
//// Check CONFIGURATION label uniqueness
//bool checkComponentLabels(COMPUTER computer) {
//	// CONFIGURATION Component Label list
//	list[str] labels = getComponentLabels(computer);
//	
//	// Report duplicates, if they exist
//	if (size(labels) - size(dup(labels)) > 0) {
//		error("duplicate Configuration labels: " + toString(labels - dup(labels)));
//		return false;
//	}
//	
//	log("-- No duplicate Configuration labels found.");
//	return true;
//}
//
//// Check all REUSE label exist
//bool checkReuseLabels(COMPUTER computer) {
//	
//	// CONFIGURATION labels list
//	set[str] labels = toSet(getComponentLabels(computer));
//	
//	// Reuse CONFIGURATION labels list
//	set[str] reuseLabels = toSet(getReuseComponentLabels(computer));
//	
//	// Report non-existent TMs
//	if (size(reuseLabels - labels) > 0) {
//		error("non-existent Configurations: " + toString(reuseLabels - labels));
//		return false;
//	}
//	
//	log("-- No non-existent Configuration reused.");
//	return true;
//}
//// Check all components and find if they have correct properties.
//bool checkPropertyNumAndType(COMPUTER computer) {
//	for (/CONFIGURATION c := computer.configs) {
//		switch(c) {
//			case storage(l,ps): {
//				if(size(dup(ps)) != 1) {
//					error("Storage " + c.label + " has an illegal property");
//					return false;
//				}
//				for (/PROPERTY p := c.properties) {
//					switch(p) {
//						case storage(str stype, int ssize): {
//							log("Storage property catched;");
//						}
//						default: {
//							error("Storage " + c.label + " has an illegal property");
//							return false;
//						}
//					}
//				}
//					
//			}
//			
//			case processing(l,ps): {
//				if(size(dup(ps)) != 5) {
//					error("Processing " + c.label + " has illegal properties");
//					return false;
//				}
//				for (/PROPERTY p := c.properties) {
//					switch(p) {
//						case cores(int cores): {
//							log("Processing cores catched;");
//						}
//						case speed(real speed): {
//							log("Processing speed catched;");
//						}
//						case l1(int l1size, str l1mea): {
//							log("Processing l1 cache catched;");
//						}
//						case l2(int l1size, str l1mea): {
//							log("Processing l2 cache catched;");
//						}
//						case l3(int l1size, str l1mea): {
//							log("Processing l3 cache catched;");
//						}
//						default: {
//							error("Processing " + c.label + " has illegal properties");
//							return false;
//						}
//					}
//				}
//			}
//			
//			case display(l,ps): {
//				if(size(dup(ps)) != 2) {
//					error("Display " + c.label + " has illegal properties");
//					return false;
//				}
//				for (/PROPERTY p := c.properties) {
//					switch(p) {
//						case diasize(int dsize): {
//							log("Display diagonal size catched;");
//						}
//						case diatype(str dtype): {
//							log("Display diagonal type catched;");
//						}
//						default: {
//							error("Display " + c.label + " has illegal properties");
//							return false;
//						}
//					}
//				}
//			}
//			
//			default:
//				throw "Unhandled configuration: <c>";
//		}
//	}
//	
//	log("-- No illegal property number or types found.");
//	return true;
//}
//
//bool checkStoragesAndCaches(COMPUTER computer) {
//	//count total storage size
//	int totalStorage = 0;
//	
//	for (/CONFIGURATION c := computer.configs) {
//		switch(c) {
//			// Check all Storage size must be greater than zero but less than or equal to 8192 GiB
//			case storage(l,ps): {
//				p = head(ps);
//				if(p.ssize > 1024 || p.ssize < 32) {
//					error("Storage " + c.label + " has an illegal size");
//					return false;
//				}else 
//					totalStorage += p.ssize;
//			}
//			
//			// Check all Processing Caches: The maximum L1 size is 128 KiB, the maximum L2 size is 8 MiB, the maximum L3 size is 32 MiB; 
//			// and their sizes must satisfy L1 < L2 < L3.
//			case processing(l,ps): {
//				tuple[int, int, int] caches = <0, 0, 0>;
//				for (/PROPERTY p := c.properties) {
//					switch(p) {
//						case l1(int l1size, str l1mea): {
//							if(p.l1mea != "KiB")
//								caches[0] = p.l1size * 1024;
//							else
//								caches[0] = p.l1size;
//						}
//						case l2(int l2size, str l2mea): {
//							if(p.l2mea != "KiB")
//								caches[1] = p.l2size * 1024;
//							else
//								caches[0] = p.l1size;
//						}
//						case l3(int l3size, str l3mea): {
//							if(p.l3mea != "KiB")
//								caches[2] = p.l3size * 1024;
//							else
//								caches[0] = p.l1size;
//						}
//					}
//				}
//				//check if this processing caches is correct
//				if(caches[0] > 128 || caches[1] > 8192 || caches[2] > 32768 || caches[0] < 0) {
//					error("Processing " + c.label + " has illegal cache size");
//					return false;
//				}
//				if(caches[0] > caches[1] || caches[0] > caches[2] || caches[1] > caches[2]) {
//					error("Processing " + c.label + " has illegal cache order");
//					return false;
//				}
//			}
//		}
//	}
//		
//	if(totalStorage > 8192 || totalStorage <= 0) {
//		error("Computer " + computer.label + " has illegal total storage size");
//		totalStorage = 0;
//		return false;
//	}
//		
//	log("-- No illegal storage or cache size found.");
//	return true;
//}
//
//bool checkProcessings(COMPUTER computer) {
//	for (/CONFIGURATION c := computer.configs) {
//		// Get size and label from computer if it is a storage
//		tuple[str, int, int, int] dup = getProcessingCaches(c);
//		
//		//check if this processing caches is correct
//		if(dup[1] > dup[2] || dup[1] > dup[3] || dup[2] > dup[3]) {
//			error("Processing " + dup[0] + " has illegal cache order");
//			return false;
//		}
//		if(dup[1] > 128 || dup[2] > 8192 || dup[3] > 32768 || dup[1] < 0) {
//			error("Processing " + dup[0] + " has illegal cache size");
//			return false;
//		}
//	}
//	return true;
//}
//
//
//bool checkDuplicateComponents(COMPUTER computer) {
//    list[CONFIGURATION] localConfigs = [];
//    for(/CONFIGURATION c := computer.configs) {
//        switch(c){
//            case storage(_,ps):     localConfigs += [storage("",ps)];
//            case processing(_,ps):  localConfigs += [processing("",ps)];
//            case display(_,ps):     localConfigs += [display("",ps)];
//            default:
//                throw "Unhandled configuration: <c>";
//        }
//    }
//    int nrDups = size(computer.configs) - size(dup(localConfigs));
//    if (nrDups == 0) {
//        log("-- <toString(nrDups)> duplicate configurations found.");
//        return true;
//    };
//    error("Found <toString(nrDups)> duplicate configurations.");
//    return false;
//}
//
///* 
// * ----- HELPER -----
// */
// 
//
//// Get CONFIGURATION labels
//list[str] getComponentLabels(COMPUTER computer) {
//	list[str] labels = [];
//	for (/CONFIGURATION co := computer.configs) {
//		labels = labels + co.label;
//	}
//	return labels;
//}
//
//// Get Reuse CONFIGURATION labels
//list[str] getReuseComponentLabels(COMPUTER computer) {
//	list[str] labels = [];
//	switch(computer) {
//		case computer(str label, list[CONFIGURATION] configs, list[REUSE] reuses): {
//			for (/REUSE re := computer.reuses) {
//				labels = labels + re.label;
//			}
//			return labels;
//		}
//		case computerW(str label, list[CONFIGURATION] configs):
//			return labels;
//	}
//}