/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.unicase.workspace.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.unicase.esmodel.ProjectInfo;
import org.unicase.emfstore.exceptions.EmfStoreException;
import org.unicase.esmodel.ProjectId;
import org.unicase.esmodel.changemanagment.PrimaryVersionSpec;
import org.unicase.esmodel.changemanagment.VersionSpec;
import org.unicase.model.Project;
import org.unicase.workspace.Configuration;
import org.unicase.workspace.ProjectSpace;
import org.unicase.workspace.ProjectSpaceListener;
import org.unicase.workspace.ServerInfo;
import org.unicase.workspace.Usersession;
import org.unicase.workspace.Workspace;
import org.unicase.workspace.WorkspaceFactory;
import org.unicase.workspace.WorkspaceListener;
import org.unicase.workspace.WorkspacePackage;
import org.unicase.workspace.connectionmanager.ConnectionException;
import org.unicase.workspace.connectionmanager.ConnectionManager;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Workspace</b></em>'.
 * @implements ProjectSpaceListener
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.unicase.workspace.impl.WorkspaceImpl#getProjectSpaces <em>Project Spaces</em>}</li>
 *   <li>{@link org.unicase.workspace.impl.WorkspaceImpl#getServerInfos <em>Server Infos</em>}</li>
 *   <li>{@link org.unicase.workspace.impl.WorkspaceImpl#getUsersession <em>Usersession</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class WorkspaceImpl extends EObjectImpl implements Workspace, ProjectSpaceListener {
	
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
	 * The cached value of the '{@link #getServerInfos() <em>Server Infos</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getServerInfos()
	 * @generated
	 * @ordered
	 */
	protected EList<ServerInfo> serverInfos;

	/**
	 * The cached value of the '{@link #getUsersession() <em>Usersession</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUsersession()
	 * @generated
	 * @ordered
	 */
	protected EList<Usersession> usersession;

	/**
	 * The current connection manager used to connect to the server(s).
	 * @generated NOT
	 */
	private ConnectionManager connectionManager;

	/**
	 *
	 * @generated NOT
	 */
	private List<WorkspaceListener> listeners;
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	protected WorkspaceImpl() {
		super();
		this.listeners=new ArrayList<WorkspaceListener>();
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
	 * @generated
	 */
	public EList<Usersession> getUsersession() {
		if (usersession == null) {
			usersession = new EObjectContainmentEList<Usersession>(Usersession.class, this, WorkspacePackage.WORKSPACE__USERSESSION);
		}
		return usersession;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public ProjectSpace checkout(Usersession usersession, ProjectInfo projectInfo) throws EmfStoreException {
		
		//get Project from server
		Project project = this.connectionManager.getProject(usersession.getSessionId(), projectInfo.getProjectId(), projectInfo.getVersion());
		
		//resolve version spec if neccessary
		PrimaryVersionSpec primaryVersionSpec;
		if (projectInfo.getVersion() instanceof PrimaryVersionSpec) {
			primaryVersionSpec = (PrimaryVersionSpec) projectInfo.getVersion();
		}
		else {
			primaryVersionSpec = this.connectionManager.resolveVersionSpec(usersession.getSessionId(), projectInfo.getVersion());
		}
		//init project space
		ProjectSpace projectSpace = WorkspaceFactory.eINSTANCE.createProjectSpace();
		projectSpace.setProjectId(projectInfo.getProjectId());
		projectSpace.setProjectName(projectInfo.getName());
		projectSpace.setProjectDescription(projectInfo.getDescription());
		projectSpace.setBaseVersion(primaryVersionSpec);
		projectSpace.setLastUpdated(new Date());
		projectSpace.setUsersession(usersession);
		projectSpace.setProject(project);
		
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
			case WorkspacePackage.WORKSPACE__USERSESSION:
				return ((InternalEList<?>)getUsersession()).basicRemove(otherEnd, msgs);
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
			case WorkspacePackage.WORKSPACE__USERSESSION:
				return getUsersession();
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
			case WorkspacePackage.WORKSPACE__USERSESSION:
				getUsersession().clear();
				getUsersession().addAll((Collection<? extends Usersession>)newValue);
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
			case WorkspacePackage.WORKSPACE__USERSESSION:
				getUsersession().clear();
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
			case WorkspacePackage.WORKSPACE__USERSESSION:
				return usersession != null && !usersession.isEmpty();
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

	/** 
	 * @see org.eclipse.core.runtime.IAdaptable#getAdapter(java.lang.Class)
	 *
	 * @generated NOT
	 */
	public Object getAdapter(Class adapter) {
		// TODO Auto-generated method stub
		return null;
	}

	/** 
	 * @see org.unicase.workspace.Workspace#addWorkspaceListener(org.unicase.workspace.WorkspaceListener)
	 *
	 * @generated NOT
	 */
	public void addListener(WorkspaceListener listener) {
		this.listeners.add(listener);
		
	}

	public void init() {
		//initialize all projectSpaces
		for (ProjectSpace projectSpace: getProjectSpaces()) {
			projectSpace.init();
			projectSpace.addListener(this);
		}	
	}

	public void notifyProjectSpaceGotDirty() {
		for (WorkspaceListener listener: listeners) {
			listener.notifyWorkspaceGotDirty();
		}
	}

} //WorkspaceImpl
