/**
 */
package metamodelHCL;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Resolution Property</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link metamodelHCL.ResolutionProperty#getType <em>Type</em>}</li>
 * </ul>
 *
 * @see metamodelHCL.MetamodelHCLPackage#getResolutionProperty()
 * @model
 * @generated
 */
public interface ResolutionProperty extends DisplayProperty {
	/**
	 * Returns the value of the '<em><b>Type</b></em>' attribute.
	 * The default value is <code>""</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Type</em>' attribute.
	 * @see #setType(String)
	 * @see metamodelHCL.MetamodelHCLPackage#getResolutionProperty_Type()
	 * @model default="" required="true"
	 * @generated
	 */
	String getType();

	/**
	 * Sets the value of the '{@link metamodelHCL.ResolutionProperty#getType <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type</em>' attribute.
	 * @see #getType()
	 * @generated
	 */
	void setType(String value);

} // ResolutionProperty
