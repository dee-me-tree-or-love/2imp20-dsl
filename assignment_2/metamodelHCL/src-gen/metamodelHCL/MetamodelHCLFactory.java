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
	 * Returns a new object of class '<em>Cores</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Cores</em>'.
	 * @generated
	 */
	Cores createCores();

	/**
	 * Returns a new object of class '<em>Speed</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Speed</em>'.
	 * @generated
	 */
	Speed createSpeed();

	/**
	 * Returns a new object of class '<em>L1</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>L1</em>'.
	 * @generated
	 */
	L1 createL1();

	/**
	 * Returns a new object of class '<em>L2</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>L2</em>'.
	 * @generated
	 */
	L2 createL2();

	/**
	 * Returns a new object of class '<em>L3</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>L3</em>'.
	 * @generated
	 */
	L3 createL3();

	/**
	 * Returns a new object of class '<em>Single Storage</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Single Storage</em>'.
	 * @generated
	 */
	SingleStorage createSingleStorage();

	/**
	 * Returns a new object of class '<em>Diagonal</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Diagonal</em>'.
	 * @generated
	 */
	Diagonal createDiagonal();

	/**
	 * Returns a new object of class '<em>Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Type</em>'.
	 * @generated
	 */
	Type createType();

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
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	MetamodelHCLPackage getMetamodelHCLPackage();

} //MetamodelHCLFactory
