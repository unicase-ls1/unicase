/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.unicase.emfstore.esmodel.impl;

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
import org.unicase.emfstore.esmodel.EsmodelPackage;
import org.unicase.emfstore.esmodel.ProjectHistory;
import org.unicase.emfstore.esmodel.ServerSpace;
import org.unicase.emfstore.esmodel.SessionId;
import org.unicase.emfstore.esmodel.accesscontrol.ACGroup;
import org.unicase.emfstore.esmodel.accesscontrol.ACUser;
import org.unicase.emfstore.esmodel.accesscontrol.ACOrgUnit;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Server Space</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.unicase.emfstore.esmodel.impl.ServerSpaceImpl#getGroups <em>Groups</em>}</li>
 *   <li>{@link org.unicase.emfstore.esmodel.impl.ServerSpaceImpl#getProjects <em>Projects</em>}</li>
 *   <li>{@link org.unicase.emfstore.esmodel.impl.ServerSpaceImpl#getOpenSessions <em>Open Sessions</em>}</li>
 *   <li>{@link org.unicase.emfstore.esmodel.impl.ServerSpaceImpl#getUsers <em>Users</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ServerSpaceImpl extends EObjectImpl implements ServerSpace {
	/**
	 * The cached value of the '{@link #getGroups() <em>Groups</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getGroups()
	 * @generated
	 * @ordered
	 */
	protected EList<ACGroup> groups;

	/**
	 * The cached value of the '{@link #getProjects() <em>Projects</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getProjects()
	 * @generated
	 * @ordered
	 */
	protected EList<ProjectHistory> projects;

	/**
	 * The cached value of the '{@link #getOpenSessions() <em>Open Sessions</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOpenSessions()
	 * @generated
	 * @ordered
	 */
	protected EList<SessionId> openSessions;

	/**
	 * The cached value of the '{@link #getUsers() <em>Users</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUsers()
	 * @generated
	 * @ordered
	 */
	protected ACUser users;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ServerSpaceImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return EsmodelPackage.Literals.SERVER_SPACE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ACGroup> getGroups() {
		if (groups == null) {
			groups = new EObjectContainmentEList<ACGroup>(ACGroup.class, this, EsmodelPackage.SERVER_SPACE__GROUPS);
		}
		return groups;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ProjectHistory> getProjects() {
		if (projects == null) {
			projects = new EObjectContainmentEList<ProjectHistory>(ProjectHistory.class, this, EsmodelPackage.SERVER_SPACE__PROJECTS);
		}
		return projects;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<SessionId> getOpenSessions() {
		if (openSessions == null) {
			openSessions = new EObjectContainmentEList<SessionId>(SessionId.class, this, EsmodelPackage.SERVER_SPACE__OPEN_SESSIONS);
		}
		return openSessions;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ACUser getUsers() {
		return users;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetUsers(ACUser newUsers, NotificationChain msgs) {
		ACUser oldUsers = users;
		users = newUsers;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, EsmodelPackage.SERVER_SPACE__USERS, oldUsers, newUsers);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setUsers(ACUser newUsers) {
		if (newUsers != users) {
			NotificationChain msgs = null;
			if (users != null)
				msgs = ((InternalEObject)users).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - EsmodelPackage.SERVER_SPACE__USERS, null, msgs);
			if (newUsers != null)
				msgs = ((InternalEObject)newUsers).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - EsmodelPackage.SERVER_SPACE__USERS, null, msgs);
			msgs = basicSetUsers(newUsers, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsmodelPackage.SERVER_SPACE__USERS, newUsers, newUsers));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case EsmodelPackage.SERVER_SPACE__GROUPS:
				return ((InternalEList<?>)getGroups()).basicRemove(otherEnd, msgs);
			case EsmodelPackage.SERVER_SPACE__PROJECTS:
				return ((InternalEList<?>)getProjects()).basicRemove(otherEnd, msgs);
			case EsmodelPackage.SERVER_SPACE__OPEN_SESSIONS:
				return ((InternalEList<?>)getOpenSessions()).basicRemove(otherEnd, msgs);
			case EsmodelPackage.SERVER_SPACE__USERS:
				return basicSetUsers(null, msgs);
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
			case EsmodelPackage.SERVER_SPACE__GROUPS:
				return getGroups();
			case EsmodelPackage.SERVER_SPACE__PROJECTS:
				return getProjects();
			case EsmodelPackage.SERVER_SPACE__OPEN_SESSIONS:
				return getOpenSessions();
			case EsmodelPackage.SERVER_SPACE__USERS:
				return getUsers();
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
			case EsmodelPackage.SERVER_SPACE__GROUPS:
				getGroups().clear();
				getGroups().addAll((Collection<? extends ACGroup>)newValue);
				return;
			case EsmodelPackage.SERVER_SPACE__PROJECTS:
				getProjects().clear();
				getProjects().addAll((Collection<? extends ProjectHistory>)newValue);
				return;
			case EsmodelPackage.SERVER_SPACE__OPEN_SESSIONS:
				getOpenSessions().clear();
				getOpenSessions().addAll((Collection<? extends SessionId>)newValue);
				return;
			case EsmodelPackage.SERVER_SPACE__USERS:
				setUsers((ACUser)newValue);
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
			case EsmodelPackage.SERVER_SPACE__GROUPS:
				getGroups().clear();
				return;
			case EsmodelPackage.SERVER_SPACE__PROJECTS:
				getProjects().clear();
				return;
			case EsmodelPackage.SERVER_SPACE__OPEN_SESSIONS:
				getOpenSessions().clear();
				return;
			case EsmodelPackage.SERVER_SPACE__USERS:
				setUsers((ACUser)null);
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
			case EsmodelPackage.SERVER_SPACE__GROUPS:
				return groups != null && !groups.isEmpty();
			case EsmodelPackage.SERVER_SPACE__PROJECTS:
				return projects != null && !projects.isEmpty();
			case EsmodelPackage.SERVER_SPACE__OPEN_SESSIONS:
				return openSessions != null && !openSessions.isEmpty();
			case EsmodelPackage.SERVER_SPACE__USERS:
				return users != null;
		}
		return super.eIsSet(featureID);
	}

} //ServerSpaceImpl
