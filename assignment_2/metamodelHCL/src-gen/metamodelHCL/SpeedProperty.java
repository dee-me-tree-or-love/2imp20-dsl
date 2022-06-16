/**
 */
package metamodelHCL;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Speed Property</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link metamodelHCL.SpeedProperty#getSpeed <em>Speed</em>}</li>
 *   <li>{@link metamodelHCL.SpeedProperty#getUnit <em>Unit</em>}</li>
 * </ul>
 *
 * @see metamodelHCL.MetamodelHCLPackage#getSpeedProperty()
 * @model
 * @generated
 */
public interface SpeedProperty extends ProcessingProperty {
	/**
	 * Returns the value of the '<em><b>Speed</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Speed</em>' attribute.
	 * @see #setSpeed(float)
	 * @see metamodelHCL.MetamodelHCLPackage#getSpeedProperty_Speed()
	 * @model required="true"
	 * @generated
	 */
	float getSpeed();

	/**
	 * Sets the value of the '{@link metamodelHCL.SpeedProperty#getSpeed <em>Speed</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Speed</em>' attribute.
	 * @see #getSpeed()
	 * @generated
	 */
	void setSpeed(float value);

	/**
	 * Returns the value of the '<em><b>Unit</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Unit</em>' attribute.
	 * @see #setUnit(String)
	 * @see metamodelHCL.MetamodelHCLPackage#getSpeedProperty_Unit()
	 * @model required="true"
	 * @generated
	 */
	String getUnit();

	/**
	 * Sets the value of the '{@link metamodelHCL.SpeedProperty#getUnit <em>Unit</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Unit</em>' attribute.
	 * @see #getUnit()
	 * @generated
	 */
	void setUnit(String value);

} // SpeedProperty
