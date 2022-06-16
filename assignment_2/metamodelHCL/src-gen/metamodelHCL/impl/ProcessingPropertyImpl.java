/**
 */
package metamodelHCL.impl;

import metamodelHCL.MetamodelHCLPackage;
import metamodelHCL.Processing;
import metamodelHCL.ProcessingProperty;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Processing Property</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link metamodelHCL.impl.ProcessingPropertyImpl#getProcessing <em>Processing</em>}</li>
 * </ul>
 *
 * @generated
 */
public abstract class ProcessingPropertyImpl extends MinimalEObjectImpl.Container implements ProcessingProperty {
	/**
	 * The cached value of the '{@link #getProcessing() <em>Processing</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getProcessing()
	 * @generated
	 * @ordered
	 */
	protected Processing processing;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ProcessingPropertyImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return MetamodelHCLPackage.Literals.PROCESSING_PROPERTY;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Processing getProcessing() {
		if (processing != null && processing.eIsProxy()) {
			InternalEObject oldProcessing = (InternalEObject) processing;
			processing = (Processing) eResolveProxy(oldProcessing);
			if (processing != oldProcessing) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE,
							MetamodelHCLPackage.PROCESSING_PROPERTY__PROCESSING, oldProcessing, processing));
			}
		}
		return processing;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Processing basicGetProcessing() {
		return processing;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setProcessing(Processing newProcessing) {
		Processing oldProcessing = processing;
		processing = newProcessing;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MetamodelHCLPackage.PROCESSING_PROPERTY__PROCESSING,
					oldProcessing, processing));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
		case MetamodelHCLPackage.PROCESSING_PROPERTY__PROCESSING:
			if (resolve)
				return getProcessing();
			return basicGetProcessing();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
		case MetamodelHCLPackage.PROCESSING_PROPERTY__PROCESSING:
			setProcessing((Processing) newValue);
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
		case MetamodelHCLPackage.PROCESSING_PROPERTY__PROCESSING:
			setProcessing((Processing) null);
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
		case MetamodelHCLPackage.PROCESSING_PROPERTY__PROCESSING:
			return processing != null;
		}
		return super.eIsSet(featureID);
	}

} //ProcessingPropertyImpl
