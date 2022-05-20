module hcl::Check

import hcl::AST;

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
 * ----- MAIN -----
 */

bool checkHardwareConfiguration(COMPUTER computer) {
	log("-- CHECKING COMPUTER --");
	return checkComponentLabels(computer)
        && checkReuseLabels(computer) 
		&& checkStorages(computer)
		&& checkProcessings(computer)
		&& succes();		
}



/*
 * ----- CHECKER -----
 */
 

// Check CONFIGURATION label uniqueness
bool checkComponentLabels(COMPUTER computer) {
	// CONFIGURATION Component Label list
	list[str] labels = getComponentLabels(computer);
	
	// Report duplicates, if they exist
	if (size(labels) - size(dup(labels)) > 0) {
		error("duplicate Configuration labels: " + toString(labels - dup(labels)));
		return false;
	}
	
	log("No duplicate Configuration names found.");
	return true;
}

// Check all REUSE label exist
bool checkReuseLabels(COMPUTER computer) {
	
	// CONFIGURATION labels list
	set[str] labels = toSet(getComponentLabels(computer));
	
	// Reuse CONFIGURATION labels list
	set[str] reuseLabels = toSet(getReuseComponentLabels(computer));
	
	// Report non-existent TMs
	if (size(reuseLabels - labels) > 0) {
		error("non-existent Configurations: " + toString(reuseLabels - labels));
		return false;
	}
	
	log("No non-existent Configuration labels found.");
	return true;
}

// Check all Storage size must be greater than zero but less than or equal to 8192 GiB
bool checkStorages(COMPUTER computer) {
	for (/CONFIGURATION co := computer.configurations) {
		// Get size and label from computer if it is a storage
		tuple[str, int] dup = getStorage(co);
		
		//check if this storage size is correct
		if(dup[1] <= 0 || dup[1] > 8192) {
			error("Storage " + dup[0] + " has an illegal size");
			return false;
		}
	}
	return true;
}

// Check all Processing Caches: The maximum L1 size is 128 KiB, the maximum L2 size is 8 MiB, the maximum L3 size is 32 MiB; 
// and their sizes must satisfy L1 < L2 < L3.
bool checkProcessings(COMPUTER computer) {
	for (/CONFIGURATION co := computer.configurations) {
		// Get size and label from computer if it is a storage
		tuple[str, int, int, int] dup = getProcessingCaches(co);
		
		//check if this processing caches is correct
		if(dup[1] > dup[2] || dup[1] > dup[3] || dup[2] > dup[3]) {
			error("Processing " + dup[0] + " has illegal cache order");
			return false;
		}
		if(dup[1] > 128 || dup[2] > 8192 || dup[3] > 32768 || dup[1] < 0) {
			error("Processing " + dup[0] + " has illegal cache size");
			return false;
		}
	}
	return true;
}

/* 
 * ----- HELPER -----
 */
 

// Get CONFIGURATION labels
list[str] getComponentLabels(COMPUTER computer) {
	list[str] labels = [];
	for (/CONFIGURATION co := computer.configurations) {
		labels = labels + co.label;
	}
	return labels;
}

// Get Reuse CONFIGURATION labels
list[str] getReuseComponentLabels(COMPUTER computer) {
	list[str] labels = [];
	for (/REUSE re := computer.reuseComponents) {
		labels = labels + re.label;
	}
	return labels;
}

// Get All Storage CONFIGURATION size list
tuple[str, int] getStorage(CONFIGURATION co) {
	if(co.ssize)//PROBLEM: how to check if it is storage
		return <co.label, co.ssize>;
}

// Get All Storage CONFIGURATION size list
tuple[str, int, int, int] getProcessingCaches(CONFIGURATION co) {
	if(co.cores) {//PROBLEM: how to check if it is processing
		tuple[str, int, int, int] cache = <co.label, co.l1size, co.l2size, co.l3size>;
		if(co.l1mea != "KiB")
			cache[1] = cache[1] * 1024;
		if(co.l2mea != "KiB")
			cache[2] = cache[2] * 1024;
		if(co.l3mea != "KiB")
			cache[3] = cache[3] * 1024;
			
		return cache;
	}
}

// Log a string; change the println() to whatever is needed
void log(str msg) {
	println(msg);
}

// Method for logging errors
void error(str msg) {
	log("ERROR: " + msg + "!\n");
}

// Only logs if all checks successful
bool succes() {
	log("Check successful!\n");
	return true;
}