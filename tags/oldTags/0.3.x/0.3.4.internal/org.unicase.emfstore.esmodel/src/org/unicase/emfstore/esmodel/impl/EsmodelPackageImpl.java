/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.emfstore.esmodel.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.impl.EPackageImpl;
import org.unicase.emfstore.esmodel.ClientVersionInfo;
import org.unicase.emfstore.esmodel.EsmodelFactory;
import org.unicase.emfstore.esmodel.EsmodelPackage;
import org.unicase.emfstore.esmodel.ProjectHistory;
import org.unicase.emfstore.esmodel.ProjectId;
import org.unicase.emfstore.esmodel.ProjectInfo;
import org.unicase.emfstore.esmodel.ServerSpace;
import org.unicase.emfstore.esmodel.SessionId;
import org.unicase.emfstore.esmodel.VersionInfo;
import org.unicase.emfstore.esmodel.accesscontrol.AccesscontrolPackage;
import org.unicase.emfstore.esmodel.accesscontrol.impl.AccesscontrolPackageImpl;
import org.unicase.emfstore.esmodel.accesscontrol.roles.RolesPackage;
import org.unicase.emfstore.esmodel.accesscontrol.roles.impl.RolesPackageImpl;
import org.unicase.emfstore.esmodel.versioning.VersioningPackage;
import org.unicase.emfstore.esmodel.versioning.events.EventsPackage;
import org.unicase.emfstore.esmodel.versioning.events.impl.EventsPackageImpl;
import org.unicase.emfstore.esmodel.versioning.impl.VersioningPackageImpl;
import org.unicase.emfstore.esmodel.versioning.operations.OperationsPackage;
import org.unicase.emfstore.esmodel.versioning.operations.impl.OperationsPackageImpl;
import org.unicase.model.ModelPackage;

/**
 * <!-- begin-user-doc --> An implementation of the model <b>Package</b>. <!-- end-user-doc -->
 * 
 * @generated
 */
public class EsmodelPackageImpl extends EPackageImpl implements EsmodelPackage {
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass projectHistoryEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass projectInfoEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass sessionIdEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass serverSpaceEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass projectIdEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass versionInfoEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass clientVersionInfoEClass = null;

	/**
	 * Creates an instance of the model <b>Package</b>, registered with {@link org.eclipse.emf.ecore.EPackage.Registry
	 * EPackage.Registry} by the package package URI value.
	 * <p>
	 * Note: the correct way to create the package is via the static factory method {@link #init init()}, which also
	 * performs initialization of the package, or returns the registered package, if one already exists. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.emf.ecore.EPackage.Registry
	 * @see org.unicase.emfstore.esmodel.EsmodelPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private EsmodelPackageImpl() {
		super(eNS_URI, EsmodelFactory.eINSTANCE);
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
	public static EsmodelPackage init() {
		if (isInited)
			return (EsmodelPackage) EPackage.Registry.INSTANCE.getEPackage(EsmodelPackage.eNS_URI);

		// Obtain or create and register package
		EsmodelPackageImpl theEsmodelPackage = (EsmodelPackageImpl) (EPackage.Registry.INSTANCE.getEPackage(eNS_URI) instanceof EsmodelPackageImpl ? EPackage.Registry.INSTANCE
			.getEPackage(eNS_URI)
			: new EsmodelPackageImpl());

		isInited = true;

		// Initialize simple dependencies
		ModelPackage.eINSTANCE.eClass();

		// Obtain or create and register interdependencies
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
		theEsmodelPackage.createPackageContents();
		theVersioningPackage.createPackageContents();
		theOperationsPackage.createPackageContents();
		theEventsPackage.createPackageContents();
		theAccesscontrolPackage.createPackageContents();
		theRolesPackage.createPackageContents();

		// Initialize created meta-data
		theEsmodelPackage.initializePackageContents();
		theVersioningPackage.initializePackageContents();
		theOperationsPackage.initializePackageContents();
		theEventsPackage.initializePackageContents();
		theAccesscontrolPackage.initializePackageContents();
		theRolesPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theEsmodelPackage.freeze();

		return theEsmodelPackage;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getProjectHistory() {
		return projectHistoryEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getProjectHistory_ProjectId() {
		return (EReference) projectHistoryEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getProjectHistory_Versions() {
		return (EReference) projectHistoryEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EAttribute getProjectHistory_ProjectName() {
		return (EAttribute) projectHistoryEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EAttribute getProjectHistory_ProjectDescription() {
		return (EAttribute) projectHistoryEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getProjectInfo() {
		return projectInfoEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EAttribute getProjectInfo_Name() {
		return (EAttribute) projectInfoEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EAttribute getProjectInfo_Description() {
		return (EAttribute) projectInfoEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getProjectInfo_ProjectId() {
		return (EReference) projectInfoEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getProjectInfo_Version() {
		return (EReference) projectInfoEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getSessionId() {
		return sessionIdEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getServerSpace() {
		return serverSpaceEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getServerSpace_Groups() {
		return (EReference) serverSpaceEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getServerSpace_Projects() {
		return (EReference) serverSpaceEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getServerSpace_OpenSessions() {
		return (EReference) serverSpaceEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getServerSpace_Users() {
		return (EReference) serverSpaceEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getProjectId() {
		return projectIdEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getVersionInfo() {
		return versionInfoEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EAttribute getVersionInfo_EmfStoreVersionString() {
		return (EAttribute) versionInfoEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getClientVersionInfo() {
		return clientVersionInfoEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EAttribute getClientVersionInfo_Version() {
		return (EAttribute) clientVersionInfoEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EAttribute getClientVersionInfo_Name() {
		return (EAttribute) clientVersionInfoEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EsmodelFactory getEsmodelFactory() {
		return (EsmodelFactory) getEFactoryInstance();
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
		projectHistoryEClass = createEClass(PROJECT_HISTORY);
		createEReference(projectHistoryEClass, PROJECT_HISTORY__PROJECT_ID);
		createEReference(projectHistoryEClass, PROJECT_HISTORY__VERSIONS);
		createEAttribute(projectHistoryEClass, PROJECT_HISTORY__PROJECT_NAME);
		createEAttribute(projectHistoryEClass, PROJECT_HISTORY__PROJECT_DESCRIPTION);

		projectInfoEClass = createEClass(PROJECT_INFO);
		createEAttribute(projectInfoEClass, PROJECT_INFO__NAME);
		createEAttribute(projectInfoEClass, PROJECT_INFO__DESCRIPTION);
		createEReference(projectInfoEClass, PROJECT_INFO__PROJECT_ID);
		createEReference(projectInfoEClass, PROJECT_INFO__VERSION);

		sessionIdEClass = createEClass(SESSION_ID);

		serverSpaceEClass = createEClass(SERVER_SPACE);
		createEReference(serverSpaceEClass, SERVER_SPACE__GROUPS);
		createEReference(serverSpaceEClass, SERVER_SPACE__PROJECTS);
		createEReference(serverSpaceEClass, SERVER_SPACE__OPEN_SESSIONS);
		createEReference(serverSpaceEClass, SERVER_SPACE__USERS);

		projectIdEClass = createEClass(PROJECT_ID);

		versionInfoEClass = createEClass(VERSION_INFO);
		createEAttribute(versionInfoEClass, VERSION_INFO__EMF_STORE_VERSION_STRING);

		clientVersionInfoEClass = createEClass(CLIENT_VERSION_INFO);
		createEAttribute(clientVersionInfoEClass, CLIENT_VERSION_INFO__VERSION);
		createEAttribute(clientVersionInfoEClass, CLIENT_VERSION_INFO__NAME);
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
		VersioningPackage theVersioningPackage = (VersioningPackage) EPackage.Registry.INSTANCE
			.getEPackage(VersioningPackage.eNS_URI);
		AccesscontrolPackage theAccesscontrolPackage = (AccesscontrolPackage) EPackage.Registry.INSTANCE
			.getEPackage(AccesscontrolPackage.eNS_URI);
		ModelPackage theModelPackage = (ModelPackage) EPackage.Registry.INSTANCE.getEPackage(ModelPackage.eNS_URI);
		EcorePackage theEcorePackage = (EcorePackage) EPackage.Registry.INSTANCE.getEPackage(EcorePackage.eNS_URI);

		// Add subpackages
		getESubpackages().add(theVersioningPackage);
		getESubpackages().add(theAccesscontrolPackage);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		sessionIdEClass.getESuperTypes().add(theModelPackage.getUniqueIdentifier());
		projectIdEClass.getESuperTypes().add(theModelPackage.getUniqueIdentifier());

		// Initialize classes and features; add operations and parameters
		initEClass(projectHistoryEClass, ProjectHistory.class, "ProjectHistory", !IS_ABSTRACT, !IS_INTERFACE,
			IS_GENERATED_INSTANCE_CLASS);
		initEReference(getProjectHistory_ProjectId(), this.getProjectId(), null, "projectId", null, 0, 1,
			ProjectHistory.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES,
			!IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getProjectHistory_Versions(), theVersioningPackage.getVersion(), null, "versions", null, 1, -1,
			ProjectHistory.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES,
			!IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getProjectHistory_ProjectName(), ecorePackage.getEString(), "projectName", null, 1, 1,
			ProjectHistory.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE,
			!IS_DERIVED, IS_ORDERED);
		initEAttribute(getProjectHistory_ProjectDescription(), ecorePackage.getEString(), "projectDescription", null,
			1, 1, ProjectHistory.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE,
			!IS_DERIVED, IS_ORDERED);

		initEClass(projectInfoEClass, ProjectInfo.class, "ProjectInfo", !IS_ABSTRACT, !IS_INTERFACE,
			IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getProjectInfo_Name(), ecorePackage.getEString(), "name", null, 1, 1, ProjectInfo.class,
			!IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getProjectInfo_Description(), ecorePackage.getEString(), "description", null, 0, 1,
			ProjectInfo.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE,
			!IS_DERIVED, IS_ORDERED);
		initEReference(getProjectInfo_ProjectId(), this.getProjectId(), null, "projectId", null, 1, 1,
			ProjectInfo.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES,
			!IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getProjectInfo_Version(), theVersioningPackage.getPrimaryVersionSpec(), null, "version", null,
			1, 1, ProjectInfo.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES,
			!IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(sessionIdEClass, SessionId.class, "SessionId", !IS_ABSTRACT, !IS_INTERFACE,
			IS_GENERATED_INSTANCE_CLASS);

		initEClass(serverSpaceEClass, ServerSpace.class, "ServerSpace", !IS_ABSTRACT, !IS_INTERFACE,
			IS_GENERATED_INSTANCE_CLASS);
		initEReference(getServerSpace_Groups(), theAccesscontrolPackage.getACGroup(), null, "groups", null, 0, -1,
			ServerSpace.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES,
			!IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getServerSpace_Projects(), this.getProjectHistory(), null, "projects", null, 0, -1,
			ServerSpace.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES,
			!IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getServerSpace_OpenSessions(), this.getSessionId(), null, "openSessions", null, 0, -1,
			ServerSpace.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES,
			!IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getServerSpace_Users(), theAccesscontrolPackage.getACUser(), null, "users", null, 0, -1,
			ServerSpace.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES,
			!IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(projectIdEClass, ProjectId.class, "ProjectId", !IS_ABSTRACT, !IS_INTERFACE,
			IS_GENERATED_INSTANCE_CLASS);

		initEClass(versionInfoEClass, VersionInfo.class, "VersionInfo", !IS_ABSTRACT, !IS_INTERFACE,
			IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getVersionInfo_EmfStoreVersionString(), ecorePackage.getEString(), "emfStoreVersionString",
			null, 0, 1, VersionInfo.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID,
			IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(clientVersionInfoEClass, ClientVersionInfo.class, "ClientVersionInfo", !IS_ABSTRACT, !IS_INTERFACE,
			IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getClientVersionInfo_Version(), theEcorePackage.getEString(), "version", null, 0, 1,
			ClientVersionInfo.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE,
			!IS_DERIVED, IS_ORDERED);
		initEAttribute(getClientVersionInfo_Name(), theEcorePackage.getEString(), "name", null, 0, 1,
			ClientVersionInfo.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE,
			!IS_DERIVED, IS_ORDERED);

		// Create resource
		createResource(eNS_URI);
	}

} // EsmodelPackageImpl
