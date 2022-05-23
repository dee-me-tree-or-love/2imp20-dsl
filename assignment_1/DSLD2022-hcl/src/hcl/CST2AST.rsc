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

// Converts a list of configurations to three list of different components
//CONFIGURATION cst2ast((Configuration)`processing :<Id label> { cores : <Integer cores> , speed : <Real speed> Ghz , L1 : <Integer l1size> <CacheSize l1mea> , L2 : <Integer l2size> <CacheSize l2mea> , L3 : <Integer l3size> <CacheSize l3mea> }`){
//	return processing("<co.label>", "<co.cores>", "<co.speed>", "<co.l1size>", "<co.l1mea>", "<co.l2size>", "<co.l2mea>", "<co.l3size>", "<co.l3mea>");
//}
//
//CONFIGURATION cst2ast((Configuration)`storage <Id label> { storage : <StorageType stype> of <Integer ssize> GiB`){
//	return storage("<co.label>", "<co.stype>", "<co.ssize>");
//}
//
//CONFIGURATION cst2ast((Configuration)`display <Id label> { diagonal : <Integer dsize> inch , type : <DisplayType dtype>`){
//	return display("<co.label>", "<co.dsize>", "<co.dtype>");
//}

CONFIGURATION cst2ast(Configuration c) {
	return configuration("<c.co>", "<c.label>", [cst2ast(p) | (Property p <- c.properties)]);
}

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
