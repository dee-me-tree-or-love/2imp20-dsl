module hcl::CST2AST

import hcl::AST;
import hcl::Syntax;

import String;

/*
 * Implement a mapping from concrete syntax trees (CSTs) to abstract syntax trees (ASTs)
 * Hint: Use switch to do case distinction with concrete patterns
 * Map regular CST arguments (e.g., *, +, ?) to lists
 * Map lexical nodes to Rascal primitive types (bool, int, str)
 */

// Utility functions
// ~~~~~~~~~~~~~~~~~

void u_panic(item){
    throw "Unhandled concrete element: <item>";
}


// Transformation functions
// ~~~~~~~~~~~~~~~~~~~~~~~~

A_COMPUTER loadAst(start[CComputer] sf) {
    CComputer c = sf.top;
    return cst2ast(c);
}

A_COMPUTER cst2ast(CComputer c){
    decls = [cst2ast(cdecl) | (CComponentDecl cdecl <- c.decls) ];
    return A_COMPUTER::computer("<c.label>", decls);
}

A_COMPONENT_DECL cst2ast(CComponentDecl cd){
    switch(cd) {
        case (CComponentDecl)`<CComponentConfig item>`:
            return A_COMPONENT_DECL::config(cst2ast(item));
        case (CComponentDecl)`<CComponentReuse item>`:
            return A_COMPONENT_DECL::reuse(cst2ast(item));
        default:
          u_panic(cd);
    }
}

A_COMPONENT_REUSE cst2ast(CComponentReuse critem) {
    return A_COMPONENT_REUSE::body("<critem.label>");
}

A_COMPONENT_CONFIG cst2ast(CComponentConfig citem) {
    switch(citem) {
        case (CComponentConfig)`<CComponentStorage item>`:
            return A_COMPONENT_CONFIG::storage(cst2ast(item));
        case (CComponentConfig)`<CComponentDisplay item>`:
            return A_COMPONENT_CONFIG::display(cst2ast(item));
        case (CComponentConfig)`<CComponentProcessing item>`:
            return A_COMPONENT_CONFIG::processing(cst2ast(item));
        default:
          u_panic(citem);
    }
}

A_COMPONENT_STORAGE cst2ast(CComponentStorage citem){
    props = [cst2ast(cp) | (CPropertyStorage cp <- citem.props)];
    return A_COMPONENT_STORAGE::body("<citem.label>", props);
}

A_PROPERTY_STORAGE cst2ast(CPropertyStorage cprop){
    switch(cprop) {
        case (CPropertyStorage)`storage : <CStorageType storageType> of <CInteger size> <CStorageUnit unit>`:
            return A_PROPERTY_STORAGE::propStorage("<storageType>", toInt("<size>"), "<unit>");
        default:
            u_panic(cprop);
    }
}

A_COMPONENT_DISPLAY cst2ast(CComponentDisplay citem){
    props = [cst2ast(cp) | (CPropertyDisplay cp <- citem.props)];
    return A_COMPONENT_DISPLAY::body("<citem.label>", props);
}

A_PROPERTY_DISPLAY cst2ast(CPropertyDisplay cprop){
    switch(cprop) {
        case (CPropertyDisplay)`diagonal : <CInteger size> <CDisplayUnit unit>`:
            return A_PROPERTY_DISPLAY::propDiagonal(toInt("<size>"), "<unit>");
        case (CPropertyDisplay)`type : <CDisplayType displayType>`:
            return A_PROPERTY_DISPLAY::propResolutionType("<displayType>");
        default:
            u_panic(cprop);
    }
}

A_COMPONENT_PROCESSING cst2ast(CComponentProcessing citem){
    props = [cst2ast(cp) | (CPropertyProcessing cp <- citem.props)];
    return A_COMPONENT_PROCESSING::body("<citem.label>", props);
}

A_PROPERTY_PROCESSING cst2ast(CPropertyProcessing cprop){
    switch(cprop) {
        case (CPropertyProcessing)`cores : <CInteger cores>`:
            return A_PROPERTY_PROCESSING::propCores(toInt("<cores>"));
        case (CPropertyProcessing)`speed : <CReal speed> <CSpeedUnit unit>`:
            return A_PROPERTY_PROCESSING::propSpeed(toReal("<speed>"));
        case (CPropertyProcessing)`L1 : < CInteger size> <CCacheUnit unit>`:
            return A_PROPERTY_PROCESSING::propL1(toInt("<size>"), "<unit>");
        case (CPropertyProcessing)`L2 : < CInteger size> <CCacheUnit unit>`:
            return A_PROPERTY_PROCESSING::propL2(toInt("<size>"), "<unit>");
        case (CPropertyProcessing)`L3 : < CInteger size> <CCacheUnit unit>`:
            return A_PROPERTY_PROCESSING::propL3(toInt("<size>"), "<unit>");
        default:
            u_panic(cprop);
    }
}
