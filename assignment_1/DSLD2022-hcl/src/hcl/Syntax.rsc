module hcl::Syntax

/*
 * Define a concrete syntax for HCL. The langauge's specification is available in the PDF (Section 3)
 */

// Constants and utility definitions.
// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~


// Keywords which should never be used as identifiers
keyword CKeywords = "computer" | "processing" | "display" | "storage" | "of" |
                      "SSD" | "HDD" | "5K" | "4K" | "HD" | "Full-HD" | 
                      "MiB" | "KiB" | "GiB" | "GHz"
                      "true" | "false" 
                      "speed" | "cores" | "L1" | "L2" | "L3" | "diagonal" | "inch" | "type" 
                      ;

// RegEx definition of identifiers(Id), Reals, Integers, Boolean and String
lexical CId  = ([A-Za-z][A-Za-z0-9_\-]*) \ CKeywords;
lexical CInteger = ([0-9][0-9]*); 
lexical CReal = CInteger | CInteger [.] [0-9]+;
lexical CString = "\"" ![\"]*  "\"";
lexical CBoolean = "true" | "false";

// Basic language layout rules
layout  Layout = WhitespaceAndComment* !>> [\ \t\n\r%];
lexical WhitespaceAndComment 
   = [\ \t\n\r]
   | @category="Comment" "|-" ![%]+ "-|"
   | @category="Comment" "--" ![\n]* $
   ;

lexical CCacheUnit = "MiB" | "KiB";
lexical CSpeedUnit = "Ghz";
lexical CStorageType = "HDD" | "SSD";
lexical CStorageUnit = "GiB";
lexical CDisplayType = "5K" | "4K" | "HD" | "Full-HD";
lexical CDisplayUnit = "inch";

// Concrete domain elements.
// ~~~~~~~~~~~~~~~~~~~~~~~~~

start syntax CComputer
    = computer : "computer" CId label "{" { CComponentDecl "," }* decls "}"
    ;

start syntax CComponentDecl
    = config: CComponentConfig item
    | reuse: CComponentReuse item
    ;

start syntax CComponentReuse
    = body: CId label
    ;

start syntax CComponentConfig
    = storage: CComponentStorage item
    | display: CComponentDisplay item
    | processing: CComponentProcessing item
    ;

start syntax CComponentStorage
    = body: "storage" CId label "{" { CPropertyStorage "," }+ props "}"
    ;

start syntax CPropertyStorage
    = propStorage: "storage" 
               ":" CStorageType storageType 
               "of" CInteger size 
               CStorageUnit unit
    ;

start syntax CComponentDisplay
    = body: "display" CId label "{" { CPropertyDisplay "," }+ props "}"
    ;

start syntax CPropertyDisplay
    = propDiagonal: "diagonal" ":" CInteger size CDisplayUnit unit
    | propResolutionType: "type" ":" CDisplayType displayType
    ;
    
start syntax CComponentProcessing
    = body: "processing" CId label "{" { CPropertyProcessing "," }+ props "}"
    ;

start syntax CPropertyProcessing
    = propCores: "cores" ":" CInteger cores
    | propSpeed: "speed" ":" CReal speed CSpeedUnit unit
    | propL1: "L1" ":" CInteger size CCacheUnit unit
    | propL2: "L2" ":" CInteger size CCacheUnit unit
    | propL3: "L3" ":" CInteger size CCacheUnit unit
    ;

