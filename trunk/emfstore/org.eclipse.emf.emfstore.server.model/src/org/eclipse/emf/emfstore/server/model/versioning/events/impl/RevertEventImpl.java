/*******************************************************************************
 * Copyright (c) 2008-2011 Chair for Applied Software Engineering, Technische Universitaet Muenchen.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 ******************************************************************************/
package org.eclipse.emf.emfstore.server.model.versioning.events.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.emfstore.server.model.versioning.events.EventsPackage;
import org.eclipse.emf.emfstore.server.model.versioning.events.RevertEvent;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Revert Event</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.emf.emfstore.server.model.versioning.events.impl.RevertEventImpl#getRevertedChangesCount <em>Reverted Changes Count</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class RevertEventImpl extends EventImpl implements RevertEvent {
	/**
	 * The default value of the '{@link #getRevertedChangesCount() <em>Reverted Changes Count</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getRevertedChangesCount()
	 * @generated
	 * @ordered
	 */
	protected static final int REVERTED_CHANGES_COUNT_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getRevertedChangesCount() <em>Reverted Changes Count</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getRevertedChangesCount()
	 * @generated
	 * @ordered
	 */
	protected int revertedChangesCount = REVERTED_CHANGES_COUNT_EDEFAULT;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected RevertEventImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return EventsPackage.Literals.REVERT_EVENT;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public int getRevertedChangesCount() {
		return revertedChangesCount;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setRevertedChangesCount(int newRevertedChangesCount) {
		int oldRevertedChangesCount = revertedChangesCount;
		revertedChangesCount = newRevertedChangesCount;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EventsPackage.REVERT_EVENT__REVERTED_CHANGES_COUNT, oldRevertedChangesCount, revertedChangesCount));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case EventsPackage.REVERT_EVENT__REVERTED_CHANGES_COUNT:
				return getRevertedChangesCount();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case EventsPackage.REVERT_EVENT__REVERTED_CHANGES_COUNT:
				setRevertedChangesCount((Integer)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case EventsPackage.REVERT_EVENT__REVERTED_CHANGES_COUNT:
				setRevertedChangesCount(REVERTED_CHANGES_COUNT_EDEFAULT);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case EventsPackage.REVERT_EVENT__REVERTED_CHANGES_COUNT:
				return revertedChangesCount != REVERTED_CHANGES_COUNT_EDEFAULT;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (revertedChangesCount: ");
		result.append(revertedChangesCount);
		result.append(')');
		return result.toString();
	}

} // RevertEventImpl
