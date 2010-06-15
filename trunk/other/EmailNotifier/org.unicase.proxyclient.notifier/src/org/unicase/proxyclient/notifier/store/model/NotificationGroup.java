/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.proxyclient.notifier.store.model;

import java.util.Date;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Notification Group</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.unicase.proxyclient.notifier.store.model.NotificationGroup#getName <em>Name</em>}</li>
 *   <li>{@link org.unicase.proxyclient.notifier.store.model.NotificationGroup#getNextSending <em>Next Sending</em>}</li>
 *   <li>{@link org.unicase.proxyclient.notifier.store.model.NotificationGroup#getNotifications <em>Notifications</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.unicase.proxyclient.notifier.store.model.NPCPackage#getNotificationGroup()
 * @model
 * @generated
 * 
 * @author staudta
 */
public interface NotificationGroup extends EObject {
	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see org.unicase.proxyclient.notifier.store.model.NPCPackage#getNotificationGroup_Name()
	 * @model required="true"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link org.unicase.proxyclient.notifier.store.model.NotificationGroup#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Next Sending</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Next Sending</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Next Sending</em>' attribute.
	 * @see #setNextSending(Date)
	 * @see org.unicase.proxyclient.notifier.store.model.NPCPackage#getNotificationGroup_NextSending()
	 * @model required="true"
	 * @generated
	 */
	Date getNextSending();

	/**
	 * Sets the value of the '{@link org.unicase.proxyclient.notifier.store.model.NotificationGroup#getNextSending <em>Next Sending</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Next Sending</em>' attribute.
	 * @see #getNextSending()
	 * @generated
	 */
	void setNextSending(Date value);

	/**
	 * Returns the value of the '<em><b>Notifications</b></em>' containment reference list.
	 * The list contents are of type {@link org.unicase.proxyclient.notifier.store.model.NotificationEntry}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Notifications</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Notifications</em>' containment reference list.
	 * @see org.unicase.proxyclient.notifier.store.model.NPCPackage#getNotificationGroup_Notifications()
	 * @model containment="true"
	 * @generated
	 */
	EList<NotificationEntry> getNotifications();

} // NotificationGroup
