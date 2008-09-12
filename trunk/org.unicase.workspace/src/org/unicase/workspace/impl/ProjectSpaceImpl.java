/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this distribution, and is available at http://www.eclipse.org/legal/epl-v10.html
 * </copyright>
 *
 * $Id$
 */
package org.unicase.workspace.impl;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.change.ChangeDescription;
import org.eclipse.emf.ecore.change.util.ChangeRecorder;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.xmi.DanglingHREFException;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.unicase.emfstore.esmodel.EsmodelFactory;
import org.unicase.emfstore.esmodel.ProjectId;
import org.unicase.emfstore.esmodel.ProjectInfo;
import org.unicase.emfstore.esmodel.versioning.ChangePackage;
import org.unicase.emfstore.esmodel.versioning.LogMessage;
import org.unicase.emfstore.esmodel.versioning.PrimaryVersionSpec;
import org.unicase.emfstore.esmodel.versioning.VersionSpec;
import org.unicase.emfstore.esmodel.versioning.VersioningFactory;
import org.unicase.emfstore.exceptions.BaseVersionOutdatedException;
import org.unicase.emfstore.exceptions.EmfStoreException;
import org.unicase.model.ModelElement;
import org.unicase.model.Project;
import org.unicase.model.impl.IdentifiableElementImpl;
import org.unicase.model.util.ModelElementChangeNotifier;
import org.unicase.model.util.ModelElementChangeObserver;
import org.unicase.model.util.ModelValidationHelper;
import org.unicase.workspace.Configuration;
import org.unicase.workspace.ProjectSpace;
import org.unicase.workspace.Usersession;
import org.unicase.workspace.WorkspaceManager;
import org.unicase.workspace.WorkspacePackage;
import org.unicase.workspace.connectionmanager.ConnectionManager;
import org.unicase.workspace.exceptions.IllegalProjectSpaceStateException;
import org.unicase.workspace.exceptions.NoChangesOnServerException;
import org.unicase.workspace.exceptions.NoLocalChangesException;

/**
 * <!-- begin-user-doc --> An implementation of the model object '
 * <em><b>Project Container</b></em>'.
 * 
 * @implements ModelElementChangeObserver <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.unicase.workspace.impl.ProjectSpaceImpl#getProject <em>Project</em>}</li>
 *   <li>{@link org.unicase.workspace.impl.ProjectSpaceImpl#getProjectId <em>Project Id</em>}</li>
 *   <li>{@link org.unicase.workspace.impl.ProjectSpaceImpl#getProjectName <em>Project Name</em>}</li>
 *   <li>{@link org.unicase.workspace.impl.ProjectSpaceImpl#getProjectDescription <em>Project Description</em>}</li>
 *   <li>{@link org.unicase.workspace.impl.ProjectSpaceImpl#getLocalChanges <em>Local Changes</em>}</li>
 *   <li>{@link org.unicase.workspace.impl.ProjectSpaceImpl#getUsersession <em>Usersession</em>}</li>
 *   <li>{@link org.unicase.workspace.impl.ProjectSpaceImpl#getLastUpdated <em>Last Updated</em>}</li>
 *   <li>{@link org.unicase.workspace.impl.ProjectSpaceImpl#getBaseVersion <em>Base Version</em>}</li>
 *   <li>{@link org.unicase.workspace.impl.ProjectSpaceImpl#getResourceCount <em>Resource Count</em>}</li>
 *   <li>{@link org.unicase.workspace.impl.ProjectSpaceImpl#isDirty <em>Dirty</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ProjectSpaceImpl extends IdentifiableElementImpl implements
		ProjectSpace, ModelElementChangeObserver {

	/**
	 * @generated NOT
	 */
	private ChangeRecorder changeRecorder;

	/**
	 * The cached value of the '{@link #getProject() <em>Project</em>}' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getProject()
	 * @generated
	 * @ordered
	 */
	protected Project project;

	/**
	 * The cached value of the '{@link #getProjectId() <em>Project Id</em>}' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getProjectId()
	 * @generated
	 * @ordered
	 */
	protected ProjectId projectId;

	/**
	 * The default value of the '{@link #getProjectName() <em>Project Name</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getProjectName()
	 * @generated
	 * @ordered
	 */
	protected static final String PROJECT_NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getProjectName() <em>Project Name</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getProjectName()
	 * @generated
	 * @ordered
	 */
	protected String projectName = PROJECT_NAME_EDEFAULT;

	/**
	 * The default value of the '{@link #getProjectDescription() <em>Project Description</em>}' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @see #getProjectDescription()
	 * @generated
	 * @ordered
	 */
	protected static final String PROJECT_DESCRIPTION_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getProjectDescription() <em>Project Description</em>}' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @see #getProjectDescription()
	 * @generated
	 * @ordered
	 */
	protected String projectDescription = PROJECT_DESCRIPTION_EDEFAULT;

	/**
	 * The cached value of the '{@link #getLocalChanges() <em>Local Changes</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLocalChanges()
	 * @generated
	 * @ordered
	 */
	protected ChangeDescription localChanges;

	/**
	 * The cached value of the '{@link #getUsersession() <em>Usersession</em>}' reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getUsersession()
	 * @generated
	 * @ordered
	 */
	protected Usersession usersession;

	/**
	 * The default value of the '{@link #getLastUpdated() <em>Last Updated</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getLastUpdated()
	 * @generated
	 * @ordered
	 */
	protected static final Date LAST_UPDATED_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getLastUpdated() <em>Last Updated</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getLastUpdated()
	 * @generated
	 * @ordered
	 */
	protected Date lastUpdated = LAST_UPDATED_EDEFAULT;

	/**
	 * The cached value of the '{@link #getBaseVersion() <em>Base Version</em>}' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getBaseVersion()
	 * @generated
	 * @ordered
	 */
	protected PrimaryVersionSpec baseVersion;

	/**
	 * The default value of the '{@link #getResourceCount() <em>Resource Count</em>}' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @see #getResourceCount()
	 * @generated
	 * @ordered
	 */
	protected static final int RESOURCE_COUNT_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getResourceCount() <em>Resource Count</em>}' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @see #getResourceCount()
	 * @generated
	 * @ordered
	 */
	protected int resourceCount = RESOURCE_COUNT_EDEFAULT;

	/**
	 * The default value of the '{@link #isDirty() <em>Dirty</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isDirty()
	 * @generated
	 * @ordered
	 */
	protected static final boolean DIRTY_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isDirty() <em>Dirty</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isDirty()
	 * @generated
	 * @ordered
	 */
	protected boolean dirty = DIRTY_EDEFAULT;

	// begin of custom code
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	protected ProjectSpaceImpl() {
		super();
	}

	// end of custom code

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return WorkspacePackage.Literals.PROJECT_SPACE;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public Project getProject() {
		if (project != null && project.eIsProxy()) {
			InternalEObject oldProject = (InternalEObject) project;
			project = (Project) eResolveProxy(oldProject);
			if (project != oldProject) {
				InternalEObject newProject = (InternalEObject) project;
				NotificationChain msgs = oldProject.eInverseRemove(this,
						EOPPOSITE_FEATURE_BASE
								- WorkspacePackage.PROJECT_SPACE__PROJECT,
						null, null);
				if (newProject.eInternalContainer() == null) {
					msgs = newProject.eInverseAdd(this, EOPPOSITE_FEATURE_BASE
							- WorkspacePackage.PROJECT_SPACE__PROJECT, null,
							msgs);
				}
				if (msgs != null)
					msgs.dispatch();
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE,
							WorkspacePackage.PROJECT_SPACE__PROJECT,
							oldProject, project));
			}
		}
		return project;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public Project basicGetProject() {
		return project;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetProject(Project newProject,
			NotificationChain msgs) {
		Project oldProject = project;
		project = newProject;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this,
					Notification.SET, WorkspacePackage.PROJECT_SPACE__PROJECT,
					oldProject, newProject);
			if (msgs == null)
				msgs = notification;
			else
				msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setProject(Project newProject) {
		if (newProject != project) {
			NotificationChain msgs = null;
			if (project != null)
				msgs = ((InternalEObject) project).eInverseRemove(this,
						EOPPOSITE_FEATURE_BASE
								- WorkspacePackage.PROJECT_SPACE__PROJECT,
						null, msgs);
			if (newProject != null)
				msgs = ((InternalEObject) newProject).eInverseAdd(this,
						EOPPOSITE_FEATURE_BASE
								- WorkspacePackage.PROJECT_SPACE__PROJECT,
						null, msgs);
			msgs = basicSetProject(newProject, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					WorkspacePackage.PROJECT_SPACE__PROJECT, newProject,
					newProject));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public ProjectId getProjectId() {
		if (projectId != null && projectId.eIsProxy()) {
			InternalEObject oldProjectId = (InternalEObject) projectId;
			projectId = (ProjectId) eResolveProxy(oldProjectId);
			if (projectId != oldProjectId) {
				InternalEObject newProjectId = (InternalEObject) projectId;
				NotificationChain msgs = oldProjectId.eInverseRemove(this,
						EOPPOSITE_FEATURE_BASE
								- WorkspacePackage.PROJECT_SPACE__PROJECT_ID,
						null, null);
				if (newProjectId.eInternalContainer() == null) {
					msgs = newProjectId
							.eInverseAdd(
									this,
									EOPPOSITE_FEATURE_BASE
											- WorkspacePackage.PROJECT_SPACE__PROJECT_ID,
									null, msgs);
				}
				if (msgs != null)
					msgs.dispatch();
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE,
							WorkspacePackage.PROJECT_SPACE__PROJECT_ID,
							oldProjectId, projectId));
			}
		}
		return projectId;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public ProjectId basicGetProjectId() {
		return projectId;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetProjectId(ProjectId newProjectId,
			NotificationChain msgs) {
		ProjectId oldProjectId = projectId;
		projectId = newProjectId;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this,
					Notification.SET,
					WorkspacePackage.PROJECT_SPACE__PROJECT_ID, oldProjectId,
					newProjectId);
			if (msgs == null)
				msgs = notification;
			else
				msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setProjectId(ProjectId newProjectId) {
		if (newProjectId != projectId) {
			NotificationChain msgs = null;
			if (projectId != null)
				msgs = ((InternalEObject) projectId).eInverseRemove(this,
						EOPPOSITE_FEATURE_BASE
								- WorkspacePackage.PROJECT_SPACE__PROJECT_ID,
						null, msgs);
			if (newProjectId != null)
				msgs = ((InternalEObject) newProjectId).eInverseAdd(this,
						EOPPOSITE_FEATURE_BASE
								- WorkspacePackage.PROJECT_SPACE__PROJECT_ID,
						null, msgs);
			msgs = basicSetProjectId(newProjectId, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					WorkspacePackage.PROJECT_SPACE__PROJECT_ID, newProjectId,
					newProjectId));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String getProjectName() {
		return projectName;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setProjectName(String newProjectName) {
		String oldProjectName = projectName;
		projectName = newProjectName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					WorkspacePackage.PROJECT_SPACE__PROJECT_NAME,
					oldProjectName, projectName));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String getProjectDescription() {
		return projectDescription;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setProjectDescription(String newProjectDescription) {
		String oldProjectDescription = projectDescription;
		projectDescription = newProjectDescription;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					WorkspacePackage.PROJECT_SPACE__PROJECT_DESCRIPTION,
					oldProjectDescription, projectDescription));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public ChangeDescription getLocalChanges() {
		if (localChanges != null && localChanges.eIsProxy()) {
			InternalEObject oldLocalChanges = (InternalEObject) localChanges;
			localChanges = (ChangeDescription) eResolveProxy(oldLocalChanges);
			if (localChanges != oldLocalChanges) {
				InternalEObject newLocalChanges = (InternalEObject) localChanges;
				NotificationChain msgs = oldLocalChanges
						.eInverseRemove(
								this,
								EOPPOSITE_FEATURE_BASE
										- WorkspacePackage.PROJECT_SPACE__LOCAL_CHANGES,
								null, null);
				if (newLocalChanges.eInternalContainer() == null) {
					msgs = newLocalChanges
							.eInverseAdd(
									this,
									EOPPOSITE_FEATURE_BASE
											- WorkspacePackage.PROJECT_SPACE__LOCAL_CHANGES,
									null, msgs);
				}
				if (msgs != null)
					msgs.dispatch();
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE,
							WorkspacePackage.PROJECT_SPACE__LOCAL_CHANGES,
							oldLocalChanges, localChanges));
			}
		}
		return localChanges;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public ChangeDescription basicGetLocalChanges() {
		return localChanges;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetLocalChanges(
			ChangeDescription newLocalChanges, NotificationChain msgs) {
		ChangeDescription oldLocalChanges = localChanges;
		localChanges = newLocalChanges;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this,
					Notification.SET,
					WorkspacePackage.PROJECT_SPACE__LOCAL_CHANGES,
					oldLocalChanges, newLocalChanges);
			if (msgs == null)
				msgs = notification;
			else
				msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setLocalChanges(ChangeDescription newLocalChanges) {
		if (newLocalChanges != localChanges) {
			NotificationChain msgs = null;
			if (localChanges != null)
				msgs = ((InternalEObject) localChanges)
						.eInverseRemove(
								this,
								EOPPOSITE_FEATURE_BASE
										- WorkspacePackage.PROJECT_SPACE__LOCAL_CHANGES,
								null, msgs);
			if (newLocalChanges != null)
				msgs = ((InternalEObject) newLocalChanges)
						.eInverseAdd(
								this,
								EOPPOSITE_FEATURE_BASE
										- WorkspacePackage.PROJECT_SPACE__LOCAL_CHANGES,
								null, msgs);
			msgs = basicSetLocalChanges(newLocalChanges, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					WorkspacePackage.PROJECT_SPACE__LOCAL_CHANGES,
					newLocalChanges, newLocalChanges));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public Usersession getUsersession() {
		if (usersession != null && usersession.eIsProxy()) {
			InternalEObject oldUsersession = (InternalEObject) usersession;
			usersession = (Usersession) eResolveProxy(oldUsersession);
			if (usersession != oldUsersession) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE,
							WorkspacePackage.PROJECT_SPACE__USERSESSION,
							oldUsersession, usersession));
			}
		}
		return usersession;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public Usersession basicGetUsersession() {
		return usersession;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setUsersession(Usersession newUsersession) {
		Usersession oldUsersession = usersession;
		usersession = newUsersession;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					WorkspacePackage.PROJECT_SPACE__USERSESSION,
					oldUsersession, usersession));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public Date getLastUpdated() {
		return lastUpdated;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setLastUpdated(Date newLastUpdated) {
		Date oldLastUpdated = lastUpdated;
		lastUpdated = newLastUpdated;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					WorkspacePackage.PROJECT_SPACE__LAST_UPDATED,
					oldLastUpdated, lastUpdated));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public PrimaryVersionSpec getBaseVersion() {
		if (baseVersion != null && baseVersion.eIsProxy()) {
			InternalEObject oldBaseVersion = (InternalEObject) baseVersion;
			baseVersion = (PrimaryVersionSpec) eResolveProxy(oldBaseVersion);
			if (baseVersion != oldBaseVersion) {
				InternalEObject newBaseVersion = (InternalEObject) baseVersion;
				NotificationChain msgs = oldBaseVersion.eInverseRemove(this,
						EOPPOSITE_FEATURE_BASE
								- WorkspacePackage.PROJECT_SPACE__BASE_VERSION,
						null, null);
				if (newBaseVersion.eInternalContainer() == null) {
					msgs = newBaseVersion
							.eInverseAdd(
									this,
									EOPPOSITE_FEATURE_BASE
											- WorkspacePackage.PROJECT_SPACE__BASE_VERSION,
									null, msgs);
				}
				if (msgs != null)
					msgs.dispatch();
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE,
							WorkspacePackage.PROJECT_SPACE__BASE_VERSION,
							oldBaseVersion, baseVersion));
			}
		}
		return baseVersion;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public PrimaryVersionSpec basicGetBaseVersion() {
		return baseVersion;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetBaseVersion(
			PrimaryVersionSpec newBaseVersion, NotificationChain msgs) {
		PrimaryVersionSpec oldBaseVersion = baseVersion;
		baseVersion = newBaseVersion;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this,
					Notification.SET,
					WorkspacePackage.PROJECT_SPACE__BASE_VERSION,
					oldBaseVersion, newBaseVersion);
			if (msgs == null)
				msgs = notification;
			else
				msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setBaseVersion(PrimaryVersionSpec newBaseVersion) {
		if (newBaseVersion != baseVersion) {
			NotificationChain msgs = null;
			if (baseVersion != null)
				msgs = ((InternalEObject) baseVersion).eInverseRemove(this,
						EOPPOSITE_FEATURE_BASE
								- WorkspacePackage.PROJECT_SPACE__BASE_VERSION,
						null, msgs);
			if (newBaseVersion != null)
				msgs = ((InternalEObject) newBaseVersion).eInverseAdd(this,
						EOPPOSITE_FEATURE_BASE
								- WorkspacePackage.PROJECT_SPACE__BASE_VERSION,
						null, msgs);
			msgs = basicSetBaseVersion(newBaseVersion, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					WorkspacePackage.PROJECT_SPACE__BASE_VERSION,
					newBaseVersion, newBaseVersion));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public int getResourceCount() {
		return resourceCount;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setResourceCount(int newResourceCount) {
		int oldResourceCount = resourceCount;
		resourceCount = newResourceCount;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					WorkspacePackage.PROJECT_SPACE__RESOURCE_COUNT,
					oldResourceCount, resourceCount));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isDirty() {
		return dirty;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDirty(boolean newDirty) {
		boolean oldDirty = dirty;
		dirty = newDirty;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					WorkspacePackage.PROJECT_SPACE__DIRTY, oldDirty, dirty));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @throws EmfStoreException
	 * @generated NOT
	 */
	public PrimaryVersionSpec commit() throws EmfStoreException {
		LogMessage logMessage = VersioningFactory.eINSTANCE.createLogMessage();
		logMessage.setAuthor("(Not set)");
		logMessage.setDate(new Date());
		logMessage.setMessage("(Not set)");
		return commit(logMessage);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @throws EmfStoreException
	 * @generated NOT
	 */
	public PrimaryVersionSpec commit(final LogMessage logMessage)
			throws EmfStoreException {

		long currentTimeMillis = System.currentTimeMillis();

		stopChangeRecording();

		// check if there are any changes
		if (getLocalChanges() == null
				|| isChangeDescriptionEmpty(getLocalChanges())) {
			startChangeRecording();
			throw new NoLocalChangesException();
		}

		// check if we need to update first
		PrimaryVersionSpec resolvedVersion;
		try {
			resolvedVersion = resolveVersionSpec(VersionSpec.HEAD_VERSION);
		} catch (EmfStoreException e) {
			startChangeRecording();
			throw e;
		}
		if ((!getBaseVersion().equals(resolvedVersion))) {
			startChangeRecording();
			throw new BaseVersionOutdatedException();
		}

		final ConnectionManager connectionManager = WorkspaceManager
				.getInstance().getConnectionManager();

		ChangePackage changePackage = VersioningFactory.eINSTANCE
				.createChangePackage();
		changePackage.init(getProject(), getLocalChanges());

		PrimaryVersionSpec newBaseVersion;
		try {
			newBaseVersion = connectionManager.createVersion(getUsersession()
					.getSessionId(), getProjectId(), getBaseVersion(),
					changePackage, logMessage);
		} catch (EmfStoreException e) {
			startChangeRecording();
			throw e;
		}

		this.setLocalChanges(null);
		setBaseVersion(newBaseVersion);

		save();
		// save starts recording ...
		// startChangeRecording();

		return newBaseVersion;
	}

	private boolean isChangeDescriptionEmpty(ChangeDescription changeDescription) {
		return (changeDescription.getObjectChanges().isEmpty()
				&& changeDescription.getObjectsToAttach().isEmpty() && changeDescription
				.getObjectsToDetach().isEmpty());
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.unicase.workspace.ProjectSpace#update()
	 * @generated NOT
	 */
	public void update() throws EmfStoreException {
		update(VersionSpec.HEAD_VERSION);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.unicase.workspace.ProjectSpace#update(org.unicase.emfstore.esmodel.versioning.VersionSpec)
	 * @generated NOT
	 */
	public void update(final VersionSpec version) throws EmfStoreException {

		final ConnectionManager connectionManager = WorkspaceManager
				.getInstance().getConnectionManager();
		PrimaryVersionSpec resolvedVersion = resolveVersionSpec(version);

		if (resolvedVersion.compareTo(getBaseVersion()) == 0) {
			throw new NoChangesOnServerException();
		}
		if (resolvedVersion.compareTo(getBaseVersion()) < 0) {
			throw new IllegalProjectSpaceStateException(
					"The base revision of this project space is "
							+ getBaseVersion().getIdentifier()
							+ ", but the server version of this project is "
							+ resolvedVersion.getIdentifier() + "!");
		}
		stopChangeRecording();
		List<ChangePackage> changes = new ArrayList<ChangePackage>();
		try {
			changes = connectionManager.getChanges(getUsersession()
					.getSessionId(), getProjectId(), getBaseVersion(),
					resolvedVersion);
		} catch (EmfStoreException e) {
			startChangeRecording();
			throw e;
		}

		// detect conflicts
		// for (ChangePackage change : changes) {
		// // MK: implement conflict detection here
		// ConflictDetector conflictDetector = new ConflictDetector(
		// new BasicConflictDetectionStrategy());
		// ChangePackage changePackage = VersioningFactory.eINSTANCE
		// .createChangePackage();
		// changePackage.init(getProject(), getLocalChanges());
		// if (conflictDetector.doConflict(change, changePackage)) {
		// throw new ChangeConflictException();
		// }
		// }

		for (ChangePackage change : changes) {
			change.apply(getProject());
		}
		setBaseVersion(resolvedVersion);

		// FIXME: record has to be started, because save() calls endrecording
		// and
		// whithout a running recording endrecording sets localchanges to null
		// there must be a nicer solution
		startChangeRecording();
		save();
		// save() calls startChangeRecording ...
		// startChangeRecording();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public void revert() {
		// MK: fix this for changepackage
		stopChangeRecording();
		getLocalChanges().apply();
		setLocalChanges(null);
		startChangeRecording();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public void save() {
		stopChangeRecording();
		saveResources();
		startChangeRecording();
	}

	/**
	 * Stops current recording of changes and adds recorded changes to this
	 * project spaces changes.
	 * 
	 * @generated NOT
	 */
	private void stopChangeRecording() {
		this.setLocalChanges(this.changeRecorder.endRecording());
	}

	/**
	 * Starts change recording on this workspace, resumes previous recordings if
	 * there are any.
	 * 
	 * @generated NOT
	 */
	private void startChangeRecording() {

		changeRecorder = new ChangeRecorder();
		if (getLocalChanges() == null) {
			changeRecorder.beginRecording(Collections.singleton(getProject()));
		} else {
			changeRecorder.beginRecording((ChangeDescription) EcoreUtil
					.copy(getLocalChanges()), Collections
					.singleton(getProject()));
		}

	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.unicase.workspace.ProjectSpace#init()
	 * @generated NOT
	 */
	public void init() {
		// MK: possibly performance hit
		this.eResource().setTrackingModification(true);
		for (final ModelElement modelElement : this.getProject()
				.getAllModelElements()) {
			new ModelElementChangeNotifier(modelElement, this);
		}
		startChangeRecording();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.unicase.workspace.ProjectSpace#getProjectInfo()
	 * @generated NOT
	 */
	public ProjectInfo getProjectInfo() {
		ProjectInfo projectInfo = EsmodelFactory.eINSTANCE.createProjectInfo();
		projectInfo.setProjectId(getProjectId());
		projectInfo.setName(getProjectName());
		projectInfo.setDescription(getProjectDescription());
		projectInfo.setVersion(getBaseVersion());
		return projectInfo;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.unicase.workspace.ProjectSpace#resolveVersionSpec(org.unicase.emfstore.esmodel.versioning.VersionSpec)
	 * @throws EmfStoreException
	 * @generated NOT
	 */
	public PrimaryVersionSpec resolveVersionSpec(VersionSpec versionSpec)
			throws EmfStoreException {
		ConnectionManager connectionManager = WorkspaceManager.getInstance()
				.getConnectionManager();
		//FIXME OW why head version spec
		//FIXME use resolve version spec of usersession
		return connectionManager.resolveVersionSpec(getUsersession()
				.getSessionId(), getProjectId(), VersioningFactory.eINSTANCE
				.createHeadVersionSpec());
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public void initResources(ResourceSet resourceSet) {
		setResourceCount(0);
		String fileName = Configuration.getWorkspaceDirectory() + "ps-"
				+ getIdentifier() + File.separatorChar + getResourceCount();
		URI fileURI = URI.createFileURI(fileName);
		List<Resource> resources = new ArrayList<Resource>();
		Resource resource = resourceSet.createResource(fileURI);
		resource.getContents().add(this);
		resources.add(resource);
		setResourceCount(getResourceCount() + 1);
		List<ModelElement> modelElements = getProject().getAllModelElements();
		int counter = 0;
		for (ModelElement modelElement : modelElements) {
			if (counter > Configuration.getMaxMECountPerResource()) {
				fileName = Configuration.getWorkspaceDirectory() + "ps-"
						+ getIdentifier() + File.separatorChar
						+ getResourceCount();
				fileURI = URI.createFileURI(fileName);
				resource = resourceSet.createResource(fileURI);
				setResourceCount(getResourceCount() + 1);
				resources.add(resource);
				counter = 0;
			}
			counter++;
			resource.getContents().add(modelElement);
		}
		for (Resource currentResource : resources) {
			try {
				currentResource.save(Configuration.getResourceSaveOptions());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		init();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd,
			int featureID, NotificationChain msgs) {
		switch (featureID) {
		case WorkspacePackage.PROJECT_SPACE__PROJECT:
			return basicSetProject(null, msgs);
		case WorkspacePackage.PROJECT_SPACE__PROJECT_ID:
			return basicSetProjectId(null, msgs);
		case WorkspacePackage.PROJECT_SPACE__LOCAL_CHANGES:
			return basicSetLocalChanges(null, msgs);
		case WorkspacePackage.PROJECT_SPACE__BASE_VERSION:
			return basicSetBaseVersion(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
		case WorkspacePackage.PROJECT_SPACE__PROJECT:
			if (resolve)
				return getProject();
			return basicGetProject();
		case WorkspacePackage.PROJECT_SPACE__PROJECT_ID:
			if (resolve)
				return getProjectId();
			return basicGetProjectId();
		case WorkspacePackage.PROJECT_SPACE__PROJECT_NAME:
			return getProjectName();
		case WorkspacePackage.PROJECT_SPACE__PROJECT_DESCRIPTION:
			return getProjectDescription();
		case WorkspacePackage.PROJECT_SPACE__LOCAL_CHANGES:
			if (resolve)
				return getLocalChanges();
			return basicGetLocalChanges();
		case WorkspacePackage.PROJECT_SPACE__USERSESSION:
			if (resolve)
				return getUsersession();
			return basicGetUsersession();
		case WorkspacePackage.PROJECT_SPACE__LAST_UPDATED:
			return getLastUpdated();
		case WorkspacePackage.PROJECT_SPACE__BASE_VERSION:
			if (resolve)
				return getBaseVersion();
			return basicGetBaseVersion();
		case WorkspacePackage.PROJECT_SPACE__RESOURCE_COUNT:
			return new Integer(getResourceCount());
		case WorkspacePackage.PROJECT_SPACE__DIRTY:
			return isDirty() ? Boolean.TRUE : Boolean.FALSE;
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
		case WorkspacePackage.PROJECT_SPACE__PROJECT:
			setProject((Project) newValue);
			return;
		case WorkspacePackage.PROJECT_SPACE__PROJECT_ID:
			setProjectId((ProjectId) newValue);
			return;
		case WorkspacePackage.PROJECT_SPACE__PROJECT_NAME:
			setProjectName((String) newValue);
			return;
		case WorkspacePackage.PROJECT_SPACE__PROJECT_DESCRIPTION:
			setProjectDescription((String) newValue);
			return;
		case WorkspacePackage.PROJECT_SPACE__LOCAL_CHANGES:
			setLocalChanges((ChangeDescription) newValue);
			return;
		case WorkspacePackage.PROJECT_SPACE__USERSESSION:
			setUsersession((Usersession) newValue);
			return;
		case WorkspacePackage.PROJECT_SPACE__LAST_UPDATED:
			setLastUpdated((Date) newValue);
			return;
		case WorkspacePackage.PROJECT_SPACE__BASE_VERSION:
			setBaseVersion((PrimaryVersionSpec) newValue);
			return;
		case WorkspacePackage.PROJECT_SPACE__RESOURCE_COUNT:
			setResourceCount(((Integer) newValue).intValue());
			return;
		case WorkspacePackage.PROJECT_SPACE__DIRTY:
			setDirty(((Boolean) newValue).booleanValue());
			return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
		case WorkspacePackage.PROJECT_SPACE__PROJECT:
			setProject((Project) null);
			return;
		case WorkspacePackage.PROJECT_SPACE__PROJECT_ID:
			setProjectId((ProjectId) null);
			return;
		case WorkspacePackage.PROJECT_SPACE__PROJECT_NAME:
			setProjectName(PROJECT_NAME_EDEFAULT);
			return;
		case WorkspacePackage.PROJECT_SPACE__PROJECT_DESCRIPTION:
			setProjectDescription(PROJECT_DESCRIPTION_EDEFAULT);
			return;
		case WorkspacePackage.PROJECT_SPACE__LOCAL_CHANGES:
			setLocalChanges((ChangeDescription) null);
			return;
		case WorkspacePackage.PROJECT_SPACE__USERSESSION:
			setUsersession((Usersession) null);
			return;
		case WorkspacePackage.PROJECT_SPACE__LAST_UPDATED:
			setLastUpdated(LAST_UPDATED_EDEFAULT);
			return;
		case WorkspacePackage.PROJECT_SPACE__BASE_VERSION:
			setBaseVersion((PrimaryVersionSpec) null);
			return;
		case WorkspacePackage.PROJECT_SPACE__RESOURCE_COUNT:
			setResourceCount(RESOURCE_COUNT_EDEFAULT);
			return;
		case WorkspacePackage.PROJECT_SPACE__DIRTY:
			setDirty(DIRTY_EDEFAULT);
			return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
		case WorkspacePackage.PROJECT_SPACE__PROJECT:
			return project != null;
		case WorkspacePackage.PROJECT_SPACE__PROJECT_ID:
			return projectId != null;
		case WorkspacePackage.PROJECT_SPACE__PROJECT_NAME:
			return PROJECT_NAME_EDEFAULT == null ? projectName != null
					: !PROJECT_NAME_EDEFAULT.equals(projectName);
		case WorkspacePackage.PROJECT_SPACE__PROJECT_DESCRIPTION:
			return PROJECT_DESCRIPTION_EDEFAULT == null ? projectDescription != null
					: !PROJECT_DESCRIPTION_EDEFAULT.equals(projectDescription);
		case WorkspacePackage.PROJECT_SPACE__LOCAL_CHANGES:
			return localChanges != null;
		case WorkspacePackage.PROJECT_SPACE__USERSESSION:
			return usersession != null;
		case WorkspacePackage.PROJECT_SPACE__LAST_UPDATED:
			return LAST_UPDATED_EDEFAULT == null ? lastUpdated != null
					: !LAST_UPDATED_EDEFAULT.equals(lastUpdated);
		case WorkspacePackage.PROJECT_SPACE__BASE_VERSION:
			return baseVersion != null;
		case WorkspacePackage.PROJECT_SPACE__RESOURCE_COUNT:
			return resourceCount != RESOURCE_COUNT_EDEFAULT;
		case WorkspacePackage.PROJECT_SPACE__DIRTY:
			return dirty != DIRTY_EDEFAULT;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy())
			return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (projectName: ");
		result.append(projectName);
		result.append(", projectDescription: ");
		result.append(projectDescription);
		result.append(", lastUpdated: ");
		result.append(lastUpdated);
		result.append(", resourceCount: ");
		result.append(resourceCount);
		result.append(", dirty: ");
		result.append(dirty);
		result.append(')');
		return result.toString();
	}

	public void shareProject(Usersession usersession) throws EmfStoreException {
		this.stopChangeRecording();
		this.setUsersession(usersession);
		LogMessage logMessage = VersioningFactory.eINSTANCE.createLogMessage();
		logMessage.setAuthor(usersession.getUsername());
		logMessage.setDate(new Date());
		logMessage.setMessage("Initial commit");
		ProjectInfo createdProject = WorkspaceManager.getInstance()
				.getConnectionManager().createProject(
						usersession.getSessionId(), this.getProjectName(),
						this.getProjectDescription(), logMessage,
						this.getProject());
		this.setBaseVersion(createdProject.getVersion());
		this.setLastUpdated(new Date());
		this.setProjectId(createdProject.getProjectId());
		this.setLocalChanges(null);
		save();
		this.startChangeRecording();
	}

	/**
	 * @param absoluteFileName
	 * @param projectSpace
	 */
	public void exportProject(String absoluteFileName) throws IOException {
		WorkspaceManager.getInstance().getCurrentWorkspace().exportProject(
				this, absoluteFileName);
	}

	public void notify(Notification notification, ModelElement modelElement) {
		if (notification.getEventType() == Notification.ADD
				&& notification.getFeature() instanceof EStructuralFeature) {
			// FIXME OW: check cast
			EObject newValue = (EObject) notification.getNewValue();
			addToResource(newValue, modelElement);

		} else if (notification.getEventType() == Notification.ADD_MANY
				&& notification.getFeature() instanceof EStructuralFeature) {
			// FIXME OW: check cast
			List<EObject> newValues = (List<EObject>) notification
					.getNewValue();
			for (EObject newElement : newValues) {
				addToResource(newElement, modelElement);
			}
		}
		saveResources();
	}

	/**
	 * Save all resources that are dirty.
	 */
	private void saveResources() {
		EList<Resource> resources = this.eResource().getResourceSet()
				.getResources();
		for (Resource resource : resources) {
			if (resource.isModified()) {
				try {
					resource.save(Configuration.getResourceSaveOptions());
				} catch (IOException e) {
					Throwable cause = e.getCause();
					if (cause != null && cause instanceof DanglingHREFException) {
						boolean foundProblems = ModelValidationHelper
								.checkAndFixProject(getProject());
						if (foundProblems) {
							//FIXME OW MK log problem
						}
					}

				}

			}
		}
	}

	private void addToResource(final EObject eObject, final EObject parent) {
		TransactionalEditingDomain domain = WorkspaceManager.getInstance()
				.getCurrentWorkspace().getEditingDomain();
		domain.getCommandStack().execute(new RecordingCommand(domain) {
			@Override
			protected void doExecute() {
				Resource oldResource = parent.eResource();
				String oldFileName = Configuration.getWorkspaceDirectory()
						+ "ps-" + getIdentifier() + File.separatorChar
						+ (getResourceCount() - 1);
				//FIXME MK check if file exists
				if (new File(oldFileName).length() > Configuration
						.getMaxResourceFileSizeOnExpand()) {
					String newfileName = Configuration.getWorkspaceDirectory()
							+ "ps-" + getIdentifier() + File.separatorChar
							+ getResourceCount();
					URI fileURI = URI.createFileURI(newfileName);
					Resource resource = oldResource.getResourceSet()
							.createResource(fileURI);
					// MK: possibly performance hit
					resource.setTrackingModification(true);
					setResourceCount(getResourceCount() + 1);
				}
			}
		});

	}

} // ProjectContainerImpl
