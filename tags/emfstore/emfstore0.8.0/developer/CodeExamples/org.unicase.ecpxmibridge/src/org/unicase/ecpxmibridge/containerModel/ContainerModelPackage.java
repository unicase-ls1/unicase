/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ecpxmibridge.containerModel;

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
 * @see org.unicase.ecpxmibridge.containerModel.ContainerModelFactory
 * @model kind="package"
 * @generated
 */
public interface ContainerModelPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "containerModel";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://unicase.org/ecpxmibridge/containerModel";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "org.unicase.ecpxmibridge.containerModel";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	ContainerModelPackage eINSTANCE = org.unicase.ecpxmibridge.containerModel.impl.ContainerModelPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.unicase.ecpxmibridge.containerModel.impl.XMIRootContainerImpl <em>XMI Root Container</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.unicase.ecpxmibridge.containerModel.impl.XMIRootContainerImpl
	 * @see org.unicase.ecpxmibridge.containerModel.impl.ContainerModelPackageImpl#getXMIRootContainer()
	 * @generated
	 */
	int XMI_ROOT_CONTAINER = 0;

	/**
	 * The feature id for the '<em><b>Contents</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XMI_ROOT_CONTAINER__CONTENTS = 0;

	/**
	 * The number of structural features of the '<em>XMI Root Container</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XMI_ROOT_CONTAINER_FEATURE_COUNT = 1;


	/**
	 * Returns the meta object for class '{@link org.unicase.ecpxmibridge.containerModel.XMIRootContainer <em>XMI Root Container</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>XMI Root Container</em>'.
	 * @see org.unicase.ecpxmibridge.containerModel.XMIRootContainer
	 * @generated
	 */
	EClass getXMIRootContainer();

	/**
	 * Returns the meta object for the containment reference list '{@link org.unicase.ecpxmibridge.containerModel.XMIRootContainer#getContents <em>Contents</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Contents</em>'.
	 * @see org.unicase.ecpxmibridge.containerModel.XMIRootContainer#getContents()
	 * @see #getXMIRootContainer()
	 * @generated
	 */
	EReference getXMIRootContainer_Contents();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	ContainerModelFactory getContainerModelFactory();

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
		 * The meta object literal for the '{@link org.unicase.ecpxmibridge.containerModel.impl.XMIRootContainerImpl <em>XMI Root Container</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.unicase.ecpxmibridge.containerModel.impl.XMIRootContainerImpl
		 * @see org.unicase.ecpxmibridge.containerModel.impl.ContainerModelPackageImpl#getXMIRootContainer()
		 * @generated
		 */
		EClass XMI_ROOT_CONTAINER = eINSTANCE.getXMIRootContainer();

		/**
		 * The meta object literal for the '<em><b>Contents</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference XMI_ROOT_CONTAINER__CONTENTS = eINSTANCE.getXMIRootContainer_Contents();

	}

} //ContainerModelPackage
