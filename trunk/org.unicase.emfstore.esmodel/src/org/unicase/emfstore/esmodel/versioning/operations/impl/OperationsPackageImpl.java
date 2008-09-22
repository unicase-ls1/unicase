/**
 * Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this distribution, and is available at http://www.eclipse.org/legal/epl-v10.html
 *
 * $Id$
 */
package org.unicase.emfstore.esmodel.versioning.operations.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EOperation;
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
import org.unicase.emfstore.esmodel.impl.EsmodelPackageImpl;
import org.unicase.emfstore.esmodel.versioning.VersioningPackage;
import org.unicase.emfstore.esmodel.versioning.changeContainer.ChangeContainerPackage;
import org.unicase.emfstore.esmodel.versioning.changeContainer.impl.ChangeContainerPackageImpl;
import org.unicase.emfstore.esmodel.versioning.impl.VersioningPackageImpl;
import org.unicase.emfstore.esmodel.versioning.operations.AbstractOperation;
import org.unicase.emfstore.esmodel.versioning.operations.AttributeOperation;
import org.unicase.emfstore.esmodel.versioning.operations.CompositeOperation;
import org.unicase.emfstore.esmodel.versioning.operations.CreateDeleteOperation;
import org.unicase.emfstore.esmodel.versioning.operations.FeatureOperation;
import org.unicase.emfstore.esmodel.versioning.operations.MultiAttributeOperation;
import org.unicase.emfstore.esmodel.versioning.operations.MultiReferenceMoveOperation;
import org.unicase.emfstore.esmodel.versioning.operations.MultiReferenceOperation;
import org.unicase.emfstore.esmodel.versioning.operations.OperationsFactory;
import org.unicase.emfstore.esmodel.versioning.operations.OperationsPackage;
import org.unicase.emfstore.esmodel.versioning.operations.SingleReferenceOperation;
import org.unicase.model.ModelPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class OperationsPackageImpl extends EPackageImpl implements
		OperationsPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass abstractOperationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass compositeOperationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass featureOperationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass createDeleteOperationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass attributeOperationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass singleReferenceOperationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass multiReferenceOperationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass multiReferenceMoveOperationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass multiAttributeOperationEClass = null;

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
	 * @see org.unicase.emfstore.esmodel.versioning.operations.OperationsPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private OperationsPackageImpl() {
		super(eNS_URI, OperationsFactory.eINSTANCE);
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
	public static OperationsPackage init() {
		if (isInited)
			return (OperationsPackage) EPackage.Registry.INSTANCE
					.getEPackage(OperationsPackage.eNS_URI);

		// Obtain or create and register package
		OperationsPackageImpl theOperationsPackage = (OperationsPackageImpl) (EPackage.Registry.INSTANCE
				.getEPackage(eNS_URI) instanceof OperationsPackageImpl ? EPackage.Registry.INSTANCE
				.getEPackage(eNS_URI)
				: new OperationsPackageImpl());

		isInited = true;

		// Initialize simple dependencies
		ChangePackage.eINSTANCE.eClass();
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
		ChangeContainerPackageImpl theChangeContainerPackage = (ChangeContainerPackageImpl) (EPackage.Registry.INSTANCE
				.getEPackage(ChangeContainerPackage.eNS_URI) instanceof ChangeContainerPackageImpl ? EPackage.Registry.INSTANCE
				.getEPackage(ChangeContainerPackage.eNS_URI)
				: ChangeContainerPackage.eINSTANCE);
		AccesscontrolPackageImpl theAccesscontrolPackage = (AccesscontrolPackageImpl) (EPackage.Registry.INSTANCE
				.getEPackage(AccesscontrolPackage.eNS_URI) instanceof AccesscontrolPackageImpl ? EPackage.Registry.INSTANCE
				.getEPackage(AccesscontrolPackage.eNS_URI)
				: AccesscontrolPackage.eINSTANCE);
		RolesPackageImpl theRolesPackage = (RolesPackageImpl) (EPackage.Registry.INSTANCE
				.getEPackage(RolesPackage.eNS_URI) instanceof RolesPackageImpl ? EPackage.Registry.INSTANCE
				.getEPackage(RolesPackage.eNS_URI)
				: RolesPackage.eINSTANCE);

		// Create package meta-data objects
		theOperationsPackage.createPackageContents();
		theEsmodelPackage.createPackageContents();
		theVersioningPackage.createPackageContents();
		theChangeContainerPackage.createPackageContents();
		theAccesscontrolPackage.createPackageContents();
		theRolesPackage.createPackageContents();

		// Initialize created meta-data
		theOperationsPackage.initializePackageContents();
		theEsmodelPackage.initializePackageContents();
		theVersioningPackage.initializePackageContents();
		theChangeContainerPackage.initializePackageContents();
		theAccesscontrolPackage.initializePackageContents();
		theRolesPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theOperationsPackage.freeze();

		return theOperationsPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAbstractOperation() {
		return abstractOperationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAbstractOperation_Name() {
		return (EAttribute) abstractOperationEClass.getEStructuralFeatures()
				.get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAbstractOperation_Description() {
		return (EAttribute) abstractOperationEClass.getEStructuralFeatures()
				.get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAbstractOperation_ModelElementId() {
		return (EReference) abstractOperationEClass.getEStructuralFeatures()
				.get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAbstractOperation_Username() {
		return (EAttribute) abstractOperationEClass.getEStructuralFeatures()
				.get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCompositeOperation() {
		return compositeOperationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCompositeOperation_SubOperations() {
		return (EReference) compositeOperationEClass.getEStructuralFeatures()
				.get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCompositeOperation_CompositeName() {
		return (EAttribute) compositeOperationEClass.getEStructuralFeatures()
				.get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCompositeOperation_CompositeDescription() {
		return (EAttribute) compositeOperationEClass.getEStructuralFeatures()
				.get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCompositeOperation_Reversed() {
		return (EAttribute) compositeOperationEClass.getEStructuralFeatures()
				.get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getFeatureOperation() {
		return featureOperationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getFeatureOperation_FeatureName() {
		return (EAttribute) featureOperationEClass.getEStructuralFeatures()
				.get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCreateDeleteOperation() {
		return createDeleteOperationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCreateDeleteOperation_Delete() {
		return (EAttribute) createDeleteOperationEClass
				.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCreateDeleteOperation_ModelElement() {
		return (EReference) createDeleteOperationEClass
				.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAttributeOperation() {
		return attributeOperationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAttributeOperation_OldValue() {
		return (EAttribute) attributeOperationEClass.getEStructuralFeatures()
				.get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAttributeOperation_NewValue() {
		return (EAttribute) attributeOperationEClass.getEStructuralFeatures()
				.get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSingleReferenceOperation() {
		return singleReferenceOperationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSingleReferenceOperation_OldValue() {
		return (EReference) singleReferenceOperationEClass
				.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSingleReferenceOperation_NewValue() {
		return (EReference) singleReferenceOperationEClass
				.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMultiReferenceOperation() {
		return multiReferenceOperationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMultiReferenceOperation_Add() {
		return (EAttribute) multiReferenceOperationEClass
				.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMultiReferenceOperation_Index() {
		return (EAttribute) multiReferenceOperationEClass
				.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMultiReferenceOperation_ReferencedModelElements() {
		return (EReference) multiReferenceOperationEClass
				.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMultiReferenceMoveOperation() {
		return multiReferenceMoveOperationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMultiReferenceMoveOperation_OldIndex() {
		return (EAttribute) multiReferenceMoveOperationEClass
				.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMultiReferenceMoveOperation_NewIndex() {
		return (EAttribute) multiReferenceMoveOperationEClass
				.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMultiReferenceMoveOperation_ReferencedModelElementId() {
		return (EReference) multiReferenceMoveOperationEClass
				.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMultiAttributeOperation() {
		return multiAttributeOperationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMultiAttributeOperation_Add() {
		return (EAttribute) multiAttributeOperationEClass
				.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMultiAttributeOperation_Index() {
		return (EAttribute) multiAttributeOperationEClass
				.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMultiAttributeOperation_Values() {
		return (EAttribute) multiAttributeOperationEClass
				.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OperationsFactory getOperationsFactory() {
		return (OperationsFactory) getEFactoryInstance();
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
		abstractOperationEClass = createEClass(ABSTRACT_OPERATION);
		createEAttribute(abstractOperationEClass, ABSTRACT_OPERATION__NAME);
		createEAttribute(abstractOperationEClass,
				ABSTRACT_OPERATION__DESCRIPTION);
		createEReference(abstractOperationEClass,
				ABSTRACT_OPERATION__MODEL_ELEMENT_ID);
		createEAttribute(abstractOperationEClass, ABSTRACT_OPERATION__USERNAME);

		compositeOperationEClass = createEClass(COMPOSITE_OPERATION);
		createEReference(compositeOperationEClass,
				COMPOSITE_OPERATION__SUB_OPERATIONS);
		createEAttribute(compositeOperationEClass,
				COMPOSITE_OPERATION__COMPOSITE_NAME);
		createEAttribute(compositeOperationEClass,
				COMPOSITE_OPERATION__COMPOSITE_DESCRIPTION);
		createEAttribute(compositeOperationEClass,
				COMPOSITE_OPERATION__REVERSED);

		featureOperationEClass = createEClass(FEATURE_OPERATION);
		createEAttribute(featureOperationEClass,
				FEATURE_OPERATION__FEATURE_NAME);

		createDeleteOperationEClass = createEClass(CREATE_DELETE_OPERATION);
		createEAttribute(createDeleteOperationEClass,
				CREATE_DELETE_OPERATION__DELETE);
		createEReference(createDeleteOperationEClass,
				CREATE_DELETE_OPERATION__MODEL_ELEMENT);

		attributeOperationEClass = createEClass(ATTRIBUTE_OPERATION);
		createEAttribute(attributeOperationEClass,
				ATTRIBUTE_OPERATION__OLD_VALUE);
		createEAttribute(attributeOperationEClass,
				ATTRIBUTE_OPERATION__NEW_VALUE);

		singleReferenceOperationEClass = createEClass(SINGLE_REFERENCE_OPERATION);
		createEReference(singleReferenceOperationEClass,
				SINGLE_REFERENCE_OPERATION__OLD_VALUE);
		createEReference(singleReferenceOperationEClass,
				SINGLE_REFERENCE_OPERATION__NEW_VALUE);

		multiReferenceOperationEClass = createEClass(MULTI_REFERENCE_OPERATION);
		createEAttribute(multiReferenceOperationEClass,
				MULTI_REFERENCE_OPERATION__ADD);
		createEAttribute(multiReferenceOperationEClass,
				MULTI_REFERENCE_OPERATION__INDEX);
		createEReference(multiReferenceOperationEClass,
				MULTI_REFERENCE_OPERATION__REFERENCED_MODEL_ELEMENTS);

		multiReferenceMoveOperationEClass = createEClass(MULTI_REFERENCE_MOVE_OPERATION);
		createEAttribute(multiReferenceMoveOperationEClass,
				MULTI_REFERENCE_MOVE_OPERATION__OLD_INDEX);
		createEAttribute(multiReferenceMoveOperationEClass,
				MULTI_REFERENCE_MOVE_OPERATION__NEW_INDEX);
		createEReference(multiReferenceMoveOperationEClass,
				MULTI_REFERENCE_MOVE_OPERATION__REFERENCED_MODEL_ELEMENT_ID);

		multiAttributeOperationEClass = createEClass(MULTI_ATTRIBUTE_OPERATION);
		createEAttribute(multiAttributeOperationEClass,
				MULTI_ATTRIBUTE_OPERATION__ADD);
		createEAttribute(multiAttributeOperationEClass,
				MULTI_ATTRIBUTE_OPERATION__INDEX);
		createEAttribute(multiAttributeOperationEClass,
				MULTI_ATTRIBUTE_OPERATION__VALUES);
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

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		compositeOperationEClass.getESuperTypes().add(
				this.getAbstractOperation());
		featureOperationEClass.getESuperTypes()
				.add(this.getAbstractOperation());
		createDeleteOperationEClass.getESuperTypes().add(
				this.getAbstractOperation());
		attributeOperationEClass.getESuperTypes().add(
				this.getFeatureOperation());
		singleReferenceOperationEClass.getESuperTypes().add(
				this.getFeatureOperation());
		multiReferenceOperationEClass.getESuperTypes().add(
				this.getFeatureOperation());
		multiReferenceMoveOperationEClass.getESuperTypes().add(
				this.getFeatureOperation());
		multiAttributeOperationEClass.getESuperTypes().add(
				this.getFeatureOperation());

		// Initialize classes and features; add operations and parameters
		initEClass(abstractOperationEClass, AbstractOperation.class,
				"AbstractOperation", IS_ABSTRACT, !IS_INTERFACE,
				IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getAbstractOperation_Name(), ecorePackage.getEString(),
				"name", null, 0, 1, AbstractOperation.class, IS_TRANSIENT,
				IS_VOLATILE, !IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE,
				IS_DERIVED, IS_ORDERED);
		initEAttribute(getAbstractOperation_Description(), ecorePackage
				.getEString(), "description", "", 0, 1,
				AbstractOperation.class, IS_TRANSIENT, IS_VOLATILE,
				!IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, IS_DERIVED,
				IS_ORDERED);
		initEReference(getAbstractOperation_ModelElementId(), theModelPackage
				.getModelElementId(), null, "modelElementId", null, 0, 1,
				AbstractOperation.class, !IS_TRANSIENT, !IS_VOLATILE,
				IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES,
				!IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAbstractOperation_Username(), ecorePackage
				.getEString(), "username", null, 0, 1, AbstractOperation.class,
				!IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE,
				!IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		EOperation op = addEOperation(abstractOperationEClass, null, "apply",
				0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theModelPackage.getProject(), "project", 0, 1,
				IS_UNIQUE, IS_ORDERED);

		addEOperation(abstractOperationEClass, this.getAbstractOperation(),
				"reverse", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(abstractOperationEClass, ecorePackage.getEBoolean(),
				"canApply", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theModelPackage.getProject(), "project", 0, 1,
				IS_UNIQUE, IS_ORDERED);

		initEClass(compositeOperationEClass, CompositeOperation.class,
				"CompositeOperation", !IS_ABSTRACT, !IS_INTERFACE,
				IS_GENERATED_INSTANCE_CLASS);
		initEReference(getCompositeOperation_SubOperations(), this
				.getAbstractOperation(), null, "subOperations", null, 0, -1,
				CompositeOperation.class, !IS_TRANSIENT, !IS_VOLATILE,
				IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES,
				!IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getCompositeOperation_CompositeName(), ecorePackage
				.getEString(), "compositeName", null, 0, 1,
				CompositeOperation.class, !IS_TRANSIENT, !IS_VOLATILE,
				IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED,
				IS_ORDERED);
		initEAttribute(getCompositeOperation_CompositeDescription(),
				ecorePackage.getEString(), "compositeDescription", null, 0, 1,
				CompositeOperation.class, !IS_TRANSIENT, !IS_VOLATILE,
				IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED,
				IS_ORDERED);
		initEAttribute(getCompositeOperation_Reversed(), ecorePackage
				.getEBoolean(), "reversed", null, 0, 1,
				CompositeOperation.class, !IS_TRANSIENT, !IS_VOLATILE,
				IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED,
				IS_ORDERED);

		addEOperation(compositeOperationEClass, null, "cannonize", 0, 1,
				IS_UNIQUE, IS_ORDERED);

		initEClass(featureOperationEClass, FeatureOperation.class,
				"FeatureOperation", IS_ABSTRACT, !IS_INTERFACE,
				IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getFeatureOperation_FeatureName(), theEcorePackage
				.getEString(), "featureName", "", 0, 1, FeatureOperation.class,
				!IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE,
				!IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(createDeleteOperationEClass, CreateDeleteOperation.class,
				"CreateDeleteOperation", !IS_ABSTRACT, !IS_INTERFACE,
				IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getCreateDeleteOperation_Delete(), ecorePackage
				.getEBoolean(), "delete", null, 0, 1,
				CreateDeleteOperation.class, !IS_TRANSIENT, !IS_VOLATILE,
				IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED,
				IS_ORDERED);
		initEReference(getCreateDeleteOperation_ModelElement(), theModelPackage
				.getModelElement(), null, "modelElement", null, 0, 1,
				CreateDeleteOperation.class, !IS_TRANSIENT, !IS_VOLATILE,
				IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES,
				!IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(attributeOperationEClass, AttributeOperation.class,
				"AttributeOperation", !IS_ABSTRACT, !IS_INTERFACE,
				IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getAttributeOperation_OldValue(), theEcorePackage
				.getEJavaObject(), "oldValue", null, 0, 1,
				AttributeOperation.class, !IS_TRANSIENT, !IS_VOLATILE,
				IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED,
				IS_ORDERED);
		initEAttribute(getAttributeOperation_NewValue(), theEcorePackage
				.getEJavaObject(), "newValue", null, 0, 1,
				AttributeOperation.class, !IS_TRANSIENT, !IS_VOLATILE,
				IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED,
				IS_ORDERED);

		initEClass(singleReferenceOperationEClass,
				SingleReferenceOperation.class, "SingleReferenceOperation",
				!IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getSingleReferenceOperation_OldValue(), theModelPackage
				.getModelElementId(), null, "oldValue", null, 0, 1,
				SingleReferenceOperation.class, !IS_TRANSIENT, !IS_VOLATILE,
				IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES,
				!IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getSingleReferenceOperation_NewValue(), theModelPackage
				.getModelElementId(), null, "newValue", null, 0, 1,
				SingleReferenceOperation.class, !IS_TRANSIENT, !IS_VOLATILE,
				IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES,
				!IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(multiReferenceOperationEClass,
				MultiReferenceOperation.class, "MultiReferenceOperation",
				!IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getMultiReferenceOperation_Add(), ecorePackage
				.getEBoolean(), "add", null, 0, 1,
				MultiReferenceOperation.class, !IS_TRANSIENT, !IS_VOLATILE,
				IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED,
				IS_ORDERED);
		initEAttribute(getMultiReferenceOperation_Index(), ecorePackage
				.getEInt(), "index", null, 0, 1, MultiReferenceOperation.class,
				!IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE,
				!IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getMultiReferenceOperation_ReferencedModelElements(),
				theModelPackage.getModelElementId(), null,
				"referencedModelElements", null, 0, -1,
				MultiReferenceOperation.class, !IS_TRANSIENT, !IS_VOLATILE,
				IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES,
				!IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(multiReferenceMoveOperationEClass,
				MultiReferenceMoveOperation.class,
				"MultiReferenceMoveOperation", !IS_ABSTRACT, !IS_INTERFACE,
				IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getMultiReferenceMoveOperation_OldIndex(), ecorePackage
				.getEInt(), "oldIndex", null, 0, 1,
				MultiReferenceMoveOperation.class, !IS_TRANSIENT, !IS_VOLATILE,
				IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED,
				IS_ORDERED);
		initEAttribute(getMultiReferenceMoveOperation_NewIndex(), ecorePackage
				.getEInt(), "newIndex", null, 0, 1,
				MultiReferenceMoveOperation.class, !IS_TRANSIENT, !IS_VOLATILE,
				IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED,
				IS_ORDERED);
		initEReference(
				getMultiReferenceMoveOperation_ReferencedModelElementId(),
				theModelPackage.getModelElementId(), null,
				"referencedModelElementId", null, 0, 1,
				MultiReferenceMoveOperation.class, !IS_TRANSIENT, !IS_VOLATILE,
				IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES,
				!IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(multiAttributeOperationEClass,
				MultiAttributeOperation.class, "MultiAttributeOperation",
				!IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getMultiAttributeOperation_Add(), ecorePackage
				.getEBoolean(), "add", null, 0, 1,
				MultiAttributeOperation.class, !IS_TRANSIENT, !IS_VOLATILE,
				IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED,
				IS_ORDERED);
		initEAttribute(getMultiAttributeOperation_Index(), ecorePackage
				.getEInt(), "index", null, 0, 1, MultiAttributeOperation.class,
				!IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE,
				!IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getMultiAttributeOperation_Values(), ecorePackage
				.getEJavaObject(), "values", null, 0, -1,
				MultiAttributeOperation.class, !IS_TRANSIENT, !IS_VOLATILE,
				IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED,
				IS_ORDERED);
	}

} //OperationsPackageImpl
