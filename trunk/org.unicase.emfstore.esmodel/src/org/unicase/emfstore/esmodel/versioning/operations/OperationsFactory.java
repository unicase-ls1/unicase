/**
 * Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this distribution, and is available at http://www.eclipse.org/legal/epl-v10.html
 *
 * $Id$
 */
package org.unicase.emfstore.esmodel.versioning.operations;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.unicase.emfstore.esmodel.versioning.operations.OperationsPackage
 * @generated
 */
public interface OperationsFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	OperationsFactory eINSTANCE = org.unicase.emfstore.esmodel.versioning.operations.impl.OperationsFactoryImpl
			.init();

	/**
	 * Returns a new object of class '<em>Abstract Operation</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Abstract Operation</em>'.
	 * @generated
	 */
	AbstractOperation createAbstractOperation();

	/**
	 * Returns a new object of class '<em>Composite Operation</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Composite Operation</em>'.
	 * @generated
	 */
	CompositeOperation createCompositeOperation();

	/**
	 * Returns a new object of class '<em>Feature Operation</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Feature Operation</em>'.
	 * @generated
	 */
	FeatureOperation createFeatureOperation();

	/**
	 * Returns a new object of class '<em>Create Operation</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Create Operation</em>'.
	 * @generated
	 */
	CreateOperation createCreateOperation();

	/**
	 * Returns a new object of class '<em>Delete Operation</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Delete Operation</em>'.
	 * @generated
	 */
	DeleteOperation createDeleteOperation();

	/**
	 * Returns a new object of class '<em>Atomic Operation</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Atomic Operation</em>'.
	 * @generated
	 */
	AtomicOperation createAtomicOperation();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	OperationsPackage getOperationsPackage();

} //OperationsFactory
