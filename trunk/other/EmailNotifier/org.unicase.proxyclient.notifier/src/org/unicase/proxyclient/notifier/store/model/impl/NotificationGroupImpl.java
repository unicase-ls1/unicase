/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.proxyclient.notifier.store.model.impl;

import java.util.Collection;
import java.util.Date;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.unicase.proxyclient.notifier.store.model.NPCPackage;
import org.unicase.proxyclient.notifier.store.model.NotificationEntry;
import org.unicase.proxyclient.notifier.store.model.NotificationGroup;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Notification Group</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.unicase.proxyclient.notifier.store.model.impl.NotificationGroupImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.unicase.proxyclient.notifier.store.model.impl.NotificationGroupImpl#getNextSending <em>Next Sending</em>}</li>
 *   <li>{@link org.unicase.proxyclient.notifier.store.model.impl.NotificationGroupImpl#getNotifications <em>Notifications</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 * 
 * @author staudta
 */
public class NotificationGroupImpl extends EObjectImpl implements NotificationGroup {
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
	 * The default value of the '{@link #getNextSending() <em>Next Sending</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNextSending()
	 * @generated
	 * @ordered
	 */
	protected static final Date NEXT_SENDING_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getNextSending() <em>Next Sending</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNextSending()
	 * @generated
	 * @ordered
	 */
	protected Date nextSending = NEXT_SENDING_EDEFAULT;

	/**
	 * The cached value of the '{@link #getNotifications() <em>Notifications</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNotifications()
	 * @generated
	 * @ordered
	 */
	protected EList<NotificationEntry> notifications;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected NotificationGroupImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return NPCPackage.Literals.NOTIFICATION_GROUP;
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
			eNotify(new ENotificationImpl(this, Notification.SET, NPCPackage.NOTIFICATION_GROUP__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Date getNextSending() {
		return nextSending;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setNextSending(Date newNextSending) {
		Date oldNextSending = nextSending;
		nextSending = newNextSending;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, NPCPackage.NOTIFICATION_GROUP__NEXT_SENDING, oldNextSending, nextSending));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<NotificationEntry> getNotifications() {
		if (notifications == null) {
			notifications = new EObjectContainmentEList<NotificationEntry>(NotificationEntry.class, this, NPCPackage.NOTIFICATION_GROUP__NOTIFICATIONS);
		}
		return notifications;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case NPCPackage.NOTIFICATION_GROUP__NOTIFICATIONS:
				return ((InternalEList<?>)getNotifications()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case NPCPackage.NOTIFICATION_GROUP__NAME:
				return getName();
			case NPCPackage.NOTIFICATION_GROUP__NEXT_SENDING:
				return getNextSending();
			case NPCPackage.NOTIFICATION_GROUP__NOTIFICATIONS:
				return getNotifications();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case NPCPackage.NOTIFICATION_GROUP__NAME:
				setName((String)newValue);
				return;
			case NPCPackage.NOTIFICATION_GROUP__NEXT_SENDING:
				setNextSending((Date)newValue);
				return;
			case NPCPackage.NOTIFICATION_GROUP__NOTIFICATIONS:
				getNotifications().clear();
				getNotifications().addAll((Collection<? extends NotificationEntry>)newValue);
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
			case NPCPackage.NOTIFICATION_GROUP__NAME:
				setName(NAME_EDEFAULT);
				return;
			case NPCPackage.NOTIFICATION_GROUP__NEXT_SENDING:
				setNextSending(NEXT_SENDING_EDEFAULT);
				return;
			case NPCPackage.NOTIFICATION_GROUP__NOTIFICATIONS:
				getNotifications().clear();
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
			case NPCPackage.NOTIFICATION_GROUP__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case NPCPackage.NOTIFICATION_GROUP__NEXT_SENDING:
				return NEXT_SENDING_EDEFAULT == null ? nextSending != null : !NEXT_SENDING_EDEFAULT.equals(nextSending);
			case NPCPackage.NOTIFICATION_GROUP__NOTIFICATIONS:
				return notifications != null && !notifications.isEmpty();
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
		result.append(", nextSending: ");
		result.append(nextSending);
		result.append(')');
		return result.toString();
	}

} //NotificationGroupImpl
