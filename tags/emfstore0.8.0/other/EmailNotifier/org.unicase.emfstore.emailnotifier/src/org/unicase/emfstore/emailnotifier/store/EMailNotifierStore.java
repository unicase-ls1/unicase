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
 * A representation of the model object '<em><b>EMail Notifier Store</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.unicase.emfstore.emailnotifier.store.EMailNotifierStore#getProjects <em>Projects</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.unicase.emfstore.emailnotifier.store.ENSPackage#getEMailNotifierStore()
 * @model
 * @generated
 */
public interface EMailNotifierStore extends EObject {
	/**
	 * Returns the value of the '<em><b>Projects</b></em>' containment reference list.
	 * The list contents are of type {@link org.unicase.emfstore.emailnotifier.store.ENSNotificationProject}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Projects</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Projects</em>' containment reference list.
	 * @see org.unicase.emfstore.emailnotifier.store.ENSPackage#getEMailNotifierStore_Projects()
	 * @model containment="true"
	 * @generated
	 */
	EList<ENSNotificationProject> getProjects();

} // EMailNotifierStore
