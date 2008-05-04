/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.unicase.workspace.impl;

import java.util.Collection;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.change.util.ChangeRecorder;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.unicase.esmodel.SessionId;
import org.unicase.esmodel.changemanagment.PrimaryVersionSpec;
import org.unicase.esmodel.changemanagment.VersionSpec;
import org.unicase.model.Project;
import org.unicase.model.ProjectId;
import org.unicase.workspace.ConnectionException;
import org.unicase.workspace.ProjectSpace;
import org.unicase.workspace.ServerInfo;
import org.unicase.workspace.Usersession;
import org.unicase.workspace.Workspace;
import org.unicase.workspace.WorkspacePackage;
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
	 * The cached value of the '{@link #getProjectSpaces() <em>Project Spaces</em>}' reference list.
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
	 * The cached value of the '{@link #getServerInfos() <em>Server Infos</em>}' reference list.
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
			projectSpaces = new EObjectResolvingEList<ProjectSpace>(ProjectSpace.class, this, WorkspacePackage.WORKSPACE__PROJECT_SPACES);
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
			serverInfos = new EObjectResolvingEList<ServerInfo>(ServerInfo.class, this, WorkspacePackage.WORKSPACE__SERVER_INFOS);
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
public ProjectSpace checkout(Usersession usersession, ProjectId projectId, VersionSpec version) throws ConnectionException {
		Project project = this.connectionManager.getProject(usersession.getSessionId(), projectId, version);
		PrimaryVersionSpec primaryVersionSpec = this.connectionManager.resolveVersionSpec(version);
		ProjectSpace projectSpace = WorkspaceFactoryImpl.eINSTANCE.createProjectSpace();
		projectSpace.setBaseVersion(primaryVersionSpec);
		projectSpace.setProject(project);
		projectSpace.setUsersession(usersession);
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
		//TODO:
		//now save the workspace to file
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

} //WorkspaceImpl
