/**
 * Copyright (c) 2008 Jonas Helming, Maximilian Kögel
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * $Id$
 */
package org.unicase.emfstore.esmodel.changemanagment.changepackage.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EGenericType;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.change.ChangePackage;
import org.eclipse.emf.ecore.impl.EPackageImpl;
import org.unicase.emfstore.esmodel.EsmodelPackage;
import org.unicase.emfstore.esmodel.accesscontrol.AccesscontrolPackage;
import org.unicase.emfstore.esmodel.accesscontrol.impl.AccesscontrolPackageImpl;
import org.unicase.emfstore.esmodel.accesscontrol.roles.RolesPackage;
import org.unicase.emfstore.esmodel.accesscontrol.roles.impl.RolesPackageImpl;
import org.unicase.emfstore.esmodel.changemanagment.ChangemanagmentPackage;
import org.unicase.emfstore.esmodel.changemanagment.changepackage.ChangepackageFactory;
import org.unicase.emfstore.esmodel.changemanagment.changepackage.ChangepackagePackage;
import org.unicase.emfstore.esmodel.changemanagment.changepackage.ESAbstractOperation;
import org.unicase.emfstore.esmodel.changemanagment.changepackage.ESChangePackage;
import org.unicase.emfstore.esmodel.changemanagment.changepackage.ESEvent;
import org.unicase.emfstore.esmodel.changemanagment.changepackage.ESListEvent;
import org.unicase.emfstore.esmodel.changemanagment.changepackage.ESModifyElementEvent;
import org.unicase.emfstore.esmodel.changemanagment.changepackage.ESOperation;
import org.unicase.emfstore.esmodel.changemanagment.changepackage.ESeAttributeEvent;
import org.unicase.emfstore.esmodel.changemanagment.impl.ChangemanagmentPackageImpl;
import org.unicase.emfstore.esmodel.impl.EsmodelPackageImpl;
import org.unicase.model.ModelPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class ChangepackagePackageImpl extends EPackageImpl implements
		ChangepackagePackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass esChangePackageEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass esAbstractOperationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass esOperationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass esEventEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass eSeAttributeEventEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass esListEventEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass esModifyElementEventEClass = null;

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
	 * @see org.unicase.emfstore.esmodel.changemanagment.changepackage.ChangepackagePackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private ChangepackagePackageImpl() {
		super(eNS_URI, ChangepackageFactory.eINSTANCE);
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
	public static ChangepackagePackage init() {
		if (isInited)
			return (ChangepackagePackage) EPackage.Registry.INSTANCE
					.getEPackage(ChangepackagePackage.eNS_URI);

		// Obtain or create and register package
		ChangepackagePackageImpl theChangepackagePackage = (ChangepackagePackageImpl) (EPackage.Registry.INSTANCE
				.getEPackage(eNS_URI) instanceof ChangepackagePackageImpl ? EPackage.Registry.INSTANCE
				.getEPackage(eNS_URI)
				: new ChangepackagePackageImpl());

		isInited = true;

		// Initialize simple dependencies
		ChangePackage.eINSTANCE.eClass();
		ModelPackage.eINSTANCE.eClass();

		// Obtain or create and register interdependencies
		EsmodelPackageImpl theEsmodelPackage = (EsmodelPackageImpl) (EPackage.Registry.INSTANCE
				.getEPackage(EsmodelPackage.eNS_URI) instanceof EsmodelPackageImpl ? EPackage.Registry.INSTANCE
				.getEPackage(EsmodelPackage.eNS_URI)
				: EsmodelPackage.eINSTANCE);
		ChangemanagmentPackageImpl theChangemanagmentPackage = (ChangemanagmentPackageImpl) (EPackage.Registry.INSTANCE
				.getEPackage(ChangemanagmentPackage.eNS_URI) instanceof ChangemanagmentPackageImpl ? EPackage.Registry.INSTANCE
				.getEPackage(ChangemanagmentPackage.eNS_URI)
				: ChangemanagmentPackage.eINSTANCE);
		AccesscontrolPackageImpl theAccesscontrolPackage = (AccesscontrolPackageImpl) (EPackage.Registry.INSTANCE
				.getEPackage(AccesscontrolPackage.eNS_URI) instanceof AccesscontrolPackageImpl ? EPackage.Registry.INSTANCE
				.getEPackage(AccesscontrolPackage.eNS_URI)
				: AccesscontrolPackage.eINSTANCE);
		RolesPackageImpl theRolesPackage = (RolesPackageImpl) (EPackage.Registry.INSTANCE
				.getEPackage(RolesPackage.eNS_URI) instanceof RolesPackageImpl ? EPackage.Registry.INSTANCE
				.getEPackage(RolesPackage.eNS_URI)
				: RolesPackage.eINSTANCE);

		// Create package meta-data objects
		theChangepackagePackage.createPackageContents();
		theEsmodelPackage.createPackageContents();
		theChangemanagmentPackage.createPackageContents();
		theAccesscontrolPackage.createPackageContents();
		theRolesPackage.createPackageContents();

		// Initialize created meta-data
		theChangepackagePackage.initializePackageContents();
		theEsmodelPackage.initializePackageContents();
		theChangemanagmentPackage.initializePackageContents();
		theAccesscontrolPackage.initializePackageContents();
		theRolesPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theChangepackagePackage.freeze();

		return theChangepackagePackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getESChangePackage() {
		return esChangePackageEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getESChangePackage_Operations() {
		return (EReference) esChangePackageEClass.getEStructuralFeatures().get(
				0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getESAbstractOperation() {
		return esAbstractOperationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getESOperation() {
		return esOperationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getESOperation_Name() {
		return (EAttribute) esOperationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getESOperation_Description() {
		return (EAttribute) esOperationEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getESOperation_Operations() {
		return (EReference) esOperationEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getESEvent() {
		return esEventEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getESEvent_ModelElementId() {
		return (EReference) esEventEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getESEvent_FeatureId() {
		return (EAttribute) esEventEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getESEvent_ModelElementClass() {
		return (EAttribute) esEventEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getESeAttributeEvent() {
		return eSeAttributeEventEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getESeAttributeEvent_PreviousState() {
		return (EReference) eSeAttributeEventEClass.getEStructuralFeatures()
				.get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getESeAttributeEvent_SubsequentState() {
		return (EReference) eSeAttributeEventEClass.getEStructuralFeatures()
				.get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getESListEvent() {
		return esListEventEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getESModifyElementEvent() {
		return esModifyElementEventEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getESModifyElementEvent_PreviousState() {
		return (EAttribute) esModifyElementEventEClass.getEStructuralFeatures()
				.get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getESModifyElementEvent_SubsequentState() {
		return (EAttribute) esModifyElementEventEClass.getEStructuralFeatures()
				.get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ChangepackageFactory getChangepackageFactory() {
		return (ChangepackageFactory) getEFactoryInstance();
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
		esChangePackageEClass = createEClass(ES_CHANGE_PACKAGE);
		createEReference(esChangePackageEClass, ES_CHANGE_PACKAGE__OPERATIONS);

		esAbstractOperationEClass = createEClass(ES_ABSTRACT_OPERATION);

		esOperationEClass = createEClass(ES_OPERATION);
		createEAttribute(esOperationEClass, ES_OPERATION__NAME);
		createEAttribute(esOperationEClass, ES_OPERATION__DESCRIPTION);
		createEReference(esOperationEClass, ES_OPERATION__OPERATIONS);

		esEventEClass = createEClass(ES_EVENT);
		createEReference(esEventEClass, ES_EVENT__MODEL_ELEMENT_ID);
		createEAttribute(esEventEClass, ES_EVENT__FEATURE_ID);
		createEAttribute(esEventEClass, ES_EVENT__MODEL_ELEMENT_CLASS);

		eSeAttributeEventEClass = createEClass(ESE_ATTRIBUTE_EVENT);
		createEReference(eSeAttributeEventEClass,
				ESE_ATTRIBUTE_EVENT__PREVIOUS_STATE);
		createEReference(eSeAttributeEventEClass,
				ESE_ATTRIBUTE_EVENT__SUBSEQUENT_STATE);

		esListEventEClass = createEClass(ES_LIST_EVENT);

		esModifyElementEventEClass = createEClass(ES_MODIFY_ELEMENT_EVENT);
		createEAttribute(esModifyElementEventEClass,
				ES_MODIFY_ELEMENT_EVENT__PREVIOUS_STATE);
		createEAttribute(esModifyElementEventEClass,
				ES_MODIFY_ELEMENT_EVENT__SUBSEQUENT_STATE);
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
		EcorePackage theEcorePackage = (EcorePackage) EPackage.Registry.INSTANCE
				.getEPackage(EcorePackage.eNS_URI);
		ModelPackage theModelPackage = (ModelPackage) EPackage.Registry.INSTANCE
				.getEPackage(ModelPackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		esOperationEClass.getESuperTypes().add(this.getESAbstractOperation());
		esEventEClass.getESuperTypes().add(this.getESAbstractOperation());
		eSeAttributeEventEClass.getESuperTypes().add(this.getESEvent());
		esListEventEClass.getESuperTypes().add(this.getESEvent());
		esModifyElementEventEClass.getESuperTypes().add(this.getESEvent());

		// Initialize classes and features; add operations and parameters
		initEClass(esChangePackageEClass, ESChangePackage.class,
				"ESChangePackage", !IS_ABSTRACT, !IS_INTERFACE,
				IS_GENERATED_INSTANCE_CLASS);
		initEReference(getESChangePackage_Operations(), this
				.getESAbstractOperation(), null, "operations", null, 0, -1,
				ESChangePackage.class, !IS_TRANSIENT, !IS_VOLATILE,
				IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES,
				!IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(esAbstractOperationEClass, ESAbstractOperation.class,
				"ESAbstractOperation", IS_ABSTRACT, IS_INTERFACE,
				IS_GENERATED_INSTANCE_CLASS);

		initEClass(esOperationEClass, ESOperation.class, "ESOperation",
				!IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getESOperation_Name(), theEcorePackage.getEString(),
				"name", null, 0, 1, ESOperation.class, !IS_TRANSIENT,
				!IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE,
				!IS_DERIVED, IS_ORDERED);
		initEAttribute(getESOperation_Description(), theEcorePackage
				.getEString(), "description", null, 0, 1, ESOperation.class,
				!IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE,
				!IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getESOperation_Operations(), this
				.getESAbstractOperation(), null, "operations", null, 1, -1,
				ESOperation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE,
				IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE,
				!IS_DERIVED, IS_ORDERED);

		initEClass(esEventEClass, ESEvent.class, "ESEvent", IS_ABSTRACT,
				!IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getESEvent_ModelElementId(), theModelPackage
				.getModelElementId(), null, "modelElementId", null, 0, 1,
				ESEvent.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE,
				IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE,
				!IS_DERIVED, IS_ORDERED);
		initEAttribute(getESEvent_FeatureId(), ecorePackage.getEInt(),
				"featureId", null, 0, 1, ESEvent.class, !IS_TRANSIENT,
				!IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE,
				!IS_DERIVED, IS_ORDERED);
		EGenericType g1 = createEGenericType(theEcorePackage.getEJavaClass());
		EGenericType g2 = createEGenericType();
		g1.getETypeArguments().add(g2);
		initEAttribute(getESEvent_ModelElementClass(), g1, "modelElementClass",
				null, 0, 1, ESEvent.class, !IS_TRANSIENT, !IS_VOLATILE,
				IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED,
				IS_ORDERED);

		initEClass(eSeAttributeEventEClass, ESeAttributeEvent.class,
				"ESeAttributeEvent", !IS_ABSTRACT, !IS_INTERFACE,
				IS_GENERATED_INSTANCE_CLASS);
		initEReference(getESeAttributeEvent_PreviousState(), theEcorePackage
				.getEAttribute(), null, "previousState", null, 0, 1,
				ESeAttributeEvent.class, !IS_TRANSIENT, !IS_VOLATILE,
				IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES,
				!IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getESeAttributeEvent_SubsequentState(), theEcorePackage
				.getEAttribute(), null, "subsequentState", null, 0, 1,
				ESeAttributeEvent.class, !IS_TRANSIENT, !IS_VOLATILE,
				IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES,
				!IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(esListEventEClass, ESListEvent.class, "ESListEvent",
				!IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(esModifyElementEventEClass, ESModifyElementEvent.class,
				"ESModifyElementEvent", !IS_ABSTRACT, !IS_INTERFACE,
				IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getESModifyElementEvent_PreviousState(), theEcorePackage
				.getEString(), "previousState", null, 0, 1,
				ESModifyElementEvent.class, !IS_TRANSIENT, !IS_VOLATILE,
				IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED,
				IS_ORDERED);
		initEAttribute(getESModifyElementEvent_SubsequentState(), ecorePackage
				.getEString(), "subsequentState", null, 0, 1,
				ESModifyElementEvent.class, !IS_TRANSIENT, !IS_VOLATILE,
				IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED,
				IS_ORDERED);
	}

} //ChangepackagePackageImpl
