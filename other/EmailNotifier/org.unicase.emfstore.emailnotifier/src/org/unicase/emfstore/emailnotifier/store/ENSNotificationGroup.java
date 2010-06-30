/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.emfstore.emailnotifier.store;

import java.util.Date;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Notification Group</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.unicase.emfstore.emailnotifier.store.ENSNotificationGroup#getName <em>Name</em>}</li>
 *   <li>{@link org.unicase.emfstore.emailnotifier.store.ENSNotificationGroup#getSendOption <em>Send Option</em>}</li>
 *   <li>{@link org.unicase.emfstore.emailnotifier.store.ENSNotificationGroup#getBaseVersion <em>Base Version</em>}</li>
 *   <li>{@link org.unicase.emfstore.emailnotifier.store.ENSNotificationGroup#getNextSendingDate <em>Next Sending Date</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.unicase.emfstore.emailnotifier.store.ENSPackage#getENSNotificationGroup()
 * @model
 * @generated
 */
public interface ENSNotificationGroup extends EObject {
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
	 * @see org.unicase.emfstore.emailnotifier.store.ENSPackage#getENSNotificationGroup_Name()
	 * @model required="true"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link org.unicase.emfstore.emailnotifier.store.ENSNotificationGroup#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Send Option</b></em>' attribute.
	 * The literals are from the enumeration {@link org.unicase.emfstore.emailnotifier.store.SendOption}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Send Option</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Send Option</em>' attribute.
	 * @see org.unicase.emfstore.emailnotifier.store.SendOption
	 * @see #setSendOption(SendOption)
	 * @see org.unicase.emfstore.emailnotifier.store.ENSPackage#getENSNotificationGroup_SendOption()
	 * @model required="true"
	 * @generated
	 */
	SendOption getSendOption();

	/**
	 * Sets the value of the '{@link org.unicase.emfstore.emailnotifier.store.ENSNotificationGroup#getSendOption <em>Send Option</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Send Option</em>' attribute.
	 * @see org.unicase.emfstore.emailnotifier.store.SendOption
	 * @see #getSendOption()
	 * @generated
	 */
	void setSendOption(SendOption value);

	/**
	 * Returns the value of the '<em><b>Base Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Base Version</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Base Version</em>' attribute.
	 * @see #setBaseVersion(int)
	 * @see org.unicase.emfstore.emailnotifier.store.ENSPackage#getENSNotificationGroup_BaseVersion()
	 * @model required="true"
	 * @generated
	 */
	int getBaseVersion();

	/**
	 * Sets the value of the '{@link org.unicase.emfstore.emailnotifier.store.ENSNotificationGroup#getBaseVersion <em>Base Version</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Base Version</em>' attribute.
	 * @see #getBaseVersion()
	 * @generated
	 */
	void setBaseVersion(int value);

	/**
	 * Returns the value of the '<em><b>Next Sending Date</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Next Sending Date</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Next Sending Date</em>' attribute.
	 * @see #setNextSendingDate(Date)
	 * @see org.unicase.emfstore.emailnotifier.store.ENSPackage#getENSNotificationGroup_NextSendingDate()
	 * @model required="true"
	 * @generated
	 */
	Date getNextSendingDate();

	/**
	 * Sets the value of the '{@link org.unicase.emfstore.emailnotifier.store.ENSNotificationGroup#getNextSendingDate <em>Next Sending Date</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Next Sending Date</em>' attribute.
	 * @see #getNextSendingDate()
	 * @generated
	 */
	void setNextSendingDate(Date value);

} // ENSNotificationGroup
