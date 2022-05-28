module hcl::AST

/*
 * Define the Abstract Syntax for HCL
 *
 * - make sure there is an almost one-to-one correspondence with the grammar in Syntax.rsc
 */

public data A_COMPUTER
    = computer(str label, list[A_COMPONENT_DECL] decls)
    ;

public data A_COMPONENT_DECL
    = config(A_COMPONENT_CONFIG configItem)
    | reuse(A_COMPONENT_REUSE reuseItem)
    ;

public data A_COMPONENT_REUSE
    = body(str label)
    ;

public data A_COMPONENT_CONFIG
    = storage(A_COMPONENT_STORAGE storageItem)
    | display(A_COMPONENT_DISPLAY displayItem)
    | processing(A_COMPONENT_PROCESSING processingItem)
    ;

public data A_COMPONENT_STORAGE
    = body(str label, list[A_PROPERTY_STORAGE] props)
    ;

public data A_PROPERTY_STORAGE
    = propStorage(str storageType, int size, str unit)
    ;

public data A_COMPONENT_DISPLAY
    = body(str label, list[A_PROPERTY_DISPLAY] props)
    ;

public data A_PROPERTY_DISPLAY
    = propDiagonal(int size, str unit)
    | propResolutionType(str displayType)
    ;

public data A_COMPONENT_PROCESSING
    = body(str label, list[A_PROPERTY_PROCESSING] props)
    ;

public data A_PROPERTY_PROCESSING
    = propCores(int cores)
    | propSpeed(real speed)
    | propL1(int size, str unit)
    | propL2(int size, str unit)
    | propL3(int size, str unit)
    ;

anno loc A_COMPUTER@location;   //parse tree root