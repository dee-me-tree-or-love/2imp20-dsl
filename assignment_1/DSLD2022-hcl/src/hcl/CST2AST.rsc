module hcl::CST2AST

import hcl::AST;
import hcl::Syntax;

import String;
import List;

/*
 * Implement a mapping from concrete syntax trees (CSTs) to abstract syntax trees (ASTs)
 * Hint: Use switch to do case distinction with concrete patterns
 * Map regular CST arguments (e.g., *, +, ?) to lists
 * Map lexical nodes to Rascal primitive types (bool, int, str)
 */

// Transforms a computer to a series of configurations and reuseComponents
COMPUTER cst2ast(start[Computer] sf) {
    Computer c = sf.top;

    reuseItems = [];
    for (ComputerReuseBlock reuseBlock <- c.reuseBlock ) {
        reuseItems += reuseBlock.items;
    }

    COMPUTER result = computer(
        "<c.label>", 
        [cst2ast(co) | (Configuration co <- c.configs.items)], 
        // FIXME: fix the issue with parsing the "reuse" part of the computer pattern. It fails with `Undeclared type: Tree`
        [cst2ast(re) | (Reuse re <- reuseItems)]
        //[]
    );
    return result;
}

// Converts the provided configuration to its AST representation
CONFIGURATION cst2ast(Configuration c) {
    switch(c) {
        case (Configuration)`processing <Id label> <ConfigurationBody body>`:
            return CONFIGURATION::processing("<label>", [cst2ast(p) | (Property p <- body.items)]);
        
        case (Configuration)`storage <Id label> <ConfigurationBody body>`:
            return CONFIGURATION::storage("<label>", [cst2ast(p) | (Property p <- body.items)]);
        
        case (Configuration)`display <Id label> <ConfigurationBody body>`:
            return CONFIGURATION::display("<label>", [cst2ast(p) | (Property p <- body.items)]);
        
        default:
            throw "Unhandled configuration: <c>";
    }
}

// Converts the provided property to its corresponding AST representation
PROPERTY cst2ast(Property p) {
    switch(p) {
        case (Property)`cores : <Integer cores>`:
            return PROPERTY::cores(toInt("<cores>"));

        case (Property)`speed : <Real speed> Ghz`:
            return PROPERTY::speed(toReal("<speed>"));

        case (Property)`L1 : <Integer l1size> <CacheSize l1mea>`:
            return PROPERTY::l1(toInt("<l1size>"), "<l1mea>");

        case (Property)`L2 : <Integer l2size> <CacheSize l2mea>`:
            return PROPERTY::l2(toInt("<l2size>"), "<l2mea>");

        case (Property)`L3 : <Integer l3size> <CacheSize l3mea>`:
            return PROPERTY::l3(toInt("<l3size>"), "<l3mea>");

        case (Property)`storage : <StorageType stype> of <Integer ssize> GiB`:
            return PROPERTY::storage("<stype>", toInt("<ssize>"));

        case (Property)`diagonal : <Integer dsize> inch`:
            return PROPERTY::diasize(toInt("<dsize>"));

        case (Property)`type : <DisplayType dtype>`:
            return PROPERTY::diatype("<dtype>");

        default:
            throw "Unhandled property: <p>";
    }
}

// Converts a list of reuseStatements to three list of different components
REUSE cst2ast(Reuse re){
    return REUSE::reuse("<re.label>");
    
}
