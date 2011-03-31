/*******************************************************************************
 * Copyright (c) 2008-2011 Chair for Applied Software Engineering, Technische Universitaet Muenchen.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 ******************************************************************************/
package org.eclipse.emf.emfstore.server.model.versioning.impl;

import java.util.Date;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.emfstore.server.model.versioning.LogMessage;
import org.eclipse.emf.emfstore.server.model.versioning.VersioningPackage;

/**
 * <!-- begin-user-doc --> An implementation of the model object ' <em><b>Log Message</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.emf.emfstore.server.model.versioning.impl.LogMessageImpl#getAuthor <em>Author</em>}</li>
 *   <li>{@link org.eclipse.emf.emfstore.server.model.versioning.impl.LogMessageImpl#getMessage <em>Message</em>}</li>
 *   <li>{@link org.eclipse.emf.emfstore.server.model.versioning.impl.LogMessageImpl#getDate <em>Date</em>}</li>
 *   <li>{@link org.eclipse.emf.emfstore.server.model.versioning.impl.LogMessageImpl#getClientDate <em>Client Date</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class LogMessageImpl extends EObjectImpl implements LogMessage {
	/**
	 * The default value of the '{@link #getAuthor() <em>Author</em>}' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @see #getAuthor()
	 * @generated
	 * @ordered
	 */
	protected static final String AUTHOR_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getAuthor() <em>Author</em>}' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @see #getAuthor()
	 * @generated
	 * @ordered
	 */
	protected String author = AUTHOR_EDEFAULT;

	/**
	 * The default value of the '{@link #getMessage() <em>Message</em>}' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @see #getMessage()
	 * @generated
	 * @ordered
	 */
	protected static final String MESSAGE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getMessage() <em>Message</em>}' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @see #getMessage()
	 * @generated
	 * @ordered
	 */
	protected String message = MESSAGE_EDEFAULT;

	/**
	 * The default value of the '{@link #getDate() <em>Date</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @see #getDate()
	 * @generated
	 * @ordered
	 */
	protected static final Date DATE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getDate() <em>Date</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @see #getDate()
	 * @generated
	 * @ordered
	 */
	protected Date date = DATE_EDEFAULT;

	/**
	 * The default value of the '{@link #getClientDate() <em>Client Date</em>}' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @see #getClientDate()
	 * @generated
	 * @ordered
	 */
	protected static final Date CLIENT_DATE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getClientDate() <em>Client Date</em>}' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @see #getClientDate()
	 * @generated
	 * @ordered
	 */
	protected Date clientDate = CLIENT_DATE_EDEFAULT;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected LogMessageImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return VersioningPackage.Literals.LOG_MESSAGE;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setMessage(String newMessage) {
		String oldMessage = message;
		message = newMessage;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, VersioningPackage.LOG_MESSAGE__MESSAGE, oldMessage, message));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String getAuthor() {
		return author;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setAuthor(String newAuthor) {
		String oldAuthor = author;
		author = newAuthor;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, VersioningPackage.LOG_MESSAGE__AUTHOR, oldAuthor, author));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public Date getDate() {
		return date;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setDate(Date newDate) {
		Date oldDate = date;
		date = newDate;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, VersioningPackage.LOG_MESSAGE__DATE, oldDate, date));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public Date getClientDate() {
		return clientDate;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setClientDate(Date newClientDate) {
		Date oldClientDate = clientDate;
		clientDate = newClientDate;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, VersioningPackage.LOG_MESSAGE__CLIENT_DATE, oldClientDate, clientDate));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case VersioningPackage.LOG_MESSAGE__AUTHOR:
				return getAuthor();
			case VersioningPackage.LOG_MESSAGE__MESSAGE:
				return getMessage();
			case VersioningPackage.LOG_MESSAGE__DATE:
				return getDate();
			case VersioningPackage.LOG_MESSAGE__CLIENT_DATE:
				return getClientDate();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case VersioningPackage.LOG_MESSAGE__AUTHOR:
				setAuthor((String)newValue);
				return;
			case VersioningPackage.LOG_MESSAGE__MESSAGE:
				setMessage((String)newValue);
				return;
			case VersioningPackage.LOG_MESSAGE__DATE:
				setDate((Date)newValue);
				return;
			case VersioningPackage.LOG_MESSAGE__CLIENT_DATE:
				setClientDate((Date)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case VersioningPackage.LOG_MESSAGE__AUTHOR:
				setAuthor(AUTHOR_EDEFAULT);
				return;
			case VersioningPackage.LOG_MESSAGE__MESSAGE:
				setMessage(MESSAGE_EDEFAULT);
				return;
			case VersioningPackage.LOG_MESSAGE__DATE:
				setDate(DATE_EDEFAULT);
				return;
			case VersioningPackage.LOG_MESSAGE__CLIENT_DATE:
				setClientDate(CLIENT_DATE_EDEFAULT);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case VersioningPackage.LOG_MESSAGE__AUTHOR:
				return AUTHOR_EDEFAULT == null ? author != null : !AUTHOR_EDEFAULT.equals(author);
			case VersioningPackage.LOG_MESSAGE__MESSAGE:
				return MESSAGE_EDEFAULT == null ? message != null : !MESSAGE_EDEFAULT.equals(message);
			case VersioningPackage.LOG_MESSAGE__DATE:
				return DATE_EDEFAULT == null ? date != null : !DATE_EDEFAULT.equals(date);
			case VersioningPackage.LOG_MESSAGE__CLIENT_DATE:
				return CLIENT_DATE_EDEFAULT == null ? clientDate != null : !CLIENT_DATE_EDEFAULT.equals(clientDate);
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (author: ");
		result.append(author);
		result.append(", message: ");
		result.append(message);
		result.append(", date: ");
		result.append(date);
		result.append(", clientDate: ");
		result.append(clientDate);
		result.append(')');
		return result.toString();
	}

} // LogMessageImpl
