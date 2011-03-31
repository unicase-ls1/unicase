/*******************************************************************************
 * Copyright (c) 2008-2011 Chair for Applied Software Engineering, Technische Universitaet Muenchen.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 ******************************************************************************/
package org.eclipse.emf.emfstore.server.model.accesscontrol.roles.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.impl.EPackageImpl;
import org.eclipse.emf.emfstore.common.model.ModelPackage;
import org.eclipse.emf.emfstore.server.model.accesscontrol.AccesscontrolPackage;
import org.eclipse.emf.emfstore.server.model.accesscontrol.impl.AccesscontrolPackageImpl;
import org.eclipse.emf.emfstore.server.model.accesscontrol.roles.ProjectAdminRole;
import org.eclipse.emf.emfstore.server.model.accesscontrol.roles.ReaderRole;
import org.eclipse.emf.emfstore.server.model.accesscontrol.roles.Role;
import org.eclipse.emf.emfstore.server.model.accesscontrol.roles.RolesFactory;
import org.eclipse.emf.emfstore.server.model.accesscontrol.roles.RolesPackage;
import org.eclipse.emf.emfstore.server.model.accesscontrol.roles.ServerAdmin;
import org.eclipse.emf.emfstore.server.model.accesscontrol.roles.WriterRole;
import org.eclipse.emf.emfstore.server.model.impl.ModelPackageImpl;
import org.eclipse.emf.emfstore.server.model.notification.NotificationPackage;
import org.eclipse.emf.emfstore.server.model.notification.impl.NotificationPackageImpl;
import org.eclipse.emf.emfstore.server.model.url.UrlPackage;
import org.eclipse.emf.emfstore.server.model.url.impl.UrlPackageImpl;
import org.eclipse.emf.emfstore.server.model.versioning.VersioningPackage;
import org.eclipse.emf.emfstore.server.model.versioning.events.EventsPackage;
import org.eclipse.emf.emfstore.server.model.versioning.events.impl.EventsPackageImpl;
import org.eclipse.emf.emfstore.server.model.versioning.events.server.ServerPackage;
import org.eclipse.emf.emfstore.server.model.versioning.events.server.impl.ServerPackageImpl;
import org.eclipse.emf.emfstore.server.model.versioning.impl.VersioningPackageImpl;
import org.eclipse.emf.emfstore.server.model.versioning.operations.OperationsPackage;
import org.eclipse.emf.emfstore.server.model.versioning.operations.impl.OperationsPackageImpl;
import org.eclipse.emf.emfstore.server.model.versioning.operations.semantic.SemanticPackage;
import org.eclipse.emf.emfstore.server.model.versioning.operations.semantic.impl.SemanticPackageImpl;

/**
 * <!-- begin-user-doc --> An implementation of the model <b>Package</b>. <!-- end-user-doc -->
 * @generated
 */
public class RolesPackageImpl extends EPackageImpl implements RolesPackage {
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass roleEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass readerRoleEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass writerRoleEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass projectAdminRoleEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass serverAdminEClass = null;

	/**
	 * Creates an instance of the model <b>Package</b>, registered with {@link org.eclipse.emf.ecore.EPackage.Registry
	 * EPackage.Registry} by the package package URI value.
	 * <p>
	 * Note: the correct way to create the package is via the static factory method {@link #init init()}, which also
	 * performs initialization of the package, or returns the registered package, if one already exists. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.emf.ecore.EPackage.Registry
	 * @see org.eclipse.emf.emfstore.server.model.accesscontrol.roles.RolesPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private RolesPackageImpl() {
		super(eNS_URI, RolesFactory.eINSTANCE);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private static boolean isInited = false;

	/**
	 * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
	 * 
	 * <p>This method is used to initialize {@link RolesPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static RolesPackage init() {
		if (isInited) return (RolesPackage)EPackage.Registry.INSTANCE.getEPackage(RolesPackage.eNS_URI);

		// Obtain or create and register package
		RolesPackageImpl theRolesPackage = (RolesPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof RolesPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new RolesPackageImpl());

		isInited = true;

		// Initialize simple dependencies
		ModelPackage.eINSTANCE.eClass();

		// Obtain or create and register interdependencies
		ModelPackageImpl theModelPackage_1 = (ModelPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(org.eclipse.emf.emfstore.server.model.ModelPackage.eNS_URI) instanceof ModelPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(org.eclipse.emf.emfstore.server.model.ModelPackage.eNS_URI) : org.eclipse.emf.emfstore.server.model.ModelPackage.eINSTANCE);
		VersioningPackageImpl theVersioningPackage = (VersioningPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(VersioningPackage.eNS_URI) instanceof VersioningPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(VersioningPackage.eNS_URI) : VersioningPackage.eINSTANCE);
		OperationsPackageImpl theOperationsPackage = (OperationsPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(OperationsPackage.eNS_URI) instanceof OperationsPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(OperationsPackage.eNS_URI) : OperationsPackage.eINSTANCE);
		SemanticPackageImpl theSemanticPackage = (SemanticPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(SemanticPackage.eNS_URI) instanceof SemanticPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(SemanticPackage.eNS_URI) : SemanticPackage.eINSTANCE);
		EventsPackageImpl theEventsPackage = (EventsPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(EventsPackage.eNS_URI) instanceof EventsPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(EventsPackage.eNS_URI) : EventsPackage.eINSTANCE);
		ServerPackageImpl theServerPackage = (ServerPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(ServerPackage.eNS_URI) instanceof ServerPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(ServerPackage.eNS_URI) : ServerPackage.eINSTANCE);
		AccesscontrolPackageImpl theAccesscontrolPackage = (AccesscontrolPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(AccesscontrolPackage.eNS_URI) instanceof AccesscontrolPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(AccesscontrolPackage.eNS_URI) : AccesscontrolPackage.eINSTANCE);
		NotificationPackageImpl theNotificationPackage = (NotificationPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(NotificationPackage.eNS_URI) instanceof NotificationPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(NotificationPackage.eNS_URI) : NotificationPackage.eINSTANCE);
		UrlPackageImpl theUrlPackage = (UrlPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(UrlPackage.eNS_URI) instanceof UrlPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(UrlPackage.eNS_URI) : UrlPackage.eINSTANCE);

		// Create package meta-data objects
		theRolesPackage.createPackageContents();
		theModelPackage_1.createPackageContents();
		theVersioningPackage.createPackageContents();
		theOperationsPackage.createPackageContents();
		theSemanticPackage.createPackageContents();
		theEventsPackage.createPackageContents();
		theServerPackage.createPackageContents();
		theAccesscontrolPackage.createPackageContents();
		theNotificationPackage.createPackageContents();
		theUrlPackage.createPackageContents();

		// Initialize created meta-data
		theRolesPackage.initializePackageContents();
		theModelPackage_1.initializePackageContents();
		theVersioningPackage.initializePackageContents();
		theOperationsPackage.initializePackageContents();
		theSemanticPackage.initializePackageContents();
		theEventsPackage.initializePackageContents();
		theServerPackage.initializePackageContents();
		theAccesscontrolPackage.initializePackageContents();
		theNotificationPackage.initializePackageContents();
		theUrlPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theRolesPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(RolesPackage.eNS_URI, theRolesPackage);
		return theRolesPackage;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getRole() {
		return roleEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRole_Projects() {
		return (EReference)roleEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getReaderRole() {
		return readerRoleEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getWriterRole() {
		return writerRoleEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getProjectAdminRole() {
		return projectAdminRoleEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getServerAdmin() {
		return serverAdminEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public RolesFactory getRolesFactory() {
		return (RolesFactory)getEFactoryInstance();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isCreated = false;

	/**
	 * Creates the meta-model objects for the package.  This method is
	 * guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void createPackageContents() {
		if (isCreated) return;
		isCreated = true;

		// Create classes and their features
		roleEClass = createEClass(ROLE);
		createEReference(roleEClass, ROLE__PROJECTS);

		readerRoleEClass = createEClass(READER_ROLE);

		writerRoleEClass = createEClass(WRITER_ROLE);

		projectAdminRoleEClass = createEClass(PROJECT_ADMIN_ROLE);

		serverAdminEClass = createEClass(SERVER_ADMIN);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isInitialized = false;

	/**
	 * Complete the initialization of the package and its meta-model.  This
	 * method is guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
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
		org.eclipse.emf.emfstore.server.model.ModelPackage theModelPackage_1 = (org.eclipse.emf.emfstore.server.model.ModelPackage)EPackage.Registry.INSTANCE.getEPackage(org.eclipse.emf.emfstore.server.model.ModelPackage.eNS_URI);
		ModelPackage theModelPackage = (ModelPackage)EPackage.Registry.INSTANCE.getEPackage(ModelPackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		readerRoleEClass.getESuperTypes().add(this.getRole());
		writerRoleEClass.getESuperTypes().add(this.getRole());
		projectAdminRoleEClass.getESuperTypes().add(this.getRole());
		serverAdminEClass.getESuperTypes().add(this.getRole());

		// Initialize classes and features; add operations and parameters
		initEClass(roleEClass, Role.class, "Role", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getRole_Projects(), theModelPackage_1.getProjectId(), null, "projects", null, 0, -1, Role.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		getRole_Projects().getEKeys().add(theModelPackage.getUniqueIdentifier_Id());

		EOperation op = addEOperation(roleEClass, ecorePackage.getEBoolean(), "canAdministrate", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theModelPackage_1.getProjectId(), "projectId", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(roleEClass, ecorePackage.getEBoolean(), "canCreate", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theModelPackage_1.getProjectId(), "projectId", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEObject(), "modelElement", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(roleEClass, ecorePackage.getEBoolean(), "canDelete", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theModelPackage_1.getProjectId(), "projectId", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEObject(), "modelElement", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(roleEClass, ecorePackage.getEBoolean(), "canModify", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theModelPackage_1.getProjectId(), "projectId", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEObject(), "modelElement", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(roleEClass, ecorePackage.getEBoolean(), "canRead", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theModelPackage_1.getProjectId(), "projectId", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEObject(), "modelElement", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(readerRoleEClass, ReaderRole.class, "ReaderRole", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(writerRoleEClass, WriterRole.class, "WriterRole", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(projectAdminRoleEClass, ProjectAdminRole.class, "ProjectAdminRole", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(serverAdminEClass, ServerAdmin.class, "ServerAdmin", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
	}

} // RolesPackageImpl
