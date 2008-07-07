/**
 * Copyright (c) 2008 Jonas Helming, Maximilian Kögel
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * $Id$
 */
package org.unicase.emfstore.esmodel.changemanagment.changepackage;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.unicase.emfstore.esmodel.changemanagment.changepackage.ChangepackagePackage
 * @generated
 */
public interface ChangepackageFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	ChangepackageFactory eINSTANCE = org.unicase.emfstore.esmodel.changemanagment.changepackage.impl.ChangepackageFactoryImpl
			.init();

	/**
	 * Returns a new object of class '<em>Change Package</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Change Package</em>'.
	 * @generated
	 */
	ChangePackage createChangePackage();

	/**
	 * Returns a new object of class '<em>ES Operation</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>ES Operation</em>'.
	 * @generated
	 */
	ESOperation createESOperation();

	/**
	 * Returns a new object of class '<em>ESe Attribute Event</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>ESe Attribute Event</em>'.
	 * @generated
	 */
	ESeAttributeEvent createESeAttributeEvent();

	/**
	 * Returns a new object of class '<em>ES List Event</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>ES List Event</em>'.
	 * @generated
	 */
	ESListEvent createESListEvent();

	/**
	 * Returns a new object of class '<em>ES Modify Element Event</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>ES Modify Element Event</em>'.
	 * @generated
	 */
	ESModifyElementEvent createESModifyElementEvent();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	ChangepackagePackage getChangepackagePackage();

} //ChangepackageFactory
