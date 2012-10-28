/**
 * <copyright> Copyright (c) 2009-2012 Chair of Applied Software Engineering, Technische Universität München (TUM).
 * All rights reserved. This program and the accompanying materials are made available under the terms of
 * the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.dashboard.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.unicase.dashboard.DashboardNotification;
import org.unicase.dashboard.DashboardNotificationComposite;
import org.unicase.dashboard.DashboardPackage;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Notification Composite</b></em>'. <!--
 * end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link org.unicase.dashboard.impl.DashboardNotificationCompositeImpl#getNotifications <em>Notifications</em>}</li>
 * </ul>
 * </p>
 * 
 * @generated
 */
public class DashboardNotificationCompositeImpl extends EObjectImpl implements DashboardNotificationComposite {
	/**
	 * The cached value of the '{@link #getNotifications() <em>Notifications</em>}' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getNotifications()
	 * @generated
	 * @ordered
	 */
	protected EList<DashboardNotification> notifications;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected DashboardNotificationCompositeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DashboardPackage.Literals.DASHBOARD_NOTIFICATION_COMPOSITE;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EList<DashboardNotification> getNotifications() {
		if (notifications == null) {
			notifications = new EObjectContainmentEList.Resolving<DashboardNotification>(DashboardNotification.class,
				this, DashboardPackage.DASHBOARD_NOTIFICATION_COMPOSITE__NOTIFICATIONS);
		}
		return notifications;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
		case DashboardPackage.DASHBOARD_NOTIFICATION_COMPOSITE__NOTIFICATIONS:
			return ((InternalEList<?>) getNotifications()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
		case DashboardPackage.DASHBOARD_NOTIFICATION_COMPOSITE__NOTIFICATIONS:
			return getNotifications();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
		case DashboardPackage.DASHBOARD_NOTIFICATION_COMPOSITE__NOTIFICATIONS:
			getNotifications().clear();
			getNotifications().addAll((Collection<? extends DashboardNotification>) newValue);
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
		case DashboardPackage.DASHBOARD_NOTIFICATION_COMPOSITE__NOTIFICATIONS:
			getNotifications().clear();
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
		case DashboardPackage.DASHBOARD_NOTIFICATION_COMPOSITE__NOTIFICATIONS:
			return notifications != null && !notifications.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} // DashboardNotificationCompositeImpl
