/**
 * Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this distribution, and is available at http://www.eclipse.org/legal/epl-v10.html
 *
 * $Id$
 */
package org.unicase.emfstore.esmodel.versioning.operations;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

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
 * @see org.unicase.emfstore.esmodel.versioning.operations.OperationsFactory
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
	String eNS_URI = "http://unicase.org/esmodel/versioning/operations";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "org.unicase.emfstore.esmodel.versioning.operations";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	OperationsPackage eINSTANCE = org.unicase.emfstore.esmodel.versioning.operations.impl.OperationsPackageImpl
			.init();

	/**
	 * The meta object id for the '{@link org.unicase.emfstore.esmodel.versioning.operations.impl.AbstractOperationImpl <em>Abstract Operation</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.unicase.emfstore.esmodel.versioning.operations.impl.AbstractOperationImpl
	 * @see org.unicase.emfstore.esmodel.versioning.operations.impl.OperationsPackageImpl#getAbstractOperation()
	 * @generated
	 */
	int ABSTRACT_OPERATION = 0;

	/**
	 * The number of structural features of the '<em>Abstract Operation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_OPERATION_FEATURE_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.unicase.emfstore.esmodel.versioning.operations.impl.CompositeOperationImpl <em>Composite Operation</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.unicase.emfstore.esmodel.versioning.operations.impl.CompositeOperationImpl
	 * @see org.unicase.emfstore.esmodel.versioning.operations.impl.OperationsPackageImpl#getCompositeOperation()
	 * @generated
	 */
	int COMPOSITE_OPERATION = 1;

	/**
	 * The feature id for the '<em><b>Atomic Operations</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITE_OPERATION__ATOMIC_OPERATIONS = ABSTRACT_OPERATION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITE_OPERATION__NAME = ABSTRACT_OPERATION_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITE_OPERATION__DESCRIPTION = ABSTRACT_OPERATION_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Composite Operation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITE_OPERATION_FEATURE_COUNT = ABSTRACT_OPERATION_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link org.unicase.emfstore.esmodel.versioning.operations.impl.AtomicOperationImpl <em>Atomic Operation</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.unicase.emfstore.esmodel.versioning.operations.impl.AtomicOperationImpl
	 * @see org.unicase.emfstore.esmodel.versioning.operations.impl.OperationsPackageImpl#getAtomicOperation()
	 * @generated
	 */
	int ATOMIC_OPERATION = 5;

	/**
	 * The number of structural features of the '<em>Atomic Operation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATOMIC_OPERATION_FEATURE_COUNT = ABSTRACT_OPERATION_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.unicase.emfstore.esmodel.versioning.operations.impl.FeatureOperationImpl <em>Feature Operation</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.unicase.emfstore.esmodel.versioning.operations.impl.FeatureOperationImpl
	 * @see org.unicase.emfstore.esmodel.versioning.operations.impl.OperationsPackageImpl#getFeatureOperation()
	 * @generated
	 */
	int FEATURE_OPERATION = 2;

	/**
	 * The feature id for the '<em><b>Feature Change</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE_OPERATION__FEATURE_CHANGE = ATOMIC_OPERATION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Feature Operation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE_OPERATION_FEATURE_COUNT = ATOMIC_OPERATION_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.unicase.emfstore.esmodel.versioning.operations.impl.CreateOperationImpl <em>Create Operation</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.unicase.emfstore.esmodel.versioning.operations.impl.CreateOperationImpl
	 * @see org.unicase.emfstore.esmodel.versioning.operations.impl.OperationsPackageImpl#getCreateOperation()
	 * @generated
	 */
	int CREATE_OPERATION = 3;

	/**
	 * The feature id for the '<em><b>Object To Create</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CREATE_OPERATION__OBJECT_TO_CREATE = ATOMIC_OPERATION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Create Operation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CREATE_OPERATION_FEATURE_COUNT = ATOMIC_OPERATION_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.unicase.emfstore.esmodel.versioning.operations.impl.DeleteOperationImpl <em>Delete Operation</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.unicase.emfstore.esmodel.versioning.operations.impl.DeleteOperationImpl
	 * @see org.unicase.emfstore.esmodel.versioning.operations.impl.OperationsPackageImpl#getDeleteOperation()
	 * @generated
	 */
	int DELETE_OPERATION = 4;

	/**
	 * The feature id for the '<em><b>Object To Delete</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DELETE_OPERATION__OBJECT_TO_DELETE = ATOMIC_OPERATION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Delete Operation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DELETE_OPERATION_FEATURE_COUNT = ATOMIC_OPERATION_FEATURE_COUNT + 1;

	/**
	 * Returns the meta object for class '{@link org.unicase.emfstore.esmodel.versioning.operations.AbstractOperation <em>Abstract Operation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Abstract Operation</em>'.
	 * @see org.unicase.emfstore.esmodel.versioning.operations.AbstractOperation
	 * @generated
	 */
	EClass getAbstractOperation();

	/**
	 * Returns the meta object for class '{@link org.unicase.emfstore.esmodel.versioning.operations.CompositeOperation <em>Composite Operation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Composite Operation</em>'.
	 * @see org.unicase.emfstore.esmodel.versioning.operations.CompositeOperation
	 * @generated
	 */
	EClass getCompositeOperation();

	/**
	 * Returns the meta object for the reference list '{@link org.unicase.emfstore.esmodel.versioning.operations.CompositeOperation#getAtomicOperations <em>Atomic Operations</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Atomic Operations</em>'.
	 * @see org.unicase.emfstore.esmodel.versioning.operations.CompositeOperation#getAtomicOperations()
	 * @see #getCompositeOperation()
	 * @generated
	 */
	EReference getCompositeOperation_AtomicOperations();

	/**
	 * Returns the meta object for the attribute '{@link org.unicase.emfstore.esmodel.versioning.operations.CompositeOperation#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.unicase.emfstore.esmodel.versioning.operations.CompositeOperation#getName()
	 * @see #getCompositeOperation()
	 * @generated
	 */
	EAttribute getCompositeOperation_Name();

	/**
	 * Returns the meta object for the attribute '{@link org.unicase.emfstore.esmodel.versioning.operations.CompositeOperation#getDescription <em>Description</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Description</em>'.
	 * @see org.unicase.emfstore.esmodel.versioning.operations.CompositeOperation#getDescription()
	 * @see #getCompositeOperation()
	 * @generated
	 */
	EAttribute getCompositeOperation_Description();

	/**
	 * Returns the meta object for class '{@link org.unicase.emfstore.esmodel.versioning.operations.FeatureOperation <em>Feature Operation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Feature Operation</em>'.
	 * @see org.unicase.emfstore.esmodel.versioning.operations.FeatureOperation
	 * @generated
	 */
	EClass getFeatureOperation();

	/**
	 * Returns the meta object for the reference '{@link org.unicase.emfstore.esmodel.versioning.operations.FeatureOperation#getFeatureChange <em>Feature Change</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Feature Change</em>'.
	 * @see org.unicase.emfstore.esmodel.versioning.operations.FeatureOperation#getFeatureChange()
	 * @see #getFeatureOperation()
	 * @generated
	 */
	EReference getFeatureOperation_FeatureChange();

	/**
	 * Returns the meta object for class '{@link org.unicase.emfstore.esmodel.versioning.operations.CreateOperation <em>Create Operation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Create Operation</em>'.
	 * @see org.unicase.emfstore.esmodel.versioning.operations.CreateOperation
	 * @generated
	 */
	EClass getCreateOperation();

	/**
	 * Returns the meta object for the reference '{@link org.unicase.emfstore.esmodel.versioning.operations.CreateOperation#getObjectToCreate <em>Object To Create</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Object To Create</em>'.
	 * @see org.unicase.emfstore.esmodel.versioning.operations.CreateOperation#getObjectToCreate()
	 * @see #getCreateOperation()
	 * @generated
	 */
	EReference getCreateOperation_ObjectToCreate();

	/**
	 * Returns the meta object for class '{@link org.unicase.emfstore.esmodel.versioning.operations.DeleteOperation <em>Delete Operation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Delete Operation</em>'.
	 * @see org.unicase.emfstore.esmodel.versioning.operations.DeleteOperation
	 * @generated
	 */
	EClass getDeleteOperation();

	/**
	 * Returns the meta object for the reference '{@link org.unicase.emfstore.esmodel.versioning.operations.DeleteOperation#getObjectToDelete <em>Object To Delete</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Object To Delete</em>'.
	 * @see org.unicase.emfstore.esmodel.versioning.operations.DeleteOperation#getObjectToDelete()
	 * @see #getDeleteOperation()
	 * @generated
	 */
	EReference getDeleteOperation_ObjectToDelete();

	/**
	 * Returns the meta object for class '{@link org.unicase.emfstore.esmodel.versioning.operations.AtomicOperation <em>Atomic Operation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Atomic Operation</em>'.
	 * @see org.unicase.emfstore.esmodel.versioning.operations.AtomicOperation
	 * @generated
	 */
	EClass getAtomicOperation();

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
		 * The meta object literal for the '{@link org.unicase.emfstore.esmodel.versioning.operations.impl.AbstractOperationImpl <em>Abstract Operation</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.unicase.emfstore.esmodel.versioning.operations.impl.AbstractOperationImpl
		 * @see org.unicase.emfstore.esmodel.versioning.operations.impl.OperationsPackageImpl#getAbstractOperation()
		 * @generated
		 */
		EClass ABSTRACT_OPERATION = eINSTANCE.getAbstractOperation();

		/**
		 * The meta object literal for the '{@link org.unicase.emfstore.esmodel.versioning.operations.impl.CompositeOperationImpl <em>Composite Operation</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.unicase.emfstore.esmodel.versioning.operations.impl.CompositeOperationImpl
		 * @see org.unicase.emfstore.esmodel.versioning.operations.impl.OperationsPackageImpl#getCompositeOperation()
		 * @generated
		 */
		EClass COMPOSITE_OPERATION = eINSTANCE.getCompositeOperation();

		/**
		 * The meta object literal for the '<em><b>Atomic Operations</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COMPOSITE_OPERATION__ATOMIC_OPERATIONS = eINSTANCE
				.getCompositeOperation_AtomicOperations();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute COMPOSITE_OPERATION__NAME = eINSTANCE
				.getCompositeOperation_Name();

		/**
		 * The meta object literal for the '<em><b>Description</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute COMPOSITE_OPERATION__DESCRIPTION = eINSTANCE
				.getCompositeOperation_Description();

		/**
		 * The meta object literal for the '{@link org.unicase.emfstore.esmodel.versioning.operations.impl.FeatureOperationImpl <em>Feature Operation</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.unicase.emfstore.esmodel.versioning.operations.impl.FeatureOperationImpl
		 * @see org.unicase.emfstore.esmodel.versioning.operations.impl.OperationsPackageImpl#getFeatureOperation()
		 * @generated
		 */
		EClass FEATURE_OPERATION = eINSTANCE.getFeatureOperation();

		/**
		 * The meta object literal for the '<em><b>Feature Change</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FEATURE_OPERATION__FEATURE_CHANGE = eINSTANCE
				.getFeatureOperation_FeatureChange();

		/**
		 * The meta object literal for the '{@link org.unicase.emfstore.esmodel.versioning.operations.impl.CreateOperationImpl <em>Create Operation</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.unicase.emfstore.esmodel.versioning.operations.impl.CreateOperationImpl
		 * @see org.unicase.emfstore.esmodel.versioning.operations.impl.OperationsPackageImpl#getCreateOperation()
		 * @generated
		 */
		EClass CREATE_OPERATION = eINSTANCE.getCreateOperation();

		/**
		 * The meta object literal for the '<em><b>Object To Create</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CREATE_OPERATION__OBJECT_TO_CREATE = eINSTANCE
				.getCreateOperation_ObjectToCreate();

		/**
		 * The meta object literal for the '{@link org.unicase.emfstore.esmodel.versioning.operations.impl.DeleteOperationImpl <em>Delete Operation</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.unicase.emfstore.esmodel.versioning.operations.impl.DeleteOperationImpl
		 * @see org.unicase.emfstore.esmodel.versioning.operations.impl.OperationsPackageImpl#getDeleteOperation()
		 * @generated
		 */
		EClass DELETE_OPERATION = eINSTANCE.getDeleteOperation();

		/**
		 * The meta object literal for the '<em><b>Object To Delete</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DELETE_OPERATION__OBJECT_TO_DELETE = eINSTANCE
				.getDeleteOperation_ObjectToDelete();

		/**
		 * The meta object literal for the '{@link org.unicase.emfstore.esmodel.versioning.operations.impl.AtomicOperationImpl <em>Atomic Operation</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.unicase.emfstore.esmodel.versioning.operations.impl.AtomicOperationImpl
		 * @see org.unicase.emfstore.esmodel.versioning.operations.impl.OperationsPackageImpl#getAtomicOperation()
		 * @generated
		 */
		EClass ATOMIC_OPERATION = eINSTANCE.getAtomicOperation();

	}

} //OperationsPackage
