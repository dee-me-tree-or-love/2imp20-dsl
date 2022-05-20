module hcl::AST

/*
 * Define the Abstract Syntax for HCL
 *
 * - make sure there is an almost one-to-one correspondence with the grammar in Syntax.rsc
 */
 
//Computer Definition
public data COMPUTER
	= computer(list[CONFIGURATION] configurations, list[REUSE] reuseComponents);

//public data CONFIGURATION
// 	//= processing(str label, int cores, real speed, int l1size, str l1mea, int l2size, str l2mea, int l3size, str l3mea)
// 	= processing(str label, set[PROCESS] pproperties)
// 	| storage(str label, str stype, int ssize)
// 	| display(str label, int dsize, str dtype)
// 	;

 
public data CONFIGURATION
 	= configuration(str componentType, str label, list[PROPERTY] properties)
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