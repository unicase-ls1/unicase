/*******************************************************************************
 * Copyright (c) 2008-2011 Chair for Applied Software Engineering,
 * Technische Universitaet Muenchen.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 ******************************************************************************/
package org.eclipse.emf.emfstore.server.model.versioning.impl;

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
import org.eclipse.emf.emfstore.server.model.url.UrlPackage;
import org.eclipse.emf.emfstore.server.model.url.impl.UrlPackageImpl;
import org.eclipse.emf.emfstore.server.model.versioning.ChangePackage;
import org.eclipse.emf.emfstore.server.model.versioning.DateVersionSpec;
import org.eclipse.emf.emfstore.server.model.versioning.HeadVersionSpec;
import org.eclipse.emf.emfstore.server.model.versioning.HistoryInfo;
import org.eclipse.emf.emfstore.server.model.versioning.HistoryQuery;
import org.eclipse.emf.emfstore.server.model.versioning.LogMessage;
import org.eclipse.emf.emfstore.server.model.versioning.PrimaryVersionSpec;
import org.eclipse.emf.emfstore.server.model.versioning.TagVersionSpec;
import org.eclipse.emf.emfstore.server.model.versioning.Version;
import org.eclipse.emf.emfstore.server.model.versioning.VersionProperty;
import org.eclipse.emf.emfstore.server.model.versioning.VersionSpec;
import org.eclipse.emf.emfstore.server.model.versioning.VersioningFactory;
import org.eclipse.emf.emfstore.server.model.versioning.VersioningPackage;
import org.eclipse.emf.emfstore.server.model.versioning.events.EventsPackage;
import org.eclipse.emf.emfstore.server.model.versioning.events.impl.EventsPackageImpl;
import org.eclipse.emf.emfstore.server.model.versioning.events.server.ServerPackage;
import org.eclipse.emf.emfstore.server.model.versioning.events.server.impl.ServerPackageImpl;
import org.eclipse.emf.emfstore.server.model.versioning.operations.OperationsPackage;
import org.eclipse.emf.emfstore.server.model.versioning.operations.impl.OperationsPackageImpl;
import org.eclipse.emf.emfstore.server.model.versioning.operations.semantic.SemanticPackage;
import org.eclipse.emf.emfstore.server.model.versioning.operations.semantic.impl.SemanticPackageImpl;

/**
 * <!-- begin-user-doc --> An implementation of the model <b>Package</b>. <!-- end-user-doc -->
 * @generated
 */
public class VersioningPackageImpl extends EPackageImpl implements VersioningPackage {
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass tagVersionSpecEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass dateVersionSpecEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass primaryVersionSpecEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass versionSpecEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass logMessageEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass changePackageEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass historyInfoEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass historyQueryEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass versionEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass headVersionSpecEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass versionPropertyEClass = null;

	/**
	 * Creates an instance of the model <b>Package</b>, registered with {@link org.eclipse.emf.ecore.EPackage.Registry
	 * EPackage.Registry} by the package package URI value.
	 * <p>
	 * Note: the correct way to create the package is via the static factory method {@link #init init()}, which also
	 * performs initialization of the package, or returns the registered package, if one already exists. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.emf.ecore.EPackage.Registry
	 * @see org.eclipse.emf.emfstore.server.model.versioning.VersioningPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private VersioningPackageImpl() {
		super(eNS_URI, VersioningFactory.eINSTANCE);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private static boolean isInited = false;

	/**
	 * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
	 * 
	 * <p>This method is used to initialize {@link VersioningPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static VersioningPackage init() {
		if (isInited) return (VersioningPackage)EPackage.Registry.INSTANCE.getEPackage(VersioningPackage.eNS_URI);

		// Obtain or create and register package
		VersioningPackageImpl theVersioningPackage = (VersioningPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof VersioningPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new VersioningPackageImpl());

		isInited = true;

		// Initialize simple dependencies
		ModelPackage.eINSTANCE.eClass();

		// Obtain or create and register interdependencies
		ModelPackageImpl theModelPackage_1 = (ModelPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(org.eclipse.emf.emfstore.server.model.ModelPackage.eNS_URI) instanceof ModelPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(org.eclipse.emf.emfstore.server.model.ModelPackage.eNS_URI) : org.eclipse.emf.emfstore.server.model.ModelPackage.eINSTANCE);
		OperationsPackageImpl theOperationsPackage = (OperationsPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(OperationsPackage.eNS_URI) instanceof OperationsPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(OperationsPackage.eNS_URI) : OperationsPackage.eINSTANCE);
		SemanticPackageImpl theSemanticPackage = (SemanticPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(SemanticPackage.eNS_URI) instanceof SemanticPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(SemanticPackage.eNS_URI) : SemanticPackage.eINSTANCE);
		EventsPackageImpl theEventsPackage = (EventsPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(EventsPackage.eNS_URI) instanceof EventsPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(EventsPackage.eNS_URI) : EventsPackage.eINSTANCE);
		ServerPackageImpl theServerPackage = (ServerPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(ServerPackage.eNS_URI) instanceof ServerPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(ServerPackage.eNS_URI) : ServerPackage.eINSTANCE);
		AccesscontrolPackageImpl theAccesscontrolPackage = (AccesscontrolPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(AccesscontrolPackage.eNS_URI) instanceof AccesscontrolPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(AccesscontrolPackage.eNS_URI) : AccesscontrolPackage.eINSTANCE);
		RolesPackageImpl theRolesPackage = (RolesPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(RolesPackage.eNS_URI) instanceof RolesPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(RolesPackage.eNS_URI) : RolesPackage.eINSTANCE);
		NotificationPackageImpl theNotificationPackage = (NotificationPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(NotificationPackage.eNS_URI) instanceof NotificationPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(NotificationPackage.eNS_URI) : NotificationPackage.eINSTANCE);
		UrlPackageImpl theUrlPackage = (UrlPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(UrlPackage.eNS_URI) instanceof UrlPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(UrlPackage.eNS_URI) : UrlPackage.eINSTANCE);

		// Create package meta-data objects
		theVersioningPackage.createPackageContents();
		theModelPackage_1.createPackageContents();
		theOperationsPackage.createPackageContents();
		theSemanticPackage.createPackageContents();
		theEventsPackage.createPackageContents();
		theServerPackage.createPackageContents();
		theAccesscontrolPackage.createPackageContents();
		theRolesPackage.createPackageContents();
		theNotificationPackage.createPackageContents();
		theUrlPackage.createPackageContents();

		// Initialize created meta-data
		theVersioningPackage.initializePackageContents();
		theModelPackage_1.initializePackageContents();
		theOperationsPackage.initializePackageContents();
		theSemanticPackage.initializePackageContents();
		theEventsPackage.initializePackageContents();
		theServerPackage.initializePackageContents();
		theAccesscontrolPackage.initializePackageContents();
		theRolesPackage.initializePackageContents();
		theNotificationPackage.initializePackageContents();
		theUrlPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theVersioningPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(VersioningPackage.eNS_URI, theVersioningPackage);
		return theVersioningPackage;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTagVersionSpec() {
		return tagVersionSpecEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTagVersionSpec_Name() {
		return (EAttribute)tagVersionSpecEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDateVersionSpec() {
		return dateVersionSpecEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDateVersionSpec_Date() {
		return (EAttribute)dateVersionSpecEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPrimaryVersionSpec() {
		return primaryVersionSpecEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPrimaryVersionSpec_Identifier() {
		return (EAttribute)primaryVersionSpecEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getVersionSpec() {
		return versionSpecEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getLogMessage() {
		return logMessageEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getLogMessage_Message() {
		return (EAttribute)logMessageEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getLogMessage_Date() {
		return (EAttribute)logMessageEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getLogMessage_ClientDate() {
		return (EAttribute)logMessageEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getLogMessage_Author() {
		return (EAttribute)logMessageEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getChangePackage() {
		return changePackageEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getChangePackage_Operations() {
		return (EReference)changePackageEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getChangePackage_Events() {
		return (EReference)changePackageEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getChangePackage_LogMessage() {
		return (EReference)changePackageEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getChangePackage_Notifications() {
		return (EReference)changePackageEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getChangePackage_VersionProperties() {
		return (EReference)changePackageEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getHistoryInfo() {
		return historyInfoEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getHistoryInfo_PrimerySpec() {
		return (EReference)historyInfoEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getHistoryInfo_LogMessage() {
		return (EReference)historyInfoEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getHistoryInfo_TagSpecs() {
		return (EReference)historyInfoEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getHistoryInfo_VersionProperties() {
		return (EReference)historyInfoEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getHistoryInfo_ChangePackage() {
		return (EReference)historyInfoEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getHistoryQuery() {
		return historyQueryEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getHistoryQuery_Source() {
		return (EReference)historyQueryEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getHistoryQuery_Target() {
		return (EReference)historyQueryEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getHistoryQuery_ModelElements() {
		return (EReference)historyQueryEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getHistoryQuery_IncludeChangePackage() {
		return (EAttribute)historyQueryEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getVersion() {
		return versionEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getVersion_ProjectState() {
		return (EReference)versionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getVersion_PrimarySpec() {
		return (EReference)versionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getVersion_TagSpecs() {
		return (EReference)versionEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getVersion_NextVersion() {
		return (EReference)versionEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getVersion_PreviousVersion() {
		return (EReference)versionEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getVersion_Changes() {
		return (EReference)versionEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getVersion_LogMessage() {
		return (EReference)versionEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getHeadVersionSpec() {
		return headVersionSpecEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getVersionProperty() {
		return versionPropertyEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getVersionProperty_Name() {
		return (EAttribute)versionPropertyEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getVersionProperty_Value() {
		return (EAttribute)versionPropertyEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public VersioningFactory getVersioningFactory() {
		return (VersioningFactory)getEFactoryInstance();
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
		tagVersionSpecEClass = createEClass(TAG_VERSION_SPEC);
		createEAttribute(tagVersionSpecEClass, TAG_VERSION_SPEC__NAME);

		dateVersionSpecEClass = createEClass(DATE_VERSION_SPEC);
		createEAttribute(dateVersionSpecEClass, DATE_VERSION_SPEC__DATE);

		primaryVersionSpecEClass = createEClass(PRIMARY_VERSION_SPEC);
		createEAttribute(primaryVersionSpecEClass, PRIMARY_VERSION_SPEC__IDENTIFIER);

		versionSpecEClass = createEClass(VERSION_SPEC);

		logMessageEClass = createEClass(LOG_MESSAGE);
		createEAttribute(logMessageEClass, LOG_MESSAGE__AUTHOR);
		createEAttribute(logMessageEClass, LOG_MESSAGE__MESSAGE);
		createEAttribute(logMessageEClass, LOG_MESSAGE__DATE);
		createEAttribute(logMessageEClass, LOG_MESSAGE__CLIENT_DATE);

		changePackageEClass = createEClass(CHANGE_PACKAGE);
		createEReference(changePackageEClass, CHANGE_PACKAGE__OPERATIONS);
		createEReference(changePackageEClass, CHANGE_PACKAGE__EVENTS);
		createEReference(changePackageEClass, CHANGE_PACKAGE__LOG_MESSAGE);
		createEReference(changePackageEClass, CHANGE_PACKAGE__NOTIFICATIONS);
		createEReference(changePackageEClass, CHANGE_PACKAGE__VERSION_PROPERTIES);

		historyInfoEClass = createEClass(HISTORY_INFO);
		createEReference(historyInfoEClass, HISTORY_INFO__PRIMERY_SPEC);
		createEReference(historyInfoEClass, HISTORY_INFO__LOG_MESSAGE);
		createEReference(historyInfoEClass, HISTORY_INFO__TAG_SPECS);
		createEReference(historyInfoEClass, HISTORY_INFO__VERSION_PROPERTIES);
		createEReference(historyInfoEClass, HISTORY_INFO__CHANGE_PACKAGE);

		historyQueryEClass = createEClass(HISTORY_QUERY);
		createEReference(historyQueryEClass, HISTORY_QUERY__SOURCE);
		createEReference(historyQueryEClass, HISTORY_QUERY__TARGET);
		createEReference(historyQueryEClass, HISTORY_QUERY__MODEL_ELEMENTS);
		createEAttribute(historyQueryEClass, HISTORY_QUERY__INCLUDE_CHANGE_PACKAGE);

		versionEClass = createEClass(VERSION);
		createEReference(versionEClass, VERSION__PROJECT_STATE);
		createEReference(versionEClass, VERSION__PRIMARY_SPEC);
		createEReference(versionEClass, VERSION__TAG_SPECS);
		createEReference(versionEClass, VERSION__NEXT_VERSION);
		createEReference(versionEClass, VERSION__PREVIOUS_VERSION);
		createEReference(versionEClass, VERSION__CHANGES);
		createEReference(versionEClass, VERSION__LOG_MESSAGE);

		headVersionSpecEClass = createEClass(HEAD_VERSION_SPEC);

		versionPropertyEClass = createEClass(VERSION_PROPERTY);
		createEAttribute(versionPropertyEClass, VERSION_PROPERTY__NAME);
		createEAttribute(versionPropertyEClass, VERSION_PROPERTY__VALUE);
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
		OperationsPackage theOperationsPackage = (OperationsPackage)EPackage.Registry.INSTANCE.getEPackage(OperationsPackage.eNS_URI);
		EventsPackage theEventsPackage = (EventsPackage)EPackage.Registry.INSTANCE.getEPackage(EventsPackage.eNS_URI);
		NotificationPackage theNotificationPackage = (NotificationPackage)EPackage.Registry.INSTANCE.getEPackage(NotificationPackage.eNS_URI);
		ModelPackage theModelPackage = (ModelPackage)EPackage.Registry.INSTANCE.getEPackage(ModelPackage.eNS_URI);

		// Add subpackages
		getESubpackages().add(theOperationsPackage);
		getESubpackages().add(theEventsPackage);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		tagVersionSpecEClass.getESuperTypes().add(this.getVersionSpec());
		dateVersionSpecEClass.getESuperTypes().add(this.getVersionSpec());
		primaryVersionSpecEClass.getESuperTypes().add(this.getVersionSpec());
		headVersionSpecEClass.getESuperTypes().add(this.getVersionSpec());

		// Initialize classes and features; add operations and parameters
		initEClass(tagVersionSpecEClass, TagVersionSpec.class, "TagVersionSpec", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getTagVersionSpec_Name(), ecorePackage.getEString(), "name", null, 1, 1, TagVersionSpec.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(dateVersionSpecEClass, DateVersionSpec.class, "DateVersionSpec", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getDateVersionSpec_Date(), ecorePackage.getEDate(), "date", null, 1, 1, DateVersionSpec.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(primaryVersionSpecEClass, PrimaryVersionSpec.class, "PrimaryVersionSpec", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getPrimaryVersionSpec_Identifier(), ecorePackage.getEInt(), "identifier", null, 1, 1, PrimaryVersionSpec.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(versionSpecEClass, VersionSpec.class, "VersionSpec", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(logMessageEClass, LogMessage.class, "LogMessage", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getLogMessage_Author(), ecorePackage.getEString(), "author", null, 1, 1, LogMessage.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getLogMessage_Message(), ecorePackage.getEString(), "message", null, 1, 1, LogMessage.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getLogMessage_Date(), ecorePackage.getEDate(), "date", null, 1, 1, LogMessage.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getLogMessage_ClientDate(), ecorePackage.getEDate(), "clientDate", null, 0, 1, LogMessage.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(changePackageEClass, ChangePackage.class, "ChangePackage", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getChangePackage_Operations(), theOperationsPackage.getAbstractOperation(), null, "operations", null, 0, -1, ChangePackage.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getChangePackage_Events(), theEventsPackage.getEvent(), null, "events", null, 0, -1, ChangePackage.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getChangePackage_LogMessage(), this.getLogMessage(), null, "logMessage", null, 0, 1, ChangePackage.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getChangePackage_Notifications(), theNotificationPackage.getESNotification(), null, "notifications", null, 0, -1, ChangePackage.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getChangePackage_VersionProperties(), this.getVersionProperty(), null, "versionProperties", null, 0, -1, ChangePackage.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(historyInfoEClass, HistoryInfo.class, "HistoryInfo", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getHistoryInfo_PrimerySpec(), this.getPrimaryVersionSpec(), null, "primerySpec", null, 1, 1, HistoryInfo.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getHistoryInfo_LogMessage(), this.getLogMessage(), null, "logMessage", null, 1, 1, HistoryInfo.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getHistoryInfo_TagSpecs(), this.getTagVersionSpec(), null, "tagSpecs", null, 0, -1, HistoryInfo.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getHistoryInfo_VersionProperties(), this.getVersionProperty(), null, "versionProperties", null, 0, -1, HistoryInfo.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getHistoryInfo_ChangePackage(), this.getChangePackage(), null, "changePackage", null, 0, 1, HistoryInfo.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(historyQueryEClass, HistoryQuery.class, "HistoryQuery", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getHistoryQuery_Source(), this.getPrimaryVersionSpec(), null, "source", null, 0, 1, HistoryQuery.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getHistoryQuery_Target(), this.getPrimaryVersionSpec(), null, "target", null, 0, 1, HistoryQuery.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getHistoryQuery_ModelElements(), theModelPackage.getModelElementId(), null, "modelElements", null, 0, -1, HistoryQuery.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getHistoryQuery_IncludeChangePackage(), ecorePackage.getEBoolean(), "includeChangePackage", null, 0, 1, HistoryQuery.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(versionEClass, Version.class, "Version", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getVersion_ProjectState(), theModelPackage.getProject(), null, "projectState", null, 0, 1, Version.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getVersion_PrimarySpec(), this.getPrimaryVersionSpec(), null, "primarySpec", null, 1, 1, Version.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getVersion_TagSpecs(), this.getTagVersionSpec(), null, "tagSpecs", null, 0, -1, Version.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getVersion_NextVersion(), this.getVersion(), this.getVersion_PreviousVersion(), "nextVersion", null, 0, 1, Version.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getVersion_PreviousVersion(), this.getVersion(), this.getVersion_NextVersion(), "previousVersion", null, 0, 1, Version.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getVersion_Changes(), this.getChangePackage(), null, "changes", null, 0, 1, Version.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getVersion_LogMessage(), this.getLogMessage(), null, "logMessage", null, 0, 1, Version.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(headVersionSpecEClass, HeadVersionSpec.class, "HeadVersionSpec", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(versionPropertyEClass, VersionProperty.class, "VersionProperty", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getVersionProperty_Name(), ecorePackage.getEString(), "name", null, 0, 1, VersionProperty.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getVersionProperty_Value(), ecorePackage.getEString(), "value", null, 0, 1, VersionProperty.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
	}

} // VersioningPackageImpl
