/**
 */
package metamodelHCL;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Processing</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link metamodelHCL.Processing#getProperties <em>Properties</em>}</li>
 * </ul>
 *
 * @see metamodelHCL.MetamodelHCLPackage#getProcessing()
 * @model
 * @generated
 */
public interface Processing extends Component {
	/**
	 * Returns the value of the '<em><b>Properties</b></em>' containment reference list.
	 * The list contents are of type {@link metamodelHCL.ProcessingProperty}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Properties</em>' containment reference list.
	 * @see metamodelHCL.MetamodelHCLPackage#getProcessing_Properties()
	 * @model containment="true" upper="5"
	 * @generated
	 */
	EList<ProcessingProperty> getProperties();

} // Processing
