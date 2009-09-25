/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.emfstore.esmodel.versioning.events.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.unicase.emfstore.esmodel.notification.ESNotification;
import org.unicase.emfstore.esmodel.versioning.events.EventsPackage;
import org.unicase.emfstore.esmodel.versioning.events.NotificationGenerationEvent;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Notification Generation Event</b></em>'. <!--
 * end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link org.unicase.emfstore.esmodel.versioning.events.impl.NotificationGenerationEventImpl#getNotifications <em>
 * Notifications</em>}</li>
 * </ul>
 * </p>
 * 
 * @generated
 */
public class NotificationGenerationEventImpl extends EventImpl implements NotificationGenerationEvent {
	/**
	 * The cached value of the '{@link #getNotifications() <em>Notifications</em>}' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getNotifications()
	 * @generated
	 * @ordered
	 */
	protected EList<ESNotification> notifications;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected NotificationGenerationEventImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return EventsPackage.Literals.NOTIFICATION_GENERATION_EVENT;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EList<ESNotification> getNotifications() {
		if (notifications == null) {
			notifications = new EObjectContainmentEList.Resolving<ESNotification>(ESNotification.class, this,
				EventsPackage.NOTIFICATION_GENERATION_EVENT__NOTIFICATIONS);
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
		case EventsPackage.NOTIFICATION_GENERATION_EVENT__NOTIFICATIONS:
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
		case EventsPackage.NOTIFICATION_GENERATION_EVENT__NOTIFICATIONS:
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
		case EventsPackage.NOTIFICATION_GENERATION_EVENT__NOTIFICATIONS:
			getNotifications().clear();
			getNotifications().addAll((Collection<? extends ESNotification>) newValue);
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
		case EventsPackage.NOTIFICATION_GENERATION_EVENT__NOTIFICATIONS:
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
		case EventsPackage.NOTIFICATION_GENERATION_EVENT__NOTIFICATIONS:
			return notifications != null && !notifications.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} // NotificationGenerationEventImpl
