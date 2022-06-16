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
 *   <li>{@link metamodelHCL.Storage#getProperties <em>Properties</em>}</li>
 * </ul>
 *
 * @see metamodelHCL.MetamodelHCLPackage#getStorage()
 * @model
 * @generated
 */
public interface Storage extends Component {
	/**
	 * Returns the value of the '<em><b>Properties</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Properties</em>' containment reference.
	 * @see #setProperties(StorageProperty)
	 * @see metamodelHCL.MetamodelHCLPackage#getStorage_Properties()
	 * @model containment="true"
	 * @generated
	 */
	StorageProperty getProperties();

	/**
	 * Sets the value of the '{@link metamodelHCL.Storage#getProperties <em>Properties</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Properties</em>' containment reference.
	 * @see #getProperties()
	 * @generated
	 */
	void setProperties(StorageProperty value);

} // Storage
