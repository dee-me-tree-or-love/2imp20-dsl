/**
 */
package metamodelHCL;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see metamodelHCL.MetamodelHCLPackage
 * @generated
 */
public interface MetamodelHCLFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	MetamodelHCLFactory eINSTANCE = metamodelHCL.impl.MetamodelHCLFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Processing</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Processing</em>'.
	 * @generated
	 */
	Processing createProcessing();

	/**
	 * Returns a new object of class '<em>Storage</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Storage</em>'.
	 * @generated
	 */
	Storage createStorage();

	/**
	 * Returns a new object of class '<em>Display</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Display</em>'.
	 * @generated
	 */
	Display createDisplay();

	/**
	 * Returns a new object of class '<em>Reused Component</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Reused Component</em>'.
	 * @generated
	 */
	ReusedComponent createReusedComponent();

	/**
	 * Returns a new object of class '<em>L1 Cache Property</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>L1 Cache Property</em>'.
	 * @generated
	 */
	L1CacheProperty createL1CacheProperty();

	/**
	 * Returns a new object of class '<em>L2 Cache Property</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>L2 Cache Property</em>'.
	 * @generated
	 */
	L2CacheProperty createL2CacheProperty();

	/**
	 * Returns a new object of class '<em>L3 Cache Property</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>L3 Cache Property</em>'.
	 * @generated
	 */
	L3CacheProperty createL3CacheProperty();

	/**
	 * Returns a new object of class '<em>Single Storage</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Single Storage</em>'.
	 * @generated
	 */
	SingleStorage createSingleStorage();

	/**
	 * Returns a new object of class '<em>Diagonal Property</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Diagonal Property</em>'.
	 * @generated
	 */
	DiagonalProperty createDiagonalProperty();

	/**
	 * Returns a new object of class '<em>Resolution Property</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Resolution Property</em>'.
	 * @generated
	 */
	ResolutionProperty createResolutionProperty();

	/**
	 * Returns a new object of class '<em>Computer</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Computer</em>'.
	 * @generated
	 */
	Computer createComputer();

	/**
	 * Returns a new object of class '<em>Model</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Model</em>'.
	 * @generated
	 */
	Model createModel();

	/**
	 * Returns a new object of class '<em>Cores Property</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Cores Property</em>'.
	 * @generated
	 */
	CoresProperty createCoresProperty();

	/**
	 * Returns a new object of class '<em>Speed Property</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Speed Property</em>'.
	 * @generated
	 */
	SpeedProperty createSpeedProperty();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	MetamodelHCLPackage getMetamodelHCLPackage();

} //MetamodelHCLFactory
