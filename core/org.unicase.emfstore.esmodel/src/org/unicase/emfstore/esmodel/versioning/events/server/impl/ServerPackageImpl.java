/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.emfstore.esmodel.versioning.events.server.impl;

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
import org.unicase.emfstore.esmodel.notification.NotificationPackage;
import org.unicase.emfstore.esmodel.notification.impl.NotificationPackageImpl;
import org.unicase.emfstore.esmodel.url.UrlPackage;
import org.unicase.emfstore.esmodel.url.impl.UrlPackageImpl;
import org.unicase.emfstore.esmodel.versioning.VersioningPackage;
import org.unicase.emfstore.esmodel.versioning.events.EventsPackage;
import org.unicase.emfstore.esmodel.versioning.events.impl.EventsPackageImpl;
import org.unicase.emfstore.esmodel.versioning.events.server.ProjectUpdatedEvent;
import org.unicase.emfstore.esmodel.versioning.events.server.ServerEvent;
import org.unicase.emfstore.esmodel.versioning.events.server.ServerFactory;
import org.unicase.emfstore.esmodel.versioning.events.server.ServerPackage;
import org.unicase.emfstore.esmodel.versioning.events.server.ServerProjectEvent;
import org.unicase.emfstore.esmodel.versioning.impl.VersioningPackageImpl;
import org.unicase.emfstore.esmodel.versioning.operations.OperationsPackage;
import org.unicase.emfstore.esmodel.versioning.operations.impl.OperationsPackageImpl;
import org.unicase.emfstore.esmodel.versioning.operations.semantic.SemanticPackage;
import org.unicase.emfstore.esmodel.versioning.operations.semantic.impl.SemanticPackageImpl;
import org.unicase.metamodel.MetamodelPackage;

/**
 * <!-- begin-user-doc --> An implementation of the model <b>Package</b>. <!-- end-user-doc -->
 * 
 * @generated
 */
public class ServerPackageImpl extends EPackageImpl implements ServerPackage {
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass serverEventEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass serverProjectEventEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass projectUpdatedEventEClass = null;

	/**
	 * Creates an instance of the model <b>Package</b>, registered with {@link org.eclipse.emf.ecore.EPackage.Registry
	 * EPackage.Registry} by the package package URI value.
	 * <p>
	 * Note: the correct way to create the package is via the static factory method {@link #init init()}, which also
	 * performs initialization of the package, or returns the registered package, if one already exists. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.emf.ecore.EPackage.Registry
	 * @see org.unicase.emfstore.esmodel.versioning.events.server.ServerPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private ServerPackageImpl() {
		super(eNS_URI, ServerFactory.eINSTANCE);
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
	 * This method is used to initialize {@link ServerPackage#eINSTANCE} when that field is accessed. Clients should not
	 * invoke it directly. Instead, they should simply access that field to obtain the package. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static ServerPackage init() {
		if (isInited)
			return (ServerPackage) EPackage.Registry.INSTANCE.getEPackage(ServerPackage.eNS_URI);

		// Obtain or create and register package
		ServerPackageImpl theServerPackage = (ServerPackageImpl) (EPackage.Registry.INSTANCE.get(eNS_URI) instanceof ServerPackageImpl ? EPackage.Registry.INSTANCE
			.get(eNS_URI)
			: new ServerPackageImpl());

		isInited = true;

		// Initialize simple dependencies
		MetamodelPackage.eINSTANCE.eClass();

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
		SemanticPackageImpl theSemanticPackage = (SemanticPackageImpl) (EPackage.Registry.INSTANCE
			.getEPackage(SemanticPackage.eNS_URI) instanceof SemanticPackageImpl ? EPackage.Registry.INSTANCE
			.getEPackage(SemanticPackage.eNS_URI) : SemanticPackage.eINSTANCE);
		EventsPackageImpl theEventsPackage = (EventsPackageImpl) (EPackage.Registry.INSTANCE
			.getEPackage(EventsPackage.eNS_URI) instanceof EventsPackageImpl ? EPackage.Registry.INSTANCE
			.getEPackage(EventsPackage.eNS_URI) : EventsPackage.eINSTANCE);
		AccesscontrolPackageImpl theAccesscontrolPackage = (AccesscontrolPackageImpl) (EPackage.Registry.INSTANCE
			.getEPackage(AccesscontrolPackage.eNS_URI) instanceof AccesscontrolPackageImpl ? EPackage.Registry.INSTANCE
			.getEPackage(AccesscontrolPackage.eNS_URI) : AccesscontrolPackage.eINSTANCE);
		RolesPackageImpl theRolesPackage = (RolesPackageImpl) (EPackage.Registry.INSTANCE
			.getEPackage(RolesPackage.eNS_URI) instanceof RolesPackageImpl ? EPackage.Registry.INSTANCE
			.getEPackage(RolesPackage.eNS_URI) : RolesPackage.eINSTANCE);
		NotificationPackageImpl theNotificationPackage = (NotificationPackageImpl) (EPackage.Registry.INSTANCE
			.getEPackage(NotificationPackage.eNS_URI) instanceof NotificationPackageImpl ? EPackage.Registry.INSTANCE
			.getEPackage(NotificationPackage.eNS_URI) : NotificationPackage.eINSTANCE);
		UrlPackageImpl theUrlPackage = (UrlPackageImpl) (EPackage.Registry.INSTANCE.getEPackage(UrlPackage.eNS_URI) instanceof UrlPackageImpl ? EPackage.Registry.INSTANCE
			.getEPackage(UrlPackage.eNS_URI)
			: UrlPackage.eINSTANCE);

		// Create package meta-data objects
		theServerPackage.createPackageContents();
		theEsmodelPackage.createPackageContents();
		theVersioningPackage.createPackageContents();
		theOperationsPackage.createPackageContents();
		theSemanticPackage.createPackageContents();
		theEventsPackage.createPackageContents();
		theAccesscontrolPackage.createPackageContents();
		theRolesPackage.createPackageContents();
		theNotificationPackage.createPackageContents();
		theUrlPackage.createPackageContents();

		// Initialize created meta-data
		theServerPackage.initializePackageContents();
		theEsmodelPackage.initializePackageContents();
		theVersioningPackage.initializePackageContents();
		theOperationsPackage.initializePackageContents();
		theSemanticPackage.initializePackageContents();
		theEventsPackage.initializePackageContents();
		theAccesscontrolPackage.initializePackageContents();
		theRolesPackage.initializePackageContents();
		theNotificationPackage.initializePackageContents();
		theUrlPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theServerPackage.freeze();

		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(ServerPackage.eNS_URI, theServerPackage);
		return theServerPackage;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getServerEvent() {
		return serverEventEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getServerProjectEvent() {
		return serverProjectEventEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getServerProjectEvent_ProjectId() {
		return (EReference) serverProjectEventEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getProjectUpdatedEvent() {
		return projectUpdatedEventEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getProjectUpdatedEvent_NewVersion() {
		return (EReference) projectUpdatedEventEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public ServerFactory getServerFactory() {
		return (ServerFactory) getEFactoryInstance();
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
		serverEventEClass = createEClass(SERVER_EVENT);

		serverProjectEventEClass = createEClass(SERVER_PROJECT_EVENT);
		createEReference(serverProjectEventEClass, SERVER_PROJECT_EVENT__PROJECT_ID);

		projectUpdatedEventEClass = createEClass(PROJECT_UPDATED_EVENT);
		createEReference(projectUpdatedEventEClass, PROJECT_UPDATED_EVENT__NEW_VERSION);
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
		EventsPackage theEventsPackage = (EventsPackage) EPackage.Registry.INSTANCE.getEPackage(EventsPackage.eNS_URI);
		EsmodelPackage theEsmodelPackage = (EsmodelPackage) EPackage.Registry.INSTANCE
			.getEPackage(EsmodelPackage.eNS_URI);
		VersioningPackage theVersioningPackage = (VersioningPackage) EPackage.Registry.INSTANCE
			.getEPackage(VersioningPackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		serverEventEClass.getESuperTypes().add(theEventsPackage.getEvent());
		serverProjectEventEClass.getESuperTypes().add(this.getServerEvent());
		projectUpdatedEventEClass.getESuperTypes().add(this.getServerProjectEvent());

		// Initialize classes and features; add operations and parameters
		initEClass(serverEventEClass, ServerEvent.class, "ServerEvent", IS_ABSTRACT, !IS_INTERFACE,
			IS_GENERATED_INSTANCE_CLASS);

		initEClass(serverProjectEventEClass, ServerProjectEvent.class, "ServerProjectEvent", IS_ABSTRACT,
			!IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getServerProjectEvent_ProjectId(), theEsmodelPackage.getProjectId(), null, "projectId", null, 0,
			1, ServerProjectEvent.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES,
			!IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(projectUpdatedEventEClass, ProjectUpdatedEvent.class, "ProjectUpdatedEvent", !IS_ABSTRACT,
			!IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getProjectUpdatedEvent_NewVersion(), theVersioningPackage.getPrimaryVersionSpec(), null,
			"newVersion", null, 0, 1, ProjectUpdatedEvent.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE,
			IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
	}

} // ServerPackageImpl
