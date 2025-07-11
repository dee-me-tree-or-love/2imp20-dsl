/**
 */
package metamodelHCL;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Model</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link metamodelHCL.Model#getComputers <em>Computers</em>}</li>
 * </ul>
 *
 * @see metamodelHCL.MetamodelHCLPackage#getModel()
 * @model
 * @generated
 */
public interface Model extends EObject {
	/**
	 * Returns the value of the '<em><b>Computers</b></em>' containment reference list.
	 * The list contents are of type {@link metamodelHCL.Computer}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Computers</em>' containment reference list.
	 * @see metamodelHCL.MetamodelHCLPackage#getModel_Computers()
	 * @model containment="true"
	 * @generated
	 */
	EList<Computer> getComputers();

} // Model
