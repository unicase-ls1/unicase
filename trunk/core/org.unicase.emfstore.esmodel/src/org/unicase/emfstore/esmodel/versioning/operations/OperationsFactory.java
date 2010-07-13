/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.emfstore.esmodel.versioning.operations;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc --> The <b>Factory</b> for the model. It provides a create method for each non-abstract class of
 * the model. <!-- end-user-doc -->
 * 
 * @see org.unicase.emfstore.esmodel.versioning.operations.OperationsPackage
 * @generated
 */
public interface OperationsFactory extends EFactory {
	/**
	 * The singleton instance of the factory. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	OperationsFactory eINSTANCE = org.unicase.emfstore.esmodel.versioning.operations.impl.OperationsFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Composite Operation</em>'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return a new object of class '<em>Composite Operation</em>'.
	 * @generated
	 */
	CompositeOperation createCompositeOperation();

	/**
	 * Returns a new object of class '<em>Create Delete Operation</em>'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return a new object of class '<em>Create Delete Operation</em>'.
	 * @generated
	 */
	CreateDeleteOperation createCreateDeleteOperation();

	/**
	 * Returns a new object of class '<em>Attribute Operation</em>'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return a new object of class '<em>Attribute Operation</em>'.
	 * @generated
	 */
	AttributeOperation createAttributeOperation();

	/**
	 * Returns a new object of class '<em>Multi Attribute Operation</em>'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return a new object of class '<em>Multi Attribute Operation</em>'.
	 * @generated
	 */
	MultiAttributeOperation createMultiAttributeOperation();

	/**
	 * Returns a new object of class '<em>Multi Attribute Set Operation</em>'. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @return a new object of class '<em>Multi Attribute Set Operation</em>'.
	 * @generated
	 */
	MultiAttributeSetOperation createMultiAttributeSetOperation();

	/**
	 * Returns a new object of class '<em>Multi Attribute Move Operation</em>'. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @return a new object of class '<em>Multi Attribute Move Operation</em>'.
	 * @generated
	 */
	MultiAttributeMoveOperation createMultiAttributeMoveOperation();

	/**
	 * Returns a new object of class '<em>Single Reference Operation</em>'. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @return a new object of class '<em>Single Reference Operation</em>'.
	 * @generated
	 */
	SingleReferenceOperation createSingleReferenceOperation();

	/**
	 * Returns a new object of class '<em>Multi Reference Operation</em>'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return a new object of class '<em>Multi Reference Operation</em>'.
	 * @generated
	 */
	MultiReferenceOperation createMultiReferenceOperation();

	/**
	 * Returns a new object of class '<em>Multi Reference Set Operation</em>'. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @return a new object of class '<em>Multi Reference Set Operation</em>'.
	 * @generated
	 */
	MultiReferenceSetOperation createMultiReferenceSetOperation();

	/**
	 * Returns a new object of class '<em>Multi Reference Move Operation</em>'. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @return a new object of class '<em>Multi Reference Move Operation</em>'.
	 * @generated
	 */
	MultiReferenceMoveOperation createMultiReferenceMoveOperation();

	/**
	 * Returns a new object of class '<em>Diagram Layout Operation</em>'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return a new object of class '<em>Diagram Layout Operation</em>'.
	 * @generated
	 */
	DiagramLayoutOperation createDiagramLayoutOperation();

	/**
	 * Returns a new object of class '<em>Operation Id</em>'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return a new object of class '<em>Operation Id</em>'.
	 * @generated
	 */
	OperationId createOperationId();

	/**
	 * Returns a new object of class '<em>Operation Group</em>'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return a new object of class '<em>Operation Group</em>'.
	 * @generated
	 */
	OperationGroup createOperationGroup();

	/**
	 * Returns a new object of class '<em>Model Element Group</em>'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return a new object of class '<em>Model Element Group</em>'.
	 * @generated
	 */
	ModelElementGroup createModelElementGroup();

	/**
	 * Returns the package supported by this factory. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the package supported by this factory.
	 * @generated
	 */
	OperationsPackage getOperationsPackage();

} // OperationsFactory
