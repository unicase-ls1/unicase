/**
 * <copyright> Copyright (c) 2009-2012 Chair of Applied Software Engineering, Technische Universit�t M�nchen (TUM).
 * All rights reserved. This program and the accompanying materials are made available under the terms of
 * the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.implementation.operations.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.impl.EPackageImpl;
import org.unicase.implementation.operations.ExtractClassOperation;
import org.unicase.implementation.operations.ExtractSuperClassOperation;
import org.unicase.implementation.operations.InlineClassOperation;
import org.unicase.implementation.operations.InlineSuperClassOperation;
import org.unicase.implementation.operations.OperationsFactory;
import org.unicase.implementation.operations.OperationsPackage;
import org.unicase.implementation.operations.PartitionAssociationOperation;
import org.unicase.implementation.operations.PullUpOperation;
import org.unicase.implementation.operations.PushDownOperation;
import org.unicase.model.ModelPackage;
import org.unicase.model.classes.ClassesPackage;

/**
 * <!-- begin-user-doc --> An implementation of the model <b>Package</b>. <!-- end-user-doc -->
 * @generated
 */
public class OperationsPackageImpl extends EPackageImpl implements OperationsPackage {
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass extractSuperClassOperationEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass inlineSuperClassOperationEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass inlineClassOperationEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass extractClassOperationEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass partitionAssociationOperationEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass pushDownOperationEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass pullUpOperationEClass = null;

	/**
	 * Creates an instance of the model <b>Package</b>, registered with {@link org.eclipse.emf.ecore.EPackage.Registry
	 * EPackage.Registry} by the package package URI value.
	 * <p>
	 * Note: the correct way to create the package is via the static factory method {@link #init init()}, which also
	 * performs initialization of the package, or returns the registered package, if one already exists. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.emf.ecore.EPackage.Registry
	 * @see org.unicase.implementation.operations.OperationsPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private OperationsPackageImpl() {
		super(eNS_URI, OperationsFactory.eINSTANCE);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private static boolean isInited = false;

	/**
	 * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
	 * 
	 * <p>This method is used to initialize {@link OperationsPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static OperationsPackage init() {
		if (isInited) return (OperationsPackage)EPackage.Registry.INSTANCE.getEPackage(OperationsPackage.eNS_URI);

		// Obtain or create and register package
		OperationsPackageImpl theOperationsPackage = (OperationsPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof OperationsPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new OperationsPackageImpl());

		isInited = true;

		// Initialize simple dependencies
		ModelPackage.eINSTANCE.eClass();

		// Create package meta-data objects
		theOperationsPackage.createPackageContents();

		// Initialize created meta-data
		theOperationsPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theOperationsPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(OperationsPackage.eNS_URI, theOperationsPackage);
		return theOperationsPackage;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getExtractSuperClassOperation() {
		return extractSuperClassOperationEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getExtractSuperClassOperation_SubClasses() {
		return (EReference)extractSuperClassOperationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getExtractSuperClassOperation_Attributes() {
		return (EReference)extractSuperClassOperationEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getExtractSuperClassOperation_OutgoingAssociations() {
		return (EReference)extractSuperClassOperationEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getExtractSuperClassOperation_IncomingAssociations() {
		return (EReference)extractSuperClassOperationEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getExtractSuperClassOperation_SuperClassName() {
		return (EAttribute)extractSuperClassOperationEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getExtractSuperClassOperation_TargetPackage() {
		return (EReference)extractSuperClassOperationEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getExtractSuperClassOperation_SuperSuperClasses() {
		return (EReference)extractSuperClassOperationEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getInlineSuperClassOperation() {
		return inlineSuperClassOperationEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getInlineSuperClassOperation_SuperClass() {
		return (EReference)inlineSuperClassOperationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getInlineClassOperation() {
		return inlineClassOperationEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getInlineClassOperation_Association() {
		return (EReference)inlineClassOperationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getInlineClassOperation_InlineClass() {
		return (EReference)inlineClassOperationEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getExtractClassOperation() {
		return extractClassOperationEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getExtractClassOperation_ContextClass() {
		return (EReference)extractClassOperationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getExtractClassOperation_Attributes() {
		return (EReference)extractClassOperationEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getExtractClassOperation_OutgoingAssociations() {
		return (EReference)extractClassOperationEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getExtractClassOperation_IncomingAssociations() {
		return (EReference)extractClassOperationEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getExtractClassOperation_CompositionName() {
		return (EAttribute)extractClassOperationEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getExtractClassOperation_ClassName() {
		return (EAttribute)extractClassOperationEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getExtractClassOperation_TargetPackage() {
		return (EReference)extractClassOperationEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPartitionAssociationOperation() {
		return partitionAssociationOperationEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPartitionAssociationOperation_Association() {
		return (EReference)partitionAssociationOperationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPushDownOperation() {
		return pushDownOperationEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPushDownOperation_SuperClass() {
		return (EReference)pushDownOperationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPushDownOperation_Attributes() {
		return (EReference)pushDownOperationEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPushDownOperation_OutgoingAssociations() {
		return (EReference)pushDownOperationEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPushDownOperation_IncomingAssociations() {
		return (EReference)pushDownOperationEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPullUpOperation() {
		return pullUpOperationEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPullUpOperation_SuperClass() {
		return (EReference)pullUpOperationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPullUpOperation_Attributes() {
		return (EReference)pullUpOperationEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPullUpOperation_OutgoingAssociations() {
		return (EReference)pullUpOperationEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPullUpOperation_IncomingAssociations() {
		return (EReference)pullUpOperationEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public OperationsFactory getOperationsFactory() {
		return (OperationsFactory)getEFactoryInstance();
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
		extractSuperClassOperationEClass = createEClass(EXTRACT_SUPER_CLASS_OPERATION);
		createEReference(extractSuperClassOperationEClass, EXTRACT_SUPER_CLASS_OPERATION__SUB_CLASSES);
		createEReference(extractSuperClassOperationEClass, EXTRACT_SUPER_CLASS_OPERATION__ATTRIBUTES);
		createEReference(extractSuperClassOperationEClass, EXTRACT_SUPER_CLASS_OPERATION__OUTGOING_ASSOCIATIONS);
		createEReference(extractSuperClassOperationEClass, EXTRACT_SUPER_CLASS_OPERATION__INCOMING_ASSOCIATIONS);
		createEAttribute(extractSuperClassOperationEClass, EXTRACT_SUPER_CLASS_OPERATION__SUPER_CLASS_NAME);
		createEReference(extractSuperClassOperationEClass, EXTRACT_SUPER_CLASS_OPERATION__TARGET_PACKAGE);
		createEReference(extractSuperClassOperationEClass, EXTRACT_SUPER_CLASS_OPERATION__SUPER_SUPER_CLASSES);

		inlineSuperClassOperationEClass = createEClass(INLINE_SUPER_CLASS_OPERATION);
		createEReference(inlineSuperClassOperationEClass, INLINE_SUPER_CLASS_OPERATION__SUPER_CLASS);

		extractClassOperationEClass = createEClass(EXTRACT_CLASS_OPERATION);
		createEReference(extractClassOperationEClass, EXTRACT_CLASS_OPERATION__CONTEXT_CLASS);
		createEReference(extractClassOperationEClass, EXTRACT_CLASS_OPERATION__ATTRIBUTES);
		createEReference(extractClassOperationEClass, EXTRACT_CLASS_OPERATION__OUTGOING_ASSOCIATIONS);
		createEReference(extractClassOperationEClass, EXTRACT_CLASS_OPERATION__INCOMING_ASSOCIATIONS);
		createEAttribute(extractClassOperationEClass, EXTRACT_CLASS_OPERATION__COMPOSITION_NAME);
		createEAttribute(extractClassOperationEClass, EXTRACT_CLASS_OPERATION__CLASS_NAME);
		createEReference(extractClassOperationEClass, EXTRACT_CLASS_OPERATION__TARGET_PACKAGE);

		inlineClassOperationEClass = createEClass(INLINE_CLASS_OPERATION);
		createEReference(inlineClassOperationEClass, INLINE_CLASS_OPERATION__ASSOCIATION);
		createEReference(inlineClassOperationEClass, INLINE_CLASS_OPERATION__INLINE_CLASS);

		partitionAssociationOperationEClass = createEClass(PARTITION_ASSOCIATION_OPERATION);
		createEReference(partitionAssociationOperationEClass, PARTITION_ASSOCIATION_OPERATION__ASSOCIATION);

		pushDownOperationEClass = createEClass(PUSH_DOWN_OPERATION);
		createEReference(pushDownOperationEClass, PUSH_DOWN_OPERATION__SUPER_CLASS);
		createEReference(pushDownOperationEClass, PUSH_DOWN_OPERATION__ATTRIBUTES);
		createEReference(pushDownOperationEClass, PUSH_DOWN_OPERATION__OUTGOING_ASSOCIATIONS);
		createEReference(pushDownOperationEClass, PUSH_DOWN_OPERATION__INCOMING_ASSOCIATIONS);

		pullUpOperationEClass = createEClass(PULL_UP_OPERATION);
		createEReference(pullUpOperationEClass, PULL_UP_OPERATION__SUPER_CLASS);
		createEReference(pullUpOperationEClass, PULL_UP_OPERATION__ATTRIBUTES);
		createEReference(pullUpOperationEClass, PULL_UP_OPERATION__OUTGOING_ASSOCIATIONS);
		createEReference(pullUpOperationEClass, PULL_UP_OPERATION__INCOMING_ASSOCIATIONS);
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
		org.eclipse.emf.emfstore.internal.server.model.versioning.operations.semantic.SemanticPackage theSemanticPackage = (org.eclipse.emf.emfstore.internal.server.model.versioning.operations.semantic.SemanticPackage)EPackage.Registry.INSTANCE.getEPackage(org.eclipse.emf.emfstore.internal.server.model.versioning.operations.semantic.SemanticPackage.eNS_URI);
		org.eclipse.emf.emfstore.internal.common.model.ModelPackage theModelPackage_1 = (org.eclipse.emf.emfstore.internal.common.model.ModelPackage)EPackage.Registry.INSTANCE.getEPackage(org.eclipse.emf.emfstore.internal.common.model.ModelPackage.eNS_URI);
		ClassesPackage theClassesPackage = (ClassesPackage)EPackage.Registry.INSTANCE.getEPackage(ClassesPackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		extractSuperClassOperationEClass.getESuperTypes().add(theSemanticPackage.getSemanticCompositeOperation());
		inlineSuperClassOperationEClass.getESuperTypes().add(theSemanticPackage.getSemanticCompositeOperation());
		extractClassOperationEClass.getESuperTypes().add(theSemanticPackage.getSemanticCompositeOperation());
		inlineClassOperationEClass.getESuperTypes().add(theSemanticPackage.getSemanticCompositeOperation());
		partitionAssociationOperationEClass.getESuperTypes().add(theSemanticPackage.getSemanticCompositeOperation());
		pushDownOperationEClass.getESuperTypes().add(theSemanticPackage.getSemanticCompositeOperation());
		pullUpOperationEClass.getESuperTypes().add(theSemanticPackage.getSemanticCompositeOperation());

		// Initialize classes and features; add operations and parameters
		initEClass(extractSuperClassOperationEClass, ExtractSuperClassOperation.class, "ExtractSuperClassOperation", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getExtractSuperClassOperation_SubClasses(), theModelPackage_1.getModelElementId(), null, "subClasses", null, 1, -1, ExtractSuperClassOperation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getExtractSuperClassOperation_Attributes(), theModelPackage_1.getModelElementId(), null, "attributes", null, 0, -1, ExtractSuperClassOperation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getExtractSuperClassOperation_OutgoingAssociations(), theModelPackage_1.getModelElementId(), null, "outgoingAssociations", null, 0, -1, ExtractSuperClassOperation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getExtractSuperClassOperation_IncomingAssociations(), theModelPackage_1.getModelElementId(), null, "incomingAssociations", null, 0, -1, ExtractSuperClassOperation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getExtractSuperClassOperation_SuperClassName(), ecorePackage.getEString(), "superClassName", null, 1, 1, ExtractSuperClassOperation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getExtractSuperClassOperation_TargetPackage(), theModelPackage_1.getModelElementId(), null, "targetPackage", null, 1, 1, ExtractSuperClassOperation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getExtractSuperClassOperation_SuperSuperClasses(), theModelPackage_1.getModelElementId(), null, "superSuperClasses", null, 0, -1, ExtractSuperClassOperation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		EOperation op = addEOperation(extractSuperClassOperationEClass, theClassesPackage.getClass_(), "getSubClasses", 1, -1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theModelPackage_1.getProject(), "project", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(extractSuperClassOperationEClass, theClassesPackage.getAttribute(), "getAttributes", 0, -1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theModelPackage_1.getProject(), "project", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(extractSuperClassOperationEClass, theClassesPackage.getAttribute(), "getPossibleAttributes", 0, -1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theModelPackage_1.getProject(), "project", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(extractSuperClassOperationEClass, theClassesPackage.getAssociation(), "getOutgoingAssociations", 0, -1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theModelPackage_1.getProject(), "project", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(extractSuperClassOperationEClass, theClassesPackage.getAssociation(), "getPossibleOutgoingAssociations", 0, -1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theModelPackage_1.getProject(), "project", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(extractSuperClassOperationEClass, theClassesPackage.getAssociation(), "getIncomingAssociations", 0, -1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theModelPackage_1.getProject(), "project", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(extractSuperClassOperationEClass, theClassesPackage.getAssociation(), "getPossibleIncomingAssociations", 0, -1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theModelPackage_1.getProject(), "project", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(extractSuperClassOperationEClass, theClassesPackage.getPackage(), "getTargetPackage", 1, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theModelPackage_1.getProject(), "project", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(extractSuperClassOperationEClass, theClassesPackage.getClass_(), "getSuperSuperClasses", 0, -1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theModelPackage_1.getProject(), "project", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(extractSuperClassOperationEClass, theClassesPackage.getClass_(), "getPossibleSuperSuperClasses", 0, -1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theModelPackage_1.getProject(), "project", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(extractSuperClassOperationEClass, ecorePackage.getEBoolean(), "validateSuperClassName", 1, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theModelPackage_1.getProject(), "project", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(inlineSuperClassOperationEClass, InlineSuperClassOperation.class, "InlineSuperClassOperation", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getInlineSuperClassOperation_SuperClass(), theModelPackage_1.getModelElementId(), null, "superClass", null, 1, 1, InlineSuperClassOperation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		op = addEOperation(inlineSuperClassOperationEClass, theClassesPackage.getClass_(), "getSuperClass", 1, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theModelPackage_1.getProject(), "project", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(inlineSuperClassOperationEClass, ecorePackage.getEBoolean(), "validateSuperClassSubClasses", 1, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theModelPackage_1.getProject(), "project", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(extractClassOperationEClass, ExtractClassOperation.class, "ExtractClassOperation", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getExtractClassOperation_ContextClass(), theModelPackage_1.getModelElementId(), null, "contextClass", null, 1, 1, ExtractClassOperation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getExtractClassOperation_Attributes(), theModelPackage_1.getModelElementId(), null, "attributes", null, 0, -1, ExtractClassOperation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getExtractClassOperation_OutgoingAssociations(), theModelPackage_1.getModelElementId(), null, "outgoingAssociations", null, 0, -1, ExtractClassOperation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getExtractClassOperation_IncomingAssociations(), theModelPackage_1.getModelElementId(), null, "incomingAssociations", null, 0, -1, ExtractClassOperation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getExtractClassOperation_CompositionName(), ecorePackage.getEString(), "compositionName", null, 1, 1, ExtractClassOperation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getExtractClassOperation_ClassName(), ecorePackage.getEString(), "className", null, 1, 1, ExtractClassOperation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getExtractClassOperation_TargetPackage(), theModelPackage_1.getModelElementId(), null, "targetPackage", null, 1, 1, ExtractClassOperation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		op = addEOperation(extractClassOperationEClass, theClassesPackage.getClass_(), "getContextClass", 1, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theModelPackage_1.getProject(), "project", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(extractClassOperationEClass, theClassesPackage.getAttribute(), "getAttributes", 0, -1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theModelPackage_1.getProject(), "project", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(extractClassOperationEClass, theClassesPackage.getAttribute(), "getPossibleAttributes", 0, -1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theModelPackage_1.getProject(), "project", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(extractClassOperationEClass, theClassesPackage.getAssociation(), "getOutgoingAssociations", 0, -1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theModelPackage_1.getProject(), "project", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(extractClassOperationEClass, theClassesPackage.getAssociation(), "getPossibleOutgoingAssociations", 0, -1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theModelPackage_1.getProject(), "project", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(extractClassOperationEClass, theClassesPackage.getAssociation(), "getIncomingAssociations", 0, -1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theModelPackage_1.getProject(), "project", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(extractClassOperationEClass, theClassesPackage.getAssociation(), "getPossibleIncomingAssociations", 0, -1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theModelPackage_1.getProject(), "project", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(extractClassOperationEClass, theClassesPackage.getPackage(), "getTargetPackage", 1, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theModelPackage_1.getProject(), "project", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(extractClassOperationEClass, ecorePackage.getEBoolean(), "validateClassName", 1, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theModelPackage_1.getProject(), "project", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(extractClassOperationEClass, ecorePackage.getEBoolean(), "validateCompositionName", 1, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theModelPackage_1.getProject(), "project", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(inlineClassOperationEClass, InlineClassOperation.class, "InlineClassOperation", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getInlineClassOperation_Association(), theModelPackage_1.getModelElementId(), null, "association", null, 1, 1, InlineClassOperation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getInlineClassOperation_InlineClass(), theModelPackage_1.getModelElementId(), null, "inlineClass", null, 1, 1, InlineClassOperation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		op = addEOperation(inlineClassOperationEClass, theClassesPackage.getAssociation(), "getAssociation", 1, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theModelPackage_1.getProject(), "project", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(inlineClassOperationEClass, theClassesPackage.getAssociation(), "getPossibleAssociation", 0, -1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theModelPackage_1.getProject(), "project", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(inlineClassOperationEClass, theClassesPackage.getClass_(), "getInlineClass", 1, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theModelPackage_1.getProject(), "project", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(inlineClassOperationEClass, theClassesPackage.getClass_(), "getPossibleInlineClass", 0, -1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theModelPackage_1.getProject(), "project", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(inlineClassOperationEClass, ecorePackage.getEBoolean(), "validateAssociationComposition", 1, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theModelPackage_1.getProject(), "project", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(inlineClassOperationEClass, ecorePackage.getEBoolean(), "validateAssociationMultiplicity", 1, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theModelPackage_1.getProject(), "project", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(inlineClassOperationEClass, ecorePackage.getEBoolean(), "validateInlineClassSubClasses", 1, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theModelPackage_1.getProject(), "project", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(inlineClassOperationEClass, ecorePackage.getEBoolean(), "validateInlineClassAssociationTarget", 1, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theModelPackage_1.getProject(), "project", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(partitionAssociationOperationEClass, PartitionAssociationOperation.class, "PartitionAssociationOperation", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getPartitionAssociationOperation_Association(), theModelPackage_1.getModelElementId(), null, "association", null, 1, 1, PartitionAssociationOperation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		op = addEOperation(partitionAssociationOperationEClass, theClassesPackage.getAssociation(), "getAssociation", 1, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theModelPackage_1.getProject(), "project", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(partitionAssociationOperationEClass, ecorePackage.getEBoolean(), "validateAssociationTarget", 1, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theModelPackage_1.getProject(), "project", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(partitionAssociationOperationEClass, ecorePackage.getEBoolean(), "validateAssociationMultiplicity", 1, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theModelPackage_1.getProject(), "project", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(pushDownOperationEClass, PushDownOperation.class, "PushDownOperation", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getPushDownOperation_SuperClass(), theModelPackage_1.getModelElementId(), null, "superClass", null, 1, 1, PushDownOperation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getPushDownOperation_Attributes(), theModelPackage_1.getModelElementId(), null, "attributes", null, 0, -1, PushDownOperation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getPushDownOperation_OutgoingAssociations(), theModelPackage_1.getModelElementId(), null, "outgoingAssociations", null, 0, -1, PushDownOperation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getPushDownOperation_IncomingAssociations(), theModelPackage_1.getModelElementId(), null, "incomingAssociations", null, 0, -1, PushDownOperation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		op = addEOperation(pushDownOperationEClass, theClassesPackage.getClass_(), "getSuperClass", 1, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theModelPackage_1.getProject(), "project", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(pushDownOperationEClass, theClassesPackage.getAttribute(), "getAttributes", 0, -1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theModelPackage_1.getProject(), "project", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(pushDownOperationEClass, theClassesPackage.getAttribute(), "getPossibleAttributes", 0, -1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theModelPackage_1.getProject(), "project", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(pushDownOperationEClass, theClassesPackage.getAssociation(), "getOutgoingAssociations", 0, -1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theModelPackage_1.getProject(), "project", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(pushDownOperationEClass, theClassesPackage.getAssociation(), "getPossibleOutgoingAssociations", 0, -1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theModelPackage_1.getProject(), "project", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(pushDownOperationEClass, theClassesPackage.getAssociation(), "getIncomingAssociations", 0, -1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theModelPackage_1.getProject(), "project", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(pushDownOperationEClass, theClassesPackage.getAssociation(), "getPossibleIncomingAssociations", 0, -1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theModelPackage_1.getProject(), "project", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(pushDownOperationEClass, ecorePackage.getEBoolean(), "validateSuperClassSubClasses", 1, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theModelPackage_1.getProject(), "project", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(pushDownOperationEClass, ecorePackage.getEBoolean(), "validateAttributesAssociations", 1, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theModelPackage_1.getProject(), "project", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(pullUpOperationEClass, PullUpOperation.class, "PullUpOperation", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getPullUpOperation_SuperClass(), theModelPackage_1.getModelElementId(), null, "superClass", null, 1, 1, PullUpOperation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getPullUpOperation_Attributes(), theModelPackage_1.getModelElementId(), null, "attributes", null, 0, -1, PullUpOperation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getPullUpOperation_OutgoingAssociations(), theModelPackage_1.getModelElementId(), null, "outgoingAssociations", null, 0, -1, PullUpOperation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getPullUpOperation_IncomingAssociations(), theModelPackage_1.getModelElementId(), null, "incomingAssociations", null, 0, -1, PullUpOperation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		op = addEOperation(pullUpOperationEClass, theClassesPackage.getClass_(), "getSuperClass", 1, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theModelPackage_1.getProject(), "project", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(pullUpOperationEClass, theClassesPackage.getClass_(), "getPossibleSuperClasses", 0, -1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theModelPackage_1.getProject(), "project", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(pullUpOperationEClass, theClassesPackage.getAttribute(), "getAttributes", 0, -1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theModelPackage_1.getProject(), "project", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(pullUpOperationEClass, theClassesPackage.getAttribute(), "getPossibleAttributes", 0, -1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theModelPackage_1.getProject(), "project", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(pullUpOperationEClass, theClassesPackage.getAssociation(), "getOutgoingAssociations", 0, -1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theModelPackage_1.getProject(), "project", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(pullUpOperationEClass, theClassesPackage.getAssociation(), "getPossibleOutgoingAssociations", 0, -1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theModelPackage_1.getProject(), "project", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(pullUpOperationEClass, theClassesPackage.getAssociation(), "getIncomingAssociations", 0, -1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theModelPackage_1.getProject(), "project", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(pullUpOperationEClass, theClassesPackage.getAssociation(), "getPossibleIncomingAssociations", 0, -1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theModelPackage_1.getProject(), "project", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(pullUpOperationEClass, ecorePackage.getEBoolean(), "validateAttributesAssociations", 1, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theModelPackage_1.getProject(), "project", 0, 1, IS_UNIQUE, IS_ORDERED);

		// Create resource
		createResource(eNS_URI);

		// Create annotations
		// http://unicase.org/operations
		createOperationsAnnotations();
	}

	/**
	 * Initializes the annotations for <b>http://unicase.org/operations</b>. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @generated
	 */
	protected void createOperationsAnnotations() {
		String source = "http://unicase.org/operations";	
		addAnnotation
		  (extractSuperClassOperationEClass, 
		   source, 
		   new String[] {
			 "description", "Attributes and associations from a number of classes are extracted into a common super class.",
			 "label", "Extract Super Class"
		   });	
		addAnnotation
		  (extractSuperClassOperationEClass.getEOperations().get(10), 
		   source, 
		   new String[] {
			 "description", "A class or enumeration with that name already exists."
		   });	
		addAnnotation
		  (inlineSuperClassOperationEClass, 
		   source, 
		   new String[] {
			 "description", "A super class is inlined into its sub classes.",
			 "label", "Inline Super Class"
		   });	
		addAnnotation
		  (inlineSuperClassOperationEClass.getEOperations().get(1), 
		   source, 
		   new String[] {
			 "description", "The super class must have sub classes."
		   });	
		addAnnotation
		  (extractClassOperationEClass, 
		   source, 
		   new String[] {
			 "description", "A set of attributes and associations are extracted to a new class which is reachable trough a composition.",
			 "label", "Extract Class"
		   });	
		addAnnotation
		  (extractClassOperationEClass.getEOperations().get(8), 
		   source, 
		   new String[] {
			 "description", "A class or enumeration with that name already exists."
		   });	
		addAnnotation
		  (extractClassOperationEClass.getEOperations().get(9), 
		   source, 
		   new String[] {
			 "description", "An attribute or association with that name already exists."
		   });	
		addAnnotation
		  (inlineClassOperationEClass, 
		   source, 
		   new String[] {
			 "description", "A class reachable through a single-valued composition is inlined.",
			 "label", "Inline Class"
		   });	
		addAnnotation
		  (inlineClassOperationEClass.getEOperations().get(4), 
		   source, 
		   new String[] {
			 "description", "The association must be a composition."
		   });	
		addAnnotation
		  (inlineClassOperationEClass.getEOperations().get(5), 
		   source, 
		   new String[] {
			 "description", "The multiplicity of the association must be 1-to-1."
		   });	
		addAnnotation
		  (inlineClassOperationEClass.getEOperations().get(6), 
		   source, 
		   new String[] {
			 "description", "The class to be inlined must not have sub classes."
		   });	
		addAnnotation
		  (inlineClassOperationEClass.getEOperations().get(7), 
		   source, 
		   new String[] {
			 "description", "The class to be inlined must not be target of another association."
		   });	
		addAnnotation
		  (partitionAssociationOperationEClass, 
		   source, 
		   new String[] {
			 "description", "An association to an abstract class is partitioned into seperate associations for every subclass.",
			 "label", "Partition Association"
		   });	
		addAnnotation
		  (partitionAssociationOperationEClass.getEOperations().get(1), 
		   source, 
		   new String[] {
			 "description", "The type of the reference must be abstract and must have sub classes."
		   });	
		addAnnotation
		  (partitionAssociationOperationEClass.getEOperations().get(2), 
		   source, 
		   new String[] {
			 "description", "The reference must be multi-valued."
		   });	
		addAnnotation
		  (pushDownOperationEClass, 
		   source, 
		   new String[] {
			 "description", "Attributes and associations are pushed down to sub classes.",
			 "label", "Push Down Attributes and Associations"
		   });	
		addAnnotation
		  (pushDownOperationEClass.getEOperations().get(7), 
		   source, 
		   new String[] {
			 "description", "The attribute\'s defining class must have sub classes."
		   });	
		addAnnotation
		  (pushDownOperationEClass.getEOperations().get(8), 
		   source, 
		   new String[] {
			 "description", "At least one attribute or association must be pushed down."
		   });	
		addAnnotation
		  (pullUpOperationEClass, 
		   source, 
		   new String[] {
			 "description", "Attributes and associations are pulled up into a common super class.",
			 "label", "Pull Up Attributes and Associations"
		   });	
		addAnnotation
		  (pullUpOperationEClass.getEOperations().get(8), 
		   source, 
		   new String[] {
			 "description", "At least one attribute or association must be pulled up."
		   });
	}

} // OperationsPackageImpl
