/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.unicase.proxyclient.notifier.store.model.impl;

import java.util.Collection;

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
import org.unicase.proxyclient.notifier.store.model.NotificationGroup;
import org.unicase.proxyclient.notifier.store.model.NotificationProject;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Notification Project</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.unicase.proxyclient.notifier.store.model.impl.NotificationProjectImpl#getId <em>Id</em>}</li>
 *   <li>{@link org.unicase.proxyclient.notifier.store.model.impl.NotificationProjectImpl#getUserName <em>User Name</em>}</li>
 *   <li>{@link org.unicase.proxyclient.notifier.store.model.impl.NotificationProjectImpl#getLastSeenEMail <em>Last Seen EMail</em>}</li>
 *   <li>{@link org.unicase.proxyclient.notifier.store.model.impl.NotificationProjectImpl#getGroups <em>Groups</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class NotificationProjectImpl extends EObjectImpl implements NotificationProject {
	/**
	 * The default value of the '{@link #getId() <em>Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getId()
	 * @generated
	 * @ordered
	 */
	protected static final String ID_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getId() <em>Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getId()
	 * @generated
	 * @ordered
	 */
	protected String id = ID_EDEFAULT;

	/**
	 * The default value of the '{@link #getUserName() <em>User Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUserName()
	 * @generated
	 * @ordered
	 */
	protected static final String USER_NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getUserName() <em>User Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUserName()
	 * @generated
	 * @ordered
	 */
	protected String userName = USER_NAME_EDEFAULT;

	/**
	 * The default value of the '{@link #getLastSeenEMail() <em>Last Seen EMail</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLastSeenEMail()
	 * @generated
	 * @ordered
	 */
	protected static final String LAST_SEEN_EMAIL_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getLastSeenEMail() <em>Last Seen EMail</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLastSeenEMail()
	 * @generated
	 * @ordered
	 */
	protected String lastSeenEMail = LAST_SEEN_EMAIL_EDEFAULT;

	/**
	 * The cached value of the '{@link #getGroups() <em>Groups</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getGroups()
	 * @generated
	 * @ordered
	 */
	protected EList<NotificationGroup> groups;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected NotificationProjectImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return NPCPackage.Literals.NOTIFICATION_PROJECT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getId() {
		return id;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setId(String newId) {
		String oldId = id;
		id = newId;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, NPCPackage.NOTIFICATION_PROJECT__ID, oldId, id));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setUserName(String newUserName) {
		String oldUserName = userName;
		userName = newUserName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, NPCPackage.NOTIFICATION_PROJECT__USER_NAME, oldUserName, userName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getLastSeenEMail() {
		return lastSeenEMail;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLastSeenEMail(String newLastSeenEMail) {
		String oldLastSeenEMail = lastSeenEMail;
		lastSeenEMail = newLastSeenEMail;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, NPCPackage.NOTIFICATION_PROJECT__LAST_SEEN_EMAIL, oldLastSeenEMail, lastSeenEMail));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<NotificationGroup> getGroups() {
		if (groups == null) {
			groups = new EObjectContainmentEList<NotificationGroup>(NotificationGroup.class, this, NPCPackage.NOTIFICATION_PROJECT__GROUPS);
		}
		return groups;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case NPCPackage.NOTIFICATION_PROJECT__GROUPS:
				return ((InternalEList<?>)getGroups()).basicRemove(otherEnd, msgs);
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
			case NPCPackage.NOTIFICATION_PROJECT__ID:
				return getId();
			case NPCPackage.NOTIFICATION_PROJECT__USER_NAME:
				return getUserName();
			case NPCPackage.NOTIFICATION_PROJECT__LAST_SEEN_EMAIL:
				return getLastSeenEMail();
			case NPCPackage.NOTIFICATION_PROJECT__GROUPS:
				return getGroups();
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
			case NPCPackage.NOTIFICATION_PROJECT__ID:
				setId((String)newValue);
				return;
			case NPCPackage.NOTIFICATION_PROJECT__USER_NAME:
				setUserName((String)newValue);
				return;
			case NPCPackage.NOTIFICATION_PROJECT__LAST_SEEN_EMAIL:
				setLastSeenEMail((String)newValue);
				return;
			case NPCPackage.NOTIFICATION_PROJECT__GROUPS:
				getGroups().clear();
				getGroups().addAll((Collection<? extends NotificationGroup>)newValue);
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
			case NPCPackage.NOTIFICATION_PROJECT__ID:
				setId(ID_EDEFAULT);
				return;
			case NPCPackage.NOTIFICATION_PROJECT__USER_NAME:
				setUserName(USER_NAME_EDEFAULT);
				return;
			case NPCPackage.NOTIFICATION_PROJECT__LAST_SEEN_EMAIL:
				setLastSeenEMail(LAST_SEEN_EMAIL_EDEFAULT);
				return;
			case NPCPackage.NOTIFICATION_PROJECT__GROUPS:
				getGroups().clear();
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
			case NPCPackage.NOTIFICATION_PROJECT__ID:
				return ID_EDEFAULT == null ? id != null : !ID_EDEFAULT.equals(id);
			case NPCPackage.NOTIFICATION_PROJECT__USER_NAME:
				return USER_NAME_EDEFAULT == null ? userName != null : !USER_NAME_EDEFAULT.equals(userName);
			case NPCPackage.NOTIFICATION_PROJECT__LAST_SEEN_EMAIL:
				return LAST_SEEN_EMAIL_EDEFAULT == null ? lastSeenEMail != null : !LAST_SEEN_EMAIL_EDEFAULT.equals(lastSeenEMail);
			case NPCPackage.NOTIFICATION_PROJECT__GROUPS:
				return groups != null && !groups.isEmpty();
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
		result.append(" (id: ");
		result.append(id);
		result.append(", userName: ");
		result.append(userName);
		result.append(", lastSeenEMail: ");
		result.append(lastSeenEMail);
		result.append(')');
		return result.toString();
	}

} //NotificationProjectImpl
