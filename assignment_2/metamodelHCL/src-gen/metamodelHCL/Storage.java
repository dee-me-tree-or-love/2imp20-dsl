/**
 */
package metamodelHCL;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Storage</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link metamodelHCL.Storage#getStorageproperty <em>Storageproperty</em>}</li>
 * </ul>
 *
 * @see metamodelHCL.MetamodelHCLPackage#getStorage()
 * @model
 * @generated
 */
public interface Storage extends Component {
	/**
	 * Returns the value of the '<em><b>Storageproperty</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Storageproperty</em>' containment reference.
	 * @see #setStorageproperty(StorageProperty)
	 * @see metamodelHCL.MetamodelHCLPackage#getStorage_Storageproperty()
	 * @model containment="true" required="true"
	 * @generated
	 */
	StorageProperty getStorageproperty();

	/**
	 * Sets the value of the '{@link metamodelHCL.Storage#getStorageproperty <em>Storageproperty</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Storageproperty</em>' containment reference.
	 * @see #getStorageproperty()
	 * @generated
	 */
	void setStorageproperty(StorageProperty value);

} // Storage
