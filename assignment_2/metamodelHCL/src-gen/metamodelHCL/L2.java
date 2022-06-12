/**
 */
package metamodelHCL;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>L2</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link metamodelHCL.L2#getNumber <em>Number</em>}</li>
 *   <li>{@link metamodelHCL.L2#getType <em>Type</em>}</li>
 * </ul>
 *
 * @see metamodelHCL.MetamodelHCLPackage#getL2()
 * @model
 * @generated
 */
public interface L2 extends Cache {
	/**
	 * Returns the value of the '<em><b>Number</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Number</em>' attribute.
	 * @see #setNumber(int)
	 * @see metamodelHCL.MetamodelHCLPackage#getL2_Number()
	 * @model
	 * @generated
	 */
	int getNumber();

	/**
	 * Sets the value of the '{@link metamodelHCL.L2#getNumber <em>Number</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Number</em>' attribute.
	 * @see #getNumber()
	 * @generated
	 */
	void setNumber(int value);

	/**
	 * Returns the value of the '<em><b>Type</b></em>' attribute.
	 * The default value is <code>"MiB"</code>.
	 * The literals are from the enumeration {@link metamodelHCL.SizeTypeEnum}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Type</em>' attribute.
	 * @see metamodelHCL.SizeTypeEnum
	 * @see #setType(SizeTypeEnum)
	 * @see metamodelHCL.MetamodelHCLPackage#getL2_Type()
	 * @model default="MiB"
	 * @generated
	 */
	SizeTypeEnum getType();

	/**
	 * Sets the value of the '{@link metamodelHCL.L2#getType <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type</em>' attribute.
	 * @see metamodelHCL.SizeTypeEnum
	 * @see #getType()
	 * @generated
	 */
	void setType(SizeTypeEnum value);

} // L2
