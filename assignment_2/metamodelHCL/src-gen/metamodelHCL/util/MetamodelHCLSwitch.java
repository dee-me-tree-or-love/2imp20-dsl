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
		case MetamodelHCLPackage.CORES: {
			Cores cores = (Cores) theEObject;
			T result = caseCores(cores);
			if (result == null)
				result = caseProcessingProperty(cores);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case MetamodelHCLPackage.SPEED: {
			Speed speed = (Speed) theEObject;
			T result = caseSpeed(speed);
			if (result == null)
				result = caseProcessingProperty(speed);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case MetamodelHCLPackage.CACHE: {
			Cache cache = (Cache) theEObject;
			T result = caseCache(cache);
			if (result == null)
				result = caseProcessingProperty(cache);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case MetamodelHCLPackage.L1: {
			L1 l1 = (L1) theEObject;
			T result = caseL1(l1);
			if (result == null)
				result = caseCache(l1);
			if (result == null)
				result = caseProcessingProperty(l1);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case MetamodelHCLPackage.L2: {
			L2 l2 = (L2) theEObject;
			T result = caseL2(l2);
			if (result == null)
				result = caseCache(l2);
			if (result == null)
				result = caseProcessingProperty(l2);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case MetamodelHCLPackage.L3: {
			L3 l3 = (L3) theEObject;
			T result = caseL3(l3);
			if (result == null)
				result = caseCache(l3);
			if (result == null)
				result = caseProcessingProperty(l3);
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
		case MetamodelHCLPackage.DIAGONAL: {
			Diagonal diagonal = (Diagonal) theEObject;
			T result = caseDiagonal(diagonal);
			if (result == null)
				result = caseDisplayProperty(diagonal);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case MetamodelHCLPackage.TYPE: {
			Type type = (Type) theEObject;
			T result = caseType(type);
			if (result == null)
				result = caseDisplayProperty(type);
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
	 * Returns the result of interpreting the object as an instance of '<em>Cores</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Cores</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCores(Cores object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Speed</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Speed</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSpeed(Speed object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Cache</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Cache</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCache(Cache object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>L1</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>L1</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseL1(L1 object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>L2</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>L2</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseL2(L2 object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>L3</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>L3</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseL3(L3 object) {
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
	 * Returns the result of interpreting the object as an instance of '<em>Diagonal</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Diagonal</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDiagonal(Diagonal object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseType(Type object) {
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
