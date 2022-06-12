/**
 */
package metamodelHCL.impl;

import metamodelHCL.MetamodelHCLPackage;
import metamodelHCL.Storage;
import metamodelHCL.StorageProperty;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Storage</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link metamodelHCL.impl.StorageImpl#getStorageproperty <em>Storageproperty</em>}</li>
 * </ul>
 *
 * @generated
 */
public class StorageImpl extends ComponentImpl implements Storage {
	/**
	 * The cached value of the '{@link #getStorageproperty() <em>Storageproperty</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStorageproperty()
	 * @generated
	 * @ordered
	 */
	protected StorageProperty storageproperty;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected StorageImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return MetamodelHCLPackage.Literals.STORAGE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StorageProperty getStorageproperty() {
		return storageproperty;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetStorageproperty(StorageProperty newStorageproperty, NotificationChain msgs) {
		StorageProperty oldStorageproperty = storageproperty;
		storageproperty = newStorageproperty;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET,
					MetamodelHCLPackage.STORAGE__STORAGEPROPERTY, oldStorageproperty, newStorageproperty);
			if (msgs == null)
				msgs = notification;
			else
				msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setStorageproperty(StorageProperty newStorageproperty) {
		if (newStorageproperty != storageproperty) {
			NotificationChain msgs = null;
			if (storageproperty != null)
				msgs = ((InternalEObject) storageproperty).eInverseRemove(this,
						EOPPOSITE_FEATURE_BASE - MetamodelHCLPackage.STORAGE__STORAGEPROPERTY, null, msgs);
			if (newStorageproperty != null)
				msgs = ((InternalEObject) newStorageproperty).eInverseAdd(this,
						EOPPOSITE_FEATURE_BASE - MetamodelHCLPackage.STORAGE__STORAGEPROPERTY, null, msgs);
			msgs = basicSetStorageproperty(newStorageproperty, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MetamodelHCLPackage.STORAGE__STORAGEPROPERTY,
					newStorageproperty, newStorageproperty));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
		case MetamodelHCLPackage.STORAGE__STORAGEPROPERTY:
			return basicSetStorageproperty(null, msgs);
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
		case MetamodelHCLPackage.STORAGE__STORAGEPROPERTY:
			return getStorageproperty();
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
		case MetamodelHCLPackage.STORAGE__STORAGEPROPERTY:
			setStorageproperty((StorageProperty) newValue);
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
		case MetamodelHCLPackage.STORAGE__STORAGEPROPERTY:
			setStorageproperty((StorageProperty) null);
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
		case MetamodelHCLPackage.STORAGE__STORAGEPROPERTY:
			return storageproperty != null;
		}
		return super.eIsSet(featureID);
	}

} //StorageImpl
