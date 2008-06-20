/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Kšgel. All rights reserved. This program and the accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this distribution, and is available at http://www.eclipse.org/legal/epl-v10.html
 * </copyright>
 *
 * $Id$
 */
package org.unicase.workspace.impl;

import java.io.IOException;
import java.util.Collection;
import java.util.Date;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.unicase.emfstore.esmodel.ProjectInfo;
import org.unicase.emfstore.esmodel.changemanagment.PrimaryVersionSpec;
import org.unicase.emfstore.exceptions.EmfStoreException;
import org.unicase.model.Project;
import org.unicase.workspace.Configuration;
import org.unicase.workspace.ProjectSpace;
import org.unicase.workspace.ServerInfo;
import org.unicase.workspace.Usersession;
import org.unicase.workspace.Workspace;
import org.unicase.workspace.WorkspaceFactory;
import org.unicase.workspace.WorkspacePackage;
import org.unicase.workspace.connectionmanager.ConnectionManager;

/**
 * <!-- begin-user-doc --> An implementation of the model object '
 * <em><b>Workspace</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link org.unicase.workspace.impl.WorkspaceImpl#getProjectSpaces <em>
 * Project Spaces</em>}</li>
 * <li>{@link org.unicase.workspace.impl.WorkspaceImpl#getServerInfos <em>Server
 * Infos</em>}</li>
 * <li>{@link org.unicase.workspace.impl.WorkspaceImpl#getUsersessions <em>
 * Usersessions</em>}</li>
 * </ul>
 * </p>
 * 
 * @generated
 */
public class WorkspaceImpl extends EObjectImpl implements Workspace {
	ProjectSpace projectSpace;
	/**
	 * @generated NOT
	 */
	private Resource resource;

	/**
	 * The cached value of the '{@link #getProjectSpaces()
	 * <em>Project Spaces</em>}' containment reference list. <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * 
	 * @see #getProjectSpaces()
	 * @generated
	 * @ordered
	 */
	protected EList<ProjectSpace> projectSpaces;

	/**
	 * The cached value of the '{@link #getServerInfos() <em>Server Infos</em>}'
	 * containment reference list. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getServerInfos()
	 * @generated
	 * @ordered
	 */
	protected EList<ServerInfo> serverInfos;

	/**
	 * The cached value of the '{@link #getUsersessions() <em>Usersessions</em>}
	 * ' containment reference list. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @see #getUsersessions()
	 * @generated
	 * @ordered
	 */
	protected EList<Usersession> usersessions;

	//begin of custom code
	/**
	 * The current connection manager used to connect to the server(s).
	 * 
	 * @generated NOT
	 */
	private ConnectionManager connectionManager;
	private TransactionalEditingDomain transactionalEditingDomain;
	//end of custom code
	
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated 
	 * 
	 */
	protected WorkspaceImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return WorkspacePackage.Literals.WORKSPACE;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EList<ProjectSpace> getProjectSpaces() {
		if (projectSpaces == null) {
			projectSpaces = new EObjectContainmentEList<ProjectSpace>(
					ProjectSpace.class, this,
					WorkspacePackage.WORKSPACE__PROJECT_SPACES);
		}
		return projectSpaces;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EList<ServerInfo> getServerInfos() {
		if (serverInfos == null) {
			serverInfos = new EObjectContainmentEList<ServerInfo>(
					ServerInfo.class, this,
					WorkspacePackage.WORKSPACE__SERVER_INFOS);
		}
		return serverInfos;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EList<Usersession> getUsersessions() {
		if (usersessions == null) {
			usersessions = new EObjectContainmentEList<Usersession>(
					Usersession.class, this,
					WorkspacePackage.WORKSPACE__USERSESSIONS);
		}
		return usersessions;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public ProjectSpace checkout(final Usersession usersession,
			final ProjectInfo projectInfo) throws EmfStoreException {

		// get Project from server
		final Project project = this.connectionManager.getProject(usersession
				.getSessionId(), projectInfo.getProjectId(), projectInfo
				.getVersion());

		final PrimaryVersionSpec primaryVersionSpec = projectInfo.getVersion();
		
		// init project space
		TransactionalEditingDomain domain = TransactionalEditingDomain.Registry.INSTANCE
				.getEditingDomain("org.unicase.EditingDomain");
		domain.getCommandStack().execute(new RecordingCommand(domain) {
			@Override
			protected void doExecute() {
				projectSpace = WorkspaceFactory.eINSTANCE.createProjectSpace();
				projectSpace.setProjectId(projectInfo.getProjectId());
				projectSpace.setProjectName(projectInfo.getName());
				projectSpace
						.setProjectDescription(projectInfo.getDescription());
				projectSpace.setBaseVersion(primaryVersionSpec);
				projectSpace.setLastUpdated(new Date());
				projectSpace.setUsersession(usersession);
				projectSpace.setProject(project);

				getProjectSpaces().add(projectSpace);
				save();
			}
		});

		return projectSpace;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public void save() {
		for (ProjectSpace projectSpace : this.getProjectSpaces()) {
			projectSpace.save();
		}
		try {
			this.resource.save(Configuration.getResourceSaveOptions());
		} catch (IOException e) {
			// MK Auto-generated catch block
			e.printStackTrace();
		}

	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public boolean isDirty() {
		for (ProjectSpace projectSpace : this.projectSpaces) {
			if (projectSpace.isDirty()) {
				return true;
			}
		}
		return false;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd,
			int featureID, NotificationChain msgs) {
		switch (featureID) {
		case WorkspacePackage.WORKSPACE__PROJECT_SPACES:
			return ((InternalEList<?>) getProjectSpaces()).basicRemove(
					otherEnd, msgs);
		case WorkspacePackage.WORKSPACE__SERVER_INFOS:
			return ((InternalEList<?>) getServerInfos()).basicRemove(otherEnd,
					msgs);
		case WorkspacePackage.WORKSPACE__USERSESSIONS:
			return ((InternalEList<?>) getUsersessions()).basicRemove(otherEnd,
					msgs);
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
		case WorkspacePackage.WORKSPACE__PROJECT_SPACES:
			return getProjectSpaces();
		case WorkspacePackage.WORKSPACE__SERVER_INFOS:
			return getServerInfos();
		case WorkspacePackage.WORKSPACE__USERSESSIONS:
			return getUsersessions();
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
		case WorkspacePackage.WORKSPACE__PROJECT_SPACES:
			getProjectSpaces().clear();
			getProjectSpaces().addAll(
					(Collection<? extends ProjectSpace>) newValue);
			return;
		case WorkspacePackage.WORKSPACE__SERVER_INFOS:
			getServerInfos().clear();
			getServerInfos()
					.addAll((Collection<? extends ServerInfo>) newValue);
			return;
		case WorkspacePackage.WORKSPACE__USERSESSIONS:
			getUsersessions().clear();
			getUsersessions().addAll(
					(Collection<? extends Usersession>) newValue);
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
		case WorkspacePackage.WORKSPACE__PROJECT_SPACES:
			getProjectSpaces().clear();
			return;
		case WorkspacePackage.WORKSPACE__SERVER_INFOS:
			getServerInfos().clear();
			return;
		case WorkspacePackage.WORKSPACE__USERSESSIONS:
			getUsersessions().clear();
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
		case WorkspacePackage.WORKSPACE__PROJECT_SPACES:
			return projectSpaces != null && !projectSpaces.isEmpty();
		case WorkspacePackage.WORKSPACE__SERVER_INFOS:
			return serverInfos != null && !serverInfos.isEmpty();
		case WorkspacePackage.WORKSPACE__USERSESSIONS:
			return usersessions != null && !usersessions.isEmpty();
		}
		return super.eIsSet(featureID);
	}

	/**
	 * @param connectionManager
	 * @generated NOT
	 */
	public void setConnectionManager(ConnectionManager connectionManager) {
		this.connectionManager = connectionManager;
	}

	/**
	 * @param resource
	 * @generated NOT
	 */
	public void setResource(Resource resource) {
		this.resource = resource;
	}

	/**
	 * @see org.eclipse.core.runtime.IAdaptable#getAdapter(java.lang.Class)
	 * 
	 * @generated NOT
	 */
	@SuppressWarnings("unchecked")
	public Object getAdapter(Class adapter) {
		// TODO Auto-generated method stub
		return null;
	}

	public void init(TransactionalEditingDomain editingDomain) {
		this.transactionalEditingDomain=editingDomain;
		// initialize all projectSpaces
		for (ProjectSpace projectSpace : getProjectSpaces()) {
			projectSpace.init();
		}
	}

	public TransactionalEditingDomain getEditingDomain() {
		return this.transactionalEditingDomain;
	}
} // WorkspaceImpl
