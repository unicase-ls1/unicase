/*******************************************************************************
 * Copyright (c) 2008-2011 Chair for Applied Software Engineering, Technische Universitaet Muenchen.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 ******************************************************************************/
package org.eclipse.emf.emfstore.server.model.url.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.impl.EPackageImpl;
import org.eclipse.emf.emfstore.common.model.ModelPackage;
import org.eclipse.emf.emfstore.server.model.accesscontrol.AccesscontrolPackage;
import org.eclipse.emf.emfstore.server.model.accesscontrol.impl.AccesscontrolPackageImpl;
import org.eclipse.emf.emfstore.server.model.accesscontrol.roles.RolesPackage;
import org.eclipse.emf.emfstore.server.model.accesscontrol.roles.impl.RolesPackageImpl;
import org.eclipse.emf.emfstore.server.model.impl.ModelPackageImpl;
import org.eclipse.emf.emfstore.server.model.notification.NotificationPackage;
import org.eclipse.emf.emfstore.server.model.notification.impl.NotificationPackageImpl;
import org.eclipse.emf.emfstore.server.model.url.ModelElementUrl;
import org.eclipse.emf.emfstore.server.model.url.ModelElementUrlFragment;
import org.eclipse.emf.emfstore.server.model.url.ProjectUrlFragment;
import org.eclipse.emf.emfstore.server.model.url.ServerUrl;
import org.eclipse.emf.emfstore.server.model.url.UrlFactory;
import org.eclipse.emf.emfstore.server.model.url.UrlPackage;
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
public class UrlPackageImpl extends EPackageImpl implements UrlPackage {
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass serverUrlEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass projectUrlFragmentEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass modelElementUrlFragmentEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass modelElementUrlEClass = null;

	/**
	 * Creates an instance of the model <b>Package</b>, registered with {@link org.eclipse.emf.ecore.EPackage.Registry
	 * EPackage.Registry} by the package package URI value.
	 * <p>
	 * Note: the correct way to create the package is via the static factory method {@link #init init()}, which also
	 * performs initialization of the package, or returns the registered package, if one already exists. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.emf.ecore.EPackage.Registry
	 * @see org.eclipse.emf.emfstore.server.model.url.UrlPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private UrlPackageImpl() {
		super(eNS_URI, UrlFactory.eINSTANCE);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private static boolean isInited = false;

	/**
	 * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
	 * 
	 * <p>This method is used to initialize {@link UrlPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static UrlPackage init() {
		if (isInited) return (UrlPackage)EPackage.Registry.INSTANCE.getEPackage(UrlPackage.eNS_URI);

		// Obtain or create and register package
		UrlPackageImpl theUrlPackage = (UrlPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof UrlPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new UrlPackageImpl());

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
		RolesPackageImpl theRolesPackage = (RolesPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(RolesPackage.eNS_URI) instanceof RolesPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(RolesPackage.eNS_URI) : RolesPackage.eINSTANCE);
		NotificationPackageImpl theNotificationPackage = (NotificationPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(NotificationPackage.eNS_URI) instanceof NotificationPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(NotificationPackage.eNS_URI) : NotificationPackage.eINSTANCE);

		// Create package meta-data objects
		theUrlPackage.createPackageContents();
		theModelPackage_1.createPackageContents();
		theVersioningPackage.createPackageContents();
		theOperationsPackage.createPackageContents();
		theSemanticPackage.createPackageContents();
		theEventsPackage.createPackageContents();
		theServerPackage.createPackageContents();
		theAccesscontrolPackage.createPackageContents();
		theRolesPackage.createPackageContents();
		theNotificationPackage.createPackageContents();

		// Initialize created meta-data
		theUrlPackage.initializePackageContents();
		theModelPackage_1.initializePackageContents();
		theVersioningPackage.initializePackageContents();
		theOperationsPackage.initializePackageContents();
		theSemanticPackage.initializePackageContents();
		theEventsPackage.initializePackageContents();
		theServerPackage.initializePackageContents();
		theAccesscontrolPackage.initializePackageContents();
		theRolesPackage.initializePackageContents();
		theNotificationPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theUrlPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(UrlPackage.eNS_URI, theUrlPackage);
		return theUrlPackage;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getServerUrl() {
		return serverUrlEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getServerUrl_HostName() {
		return (EAttribute)serverUrlEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getServerUrl_Port() {
		return (EAttribute)serverUrlEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getProjectUrlFragment() {
		return projectUrlFragmentEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getProjectUrlFragment_Name() {
		return (EAttribute)projectUrlFragmentEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getProjectUrlFragment_ProjectId() {
		return (EReference)projectUrlFragmentEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getModelElementUrlFragment() {
		return modelElementUrlFragmentEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getModelElementUrlFragment_Name() {
		return (EAttribute)modelElementUrlFragmentEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getModelElementUrlFragment_ModelElementId() {
		return (EReference)modelElementUrlFragmentEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getModelElementUrl() {
		return modelElementUrlEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getModelElementUrl_ServerUrl() {
		return (EReference)modelElementUrlEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getModelElementUrl_ProjectUrlFragment() {
		return (EReference)modelElementUrlEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getModelElementUrl_ModelElementUrlFragment() {
		return (EReference)modelElementUrlEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public UrlFactory getUrlFactory() {
		return (UrlFactory)getEFactoryInstance();
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
		serverUrlEClass = createEClass(SERVER_URL);
		createEAttribute(serverUrlEClass, SERVER_URL__HOST_NAME);
		createEAttribute(serverUrlEClass, SERVER_URL__PORT);

		projectUrlFragmentEClass = createEClass(PROJECT_URL_FRAGMENT);
		createEAttribute(projectUrlFragmentEClass, PROJECT_URL_FRAGMENT__NAME);
		createEReference(projectUrlFragmentEClass, PROJECT_URL_FRAGMENT__PROJECT_ID);

		modelElementUrlFragmentEClass = createEClass(MODEL_ELEMENT_URL_FRAGMENT);
		createEAttribute(modelElementUrlFragmentEClass, MODEL_ELEMENT_URL_FRAGMENT__NAME);
		createEReference(modelElementUrlFragmentEClass, MODEL_ELEMENT_URL_FRAGMENT__MODEL_ELEMENT_ID);

		modelElementUrlEClass = createEClass(MODEL_ELEMENT_URL);
		createEReference(modelElementUrlEClass, MODEL_ELEMENT_URL__SERVER_URL);
		createEReference(modelElementUrlEClass, MODEL_ELEMENT_URL__PROJECT_URL_FRAGMENT);
		createEReference(modelElementUrlEClass, MODEL_ELEMENT_URL__MODEL_ELEMENT_URL_FRAGMENT);
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

		// Initialize classes and features; add operations and parameters
		initEClass(serverUrlEClass, ServerUrl.class, "ServerUrl", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getServerUrl_HostName(), ecorePackage.getEString(), "hostName", null, 0, 1, ServerUrl.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getServerUrl_Port(), ecorePackage.getEInt(), "port", null, 0, 1, ServerUrl.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(projectUrlFragmentEClass, ProjectUrlFragment.class, "ProjectUrlFragment", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getProjectUrlFragment_Name(), ecorePackage.getEString(), "name", null, 0, 1, ProjectUrlFragment.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getProjectUrlFragment_ProjectId(), theModelPackage_1.getProjectId(), null, "projectId", null, 0, 1, ProjectUrlFragment.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		getProjectUrlFragment_ProjectId().getEKeys().add(theModelPackage.getUniqueIdentifier_Id());

		initEClass(modelElementUrlFragmentEClass, ModelElementUrlFragment.class, "ModelElementUrlFragment", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getModelElementUrlFragment_Name(), ecorePackage.getEString(), "name", null, 0, 1, ModelElementUrlFragment.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getModelElementUrlFragment_ModelElementId(), theModelPackage.getModelElementId(), null, "modelElementId", null, 0, 1, ModelElementUrlFragment.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(modelElementUrlEClass, ModelElementUrl.class, "ModelElementUrl", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getModelElementUrl_ServerUrl(), this.getServerUrl(), null, "serverUrl", null, 0, 1, ModelElementUrl.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getModelElementUrl_ProjectUrlFragment(), this.getProjectUrlFragment(), null, "projectUrlFragment", null, 0, 1, ModelElementUrl.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getModelElementUrl_ModelElementUrlFragment(), this.getModelElementUrlFragment(), null, "modelElementUrlFragment", null, 0, 1, ModelElementUrl.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
	}

} // UrlPackageImpl
