/**
 */
package metamodelHCL;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Storage Property</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link metamodelHCL.StorageProperty#getStorage <em>Storage</em>}</li>
 * </ul>
 *
 * @see metamodelHCL.MetamodelHCLPackage#getStorageProperty()
 * @model abstract="true"
 * @generated
 */
public interface StorageProperty extends EObject {

	/**
	 * Returns the value of the '<em><b>Storage</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Storage</em>' reference.
	 * @see #setStorage(Storage)
	 * @see metamodelHCL.MetamodelHCLPackage#getStorageProperty_Storage()
	 * @model
	 * @generated
	 */
	Storage getStorage();

	/**
	 * Sets the value of the '{@link metamodelHCL.StorageProperty#getStorage <em>Storage</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Storage</em>' reference.
	 * @see #getStorage()
	 * @generated
	 */
	void setStorage(Storage value);
} // StorageProperty
