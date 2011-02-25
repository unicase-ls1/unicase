/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.emfstore.esmodel.versioning.events;

import org.eclipse.emf.common.util.EList;
import org.unicase.emfstore.esmodel.notification.ESNotification;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Notification Generation Event</b></em>'. <!--
 * end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.unicase.emfstore.esmodel.versioning.events.NotificationGenerationEvent#getNotifications <em>Notifications</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.unicase.emfstore.esmodel.versioning.events.EventsPackage#getNotificationGenerationEvent()
 * @model
 * @generated
 */
public interface NotificationGenerationEvent extends Event {
	/**
	 * Returns the value of the '<em><b>Notifications</b></em>' containment reference list.
	 * The list contents are of type {@link org.unicase.emfstore.esmodel.notification.ESNotification}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Notifications</em>' containment reference list isn't clear, there really should be
	 * more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Notifications</em>' containment reference list.
	 * @see org.unicase.emfstore.esmodel.versioning.events.EventsPackage#getNotificationGenerationEvent_Notifications()
	 * @model containment="true" resolveProxies="true" keys="identifier"
	 * @generated
	 */
	EList<ESNotification> getNotifications();

} // NotificationGenerationEvent
