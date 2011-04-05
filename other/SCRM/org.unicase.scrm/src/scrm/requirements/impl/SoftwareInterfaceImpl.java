/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package scrm.requirements.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import scrm.requirements.RequirementsPackage;
import scrm.requirements.SoftwareInterface;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Software Interface</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link scrm.requirements.impl.SoftwareInterfaceImpl#getDataTypes <em>Data Types</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SoftwareInterfaceImpl extends InterfaceImpl implements SoftwareInterface {
	/**
	 * The default value of the '{@link #getDataTypes() <em>Data Types</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDataTypes()
	 * @generated
	 * @ordered
	 */
	protected static final String DATA_TYPES_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getDataTypes() <em>Data Types</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDataTypes()
	 * @generated
	 * @ordered
	 */
	protected String dataTypes = DATA_TYPES_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SoftwareInterfaceImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return RequirementsPackage.Literals.SOFTWARE_INTERFACE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getDataTypes() {
		return dataTypes;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDataTypes(String newDataTypes) {
		String oldDataTypes = dataTypes;
		dataTypes = newDataTypes;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RequirementsPackage.SOFTWARE_INTERFACE__DATA_TYPES, oldDataTypes, dataTypes));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case RequirementsPackage.SOFTWARE_INTERFACE__DATA_TYPES:
				return getDataTypes();
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
			case RequirementsPackage.SOFTWARE_INTERFACE__DATA_TYPES:
				setDataTypes((String)newValue);
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
			case RequirementsPackage.SOFTWARE_INTERFACE__DATA_TYPES:
				setDataTypes(DATA_TYPES_EDEFAULT);
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
			case RequirementsPackage.SOFTWARE_INTERFACE__DATA_TYPES:
				return DATA_TYPES_EDEFAULT == null ? dataTypes != null : !DATA_TYPES_EDEFAULT.equals(dataTypes);
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
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (dataTypes: ");
		result.append(dataTypes);
		result.append(')');
		return result.toString();
	}

} //SoftwareInterfaceImpl
