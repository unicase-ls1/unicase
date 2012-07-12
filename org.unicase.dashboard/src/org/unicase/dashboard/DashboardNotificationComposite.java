/**
 * <copyright> Copyright (c) 2009-2012 Chair of Applied Software Engineering, Technische Universität München (TUM).
 * All rights reserved. This program and the accompanying materials are made available under the terms of
 * the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.dashboard;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Notification Composite</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.unicase.dashboard.DashboardNotificationComposite#getNotifications <em>Notifications</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.unicase.dashboard.DashboardPackage#getDashboardNotificationComposite()
 * @model
 * @generated
 */
public interface DashboardNotificationComposite extends EObject {
	/**
	 * Returns the value of the '<em><b>Notifications</b></em>' containment reference list.
	 * The list contents are of type {@link org.unicase.dashboard.DashboardNotification}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Notifications</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Notifications</em>' containment reference list.
	 * @see org.unicase.dashboard.DashboardPackage#getDashboardNotificationComposite_Notifications()
	 * @model containment="true" resolveProxies="true"
	 * @generated
	 */
	EList<DashboardNotification> getNotifications();

} // DashboardNotificationComposite
