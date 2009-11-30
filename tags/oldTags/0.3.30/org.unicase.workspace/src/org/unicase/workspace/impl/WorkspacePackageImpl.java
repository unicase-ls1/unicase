/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.workspace.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.impl.EPackageImpl;
import org.unicase.emfstore.esmodel.EsmodelPackage;
import org.unicase.emfstore.esmodel.accesscontrol.AccesscontrolPackage;
import org.unicase.emfstore.esmodel.notification.NotificationPackage;
import org.unicase.emfstore.esmodel.versioning.VersioningPackage;
import org.unicase.emfstore.esmodel.versioning.events.EventsPackage;
import org.unicase.emfstore.esmodel.versioning.operations.OperationsPackage;
import org.unicase.model.ModelPackage;
import org.unicase.workspace.OperationComposite;
import org.unicase.workspace.PendingFileTransfer;
import org.unicase.workspace.ProjectSpace;
import org.unicase.workspace.ServerInfo;
import org.unicase.workspace.Usersession;
import org.unicase.workspace.Workspace;
import org.unicase.workspace.WorkspaceFactory;
import org.unicase.workspace.WorkspaceModelVersion;
import org.unicase.workspace.WorkspacePackage;

/**
 * <!-- begin-user-doc --> An implementation of the model <b>Package</b>. <!-- end-user-doc -->
 * 
 * @generated
 */
public class WorkspacePackageImpl extends EPackageImpl implements WorkspacePackage {
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass workspaceEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass serverInfoEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass usersessionEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass projectSpaceEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass operationCompositeEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass workspaceModelVersionEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass pendingFileTransferEClass = null;

	/**
	 * Creates an instance of the model <b>Package</b>, registered with {@link org.eclipse.emf.ecore.EPackage.Registry
	 * EPackage.Registry} by the package package URI value.
	 * <p>
	 * Note: the correct way to create the package is via the static factory method {@link #init init()}, which also
	 * performs initialization of the package, or returns the registered package, if one already exists. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.emf.ecore.EPackage.Registry
	 * @see org.unicase.workspace.WorkspacePackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private WorkspacePackageImpl() {
		super(eNS_URI, WorkspaceFactory.eINSTANCE);
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
	public static WorkspacePackage init() {
		if (isInited)
			return (WorkspacePackage) EPackage.Registry.INSTANCE.getEPackage(WorkspacePackage.eNS_URI);

		// Obtain or create and register package
		WorkspacePackageImpl theWorkspacePackage = (WorkspacePackageImpl) (EPackage.Registry.INSTANCE.get(eNS_URI) instanceof WorkspacePackageImpl ? EPackage.Registry.INSTANCE
			.get(eNS_URI)
			: new WorkspacePackageImpl());

		isInited = true;

		// Initialize simple dependencies
		EsmodelPackage.eINSTANCE.eClass();

		// Create package meta-data objects
		theWorkspacePackage.createPackageContents();

		// Initialize created meta-data
		theWorkspacePackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theWorkspacePackage.freeze();

		return theWorkspacePackage;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getWorkspace() {
		return workspaceEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getWorkspace_ProjectSpaces() {
		return (EReference) workspaceEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getWorkspace_ServerInfos() {
		return (EReference) workspaceEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getWorkspace_Usersessions() {
		return (EReference) workspaceEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getWorkspace_ActiveProjectSpace() {
		return (EReference) workspaceEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getServerInfo() {
		return serverInfoEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EAttribute getServerInfo_Name() {
		return (EAttribute) serverInfoEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EAttribute getServerInfo_Url() {
		return (EAttribute) serverInfoEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EAttribute getServerInfo_Port() {
		return (EAttribute) serverInfoEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getServerInfo_ProjectInfos() {
		return (EReference) serverInfoEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getServerInfo_LastUsersession() {
		return (EReference) serverInfoEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EAttribute getServerInfo_CertificateAlias() {
		return (EAttribute) serverInfoEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getUsersession() {
		return usersessionEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EAttribute getUsersession_Username() {
		return (EAttribute) usersessionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EAttribute getUsersession_Password() {
		return (EAttribute) usersessionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getUsersession_SessionId() {
		return (EReference) usersessionEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EAttribute getUsersession_PersistentPassword() {
		return (EAttribute) usersessionEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getUsersession_ServerInfo() {
		return (EReference) usersessionEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EAttribute getUsersession_SavePassword() {
		return (EAttribute) usersessionEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getUsersession_ACUser() {
		return (EReference) usersessionEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getProjectSpace() {
		return projectSpaceEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getProjectSpace_Project() {
		return (EReference) projectSpaceEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getProjectSpace_ProjectId() {
		return (EReference) projectSpaceEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EAttribute getProjectSpace_ProjectName() {
		return (EAttribute) projectSpaceEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EAttribute getProjectSpace_ProjectDescription() {
		return (EAttribute) projectSpaceEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getProjectSpace_Events() {
		return (EReference) projectSpaceEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getProjectSpace_Usersession() {
		return (EReference) projectSpaceEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EAttribute getProjectSpace_LastUpdated() {
		return (EAttribute) projectSpaceEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getProjectSpace_BaseVersion() {
		return (EReference) projectSpaceEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EAttribute getProjectSpace_ResourceCount() {
		return (EAttribute) projectSpaceEClass.getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EAttribute getProjectSpace_Dirty() {
		return (EAttribute) projectSpaceEClass.getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EAttribute getProjectSpace_OldLogMessages() {
		return (EAttribute) projectSpaceEClass.getEStructuralFeatures().get(10);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getProjectSpace_LocalOperations() {
		return (EReference) projectSpaceEClass.getEStructuralFeatures().get(11);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getProjectSpace_Notifications() {
		return (EReference) projectSpaceEClass.getEStructuralFeatures().get(12);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getProjectSpace_PendingFileTransfers() {
		return (EReference) projectSpaceEClass.getEStructuralFeatures().get(13);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getOperationComposite() {
		return operationCompositeEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getOperationComposite_Operations() {
		return (EReference) operationCompositeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getWorkspaceModelVersion() {
		return workspaceModelVersionEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EAttribute getWorkspaceModelVersion_ModelReleaseNumber() {
		return (EAttribute) workspaceModelVersionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getPendingFileTransfer() {
		return pendingFileTransferEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getPendingFileTransfer_AttachmentId() {
		return (EReference) pendingFileTransferEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EAttribute getPendingFileTransfer_FileVersion() {
		return (EAttribute) pendingFileTransferEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EAttribute getPendingFileTransfer_ChunkNumber() {
		return (EAttribute) pendingFileTransferEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EAttribute getPendingFileTransfer_Upload() {
		return (EAttribute) pendingFileTransferEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public WorkspaceFactory getWorkspaceFactory() {
		return (WorkspaceFactory) getEFactoryInstance();
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
		workspaceEClass = createEClass(WORKSPACE);
		createEReference(workspaceEClass, WORKSPACE__PROJECT_SPACES);
		createEReference(workspaceEClass, WORKSPACE__SERVER_INFOS);
		createEReference(workspaceEClass, WORKSPACE__USERSESSIONS);
		createEReference(workspaceEClass, WORKSPACE__ACTIVE_PROJECT_SPACE);

		serverInfoEClass = createEClass(SERVER_INFO);
		createEAttribute(serverInfoEClass, SERVER_INFO__NAME);
		createEAttribute(serverInfoEClass, SERVER_INFO__URL);
		createEAttribute(serverInfoEClass, SERVER_INFO__PORT);
		createEReference(serverInfoEClass, SERVER_INFO__PROJECT_INFOS);
		createEReference(serverInfoEClass, SERVER_INFO__LAST_USERSESSION);
		createEAttribute(serverInfoEClass, SERVER_INFO__CERTIFICATE_ALIAS);

		usersessionEClass = createEClass(USERSESSION);
		createEAttribute(usersessionEClass, USERSESSION__USERNAME);
		createEAttribute(usersessionEClass, USERSESSION__PASSWORD);
		createEReference(usersessionEClass, USERSESSION__SESSION_ID);
		createEAttribute(usersessionEClass, USERSESSION__PERSISTENT_PASSWORD);
		createEReference(usersessionEClass, USERSESSION__SERVER_INFO);
		createEAttribute(usersessionEClass, USERSESSION__SAVE_PASSWORD);
		createEReference(usersessionEClass, USERSESSION__AC_USER);

		projectSpaceEClass = createEClass(PROJECT_SPACE);
		createEReference(projectSpaceEClass, PROJECT_SPACE__PROJECT);
		createEReference(projectSpaceEClass, PROJECT_SPACE__PROJECT_ID);
		createEAttribute(projectSpaceEClass, PROJECT_SPACE__PROJECT_NAME);
		createEAttribute(projectSpaceEClass, PROJECT_SPACE__PROJECT_DESCRIPTION);
		createEReference(projectSpaceEClass, PROJECT_SPACE__EVENTS);
		createEReference(projectSpaceEClass, PROJECT_SPACE__USERSESSION);
		createEAttribute(projectSpaceEClass, PROJECT_SPACE__LAST_UPDATED);
		createEReference(projectSpaceEClass, PROJECT_SPACE__BASE_VERSION);
		createEAttribute(projectSpaceEClass, PROJECT_SPACE__RESOURCE_COUNT);
		createEAttribute(projectSpaceEClass, PROJECT_SPACE__DIRTY);
		createEAttribute(projectSpaceEClass, PROJECT_SPACE__OLD_LOG_MESSAGES);
		createEReference(projectSpaceEClass, PROJECT_SPACE__LOCAL_OPERATIONS);
		createEReference(projectSpaceEClass, PROJECT_SPACE__NOTIFICATIONS);
		createEReference(projectSpaceEClass, PROJECT_SPACE__PENDING_FILE_TRANSFERS);

		operationCompositeEClass = createEClass(OPERATION_COMPOSITE);
		createEReference(operationCompositeEClass, OPERATION_COMPOSITE__OPERATIONS);

		workspaceModelVersionEClass = createEClass(WORKSPACE_MODEL_VERSION);
		createEAttribute(workspaceModelVersionEClass, WORKSPACE_MODEL_VERSION__MODEL_RELEASE_NUMBER);

		pendingFileTransferEClass = createEClass(PENDING_FILE_TRANSFER);
		createEReference(pendingFileTransferEClass, PENDING_FILE_TRANSFER__ATTACHMENT_ID);
		createEAttribute(pendingFileTransferEClass, PENDING_FILE_TRANSFER__FILE_VERSION);
		createEAttribute(pendingFileTransferEClass, PENDING_FILE_TRANSFER__CHUNK_NUMBER);
		createEAttribute(pendingFileTransferEClass, PENDING_FILE_TRANSFER__UPLOAD);
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
		AccesscontrolPackage theAccesscontrolPackage = (AccesscontrolPackage) EPackage.Registry.INSTANCE
			.getEPackage(AccesscontrolPackage.eNS_URI);
		EventsPackage theEventsPackage = (EventsPackage) EPackage.Registry.INSTANCE.getEPackage(EventsPackage.eNS_URI);
		VersioningPackage theVersioningPackage = (VersioningPackage) EPackage.Registry.INSTANCE
			.getEPackage(VersioningPackage.eNS_URI);
		NotificationPackage theNotificationPackage = (NotificationPackage) EPackage.Registry.INSTANCE
			.getEPackage(NotificationPackage.eNS_URI);
		OperationsPackage theOperationsPackage = (OperationsPackage) EPackage.Registry.INSTANCE
			.getEPackage(OperationsPackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		projectSpaceEClass.getESuperTypes().add(theModelPackage.getIdentifiableElement());

		// Initialize classes and features; add operations and parameters
		initEClass(workspaceEClass, Workspace.class, "Workspace", !IS_ABSTRACT, !IS_INTERFACE,
			IS_GENERATED_INSTANCE_CLASS);
		initEReference(getWorkspace_ProjectSpaces(), this.getProjectSpace(), null, "projectSpaces", null, 0, -1,
			Workspace.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES,
			!IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		getWorkspace_ProjectSpaces().getEKeys().add(theModelPackage.getIdentifiableElement_Identifier());
		initEReference(getWorkspace_ServerInfos(), this.getServerInfo(), null, "serverInfos", null, 0, -1,
			Workspace.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES,
			!IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getWorkspace_Usersessions(), this.getUsersession(), null, "usersessions", null, 0, -1,
			Workspace.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES,
			!IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getWorkspace_ActiveProjectSpace(), this.getProjectSpace(), null, "activeProjectSpace", null, 0,
			1, Workspace.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES,
			!IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		getWorkspace_ActiveProjectSpace().getEKeys().add(theModelPackage.getIdentifiableElement_Identifier());

		initEClass(serverInfoEClass, ServerInfo.class, "ServerInfo", !IS_ABSTRACT, !IS_INTERFACE,
			IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getServerInfo_Name(), ecorePackage.getEString(), "name", null, 1, 1, ServerInfo.class,
			!IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getServerInfo_Url(), ecorePackage.getEString(), "url", null, 1, 1, ServerInfo.class,
			!IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getServerInfo_Port(), ecorePackage.getEInt(), "port", null, 1, 1, ServerInfo.class,
			!IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getServerInfo_ProjectInfos(), theEsmodelPackage.getProjectInfo(), null, "projectInfos", null, 0,
			-1, ServerInfo.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES,
			!IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getServerInfo_LastUsersession(), this.getUsersession(), null, "lastUsersession", null, 0, 1,
			ServerInfo.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES,
			!IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getServerInfo_CertificateAlias(), ecorePackage.getEString(), "certificateAlias", null, 1, 1,
			ServerInfo.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE,
			!IS_DERIVED, IS_ORDERED);

		initEClass(usersessionEClass, Usersession.class, "Usersession", !IS_ABSTRACT, !IS_INTERFACE,
			IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getUsersession_Username(), ecorePackage.getEString(), "username", null, 0, 1, Usersession.class,
			!IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getUsersession_Password(), ecorePackage.getEString(), "password", null, 0, 1, Usersession.class,
			IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getUsersession_SessionId(), theEsmodelPackage.getSessionId(), null, "sessionId", null, 0, 1,
			Usersession.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES,
			!IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getUsersession_PersistentPassword(), ecorePackage.getEString(), "persistentPassword", null, 0,
			1, Usersession.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE,
			!IS_DERIVED, IS_ORDERED);
		initEReference(getUsersession_ServerInfo(), this.getServerInfo(), null, "serverInfo", null, 0, 1,
			Usersession.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES,
			!IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getUsersession_SavePassword(), ecorePackage.getEBoolean(), "savePassword", null, 0, 1,
			Usersession.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE,
			!IS_DERIVED, IS_ORDERED);
		initEReference(getUsersession_ACUser(), theAccesscontrolPackage.getACUser(), null, "ACUser", null, 0, 1,
			Usersession.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES,
			!IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(projectSpaceEClass, ProjectSpace.class, "ProjectSpace", !IS_ABSTRACT, !IS_INTERFACE,
			IS_GENERATED_INSTANCE_CLASS);
		initEReference(getProjectSpace_Project(), theModelPackage.getProject(), null, "project", null, 0, 1,
			ProjectSpace.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES,
			!IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getProjectSpace_ProjectId(), theEsmodelPackage.getProjectId(), null, "projectId", null, 1, 1,
			ProjectSpace.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES,
			!IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getProjectSpace_ProjectName(), ecorePackage.getEString(), "projectName", null, 1, 1,
			ProjectSpace.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE,
			!IS_DERIVED, IS_ORDERED);
		initEAttribute(getProjectSpace_ProjectDescription(), ecorePackage.getEString(), "projectDescription", null, 1,
			1, ProjectSpace.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE,
			!IS_DERIVED, IS_ORDERED);
		initEReference(getProjectSpace_Events(), theEventsPackage.getEvent(), null, "events", null, 0, -1,
			ProjectSpace.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES,
			!IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getProjectSpace_Usersession(), this.getUsersession(), null, "usersession", null, 0, 1,
			ProjectSpace.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES,
			!IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getProjectSpace_LastUpdated(), ecorePackage.getEDate(), "lastUpdated", null, 0, 1,
			ProjectSpace.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE,
			!IS_DERIVED, IS_ORDERED);
		initEReference(getProjectSpace_BaseVersion(), theVersioningPackage.getPrimaryVersionSpec(), null,
			"baseVersion", null, 1, 1, ProjectSpace.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE,
			IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getProjectSpace_ResourceCount(), ecorePackage.getEInt(), "resourceCount", null, 0, 1,
			ProjectSpace.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE,
			!IS_DERIVED, IS_ORDERED);
		initEAttribute(getProjectSpace_Dirty(), ecorePackage.getEBoolean(), "dirty", null, 0, 1, ProjectSpace.class,
			!IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getProjectSpace_OldLogMessages(), ecorePackage.getEString(), "oldLogMessages", null, 0, -1,
			ProjectSpace.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE,
			!IS_DERIVED, IS_ORDERED);
		initEReference(getProjectSpace_LocalOperations(), this.getOperationComposite(), null, "localOperations", null,
			0, 1, ProjectSpace.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES,
			!IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getProjectSpace_Notifications(), theNotificationPackage.getESNotification(), null,
			"notifications", null, 0, -1, ProjectSpace.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE,
			IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getProjectSpace_PendingFileTransfers(), this.getPendingFileTransfer(), null,
			"pendingFileTransfers", null, 0, -1, ProjectSpace.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE,
			IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(operationCompositeEClass, OperationComposite.class, "OperationComposite", !IS_ABSTRACT,
			!IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getOperationComposite_Operations(), theOperationsPackage.getAbstractOperation(), null,
			"operations", null, 0, -1, OperationComposite.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE,
			IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(workspaceModelVersionEClass, WorkspaceModelVersion.class, "WorkspaceModelVersion", !IS_ABSTRACT,
			!IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getWorkspaceModelVersion_ModelReleaseNumber(), ecorePackage.getEInt(), "modelReleaseNumber",
			null, 0, 1, WorkspaceModelVersion.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE,
			!IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(pendingFileTransferEClass, PendingFileTransfer.class, "PendingFileTransfer", !IS_ABSTRACT,
			!IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getPendingFileTransfer_AttachmentId(), theModelPackage.getModelElementId(), null,
			"attachmentId", null, 0, 1, PendingFileTransfer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE,
			IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPendingFileTransfer_FileVersion(), ecorePackage.getEInt(), "fileVersion", null, 0, 1,
			PendingFileTransfer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE,
			!IS_DERIVED, IS_ORDERED);
		initEAttribute(getPendingFileTransfer_ChunkNumber(), ecorePackage.getEInt(), "chunkNumber", null, 0, 1,
			PendingFileTransfer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE,
			!IS_DERIVED, IS_ORDERED);
		initEAttribute(getPendingFileTransfer_Upload(), ecorePackage.getEBoolean(), "upload", null, 0, 1,
			PendingFileTransfer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE,
			!IS_DERIVED, IS_ORDERED);

		// Create resource
		createResource(eNS_URI);
	}

} // WorkspacePackageImpl
