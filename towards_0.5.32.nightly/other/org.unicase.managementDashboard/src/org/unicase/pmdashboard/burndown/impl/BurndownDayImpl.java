/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.pmdashboard.burndown.impl;

import java.util.Date;
import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.unicase.pmdashboard.burndown.BurndownDay;
import org.unicase.pmdashboard.burndown.BurndownPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Day</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.unicase.pmdashboard.burndown.impl.BurndownDayImpl#getOpenTaskCount <em>Open Task Count</em>}</li>
 *   <li>{@link org.unicase.pmdashboard.burndown.impl.BurndownDayImpl#getRemainingEstimate <em>Remaining Estimate</em>}</li>
 *   <li>{@link org.unicase.pmdashboard.burndown.impl.BurndownDayImpl#getDate <em>Date</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class BurndownDayImpl extends EObjectImpl implements BurndownDay {
	/**
	 * The default value of the '{@link #getOpenTaskCount() <em>Open Task Count</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOpenTaskCount()
	 * @generated
	 * @ordered
	 */
	protected static final int OPEN_TASK_COUNT_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getOpenTaskCount() <em>Open Task Count</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOpenTaskCount()
	 * @generated
	 * @ordered
	 */
	protected int openTaskCount = OPEN_TASK_COUNT_EDEFAULT;

	/**
	 * The default value of the '{@link #getRemainingEstimate() <em>Remaining Estimate</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRemainingEstimate()
	 * @generated
	 * @ordered
	 */
	protected static final int REMAINING_ESTIMATE_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getRemainingEstimate() <em>Remaining Estimate</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRemainingEstimate()
	 * @generated
	 * @ordered
	 */
	protected int remainingEstimate = REMAINING_ESTIMATE_EDEFAULT;

	/**
	 * The default value of the '{@link #getDate() <em>Date</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDate()
	 * @generated
	 * @ordered
	 */
	protected static final Date DATE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getDate() <em>Date</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDate()
	 * @generated
	 * @ordered
	 */
	protected Date date = DATE_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected BurndownDayImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return BurndownPackage.Literals.BURNDOWN_DAY;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getOpenTaskCount() {
		return openTaskCount;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOpenTaskCount(int newOpenTaskCount) {
		int oldOpenTaskCount = openTaskCount;
		openTaskCount = newOpenTaskCount;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, BurndownPackage.BURNDOWN_DAY__OPEN_TASK_COUNT, oldOpenTaskCount, openTaskCount));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getRemainingEstimate() {
		return remainingEstimate;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRemainingEstimate(int newRemainingEstimate) {
		int oldRemainingEstimate = remainingEstimate;
		remainingEstimate = newRemainingEstimate;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, BurndownPackage.BURNDOWN_DAY__REMAINING_ESTIMATE, oldRemainingEstimate, remainingEstimate));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Date getDate() {
		return date;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDate(Date newDate) {
		Date oldDate = date;
		date = newDate;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, BurndownPackage.BURNDOWN_DAY__DATE, oldDate, date));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case BurndownPackage.BURNDOWN_DAY__OPEN_TASK_COUNT:
				return getOpenTaskCount();
			case BurndownPackage.BURNDOWN_DAY__REMAINING_ESTIMATE:
				return getRemainingEstimate();
			case BurndownPackage.BURNDOWN_DAY__DATE:
				return getDate();
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
			case BurndownPackage.BURNDOWN_DAY__OPEN_TASK_COUNT:
				setOpenTaskCount((Integer)newValue);
				return;
			case BurndownPackage.BURNDOWN_DAY__REMAINING_ESTIMATE:
				setRemainingEstimate((Integer)newValue);
				return;
			case BurndownPackage.BURNDOWN_DAY__DATE:
				setDate((Date)newValue);
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
			case BurndownPackage.BURNDOWN_DAY__OPEN_TASK_COUNT:
				setOpenTaskCount(OPEN_TASK_COUNT_EDEFAULT);
				return;
			case BurndownPackage.BURNDOWN_DAY__REMAINING_ESTIMATE:
				setRemainingEstimate(REMAINING_ESTIMATE_EDEFAULT);
				return;
			case BurndownPackage.BURNDOWN_DAY__DATE:
				setDate(DATE_EDEFAULT);
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
			case BurndownPackage.BURNDOWN_DAY__OPEN_TASK_COUNT:
				return openTaskCount != OPEN_TASK_COUNT_EDEFAULT;
			case BurndownPackage.BURNDOWN_DAY__REMAINING_ESTIMATE:
				return remainingEstimate != REMAINING_ESTIMATE_EDEFAULT;
			case BurndownPackage.BURNDOWN_DAY__DATE:
				return DATE_EDEFAULT == null ? date != null : !DATE_EDEFAULT.equals(date);
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
		result.append(" (openTaskCount: ");
		result.append(openTaskCount);
		result.append(", remainingEstimate: ");
		result.append(remainingEstimate);
		result.append(", date: ");
		result.append(date);
		result.append(')');
		return result.toString();
	}

} //BurndownDayImpl
