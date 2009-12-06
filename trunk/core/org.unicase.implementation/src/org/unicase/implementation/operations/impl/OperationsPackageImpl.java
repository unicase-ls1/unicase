/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.implementation.operations.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.impl.EPackageImpl;
import org.unicase.emfstore.esmodel.versioning.operations.semantic.SemanticPackage;
import org.unicase.implementation.operations.ExtractSuperClassOperation;
import org.unicase.implementation.operations.InlineClassOperation;
import org.unicase.implementation.operations.OperationsFactory;
import org.unicase.implementation.operations.OperationsPackage;
import org.unicase.implementation.operations.PartitionAssociationOperation;
import org.unicase.implementation.operations.PushDownAttributeOperation;
import org.unicase.metamodel.MetamodelPackage;
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
	private EClass inlineClassOperationEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass partitionAssociationOperationEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass pushDownAttributeOperationEClass = null;

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
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getExtractSuperClassOperation_Attributes() {
		return (EReference)extractSuperClassOperationEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getExtractSuperClassOperation_Associations() {
		return (EReference)extractSuperClassOperationEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getExtractSuperClassOperation_SuperClassName() {
		return (EAttribute)extractSuperClassOperationEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getExtractSuperClassOperation_TargetPackage() {
		return (EReference)extractSuperClassOperationEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getExtractSuperClassOperation_SuperSuperClasses() {
		return (EReference)extractSuperClassOperationEClass.getEStructuralFeatures().get(5);
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
	public EClass getPushDownAttributeOperation() {
		return pushDownAttributeOperationEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPushDownAttributeOperation_Attribute() {
		return (EReference)pushDownAttributeOperationEClass.getEStructuralFeatures().get(0);
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
		createEReference(extractSuperClassOperationEClass, EXTRACT_SUPER_CLASS_OPERATION__ASSOCIATIONS);
		createEAttribute(extractSuperClassOperationEClass, EXTRACT_SUPER_CLASS_OPERATION__SUPER_CLASS_NAME);
		createEReference(extractSuperClassOperationEClass, EXTRACT_SUPER_CLASS_OPERATION__TARGET_PACKAGE);
		createEReference(extractSuperClassOperationEClass, EXTRACT_SUPER_CLASS_OPERATION__SUPER_SUPER_CLASSES);

		inlineClassOperationEClass = createEClass(INLINE_CLASS_OPERATION);
		createEReference(inlineClassOperationEClass, INLINE_CLASS_OPERATION__ASSOCIATION);

		partitionAssociationOperationEClass = createEClass(PARTITION_ASSOCIATION_OPERATION);
		createEReference(partitionAssociationOperationEClass, PARTITION_ASSOCIATION_OPERATION__ASSOCIATION);

		pushDownAttributeOperationEClass = createEClass(PUSH_DOWN_ATTRIBUTE_OPERATION);
		createEReference(pushDownAttributeOperationEClass, PUSH_DOWN_ATTRIBUTE_OPERATION__ATTRIBUTE);
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
		SemanticPackage theSemanticPackage = (SemanticPackage)EPackage.Registry.INSTANCE.getEPackage(SemanticPackage.eNS_URI);
		MetamodelPackage theMetamodelPackage = (MetamodelPackage)EPackage.Registry.INSTANCE.getEPackage(MetamodelPackage.eNS_URI);
		ClassesPackage theClassesPackage = (ClassesPackage)EPackage.Registry.INSTANCE.getEPackage(ClassesPackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		extractSuperClassOperationEClass.getESuperTypes().add(theSemanticPackage.getSemanticCompositeOperation());
		inlineClassOperationEClass.getESuperTypes().add(theSemanticPackage.getSemanticCompositeOperation());
		partitionAssociationOperationEClass.getESuperTypes().add(theSemanticPackage.getSemanticCompositeOperation());
		pushDownAttributeOperationEClass.getESuperTypes().add(theSemanticPackage.getSemanticCompositeOperation());

		// Initialize classes and features; add operations and parameters
		initEClass(extractSuperClassOperationEClass, ExtractSuperClassOperation.class, "ExtractSuperClassOperation", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getExtractSuperClassOperation_SubClasses(), theMetamodelPackage.getModelElementId(), null, "subClasses", null, 1, -1, ExtractSuperClassOperation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getExtractSuperClassOperation_Attributes(), theMetamodelPackage.getModelElementId(), null, "attributes", null, 0, -1, ExtractSuperClassOperation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getExtractSuperClassOperation_Associations(), theMetamodelPackage.getModelElementId(), null, "associations", null, 0, -1, ExtractSuperClassOperation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getExtractSuperClassOperation_SuperClassName(), ecorePackage.getEString(), "superClassName", null, 1, 1, ExtractSuperClassOperation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getExtractSuperClassOperation_TargetPackage(), theMetamodelPackage.getModelElementId(), null, "targetPackage", null, 1, 1, ExtractSuperClassOperation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getExtractSuperClassOperation_SuperSuperClasses(), theMetamodelPackage.getModelElementId(), null, "superSuperClasses", null, 0, -1, ExtractSuperClassOperation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		EOperation op = addEOperation(extractSuperClassOperationEClass, theClassesPackage.getClass_(), "getSubClasses", 1, -1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theMetamodelPackage.getProject(), "project", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(extractSuperClassOperationEClass, theClassesPackage.getAttribute(), "getAttributes", 0, -1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theMetamodelPackage.getProject(), "project", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(extractSuperClassOperationEClass, theClassesPackage.getAttribute(), "getPossibleAttributes", 0, -1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theMetamodelPackage.getProject(), "project", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(extractSuperClassOperationEClass, theClassesPackage.getAssociation(), "getAssociations", 0, -1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theMetamodelPackage.getProject(), "project", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(extractSuperClassOperationEClass, theClassesPackage.getAssociation(), "getPossibleAssociations", 0, -1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theMetamodelPackage.getProject(), "project", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(extractSuperClassOperationEClass, theClassesPackage.getPackage(), "getTargetPackage", 1, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theMetamodelPackage.getProject(), "project", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(extractSuperClassOperationEClass, theClassesPackage.getClass_(), "getSuperSuperClasses", 0, -1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theMetamodelPackage.getProject(), "project", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(extractSuperClassOperationEClass, theClassesPackage.getClass_(), "getPossibleSuperSuperClasses", 0, -1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theMetamodelPackage.getProject(), "project", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(extractSuperClassOperationEClass, ecorePackage.getEBoolean(), "validateSuperClassName", 1, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theMetamodelPackage.getProject(), "project", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(inlineClassOperationEClass, InlineClassOperation.class, "InlineClassOperation", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getInlineClassOperation_Association(), theMetamodelPackage.getModelElementId(), null, "association", null, 1, 1, InlineClassOperation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		op = addEOperation(inlineClassOperationEClass, theClassesPackage.getAssociation(), "getAssociation", 1, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theMetamodelPackage.getProject(), "project", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(inlineClassOperationEClass, ecorePackage.getEBoolean(), "validateAssociationComposition", 1, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theMetamodelPackage.getProject(), "project", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(inlineClassOperationEClass, ecorePackage.getEBoolean(), "validateAssociationMultiplicity", 1, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theMetamodelPackage.getProject(), "project", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(inlineClassOperationEClass, ecorePackage.getEBoolean(), "validateInlineClassSubClasses", 1, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theMetamodelPackage.getProject(), "project", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(inlineClassOperationEClass, ecorePackage.getEBoolean(), "validateInlineClassAssociationTarget", 1, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theMetamodelPackage.getProject(), "project", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(partitionAssociationOperationEClass, PartitionAssociationOperation.class, "PartitionAssociationOperation", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getPartitionAssociationOperation_Association(), theMetamodelPackage.getModelElementId(), null, "association", null, 1, 1, PartitionAssociationOperation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		op = addEOperation(partitionAssociationOperationEClass, theClassesPackage.getAssociation(), "getAssociation", 1, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theMetamodelPackage.getProject(), "project", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(partitionAssociationOperationEClass, ecorePackage.getEBoolean(), "validateAssociationTarget", 1, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theMetamodelPackage.getProject(), "project", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(partitionAssociationOperationEClass, ecorePackage.getEBoolean(), "validateAssociationMultiplicity", 1, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theMetamodelPackage.getProject(), "project", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(pushDownAttributeOperationEClass, PushDownAttributeOperation.class, "PushDownAttributeOperation", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getPushDownAttributeOperation_Attribute(), theMetamodelPackage.getModelElementId(), null, "attribute", null, 1, 1, PushDownAttributeOperation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		op = addEOperation(pushDownAttributeOperationEClass, theClassesPackage.getAttribute(), "getAttribute", 1, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theMetamodelPackage.getProject(), "project", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(pushDownAttributeOperationEClass, ecorePackage.getEBoolean(), "validateContextClassSubClasses", 1, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theMetamodelPackage.getProject(), "project", 0, 1, IS_UNIQUE, IS_ORDERED);

		// Create resource
		createResource(eNS_URI);

		// Create annotations
		// http://www.eclipse.org/emf/2002/Ecore
		createEcoreAnnotations();
	}

	/**
	 * Initializes the annotations for <b>http://www.eclipse.org/emf/2002/Ecore</b>.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 */
	protected void createEcoreAnnotations() {
		String source = "http://www.eclipse.org/emf/2002/Ecore";		
		addAnnotation
		  (extractSuperClassOperationEClass, 
		   source, 
		   new String[] {
			 "documentation", "Extract attributes and associations from a number of classes into a common super class."
		   });							
		addAnnotation
		  (extractSuperClassOperationEClass.getEOperations().get(8), 
		   source, 
		   new String[] {
			 "documentation", "A class or enumeration with that name already exists."
		   });			
		addAnnotation
		  (inlineClassOperationEClass.getEOperations().get(1), 
		   source, 
		   new String[] {
			 "documentation", "The association must be a composition."
		   });		
		addAnnotation
		  (inlineClassOperationEClass.getEOperations().get(2), 
		   source, 
		   new String[] {
			 "documentation", "The multiplicity of the association must be 1-to-1."
		   });		
		addAnnotation
		  (inlineClassOperationEClass.getEOperations().get(3), 
		   source, 
		   new String[] {
			 "documentation", "The class to be inlined must not have sub classes."
		   });		
		addAnnotation
		  (inlineClassOperationEClass.getEOperations().get(4), 
		   source, 
		   new String[] {
			 "documentation", "The class to be inlined must not be target of another association."
		   });			
		addAnnotation
		  (partitionAssociationOperationEClass.getEOperations().get(1), 
		   source, 
		   new String[] {
			 "documentation", "The type of the reference must be abstract and must have sub classes."
		   });		
		addAnnotation
		  (partitionAssociationOperationEClass.getEOperations().get(2), 
		   source, 
		   new String[] {
			 "documentation", "The reference must be multi-valued."
		   });			
		addAnnotation
		  (pushDownAttributeOperationEClass.getEOperations().get(1), 
		   source, 
		   new String[] {
			 "documentation", "The attribute\'s defining class must have sub classes.\r\n"
		   });
	}

} // OperationsPackageImpl
