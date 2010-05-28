/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.unicase.proxyclient.notifier.store.model;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Notifier Proxy Client Store</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.unicase.proxyclient.notifier.store.model.NotifierProxyClientStore#getProjects <em>Projects</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.unicase.proxyclient.notifier.store.model.NPCPackage#getNotifierProxyClientStore()
 * @model
 * @generated
 */
public interface NotifierProxyClientStore extends EObject {
	/**
	 * Returns the value of the '<em><b>Projects</b></em>' containment reference list.
	 * The list contents are of type {@link org.unicase.proxyclient.notifier.store.model.NotificationProject}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Projects</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Projects</em>' containment reference list.
	 * @see org.unicase.proxyclient.notifier.store.model.NPCPackage#getNotifierProxyClientStore_Projects()
	 * @model containment="true"
	 * @generated
	 */
	EList<NotificationProject> getProjects();

} // NotifierProxyClientStore
