/**
 */
package metamodelHCL;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Display</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link metamodelHCL.Display#getDisplayproperty <em>Displayproperty</em>}</li>
 * </ul>
 *
 * @see metamodelHCL.MetamodelHCLPackage#getDisplay()
 * @model
 * @generated
 */
public interface Display extends Component {
	/**
	 * Returns the value of the '<em><b>Displayproperty</b></em>' containment reference list.
	 * The list contents are of type {@link metamodelHCL.DisplayProperty}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Displayproperty</em>' containment reference list.
	 * @see metamodelHCL.MetamodelHCLPackage#getDisplay_Displayproperty()
	 * @model containment="true" lower="2" upper="2"
	 * @generated
	 */
	EList<DisplayProperty> getDisplayproperty();

} // Display
