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
 *   <li>{@link metamodelHCL.Processing#getProcessingproperty <em>Processingproperty</em>}</li>
 * </ul>
 *
 * @see metamodelHCL.MetamodelHCLPackage#getProcessing()
 * @model
 * @generated
 */
public interface Processing extends Component {
	/**
	 * Returns the value of the '<em><b>Processingproperty</b></em>' containment reference list.
	 * The list contents are of type {@link metamodelHCL.ProcessingProperty}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Processingproperty</em>' containment reference list.
	 * @see metamodelHCL.MetamodelHCLPackage#getProcessing_Processingproperty()
	 * @model containment="true" lower="5" upper="5"
	 * @generated
	 */
	EList<ProcessingProperty> getProcessingproperty();

} // Processing
