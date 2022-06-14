/**
 */
package metamodelHCL;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Single Storage</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link metamodelHCL.SingleStorage#getStype <em>Stype</em>}</li>
 *   <li>{@link metamodelHCL.SingleStorage#getSsize <em>Ssize</em>}</li>
 * </ul>
 *
 * @see metamodelHCL.MetamodelHCLPackage#getSingleStorage()
 * @model
 * @generated
 */
public interface SingleStorage extends StorageProperty {
	/**
	 * Returns the value of the '<em><b>Stype</b></em>' attribute.
	 * The literals are from the enumeration {@link metamodelHCL.StorageTypeEnum}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Stype</em>' attribute.
	 * @see metamodelHCL.StorageTypeEnum
	 * @see #setStype(StorageTypeEnum)
	 * @see metamodelHCL.MetamodelHCLPackage#getSingleStorage_Stype()
	 * @model required="true"
	 * @generated
	 */
	StorageTypeEnum getStype();

	/**
	 * Sets the value of the '{@link metamodelHCL.SingleStorage#getStype <em>Stype</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Stype</em>' attribute.
	 * @see metamodelHCL.StorageTypeEnum
	 * @see #getStype()
	 * @generated
	 */
	void setStype(StorageTypeEnum value);

	/**
	 * Returns the value of the '<em><b>Ssize</b></em>' attribute.
	 * The default value is <code>""</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Ssize</em>' attribute.
	 * @see #setSsize(String)
	 * @see metamodelHCL.MetamodelHCLPackage#getSingleStorage_Ssize()
	 * @model default="" required="true"
	 * @generated
	 */
	String getSsize();

	/**
	 * Sets the value of the '{@link metamodelHCL.SingleStorage#getSsize <em>Ssize</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Ssize</em>' attribute.
	 * @see #getSsize()
	 * @generated
	 */
	void setSsize(String value);

} // SingleStorage
