/**
 */
package metamodelHCL.util;

import metamodelHCL.*;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.util.Switch;

/**
 * <!-- begin-user-doc -->
 * The <b>Switch</b> for the model's inheritance hierarchy.
 * It supports the call {@link #doSwitch(EObject) doSwitch(object)}
 * to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object
 * and proceeding up the inheritance hierarchy
 * until a non-null result is returned,
 * which is the result of the switch.
 * <!-- end-user-doc -->
 * @see metamodelHCL.MetamodelHCLPackage
 * @generated
 */
public class MetamodelHCLSwitch<T> extends Switch<T> {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static MetamodelHCLPackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MetamodelHCLSwitch() {
		if (modelPackage == null) {
			modelPackage = MetamodelHCLPackage.eINSTANCE;
		}
	}

	/**
	 * Checks whether this is a switch for the given package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param ePackage the package in question.
	 * @return whether this is a switch for the given package.
	 * @generated
	 */
	@Override
	protected boolean isSwitchFor(EPackage ePackage) {
		return ePackage == modelPackage;
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	@Override
	protected T doSwitch(int classifierID, EObject theEObject) {
		switch (classifierID) {
		case MetamodelHCLPackage.COMPONENT: {
			Component component = (Component) theEObject;
			T result = caseComponent(component);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case MetamodelHCLPackage.PROCESSING: {
			Processing processing = (Processing) theEObject;
			T result = caseProcessing(processing);
			if (result == null)
				result = caseComponent(processing);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case MetamodelHCLPackage.STORAGE: {
			Storage storage = (Storage) theEObject;
			T result = caseStorage(storage);
			if (result == null)
				result = caseComponent(storage);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case MetamodelHCLPackage.DISPLAY: {
			Display display = (Display) theEObject;
			T result = caseDisplay(display);
			if (result == null)
				result = caseComponent(display);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case MetamodelHCLPackage.REUSED_COMPONENT: {
			ReusedComponent reusedComponent = (ReusedComponent) theEObject;
			T result = caseReusedComponent(reusedComponent);
			if (result == null)
				result = caseComponent(reusedComponent);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case MetamodelHCLPackage.PROCESSING_PROPERTY: {
			ProcessingProperty processingProperty = (ProcessingProperty) theEObject;
			T result = caseProcessingProperty(processingProperty);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case MetamodelHCLPackage.STORAGE_PROPERTY: {
			StorageProperty storageProperty = (StorageProperty) theEObject;
			T result = caseStorageProperty(storageProperty);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case MetamodelHCLPackage.DISPLAY_PROPERTY: {
			DisplayProperty displayProperty = (DisplayProperty) theEObject;
			T result = caseDisplayProperty(displayProperty);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case MetamodelHCLPackage.L1_CACHE_PROPERTY: {
			L1CacheProperty l1CacheProperty = (L1CacheProperty) theEObject;
			T result = caseL1CacheProperty(l1CacheProperty);
			if (result == null)
				result = caseCacheProperty(l1CacheProperty);
			if (result == null)
				result = caseProcessingProperty(l1CacheProperty);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case MetamodelHCLPackage.L2_CACHE_PROPERTY: {
			L2CacheProperty l2CacheProperty = (L2CacheProperty) theEObject;
			T result = caseL2CacheProperty(l2CacheProperty);
			if (result == null)
				result = caseCacheProperty(l2CacheProperty);
			if (result == null)
				result = caseProcessingProperty(l2CacheProperty);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case MetamodelHCLPackage.L3_CACHE_PROPERTY: {
			L3CacheProperty l3CacheProperty = (L3CacheProperty) theEObject;
			T result = caseL3CacheProperty(l3CacheProperty);
			if (result == null)
				result = caseCacheProperty(l3CacheProperty);
			if (result == null)
				result = caseProcessingProperty(l3CacheProperty);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case MetamodelHCLPackage.SINGLE_STORAGE: {
			SingleStorage singleStorage = (SingleStorage) theEObject;
			T result = caseSingleStorage(singleStorage);
			if (result == null)
				result = caseStorageProperty(singleStorage);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case MetamodelHCLPackage.DIAGONAL_PROPERTY: {
			DiagonalProperty diagonalProperty = (DiagonalProperty) theEObject;
			T result = caseDiagonalProperty(diagonalProperty);
			if (result == null)
				result = caseDisplayProperty(diagonalProperty);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case MetamodelHCLPackage.RESOLUTION_PROPERTY: {
			ResolutionProperty resolutionProperty = (ResolutionProperty) theEObject;
			T result = caseResolutionProperty(resolutionProperty);
			if (result == null)
				result = caseDisplayProperty(resolutionProperty);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case MetamodelHCLPackage.COMPUTER: {
			Computer computer = (Computer) theEObject;
			T result = caseComputer(computer);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case MetamodelHCLPackage.MODEL: {
			Model model = (Model) theEObject;
			T result = caseModel(model);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case MetamodelHCLPackage.CORES_PROPERTY: {
			CoresProperty coresProperty = (CoresProperty) theEObject;
			T result = caseCoresProperty(coresProperty);
			if (result == null)
				result = caseProcessingProperty(coresProperty);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case MetamodelHCLPackage.SPEED_PROPERTY: {
			SpeedProperty speedProperty = (SpeedProperty) theEObject;
			T result = caseSpeedProperty(speedProperty);
			if (result == null)
				result = caseProcessingProperty(speedProperty);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case MetamodelHCLPackage.CACHE_PROPERTY: {
			CacheProperty cacheProperty = (CacheProperty) theEObject;
			T result = caseCacheProperty(cacheProperty);
			if (result == null)
				result = caseProcessingProperty(cacheProperty);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		default:
			return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Component</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Component</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseComponent(Component object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Processing</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Processing</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseProcessing(Processing object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Storage</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Storage</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseStorage(Storage object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Display</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Display</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDisplay(Display object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Reused Component</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Reused Component</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseReusedComponent(ReusedComponent object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Processing Property</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Processing Property</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseProcessingProperty(ProcessingProperty object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Storage Property</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Storage Property</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseStorageProperty(StorageProperty object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Display Property</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Display Property</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDisplayProperty(DisplayProperty object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>L1 Cache Property</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>L1 Cache Property</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseL1CacheProperty(L1CacheProperty object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>L2 Cache Property</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>L2 Cache Property</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseL2CacheProperty(L2CacheProperty object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>L3 Cache Property</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>L3 Cache Property</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseL3CacheProperty(L3CacheProperty object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Single Storage</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Single Storage</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSingleStorage(SingleStorage object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Diagonal Property</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Diagonal Property</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDiagonalProperty(DiagonalProperty object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Resolution Property</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Resolution Property</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseResolutionProperty(ResolutionProperty object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Computer</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Computer</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseComputer(Computer object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Model</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Model</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseModel(Model object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Cores Property</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Cores Property</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCoresProperty(CoresProperty object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Speed Property</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Speed Property</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSpeedProperty(SpeedProperty object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Cache Property</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Cache Property</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCacheProperty(CacheProperty object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch, but this is the last case anyway.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject)
	 * @generated
	 */
	@Override
	public T defaultCase(EObject object) {
		return null;
	}

} //MetamodelHCLSwitch
