/**
 */
package metamodelHCL.impl;

import metamodelHCL.MetamodelHCLPackage;
import metamodelHCL.SingleStorage;
import metamodelHCL.SizeTypeEnum;
import metamodelHCL.StorageTypeEnum;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Single Storage</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link metamodelHCL.impl.SingleStorageImpl#getStype <em>Stype</em>}</li>
 *   <li>{@link metamodelHCL.impl.SingleStorageImpl#getSsize <em>Ssize</em>}</li>
 * </ul>
 *
 * @generated
 */
public class SingleStorageImpl extends StoragePropertyImpl implements SingleStorage {
	/**
	 * The default value of the '{@link #getStype() <em>Stype</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStype()
	 * @generated
	 * @ordered
	 */
	protected static final StorageTypeEnum STYPE_EDEFAULT = StorageTypeEnum.HDD;

	/**
	 * The cached value of the '{@link #getStype() <em>Stype</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStype()
	 * @generated
	 * @ordered
	 */
	protected StorageTypeEnum stype = STYPE_EDEFAULT;

	/**
	 * The default value of the '{@link #getSsize() <em>Ssize</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSsize()
	 * @generated
	 * @ordered
	 */
	protected static final SizeTypeEnum SSIZE_EDEFAULT = SizeTypeEnum.GI_B;

	/**
	 * The cached value of the '{@link #getSsize() <em>Ssize</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSsize()
	 * @generated
	 * @ordered
	 */
	protected SizeTypeEnum ssize = SSIZE_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SingleStorageImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return MetamodelHCLPackage.Literals.SINGLE_STORAGE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StorageTypeEnum getStype() {
		return stype;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setStype(StorageTypeEnum newStype) {
		StorageTypeEnum oldStype = stype;
		stype = newStype == null ? STYPE_EDEFAULT : newStype;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MetamodelHCLPackage.SINGLE_STORAGE__STYPE, oldStype,
					stype));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SizeTypeEnum getSsize() {
		return ssize;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSsize(SizeTypeEnum newSsize) {
		SizeTypeEnum oldSsize = ssize;
		ssize = newSsize == null ? SSIZE_EDEFAULT : newSsize;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MetamodelHCLPackage.SINGLE_STORAGE__SSIZE, oldSsize,
					ssize));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
		case MetamodelHCLPackage.SINGLE_STORAGE__STYPE:
			return getStype();
		case MetamodelHCLPackage.SINGLE_STORAGE__SSIZE:
			return getSsize();
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
		case MetamodelHCLPackage.SINGLE_STORAGE__STYPE:
			setStype((StorageTypeEnum) newValue);
			return;
		case MetamodelHCLPackage.SINGLE_STORAGE__SSIZE:
			setSsize((SizeTypeEnum) newValue);
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
		case MetamodelHCLPackage.SINGLE_STORAGE__STYPE:
			setStype(STYPE_EDEFAULT);
			return;
		case MetamodelHCLPackage.SINGLE_STORAGE__SSIZE:
			setSsize(SSIZE_EDEFAULT);
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
		case MetamodelHCLPackage.SINGLE_STORAGE__STYPE:
			return stype != STYPE_EDEFAULT;
		case MetamodelHCLPackage.SINGLE_STORAGE__SSIZE:
			return ssize != SSIZE_EDEFAULT;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy())
			return super.toString();

		StringBuilder result = new StringBuilder(super.toString());
		result.append(" (stype: ");
		result.append(stype);
		result.append(", ssize: ");
		result.append(ssize);
		result.append(')');
		return result.toString();
	}

} //SingleStorageImpl
