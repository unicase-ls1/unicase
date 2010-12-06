/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.workspace.impl;

import java.io.File;
import java.io.IOException;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.unicase.emfstore.esmodel.ProjectInfo;
import org.unicase.emfstore.esmodel.notification.ESNotification;
import org.unicase.emfstore.esmodel.url.ProjectUrlFragment;
import org.unicase.emfstore.esmodel.url.ServerUrl;
import org.unicase.emfstore.esmodel.versioning.ChangePackage;
import org.unicase.emfstore.esmodel.versioning.DateVersionSpec;
import org.unicase.emfstore.esmodel.versioning.PrimaryVersionSpec;
import org.unicase.emfstore.esmodel.versioning.VersionSpec;
import org.unicase.emfstore.esmodel.versioning.VersioningFactory;
import org.unicase.emfstore.esmodel.versioning.events.EventsFactory;
import org.unicase.emfstore.esmodel.versioning.events.PluginStartEvent;
import org.unicase.emfstore.exceptions.EmfStoreException;
import org.unicase.emfstore.exceptions.InvalidVersionSpecException;
import org.unicase.metamodel.MetamodelFactory;
import org.unicase.metamodel.Project;
import org.unicase.metamodel.util.FileUtil;
import org.unicase.metamodel.util.ModelUtil;
import org.unicase.workspace.Configuration;
import org.unicase.workspace.ProjectSpace;
import org.unicase.workspace.ServerInfo;
import org.unicase.workspace.Usersession;
import org.unicase.workspace.Workspace;
import org.unicase.workspace.WorkspaceFactory;
import org.unicase.workspace.WorkspaceManager;
import org.unicase.workspace.WorkspacePackage;
import org.unicase.workspace.connectionmanager.ConnectionManager;
import org.unicase.workspace.exceptions.ProjectUrlResolutionException;
import org.unicase.workspace.exceptions.ServerUrlResolutionException;
import org.unicase.workspace.exceptions.UnkownProjectException;
import org.unicase.workspace.notification.NotificationGenerator;
import org.unicase.workspace.observers.DeleteProjectSpaceObserver;
import org.unicase.workspace.util.ResourceHelper;
import org.unicase.workspace.util.WorkspaceUtil;

/**
 * <!-- begin-user-doc --> An implementation of the model object ' <em><b>Workspace</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link org.unicase.workspace.impl.WorkspaceImpl#getProjectSpaces <em>Project Spaces</em>}</li>
 * <li>{@link org.unicase.workspace.impl.WorkspaceImpl#getServerInfos <em>Server Infos</em>}</li>
 * <li>{@link org.unicase.workspace.impl.WorkspaceImpl#getUsersessions <em>Usersessions</em>}</li>
 * <li>{@link org.unicase.workspace.impl.WorkspaceImpl#getActiveProjectSpace <em>Active Project Space</em>}</li>
 * </ul>
 * </p>
 * 
 * @generated
 */
public class WorkspaceImpl extends EObjectImpl implements Workspace {

	/**
	 * @generated NOT
	 */
	private ResourceSet workspaceResourceSet;

	/**
	 * The cached value of the '{@link #getProjectSpaces() <em>Project Spaces</em>}' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getProjectSpaces()
	 * @generated
	 * @ordered
	 */
	protected EList<ProjectSpace> projectSpaces;

	/**
	 * The cached value of the '{@link #getServerInfos() <em>Server Infos</em>}' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getServerInfos()
	 * @generated
	 * @ordered
	 */
	protected EList<ServerInfo> serverInfos;

	/**
	 * The cached value of the '{@link #getUsersessions() <em>Usersessions</em>} ' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getUsersessions()
	 * @generated
	 * @ordered
	 */
	protected EList<Usersession> usersessions;

	/**
	 * The cached value of the '{@link #getActiveProjectSpace() <em>Active Project Space</em>}' reference. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getActiveProjectSpace()
	 * @generated
	 * @ordered
	 */
	protected ProjectSpace activeProjectSpace;

	// begin of custom code
	/**
	 * The current connection manager used to connect to the server(s).
	 * 
	 * @generated NOT
	 */
	private ConnectionManager connectionManager;
	private TransactionalEditingDomain transactionalEditingDomain;

	private Map<Project, ProjectSpace> projectToProjectSpaceMap;

	// end of custom code

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
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
			projectSpaces = new EObjectContainmentEList.Resolving<ProjectSpace>(ProjectSpace.class, this,
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
			serverInfos = new EObjectContainmentEList.Resolving<ServerInfo>(ServerInfo.class, this,
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
			usersessions = new EObjectContainmentEList.Resolving<Usersession>(Usersession.class, this,
				WorkspacePackage.WORKSPACE__USERSESSIONS);
		}
		return usersessions;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public ProjectSpace getActiveProjectSpace() {
		if (activeProjectSpace != null && activeProjectSpace.eIsProxy()) {
			InternalEObject oldActiveProjectSpace = (InternalEObject) activeProjectSpace;
			activeProjectSpace = (ProjectSpace) eResolveProxy(oldActiveProjectSpace);
			if (activeProjectSpace != oldActiveProjectSpace) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE,
						WorkspacePackage.WORKSPACE__ACTIVE_PROJECT_SPACE, oldActiveProjectSpace, activeProjectSpace));
			}
		}
		return activeProjectSpace;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public ProjectSpace basicGetActiveProjectSpace() {
		return activeProjectSpace;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setActiveProjectSpace(ProjectSpace newActiveProjectSpace) {
		ProjectSpace oldActiveProjectSpace = activeProjectSpace;
		activeProjectSpace = newActiveProjectSpace;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WorkspacePackage.WORKSPACE__ACTIVE_PROJECT_SPACE,
				oldActiveProjectSpace, activeProjectSpace));
	}

	public ProjectSpace checkout(final Usersession usersession, final ProjectInfo projectInfo) throws EmfStoreException {
		PrimaryVersionSpec targetSpec = this.connectionManager.resolveVersionSpec(usersession.getSessionId(),
			projectInfo.getProjectId(), VersionSpec.HEAD_VERSION);
		return checkout(usersession, projectInfo, targetSpec);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @generated NOT
	 */
	public ProjectSpace checkout(final Usersession usersession, final ProjectInfo projectInfo,
		PrimaryVersionSpec targetSpec) throws EmfStoreException {

		// MK: hack: set head version manually because esbrowser does not update revisions properly
		ProjectInfo projectInfoCopy = (ProjectInfo) EcoreUtil.copy(projectInfo);
		projectInfoCopy.setVersion(targetSpec);

		// get Project from server
		Project project = this.connectionManager.getProject(usersession.getSessionId(), projectInfo.getProjectId(),
			projectInfoCopy.getVersion());

		if (project == null) {
			throw new EmfStoreException("Server returned a null project!");
		}

		final PrimaryVersionSpec primaryVersionSpec = projectInfoCopy.getVersion();

		ProjectSpace projectSpace = WorkspaceFactory.eINSTANCE.createProjectSpace();

		// init project space
		projectSpace.setProjectId(projectInfo.getProjectId());
		projectSpace.setProjectName(projectInfo.getName());
		projectSpace.setProjectDescription(projectInfo.getDescription());
		projectSpace.setBaseVersion(primaryVersionSpec);
		projectSpace.setLastUpdated(new Date());
		projectSpace.setUsersession(usersession);
		usersession.addLoginObserver((ProjectSpaceImpl) projectSpace);
		projectSpace.setProject(project);
		projectSpace.setResourceCount(0);
		projectSpace.setLocalOperations(WorkspaceFactory.eINSTANCE.createOperationComposite());

		projectSpace.initResources(this.workspaceResourceSet);

		// getRecentChanges and generate notifications
		try {
			DateVersionSpec dateVersionSpec = VersioningFactory.eINSTANCE.createDateVersionSpec();
			Calendar calendar = Calendar.getInstance();
			calendar.add(Calendar.DAY_OF_YEAR, -10);
			dateVersionSpec.setDate(calendar.getTime());
			PrimaryVersionSpec sourceSpec;
			try {
				sourceSpec = this.connectionManager.resolveVersionSpec(usersession.getSessionId(), projectSpace
					.getProjectId(), dateVersionSpec);
			} catch (InvalidVersionSpecException e) {
				sourceSpec = VersioningFactory.eINSTANCE.createPrimaryVersionSpec();
				sourceSpec.setIdentifier(0);
			}
			List<ChangePackage> changes = connectionManager.getChanges(usersession.getSessionId(), projectSpace
				.getProjectId(), sourceSpec, targetSpec);
			List<ESNotification> newNotifications = NotificationGenerator.getInstance(projectSpace)
				.generateNotifications(changes, usersession.getUsername());
			projectSpace.getNotificationsFromComposite().addAll(newNotifications);
			projectSpace.eResource().save(null);
		} catch (EmfStoreException e) {
			projectSpace.getNotificationsFromComposite().clear();
			WorkspaceUtil.logWarning("Creating notifications failed!", e);
			// BEGIN SUPRESS CATCH EXCEPTION
		} catch (RuntimeException e) {
			// END SUPRESS CATCH EXCEPTION
			projectSpace.getNotificationsFromComposite().clear();
			WorkspaceUtil.logWarning("Creating notifications failed!", e);
		} catch (IOException e) {
			projectSpace.getNotificationsFromComposite().clear();
			WorkspaceUtil.logWarning("Creating notifications failed!", e);
		}

		addProjectSpace(projectSpace);
		this.save();

		return projectSpace;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @generated NOT
	 */
	public void save() {
		try {
			this.eResource().save(Configuration.getResourceSaveOptions());
		} catch (IOException e) {
			// MK Auto-generated catch block
			// FIXME OW MK: also insert code for dangling href handling here

		}
	}

	// end of custom code
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
		case WorkspacePackage.WORKSPACE__PROJECT_SPACES:
			return ((InternalEList<?>) getProjectSpaces()).basicRemove(otherEnd, msgs);
		case WorkspacePackage.WORKSPACE__SERVER_INFOS:
			return ((InternalEList<?>) getServerInfos()).basicRemove(otherEnd, msgs);
		case WorkspacePackage.WORKSPACE__USERSESSIONS:
			return ((InternalEList<?>) getUsersessions()).basicRemove(otherEnd, msgs);
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
		case WorkspacePackage.WORKSPACE__ACTIVE_PROJECT_SPACE:
			if (resolve)
				return getActiveProjectSpace();
			return basicGetActiveProjectSpace();
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
			getProjectSpaces().addAll((Collection<? extends ProjectSpace>) newValue);
			return;
		case WorkspacePackage.WORKSPACE__SERVER_INFOS:
			getServerInfos().clear();
			getServerInfos().addAll((Collection<? extends ServerInfo>) newValue);
			return;
		case WorkspacePackage.WORKSPACE__USERSESSIONS:
			getUsersessions().clear();
			getUsersessions().addAll((Collection<? extends Usersession>) newValue);
			return;
		case WorkspacePackage.WORKSPACE__ACTIVE_PROJECT_SPACE:
			setActiveProjectSpace((ProjectSpace) newValue);
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
		case WorkspacePackage.WORKSPACE__ACTIVE_PROJECT_SPACE:
			setActiveProjectSpace((ProjectSpace) null);
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
		case WorkspacePackage.WORKSPACE__ACTIVE_PROJECT_SPACE:
			return activeProjectSpace != null;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @generated NOT
	 */
	public void setConnectionManager(ConnectionManager connectionManager) {
		this.connectionManager = connectionManager;
	}

	/**
	 * {@inheritDoc} This is to enable the workspace to be root of table views.
	 * 
	 * @see org.eclipse.core.runtime.IAdaptable#getAdapter(java.lang.Class)
	 * @generated NOT
	 */
	@SuppressWarnings("unchecked")
	public Object getAdapter(Class adapter) {
		return null;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.unicase.workspace.Workspace#init(org.eclipse.emf.transaction.TransactionalEditingDomain)
	 * @generated NOT
	 */
	public void init(TransactionalEditingDomain editingDomain) {
		this.transactionalEditingDomain = editingDomain;
		projectToProjectSpaceMap = new HashMap<Project, ProjectSpace>();
		// initialize all projectSpaces
		for (ProjectSpace projectSpace : getProjectSpaces()) {
			projectSpace.init();
			projectToProjectSpaceMap.put(projectSpace.getProject(), projectSpace);
			// add plugin start event
			PluginStartEvent event = EventsFactory.eINSTANCE.createPluginStartEvent();
			event.setPluginId("org.unicase.workspace");
			event.setTimestamp(new Date());
			projectSpace.addEvent(event);
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.unicase.workspace.Workspace#getEditingDomain()
	 * @generated NOT
	 */
	public TransactionalEditingDomain getEditingDomain() {
		return this.transactionalEditingDomain;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.unicase.workspace.Workspace#importProject(java.lang.String)
	 */
	public ProjectSpace importProject(String absoluteFileName) throws IOException {
		Project project = ResourceHelper.getElementFromResource(absoluteFileName, Project.class, 0);
		return importProject(project, absoluteFileName.substring(absoluteFileName.lastIndexOf(File.separatorChar) + 1),
			"Imported from " + absoluteFileName);
	}

	/**
	 * {@inheritDoc}
	 */
	public ProjectSpace importProject(Project project, String name, String description) {
		ProjectSpace projectSpace = WorkspaceFactory.eINSTANCE.createProjectSpace();
		projectSpace.setProject(project);
		projectSpace.setProjectName(name);
		projectSpace.setProjectDescription(description);
		projectSpace.setLocalOperations(WorkspaceFactory.eINSTANCE.createOperationComposite());

		projectSpace.initResources(this.workspaceResourceSet);

		addProjectSpace(projectSpace);
		this.save();

		return projectSpace;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.unicase.workspace.Workspace#importProjectSpace(java.lang.String)
	 */
	public ProjectSpace importProjectSpace(String absoluteFileName) throws IOException {

		ProjectSpace projectSpace = ResourceHelper.getElementFromResource(absoluteFileName, ProjectSpace.class, 0);

		projectSpace.initResources(this.workspaceResourceSet);

		addProjectSpace(projectSpace);
		this.save();
		return projectSpace;
	}

	/**
	 * Adds a new ProjectSpace to workspace.
	 * 
	 * @param projectSpace project space
	 */
	public void addProjectSpace(ProjectSpace projectSpace) {
		getProjectSpaces().add(projectSpace);
		projectToProjectSpaceMap.put(projectSpace.getProject(), projectSpace);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.unicase.workspace.Workspace#setWorkspaceResourceSet(org.eclipse.emf.ecore.resource.ResourceSet)
	 */
	public void setWorkspaceResourceSet(ResourceSet resourceSet) {
		this.workspaceResourceSet = resourceSet;
	}

	/**
	 * {@inheritDoc}
	 */
	public ResourceSet getWorkspaceResourceSet() {
		return this.workspaceResourceSet;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.unicase.workspace.Workspace#exportProjectSpace(org.unicase.workspace.ProjectSpace, java.lang.String)
	 */
	public void exportProjectSpace(ProjectSpace projectSpace, String absoluteFileName) throws IOException {

		ProjectSpace copiedProjectSpace = (ProjectSpace) EcoreUtil.copy(projectSpace);
		copiedProjectSpace.setUsersession(null);

		Project clonedProject = ModelUtil.clone(projectSpace.getProject());
		copiedProjectSpace.setProject(clonedProject);

		ResourceHelper.putElementIntoNewResourceWithProject(absoluteFileName, copiedProjectSpace, copiedProjectSpace
			.getProject());
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.unicase.workspace.Workspace#exportWorkSpace(java.lang.String)
	 */
	public void exportWorkSpace(String absoluteFileName) throws IOException {

		Workspace copy = ModelUtil.clone(WorkspaceManager.getInstance().getCurrentWorkspace());

		int i = 0;

		for (ProjectSpace copiedProjectSpace : copy.getProjectSpaces()) {
			Project orgProject = WorkspaceManager.getInstance().getCurrentWorkspace().getProjectSpaces().get(i++)
				.getProject();
			copiedProjectSpace.setProject(ModelUtil.clone(orgProject));
		}

		ResourceHelper.putWorkspaceIntoNewResource(absoluteFileName, copy);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.unicase.workspace.Workspace#exportProject(org.unicase.workspace.ProjectSpace, java.lang.String)
	 */
	public void exportProject(ProjectSpace projectSpace, String absoluteFileName) throws IOException {

		Project project = (Project) EcoreUtil.copy(projectSpace.getProject());
		ResourceHelper.putElementIntoNewResource(absoluteFileName, project);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.unicase.workspace.Workspace#resolve(org.unicase.emfstore.esmodel.url.ProjectUrlFragment)
	 */
	public Set<ProjectSpace> resolve(ProjectUrlFragment projectUrlFragment) throws ProjectUrlResolutionException {
		Set<ProjectSpace> result = new HashSet<ProjectSpace>();
		for (ProjectSpace projectSpace : getProjectSpaces()) {
			if (projectSpace.getProjectId().equals(projectUrlFragment.getProjectId())) {
				result.add(projectSpace);
			}
		}
		if (result.size() == 0) {
			throw new ProjectUrlResolutionException();
		}
		return result;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.unicase.workspace.Workspace#resolve(org.unicase.emfstore.esmodel.url.ServerUrl)
	 */
	public Set<ServerInfo> resolve(ServerUrl serverUrl) throws ServerUrlResolutionException {
		Set<ServerInfo> result = new HashSet<ServerInfo>();
		for (ServerInfo serverInfo : getServerInfos()) {
			boolean matchingHostname = serverInfo.getUrl().equals(serverUrl.getHostName());
			boolean matchingPort = serverInfo.getPort() == serverUrl.getPort();
			if (matchingHostname && matchingPort) {
				result.add(serverInfo);
			}
		}
		if (result.size() == 0) {
			throw new ServerUrlResolutionException();
		}
		return result;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.unicase.workspace.Workspace#getProjectSpace(org.unicase.metamodel.Project)
	 */
	public ProjectSpace getProjectSpace(Project project) throws UnkownProjectException {
		ProjectSpace projectSpace = projectToProjectSpaceMap.get(project);
		if (projectSpace == null) {
			throw new UnkownProjectException();
		}
		return projectSpace;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.unicase.workspace.Workspace#deleteProjectSpace(org.unicase.workspace.ProjectSpace)
	 */
	public void deleteProjectSpace(ProjectSpace projectSpace) throws IOException {

		// delete project to notify listeners
		projectSpace.getProject().delete();

		getProjectSpaces().remove(projectSpace);
		if (getActiveProjectSpace() == projectSpace) {
			setActiveProjectSpace(null);
		}
		save();
		projectToProjectSpaceMap.remove(projectSpace.getProject());

		// delete folder of projectSPace
		String pathToProject = Configuration.getWorkspaceDirectory() + "ps-" + projectSpace.getIdentifier();
		FileUtil.deleteFolder(new File(pathToProject));

		WorkspaceManager.getObserverBus().notify(DeleteProjectSpaceObserver.class).projectDeleted(projectSpace);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @generated NOT
	 */
	public ProjectSpace createLocalProject(String projectName, String projectDescription) {

		ProjectSpace projectSpace = WorkspaceFactory.eINSTANCE.createProjectSpace();
		projectSpace.setProject(MetamodelFactory.eINSTANCE.createProject());
		projectSpace.setProjectName(projectName);
		projectSpace.setProjectDescription(projectDescription);
		projectSpace.setLocalOperations(WorkspaceFactory.eINSTANCE.createOperationComposite());

		projectSpace.initResources(this.getWorkspaceResourceSet());

		this.addProjectSpace(projectSpace);
		this.save();

		return projectSpace;
	}

} // WorkspaceImpl
