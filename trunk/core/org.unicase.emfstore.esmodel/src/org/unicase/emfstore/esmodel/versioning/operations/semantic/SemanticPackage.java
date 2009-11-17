/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.emfstore.esmodel.versioning.operations.semantic;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.unicase.emfstore.esmodel.versioning.operations.OperationsPackage;

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
 * @see org.unicase.emfstore.esmodel.versioning.operations.semantic.SemanticFactory
 * @model kind="package"
 * @generated
 */
public interface SemanticPackage extends EPackage {
	/**
	 * The package name. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	String eNAME = "semantic";

	/**
	 * The package namespace URI. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	String eNS_URI = "http://unicase.org/esmodel/versioning/operations/semantic";

	/**
	 * The package namespace name. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	String eNS_PREFIX = "org.unicase.emfstore.esmodel.versioning.operations.semantic";

	/**
	 * The singleton instance of the package. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	SemanticPackage eINSTANCE = org.unicase.emfstore.esmodel.versioning.operations.semantic.impl.SemanticPackageImpl
		.init();

	/**
	 * The meta object id for the '
	 * {@link org.unicase.emfstore.esmodel.versioning.operations.semantic.impl.SemanticCompositeOperationImpl
	 * <em>Composite Operation</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see org.unicase.emfstore.esmodel.versioning.operations.semantic.impl.SemanticCompositeOperationImpl
	 * @see org.unicase.emfstore.esmodel.versioning.operations.semantic.impl.SemanticPackageImpl#getSemanticCompositeOperation()
	 * @generated
	 */
	int SEMANTIC_COMPOSITE_OPERATION = 0;

	/**
	 * The feature id for the '<em><b>Identifier</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SEMANTIC_COMPOSITE_OPERATION__IDENTIFIER = OperationsPackage.COMPOSITE_OPERATION__IDENTIFIER;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SEMANTIC_COMPOSITE_OPERATION__NAME = OperationsPackage.COMPOSITE_OPERATION__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SEMANTIC_COMPOSITE_OPERATION__DESCRIPTION = OperationsPackage.COMPOSITE_OPERATION__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Model Element Id</b></em>' containment reference. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SEMANTIC_COMPOSITE_OPERATION__MODEL_ELEMENT_ID = OperationsPackage.COMPOSITE_OPERATION__MODEL_ELEMENT_ID;

	/**
	 * The feature id for the '<em><b>Accepted</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SEMANTIC_COMPOSITE_OPERATION__ACCEPTED = OperationsPackage.COMPOSITE_OPERATION__ACCEPTED;

	/**
	 * The feature id for the '<em><b>Client Date</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SEMANTIC_COMPOSITE_OPERATION__CLIENT_DATE = OperationsPackage.COMPOSITE_OPERATION__CLIENT_DATE;

	/**
	 * The feature id for the '<em><b>Sub Operations</b></em>' containment reference list. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SEMANTIC_COMPOSITE_OPERATION__SUB_OPERATIONS = OperationsPackage.COMPOSITE_OPERATION__SUB_OPERATIONS;

	/**
	 * The feature id for the '<em><b>Main Operation</b></em>' reference. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SEMANTIC_COMPOSITE_OPERATION__MAIN_OPERATION = OperationsPackage.COMPOSITE_OPERATION__MAIN_OPERATION;

	/**
	 * The feature id for the '<em><b>Composite Name</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SEMANTIC_COMPOSITE_OPERATION__COMPOSITE_NAME = OperationsPackage.COMPOSITE_OPERATION__COMPOSITE_NAME;

	/**
	 * The feature id for the '<em><b>Composite Description</b></em>' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SEMANTIC_COMPOSITE_OPERATION__COMPOSITE_DESCRIPTION = OperationsPackage.COMPOSITE_OPERATION__COMPOSITE_DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Reversed</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SEMANTIC_COMPOSITE_OPERATION__REVERSED = OperationsPackage.COMPOSITE_OPERATION__REVERSED;

	/**
	 * The number of structural features of the '<em>Composite Operation</em>' class. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SEMANTIC_COMPOSITE_OPERATION_FEATURE_COUNT = OperationsPackage.COMPOSITE_OPERATION_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '
	 * {@link org.unicase.emfstore.esmodel.versioning.operations.semantic.impl.ExtractToSuperclassOperationImpl
	 * <em>Extract To Superclass Operation</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see org.unicase.emfstore.esmodel.versioning.operations.semantic.impl.ExtractToSuperclassOperationImpl
	 * @see org.unicase.emfstore.esmodel.versioning.operations.semantic.impl.SemanticPackageImpl#getExtractToSuperclassOperation()
	 * @generated
	 */
	int EXTRACT_TO_SUPERCLASS_OPERATION = 1;

	/**
	 * The feature id for the '<em><b>Identifier</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int EXTRACT_TO_SUPERCLASS_OPERATION__IDENTIFIER = SEMANTIC_COMPOSITE_OPERATION__IDENTIFIER;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int EXTRACT_TO_SUPERCLASS_OPERATION__NAME = SEMANTIC_COMPOSITE_OPERATION__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int EXTRACT_TO_SUPERCLASS_OPERATION__DESCRIPTION = SEMANTIC_COMPOSITE_OPERATION__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Model Element Id</b></em>' containment reference. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int EXTRACT_TO_SUPERCLASS_OPERATION__MODEL_ELEMENT_ID = SEMANTIC_COMPOSITE_OPERATION__MODEL_ELEMENT_ID;

	/**
	 * The feature id for the '<em><b>Accepted</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int EXTRACT_TO_SUPERCLASS_OPERATION__ACCEPTED = SEMANTIC_COMPOSITE_OPERATION__ACCEPTED;

	/**
	 * The feature id for the '<em><b>Client Date</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int EXTRACT_TO_SUPERCLASS_OPERATION__CLIENT_DATE = SEMANTIC_COMPOSITE_OPERATION__CLIENT_DATE;

	/**
	 * The feature id for the '<em><b>Sub Operations</b></em>' containment reference list. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int EXTRACT_TO_SUPERCLASS_OPERATION__SUB_OPERATIONS = SEMANTIC_COMPOSITE_OPERATION__SUB_OPERATIONS;

	/**
	 * The feature id for the '<em><b>Main Operation</b></em>' reference. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int EXTRACT_TO_SUPERCLASS_OPERATION__MAIN_OPERATION = SEMANTIC_COMPOSITE_OPERATION__MAIN_OPERATION;

	/**
	 * The feature id for the '<em><b>Composite Name</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int EXTRACT_TO_SUPERCLASS_OPERATION__COMPOSITE_NAME = SEMANTIC_COMPOSITE_OPERATION__COMPOSITE_NAME;

	/**
	 * The feature id for the '<em><b>Composite Description</b></em>' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int EXTRACT_TO_SUPERCLASS_OPERATION__COMPOSITE_DESCRIPTION = SEMANTIC_COMPOSITE_OPERATION__COMPOSITE_DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Reversed</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int EXTRACT_TO_SUPERCLASS_OPERATION__REVERSED = SEMANTIC_COMPOSITE_OPERATION__REVERSED;

	/**
	 * The feature id for the '<em><b>Super Class Name</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @generated
	 * @ordered
	 */
	int EXTRACT_TO_SUPERCLASS_OPERATION__SUPER_CLASS_NAME = SEMANTIC_COMPOSITE_OPERATION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Sub Classes</b></em>' containment reference list. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int EXTRACT_TO_SUPERCLASS_OPERATION__SUB_CLASSES = SEMANTIC_COMPOSITE_OPERATION_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Features</b></em>' reference list. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int EXTRACT_TO_SUPERCLASS_OPERATION__FEATURES = SEMANTIC_COMPOSITE_OPERATION_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Target Package</b></em>' reference. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int EXTRACT_TO_SUPERCLASS_OPERATION__TARGET_PACKAGE = SEMANTIC_COMPOSITE_OPERATION_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Extract To Superclass Operation</em>' class. <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int EXTRACT_TO_SUPERCLASS_OPERATION_FEATURE_COUNT = SEMANTIC_COMPOSITE_OPERATION_FEATURE_COUNT + 4;

	/**
	 * Returns the meta object for class '
	 * {@link org.unicase.emfstore.esmodel.versioning.operations.semantic.SemanticCompositeOperation
	 * <em>Composite Operation</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Composite Operation</em>'.
	 * @see org.unicase.emfstore.esmodel.versioning.operations.semantic.SemanticCompositeOperation
	 * @generated
	 */
	EClass getSemanticCompositeOperation();

	/**
	 * Returns the meta object for class '
	 * {@link org.unicase.emfstore.esmodel.versioning.operations.semantic.ExtractToSuperclassOperation
	 * <em>Extract To Superclass Operation</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Extract To Superclass Operation</em>'.
	 * @see org.unicase.emfstore.esmodel.versioning.operations.semantic.ExtractToSuperclassOperation
	 * @generated
	 */
	EClass getExtractToSuperclassOperation();

	/**
	 * Returns the meta object for the attribute '
	 * {@link org.unicase.emfstore.esmodel.versioning.operations.semantic.ExtractToSuperclassOperation#getSuperClassName
	 * <em>Super Class Name</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Super Class Name</em>'.
	 * @see org.unicase.emfstore.esmodel.versioning.operations.semantic.ExtractToSuperclassOperation#getSuperClassName()
	 * @see #getExtractToSuperclassOperation()
	 * @generated
	 */
	EAttribute getExtractToSuperclassOperation_SuperClassName();

	/**
	 * Returns the meta object for the containment reference list '
	 * {@link org.unicase.emfstore.esmodel.versioning.operations.semantic.ExtractToSuperclassOperation#getSubClasses
	 * <em>Sub Classes</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the containment reference list '<em>Sub Classes</em>'.
	 * @see org.unicase.emfstore.esmodel.versioning.operations.semantic.ExtractToSuperclassOperation#getSubClasses()
	 * @see #getExtractToSuperclassOperation()
	 * @generated
	 */
	EReference getExtractToSuperclassOperation_SubClasses();

	/**
	 * Returns the meta object for the reference list '
	 * {@link org.unicase.emfstore.esmodel.versioning.operations.semantic.ExtractToSuperclassOperation#getFeatures
	 * <em>Features</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference list '<em>Features</em>'.
	 * @see org.unicase.emfstore.esmodel.versioning.operations.semantic.ExtractToSuperclassOperation#getFeatures()
	 * @see #getExtractToSuperclassOperation()
	 * @generated
	 */
	EReference getExtractToSuperclassOperation_Features();

	/**
	 * Returns the meta object for the reference '
	 * {@link org.unicase.emfstore.esmodel.versioning.operations.semantic.ExtractToSuperclassOperation#getTargetPackage
	 * <em>Target Package</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference '<em>Target Package</em>'.
	 * @see org.unicase.emfstore.esmodel.versioning.operations.semantic.ExtractToSuperclassOperation#getTargetPackage()
	 * @see #getExtractToSuperclassOperation()
	 * @generated
	 */
	EReference getExtractToSuperclassOperation_TargetPackage();

	/**
	 * Returns the factory that creates the instances of the model. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	SemanticFactory getSemanticFactory();

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
		 * {@link org.unicase.emfstore.esmodel.versioning.operations.semantic.impl.SemanticCompositeOperationImpl
		 * <em>Composite Operation</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @see org.unicase.emfstore.esmodel.versioning.operations.semantic.impl.SemanticCompositeOperationImpl
		 * @see org.unicase.emfstore.esmodel.versioning.operations.semantic.impl.SemanticPackageImpl#getSemanticCompositeOperation()
		 * @generated
		 */
		EClass SEMANTIC_COMPOSITE_OPERATION = eINSTANCE.getSemanticCompositeOperation();

		/**
		 * The meta object literal for the '
		 * {@link org.unicase.emfstore.esmodel.versioning.operations.semantic.impl.ExtractToSuperclassOperationImpl
		 * <em>Extract To Superclass Operation</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @see org.unicase.emfstore.esmodel.versioning.operations.semantic.impl.ExtractToSuperclassOperationImpl
		 * @see org.unicase.emfstore.esmodel.versioning.operations.semantic.impl.SemanticPackageImpl#getExtractToSuperclassOperation()
		 * @generated
		 */
		EClass EXTRACT_TO_SUPERCLASS_OPERATION = eINSTANCE.getExtractToSuperclassOperation();

		/**
		 * The meta object literal for the '<em><b>Super Class Name</b></em>' attribute feature. <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute EXTRACT_TO_SUPERCLASS_OPERATION__SUPER_CLASS_NAME = eINSTANCE
			.getExtractToSuperclassOperation_SuperClassName();

		/**
		 * The meta object literal for the '<em><b>Sub Classes</b></em>' containment reference list feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference EXTRACT_TO_SUPERCLASS_OPERATION__SUB_CLASSES = eINSTANCE
			.getExtractToSuperclassOperation_SubClasses();

		/**
		 * The meta object literal for the '<em><b>Features</b></em>' reference list feature. <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference EXTRACT_TO_SUPERCLASS_OPERATION__FEATURES = eINSTANCE.getExtractToSuperclassOperation_Features();

		/**
		 * The meta object literal for the '<em><b>Target Package</b></em>' reference feature. <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference EXTRACT_TO_SUPERCLASS_OPERATION__TARGET_PACKAGE = eINSTANCE
			.getExtractToSuperclassOperation_TargetPackage();

	}

} // SemanticPackage
