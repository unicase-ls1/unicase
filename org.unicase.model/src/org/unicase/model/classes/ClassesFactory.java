/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Kšgel All rights reserved. This program and the accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this distribution, and is available at http://www.eclipse.org/legal/epl-v10.html
 * </copyright>
 *
 * $Id$
 */
package org.unicase.model.classes;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc --> The <b>Factory</b> for the model. It provides a
 * create method for each non-abstract class of the model. <!-- end-user-doc -->
 * 
 * @see org.unicase.model.classes.ClassesPackage
 * @generated
 */
public interface ClassesFactory extends EFactory {
	/**
	 * The singleton instance of the factory. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 */
	ClassesFactory eINSTANCE = org.unicase.model.classes.impl.ClassesFactoryImpl
			.init();

	/**
	 * Returns a new object of class '<em>Class</em>'. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return a new object of class '<em>Class</em>'.
	 * @generated
	 */
	org.unicase.model.classes.Class createClass();

	/**
	 * Returns a new object of class '<em>Package</em>'. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return a new object of class '<em>Package</em>'.
	 * @generated
	 */
	org.unicase.model.classes.Package createPackage();

	/**
	 * Returns a new object of class '<em>Association</em>'. <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * 
	 * @return a new object of class '<em>Association</em>'.
	 * @generated
	 */
	Association createAssociation();

	/**
	 * Returns the package supported by this factory. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the package supported by this factory.
	 * @generated
	 */
	ClassesPackage getClassesPackage();

} // ClassesFactory
