/*******************************************************************************
 * Copyright (c) 2008-2011 Chair for Applied Software Engineering,
 * Technische Universitaet Muenchen.
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
import org.eclipse.emf.emfstore.server.model.versioning.events.NotificationReadEvent;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Notification Read Event</b></em>'. <!--
 * end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link org.eclipse.emf.emfstore.server.model.versioning.events.impl.NotificationReadEventImpl#getNotificationId
 * <em>Notification Id</em>}</li>
 * </ul>
 * </p>
 * 
 * @generated
 */
public class NotificationReadEventImpl extends ReadEventImpl implements NotificationReadEvent {
	/**
	 * The default value of the '{@link #getNotificationId() <em>Notification Id</em>}' attribute.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * 
	 * @see #getNotificationId()
	 * @generated
	 * @ordered
	 */
	protected static final String NOTIFICATION_ID_EDEFAULT = "";

	/**
	 * The cached value of the '{@link #getNotificationId() <em>Notification Id</em>}' attribute.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * 
	 * @see #getNotificationId()
	 * @generated
	 * @ordered
	 */
	protected String notificationId = NOTIFICATION_ID_EDEFAULT;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected NotificationReadEventImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return EventsPackage.Literals.NOTIFICATION_READ_EVENT;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public String getNotificationId() {
		return notificationId;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setNotificationId(String newNotificationId) {
		String oldNotificationId = notificationId;
		notificationId = newNotificationId;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
				EventsPackage.NOTIFICATION_READ_EVENT__NOTIFICATION_ID, oldNotificationId, notificationId));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
		case EventsPackage.NOTIFICATION_READ_EVENT__NOTIFICATION_ID:
			return getNotificationId();
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
		case EventsPackage.NOTIFICATION_READ_EVENT__NOTIFICATION_ID:
			setNotificationId((String) newValue);
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
		case EventsPackage.NOTIFICATION_READ_EVENT__NOTIFICATION_ID:
			setNotificationId(NOTIFICATION_ID_EDEFAULT);
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
		case EventsPackage.NOTIFICATION_READ_EVENT__NOTIFICATION_ID:
			return NOTIFICATION_ID_EDEFAULT == null ? notificationId != null : !NOTIFICATION_ID_EDEFAULT
				.equals(notificationId);
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
		result.append(" (notificationId: ");
		result.append(notificationId);
		result.append(')');
		return result.toString();
	}

} // NotificationReadEventImpl
