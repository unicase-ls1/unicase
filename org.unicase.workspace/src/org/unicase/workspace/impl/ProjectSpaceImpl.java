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
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.naming.NoInitialContextException;

import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.change.ChangeDescription;
import org.eclipse.emf.ecore.change.util.ChangeRecorder;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EDataTypeUniqueEList;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.emf.ecore.xmi.DanglingHREFException;
import org.eclipse.emf.transaction.NotificationFilter;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.ResourceSetChangeEvent;
import org.eclipse.emf.transaction.ResourceSetListener;
import org.eclipse.emf.transaction.RollbackException;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.unicase.emfstore.esmodel.EsmodelFactory;
import org.unicase.emfstore.esmodel.ProjectId;
import org.unicase.emfstore.esmodel.ProjectInfo;
import org.unicase.emfstore.esmodel.versioning.ChangePackage;
import org.unicase.emfstore.esmodel.versioning.LogMessage;
import org.unicase.emfstore.esmodel.versioning.PrimaryVersionSpec;
import org.unicase.emfstore.esmodel.versioning.VersionSpec;
import org.unicase.emfstore.esmodel.versioning.VersioningFactory;
import org.unicase.emfstore.esmodel.versioning.operations.AbstractOperation;
import org.unicase.emfstore.esmodel.versioning.operations.AttributeOperation;
import org.unicase.emfstore.esmodel.versioning.operations.CreateDeleteOperation;
import org.unicase.emfstore.esmodel.versioning.operations.MultiAttributeOperation;
import org.unicase.emfstore.esmodel.versioning.operations.MultiReferenceMoveOperation;
import org.unicase.emfstore.esmodel.versioning.operations.MultiReferenceOperation;
import org.unicase.emfstore.esmodel.versioning.operations.OperationsFactory;
import org.unicase.emfstore.esmodel.versioning.operations.SingleReferenceOperation;
import org.unicase.emfstore.exceptions.BaseVersionOutdatedException;
import org.unicase.emfstore.exceptions.EmfStoreException;
import org.unicase.model.ModelElement;
import org.unicase.model.ModelElementId;
import org.unicase.model.Project;
import org.unicase.model.impl.IdentifiableElementImpl;
import org.unicase.model.util.ModelUtil;
import org.unicase.model.util.ModelValidationHelper;
import org.unicase.model.util.ProjectChangeNotifier;
import org.unicase.model.util.ProjectChangeObserver;
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
 * @implements ResourceSetListener <!-- end-user-doc -->
 *             <p>
 *             The following features are implemented:
 *             <ul>
 *             <li>
 *             {@link org.unicase.workspace.impl.ProjectSpaceImpl#getProject
 *             <em>Project</em>}</li>
 *             <li>
 *             {@link org.unicase.workspace.impl.ProjectSpaceImpl#getProjectId
 *             <em>Project Id</em>}</li>
 *             <li>
 *             {@link org.unicase.workspace.impl.ProjectSpaceImpl#getProjectName
 *             <em>Project Name</em>}</li>
 *             <li>
 *             {@link org.unicase.workspace.impl.ProjectSpaceImpl#getProjectDescription
 *             <em>Project Description</em>}</li>
 *             <li>
 *             {@link org.unicase.workspace.impl.ProjectSpaceImpl#getLocalChanges
 *             <em>Local Changes</em>}</li>
 *             <li>
 *             {@link org.unicase.workspace.impl.ProjectSpaceImpl#getOperations
 *             <em>Operations</em>}</li>
 *             <li>
 *             {@link org.unicase.workspace.impl.ProjectSpaceImpl#getUsersession
 *             <em>Usersession</em>}</li>
 *             <li>
 *             {@link org.unicase.workspace.impl.ProjectSpaceImpl#getLastUpdated
 *             <em>Last Updated</em>}</li>
 *             <li>
 *             {@link org.unicase.workspace.impl.ProjectSpaceImpl#getBaseVersion
 *             <em>Base Version</em>}</li>
 *             <li>
 *             {@link org.unicase.workspace.impl.ProjectSpaceImpl#getResourceCount
 *             <em>Resource Count</em>}</li>
 *             <li>{@link org.unicase.workspace.impl.ProjectSpaceImpl#isDirty
 *             <em>Dirty</em>}</li>
 *             <li>
 *             {@link org.unicase.workspace.impl.ProjectSpaceImpl#getOldLogMessages
 *             <em>Old Log Messages</em>}</li>
 *             </ul>
 *             </p>
 * 
 * @generated
 */
public class ProjectSpaceImpl extends IdentifiableElementImpl implements
		ProjectSpace, ResourceSetListener, ProjectChangeObserver {

	/**
	 * @generated NOT
	 */
	private ChangeRecorder changeRecorder;

	public List<AbstractOperation> myOperations;

	/**
	 * The cached value of the '{@link #getProject() <em>Project</em>}'
	 * containment reference. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getProject()
	 * @generated
	 * @ordered
	 */
	protected Project project;

	/**
	 * The cached value of the '{@link #getProjectId() <em>Project Id</em>}'
	 * containment reference. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getProjectId()
	 * @generated
	 * @ordered
	 */
	protected ProjectId projectId;

	/**
	 * The default value of the '{@link #getProjectName() <em>Project Name</em>}
	 * ' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getProjectName()
	 * @generated
	 * @ordered
	 */
	protected static final String PROJECT_NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getProjectName() <em>Project Name</em>}'
	 * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getProjectName()
	 * @generated
	 * @ordered
	 */
	protected String projectName = PROJECT_NAME_EDEFAULT;

	/**
	 * The default value of the '{@link #getProjectDescription()
	 * <em>Project Description</em>}' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @see #getProjectDescription()
	 * @generated
	 * @ordered
	 */
	protected static final String PROJECT_DESCRIPTION_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getProjectDescription()
	 * <em>Project Description</em>}' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @see #getProjectDescription()
	 * @generated
	 * @ordered
	 */
	protected String projectDescription = PROJECT_DESCRIPTION_EDEFAULT;

	/**
	 * The cached value of the '{@link #getLocalChanges()
	 * <em>Local Changes</em>}' containment reference. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getLocalChanges()
	 * @generated
	 * @ordered
	 */
	protected ChangeDescription localChanges;

	/**
	 * The cached value of the '{@link #getOperations() <em>Operations</em>}'
	 * containment reference list. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getOperations()
	 * @generated
	 * @ordered
	 */
	protected EList<AbstractOperation> operations;

	/**
	 * The cached value of the '{@link #getUsersession() <em>Usersession</em>}'
	 * reference. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getUsersession()
	 * @generated
	 * @ordered
	 */
	protected Usersession usersession;

	/**
	 * The default value of the '{@link #getLastUpdated() <em>Last Updated</em>}
	 * ' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getLastUpdated()
	 * @generated
	 * @ordered
	 */
	protected static final Date LAST_UPDATED_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getLastUpdated() <em>Last Updated</em>}'
	 * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getLastUpdated()
	 * @generated
	 * @ordered
	 */
	protected Date lastUpdated = LAST_UPDATED_EDEFAULT;

	/**
	 * The cached value of the '{@link #getBaseVersion() <em>Base Version</em>}'
	 * containment reference. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getBaseVersion()
	 * @generated
	 * @ordered
	 */
	protected PrimaryVersionSpec baseVersion;

	/**
	 * The default value of the '{@link #getResourceCount()
	 * <em>Resource Count</em>}' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @see #getResourceCount()
	 * @generated
	 * @ordered
	 */
	protected static final int RESOURCE_COUNT_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getResourceCount()
	 * <em>Resource Count</em>}' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @see #getResourceCount()
	 * @generated
	 * @ordered
	 */
	protected int resourceCount = RESOURCE_COUNT_EDEFAULT;

	/**
	 * The default value of the '{@link #isDirty() <em>Dirty</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #isDirty()
	 * @generated
	 * @ordered
	 */
	protected static final boolean DIRTY_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isDirty() <em>Dirty</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #isDirty()
	 * @generated
	 * @ordered
	 */
	protected boolean dirty = DIRTY_EDEFAULT;

	/**
	 * The cached value of the '{@link #getOldLogMessages()
	 * <em>Old Log Messages</em>}' attribute list. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @see #getOldLogMessages()
	 * @generated
	 * @ordered
	 */
	protected EList<String> oldLogMessages;

	private boolean isRecording;

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
	 * 
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
	 * 
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
	 * 
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
			eNotify(new ENotificationImpl(this, Notification.SET,
					WorkspacePackage.PROJECT_SPACE__PROJECT_NAME,
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
			eNotify(new ENotificationImpl(this, Notification.SET,
					WorkspacePackage.PROJECT_SPACE__PROJECT_DESCRIPTION,
					oldProjectDescription, projectDescription));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
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
	 * 
	 * @generated
	 */
	public ChangeDescription basicGetLocalChanges() {
		return localChanges;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
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
	 * 
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
	 * 
	 * @generated
	 */
	public EList<AbstractOperation> getOperations() {
		if (operations == null) {
			operations = new EObjectContainmentEList.Resolving<AbstractOperation>(
					AbstractOperation.class, this,
					WorkspacePackage.PROJECT_SPACE__OPERATIONS);
		}
		return operations;
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
							WorkspacePackage.PROJECT_SPACE__USERSESSION,
							oldUsersession, usersession));
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
			eNotify(new ENotificationImpl(this, Notification.SET,
					WorkspacePackage.PROJECT_SPACE__USERSESSION,
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
			eNotify(new ENotificationImpl(this, Notification.SET,
					WorkspacePackage.PROJECT_SPACE__LAST_UPDATED,
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
	 * 
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
			eNotify(new ENotificationImpl(this, Notification.SET,
					WorkspacePackage.PROJECT_SPACE__RESOURCE_COUNT,
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
			eNotify(new ENotificationImpl(this, Notification.SET,
					WorkspacePackage.PROJECT_SPACE__DIRTY, oldDirty, dirty));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EList<String> getOldLogMessages() {
		if (oldLogMessages == null) {
			oldLogMessages = new EDataTypeUniqueEList<String>(String.class,
					this, WorkspacePackage.PROJECT_SPACE__OLD_LOG_MESSAGES);
		}
		return oldLogMessages;
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

		// stop notifications
		for (ModelElement modelElement : project.getAllModelElements()) {
			modelElement.eSetDeliver(false);
		}

		final ConnectionManager connectionManager = WorkspaceManager
				.getInstance().getConnectionManager();

		ChangePackage changePackage = VersioningFactory.eINSTANCE
				.createChangePackage();
		changePackage.init(getProject(), getLocalChanges());
		changePackage.getOperations().addAll(this.myOperations);
		// changePackage.cannonize();

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
		this.myOperations = new ArrayList<AbstractOperation>();
		setBaseVersion(newBaseVersion);

		saveResources(true);

		// save starts recording ...
		// startChangeRecording();

		// start notifications
		for (ModelElement modelElement : project.getAllModelElements()) {
			modelElement.eSetDeliver(true);
		}
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
		// getLocalChanges().apply();
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
		saveResources(false);
		startChangeRecording();
	}

	/**
	 * Stops current recording of changes and adds recorded changes to this
	 * project spaces changes.
	 * 
	 * @generated NOT
	 */
	private void stopChangeRecording() {
		this.isRecording = false;
		this.setLocalChanges(this.changeRecorder.endRecording());
	}

	/**
	 * Starts change recording on this workspace, resumes previous recordings if
	 * there are any.
	 * 
	 * @generated NOT
	 */
	private void startChangeRecording() {

		isRecording = true;
		changeRecorder = new ChangeRecorder();
		if (getLocalChanges() == null) {
			changeRecorder.beginRecording(Collections.singleton(getProject()));
			setDirty(false);
		} else {
			changeRecorder.beginRecording((ChangeDescription) EcoreUtil
					.copy(getLocalChanges()), Collections
					.singleton(getProject()));
			setDirty(true);
		}

	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.unicase.workspace.ProjectSpace#init()
	 * @generated NOT
	 */
	public void init() {
		this.myOperations = new ArrayList<AbstractOperation>();
		TransactionalEditingDomain domain = TransactionalEditingDomain.Registry.INSTANCE
				.getEditingDomain("org.unicase.EditingDomain");
		domain.addResourceSetListener(this);
		// MK: possibly performance hit
		this.eResource().setTrackingModification(true);
		new ProjectChangeNotifier(this.getProject(), this);
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
		// FIXME OW why head version spec
		// FIXME use resolve version spec of usersession
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
	 * 
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
		case WorkspacePackage.PROJECT_SPACE__OPERATIONS:
			return ((InternalEList<?>) getOperations()).basicRemove(otherEnd,
					msgs);
		case WorkspacePackage.PROJECT_SPACE__BASE_VERSION:
			return basicSetBaseVersion(null, msgs);
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
		case WorkspacePackage.PROJECT_SPACE__LOCAL_CHANGES:
			if (resolve)
				return getLocalChanges();
			return basicGetLocalChanges();
		case WorkspacePackage.PROJECT_SPACE__OPERATIONS:
			return getOperations();
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
		case WorkspacePackage.PROJECT_SPACE__LOCAL_CHANGES:
			setLocalChanges((ChangeDescription) newValue);
			return;
		case WorkspacePackage.PROJECT_SPACE__OPERATIONS:
			getOperations().clear();
			getOperations().addAll(
					(Collection<? extends AbstractOperation>) newValue);
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
		case WorkspacePackage.PROJECT_SPACE__LOCAL_CHANGES:
			setLocalChanges((ChangeDescription) null);
			return;
		case WorkspacePackage.PROJECT_SPACE__OPERATIONS:
			getOperations().clear();
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
			return PROJECT_NAME_EDEFAULT == null ? projectName != null
					: !PROJECT_NAME_EDEFAULT.equals(projectName);
		case WorkspacePackage.PROJECT_SPACE__PROJECT_DESCRIPTION:
			return PROJECT_DESCRIPTION_EDEFAULT == null ? projectDescription != null
					: !PROJECT_DESCRIPTION_EDEFAULT.equals(projectDescription);
		case WorkspacePackage.PROJECT_SPACE__LOCAL_CHANGES:
			return localChanges != null;
		case WorkspacePackage.PROJECT_SPACE__OPERATIONS:
			return operations != null && !operations.isEmpty();
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
		case WorkspacePackage.PROJECT_SPACE__OLD_LOG_MESSAGES:
			return oldLogMessages != null && !oldLogMessages.isEmpty();
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

	/**
	 * Save all resources that are dirty.
	 */
	private void saveResources(boolean force) {
		EList<Resource> resources = this.eResource().getResourceSet()
				.getResources();
		for (Resource resource : resources) {
			// if (resource.isModified() || force) {
			if (true) {
				try {
					resource.save(Configuration.getResourceSaveOptions());
				} catch (IOException e) {
					Throwable cause = e.getCause();
					if (cause != null && cause instanceof DanglingHREFException) {
						boolean foundProblems = ModelValidationHelper
								.checkAndFixProject(getProject());
						if (foundProblems) {
							// FIXME OW MK log problem
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
				// FIXME MK check if file exists
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

	public NotificationFilter getFilter() {
		return NotificationFilter.NOT_TOUCH;
	}

	public boolean isAggregatePrecommitListener() {
		return false;
	}

	public boolean isPostcommitOnly() {
		return true;
	}

	public boolean isPrecommitOnly() {
		return false;
	}

	public void resourceSetChanged(final ResourceSetChangeEvent event) {

		if (!this.isRecording) {
			return;
		}

		// filter notifications to project
		List<Notification> notifications = event.getNotifications();
		List<Notification> projectNotifications = new ArrayList<Notification>();
		for (Notification notification : notifications) {
			Object notifier = notification.getNotifier();
			if (notifier instanceof ModelElement) {
				ModelElement modelElement = (ModelElement) notifier;
				if (ProjectSpaceImpl.this.getProject().contains(modelElement)) {
					projectNotifications.add(notification);
				}
			}
			if (notifier instanceof Project) {
				projectNotifications.add(notification);
			}
		}
		if (projectNotifications.size() == 0) {
			return;
		}

		for (int i = 0; i < projectNotifications.size(); i++) {
			Notification notification = projectNotifications.get(i);
			Object feature = notification.getFeature();
			Object newValue = notification.getNewValue();
			Object oldValue = notification.getOldValue();
			if (notification.getEventType() == Notification.SET) {
				if (feature instanceof EAttribute) {
					// Simple attribute set
					AttributeOperation attributeOperation = createAttributeOperation(
							notification, feature, newValue, oldValue);
					this.myOperations.add(attributeOperation);
					continue;
				} else if (feature instanceof EReference) {

					// single reference set
					EReference reference = (EReference) feature;
					ModelElement newValueME = (ModelElement) newValue;

					if (reference.isContainment()) {
						if (newValue == null) {
							// element removed from containment hierachy
							CreateDeleteOperation createDeleteOperation = createCreateDeleteOperation(newValueME, true);
							this.myOperations.add(createDeleteOperation);
						} else {
							// element added to containment hierachy
							CreateDeleteOperation createDeleteOperation = createCreateDeleteOperation(newValueME, false);
							this.myOperations.add(createDeleteOperation);
						}
					}

					// handle bidirectional features
					EReference opposite = reference.getEOpposite();
					if (opposite != null) {
						if (projectNotifications.size() > i + 1) {
							Notification nextNotification = projectNotifications
									.get(i + 1);
							// next notification is about the opposite of this
							// notification
							if ((nextNotification.getFeature() instanceof EReference)
									&& nextNotification.getNotifier() == newValue
									&& opposite.getName().equals(
											((EReference) nextNotification
													.getFeature()).getName())) {
								// skip
								// i++;
								continue;
							}
						}
					}

					SingleReferenceOperation singleReferenceOperation = createSingleReferenceOperation(
							notification, oldValue, reference, newValueME);
					this.myOperations.add(singleReferenceOperation);
					continue;
				}
				// FIXME MK: this should never happen
				throw new IllegalStateException();
			}

			if (notification.getEventType() == Notification.ADD) {
				if (feature instanceof EReference) {
					if (notification.getNotifier() instanceof Project) {
						CreateDeleteOperation createDeleteOperation = createCreateDeleteOperation(
								(ModelElement) newValue, false);
						this.myOperations.add(createDeleteOperation);
					} else {
						i = handleEReference(feature, newValue, notification,
								true, projectNotifications, i);
					}
				} else if (feature instanceof EAttribute) {
					EAttribute attribute = (EAttribute) feature;
					MultiAttributeOperation multiAttributeOperation = createMultiAttributeOperation(
							notification, newValue, attribute, true);
					this.myOperations.add(multiAttributeOperation);
					continue;
				} else {
					// FIXME MK: this should never happen
					throw new IllegalStateException();
				}
				continue;
			}

			if (notification.getEventType() == Notification.REMOVE) {
				if (feature instanceof EReference) {
					if (notification.getNotifier() instanceof Project) {
						CreateDeleteOperation createDeleteOperation = createCreateDeleteOperation(
								(ModelElement) newValue, true);
						this.myOperations.add(createDeleteOperation);
					} else {
						i = handleEReference(feature, newValue, notification,
								false, projectNotifications, i);
					}
				} else if (feature instanceof EAttribute) {
					EAttribute attribute = (EAttribute) feature;
					MultiAttributeOperation multiAttributeOperation = createMultiAttributeOperation(
							notification, newValue, attribute, false);
					this.myOperations.add(multiAttributeOperation);
					continue;
				} else {
					// FIXME MK: this should never happen
					throw new IllegalStateException();
				}
				continue;
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
					MultiReferenceMoveOperation multiReferenceMoveOperation = OperationsFactory.eINSTANCE
							.createMultiReferenceMoveOperation();
					multiReferenceMoveOperation.setFeatureName(reference
							.getName());
					multiReferenceMoveOperation
							.setModelElementId(((ModelElement) notification
									.getNotifier()).getModelElementId());
					multiReferenceMoveOperation
							.setReferencedModelElementId(((ModelElement) notification
									.getNewValue()).getModelElementId());
					multiReferenceMoveOperation.setNewIndex(notification
							.getPosition());
					multiReferenceMoveOperation.setOldIndex((Integer) oldValue);
					this.myOperations.add(multiReferenceMoveOperation);
					continue;
				} else {
					// FIXME MK: this should never happen
					throw new IllegalStateException();
				}
			}
			throw new IllegalStateException();
		}

	}

	private MultiAttributeOperation createMultiAttributeOperation(
			Notification notification, Object newValue, EAttribute attribute,
			boolean isAdd) {
		MultiAttributeOperation multiAttributeOperation = OperationsFactory.eINSTANCE
				.createMultiAttributeOperation();
		multiAttributeOperation.setAdd(isAdd);
		multiAttributeOperation.setFeatureName(attribute.getName());
		multiAttributeOperation.setIndex(notification.getPosition());
		multiAttributeOperation.setModelElementId(((ModelElement) notification
				.getNotifier()).getModelElementId());
		multiAttributeOperation.getValues().add(newValue);
		return multiAttributeOperation;
	}

	private AttributeOperation createAttributeOperation(
			Notification notification, Object feature, Object newValue,
			Object oldValue) {
		EAttribute attribute = (EAttribute) feature;
		AttributeOperation attributeOperation = OperationsFactory.eINSTANCE
				.createAttributeOperation();
		attributeOperation.setFeatureName(attribute.getName());
		ModelElement modelElement = (ModelElement) notification.getNotifier();
		attributeOperation.setModelElementId((ModelElementId) EcoreUtil
				.copy(modelElement.getModelElementId()));
		attributeOperation.setNewValue(newValue);
		attributeOperation.setOldValue(oldValue);
		return attributeOperation;
	}

	private int handleEReference(Object feature, Object newValue,
			Notification notification, boolean isAdd,
			List<Notification> projectNotifications, int i) {

		EReference reference = (EReference) feature;
		ModelElement modelElement = (ModelElement) newValue;

		if (reference.isContainment()) {
			// element was added or removed to/from containment hierachy

			CreateDeleteOperation createDeleteOperation = createCreateDeleteOperation(
					modelElement, !isAdd);
			this.myOperations.add(createDeleteOperation);

		}

		// handle bidirectional features
		EReference opposite = reference.getEOpposite();
		if (opposite != null) {
			if (projectNotifications.size() > i + 1) {
				Notification nextNotification = projectNotifications.get(i + 1);
				// next notification is about the opposite of this notification
				if ((nextNotification.getFeature() instanceof EReference)
						&& nextNotification.getNotifier() == newValue
						&& opposite.getName().equals(
								((EReference) nextNotification.getFeature())
										.getName())) {
					// skip
					// i++;
					return i;
				}
			}
		}

		// element was added/removed to/from a reference feature
		ModelElement parent = (ModelElement) notification.getNotifier();

		if (reference.isMany()) {
			MultiReferenceOperation multiReferenceOperation = createMultiReferenceOperation(
					notification, reference, modelElement, parent, isAdd);
			this.myOperations.add(multiReferenceOperation);
		} else {
			// should never hit here
			throw new IllegalStateException();
		}
		return i;
	}

	private MultiReferenceOperation createMultiReferenceOperation(
			Notification notification, EReference reference,
			ModelElement modelElement, ModelElement parent, boolean isAdd) {
		MultiReferenceOperation multiReferenceOperation = OperationsFactory.eINSTANCE
				.createMultiReferenceOperation();
		multiReferenceOperation.setFeatureName(reference.getName());
		multiReferenceOperation.setAdd(isAdd);
		multiReferenceOperation.setIndex(notification.getPosition());
		multiReferenceOperation.getReferencedModelElements().add(
				(ModelElementId) (modelElement.getModelElementId()));
		multiReferenceOperation.setModelElementId(parent.getModelElementId());
		return multiReferenceOperation;
	}

	private SingleReferenceOperation createSingleReferenceOperation(
			Notification notification, Object oldValue, EReference reference,
			ModelElement newValueME) {
		SingleReferenceOperation singleReferenceOperation = OperationsFactory.eINSTANCE
				.createSingleReferenceOperation();
		singleReferenceOperation.setFeatureName(reference.getName());
		if (oldValue != null) {
			singleReferenceOperation.setOldValue(((ModelElement) oldValue)
					.getModelElementId());
		}
		if (newValueME != null) {
			singleReferenceOperation
					.setNewValue(newValueME.getModelElementId());
		}
		singleReferenceOperation.setModelElementId(((ModelElement) notification
				.getNotifier()).getModelElementId());
		return singleReferenceOperation;
	}

	private CreateDeleteOperation createCreateDeleteOperation(
			ModelElement modelElement, boolean delete) {
		CreateDeleteOperation createDeleteOperation = OperationsFactory.eINSTANCE
				.createCreateDeleteOperation();
		createDeleteOperation.setDelete(delete);
		createDeleteOperation.setModelElement((ModelElement) EcoreUtil
				.copy(modelElement));
		createDeleteOperation.setModelElementId((ModelElementId) EcoreUtil
				.copy(modelElement.getModelElementId()));
		return createDeleteOperation;
	}

	public Command transactionAboutToCommit(ResourceSetChangeEvent event)
			throws RollbackException {
		// do nothing
		return null;
	}

	public void modelElementAdded(Project project, ModelElement modelElement) {
		// TODO Auto-generated method stub

	}

	public void modelElementRemoved(Project project, ModelElement modelElement) {
		// TODO Auto-generated method stub

	}

	public void notify(Notification notification, Project project,
			ModelElement modelElement) {
		if (notification.getEventType() == Notification.ADD
				&& notification.getFeature() instanceof EStructuralFeature
				&& notification.getNewValue() instanceof EObject) {
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
		this.getOperations().addAll(this.myOperations);
		saveResources(false);
	}

} // ProjectContainerImpl
