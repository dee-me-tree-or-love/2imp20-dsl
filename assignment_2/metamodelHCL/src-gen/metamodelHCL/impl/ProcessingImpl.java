/**
 */
package metamodelHCL.impl;

import java.util.Collection;

import metamodelHCL.MetamodelHCLPackage;
import metamodelHCL.Processing;
import metamodelHCL.ProcessingProperty;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Processing</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link metamodelHCL.impl.ProcessingImpl#getProcessingproperty <em>Processingproperty</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ProcessingImpl extends ComponentImpl implements Processing {
	/**
	 * The cached value of the '{@link #getProcessingproperty() <em>Processingproperty</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getProcessingproperty()
	 * @generated
	 * @ordered
	 */
	protected EList<ProcessingProperty> processingproperty;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ProcessingImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return MetamodelHCLPackage.Literals.PROCESSING;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ProcessingProperty> getProcessingproperty() {
		if (processingproperty == null) {
			processingproperty = new EObjectContainmentEList<ProcessingProperty>(ProcessingProperty.class, this,
					MetamodelHCLPackage.PROCESSING__PROCESSINGPROPERTY);
		}
		return processingproperty;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
		case MetamodelHCLPackage.PROCESSING__PROCESSINGPROPERTY:
			return ((InternalEList<?>) getProcessingproperty()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
		case MetamodelHCLPackage.PROCESSING__PROCESSINGPROPERTY:
			return getProcessingproperty();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
		case MetamodelHCLPackage.PROCESSING__PROCESSINGPROPERTY:
			getProcessingproperty().clear();
			getProcessingproperty().addAll((Collection<? extends ProcessingProperty>) newValue);
			return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
		case MetamodelHCLPackage.PROCESSING__PROCESSINGPROPERTY:
			getProcessingproperty().clear();
			return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
		case MetamodelHCLPackage.PROCESSING__PROCESSINGPROPERTY:
			return processingproperty != null && !processingproperty.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //ProcessingImpl
