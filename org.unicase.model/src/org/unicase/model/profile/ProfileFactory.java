/**
 * <copyright> Copyright (c) 2015-2016 Chair of Applied Software Engineering, Technische Universität München (TUM).
 * All rights reserved. This program and the accompanying materials are made available under the terms of
 * the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.model.profile;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc --> The <b>Factory</b> for the model. It provides a create method for each non-abstract class of
 * the model. <!-- end-user-doc -->
 * @see org.unicase.model.profile.ProfilePackage
 * @generated
 */
public interface ProfileFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	ProfileFactory eINSTANCE = org.unicase.model.profile.impl.ProfileFactoryImpl
			.init();

	/**
	 * Returns a new object of class '<em>Profile</em>'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return a new object of class '<em>Profile</em>'.
	 * @generated
	 */
	Profile createProfile();

	/**
	 * Returns a new object of class '<em>Stereotype</em>'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return a new object of class '<em>Stereotype</em>'.
	 * @generated
	 */
	Stereotype createStereotype();

	/**
	 * Returns a new object of class '<em>Stereotype Instance</em>'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return a new object of class '<em>Stereotype Instance</em>'.
	 * @generated
	 */
	StereotypeInstance createStereotypeInstance();

	/**
	 * Returns a new object of class '<em>Stereotype Attribute Simple</em>'. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @return a new object of class '<em>Stereotype Attribute Simple</em>'.
	 * @generated
	 */
	StereotypeAttributeSimple createStereotypeAttributeSimple();

	/**
	 * Returns a new object of class '<em>Stereotype Attribute Instance String</em>'.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @return a new object of class '<em>Stereotype Attribute Instance String</em>'.
	 * @generated
	 */
	StereotypeAttributeInstanceString createStereotypeAttributeInstanceString();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	ProfilePackage getProfilePackage();

} // ProfileFactory
