/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.unicase.workspace.impl;

import java.io.IOException;
import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.unicase.emfstore.exceptions.EmfStoreException;
import org.unicase.esmodel.changemanagment.PrimaryVersionSpec;
import org.unicase.esmodel.changemanagment.VersionSpec;
import org.unicase.model.Project;
import org.unicase.model.ProjectId;
import org.unicase.workspace.Configuration;
import org.unicase.workspace.ProjectSpace;
import org.unicase.workspace.ServerInfo;
import org.unicase.workspace.Usersession;
import org.unicase.workspace.Workspace;
import org.unicase.workspace.WorkspaceFactory;
import org.unicase.workspace.WorkspacePackage;
import org.unicase.workspace.connectionmanager.ConnectionException;
import org.unicase.workspace.connectionmanager.ConnectionManager;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Workspace</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.unicase.workspace.impl.WorkspaceImpl#getProjectSpaces <em>Project Spaces</em>}</li>
 *   <li>{@link org.unicase.workspace.impl.WorkspaceImpl#getServerInfos <em>Server Infos</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class WorkspaceImpl extends EObjectImpl implements Workspace {
	
	/**
	 * @generated NOT
	 */
	private Resource resource;
	
	/**
	 * The cached value of the '{@link #getProjectSpaces() <em>Project Spaces</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getProjectSpaces()
	 * @generated
	 * @ordered
	 */
	protected EList<ProjectSpace> projectSpaces;

	/**
	 * The current connection manager used to connect to the server(s).
	 * @generated NOT
	 */
	private ConnectionManager connectionManager;
	
	/**
	 * The cached value of the '{@link #getServerInfos() <em>Server Infos</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getServerInfos()
	 * @generated
	 * @ordered
	 */
	protected EList<ServerInfo> serverInfos;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected WorkspaceImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return WorkspacePackage.Literals.WORKSPACE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ProjectSpace> getProjectSpaces() {
		if (projectSpaces == null) {
			projectSpaces = new EObjectContainmentEList<ProjectSpace>(ProjectSpace.class, this, WorkspacePackage.WORKSPACE__PROJECT_SPACES);
		}
		return projectSpaces;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ServerInfo> getServerInfos() {
		if (serverInfos == null) {
			serverInfos = new EObjectContainmentEList<ServerInfo>(ServerInfo.class, this, WorkspacePackage.WORKSPACE__SERVER_INFOS);
		}
		return serverInfos;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @throws ConnectionException 
	 * @throws ConnectionException 
	 * @generated NOT
	 */
public ProjectSpace checkout(Usersession usersession, ProjectId projectId, VersionSpec version) throws EmfStoreException {
		Project project = this.connectionManager.getProject(usersession.getSessionId(), projectId, version);
		PrimaryVersionSpec primaryVersionSpec = this.connectionManager.resolveVersionSpec(usersession.getSessionId(), version);
		ProjectSpace projectSpace = WorkspaceFactory.eINSTANCE.createProjectSpace();
		projectSpace.setBaseVersion(primaryVersionSpec);
		projectSpace.setProject(project);
		projectSpace.setUsersession(usersession);
		this.getProjectSpaces().add(projectSpace);
		save();
		return projectSpace;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public void save() {
		for (ProjectSpace projectSpace: this.getProjectSpaces()) {
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
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case WorkspacePackage.WORKSPACE__PROJECT_SPACES:
				return ((InternalEList<?>)getProjectSpaces()).basicRemove(otherEnd, msgs);
			case WorkspacePackage.WORKSPACE__SERVER_INFOS:
				return ((InternalEList<?>)getServerInfos()).basicRemove(otherEnd, msgs);
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
			case WorkspacePackage.WORKSPACE__PROJECT_SPACES:
				return getProjectSpaces();
			case WorkspacePackage.WORKSPACE__SERVER_INFOS:
				return getServerInfos();
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
			case WorkspacePackage.WORKSPACE__PROJECT_SPACES:
				getProjectSpaces().clear();
				getProjectSpaces().addAll((Collection<? extends ProjectSpace>)newValue);
				return;
			case WorkspacePackage.WORKSPACE__SERVER_INFOS:
				getServerInfos().clear();
				getServerInfos().addAll((Collection<? extends ServerInfo>)newValue);
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
			case WorkspacePackage.WORKSPACE__PROJECT_SPACES:
				getProjectSpaces().clear();
				return;
			case WorkspacePackage.WORKSPACE__SERVER_INFOS:
				getServerInfos().clear();
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
			case WorkspacePackage.WORKSPACE__PROJECT_SPACES:
				return projectSpaces != null && !projectSpaces.isEmpty();
			case WorkspacePackage.WORKSPACE__SERVER_INFOS:
				return serverInfos != null && !serverInfos.isEmpty();
		}
		return super.eIsSet(featureID);
	}
	
	/**
	 * @param connectionManager
	 * @generated NOT
	 */
	public void setConnectionManager(ConnectionManager connectionManager) {
		this.connectionManager=connectionManager;
	}
	
	/**
	 * @param resource
	 * @generated NOT
	 */
	public void setResource(Resource resource) {
		this.resource=resource;
	}

	public Object getAdapter(Class adapter) {
		// TODO Auto-generated method stub
		return null;
	}

} //WorkspaceImpl
