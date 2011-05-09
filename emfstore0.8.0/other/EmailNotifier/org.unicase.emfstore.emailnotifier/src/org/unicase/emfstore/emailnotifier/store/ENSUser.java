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
 * A representation of the model object '<em><b>User</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.unicase.emfstore.emailnotifier.store.ENSUser#getUserName <em>User Name</em>}</li>
 *   <li>{@link org.unicase.emfstore.emailnotifier.store.ENSUser#getUserEMail <em>User EMail</em>}</li>
 *   <li>{@link org.unicase.emfstore.emailnotifier.store.ENSUser#getGroups <em>Groups</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.unicase.emfstore.emailnotifier.store.ENSPackage#getENSUser()
 * @model
 * @generated
 */
public interface ENSUser extends EObject {
	/**
	 * Returns the value of the '<em><b>User Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>User Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>User Name</em>' attribute.
	 * @see #setUserName(String)
	 * @see org.unicase.emfstore.emailnotifier.store.ENSPackage#getENSUser_UserName()
	 * @model required="true"
	 * @generated
	 */
	String getUserName();

	/**
	 * Sets the value of the '{@link org.unicase.emfstore.emailnotifier.store.ENSUser#getUserName <em>User Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>User Name</em>' attribute.
	 * @see #getUserName()
	 * @generated
	 */
	void setUserName(String value);

	/**
	 * Returns the value of the '<em><b>User EMail</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>User EMail</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>User EMail</em>' attribute.
	 * @see #setUserEMail(String)
	 * @see org.unicase.emfstore.emailnotifier.store.ENSPackage#getENSUser_UserEMail()
	 * @model required="true"
	 * @generated
	 */
	String getUserEMail();

	/**
	 * Sets the value of the '{@link org.unicase.emfstore.emailnotifier.store.ENSUser#getUserEMail <em>User EMail</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>User EMail</em>' attribute.
	 * @see #getUserEMail()
	 * @generated
	 */
	void setUserEMail(String value);

	/**
	 * Returns the value of the '<em><b>Groups</b></em>' containment reference list.
	 * The list contents are of type {@link org.unicase.emfstore.emailnotifier.store.ENSNotificationGroup}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Groups</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Groups</em>' containment reference list.
	 * @see org.unicase.emfstore.emailnotifier.store.ENSPackage#getENSUser_Groups()
	 * @model containment="true"
	 * @generated
	 */
	EList<ENSNotificationGroup> getGroups();

} // ENSUser
