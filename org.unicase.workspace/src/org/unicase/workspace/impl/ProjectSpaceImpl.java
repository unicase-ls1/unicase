/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.workspace.impl;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.notify.impl.NotificationImpl;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
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
import org.unicase.emfstore.esmodel.versioning.ChangePackage;
import org.unicase.emfstore.esmodel.versioning.LogMessage;
import org.unicase.emfstore.esmodel.versioning.PrimaryVersionSpec;
import org.unicase.emfstore.esmodel.versioning.TagVersionSpec;
import org.unicase.emfstore.esmodel.versioning.VersionSpec;
import org.unicase.emfstore.esmodel.versioning.VersioningFactory;
import org.unicase.emfstore.esmodel.versioning.events.Event;
import org.unicase.emfstore.esmodel.versioning.operations.AbstractOperation;
import org.unicase.emfstore.esmodel.versioning.operations.AttributeOperation;
import org.unicase.emfstore.esmodel.versioning.operations.CreateDeleteOperation;
import org.unicase.emfstore.esmodel.versioning.operations.DiagramLayoutOperation;
import org.unicase.emfstore.esmodel.versioning.operations.MultiAttributeOperation;
import org.unicase.emfstore.esmodel.versioning.operations.MultiReferenceMoveOperation;
import org.unicase.emfstore.esmodel.versioning.operations.MultiReferenceOperation;
import org.unicase.emfstore.esmodel.versioning.operations.OperationsFactory;
import org.unicase.emfstore.esmodel.versioning.operations.ReferenceOperation;
import org.unicase.emfstore.esmodel.versioning.operations.SingleReferenceOperation;
import org.unicase.emfstore.esmodel.versioning.operations.util.OperationsCannonizer;
import org.unicase.emfstore.exceptions.BaseVersionOutdatedException;
import org.unicase.emfstore.exceptions.EmfStoreException;
import org.unicase.model.ModelElement;
import org.unicase.model.ModelElementId;
import org.unicase.model.Project;
import org.unicase.model.diagram.DiagramFactory;
import org.unicase.model.diagram.DiagramPackage;
import org.unicase.model.impl.IdentifiableElementImpl;
import org.unicase.model.util.ModelValidationHelper;
import org.unicase.model.util.ProjectChangeObserver;
import org.unicase.workspace.Configuration;
import org.unicase.workspace.OperationComposite;
import org.unicase.workspace.ProjectSpace;
import org.unicase.workspace.Usersession;
import org.unicase.workspace.WorkspaceFactory;
import org.unicase.workspace.WorkspaceManager;
import org.unicase.workspace.WorkspacePackage;
import org.unicase.workspace.connectionmanager.ConnectionManager;
import org.unicase.workspace.exceptions.ChangeConflictException;
import org.unicase.workspace.exceptions.IllegalProjectSpaceStateException;
import org.unicase.workspace.exceptions.NoChangesOnServerException;
import org.unicase.workspace.exceptions.NoLocalChangesException;
import org.unicase.workspace.util.CommitObserver;
import org.unicase.workspace.util.UpdateObserver;
import org.unicase.workspace.util.WorkspaceUtil;

/*
 * <!-- begin-user-doc --> An implementation of the model object ' <em><b>Project Container</b></em>'.
 * @implements ProjectChangeObserver <!-- end-user-doc --> <p> The following features are implemented: <ul> <li>{@link
 * org.unicase.workspace.impl.ProjectSpaceImpl#getProject <em>Project</em>}</li> <li>{@link
 * org.unicase.workspace.impl.ProjectSpaceImpl#getProjectId <em>Project Id</em>}</li> <li>{@link
 * org.unicase.workspace.impl.ProjectSpaceImpl#getProjectName <em>Project Name</em>}</li> <li>{@link
 * org.unicase.workspace.impl.ProjectSpaceImpl#getProjectDescription <em>Project Description</em>}</li> <li>{@link
 * org.unicase.workspace.impl.ProjectSpaceImpl#getEvents <em>Events</em>}</li> <li>{@link
 * org.unicase.workspace.impl.ProjectSpaceImpl#getUsersession <em>Usersession</em>}</li> <li>{@link
 * org.unicase.workspace.impl.ProjectSpaceImpl#getLastUpdated <em>Last Updated</em>}</li> <li>{@link
 * org.unicase.workspace.impl.ProjectSpaceImpl#getBaseVersion <em>Base Version</em>}</li> <li>{@link
 * org.unicase.workspace.impl.ProjectSpaceImpl#getResourceCount <em>Resource Count</em>}</li> <li>{@link
 * org.unicase.workspace.impl.ProjectSpaceImpl#isDirty <em>Dirty</em>}</li> <li>{@link
 * org.unicase.workspace.impl.ProjectSpaceImpl#getOldLogMessages <em>Old Log Messages</em>}</li> <li>{@link
 * org.unicase.workspace.impl.ProjectSpaceImpl#getLocalOperations <em>Local Operations</em>}</li> </ul> </p>
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

	private boolean isRecording;

	private CreateDeleteOperation deleteOperation;

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

		stopChangeRecording();

		// check if there are any changes
		if (this.getOperations().size() == 0) {
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
			startChangeRecording();
			return this.getBaseVersion();
		}

		PrimaryVersionSpec newBaseVersion;
		try {
			newBaseVersion = connectionManager.createVersion(getUsersession().getSessionId(), getProjectId(),
				getBaseVersion(), changePackage, logMessage);
		} catch (EmfStoreException e) {
			startChangeRecording();
			throw e;
		}

		setBaseVersion(newBaseVersion);
		getOperations().clear();
		getEvents().clear();

		saveProjectSpaceOnly();

		startChangeRecording();

		return newBaseVersion;
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
		stopChangeRecording();

		List<ChangePackage> changes = new ArrayList<ChangePackage>();
		try {

			changes = connectionManager.getChanges(getUsersession().getSessionId(), projectId, baseVersion,
				resolvedVersion);
		} catch (EmfStoreException e) {
			startChangeRecording();
			throw e;
		}

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
		final List<ChangePackage> cps = changes;
		for (ChangePackage change : cps) {
			change.apply(getProject());
		}

		setBaseVersion(resolvedVersion);
		saveResourceSet();
		if (!isRecording) {
			startChangeRecording();
		}
		return resolvedVersion;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public void revert() {
		stopChangeRecording();

		// revert all local changes
		ChangePackage changePackage = VersioningFactory.eINSTANCE.createChangePackage();
		changePackage.getOperations().addAll(getOperations());
		changePackage.cannonize();
		changePackage.reverse().apply(project);

		this.getOperations().clear();

		startChangeRecording();
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
		setDirty(getOperations().size() > 0);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.unicase.workspace.ProjectSpace#init()
	 * @generated NOT
	 */
	public void init() {
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
			return new Integer(getResourceCount());
		case WorkspacePackage.PROJECT_SPACE__DIRTY:
			return isDirty() ? Boolean.TRUE : Boolean.FALSE;
		case WorkspacePackage.PROJECT_SPACE__OLD_LOG_MESSAGES:
			return getOldLogMessages();
		case WorkspacePackage.PROJECT_SPACE__LOCAL_OPERATIONS:
			if (resolve)
				return getLocalOperations();
			return basicGetLocalOperations();
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
			setResourceCount(((Integer) newValue).intValue());
			return;
		case WorkspacePackage.PROJECT_SPACE__DIRTY:
			setDirty(((Boolean) newValue).booleanValue());
			return;
		case WorkspacePackage.PROJECT_SPACE__OLD_LOG_MESSAGES:
			getOldLogMessages().clear();
			getOldLogMessages().addAll((Collection<? extends String>) newValue);
			return;
		case WorkspacePackage.PROJECT_SPACE__LOCAL_OPERATIONS:
			setLocalOperations((OperationComposite) newValue);
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
	 * @see org.unicase.workspace.ProjectSpace#shareProject(org.unicase.workspace.Usersession)
	 * @generated NOT
	 */
	public void shareProject(Usersession usersession) throws EmfStoreException {
		this.stopChangeRecording();
		this.setUsersession(usersession);
		LogMessage logMessage = VersioningFactory.eINSTANCE.createLogMessage();
		logMessage.setAuthor(usersession.getUsername());
		logMessage.setClientDate(new Date());
		logMessage.setMessage("Initial commit");
		ProjectInfo createdProject = WorkspaceManager.getInstance().getConnectionManager().createProject(
			usersession.getSessionId(), this.getProjectName(), this.getProjectDescription(), logMessage,
			this.getProject());
		this.setBaseVersion(createdProject.getVersion());
		this.setLastUpdated(new Date());
		this.setProjectId(createdProject.getProjectId());
		this.getOperations().clear();
		this.saveProjectSpaceOnly();
		this.startChangeRecording();
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
		TransactionalEditingDomain domain = WorkspaceManager.getInstance().getCurrentWorkspace().getEditingDomain();
		domain.getCommandStack().execute(new RecordingCommand(domain) {
			@Override
			protected void doExecute() {
				Resource oldResource = modelElement.eResource();
				String oldFileName = Configuration.getWorkspaceDirectory() + "ps-" + getIdentifier()
					+ File.separatorChar + (getResourceCount() - 1) + ".ucf";
				// FIXME MK check if file exists
				if (new File(oldFileName).length() > Configuration.getMaxResourceFileSizeOnExpand()) {
					String newfileName = Configuration.getWorkspaceDirectory() + "ps-" + getIdentifier()
						+ File.separatorChar + getResourceCount() + ".ucf";
					URI fileURI = URI.createFileURI(newfileName);
					oldResource.getResourceSet().createResource(fileURI);
					setResourceCount(getResourceCount() + 1);
				}
			}
		});

	}

	/**
	 * Create all neccessary operations for the notification.
	 * 
	 * @param notification the notification
	 * @param modelElement the model element the triggered the notification
	 * @generated NOT
	 */
	private void createOperations(final Notification notification, ModelElement modelElement) {

		Object feature = notification.getFeature();
		Object newValue = notification.getNewValue();
		Object oldValue = notification.getOldValue();
		if (notification.getEventType() == Notification.SET) {
			if (feature instanceof EAttribute) {
				// Simple attribute set
				EAttribute attribute = (EAttribute) feature;
				if (attribute.isTransient()) {
					return;
				}
				DiagramPackage diagramPackage = DiagramFactory.eINSTANCE.getDiagramPackage();
				if (attribute.getName().equals(diagramPackage.getMEDiagram_DiagramLayout().getName())
					&& diagramPackage.getMEDiagram().isInstance(modelElement)) {

					DiagramLayoutOperation createDiagramLayoutOperation = OperationsFactory.eINSTANCE
						.createDiagramLayoutOperation();
					createDiagramLayoutOperation.setFeatureName(attribute.getName());
					createDiagramLayoutOperation.setModelElementId((ModelElementId) EcoreUtil.copy(modelElement
						.getModelElementId()));
					createDiagramLayoutOperation.setNewValue(newValue);
					createDiagramLayoutOperation.setOldValue(oldValue);
					this.getOperations().add(createDiagramLayoutOperation);
					return;

				} else {
					AttributeOperation attributeOperation = createAttributeOperation(notification, feature, newValue,
						oldValue);
					this.getOperations().add(attributeOperation);
					return;
				}
			} else if (feature instanceof EReference) {
				if (((EReference) feature).isTransient()) {
					return;
				}
				handleSetReference(notification, (EReference) feature, (ModelElement) newValue, (ModelElement) oldValue);
				return;
			}
			throw new IllegalStateException();
		}

		if (notification.getEventType() == Notification.ADD) {
			if (feature instanceof EReference) {
				handleEReference((EReference) feature, (ModelElement) newValue, notification, true);
			} else if (feature instanceof EAttribute) {
				EAttribute attribute = (EAttribute) feature;
				if (attribute.isTransient()) {
					return;
				}
				MultiAttributeOperation multiAttributeOperation = createMultiAttributeOperation(notification, newValue,
					attribute, true);
				this.getOperations().add(multiAttributeOperation);
				return;
			} else {
				throw new IllegalStateException();
			}
		}

		if (notification.getEventType() == Notification.REMOVE) {
			if (feature instanceof EReference) {
				handleEReference((EReference) feature, (ModelElement) oldValue, notification, false);
			} else if (feature instanceof EAttribute) {
				EAttribute attribute = (EAttribute) feature;
				if (attribute.isTransient()) {
					return;
				}
				MultiAttributeOperation multiAttributeOperation = createMultiAttributeOperation(notification, oldValue,
					attribute, false);
				this.getOperations().add(multiAttributeOperation);
				return;
			} else {
				throw new IllegalStateException();
			}
			return;
		}

		if (notification.getEventType() == Notification.ADD_MANY) {
			// FIXME MK: implement
			throw new UnsupportedOperationException();
		}
		if (notification.getEventType() == Notification.REMOVE_MANY) {
			// FIXME MK: implement
			throw new UnsupportedOperationException();
		}
		if (notification.getEventType() == Notification.UNSET) {
			// FIXME MK: how can I trigger this
			throw new UnsupportedOperationException();
		}
		if (notification.getEventType() == Notification.MOVE) {
			// FIXME MK: what about move many
			if (feature instanceof EReference) {
				EReference reference = (EReference) feature;
				if (reference.isTransient()) {
					return;
				}
				MultiReferenceMoveOperation multiReferenceMoveOperation = OperationsFactory.eINSTANCE
					.createMultiReferenceMoveOperation();
				multiReferenceMoveOperation.setFeatureName(reference.getName());
				multiReferenceMoveOperation.setModelElementId(((ModelElement) notification.getNotifier())
					.getModelElementId());
				multiReferenceMoveOperation.setReferencedModelElementId(((ModelElement) notification.getNewValue())
					.getModelElementId());
				multiReferenceMoveOperation.setNewIndex(notification.getPosition());
				multiReferenceMoveOperation.setOldIndex((Integer) oldValue);
				this.getOperations().add(multiReferenceMoveOperation);

			} else {
				throw new IllegalStateException();
			}
		}

	}

	private void handleSetReference(Notification notification, EReference reference, ModelElement newValue,
		ModelElement oldValue) {

		if (reference.isTransient()) {
			return;
		}
		// handle bidirectional notifications
		if (reference.getEOpposite() != null) {
			if (notification instanceof NotificationImpl) {
				Field declaredField;
				try {
					declaredField = NotificationImpl.class.getDeclaredField("next");
					declaredField.setAccessible(true);
					Object object = declaredField.get(notification);
					Notification nextNotification = (Notification) object;
					if (nextNotification != null && nextNotification.getFeature() == reference.getEOpposite()) {
						if (newValue == null && nextNotification.getNotifier() == oldValue) {
							// skip this
							return;
						} else if (oldValue == null && nextNotification.getNotifier() == newValue) {
							// skip this
							return;
						}
					}

				} catch (SecurityException e) {
					// MK Auto-generated catch block
					e.printStackTrace();
				} catch (NoSuchFieldException e) {
					// MK Auto-generated catch block
					e.printStackTrace();
				} catch (IllegalArgumentException e) {
					// MK Auto-generated catch block
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					// MK Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

		// single reference set
		SingleReferenceOperation singleReferenceOperation = createSingleReferenceOperation(notification, oldValue,
			reference, newValue);
		this.getOperations().add(singleReferenceOperation);
	}

	private MultiAttributeOperation createMultiAttributeOperation(Notification notification, Object newValue,
		EAttribute attribute, boolean isAdd) {
		MultiAttributeOperation multiAttributeOperation = OperationsFactory.eINSTANCE.createMultiAttributeOperation();
		multiAttributeOperation.setAdd(isAdd);
		multiAttributeOperation.setFeatureName(attribute.getName());
		multiAttributeOperation.setIndex(notification.getPosition());
		multiAttributeOperation.setModelElementId(((ModelElement) notification.getNotifier()).getModelElementId());
		multiAttributeOperation.getValues().add(newValue);
		return multiAttributeOperation;
	}

	private AttributeOperation createAttributeOperation(Notification notification, Object feature, Object newValue,
		Object oldValue) {
		EAttribute attribute = (EAttribute) feature;
		AttributeOperation attributeOperation = OperationsFactory.eINSTANCE.createAttributeOperation();
		attributeOperation.setFeatureName(attribute.getName());
		ModelElement modelElement = (ModelElement) notification.getNotifier();
		attributeOperation.setModelElementId((ModelElementId) EcoreUtil.copy(modelElement.getModelElementId()));
		attributeOperation.setNewValue(newValue);
		attributeOperation.setOldValue(oldValue);
		return attributeOperation;
	}

	private void handleEReference(EReference reference, ModelElement modelElement, Notification notification,
		boolean isAdd) {

		if (reference.isTransient()) {
			return;
		}
		if (reference.isMany()) {
			// handle bidirectional notifications
			if (reference.getEOpposite() != null) {
				if (notification instanceof NotificationImpl) {
					Field declaredField;
					try {
						declaredField = NotificationImpl.class.getDeclaredField("next");
						declaredField.setAccessible(true);
						Object object = declaredField.get(notification);
						Notification nextNotification = (Notification) object;
						if (nextNotification != null && nextNotification.getFeature() == reference.getEOpposite()
							&& nextNotification.getNotifier() == modelElement) {
							// skip this notification
							return;
						}
						// exception handling will only log error since this is
						// not fatal if it fails, it just results in redundant
						// operations being created.
					} catch (SecurityException e) {
						WorkspaceUtil.logException("Access to next field of notification failed.", e);
					} catch (NoSuchFieldException e) {
						WorkspaceUtil.logException("Access to next field of notification failed.", e);
					} catch (IllegalArgumentException e) {
						WorkspaceUtil.logException("Access to next field of notification failed.", e);
					} catch (IllegalAccessException e) {
						WorkspaceUtil.logException("Access to next field of notification failed.", e);
					}
				}
			}

			// element was added/removed to/from a reference feature
			ModelElement parent = (ModelElement) notification.getNotifier();

			MultiReferenceOperation multiReferenceOperation = createMultiReferenceOperation(notification, reference,
				modelElement, parent, isAdd);
			int index = getOperations().size();
			// check if this operation refers to a previous delete
			List<AbstractOperation> operations = this.getOperations();
			for (int i = operations.size() - 1; i >= 0; i--) {
				AbstractOperation lastOperation = operations.get(i);
				if (!isRelated(modelElement, isAdd, parent, lastOperation)) {
					index = i + 1;
					break;
				} else {
					index = i;
				}
			}

			operations.add(index, multiReferenceOperation);
		} else {
			// should never hit here
			throw new IllegalStateException();
		}
	}

	private boolean isRelated(ModelElement modelElement, boolean isAdd, ModelElement parent,
		AbstractOperation lastOperation) {
		if (!isAdd && lastOperation instanceof CreateDeleteOperation
			&& ((CreateDeleteOperation) lastOperation).isDelete()) {
			if (lastOperation.getModelElementId().equals(parent.getModelElementId())
				|| lastOperation.getModelElementId().equals(modelElement.getModelElementId())) {
				return true;
			}
		}
		return false;
	}

	private MultiReferenceOperation createMultiReferenceOperation(Notification notification, EReference reference,
		ModelElement modelElement, ModelElement parent, boolean isAdd) {
		MultiReferenceOperation multiReferenceOperation = OperationsFactory.eINSTANCE.createMultiReferenceOperation();
		setBidirectionalInfos(reference, multiReferenceOperation);
		multiReferenceOperation.setFeatureName(reference.getName());
		multiReferenceOperation.setAdd(isAdd);
		multiReferenceOperation.setIndex(notification.getPosition());
		multiReferenceOperation.getReferencedModelElements().add(modelElement.getModelElementId());
		multiReferenceOperation.setModelElementId(parent.getModelElementId());
		return multiReferenceOperation;
	}

	private SingleReferenceOperation createSingleReferenceOperation(Notification notification, Object oldValue,
		EReference reference, ModelElement newValueME) {
		SingleReferenceOperation singleReferenceOperation = OperationsFactory.eINSTANCE
			.createSingleReferenceOperation();
		singleReferenceOperation.setFeatureName(reference.getName());
		setBidirectionalInfos(reference, singleReferenceOperation);

		if (oldValue != null) {
			singleReferenceOperation.setOldValue(((ModelElement) oldValue).getModelElementId());
		}
		if (newValueME != null) {
			singleReferenceOperation.setNewValue(newValueME.getModelElementId());
		}
		singleReferenceOperation.setModelElementId(((ModelElement) notification.getNotifier()).getModelElementId());
		return singleReferenceOperation;
	}

	private void setBidirectionalInfos(EReference reference, ReferenceOperation referenceOperation) {
		if (reference.getEOpposite() != null) {
			referenceOperation.setBidirectional(true);
			referenceOperation.setOppositeFeatureName(reference.getEOpposite().getName());
		} else {
			referenceOperation.setBidirectional(false);
		}
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
		createDeleteOperation.setModelElementId((ModelElementId) EcoreUtil.copy(modelElement.getModelElementId()));
		return createDeleteOperation;
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
			// filter create operation if a predeccessing delete is already
			// present
			List<AbstractOperation> operations = this.getOperations();
			for (int i = 0; i < operations.size(); i++) {
				AbstractOperation abstractOperation = operations.get(i);
				if (abstractOperation instanceof CreateDeleteOperation) {
					CreateDeleteOperation operation = (CreateDeleteOperation) abstractOperation;
					if (operation.isDelete() && operation.getModelElementId().equals(modelElement.getModelElementId())) {
						operations.remove(operation);
						return;
					}
				}
			}
			operations.add(createCreateDeleteOperation(modelElement, false));
			saveProjectSpaceOnly();
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.unicase.model.util.ProjectChangeObserver#modelElementRemoved(org.unicase.model.Project,
	 *      org.unicase.model.ModelElement)
	 */
	public void modelElementRemoved(Project project, ModelElement modelElement) {
		// MK clean resources from deleted model elements
		// if (isRecording) {
		// CreateDeleteOperation createDeleteOperation = createCreateDeleteOperation(modelElement, true);
		// this.getOperations().add(createDeleteOperation);
		// saveProjectSpaceOnly();
		// }
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.unicase.model.util.ProjectChangeObserver#notify(org.eclipse.emf.common.notify.Notification,
	 *      org.unicase.model.Project, org.unicase.model.ModelElement)
	 */
	public void notify(Notification notification, Project project, ModelElement modelElement) {
		if (isRecording) {
			createOperations(notification, modelElement);
			OperationsCannonizer.cannonize(getOperations());
			saveProjectSpaceOnly();
			save(modelElement);
			setDirty(getOperations().size() > 0);
		}
	}

	private void save(ModelElement modelElement) {
		Resource resource = modelElement.eResource();
		if (resource == null) {
			return;
		}
		try {
			resource.save(Configuration.getResourceSaveOptions());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
		stopChangeRecording();
		ResourceSetImpl resourceSet = new ResourceSetImpl();
		Resource resource = resourceSet.getResource(URI.createFileURI(fileName), true);
		EList<EObject> directContents = resource.getContents();
		// sanity check

		if (directContents.size() != 1 && (!(directContents.get(0) instanceof ChangePackage))) {
			throw new IOException("File is corrupt, does not contain Changes.");
		}

		ChangePackage changePackage = (ChangePackage) directContents.get(0);
		changePackage.apply(getProject());
		this.getOperations().addAll(changePackage.getOperations());
		saveResourceSet();
		startChangeRecording();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.unicase.workspace.ProjectSpace#undoLastOperation()
	 */
	public void undoLastOperation() {
		stopChangeRecording();
		List<AbstractOperation> operations = this.getOperations();
		AbstractOperation lastOperation = operations.get(operations.size() - 1);
		lastOperation.reverse().apply(getProject());
		operations.remove(lastOperation);
		saveResourceSet();
		startChangeRecording();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.unicase.workspace.ProjectSpace#addEvent(org.unicase.emfstore.esmodel.versioning.events.Event)
	 */
	public void addEvent(Event event) {
		this.getEvents().add(event);
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

	public void modelElementDeleteCompleted(ModelElement modelElement) {
		if (isRecording) {
			deleteOperation.setDelete(true);
			deleteOperation.setModelElement(modelElement);
			deleteOperation.setModelElementId(modelElement.getModelElementId());
			this.getOperations().add(deleteOperation);

			deleteOperation = null;
			saveProjectSpaceOnly();
			Resource resource = modelElement.eResource();
			if (resource != null) {
				resource.getContents().remove(modelElement);
				saveResource(resource);
			}
		}
	}

	public void modelElementDeleteStarted(ModelElement modelElement) {
		if (isRecording) {
			this.deleteOperation = OperationsFactory.eINSTANCE.createCreateDeleteOperation();
		}
		// MK: implement recording to subOperations of deleteoperation
	}

} // ProjectContainerImpl
