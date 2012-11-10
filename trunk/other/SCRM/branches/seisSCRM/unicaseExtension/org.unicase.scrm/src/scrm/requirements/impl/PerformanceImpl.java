/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package scrm.requirements.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

import scrm.requirements.Hardware;
import scrm.requirements.Performance;
import scrm.requirements.RequirementsPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Performance</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link scrm.requirements.impl.PerformanceImpl#getHardware <em>Hardware</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class PerformanceImpl extends RequirementImpl implements Performance {
	/**
	 * The cached value of the '{@link #getHardware() <em>Hardware</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getHardware()
	 * @generated
	 * @ordered
	 */
	protected Hardware hardware;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected PerformanceImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return RequirementsPackage.Literals.PERFORMANCE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Hardware getHardware() {
		if (hardware != null && hardware.eIsProxy()) {
			InternalEObject oldHardware = (InternalEObject) hardware;
			hardware = (Hardware) eResolveProxy(oldHardware);
			if (hardware != oldHardware) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE,
							RequirementsPackage.PERFORMANCE__HARDWARE,
							oldHardware, hardware));
			}
		}
		return hardware;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Hardware basicGetHardware() {
		return hardware;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setHardware(Hardware newHardware) {
		Hardware oldHardware = hardware;
		hardware = newHardware;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					RequirementsPackage.PERFORMANCE__HARDWARE, oldHardware,
					hardware));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
		case RequirementsPackage.PERFORMANCE__HARDWARE:
			if (resolve)
				return getHardware();
			return basicGetHardware();
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
		case RequirementsPackage.PERFORMANCE__HARDWARE:
			setHardware((Hardware) newValue);
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
		case RequirementsPackage.PERFORMANCE__HARDWARE:
			setHardware((Hardware) null);
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
		case RequirementsPackage.PERFORMANCE__HARDWARE:
			return hardware != null;
		}
		return super.eIsSet(featureID);
	}

} //PerformanceImpl
