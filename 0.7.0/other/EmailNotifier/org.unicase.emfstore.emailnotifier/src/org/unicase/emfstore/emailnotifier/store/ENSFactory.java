/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.emfstore.emailnotifier.store;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.unicase.emfstore.emailnotifier.store.ENSPackage
 * @generated
 */
public interface ENSFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	ENSFactory eINSTANCE = org.unicase.emfstore.emailnotifier.store.impl.ENSFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>EMail Notifier Store</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>EMail Notifier Store</em>'.
	 * @generated
	 */
	EMailNotifierStore createEMailNotifierStore();

	/**
	 * Returns a new object of class '<em>Notification Project</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Notification Project</em>'.
	 * @generated
	 */
	ENSNotificationProject createENSNotificationProject();

	/**
	 * Returns a new object of class '<em>User</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>User</em>'.
	 * @generated
	 */
	ENSUser createENSUser();

	/**
	 * Returns a new object of class '<em>Notification Group</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Notification Group</em>'.
	 * @generated
	 */
	ENSNotificationGroup createENSNotificationGroup();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	ENSPackage getENSPackage();

} //ENSFactory
