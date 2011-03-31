/*******************************************************************************
 * Copyright (c) 2008-2011 Chair for Applied Software Engineering, Technische Universitaet Muenchen.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 ******************************************************************************/
package org.eclipse.emf.emfstore.server.model.versioning.operations.semantic;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.emfstore.server.model.versioning.operations.OperationsPackage;

/**
 * <!-- begin-user-doc --> The <b>Package</b> for the model. It contains accessors for the meta objects to represent
 * <ul>
 * <li>each class,</li>
 * <li>each feature of each class,</li>
 * <li>each enum,</li>
 * <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see org.eclipse.emf.emfstore.server.model.versioning.operations.semantic.SemanticFactory
 * @model kind="package"
 * @generated
 */
public interface SemanticPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "semantic";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://eclipse.org/emf/emfstore/server/model/versioning/operations/semantic";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "org.eclipse.emf.emfstore.server.model.versioning.operations.semantic";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	SemanticPackage eINSTANCE = org.eclipse.emf.emfstore.server.model.versioning.operations.semantic.impl.SemanticPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.eclipse.emf.emfstore.server.model.versioning.operations.semantic.impl.SemanticCompositeOperationImpl <em>Composite Operation</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see org.eclipse.emf.emfstore.server.model.versioning.operations.semantic.impl.SemanticCompositeOperationImpl
	 * @see org.eclipse.emf.emfstore.server.model.versioning.operations.semantic.impl.SemanticPackageImpl#getSemanticCompositeOperation()
	 * @generated
	 */
	int SEMANTIC_COMPOSITE_OPERATION = 0;

	/**
	 * The feature id for the '<em><b>Identifier</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEMANTIC_COMPOSITE_OPERATION__IDENTIFIER = OperationsPackage.COMPOSITE_OPERATION__IDENTIFIER;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEMANTIC_COMPOSITE_OPERATION__NAME = OperationsPackage.COMPOSITE_OPERATION__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEMANTIC_COMPOSITE_OPERATION__DESCRIPTION = OperationsPackage.COMPOSITE_OPERATION__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Model Element Id</b></em>' containment reference.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEMANTIC_COMPOSITE_OPERATION__MODEL_ELEMENT_ID = OperationsPackage.COMPOSITE_OPERATION__MODEL_ELEMENT_ID;

	/**
	 * The feature id for the '<em><b>Accepted</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEMANTIC_COMPOSITE_OPERATION__ACCEPTED = OperationsPackage.COMPOSITE_OPERATION__ACCEPTED;

	/**
	 * The feature id for the '<em><b>Client Date</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEMANTIC_COMPOSITE_OPERATION__CLIENT_DATE = OperationsPackage.COMPOSITE_OPERATION__CLIENT_DATE;

	/**
	 * The feature id for the '<em><b>Sub Operations</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEMANTIC_COMPOSITE_OPERATION__SUB_OPERATIONS = OperationsPackage.COMPOSITE_OPERATION__SUB_OPERATIONS;

	/**
	 * The feature id for the '<em><b>Main Operation</b></em>' reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEMANTIC_COMPOSITE_OPERATION__MAIN_OPERATION = OperationsPackage.COMPOSITE_OPERATION__MAIN_OPERATION;

	/**
	 * The feature id for the '<em><b>Composite Name</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEMANTIC_COMPOSITE_OPERATION__COMPOSITE_NAME = OperationsPackage.COMPOSITE_OPERATION__COMPOSITE_NAME;

	/**
	 * The feature id for the '<em><b>Composite Description</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEMANTIC_COMPOSITE_OPERATION__COMPOSITE_DESCRIPTION = OperationsPackage.COMPOSITE_OPERATION__COMPOSITE_DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Reversed</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEMANTIC_COMPOSITE_OPERATION__REVERSED = OperationsPackage.COMPOSITE_OPERATION__REVERSED;

	/**
	 * The number of structural features of the '<em>Composite Operation</em>' class.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEMANTIC_COMPOSITE_OPERATION_FEATURE_COUNT = OperationsPackage.COMPOSITE_OPERATION_FEATURE_COUNT + 0;

	/**
	 * Returns the meta object for class '{@link org.eclipse.emf.emfstore.server.model.versioning.operations.semantic.SemanticCompositeOperation <em>Composite Operation</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for class '<em>Composite Operation</em>'.
	 * @see org.eclipse.emf.emfstore.server.model.versioning.operations.semantic.SemanticCompositeOperation
	 * @generated
	 */
	EClass getSemanticCompositeOperation();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
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
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link org.eclipse.emf.emfstore.server.model.versioning.operations.semantic.impl.SemanticCompositeOperationImpl <em>Composite Operation</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see org.eclipse.emf.emfstore.server.model.versioning.operations.semantic.impl.SemanticCompositeOperationImpl
		 * @see org.eclipse.emf.emfstore.server.model.versioning.operations.semantic.impl.SemanticPackageImpl#getSemanticCompositeOperation()
		 * @generated
		 */
		EClass SEMANTIC_COMPOSITE_OPERATION = eINSTANCE.getSemanticCompositeOperation();

	}

} // SemanticPackage
