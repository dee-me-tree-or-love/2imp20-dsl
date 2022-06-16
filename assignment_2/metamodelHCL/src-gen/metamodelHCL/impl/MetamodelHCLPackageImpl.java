/**
 */
package metamodelHCL.impl;

import metamodelHCL.CacheProperty;
import metamodelHCL.Component;
import metamodelHCL.Computer;
import metamodelHCL.CoresProperty;
import metamodelHCL.DiagonalProperty;
import metamodelHCL.Display;
import metamodelHCL.DisplayProperty;
import metamodelHCL.L1CacheProperty;
import metamodelHCL.L2CacheProperty;
import metamodelHCL.L3CacheProperty;
import metamodelHCL.MetamodelHCLFactory;
import metamodelHCL.MetamodelHCLPackage;
import metamodelHCL.Model;
import metamodelHCL.Processing;
import metamodelHCL.ProcessingProperty;
import metamodelHCL.ResolutionProperty;
import metamodelHCL.ReusedComponent;
import metamodelHCL.SingleStorage;
import metamodelHCL.SpeedProperty;
import metamodelHCL.Storage;
import metamodelHCL.StorageProperty;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
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
	private EClass l1CachePropertyEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass l2CachePropertyEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass l3CachePropertyEClass = null;

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
	private EClass diagonalPropertyEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass resolutionPropertyEClass = null;

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
	private EClass modelEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass coresPropertyEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass speedPropertyEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass cachePropertyEClass = null;

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
	public EReference getComponent_Computer() {
		return (EReference) componentEClass.getEStructuralFeatures().get(1);
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
	public EReference getProcessing_Properties() {
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
	public EReference getStorage_Properties() {
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
	public EReference getDisplay_Properties() {
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
	public EReference getProcessingProperty_Processing() {
		return (EReference) processingPropertyEClass.getEStructuralFeatures().get(0);
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
	public EReference getStorageProperty_Storage() {
		return (EReference) storagePropertyEClass.getEStructuralFeatures().get(0);
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
	public EReference getDisplayProperty_Display() {
		return (EReference) displayPropertyEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getL1CacheProperty() {
		return l1CachePropertyEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getL2CacheProperty() {
		return l2CachePropertyEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getL3CacheProperty() {
		return l3CachePropertyEClass;
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
	public EAttribute getSingleStorage_Unit() {
		return (EAttribute) singleStorageEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSingleStorage_Size() {
		return (EAttribute) singleStorageEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDiagonalProperty() {
		return diagonalPropertyEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDiagonalProperty_Size() {
		return (EAttribute) diagonalPropertyEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDiagonalProperty_Unit() {
		return (EAttribute) diagonalPropertyEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getResolutionProperty() {
		return resolutionPropertyEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getResolutionProperty_Type() {
		return (EAttribute) resolutionPropertyEClass.getEStructuralFeatures().get(0);
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
	public EReference getComputer_Components() {
		return (EReference) computerEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getModel() {
		return modelEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getModel_Computers() {
		return (EReference) modelEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCoresProperty() {
		return coresPropertyEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCoresProperty_Number() {
		return (EAttribute) coresPropertyEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSpeedProperty() {
		return speedPropertyEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSpeedProperty_Speed() {
		return (EAttribute) speedPropertyEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSpeedProperty_Unit() {
		return (EAttribute) speedPropertyEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCacheProperty() {
		return cachePropertyEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCacheProperty_Size() {
		return (EAttribute) cachePropertyEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCacheProperty_Unit() {
		return (EAttribute) cachePropertyEClass.getEStructuralFeatures().get(1);
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
		createEReference(componentEClass, COMPONENT__COMPUTER);

		processingEClass = createEClass(PROCESSING);
		createEReference(processingEClass, PROCESSING__PROPERTIES);

		storageEClass = createEClass(STORAGE);
		createEReference(storageEClass, STORAGE__PROPERTIES);

		displayEClass = createEClass(DISPLAY);
		createEReference(displayEClass, DISPLAY__PROPERTIES);

		reusedComponentEClass = createEClass(REUSED_COMPONENT);

		processingPropertyEClass = createEClass(PROCESSING_PROPERTY);
		createEReference(processingPropertyEClass, PROCESSING_PROPERTY__PROCESSING);

		storagePropertyEClass = createEClass(STORAGE_PROPERTY);
		createEReference(storagePropertyEClass, STORAGE_PROPERTY__STORAGE);

		displayPropertyEClass = createEClass(DISPLAY_PROPERTY);
		createEReference(displayPropertyEClass, DISPLAY_PROPERTY__DISPLAY);

		l1CachePropertyEClass = createEClass(L1_CACHE_PROPERTY);

		l2CachePropertyEClass = createEClass(L2_CACHE_PROPERTY);

		l3CachePropertyEClass = createEClass(L3_CACHE_PROPERTY);

		singleStorageEClass = createEClass(SINGLE_STORAGE);
		createEAttribute(singleStorageEClass, SINGLE_STORAGE__UNIT);
		createEAttribute(singleStorageEClass, SINGLE_STORAGE__SIZE);

		diagonalPropertyEClass = createEClass(DIAGONAL_PROPERTY);
		createEAttribute(diagonalPropertyEClass, DIAGONAL_PROPERTY__SIZE);
		createEAttribute(diagonalPropertyEClass, DIAGONAL_PROPERTY__UNIT);

		resolutionPropertyEClass = createEClass(RESOLUTION_PROPERTY);
		createEAttribute(resolutionPropertyEClass, RESOLUTION_PROPERTY__TYPE);

		computerEClass = createEClass(COMPUTER);
		createEAttribute(computerEClass, COMPUTER__LABEL);
		createEReference(computerEClass, COMPUTER__COMPONENTS);

		modelEClass = createEClass(MODEL);
		createEReference(modelEClass, MODEL__COMPUTERS);

		coresPropertyEClass = createEClass(CORES_PROPERTY);
		createEAttribute(coresPropertyEClass, CORES_PROPERTY__NUMBER);

		speedPropertyEClass = createEClass(SPEED_PROPERTY);
		createEAttribute(speedPropertyEClass, SPEED_PROPERTY__SPEED);
		createEAttribute(speedPropertyEClass, SPEED_PROPERTY__UNIT);

		cachePropertyEClass = createEClass(CACHE_PROPERTY);
		createEAttribute(cachePropertyEClass, CACHE_PROPERTY__SIZE);
		createEAttribute(cachePropertyEClass, CACHE_PROPERTY__UNIT);
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
		l1CachePropertyEClass.getESuperTypes().add(this.getCacheProperty());
		l2CachePropertyEClass.getESuperTypes().add(this.getCacheProperty());
		l3CachePropertyEClass.getESuperTypes().add(this.getCacheProperty());
		singleStorageEClass.getESuperTypes().add(this.getStorageProperty());
		diagonalPropertyEClass.getESuperTypes().add(this.getDisplayProperty());
		resolutionPropertyEClass.getESuperTypes().add(this.getDisplayProperty());
		coresPropertyEClass.getESuperTypes().add(this.getProcessingProperty());
		speedPropertyEClass.getESuperTypes().add(this.getProcessingProperty());
		cachePropertyEClass.getESuperTypes().add(this.getProcessingProperty());

		// Initialize classes, features, and operations; add parameters
		initEClass(componentEClass, Component.class, "Component", IS_ABSTRACT, !IS_INTERFACE,
				IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getComponent_Label(), ecorePackage.getEString(), "label", null, 1, 1, Component.class,
				!IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getComponent_Computer(), this.getComputer(), null, "computer", null, 0, 1, Component.class,
				!IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE,
				IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(processingEClass, Processing.class, "Processing", !IS_ABSTRACT, !IS_INTERFACE,
				IS_GENERATED_INSTANCE_CLASS);
		initEReference(getProcessing_Properties(), this.getProcessingProperty(), null, "properties", null, 0, 5,
				Processing.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES,
				!IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(storageEClass, Storage.class, "Storage", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getStorage_Properties(), this.getStorageProperty(), null, "properties", null, 0, 1,
				Storage.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES,
				!IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(displayEClass, Display.class, "Display", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getDisplay_Properties(), this.getDisplayProperty(), null, "properties", null, 0, 2,
				Display.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES,
				!IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(reusedComponentEClass, ReusedComponent.class, "ReusedComponent", !IS_ABSTRACT, !IS_INTERFACE,
				IS_GENERATED_INSTANCE_CLASS);

		initEClass(processingPropertyEClass, ProcessingProperty.class, "ProcessingProperty", IS_ABSTRACT, !IS_INTERFACE,
				IS_GENERATED_INSTANCE_CLASS);
		initEReference(getProcessingProperty_Processing(), this.getProcessing(), null, "processing", null, 0, 1,
				ProcessingProperty.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES,
				!IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(storagePropertyEClass, StorageProperty.class, "StorageProperty", IS_ABSTRACT, !IS_INTERFACE,
				IS_GENERATED_INSTANCE_CLASS);
		initEReference(getStorageProperty_Storage(), this.getStorage(), null, "storage", null, 0, 1,
				StorageProperty.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES,
				!IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(displayPropertyEClass, DisplayProperty.class, "DisplayProperty", IS_ABSTRACT, !IS_INTERFACE,
				IS_GENERATED_INSTANCE_CLASS);
		initEReference(getDisplayProperty_Display(), this.getDisplay(), null, "display", null, 0, 1,
				DisplayProperty.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES,
				!IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(l1CachePropertyEClass, L1CacheProperty.class, "L1CacheProperty", !IS_ABSTRACT, !IS_INTERFACE,
				IS_GENERATED_INSTANCE_CLASS);

		initEClass(l2CachePropertyEClass, L2CacheProperty.class, "L2CacheProperty", !IS_ABSTRACT, !IS_INTERFACE,
				IS_GENERATED_INSTANCE_CLASS);

		initEClass(l3CachePropertyEClass, L3CacheProperty.class, "L3CacheProperty", !IS_ABSTRACT, !IS_INTERFACE,
				IS_GENERATED_INSTANCE_CLASS);

		initEClass(singleStorageEClass, SingleStorage.class, "SingleStorage", !IS_ABSTRACT, !IS_INTERFACE,
				IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getSingleStorage_Unit(), ecorePackage.getEString(), "unit", null, 1, 1, SingleStorage.class,
				!IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSingleStorage_Size(), ecorePackage.getEInt(), "size", "0", 1, 1, SingleStorage.class,
				!IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(diagonalPropertyEClass, DiagonalProperty.class, "DiagonalProperty", !IS_ABSTRACT, !IS_INTERFACE,
				IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getDiagonalProperty_Size(), ecorePackage.getEInt(), "size", null, 1, 1, DiagonalProperty.class,
				!IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getDiagonalProperty_Unit(), ecorePackage.getEString(), "unit", null, 1, 1,
				DiagonalProperty.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE,
				!IS_DERIVED, IS_ORDERED);

		initEClass(resolutionPropertyEClass, ResolutionProperty.class, "ResolutionProperty", !IS_ABSTRACT,
				!IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getResolutionProperty_Type(), ecorePackage.getEString(), "type", "", 1, 1,
				ResolutionProperty.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE,
				!IS_DERIVED, IS_ORDERED);

		initEClass(computerEClass, Computer.class, "Computer", !IS_ABSTRACT, !IS_INTERFACE,
				IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getComputer_Label(), ecorePackage.getEString(), "label", null, 1, 1, Computer.class,
				!IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getComputer_Components(), this.getComponent(), null, "components", null, 0, -1, Computer.class,
				!IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE,
				IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(modelEClass, Model.class, "Model", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getModel_Computers(), this.getComputer(), null, "computers", null, 0, -1, Model.class,
				!IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE,
				IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(coresPropertyEClass, CoresProperty.class, "CoresProperty", !IS_ABSTRACT, !IS_INTERFACE,
				IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getCoresProperty_Number(), ecorePackage.getEInt(), "number", null, 1, 1, CoresProperty.class,
				!IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(speedPropertyEClass, SpeedProperty.class, "SpeedProperty", !IS_ABSTRACT, !IS_INTERFACE,
				IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getSpeedProperty_Speed(), ecorePackage.getEFloat(), "speed", null, 1, 1, SpeedProperty.class,
				!IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSpeedProperty_Unit(), ecorePackage.getEString(), "unit", null, 1, 1, SpeedProperty.class,
				!IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(cachePropertyEClass, CacheProperty.class, "CacheProperty", IS_ABSTRACT, !IS_INTERFACE,
				IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getCacheProperty_Size(), ecorePackage.getEInt(), "size", null, 1, 1, CacheProperty.class,
				!IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getCacheProperty_Unit(), ecorePackage.getEString(), "unit", null, 1, 1, CacheProperty.class,
				!IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Create resource
		createResource(eNS_URI);
	}

} //MetamodelHCLPackageImpl
