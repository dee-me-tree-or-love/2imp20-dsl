/**
 */
package metamodelHCL;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Computer</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link metamodelHCL.Computer#getLabel <em>Label</em>}</li>
 *   <li>{@link metamodelHCL.Computer#getComponent <em>Component</em>}</li>
 * </ul>
 *
 * @see metamodelHCL.MetamodelHCLPackage#getComputer()
 * @model
 * @generated
 */
public interface Computer extends EObject {
	/**
	 * Returns the value of the '<em><b>Label</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Label</em>' attribute.
	 * @see #setLabel(String)
	 * @see metamodelHCL.MetamodelHCLPackage#getComputer_Label()
	 * @model required="true"
	 * @generated
	 */
	String getLabel();

	/**
	 * Sets the value of the '{@link metamodelHCL.Computer#getLabel <em>Label</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Label</em>' attribute.
	 * @see #getLabel()
	 * @generated
	 */
	void setLabel(String value);

	/**
	 * Returns the value of the '<em><b>Component</b></em>' containment reference list.
	 * The list contents are of type {@link metamodelHCL.Component}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Component</em>' containment reference list.
	 * @see metamodelHCL.MetamodelHCLPackage#getComputer_Component()
	 * @model containment="true"
	 * @generated
	 */
	EList<Component> getComponent();

} // Computer
