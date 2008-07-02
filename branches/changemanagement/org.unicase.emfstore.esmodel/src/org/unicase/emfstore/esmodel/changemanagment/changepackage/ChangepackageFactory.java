/**
 * Copyright (c) 2008 Jonas Helming, Maximilian Kšgel
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * $Id$
 */
package org.unicase.emfstore.esmodel.changemanagment.changepackage;

import org.eclipse.emf.ecore.EFactory;
import org.eclipse.emf.ecore.change.ChangeDescription;

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
	 * Returns a new object of class '<em>Changepackage</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Changepackage</em>'.
	 * @generated
	 */
	Changepackage createChangepackage();
	
	/**
	 * Converts a {@link ChangeDescription} into our ChangePackage format.
	 * 
	 * @param changeDescription a changedescription
	 * @return a changepackage
	 */
	Changepackage convertToChangepackage(ChangeDescription changeDescription);

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
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	ChangepackagePackage getChangepackagePackage();

} //ChangepackageFactory
