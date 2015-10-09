/**
 * <copyright> Copyright (c) 2015-2016 Chair of Applied Software Engineering, Technische Universität München (TUM).
 * All rights reserved. This program and the accompanying materials are made available under the terms of
 * the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.dashboard;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Notification Operation</b></em>'. <!--
 * end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.unicase.dashboard.NotificationOperation#getNotifications <em>Notifications</em>}</li>
 *   <li>{@link org.unicase.dashboard.NotificationOperation#isReversed <em>Reversed</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.unicase.dashboard.DashboardPackage#getNotificationOperation()
 * @model
 * @generated
 */
public interface NotificationOperation
		extends
		org.eclipse.emf.emfstore.internal.server.model.versioning.operations.AbstractOperation,
		org.eclipse.emf.emfstore.internal.common.model.NonDomainElement {

	/**
	 * Returns the value of the '<em><b>Notifications</b></em>' containment reference list.
	 * The list contents are of type {@link org.unicase.dashboard.DashboardNotification}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Notifications</em>' containment reference list isn't clear, there really should be
	 * more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Notifications</em>' containment reference list.
	 * @see org.unicase.dashboard.DashboardPackage#getNotificationOperation_Notifications()
	 * @model containment="true" resolveProxies="true"
	 * @generated
	 */
	EList<DashboardNotification> getNotifications();

	/**
	 * Returns the value of the '<em><b>Reversed</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Reversed</em>' attribute isn't clear, there really should be more of a description
	 * here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Reversed</em>' attribute.
	 * @see #setReversed(boolean)
	 * @see org.unicase.dashboard.DashboardPackage#getNotificationOperation_Reversed()
	 * @model
	 * @generated
	 */
	boolean isReversed();

	/**
	 * Sets the value of the '{@link org.unicase.dashboard.NotificationOperation#isReversed <em>Reversed</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Reversed</em>' attribute.
	 * @see #isReversed()
	 * @generated
	 */
	void setReversed(boolean value);
} // NotificationOperation
