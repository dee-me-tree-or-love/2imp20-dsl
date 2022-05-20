module hcl::AST

/*
 * Define the Abstract Syntax for HCL
 *
 * - make sure there is an almost one-to-one correspondence with the grammar in Syntax.rsc
 */
 
//Computer Definition
public data COMPUTER
	= computer(list[CONFIGURATION] configurations, list[REUSE] reuseComponents);
 
public data CONFIGURATION
 	= processing(int cores, real speed, int l1size, str l1mea, int l2size, str l2mea, int l3size, str l3mea)
 	| storage(str stype, int ssize)
 	| display(int dsize, str dtype)
 	;

public data REUSE
    = reuse(str reuseComponent)
	;


anno loc COMPUTER@location;   //parse tree root