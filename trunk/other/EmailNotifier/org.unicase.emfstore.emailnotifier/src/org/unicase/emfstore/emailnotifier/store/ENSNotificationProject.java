/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.emfstore.emailnotifier.store;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Notification Project</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.unicase.emfstore.emailnotifier.store.ENSNotificationProject#getId <em>Id</em>}</li>
 *   <li>{@link org.unicase.emfstore.emailnotifier.store.ENSNotificationProject#getLatestVersion <em>Latest Version</em>}</li>
 *   <li>{@link org.unicase.emfstore.emailnotifier.store.ENSNotificationProject#getUsers <em>Users</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.unicase.emfstore.emailnotifier.store.ENSPackage#getENSNotificationProject()
 * @model
 * @generated
 */
public interface ENSNotificationProject extends EObject {
	/**
	 * Returns the value of the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Id</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Id</em>' attribute.
	 * @see #setId(String)
	 * @see org.unicase.emfstore.emailnotifier.store.ENSPackage#getENSNotificationProject_Id()
	 * @model required="true"
	 * @generated
	 */
	String getId();

	/**
	 * Sets the value of the '{@link org.unicase.emfstore.emailnotifier.store.ENSNotificationProject#getId <em>Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Id</em>' attribute.
	 * @see #getId()
	 * @generated
	 */
	void setId(String value);

	/**
	 * Returns the value of the '<em><b>Latest Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Latest Version</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Latest Version</em>' attribute.
	 * @see #setLatestVersion(int)
	 * @see org.unicase.emfstore.emailnotifier.store.ENSPackage#getENSNotificationProject_LatestVersion()
	 * @model required="true"
	 * @generated
	 */
	int getLatestVersion();

	/**
	 * Sets the value of the '{@link org.unicase.emfstore.emailnotifier.store.ENSNotificationProject#getLatestVersion <em>Latest Version</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Latest Version</em>' attribute.
	 * @see #getLatestVersion()
	 * @generated
	 */
	void setLatestVersion(int value);

	/**
	 * Returns the value of the '<em><b>Users</b></em>' containment reference list.
	 * The list contents are of type {@link org.unicase.emfstore.emailnotifier.store.ENSUser}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Users</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Users</em>' containment reference list.
	 * @see org.unicase.emfstore.emailnotifier.store.ENSPackage#getENSNotificationProject_Users()
	 * @model containment="true"
	 * @generated
	 */
	EList<ENSUser> getUsers();

} // ENSNotificationProject
