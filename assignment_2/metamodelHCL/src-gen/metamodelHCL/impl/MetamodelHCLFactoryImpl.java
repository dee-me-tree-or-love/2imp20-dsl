/**
 */
package metamodelHCL.impl;

import metamodelHCL.*;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
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
		case MetamodelHCLPackage.CORES:
			return createCores();
		case MetamodelHCLPackage.SPEED:
			return createSpeed();
		case MetamodelHCLPackage.L1:
			return createL1();
		case MetamodelHCLPackage.L2:
			return createL2();
		case MetamodelHCLPackage.L3:
			return createL3();
		case MetamodelHCLPackage.SINGLE_STORAGE:
			return createSingleStorage();
		case MetamodelHCLPackage.DIAGONAL:
			return createDiagonal();
		case MetamodelHCLPackage.TYPE:
			return createType();
		case MetamodelHCLPackage.COMPUTER:
			return createComputer();
		case MetamodelHCLPackage.MODEL:
			return createModel();
		default:
			throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object createFromString(EDataType eDataType, String initialValue) {
		switch (eDataType.getClassifierID()) {
		case MetamodelHCLPackage.STORAGE_TYPE_ENUM:
			return createStorageTypeEnumFromString(eDataType, initialValue);
		default:
			throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String convertToString(EDataType eDataType, Object instanceValue) {
		switch (eDataType.getClassifierID()) {
		case MetamodelHCLPackage.STORAGE_TYPE_ENUM:
			return convertStorageTypeEnumToString(eDataType, instanceValue);
		default:
			throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
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
	public Cores createCores() {
		CoresImpl cores = new CoresImpl();
		return cores;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Speed createSpeed() {
		SpeedImpl speed = new SpeedImpl();
		return speed;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public L1 createL1() {
		L1Impl l1 = new L1Impl();
		return l1;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public L2 createL2() {
		L2Impl l2 = new L2Impl();
		return l2;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public L3 createL3() {
		L3Impl l3 = new L3Impl();
		return l3;
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
	public Diagonal createDiagonal() {
		DiagonalImpl diagonal = new DiagonalImpl();
		return diagonal;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Type createType() {
		TypeImpl type = new TypeImpl();
		return type;
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
	public StorageTypeEnum createStorageTypeEnumFromString(EDataType eDataType, String initialValue) {
		StorageTypeEnum result = StorageTypeEnum.get(initialValue);
		if (result == null)
			throw new IllegalArgumentException(
					"The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertStorageTypeEnumToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
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
