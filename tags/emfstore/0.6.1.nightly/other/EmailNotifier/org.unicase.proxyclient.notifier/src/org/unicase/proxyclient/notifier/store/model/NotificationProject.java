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
 * A representation of the model object '<em><b>Notification Project</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.unicase.proxyclient.notifier.store.model.NotificationProject#getId <em>Id</em>}</li>
 *   <li>{@link org.unicase.proxyclient.notifier.store.model.NotificationProject#getUserName <em>User Name</em>}</li>
 *   <li>{@link org.unicase.proxyclient.notifier.store.model.NotificationProject#getLastSeenEMail <em>Last Seen EMail</em>}</li>
 *   <li>{@link org.unicase.proxyclient.notifier.store.model.NotificationProject#getGroups <em>Groups</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.unicase.proxyclient.notifier.store.model.NPCPackage#getNotificationProject()
 * @model
 * @generated
 */
public interface NotificationProject extends EObject {
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
	 * @see org.unicase.proxyclient.notifier.store.model.NPCPackage#getNotificationProject_Id()
	 * @model required="true"
	 * @generated
	 */
	String getId();

	/**
	 * Sets the value of the '{@link org.unicase.proxyclient.notifier.store.model.NotificationProject#getId <em>Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Id</em>' attribute.
	 * @see #getId()
	 * @generated
	 */
	void setId(String value);

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
	 * @see org.unicase.proxyclient.notifier.store.model.NPCPackage#getNotificationProject_UserName()
	 * @model required="true"
	 * @generated
	 */
	String getUserName();

	/**
	 * Sets the value of the '{@link org.unicase.proxyclient.notifier.store.model.NotificationProject#getUserName <em>User Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>User Name</em>' attribute.
	 * @see #getUserName()
	 * @generated
	 */
	void setUserName(String value);

	/**
	 * Returns the value of the '<em><b>Last Seen EMail</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Last Seen EMail</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Last Seen EMail</em>' attribute.
	 * @see #setLastSeenEMail(String)
	 * @see org.unicase.proxyclient.notifier.store.model.NPCPackage#getNotificationProject_LastSeenEMail()
	 * @model required="true"
	 * @generated
	 */
	String getLastSeenEMail();

	/**
	 * Sets the value of the '{@link org.unicase.proxyclient.notifier.store.model.NotificationProject#getLastSeenEMail <em>Last Seen EMail</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Last Seen EMail</em>' attribute.
	 * @see #getLastSeenEMail()
	 * @generated
	 */
	void setLastSeenEMail(String value);

	/**
	 * Returns the value of the '<em><b>Groups</b></em>' containment reference list.
	 * The list contents are of type {@link org.unicase.proxyclient.notifier.store.model.NotificationGroup}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Groups</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Groups</em>' containment reference list.
	 * @see org.unicase.proxyclient.notifier.store.model.NPCPackage#getNotificationProject_Groups()
	 * @model containment="true"
	 * @generated
	 */
	EList<NotificationGroup> getGroups();

} // NotificationProject
