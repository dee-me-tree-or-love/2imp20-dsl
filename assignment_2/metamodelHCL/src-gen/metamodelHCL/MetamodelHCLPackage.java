/**
 */
package metamodelHCL;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
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
	 * The number of structural features of the '<em>Component</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT_FEATURE_COUNT = 1;

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
	 * The feature id for the '<em><b>Processingproperty</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROCESSING__PROCESSINGPROPERTY = COMPONENT_FEATURE_COUNT + 0;

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
	 * The feature id for the '<em><b>Storageproperty</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STORAGE__STORAGEPROPERTY = COMPONENT_FEATURE_COUNT + 0;

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
	 * The feature id for the '<em><b>Displayproperty</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DISPLAY__DISPLAYPROPERTY = COMPONENT_FEATURE_COUNT + 0;

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
	 * The number of structural features of the '<em>Processing Property</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROCESSING_PROPERTY_FEATURE_COUNT = 0;

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
	 * The number of structural features of the '<em>Storage Property</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STORAGE_PROPERTY_FEATURE_COUNT = 0;

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
	 * The number of structural features of the '<em>Display Property</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DISPLAY_PROPERTY_FEATURE_COUNT = 0;

	/**
	 * The number of operations of the '<em>Display Property</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DISPLAY_PROPERTY_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link metamodelHCL.impl.CoresImpl <em>Cores</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see metamodelHCL.impl.CoresImpl
	 * @see metamodelHCL.impl.MetamodelHCLPackageImpl#getCores()
	 * @generated
	 */
	int CORES = 8;

	/**
	 * The feature id for the '<em><b>Number</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CORES__NUMBER = PROCESSING_PROPERTY_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Cores</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CORES_FEATURE_COUNT = PROCESSING_PROPERTY_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Cores</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CORES_OPERATION_COUNT = PROCESSING_PROPERTY_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link metamodelHCL.impl.SpeedImpl <em>Speed</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see metamodelHCL.impl.SpeedImpl
	 * @see metamodelHCL.impl.MetamodelHCLPackageImpl#getSpeed()
	 * @generated
	 */
	int SPEED = 9;

	/**
	 * The feature id for the '<em><b>Speed</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPEED__SPEED = PROCESSING_PROPERTY_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Speed</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPEED_FEATURE_COUNT = PROCESSING_PROPERTY_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Speed</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPEED_OPERATION_COUNT = PROCESSING_PROPERTY_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link metamodelHCL.impl.CacheImpl <em>Cache</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see metamodelHCL.impl.CacheImpl
	 * @see metamodelHCL.impl.MetamodelHCLPackageImpl#getCache()
	 * @generated
	 */
	int CACHE = 10;

	/**
	 * The number of structural features of the '<em>Cache</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CACHE_FEATURE_COUNT = PROCESSING_PROPERTY_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Cache</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CACHE_OPERATION_COUNT = PROCESSING_PROPERTY_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link metamodelHCL.impl.L1Impl <em>L1</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see metamodelHCL.impl.L1Impl
	 * @see metamodelHCL.impl.MetamodelHCLPackageImpl#getL1()
	 * @generated
	 */
	int L1 = 11;

	/**
	 * The feature id for the '<em><b>Number</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int L1__NUMBER = CACHE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int L1__TYPE = CACHE_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>L1</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int L1_FEATURE_COUNT = CACHE_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>L1</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int L1_OPERATION_COUNT = CACHE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link metamodelHCL.impl.L2Impl <em>L2</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see metamodelHCL.impl.L2Impl
	 * @see metamodelHCL.impl.MetamodelHCLPackageImpl#getL2()
	 * @generated
	 */
	int L2 = 12;

	/**
	 * The feature id for the '<em><b>Number</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int L2__NUMBER = CACHE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int L2__TYPE = CACHE_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>L2</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int L2_FEATURE_COUNT = CACHE_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>L2</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int L2_OPERATION_COUNT = CACHE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link metamodelHCL.impl.L3Impl <em>L3</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see metamodelHCL.impl.L3Impl
	 * @see metamodelHCL.impl.MetamodelHCLPackageImpl#getL3()
	 * @generated
	 */
	int L3 = 13;

	/**
	 * The feature id for the '<em><b>Number</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int L3__NUMBER = CACHE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int L3__TYPE = CACHE_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>L3</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int L3_FEATURE_COUNT = CACHE_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>L3</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int L3_OPERATION_COUNT = CACHE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link metamodelHCL.impl.SingleStorageImpl <em>Single Storage</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see metamodelHCL.impl.SingleStorageImpl
	 * @see metamodelHCL.impl.MetamodelHCLPackageImpl#getSingleStorage()
	 * @generated
	 */
	int SINGLE_STORAGE = 14;

	/**
	 * The feature id for the '<em><b>Stype</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SINGLE_STORAGE__STYPE = STORAGE_PROPERTY_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Ssize</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SINGLE_STORAGE__SSIZE = STORAGE_PROPERTY_FEATURE_COUNT + 1;

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
	 * The meta object id for the '{@link metamodelHCL.impl.DiagonalImpl <em>Diagonal</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see metamodelHCL.impl.DiagonalImpl
	 * @see metamodelHCL.impl.MetamodelHCLPackageImpl#getDiagonal()
	 * @generated
	 */
	int DIAGONAL = 15;

	/**
	 * The feature id for the '<em><b>Inch</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIAGONAL__INCH = DISPLAY_PROPERTY_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Diagonal</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIAGONAL_FEATURE_COUNT = DISPLAY_PROPERTY_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Diagonal</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIAGONAL_OPERATION_COUNT = DISPLAY_PROPERTY_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link metamodelHCL.impl.TypeImpl <em>Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see metamodelHCL.impl.TypeImpl
	 * @see metamodelHCL.impl.MetamodelHCLPackageImpl#getType()
	 * @generated
	 */
	int TYPE = 16;

	/**
	 * The feature id for the '<em><b>Dtype</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE__DTYPE = DISPLAY_PROPERTY_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_FEATURE_COUNT = DISPLAY_PROPERTY_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_OPERATION_COUNT = DISPLAY_PROPERTY_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link metamodelHCL.impl.ComputerImpl <em>Computer</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see metamodelHCL.impl.ComputerImpl
	 * @see metamodelHCL.impl.MetamodelHCLPackageImpl#getComputer()
	 * @generated
	 */
	int COMPUTER = 17;

	/**
	 * The feature id for the '<em><b>Label</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPUTER__LABEL = 0;

	/**
	 * The feature id for the '<em><b>Component</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPUTER__COMPONENT = 1;

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
	 * The meta object id for the '{@link metamodelHCL.SizeTypeEnum <em>Size Type Enum</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see metamodelHCL.SizeTypeEnum
	 * @see metamodelHCL.impl.MetamodelHCLPackageImpl#getSizeTypeEnum()
	 * @generated
	 */
	int SIZE_TYPE_ENUM = 18;

	/**
	 * The meta object id for the '{@link metamodelHCL.StorageTypeEnum <em>Storage Type Enum</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see metamodelHCL.StorageTypeEnum
	 * @see metamodelHCL.impl.MetamodelHCLPackageImpl#getStorageTypeEnum()
	 * @generated
	 */
	int STORAGE_TYPE_ENUM = 19;

	/**
	 * The meta object id for the '{@link metamodelHCL.DisplayTypeEnum <em>Display Type Enum</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see metamodelHCL.DisplayTypeEnum
	 * @see metamodelHCL.impl.MetamodelHCLPackageImpl#getDisplayTypeEnum()
	 * @generated
	 */
	int DISPLAY_TYPE_ENUM = 20;

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
	 * Returns the meta object for class '{@link metamodelHCL.Processing <em>Processing</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Processing</em>'.
	 * @see metamodelHCL.Processing
	 * @generated
	 */
	EClass getProcessing();

	/**
	 * Returns the meta object for the containment reference list '{@link metamodelHCL.Processing#getProcessingproperty <em>Processingproperty</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Processingproperty</em>'.
	 * @see metamodelHCL.Processing#getProcessingproperty()
	 * @see #getProcessing()
	 * @generated
	 */
	EReference getProcessing_Processingproperty();

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
	 * Returns the meta object for the containment reference '{@link metamodelHCL.Storage#getStorageproperty <em>Storageproperty</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Storageproperty</em>'.
	 * @see metamodelHCL.Storage#getStorageproperty()
	 * @see #getStorage()
	 * @generated
	 */
	EReference getStorage_Storageproperty();

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
	 * Returns the meta object for the containment reference list '{@link metamodelHCL.Display#getDisplayproperty <em>Displayproperty</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Displayproperty</em>'.
	 * @see metamodelHCL.Display#getDisplayproperty()
	 * @see #getDisplay()
	 * @generated
	 */
	EReference getDisplay_Displayproperty();

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
	 * Returns the meta object for class '{@link metamodelHCL.StorageProperty <em>Storage Property</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Storage Property</em>'.
	 * @see metamodelHCL.StorageProperty
	 * @generated
	 */
	EClass getStorageProperty();

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
	 * Returns the meta object for class '{@link metamodelHCL.Cores <em>Cores</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Cores</em>'.
	 * @see metamodelHCL.Cores
	 * @generated
	 */
	EClass getCores();

	/**
	 * Returns the meta object for the attribute '{@link metamodelHCL.Cores#getNumber <em>Number</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Number</em>'.
	 * @see metamodelHCL.Cores#getNumber()
	 * @see #getCores()
	 * @generated
	 */
	EAttribute getCores_Number();

	/**
	 * Returns the meta object for class '{@link metamodelHCL.Speed <em>Speed</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Speed</em>'.
	 * @see metamodelHCL.Speed
	 * @generated
	 */
	EClass getSpeed();

	/**
	 * Returns the meta object for the attribute '{@link metamodelHCL.Speed#getSpeed <em>Speed</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Speed</em>'.
	 * @see metamodelHCL.Speed#getSpeed()
	 * @see #getSpeed()
	 * @generated
	 */
	EAttribute getSpeed_Speed();

	/**
	 * Returns the meta object for class '{@link metamodelHCL.Cache <em>Cache</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Cache</em>'.
	 * @see metamodelHCL.Cache
	 * @generated
	 */
	EClass getCache();

	/**
	 * Returns the meta object for class '{@link metamodelHCL.L1 <em>L1</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>L1</em>'.
	 * @see metamodelHCL.L1
	 * @generated
	 */
	EClass getL1();

	/**
	 * Returns the meta object for the attribute '{@link metamodelHCL.L1#getNumber <em>Number</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Number</em>'.
	 * @see metamodelHCL.L1#getNumber()
	 * @see #getL1()
	 * @generated
	 */
	EAttribute getL1_Number();

	/**
	 * Returns the meta object for the attribute '{@link metamodelHCL.L1#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Type</em>'.
	 * @see metamodelHCL.L1#getType()
	 * @see #getL1()
	 * @generated
	 */
	EAttribute getL1_Type();

	/**
	 * Returns the meta object for class '{@link metamodelHCL.L2 <em>L2</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>L2</em>'.
	 * @see metamodelHCL.L2
	 * @generated
	 */
	EClass getL2();

	/**
	 * Returns the meta object for the attribute '{@link metamodelHCL.L2#getNumber <em>Number</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Number</em>'.
	 * @see metamodelHCL.L2#getNumber()
	 * @see #getL2()
	 * @generated
	 */
	EAttribute getL2_Number();

	/**
	 * Returns the meta object for the attribute '{@link metamodelHCL.L2#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Type</em>'.
	 * @see metamodelHCL.L2#getType()
	 * @see #getL2()
	 * @generated
	 */
	EAttribute getL2_Type();

	/**
	 * Returns the meta object for class '{@link metamodelHCL.L3 <em>L3</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>L3</em>'.
	 * @see metamodelHCL.L3
	 * @generated
	 */
	EClass getL3();

	/**
	 * Returns the meta object for the attribute '{@link metamodelHCL.L3#getNumber <em>Number</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Number</em>'.
	 * @see metamodelHCL.L3#getNumber()
	 * @see #getL3()
	 * @generated
	 */
	EAttribute getL3_Number();

	/**
	 * Returns the meta object for the attribute '{@link metamodelHCL.L3#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Type</em>'.
	 * @see metamodelHCL.L3#getType()
	 * @see #getL3()
	 * @generated
	 */
	EAttribute getL3_Type();

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
	 * Returns the meta object for the attribute '{@link metamodelHCL.SingleStorage#getStype <em>Stype</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Stype</em>'.
	 * @see metamodelHCL.SingleStorage#getStype()
	 * @see #getSingleStorage()
	 * @generated
	 */
	EAttribute getSingleStorage_Stype();

	/**
	 * Returns the meta object for the attribute '{@link metamodelHCL.SingleStorage#getSsize <em>Ssize</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Ssize</em>'.
	 * @see metamodelHCL.SingleStorage#getSsize()
	 * @see #getSingleStorage()
	 * @generated
	 */
	EAttribute getSingleStorage_Ssize();

	/**
	 * Returns the meta object for class '{@link metamodelHCL.Diagonal <em>Diagonal</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Diagonal</em>'.
	 * @see metamodelHCL.Diagonal
	 * @generated
	 */
	EClass getDiagonal();

	/**
	 * Returns the meta object for the attribute '{@link metamodelHCL.Diagonal#getInch <em>Inch</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Inch</em>'.
	 * @see metamodelHCL.Diagonal#getInch()
	 * @see #getDiagonal()
	 * @generated
	 */
	EAttribute getDiagonal_Inch();

	/**
	 * Returns the meta object for class '{@link metamodelHCL.Type <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Type</em>'.
	 * @see metamodelHCL.Type
	 * @generated
	 */
	EClass getType();

	/**
	 * Returns the meta object for the attribute '{@link metamodelHCL.Type#getDtype <em>Dtype</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Dtype</em>'.
	 * @see metamodelHCL.Type#getDtype()
	 * @see #getType()
	 * @generated
	 */
	EAttribute getType_Dtype();

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
	 * Returns the meta object for the containment reference list '{@link metamodelHCL.Computer#getComponent <em>Component</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Component</em>'.
	 * @see metamodelHCL.Computer#getComponent()
	 * @see #getComputer()
	 * @generated
	 */
	EReference getComputer_Component();

	/**
	 * Returns the meta object for enum '{@link metamodelHCL.SizeTypeEnum <em>Size Type Enum</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Size Type Enum</em>'.
	 * @see metamodelHCL.SizeTypeEnum
	 * @generated
	 */
	EEnum getSizeTypeEnum();

	/**
	 * Returns the meta object for enum '{@link metamodelHCL.StorageTypeEnum <em>Storage Type Enum</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Storage Type Enum</em>'.
	 * @see metamodelHCL.StorageTypeEnum
	 * @generated
	 */
	EEnum getStorageTypeEnum();

	/**
	 * Returns the meta object for enum '{@link metamodelHCL.DisplayTypeEnum <em>Display Type Enum</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Display Type Enum</em>'.
	 * @see metamodelHCL.DisplayTypeEnum
	 * @generated
	 */
	EEnum getDisplayTypeEnum();

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
		 * The meta object literal for the '{@link metamodelHCL.impl.ProcessingImpl <em>Processing</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see metamodelHCL.impl.ProcessingImpl
		 * @see metamodelHCL.impl.MetamodelHCLPackageImpl#getProcessing()
		 * @generated
		 */
		EClass PROCESSING = eINSTANCE.getProcessing();

		/**
		 * The meta object literal for the '<em><b>Processingproperty</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PROCESSING__PROCESSINGPROPERTY = eINSTANCE.getProcessing_Processingproperty();

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
		 * The meta object literal for the '<em><b>Storageproperty</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference STORAGE__STORAGEPROPERTY = eINSTANCE.getStorage_Storageproperty();

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
		 * The meta object literal for the '<em><b>Displayproperty</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DISPLAY__DISPLAYPROPERTY = eINSTANCE.getDisplay_Displayproperty();

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
		 * The meta object literal for the '{@link metamodelHCL.impl.StoragePropertyImpl <em>Storage Property</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see metamodelHCL.impl.StoragePropertyImpl
		 * @see metamodelHCL.impl.MetamodelHCLPackageImpl#getStorageProperty()
		 * @generated
		 */
		EClass STORAGE_PROPERTY = eINSTANCE.getStorageProperty();

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
		 * The meta object literal for the '{@link metamodelHCL.impl.CoresImpl <em>Cores</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see metamodelHCL.impl.CoresImpl
		 * @see metamodelHCL.impl.MetamodelHCLPackageImpl#getCores()
		 * @generated
		 */
		EClass CORES = eINSTANCE.getCores();

		/**
		 * The meta object literal for the '<em><b>Number</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CORES__NUMBER = eINSTANCE.getCores_Number();

		/**
		 * The meta object literal for the '{@link metamodelHCL.impl.SpeedImpl <em>Speed</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see metamodelHCL.impl.SpeedImpl
		 * @see metamodelHCL.impl.MetamodelHCLPackageImpl#getSpeed()
		 * @generated
		 */
		EClass SPEED = eINSTANCE.getSpeed();

		/**
		 * The meta object literal for the '<em><b>Speed</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SPEED__SPEED = eINSTANCE.getSpeed_Speed();

		/**
		 * The meta object literal for the '{@link metamodelHCL.impl.CacheImpl <em>Cache</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see metamodelHCL.impl.CacheImpl
		 * @see metamodelHCL.impl.MetamodelHCLPackageImpl#getCache()
		 * @generated
		 */
		EClass CACHE = eINSTANCE.getCache();

		/**
		 * The meta object literal for the '{@link metamodelHCL.impl.L1Impl <em>L1</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see metamodelHCL.impl.L1Impl
		 * @see metamodelHCL.impl.MetamodelHCLPackageImpl#getL1()
		 * @generated
		 */
		EClass L1 = eINSTANCE.getL1();

		/**
		 * The meta object literal for the '<em><b>Number</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute L1__NUMBER = eINSTANCE.getL1_Number();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute L1__TYPE = eINSTANCE.getL1_Type();

		/**
		 * The meta object literal for the '{@link metamodelHCL.impl.L2Impl <em>L2</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see metamodelHCL.impl.L2Impl
		 * @see metamodelHCL.impl.MetamodelHCLPackageImpl#getL2()
		 * @generated
		 */
		EClass L2 = eINSTANCE.getL2();

		/**
		 * The meta object literal for the '<em><b>Number</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute L2__NUMBER = eINSTANCE.getL2_Number();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute L2__TYPE = eINSTANCE.getL2_Type();

		/**
		 * The meta object literal for the '{@link metamodelHCL.impl.L3Impl <em>L3</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see metamodelHCL.impl.L3Impl
		 * @see metamodelHCL.impl.MetamodelHCLPackageImpl#getL3()
		 * @generated
		 */
		EClass L3 = eINSTANCE.getL3();

		/**
		 * The meta object literal for the '<em><b>Number</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute L3__NUMBER = eINSTANCE.getL3_Number();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute L3__TYPE = eINSTANCE.getL3_Type();

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
		 * The meta object literal for the '<em><b>Stype</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SINGLE_STORAGE__STYPE = eINSTANCE.getSingleStorage_Stype();

		/**
		 * The meta object literal for the '<em><b>Ssize</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SINGLE_STORAGE__SSIZE = eINSTANCE.getSingleStorage_Ssize();

		/**
		 * The meta object literal for the '{@link metamodelHCL.impl.DiagonalImpl <em>Diagonal</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see metamodelHCL.impl.DiagonalImpl
		 * @see metamodelHCL.impl.MetamodelHCLPackageImpl#getDiagonal()
		 * @generated
		 */
		EClass DIAGONAL = eINSTANCE.getDiagonal();

		/**
		 * The meta object literal for the '<em><b>Inch</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DIAGONAL__INCH = eINSTANCE.getDiagonal_Inch();

		/**
		 * The meta object literal for the '{@link metamodelHCL.impl.TypeImpl <em>Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see metamodelHCL.impl.TypeImpl
		 * @see metamodelHCL.impl.MetamodelHCLPackageImpl#getType()
		 * @generated
		 */
		EClass TYPE = eINSTANCE.getType();

		/**
		 * The meta object literal for the '<em><b>Dtype</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TYPE__DTYPE = eINSTANCE.getType_Dtype();

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
		 * The meta object literal for the '<em><b>Component</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COMPUTER__COMPONENT = eINSTANCE.getComputer_Component();

		/**
		 * The meta object literal for the '{@link metamodelHCL.SizeTypeEnum <em>Size Type Enum</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see metamodelHCL.SizeTypeEnum
		 * @see metamodelHCL.impl.MetamodelHCLPackageImpl#getSizeTypeEnum()
		 * @generated
		 */
		EEnum SIZE_TYPE_ENUM = eINSTANCE.getSizeTypeEnum();

		/**
		 * The meta object literal for the '{@link metamodelHCL.StorageTypeEnum <em>Storage Type Enum</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see metamodelHCL.StorageTypeEnum
		 * @see metamodelHCL.impl.MetamodelHCLPackageImpl#getStorageTypeEnum()
		 * @generated
		 */
		EEnum STORAGE_TYPE_ENUM = eINSTANCE.getStorageTypeEnum();

		/**
		 * The meta object literal for the '{@link metamodelHCL.DisplayTypeEnum <em>Display Type Enum</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see metamodelHCL.DisplayTypeEnum
		 * @see metamodelHCL.impl.MetamodelHCLPackageImpl#getDisplayTypeEnum()
		 * @generated
		 */
		EEnum DISPLAY_TYPE_ENUM = eINSTANCE.getDisplayTypeEnum();

	}

} //MetamodelHCLPackage
