/*******************************************************************************
 * Copyright (c) 2008-2011 Chair for Applied Software Engineering,
 * Technische Universitaet Muenchen.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 ******************************************************************************/
package org.eclipse.emf.emfstore.server.model.impl;

import java.io.IOException;
import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.emf.emfstore.server.model.ModelPackage;
import org.eclipse.emf.emfstore.server.model.ProjectHistory;
import org.eclipse.emf.emfstore.server.model.ServerSpace;
import org.eclipse.emf.emfstore.server.model.SessionId;
import org.eclipse.emf.emfstore.server.model.accesscontrol.ACGroup;
import org.eclipse.emf.emfstore.server.model.accesscontrol.ACUser;

/**
 * <!-- begin-user-doc --> An implementation of the model object ' <em><b>Server Space</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link org.eclipse.emf.emfstore.server.model.impl.ServerSpaceImpl#getGroups <em>Groups</em>}</li>
 * <li>{@link org.eclipse.emf.emfstore.server.model.impl.ServerSpaceImpl#getProjects <em>Projects</em>}</li>
 * <li>{@link org.eclipse.emf.emfstore.server.model.impl.ServerSpaceImpl#getOpenSessions <em>Open Sessions</em>}</li>
 * <li>{@link org.eclipse.emf.emfstore.server.model.impl.ServerSpaceImpl#getUsers <em>Users</em>}</li>
 * </ul>
 * </p>
 * 
 * @generated
 */
public class ServerSpaceImpl extends EObjectImpl implements ServerSpace {
	/**
	 * The cached value of the '{@link #getGroups() <em>Groups</em>}' containment reference list.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * 
	 * @see #getGroups()
	 * @generated
	 * @ordered
	 */
	protected EList<ACGroup> groups;

	/**
	 * The cached value of the '{@link #getProjects() <em>Projects</em>}' reference list.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @see #getProjects()
	 * @generated
	 * @ordered
	 */
	protected EList<ProjectHistory> projects;

	/**
	 * The cached value of the '{@link #getOpenSessions() <em>Open Sessions</em>}' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getOpenSessions()
	 * @generated
	 * @ordered
	 */
	protected EList<SessionId> openSessions;

	/**
	 * The cached value of the '{@link #getUsers() <em>Users</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getUsers()
	 * @generated
	 * @ordered
	 */
	protected EList<ACUser> users;

	private Resource resource;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected ServerSpaceImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ModelPackage.Literals.SERVER_SPACE;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EList<ACGroup> getGroups() {
		if (groups == null) {
			groups = new EObjectContainmentEList.Resolving<ACGroup>(ACGroup.class, this,
				ModelPackage.SERVER_SPACE__GROUPS);
		}
		return groups;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EList<ProjectHistory> getProjects() {
		if (projects == null) {
			projects = new EObjectResolvingEList<ProjectHistory>(ProjectHistory.class, this,
				ModelPackage.SERVER_SPACE__PROJECTS);
		}
		return projects;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EList<SessionId> getOpenSessions() {
		if (openSessions == null) {
			openSessions = new EObjectContainmentEList.Resolving<SessionId>(SessionId.class, this,
				ModelPackage.SERVER_SPACE__OPEN_SESSIONS);
		}
		return openSessions;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EList<ACUser> getUsers() {
		if (users == null) {
			users = new EObjectContainmentEList.Resolving<ACUser>(ACUser.class, this, ModelPackage.SERVER_SPACE__USERS);
		}
		return users;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
		case ModelPackage.SERVER_SPACE__GROUPS:
			return ((InternalEList<?>) getGroups()).basicRemove(otherEnd, msgs);
		case ModelPackage.SERVER_SPACE__OPEN_SESSIONS:
			return ((InternalEList<?>) getOpenSessions()).basicRemove(otherEnd, msgs);
		case ModelPackage.SERVER_SPACE__USERS:
			return ((InternalEList<?>) getUsers()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
		case ModelPackage.SERVER_SPACE__GROUPS:
			return getGroups();
		case ModelPackage.SERVER_SPACE__PROJECTS:
			return getProjects();
		case ModelPackage.SERVER_SPACE__OPEN_SESSIONS:
			return getOpenSessions();
		case ModelPackage.SERVER_SPACE__USERS:
			return getUsers();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
		case ModelPackage.SERVER_SPACE__GROUPS:
			getGroups().clear();
			getGroups().addAll((Collection<? extends ACGroup>) newValue);
			return;
		case ModelPackage.SERVER_SPACE__PROJECTS:
			getProjects().clear();
			getProjects().addAll((Collection<? extends ProjectHistory>) newValue);
			return;
		case ModelPackage.SERVER_SPACE__OPEN_SESSIONS:
			getOpenSessions().clear();
			getOpenSessions().addAll((Collection<? extends SessionId>) newValue);
			return;
		case ModelPackage.SERVER_SPACE__USERS:
			getUsers().clear();
			getUsers().addAll((Collection<? extends ACUser>) newValue);
			return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
		case ModelPackage.SERVER_SPACE__GROUPS:
			getGroups().clear();
			return;
		case ModelPackage.SERVER_SPACE__PROJECTS:
			getProjects().clear();
			return;
		case ModelPackage.SERVER_SPACE__OPEN_SESSIONS:
			getOpenSessions().clear();
			return;
		case ModelPackage.SERVER_SPACE__USERS:
			getUsers().clear();
			return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
		case ModelPackage.SERVER_SPACE__GROUPS:
			return groups != null && !groups.isEmpty();
		case ModelPackage.SERVER_SPACE__PROJECTS:
			return projects != null && !projects.isEmpty();
		case ModelPackage.SERVER_SPACE__OPEN_SESSIONS:
			return openSessions != null && !openSessions.isEmpty();
		case ModelPackage.SERVER_SPACE__USERS:
			return users != null && !users.isEmpty();
		}
		return super.eIsSet(featureID);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @throws IOException
	 */
	public void save() throws IOException {
		this.resource.save(null);
	}

	/**
	 * {@inheritDoc}
	 */
	public void setResource(Resource resource) {
		this.resource = resource;
	}

} // ServerSpaceImpl
