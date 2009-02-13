/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.emfstore.esmodel.notification;

import org.eclipse.emf.common.util.EList;
import org.unicase.emfstore.esmodel.ProjectId;
import org.unicase.model.IdentifiableElement;
import org.unicase.model.ModelElementId;

/*
 * <!-- begin-user-doc --> A representation of the model object '<em><b>ES Notification</b></em>'. <!-- end-user-doc -->
 * <p> The following features are supported: <ul> <li>{@link
 * org.unicase.emfstore.esmodel.notification.ESNotification#getSender <em>Sender</em>}</li> <li>{@link
 * org.unicase.emfstore.esmodel.notification.ESNotification#getRecipient <em>Recipient</em>}</li> <li>{@link
 * org.unicase.emfstore.esmodel.notification.ESNotification#getProject <em>Project</em>}</li> <li>{@link
 * org.unicase.emfstore.esmodel.notification.ESNotification#getRelatedModelElements <em>Related Model
 * Elements</em>}</li> <li>{@link org.unicase.emfstore.esmodel.notification.ESNotification#getMessage
 * <em>Message</em>}</li> </ul> </p>
 * @see org.unicase.emfstore.esmodel.notification.NotificationPackage#getESNotification()
 * @model
 * @generated
 */
public interface ESNotification extends IdentifiableElement {
	/**
	 * Returns the value of the '<em><b>Sender</b></em>' attribute. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Sender</em>' attribute isn't clear, there really should be more of a description
	 * here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Sender</em>' attribute.
	 * @see #setSender(String)
	 * @see org.unicase.emfstore.esmodel.notification.NotificationPackage#getESNotification_Sender()
	 * @model
	 * @generated
	 */
	String getSender();

	/**
	 * Sets the value of the '{@link org.unicase.emfstore.esmodel.notification.ESNotification#getSender <em>Sender</em>}
	 * ' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value the new value of the '<em>Sender</em>' attribute.
	 * @see #getSender()
	 * @generated
	 */
	void setSender(String value);

	/**
	 * Returns the value of the '<em><b>Recipient</b></em>' attribute. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Recipient</em>' attribute isn't clear, there really should be more of a description
	 * here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Recipient</em>' attribute.
	 * @see #setRecipient(String)
	 * @see org.unicase.emfstore.esmodel.notification.NotificationPackage#getESNotification_Recipient()
	 * @model
	 * @generated
	 */
	String getRecipient();

	/**
	 * Sets the value of the '{@link org.unicase.emfstore.esmodel.notification.ESNotification#getRecipient
	 * <em>Recipient</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value the new value of the '<em>Recipient</em>' attribute.
	 * @see #getRecipient()
	 * @generated
	 */
	void setRecipient(String value);

	/**
	 * Returns the value of the '<em><b>Project</b></em>' containment reference. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Project</em>' containment reference isn't clear, there really should be more of a
	 * description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Project</em>' containment reference.
	 * @see #setProject(ProjectId)
	 * @see org.unicase.emfstore.esmodel.notification.NotificationPackage#getESNotification_Project()
	 * @model containment="true" resolveProxies="true"
	 * @generated
	 */
	ProjectId getProject();

	/**
	 * Sets the value of the '{@link org.unicase.emfstore.esmodel.notification.ESNotification#getProject
	 * <em>Project</em>}' containment reference. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value the new value of the '<em>Project</em>' containment reference.
	 * @see #getProject()
	 * @generated
	 */
	void setProject(ProjectId value);

	/**
	 * Returns the value of the '<em><b>Related Model Elements</b></em>' containment reference list. The list contents
	 * are of type {@link org.unicase.model.ModelElementId}. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Related Model Elements</em>' containment reference list isn't clear, there really
	 * should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Related Model Elements</em>' containment reference list.
	 * @see org.unicase.emfstore.esmodel.notification.NotificationPackage#getESNotification_RelatedModelElements()
	 * @model containment="true" resolveProxies="true"
	 * @generated
	 */
	EList<ModelElementId> getRelatedModelElements();

	/**
	 * Returns the value of the '<em><b>Message</b></em>' attribute. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Message</em>' attribute isn't clear, there really should be more of a description
	 * here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Message</em>' attribute.
	 * @see #setMessage(String)
	 * @see org.unicase.emfstore.esmodel.notification.NotificationPackage#getESNotification_Message()
	 * @model
	 * @generated
	 */
	String getMessage();

	/**
	 * Sets the value of the '{@link org.unicase.emfstore.esmodel.notification.ESNotification#getMessage
	 * <em>Message</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value the new value of the '<em>Message</em>' attribute.
	 * @see #getMessage()
	 * @generated
	 */
	void setMessage(String value);

} // ESNotification
