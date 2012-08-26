/**
 * <copyright> Copyright (c) 2009-2012 Chair of Applied Software Engineering, Technische Universität München (TUM).
 * All rights reserved. This program and the accompanying materials are made available under the terms of
 * the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.implementation.operations;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.emfstore.server.model.versioning.operations.semantic.SemanticPackage;

/**
 * <!-- begin-user-doc --> The <b>Package</b> for the model. It contains accessors for the meta objects to represent
 * <ul>
 * <li>each class,</li>
 * <li>each feature of each class,</li>
 * <li>each enum,</li>
 * <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * 
 * @see org.unicase.implementation.operations.OperationsFactory
 * @model kind="package"
 * @generated
 */
public interface OperationsPackage extends EPackage {
	/**
	 * The package name. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	String eNAME = "operations";

	/**
	 * The package namespace URI. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	String eNS_URI = "http://unicase.org/operations";

	/**
	 * The package namespace name. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	String eNS_PREFIX = "operations";

	/**
	 * The singleton instance of the package. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	OperationsPackage eINSTANCE = org.unicase.implementation.operations.impl.OperationsPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.unicase.implementation.operations.impl.ExtractSuperClassOperationImpl
	 * <em>Extract Super Class Operation</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see org.unicase.implementation.operations.impl.ExtractSuperClassOperationImpl
	 * @see org.unicase.implementation.operations.impl.OperationsPackageImpl#getExtractSuperClassOperation()
	 * @generated
	 */
	int EXTRACT_SUPER_CLASS_OPERATION = 0;

	/**
	 * The feature id for the '<em><b>Identifier</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int EXTRACT_SUPER_CLASS_OPERATION__IDENTIFIER = SemanticPackage.SEMANTIC_COMPOSITE_OPERATION__IDENTIFIER;

	/**
	 * The feature id for the '<em><b>Model Element Id</b></em>' containment reference. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int EXTRACT_SUPER_CLASS_OPERATION__MODEL_ELEMENT_ID = SemanticPackage.SEMANTIC_COMPOSITE_OPERATION__MODEL_ELEMENT_ID;

	/**
	 * The feature id for the '<em><b>Accepted</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int EXTRACT_SUPER_CLASS_OPERATION__ACCEPTED = SemanticPackage.SEMANTIC_COMPOSITE_OPERATION__ACCEPTED;

	/**
	 * The feature id for the '<em><b>Client Date</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int EXTRACT_SUPER_CLASS_OPERATION__CLIENT_DATE = SemanticPackage.SEMANTIC_COMPOSITE_OPERATION__CLIENT_DATE;

	/**
	 * The feature id for the '<em><b>Sub Operations</b></em>' containment reference list. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int EXTRACT_SUPER_CLASS_OPERATION__SUB_OPERATIONS = SemanticPackage.SEMANTIC_COMPOSITE_OPERATION__SUB_OPERATIONS;

	/**
	 * The feature id for the '<em><b>Main Operation</b></em>' reference. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int EXTRACT_SUPER_CLASS_OPERATION__MAIN_OPERATION = SemanticPackage.SEMANTIC_COMPOSITE_OPERATION__MAIN_OPERATION;

	/**
	 * The feature id for the '<em><b>Composite Name</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int EXTRACT_SUPER_CLASS_OPERATION__COMPOSITE_NAME = SemanticPackage.SEMANTIC_COMPOSITE_OPERATION__COMPOSITE_NAME;

	/**
	 * The feature id for the '<em><b>Composite Description</b></em>' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int EXTRACT_SUPER_CLASS_OPERATION__COMPOSITE_DESCRIPTION = SemanticPackage.SEMANTIC_COMPOSITE_OPERATION__COMPOSITE_DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Reversed</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int EXTRACT_SUPER_CLASS_OPERATION__REVERSED = SemanticPackage.SEMANTIC_COMPOSITE_OPERATION__REVERSED;

	/**
	 * The feature id for the '<em><b>Sub Classes</b></em>' containment reference list. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int EXTRACT_SUPER_CLASS_OPERATION__SUB_CLASSES = SemanticPackage.SEMANTIC_COMPOSITE_OPERATION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Attributes</b></em>' containment reference list. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int EXTRACT_SUPER_CLASS_OPERATION__ATTRIBUTES = SemanticPackage.SEMANTIC_COMPOSITE_OPERATION_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Outgoing Associations</b></em>' containment reference list. <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int EXTRACT_SUPER_CLASS_OPERATION__OUTGOING_ASSOCIATIONS = SemanticPackage.SEMANTIC_COMPOSITE_OPERATION_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Incoming Associations</b></em>' containment reference list. <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int EXTRACT_SUPER_CLASS_OPERATION__INCOMING_ASSOCIATIONS = SemanticPackage.SEMANTIC_COMPOSITE_OPERATION_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Super Class Name</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @generated
	 * @ordered
	 */
	int EXTRACT_SUPER_CLASS_OPERATION__SUPER_CLASS_NAME = SemanticPackage.SEMANTIC_COMPOSITE_OPERATION_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Target Package</b></em>' containment reference. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int EXTRACT_SUPER_CLASS_OPERATION__TARGET_PACKAGE = SemanticPackage.SEMANTIC_COMPOSITE_OPERATION_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Super Super Classes</b></em>' containment reference list. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int EXTRACT_SUPER_CLASS_OPERATION__SUPER_SUPER_CLASSES = SemanticPackage.SEMANTIC_COMPOSITE_OPERATION_FEATURE_COUNT + 6;

	/**
	 * The number of structural features of the '<em>Extract Super Class Operation</em>' class. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int EXTRACT_SUPER_CLASS_OPERATION_FEATURE_COUNT = SemanticPackage.SEMANTIC_COMPOSITE_OPERATION_FEATURE_COUNT + 7;

	/**
	 * The meta object id for the '{@link org.unicase.implementation.operations.impl.InlineSuperClassOperationImpl
	 * <em>Inline Super Class Operation</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see org.unicase.implementation.operations.impl.InlineSuperClassOperationImpl
	 * @see org.unicase.implementation.operations.impl.OperationsPackageImpl#getInlineSuperClassOperation()
	 * @generated
	 */
	int INLINE_SUPER_CLASS_OPERATION = 1;

	/**
	 * The feature id for the '<em><b>Identifier</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int INLINE_SUPER_CLASS_OPERATION__IDENTIFIER = SemanticPackage.SEMANTIC_COMPOSITE_OPERATION__IDENTIFIER;

	/**
	 * The feature id for the '<em><b>Model Element Id</b></em>' containment reference. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int INLINE_SUPER_CLASS_OPERATION__MODEL_ELEMENT_ID = SemanticPackage.SEMANTIC_COMPOSITE_OPERATION__MODEL_ELEMENT_ID;

	/**
	 * The feature id for the '<em><b>Accepted</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int INLINE_SUPER_CLASS_OPERATION__ACCEPTED = SemanticPackage.SEMANTIC_COMPOSITE_OPERATION__ACCEPTED;

	/**
	 * The feature id for the '<em><b>Client Date</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int INLINE_SUPER_CLASS_OPERATION__CLIENT_DATE = SemanticPackage.SEMANTIC_COMPOSITE_OPERATION__CLIENT_DATE;

	/**
	 * The feature id for the '<em><b>Sub Operations</b></em>' containment reference list. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int INLINE_SUPER_CLASS_OPERATION__SUB_OPERATIONS = SemanticPackage.SEMANTIC_COMPOSITE_OPERATION__SUB_OPERATIONS;

	/**
	 * The feature id for the '<em><b>Main Operation</b></em>' reference. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int INLINE_SUPER_CLASS_OPERATION__MAIN_OPERATION = SemanticPackage.SEMANTIC_COMPOSITE_OPERATION__MAIN_OPERATION;

	/**
	 * The feature id for the '<em><b>Composite Name</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int INLINE_SUPER_CLASS_OPERATION__COMPOSITE_NAME = SemanticPackage.SEMANTIC_COMPOSITE_OPERATION__COMPOSITE_NAME;

	/**
	 * The feature id for the '<em><b>Composite Description</b></em>' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int INLINE_SUPER_CLASS_OPERATION__COMPOSITE_DESCRIPTION = SemanticPackage.SEMANTIC_COMPOSITE_OPERATION__COMPOSITE_DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Reversed</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int INLINE_SUPER_CLASS_OPERATION__REVERSED = SemanticPackage.SEMANTIC_COMPOSITE_OPERATION__REVERSED;

	/**
	 * The feature id for the '<em><b>Super Class</b></em>' containment reference. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int INLINE_SUPER_CLASS_OPERATION__SUPER_CLASS = SemanticPackage.SEMANTIC_COMPOSITE_OPERATION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Inline Super Class Operation</em>' class. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int INLINE_SUPER_CLASS_OPERATION_FEATURE_COUNT = SemanticPackage.SEMANTIC_COMPOSITE_OPERATION_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.unicase.implementation.operations.impl.InlineClassOperationImpl
	 * <em>Inline Class Operation</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see org.unicase.implementation.operations.impl.InlineClassOperationImpl
	 * @see org.unicase.implementation.operations.impl.OperationsPackageImpl#getInlineClassOperation()
	 * @generated
	 */
	int INLINE_CLASS_OPERATION = 3;

	/**
	 * The meta object id for the '{@link org.unicase.implementation.operations.impl.ExtractClassOperationImpl
	 * <em>Extract Class Operation</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see org.unicase.implementation.operations.impl.ExtractClassOperationImpl
	 * @see org.unicase.implementation.operations.impl.OperationsPackageImpl#getExtractClassOperation()
	 * @generated
	 */
	int EXTRACT_CLASS_OPERATION = 2;

	/**
	 * The feature id for the '<em><b>Identifier</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int EXTRACT_CLASS_OPERATION__IDENTIFIER = SemanticPackage.SEMANTIC_COMPOSITE_OPERATION__IDENTIFIER;

	/**
	 * The feature id for the '<em><b>Model Element Id</b></em>' containment reference. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int EXTRACT_CLASS_OPERATION__MODEL_ELEMENT_ID = SemanticPackage.SEMANTIC_COMPOSITE_OPERATION__MODEL_ELEMENT_ID;

	/**
	 * The feature id for the '<em><b>Accepted</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int EXTRACT_CLASS_OPERATION__ACCEPTED = SemanticPackage.SEMANTIC_COMPOSITE_OPERATION__ACCEPTED;

	/**
	 * The feature id for the '<em><b>Client Date</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int EXTRACT_CLASS_OPERATION__CLIENT_DATE = SemanticPackage.SEMANTIC_COMPOSITE_OPERATION__CLIENT_DATE;

	/**
	 * The feature id for the '<em><b>Sub Operations</b></em>' containment reference list. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int EXTRACT_CLASS_OPERATION__SUB_OPERATIONS = SemanticPackage.SEMANTIC_COMPOSITE_OPERATION__SUB_OPERATIONS;

	/**
	 * The feature id for the '<em><b>Main Operation</b></em>' reference. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int EXTRACT_CLASS_OPERATION__MAIN_OPERATION = SemanticPackage.SEMANTIC_COMPOSITE_OPERATION__MAIN_OPERATION;

	/**
	 * The feature id for the '<em><b>Composite Name</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int EXTRACT_CLASS_OPERATION__COMPOSITE_NAME = SemanticPackage.SEMANTIC_COMPOSITE_OPERATION__COMPOSITE_NAME;

	/**
	 * The feature id for the '<em><b>Composite Description</b></em>' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int EXTRACT_CLASS_OPERATION__COMPOSITE_DESCRIPTION = SemanticPackage.SEMANTIC_COMPOSITE_OPERATION__COMPOSITE_DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Reversed</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int EXTRACT_CLASS_OPERATION__REVERSED = SemanticPackage.SEMANTIC_COMPOSITE_OPERATION__REVERSED;

	/**
	 * The feature id for the '<em><b>Context Class</b></em>' containment reference. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int EXTRACT_CLASS_OPERATION__CONTEXT_CLASS = SemanticPackage.SEMANTIC_COMPOSITE_OPERATION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Attributes</b></em>' containment reference list. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int EXTRACT_CLASS_OPERATION__ATTRIBUTES = SemanticPackage.SEMANTIC_COMPOSITE_OPERATION_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Outgoing Associations</b></em>' containment reference list. <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int EXTRACT_CLASS_OPERATION__OUTGOING_ASSOCIATIONS = SemanticPackage.SEMANTIC_COMPOSITE_OPERATION_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Incoming Associations</b></em>' containment reference list. <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int EXTRACT_CLASS_OPERATION__INCOMING_ASSOCIATIONS = SemanticPackage.SEMANTIC_COMPOSITE_OPERATION_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Composition Name</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @generated
	 * @ordered
	 */
	int EXTRACT_CLASS_OPERATION__COMPOSITION_NAME = SemanticPackage.SEMANTIC_COMPOSITE_OPERATION_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Class Name</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int EXTRACT_CLASS_OPERATION__CLASS_NAME = SemanticPackage.SEMANTIC_COMPOSITE_OPERATION_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Target Package</b></em>' containment reference. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int EXTRACT_CLASS_OPERATION__TARGET_PACKAGE = SemanticPackage.SEMANTIC_COMPOSITE_OPERATION_FEATURE_COUNT + 6;

	/**
	 * The number of structural features of the '<em>Extract Class Operation</em>' class. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int EXTRACT_CLASS_OPERATION_FEATURE_COUNT = SemanticPackage.SEMANTIC_COMPOSITE_OPERATION_FEATURE_COUNT + 7;

	/**
	 * The feature id for the '<em><b>Identifier</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int INLINE_CLASS_OPERATION__IDENTIFIER = SemanticPackage.SEMANTIC_COMPOSITE_OPERATION__IDENTIFIER;

	/**
	 * The feature id for the '<em><b>Model Element Id</b></em>' containment reference. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int INLINE_CLASS_OPERATION__MODEL_ELEMENT_ID = SemanticPackage.SEMANTIC_COMPOSITE_OPERATION__MODEL_ELEMENT_ID;

	/**
	 * The feature id for the '<em><b>Accepted</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int INLINE_CLASS_OPERATION__ACCEPTED = SemanticPackage.SEMANTIC_COMPOSITE_OPERATION__ACCEPTED;

	/**
	 * The feature id for the '<em><b>Client Date</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int INLINE_CLASS_OPERATION__CLIENT_DATE = SemanticPackage.SEMANTIC_COMPOSITE_OPERATION__CLIENT_DATE;

	/**
	 * The feature id for the '<em><b>Sub Operations</b></em>' containment reference list. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int INLINE_CLASS_OPERATION__SUB_OPERATIONS = SemanticPackage.SEMANTIC_COMPOSITE_OPERATION__SUB_OPERATIONS;

	/**
	 * The feature id for the '<em><b>Main Operation</b></em>' reference. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int INLINE_CLASS_OPERATION__MAIN_OPERATION = SemanticPackage.SEMANTIC_COMPOSITE_OPERATION__MAIN_OPERATION;

	/**
	 * The feature id for the '<em><b>Composite Name</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int INLINE_CLASS_OPERATION__COMPOSITE_NAME = SemanticPackage.SEMANTIC_COMPOSITE_OPERATION__COMPOSITE_NAME;

	/**
	 * The feature id for the '<em><b>Composite Description</b></em>' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int INLINE_CLASS_OPERATION__COMPOSITE_DESCRIPTION = SemanticPackage.SEMANTIC_COMPOSITE_OPERATION__COMPOSITE_DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Reversed</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int INLINE_CLASS_OPERATION__REVERSED = SemanticPackage.SEMANTIC_COMPOSITE_OPERATION__REVERSED;

	/**
	 * The feature id for the '<em><b>Association</b></em>' containment reference. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int INLINE_CLASS_OPERATION__ASSOCIATION = SemanticPackage.SEMANTIC_COMPOSITE_OPERATION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Inline Class</b></em>' containment reference. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int INLINE_CLASS_OPERATION__INLINE_CLASS = SemanticPackage.SEMANTIC_COMPOSITE_OPERATION_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Inline Class Operation</em>' class. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int INLINE_CLASS_OPERATION_FEATURE_COUNT = SemanticPackage.SEMANTIC_COMPOSITE_OPERATION_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.unicase.implementation.operations.impl.PartitionAssociationOperationImpl
	 * <em>Partition Association Operation</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see org.unicase.implementation.operations.impl.PartitionAssociationOperationImpl
	 * @see org.unicase.implementation.operations.impl.OperationsPackageImpl#getPartitionAssociationOperation()
	 * @generated
	 */
	int PARTITION_ASSOCIATION_OPERATION = 4;

	/**
	 * The feature id for the '<em><b>Identifier</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int PARTITION_ASSOCIATION_OPERATION__IDENTIFIER = SemanticPackage.SEMANTIC_COMPOSITE_OPERATION__IDENTIFIER;

	/**
	 * The feature id for the '<em><b>Model Element Id</b></em>' containment reference. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int PARTITION_ASSOCIATION_OPERATION__MODEL_ELEMENT_ID = SemanticPackage.SEMANTIC_COMPOSITE_OPERATION__MODEL_ELEMENT_ID;

	/**
	 * The feature id for the '<em><b>Accepted</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int PARTITION_ASSOCIATION_OPERATION__ACCEPTED = SemanticPackage.SEMANTIC_COMPOSITE_OPERATION__ACCEPTED;

	/**
	 * The feature id for the '<em><b>Client Date</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int PARTITION_ASSOCIATION_OPERATION__CLIENT_DATE = SemanticPackage.SEMANTIC_COMPOSITE_OPERATION__CLIENT_DATE;

	/**
	 * The feature id for the '<em><b>Sub Operations</b></em>' containment reference list. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int PARTITION_ASSOCIATION_OPERATION__SUB_OPERATIONS = SemanticPackage.SEMANTIC_COMPOSITE_OPERATION__SUB_OPERATIONS;

	/**
	 * The feature id for the '<em><b>Main Operation</b></em>' reference. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int PARTITION_ASSOCIATION_OPERATION__MAIN_OPERATION = SemanticPackage.SEMANTIC_COMPOSITE_OPERATION__MAIN_OPERATION;

	/**
	 * The feature id for the '<em><b>Composite Name</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int PARTITION_ASSOCIATION_OPERATION__COMPOSITE_NAME = SemanticPackage.SEMANTIC_COMPOSITE_OPERATION__COMPOSITE_NAME;

	/**
	 * The feature id for the '<em><b>Composite Description</b></em>' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int PARTITION_ASSOCIATION_OPERATION__COMPOSITE_DESCRIPTION = SemanticPackage.SEMANTIC_COMPOSITE_OPERATION__COMPOSITE_DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Reversed</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int PARTITION_ASSOCIATION_OPERATION__REVERSED = SemanticPackage.SEMANTIC_COMPOSITE_OPERATION__REVERSED;

	/**
	 * The feature id for the '<em><b>Association</b></em>' containment reference. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int PARTITION_ASSOCIATION_OPERATION__ASSOCIATION = SemanticPackage.SEMANTIC_COMPOSITE_OPERATION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Partition Association Operation</em>' class. <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int PARTITION_ASSOCIATION_OPERATION_FEATURE_COUNT = SemanticPackage.SEMANTIC_COMPOSITE_OPERATION_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.unicase.implementation.operations.impl.PushDownOperationImpl
	 * <em>Push Down Operation</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see org.unicase.implementation.operations.impl.PushDownOperationImpl
	 * @see org.unicase.implementation.operations.impl.OperationsPackageImpl#getPushDownOperation()
	 * @generated
	 */
	int PUSH_DOWN_OPERATION = 5;

	/**
	 * The feature id for the '<em><b>Identifier</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int PUSH_DOWN_OPERATION__IDENTIFIER = SemanticPackage.SEMANTIC_COMPOSITE_OPERATION__IDENTIFIER;

	/**
	 * The feature id for the '<em><b>Model Element Id</b></em>' containment reference. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int PUSH_DOWN_OPERATION__MODEL_ELEMENT_ID = SemanticPackage.SEMANTIC_COMPOSITE_OPERATION__MODEL_ELEMENT_ID;

	/**
	 * The feature id for the '<em><b>Accepted</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int PUSH_DOWN_OPERATION__ACCEPTED = SemanticPackage.SEMANTIC_COMPOSITE_OPERATION__ACCEPTED;

	/**
	 * The feature id for the '<em><b>Client Date</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int PUSH_DOWN_OPERATION__CLIENT_DATE = SemanticPackage.SEMANTIC_COMPOSITE_OPERATION__CLIENT_DATE;

	/**
	 * The feature id for the '<em><b>Sub Operations</b></em>' containment reference list. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int PUSH_DOWN_OPERATION__SUB_OPERATIONS = SemanticPackage.SEMANTIC_COMPOSITE_OPERATION__SUB_OPERATIONS;

	/**
	 * The feature id for the '<em><b>Main Operation</b></em>' reference. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int PUSH_DOWN_OPERATION__MAIN_OPERATION = SemanticPackage.SEMANTIC_COMPOSITE_OPERATION__MAIN_OPERATION;

	/**
	 * The feature id for the '<em><b>Composite Name</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int PUSH_DOWN_OPERATION__COMPOSITE_NAME = SemanticPackage.SEMANTIC_COMPOSITE_OPERATION__COMPOSITE_NAME;

	/**
	 * The feature id for the '<em><b>Composite Description</b></em>' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int PUSH_DOWN_OPERATION__COMPOSITE_DESCRIPTION = SemanticPackage.SEMANTIC_COMPOSITE_OPERATION__COMPOSITE_DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Reversed</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int PUSH_DOWN_OPERATION__REVERSED = SemanticPackage.SEMANTIC_COMPOSITE_OPERATION__REVERSED;

	/**
	 * The feature id for the '<em><b>Super Class</b></em>' containment reference. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int PUSH_DOWN_OPERATION__SUPER_CLASS = SemanticPackage.SEMANTIC_COMPOSITE_OPERATION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Attributes</b></em>' containment reference list. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int PUSH_DOWN_OPERATION__ATTRIBUTES = SemanticPackage.SEMANTIC_COMPOSITE_OPERATION_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Outgoing Associations</b></em>' containment reference list. <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int PUSH_DOWN_OPERATION__OUTGOING_ASSOCIATIONS = SemanticPackage.SEMANTIC_COMPOSITE_OPERATION_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Incoming Associations</b></em>' containment reference list. <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int PUSH_DOWN_OPERATION__INCOMING_ASSOCIATIONS = SemanticPackage.SEMANTIC_COMPOSITE_OPERATION_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Push Down Operation</em>' class. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int PUSH_DOWN_OPERATION_FEATURE_COUNT = SemanticPackage.SEMANTIC_COMPOSITE_OPERATION_FEATURE_COUNT + 4;

	/**
	 * The meta object id for the '{@link org.unicase.implementation.operations.impl.PullUpOperationImpl
	 * <em>Pull Up Operation</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see org.unicase.implementation.operations.impl.PullUpOperationImpl
	 * @see org.unicase.implementation.operations.impl.OperationsPackageImpl#getPullUpOperation()
	 * @generated
	 */
	int PULL_UP_OPERATION = 6;

	/**
	 * The feature id for the '<em><b>Identifier</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int PULL_UP_OPERATION__IDENTIFIER = SemanticPackage.SEMANTIC_COMPOSITE_OPERATION__IDENTIFIER;

	/**
	 * The feature id for the '<em><b>Model Element Id</b></em>' containment reference. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int PULL_UP_OPERATION__MODEL_ELEMENT_ID = SemanticPackage.SEMANTIC_COMPOSITE_OPERATION__MODEL_ELEMENT_ID;

	/**
	 * The feature id for the '<em><b>Accepted</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int PULL_UP_OPERATION__ACCEPTED = SemanticPackage.SEMANTIC_COMPOSITE_OPERATION__ACCEPTED;

	/**
	 * The feature id for the '<em><b>Client Date</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int PULL_UP_OPERATION__CLIENT_DATE = SemanticPackage.SEMANTIC_COMPOSITE_OPERATION__CLIENT_DATE;

	/**
	 * The feature id for the '<em><b>Sub Operations</b></em>' containment reference list. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int PULL_UP_OPERATION__SUB_OPERATIONS = SemanticPackage.SEMANTIC_COMPOSITE_OPERATION__SUB_OPERATIONS;

	/**
	 * The feature id for the '<em><b>Main Operation</b></em>' reference. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int PULL_UP_OPERATION__MAIN_OPERATION = SemanticPackage.SEMANTIC_COMPOSITE_OPERATION__MAIN_OPERATION;

	/**
	 * The feature id for the '<em><b>Composite Name</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int PULL_UP_OPERATION__COMPOSITE_NAME = SemanticPackage.SEMANTIC_COMPOSITE_OPERATION__COMPOSITE_NAME;

	/**
	 * The feature id for the '<em><b>Composite Description</b></em>' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int PULL_UP_OPERATION__COMPOSITE_DESCRIPTION = SemanticPackage.SEMANTIC_COMPOSITE_OPERATION__COMPOSITE_DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Reversed</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int PULL_UP_OPERATION__REVERSED = SemanticPackage.SEMANTIC_COMPOSITE_OPERATION__REVERSED;

	/**
	 * The feature id for the '<em><b>Super Class</b></em>' containment reference. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int PULL_UP_OPERATION__SUPER_CLASS = SemanticPackage.SEMANTIC_COMPOSITE_OPERATION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Attributes</b></em>' containment reference list. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int PULL_UP_OPERATION__ATTRIBUTES = SemanticPackage.SEMANTIC_COMPOSITE_OPERATION_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Outgoing Associations</b></em>' containment reference list. <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int PULL_UP_OPERATION__OUTGOING_ASSOCIATIONS = SemanticPackage.SEMANTIC_COMPOSITE_OPERATION_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Incoming Associations</b></em>' containment reference list. <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int PULL_UP_OPERATION__INCOMING_ASSOCIATIONS = SemanticPackage.SEMANTIC_COMPOSITE_OPERATION_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Pull Up Operation</em>' class. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int PULL_UP_OPERATION_FEATURE_COUNT = SemanticPackage.SEMANTIC_COMPOSITE_OPERATION_FEATURE_COUNT + 4;

	/**
	 * Returns the meta object for class '{@link org.unicase.implementation.operations.ExtractSuperClassOperation
	 * <em>Extract Super Class Operation</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Extract Super Class Operation</em>'.
	 * @see org.unicase.implementation.operations.ExtractSuperClassOperation
	 * @generated
	 */
	EClass getExtractSuperClassOperation();

	/**
	 * Returns the meta object for the containment reference list '
	 * {@link org.unicase.implementation.operations.ExtractSuperClassOperation#getSubClasses <em>Sub Classes</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the containment reference list '<em>Sub Classes</em>'.
	 * @see org.unicase.implementation.operations.ExtractSuperClassOperation#getSubClasses()
	 * @see #getExtractSuperClassOperation()
	 * @generated
	 */
	EReference getExtractSuperClassOperation_SubClasses();

	/**
	 * Returns the meta object for the containment reference list '
	 * {@link org.unicase.implementation.operations.ExtractSuperClassOperation#getAttributes <em>Attributes</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the containment reference list '<em>Attributes</em>'.
	 * @see org.unicase.implementation.operations.ExtractSuperClassOperation#getAttributes()
	 * @see #getExtractSuperClassOperation()
	 * @generated
	 */
	EReference getExtractSuperClassOperation_Attributes();

	/**
	 * Returns the meta object for the containment reference list '
	 * {@link org.unicase.implementation.operations.ExtractSuperClassOperation#getOutgoingAssociations
	 * <em>Outgoing Associations</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the containment reference list '<em>Outgoing Associations</em>'.
	 * @see org.unicase.implementation.operations.ExtractSuperClassOperation#getOutgoingAssociations()
	 * @see #getExtractSuperClassOperation()
	 * @generated
	 */
	EReference getExtractSuperClassOperation_OutgoingAssociations();

	/**
	 * Returns the meta object for the containment reference list '
	 * {@link org.unicase.implementation.operations.ExtractSuperClassOperation#getIncomingAssociations
	 * <em>Incoming Associations</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the containment reference list '<em>Incoming Associations</em>'.
	 * @see org.unicase.implementation.operations.ExtractSuperClassOperation#getIncomingAssociations()
	 * @see #getExtractSuperClassOperation()
	 * @generated
	 */
	EReference getExtractSuperClassOperation_IncomingAssociations();

	/**
	 * Returns the meta object for the attribute '
	 * {@link org.unicase.implementation.operations.ExtractSuperClassOperation#getSuperClassName
	 * <em>Super Class Name</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Super Class Name</em>'.
	 * @see org.unicase.implementation.operations.ExtractSuperClassOperation#getSuperClassName()
	 * @see #getExtractSuperClassOperation()
	 * @generated
	 */
	EAttribute getExtractSuperClassOperation_SuperClassName();

	/**
	 * Returns the meta object for the containment reference '
	 * {@link org.unicase.implementation.operations.ExtractSuperClassOperation#getTargetPackage <em>Target Package</em>}
	 * '. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the containment reference '<em>Target Package</em>'.
	 * @see org.unicase.implementation.operations.ExtractSuperClassOperation#getTargetPackage()
	 * @see #getExtractSuperClassOperation()
	 * @generated
	 */
	EReference getExtractSuperClassOperation_TargetPackage();

	/**
	 * Returns the meta object for the containment reference list '
	 * {@link org.unicase.implementation.operations.ExtractSuperClassOperation#getSuperSuperClasses
	 * <em>Super Super Classes</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the containment reference list '<em>Super Super Classes</em>'.
	 * @see org.unicase.implementation.operations.ExtractSuperClassOperation#getSuperSuperClasses()
	 * @see #getExtractSuperClassOperation()
	 * @generated
	 */
	EReference getExtractSuperClassOperation_SuperSuperClasses();

	/**
	 * Returns the meta object for class '{@link org.unicase.implementation.operations.InlineSuperClassOperation
	 * <em>Inline Super Class Operation</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Inline Super Class Operation</em>'.
	 * @see org.unicase.implementation.operations.InlineSuperClassOperation
	 * @generated
	 */
	EClass getInlineSuperClassOperation();

	/**
	 * Returns the meta object for the containment reference '
	 * {@link org.unicase.implementation.operations.InlineSuperClassOperation#getSuperClass <em>Super Class</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the containment reference '<em>Super Class</em>'.
	 * @see org.unicase.implementation.operations.InlineSuperClassOperation#getSuperClass()
	 * @see #getInlineSuperClassOperation()
	 * @generated
	 */
	EReference getInlineSuperClassOperation_SuperClass();

	/**
	 * Returns the meta object for class '{@link org.unicase.implementation.operations.InlineClassOperation
	 * <em>Inline Class Operation</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Inline Class Operation</em>'.
	 * @see org.unicase.implementation.operations.InlineClassOperation
	 * @generated
	 */
	EClass getInlineClassOperation();

	/**
	 * Returns the meta object for the containment reference '
	 * {@link org.unicase.implementation.operations.InlineClassOperation#getAssociation <em>Association</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the containment reference '<em>Association</em>'.
	 * @see org.unicase.implementation.operations.InlineClassOperation#getAssociation()
	 * @see #getInlineClassOperation()
	 * @generated
	 */
	EReference getInlineClassOperation_Association();

	/**
	 * Returns the meta object for the containment reference '
	 * {@link org.unicase.implementation.operations.InlineClassOperation#getInlineClass <em>Inline Class</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the containment reference '<em>Inline Class</em>'.
	 * @see org.unicase.implementation.operations.InlineClassOperation#getInlineClass()
	 * @see #getInlineClassOperation()
	 * @generated
	 */
	EReference getInlineClassOperation_InlineClass();

	/**
	 * Returns the meta object for class '{@link org.unicase.implementation.operations.ExtractClassOperation
	 * <em>Extract Class Operation</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Extract Class Operation</em>'.
	 * @see org.unicase.implementation.operations.ExtractClassOperation
	 * @generated
	 */
	EClass getExtractClassOperation();

	/**
	 * Returns the meta object for the containment reference '
	 * {@link org.unicase.implementation.operations.ExtractClassOperation#getContextClass <em>Context Class</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the containment reference '<em>Context Class</em>'.
	 * @see org.unicase.implementation.operations.ExtractClassOperation#getContextClass()
	 * @see #getExtractClassOperation()
	 * @generated
	 */
	EReference getExtractClassOperation_ContextClass();

	/**
	 * Returns the meta object for the containment reference list '
	 * {@link org.unicase.implementation.operations.ExtractClassOperation#getAttributes <em>Attributes</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the containment reference list '<em>Attributes</em>'.
	 * @see org.unicase.implementation.operations.ExtractClassOperation#getAttributes()
	 * @see #getExtractClassOperation()
	 * @generated
	 */
	EReference getExtractClassOperation_Attributes();

	/**
	 * Returns the meta object for the containment reference list '
	 * {@link org.unicase.implementation.operations.ExtractClassOperation#getOutgoingAssociations
	 * <em>Outgoing Associations</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the containment reference list '<em>Outgoing Associations</em>'.
	 * @see org.unicase.implementation.operations.ExtractClassOperation#getOutgoingAssociations()
	 * @see #getExtractClassOperation()
	 * @generated
	 */
	EReference getExtractClassOperation_OutgoingAssociations();

	/**
	 * Returns the meta object for the containment reference list '
	 * {@link org.unicase.implementation.operations.ExtractClassOperation#getIncomingAssociations
	 * <em>Incoming Associations</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the containment reference list '<em>Incoming Associations</em>'.
	 * @see org.unicase.implementation.operations.ExtractClassOperation#getIncomingAssociations()
	 * @see #getExtractClassOperation()
	 * @generated
	 */
	EReference getExtractClassOperation_IncomingAssociations();

	/**
	 * Returns the meta object for the attribute '
	 * {@link org.unicase.implementation.operations.ExtractClassOperation#getCompositionName <em>Composition Name</em>}
	 * '. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Composition Name</em>'.
	 * @see org.unicase.implementation.operations.ExtractClassOperation#getCompositionName()
	 * @see #getExtractClassOperation()
	 * @generated
	 */
	EAttribute getExtractClassOperation_CompositionName();

	/**
	 * Returns the meta object for the attribute '
	 * {@link org.unicase.implementation.operations.ExtractClassOperation#getClassName <em>Class Name</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Class Name</em>'.
	 * @see org.unicase.implementation.operations.ExtractClassOperation#getClassName()
	 * @see #getExtractClassOperation()
	 * @generated
	 */
	EAttribute getExtractClassOperation_ClassName();

	/**
	 * Returns the meta object for the containment reference '
	 * {@link org.unicase.implementation.operations.ExtractClassOperation#getTargetPackage <em>Target Package</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the containment reference '<em>Target Package</em>'.
	 * @see org.unicase.implementation.operations.ExtractClassOperation#getTargetPackage()
	 * @see #getExtractClassOperation()
	 * @generated
	 */
	EReference getExtractClassOperation_TargetPackage();

	/**
	 * Returns the meta object for class '{@link org.unicase.implementation.operations.PartitionAssociationOperation
	 * <em>Partition Association Operation</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Partition Association Operation</em>'.
	 * @see org.unicase.implementation.operations.PartitionAssociationOperation
	 * @generated
	 */
	EClass getPartitionAssociationOperation();

	/**
	 * Returns the meta object for the containment reference '
	 * {@link org.unicase.implementation.operations.PartitionAssociationOperation#getAssociation <em>Association</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the containment reference '<em>Association</em>'.
	 * @see org.unicase.implementation.operations.PartitionAssociationOperation#getAssociation()
	 * @see #getPartitionAssociationOperation()
	 * @generated
	 */
	EReference getPartitionAssociationOperation_Association();

	/**
	 * Returns the meta object for class '{@link org.unicase.implementation.operations.PushDownOperation
	 * <em>Push Down Operation</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Push Down Operation</em>'.
	 * @see org.unicase.implementation.operations.PushDownOperation
	 * @generated
	 */
	EClass getPushDownOperation();

	/**
	 * Returns the meta object for the containment reference '
	 * {@link org.unicase.implementation.operations.PushDownOperation#getSuperClass <em>Super Class</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the containment reference '<em>Super Class</em>'.
	 * @see org.unicase.implementation.operations.PushDownOperation#getSuperClass()
	 * @see #getPushDownOperation()
	 * @generated
	 */
	EReference getPushDownOperation_SuperClass();

	/**
	 * Returns the meta object for the containment reference list '
	 * {@link org.unicase.implementation.operations.PushDownOperation#getAttributes <em>Attributes</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the containment reference list '<em>Attributes</em>'.
	 * @see org.unicase.implementation.operations.PushDownOperation#getAttributes()
	 * @see #getPushDownOperation()
	 * @generated
	 */
	EReference getPushDownOperation_Attributes();

	/**
	 * Returns the meta object for the containment reference list '
	 * {@link org.unicase.implementation.operations.PushDownOperation#getOutgoingAssociations
	 * <em>Outgoing Associations</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the containment reference list '<em>Outgoing Associations</em>'.
	 * @see org.unicase.implementation.operations.PushDownOperation#getOutgoingAssociations()
	 * @see #getPushDownOperation()
	 * @generated
	 */
	EReference getPushDownOperation_OutgoingAssociations();

	/**
	 * Returns the meta object for the containment reference list '
	 * {@link org.unicase.implementation.operations.PushDownOperation#getIncomingAssociations
	 * <em>Incoming Associations</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the containment reference list '<em>Incoming Associations</em>'.
	 * @see org.unicase.implementation.operations.PushDownOperation#getIncomingAssociations()
	 * @see #getPushDownOperation()
	 * @generated
	 */
	EReference getPushDownOperation_IncomingAssociations();

	/**
	 * Returns the meta object for class '{@link org.unicase.implementation.operations.PullUpOperation
	 * <em>Pull Up Operation</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Pull Up Operation</em>'.
	 * @see org.unicase.implementation.operations.PullUpOperation
	 * @generated
	 */
	EClass getPullUpOperation();

	/**
	 * Returns the meta object for the containment reference '
	 * {@link org.unicase.implementation.operations.PullUpOperation#getSuperClass <em>Super Class</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the containment reference '<em>Super Class</em>'.
	 * @see org.unicase.implementation.operations.PullUpOperation#getSuperClass()
	 * @see #getPullUpOperation()
	 * @generated
	 */
	EReference getPullUpOperation_SuperClass();

	/**
	 * Returns the meta object for the containment reference list '
	 * {@link org.unicase.implementation.operations.PullUpOperation#getAttributes <em>Attributes</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the containment reference list '<em>Attributes</em>'.
	 * @see org.unicase.implementation.operations.PullUpOperation#getAttributes()
	 * @see #getPullUpOperation()
	 * @generated
	 */
	EReference getPullUpOperation_Attributes();

	/**
	 * Returns the meta object for the containment reference list '
	 * {@link org.unicase.implementation.operations.PullUpOperation#getOutgoingAssociations
	 * <em>Outgoing Associations</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the containment reference list '<em>Outgoing Associations</em>'.
	 * @see org.unicase.implementation.operations.PullUpOperation#getOutgoingAssociations()
	 * @see #getPullUpOperation()
	 * @generated
	 */
	EReference getPullUpOperation_OutgoingAssociations();

	/**
	 * Returns the meta object for the containment reference list '
	 * {@link org.unicase.implementation.operations.PullUpOperation#getIncomingAssociations
	 * <em>Incoming Associations</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the containment reference list '<em>Incoming Associations</em>'.
	 * @see org.unicase.implementation.operations.PullUpOperation#getIncomingAssociations()
	 * @see #getPullUpOperation()
	 * @generated
	 */
	EReference getPullUpOperation_IncomingAssociations();

	/**
	 * Returns the factory that creates the instances of the model. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	OperationsFactory getOperationsFactory();

	/**
	 * <!-- begin-user-doc --> Defines literals for the meta objects that represent
	 * <ul>
	 * <li>each class,</li>
	 * <li>each feature of each class,</li>
	 * <li>each enum,</li>
	 * <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '
		 * {@link org.unicase.implementation.operations.impl.ExtractSuperClassOperationImpl
		 * <em>Extract Super Class Operation</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @see org.unicase.implementation.operations.impl.ExtractSuperClassOperationImpl
		 * @see org.unicase.implementation.operations.impl.OperationsPackageImpl#getExtractSuperClassOperation()
		 * @generated
		 */
		EClass EXTRACT_SUPER_CLASS_OPERATION = eINSTANCE.getExtractSuperClassOperation();

		/**
		 * The meta object literal for the '<em><b>Sub Classes</b></em>' containment reference list feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference EXTRACT_SUPER_CLASS_OPERATION__SUB_CLASSES = eINSTANCE.getExtractSuperClassOperation_SubClasses();

		/**
		 * The meta object literal for the '<em><b>Attributes</b></em>' containment reference list feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference EXTRACT_SUPER_CLASS_OPERATION__ATTRIBUTES = eINSTANCE.getExtractSuperClassOperation_Attributes();

		/**
		 * The meta object literal for the '<em><b>Outgoing Associations</b></em>' containment reference list feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference EXTRACT_SUPER_CLASS_OPERATION__OUTGOING_ASSOCIATIONS = eINSTANCE
			.getExtractSuperClassOperation_OutgoingAssociations();

		/**
		 * The meta object literal for the '<em><b>Incoming Associations</b></em>' containment reference list feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference EXTRACT_SUPER_CLASS_OPERATION__INCOMING_ASSOCIATIONS = eINSTANCE
			.getExtractSuperClassOperation_IncomingAssociations();

		/**
		 * The meta object literal for the '<em><b>Super Class Name</b></em>' attribute feature. <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute EXTRACT_SUPER_CLASS_OPERATION__SUPER_CLASS_NAME = eINSTANCE
			.getExtractSuperClassOperation_SuperClassName();

		/**
		 * The meta object literal for the '<em><b>Target Package</b></em>' containment reference feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference EXTRACT_SUPER_CLASS_OPERATION__TARGET_PACKAGE = eINSTANCE
			.getExtractSuperClassOperation_TargetPackage();

		/**
		 * The meta object literal for the '<em><b>Super Super Classes</b></em>' containment reference list feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference EXTRACT_SUPER_CLASS_OPERATION__SUPER_SUPER_CLASSES = eINSTANCE
			.getExtractSuperClassOperation_SuperSuperClasses();

		/**
		 * The meta object literal for the '
		 * {@link org.unicase.implementation.operations.impl.InlineSuperClassOperationImpl
		 * <em>Inline Super Class Operation</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @see org.unicase.implementation.operations.impl.InlineSuperClassOperationImpl
		 * @see org.unicase.implementation.operations.impl.OperationsPackageImpl#getInlineSuperClassOperation()
		 * @generated
		 */
		EClass INLINE_SUPER_CLASS_OPERATION = eINSTANCE.getInlineSuperClassOperation();

		/**
		 * The meta object literal for the '<em><b>Super Class</b></em>' containment reference feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference INLINE_SUPER_CLASS_OPERATION__SUPER_CLASS = eINSTANCE.getInlineSuperClassOperation_SuperClass();

		/**
		 * The meta object literal for the '{@link org.unicase.implementation.operations.impl.InlineClassOperationImpl
		 * <em>Inline Class Operation</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @see org.unicase.implementation.operations.impl.InlineClassOperationImpl
		 * @see org.unicase.implementation.operations.impl.OperationsPackageImpl#getInlineClassOperation()
		 * @generated
		 */
		EClass INLINE_CLASS_OPERATION = eINSTANCE.getInlineClassOperation();

		/**
		 * The meta object literal for the '<em><b>Association</b></em>' containment reference feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference INLINE_CLASS_OPERATION__ASSOCIATION = eINSTANCE.getInlineClassOperation_Association();

		/**
		 * The meta object literal for the '<em><b>Inline Class</b></em>' containment reference feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference INLINE_CLASS_OPERATION__INLINE_CLASS = eINSTANCE.getInlineClassOperation_InlineClass();

		/**
		 * The meta object literal for the '{@link org.unicase.implementation.operations.impl.ExtractClassOperationImpl
		 * <em>Extract Class Operation</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @see org.unicase.implementation.operations.impl.ExtractClassOperationImpl
		 * @see org.unicase.implementation.operations.impl.OperationsPackageImpl#getExtractClassOperation()
		 * @generated
		 */
		EClass EXTRACT_CLASS_OPERATION = eINSTANCE.getExtractClassOperation();

		/**
		 * The meta object literal for the '<em><b>Context Class</b></em>' containment reference feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference EXTRACT_CLASS_OPERATION__CONTEXT_CLASS = eINSTANCE.getExtractClassOperation_ContextClass();

		/**
		 * The meta object literal for the '<em><b>Attributes</b></em>' containment reference list feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference EXTRACT_CLASS_OPERATION__ATTRIBUTES = eINSTANCE.getExtractClassOperation_Attributes();

		/**
		 * The meta object literal for the '<em><b>Outgoing Associations</b></em>' containment reference list feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference EXTRACT_CLASS_OPERATION__OUTGOING_ASSOCIATIONS = eINSTANCE
			.getExtractClassOperation_OutgoingAssociations();

		/**
		 * The meta object literal for the '<em><b>Incoming Associations</b></em>' containment reference list feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference EXTRACT_CLASS_OPERATION__INCOMING_ASSOCIATIONS = eINSTANCE
			.getExtractClassOperation_IncomingAssociations();

		/**
		 * The meta object literal for the '<em><b>Composition Name</b></em>' attribute feature. <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute EXTRACT_CLASS_OPERATION__COMPOSITION_NAME = eINSTANCE.getExtractClassOperation_CompositionName();

		/**
		 * The meta object literal for the '<em><b>Class Name</b></em>' attribute feature. <!-- begin-user-doc --> <!--
		 * end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute EXTRACT_CLASS_OPERATION__CLASS_NAME = eINSTANCE.getExtractClassOperation_ClassName();

		/**
		 * The meta object literal for the '<em><b>Target Package</b></em>' containment reference feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference EXTRACT_CLASS_OPERATION__TARGET_PACKAGE = eINSTANCE.getExtractClassOperation_TargetPackage();

		/**
		 * The meta object literal for the '
		 * {@link org.unicase.implementation.operations.impl.PartitionAssociationOperationImpl
		 * <em>Partition Association Operation</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @see org.unicase.implementation.operations.impl.PartitionAssociationOperationImpl
		 * @see org.unicase.implementation.operations.impl.OperationsPackageImpl#getPartitionAssociationOperation()
		 * @generated
		 */
		EClass PARTITION_ASSOCIATION_OPERATION = eINSTANCE.getPartitionAssociationOperation();

		/**
		 * The meta object literal for the '<em><b>Association</b></em>' containment reference feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference PARTITION_ASSOCIATION_OPERATION__ASSOCIATION = eINSTANCE
			.getPartitionAssociationOperation_Association();

		/**
		 * The meta object literal for the '{@link org.unicase.implementation.operations.impl.PushDownOperationImpl
		 * <em>Push Down Operation</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @see org.unicase.implementation.operations.impl.PushDownOperationImpl
		 * @see org.unicase.implementation.operations.impl.OperationsPackageImpl#getPushDownOperation()
		 * @generated
		 */
		EClass PUSH_DOWN_OPERATION = eINSTANCE.getPushDownOperation();

		/**
		 * The meta object literal for the '<em><b>Super Class</b></em>' containment reference feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference PUSH_DOWN_OPERATION__SUPER_CLASS = eINSTANCE.getPushDownOperation_SuperClass();

		/**
		 * The meta object literal for the '<em><b>Attributes</b></em>' containment reference list feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference PUSH_DOWN_OPERATION__ATTRIBUTES = eINSTANCE.getPushDownOperation_Attributes();

		/**
		 * The meta object literal for the '<em><b>Outgoing Associations</b></em>' containment reference list feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference PUSH_DOWN_OPERATION__OUTGOING_ASSOCIATIONS = eINSTANCE.getPushDownOperation_OutgoingAssociations();

		/**
		 * The meta object literal for the '<em><b>Incoming Associations</b></em>' containment reference list feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference PUSH_DOWN_OPERATION__INCOMING_ASSOCIATIONS = eINSTANCE.getPushDownOperation_IncomingAssociations();

		/**
		 * The meta object literal for the '{@link org.unicase.implementation.operations.impl.PullUpOperationImpl
		 * <em>Pull Up Operation</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @see org.unicase.implementation.operations.impl.PullUpOperationImpl
		 * @see org.unicase.implementation.operations.impl.OperationsPackageImpl#getPullUpOperation()
		 * @generated
		 */
		EClass PULL_UP_OPERATION = eINSTANCE.getPullUpOperation();

		/**
		 * The meta object literal for the '<em><b>Super Class</b></em>' containment reference feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference PULL_UP_OPERATION__SUPER_CLASS = eINSTANCE.getPullUpOperation_SuperClass();

		/**
		 * The meta object literal for the '<em><b>Attributes</b></em>' containment reference list feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference PULL_UP_OPERATION__ATTRIBUTES = eINSTANCE.getPullUpOperation_Attributes();

		/**
		 * The meta object literal for the '<em><b>Outgoing Associations</b></em>' containment reference list feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference PULL_UP_OPERATION__OUTGOING_ASSOCIATIONS = eINSTANCE.getPullUpOperation_OutgoingAssociations();

		/**
		 * The meta object literal for the '<em><b>Incoming Associations</b></em>' containment reference list feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference PULL_UP_OPERATION__INCOMING_ASSOCIATIONS = eINSTANCE.getPullUpOperation_IncomingAssociations();

	}

} // OperationsPackage
