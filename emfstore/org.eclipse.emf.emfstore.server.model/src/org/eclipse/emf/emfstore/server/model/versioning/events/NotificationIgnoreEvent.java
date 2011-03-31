/*******************************************************************************
 * Copyright (c) 2008-2011 Chair for Applied Software Engineering, Technische Universitaet Muenchen.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 ******************************************************************************/
package org.eclipse.emf.emfstore.server.model.versioning.events;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Notification Ignore Event</b></em>'. <!--
 * end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.emf.emfstore.server.model.versioning.events.NotificationIgnoreEvent#getNotificationId <em>Notification Id</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.emf.emfstore.server.model.versioning.events.EventsPackage#getNotificationIgnoreEvent()
 * @model
 * @generated
 */
public interface NotificationIgnoreEvent extends Event {
	/**
	 * Returns the value of the '<em><b>Notification Id</b></em>' attribute. The default value is <code>""</code>. <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Notification Id</em>' attribute isn't clear, there really should be more of a
	 * description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Notification Id</em>' attribute.
	 * @see #setNotificationId(String)
	 * @see org.eclipse.emf.emfstore.server.model.versioning.events.EventsPackage#getNotificationIgnoreEvent_NotificationId()
	 * @model default=""
	 * @generated
	 */
	String getNotificationId();

	/**
	 * Sets the value of the '{@link org.eclipse.emf.emfstore.server.model.versioning.events.NotificationIgnoreEvent#getNotificationId <em>Notification Id</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Notification Id</em>' attribute.
	 * @see #getNotificationId()
	 * @generated
	 */
	void setNotificationId(String value);

} // NotificationIgnoreEvent
