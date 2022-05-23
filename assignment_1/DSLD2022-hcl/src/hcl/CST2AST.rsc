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
COMPUTER cst2ast(start[Computer] sf) {
	Computer c = sf.top;
	COMPUTER result = computer([cst2ast(co) | (Configuration co <- c.configurations)], [cst2ast(re) | (Reuse re <- c.reuseComponents)]);
	return result;
}

// Converts the provided configuration to its AST representation
CONFIGURATION cst2ast(Configuration c) {
	switch(c) {
		case (Configuration)`processing <Id label> <ConfigurationBody body>`:
			return processing("<label>", [cst2ast(p) | (Property p <- body)]);
		
		case (Configuration)`storage <Id label> <ConfigurationBody body>`:
			return processing("<label>", [cst2ast(p) | (Property p <- body)]);
		
		case (Configuration)`display <Id label> <ConfigurationBody body>`:
			return processing("<label>", [cst2ast(p) | (Property p <- body)]);
		
		default:
			throw "Unhandled configuration: <c>";
	}
}

// Converts the provided property to its corresponding AST representation
PROPERTY cst2ast(Property p) {
	switch(p) {
		case (Property)`cores : <Integer cores>`:
			return cores("<p.cores>");

		case (Property)`speed : <Real speed> Ghz`:
			return speed("<p.speed>");

		case (Property)`L1 : <Integer l1size> <CacheSize l1mea>`:
			return l1("<p.l1size>", "<p.l1mea>");

		case (Property)`L2 : <Integer l2size> <CacheSize l2mea>`:
			return l2("<p.l2size>", "<p.l2mea>");

		case (Property)`L3 : <Integer l3size> <CacheSize l3mea>`:
			return l3("<p.l3size>", "<p.l3mea>");

		case (Property)`storage : <StorageType stype> of <Integer ssize> GiB`:
			return storage("<p.stype>", "<p.ssize>");

		case (Property)`diagonal : <Integer dsize> inch`:
			return diasize("<p.dsize>");

		case (Property)`type : <DisplayType dtype>`:
			return diatype("<p.dtype>");

		default:
			throw "Unhandled property: <p>";
	}
}

// Converts a list of reuseStatements to three list of different components
REUSE cst2ast(REUSE re){
	return reuse("<re.label>");
	
}
