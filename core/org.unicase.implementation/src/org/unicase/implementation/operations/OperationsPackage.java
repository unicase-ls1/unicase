/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.unicase.implementation.operations;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.unicase.emfstore.esmodel.versioning.operations.semantic.SemanticPackage;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see org.unicase.implementation.operations.OperationsFactory
 * @model kind="package"
 * @generated
 */
public interface OperationsPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "operations";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "operations";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "operations";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	OperationsPackage eINSTANCE = org.unicase.implementation.operations.impl.OperationsPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.unicase.implementation.operations.impl.ExtractSuperClassOperationImpl <em>Extract Super Class Operation</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.unicase.implementation.operations.impl.ExtractSuperClassOperationImpl
	 * @see org.unicase.implementation.operations.impl.OperationsPackageImpl#getExtractSuperClassOperation()
	 * @generated
	 */
	int EXTRACT_SUPER_CLASS_OPERATION = 0;

	/**
	 * The feature id for the '<em><b>Identifier</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTRACT_SUPER_CLASS_OPERATION__IDENTIFIER = SemanticPackage.SEMANTIC_COMPOSITE_OPERATION__IDENTIFIER;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTRACT_SUPER_CLASS_OPERATION__NAME = SemanticPackage.SEMANTIC_COMPOSITE_OPERATION__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTRACT_SUPER_CLASS_OPERATION__DESCRIPTION = SemanticPackage.SEMANTIC_COMPOSITE_OPERATION__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Model Element Id</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTRACT_SUPER_CLASS_OPERATION__MODEL_ELEMENT_ID = SemanticPackage.SEMANTIC_COMPOSITE_OPERATION__MODEL_ELEMENT_ID;

	/**
	 * The feature id for the '<em><b>Accepted</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTRACT_SUPER_CLASS_OPERATION__ACCEPTED = SemanticPackage.SEMANTIC_COMPOSITE_OPERATION__ACCEPTED;

	/**
	 * The feature id for the '<em><b>Client Date</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTRACT_SUPER_CLASS_OPERATION__CLIENT_DATE = SemanticPackage.SEMANTIC_COMPOSITE_OPERATION__CLIENT_DATE;

	/**
	 * The feature id for the '<em><b>Sub Operations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTRACT_SUPER_CLASS_OPERATION__SUB_OPERATIONS = SemanticPackage.SEMANTIC_COMPOSITE_OPERATION__SUB_OPERATIONS;

	/**
	 * The feature id for the '<em><b>Main Operation</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTRACT_SUPER_CLASS_OPERATION__MAIN_OPERATION = SemanticPackage.SEMANTIC_COMPOSITE_OPERATION__MAIN_OPERATION;

	/**
	 * The feature id for the '<em><b>Composite Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTRACT_SUPER_CLASS_OPERATION__COMPOSITE_NAME = SemanticPackage.SEMANTIC_COMPOSITE_OPERATION__COMPOSITE_NAME;

	/**
	 * The feature id for the '<em><b>Composite Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTRACT_SUPER_CLASS_OPERATION__COMPOSITE_DESCRIPTION = SemanticPackage.SEMANTIC_COMPOSITE_OPERATION__COMPOSITE_DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Reversed</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTRACT_SUPER_CLASS_OPERATION__REVERSED = SemanticPackage.SEMANTIC_COMPOSITE_OPERATION__REVERSED;

	/**
	 * The feature id for the '<em><b>Sub Classes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTRACT_SUPER_CLASS_OPERATION__SUB_CLASSES = SemanticPackage.SEMANTIC_COMPOSITE_OPERATION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Super Class Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTRACT_SUPER_CLASS_OPERATION__SUPER_CLASS_NAME = SemanticPackage.SEMANTIC_COMPOSITE_OPERATION_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Target Package</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTRACT_SUPER_CLASS_OPERATION__TARGET_PACKAGE = SemanticPackage.SEMANTIC_COMPOSITE_OPERATION_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Super Super Classes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTRACT_SUPER_CLASS_OPERATION__SUPER_SUPER_CLASSES = SemanticPackage.SEMANTIC_COMPOSITE_OPERATION_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Extract Super Class Operation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTRACT_SUPER_CLASS_OPERATION_FEATURE_COUNT = SemanticPackage.SEMANTIC_COMPOSITE_OPERATION_FEATURE_COUNT + 4;


	/**
	 * Returns the meta object for class '{@link org.unicase.implementation.operations.ExtractSuperClassOperation <em>Extract Super Class Operation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Extract Super Class Operation</em>'.
	 * @see org.unicase.implementation.operations.ExtractSuperClassOperation
	 * @generated
	 */
	EClass getExtractSuperClassOperation();

	/**
	 * Returns the meta object for the containment reference list '{@link org.unicase.implementation.operations.ExtractSuperClassOperation#getSubClasses <em>Sub Classes</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Sub Classes</em>'.
	 * @see org.unicase.implementation.operations.ExtractSuperClassOperation#getSubClasses()
	 * @see #getExtractSuperClassOperation()
	 * @generated
	 */
	EReference getExtractSuperClassOperation_SubClasses();

	/**
	 * Returns the meta object for the attribute '{@link org.unicase.implementation.operations.ExtractSuperClassOperation#getSuperClassName <em>Super Class Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Super Class Name</em>'.
	 * @see org.unicase.implementation.operations.ExtractSuperClassOperation#getSuperClassName()
	 * @see #getExtractSuperClassOperation()
	 * @generated
	 */
	EAttribute getExtractSuperClassOperation_SuperClassName();

	/**
	 * Returns the meta object for the containment reference '{@link org.unicase.implementation.operations.ExtractSuperClassOperation#getTargetPackage <em>Target Package</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Target Package</em>'.
	 * @see org.unicase.implementation.operations.ExtractSuperClassOperation#getTargetPackage()
	 * @see #getExtractSuperClassOperation()
	 * @generated
	 */
	EReference getExtractSuperClassOperation_TargetPackage();

	/**
	 * Returns the meta object for the containment reference list '{@link org.unicase.implementation.operations.ExtractSuperClassOperation#getSuperSuperClasses <em>Super Super Classes</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Super Super Classes</em>'.
	 * @see org.unicase.implementation.operations.ExtractSuperClassOperation#getSuperSuperClasses()
	 * @see #getExtractSuperClassOperation()
	 * @generated
	 */
	EReference getExtractSuperClassOperation_SuperSuperClasses();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	OperationsFactory getOperationsFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link org.unicase.implementation.operations.impl.ExtractSuperClassOperationImpl <em>Extract Super Class Operation</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.unicase.implementation.operations.impl.ExtractSuperClassOperationImpl
		 * @see org.unicase.implementation.operations.impl.OperationsPackageImpl#getExtractSuperClassOperation()
		 * @generated
		 */
		EClass EXTRACT_SUPER_CLASS_OPERATION = eINSTANCE.getExtractSuperClassOperation();

		/**
		 * The meta object literal for the '<em><b>Sub Classes</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EXTRACT_SUPER_CLASS_OPERATION__SUB_CLASSES = eINSTANCE.getExtractSuperClassOperation_SubClasses();

		/**
		 * The meta object literal for the '<em><b>Super Class Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EXTRACT_SUPER_CLASS_OPERATION__SUPER_CLASS_NAME = eINSTANCE.getExtractSuperClassOperation_SuperClassName();

		/**
		 * The meta object literal for the '<em><b>Target Package</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EXTRACT_SUPER_CLASS_OPERATION__TARGET_PACKAGE = eINSTANCE.getExtractSuperClassOperation_TargetPackage();

		/**
		 * The meta object literal for the '<em><b>Super Super Classes</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EXTRACT_SUPER_CLASS_OPERATION__SUPER_SUPER_CLASSES = eINSTANCE.getExtractSuperClassOperation_SuperSuperClasses();

	}

} //OperationsPackage
