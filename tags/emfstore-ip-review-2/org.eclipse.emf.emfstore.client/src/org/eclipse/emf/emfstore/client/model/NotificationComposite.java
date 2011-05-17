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
package org.eclipse.emf.emfstore.client.model;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.emfstore.server.model.notification.ESNotification;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Notification Composite</b></em>'. <!--
 * end-user-doc -->
 * 
 * <p>
 * The following features are supported:
 * <ul>
 * <li>{@link org.eclipse.emf.emfstore.client.model.NotificationComposite#getNotifications <em>Notifications</em>}</li>
 * </ul>
 * </p>
 * 
 * @see org.eclipse.emf.emfstore.client.model.ModelPackage#getNotificationComposite()
 * @model
 * @generated
 */
public interface NotificationComposite extends EObject {
	/**
	 * Returns the value of the '<em><b>Notifications</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.emf.emfstore.server.model.notification.ESNotification}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Notifications</em>' containment reference list isn't clear, there really should be
	 * more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Notifications</em>' containment reference list.
	 * @see org.eclipse.emf.emfstore.client.model.ModelPackage#getNotificationComposite_Notifications()
	 * @model containment="true" resolveProxies="true"
	 * @generated
	 */
	EList<ESNotification> getNotifications();

} // NotificationComposite
