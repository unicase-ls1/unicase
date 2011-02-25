/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 *
 * $Id$
 */
package org.unicase.emfstore.jdt.operationstore;

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
 * @see org.unicase.emfstore.jdt.operationstore.OperationstoreFactory
 * @model kind="package"
 * @generated
 */
public interface OperationstorePackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "operationstore";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://emfstore.org/jdt/operationstore";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "org.unicase.emfstore.jdt.operationstore";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	OperationstorePackage eINSTANCE = org.unicase.emfstore.jdt.operationstore.impl.OperationstorePackageImpl.init();

	/**
	 * The meta object id for the '{@link org.unicase.emfstore.jdt.operationstore.impl.OperationStoreImpl <em>Operation Store</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.unicase.emfstore.jdt.operationstore.impl.OperationStoreImpl
	 * @see org.unicase.emfstore.jdt.operationstore.impl.OperationstorePackageImpl#getOperationStore()
	 * @generated
	 */
	int OPERATION_STORE = 0;

	/**
	 * The feature id for the '<em><b>Operation Sets</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION_STORE__OPERATION_SETS = 0;

	/**
	 * The number of structural features of the '<em>Operation Store</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION_STORE_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link org.unicase.emfstore.jdt.operationstore.impl.OperationSetImpl <em>Operation Set</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.unicase.emfstore.jdt.operationstore.impl.OperationSetImpl
	 * @see org.unicase.emfstore.jdt.operationstore.impl.OperationstorePackageImpl#getOperationSet()
	 * @generated
	 */
	int OPERATION_SET = 1;

	/**
	 * The feature id for the '<em><b>Base Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION_SET__BASE_VERSION = 0;

	/**
	 * The feature id for the '<em><b>Operations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION_SET__OPERATIONS = 1;

	/**
	 * The number of structural features of the '<em>Operation Set</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION_SET_FEATURE_COUNT = 2;


	/**
	 * Returns the meta object for class '{@link org.unicase.emfstore.jdt.operationstore.OperationStore <em>Operation Store</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Operation Store</em>'.
	 * @see org.unicase.emfstore.jdt.operationstore.OperationStore
	 * @generated
	 */
	EClass getOperationStore();

	/**
	 * Returns the meta object for the containment reference list '{@link org.unicase.emfstore.jdt.operationstore.OperationStore#getOperationSets <em>Operation Sets</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Operation Sets</em>'.
	 * @see org.unicase.emfstore.jdt.operationstore.OperationStore#getOperationSets()
	 * @see #getOperationStore()
	 * @generated
	 */
	EReference getOperationStore_OperationSets();

	/**
	 * Returns the meta object for class '{@link org.unicase.emfstore.jdt.operationstore.OperationSet <em>Operation Set</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Operation Set</em>'.
	 * @see org.unicase.emfstore.jdt.operationstore.OperationSet
	 * @generated
	 */
	EClass getOperationSet();

	/**
	 * Returns the meta object for the attribute '{@link org.unicase.emfstore.jdt.operationstore.OperationSet#getBaseVersion <em>Base Version</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Base Version</em>'.
	 * @see org.unicase.emfstore.jdt.operationstore.OperationSet#getBaseVersion()
	 * @see #getOperationSet()
	 * @generated
	 */
	EAttribute getOperationSet_BaseVersion();

	/**
	 * Returns the meta object for the containment reference list '{@link org.unicase.emfstore.jdt.operationstore.OperationSet#getOperations <em>Operations</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Operations</em>'.
	 * @see org.unicase.emfstore.jdt.operationstore.OperationSet#getOperations()
	 * @see #getOperationSet()
	 * @generated
	 */
	EReference getOperationSet_Operations();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	OperationstoreFactory getOperationstoreFactory();

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
		 * The meta object literal for the '{@link org.unicase.emfstore.jdt.operationstore.impl.OperationStoreImpl <em>Operation Store</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.unicase.emfstore.jdt.operationstore.impl.OperationStoreImpl
		 * @see org.unicase.emfstore.jdt.operationstore.impl.OperationstorePackageImpl#getOperationStore()
		 * @generated
		 */
		EClass OPERATION_STORE = eINSTANCE.getOperationStore();

		/**
		 * The meta object literal for the '<em><b>Operation Sets</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference OPERATION_STORE__OPERATION_SETS = eINSTANCE.getOperationStore_OperationSets();

		/**
		 * The meta object literal for the '{@link org.unicase.emfstore.jdt.operationstore.impl.OperationSetImpl <em>Operation Set</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.unicase.emfstore.jdt.operationstore.impl.OperationSetImpl
		 * @see org.unicase.emfstore.jdt.operationstore.impl.OperationstorePackageImpl#getOperationSet()
		 * @generated
		 */
		EClass OPERATION_SET = eINSTANCE.getOperationSet();

		/**
		 * The meta object literal for the '<em><b>Base Version</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute OPERATION_SET__BASE_VERSION = eINSTANCE.getOperationSet_BaseVersion();

		/**
		 * The meta object literal for the '<em><b>Operations</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference OPERATION_SET__OPERATIONS = eINSTANCE.getOperationSet_Operations();

	}

} //OperationstorePackage
