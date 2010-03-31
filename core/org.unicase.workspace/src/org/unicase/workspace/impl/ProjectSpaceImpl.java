/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.workspace.impl;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import org.eclipse.core.runtime.jobs.Job;
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
import org.unicase.emfstore.conflictDetection.ConflictDetector;
import org.unicase.emfstore.esmodel.EsmodelFactory;
import org.unicase.emfstore.esmodel.ProjectId;
import org.unicase.emfstore.esmodel.ProjectInfo;
import org.unicase.emfstore.esmodel.accesscontrol.ACUser;
import org.unicase.emfstore.esmodel.accesscontrol.OrgUnitProperty;
import org.unicase.emfstore.esmodel.notification.ESNotification;
import org.unicase.emfstore.esmodel.url.ModelElementUrlFragment;
import org.unicase.emfstore.esmodel.versioning.ChangePackage;
import org.unicase.emfstore.esmodel.versioning.LogMessage;
import org.unicase.emfstore.esmodel.versioning.PrimaryVersionSpec;
import org.unicase.emfstore.esmodel.versioning.TagVersionSpec;
import org.unicase.emfstore.esmodel.versioning.VersionSpec;
import org.unicase.emfstore.esmodel.versioning.VersioningFactory;
import org.unicase.emfstore.esmodel.versioning.events.Event;
import org.unicase.emfstore.esmodel.versioning.operations.AbstractOperation;
import org.unicase.emfstore.esmodel.versioning.operations.CompositeOperation;
import org.unicase.emfstore.exceptions.BaseVersionOutdatedException;
import org.unicase.emfstore.exceptions.EmfStoreException;
import org.unicase.emfstore.exceptions.FileTransferException;
import org.unicase.emfstore.filetransfer.FileInformation;
import org.unicase.metamodel.MetamodelFactory;
import org.unicase.metamodel.ModelElement;
import org.unicase.metamodel.ModelElementId;
import org.unicase.metamodel.Project;
import org.unicase.metamodel.impl.IdentifiableElementImpl;
import org.unicase.metamodel.impl.ProjectImpl;
import org.unicase.metamodel.util.AutoSplitAndSaveResourceContainmentList;
import org.unicase.metamodel.util.ModelUtil;
import org.unicase.workspace.CompositeOperationHandle;
import org.unicase.workspace.Configuration;
import org.unicase.workspace.EventComposite;
import org.unicase.workspace.ModifiedModelElementsCache;
import org.unicase.workspace.NotificationComposite;
import org.unicase.workspace.OperationComposite;
import org.unicase.workspace.PendingFileTransfer;
import org.unicase.workspace.ProjectSpace;
import org.unicase.workspace.Usersession;
import org.unicase.workspace.WorkspaceFactory;
import org.unicase.workspace.WorkspaceManager;
import org.unicase.workspace.WorkspacePackage;
import org.unicase.workspace.changeTracking.notification.recording.NotificationRecorder;
import org.unicase.workspace.connectionmanager.ConnectionManager;
import org.unicase.workspace.exceptions.ChangeConflictException;
import org.unicase.workspace.exceptions.IllegalProjectSpaceStateException;
import org.unicase.workspace.exceptions.MEUrlResolutionException;
import org.unicase.workspace.exceptions.NoChangesOnServerException;
import org.unicase.workspace.exceptions.NoLocalChangesException;
import org.unicase.workspace.exceptions.PropertyNotFoundException;
import org.unicase.workspace.filetransfer.FileDownloadJob;
import org.unicase.workspace.filetransfer.FileRequestHandler;
import org.unicase.workspace.filetransfer.FileTransferJob;
import org.unicase.workspace.filetransfer.FileTransferUtil;
import org.unicase.workspace.filetransfer.FileUploadJob;
import org.unicase.workspace.notification.NotificationGenerator;
import org.unicase.workspace.observers.CommitObserver;
import org.unicase.workspace.observers.ConflictResolver;
import org.unicase.workspace.observers.LoginObserver;
import org.unicase.workspace.observers.OperationListener;
import org.unicase.workspace.observers.ShareObserver;
import org.unicase.workspace.observers.UpdateObserver;
import org.unicase.workspace.preferences.PropertyKey;
import org.unicase.workspace.util.ResourceHelper;
import org.unicase.workspace.util.UnicaseCommand;
import org.unicase.workspace.util.WorkspaceUtil;

/**
 * <!-- begin-user-doc --> An implementation of the model object ' <em><b>Project Container</b></em>'.
 * 
 * @implements LoginObserver <!-- end-user-doc -->
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
 *             <li>{@link org.unicase.workspace.impl.ProjectSpaceImpl#getPendingFileTransfers <em>Pending File Transfers
 *             </em>}</li>
 *             <li>{@link org.unicase.workspace.impl.ProjectSpaceImpl#getEventComposite <em>Event Composite</em>}</li>
 *             <li>{@link org.unicase.workspace.impl.ProjectSpaceImpl#getNotificationComposite <em>Notification
 *             Composite</em>}</li>
 *             </ul>
 *             </p>
 * @generated
 */
public class ProjectSpaceImpl extends IdentifiableElementImpl implements ProjectSpace, LoginObserver {

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

	/**
	 * The cached value of the '{@link #getPendingFileTransfers() <em>Pending File Transfers</em>}' containment
	 * reference list. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getPendingFileTransfers()
	 * @generated
	 * @ordered
	 */
	protected EList<PendingFileTransfer> pendingFileTransfers;

	/**
	 * The cached value of the '{@link #getEventComposite() <em>Event Composite</em>}' containment reference. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getEventComposite()
	 * @generated
	 * @ordered
	 */
	protected EventComposite eventComposite;

	/**
	 * The cached value of the '{@link #getNotificationComposite() <em>Notification Composite</em>}' containment
	 * reference. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getNotificationComposite()
	 * @generated
	 * @ordered
	 */
	protected NotificationComposite notificationComposite;

	private boolean initCompleted;

	private boolean isTransient;

	private List<CommitObserver> commitObservers;

	private ModifiedModelElementsCache modifiedModelElementsCache;

	private List<OperationListener> operationListeners;

	private ProjectChangeTracker changeTracker;

	private AutoSplitAndSaveResourceContainmentList<AbstractOperation> operationsList;

	private AutoSplitAndSaveResourceContainmentList<Event> eventList;

	private HashMap<String, OrgUnitProperty> propertyMap;

	private AutoSplitAndSaveResourceContainmentList<ESNotification> notificationList;

	private ArrayList<ShareObserver> shareObservers;

	// begin of custom code
	/**
	 * Constructor. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	protected ProjectSpaceImpl() {
		super();
		this.commitObservers = new ArrayList<CommitObserver>();
		this.operationListeners = new ArrayList<OperationListener>();
		this.shareObservers = new ArrayList<ShareObserver>();
		this.propertyMap = new HashMap<String, OrgUnitProperty>();
		modifiedModelElementsCache = new ModifiedModelElementsCache(this);
		this.addOperationListener(modifiedModelElementsCache);
		this.addCommitObserver(modifiedModelElementsCache);
		shareObservers.add(modifiedModelElementsCache);
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
	@Deprecated
	public EList<Event> getEvents() {
		if (events == null) {
			events = new EObjectContainmentEList.Resolving<Event>(Event.class, this,
				WorkspacePackage.PROJECT_SPACE__EVENTS);
		}
		return events;
	}

	// begin of custom code
	/**
	 * Get the events that have been logged for this project space.
	 * 
	 * @return a list of events ordered by creation time
	 */
	public List<Event> getEventsFromComposite() {
		// check if operation composite exists
		EventComposite eventComposite = this.getEventComposite();
		if (isTransient) {
			if (eventComposite == null) {
				eventComposite = WorkspaceFactory.eINSTANCE.createEventComposite();
				this.setEventComposite(eventComposite);
			}
			return eventComposite.getEvents();
		}
		if (eventComposite == null) {
			eventComposite = WorkspaceFactory.eINSTANCE.createEventComposite();
			// migration code: existing events in the event feature are added to the composite
			eventList = new AutoSplitAndSaveResourceContainmentList<Event>(eventComposite, eventComposite.getEvents(),
				this.eResource().getResourceSet(), Configuration.getWorkspaceDirectory() + "ps-" + getIdentifier()
					+ File.separatorChar + "events", ".eff");
			this.setEventComposite(eventComposite);
			if (getEvents().size() > 0) {
				eventList.addAll(getEvents());
				saveProjectSpaceOnly();
			}
		}
		if (eventList == null) {
			eventList = new AutoSplitAndSaveResourceContainmentList<Event>(eventComposite, eventComposite.getEvents(),
				this.eResource().getResourceSet(), Configuration.getWorkspaceDirectory() + "ps-" + getIdentifier()
					+ File.separatorChar + "events", ".eff");
		}
		return eventList;
	}

	// end of custom code

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
	@Deprecated
	public EList<ESNotification> getNotifications() {
		if (notifications == null) {
			notifications = new EObjectContainmentEList.Resolving<ESNotification>(ESNotification.class, this,
				WorkspacePackage.PROJECT_SPACE__NOTIFICATIONS);
		}
		return notifications;
	}

	/**
	 * Get the events that have been logged for this project space.
	 * 
	 * @return a list of events ordered by creation time
	 */
	public List<ESNotification> getNotificationsFromComposite() {
		// check if operation composite exists
		NotificationComposite notificationComposite = this.getNotificationComposite();
		if (isTransient) {
			if (notificationComposite == null) {
				notificationComposite = WorkspaceFactory.eINSTANCE.createNotificationComposite();
				this.setNotificationComposite(notificationComposite);
			}
			return notificationComposite.getNotifications();
		}
		if (notificationComposite == null) {
			notificationComposite = WorkspaceFactory.eINSTANCE.createNotificationComposite();
			// migration code: existing notifications in the notification feature are added to the composite
			notificationList = new AutoSplitAndSaveResourceContainmentList<ESNotification>(notificationComposite,
				notificationComposite.getNotifications(), this.eResource().getResourceSet(), Configuration
					.getWorkspaceDirectory()
					+ "ps-" + getIdentifier() + File.separatorChar + "notifications", ".nff");
			this.setNotificationComposite(notificationComposite);
			if (getNotifications().size() > 0) {
				notificationList.addAll(getNotifications());
				saveProjectSpaceOnly();
			}
		}
		if (notificationList == null) {
			notificationList = new AutoSplitAndSaveResourceContainmentList<ESNotification>(notificationComposite,
				notificationComposite.getNotifications(), this.eResource().getResourceSet(), Configuration
					.getWorkspaceDirectory()
					+ "ps-" + getIdentifier() + File.separatorChar + "notifications", ".nff");
		}
		return notificationList;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EList<PendingFileTransfer> getPendingFileTransfers() {
		if (pendingFileTransfers == null) {
			pendingFileTransfers = new EObjectContainmentEList.Resolving<PendingFileTransfer>(
				PendingFileTransfer.class, this, WorkspacePackage.PROJECT_SPACE__PENDING_FILE_TRANSFERS);
		}
		return pendingFileTransfers;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EventComposite getEventComposite() {
		if (eventComposite != null && eventComposite.eIsProxy()) {
			InternalEObject oldEventComposite = (InternalEObject) eventComposite;
			eventComposite = (EventComposite) eResolveProxy(oldEventComposite);
			if (eventComposite != oldEventComposite) {
				InternalEObject newEventComposite = (InternalEObject) eventComposite;
				NotificationChain msgs = oldEventComposite.eInverseRemove(this, EOPPOSITE_FEATURE_BASE
					- WorkspacePackage.PROJECT_SPACE__EVENT_COMPOSITE, null, null);
				if (newEventComposite.eInternalContainer() == null) {
					msgs = newEventComposite.eInverseAdd(this, EOPPOSITE_FEATURE_BASE
						- WorkspacePackage.PROJECT_SPACE__EVENT_COMPOSITE, null, msgs);
				}
				if (msgs != null)
					msgs.dispatch();
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE,
						WorkspacePackage.PROJECT_SPACE__EVENT_COMPOSITE, oldEventComposite, eventComposite));
			}
		}
		return eventComposite;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EventComposite basicGetEventComposite() {
		return eventComposite;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public NotificationChain basicSetEventComposite(EventComposite newEventComposite, NotificationChain msgs) {
		EventComposite oldEventComposite = eventComposite;
		eventComposite = newEventComposite;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET,
				WorkspacePackage.PROJECT_SPACE__EVENT_COMPOSITE, oldEventComposite, newEventComposite);
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
	public void setEventComposite(EventComposite newEventComposite) {
		if (newEventComposite != eventComposite) {
			NotificationChain msgs = null;
			if (eventComposite != null)
				msgs = ((InternalEObject) eventComposite).eInverseRemove(this, EOPPOSITE_FEATURE_BASE
					- WorkspacePackage.PROJECT_SPACE__EVENT_COMPOSITE, null, msgs);
			if (newEventComposite != null)
				msgs = ((InternalEObject) newEventComposite).eInverseAdd(this, EOPPOSITE_FEATURE_BASE
					- WorkspacePackage.PROJECT_SPACE__EVENT_COMPOSITE, null, msgs);
			msgs = basicSetEventComposite(newEventComposite, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WorkspacePackage.PROJECT_SPACE__EVENT_COMPOSITE,
				newEventComposite, newEventComposite));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public NotificationComposite getNotificationComposite() {
		if (notificationComposite != null && notificationComposite.eIsProxy()) {
			InternalEObject oldNotificationComposite = (InternalEObject) notificationComposite;
			notificationComposite = (NotificationComposite) eResolveProxy(oldNotificationComposite);
			if (notificationComposite != oldNotificationComposite) {
				InternalEObject newNotificationComposite = (InternalEObject) notificationComposite;
				NotificationChain msgs = oldNotificationComposite.eInverseRemove(this, EOPPOSITE_FEATURE_BASE
					- WorkspacePackage.PROJECT_SPACE__NOTIFICATION_COMPOSITE, null, null);
				if (newNotificationComposite.eInternalContainer() == null) {
					msgs = newNotificationComposite.eInverseAdd(this, EOPPOSITE_FEATURE_BASE
						- WorkspacePackage.PROJECT_SPACE__NOTIFICATION_COMPOSITE, null, msgs);
				}
				if (msgs != null)
					msgs.dispatch();
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE,
						WorkspacePackage.PROJECT_SPACE__NOTIFICATION_COMPOSITE, oldNotificationComposite,
						notificationComposite));
			}
		}
		return notificationComposite;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public NotificationComposite basicGetNotificationComposite() {
		return notificationComposite;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public NotificationChain basicSetNotificationComposite(NotificationComposite newNotificationComposite,
		NotificationChain msgs) {
		NotificationComposite oldNotificationComposite = notificationComposite;
		notificationComposite = newNotificationComposite;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET,
				WorkspacePackage.PROJECT_SPACE__NOTIFICATION_COMPOSITE, oldNotificationComposite,
				newNotificationComposite);
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
	public void setNotificationComposite(NotificationComposite newNotificationComposite) {
		if (newNotificationComposite != notificationComposite) {
			NotificationChain msgs = null;
			if (notificationComposite != null)
				msgs = ((InternalEObject) notificationComposite).eInverseRemove(this, EOPPOSITE_FEATURE_BASE
					- WorkspacePackage.PROJECT_SPACE__NOTIFICATION_COMPOSITE, null, msgs);
			if (newNotificationComposite != null)
				msgs = ((InternalEObject) newNotificationComposite).eInverseAdd(this, EOPPOSITE_FEATURE_BASE
					- WorkspacePackage.PROJECT_SPACE__NOTIFICATION_COMPOSITE, null, msgs);
			msgs = basicSetNotificationComposite(newNotificationComposite, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
				WorkspacePackage.PROJECT_SPACE__NOTIFICATION_COMPOSITE, newNotificationComposite,
				newNotificationComposite));
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @generated NOT
	 */
	public PrimaryVersionSpec commit(final LogMessage logMessage) throws EmfStoreException {
		return commit(logMessage, null);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @generated NOT
	 */
	public PrimaryVersionSpec commit(final LogMessage logMessage, CommitObserver commitObserver)
		throws EmfStoreException {

		// check if there are any changes
		if (!this.isDirty()) {
			throw new NoLocalChangesException();
		}

		// check if we need to update first
		PrimaryVersionSpec resolvedVersion;
		resolvedVersion = resolveVersionSpec(VersionSpec.HEAD_VERSION);

		if ((!getBaseVersion().equals(resolvedVersion))) {
			throw new BaseVersionOutdatedException();
		}

		final ConnectionManager connectionManager = WorkspaceManager.getInstance().getConnectionManager();

		ChangePackage changePackage = getLocalChangePackage(true);

		if (changePackage.getOperations().isEmpty()) {
			for (AbstractOperation operation : getOperations()) {
				notifyOperationUndone(operation);
			}
			getOperations().clear();
			updateDirtyState();
			throw new NoLocalChangesException();
		}

		notifyPreCommitObservers(changePackage);

		if (commitObserver != null && !commitObserver.inspectChanges(this, changePackage)) {
			return this.getBaseVersion();
		}

		PrimaryVersionSpec newBaseVersion;
		newBaseVersion = connectionManager.createVersion(getUsersession().getSessionId(), getProjectId(),
			getBaseVersion(), changePackage, logMessage);

		setBaseVersion(newBaseVersion);
		getOperations().clear();
		getEventsFromComposite().clear();

		saveProjectSpaceOnly();

		if (commitObserver != null) {
			commitObserver.commitCompleted(this, newBaseVersion);
		}

		notifyPostCommitObservers(newBaseVersion);

		updateDirtyState();
		return newBaseVersion;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.unicase.workspace.ProjectSpace#getLocalChangePackage()
	 */
	public ChangePackage getLocalChangePackage(boolean canonize) {
		ChangePackage changePackage = VersioningFactory.eINSTANCE.createChangePackage();
		// copy operations from projectspace
		for (AbstractOperation abstractOperation : getOperations()) {
			AbstractOperation copy = (AbstractOperation) EcoreUtil.copy(abstractOperation);
			changePackage.getOperations().add(copy);
		}
		// copy events from projectspace
		for (Event event : getEventsFromComposite()) {
			Event copy = (Event) EcoreUtil.copy(event);
			changePackage.getEvents().add(copy);
		}

		if (canonize) {
			changePackage.cannonize();
		}
		return changePackage;
	}

	private void notifyPostCommitObservers(PrimaryVersionSpec newBaseVersion) {
		for (CommitObserver observer : commitObservers) {
			try {
				observer.commitCompleted(this, newBaseVersion);
				// BEGIN SUPRESS CATCH EXCEPTION
			} catch (RuntimeException e) {
				// END SUPRESS CATCH EXCEPTION
				WorkspaceUtil.logException("CommitObserver failed with exception", e);
			}
		}
	}

	private void notifyPreCommitObservers(ChangePackage changePackage) {
		for (CommitObserver observer : commitObservers) {
			try {
				observer.inspectChanges(this, changePackage);
				// BEGIN SUPRESS CATCH EXCEPTION
			} catch (RuntimeException e) {
				// END SUPRESS CATCH EXCEPTION
				WorkspaceUtil.logException("CommitObserver failed with exception", e);
			}
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.unicase.workspace.ProjectSpace#getOperations()
	 */
	public List<AbstractOperation> getOperations() {
		// check if operation composite exists
		OperationComposite operationComposite = this.getLocalOperations();
		if (operationComposite == null) {
			this.setLocalOperations(WorkspaceFactory.eINSTANCE.createOperationComposite());
			operationComposite = getLocalOperations();
		}
		if (isTransient) {
			return operationComposite.getOperations();
		}
		if (operationsList == null) {
			operationsList = new AutoSplitAndSaveResourceContainmentList<AbstractOperation>(operationComposite,
				operationComposite.getOperations(), this.eResource().getResourceSet(), Configuration
					.getWorkspaceDirectory()
					+ "ps-" + getIdentifier() + File.separatorChar + "operations", ".off");
		}
		return operationsList;
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

		ConflictDetector conflictDetector = new ConflictDetector();
		for (ChangePackage change : changes) {
			ChangePackage changePackage = getLocalChangePackage(false);
			if (conflictDetector.doConflict(change, changePackage)) {
				throw new ChangeConflictException(changes, this, conflictDetector);
			}
		}

		// notify updateObserver if there is one
		if (observer != null && !observer.inspectChanges(changes)) {
			return getBaseVersion();
		}

		final List<ChangePackage> cps = changes;
		for (ChangePackage change : cps) {
			applyOperations(change.getCopyOfOperations(), false);
		}

		setBaseVersion(resolvedVersion);
		saveProjectSpaceOnly();

		generateNotifications(changes);

		if (observer != null) {
			observer.updateCompleted();
		}

		// check for operations on file attachments: if version has been increased and file is required offline, add to
		// pending file transfers
		// checkUpdatedFileAttachments(changes);

		return resolvedVersion;
	}

	// private void checkUpdatedFileAttachments(List<ChangePackage> changes) {
	// List<FileAttachment> attachmentsToDownload = new LinkedList<FileAttachment>();
	// for (ChangePackage change : changes) {
	// EList<AbstractOperation> operations = change.getOperations();
	// for (AbstractOperation operation : operations) {
	// if (!OperationsPackage.eINSTANCE.getAttributeOperation().isInstance(operation)) {
	// continue;
	// }
	// AttributeOperation attributeOperation = (AttributeOperation) operation;
	// if (!attributeOperation.getFeatureName().equals(
	// AttachmentPackage.eINSTANCE.getFileAttachment_FileID().getName())) {
	// continue;
	// }
	// ModelElement modelElement = getProject().getModelElement(operation.getModelElementId());
	// if (AttachmentPackage.eINSTANCE.getFileAttachment().isInstance(modelElement)) {
	// FileAttachment fileAttachment = (FileAttachment) getProject().getModelElement(
	// operation.getModelElementId());
	// if (fileAttachment.isRequiredOffline()) {
	// attachmentsToDownload.add((FileAttachment) modelElement);
	// }
	// }
	// }
	// }
	// for (final FileAttachment fileAttachment : attachmentsToDownload) {
	// final PendingFileTransfer transfer = WorkspaceFactoryImpl.eINSTANCE.createPendingFileTransfer();
	// transfer.setAttachmentId(fileAttachment.getModelElementId());
	// transfer.setChunkNumber(0);
	// transfer.setFileVersion(Integer.parseInt(fileAttachment.getFileID()));
	// transfer.setFileName(fileAttachment.getFileName());
	// transfer.setPreliminaryFileName(null);
	// transfer.setUpload(false);
	// new UnicaseCommand() {
	// @Override
	// protected void doRun() {
	// fileAttachment.setDownloading(true);
	// getPendingFileTransfers().add(transfer);
	// }
	// }.run();
	// }
	// }

	private void generateNotifications(List<ChangePackage> changes) {
		// generate notifications from change packages, ignore all exception if any
		try {
			List<ESNotification> newNotifications = NotificationGenerator.getInstance(this).generateNotifications(
				changes, this.getUsersession().getUsername());
			this.getNotificationsFromComposite().addAll(newNotifications);
			// BEGIN SUPRESS CATCH EXCEPTION
		} catch (RuntimeException e) {
			// END SUPRESS CATCH EXCEPTION
			WorkspaceUtil.logException("Creating notifications failed!", e);
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @generated NOT
	 */
	public void revert() {
		while (!getOperations().isEmpty()) {
			undoLastOperation();
		}
		updateDirtyState();
	}

	/**
	 * Stops current recording of changes and adds recorded changes to this project spaces changes.
	 * 
	 * @generated NOT
	 */
	public void stopChangeRecording() {
		this.changeTracker.stopChangeRecording();
	}

	/**
	 * Starts change recording on this workspace, resumes previous recordings if there are any.
	 * 
	 * @generated NOT
	 */
	public void startChangeRecording() {
		this.changeTracker.startChangeRecording();
		updateDirtyState();
	}

	/**
	 * Updates the dirty state of the project space.
	 */
	public void updateDirtyState() {
		setDirty(!getOperations().isEmpty());
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.unicase.workspace.ProjectSpace#init()
	 * @generated NOT
	 */
	public void init() {
		initCompleted = true;
		this.changeTracker = new ProjectChangeTracker(this);
		this.getProject().addProjectChangeObserver(this.changeTracker);
		if (project instanceof ProjectImpl) {
			((ProjectImpl) this.getProject()).setUndetachable(changeTracker);
		}
		if (getUsersession() != null) {
			getUsersession().addLoginObserver(this);
			ACUser acUser = getUsersession().getACUser();
			if (acUser != null) {
				for (OrgUnitProperty p : acUser.getProperties()) {
					propertyMap.put(p.getName(), p);
				}
			}
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
		projectInfo.setProjectId(ModelUtil.clone(getProjectId()));
		projectInfo.setName(getProjectName());
		projectInfo.setDescription(getProjectDescription());
		projectInfo.setVersion(ModelUtil.clone(getBaseVersion()));
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
		return connectionManager.resolveVersionSpec(getUsersession().getSessionId(), getProjectId(), versionSpec);
	}

	/**
	 * {@inheritDoc}
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

	// end of custom code
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
		case WorkspacePackage.PROJECT_SPACE__PENDING_FILE_TRANSFERS:
			return ((InternalEList<?>) getPendingFileTransfers()).basicRemove(otherEnd, msgs);
		case WorkspacePackage.PROJECT_SPACE__EVENT_COMPOSITE:
			return basicSetEventComposite(null, msgs);
		case WorkspacePackage.PROJECT_SPACE__NOTIFICATION_COMPOSITE:
			return basicSetNotificationComposite(null, msgs);
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
		case WorkspacePackage.PROJECT_SPACE__PENDING_FILE_TRANSFERS:
			return getPendingFileTransfers();
		case WorkspacePackage.PROJECT_SPACE__EVENT_COMPOSITE:
			if (resolve)
				return getEventComposite();
			return basicGetEventComposite();
		case WorkspacePackage.PROJECT_SPACE__NOTIFICATION_COMPOSITE:
			if (resolve)
				return getNotificationComposite();
			return basicGetNotificationComposite();
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
		case WorkspacePackage.PROJECT_SPACE__PENDING_FILE_TRANSFERS:
			getPendingFileTransfers().clear();
			getPendingFileTransfers().addAll((Collection<? extends PendingFileTransfer>) newValue);
			return;
		case WorkspacePackage.PROJECT_SPACE__EVENT_COMPOSITE:
			setEventComposite((EventComposite) newValue);
			return;
		case WorkspacePackage.PROJECT_SPACE__NOTIFICATION_COMPOSITE:
			setNotificationComposite((NotificationComposite) newValue);
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
		case WorkspacePackage.PROJECT_SPACE__PENDING_FILE_TRANSFERS:
			getPendingFileTransfers().clear();
			return;
		case WorkspacePackage.PROJECT_SPACE__EVENT_COMPOSITE:
			setEventComposite((EventComposite) null);
			return;
		case WorkspacePackage.PROJECT_SPACE__NOTIFICATION_COMPOSITE:
			setNotificationComposite((NotificationComposite) null);
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
		case WorkspacePackage.PROJECT_SPACE__PENDING_FILE_TRANSFERS:
			return pendingFileTransfers != null && !pendingFileTransfers.isEmpty();
		case WorkspacePackage.PROJECT_SPACE__EVENT_COMPOSITE:
			return eventComposite != null;
		case WorkspacePackage.PROJECT_SPACE__NOTIFICATION_COMPOSITE:
			return notificationComposite != null;
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
		usersession.addLoginObserver(this);
		LogMessage logMessage = VersioningFactory.eINSTANCE.createLogMessage();
		logMessage.setAuthor(usersession.getUsername());
		logMessage.setClientDate(new Date());
		logMessage.setMessage("Initial commit");
		ProjectInfo createdProject;

		// Set user as creator when sharing a project
		for (ModelElement me : this.getProject().getAllModelElements()) {
			if (me.getCreator() == null || me.getCreator().equals("")
				|| me.getCreator().equals(ProjectChangeTracker.UNKOWN_CREATOR)) {
				me.setCreator(usersession.getUsername());
			}
		}

		createdProject = WorkspaceManager.getInstance().getConnectionManager().createProject(
			usersession.getSessionId(), this.getProjectName(), this.getProjectDescription(), logMessage,
			this.getProject());
		this.setBaseVersion(createdProject.getVersion());
		this.setLastUpdated(new Date());
		this.setProjectId(createdProject.getProjectId());
		this.saveProjectSpaceOnly();
		notifyShareObservers();
		getOperations().clear();
		usersession.updateProjectInfos();
		updateDirtyState();

	}

	private void notifyShareObservers() {
		for (ShareObserver shareObserver : shareObservers) {
			try {
				shareObserver.shareDone();
				// BEGIN SUPRESS CATCH EXCEPTION
			} catch (RuntimeException e) {
				// END SUPRESS CATCH EXCEPTION
				WorkspaceUtil.logException("ShareObserver failed with exception", e);
			}
		}
	}

	/**
	 * Saves the project space itself only, no containment children.
	 */
	public void saveProjectSpaceOnly() {
		saveResource(this.eResource());
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
	 * Save the given resource that is part of the project space resource set.
	 * 
	 * @param resource the resource
	 */
	public void saveResource(Resource resource) {
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
			WorkspaceUtil
				.logException(
					"An error in the data was detected during save! The safest way to deal with this problem is to delete this project and checkout again.",
					e);
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.unicase.workspace.ProjectSpace#exportLocalChanges(java.lang.String)
	 */
	public void exportLocalChanges(String fileName) throws IOException {

		ResourceHelper.putElementIntoNewResource(fileName, getLocalChangePackage(false));
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
		applyOperationsWithRecording(changePackage.getOperations(), true);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.unicase.workspace.ProjectSpace#undoLastOperation()
	 */
	public void undoLastOperation() {
		if (!this.getOperations().isEmpty()) {
			List<AbstractOperation> operations = this.getOperations();
			AbstractOperation lastOperation = operations.get(operations.size() - 1);
			stopChangeRecording();
			lastOperation.reverse().apply(getProject());
			notifyOperationUndone(lastOperation);
			startChangeRecording();
			operations.remove(lastOperation);
		}
		updateDirtyState();
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
		this.getEventsFromComposite().add(event);
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

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.unicase.workspace.ProjectSpace#resolve(org.unicase.emfstore.esmodel.url.ModelElementUrlFragment)
	 */
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
	 * @see org.unicase.workspace.ProjectSpace#makeTransient()
	 */
	public void makeTransient() {
		if (initCompleted) {
			throw new IllegalAccessError("Project Space cannot be set to transient after init.");
		}
		isTransient = true;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @deprecated
	 * @see org.unicase.workspace.ProjectSpace#applyMergeResult(java.util.List)
	 */
	@Deprecated
	public void applyMergeResult(List<AbstractOperation> mergeResult, VersionSpec mergeTargetSpec)
		throws EmfStoreException {
		revert();
		update(mergeTargetSpec);

		applyOperations(mergeResult);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.unicase.workspace.ProjectSpace#addCommitObserver(org.unicase.workspace.observers.CommitObserver)
	 */
	public void addCommitObserver(CommitObserver observer) {
		this.commitObservers.add(observer);
	}

	/**
	 * {@inheritDoc}
	 */
	public void loginCompleted(Usersession session) {
		try {
			// stop all running file transfers before resuming, to prevent redundant conflicting uploads
			if (stopTransfers()) {
				resumeTransfers();
			}
			transmitProperties();
			// BEGIN SUPRESS CATCH EXCEPTION
		} catch (RuntimeException e) {
			// END SUPRESS CATCH EXCEPTION
			WorkspaceUtil.logException("Resuming file transfers or transmitting properties failed!", e);
		}
	}

	private void addFileTransfer(final PendingFileTransfer tmpTransfer, File selectedFile, boolean run)
		throws FileTransferException {
		// in case of an upload, isUpload has to evaluate to true and a selectedFile (file to be uploaded) must be
		// not-null
		if (tmpTransfer.isUpload() && selectedFile != null) {
			String uUID = EcoreUtil.generateUUID();
			tmpTransfer.setPreliminaryFileName(uUID);
			try {
				FileTransferUtil.copyUnversionedFileToCache(selectedFile, uUID, projectId);
			} catch (IOException e) {
				throw new FileTransferException("Could not copy the file " + selectedFile.getName()
					+ " to the cache. Please ensure that you have the rights to do this and try again!", e);
			}
		} else {
			tmpTransfer.setPreliminaryFileName(null);
		}
		for (PendingFileTransfer transfer : getPendingFileTransfers()) {
			if ((transfer.isUpload() == tmpTransfer.isUpload()
				&& transfer.getAttachmentId().equals(tmpTransfer.getAttachmentId()) && transfer.getFileVersion() == tmpTransfer
				.getFileVersion())) {
				throw new FileTransferException("File transfer already pending!");
			}
		}
		new UnicaseCommand() {
			@Override
			protected void doRun() {
				getPendingFileTransfers().add(tmpTransfer);
			}
		}.run();
		if (run) {
			startFileTransfer(tmpTransfer);
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @throws FileTransferException
	 * @see org.unicase.workspace.ProjectSpace#addFileTransfer(org.unicase.model.attachment.FileAttachment,
	 *      org.unicase.emfstore.filetransfer.FileInformation, boolean)
	 */
	public void addFileTransfer(FileInformation fileInformation, File selectedFile, boolean isUpload, boolean run)
		throws FileTransferException {
		addFileTransfer(FileTransferUtil.createPendingFileTransferFromFileInformation(fileInformation, isUpload),
			selectedFile, run);
	}

	/**
	 * Starts a file transfer job. Checks if the FileAttachment linked to it still exists, if not, the transfer is
	 * removed.
	 * 
	 * @param transfer the transfer
	 */
	private void startFileTransfer(PendingFileTransfer transfer) {
		if (transfer.isUpload()) {
			new FileUploadJob(transfer, this, true).schedule();
		} else {
			new FileDownloadJob(transfer, this, true).schedule();
		}
	}

	/**
	 * Resumes the pending file transfers.
	 */
	private void resumeTransfers() {
		ArrayList<Job> jobs = new ArrayList<Job>();
		Iterator<PendingFileTransfer> iterator = getPendingFileTransfers().listIterator();
		while (iterator.hasNext()) {
			PendingFileTransfer transfer = iterator.next();
			if (transfer.isUpload()) {
				jobs.add(new FileUploadJob(transfer, this, true));
			} else {
				jobs.add(new FileDownloadJob(transfer, this, true));
			}
			for (Job job : jobs) {
				job.schedule();
			}
		}

	}

	/**
	 * @return true if the pending file transfers could be stopped.
	 */
	private boolean stopTransfers() {
		Job[] jobs = Job.getJobManager().find(FileTransferJob.class);
		for (Job job : jobs) {
			if (!job.cancel()) {
				return false;
			}
		}
		return true;
	}

	/**
	 * {@inheritDoc}
	 */
	public void merge(PrimaryVersionSpec target, ConflictResolver conflictResolver) throws EmfStoreException {
		// merge the conflicts
		ChangePackage myCp = this.getLocalChangePackage(true);
		List<ChangePackage> theirCps = this.getChanges(getBaseVersion(), target);
		if (conflictResolver.resolveConflicts(project, theirCps, myCp, getBaseVersion(), target)) {

			// revert the local operations and apply all their operations
			this.revert();

			for (ChangePackage changePackage : theirCps) {
				applyOperations(changePackage.getOperations(), false);
			}

			// generate merge result and apply to local workspace
			List<AbstractOperation> acceptedMine = conflictResolver.getAcceptedMine();
			List<AbstractOperation> rejectedTheirs = conflictResolver.getRejectedTheirs();
			List<AbstractOperation> mergeResult = new ArrayList<AbstractOperation>();
			for (AbstractOperation operationToReverse : rejectedTheirs) {
				mergeResult.add(0, operationToReverse.reverse());
			}
			mergeResult.addAll(acceptedMine);

			applyOperations(mergeResult, true);

			this.setBaseVersion(target);

			saveProjectSpaceOnly();
		}

	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.unicase.workspace.ProjectSpace#getModifiedModelElementsCache()
	 */
	public ModifiedModelElementsCache getModifiedModelElementsCache() {
		return modifiedModelElementsCache;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @param operationListener
	 */
	public void addOperationListener(OperationListener operationListener) {
		this.operationListeners.add(operationListener);
	}

	private void notifyOperationUndone(AbstractOperation operation) {
		for (OperationListener operationListener : operationListeners) {
			operationListener.operationUnDone(operation);
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @param operationListner
	 */
	public void removeOperationListener(OperationListener operationListner) {
		this.operationListeners.remove(operationListner);

	}

	/**
	 * Notify the operation observer that an operation has just completed.
	 * 
	 * @param operation the operation
	 */
	void notifyOperationExecuted(AbstractOperation operation) {
		for (OperationListener operationListener : operationListeners) {
			operationListener.operationExecuted(operation);
		}
	}

	/**
	 * Add operation to the project spaces local operations.
	 * 
	 * @param operation the operation
	 */
	void addOperation(AbstractOperation operation) {
		this.getOperations().add(operation);
		updateDirtyState();

		// do not notify on composite start, wait until completion
		if (operation instanceof CompositeOperation) {
			// check of automatic composite if yes then continue
			if (((CompositeOperation) operation).getMainOperation() == null) {
				return;
			}
		}
		this.notifyOperationExecuted(operation);
	}

	/**
	 * Get the current nofitication recorder.
	 * 
	 * @return the recorder
	 */
	public NotificationRecorder getNotificationRecorder() {
		return this.changeTracker.getNotificationRecorder();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.unicase.workspace.ProjectSpace#beginCompositeOperation()
	 */
	public CompositeOperationHandle beginCompositeOperation() {
		return this.changeTracker.beginCompositeOperation();
	}

	/**
	 * Apply a list of operations to the project.
	 * 
	 * @param operations the list of operations
	 */
	public void applyOperations(List<AbstractOperation> operations) {
		applyOperations(operations, true);
	}

	/**
	 * Apply a list of operations to the project.
	 * 
	 * @param operations list of operations
	 * @param addOperation true if operation should be saved in project space.
	 */
	public void applyOperations(List<AbstractOperation> operations, boolean addOperation) {
		stopChangeRecording();
		for (AbstractOperation operation : operations) {
			operation.apply(getProject());
			if (addOperation) {
				addOperation(operation);
			}
		}
		startChangeRecording();
	}

	/**
	 * Apply a list of operations to the project. This method is used by {@link #importLocalChanges(String)}. It is
	 * possible to force import operations.
	 * 
	 * @param operations list of operations
	 * @param force if true, no exception is thrown if operation.apply failes
	 */
	public void applyOperationsWithRecording(List<AbstractOperation> operations, boolean force) {
		for (AbstractOperation operation : operations) {
			try {
				operation.apply(getProject());
			} catch (IllegalStateException e) {
				if (!force) {
					throw e;
				}
			}
		}
	}

	/**
	 * {@inheritDoc}
	 */
	public OrgUnitProperty getProperty(PropertyKey name) throws PropertyNotFoundException {
		return getProperty(name.toString());
	}

	/**
	 * getter for a string argument - see {@link #setProperty(OrgUnitProperty)}.
	 */
	private OrgUnitProperty getProperty(String name) throws PropertyNotFoundException {
		// sanity checks
		if (getUsersession() != null && getUsersession().getACUser() != null) {
			OrgUnitProperty orgUnitProperty = propertyMap.get(name);
			if (orgUnitProperty != null) {
				return orgUnitProperty;
			}
		}
		throw new PropertyNotFoundException();
	}

	/**
	 *{@inheritDoc}
	 */
	public void setProperty(OrgUnitProperty property) {
		// sanity checks
		if (getUsersession() != null && getUsersession().getACUser() != null) {
			try {
				OrgUnitProperty prop = getProperty(property.getName());
				prop.setValue(property.getValue());
			} catch (PropertyNotFoundException e) {
				getUsersession().getACUser().getProperties().add(property);
				propertyMap.put(property.getName(), property);
			}
			// the properties that have been altered are retained in a separate list
			for (OrgUnitProperty changedProperty : getUsersession().getChangedProperties()) {
				if (changedProperty.getName().equals(property.getName())) {
					changedProperty.setValue(property.getValue());
					WorkspaceManager.getInstance().getCurrentWorkspace().save();
					return;
				}
			}
			getUsersession().getChangedProperties().add(property);
			WorkspaceManager.getInstance().getCurrentWorkspace().save();
		}
	}

	/**
	 * {@inheritDoc}
	 */
	public boolean hasProperty(PropertyKey key) {
		return propertyMap.containsKey(key.toString());
	}

	private void transmitProperties() {
		ListIterator<OrgUnitProperty> iterator = getUsersession().getChangedProperties().listIterator();
		while (iterator.hasNext()) {
			try {
				WorkspaceManager.getInstance().getConnectionManager().transmitProperty(getUsersession().getSessionId(),
					iterator.next(), getUsersession().getACUser(), getProjectId());
				iterator.remove();
			} catch (EmfStoreException e) {
				WorkspaceUtil.logException("Transmission of properties failed with exception", e);
			}
		}
	}

	/**
	 *{@inheritDoc}
	 */
	public void removePendingFileUpload(String fileAttachmentId) {
		final Iterator<PendingFileTransfer> iterator = getPendingFileTransfers().listIterator();
		while (iterator.hasNext()) {
			final PendingFileTransfer transfer = iterator.next();
			if (transfer.isUpload() && transfer.getAttachmentId().getId().equals(fileAttachmentId)) {
				new UnicaseCommand() {
					@Override
					protected void doRun() {
						transfer.setAttachmentId(null);
						iterator.remove();
					}
				}.run();
				return;
			}
		}
		return;
	}

	/**
	 * {@inheritDoc}
	 */
	public boolean isTransient() {
		return isTransient;
	}

	/**
	 * {@inheritDoc}
	 */
	public boolean hasFileTransfer(FileInformation fileInformation, boolean upload) {
		PendingFileTransfer tmpTransfer = FileTransferUtil.createPendingFileTransferFromFileInformation(
			fileInformation, upload);
		for (PendingFileTransfer transfer : getPendingFileTransfers()) {
			if (transfer.isUpload() == upload && transfer.getAttachmentId().equals(tmpTransfer.getAttachmentId())
				&& transfer.getFileVersion() == tmpTransfer.getFileVersion()) {
				return true;
			}
		}
		return false;
	}

	/**
	 * {@inheritDoc}
	 */
	public String addFile(File file) throws FileTransferException {
		if (file.isDirectory()) {
			throw new FileTransferException("Can only upload files!");
		}
		// String fileIdentifier = EcoreUtil.generateUUID();
		ModelElementId identifier = MetamodelFactory.eINSTANCE.createModelElementId();
		// create pending file transfer
		PendingFileTransfer tmpTransfer = WorkspaceFactory.eINSTANCE.createPendingFileTransfer();
		tmpTransfer.setAttachmentId(identifier);
		tmpTransfer.setFileName(file.getName());
		tmpTransfer.setUpload(true);
		tmpTransfer.setFileVersion(-1);
		addFileTransfer(tmpTransfer, file, true);
		return identifier.getId();
	}

	/**
	 * {@inheritDoc}
	 */
	public FileRequestHandler getFile(String fileIdentifier) throws FileTransferException {
		// create model element id to identify file
		ModelElementId identifier = MetamodelFactory.eINSTANCE.createModelElementId();
		identifier.setId(fileIdentifier);
		// create pending file transfer
		PendingFileTransfer tmpTransfer = WorkspaceFactory.eINSTANCE.createPendingFileTransfer();
		tmpTransfer.setAttachmentId(identifier);
		tmpTransfer.setUpload(false);
		tmpTransfer.setFileVersion(0);
		try {
			FileTransferUtil.findCachedFile(tmpTransfer, projectId);
		} catch (FileNotFoundException e) {
			addFileTransfer(tmpTransfer, null, true);
		}
		FileRequestHandler fHandler = new FileRequestHandler(FileTransferUtil
			.createFileInformationFromPendingFileTransfer(tmpTransfer), this);
		return fHandler;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.unicase.workspace.ProjectSpace#commit()
	 */
	public PrimaryVersionSpec commit() throws EmfStoreException {
		LogMessage logMessage = VersioningFactory.eINSTANCE.createLogMessage();
		String commiter = "UNKOWN";
		if (this.getUsersession().getACUser() != null && this.getUsersession().getACUser().getName() != null) {
			commiter = this.getUsersession().getACUser().getName();
		}
		logMessage.setAuthor(commiter);
		logMessage.setClientDate(new Date());
		logMessage.setMessage("");
		return commit(logMessage);
	}
} // ProjectContainerImpl
