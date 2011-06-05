/**
 * <copyright> Copyright (c) 2008-2011 Chair for Applied Software Engineering, Technische Unversitaet Muenchen. All rights reserved. This program and the accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 * 
 */
package org.eclipse.emf.emfstore.client.model.impl;

import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.eclipse.emf.emfstore.client.model.ModelPackage;
import org.eclipse.emf.emfstore.client.model.ProjectSpaceDataInternal;
import org.eclipse.emf.emfstore.client.model.ServerInfo;
import org.eclipse.emf.emfstore.client.model.Usersession;
import org.eclipse.emf.emfstore.client.model.WorkspaceDataInternal;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Workspace Data Internal</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.emf.emfstore.client.model.impl.WorkspaceDataInternalImpl#getInternalProjectSpaces <em>Internal Project Spaces</em>}</li>
 *   <li>{@link org.eclipse.emf.emfstore.client.model.impl.WorkspaceDataInternalImpl#getInternalServerInfos <em>Internal Server Infos</em>}</li>
 *   <li>{@link org.eclipse.emf.emfstore.client.model.impl.WorkspaceDataInternalImpl#getInternalUsersessions <em>Internal Usersessions</em>}</li>
 *   <li>{@link org.eclipse.emf.emfstore.client.model.impl.WorkspaceDataInternalImpl#getInternalActiveProjectSpace <em>Internal Active Project Space</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class WorkspaceDataInternalImpl extends EObjectImpl implements
		WorkspaceDataInternal {
	/**
	 * The cached value of the '{@link #getInternalProjectSpaces() <em>Internal Project Spaces</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInternalProjectSpaces()
	 * @generated
	 * @ordered
	 */
	protected EList<ProjectSpaceDataInternal> internalProjectSpaces;

	/**
	 * The cached value of the '{@link #getInternalServerInfos() <em>Internal Server Infos</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInternalServerInfos()
	 * @generated
	 * @ordered
	 */
	protected EList<ServerInfo> internalServerInfos;

	/**
	 * The cached value of the '{@link #getInternalUsersessions() <em>Internal Usersessions</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInternalUsersessions()
	 * @generated
	 * @ordered
	 */
	protected EList<Usersession> internalUsersessions;

	/**
	 * The cached value of the '{@link #getInternalActiveProjectSpace() <em>Internal Active Project Space</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInternalActiveProjectSpace()
	 * @generated
	 * @ordered
	 */
	protected ProjectSpaceDataInternal internalActiveProjectSpace;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected WorkspaceDataInternalImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ModelPackage.Literals.WORKSPACE_DATA_INTERNAL;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ProjectSpaceDataInternal> getInternalProjectSpaces() {
		if (internalProjectSpaces == null) {
			internalProjectSpaces = new EObjectContainmentEList.Resolving<ProjectSpaceDataInternal>(
					ProjectSpaceDataInternal.class,
					this,
					ModelPackage.WORKSPACE_DATA_INTERNAL__INTERNAL_PROJECT_SPACES);
		}
		return internalProjectSpaces;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ServerInfo> getInternalServerInfos() {
		if (internalServerInfos == null) {
			internalServerInfos = new EObjectContainmentEList.Resolving<ServerInfo>(
					ServerInfo.class, this,
					ModelPackage.WORKSPACE_DATA_INTERNAL__INTERNAL_SERVER_INFOS);
		}
		return internalServerInfos;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Usersession> getInternalUsersessions() {
		if (internalUsersessions == null) {
			internalUsersessions = new EObjectContainmentEList.Resolving<Usersession>(
					Usersession.class, this,
					ModelPackage.WORKSPACE_DATA_INTERNAL__INTERNAL_USERSESSIONS);
		}
		return internalUsersessions;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ProjectSpaceDataInternal getInternalActiveProjectSpace() {
		if (internalActiveProjectSpace != null
				&& internalActiveProjectSpace.eIsProxy()) {
			InternalEObject oldInternalActiveProjectSpace = (InternalEObject) internalActiveProjectSpace;
			internalActiveProjectSpace = (ProjectSpaceDataInternal) eResolveProxy(oldInternalActiveProjectSpace);
			if (internalActiveProjectSpace != oldInternalActiveProjectSpace) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(
							this,
							Notification.RESOLVE,
							ModelPackage.WORKSPACE_DATA_INTERNAL__INTERNAL_ACTIVE_PROJECT_SPACE,
							oldInternalActiveProjectSpace,
							internalActiveProjectSpace));
			}
		}
		return internalActiveProjectSpace;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ProjectSpaceDataInternal basicGetInternalActiveProjectSpace() {
		return internalActiveProjectSpace;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setInternalActiveProjectSpace(
			ProjectSpaceDataInternal newInternalActiveProjectSpace) {
		ProjectSpaceDataInternal oldInternalActiveProjectSpace = internalActiveProjectSpace;
		internalActiveProjectSpace = newInternalActiveProjectSpace;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(
					this,
					Notification.SET,
					ModelPackage.WORKSPACE_DATA_INTERNAL__INTERNAL_ACTIVE_PROJECT_SPACE,
					oldInternalActiveProjectSpace, internalActiveProjectSpace));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd,
			int featureID, NotificationChain msgs) {
		switch (featureID) {
		case ModelPackage.WORKSPACE_DATA_INTERNAL__INTERNAL_PROJECT_SPACES:
			return ((InternalEList<?>) getInternalProjectSpaces()).basicRemove(
					otherEnd, msgs);
		case ModelPackage.WORKSPACE_DATA_INTERNAL__INTERNAL_SERVER_INFOS:
			return ((InternalEList<?>) getInternalServerInfos()).basicRemove(
					otherEnd, msgs);
		case ModelPackage.WORKSPACE_DATA_INTERNAL__INTERNAL_USERSESSIONS:
			return ((InternalEList<?>) getInternalUsersessions()).basicRemove(
					otherEnd, msgs);
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
		case ModelPackage.WORKSPACE_DATA_INTERNAL__INTERNAL_PROJECT_SPACES:
			return getInternalProjectSpaces();
		case ModelPackage.WORKSPACE_DATA_INTERNAL__INTERNAL_SERVER_INFOS:
			return getInternalServerInfos();
		case ModelPackage.WORKSPACE_DATA_INTERNAL__INTERNAL_USERSESSIONS:
			return getInternalUsersessions();
		case ModelPackage.WORKSPACE_DATA_INTERNAL__INTERNAL_ACTIVE_PROJECT_SPACE:
			if (resolve)
				return getInternalActiveProjectSpace();
			return basicGetInternalActiveProjectSpace();
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
		case ModelPackage.WORKSPACE_DATA_INTERNAL__INTERNAL_PROJECT_SPACES:
			getInternalProjectSpaces().clear();
			getInternalProjectSpaces().addAll(
					(Collection<? extends ProjectSpaceDataInternal>) newValue);
			return;
		case ModelPackage.WORKSPACE_DATA_INTERNAL__INTERNAL_SERVER_INFOS:
			getInternalServerInfos().clear();
			getInternalServerInfos().addAll(
					(Collection<? extends ServerInfo>) newValue);
			return;
		case ModelPackage.WORKSPACE_DATA_INTERNAL__INTERNAL_USERSESSIONS:
			getInternalUsersessions().clear();
			getInternalUsersessions().addAll(
					(Collection<? extends Usersession>) newValue);
			return;
		case ModelPackage.WORKSPACE_DATA_INTERNAL__INTERNAL_ACTIVE_PROJECT_SPACE:
			setInternalActiveProjectSpace((ProjectSpaceDataInternal) newValue);
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
		case ModelPackage.WORKSPACE_DATA_INTERNAL__INTERNAL_PROJECT_SPACES:
			getInternalProjectSpaces().clear();
			return;
		case ModelPackage.WORKSPACE_DATA_INTERNAL__INTERNAL_SERVER_INFOS:
			getInternalServerInfos().clear();
			return;
		case ModelPackage.WORKSPACE_DATA_INTERNAL__INTERNAL_USERSESSIONS:
			getInternalUsersessions().clear();
			return;
		case ModelPackage.WORKSPACE_DATA_INTERNAL__INTERNAL_ACTIVE_PROJECT_SPACE:
			setInternalActiveProjectSpace((ProjectSpaceDataInternal) null);
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
		case ModelPackage.WORKSPACE_DATA_INTERNAL__INTERNAL_PROJECT_SPACES:
			return internalProjectSpaces != null
					&& !internalProjectSpaces.isEmpty();
		case ModelPackage.WORKSPACE_DATA_INTERNAL__INTERNAL_SERVER_INFOS:
			return internalServerInfos != null
					&& !internalServerInfos.isEmpty();
		case ModelPackage.WORKSPACE_DATA_INTERNAL__INTERNAL_USERSESSIONS:
			return internalUsersessions != null
					&& !internalUsersessions.isEmpty();
		case ModelPackage.WORKSPACE_DATA_INTERNAL__INTERNAL_ACTIVE_PROJECT_SPACE:
			return internalActiveProjectSpace != null;
		}
		return super.eIsSet(featureID);
	}

	@Override
	public List<ServerInfo> getServerInfos() {
		return (List<ServerInfo>) getInternalServerInfos();
	}

	@Override
	public List<Usersession> getUsersessions() {
		return (List<Usersession>) getInternalUsersessions();
	}

} //WorkspaceDataInternalImpl
