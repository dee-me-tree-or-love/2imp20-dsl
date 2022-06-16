/**
 */
package metamodelHCL;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Processing Property</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link metamodelHCL.ProcessingProperty#getProcessing <em>Processing</em>}</li>
 * </ul>
 *
 * @see metamodelHCL.MetamodelHCLPackage#getProcessingProperty()
 * @model abstract="true"
 * @generated
 */
public interface ProcessingProperty extends EObject {

	/**
	 * Returns the value of the '<em><b>Processing</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Processing</em>' reference.
	 * @see #setProcessing(Processing)
	 * @see metamodelHCL.MetamodelHCLPackage#getProcessingProperty_Processing()
	 * @model
	 * @generated
	 */
	Processing getProcessing();

	/**
	 * Sets the value of the '{@link metamodelHCL.ProcessingProperty#getProcessing <em>Processing</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Processing</em>' reference.
	 * @see #getProcessing()
	 * @generated
	 */
	void setProcessing(Processing value);
} // ProcessingProperty
