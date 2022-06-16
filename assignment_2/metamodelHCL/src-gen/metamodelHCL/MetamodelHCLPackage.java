/**
 */
package metamodelHCL;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each operation of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see metamodelHCL.MetamodelHCLFactory
 * @model kind="package"
 * @generated
 */
public interface MetamodelHCLPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "metamodelHCL";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.example.org/metamodelHCL";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "metamodelHCL";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	MetamodelHCLPackage eINSTANCE = metamodelHCL.impl.MetamodelHCLPackageImpl.init();

	/**
	 * The meta object id for the '{@link metamodelHCL.impl.ComponentImpl <em>Component</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see metamodelHCL.impl.ComponentImpl
	 * @see metamodelHCL.impl.MetamodelHCLPackageImpl#getComponent()
	 * @generated
	 */
	int COMPONENT = 0;

	/**
	 * The feature id for the '<em><b>Label</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT__LABEL = 0;

	/**
	 * The feature id for the '<em><b>Computer</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT__COMPUTER = 1;

	/**
	 * The number of structural features of the '<em>Component</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>Component</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link metamodelHCL.impl.ProcessingImpl <em>Processing</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see metamodelHCL.impl.ProcessingImpl
	 * @see metamodelHCL.impl.MetamodelHCLPackageImpl#getProcessing()
	 * @generated
	 */
	int PROCESSING = 1;

	/**
	 * The feature id for the '<em><b>Label</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROCESSING__LABEL = COMPONENT__LABEL;

	/**
	 * The feature id for the '<em><b>Computer</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROCESSING__COMPUTER = COMPONENT__COMPUTER;

	/**
	 * The feature id for the '<em><b>Properties</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROCESSING__PROPERTIES = COMPONENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Processing</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROCESSING_FEATURE_COUNT = COMPONENT_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Processing</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROCESSING_OPERATION_COUNT = COMPONENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link metamodelHCL.impl.StorageImpl <em>Storage</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see metamodelHCL.impl.StorageImpl
	 * @see metamodelHCL.impl.MetamodelHCLPackageImpl#getStorage()
	 * @generated
	 */
	int STORAGE = 2;

	/**
	 * The feature id for the '<em><b>Label</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STORAGE__LABEL = COMPONENT__LABEL;

	/**
	 * The feature id for the '<em><b>Computer</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STORAGE__COMPUTER = COMPONENT__COMPUTER;

	/**
	 * The feature id for the '<em><b>Properties</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STORAGE__PROPERTIES = COMPONENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Storage</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STORAGE_FEATURE_COUNT = COMPONENT_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Storage</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STORAGE_OPERATION_COUNT = COMPONENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link metamodelHCL.impl.DisplayImpl <em>Display</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see metamodelHCL.impl.DisplayImpl
	 * @see metamodelHCL.impl.MetamodelHCLPackageImpl#getDisplay()
	 * @generated
	 */
	int DISPLAY = 3;

	/**
	 * The feature id for the '<em><b>Label</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DISPLAY__LABEL = COMPONENT__LABEL;

	/**
	 * The feature id for the '<em><b>Computer</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DISPLAY__COMPUTER = COMPONENT__COMPUTER;

	/**
	 * The feature id for the '<em><b>Properties</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DISPLAY__PROPERTIES = COMPONENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Display</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DISPLAY_FEATURE_COUNT = COMPONENT_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Display</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DISPLAY_OPERATION_COUNT = COMPONENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link metamodelHCL.impl.ReusedComponentImpl <em>Reused Component</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see metamodelHCL.impl.ReusedComponentImpl
	 * @see metamodelHCL.impl.MetamodelHCLPackageImpl#getReusedComponent()
	 * @generated
	 */
	int REUSED_COMPONENT = 4;

	/**
	 * The feature id for the '<em><b>Label</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REUSED_COMPONENT__LABEL = COMPONENT__LABEL;

	/**
	 * The feature id for the '<em><b>Computer</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REUSED_COMPONENT__COMPUTER = COMPONENT__COMPUTER;

	/**
	 * The number of structural features of the '<em>Reused Component</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REUSED_COMPONENT_FEATURE_COUNT = COMPONENT_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Reused Component</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REUSED_COMPONENT_OPERATION_COUNT = COMPONENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link metamodelHCL.impl.ProcessingPropertyImpl <em>Processing Property</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see metamodelHCL.impl.ProcessingPropertyImpl
	 * @see metamodelHCL.impl.MetamodelHCLPackageImpl#getProcessingProperty()
	 * @generated
	 */
	int PROCESSING_PROPERTY = 5;

	/**
	 * The feature id for the '<em><b>Processing</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROCESSING_PROPERTY__PROCESSING = 0;

	/**
	 * The number of structural features of the '<em>Processing Property</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROCESSING_PROPERTY_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>Processing Property</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROCESSING_PROPERTY_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link metamodelHCL.impl.StoragePropertyImpl <em>Storage Property</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see metamodelHCL.impl.StoragePropertyImpl
	 * @see metamodelHCL.impl.MetamodelHCLPackageImpl#getStorageProperty()
	 * @generated
	 */
	int STORAGE_PROPERTY = 6;

	/**
	 * The feature id for the '<em><b>Storage</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STORAGE_PROPERTY__STORAGE = 0;

	/**
	 * The number of structural features of the '<em>Storage Property</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STORAGE_PROPERTY_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>Storage Property</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STORAGE_PROPERTY_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link metamodelHCL.impl.DisplayPropertyImpl <em>Display Property</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see metamodelHCL.impl.DisplayPropertyImpl
	 * @see metamodelHCL.impl.MetamodelHCLPackageImpl#getDisplayProperty()
	 * @generated
	 */
	int DISPLAY_PROPERTY = 7;

	/**
	 * The feature id for the '<em><b>Display</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DISPLAY_PROPERTY__DISPLAY = 0;

	/**
	 * The number of structural features of the '<em>Display Property</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DISPLAY_PROPERTY_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>Display Property</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DISPLAY_PROPERTY_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link metamodelHCL.impl.CachePropertyImpl <em>Cache Property</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see metamodelHCL.impl.CachePropertyImpl
	 * @see metamodelHCL.impl.MetamodelHCLPackageImpl#getCacheProperty()
	 * @generated
	 */
	int CACHE_PROPERTY = 18;

	/**
	 * The feature id for the '<em><b>Processing</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CACHE_PROPERTY__PROCESSING = PROCESSING_PROPERTY__PROCESSING;

	/**
	 * The feature id for the '<em><b>Size</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CACHE_PROPERTY__SIZE = PROCESSING_PROPERTY_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Unit</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CACHE_PROPERTY__UNIT = PROCESSING_PROPERTY_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Cache Property</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CACHE_PROPERTY_FEATURE_COUNT = PROCESSING_PROPERTY_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Cache Property</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CACHE_PROPERTY_OPERATION_COUNT = PROCESSING_PROPERTY_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link metamodelHCL.impl.L1CachePropertyImpl <em>L1 Cache Property</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see metamodelHCL.impl.L1CachePropertyImpl
	 * @see metamodelHCL.impl.MetamodelHCLPackageImpl#getL1CacheProperty()
	 * @generated
	 */
	int L1_CACHE_PROPERTY = 8;

	/**
	 * The feature id for the '<em><b>Processing</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int L1_CACHE_PROPERTY__PROCESSING = CACHE_PROPERTY__PROCESSING;

	/**
	 * The feature id for the '<em><b>Size</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int L1_CACHE_PROPERTY__SIZE = CACHE_PROPERTY__SIZE;

	/**
	 * The feature id for the '<em><b>Unit</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int L1_CACHE_PROPERTY__UNIT = CACHE_PROPERTY__UNIT;

	/**
	 * The number of structural features of the '<em>L1 Cache Property</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int L1_CACHE_PROPERTY_FEATURE_COUNT = CACHE_PROPERTY_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>L1 Cache Property</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int L1_CACHE_PROPERTY_OPERATION_COUNT = CACHE_PROPERTY_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link metamodelHCL.impl.L2CachePropertyImpl <em>L2 Cache Property</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see metamodelHCL.impl.L2CachePropertyImpl
	 * @see metamodelHCL.impl.MetamodelHCLPackageImpl#getL2CacheProperty()
	 * @generated
	 */
	int L2_CACHE_PROPERTY = 9;

	/**
	 * The feature id for the '<em><b>Processing</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int L2_CACHE_PROPERTY__PROCESSING = CACHE_PROPERTY__PROCESSING;

	/**
	 * The feature id for the '<em><b>Size</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int L2_CACHE_PROPERTY__SIZE = CACHE_PROPERTY__SIZE;

	/**
	 * The feature id for the '<em><b>Unit</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int L2_CACHE_PROPERTY__UNIT = CACHE_PROPERTY__UNIT;

	/**
	 * The number of structural features of the '<em>L2 Cache Property</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int L2_CACHE_PROPERTY_FEATURE_COUNT = CACHE_PROPERTY_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>L2 Cache Property</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int L2_CACHE_PROPERTY_OPERATION_COUNT = CACHE_PROPERTY_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link metamodelHCL.impl.L3CachePropertyImpl <em>L3 Cache Property</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see metamodelHCL.impl.L3CachePropertyImpl
	 * @see metamodelHCL.impl.MetamodelHCLPackageImpl#getL3CacheProperty()
	 * @generated
	 */
	int L3_CACHE_PROPERTY = 10;

	/**
	 * The feature id for the '<em><b>Processing</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int L3_CACHE_PROPERTY__PROCESSING = CACHE_PROPERTY__PROCESSING;

	/**
	 * The feature id for the '<em><b>Size</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int L3_CACHE_PROPERTY__SIZE = CACHE_PROPERTY__SIZE;

	/**
	 * The feature id for the '<em><b>Unit</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int L3_CACHE_PROPERTY__UNIT = CACHE_PROPERTY__UNIT;

	/**
	 * The number of structural features of the '<em>L3 Cache Property</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int L3_CACHE_PROPERTY_FEATURE_COUNT = CACHE_PROPERTY_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>L3 Cache Property</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int L3_CACHE_PROPERTY_OPERATION_COUNT = CACHE_PROPERTY_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link metamodelHCL.impl.SingleStorageImpl <em>Single Storage</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see metamodelHCL.impl.SingleStorageImpl
	 * @see metamodelHCL.impl.MetamodelHCLPackageImpl#getSingleStorage()
	 * @generated
	 */
	int SINGLE_STORAGE = 11;

	/**
	 * The feature id for the '<em><b>Storage</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SINGLE_STORAGE__STORAGE = STORAGE_PROPERTY__STORAGE;

	/**
	 * The feature id for the '<em><b>Unit</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SINGLE_STORAGE__UNIT = STORAGE_PROPERTY_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Size</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SINGLE_STORAGE__SIZE = STORAGE_PROPERTY_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Single Storage</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SINGLE_STORAGE_FEATURE_COUNT = STORAGE_PROPERTY_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Single Storage</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SINGLE_STORAGE_OPERATION_COUNT = STORAGE_PROPERTY_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link metamodelHCL.impl.DiagonalPropertyImpl <em>Diagonal Property</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see metamodelHCL.impl.DiagonalPropertyImpl
	 * @see metamodelHCL.impl.MetamodelHCLPackageImpl#getDiagonalProperty()
	 * @generated
	 */
	int DIAGONAL_PROPERTY = 12;

	/**
	 * The feature id for the '<em><b>Display</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIAGONAL_PROPERTY__DISPLAY = DISPLAY_PROPERTY__DISPLAY;

	/**
	 * The feature id for the '<em><b>Size</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIAGONAL_PROPERTY__SIZE = DISPLAY_PROPERTY_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Unit</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIAGONAL_PROPERTY__UNIT = DISPLAY_PROPERTY_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Diagonal Property</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIAGONAL_PROPERTY_FEATURE_COUNT = DISPLAY_PROPERTY_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Diagonal Property</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIAGONAL_PROPERTY_OPERATION_COUNT = DISPLAY_PROPERTY_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link metamodelHCL.impl.ResolutionPropertyImpl <em>Resolution Property</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see metamodelHCL.impl.ResolutionPropertyImpl
	 * @see metamodelHCL.impl.MetamodelHCLPackageImpl#getResolutionProperty()
	 * @generated
	 */
	int RESOLUTION_PROPERTY = 13;

	/**
	 * The feature id for the '<em><b>Display</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOLUTION_PROPERTY__DISPLAY = DISPLAY_PROPERTY__DISPLAY;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOLUTION_PROPERTY__TYPE = DISPLAY_PROPERTY_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Resolution Property</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOLUTION_PROPERTY_FEATURE_COUNT = DISPLAY_PROPERTY_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Resolution Property</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOLUTION_PROPERTY_OPERATION_COUNT = DISPLAY_PROPERTY_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link metamodelHCL.impl.ComputerImpl <em>Computer</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see metamodelHCL.impl.ComputerImpl
	 * @see metamodelHCL.impl.MetamodelHCLPackageImpl#getComputer()
	 * @generated
	 */
	int COMPUTER = 14;

	/**
	 * The feature id for the '<em><b>Label</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPUTER__LABEL = 0;

	/**
	 * The feature id for the '<em><b>Components</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPUTER__COMPONENTS = 1;

	/**
	 * The number of structural features of the '<em>Computer</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPUTER_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>Computer</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPUTER_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link metamodelHCL.impl.ModelImpl <em>Model</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see metamodelHCL.impl.ModelImpl
	 * @see metamodelHCL.impl.MetamodelHCLPackageImpl#getModel()
	 * @generated
	 */
	int MODEL = 15;

	/**
	 * The feature id for the '<em><b>Computers</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL__COMPUTERS = 0;

	/**
	 * The number of structural features of the '<em>Model</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>Model</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link metamodelHCL.impl.CoresPropertyImpl <em>Cores Property</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see metamodelHCL.impl.CoresPropertyImpl
	 * @see metamodelHCL.impl.MetamodelHCLPackageImpl#getCoresProperty()
	 * @generated
	 */
	int CORES_PROPERTY = 16;

	/**
	 * The feature id for the '<em><b>Processing</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CORES_PROPERTY__PROCESSING = PROCESSING_PROPERTY__PROCESSING;

	/**
	 * The feature id for the '<em><b>Number</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CORES_PROPERTY__NUMBER = PROCESSING_PROPERTY_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Cores Property</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CORES_PROPERTY_FEATURE_COUNT = PROCESSING_PROPERTY_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Cores Property</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CORES_PROPERTY_OPERATION_COUNT = PROCESSING_PROPERTY_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link metamodelHCL.impl.SpeedPropertyImpl <em>Speed Property</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see metamodelHCL.impl.SpeedPropertyImpl
	 * @see metamodelHCL.impl.MetamodelHCLPackageImpl#getSpeedProperty()
	 * @generated
	 */
	int SPEED_PROPERTY = 17;

	/**
	 * The feature id for the '<em><b>Processing</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPEED_PROPERTY__PROCESSING = PROCESSING_PROPERTY__PROCESSING;

	/**
	 * The feature id for the '<em><b>Speed</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPEED_PROPERTY__SPEED = PROCESSING_PROPERTY_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Unit</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPEED_PROPERTY__UNIT = PROCESSING_PROPERTY_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Speed Property</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPEED_PROPERTY_FEATURE_COUNT = PROCESSING_PROPERTY_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Speed Property</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPEED_PROPERTY_OPERATION_COUNT = PROCESSING_PROPERTY_OPERATION_COUNT + 0;

	/**
	 * Returns the meta object for class '{@link metamodelHCL.Component <em>Component</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Component</em>'.
	 * @see metamodelHCL.Component
	 * @generated
	 */
	EClass getComponent();

	/**
	 * Returns the meta object for the attribute '{@link metamodelHCL.Component#getLabel <em>Label</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Label</em>'.
	 * @see metamodelHCL.Component#getLabel()
	 * @see #getComponent()
	 * @generated
	 */
	EAttribute getComponent_Label();

	/**
	 * Returns the meta object for the reference '{@link metamodelHCL.Component#getComputer <em>Computer</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Computer</em>'.
	 * @see metamodelHCL.Component#getComputer()
	 * @see #getComponent()
	 * @generated
	 */
	EReference getComponent_Computer();

	/**
	 * Returns the meta object for class '{@link metamodelHCL.Processing <em>Processing</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Processing</em>'.
	 * @see metamodelHCL.Processing
	 * @generated
	 */
	EClass getProcessing();

	/**
	 * Returns the meta object for the containment reference list '{@link metamodelHCL.Processing#getProperties <em>Properties</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Properties</em>'.
	 * @see metamodelHCL.Processing#getProperties()
	 * @see #getProcessing()
	 * @generated
	 */
	EReference getProcessing_Properties();

	/**
	 * Returns the meta object for class '{@link metamodelHCL.Storage <em>Storage</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Storage</em>'.
	 * @see metamodelHCL.Storage
	 * @generated
	 */
	EClass getStorage();

	/**
	 * Returns the meta object for the containment reference '{@link metamodelHCL.Storage#getProperties <em>Properties</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Properties</em>'.
	 * @see metamodelHCL.Storage#getProperties()
	 * @see #getStorage()
	 * @generated
	 */
	EReference getStorage_Properties();

	/**
	 * Returns the meta object for class '{@link metamodelHCL.Display <em>Display</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Display</em>'.
	 * @see metamodelHCL.Display
	 * @generated
	 */
	EClass getDisplay();

	/**
	 * Returns the meta object for the containment reference list '{@link metamodelHCL.Display#getProperties <em>Properties</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Properties</em>'.
	 * @see metamodelHCL.Display#getProperties()
	 * @see #getDisplay()
	 * @generated
	 */
	EReference getDisplay_Properties();

	/**
	 * Returns the meta object for class '{@link metamodelHCL.ReusedComponent <em>Reused Component</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Reused Component</em>'.
	 * @see metamodelHCL.ReusedComponent
	 * @generated
	 */
	EClass getReusedComponent();

	/**
	 * Returns the meta object for class '{@link metamodelHCL.ProcessingProperty <em>Processing Property</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Processing Property</em>'.
	 * @see metamodelHCL.ProcessingProperty
	 * @generated
	 */
	EClass getProcessingProperty();

	/**
	 * Returns the meta object for the reference '{@link metamodelHCL.ProcessingProperty#getProcessing <em>Processing</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Processing</em>'.
	 * @see metamodelHCL.ProcessingProperty#getProcessing()
	 * @see #getProcessingProperty()
	 * @generated
	 */
	EReference getProcessingProperty_Processing();

	/**
	 * Returns the meta object for class '{@link metamodelHCL.StorageProperty <em>Storage Property</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Storage Property</em>'.
	 * @see metamodelHCL.StorageProperty
	 * @generated
	 */
	EClass getStorageProperty();

	/**
	 * Returns the meta object for the reference '{@link metamodelHCL.StorageProperty#getStorage <em>Storage</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Storage</em>'.
	 * @see metamodelHCL.StorageProperty#getStorage()
	 * @see #getStorageProperty()
	 * @generated
	 */
	EReference getStorageProperty_Storage();

	/**
	 * Returns the meta object for class '{@link metamodelHCL.DisplayProperty <em>Display Property</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Display Property</em>'.
	 * @see metamodelHCL.DisplayProperty
	 * @generated
	 */
	EClass getDisplayProperty();

	/**
	 * Returns the meta object for the reference '{@link metamodelHCL.DisplayProperty#getDisplay <em>Display</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Display</em>'.
	 * @see metamodelHCL.DisplayProperty#getDisplay()
	 * @see #getDisplayProperty()
	 * @generated
	 */
	EReference getDisplayProperty_Display();

	/**
	 * Returns the meta object for class '{@link metamodelHCL.L1CacheProperty <em>L1 Cache Property</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>L1 Cache Property</em>'.
	 * @see metamodelHCL.L1CacheProperty
	 * @generated
	 */
	EClass getL1CacheProperty();

	/**
	 * Returns the meta object for class '{@link metamodelHCL.L2CacheProperty <em>L2 Cache Property</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>L2 Cache Property</em>'.
	 * @see metamodelHCL.L2CacheProperty
	 * @generated
	 */
	EClass getL2CacheProperty();

	/**
	 * Returns the meta object for class '{@link metamodelHCL.L3CacheProperty <em>L3 Cache Property</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>L3 Cache Property</em>'.
	 * @see metamodelHCL.L3CacheProperty
	 * @generated
	 */
	EClass getL3CacheProperty();

	/**
	 * Returns the meta object for class '{@link metamodelHCL.SingleStorage <em>Single Storage</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Single Storage</em>'.
	 * @see metamodelHCL.SingleStorage
	 * @generated
	 */
	EClass getSingleStorage();

	/**
	 * Returns the meta object for the attribute '{@link metamodelHCL.SingleStorage#getUnit <em>Unit</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Unit</em>'.
	 * @see metamodelHCL.SingleStorage#getUnit()
	 * @see #getSingleStorage()
	 * @generated
	 */
	EAttribute getSingleStorage_Unit();

	/**
	 * Returns the meta object for the attribute '{@link metamodelHCL.SingleStorage#getSize <em>Size</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Size</em>'.
	 * @see metamodelHCL.SingleStorage#getSize()
	 * @see #getSingleStorage()
	 * @generated
	 */
	EAttribute getSingleStorage_Size();

	/**
	 * Returns the meta object for class '{@link metamodelHCL.DiagonalProperty <em>Diagonal Property</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Diagonal Property</em>'.
	 * @see metamodelHCL.DiagonalProperty
	 * @generated
	 */
	EClass getDiagonalProperty();

	/**
	 * Returns the meta object for the attribute '{@link metamodelHCL.DiagonalProperty#getSize <em>Size</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Size</em>'.
	 * @see metamodelHCL.DiagonalProperty#getSize()
	 * @see #getDiagonalProperty()
	 * @generated
	 */
	EAttribute getDiagonalProperty_Size();

	/**
	 * Returns the meta object for the attribute '{@link metamodelHCL.DiagonalProperty#getUnit <em>Unit</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Unit</em>'.
	 * @see metamodelHCL.DiagonalProperty#getUnit()
	 * @see #getDiagonalProperty()
	 * @generated
	 */
	EAttribute getDiagonalProperty_Unit();

	/**
	 * Returns the meta object for class '{@link metamodelHCL.ResolutionProperty <em>Resolution Property</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Resolution Property</em>'.
	 * @see metamodelHCL.ResolutionProperty
	 * @generated
	 */
	EClass getResolutionProperty();

	/**
	 * Returns the meta object for the attribute '{@link metamodelHCL.ResolutionProperty#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Type</em>'.
	 * @see metamodelHCL.ResolutionProperty#getType()
	 * @see #getResolutionProperty()
	 * @generated
	 */
	EAttribute getResolutionProperty_Type();

	/**
	 * Returns the meta object for class '{@link metamodelHCL.Computer <em>Computer</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Computer</em>'.
	 * @see metamodelHCL.Computer
	 * @generated
	 */
	EClass getComputer();

	/**
	 * Returns the meta object for the attribute '{@link metamodelHCL.Computer#getLabel <em>Label</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Label</em>'.
	 * @see metamodelHCL.Computer#getLabel()
	 * @see #getComputer()
	 * @generated
	 */
	EAttribute getComputer_Label();

	/**
	 * Returns the meta object for the containment reference list '{@link metamodelHCL.Computer#getComponents <em>Components</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Components</em>'.
	 * @see metamodelHCL.Computer#getComponents()
	 * @see #getComputer()
	 * @generated
	 */
	EReference getComputer_Components();

	/**
	 * Returns the meta object for class '{@link metamodelHCL.Model <em>Model</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Model</em>'.
	 * @see metamodelHCL.Model
	 * @generated
	 */
	EClass getModel();

	/**
	 * Returns the meta object for the containment reference list '{@link metamodelHCL.Model#getComputers <em>Computers</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Computers</em>'.
	 * @see metamodelHCL.Model#getComputers()
	 * @see #getModel()
	 * @generated
	 */
	EReference getModel_Computers();

	/**
	 * Returns the meta object for class '{@link metamodelHCL.CoresProperty <em>Cores Property</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Cores Property</em>'.
	 * @see metamodelHCL.CoresProperty
	 * @generated
	 */
	EClass getCoresProperty();

	/**
	 * Returns the meta object for the attribute '{@link metamodelHCL.CoresProperty#getNumber <em>Number</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Number</em>'.
	 * @see metamodelHCL.CoresProperty#getNumber()
	 * @see #getCoresProperty()
	 * @generated
	 */
	EAttribute getCoresProperty_Number();

	/**
	 * Returns the meta object for class '{@link metamodelHCL.SpeedProperty <em>Speed Property</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Speed Property</em>'.
	 * @see metamodelHCL.SpeedProperty
	 * @generated
	 */
	EClass getSpeedProperty();

	/**
	 * Returns the meta object for the attribute '{@link metamodelHCL.SpeedProperty#getSpeed <em>Speed</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Speed</em>'.
	 * @see metamodelHCL.SpeedProperty#getSpeed()
	 * @see #getSpeedProperty()
	 * @generated
	 */
	EAttribute getSpeedProperty_Speed();

	/**
	 * Returns the meta object for the attribute '{@link metamodelHCL.SpeedProperty#getUnit <em>Unit</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Unit</em>'.
	 * @see metamodelHCL.SpeedProperty#getUnit()
	 * @see #getSpeedProperty()
	 * @generated
	 */
	EAttribute getSpeedProperty_Unit();

	/**
	 * Returns the meta object for class '{@link metamodelHCL.CacheProperty <em>Cache Property</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Cache Property</em>'.
	 * @see metamodelHCL.CacheProperty
	 * @generated
	 */
	EClass getCacheProperty();

	/**
	 * Returns the meta object for the attribute '{@link metamodelHCL.CacheProperty#getSize <em>Size</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Size</em>'.
	 * @see metamodelHCL.CacheProperty#getSize()
	 * @see #getCacheProperty()
	 * @generated
	 */
	EAttribute getCacheProperty_Size();

	/**
	 * Returns the meta object for the attribute '{@link metamodelHCL.CacheProperty#getUnit <em>Unit</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Unit</em>'.
	 * @see metamodelHCL.CacheProperty#getUnit()
	 * @see #getCacheProperty()
	 * @generated
	 */
	EAttribute getCacheProperty_Unit();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	MetamodelHCLFactory getMetamodelHCLFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each operation of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link metamodelHCL.impl.ComponentImpl <em>Component</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see metamodelHCL.impl.ComponentImpl
		 * @see metamodelHCL.impl.MetamodelHCLPackageImpl#getComponent()
		 * @generated
		 */
		EClass COMPONENT = eINSTANCE.getComponent();

		/**
		 * The meta object literal for the '<em><b>Label</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute COMPONENT__LABEL = eINSTANCE.getComponent_Label();

		/**
		 * The meta object literal for the '<em><b>Computer</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COMPONENT__COMPUTER = eINSTANCE.getComponent_Computer();

		/**
		 * The meta object literal for the '{@link metamodelHCL.impl.ProcessingImpl <em>Processing</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see metamodelHCL.impl.ProcessingImpl
		 * @see metamodelHCL.impl.MetamodelHCLPackageImpl#getProcessing()
		 * @generated
		 */
		EClass PROCESSING = eINSTANCE.getProcessing();

		/**
		 * The meta object literal for the '<em><b>Properties</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PROCESSING__PROPERTIES = eINSTANCE.getProcessing_Properties();

		/**
		 * The meta object literal for the '{@link metamodelHCL.impl.StorageImpl <em>Storage</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see metamodelHCL.impl.StorageImpl
		 * @see metamodelHCL.impl.MetamodelHCLPackageImpl#getStorage()
		 * @generated
		 */
		EClass STORAGE = eINSTANCE.getStorage();

		/**
		 * The meta object literal for the '<em><b>Properties</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference STORAGE__PROPERTIES = eINSTANCE.getStorage_Properties();

		/**
		 * The meta object literal for the '{@link metamodelHCL.impl.DisplayImpl <em>Display</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see metamodelHCL.impl.DisplayImpl
		 * @see metamodelHCL.impl.MetamodelHCLPackageImpl#getDisplay()
		 * @generated
		 */
		EClass DISPLAY = eINSTANCE.getDisplay();

		/**
		 * The meta object literal for the '<em><b>Properties</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DISPLAY__PROPERTIES = eINSTANCE.getDisplay_Properties();

		/**
		 * The meta object literal for the '{@link metamodelHCL.impl.ReusedComponentImpl <em>Reused Component</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see metamodelHCL.impl.ReusedComponentImpl
		 * @see metamodelHCL.impl.MetamodelHCLPackageImpl#getReusedComponent()
		 * @generated
		 */
		EClass REUSED_COMPONENT = eINSTANCE.getReusedComponent();

		/**
		 * The meta object literal for the '{@link metamodelHCL.impl.ProcessingPropertyImpl <em>Processing Property</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see metamodelHCL.impl.ProcessingPropertyImpl
		 * @see metamodelHCL.impl.MetamodelHCLPackageImpl#getProcessingProperty()
		 * @generated
		 */
		EClass PROCESSING_PROPERTY = eINSTANCE.getProcessingProperty();

		/**
		 * The meta object literal for the '<em><b>Processing</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PROCESSING_PROPERTY__PROCESSING = eINSTANCE.getProcessingProperty_Processing();

		/**
		 * The meta object literal for the '{@link metamodelHCL.impl.StoragePropertyImpl <em>Storage Property</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see metamodelHCL.impl.StoragePropertyImpl
		 * @see metamodelHCL.impl.MetamodelHCLPackageImpl#getStorageProperty()
		 * @generated
		 */
		EClass STORAGE_PROPERTY = eINSTANCE.getStorageProperty();

		/**
		 * The meta object literal for the '<em><b>Storage</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference STORAGE_PROPERTY__STORAGE = eINSTANCE.getStorageProperty_Storage();

		/**
		 * The meta object literal for the '{@link metamodelHCL.impl.DisplayPropertyImpl <em>Display Property</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see metamodelHCL.impl.DisplayPropertyImpl
		 * @see metamodelHCL.impl.MetamodelHCLPackageImpl#getDisplayProperty()
		 * @generated
		 */
		EClass DISPLAY_PROPERTY = eINSTANCE.getDisplayProperty();

		/**
		 * The meta object literal for the '<em><b>Display</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DISPLAY_PROPERTY__DISPLAY = eINSTANCE.getDisplayProperty_Display();

		/**
		 * The meta object literal for the '{@link metamodelHCL.impl.L1CachePropertyImpl <em>L1 Cache Property</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see metamodelHCL.impl.L1CachePropertyImpl
		 * @see metamodelHCL.impl.MetamodelHCLPackageImpl#getL1CacheProperty()
		 * @generated
		 */
		EClass L1_CACHE_PROPERTY = eINSTANCE.getL1CacheProperty();

		/**
		 * The meta object literal for the '{@link metamodelHCL.impl.L2CachePropertyImpl <em>L2 Cache Property</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see metamodelHCL.impl.L2CachePropertyImpl
		 * @see metamodelHCL.impl.MetamodelHCLPackageImpl#getL2CacheProperty()
		 * @generated
		 */
		EClass L2_CACHE_PROPERTY = eINSTANCE.getL2CacheProperty();

		/**
		 * The meta object literal for the '{@link metamodelHCL.impl.L3CachePropertyImpl <em>L3 Cache Property</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see metamodelHCL.impl.L3CachePropertyImpl
		 * @see metamodelHCL.impl.MetamodelHCLPackageImpl#getL3CacheProperty()
		 * @generated
		 */
		EClass L3_CACHE_PROPERTY = eINSTANCE.getL3CacheProperty();

		/**
		 * The meta object literal for the '{@link metamodelHCL.impl.SingleStorageImpl <em>Single Storage</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see metamodelHCL.impl.SingleStorageImpl
		 * @see metamodelHCL.impl.MetamodelHCLPackageImpl#getSingleStorage()
		 * @generated
		 */
		EClass SINGLE_STORAGE = eINSTANCE.getSingleStorage();

		/**
		 * The meta object literal for the '<em><b>Unit</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SINGLE_STORAGE__UNIT = eINSTANCE.getSingleStorage_Unit();

		/**
		 * The meta object literal for the '<em><b>Size</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SINGLE_STORAGE__SIZE = eINSTANCE.getSingleStorage_Size();

		/**
		 * The meta object literal for the '{@link metamodelHCL.impl.DiagonalPropertyImpl <em>Diagonal Property</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see metamodelHCL.impl.DiagonalPropertyImpl
		 * @see metamodelHCL.impl.MetamodelHCLPackageImpl#getDiagonalProperty()
		 * @generated
		 */
		EClass DIAGONAL_PROPERTY = eINSTANCE.getDiagonalProperty();

		/**
		 * The meta object literal for the '<em><b>Size</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DIAGONAL_PROPERTY__SIZE = eINSTANCE.getDiagonalProperty_Size();

		/**
		 * The meta object literal for the '<em><b>Unit</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DIAGONAL_PROPERTY__UNIT = eINSTANCE.getDiagonalProperty_Unit();

		/**
		 * The meta object literal for the '{@link metamodelHCL.impl.ResolutionPropertyImpl <em>Resolution Property</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see metamodelHCL.impl.ResolutionPropertyImpl
		 * @see metamodelHCL.impl.MetamodelHCLPackageImpl#getResolutionProperty()
		 * @generated
		 */
		EClass RESOLUTION_PROPERTY = eINSTANCE.getResolutionProperty();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute RESOLUTION_PROPERTY__TYPE = eINSTANCE.getResolutionProperty_Type();

		/**
		 * The meta object literal for the '{@link metamodelHCL.impl.ComputerImpl <em>Computer</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see metamodelHCL.impl.ComputerImpl
		 * @see metamodelHCL.impl.MetamodelHCLPackageImpl#getComputer()
		 * @generated
		 */
		EClass COMPUTER = eINSTANCE.getComputer();

		/**
		 * The meta object literal for the '<em><b>Label</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute COMPUTER__LABEL = eINSTANCE.getComputer_Label();

		/**
		 * The meta object literal for the '<em><b>Components</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COMPUTER__COMPONENTS = eINSTANCE.getComputer_Components();

		/**
		 * The meta object literal for the '{@link metamodelHCL.impl.ModelImpl <em>Model</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see metamodelHCL.impl.ModelImpl
		 * @see metamodelHCL.impl.MetamodelHCLPackageImpl#getModel()
		 * @generated
		 */
		EClass MODEL = eINSTANCE.getModel();

		/**
		 * The meta object literal for the '<em><b>Computers</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MODEL__COMPUTERS = eINSTANCE.getModel_Computers();

		/**
		 * The meta object literal for the '{@link metamodelHCL.impl.CoresPropertyImpl <em>Cores Property</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see metamodelHCL.impl.CoresPropertyImpl
		 * @see metamodelHCL.impl.MetamodelHCLPackageImpl#getCoresProperty()
		 * @generated
		 */
		EClass CORES_PROPERTY = eINSTANCE.getCoresProperty();

		/**
		 * The meta object literal for the '<em><b>Number</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CORES_PROPERTY__NUMBER = eINSTANCE.getCoresProperty_Number();

		/**
		 * The meta object literal for the '{@link metamodelHCL.impl.SpeedPropertyImpl <em>Speed Property</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see metamodelHCL.impl.SpeedPropertyImpl
		 * @see metamodelHCL.impl.MetamodelHCLPackageImpl#getSpeedProperty()
		 * @generated
		 */
		EClass SPEED_PROPERTY = eINSTANCE.getSpeedProperty();

		/**
		 * The meta object literal for the '<em><b>Speed</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SPEED_PROPERTY__SPEED = eINSTANCE.getSpeedProperty_Speed();

		/**
		 * The meta object literal for the '<em><b>Unit</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SPEED_PROPERTY__UNIT = eINSTANCE.getSpeedProperty_Unit();

		/**
		 * The meta object literal for the '{@link metamodelHCL.impl.CachePropertyImpl <em>Cache Property</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see metamodelHCL.impl.CachePropertyImpl
		 * @see metamodelHCL.impl.MetamodelHCLPackageImpl#getCacheProperty()
		 * @generated
		 */
		EClass CACHE_PROPERTY = eINSTANCE.getCacheProperty();

		/**
		 * The meta object literal for the '<em><b>Size</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CACHE_PROPERTY__SIZE = eINSTANCE.getCacheProperty_Size();

		/**
		 * The meta object literal for the '<em><b>Unit</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CACHE_PROPERTY__UNIT = eINSTANCE.getCacheProperty_Unit();

	}

} //MetamodelHCLPackage
