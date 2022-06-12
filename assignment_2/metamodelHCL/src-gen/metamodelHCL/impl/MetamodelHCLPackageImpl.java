/**
 */
package metamodelHCL.impl;

import metamodelHCL.Cache;
import metamodelHCL.Component;
import metamodelHCL.Computer;
import metamodelHCL.Cores;
import metamodelHCL.Diagonal;
import metamodelHCL.Display;
import metamodelHCL.DisplayProperty;
import metamodelHCL.DisplayTypeEnum;
import metamodelHCL.MetamodelHCLFactory;
import metamodelHCL.MetamodelHCLPackage;
import metamodelHCL.Processing;
import metamodelHCL.ProcessingProperty;
import metamodelHCL.ReusedComponent;
import metamodelHCL.SingleStorage;
import metamodelHCL.SizeTypeEnum;
import metamodelHCL.Speed;
import metamodelHCL.Storage;
import metamodelHCL.StorageProperty;
import metamodelHCL.StorageTypeEnum;
import metamodelHCL.Type;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class MetamodelHCLPackageImpl extends EPackageImpl implements MetamodelHCLPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass componentEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass processingEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass storageEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass displayEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass reusedComponentEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass processingPropertyEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass storagePropertyEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass displayPropertyEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass coresEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass speedEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass cacheEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass l1EClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass l2EClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass l3EClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass singleStorageEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass diagonalEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass typeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass computerEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum sizeTypeEnumEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum storageTypeEnumEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum displayTypeEnumEEnum = null;

	/**
	 * Creates an instance of the model <b>Package</b>, registered with
	 * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
	 * package URI value.
	 * <p>Note: the correct way to create the package is via the static
	 * factory method {@link #init init()}, which also performs
	 * initialization of the package, or returns the registered package,
	 * if one already exists.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ecore.EPackage.Registry
	 * @see metamodelHCL.MetamodelHCLPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private MetamodelHCLPackageImpl() {
		super(eNS_URI, MetamodelHCLFactory.eINSTANCE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static boolean isInited = false;

	/**
	 * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
	 *
	 * <p>This method is used to initialize {@link MetamodelHCLPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static MetamodelHCLPackage init() {
		if (isInited)
			return (MetamodelHCLPackage) EPackage.Registry.INSTANCE.getEPackage(MetamodelHCLPackage.eNS_URI);

		// Obtain or create and register package
		Object registeredMetamodelHCLPackage = EPackage.Registry.INSTANCE.get(eNS_URI);
		MetamodelHCLPackageImpl theMetamodelHCLPackage = registeredMetamodelHCLPackage instanceof MetamodelHCLPackageImpl
				? (MetamodelHCLPackageImpl) registeredMetamodelHCLPackage
				: new MetamodelHCLPackageImpl();

		isInited = true;

		// Create package meta-data objects
		theMetamodelHCLPackage.createPackageContents();

		// Initialize created meta-data
		theMetamodelHCLPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theMetamodelHCLPackage.freeze();

		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(MetamodelHCLPackage.eNS_URI, theMetamodelHCLPackage);
		return theMetamodelHCLPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getComponent() {
		return componentEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getComponent_Label() {
		return (EAttribute) componentEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getProcessing() {
		return processingEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getProcessing_Processingproperty() {
		return (EReference) processingEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getStorage() {
		return storageEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getStorage_Storageproperty() {
		return (EReference) storageEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDisplay() {
		return displayEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDisplay_Displayproperty() {
		return (EReference) displayEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getReusedComponent() {
		return reusedComponentEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getProcessingProperty() {
		return processingPropertyEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getStorageProperty() {
		return storagePropertyEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDisplayProperty() {
		return displayPropertyEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCores() {
		return coresEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCores_Number() {
		return (EAttribute) coresEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSpeed() {
		return speedEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSpeed_Speed() {
		return (EAttribute) speedEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCache() {
		return cacheEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getL1() {
		return l1EClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getL1_Number() {
		return (EAttribute) l1EClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getL1_Type() {
		return (EAttribute) l1EClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getL2() {
		return l2EClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getL2_Number() {
		return (EAttribute) l2EClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getL2_Type() {
		return (EAttribute) l2EClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getL3() {
		return l3EClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getL3_Number() {
		return (EAttribute) l3EClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getL3_Type() {
		return (EAttribute) l3EClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSingleStorage() {
		return singleStorageEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSingleStorage_Stype() {
		return (EAttribute) singleStorageEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSingleStorage_Ssize() {
		return (EAttribute) singleStorageEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDiagonal() {
		return diagonalEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDiagonal_Inch() {
		return (EAttribute) diagonalEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getType() {
		return typeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getType_Dtype() {
		return (EAttribute) typeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getComputer() {
		return computerEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getComputer_Label() {
		return (EAttribute) computerEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getComputer_Component() {
		return (EReference) computerEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getSizeTypeEnum() {
		return sizeTypeEnumEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getStorageTypeEnum() {
		return storageTypeEnumEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getDisplayTypeEnum() {
		return displayTypeEnumEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MetamodelHCLFactory getMetamodelHCLFactory() {
		return (MetamodelHCLFactory) getEFactoryInstance();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isCreated = false;

	/**
	 * Creates the meta-model objects for the package.  This method is
	 * guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void createPackageContents() {
		if (isCreated)
			return;
		isCreated = true;

		// Create classes and their features
		componentEClass = createEClass(COMPONENT);
		createEAttribute(componentEClass, COMPONENT__LABEL);

		processingEClass = createEClass(PROCESSING);
		createEReference(processingEClass, PROCESSING__PROCESSINGPROPERTY);

		storageEClass = createEClass(STORAGE);
		createEReference(storageEClass, STORAGE__STORAGEPROPERTY);

		displayEClass = createEClass(DISPLAY);
		createEReference(displayEClass, DISPLAY__DISPLAYPROPERTY);

		reusedComponentEClass = createEClass(REUSED_COMPONENT);

		processingPropertyEClass = createEClass(PROCESSING_PROPERTY);

		storagePropertyEClass = createEClass(STORAGE_PROPERTY);

		displayPropertyEClass = createEClass(DISPLAY_PROPERTY);

		coresEClass = createEClass(CORES);
		createEAttribute(coresEClass, CORES__NUMBER);

		speedEClass = createEClass(SPEED);
		createEAttribute(speedEClass, SPEED__SPEED);

		cacheEClass = createEClass(CACHE);

		l1EClass = createEClass(L1);
		createEAttribute(l1EClass, L1__NUMBER);
		createEAttribute(l1EClass, L1__TYPE);

		l2EClass = createEClass(L2);
		createEAttribute(l2EClass, L2__NUMBER);
		createEAttribute(l2EClass, L2__TYPE);

		l3EClass = createEClass(L3);
		createEAttribute(l3EClass, L3__NUMBER);
		createEAttribute(l3EClass, L3__TYPE);

		singleStorageEClass = createEClass(SINGLE_STORAGE);
		createEAttribute(singleStorageEClass, SINGLE_STORAGE__STYPE);
		createEAttribute(singleStorageEClass, SINGLE_STORAGE__SSIZE);

		diagonalEClass = createEClass(DIAGONAL);
		createEAttribute(diagonalEClass, DIAGONAL__INCH);

		typeEClass = createEClass(TYPE);
		createEAttribute(typeEClass, TYPE__DTYPE);

		computerEClass = createEClass(COMPUTER);
		createEAttribute(computerEClass, COMPUTER__LABEL);
		createEReference(computerEClass, COMPUTER__COMPONENT);

		// Create enums
		sizeTypeEnumEEnum = createEEnum(SIZE_TYPE_ENUM);
		storageTypeEnumEEnum = createEEnum(STORAGE_TYPE_ENUM);
		displayTypeEnumEEnum = createEEnum(DISPLAY_TYPE_ENUM);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isInitialized = false;

	/**
	 * Complete the initialization of the package and its meta-model.  This
	 * method is guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void initializePackageContents() {
		if (isInitialized)
			return;
		isInitialized = true;

		// Initialize package
		setName(eNAME);
		setNsPrefix(eNS_PREFIX);
		setNsURI(eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		processingEClass.getESuperTypes().add(this.getComponent());
		storageEClass.getESuperTypes().add(this.getComponent());
		displayEClass.getESuperTypes().add(this.getComponent());
		reusedComponentEClass.getESuperTypes().add(this.getComponent());
		coresEClass.getESuperTypes().add(this.getProcessingProperty());
		speedEClass.getESuperTypes().add(this.getProcessingProperty());
		cacheEClass.getESuperTypes().add(this.getProcessingProperty());
		l1EClass.getESuperTypes().add(this.getCache());
		l2EClass.getESuperTypes().add(this.getCache());
		l3EClass.getESuperTypes().add(this.getCache());
		singleStorageEClass.getESuperTypes().add(this.getStorageProperty());
		diagonalEClass.getESuperTypes().add(this.getDisplayProperty());
		typeEClass.getESuperTypes().add(this.getDisplayProperty());

		// Initialize classes, features, and operations; add parameters
		initEClass(componentEClass, Component.class, "Component", IS_ABSTRACT, !IS_INTERFACE,
				IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getComponent_Label(), ecorePackage.getEString(), "label", null, 1, 1, Component.class,
				!IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(processingEClass, Processing.class, "Processing", !IS_ABSTRACT, !IS_INTERFACE,
				IS_GENERATED_INSTANCE_CLASS);
		initEReference(getProcessing_Processingproperty(), this.getProcessingProperty(), null, "processingproperty",
				null, 5, 5, Processing.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE,
				!IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(storageEClass, Storage.class, "Storage", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getStorage_Storageproperty(), this.getStorageProperty(), null, "storageproperty", null, 1, 1,
				Storage.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES,
				!IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(displayEClass, Display.class, "Display", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getDisplay_Displayproperty(), this.getDisplayProperty(), null, "displayproperty", null, 2, 2,
				Display.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES,
				!IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(reusedComponentEClass, ReusedComponent.class, "ReusedComponent", !IS_ABSTRACT, !IS_INTERFACE,
				IS_GENERATED_INSTANCE_CLASS);

		initEClass(processingPropertyEClass, ProcessingProperty.class, "ProcessingProperty", IS_ABSTRACT, !IS_INTERFACE,
				IS_GENERATED_INSTANCE_CLASS);

		initEClass(storagePropertyEClass, StorageProperty.class, "StorageProperty", IS_ABSTRACT, !IS_INTERFACE,
				IS_GENERATED_INSTANCE_CLASS);

		initEClass(displayPropertyEClass, DisplayProperty.class, "DisplayProperty", IS_ABSTRACT, !IS_INTERFACE,
				IS_GENERATED_INSTANCE_CLASS);

		initEClass(coresEClass, Cores.class, "Cores", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getCores_Number(), ecorePackage.getEInt(), "number", null, 1, 1, Cores.class, !IS_TRANSIENT,
				!IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(speedEClass, Speed.class, "Speed", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getSpeed_Speed(), ecorePackage.getEDouble(), "speed", null, 1, 1, Speed.class, !IS_TRANSIENT,
				!IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(cacheEClass, Cache.class, "Cache", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(l1EClass, metamodelHCL.L1.class, "L1", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getL1_Number(), ecorePackage.getEInt(), "number", null, 0, 1, metamodelHCL.L1.class,
				!IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getL1_Type(), this.getSizeTypeEnum(), "type", null, 0, 1, metamodelHCL.L1.class, !IS_TRANSIENT,
				!IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(l2EClass, metamodelHCL.L2.class, "L2", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getL2_Number(), ecorePackage.getEInt(), "number", null, 0, 1, metamodelHCL.L2.class,
				!IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getL2_Type(), this.getSizeTypeEnum(), "type", "MiB", 0, 1, metamodelHCL.L2.class, !IS_TRANSIENT,
				!IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(l3EClass, metamodelHCL.L3.class, "L3", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getL3_Number(), ecorePackage.getEInt(), "number", null, 0, 1, metamodelHCL.L3.class,
				!IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getL3_Type(), this.getSizeTypeEnum(), "type", "MiB", 0, 1, metamodelHCL.L3.class, !IS_TRANSIENT,
				!IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(singleStorageEClass, SingleStorage.class, "SingleStorage", !IS_ABSTRACT, !IS_INTERFACE,
				IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getSingleStorage_Stype(), this.getStorageTypeEnum(), "stype", null, 1, 1, SingleStorage.class,
				!IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSingleStorage_Ssize(), this.getSizeTypeEnum(), "ssize", "GiB", 1, 1, SingleStorage.class,
				!IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(diagonalEClass, Diagonal.class, "Diagonal", !IS_ABSTRACT, !IS_INTERFACE,
				IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getDiagonal_Inch(), ecorePackage.getEInt(), "inch", null, 1, 1, Diagonal.class, !IS_TRANSIENT,
				!IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(typeEClass, Type.class, "Type", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getType_Dtype(), this.getDisplayTypeEnum(), "dtype", "FiveK", 1, 1, Type.class, !IS_TRANSIENT,
				!IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(computerEClass, Computer.class, "Computer", !IS_ABSTRACT, !IS_INTERFACE,
				IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getComputer_Label(), ecorePackage.getEString(), "label", null, 1, 1, Computer.class,
				!IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getComputer_Component(), this.getComponent(), null, "component", null, 0, -1, Computer.class,
				!IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE,
				IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Initialize enums and add enum literals
		initEEnum(sizeTypeEnumEEnum, SizeTypeEnum.class, "SizeTypeEnum");
		addEEnumLiteral(sizeTypeEnumEEnum, SizeTypeEnum.KI_B);
		addEEnumLiteral(sizeTypeEnumEEnum, SizeTypeEnum.MI_B);
		addEEnumLiteral(sizeTypeEnumEEnum, SizeTypeEnum.GI_B);

		initEEnum(storageTypeEnumEEnum, StorageTypeEnum.class, "StorageTypeEnum");
		addEEnumLiteral(storageTypeEnumEEnum, StorageTypeEnum.HDD);
		addEEnumLiteral(storageTypeEnumEEnum, StorageTypeEnum.SSD);

		initEEnum(displayTypeEnumEEnum, DisplayTypeEnum.class, "DisplayTypeEnum");
		addEEnumLiteral(displayTypeEnumEEnum, DisplayTypeEnum.FOUR_K);
		addEEnumLiteral(displayTypeEnumEEnum, DisplayTypeEnum.FIVE_K);
		addEEnumLiteral(displayTypeEnumEEnum, DisplayTypeEnum.HD);
		addEEnumLiteral(displayTypeEnumEEnum, DisplayTypeEnum.FULL_HD);

		// Create resource
		createResource(eNS_URI);
	}

} //MetamodelHCLPackageImpl
