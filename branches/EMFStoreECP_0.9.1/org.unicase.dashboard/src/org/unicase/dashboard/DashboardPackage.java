/**
 * <copyright> Copyright (c) 2009-2012 Chair of Applied Software Engineering, Technische Universität München (TUM).
 * All rights reserved. This program and the accompanying materials are made available under the terms of
 * the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.dashboard;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see org.unicase.dashboard.DashboardFactory
 * @model kind="package"
 * @generated
 */
public interface DashboardPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "dashboard";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://unicase.org/model/dashboard";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "org.unicase.model.dashboard";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	DashboardPackage eINSTANCE = org.unicase.dashboard.impl.DashboardPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.unicase.dashboard.impl.DashboardNotificationImpl <em>Notification</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.unicase.dashboard.impl.DashboardNotificationImpl
	 * @see org.unicase.dashboard.impl.DashboardPackageImpl#getDashboardNotification()
	 * @generated
	 */
	int DASHBOARD_NOTIFICATION = 0;

	/**
	 * The feature id for the '<em><b>Seen</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DASHBOARD_NOTIFICATION__SEEN = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DASHBOARD_NOTIFICATION__NAME = 1;

	/**
	 * The feature id for the '<em><b>Message</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DASHBOARD_NOTIFICATION__MESSAGE = 2;

	/**
	 * The feature id for the '<em><b>Details</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DASHBOARD_NOTIFICATION__DETAILS = 3;

	/**
	 * The feature id for the '<em><b>Sender</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DASHBOARD_NOTIFICATION__SENDER = 4;

	/**
	 * The feature id for the '<em><b>Recipient</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DASHBOARD_NOTIFICATION__RECIPIENT = 5;

	/**
	 * The feature id for the '<em><b>Provider</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DASHBOARD_NOTIFICATION__PROVIDER = 6;

	/**
	 * The feature id for the '<em><b>Creation Date</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DASHBOARD_NOTIFICATION__CREATION_DATE = 7;

	/**
	 * The feature id for the '<em><b>Project</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DASHBOARD_NOTIFICATION__PROJECT = 8;

	/**
	 * The feature id for the '<em><b>Related Model Elements</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DASHBOARD_NOTIFICATION__RELATED_MODEL_ELEMENTS = 9;

	/**
	 * The feature id for the '<em><b>Related Operations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DASHBOARD_NOTIFICATION__RELATED_OPERATIONS = 10;

	/**
	 * The number of structural features of the '<em>Notification</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DASHBOARD_NOTIFICATION_FEATURE_COUNT = 11;

	/**
	 * The meta object id for the '{@link org.unicase.dashboard.impl.DashboardNotificationCompositeImpl <em>Notification Composite</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.unicase.dashboard.impl.DashboardNotificationCompositeImpl
	 * @see org.unicase.dashboard.impl.DashboardPackageImpl#getDashboardNotificationComposite()
	 * @generated
	 */
	int DASHBOARD_NOTIFICATION_COMPOSITE = 1;

	/**
	 * The feature id for the '<em><b>Notifications</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DASHBOARD_NOTIFICATION_COMPOSITE__NOTIFICATIONS = 0;

	/**
	 * The number of structural features of the '<em>Notification Composite</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DASHBOARD_NOTIFICATION_COMPOSITE_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link org.unicase.dashboard.impl.SubscriptionCompositeImpl <em>Subscription Composite</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.unicase.dashboard.impl.SubscriptionCompositeImpl
	 * @see org.unicase.dashboard.impl.DashboardPackageImpl#getSubscriptionComposite()
	 * @generated
	 */
	int SUBSCRIPTION_COMPOSITE = 2;

	/**
	 * The feature id for the '<em><b>Subscriptions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUBSCRIPTION_COMPOSITE__SUBSCRIPTIONS = 0;

	/**
	 * The number of structural features of the '<em>Subscription Composite</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUBSCRIPTION_COMPOSITE_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link org.unicase.dashboard.impl.TaskTraceClassesCompositeImpl <em>Task Trace Classes Composite</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.unicase.dashboard.impl.TaskTraceClassesCompositeImpl
	 * @see org.unicase.dashboard.impl.DashboardPackageImpl#getTaskTraceClassesComposite()
	 * @generated
	 */
	int TASK_TRACE_CLASSES_COMPOSITE = 3;

	/**
	 * The feature id for the '<em><b>Task Trace Classes</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TASK_TRACE_CLASSES_COMPOSITE__TASK_TRACE_CLASSES = 0;

	/**
	 * The number of structural features of the '<em>Task Trace Classes Composite</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TASK_TRACE_CLASSES_COMPOSITE_FEATURE_COUNT = 1;

	/**
	 * Returns the meta object for class '{@link org.unicase.dashboard.DashboardNotification <em>Notification</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Notification</em>'.
	 * @see org.unicase.dashboard.DashboardNotification
	 * @generated
	 */
	EClass getDashboardNotification();

	/**
	 * Returns the meta object for the attribute '{@link org.unicase.dashboard.DashboardNotification#isSeen <em>Seen</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Seen</em>'.
	 * @see org.unicase.dashboard.DashboardNotification#isSeen()
	 * @see #getDashboardNotification()
	 * @generated
	 */
	EAttribute getDashboardNotification_Seen();

	/**
	 * Returns the meta object for the attribute '{@link org.unicase.dashboard.DashboardNotification#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.unicase.dashboard.DashboardNotification#getName()
	 * @see #getDashboardNotification()
	 * @generated
	 */
	EAttribute getDashboardNotification_Name();

	/**
	 * Returns the meta object for the attribute '{@link org.unicase.dashboard.DashboardNotification#getMessage <em>Message</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Message</em>'.
	 * @see org.unicase.dashboard.DashboardNotification#getMessage()
	 * @see #getDashboardNotification()
	 * @generated
	 */
	EAttribute getDashboardNotification_Message();

	/**
	 * Returns the meta object for the attribute '{@link org.unicase.dashboard.DashboardNotification#getDetails <em>Details</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Details</em>'.
	 * @see org.unicase.dashboard.DashboardNotification#getDetails()
	 * @see #getDashboardNotification()
	 * @generated
	 */
	EAttribute getDashboardNotification_Details();

	/**
	 * Returns the meta object for the attribute '{@link org.unicase.dashboard.DashboardNotification#getSender <em>Sender</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Sender</em>'.
	 * @see org.unicase.dashboard.DashboardNotification#getSender()
	 * @see #getDashboardNotification()
	 * @generated
	 */
	EAttribute getDashboardNotification_Sender();

	/**
	 * Returns the meta object for the attribute '{@link org.unicase.dashboard.DashboardNotification#getRecipient <em>Recipient</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Recipient</em>'.
	 * @see org.unicase.dashboard.DashboardNotification#getRecipient()
	 * @see #getDashboardNotification()
	 * @generated
	 */
	EAttribute getDashboardNotification_Recipient();

	/**
	 * Returns the meta object for the attribute '{@link org.unicase.dashboard.DashboardNotification#getProvider <em>Provider</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Provider</em>'.
	 * @see org.unicase.dashboard.DashboardNotification#getProvider()
	 * @see #getDashboardNotification()
	 * @generated
	 */
	EAttribute getDashboardNotification_Provider();

	/**
	 * Returns the meta object for the attribute '{@link org.unicase.dashboard.DashboardNotification#getCreationDate <em>Creation Date</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Creation Date</em>'.
	 * @see org.unicase.dashboard.DashboardNotification#getCreationDate()
	 * @see #getDashboardNotification()
	 * @generated
	 */
	EAttribute getDashboardNotification_CreationDate();

	/**
	 * Returns the meta object for the containment reference '{@link org.unicase.dashboard.DashboardNotification#getProject <em>Project</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Project</em>'.
	 * @see org.unicase.dashboard.DashboardNotification#getProject()
	 * @see #getDashboardNotification()
	 * @generated
	 */
	EReference getDashboardNotification_Project();

	/**
	 * Returns the meta object for the containment reference list '{@link org.unicase.dashboard.DashboardNotification#getRelatedModelElements <em>Related Model Elements</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Related Model Elements</em>'.
	 * @see org.unicase.dashboard.DashboardNotification#getRelatedModelElements()
	 * @see #getDashboardNotification()
	 * @generated
	 */
	EReference getDashboardNotification_RelatedModelElements();

	/**
	 * Returns the meta object for the containment reference list '{@link org.unicase.dashboard.DashboardNotification#getRelatedOperations <em>Related Operations</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Related Operations</em>'.
	 * @see org.unicase.dashboard.DashboardNotification#getRelatedOperations()
	 * @see #getDashboardNotification()
	 * @generated
	 */
	EReference getDashboardNotification_RelatedOperations();

	/**
	 * Returns the meta object for class '{@link org.unicase.dashboard.DashboardNotificationComposite <em>Notification Composite</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Notification Composite</em>'.
	 * @see org.unicase.dashboard.DashboardNotificationComposite
	 * @generated
	 */
	EClass getDashboardNotificationComposite();

	/**
	 * Returns the meta object for the containment reference list '{@link org.unicase.dashboard.DashboardNotificationComposite#getNotifications <em>Notifications</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Notifications</em>'.
	 * @see org.unicase.dashboard.DashboardNotificationComposite#getNotifications()
	 * @see #getDashboardNotificationComposite()
	 * @generated
	 */
	EReference getDashboardNotificationComposite_Notifications();

	/**
	 * Returns the meta object for class '{@link org.unicase.dashboard.SubscriptionComposite <em>Subscription Composite</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Subscription Composite</em>'.
	 * @see org.unicase.dashboard.SubscriptionComposite
	 * @generated
	 */
	EClass getSubscriptionComposite();

	/**
	 * Returns the meta object for the containment reference list '{@link org.unicase.dashboard.SubscriptionComposite#getSubscriptions <em>Subscriptions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Subscriptions</em>'.
	 * @see org.unicase.dashboard.SubscriptionComposite#getSubscriptions()
	 * @see #getSubscriptionComposite()
	 * @generated
	 */
	EReference getSubscriptionComposite_Subscriptions();

	/**
	 * Returns the meta object for class '{@link org.unicase.dashboard.TaskTraceClassesComposite <em>Task Trace Classes Composite</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Task Trace Classes Composite</em>'.
	 * @see org.unicase.dashboard.TaskTraceClassesComposite
	 * @generated
	 */
	EClass getTaskTraceClassesComposite();

	/**
	 * Returns the meta object for the reference list '{@link org.unicase.dashboard.TaskTraceClassesComposite#getTaskTraceClasses <em>Task Trace Classes</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Task Trace Classes</em>'.
	 * @see org.unicase.dashboard.TaskTraceClassesComposite#getTaskTraceClasses()
	 * @see #getTaskTraceClassesComposite()
	 * @generated
	 */
	EReference getTaskTraceClassesComposite_TaskTraceClasses();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	DashboardFactory getDashboardFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link org.unicase.dashboard.impl.DashboardNotificationImpl <em>Notification</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.unicase.dashboard.impl.DashboardNotificationImpl
		 * @see org.unicase.dashboard.impl.DashboardPackageImpl#getDashboardNotification()
		 * @generated
		 */
		EClass DASHBOARD_NOTIFICATION = eINSTANCE.getDashboardNotification();

		/**
		 * The meta object literal for the '<em><b>Seen</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DASHBOARD_NOTIFICATION__SEEN = eINSTANCE.getDashboardNotification_Seen();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DASHBOARD_NOTIFICATION__NAME = eINSTANCE.getDashboardNotification_Name();

		/**
		 * The meta object literal for the '<em><b>Message</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DASHBOARD_NOTIFICATION__MESSAGE = eINSTANCE.getDashboardNotification_Message();

		/**
		 * The meta object literal for the '<em><b>Details</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DASHBOARD_NOTIFICATION__DETAILS = eINSTANCE.getDashboardNotification_Details();

		/**
		 * The meta object literal for the '<em><b>Sender</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DASHBOARD_NOTIFICATION__SENDER = eINSTANCE.getDashboardNotification_Sender();

		/**
		 * The meta object literal for the '<em><b>Recipient</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DASHBOARD_NOTIFICATION__RECIPIENT = eINSTANCE.getDashboardNotification_Recipient();

		/**
		 * The meta object literal for the '<em><b>Provider</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DASHBOARD_NOTIFICATION__PROVIDER = eINSTANCE.getDashboardNotification_Provider();

		/**
		 * The meta object literal for the '<em><b>Creation Date</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DASHBOARD_NOTIFICATION__CREATION_DATE = eINSTANCE.getDashboardNotification_CreationDate();

		/**
		 * The meta object literal for the '<em><b>Project</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DASHBOARD_NOTIFICATION__PROJECT = eINSTANCE.getDashboardNotification_Project();

		/**
		 * The meta object literal for the '<em><b>Related Model Elements</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DASHBOARD_NOTIFICATION__RELATED_MODEL_ELEMENTS = eINSTANCE
			.getDashboardNotification_RelatedModelElements();

		/**
		 * The meta object literal for the '<em><b>Related Operations</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DASHBOARD_NOTIFICATION__RELATED_OPERATIONS = eINSTANCE.getDashboardNotification_RelatedOperations();

		/**
		 * The meta object literal for the '{@link org.unicase.dashboard.impl.DashboardNotificationCompositeImpl <em>Notification Composite</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.unicase.dashboard.impl.DashboardNotificationCompositeImpl
		 * @see org.unicase.dashboard.impl.DashboardPackageImpl#getDashboardNotificationComposite()
		 * @generated
		 */
		EClass DASHBOARD_NOTIFICATION_COMPOSITE = eINSTANCE.getDashboardNotificationComposite();

		/**
		 * The meta object literal for the '<em><b>Notifications</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DASHBOARD_NOTIFICATION_COMPOSITE__NOTIFICATIONS = eINSTANCE
			.getDashboardNotificationComposite_Notifications();

		/**
		 * The meta object literal for the '{@link org.unicase.dashboard.impl.SubscriptionCompositeImpl <em>Subscription Composite</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.unicase.dashboard.impl.SubscriptionCompositeImpl
		 * @see org.unicase.dashboard.impl.DashboardPackageImpl#getSubscriptionComposite()
		 * @generated
		 */
		EClass SUBSCRIPTION_COMPOSITE = eINSTANCE.getSubscriptionComposite();

		/**
		 * The meta object literal for the '<em><b>Subscriptions</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SUBSCRIPTION_COMPOSITE__SUBSCRIPTIONS = eINSTANCE.getSubscriptionComposite_Subscriptions();

		/**
		 * The meta object literal for the '{@link org.unicase.dashboard.impl.TaskTraceClassesCompositeImpl <em>Task Trace Classes Composite</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.unicase.dashboard.impl.TaskTraceClassesCompositeImpl
		 * @see org.unicase.dashboard.impl.DashboardPackageImpl#getTaskTraceClassesComposite()
		 * @generated
		 */
		EClass TASK_TRACE_CLASSES_COMPOSITE = eINSTANCE.getTaskTraceClassesComposite();

		/**
		 * The meta object literal for the '<em><b>Task Trace Classes</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TASK_TRACE_CLASSES_COMPOSITE__TASK_TRACE_CLASSES = eINSTANCE
			.getTaskTraceClassesComposite_TaskTraceClasses();

	}

} //DashboardPackage
