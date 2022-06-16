/**
 */
package metamodelHCL;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Display Property</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link metamodelHCL.DisplayProperty#getDisplay <em>Display</em>}</li>
 * </ul>
 *
 * @see metamodelHCL.MetamodelHCLPackage#getDisplayProperty()
 * @model abstract="true"
 * @generated
 */
public interface DisplayProperty extends EObject {

	/**
	 * Returns the value of the '<em><b>Display</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Display</em>' reference.
	 * @see #setDisplay(Display)
	 * @see metamodelHCL.MetamodelHCLPackage#getDisplayProperty_Display()
	 * @model
	 * @generated
	 */
	Display getDisplay();

	/**
	 * Sets the value of the '{@link metamodelHCL.DisplayProperty#getDisplay <em>Display</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Display</em>' reference.
	 * @see #getDisplay()
	 * @generated
	 */
	void setDisplay(Display value);
} // DisplayProperty
