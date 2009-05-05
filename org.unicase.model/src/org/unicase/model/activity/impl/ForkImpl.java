/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.model.activity.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.unicase.model.activity.ActivityPackage;
import org.unicase.model.activity.Fork;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Fork</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link org.unicase.model.activity.impl.ForkImpl#getEntryConditions <em>Entry Conditions</em>}</li>
 * <li>{@link org.unicase.model.activity.impl.ForkImpl#getExitConditions <em>Exit Conditions</em>}</li>
 * </ul>
 * </p>
 * 
 * @generated
 */
public class ForkImpl extends ActivityObjectImpl implements Fork {
	/**
	 * The default value of the '{@link #getEntryConditions() <em>Entry Conditions</em>}' attribute. <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * 
	 * @see #getEntryConditions()
	 * @generated
	 * @ordered
	 */
	protected static final String ENTRY_CONDITIONS_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getEntryConditions() <em>Entry Conditions</em>}' attribute. <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * 
	 * @see #getEntryConditions()
	 * @generated
	 * @ordered
	 */
	protected String entryConditions = ENTRY_CONDITIONS_EDEFAULT;

	/**
	 * The default value of the '{@link #getExitConditions() <em>Exit Conditions</em>}' attribute. <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * 
	 * @see #getExitConditions()
	 * @generated
	 * @ordered
	 */
	protected static final String EXIT_CONDITIONS_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getExitConditions() <em>Exit Conditions</em>}' attribute. <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * 
	 * @see #getExitConditions()
	 * @generated
	 * @ordered
	 */
	protected String exitConditions = EXIT_CONDITIONS_EDEFAULT;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected ForkImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ActivityPackage.Literals.FORK;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public String getEntryConditions() {
		return entryConditions;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setEntryConditions(String newEntryConditions) {
		String oldEntryConditions = entryConditions;
		entryConditions = newEntryConditions;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ActivityPackage.FORK__ENTRY_CONDITIONS,
				oldEntryConditions, entryConditions));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public String getExitConditions() {
		return exitConditions;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setExitConditions(String newExitConditions) {
		String oldExitConditions = exitConditions;
		exitConditions = newExitConditions;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ActivityPackage.FORK__EXIT_CONDITIONS,
				oldExitConditions, exitConditions));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
		case ActivityPackage.FORK__ENTRY_CONDITIONS:
			return getEntryConditions();
		case ActivityPackage.FORK__EXIT_CONDITIONS:
			return getExitConditions();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
		case ActivityPackage.FORK__ENTRY_CONDITIONS:
			setEntryConditions((String) newValue);
			return;
		case ActivityPackage.FORK__EXIT_CONDITIONS:
			setExitConditions((String) newValue);
			return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
		case ActivityPackage.FORK__ENTRY_CONDITIONS:
			setEntryConditions(ENTRY_CONDITIONS_EDEFAULT);
			return;
		case ActivityPackage.FORK__EXIT_CONDITIONS:
			setExitConditions(EXIT_CONDITIONS_EDEFAULT);
			return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
		case ActivityPackage.FORK__ENTRY_CONDITIONS:
			return ENTRY_CONDITIONS_EDEFAULT == null ? entryConditions != null : !ENTRY_CONDITIONS_EDEFAULT
				.equals(entryConditions);
		case ActivityPackage.FORK__EXIT_CONDITIONS:
			return EXIT_CONDITIONS_EDEFAULT == null ? exitConditions != null : !EXIT_CONDITIONS_EDEFAULT
				.equals(exitConditions);
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy())
			return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (entryConditions: ");
		result.append(entryConditions);
		result.append(", exitConditions: ");
		result.append(exitConditions);
		result.append(')');
		return result.toString();
	}

} // ForkImpl
