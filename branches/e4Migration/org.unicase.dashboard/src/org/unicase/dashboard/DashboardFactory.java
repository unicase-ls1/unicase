/**
 * <copyright> Copyright (c) 2009-2012 Chair of Applied Software Engineering, Technische Universit�t M�nchen (TUM).
 * All rights reserved. This program and the accompanying materials are made available under the terms of
 * the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.dashboard;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc --> The <b>Factory</b> for the model. It provides a create method for each non-abstract class of
 * the model. <!-- end-user-doc -->
 * @see org.unicase.dashboard.DashboardPackage
 * @generated
 */
public interface DashboardFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	DashboardFactory eINSTANCE = org.unicase.dashboard.impl.DashboardFactoryImpl
			.init();

	/**
	 * Returns a new object of class '<em>Notification</em>'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return a new object of class '<em>Notification</em>'.
	 * @generated
	 */
	DashboardNotification createDashboardNotification();

	/**
	 * Returns a new object of class '<em>Notification Composite</em>'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return a new object of class '<em>Notification Composite</em>'.
	 * @generated
	 */
	DashboardNotificationComposite createDashboardNotificationComposite();

	/**
	 * Returns a new object of class '<em>Subscription Composite</em>'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return a new object of class '<em>Subscription Composite</em>'.
	 * @generated
	 */
	SubscriptionComposite createSubscriptionComposite();

	/**
	 * Returns a new object of class '<em>Task Trace Classes Composite</em>'. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @return a new object of class '<em>Task Trace Classes Composite</em>'.
	 * @generated
	 */
	TaskTraceClassesComposite createTaskTraceClassesComposite();

	/**
	 * Returns a new object of class '<em>Notification Operation</em>'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return a new object of class '<em>Notification Operation</em>'.
	 * @generated
	 */
	NotificationOperation createNotificationOperation();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	DashboardPackage getDashboardPackage();

} // DashboardFactory
