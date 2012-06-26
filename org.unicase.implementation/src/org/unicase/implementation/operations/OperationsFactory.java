/**
 * <copyright> Copyright (c) 2009-2012 Chair of Applied Software Engineering, Technische Universität München (TUM).
 * All rights reserved. This program and the accompanying materials are made available under the terms of
 * the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.implementation.operations;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc --> The <b>Factory</b> for the model. It provides a create method for each non-abstract class of
 * the model. <!-- end-user-doc -->
 * @see org.unicase.implementation.operations.OperationsPackage
 * @generated
 */
public interface OperationsFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	OperationsFactory eINSTANCE = org.unicase.implementation.operations.impl.OperationsFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Extract Super Class Operation</em>'. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @return a new object of class '<em>Extract Super Class Operation</em>'.
	 * @generated
	 */
	ExtractSuperClassOperation createExtractSuperClassOperation();

	/**
	 * Returns a new object of class '<em>Inline Super Class Operation</em>'. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @return a new object of class '<em>Inline Super Class Operation</em>'.
	 * @generated
	 */
	InlineSuperClassOperation createInlineSuperClassOperation();

	/**
	 * Returns a new object of class '<em>Inline Class Operation</em>'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return a new object of class '<em>Inline Class Operation</em>'.
	 * @generated
	 */
	InlineClassOperation createInlineClassOperation();

	/**
	 * Returns a new object of class '<em>Extract Class Operation</em>'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return a new object of class '<em>Extract Class Operation</em>'.
	 * @generated
	 */
	ExtractClassOperation createExtractClassOperation();

	/**
	 * Returns a new object of class '<em>Partition Association Operation</em>'.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @return a new object of class '<em>Partition Association Operation</em>'.
	 * @generated
	 */
	PartitionAssociationOperation createPartitionAssociationOperation();

	/**
	 * Returns a new object of class '<em>Push Down Operation</em>'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return a new object of class '<em>Push Down Operation</em>'.
	 * @generated
	 */
	PushDownOperation createPushDownOperation();

	/**
	 * Returns a new object of class '<em>Pull Up Operation</em>'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return a new object of class '<em>Pull Up Operation</em>'.
	 * @generated
	 */
	PullUpOperation createPullUpOperation();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	OperationsPackage getOperationsPackage();

} // OperationsFactory
