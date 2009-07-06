/**
 * <copyright>Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this distribution, and is available at http://www.eclipse.org/legal/epl-v10.html</copyright>
 *
 * $Id$
 */
package org.unicase.emfstore.esmodel.versioning.events.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.impl.EPackageImpl;
import org.unicase.emfstore.esmodel.EsmodelPackage;
import org.unicase.emfstore.esmodel.accesscontrol.AccesscontrolPackage;
import org.unicase.emfstore.esmodel.accesscontrol.impl.AccesscontrolPackageImpl;
import org.unicase.emfstore.esmodel.accesscontrol.roles.RolesPackage;
import org.unicase.emfstore.esmodel.accesscontrol.roles.impl.RolesPackageImpl;
import org.unicase.emfstore.esmodel.impl.EsmodelPackageImpl;
import org.unicase.emfstore.esmodel.versioning.VersioningPackage;
import org.unicase.emfstore.esmodel.versioning.events.CheckoutEvent;
import org.unicase.emfstore.esmodel.versioning.events.Event;
import org.unicase.emfstore.esmodel.versioning.events.EventsFactory;
import org.unicase.emfstore.esmodel.versioning.events.EventsPackage;
import org.unicase.emfstore.esmodel.versioning.events.ExceptionEvent;
import org.unicase.emfstore.esmodel.versioning.events.MergeEvent;
import org.unicase.emfstore.esmodel.versioning.events.PluginStartEvent;
import org.unicase.emfstore.esmodel.versioning.events.ReadEvent;
import org.unicase.emfstore.esmodel.versioning.impl.VersioningPackageImpl;
import org.unicase.emfstore.esmodel.versioning.operations.OperationsPackage;
import org.unicase.emfstore.esmodel.versioning.operations.impl.OperationsPackageImpl;
import org.unicase.model.ModelPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class EventsPackageImpl extends EPackageImpl implements EventsPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass eventEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass readEventEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass mergeEventEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass checkoutEventEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass exceptionEventEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass pluginStartEventEClass = null;

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
	 * @see org.unicase.emfstore.esmodel.versioning.events.EventsPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private EventsPackageImpl() {
		super(eNS_URI, EventsFactory.eINSTANCE);
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
	public static EventsPackage init() {
		if (isInited)
			return (EventsPackage) EPackage.Registry.INSTANCE
					.getEPackage(EventsPackage.eNS_URI);

		// Obtain or create and register package
		EventsPackageImpl theEventsPackage = (EventsPackageImpl) (EPackage.Registry.INSTANCE
				.getEPackage(eNS_URI) instanceof EventsPackageImpl ? EPackage.Registry.INSTANCE
				.getEPackage(eNS_URI)
				: new EventsPackageImpl());

		isInited = true;

		// Initialize simple dependencies
		ModelPackage.eINSTANCE.eClass();

		// Obtain or create and register interdependencies
		EsmodelPackageImpl theEsmodelPackage = (EsmodelPackageImpl) (EPackage.Registry.INSTANCE
				.getEPackage(EsmodelPackage.eNS_URI) instanceof EsmodelPackageImpl ? EPackage.Registry.INSTANCE
				.getEPackage(EsmodelPackage.eNS_URI)
				: EsmodelPackage.eINSTANCE);
		VersioningPackageImpl theVersioningPackage = (VersioningPackageImpl) (EPackage.Registry.INSTANCE
				.getEPackage(VersioningPackage.eNS_URI) instanceof VersioningPackageImpl ? EPackage.Registry.INSTANCE
				.getEPackage(VersioningPackage.eNS_URI)
				: VersioningPackage.eINSTANCE);
		OperationsPackageImpl theOperationsPackage = (OperationsPackageImpl) (EPackage.Registry.INSTANCE
				.getEPackage(OperationsPackage.eNS_URI) instanceof OperationsPackageImpl ? EPackage.Registry.INSTANCE
				.getEPackage(OperationsPackage.eNS_URI)
				: OperationsPackage.eINSTANCE);
		AccesscontrolPackageImpl theAccesscontrolPackage = (AccesscontrolPackageImpl) (EPackage.Registry.INSTANCE
				.getEPackage(AccesscontrolPackage.eNS_URI) instanceof AccesscontrolPackageImpl ? EPackage.Registry.INSTANCE
				.getEPackage(AccesscontrolPackage.eNS_URI)
				: AccesscontrolPackage.eINSTANCE);
		RolesPackageImpl theRolesPackage = (RolesPackageImpl) (EPackage.Registry.INSTANCE
				.getEPackage(RolesPackage.eNS_URI) instanceof RolesPackageImpl ? EPackage.Registry.INSTANCE
				.getEPackage(RolesPackage.eNS_URI)
				: RolesPackage.eINSTANCE);

		// Create package meta-data objects
		theEventsPackage.createPackageContents();
		theEsmodelPackage.createPackageContents();
		theVersioningPackage.createPackageContents();
		theOperationsPackage.createPackageContents();
		theAccesscontrolPackage.createPackageContents();
		theRolesPackage.createPackageContents();

		// Initialize created meta-data
		theEventsPackage.initializePackageContents();
		theEsmodelPackage.initializePackageContents();
		theVersioningPackage.initializePackageContents();
		theOperationsPackage.initializePackageContents();
		theAccesscontrolPackage.initializePackageContents();
		theRolesPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theEventsPackage.freeze();

		return theEventsPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getEvent() {
		return eventEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEvent_Timestamp() {
		return (EAttribute) eventEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getReadEvent() {
		return readEventEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getReadEvent_ModelElement() {
		return (EReference) readEventEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMergeEvent() {
		return mergeEventEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMergeEvent_NumberOfConflicts() {
		return (EAttribute) mergeEventEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMergeEvent_TotalTime() {
		return (EAttribute) mergeEventEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMergeEvent_BaseVersion() {
		return (EReference) mergeEventEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMergeEvent_TargetVersion() {
		return (EReference) mergeEventEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMergeEvent_LocalChanges() {
		return (EReference) mergeEventEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCheckoutEvent() {
		return checkoutEventEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCheckoutEvent_BaseVersion() {
		return (EReference) checkoutEventEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getExceptionEvent() {
		return exceptionEventEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getExceptionEvent_ExceptionTitle() {
		return (EAttribute) exceptionEventEClass.getEStructuralFeatures()
				.get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getExceptionEvent_ExceptionStackTrace() {
		return (EAttribute) exceptionEventEClass.getEStructuralFeatures()
				.get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getExceptionEvent_ExceptionCauseTitle() {
		return (EAttribute) exceptionEventEClass.getEStructuralFeatures()
				.get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getExceptionEvent_ExceptionCauseStackTrace() {
		return (EAttribute) exceptionEventEClass.getEStructuralFeatures()
				.get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPluginStartEvent() {
		return pluginStartEventEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPluginStartEvent_PluginId() {
		return (EAttribute) pluginStartEventEClass.getEStructuralFeatures()
				.get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EventsFactory getEventsFactory() {
		return (EventsFactory) getEFactoryInstance();
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
		eventEClass = createEClass(EVENT);
		createEAttribute(eventEClass, EVENT__TIMESTAMP);

		readEventEClass = createEClass(READ_EVENT);
		createEReference(readEventEClass, READ_EVENT__MODEL_ELEMENT);

		mergeEventEClass = createEClass(MERGE_EVENT);
		createEAttribute(mergeEventEClass, MERGE_EVENT__NUMBER_OF_CONFLICTS);
		createEAttribute(mergeEventEClass, MERGE_EVENT__TOTAL_TIME);
		createEReference(mergeEventEClass, MERGE_EVENT__BASE_VERSION);
		createEReference(mergeEventEClass, MERGE_EVENT__TARGET_VERSION);
		createEReference(mergeEventEClass, MERGE_EVENT__LOCAL_CHANGES);

		checkoutEventEClass = createEClass(CHECKOUT_EVENT);
		createEReference(checkoutEventEClass, CHECKOUT_EVENT__BASE_VERSION);

		exceptionEventEClass = createEClass(EXCEPTION_EVENT);
		createEAttribute(exceptionEventEClass, EXCEPTION_EVENT__EXCEPTION_TITLE);
		createEAttribute(exceptionEventEClass,
				EXCEPTION_EVENT__EXCEPTION_STACK_TRACE);
		createEAttribute(exceptionEventEClass,
				EXCEPTION_EVENT__EXCEPTION_CAUSE_TITLE);
		createEAttribute(exceptionEventEClass,
				EXCEPTION_EVENT__EXCEPTION_CAUSE_STACK_TRACE);

		pluginStartEventEClass = createEClass(PLUGIN_START_EVENT);
		createEAttribute(pluginStartEventEClass, PLUGIN_START_EVENT__PLUGIN_ID);
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
		ModelPackage theModelPackage = (ModelPackage) EPackage.Registry.INSTANCE
				.getEPackage(ModelPackage.eNS_URI);
		EcorePackage theEcorePackage = (EcorePackage) EPackage.Registry.INSTANCE
				.getEPackage(EcorePackage.eNS_URI);
		VersioningPackage theVersioningPackage = (VersioningPackage) EPackage.Registry.INSTANCE
				.getEPackage(VersioningPackage.eNS_URI);
		OperationsPackage theOperationsPackage = (OperationsPackage) EPackage.Registry.INSTANCE
				.getEPackage(OperationsPackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		readEventEClass.getESuperTypes().add(this.getEvent());
		mergeEventEClass.getESuperTypes().add(this.getEvent());
		checkoutEventEClass.getESuperTypes().add(this.getEvent());
		exceptionEventEClass.getESuperTypes().add(this.getEvent());
		pluginStartEventEClass.getESuperTypes().add(this.getEvent());

		// Initialize classes and features; add operations and parameters
		initEClass(eventEClass, Event.class, "Event", !IS_ABSTRACT,
				!IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getEvent_Timestamp(), ecorePackage.getEDate(),
				"timestamp", null, 0, 1, Event.class, !IS_TRANSIENT,
				!IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE,
				!IS_DERIVED, IS_ORDERED);

		initEClass(readEventEClass, ReadEvent.class, "ReadEvent", !IS_ABSTRACT,
				!IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getReadEvent_ModelElement(), theModelPackage
				.getModelElementId(), null, "modelElement", null, 0, 1,
				ReadEvent.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE,
				IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE,
				!IS_DERIVED, IS_ORDERED);

		initEClass(mergeEventEClass, MergeEvent.class, "MergeEvent",
				!IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getMergeEvent_NumberOfConflicts(), ecorePackage
				.getEInt(), "numberOfConflicts", null, 0, 1, MergeEvent.class,
				!IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE,
				!IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getMergeEvent_TotalTime(), theEcorePackage.getEInt(),
				"totalTime", null, 0, 1, MergeEvent.class, !IS_TRANSIENT,
				!IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE,
				!IS_DERIVED, IS_ORDERED);
		initEReference(getMergeEvent_BaseVersion(), theVersioningPackage
				.getPrimaryVersionSpec(), null, "baseVersion", null, 0, 1,
				MergeEvent.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE,
				IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE,
				!IS_DERIVED, IS_ORDERED);
		initEReference(getMergeEvent_TargetVersion(), theVersioningPackage
				.getPrimaryVersionSpec(), null, "targetVersion", null, 0, 1,
				MergeEvent.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE,
				IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE,
				!IS_DERIVED, IS_ORDERED);
		initEReference(getMergeEvent_LocalChanges(), theOperationsPackage
				.getAbstractOperation(), null, "localChanges", null, 0, -1,
				MergeEvent.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE,
				IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE,
				!IS_DERIVED, IS_ORDERED);

		initEClass(checkoutEventEClass, CheckoutEvent.class, "CheckoutEvent",
				!IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getCheckoutEvent_BaseVersion(), theVersioningPackage
				.getPrimaryVersionSpec(), null, "baseVersion", null, 0, 1,
				CheckoutEvent.class, !IS_TRANSIENT, !IS_VOLATILE,
				IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES,
				!IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(exceptionEventEClass, ExceptionEvent.class,
				"ExceptionEvent", !IS_ABSTRACT, !IS_INTERFACE,
				IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getExceptionEvent_ExceptionTitle(), ecorePackage
				.getEString(), "ExceptionTitle", null, 0, 1,
				ExceptionEvent.class, !IS_TRANSIENT, !IS_VOLATILE,
				IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED,
				IS_ORDERED);
		initEAttribute(getExceptionEvent_ExceptionStackTrace(), ecorePackage
				.getEString(), "ExceptionStackTrace", null, 0, 1,
				ExceptionEvent.class, !IS_TRANSIENT, !IS_VOLATILE,
				IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED,
				IS_ORDERED);
		initEAttribute(getExceptionEvent_ExceptionCauseTitle(), ecorePackage
				.getEString(), "ExceptionCauseTitle", null, 0, 1,
				ExceptionEvent.class, !IS_TRANSIENT, !IS_VOLATILE,
				IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED,
				IS_ORDERED);
		initEAttribute(getExceptionEvent_ExceptionCauseStackTrace(),
				ecorePackage.getEString(), "ExceptionCauseStackTrace", null, 0,
				1, ExceptionEvent.class, !IS_TRANSIENT, !IS_VOLATILE,
				IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED,
				IS_ORDERED);

		initEClass(pluginStartEventEClass, PluginStartEvent.class,
				"PluginStartEvent", !IS_ABSTRACT, !IS_INTERFACE,
				IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getPluginStartEvent_PluginId(), ecorePackage
				.getEString(), "pluginId", null, 0, 1, PluginStartEvent.class,
				!IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE,
				!IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
	}

} //EventsPackageImpl
