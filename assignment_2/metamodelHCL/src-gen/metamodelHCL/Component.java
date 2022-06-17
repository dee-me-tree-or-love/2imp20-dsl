/**
 */
package metamodelHCL;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Component</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link metamodelHCL.Component#getLabel <em>Label</em>}</li>
 *   <li>{@link metamodelHCL.Component#getComputer <em>Computer</em>}</li>
 * </ul>
 *
 * @see metamodelHCL.MetamodelHCLPackage#getComponent()
 * @model abstract="true"
 * @generated
 */
public interface Component extends EObject {
	/**
	 * Returns the value of the '<em><b>Label</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Label</em>' attribute.
	 * @see #setLabel(String)
	 * @see metamodelHCL.MetamodelHCLPackage#getComponent_Label()
	 * @model required="true"
	 * @generated
	 */
	String getLabel();

	/**
	 * Sets the value of the '{@link metamodelHCL.Component#getLabel <em>Label</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Label</em>' attribute.
	 * @see #getLabel()
	 * @generated
	 */
	void setLabel(String value);

	/**
	 * Returns the value of the '<em><b>Computer</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Computer</em>' reference.
	 * @see #setComputer(Computer)
	 * @see metamodelHCL.MetamodelHCLPackage#getComponent_Computer()
	 * @model
	 * @generated
	 */
	Computer getComputer();

	/**
	 * Sets the value of the '{@link metamodelHCL.Component#getComputer <em>Computer</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Computer</em>' reference.
	 * @see #getComputer()
	 * @generated
	 */
	void setComputer(Computer value);

} // Component
