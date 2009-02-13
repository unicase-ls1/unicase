/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.emfstore.esmodel.notification.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.impl.EPackageImpl;
import org.unicase.emfstore.esmodel.EsmodelPackage;
import org.unicase.emfstore.esmodel.accesscontrol.AccesscontrolPackage;
import org.unicase.emfstore.esmodel.accesscontrol.impl.AccesscontrolPackageImpl;
import org.unicase.emfstore.esmodel.accesscontrol.roles.RolesPackage;
import org.unicase.emfstore.esmodel.accesscontrol.roles.impl.RolesPackageImpl;
import org.unicase.emfstore.esmodel.impl.EsmodelPackageImpl;
import org.unicase.emfstore.esmodel.notification.ESNotification;
import org.unicase.emfstore.esmodel.notification.NotificationFactory;
import org.unicase.emfstore.esmodel.notification.NotificationPackage;
import org.unicase.emfstore.esmodel.versioning.VersioningPackage;
import org.unicase.emfstore.esmodel.versioning.events.EventsPackage;
import org.unicase.emfstore.esmodel.versioning.events.impl.EventsPackageImpl;
import org.unicase.emfstore.esmodel.versioning.impl.VersioningPackageImpl;
import org.unicase.emfstore.esmodel.versioning.operations.OperationsPackage;
import org.unicase.emfstore.esmodel.versioning.operations.impl.OperationsPackageImpl;
import org.unicase.model.ModelPackage;

/*
 * <!-- begin-user-doc --> An implementation of the model <b>Package</b>. <!-- end-user-doc -->
 * @generated
 */
public class NotificationPackageImpl extends EPackageImpl implements NotificationPackage {
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass esNotificationEClass = null;

	/**
	 * Creates an instance of the model <b>Package</b>, registered with {@link org.eclipse.emf.ecore.EPackage.Registry
	 * EPackage.Registry} by the package package URI value.
	 * <p>
	 * Note: the correct way to create the package is via the static factory method {@link #init init()}, which also
	 * performs initialization of the package, or returns the registered package, if one already exists. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.emf.ecore.EPackage.Registry
	 * @see org.unicase.emfstore.esmodel.notification.NotificationPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private NotificationPackageImpl() {
		super(eNS_URI, NotificationFactory.eINSTANCE);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private static boolean isInited = false;

	/**
	 * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
	 * Simple dependencies are satisfied by calling this method on all dependent packages before doing anything else.
	 * This method drives initialization for interdependent packages directly, in parallel with this package, itself.
	 * <p>
	 * Of this package and its interdependencies, all packages which have not yet been registered by their URI values
	 * are first created and registered. The packages are then initialized in two steps: meta-model objects for all of
	 * the packages are created before any are initialized, since one package's meta-model objects may refer to those of
	 * another.
	 * <p>
	 * Invocation of this method will not affect any packages that have already been initialized. <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * 
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static NotificationPackage init() {
		if (isInited)
			return (NotificationPackage) EPackage.Registry.INSTANCE.getEPackage(NotificationPackage.eNS_URI);

		// Obtain or create and register package
		NotificationPackageImpl theNotificationPackage = (NotificationPackageImpl) (EPackage.Registry.INSTANCE
			.getEPackage(eNS_URI) instanceof NotificationPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(eNS_URI)
			: new NotificationPackageImpl());

		isInited = true;

		// Initialize simple dependencies
		ModelPackage.eINSTANCE.eClass();

		// Obtain or create and register interdependencies
		EsmodelPackageImpl theEsmodelPackage = (EsmodelPackageImpl) (EPackage.Registry.INSTANCE
			.getEPackage(EsmodelPackage.eNS_URI) instanceof EsmodelPackageImpl ? EPackage.Registry.INSTANCE
			.getEPackage(EsmodelPackage.eNS_URI) : EsmodelPackage.eINSTANCE);
		VersioningPackageImpl theVersioningPackage = (VersioningPackageImpl) (EPackage.Registry.INSTANCE
			.getEPackage(VersioningPackage.eNS_URI) instanceof VersioningPackageImpl ? EPackage.Registry.INSTANCE
			.getEPackage(VersioningPackage.eNS_URI) : VersioningPackage.eINSTANCE);
		OperationsPackageImpl theOperationsPackage = (OperationsPackageImpl) (EPackage.Registry.INSTANCE
			.getEPackage(OperationsPackage.eNS_URI) instanceof OperationsPackageImpl ? EPackage.Registry.INSTANCE
			.getEPackage(OperationsPackage.eNS_URI) : OperationsPackage.eINSTANCE);
		EventsPackageImpl theEventsPackage = (EventsPackageImpl) (EPackage.Registry.INSTANCE
			.getEPackage(EventsPackage.eNS_URI) instanceof EventsPackageImpl ? EPackage.Registry.INSTANCE
			.getEPackage(EventsPackage.eNS_URI) : EventsPackage.eINSTANCE);
		AccesscontrolPackageImpl theAccesscontrolPackage = (AccesscontrolPackageImpl) (EPackage.Registry.INSTANCE
			.getEPackage(AccesscontrolPackage.eNS_URI) instanceof AccesscontrolPackageImpl ? EPackage.Registry.INSTANCE
			.getEPackage(AccesscontrolPackage.eNS_URI) : AccesscontrolPackage.eINSTANCE);
		RolesPackageImpl theRolesPackage = (RolesPackageImpl) (EPackage.Registry.INSTANCE
			.getEPackage(RolesPackage.eNS_URI) instanceof RolesPackageImpl ? EPackage.Registry.INSTANCE
			.getEPackage(RolesPackage.eNS_URI) : RolesPackage.eINSTANCE);

		// Create package meta-data objects
		theNotificationPackage.createPackageContents();
		theEsmodelPackage.createPackageContents();
		theVersioningPackage.createPackageContents();
		theOperationsPackage.createPackageContents();
		theEventsPackage.createPackageContents();
		theAccesscontrolPackage.createPackageContents();
		theRolesPackage.createPackageContents();

		// Initialize created meta-data
		theNotificationPackage.initializePackageContents();
		theEsmodelPackage.initializePackageContents();
		theVersioningPackage.initializePackageContents();
		theOperationsPackage.initializePackageContents();
		theEventsPackage.initializePackageContents();
		theAccesscontrolPackage.initializePackageContents();
		theRolesPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theNotificationPackage.freeze();

		return theNotificationPackage;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getESNotification() {
		return esNotificationEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EAttribute getESNotification_Sender() {
		return (EAttribute) esNotificationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EAttribute getESNotification_Recipient() {
		return (EAttribute) esNotificationEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getESNotification_Project() {
		return (EReference) esNotificationEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getESNotification_RelatedModelElements() {
		return (EReference) esNotificationEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EAttribute getESNotification_Message() {
		return (EAttribute) esNotificationEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public NotificationFactory getNotificationFactory() {
		return (NotificationFactory) getEFactoryInstance();
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
		esNotificationEClass = createEClass(ES_NOTIFICATION);
		createEAttribute(esNotificationEClass, ES_NOTIFICATION__SENDER);
		createEAttribute(esNotificationEClass, ES_NOTIFICATION__RECIPIENT);
		createEReference(esNotificationEClass, ES_NOTIFICATION__PROJECT);
		createEReference(esNotificationEClass, ES_NOTIFICATION__RELATED_MODEL_ELEMENTS);
		createEAttribute(esNotificationEClass, ES_NOTIFICATION__MESSAGE);
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
		ModelPackage theModelPackage = (ModelPackage) EPackage.Registry.INSTANCE.getEPackage(ModelPackage.eNS_URI);
		EsmodelPackage theEsmodelPackage = (EsmodelPackage) EPackage.Registry.INSTANCE
			.getEPackage(EsmodelPackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		esNotificationEClass.getESuperTypes().add(theModelPackage.getIdentifiableElement());

		// Initialize classes and features; add operations and parameters
		initEClass(esNotificationEClass, ESNotification.class, "ESNotification", !IS_ABSTRACT, !IS_INTERFACE,
			IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getESNotification_Sender(), ecorePackage.getEString(), "sender", null, 0, 1,
			ESNotification.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE,
			!IS_DERIVED, IS_ORDERED);
		initEAttribute(getESNotification_Recipient(), ecorePackage.getEString(), "recipient", null, 0, 1,
			ESNotification.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE,
			!IS_DERIVED, IS_ORDERED);
		initEReference(getESNotification_Project(), theEsmodelPackage.getProjectId(), null, "project", null, 0, 1,
			ESNotification.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES,
			!IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getESNotification_RelatedModelElements(), theModelPackage.getModelElementId(), null,
			"relatedModelElements", null, 0, -1, ESNotification.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE,
			IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getESNotification_Message(), ecorePackage.getEString(), "message", null, 0, 1,
			ESNotification.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE,
			!IS_DERIVED, IS_ORDERED);
	}

} // NotificationPackageImpl
