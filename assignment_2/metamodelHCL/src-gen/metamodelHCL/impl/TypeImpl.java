/**
 */
package metamodelHCL.impl;

import metamodelHCL.DisplayTypeEnum;
import metamodelHCL.MetamodelHCLPackage;
import metamodelHCL.Type;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link metamodelHCL.impl.TypeImpl#getDtype <em>Dtype</em>}</li>
 * </ul>
 *
 * @generated
 */
public class TypeImpl extends DisplayPropertyImpl implements Type {
	/**
	 * The default value of the '{@link #getDtype() <em>Dtype</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDtype()
	 * @generated
	 * @ordered
	 */
	protected static final DisplayTypeEnum DTYPE_EDEFAULT = DisplayTypeEnum.FIVE_K;

	/**
	 * The cached value of the '{@link #getDtype() <em>Dtype</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDtype()
	 * @generated
	 * @ordered
	 */
	protected DisplayTypeEnum dtype = DTYPE_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TypeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return MetamodelHCLPackage.Literals.TYPE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DisplayTypeEnum getDtype() {
		return dtype;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDtype(DisplayTypeEnum newDtype) {
		DisplayTypeEnum oldDtype = dtype;
		dtype = newDtype == null ? DTYPE_EDEFAULT : newDtype;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MetamodelHCLPackage.TYPE__DTYPE, oldDtype, dtype));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
		case MetamodelHCLPackage.TYPE__DTYPE:
			return getDtype();
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
		case MetamodelHCLPackage.TYPE__DTYPE:
			setDtype((DisplayTypeEnum) newValue);
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
		case MetamodelHCLPackage.TYPE__DTYPE:
			setDtype(DTYPE_EDEFAULT);
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
		case MetamodelHCLPackage.TYPE__DTYPE:
			return dtype != DTYPE_EDEFAULT;
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
		result.append(" (dtype: ");
		result.append(dtype);
		result.append(')');
		return result.toString();
	}

} //TypeImpl
