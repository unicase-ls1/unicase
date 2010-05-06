/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.analyzer.iterator;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc --> The <b>Factory</b> for the model. It provides a create method for each non-abstract class of
 * the model. <!-- end-user-doc -->
 * @see org.unicase.analyzer.iterator.IteratorPackage
 * @generated
 */
public interface IteratorFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	IteratorFactory eINSTANCE = org.unicase.analyzer.iterator.impl.IteratorFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Version Iterator</em>'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return a new object of class '<em>Version Iterator</em>'.
	 * @generated
	 */
	VersionIterator createVersionIterator();

	/**
	 * Returns a new object of class '<em>Time Iterator</em>'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return a new object of class '<em>Time Iterator</em>'.
	 * @generated
	 */
	TimeIterator createTimeIterator();

	/**
	 * Returns a new object of class '<em>Version Spec Query</em>'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return a new object of class '<em>Version Spec Query</em>'.
	 * @generated
	 */
	VersionSpecQuery createVersionSpecQuery();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	IteratorPackage getIteratorPackage();

} // IteratorFactory
