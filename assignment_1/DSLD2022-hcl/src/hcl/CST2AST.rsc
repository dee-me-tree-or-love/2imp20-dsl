module hcl::CST2AST

import hcl::AST;
import hcl::Syntax;

/*
 * Implement a mapping from concrete syntax trees (CSTs) to abstract syntax trees (ASTs)
 * Hint: Use switch to do case distinction with concrete patterns
 * Map regular CST arguments (e.g., *, +, ?) to lists
 * Map lexical nodes to Rascal primitive types (bool, int, str)
 */

// Transforms a computer to a series of configurations and reuseComponents
COMPUTER cst2ast(start[Computer] sf){
	Computer c = sf.top;
	COMPUTER result = computer([cst2ast(co) | (CONFIGURATION co <- c.configurations)], [cst2ast(re) | (REUSE re <- c.reuseComponents)]);
	return result;
}

// Converts a list of configurations to three list of different components
CONFIGURATION cst2ast(CONFIGURATION co){
	if(co := "processing")
		return processing("<co.cores>", "<co.speed>", "<co.l1size>", "<co.l1mea>", "<co.l2size>", "<co.l2mea>", "<co.l3size>", "<co.l3mea>");
	if(co := "storage")
		return storage("<co.stype>", "<co.ssize>");
	if(co := "display")
		return display("<co.diagonalsize>", "<co.dtype>");
}

// Converts a list of reuseStatements to three list of different components
REUSE cst2ast(REUSE re){
	return reuse("<re.reuseComponent>");
}
