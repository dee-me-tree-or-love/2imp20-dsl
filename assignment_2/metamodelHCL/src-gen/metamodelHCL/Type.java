/**
 */
package metamodelHCL;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link metamodelHCL.Type#getDtype <em>Dtype</em>}</li>
 * </ul>
 *
 * @see metamodelHCL.MetamodelHCLPackage#getType()
 * @model
 * @generated
 */
public interface Type extends DisplayProperty {
	/**
	 * Returns the value of the '<em><b>Dtype</b></em>' attribute.
	 * The default value is <code>"FiveK"</code>.
	 * The literals are from the enumeration {@link metamodelHCL.DisplayTypeEnum}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Dtype</em>' attribute.
	 * @see metamodelHCL.DisplayTypeEnum
	 * @see #setDtype(DisplayTypeEnum)
	 * @see metamodelHCL.MetamodelHCLPackage#getType_Dtype()
	 * @model default="FiveK" required="true"
	 * @generated
	 */
	DisplayTypeEnum getDtype();

	/**
	 * Sets the value of the '{@link metamodelHCL.Type#getDtype <em>Dtype</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Dtype</em>' attribute.
	 * @see metamodelHCL.DisplayTypeEnum
	 * @see #getDtype()
	 * @generated
	 */
	void setDtype(DisplayTypeEnum value);

} // Type
