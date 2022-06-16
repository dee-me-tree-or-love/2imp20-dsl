/**
 */
package metamodelHCL.impl;

import metamodelHCL.*;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class MetamodelHCLFactoryImpl extends EFactoryImpl implements MetamodelHCLFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static MetamodelHCLFactory init() {
		try {
			MetamodelHCLFactory theMetamodelHCLFactory = (MetamodelHCLFactory) EPackage.Registry.INSTANCE
					.getEFactory(MetamodelHCLPackage.eNS_URI);
			if (theMetamodelHCLFactory != null) {
				return theMetamodelHCLFactory;
			}
		} catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new MetamodelHCLFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MetamodelHCLFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
		case MetamodelHCLPackage.PROCESSING:
			return createProcessing();
		case MetamodelHCLPackage.STORAGE:
			return createStorage();
		case MetamodelHCLPackage.DISPLAY:
			return createDisplay();
		case MetamodelHCLPackage.REUSED_COMPONENT:
			return createReusedComponent();
		case MetamodelHCLPackage.L1_CACHE_PROPERTY:
			return createL1CacheProperty();
		case MetamodelHCLPackage.L2_CACHE_PROPERTY:
			return createL2CacheProperty();
		case MetamodelHCLPackage.L3_CACHE_PROPERTY:
			return createL3CacheProperty();
		case MetamodelHCLPackage.SINGLE_STORAGE:
			return createSingleStorage();
		case MetamodelHCLPackage.DIAGONAL_PROPERTY:
			return createDiagonalProperty();
		case MetamodelHCLPackage.RESOLUTION_PROPERTY:
			return createResolutionProperty();
		case MetamodelHCLPackage.COMPUTER:
			return createComputer();
		case MetamodelHCLPackage.MODEL:
			return createModel();
		case MetamodelHCLPackage.CORES_PROPERTY:
			return createCoresProperty();
		case MetamodelHCLPackage.SPEED_PROPERTY:
			return createSpeedProperty();
		default:
			throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Processing createProcessing() {
		ProcessingImpl processing = new ProcessingImpl();
		return processing;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Storage createStorage() {
		StorageImpl storage = new StorageImpl();
		return storage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Display createDisplay() {
		DisplayImpl display = new DisplayImpl();
		return display;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ReusedComponent createReusedComponent() {
		ReusedComponentImpl reusedComponent = new ReusedComponentImpl();
		return reusedComponent;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public L1CacheProperty createL1CacheProperty() {
		L1CachePropertyImpl l1CacheProperty = new L1CachePropertyImpl();
		return l1CacheProperty;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public L2CacheProperty createL2CacheProperty() {
		L2CachePropertyImpl l2CacheProperty = new L2CachePropertyImpl();
		return l2CacheProperty;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public L3CacheProperty createL3CacheProperty() {
		L3CachePropertyImpl l3CacheProperty = new L3CachePropertyImpl();
		return l3CacheProperty;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SingleStorage createSingleStorage() {
		SingleStorageImpl singleStorage = new SingleStorageImpl();
		return singleStorage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DiagonalProperty createDiagonalProperty() {
		DiagonalPropertyImpl diagonalProperty = new DiagonalPropertyImpl();
		return diagonalProperty;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ResolutionProperty createResolutionProperty() {
		ResolutionPropertyImpl resolutionProperty = new ResolutionPropertyImpl();
		return resolutionProperty;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Computer createComputer() {
		ComputerImpl computer = new ComputerImpl();
		return computer;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Model createModel() {
		ModelImpl model = new ModelImpl();
		return model;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CoresProperty createCoresProperty() {
		CoresPropertyImpl coresProperty = new CoresPropertyImpl();
		return coresProperty;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SpeedProperty createSpeedProperty() {
		SpeedPropertyImpl speedProperty = new SpeedPropertyImpl();
		return speedProperty;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MetamodelHCLPackage getMetamodelHCLPackage() {
		return (MetamodelHCLPackage) getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static MetamodelHCLPackage getPackage() {
		return MetamodelHCLPackage.eINSTANCE;
	}

} //MetamodelHCLFactoryImpl
