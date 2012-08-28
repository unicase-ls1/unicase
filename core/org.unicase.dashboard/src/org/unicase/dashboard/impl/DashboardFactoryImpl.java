/**
 * <copyright> Copyright (c) 2009-2012 Chair of Applied Software Engineering, Technische Universität München (TUM).
 * All rights reserved. This program and the accompanying materials are made available under the terms of
 * the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.dashboard.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.unicase.dashboard.*;
import org.unicase.dashboard.DashboardFactory;
import org.unicase.dashboard.DashboardNotification;
import org.unicase.dashboard.DashboardNotificationComposite;
import org.unicase.dashboard.DashboardPackage;
import org.unicase.dashboard.SubscriptionComposite;
import org.unicase.dashboard.TaskTraceClassesComposite;

/**
 * <!-- begin-user-doc --> An implementation of the model <b>Factory</b>. <!-- end-user-doc -->
 * 
 * @generated
 */
public class DashboardFactoryImpl extends EFactoryImpl implements DashboardFactory {
	/**
	 * Creates the default factory implementation. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public static DashboardFactory init() {
		try {
			DashboardFactory theDashboardFactory = (DashboardFactory) EPackage.Registry.INSTANCE
				.getEFactory("http://unicase.org/model/dashboard");
			if (theDashboardFactory != null) {
				return theDashboardFactory;
			}
		} catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new DashboardFactoryImpl();
	}

	/**
	 * Creates an instance of the factory. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public DashboardFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
		case DashboardPackage.DASHBOARD_NOTIFICATION:
			return createDashboardNotification();
		case DashboardPackage.DASHBOARD_NOTIFICATION_COMPOSITE:
			return createDashboardNotificationComposite();
		case DashboardPackage.SUBSCRIPTION_COMPOSITE:
			return createSubscriptionComposite();
		case DashboardPackage.TASK_TRACE_CLASSES_COMPOSITE:
			return createTaskTraceClassesComposite();
		case DashboardPackage.NOTIFICATION_OPERATION:
			return createNotificationOperation();
		default:
			throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public DashboardNotification createDashboardNotification() {
		DashboardNotificationImpl dashboardNotification = new DashboardNotificationImpl();
		return dashboardNotification;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public DashboardNotificationComposite createDashboardNotificationComposite() {
		DashboardNotificationCompositeImpl dashboardNotificationComposite = new DashboardNotificationCompositeImpl();
		return dashboardNotificationComposite;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public SubscriptionComposite createSubscriptionComposite() {
		SubscriptionCompositeImpl subscriptionComposite = new SubscriptionCompositeImpl();
		return subscriptionComposite;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public TaskTraceClassesComposite createTaskTraceClassesComposite() {
		TaskTraceClassesCompositeImpl taskTraceClassesComposite = new TaskTraceClassesCompositeImpl();
		return taskTraceClassesComposite;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public NotificationOperation createNotificationOperation() {
		NotificationOperationImpl notificationOperation = new NotificationOperationImpl();
		return notificationOperation;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public DashboardPackage getDashboardPackage() {
		return (DashboardPackage) getEPackage();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static DashboardPackage getPackage() {
		return DashboardPackage.eINSTANCE;
	}

} // DashboardFactoryImpl
