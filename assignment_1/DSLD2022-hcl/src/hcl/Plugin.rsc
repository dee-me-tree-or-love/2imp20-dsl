module hcl::Plugin

import ParseTree;
import Message;
import Node;
import IO;
import util::IDE;
import hcl::Check;
import hcl::Parser;
import hcl::CST2AST;
// Attempt to make the error message annotation work.
import hcl::Syntax;

// Utility functions
// ~~~~~~~~~~~~~~~~~

// Log a string; change the println() to whatever is needed
void log(str msg) {
    println(msg);
}

/*
* This function is defined to test the functionality of the whole assignment. It receives a file path as a parameter and returns true if the program satisfies the specification or false otherwise.
* First, it calls the parser (Parser.rsc). Then, it transforms the resulting parse tree of the previous program and calls the function cst2ast (CST2AST.rsc), responsible for transforming a parse tree into an abstract syntax tree.
* Finally, the resulting AST is used to evaluate the well-formedness of the ccl program using the check function (Check.rsc).
*/
bool checkWellformedness(loc path) {
	// Parsing
	&T resource = parseHCL(path);
	// Transform the parse tree into an abstract syntax tree
	&T ast = loadAst(resource);
	// Check the well-formedness of the program
	return checkHardwareConfiguration(ast);
}

void runTestExamples(){
    list[tuple[loc, bool]] pathExpectations = [
        // TODO: make consistent names.
        <|project://DSLD2022-hcl/samples/ex.hcl|, true>,
        <|project://DSLD2022-hcl/samples/ex_duplicate_labels.hcl|, false>,
        <|project://DSLD2022-hcl/samples/ex_non_existent_reuses.hcl|, false>,
        <|project://DSLD2022-hcl/samples/parse_storageWithExcessSize.hcl|, false>,
        <|project://DSLD2022-hcl/samples/parse_storageWithExcessTotalSize.hcl|, false>,
        <|project://DSLD2022-hcl/samples/parse_processingWithWrongCacheSize.hcl|, false>
        //
        
    ];

    // Test that checkWellformedness(...) returns what is expected
    list[tuple[loc, bool, bool]] results = [
        <pe[0], pe[1], checkWellformedness(pe[0]) == pe[1]>
        | pe <-pathExpectations
    ];

    // Collect all test results
    bool allCorrect = (true | it && r[2] | r <- results );

    if(allCorrect) {
        log("OK: All test cases are valid");
    }else {
        log("FAIL: Some test cases have failed");
    };
}

// TODO: tech debt.
//      We could not get the annotations to work for some reason.
//      Attempt was to follow the examples from the Pico recipe.
// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
//public CComputer annotateHclChecks(CComputer c) {
//    annos = getAnnotations(c);
//    valid = false;
//    if (!valid) {
//        Message checkMessage =  Message::warning("Well-formedness check has failed", c@src);
//        c@messages = {checkMessage};
//    };
//    return c;
//}

/*
* This is the main function of the project. This function enables the editor's syntax highlighting.
* After calling this function from the terminal, all files with extension .hcl will be parsed using the parser defined in module hcl::Parser.
* If there are syntactic errors in the program, no highlighting will be shown in the editor.
*/
void main() {
	registerLanguage("HCL - DSLD", "hcl", Tree(str _, loc path) {
        start[CComputer] parseResult = parseHCL(path);
        return parseResult;
    });

    runTestExamples();

    // Adding annotation with error checks
    // TODO: tech debt.
    //      We could not get the annotations to work for some reason.
    // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    //registerAnnotator("HCL - DSLD", annotateHclChecks);

    // For local debugging
    //loc dir = |project://DSLD2022-hcl/samples/ex.hcl|;
    //start[CComputer] parseResult = parseHCL(dir);
    //c = parseResult;
    //annotateHclChecks(c.top);
    //astResult = loadAst(c);
    //ac = astResult;
    //checkResult = checkHardwareConfiguration(ac);
    //okc = checkResult;
}