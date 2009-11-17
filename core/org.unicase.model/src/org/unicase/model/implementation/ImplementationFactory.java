/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.model.implementation;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc --> The <b>Factory</b> for the model. It provides a create method for each non-abstract class of
 * the model. <!-- end-user-doc -->
 * 
 * @see org.unicase.model.implementation.ImplementationPackage
 * @generated
 */
public interface ImplementationFactory extends EFactory {
	/**
	 * The singleton instance of the factory. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	ImplementationFactory eINSTANCE = org.unicase.model.implementation.impl.ImplementationFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>IPackage</em>'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return a new object of class '<em>IPackage</em>'.
	 * @generated
	 */
	IPackage createIPackage();

	/**
	 * Returns a new object of class '<em>IClass</em>'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return a new object of class '<em>IClass</em>'.
	 * @generated
	 */
	IClass createIClass();

	/**
	 * Returns a new object of class '<em>IAttribute</em>'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return a new object of class '<em>IAttribute</em>'.
	 * @generated
	 */
	IAttribute createIAttribute();

	/**
	 * Returns a new object of class '<em>IReference</em>'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return a new object of class '<em>IReference</em>'.
	 * @generated
	 */
	IReference createIReference();

	/**
	 * Returns a new object of class '<em>IEnumeration</em>'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return a new object of class '<em>IEnumeration</em>'.
	 * @generated
	 */
	IEnumeration createIEnumeration();

	/**
	 * Returns a new object of class '<em>ILiteral</em>'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return a new object of class '<em>ILiteral</em>'.
	 * @generated
	 */
	ILiteral createILiteral();

	/**
	 * Returns the package supported by this factory. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the package supported by this factory.
	 * @generated
	 */
	ImplementationPackage getImplementationPackage();

} // ImplementationFactory
