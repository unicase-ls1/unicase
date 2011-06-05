/**
 * <copyright> Copyright (c) 2008-2011 Chair for Applied Software Engineering, Technische Unversitaet Muenchen. All rights reserved. This program and the accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 * 
 */
package org.eclipse.emf.emfstore.client.model.impl;

import java.io.IOException;
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
import org.eclipse.emf.ecore.util.InternalEList;

import org.eclipse.emf.emfstore.client.model.ModelPackage;
import org.eclipse.emf.emfstore.client.model.OperationComposite;
import org.eclipse.emf.emfstore.client.model.ProjectData;
import org.eclipse.emf.emfstore.client.model.ProjectSpaceDataInternal;
import org.eclipse.emf.emfstore.client.model.Usersession;

import org.eclipse.emf.emfstore.common.model.Project;
import org.eclipse.emf.emfstore.common.model.impl.IdentifiableElementImpl;
import org.eclipse.emf.emfstore.common.model.util.ModelUtil;

import org.eclipse.emf.emfstore.server.model.FileIdentifier;
import org.eclipse.emf.emfstore.server.model.ProjectId;

import org.eclipse.emf.emfstore.server.model.versioning.PrimaryVersionSpec;
import org.eclipse.emf.emfstore.server.model.versioning.operations.AbstractOperation;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Project Space Data Internal</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.emf.emfstore.client.model.impl.ProjectSpaceDataInternalImpl#getProjectId <em>Project Id</em>}</li>
 *   <li>{@link org.eclipse.emf.emfstore.client.model.impl.ProjectSpaceDataInternalImpl#getProjectName <em>Project Name</em>}</li>
 *   <li>{@link org.eclipse.emf.emfstore.client.model.impl.ProjectSpaceDataInternalImpl#getProjectDescription <em>Project Description</em>}</li>
 *   <li>{@link org.eclipse.emf.emfstore.client.model.impl.ProjectSpaceDataInternalImpl#getUsersession <em>Usersession</em>}</li>
 *   <li>{@link org.eclipse.emf.emfstore.client.model.impl.ProjectSpaceDataInternalImpl#getLastUpdated <em>Last Updated</em>}</li>
 *   <li>{@link org.eclipse.emf.emfstore.client.model.impl.ProjectSpaceDataInternalImpl#getBaseVersion <em>Base Version</em>}</li>
 *   <li>{@link org.eclipse.emf.emfstore.client.model.impl.ProjectSpaceDataInternalImpl#getResourceCount <em>Resource Count</em>}</li>
 *   <li>{@link org.eclipse.emf.emfstore.client.model.impl.ProjectSpaceDataInternalImpl#isDirty <em>Dirty</em>}</li>
 *   <li>{@link org.eclipse.emf.emfstore.client.model.impl.ProjectSpaceDataInternalImpl#getOldLogMessages <em>Old Log Messages</em>}</li>
 *   <li>{@link org.eclipse.emf.emfstore.client.model.impl.ProjectSpaceDataInternalImpl#getWaitingUploads <em>Waiting Uploads</em>}</li>
 *   <li>{@link org.eclipse.emf.emfstore.client.model.impl.ProjectSpaceDataInternalImpl#getProjectDataPath <em>Project Data Path</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ProjectSpaceDataInternalImpl extends IdentifiableElementImpl
		implements ProjectSpaceDataInternal {
	/**
	 * The cached value of the '{@link #getProjectId() <em>Project Id</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getProjectId()
	 * @generated
	 * @ordered
	 */
	protected ProjectId projectId;

	/**
	 * The default value of the '{@link #getProjectName() <em>Project Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getProjectName()
	 * @generated
	 * @ordered
	 */
	protected static final String PROJECT_NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getProjectName() <em>Project Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getProjectName()
	 * @generated
	 * @ordered
	 */
	protected String projectName = PROJECT_NAME_EDEFAULT;

	/**
	 * The default value of the '{@link #getProjectDescription() <em>Project Description</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getProjectDescription()
	 * @generated
	 * @ordered
	 */
	protected static final String PROJECT_DESCRIPTION_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getProjectDescription() <em>Project Description</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getProjectDescription()
	 * @generated
	 * @ordered
	 */
	protected String projectDescription = PROJECT_DESCRIPTION_EDEFAULT;

	/**
	 * The cached value of the '{@link #getUsersession() <em>Usersession</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUsersession()
	 * @generated
	 * @ordered
	 */
	protected Usersession usersession;

	/**
	 * The default value of the '{@link #getLastUpdated() <em>Last Updated</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLastUpdated()
	 * @generated
	 * @ordered
	 */
	protected static final Date LAST_UPDATED_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getLastUpdated() <em>Last Updated</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLastUpdated()
	 * @generated
	 * @ordered
	 */
	protected Date lastUpdated = LAST_UPDATED_EDEFAULT;

	/**
	 * The cached value of the '{@link #getBaseVersion() <em>Base Version</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBaseVersion()
	 * @generated
	 * @ordered
	 */
	protected PrimaryVersionSpec baseVersion;

	/**
	 * The default value of the '{@link #getResourceCount() <em>Resource Count</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getResourceCount()
	 * @generated
	 * @ordered
	 */
	protected static final int RESOURCE_COUNT_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getResourceCount() <em>Resource Count</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
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

	/**
	 * The cached value of the '{@link #getOldLogMessages() <em>Old Log Messages</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOldLogMessages()
	 * @generated
	 * @ordered
	 */
	protected EList<String> oldLogMessages;

	/**
	 * The cached value of the '{@link #getWaitingUploads() <em>Waiting Uploads</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getWaitingUploads()
	 * @generated
	 * @ordered
	 */
	protected EList<FileIdentifier> waitingUploads;

	/**
	 * The default value of the '{@link #getProjectDataPath() <em>Project Data Path</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getProjectDataPath()
	 * @generated
	 * @ordered
	 */
	protected static final String PROJECT_DATA_PATH_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getProjectDataPath() <em>Project Data Path</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getProjectDataPath()
	 * @generated
	 * @ordered
	 */
	protected String projectDataPath = PROJECT_DATA_PATH_EDEFAULT;

	private boolean isLoaded;

	private ProjectData projectData;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ProjectSpaceDataInternalImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ModelPackage.Literals.PROJECT_SPACE_DATA_INTERNAL;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ProjectId getProjectId() {
		if (projectId != null && projectId.eIsProxy()) {
			InternalEObject oldProjectId = (InternalEObject) projectId;
			projectId = (ProjectId) eResolveProxy(oldProjectId);
			if (projectId != oldProjectId) {
				InternalEObject newProjectId = (InternalEObject) projectId;
				NotificationChain msgs = oldProjectId
						.eInverseRemove(
								this,
								EOPPOSITE_FEATURE_BASE
										- ModelPackage.PROJECT_SPACE_DATA_INTERNAL__PROJECT_ID,
								null, null);
				if (newProjectId.eInternalContainer() == null) {
					msgs = newProjectId
							.eInverseAdd(
									this,
									EOPPOSITE_FEATURE_BASE
											- ModelPackage.PROJECT_SPACE_DATA_INTERNAL__PROJECT_ID,
									null, msgs);
				}
				if (msgs != null)
					msgs.dispatch();
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(
							this,
							Notification.RESOLVE,
							ModelPackage.PROJECT_SPACE_DATA_INTERNAL__PROJECT_ID,
							oldProjectId, projectId));
			}
		}
		return projectId;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ProjectId basicGetProjectId() {
		return projectId;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetProjectId(ProjectId newProjectId,
			NotificationChain msgs) {
		ProjectId oldProjectId = projectId;
		projectId = newProjectId;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this,
					Notification.SET,
					ModelPackage.PROJECT_SPACE_DATA_INTERNAL__PROJECT_ID,
					oldProjectId, newProjectId);
			if (msgs == null)
				msgs = notification;
			else
				msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setProjectId(ProjectId newProjectId) {
		if (newProjectId != projectId) {
			NotificationChain msgs = null;
			if (projectId != null)
				msgs = ((InternalEObject) projectId)
						.eInverseRemove(
								this,
								EOPPOSITE_FEATURE_BASE
										- ModelPackage.PROJECT_SPACE_DATA_INTERNAL__PROJECT_ID,
								null, msgs);
			if (newProjectId != null)
				msgs = ((InternalEObject) newProjectId)
						.eInverseAdd(
								this,
								EOPPOSITE_FEATURE_BASE
										- ModelPackage.PROJECT_SPACE_DATA_INTERNAL__PROJECT_ID,
								null, msgs);
			msgs = basicSetProjectId(newProjectId, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					ModelPackage.PROJECT_SPACE_DATA_INTERNAL__PROJECT_ID,
					newProjectId, newProjectId));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getProjectName() {
		return projectName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setProjectName(String newProjectName) {
		String oldProjectName = projectName;
		projectName = newProjectName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					ModelPackage.PROJECT_SPACE_DATA_INTERNAL__PROJECT_NAME,
					oldProjectName, projectName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getProjectDescription() {
		return projectDescription;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setProjectDescription(String newProjectDescription) {
		String oldProjectDescription = projectDescription;
		projectDescription = newProjectDescription;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(
					this,
					Notification.SET,
					ModelPackage.PROJECT_SPACE_DATA_INTERNAL__PROJECT_DESCRIPTION,
					oldProjectDescription, projectDescription));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Usersession getUsersession() {
		if (usersession != null && usersession.eIsProxy()) {
			InternalEObject oldUsersession = (InternalEObject) usersession;
			usersession = (Usersession) eResolveProxy(oldUsersession);
			if (usersession != oldUsersession) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(
							this,
							Notification.RESOLVE,
							ModelPackage.PROJECT_SPACE_DATA_INTERNAL__USERSESSION,
							oldUsersession, usersession));
			}
		}
		return usersession;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Usersession basicGetUsersession() {
		return usersession;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setUsersession(Usersession newUsersession) {
		Usersession oldUsersession = usersession;
		usersession = newUsersession;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					ModelPackage.PROJECT_SPACE_DATA_INTERNAL__USERSESSION,
					oldUsersession, usersession));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Date getLastUpdated() {
		return lastUpdated;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLastUpdated(Date newLastUpdated) {
		Date oldLastUpdated = lastUpdated;
		lastUpdated = newLastUpdated;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					ModelPackage.PROJECT_SPACE_DATA_INTERNAL__LAST_UPDATED,
					oldLastUpdated, lastUpdated));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PrimaryVersionSpec getBaseVersion() {
		if (baseVersion != null && baseVersion.eIsProxy()) {
			InternalEObject oldBaseVersion = (InternalEObject) baseVersion;
			baseVersion = (PrimaryVersionSpec) eResolveProxy(oldBaseVersion);
			if (baseVersion != oldBaseVersion) {
				InternalEObject newBaseVersion = (InternalEObject) baseVersion;
				NotificationChain msgs = oldBaseVersion
						.eInverseRemove(
								this,
								EOPPOSITE_FEATURE_BASE
										- ModelPackage.PROJECT_SPACE_DATA_INTERNAL__BASE_VERSION,
								null, null);
				if (newBaseVersion.eInternalContainer() == null) {
					msgs = newBaseVersion
							.eInverseAdd(
									this,
									EOPPOSITE_FEATURE_BASE
											- ModelPackage.PROJECT_SPACE_DATA_INTERNAL__BASE_VERSION,
									null, msgs);
				}
				if (msgs != null)
					msgs.dispatch();
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(
							this,
							Notification.RESOLVE,
							ModelPackage.PROJECT_SPACE_DATA_INTERNAL__BASE_VERSION,
							oldBaseVersion, baseVersion));
			}
		}
		return baseVersion;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PrimaryVersionSpec basicGetBaseVersion() {
		return baseVersion;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetBaseVersion(
			PrimaryVersionSpec newBaseVersion, NotificationChain msgs) {
		PrimaryVersionSpec oldBaseVersion = baseVersion;
		baseVersion = newBaseVersion;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this,
					Notification.SET,
					ModelPackage.PROJECT_SPACE_DATA_INTERNAL__BASE_VERSION,
					oldBaseVersion, newBaseVersion);
			if (msgs == null)
				msgs = notification;
			else
				msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBaseVersion(PrimaryVersionSpec newBaseVersion) {
		if (newBaseVersion != baseVersion) {
			NotificationChain msgs = null;
			if (baseVersion != null)
				msgs = ((InternalEObject) baseVersion)
						.eInverseRemove(
								this,
								EOPPOSITE_FEATURE_BASE
										- ModelPackage.PROJECT_SPACE_DATA_INTERNAL__BASE_VERSION,
								null, msgs);
			if (newBaseVersion != null)
				msgs = ((InternalEObject) newBaseVersion)
						.eInverseAdd(
								this,
								EOPPOSITE_FEATURE_BASE
										- ModelPackage.PROJECT_SPACE_DATA_INTERNAL__BASE_VERSION,
								null, msgs);
			msgs = basicSetBaseVersion(newBaseVersion, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					ModelPackage.PROJECT_SPACE_DATA_INTERNAL__BASE_VERSION,
					newBaseVersion, newBaseVersion));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getResourceCount() {
		return resourceCount;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setResourceCount(int newResourceCount) {
		int oldResourceCount = resourceCount;
		resourceCount = newResourceCount;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					ModelPackage.PROJECT_SPACE_DATA_INTERNAL__RESOURCE_COUNT,
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
					ModelPackage.PROJECT_SPACE_DATA_INTERNAL__DIRTY, oldDirty,
					dirty));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<String> getOldLogMessages() {
		if (oldLogMessages == null) {
			oldLogMessages = new EDataTypeUniqueEList<String>(String.class,
					this,
					ModelPackage.PROJECT_SPACE_DATA_INTERNAL__OLD_LOG_MESSAGES);
		}
		return oldLogMessages;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<FileIdentifier> getWaitingUploads() {
		if (waitingUploads == null) {
			waitingUploads = new EObjectContainmentEList.Resolving<FileIdentifier>(
					FileIdentifier.class, this,
					ModelPackage.PROJECT_SPACE_DATA_INTERNAL__WAITING_UPLOADS);
		}
		return waitingUploads;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getProjectDataPath() {
		return projectDataPath;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setProjectDataPath(String newProjectDataPath) {
		String oldProjectDataPath = projectDataPath;
		projectDataPath = newProjectDataPath;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(
					this,
					Notification.SET,
					ModelPackage.PROJECT_SPACE_DATA_INTERNAL__PROJECT_DATA_PATH,
					oldProjectDataPath, projectDataPath));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd,
			int featureID, NotificationChain msgs) {
		switch (featureID) {
		case ModelPackage.PROJECT_SPACE_DATA_INTERNAL__PROJECT_ID:
			return basicSetProjectId(null, msgs);
		case ModelPackage.PROJECT_SPACE_DATA_INTERNAL__BASE_VERSION:
			return basicSetBaseVersion(null, msgs);
		case ModelPackage.PROJECT_SPACE_DATA_INTERNAL__WAITING_UPLOADS:
			return ((InternalEList<?>) getWaitingUploads()).basicRemove(
					otherEnd, msgs);
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
		case ModelPackage.PROJECT_SPACE_DATA_INTERNAL__PROJECT_ID:
			if (resolve)
				return getProjectId();
			return basicGetProjectId();
		case ModelPackage.PROJECT_SPACE_DATA_INTERNAL__PROJECT_NAME:
			return getProjectName();
		case ModelPackage.PROJECT_SPACE_DATA_INTERNAL__PROJECT_DESCRIPTION:
			return getProjectDescription();
		case ModelPackage.PROJECT_SPACE_DATA_INTERNAL__USERSESSION:
			if (resolve)
				return getUsersession();
			return basicGetUsersession();
		case ModelPackage.PROJECT_SPACE_DATA_INTERNAL__LAST_UPDATED:
			return getLastUpdated();
		case ModelPackage.PROJECT_SPACE_DATA_INTERNAL__BASE_VERSION:
			if (resolve)
				return getBaseVersion();
			return basicGetBaseVersion();
		case ModelPackage.PROJECT_SPACE_DATA_INTERNAL__RESOURCE_COUNT:
			return getResourceCount();
		case ModelPackage.PROJECT_SPACE_DATA_INTERNAL__DIRTY:
			return isDirty();
		case ModelPackage.PROJECT_SPACE_DATA_INTERNAL__OLD_LOG_MESSAGES:
			return getOldLogMessages();
		case ModelPackage.PROJECT_SPACE_DATA_INTERNAL__WAITING_UPLOADS:
			return getWaitingUploads();
		case ModelPackage.PROJECT_SPACE_DATA_INTERNAL__PROJECT_DATA_PATH:
			return getProjectDataPath();
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
		case ModelPackage.PROJECT_SPACE_DATA_INTERNAL__PROJECT_ID:
			setProjectId((ProjectId) newValue);
			return;
		case ModelPackage.PROJECT_SPACE_DATA_INTERNAL__PROJECT_NAME:
			setProjectName((String) newValue);
			return;
		case ModelPackage.PROJECT_SPACE_DATA_INTERNAL__PROJECT_DESCRIPTION:
			setProjectDescription((String) newValue);
			return;
		case ModelPackage.PROJECT_SPACE_DATA_INTERNAL__USERSESSION:
			setUsersession((Usersession) newValue);
			return;
		case ModelPackage.PROJECT_SPACE_DATA_INTERNAL__LAST_UPDATED:
			setLastUpdated((Date) newValue);
			return;
		case ModelPackage.PROJECT_SPACE_DATA_INTERNAL__BASE_VERSION:
			setBaseVersion((PrimaryVersionSpec) newValue);
			return;
		case ModelPackage.PROJECT_SPACE_DATA_INTERNAL__RESOURCE_COUNT:
			setResourceCount((Integer) newValue);
			return;
		case ModelPackage.PROJECT_SPACE_DATA_INTERNAL__DIRTY:
			setDirty((Boolean) newValue);
			return;
		case ModelPackage.PROJECT_SPACE_DATA_INTERNAL__OLD_LOG_MESSAGES:
			getOldLogMessages().clear();
			getOldLogMessages().addAll((Collection<? extends String>) newValue);
			return;
		case ModelPackage.PROJECT_SPACE_DATA_INTERNAL__WAITING_UPLOADS:
			getWaitingUploads().clear();
			getWaitingUploads().addAll(
					(Collection<? extends FileIdentifier>) newValue);
			return;
		case ModelPackage.PROJECT_SPACE_DATA_INTERNAL__PROJECT_DATA_PATH:
			setProjectDataPath((String) newValue);
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
		case ModelPackage.PROJECT_SPACE_DATA_INTERNAL__PROJECT_ID:
			setProjectId((ProjectId) null);
			return;
		case ModelPackage.PROJECT_SPACE_DATA_INTERNAL__PROJECT_NAME:
			setProjectName(PROJECT_NAME_EDEFAULT);
			return;
		case ModelPackage.PROJECT_SPACE_DATA_INTERNAL__PROJECT_DESCRIPTION:
			setProjectDescription(PROJECT_DESCRIPTION_EDEFAULT);
			return;
		case ModelPackage.PROJECT_SPACE_DATA_INTERNAL__USERSESSION:
			setUsersession((Usersession) null);
			return;
		case ModelPackage.PROJECT_SPACE_DATA_INTERNAL__LAST_UPDATED:
			setLastUpdated(LAST_UPDATED_EDEFAULT);
			return;
		case ModelPackage.PROJECT_SPACE_DATA_INTERNAL__BASE_VERSION:
			setBaseVersion((PrimaryVersionSpec) null);
			return;
		case ModelPackage.PROJECT_SPACE_DATA_INTERNAL__RESOURCE_COUNT:
			setResourceCount(RESOURCE_COUNT_EDEFAULT);
			return;
		case ModelPackage.PROJECT_SPACE_DATA_INTERNAL__DIRTY:
			setDirty(DIRTY_EDEFAULT);
			return;
		case ModelPackage.PROJECT_SPACE_DATA_INTERNAL__OLD_LOG_MESSAGES:
			getOldLogMessages().clear();
			return;
		case ModelPackage.PROJECT_SPACE_DATA_INTERNAL__WAITING_UPLOADS:
			getWaitingUploads().clear();
			return;
		case ModelPackage.PROJECT_SPACE_DATA_INTERNAL__PROJECT_DATA_PATH:
			setProjectDataPath(PROJECT_DATA_PATH_EDEFAULT);
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
		case ModelPackage.PROJECT_SPACE_DATA_INTERNAL__PROJECT_ID:
			return projectId != null;
		case ModelPackage.PROJECT_SPACE_DATA_INTERNAL__PROJECT_NAME:
			return PROJECT_NAME_EDEFAULT == null ? projectName != null
					: !PROJECT_NAME_EDEFAULT.equals(projectName);
		case ModelPackage.PROJECT_SPACE_DATA_INTERNAL__PROJECT_DESCRIPTION:
			return PROJECT_DESCRIPTION_EDEFAULT == null ? projectDescription != null
					: !PROJECT_DESCRIPTION_EDEFAULT.equals(projectDescription);
		case ModelPackage.PROJECT_SPACE_DATA_INTERNAL__USERSESSION:
			return usersession != null;
		case ModelPackage.PROJECT_SPACE_DATA_INTERNAL__LAST_UPDATED:
			return LAST_UPDATED_EDEFAULT == null ? lastUpdated != null
					: !LAST_UPDATED_EDEFAULT.equals(lastUpdated);
		case ModelPackage.PROJECT_SPACE_DATA_INTERNAL__BASE_VERSION:
			return baseVersion != null;
		case ModelPackage.PROJECT_SPACE_DATA_INTERNAL__RESOURCE_COUNT:
			return resourceCount != RESOURCE_COUNT_EDEFAULT;
		case ModelPackage.PROJECT_SPACE_DATA_INTERNAL__DIRTY:
			return dirty != DIRTY_EDEFAULT;
		case ModelPackage.PROJECT_SPACE_DATA_INTERNAL__OLD_LOG_MESSAGES:
			return oldLogMessages != null && !oldLogMessages.isEmpty();
		case ModelPackage.PROJECT_SPACE_DATA_INTERNAL__WAITING_UPLOADS:
			return waitingUploads != null && !waitingUploads.isEmpty();
		case ModelPackage.PROJECT_SPACE_DATA_INTERNAL__PROJECT_DATA_PATH:
			return PROJECT_DATA_PATH_EDEFAULT == null ? projectDataPath != null
					: !PROJECT_DATA_PATH_EDEFAULT.equals(projectDataPath);
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
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
		result.append(", projectDataPath: ");
		result.append(projectDataPath);
		result.append(')');
		return result.toString();
	}

	@Override
	public boolean isLoaded() {
		return isLoaded;
	}

	@Override
	public void load() {
		ResourceSet resourceSet = new ResourceSetImpl();
		Resource resource = resourceSet.createResource(URI.createFileURI(projectDataPath));
		try {
			resource.load(ModelUtil.getResourceLoadOptions());
			isLoaded = true;
		} catch (IOException e) {
			isLoaded = false;
			ModelUtil.logException(e);
		}
		
		// TODO: make index-safe 
		projectData = (ProjectData) resource.getContents().get(0);
	}

	@Override
	public Project getProject() {
		if (isLoaded) {
			return projectData.getProject();
		}
		
		throw new IllegalStateException("Project not loaded.");
	}

	@Override
	public List<AbstractOperation> getOperations() {
		// TODO: difference between getLocalOperations() and getOperations()
		return null;
	}

	@Override
	public OperationComposite getLocalOperations() {
		if (isLoaded) {
			return projectData.getLocalOperations();
		}
		
		throw new IllegalStateException("Project not loaded.");
	}

	@Override
	public void setProject(Project newProject) {
		if (isLoaded) {
			projectData.setProject(newProject);
		}
		
		throw new IllegalStateException("Project not loaded.");
	}

	@Override
	public void setLocalOperations(OperationComposite operationComposite) {
		// TODO Auto-generated method stub
	}

} //ProjectSpaceDataInternalImpl
