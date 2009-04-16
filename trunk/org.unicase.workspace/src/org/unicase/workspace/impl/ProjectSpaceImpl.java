/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.workspace.impl;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EDataTypeUniqueEList;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.emf.ecore.xmi.DanglingHREFException;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.unicase.emfstore.conflictDetection.ConflictDetector;
import org.unicase.emfstore.esmodel.EsmodelFactory;
import org.unicase.emfstore.esmodel.ProjectId;
import org.unicase.emfstore.esmodel.ProjectInfo;
import org.unicase.emfstore.esmodel.notification.ESNotification;
import org.unicase.emfstore.esmodel.url.ModelElementUrlFragment;
import org.unicase.emfstore.esmodel.util.EsModelUtil;
import org.unicase.emfstore.esmodel.versioning.ChangePackage;
import org.unicase.emfstore.esmodel.versioning.LogMessage;
import org.unicase.emfstore.esmodel.versioning.PrimaryVersionSpec;
import org.unicase.emfstore.esmodel.versioning.TagVersionSpec;
import org.unicase.emfstore.esmodel.versioning.VersionSpec;
import org.unicase.emfstore.esmodel.versioning.VersioningFactory;
import org.unicase.emfstore.esmodel.versioning.events.Event;
import org.unicase.emfstore.esmodel.versioning.operations.AbstractOperation;
import org.unicase.emfstore.esmodel.versioning.operations.CreateDeleteOperation;
import org.unicase.emfstore.esmodel.versioning.operations.OperationsFactory;
import org.unicase.emfstore.esmodel.versioning.operations.OperationsPackage;
import org.unicase.emfstore.esmodel.versioning.operations.ReferenceOperation;
import org.unicase.emfstore.esmodel.versioning.operations.util.OperationsCannonizer;
import org.unicase.emfstore.exceptions.BaseVersionOutdatedException;
import org.unicase.emfstore.exceptions.EmfStoreException;
import org.unicase.model.ModelElement;
import org.unicase.model.ModelElementId;
import org.unicase.model.Project;
import org.unicase.model.impl.IdentifiableElementImpl;
import org.unicase.model.util.ModelUtil;
import org.unicase.model.util.ModelValidationHelper;
import org.unicase.model.util.ProjectChangeObserver;
import org.unicase.workspace.Configuration;
import org.unicase.workspace.OperationComposite;
import org.unicase.workspace.ProjectSpace;
import org.unicase.workspace.Usersession;
import org.unicase.workspace.WorkspaceFactory;
import org.unicase.workspace.WorkspaceManager;
import org.unicase.workspace.WorkspacePackage;
import org.unicase.workspace.changeTracking.OperationParser;
import org.unicase.workspace.connectionmanager.ConnectionManager;
import org.unicase.workspace.exceptions.ChangeConflictException;
import org.unicase.workspace.exceptions.IllegalProjectSpaceStateException;
import org.unicase.workspace.exceptions.MEUrlResolutionException;
import org.unicase.workspace.exceptions.NoChangesOnServerException;
import org.unicase.workspace.exceptions.NoLocalChangesException;
import org.unicase.workspace.exceptions.UnsupportedNotificationException;
import org.unicase.workspace.notification.NotificationGenerator;
import org.unicase.workspace.util.CommitObserver;
import org.unicase.workspace.util.UpdateObserver;
import org.unicase.workspace.util.WorkspaceUtil;

/**
 * <!-- begin-user-doc --> An implementation of the model object ' <em><b>Project Container</b></em>'.
 * 
 * @implements ProjectChangeObserver <!-- end-user-doc -->
 *             <p>
 *             The following features are implemented:
 *             <ul>
 *             <li>{@link org.unicase.workspace.impl.ProjectSpaceImpl#getProject <em>Project</em>}</li>
 *             <li>{@link org.unicase.workspace.impl.ProjectSpaceImpl#getProjectId <em>Project Id</em>}</li>
 *             <li>{@link org.unicase.workspace.impl.ProjectSpaceImpl#getProjectName <em>Project Name</em>}</li>
 *             <li>{@link org.unicase.workspace.impl.ProjectSpaceImpl#getProjectDescription <em>Project Description
 *             </em>}</li>
 *             <li>{@link org.unicase.workspace.impl.ProjectSpaceImpl#getEvents <em>Events</em>}</li>
 *             <li>{@link org.unicase.workspace.impl.ProjectSpaceImpl#getUsersession <em>Usersession</em>}</li>
 *             <li>{@link org.unicase.workspace.impl.ProjectSpaceImpl#getLastUpdated <em>Last Updated</em>}</li>
 *             <li>{@link org.unicase.workspace.impl.ProjectSpaceImpl#getBaseVersion <em>Base Version</em>}</li>
 *             <li>{@link org.unicase.workspace.impl.ProjectSpaceImpl#getResourceCount <em>Resource Count</em>}</li>
 *             <li>{@link org.unicase.workspace.impl.ProjectSpaceImpl#isDirty <em>Dirty</em>}</li>
 *             <li>{@link org.unicase.workspace.impl.ProjectSpaceImpl#getOldLogMessages <em>Old Log Messages</em>}</li>
 *             <li>{@link org.unicase.workspace.impl.ProjectSpaceImpl#getLocalOperations <em>Local Operations</em>}</li>
 *             <li>{@link org.unicase.workspace.impl.ProjectSpaceImpl#getNotifications <em>Notifications</em>}</li>
 *             </ul>
 *             </p>
 * @generated
 */
public class ProjectSpaceImpl extends IdentifiableElementImpl implements ProjectSpace, ProjectChangeObserver {

	/**
	 * The cached value of the '{@link #getProject() <em>Project</em>}' containment reference. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getProject()
	 * @generated
	 * @ordered
	 */
	protected Project project;

	/**
	 * The cached value of the '{@link #getProjectId() <em>Project Id</em>}' containment reference. <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * 
	 * @see #getProjectId()
	 * @generated
	 * @ordered
	 */
	protected ProjectId projectId;

	/**
	 * The default value of the '{@link #getProjectName() <em>Project Name</em>}' attribute. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getProjectName()
	 * @generated
	 * @ordered
	 */
	protected static final String PROJECT_NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getProjectName() <em>Project Name</em>}' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @see #getProjectName()
	 * @generated
	 * @ordered
	 */
	protected String projectName = PROJECT_NAME_EDEFAULT;

	/**
	 * The default value of the '{@link #getProjectDescription() <em>Project Description</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getProjectDescription()
	 * @generated
	 * @ordered
	 */
	protected static final String PROJECT_DESCRIPTION_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getProjectDescription() <em>Project Description</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getProjectDescription()
	 * @generated
	 * @ordered
	 */
	protected String projectDescription = PROJECT_DESCRIPTION_EDEFAULT;

	/**
	 * The cached value of the '{@link #getEvents() <em>Events</em>}' containment reference list. <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * 
	 * @see #getEvents()
	 * @generated
	 * @ordered
	 */
	protected EList<Event> events;

	/**
	 * The cached value of the '{@link #getUsersession() <em>Usersession</em>}' reference. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @see #getUsersession()
	 * @generated
	 * @ordered
	 */
	protected Usersession usersession;

	/**
	 * The default value of the '{@link #getLastUpdated() <em>Last Updated</em>}' attribute. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getLastUpdated()
	 * @generated
	 * @ordered
	 */
	protected static final Date LAST_UPDATED_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getLastUpdated() <em>Last Updated</em>}' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @see #getLastUpdated()
	 * @generated
	 * @ordered
	 */
	protected Date lastUpdated = LAST_UPDATED_EDEFAULT;

	/**
	 * The cached value of the '{@link #getBaseVersion() <em>Base Version</em>}' containment reference. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getBaseVersion()
	 * @generated
	 * @ordered
	 */
	protected PrimaryVersionSpec baseVersion;

	/**
	 * The default value of the '{@link #getResourceCount() <em>Resource Count</em>}' attribute. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getResourceCount()
	 * @generated
	 * @ordered
	 */
	protected static final int RESOURCE_COUNT_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getResourceCount() <em>Resource Count</em>}' attribute. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getResourceCount()
	 * @generated
	 * @ordered
	 */
	protected int resourceCount = RESOURCE_COUNT_EDEFAULT;

	/**
	 * The default value of the '{@link #isDirty() <em>Dirty</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @see #isDirty()
	 * @generated
	 * @ordered
	 */
	protected static final boolean DIRTY_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isDirty() <em>Dirty</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @see #isDirty()
	 * @generated
	 * @ordered
	 */
	protected boolean dirty = DIRTY_EDEFAULT;

	/**
	 * The cached value of the '{@link #getOldLogMessages() <em>Old Log Messages</em>}' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getOldLogMessages()
	 * @generated
	 * @ordered
	 */
	protected EList<String> oldLogMessages;

	/**
	 * The cached value of the '{@link #getLocalOperations() <em>Local Operations</em>}' containment reference. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getLocalOperations()
	 * @generated
	 * @ordered
	 */
	protected OperationComposite localOperations;

	/**
	 * The cached value of the '{@link #getNotifications() <em>Notifications</em>}' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getNotifications()
	 * @generated
	 * @ordered
	 */
	protected EList<ESNotification> notifications;

	private boolean isRecording;

	private CreateDeleteOperation deleteOperation;

	private boolean initCompleted;

	private boolean isTransient;

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
	 * 
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return WorkspacePackage.Literals.PROJECT_SPACE;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public Project getProject() {
		if (project != null && project.eIsProxy()) {
			InternalEObject oldProject = (InternalEObject) project;
			project = (Project) eResolveProxy(oldProject);
			if (project != oldProject) {
				InternalEObject newProject = (InternalEObject) project;
				NotificationChain msgs = oldProject.eInverseRemove(this, EOPPOSITE_FEATURE_BASE
					- WorkspacePackage.PROJECT_SPACE__PROJECT, null, null);
				if (newProject.eInternalContainer() == null) {
					msgs = newProject.eInverseAdd(this, EOPPOSITE_FEATURE_BASE
						- WorkspacePackage.PROJECT_SPACE__PROJECT, null, msgs);
				}
				if (msgs != null)
					msgs.dispatch();
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, WorkspacePackage.PROJECT_SPACE__PROJECT,
						oldProject, project));
			}
		}
		return project;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public Project basicGetProject() {
		return project;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public NotificationChain basicSetProject(Project newProject, NotificationChain msgs) {
		Project oldProject = project;
		project = newProject;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET,
				WorkspacePackage.PROJECT_SPACE__PROJECT, oldProject, newProject);
			if (msgs == null)
				msgs = notification;
			else
				msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setProject(Project newProject) {
		if (newProject != project) {
			NotificationChain msgs = null;
			if (project != null)
				msgs = ((InternalEObject) project).eInverseRemove(this, EOPPOSITE_FEATURE_BASE
					- WorkspacePackage.PROJECT_SPACE__PROJECT, null, msgs);
			if (newProject != null)
				msgs = ((InternalEObject) newProject).eInverseAdd(this, EOPPOSITE_FEATURE_BASE
					- WorkspacePackage.PROJECT_SPACE__PROJECT, null, msgs);
			msgs = basicSetProject(newProject, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WorkspacePackage.PROJECT_SPACE__PROJECT, newProject,
				newProject));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public ProjectId getProjectId() {
		if (projectId != null && projectId.eIsProxy()) {
			InternalEObject oldProjectId = (InternalEObject) projectId;
			projectId = (ProjectId) eResolveProxy(oldProjectId);
			if (projectId != oldProjectId) {
				InternalEObject newProjectId = (InternalEObject) projectId;
				NotificationChain msgs = oldProjectId.eInverseRemove(this, EOPPOSITE_FEATURE_BASE
					- WorkspacePackage.PROJECT_SPACE__PROJECT_ID, null, null);
				if (newProjectId.eInternalContainer() == null) {
					msgs = newProjectId.eInverseAdd(this, EOPPOSITE_FEATURE_BASE
						- WorkspacePackage.PROJECT_SPACE__PROJECT_ID, null, msgs);
				}
				if (msgs != null)
					msgs.dispatch();
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE,
						WorkspacePackage.PROJECT_SPACE__PROJECT_ID, oldProjectId, projectId));
			}
		}
		return projectId;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public ProjectId basicGetProjectId() {
		return projectId;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public NotificationChain basicSetProjectId(ProjectId newProjectId, NotificationChain msgs) {
		ProjectId oldProjectId = projectId;
		projectId = newProjectId;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET,
				WorkspacePackage.PROJECT_SPACE__PROJECT_ID, oldProjectId, newProjectId);
			if (msgs == null)
				msgs = notification;
			else
				msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setProjectId(ProjectId newProjectId) {
		if (newProjectId != projectId) {
			NotificationChain msgs = null;
			if (projectId != null)
				msgs = ((InternalEObject) projectId).eInverseRemove(this, EOPPOSITE_FEATURE_BASE
					- WorkspacePackage.PROJECT_SPACE__PROJECT_ID, null, msgs);
			if (newProjectId != null)
				msgs = ((InternalEObject) newProjectId).eInverseAdd(this, EOPPOSITE_FEATURE_BASE
					- WorkspacePackage.PROJECT_SPACE__PROJECT_ID, null, msgs);
			msgs = basicSetProjectId(newProjectId, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WorkspacePackage.PROJECT_SPACE__PROJECT_ID,
				newProjectId, newProjectId));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public String getProjectName() {
		return projectName;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setProjectName(String newProjectName) {
		String oldProjectName = projectName;
		projectName = newProjectName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WorkspacePackage.PROJECT_SPACE__PROJECT_NAME,
				oldProjectName, projectName));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public String getProjectDescription() {
		return projectDescription;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setProjectDescription(String newProjectDescription) {
		String oldProjectDescription = projectDescription;
		projectDescription = newProjectDescription;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WorkspacePackage.PROJECT_SPACE__PROJECT_DESCRIPTION,
				oldProjectDescription, projectDescription));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EList<Event> getEvents() {
		if (events == null) {
			events = new EObjectContainmentEList.Resolving<Event>(Event.class, this,
				WorkspacePackage.PROJECT_SPACE__EVENTS);
		}
		return events;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public Usersession getUsersession() {
		if (usersession != null && usersession.eIsProxy()) {
			InternalEObject oldUsersession = (InternalEObject) usersession;
			usersession = (Usersession) eResolveProxy(oldUsersession);
			if (usersession != oldUsersession) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE,
						WorkspacePackage.PROJECT_SPACE__USERSESSION, oldUsersession, usersession));
			}
		}
		return usersession;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public Usersession basicGetUsersession() {
		return usersession;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setUsersession(Usersession newUsersession) {
		Usersession oldUsersession = usersession;
		usersession = newUsersession;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WorkspacePackage.PROJECT_SPACE__USERSESSION,
				oldUsersession, usersession));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public Date getLastUpdated() {
		return lastUpdated;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setLastUpdated(Date newLastUpdated) {
		Date oldLastUpdated = lastUpdated;
		lastUpdated = newLastUpdated;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WorkspacePackage.PROJECT_SPACE__LAST_UPDATED,
				oldLastUpdated, lastUpdated));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public PrimaryVersionSpec getBaseVersion() {
		if (baseVersion != null && baseVersion.eIsProxy()) {
			InternalEObject oldBaseVersion = (InternalEObject) baseVersion;
			baseVersion = (PrimaryVersionSpec) eResolveProxy(oldBaseVersion);
			if (baseVersion != oldBaseVersion) {
				InternalEObject newBaseVersion = (InternalEObject) baseVersion;
				NotificationChain msgs = oldBaseVersion.eInverseRemove(this, EOPPOSITE_FEATURE_BASE
					- WorkspacePackage.PROJECT_SPACE__BASE_VERSION, null, null);
				if (newBaseVersion.eInternalContainer() == null) {
					msgs = newBaseVersion.eInverseAdd(this, EOPPOSITE_FEATURE_BASE
						- WorkspacePackage.PROJECT_SPACE__BASE_VERSION, null, msgs);
				}
				if (msgs != null)
					msgs.dispatch();
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE,
						WorkspacePackage.PROJECT_SPACE__BASE_VERSION, oldBaseVersion, baseVersion));
			}
		}
		return baseVersion;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public PrimaryVersionSpec basicGetBaseVersion() {
		return baseVersion;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public NotificationChain basicSetBaseVersion(PrimaryVersionSpec newBaseVersion, NotificationChain msgs) {
		PrimaryVersionSpec oldBaseVersion = baseVersion;
		baseVersion = newBaseVersion;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET,
				WorkspacePackage.PROJECT_SPACE__BASE_VERSION, oldBaseVersion, newBaseVersion);
			if (msgs == null)
				msgs = notification;
			else
				msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setBaseVersion(PrimaryVersionSpec newBaseVersion) {
		if (newBaseVersion != baseVersion) {
			NotificationChain msgs = null;
			if (baseVersion != null)
				msgs = ((InternalEObject) baseVersion).eInverseRemove(this, EOPPOSITE_FEATURE_BASE
					- WorkspacePackage.PROJECT_SPACE__BASE_VERSION, null, msgs);
			if (newBaseVersion != null)
				msgs = ((InternalEObject) newBaseVersion).eInverseAdd(this, EOPPOSITE_FEATURE_BASE
					- WorkspacePackage.PROJECT_SPACE__BASE_VERSION, null, msgs);
			msgs = basicSetBaseVersion(newBaseVersion, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WorkspacePackage.PROJECT_SPACE__BASE_VERSION,
				newBaseVersion, newBaseVersion));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public int getResourceCount() {
		return resourceCount;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setResourceCount(int newResourceCount) {
		int oldResourceCount = resourceCount;
		resourceCount = newResourceCount;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WorkspacePackage.PROJECT_SPACE__RESOURCE_COUNT,
				oldResourceCount, resourceCount));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public boolean isDirty() {
		return dirty;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setDirty(boolean newDirty) {
		boolean oldDirty = dirty;
		dirty = newDirty;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WorkspacePackage.PROJECT_SPACE__DIRTY, oldDirty,
				dirty));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EList<String> getOldLogMessages() {
		if (oldLogMessages == null) {
			oldLogMessages = new EDataTypeUniqueEList<String>(String.class, this,
				WorkspacePackage.PROJECT_SPACE__OLD_LOG_MESSAGES);
		}
		return oldLogMessages;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public OperationComposite getLocalOperations() {
		if (localOperations != null && localOperations.eIsProxy()) {
			InternalEObject oldLocalOperations = (InternalEObject) localOperations;
			localOperations = (OperationComposite) eResolveProxy(oldLocalOperations);
			if (localOperations != oldLocalOperations) {
				InternalEObject newLocalOperations = (InternalEObject) localOperations;
				NotificationChain msgs = oldLocalOperations.eInverseRemove(this, EOPPOSITE_FEATURE_BASE
					- WorkspacePackage.PROJECT_SPACE__LOCAL_OPERATIONS, null, null);
				if (newLocalOperations.eInternalContainer() == null) {
					msgs = newLocalOperations.eInverseAdd(this, EOPPOSITE_FEATURE_BASE
						- WorkspacePackage.PROJECT_SPACE__LOCAL_OPERATIONS, null, msgs);
				}
				if (msgs != null)
					msgs.dispatch();
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE,
						WorkspacePackage.PROJECT_SPACE__LOCAL_OPERATIONS, oldLocalOperations, localOperations));
			}
		}
		return localOperations;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public OperationComposite basicGetLocalOperations() {
		return localOperations;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public NotificationChain basicSetLocalOperations(OperationComposite newLocalOperations, NotificationChain msgs) {
		OperationComposite oldLocalOperations = localOperations;
		localOperations = newLocalOperations;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET,
				WorkspacePackage.PROJECT_SPACE__LOCAL_OPERATIONS, oldLocalOperations, newLocalOperations);
			if (msgs == null)
				msgs = notification;
			else
				msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setLocalOperations(OperationComposite newLocalOperations) {
		if (newLocalOperations != localOperations) {
			NotificationChain msgs = null;
			if (localOperations != null)
				msgs = ((InternalEObject) localOperations).eInverseRemove(this, EOPPOSITE_FEATURE_BASE
					- WorkspacePackage.PROJECT_SPACE__LOCAL_OPERATIONS, null, msgs);
			if (newLocalOperations != null)
				msgs = ((InternalEObject) newLocalOperations).eInverseAdd(this, EOPPOSITE_FEATURE_BASE
					- WorkspacePackage.PROJECT_SPACE__LOCAL_OPERATIONS, null, msgs);
			msgs = basicSetLocalOperations(newLocalOperations, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WorkspacePackage.PROJECT_SPACE__LOCAL_OPERATIONS,
				newLocalOperations, newLocalOperations));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EList<ESNotification> getNotifications() {
		if (notifications == null) {
			notifications = new EObjectContainmentEList.Resolving<ESNotification>(ESNotification.class, this,
				WorkspacePackage.PROJECT_SPACE__NOTIFICATIONS);
		}
		return notifications;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @throws EmfStoreException
	 * @throws EmfStoreException
	 * @generated NOT
	 */
	public PrimaryVersionSpec commit(final LogMessage logMessage) throws EmfStoreException {
		return commit(logMessage, null);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @throws EmfStoreException
	 * @generated NOT
	 */
	public PrimaryVersionSpec commit(final LogMessage logMessage, CommitObserver commitObserver)
		throws EmfStoreException {

		// check if there are any changes
		if (this.getOperations().size() == 0) {
			throw new NoLocalChangesException();
		}

		// check if we need to update first
		PrimaryVersionSpec resolvedVersion;
		resolvedVersion = resolveVersionSpec(VersionSpec.HEAD_VERSION);

		if ((!getBaseVersion().equals(resolvedVersion))) {
			throw new BaseVersionOutdatedException();
		}

		final ConnectionManager connectionManager = WorkspaceManager.getInstance().getConnectionManager();

		ChangePackage changePackage = VersioningFactory.eINSTANCE.createChangePackage();
		// copy operations from projectspace
		for (AbstractOperation abstractOperation : getOperations()) {
			AbstractOperation copy = (AbstractOperation) EcoreUtil.copy(abstractOperation);
			changePackage.getOperations().add(copy);
		}
		// copy events from projectspace
		for (Event event : getEvents()) {
			Event copy = (Event) EcoreUtil.copy(event);
			changePackage.getEvents().add(copy);
		}

		changePackage.cannonize();

		if (commitObserver != null && !commitObserver.inspectChanges(changePackage)) {
			return this.getBaseVersion();
		}

		PrimaryVersionSpec newBaseVersion;
		newBaseVersion = connectionManager.createVersion(getUsersession().getSessionId(), getProjectId(),
			getBaseVersion(), changePackage, logMessage);

		setBaseVersion(newBaseVersion);
		getOperations().clear();
		getEvents().clear();

		generateNotifications(changePackage);

		saveProjectSpaceOnly();

		if (commitObserver != null) {
			commitObserver.commitCompleted();
		}
		updateDirtyState();
		return newBaseVersion;
	}

	private void generateNotifications(ChangePackage changePackage) {
		ArrayList<ChangePackage> changes = new ArrayList<ChangePackage>();
		changes.add(changePackage);
		generateNotifications(changes);
	}

	/**
	 * @see org.unicase.workspace.ProjectSpace#getOperations()
	 */
	public List<AbstractOperation> getOperations() {
		// check if operation composite exists
		OperationComposite operationComposite = this.getLocalOperations();
		if (operationComposite == null) {
			operationComposite = WorkspaceFactory.eINSTANCE.createOperationComposite();
		}
		return operationComposite.getOperations();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.unicase.workspace.ProjectSpace#update()
	 * @generated NOT
	 */
	public PrimaryVersionSpec update() throws EmfStoreException {
		return update(VersionSpec.HEAD_VERSION);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.unicase.workspace.ProjectSpace#update(org.unicase.emfstore.esmodel.versioning.VersionSpec)
	 * @generated NOT
	 */
	public PrimaryVersionSpec update(final VersionSpec version) throws EmfStoreException {
		return update(version, null);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @generated NOT
	 */
	public List<ChangePackage> getChanges(VersionSpec sourceVersion, VersionSpec targetVersion)
		throws EmfStoreException {
		final ConnectionManager connectionManager = WorkspaceManager.getInstance().getConnectionManager();

		List<ChangePackage> changes = connectionManager.getChanges(getUsersession().getSessionId(), projectId,
			sourceVersion, targetVersion);
		return changes;

	}

	/**
	 * {@inheritDoc}
	 * 
	 * @throws EmfStoreException
	 * @see org.unicase.workspace.ProjectSpace#update(org.unicase.emfstore.esmodel.versioning.VersionSpec)
	 * @generated NOT
	 */
	public PrimaryVersionSpec update(final VersionSpec version, final UpdateObserver observer) throws EmfStoreException {

		final ConnectionManager connectionManager = WorkspaceManager.getInstance().getConnectionManager();
		final PrimaryVersionSpec resolvedVersion = resolveVersionSpec(version);

		if (resolvedVersion.compareTo(baseVersion) == 0) {
			throw new NoChangesOnServerException();
		}
		if (resolvedVersion.compareTo(getBaseVersion()) < 0) {
			throw new IllegalProjectSpaceStateException("The base revision of this project space is "
				+ getBaseVersion().getIdentifier() + ", but the server version of this project is "
				+ resolvedVersion.getIdentifier() + "!");
		}

		List<ChangePackage> changes = new ArrayList<ChangePackage>();

		changes = connectionManager
			.getChanges(getUsersession().getSessionId(), projectId, baseVersion, resolvedVersion);

		// detect conflicts
		ConflictDetector conflictDetector = new ConflictDetector();
		for (ChangePackage change : changes) {
			ChangePackage changePackage = VersioningFactory.eINSTANCE.createChangePackage();
			EList<AbstractOperation> copiedOperations = changePackage.getOperations();
			for (AbstractOperation operation : getOperations()) {
				copiedOperations.add((AbstractOperation) EcoreUtil.copy(operation));
			}
			if (conflictDetector.doConflict(change, changePackage)) {
				throw new ChangeConflictException(changes);
			}
		}

		// notify updateObserver if there is one
		if (observer != null && !observer.inspectChanges(changes)) {
			return getBaseVersion();
		}

		stopChangeRecording();
		final List<ChangePackage> cps = changes;
		for (ChangePackage change : cps) {
			change.apply(getProject());
		}
		startChangeRecording();

		setBaseVersion(resolvedVersion);
		saveResourceSet();

		generateNotifications(changes);

		observer.updateCompleted();

		return resolvedVersion;
	}

	private void generateNotifications(List<ChangePackage> changes) {
		// generate notifications from change packages, ignore all exception if any
		try {
			List<ESNotification> newNotifications = NotificationGenerator.getInstance().generateNotifications(changes,
				this.getUsersession().getUsername(), this);
			this.getNotifications().addAll(newNotifications);
			saveProjectSpaceOnly();
		} catch (RuntimeException e) {
			WorkspaceUtil.logException("Creating notifications failed!", e);
		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public void revert() {

		// revert all local changes
		ChangePackage changePackage = VersioningFactory.eINSTANCE.createChangePackage();
		EList<AbstractOperation> copiedOperations = changePackage.getOperations();
		for (AbstractOperation operation : getOperations()) {
			copiedOperations.add((AbstractOperation) EcoreUtil.copy(operation));
		}
		changePackage.getOperations().addAll(copiedOperations);
		changePackage.cannonize();

		stopChangeRecording();
		changePackage.reverse().apply(project);
		startChangeRecording();

		this.getOperations().clear();
		updateDirtyState();
	}

	/**
	 * Stops current recording of changes and adds recorded changes to this project spaces changes.
	 * 
	 * @generated NOT
	 */
	public void stopChangeRecording() {
		this.isRecording = false;
	}

	/**
	 * Starts change recording on this workspace, resumes previous recordings if there are any.
	 * 
	 * @generated NOT
	 */
	public void startChangeRecording() {
		isRecording = true;
		updateDirtyState();
	}

	private void updateDirtyState() {
		setDirty(getOperations().size() > 0);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.unicase.workspace.ProjectSpace#init()
	 * @generated NOT
	 */
	public void init() {
		initCompleted = true;
		this.getProject().addProjectChangeObserver(this);
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
		projectInfo.setProjectId(EsModelUtil.clone(getProjectId()));
		projectInfo.setName(getProjectName());
		projectInfo.setDescription(getProjectDescription());
		projectInfo.setVersion(EsModelUtil.clone(getBaseVersion()));
		return projectInfo;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.unicase.workspace.ProjectSpace#resolveVersionSpec(org.unicase.emfstore.esmodel.versioning.VersionSpec)
	 * @throws EmfStoreException
	 * @generated NOT
	 */
	public PrimaryVersionSpec resolveVersionSpec(VersionSpec versionSpec) throws EmfStoreException {
		ConnectionManager connectionManager = WorkspaceManager.getInstance().getConnectionManager();
		// FIXME OW why head version spec
		// FIXME use resolve version spec of usersession
		return connectionManager.resolveVersionSpec(getUsersession().getSessionId(), getProjectId(),
			VersioningFactory.eINSTANCE.createHeadVersionSpec());
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc --> {@inheritDoc}
	 * 
	 * @see org.unicase.workspace.ProjectSpace#initResources(org.eclipse.emf.ecore.resource.ResourceSet)
	 * @generated NOT
	 */
	public void initResources(ResourceSet resourceSet) {
		initCompleted = true;
		String projectSpaceFileNamePrefix = Configuration.getWorkspaceDirectory()
			+ Configuration.getProjectSpaceDirectoryPrefix() + getIdentifier() + File.separatorChar;
		String projectSpaceFileName = projectSpaceFileNamePrefix + this.getProjectName()
			+ Configuration.getProjectSpaceFileExtension();
		String operationsCompositeFileName = projectSpaceFileNamePrefix + this.getProjectName()
			+ Configuration.getOperationCompositeFileExtension();
		String projectFragementsFileNamePrefix = projectSpaceFileNamePrefix + Configuration.getProjectFolderName()
			+ File.separatorChar;
		URI projectSpaceURI = URI.createFileURI(projectSpaceFileName);
		URI operationCompositeURI = URI.createFileURI(operationsCompositeFileName);

		setResourceCount(0);
		String fileName = projectFragementsFileNamePrefix + getResourceCount()
			+ Configuration.getProjectFragmentFileExtension();
		URI fileURI = URI.createFileURI(fileName);

		List<Resource> resources = new ArrayList<Resource>();
		Resource resource = resourceSet.createResource(fileURI);
		resource.getContents().add(this.getProject());
		resources.add(resource);
		setResourceCount(getResourceCount() + 1);
		List<ModelElement> modelElements = getProject().getAllModelElements();
		int counter = Configuration.getMaxMECountPerResource() + 1;
		for (ModelElement modelElement : modelElements) {
			if (counter > Configuration.getMaxMECountPerResource()) {
				fileName = projectFragementsFileNamePrefix + getResourceCount()
					+ Configuration.getProjectFragmentFileExtension();
				fileURI = URI.createFileURI(fileName);
				resource = resourceSet.createResource(fileURI);
				setResourceCount(getResourceCount() + 1);
				resources.add(resource);
				counter = 0;
			}
			counter++;
			resource.getContents().add(modelElement);
		}
		Resource operationCompositeResource = resourceSet.createResource(operationCompositeURI);
		if (this.getLocalOperations() == null) {
			this.setLocalOperations(WorkspaceFactory.eINSTANCE.createOperationComposite());
		}
		operationCompositeResource.getContents().add(this.getLocalOperations());
		resources.add(operationCompositeResource);

		Resource projectSpaceResource = resourceSet.createResource(projectSpaceURI);
		projectSpaceResource.getContents().add(this);
		resources.add(projectSpaceResource);

		// save all resources that have been created
		for (Resource currentResource : resources) {
			try {
				currentResource.save(Configuration.getResourceSaveOptions());
			} catch (IOException e) {
				WorkspaceUtil.logException("Project Space resource init failed!", e);

			}
		}
		init();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
		case WorkspacePackage.PROJECT_SPACE__PROJECT:
			return basicSetProject(null, msgs);
		case WorkspacePackage.PROJECT_SPACE__PROJECT_ID:
			return basicSetProjectId(null, msgs);
		case WorkspacePackage.PROJECT_SPACE__EVENTS:
			return ((InternalEList<?>) getEvents()).basicRemove(otherEnd, msgs);
		case WorkspacePackage.PROJECT_SPACE__BASE_VERSION:
			return basicSetBaseVersion(null, msgs);
		case WorkspacePackage.PROJECT_SPACE__LOCAL_OPERATIONS:
			return basicSetLocalOperations(null, msgs);
		case WorkspacePackage.PROJECT_SPACE__NOTIFICATIONS:
			return ((InternalEList<?>) getNotifications()).basicRemove(otherEnd, msgs);
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
		case WorkspacePackage.PROJECT_SPACE__EVENTS:
			return getEvents();
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
			return getResourceCount();
		case WorkspacePackage.PROJECT_SPACE__DIRTY:
			return isDirty();
		case WorkspacePackage.PROJECT_SPACE__OLD_LOG_MESSAGES:
			return getOldLogMessages();
		case WorkspacePackage.PROJECT_SPACE__LOCAL_OPERATIONS:
			if (resolve)
				return getLocalOperations();
			return basicGetLocalOperations();
		case WorkspacePackage.PROJECT_SPACE__NOTIFICATIONS:
			return getNotifications();
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
		case WorkspacePackage.PROJECT_SPACE__EVENTS:
			getEvents().clear();
			getEvents().addAll((Collection<? extends Event>) newValue);
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
			setResourceCount((Integer) newValue);
			return;
		case WorkspacePackage.PROJECT_SPACE__DIRTY:
			setDirty((Boolean) newValue);
			return;
		case WorkspacePackage.PROJECT_SPACE__OLD_LOG_MESSAGES:
			getOldLogMessages().clear();
			getOldLogMessages().addAll((Collection<? extends String>) newValue);
			return;
		case WorkspacePackage.PROJECT_SPACE__LOCAL_OPERATIONS:
			setLocalOperations((OperationComposite) newValue);
			return;
		case WorkspacePackage.PROJECT_SPACE__NOTIFICATIONS:
			getNotifications().clear();
			getNotifications().addAll((Collection<? extends ESNotification>) newValue);
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
		case WorkspacePackage.PROJECT_SPACE__EVENTS:
			getEvents().clear();
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
		case WorkspacePackage.PROJECT_SPACE__OLD_LOG_MESSAGES:
			getOldLogMessages().clear();
			return;
		case WorkspacePackage.PROJECT_SPACE__LOCAL_OPERATIONS:
			setLocalOperations((OperationComposite) null);
			return;
		case WorkspacePackage.PROJECT_SPACE__NOTIFICATIONS:
			getNotifications().clear();
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
		case WorkspacePackage.PROJECT_SPACE__PROJECT:
			return project != null;
		case WorkspacePackage.PROJECT_SPACE__PROJECT_ID:
			return projectId != null;
		case WorkspacePackage.PROJECT_SPACE__PROJECT_NAME:
			return PROJECT_NAME_EDEFAULT == null ? projectName != null : !PROJECT_NAME_EDEFAULT.equals(projectName);
		case WorkspacePackage.PROJECT_SPACE__PROJECT_DESCRIPTION:
			return PROJECT_DESCRIPTION_EDEFAULT == null ? projectDescription != null : !PROJECT_DESCRIPTION_EDEFAULT
				.equals(projectDescription);
		case WorkspacePackage.PROJECT_SPACE__EVENTS:
			return events != null && !events.isEmpty();
		case WorkspacePackage.PROJECT_SPACE__USERSESSION:
			return usersession != null;
		case WorkspacePackage.PROJECT_SPACE__LAST_UPDATED:
			return LAST_UPDATED_EDEFAULT == null ? lastUpdated != null : !LAST_UPDATED_EDEFAULT.equals(lastUpdated);
		case WorkspacePackage.PROJECT_SPACE__BASE_VERSION:
			return baseVersion != null;
		case WorkspacePackage.PROJECT_SPACE__RESOURCE_COUNT:
			return resourceCount != RESOURCE_COUNT_EDEFAULT;
		case WorkspacePackage.PROJECT_SPACE__DIRTY:
			return dirty != DIRTY_EDEFAULT;
		case WorkspacePackage.PROJECT_SPACE__OLD_LOG_MESSAGES:
			return oldLogMessages != null && !oldLogMessages.isEmpty();
		case WorkspacePackage.PROJECT_SPACE__LOCAL_OPERATIONS:
			return localOperations != null;
		case WorkspacePackage.PROJECT_SPACE__NOTIFICATIONS:
			return notifications != null && !notifications.isEmpty();
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
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
		result.append(", oldLogMessages: ");
		result.append(oldLogMessages);
		result.append(')');
		return result.toString();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @throws EmfStoreException
	 * @see org.unicase.workspace.ProjectSpace#shareProject(org.unicase.workspace.Usersession)
	 * @generated NOT
	 */
	public void shareProject(Usersession usersession) throws EmfStoreException {
		this.setUsersession(usersession);
		LogMessage logMessage = VersioningFactory.eINSTANCE.createLogMessage();
		logMessage.setAuthor(usersession.getUsername());
		logMessage.setClientDate(new Date());
		logMessage.setMessage("Initial commit");
		ProjectInfo createdProject;
		createdProject = WorkspaceManager.getInstance().getConnectionManager().createProject(
			usersession.getSessionId(), this.getProjectName(), this.getProjectDescription(), logMessage,
			this.getProject());
		this.setBaseVersion(createdProject.getVersion());
		this.setLastUpdated(new Date());
		this.setProjectId(createdProject.getProjectId());
		this.getOperations().clear();
		this.saveProjectSpaceOnly();
	}

	private void saveProjectSpaceOnly() {
		saveResource(this.eResource());
		saveResource(this.getLocalOperations().eResource());
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.unicase.workspace.ProjectSpace#exportProject(java.lang.String)
	 */
	public void exportProject(String absoluteFileName) throws IOException {
		WorkspaceManager.getInstance().getCurrentWorkspace().exportProject(this, absoluteFileName);
	}

	/**
	 * Save all resources that are dirty.
	 * 
	 * @param force if all resources should be saved regardless of their dirty state
	 */
	private void saveResourceSet() {
		EList<Resource> resources = this.eResource().getResourceSet().getResources();
		for (Resource resource : resources) {
			saveResource(resource);
		}
	}

	private void saveResource(Resource resource) {
		try {
			if (resource == null) {
				if (!isTransient) {
					WorkspaceUtil.logException("Resources of project space are not properly initialized!",
						new IllegalProjectSpaceStateException("Resource to save is null"));
				}
				return;
			}
			resource.save(Configuration.getResourceSaveOptions());
		} catch (IOException e) {
			Throwable cause = e.getCause();
			if (cause != null && cause instanceof DanglingHREFException) {
				boolean foundProblems = ModelValidationHelper.checkAndFixProject(getProject());
				if (foundProblems) {
					WorkspaceUtil.logException(
						"An error in the data was detected during save! Self-healing fixed the problem.", e);
				}
			}
		}
	}

	/**
	 * Add model element to a resource, assign a new resource if neccessary.
	 * 
	 * @param modelElement the model element
	 * @generated NOT
	 */
	private void addToResource(final ModelElement modelElement) {
		if (isTransient) {
			return;
		}
		TransactionalEditingDomain domain = WorkspaceManager.getInstance().getCurrentWorkspace().getEditingDomain();
		domain.getCommandStack().execute(new RecordingCommand(domain) {
			@Override
			protected void doExecute() {
				Resource oldResource = modelElement.eResource();
				URI oldUri = oldResource.getURI();
				if (!oldUri.isFile()) {
					throw new IllegalStateException(
						"Project contains ModelElements that are not part of a file resource.");
				}
				String oldFileName = oldUri.toFileString();
				if (new File(oldFileName).length() > Configuration.getMaxResourceFileSizeOnExpand()) {
					String newfileName = Configuration.getWorkspaceDirectory() + "ps-" + getIdentifier()
						+ File.separatorChar + getResourceCount() + ".ucf";
					checkIfFileExists(newfileName);
					URI fileURI = URI.createFileURI(newfileName);
					Resource newResource = oldResource.getResourceSet().createResource(fileURI);
					setResourceCount(getResourceCount() + 1);
					newResource.getContents().add(modelElement);

				}
			}

			private void checkIfFileExists(String newfileName) {
				if (new File(newfileName).exists()) {
					throw new IllegalStateException("File fragment \"" + newfileName
						+ "\" already exists - ProjectSpace corrupted.");
				}
			}
		});

	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.unicase.model.util.ProjectChangeObserver#notify(org.eclipse.emf.common.notify.Notification,
	 *      org.unicase.model.Project, org.unicase.model.ModelElement)
	 */
	public void notify(Notification notification, Project project, ModelElement modelElement) {
		if (isRecording) {
			List<AbstractOperation> createdOperations;
			try {
				createdOperations = OperationParser.parseOperations(notification, modelElement);
			} catch (UnsupportedNotificationException e) {
				WorkspaceUtil.logException("Recording an operation failed!", e);
				// save model element anyway, other wise model could be corrupted
				save(modelElement);
				return;
			}
			if (this.deleteOperation == null) {
				getOperations().addAll(createdOperations);
				OperationsCannonizer.cannonize(getOperations());
			} else {
				EList<ReferenceOperation> subOperations = this.deleteOperation.getSubOperations();
				// check if all recorded ops are reference operations
				// MK: should also check if reference operations really refer to the delete
				for (AbstractOperation operation : createdOperations) {
					if (OperationsPackage.eINSTANCE.getReferenceOperation().isInstance(operation)) {
						subOperations.add((ReferenceOperation) operation);
					} else {
						getOperations().add(operation);
						String message = "During a delete operation an operation of a type other than ReferenceOperation occured!";
						WorkspaceUtil.logException(message, new IllegalStateException(message));
					}
				}
			}
			// MK: maybe skip save if we are within a delete operation
			saveProjectSpaceOnly();
			save(modelElement);
			updateDirtyState();
		}
	}

	private void save(ModelElement modelElement) {
		Resource resource = modelElement.eResource();
		if (resource == null) {
			String message = "Save failed: ModelElement \"" + modelElement.getIdentifier() + "\" has no resource!";
			WorkspaceUtil.logException(message, new IllegalStateException(message));
			return;
		}
		try {
			resource.save(Configuration.getResourceSaveOptions());
		} catch (IOException e) {
			String message = "Save failed: ModelElement \"" + modelElement.getIdentifier();
			WorkspaceUtil.logException(message, e);
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.unicase.workspace.ProjectSpace#exportLocalChanges(java.lang.String)
	 */
	public void exportLocalChanges(String fileName) throws IOException {
		ResourceSet resourceSet = new ResourceSetImpl();
		Resource resource = resourceSet.createResource(URI.createFileURI(fileName));
		ChangePackage changePackage = VersioningFactory.eINSTANCE.createChangePackage();
		// copy operations from projectspace
		for (AbstractOperation abstractOperation : getOperations()) {
			AbstractOperation copy = (AbstractOperation) EcoreUtil.copy(abstractOperation);
			changePackage.getOperations().add(copy);
		}

		resource.getContents().add(changePackage);
		resource.save(null);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.unicase.workspace.ProjectSpace#importLocalChanges(java.lang.String)
	 */
	public void importLocalChanges(String fileName) throws IOException {

		ResourceSetImpl resourceSet = new ResourceSetImpl();
		Resource resource = resourceSet.getResource(URI.createFileURI(fileName), true);
		EList<EObject> directContents = resource.getContents();
		// sanity check

		if (directContents.size() != 1 && (!(directContents.get(0) instanceof ChangePackage))) {
			throw new IOException("File is corrupt, does not contain Changes.");
		}

		ChangePackage changePackage = (ChangePackage) directContents.get(0);
		stopChangeRecording();
		changePackage.apply(getProject());
		startChangeRecording();
		this.getOperations().addAll(changePackage.getOperations());
		saveResourceSet();

	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.unicase.workspace.ProjectSpace#undoLastOperation()
	 */
	public void undoLastOperation() {
		List<AbstractOperation> operations = this.getOperations();
		AbstractOperation lastOperation = operations.get(operations.size() - 1);
		stopChangeRecording();
		lastOperation.reverse().apply(getProject());
		startChangeRecording();
		operations.remove(lastOperation);
		saveResourceSet();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.unicase.workspace.ProjectSpace#addEvent(org.unicase.emfstore.esmodel.versioning.events.Event)
	 */
	public void addEvent(Event event) {
		if (event.getTimestamp() == null) {
			event.setTimestamp(new Date());
		}
		this.getEvents().add(event);
		saveProjectSpaceOnly();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @generated NOT
	 */
	public void addTag(PrimaryVersionSpec versionSpec, TagVersionSpec tag) throws EmfStoreException {
		final ConnectionManager cm = WorkspaceManager.getInstance().getConnectionManager();
		cm.addTag(getUsersession().getSessionId(), getProjectId(), versionSpec, tag);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @generated NOT
	 */
	public void removeTag(PrimaryVersionSpec versionSpec, TagVersionSpec tag) throws EmfStoreException {
		final ConnectionManager cm = WorkspaceManager.getInstance().getConnectionManager();
		cm.removeTag(getUsersession().getSessionId(), getProjectId(), versionSpec, tag);
	}

	public void modelElementDeleteCompleted(Project project, ModelElement modelElement) {
		if (isRecording) {
			if (deleteOperation == null) {
				throw new IllegalStateException("DeleteCompleted called without previous delete start call");
			}
			deleteOperation.setDelete(true);
			deleteOperation.setModelElement(ModelUtil.clone(modelElement));
			deleteOperation.setModelElementId(modelElement.getModelElementId());
			this.getOperations().add(deleteOperation);

			deleteOperation = null;

			OperationsCannonizer.cannonize(getOperations());

			saveProjectSpaceOnly();
			updateDirtyState();
			Resource resource = modelElement.eResource();
			if (resource != null) {
				resource.getContents().remove(modelElement);
				saveResource(resource);
			}
			for (ModelElement child : modelElement.getAllContainedModelElements()) {
				Resource childResource = child.eResource();
				if (childResource != null) {
					childResource.getContents().remove(child);
					saveResource(childResource);
				}
			}

		}
	}

	public void modelElementDeleteStarted(Project project, ModelElement modelElement) {
		if (isRecording) {
			this.deleteOperation = OperationsFactory.eINSTANCE.createCreateDeleteOperation();
			deleteOperation.setClientDate(new Date());
		}
	}

	public ModelElement resolve(ModelElementUrlFragment modelElementUrlFragment) throws MEUrlResolutionException {
		ModelElementId modelElementId = modelElementUrlFragment.getModelElementId();
		ModelElement modelElement = getProject().getModelElement(modelElementId);
		if (modelElement == null) {
			throw new MEUrlResolutionException();
		}
		return modelElement;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.unicase.model.util.ProjectChangeObserver#modelElementAdded(org.unicase.model.Project,
	 *      org.unicase.model.ModelElement)
	 */
	public void modelElementAdded(Project project, ModelElement modelElement) {
		addToResource(modelElement);
		if (isRecording) {
			appendCreator(modelElement);
			this.getOperations().add(createCreateDeleteOperation(modelElement, false));
			saveProjectSpaceOnly();
		}
	}

	/**
	 * Appends the creator's name and the creation date.
	 * 
	 * @param modelElement the model element.
	 */
	private void appendCreator(ModelElement modelElement) {
		stopChangeRecording();
		if (modelElement.getCreator() == null || modelElement.getCreator().equals("")) {
			Usersession usersession = getUsersession();
			// used when the project has not been shared yet
			// and there is practically no possible way of
			// knowing who the creator was...
			String creator = "unicase";
			if (usersession != null) {
				creator = usersession.getACUser().getName();
			}
			modelElement.setCreator(creator);
		}
		if (modelElement.getCreationDate() == null) {
			modelElement.setCreationDate(new Date());
		}
		startChangeRecording();
	}

	/**
	 * Create a CreateDeleteOperation
	 * 
	 * @param modelElement the model element to delete or create
	 * @param delete whether the element is deleted or created
	 * @return the operation
	 */
	private CreateDeleteOperation createCreateDeleteOperation(ModelElement modelElement, boolean delete) {
		CreateDeleteOperation createDeleteOperation = OperationsFactory.eINSTANCE.createCreateDeleteOperation();
		createDeleteOperation.setDelete(delete);
		createDeleteOperation.setModelElement((ModelElement) EcoreUtil.copy(modelElement));
		createDeleteOperation.setModelElementId(modelElement.getModelElementId());
		createDeleteOperation.setClientDate(new Date());
		return createDeleteOperation;
	}

	public void makeTransient() {
		if (initCompleted) {
			throw new IllegalAccessError("Project Space cannot be set to transient after init.");
		}
		isTransient = true;
	}
} // ProjectContainerImpl
