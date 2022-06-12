/**
 */
package metamodelHCL.impl;

import java.util.Collection;

import metamodelHCL.Display;
import metamodelHCL.DisplayProperty;
import metamodelHCL.MetamodelHCLPackage;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Display</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link metamodelHCL.impl.DisplayImpl#getDisplayproperty <em>Displayproperty</em>}</li>
 * </ul>
 *
 * @generated
 */
public class DisplayImpl extends ComponentImpl implements Display {
	/**
	 * The cached value of the '{@link #getDisplayproperty() <em>Displayproperty</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDisplayproperty()
	 * @generated
	 * @ordered
	 */
	protected EList<DisplayProperty> displayproperty;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DisplayImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return MetamodelHCLPackage.Literals.DISPLAY;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<DisplayProperty> getDisplayproperty() {
		if (displayproperty == null) {
			displayproperty = new EObjectContainmentEList<DisplayProperty>(DisplayProperty.class, this,
					MetamodelHCLPackage.DISPLAY__DISPLAYPROPERTY);
		}
		return displayproperty;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
		case MetamodelHCLPackage.DISPLAY__DISPLAYPROPERTY:
			return ((InternalEList<?>) getDisplayproperty()).basicRemove(otherEnd, msgs);
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
		case MetamodelHCLPackage.DISPLAY__DISPLAYPROPERTY:
			return getDisplayproperty();
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
		case MetamodelHCLPackage.DISPLAY__DISPLAYPROPERTY:
			getDisplayproperty().clear();
			getDisplayproperty().addAll((Collection<? extends DisplayProperty>) newValue);
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
		case MetamodelHCLPackage.DISPLAY__DISPLAYPROPERTY:
			getDisplayproperty().clear();
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
		case MetamodelHCLPackage.DISPLAY__DISPLAYPROPERTY:
			return displayproperty != null && !displayproperty.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //DisplayImpl
