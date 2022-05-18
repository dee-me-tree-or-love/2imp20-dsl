module hcl::Syntax
/*
 * Define a concrete syntax for HCL. The langauge's specification is available in the PDF (Section 3)
 */

// RegEx definition of identifiers(Id), Reals, Integers, Boolean and String
lexical Id  = [a-z][a-z0-9]* !>> [a-z0-9];
lexical Integer = ([1-9][0-9]*); //delete 0 for all positive
lexical Real = Integer [.] [0-9]+;
lexical String = "\"" ![\"]*  "\"";
lexical Boolean = "true" | "false";

layout Layout = WhitespaceAndComment* !>> [\ \t\n\r%];
lexical WhitespaceAndComment 
   = [\ \t\n\r]
   | @category="Comment" "%" ![%]+ "%"
   | @category="Comment" "%%" ![\n]* $
   ;
//   
//lexical Comma = [,];
//lexical Colon = [:];
 
lexical CacheSize = "MiB" | "KiB";     
lexical StorageType = "HDD" | "SSD";
lexical DisplayType = "5K" | "4K" | "HD" | "Full-HD";

//add keywords which should never be used as identifiers
keyword Keywords = "computer" | "processing" | "display" | "storage" | "of" |
                      "SSD" | "HDD" | "5K" | "4K" | "HD" | "Full-HD" | 
                      "MiB" | "KiB" | "GiB" | "GHz"
                      "true" | "false" 
                      "speed" | "cores" | "L1" | "L2" | "L3" | "diagonal" | "inch" | "type" 
                      ;

start syntax Computer 
	= computer : "computer" Id identifier "{" ComputerSetup "}";//here assume at least we add a component and another question

// Computer setup describing the configuration and optional reuse.
syntax ComputerSetup
    = { Configuration "," }+ ("," { Reuse "," }+ )?
    ;

// Concrete Syntax for component configuration and reuse
syntax Configuration
  = processing: "processing" Id processing "{" {ProcessingConfiguration ","}+ "}"
  | storage: "storage" Id storage "{" StorageConfiguration "}"
  | display: "display" Id display "{" DisplayConfiguration "}"
  ;

// FIXME: get stuck here
// Modular Reusability block, to reuse declared labels.
syntax Reuse
  = | reuse: Id reuseComponent
  ;

// Concrete Syntax for processing configuration  problem:order?
syntax ProcessingConfiguration
    = Cores "," Speed "," L1Cache "," L2Cache "," L3Cache
    ;
// Modular processing configuration blocks
syntax Cores
    = "cores" ":" Integer int_c
    ;
syntax Speed
    = speed: "speed" ":" Real real_s "GHz"
    ;
syntax L1Cache
    = l1: "L1" ":" Integer int_1 CacheSize
    ;
syntax L2Cache
    = l2: "L2" ":" Integer int_2 CacheSize
    ;
syntax L3Cache
    = l3: "L3" ":" Integer int_3 CacheSize
    ;

// Storage configuration
syntax StorageConfiguration
    = "storage" ":"  StorageType stype "of" Integer int_s "GiB"
    ;

// Display configuration
syntax DisplayConfiguration
    = "diagonal" ":" Integer int_d "inch" ":" "," "type" ":" DisplayType dtype
    ;


// //basic expression
// syntax Expression 
//     = id: Id identifier
//     | str: String String
//     | real: Real real
//     | bool: Boolean bool
//     ;