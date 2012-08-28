/**
 * <copyright> Copyright (c) 2009-2012 Chair of Applied Software Engineering, Technische Universität München (TUM).
 * All rights reserved. This program and the accompanying materials are made available under the terms of
 * the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.dashboard.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.eclipse.emf.emfstore.server.model.ModelPackage;

import org.eclipse.emf.emfstore.server.model.versioning.operations.OperationsPackage;

import org.unicase.dashboard.DashboardFactory;
import org.unicase.dashboard.DashboardNotification;
import org.unicase.dashboard.DashboardNotificationComposite;
import org.unicase.dashboard.DashboardPackage;
import org.unicase.dashboard.NotificationOperation;
import org.unicase.dashboard.SubscriptionComposite;
import org.unicase.dashboard.TaskTraceClassesComposite;

/**
 * <!-- begin-user-doc --> An implementation of the model <b>Package</b>. <!-- end-user-doc -->
 * 
 * @generated
 */
public class DashboardPackageImpl extends EPackageImpl implements DashboardPackage {
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass dashboardNotificationEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass dashboardNotificationCompositeEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass subscriptionCompositeEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass taskTraceClassesCompositeEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass notificationOperationEClass = null;

	/**
	 * Creates an instance of the model <b>Package</b>, registered with {@link org.eclipse.emf.ecore.EPackage.Registry
	 * EPackage.Registry} by the package package URI value.
	 * <p>
	 * Note: the correct way to create the package is via the static factory method {@link #init init()}, which also
	 * performs initialization of the package, or returns the registered package, if one already exists. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.emf.ecore.EPackage.Registry
	 * @see org.unicase.dashboard.DashboardPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private DashboardPackageImpl() {
		super(eNS_URI, DashboardFactory.eINSTANCE);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private static boolean isInited = false;

	/**
	 * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
	 * <p>
	 * This method is used to initialize {@link DashboardPackage#eINSTANCE} when that field is accessed. Clients should
	 * not invoke it directly. Instead, they should simply access that field to obtain the package. <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * 
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static DashboardPackage init() {
		if (isInited)
			return (DashboardPackage) EPackage.Registry.INSTANCE.getEPackage(DashboardPackage.eNS_URI);

		// Obtain or create and register package
		DashboardPackageImpl theDashboardPackage = (DashboardPackageImpl) (EPackage.Registry.INSTANCE.get(eNS_URI) instanceof DashboardPackageImpl ? EPackage.Registry.INSTANCE
			.get(eNS_URI) : new DashboardPackageImpl());

		isInited = true;

		// Initialize simple dependencies
		ModelPackage.eINSTANCE.eClass();

		// Create package meta-data objects
		theDashboardPackage.createPackageContents();

		// Initialize created meta-data
		theDashboardPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theDashboardPackage.freeze();

		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(DashboardPackage.eNS_URI, theDashboardPackage);
		return theDashboardPackage;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getDashboardNotification() {
		return dashboardNotificationEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EAttribute getDashboardNotification_Seen() {
		return (EAttribute) dashboardNotificationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EAttribute getDashboardNotification_Name() {
		return (EAttribute) dashboardNotificationEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EAttribute getDashboardNotification_Message() {
		return (EAttribute) dashboardNotificationEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EAttribute getDashboardNotification_Details() {
		return (EAttribute) dashboardNotificationEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EAttribute getDashboardNotification_Sender() {
		return (EAttribute) dashboardNotificationEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EAttribute getDashboardNotification_Recipient() {
		return (EAttribute) dashboardNotificationEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EAttribute getDashboardNotification_Provider() {
		return (EAttribute) dashboardNotificationEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EAttribute getDashboardNotification_CreationDate() {
		return (EAttribute) dashboardNotificationEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getDashboardNotification_Project() {
		return (EReference) dashboardNotificationEClass.getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getDashboardNotification_RelatedModelElements() {
		return (EReference) dashboardNotificationEClass.getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getDashboardNotification_RelatedOperations() {
		return (EReference) dashboardNotificationEClass.getEStructuralFeatures().get(10);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getDashboardNotificationComposite() {
		return dashboardNotificationCompositeEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getDashboardNotificationComposite_Notifications() {
		return (EReference) dashboardNotificationCompositeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getSubscriptionComposite() {
		return subscriptionCompositeEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getSubscriptionComposite_Subscriptions() {
		return (EReference) subscriptionCompositeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getTaskTraceClassesComposite() {
		return taskTraceClassesCompositeEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getTaskTraceClassesComposite_TaskTraceClasses() {
		return (EReference) taskTraceClassesCompositeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getNotificationOperation() {
		return notificationOperationEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getNotificationOperation_Notifications() {
		return (EReference) notificationOperationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EAttribute getNotificationOperation_Reversed() {
		return (EAttribute) notificationOperationEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public DashboardFactory getDashboardFactory() {
		return (DashboardFactory) getEFactoryInstance();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private boolean isCreated = false;

	/**
	 * Creates the meta-model objects for the package. This method is guarded to have no affect on any invocation but
	 * its first. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void createPackageContents() {
		if (isCreated)
			return;
		isCreated = true;

		// Create classes and their features
		dashboardNotificationEClass = createEClass(DASHBOARD_NOTIFICATION);
		createEAttribute(dashboardNotificationEClass, DASHBOARD_NOTIFICATION__SEEN);
		createEAttribute(dashboardNotificationEClass, DASHBOARD_NOTIFICATION__NAME);
		createEAttribute(dashboardNotificationEClass, DASHBOARD_NOTIFICATION__MESSAGE);
		createEAttribute(dashboardNotificationEClass, DASHBOARD_NOTIFICATION__DETAILS);
		createEAttribute(dashboardNotificationEClass, DASHBOARD_NOTIFICATION__SENDER);
		createEAttribute(dashboardNotificationEClass, DASHBOARD_NOTIFICATION__RECIPIENT);
		createEAttribute(dashboardNotificationEClass, DASHBOARD_NOTIFICATION__PROVIDER);
		createEAttribute(dashboardNotificationEClass, DASHBOARD_NOTIFICATION__CREATION_DATE);
		createEReference(dashboardNotificationEClass, DASHBOARD_NOTIFICATION__PROJECT);
		createEReference(dashboardNotificationEClass, DASHBOARD_NOTIFICATION__RELATED_MODEL_ELEMENTS);
		createEReference(dashboardNotificationEClass, DASHBOARD_NOTIFICATION__RELATED_OPERATIONS);

		dashboardNotificationCompositeEClass = createEClass(DASHBOARD_NOTIFICATION_COMPOSITE);
		createEReference(dashboardNotificationCompositeEClass, DASHBOARD_NOTIFICATION_COMPOSITE__NOTIFICATIONS);

		subscriptionCompositeEClass = createEClass(SUBSCRIPTION_COMPOSITE);
		createEReference(subscriptionCompositeEClass, SUBSCRIPTION_COMPOSITE__SUBSCRIPTIONS);

		taskTraceClassesCompositeEClass = createEClass(TASK_TRACE_CLASSES_COMPOSITE);
		createEReference(taskTraceClassesCompositeEClass, TASK_TRACE_CLASSES_COMPOSITE__TASK_TRACE_CLASSES);

		notificationOperationEClass = createEClass(NOTIFICATION_OPERATION);
		createEReference(notificationOperationEClass, NOTIFICATION_OPERATION__NOTIFICATIONS);
		createEAttribute(notificationOperationEClass, NOTIFICATION_OPERATION__REVERSED);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private boolean isInitialized = false;

	/**
	 * Complete the initialization of the package and its meta-model. This method is guarded to have no affect on any
	 * invocation but its first. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void initializePackageContents() {
		if (isInitialized)
			return;
		isInitialized = true;

		// Initialize package
		setName(eNAME);
		setNsPrefix(eNS_PREFIX);
		setNsURI(eNS_URI);

		// Obtain other dependent packages
		org.eclipse.emf.emfstore.common.model.ModelPackage theModelPackage_1 = (org.eclipse.emf.emfstore.common.model.ModelPackage) EPackage.Registry.INSTANCE
			.getEPackage(org.eclipse.emf.emfstore.common.model.ModelPackage.eNS_URI);
		ModelPackage theModelPackage = (ModelPackage) EPackage.Registry.INSTANCE.getEPackage(ModelPackage.eNS_URI);
		OperationsPackage theOperationsPackage = (OperationsPackage) EPackage.Registry.INSTANCE
			.getEPackage(OperationsPackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		dashboardNotificationEClass.getESuperTypes().add(theModelPackage_1.getNonDomainElement());
		dashboardNotificationCompositeEClass.getESuperTypes().add(theModelPackage_1.getNonDomainElement());
		subscriptionCompositeEClass.getESuperTypes().add(theModelPackage_1.getNonDomainElement());
		taskTraceClassesCompositeEClass.getESuperTypes().add(theModelPackage_1.getNonDomainElement());
		notificationOperationEClass.getESuperTypes().add(theOperationsPackage.getAbstractOperation());
		notificationOperationEClass.getESuperTypes().add(theModelPackage_1.getNonDomainElement());

		// Initialize classes and features; add operations and parameters
		initEClass(dashboardNotificationEClass, DashboardNotification.class, "DashboardNotification", !IS_ABSTRACT,
			!IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getDashboardNotification_Seen(), ecorePackage.getEBoolean(), "seen", null, 0, 1,
			DashboardNotification.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE,
			!IS_DERIVED, IS_ORDERED);
		initEAttribute(getDashboardNotification_Name(), ecorePackage.getEString(), "name", null, 0, 1,
			DashboardNotification.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE,
			!IS_DERIVED, IS_ORDERED);
		initEAttribute(getDashboardNotification_Message(), ecorePackage.getEString(), "message", null, 0, 1,
			DashboardNotification.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE,
			!IS_DERIVED, IS_ORDERED);
		initEAttribute(getDashboardNotification_Details(), ecorePackage.getEString(), "details", null, 0, 1,
			DashboardNotification.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE,
			!IS_DERIVED, IS_ORDERED);
		initEAttribute(getDashboardNotification_Sender(), ecorePackage.getEString(), "sender", null, 0, 1,
			DashboardNotification.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE,
			!IS_DERIVED, IS_ORDERED);
		initEAttribute(getDashboardNotification_Recipient(), ecorePackage.getEString(), "recipient", null, 0, 1,
			DashboardNotification.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE,
			!IS_DERIVED, IS_ORDERED);
		initEAttribute(getDashboardNotification_Provider(), ecorePackage.getEString(), "provider", null, 0, 1,
			DashboardNotification.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE,
			!IS_DERIVED, IS_ORDERED);
		initEAttribute(getDashboardNotification_CreationDate(), ecorePackage.getEDate(), "creationDate", null, 0, 1,
			DashboardNotification.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE,
			!IS_DERIVED, IS_ORDERED);
		initEReference(getDashboardNotification_Project(), theModelPackage.getProjectId(), null, "project", null, 0, 1,
			DashboardNotification.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES,
			!IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDashboardNotification_RelatedModelElements(), theModelPackage_1.getModelElementId(), null,
			"relatedModelElements", null, 0, -1, DashboardNotification.class, !IS_TRANSIENT, !IS_VOLATILE,
			IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDashboardNotification_RelatedOperations(), theOperationsPackage.getOperationId(), null,
			"relatedOperations", null, 0, -1, DashboardNotification.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE,
			IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(dashboardNotificationCompositeEClass, DashboardNotificationComposite.class,
			"DashboardNotificationComposite", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getDashboardNotificationComposite_Notifications(), this.getDashboardNotification(), null,
			"notifications", null, 0, -1, DashboardNotificationComposite.class, !IS_TRANSIENT, !IS_VOLATILE,
			IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(subscriptionCompositeEClass, SubscriptionComposite.class, "SubscriptionComposite", !IS_ABSTRACT,
			!IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getSubscriptionComposite_Subscriptions(), theModelPackage_1.getModelElementId(), null,
			"subscriptions", null, 0, -1, SubscriptionComposite.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE,
			IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(taskTraceClassesCompositeEClass, TaskTraceClassesComposite.class, "TaskTraceClassesComposite",
			!IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getTaskTraceClassesComposite_TaskTraceClasses(), ecorePackage.getEObject(), null,
			"taskTraceClasses", null, 0, -1, TaskTraceClassesComposite.class, !IS_TRANSIENT, !IS_VOLATILE,
			IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(notificationOperationEClass, NotificationOperation.class, "NotificationOperation", !IS_ABSTRACT,
			!IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getNotificationOperation_Notifications(), this.getDashboardNotification(), null,
			"notifications", null, 0, -1, NotificationOperation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE,
			IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getNotificationOperation_Reversed(), ecorePackage.getEBoolean(), "reversed", null, 0, 1,
			NotificationOperation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE,
			!IS_DERIVED, IS_ORDERED);

		// Create resource
		createResource(eNS_URI);
	}

} // DashboardPackageImpl
