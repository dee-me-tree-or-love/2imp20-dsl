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
 
lexical CahceSize = "MiB" | "KiB";     
lexical StorageType = "HDD" | "SSD";
lexical DisplayType = "5K" | "4K" | "HD" | "Full-HD";

start syntax Computer 
	= computer : "computer" Id identifier "{" { Configuration ","}+  "}";//here assume at least we add a component and another question


// Concrete Syntax for component configuration and reuse
syntax Configuration
  = processing: "processing" Id processing "{" {ProcessingConfiguration ","}+ "}"
  | storage: "storage" Id storage "{" StorageConfiguration "}"
  | display: "display" Id display "{" DisplayConfiguration "}"
  | reuse: Id reuseComponent;// get stuck here
  


// Concrete Syntax for processing configuration  problem:order?
syntax ProcessingConfiguration
    ="cores" ":" Integer int_c "," "speed" ":" Real real_s "GHz" "," "L1" ":" Integer int_1 CahceSize "," "L2" ":" Integer int_2 CahceSize "," "L3" ":" Integer int_3 CahceSize 
    ;
syntax StorageConfiguration
    ="storage" ":"  StorageType "of" Integer int_s "GiB"
    ;
syntax DisplayConfiguration
    ="diagonal" ":" Integer int_d "inch" ":" "," "type" ":" DisplayType
    ;
