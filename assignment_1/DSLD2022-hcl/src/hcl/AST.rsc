module hcl::AST

/*
 * Define the Abstract Syntax for HCL
 *
 * - make sure there is an almost one-to-one correspondence with the grammar in Syntax.rsc
 */
 
 //Computer Definition
 public data COMPUTER 
 	= computer(list[CONPONENT] components);
 
 public data COMPONENT
 	= processing(list[PROCOMPOENEET] peocomponents)
 	| storage(list[STOCOMPOENEET] stocomponents)
 	| display(list[DISCOMPOENEET] discomponents)
 	;
 
 	
anno loc COMPUTER@location;   
anno loc COMPONENT@location;   
anno loc PROCOMPONENT@location;   
anno loc STOCOMPONENT@location;   
anno loc DISCOMPONENT@location;   