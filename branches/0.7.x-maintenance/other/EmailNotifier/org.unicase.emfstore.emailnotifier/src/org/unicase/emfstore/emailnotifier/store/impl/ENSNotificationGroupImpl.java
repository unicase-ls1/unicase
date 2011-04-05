/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.emfstore.emailnotifier.store.impl;

import java.util.Date;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.unicase.emfstore.emailnotifier.store.ENSNotificationGroup;
import org.unicase.emfstore.emailnotifier.store.ENSPackage;
import org.unicase.emfstore.emailnotifier.store.SendOption;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Notification Group</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.unicase.emfstore.emailnotifier.store.impl.ENSNotificationGroupImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.unicase.emfstore.emailnotifier.store.impl.ENSNotificationGroupImpl#getSendOption <em>Send Option</em>}</li>
 *   <li>{@link org.unicase.emfstore.emailnotifier.store.impl.ENSNotificationGroupImpl#getBaseVersion <em>Base Version</em>}</li>
 *   <li>{@link org.unicase.emfstore.emailnotifier.store.impl.ENSNotificationGroupImpl#getNextSendingDate <em>Next Sending Date</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ENSNotificationGroupImpl extends EObjectImpl implements ENSNotificationGroup {
	/**
	 * The default value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected String name = NAME_EDEFAULT;

	/**
	 * The default value of the '{@link #getSendOption() <em>Send Option</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSendOption()
	 * @generated
	 * @ordered
	 */
	protected static final SendOption SEND_OPTION_EDEFAULT = SendOption.IMMEDIATELY;

	/**
	 * The cached value of the '{@link #getSendOption() <em>Send Option</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSendOption()
	 * @generated
	 * @ordered
	 */
	protected SendOption sendOption = SEND_OPTION_EDEFAULT;

	/**
	 * The default value of the '{@link #getBaseVersion() <em>Base Version</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBaseVersion()
	 * @generated
	 * @ordered
	 */
	protected static final int BASE_VERSION_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getBaseVersion() <em>Base Version</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBaseVersion()
	 * @generated
	 * @ordered
	 */
	protected int baseVersion = BASE_VERSION_EDEFAULT;

	/**
	 * The default value of the '{@link #getNextSendingDate() <em>Next Sending Date</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNextSendingDate()
	 * @generated
	 * @ordered
	 */
	protected static final Date NEXT_SENDING_DATE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getNextSendingDate() <em>Next Sending Date</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNextSendingDate()
	 * @generated
	 * @ordered
	 */
	protected Date nextSendingDate = NEXT_SENDING_DATE_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ENSNotificationGroupImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ENSPackage.Literals.ENS_NOTIFICATION_GROUP;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName() {
		return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setName(String newName) {
		String oldName = name;
		name = newName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ENSPackage.ENS_NOTIFICATION_GROUP__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SendOption getSendOption() {
		return sendOption;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSendOption(SendOption newSendOption) {
		SendOption oldSendOption = sendOption;
		sendOption = newSendOption == null ? SEND_OPTION_EDEFAULT : newSendOption;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ENSPackage.ENS_NOTIFICATION_GROUP__SEND_OPTION, oldSendOption, sendOption));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getBaseVersion() {
		return baseVersion;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBaseVersion(int newBaseVersion) {
		int oldBaseVersion = baseVersion;
		baseVersion = newBaseVersion;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ENSPackage.ENS_NOTIFICATION_GROUP__BASE_VERSION, oldBaseVersion, baseVersion));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Date getNextSendingDate() {
		return nextSendingDate;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setNextSendingDate(Date newNextSendingDate) {
		Date oldNextSendingDate = nextSendingDate;
		nextSendingDate = newNextSendingDate;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ENSPackage.ENS_NOTIFICATION_GROUP__NEXT_SENDING_DATE, oldNextSendingDate, nextSendingDate));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ENSPackage.ENS_NOTIFICATION_GROUP__NAME:
				return getName();
			case ENSPackage.ENS_NOTIFICATION_GROUP__SEND_OPTION:
				return getSendOption();
			case ENSPackage.ENS_NOTIFICATION_GROUP__BASE_VERSION:
				return getBaseVersion();
			case ENSPackage.ENS_NOTIFICATION_GROUP__NEXT_SENDING_DATE:
				return getNextSendingDate();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case ENSPackage.ENS_NOTIFICATION_GROUP__NAME:
				setName((String)newValue);
				return;
			case ENSPackage.ENS_NOTIFICATION_GROUP__SEND_OPTION:
				setSendOption((SendOption)newValue);
				return;
			case ENSPackage.ENS_NOTIFICATION_GROUP__BASE_VERSION:
				setBaseVersion((Integer)newValue);
				return;
			case ENSPackage.ENS_NOTIFICATION_GROUP__NEXT_SENDING_DATE:
				setNextSendingDate((Date)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case ENSPackage.ENS_NOTIFICATION_GROUP__NAME:
				setName(NAME_EDEFAULT);
				return;
			case ENSPackage.ENS_NOTIFICATION_GROUP__SEND_OPTION:
				setSendOption(SEND_OPTION_EDEFAULT);
				return;
			case ENSPackage.ENS_NOTIFICATION_GROUP__BASE_VERSION:
				setBaseVersion(BASE_VERSION_EDEFAULT);
				return;
			case ENSPackage.ENS_NOTIFICATION_GROUP__NEXT_SENDING_DATE:
				setNextSendingDate(NEXT_SENDING_DATE_EDEFAULT);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case ENSPackage.ENS_NOTIFICATION_GROUP__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case ENSPackage.ENS_NOTIFICATION_GROUP__SEND_OPTION:
				return sendOption != SEND_OPTION_EDEFAULT;
			case ENSPackage.ENS_NOTIFICATION_GROUP__BASE_VERSION:
				return baseVersion != BASE_VERSION_EDEFAULT;
			case ENSPackage.ENS_NOTIFICATION_GROUP__NEXT_SENDING_DATE:
				return NEXT_SENDING_DATE_EDEFAULT == null ? nextSendingDate != null : !NEXT_SENDING_DATE_EDEFAULT.equals(nextSendingDate);
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (name: ");
		result.append(name);
		result.append(", sendOption: ");
		result.append(sendOption);
		result.append(", baseVersion: ");
		result.append(baseVersion);
		result.append(", nextSendingDate: ");
		result.append(nextSendingDate);
		result.append(')');
		return result.toString();
	}

} //ENSNotificationGroupImpl
