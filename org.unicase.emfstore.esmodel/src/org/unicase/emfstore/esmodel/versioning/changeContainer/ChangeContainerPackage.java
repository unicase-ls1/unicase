/**
 * Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this distribution, and is available at http://www.eclipse.org/legal/epl-v10.html
 *
 * $Id$
 */
package org.unicase.emfstore.esmodel.versioning.changeContainer;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;

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
 * @see org.unicase.emfstore.esmodel.versioning.changeContainer.ChangeContainerFactory
 * @model kind="package"
 * @generated
 */
public interface ChangeContainerPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "changeContainer";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://unicase.org/esmodel/versioning/changeContainer";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "org.unicase.emfstore.esmodel.versioning.changeContainer";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	ChangeContainerPackage eINSTANCE = org.unicase.emfstore.esmodel.versioning.changeContainer.impl.ChangeContainerPackageImpl
			.init();

	/**
	 * The meta object id for the '{@link org.unicase.emfstore.esmodel.versioning.changeContainer.impl.ChangeContainerImpl <em>Change Container</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.unicase.emfstore.esmodel.versioning.changeContainer.impl.ChangeContainerImpl
	 * @see org.unicase.emfstore.esmodel.versioning.changeContainer.impl.ChangeContainerPackageImpl#getChangeContainer()
	 * @generated
	 */
	int CHANGE_CONTAINER = 0;

	/**
	 * The feature id for the '<em><b>Forward Delta</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHANGE_CONTAINER__FORWARD_DELTA = 0;

	/**
	 * The feature id for the '<em><b>Backward Delta</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHANGE_CONTAINER__BACKWARD_DELTA = 1;

	/**
	 * The number of structural features of the '<em>Change Container</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHANGE_CONTAINER_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link org.unicase.emfstore.esmodel.versioning.changeContainer.impl.CompositeChangeContainerImpl <em>Composite Change Container</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.unicase.emfstore.esmodel.versioning.changeContainer.impl.CompositeChangeContainerImpl
	 * @see org.unicase.emfstore.esmodel.versioning.changeContainer.impl.ChangeContainerPackageImpl#getCompositeChangeContainer()
	 * @generated
	 */
	int COMPOSITE_CHANGE_CONTAINER = 1;

	/**
	 * The feature id for the '<em><b>Forward Delta</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITE_CHANGE_CONTAINER__FORWARD_DELTA = CHANGE_CONTAINER__FORWARD_DELTA;

	/**
	 * The feature id for the '<em><b>Backward Delta</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITE_CHANGE_CONTAINER__BACKWARD_DELTA = CHANGE_CONTAINER__BACKWARD_DELTA;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITE_CHANGE_CONTAINER__NAME = CHANGE_CONTAINER_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITE_CHANGE_CONTAINER__DESCRIPTION = CHANGE_CONTAINER_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Composite Change Container</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITE_CHANGE_CONTAINER_FEATURE_COUNT = CHANGE_CONTAINER_FEATURE_COUNT + 2;

	/**
	 * Returns the meta object for class '{@link org.unicase.emfstore.esmodel.versioning.changeContainer.ChangeContainer <em>Change Container</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Change Container</em>'.
	 * @see org.unicase.emfstore.esmodel.versioning.changeContainer.ChangeContainer
	 * @generated
	 */
	EClass getChangeContainer();

	/**
	 * Returns the meta object for the attribute '{@link org.unicase.emfstore.esmodel.versioning.changeContainer.ChangeContainer#getForwardDelta <em>Forward Delta</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Forward Delta</em>'.
	 * @see org.unicase.emfstore.esmodel.versioning.changeContainer.ChangeContainer#getForwardDelta()
	 * @see #getChangeContainer()
	 * @generated
	 */
	EAttribute getChangeContainer_ForwardDelta();

	/**
	 * Returns the meta object for the attribute '{@link org.unicase.emfstore.esmodel.versioning.changeContainer.ChangeContainer#getBackwardDelta <em>Backward Delta</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Backward Delta</em>'.
	 * @see org.unicase.emfstore.esmodel.versioning.changeContainer.ChangeContainer#getBackwardDelta()
	 * @see #getChangeContainer()
	 * @generated
	 */
	EAttribute getChangeContainer_BackwardDelta();

	/**
	 * Returns the meta object for class '{@link org.unicase.emfstore.esmodel.versioning.changeContainer.CompositeChangeContainer <em>Composite Change Container</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Composite Change Container</em>'.
	 * @see org.unicase.emfstore.esmodel.versioning.changeContainer.CompositeChangeContainer
	 * @generated
	 */
	EClass getCompositeChangeContainer();

	/**
	 * Returns the meta object for the attribute '{@link org.unicase.emfstore.esmodel.versioning.changeContainer.CompositeChangeContainer#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.unicase.emfstore.esmodel.versioning.changeContainer.CompositeChangeContainer#getName()
	 * @see #getCompositeChangeContainer()
	 * @generated
	 */
	EAttribute getCompositeChangeContainer_Name();

	/**
	 * Returns the meta object for the attribute '{@link org.unicase.emfstore.esmodel.versioning.changeContainer.CompositeChangeContainer#getDescription <em>Description</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Description</em>'.
	 * @see org.unicase.emfstore.esmodel.versioning.changeContainer.CompositeChangeContainer#getDescription()
	 * @see #getCompositeChangeContainer()
	 * @generated
	 */
	EAttribute getCompositeChangeContainer_Description();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	ChangeContainerFactory getChangeContainerFactory();

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
		 * The meta object literal for the '{@link org.unicase.emfstore.esmodel.versioning.changeContainer.impl.ChangeContainerImpl <em>Change Container</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.unicase.emfstore.esmodel.versioning.changeContainer.impl.ChangeContainerImpl
		 * @see org.unicase.emfstore.esmodel.versioning.changeContainer.impl.ChangeContainerPackageImpl#getChangeContainer()
		 * @generated
		 */
		EClass CHANGE_CONTAINER = eINSTANCE.getChangeContainer();

		/**
		 * The meta object literal for the '<em><b>Forward Delta</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CHANGE_CONTAINER__FORWARD_DELTA = eINSTANCE
				.getChangeContainer_ForwardDelta();

		/**
		 * The meta object literal for the '<em><b>Backward Delta</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CHANGE_CONTAINER__BACKWARD_DELTA = eINSTANCE
				.getChangeContainer_BackwardDelta();

		/**
		 * The meta object literal for the '{@link org.unicase.emfstore.esmodel.versioning.changeContainer.impl.CompositeChangeContainerImpl <em>Composite Change Container</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.unicase.emfstore.esmodel.versioning.changeContainer.impl.CompositeChangeContainerImpl
		 * @see org.unicase.emfstore.esmodel.versioning.changeContainer.impl.ChangeContainerPackageImpl#getCompositeChangeContainer()
		 * @generated
		 */
		EClass COMPOSITE_CHANGE_CONTAINER = eINSTANCE
				.getCompositeChangeContainer();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute COMPOSITE_CHANGE_CONTAINER__NAME = eINSTANCE
				.getCompositeChangeContainer_Name();

		/**
		 * The meta object literal for the '<em><b>Description</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute COMPOSITE_CHANGE_CONTAINER__DESCRIPTION = eINSTANCE
				.getCompositeChangeContainer_Description();

	}

} //ChangeContainerPackage
