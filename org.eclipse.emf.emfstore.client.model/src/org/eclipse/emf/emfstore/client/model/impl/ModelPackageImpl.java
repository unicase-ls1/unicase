/**
 * <copyright> Copyright (c) 2008-2011 Chair for Applied Software Engineering, Technische Unversitaet Muenchen. All rights reserved. This program and the accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 * 
 */
package org.eclipse.emf.emfstore.client.model.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.eclipse.emf.emfstore.client.model.ModelFactory;
import org.eclipse.emf.emfstore.client.model.ModelPackage;
import org.eclipse.emf.emfstore.client.model.OperationComposite;
import org.eclipse.emf.emfstore.client.model.PendingFileTransfer;
import org.eclipse.emf.emfstore.client.model.ProjectData;
import org.eclipse.emf.emfstore.client.model.ProjectSpaceDataInternal;
import org.eclipse.emf.emfstore.client.model.ServerInfo;
import org.eclipse.emf.emfstore.client.model.Usersession;
import org.eclipse.emf.emfstore.client.model.WorkspaceDataInternal;

import org.eclipse.emf.emfstore.server.model.accesscontrol.AccesscontrolPackage;

import org.eclipse.emf.emfstore.server.model.versioning.VersioningPackage;

import org.eclipse.emf.emfstore.server.model.versioning.operations.OperationsPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class ModelPackageImpl extends EPackageImpl implements ModelPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass workspaceDataInternalEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass serverInfoEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass usersessionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass projectSpaceDataInternalEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass operationCompositeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass pendingFileTransferEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass projectDataEClass = null;

	/**
	 * Creates an instance of the model <b>Package</b>, registered with
	 * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
	 * package URI value.
	 * <p>Note: the correct way to create the package is via the static
	 * factory method {@link #init init()}, which also performs
	 * initialization of the package, or returns the registered package,
	 * if one already exists.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ecore.EPackage.Registry
	 * @see org.eclipse.emf.emfstore.client.model.ModelPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private ModelPackageImpl() {
		super(eNS_URI, ModelFactory.eINSTANCE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static boolean isInited = false;

	/**
	 * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
	 * 
	 * <p>This method is used to initialize {@link ModelPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static ModelPackage init() {
		if (isInited)
			return (ModelPackage) EPackage.Registry.INSTANCE
					.getEPackage(ModelPackage.eNS_URI);

		// Obtain or create and register package
		ModelPackageImpl theModelPackage = (ModelPackageImpl) (EPackage.Registry.INSTANCE
				.get(eNS_URI) instanceof ModelPackageImpl ? EPackage.Registry.INSTANCE
				.get(eNS_URI) : new ModelPackageImpl());

		isInited = true;

		// Initialize simple dependencies
		org.eclipse.emf.emfstore.server.model.ModelPackage.eINSTANCE.eClass();

		// Create package meta-data objects
		theModelPackage.createPackageContents();

		// Initialize created meta-data
		theModelPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theModelPackage.freeze();

		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(ModelPackage.eNS_URI, theModelPackage);
		return theModelPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getWorkspaceDataInternal() {
		return workspaceDataInternalEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getWorkspaceDataInternal_InternalProjectSpaces() {
		return (EReference) workspaceDataInternalEClass
				.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getWorkspaceDataInternal_InternalServerInfos() {
		return (EReference) workspaceDataInternalEClass
				.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getWorkspaceDataInternal_InternalUsersessions() {
		return (EReference) workspaceDataInternalEClass
				.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getWorkspaceDataInternal_InternalActiveProjectSpace() {
		return (EReference) workspaceDataInternalEClass
				.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getServerInfo() {
		return serverInfoEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getServerInfo_Name() {
		return (EAttribute) serverInfoEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getServerInfo_Url() {
		return (EAttribute) serverInfoEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getServerInfo_Port() {
		return (EAttribute) serverInfoEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getServerInfo_ProjectInfos() {
		return (EReference) serverInfoEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getServerInfo_LastUsersession() {
		return (EReference) serverInfoEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getServerInfo_CertificateAlias() {
		return (EAttribute) serverInfoEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getUsersession() {
		return usersessionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getUsersession_Username() {
		return (EAttribute) usersessionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getUsersession_Password() {
		return (EAttribute) usersessionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getUsersession_SessionId() {
		return (EReference) usersessionEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getUsersession_PersistentPassword() {
		return (EAttribute) usersessionEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getUsersession_ServerInfo() {
		return (EReference) usersessionEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getUsersession_SavePassword() {
		return (EAttribute) usersessionEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getUsersession_ACUser() {
		return (EReference) usersessionEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getUsersession_ChangedProperties() {
		return (EReference) usersessionEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getProjectSpaceDataInternal() {
		return projectSpaceDataInternalEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getProjectSpaceDataInternal_ProjectId() {
		return (EReference) projectSpaceDataInternalEClass
				.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getProjectSpaceDataInternal_ProjectName() {
		return (EAttribute) projectSpaceDataInternalEClass
				.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getProjectSpaceDataInternal_ProjectDescription() {
		return (EAttribute) projectSpaceDataInternalEClass
				.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getProjectSpaceDataInternal_Usersession() {
		return (EReference) projectSpaceDataInternalEClass
				.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getProjectSpaceDataInternal_LastUpdated() {
		return (EAttribute) projectSpaceDataInternalEClass
				.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getProjectSpaceDataInternal_BaseVersion() {
		return (EReference) projectSpaceDataInternalEClass
				.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getProjectSpaceDataInternal_ResourceCount() {
		return (EAttribute) projectSpaceDataInternalEClass
				.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getProjectSpaceDataInternal_Dirty() {
		return (EAttribute) projectSpaceDataInternalEClass
				.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getProjectSpaceDataInternal_OldLogMessages() {
		return (EAttribute) projectSpaceDataInternalEClass
				.getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getProjectSpaceDataInternal_WaitingUploads() {
		return (EReference) projectSpaceDataInternalEClass
				.getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getProjectSpaceDataInternal_ProjectDataPath() {
		return (EAttribute) projectSpaceDataInternalEClass
				.getEStructuralFeatures().get(10);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getOperationComposite() {
		return operationCompositeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getOperationComposite_Operations() {
		return (EReference) operationCompositeEClass.getEStructuralFeatures()
				.get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPendingFileTransfer() {
		return pendingFileTransferEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPendingFileTransfer_AttachmentId() {
		return (EReference) pendingFileTransferEClass.getEStructuralFeatures()
				.get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPendingFileTransfer_FileVersion() {
		return (EAttribute) pendingFileTransferEClass.getEStructuralFeatures()
				.get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPendingFileTransfer_ChunkNumber() {
		return (EAttribute) pendingFileTransferEClass.getEStructuralFeatures()
				.get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPendingFileTransfer_Upload() {
		return (EAttribute) pendingFileTransferEClass.getEStructuralFeatures()
				.get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPendingFileTransfer_FileName() {
		return (EAttribute) pendingFileTransferEClass.getEStructuralFeatures()
				.get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPendingFileTransfer_PreliminaryFileName() {
		return (EAttribute) pendingFileTransferEClass.getEStructuralFeatures()
				.get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getProjectData() {
		return projectDataEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getProjectData_Project() {
		return (EReference) projectDataEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getProjectData_LocalOperations() {
		return (EReference) projectDataEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ModelFactory getModelFactory() {
		return (ModelFactory) getEFactoryInstance();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isCreated = false;

	/**
	 * Creates the meta-model objects for the package.  This method is
	 * guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void createPackageContents() {
		if (isCreated)
			return;
		isCreated = true;

		// Create classes and their features
		workspaceDataInternalEClass = createEClass(WORKSPACE_DATA_INTERNAL);
		createEReference(workspaceDataInternalEClass,
				WORKSPACE_DATA_INTERNAL__INTERNAL_PROJECT_SPACES);
		createEReference(workspaceDataInternalEClass,
				WORKSPACE_DATA_INTERNAL__INTERNAL_SERVER_INFOS);
		createEReference(workspaceDataInternalEClass,
				WORKSPACE_DATA_INTERNAL__INTERNAL_USERSESSIONS);
		createEReference(workspaceDataInternalEClass,
				WORKSPACE_DATA_INTERNAL__INTERNAL_ACTIVE_PROJECT_SPACE);

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
		createEReference(usersessionEClass, USERSESSION__CHANGED_PROPERTIES);

		projectSpaceDataInternalEClass = createEClass(PROJECT_SPACE_DATA_INTERNAL);
		createEReference(projectSpaceDataInternalEClass,
				PROJECT_SPACE_DATA_INTERNAL__PROJECT_ID);
		createEAttribute(projectSpaceDataInternalEClass,
				PROJECT_SPACE_DATA_INTERNAL__PROJECT_NAME);
		createEAttribute(projectSpaceDataInternalEClass,
				PROJECT_SPACE_DATA_INTERNAL__PROJECT_DESCRIPTION);
		createEReference(projectSpaceDataInternalEClass,
				PROJECT_SPACE_DATA_INTERNAL__USERSESSION);
		createEAttribute(projectSpaceDataInternalEClass,
				PROJECT_SPACE_DATA_INTERNAL__LAST_UPDATED);
		createEReference(projectSpaceDataInternalEClass,
				PROJECT_SPACE_DATA_INTERNAL__BASE_VERSION);
		createEAttribute(projectSpaceDataInternalEClass,
				PROJECT_SPACE_DATA_INTERNAL__RESOURCE_COUNT);
		createEAttribute(projectSpaceDataInternalEClass,
				PROJECT_SPACE_DATA_INTERNAL__DIRTY);
		createEAttribute(projectSpaceDataInternalEClass,
				PROJECT_SPACE_DATA_INTERNAL__OLD_LOG_MESSAGES);
		createEReference(projectSpaceDataInternalEClass,
				PROJECT_SPACE_DATA_INTERNAL__WAITING_UPLOADS);
		createEAttribute(projectSpaceDataInternalEClass,
				PROJECT_SPACE_DATA_INTERNAL__PROJECT_DATA_PATH);

		operationCompositeEClass = createEClass(OPERATION_COMPOSITE);
		createEReference(operationCompositeEClass,
				OPERATION_COMPOSITE__OPERATIONS);

		pendingFileTransferEClass = createEClass(PENDING_FILE_TRANSFER);
		createEReference(pendingFileTransferEClass,
				PENDING_FILE_TRANSFER__ATTACHMENT_ID);
		createEAttribute(pendingFileTransferEClass,
				PENDING_FILE_TRANSFER__FILE_VERSION);
		createEAttribute(pendingFileTransferEClass,
				PENDING_FILE_TRANSFER__CHUNK_NUMBER);
		createEAttribute(pendingFileTransferEClass,
				PENDING_FILE_TRANSFER__UPLOAD);
		createEAttribute(pendingFileTransferEClass,
				PENDING_FILE_TRANSFER__FILE_NAME);
		createEAttribute(pendingFileTransferEClass,
				PENDING_FILE_TRANSFER__PRELIMINARY_FILE_NAME);

		projectDataEClass = createEClass(PROJECT_DATA);
		createEReference(projectDataEClass, PROJECT_DATA__PROJECT);
		createEReference(projectDataEClass, PROJECT_DATA__LOCAL_OPERATIONS);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isInitialized = false;

	/**
	 * Complete the initialization of the package and its meta-model.  This
	 * method is guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
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
		org.eclipse.emf.emfstore.common.model.ModelPackage theModelPackage_2 = (org.eclipse.emf.emfstore.common.model.ModelPackage) EPackage.Registry.INSTANCE
				.getEPackage(org.eclipse.emf.emfstore.common.model.ModelPackage.eNS_URI);
		org.eclipse.emf.emfstore.server.model.ModelPackage theModelPackage_1 = (org.eclipse.emf.emfstore.server.model.ModelPackage) EPackage.Registry.INSTANCE
				.getEPackage(org.eclipse.emf.emfstore.server.model.ModelPackage.eNS_URI);
		AccesscontrolPackage theAccesscontrolPackage = (AccesscontrolPackage) EPackage.Registry.INSTANCE
				.getEPackage(AccesscontrolPackage.eNS_URI);
		VersioningPackage theVersioningPackage = (VersioningPackage) EPackage.Registry.INSTANCE
				.getEPackage(VersioningPackage.eNS_URI);
		OperationsPackage theOperationsPackage = (OperationsPackage) EPackage.Registry.INSTANCE
				.getEPackage(OperationsPackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		projectSpaceDataInternalEClass.getESuperTypes().add(
				theModelPackage_2.getIdentifiableElement());

		// Initialize classes and features; add operations and parameters
		initEClass(workspaceDataInternalEClass, WorkspaceDataInternal.class,
				"WorkspaceDataInternal", !IS_ABSTRACT, !IS_INTERFACE,
				IS_GENERATED_INSTANCE_CLASS);
		initEReference(getWorkspaceDataInternal_InternalProjectSpaces(),
				this.getProjectSpaceDataInternal(), null,
				"internalProjectSpaces", null, 0, -1,
				WorkspaceDataInternal.class, !IS_TRANSIENT, !IS_VOLATILE,
				IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES,
				!IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		getWorkspaceDataInternal_InternalProjectSpaces().getEKeys().add(
				theModelPackage_2.getIdentifiableElement_Identifier());
		initEReference(getWorkspaceDataInternal_InternalServerInfos(),
				this.getServerInfo(), null, "internalServerInfos", null, 0, -1,
				WorkspaceDataInternal.class, !IS_TRANSIENT, !IS_VOLATILE,
				IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES,
				!IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getWorkspaceDataInternal_InternalUsersessions(),
				this.getUsersession(), null, "internalUsersessions", null, 0,
				-1, WorkspaceDataInternal.class, !IS_TRANSIENT, !IS_VOLATILE,
				IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES,
				!IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getWorkspaceDataInternal_InternalActiveProjectSpace(),
				this.getProjectSpaceDataInternal(), null,
				"internalActiveProjectSpace", null, 0, 1,
				WorkspaceDataInternal.class, !IS_TRANSIENT, !IS_VOLATILE,
				IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES,
				!IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		getWorkspaceDataInternal_InternalActiveProjectSpace().getEKeys().add(
				theModelPackage_2.getIdentifiableElement_Identifier());

		initEClass(serverInfoEClass, ServerInfo.class, "ServerInfo",
				!IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getServerInfo_Name(), ecorePackage.getEString(), "name",
				null, 1, 1, ServerInfo.class, !IS_TRANSIENT, !IS_VOLATILE,
				IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED,
				IS_ORDERED);
		initEAttribute(getServerInfo_Url(), ecorePackage.getEString(), "url",
				null, 1, 1, ServerInfo.class, !IS_TRANSIENT, !IS_VOLATILE,
				IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED,
				IS_ORDERED);
		initEAttribute(getServerInfo_Port(), ecorePackage.getEInt(), "port",
				null, 1, 1, ServerInfo.class, !IS_TRANSIENT, !IS_VOLATILE,
				IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED,
				IS_ORDERED);
		initEReference(getServerInfo_ProjectInfos(),
				theModelPackage_1.getProjectInfo(), null, "projectInfos", null,
				0, -1, ServerInfo.class, !IS_TRANSIENT, !IS_VOLATILE,
				IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES,
				!IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getServerInfo_LastUsersession(), this.getUsersession(),
				null, "lastUsersession", null, 0, 1, ServerInfo.class,
				!IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE,
				IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED,
				IS_ORDERED);
		initEAttribute(getServerInfo_CertificateAlias(),
				ecorePackage.getEString(), "certificateAlias", null, 1, 1,
				ServerInfo.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE,
				!IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(usersessionEClass, Usersession.class, "Usersession",
				!IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getUsersession_Username(), ecorePackage.getEString(),
				"username", null, 0, 1, Usersession.class, !IS_TRANSIENT,
				!IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE,
				!IS_DERIVED, IS_ORDERED);
		initEAttribute(getUsersession_Password(), ecorePackage.getEString(),
				"password", null, 0, 1, Usersession.class, IS_TRANSIENT,
				!IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE,
				!IS_DERIVED, IS_ORDERED);
		initEReference(getUsersession_SessionId(),
				theModelPackage_1.getSessionId(), null, "sessionId", null, 0,
				1, Usersession.class, IS_TRANSIENT, !IS_VOLATILE,
				IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES,
				!IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getUsersession_PersistentPassword(),
				ecorePackage.getEString(), "persistentPassword", null, 0, 1,
				Usersession.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE,
				!IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getUsersession_ServerInfo(), this.getServerInfo(), null,
				"serverInfo", null, 0, 1, Usersession.class, !IS_TRANSIENT,
				!IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES,
				!IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getUsersession_SavePassword(),
				ecorePackage.getEBoolean(), "savePassword", null, 0, 1,
				Usersession.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE,
				!IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getUsersession_ACUser(),
				theAccesscontrolPackage.getACUser(), null, "ACUser", null, 0,
				1, Usersession.class, !IS_TRANSIENT, !IS_VOLATILE,
				IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES,
				!IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getUsersession_ChangedProperties(),
				theAccesscontrolPackage.getOrgUnitProperty(), null,
				"changedProperties", null, 0, -1, Usersession.class,
				!IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE,
				IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED,
				IS_ORDERED);

		initEClass(projectSpaceDataInternalEClass,
				ProjectSpaceDataInternal.class, "ProjectSpaceDataInternal",
				!IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getProjectSpaceDataInternal_ProjectId(),
				theModelPackage_1.getProjectId(), null, "projectId", null, 1,
				1, ProjectSpaceDataInternal.class, !IS_TRANSIENT, !IS_VOLATILE,
				IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES,
				!IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getProjectSpaceDataInternal_ProjectName(),
				ecorePackage.getEString(), "projectName", null, 1, 1,
				ProjectSpaceDataInternal.class, !IS_TRANSIENT, !IS_VOLATILE,
				IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED,
				IS_ORDERED);
		initEAttribute(getProjectSpaceDataInternal_ProjectDescription(),
				ecorePackage.getEString(), "projectDescription", null, 1, 1,
				ProjectSpaceDataInternal.class, !IS_TRANSIENT, !IS_VOLATILE,
				IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED,
				IS_ORDERED);
		initEReference(getProjectSpaceDataInternal_Usersession(),
				this.getUsersession(), null, "usersession", null, 0, 1,
				ProjectSpaceDataInternal.class, !IS_TRANSIENT, !IS_VOLATILE,
				IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES,
				!IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getProjectSpaceDataInternal_LastUpdated(),
				ecorePackage.getEDate(), "lastUpdated", null, 0, 1,
				ProjectSpaceDataInternal.class, !IS_TRANSIENT, !IS_VOLATILE,
				IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED,
				IS_ORDERED);
		initEReference(getProjectSpaceDataInternal_BaseVersion(),
				theVersioningPackage.getPrimaryVersionSpec(), null,
				"baseVersion", null, 1, 1, ProjectSpaceDataInternal.class,
				!IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE,
				IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED,
				IS_ORDERED);
		initEAttribute(getProjectSpaceDataInternal_ResourceCount(),
				ecorePackage.getEInt(), "resourceCount", null, 0, 1,
				ProjectSpaceDataInternal.class, !IS_TRANSIENT, !IS_VOLATILE,
				IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED,
				IS_ORDERED);
		initEAttribute(getProjectSpaceDataInternal_Dirty(),
				ecorePackage.getEBoolean(), "dirty", null, 0, 1,
				ProjectSpaceDataInternal.class, !IS_TRANSIENT, !IS_VOLATILE,
				IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED,
				IS_ORDERED);
		initEAttribute(getProjectSpaceDataInternal_OldLogMessages(),
				ecorePackage.getEString(), "oldLogMessages", null, 0, -1,
				ProjectSpaceDataInternal.class, !IS_TRANSIENT, !IS_VOLATILE,
				IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED,
				IS_ORDERED);
		initEReference(getProjectSpaceDataInternal_WaitingUploads(),
				theModelPackage_1.getFileIdentifier(), null, "waitingUploads",
				null, 0, -1, ProjectSpaceDataInternal.class, !IS_TRANSIENT,
				!IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES,
				!IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getProjectSpaceDataInternal_ProjectDataPath(),
				ecorePackage.getEString(), "projectDataPath", null, 0, 1,
				ProjectSpaceDataInternal.class, !IS_TRANSIENT, !IS_VOLATILE,
				IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED,
				IS_ORDERED);

		initEClass(operationCompositeEClass, OperationComposite.class,
				"OperationComposite", !IS_ABSTRACT, !IS_INTERFACE,
				IS_GENERATED_INSTANCE_CLASS);
		initEReference(getOperationComposite_Operations(),
				theOperationsPackage.getAbstractOperation(), null,
				"operations", null, 0, -1, OperationComposite.class,
				!IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE,
				IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED,
				IS_ORDERED);

		initEClass(pendingFileTransferEClass, PendingFileTransfer.class,
				"PendingFileTransfer", !IS_ABSTRACT, !IS_INTERFACE,
				IS_GENERATED_INSTANCE_CLASS);
		initEReference(getPendingFileTransfer_AttachmentId(),
				theModelPackage_2.getModelElementId(), null, "attachmentId",
				null, 0, 1, PendingFileTransfer.class, !IS_TRANSIENT,
				!IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES,
				!IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPendingFileTransfer_FileVersion(),
				ecorePackage.getEInt(), "fileVersion", null, 0, 1,
				PendingFileTransfer.class, !IS_TRANSIENT, !IS_VOLATILE,
				IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED,
				IS_ORDERED);
		initEAttribute(getPendingFileTransfer_ChunkNumber(),
				ecorePackage.getEInt(), "chunkNumber", null, 0, 1,
				PendingFileTransfer.class, !IS_TRANSIENT, !IS_VOLATILE,
				IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED,
				IS_ORDERED);
		initEAttribute(getPendingFileTransfer_Upload(),
				ecorePackage.getEBoolean(), "upload", null, 0, 1,
				PendingFileTransfer.class, !IS_TRANSIENT, !IS_VOLATILE,
				IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED,
				IS_ORDERED);
		initEAttribute(getPendingFileTransfer_FileName(),
				ecorePackage.getEString(), "fileName", null, 0, 1,
				PendingFileTransfer.class, !IS_TRANSIENT, !IS_VOLATILE,
				IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED,
				IS_ORDERED);
		initEAttribute(getPendingFileTransfer_PreliminaryFileName(),
				ecorePackage.getEString(), "preliminaryFileName", null, 0, 1,
				PendingFileTransfer.class, !IS_TRANSIENT, !IS_VOLATILE,
				IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED,
				IS_ORDERED);

		initEClass(projectDataEClass, ProjectData.class, "ProjectData",
				!IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getProjectData_Project(),
				theModelPackage_2.getProject(), null, "project", null, 0, 1,
				ProjectData.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE,
				IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE,
				!IS_DERIVED, IS_ORDERED);
		initEReference(getProjectData_LocalOperations(),
				this.getOperationComposite(), null, "localOperations", null, 0,
				1, ProjectData.class, !IS_TRANSIENT, !IS_VOLATILE,
				IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES,
				!IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Create resource
		createResource(eNS_URI);
	}

} //ModelPackageImpl
