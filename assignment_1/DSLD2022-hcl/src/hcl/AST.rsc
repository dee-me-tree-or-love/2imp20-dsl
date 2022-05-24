module hcl::AST

/*
 * Define the Abstract Syntax for HCL
 *
 * - make sure there is an almost one-to-one correspondence with the grammar in Syntax.rsc
 */
 
//Computer Definition
public data COMPUTER
	= computer(str label, list[CONFIGURATION] configs, list[REUSE] reuses)
	| computerW(str label, list[CONFIGURATION] configs);


public data CONFIGURATION
 	= processing(str label, list[PROPERTY] properties)
 	| storage(str label, list[PROPERTY] properties)
 	| display(str label, list[PROPERTY] properties)
 	;
 	
public data REUSE
    = reuse(str label)
	;

public data PROPERTY
	= cores(int cores)
	| speed(real speed)
	| l1(int l1size, str l1mea)
	| l2(int l2size, str l2mea)
	| l3(int l3size, str l3mea)
    | storage(str stype, int ssize)
    | diasize(int dsize)
    | diatype(str dtype)
	;
	
anno loc COMPUTER@location;   //parse tree root