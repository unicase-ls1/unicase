/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.unicase.workspace.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.change.ChangePackage;
import org.eclipse.emf.ecore.impl.EPackageImpl;
import org.unicase.esmodel.EsmodelPackage;
import org.unicase.esmodel.changemanagment.ChangemanagmentPackage;
import org.unicase.model.ModelPackage;
import org.unicase.workspace.ProjectSpace;
import org.unicase.workspace.ServerInfo;
import org.unicase.workspace.Usersession;
import org.unicase.workspace.Workspace;
import org.unicase.workspace.WorkspaceFactory;
import org.unicase.workspace.WorkspacePackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class WorkspacePackageImpl extends EPackageImpl implements WorkspacePackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass workspaceEClass = null;

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
	private EClass projectSpaceEClass = null;

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
	 * @see org.unicase.workspace.WorkspacePackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private WorkspacePackageImpl() {
		super(eNS_URI, WorkspaceFactory.eINSTANCE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static boolean isInited = false;

	/**
	 * Creates, registers, and initializes the <b>Package</b> for this
	 * model, and for any others upon which it depends.  Simple
	 * dependencies are satisfied by calling this method on all
	 * dependent packages before doing anything else.  This method drives
	 * initialization for interdependent packages directly, in parallel
	 * with this package, itself.
	 * <p>Of this package and its interdependencies, all packages which
	 * have not yet been registered by their URI values are first created
	 * and registered.  The packages are then initialized in two steps:
	 * meta-model objects for all of the packages are created before any
	 * are initialized, since one package's meta-model objects may refer to
	 * those of another.
	 * <p>Invocation of this method will not affect any packages that have
	 * already been initialized.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static WorkspacePackage init() {
		if (isInited) return (WorkspacePackage)EPackage.Registry.INSTANCE.getEPackage(WorkspacePackage.eNS_URI);

		// Obtain or create and register package
		WorkspacePackageImpl theWorkspacePackage = (WorkspacePackageImpl)(EPackage.Registry.INSTANCE.getEPackage(eNS_URI) instanceof WorkspacePackageImpl ? EPackage.Registry.INSTANCE.getEPackage(eNS_URI) : new WorkspacePackageImpl());

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
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getWorkspace() {
		return workspaceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getWorkspace_ProjectSpaces() {
		return (EReference)workspaceEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getWorkspace_ServerInfos() {
		return (EReference)workspaceEClass.getEStructuralFeatures().get(1);
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
		return (EAttribute)serverInfoEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getServerInfo_Url() {
		return (EAttribute)serverInfoEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getServerInfo_Port() {
		return (EAttribute)serverInfoEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getServerInfo_DisplayName() {
		return (EAttribute)serverInfoEClass.getEStructuralFeatures().get(3);
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
		return (EAttribute)usersessionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getUsersession_Password() {
		return (EAttribute)usersessionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getUsersession_SessionId() {
		return (EReference)usersessionEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getUsersession_ServerInfo() {
		return (EReference)usersessionEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getProjectSpace() {
		return projectSpaceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getProjectSpace_Project() {
		return (EReference)projectSpaceEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getProjectSpace_BaseVersion() {
		return (EReference)projectSpaceEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getProjectSpace_LocalChanges() {
		return (EReference)projectSpaceEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getProjectSpace_Usersession() {
		return (EReference)projectSpaceEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public WorkspaceFactory getWorkspaceFactory() {
		return (WorkspaceFactory)getEFactoryInstance();
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
		if (isCreated) return;
		isCreated = true;

		// Create classes and their features
		workspaceEClass = createEClass(WORKSPACE);
		createEReference(workspaceEClass, WORKSPACE__PROJECT_SPACES);
		createEReference(workspaceEClass, WORKSPACE__SERVER_INFOS);

		serverInfoEClass = createEClass(SERVER_INFO);
		createEAttribute(serverInfoEClass, SERVER_INFO__NAME);
		createEAttribute(serverInfoEClass, SERVER_INFO__URL);
		createEAttribute(serverInfoEClass, SERVER_INFO__PORT);
		createEAttribute(serverInfoEClass, SERVER_INFO__DISPLAY_NAME);

		usersessionEClass = createEClass(USERSESSION);
		createEAttribute(usersessionEClass, USERSESSION__USERNAME);
		createEAttribute(usersessionEClass, USERSESSION__PASSWORD);
		createEReference(usersessionEClass, USERSESSION__SESSION_ID);
		createEReference(usersessionEClass, USERSESSION__SERVER_INFO);

		projectSpaceEClass = createEClass(PROJECT_SPACE);
		createEReference(projectSpaceEClass, PROJECT_SPACE__PROJECT);
		createEReference(projectSpaceEClass, PROJECT_SPACE__BASE_VERSION);
		createEReference(projectSpaceEClass, PROJECT_SPACE__LOCAL_CHANGES);
		createEReference(projectSpaceEClass, PROJECT_SPACE__USERSESSION);
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
		if (isInitialized) return;
		isInitialized = true;

		// Initialize package
		setName(eNAME);
		setNsPrefix(eNS_PREFIX);
		setNsURI(eNS_URI);

		// Obtain other dependent packages
		ModelPackage theModelPackage = (ModelPackage)EPackage.Registry.INSTANCE.getEPackage(ModelPackage.eNS_URI);
		ChangemanagmentPackage theChangemanagmentPackage = (ChangemanagmentPackage)EPackage.Registry.INSTANCE.getEPackage(ChangemanagmentPackage.eNS_URI);
		EsmodelPackage theEsmodelPackage = (EsmodelPackage)EPackage.Registry.INSTANCE.getEPackage(EsmodelPackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes

		// Initialize classes and features; add operations and parameters
		initEClass(workspaceEClass, Workspace.class, "Workspace", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getWorkspace_ProjectSpaces(), this.getProjectSpace(), null, "projectSpaces", null, 0, -1, Workspace.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getWorkspace_ServerInfos(), this.getServerInfo(), null, "serverInfos", null, 0, -1, Workspace.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		EOperation op = addEOperation(workspaceEClass, this.getProjectSpace(), "checkout", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getUsersession(), "usersession", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theModelPackage.getProjectId(), "projectId", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theChangemanagmentPackage.getVersionSpec(), "version", 0, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(workspaceEClass, null, "save", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(serverInfoEClass, ServerInfo.class, "ServerInfo", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getServerInfo_Name(), ecorePackage.getEString(), "name", null, 1, 1, ServerInfo.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getServerInfo_Url(), ecorePackage.getEString(), "url", null, 1, 1, ServerInfo.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getServerInfo_Port(), ecorePackage.getEString(), "port", null, 1, 1, ServerInfo.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getServerInfo_DisplayName(), ecorePackage.getEString(), "displayName", null, 0, 1, ServerInfo.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(usersessionEClass, Usersession.class, "Usersession", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getUsersession_Username(), ecorePackage.getEString(), "username", null, 0, 1, Usersession.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getUsersession_Password(), ecorePackage.getEString(), "password", null, 0, 1, Usersession.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getUsersession_SessionId(), theEsmodelPackage.getSessionId(), null, "sessionId", null, 0, 1, Usersession.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getUsersession_ServerInfo(), this.getServerInfo(), null, "serverInfo", null, 0, 1, Usersession.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		addEOperation(usersessionEClass, ecorePackage.getEBoolean(), "isLoggedIn", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(usersessionEClass, null, "logIn", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEString(), "password", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(usersessionEClass, this.getProjectSpace(), "checkout", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theModelPackage.getProjectId(), "projectId", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theChangemanagmentPackage.getVersionSpec(), "versionSpec", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(projectSpaceEClass, ProjectSpace.class, "ProjectSpace", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getProjectSpace_Project(), theModelPackage.getProject(), null, "project", null, 1, 1, ProjectSpace.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getProjectSpace_BaseVersion(), theChangemanagmentPackage.getPrimaryVersionSpec(), null, "baseVersion", null, 1, 1, ProjectSpace.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getProjectSpace_LocalChanges(), theChangemanagmentPackage.getChangePackage(), null, "localChanges", null, 0, 1, ProjectSpace.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getProjectSpace_Usersession(), this.getUsersession(), null, "usersession", null, 0, 1, ProjectSpace.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		addEOperation(projectSpaceEClass, theChangemanagmentPackage.getPrimaryVersionSpec(), "commit", 0, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(projectSpaceEClass, null, "update", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(projectSpaceEClass, null, "update", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theChangemanagmentPackage.getVersionSpec(), "version", 0, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(projectSpaceEClass, null, "revert", 0, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(projectSpaceEClass, null, "save", 0, 1, IS_UNIQUE, IS_ORDERED);

		// Create resource
		createResource(eNS_URI);
	}

} //WorkspacePackageImpl
