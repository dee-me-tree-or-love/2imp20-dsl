module hcl::Syntax
/*
 * Define a concrete syntax for HCL. The langauge's specification is available in the PDF (Section 3)
 */

// RegEx definition of identifiers(Id), Reals, Integers, Boolean and String
lexical Id  = [A-Za-z][A-Za-z0-9_\-]*;
lexical Integer = ([0-9][0-9]*); 
lexical Real = Integer | Integer [.] [0-9]+;
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
lexical Component = "processing" | "storage" | "display";
lexical PropertyTag = "speed" | "cores" | "L1" | "L2" | "L3" | "diagonal" ;

//add keywords which should never be used as identifiers
keyword Keywords = "computer" | "processing" | "display" | "storage" | "of" |
                      "SSD" | "HDD" | "5K" | "4K" | "HD" | "Full-HD" | 
                      "MiB" | "KiB" | "GiB" | "GHz"
                      "true" | "false" 
                      "speed" | "cores" | "L1" | "L2" | "L3" | "diagonal" | "inch" | "type" 
                      ;

start syntax Computer 
	= computer : "computer" Id computer "{" ComputerSetup "}";//here assume at least we add a component and another question

// Computer setup describing the configuration and optional reuse.
syntax ComputerSetup
    = { Configuration  "," }+ ("," { Reuse  "," }+ )?
    ;

// Concrete Syntax for component configuration and reuse
//syntax Configuration
//  = processing: "processing" Id label "{" Property "," Property "," Property "," Property "," Property "}"
//  | storage: "storage" Id label "{" Property "}"
//  | display: "display" Id label "{" Property "," Property "}"
  //;
  
syntax Configuration
	= configuration: Component co Id label "{" { Property "," }+ "}"
	;

// FIXME: get stuck here
// Modular Reusability block, to reuse declared labels.
syntax Reuse
    = reuse: Id label
    ;

// Concrete Syntax for processing configuration  problem:order?
//syntax ProcessingConfiguration //PROBLEM : order
//    //= Cores "," Speed "," L1Cache "," L2Cache "," L3Cache
//    = Property "," Property "," Property "," Property "," Property
//    ;
// Modular processing configuration blocks
//syntax Cores
//    = cores: "cores" ":" Integer cores
//    ;
//syntax Speed
//    = speed: "speed" ":" Real speed "Ghz"
//    ;
//syntax L1Cache
//    = l1: "L1" ":" Integer l1size CacheSize l1mea
//    ;
//syntax L2Cache
//    = l2: "L2" ":" Integer l2size CacheSize l2mea
//    ;
//syntax L3Cache
//    = l3: "L3" ":" Integer l3size CacheSize l3mea
//    ;
    
syntax Property
    = cores: "cores" ":" Integer cores
    | speed: "speed" ":" Real speed "Ghz"
    | l1: "L1" ":" Integer l1size CacheSize l1mea
    | l2: "L2" ":" Integer l2size CacheSize l2mea
    | l3: "L3" ":" Integer l3size CacheSize l3mea
    | storage: "storage" ":" StorageType stype "of" Integer ssize "GiB"
    | diasize: "diagonal" ":" Integer dsize "inch"
    | diatype: "type" ":" DisplayType dtype
	;

// Storage configuration
//syntax StorageConfiguration
//    = "storage" ":"  StorageType stype "of" Integer ssize "GiB"
//    ;

// Display configuration
//syntax DisplayConfiguration
//    = "diagonal" ":" Integer dsize "inch" "," "type" ":" DisplayType dtype
//    ;


// //basic expression
// syntax Expression 
//     = id: Id identifier
//     | str: String String
//     | real: Real real
//     | bool: Boolean bool
//     ;