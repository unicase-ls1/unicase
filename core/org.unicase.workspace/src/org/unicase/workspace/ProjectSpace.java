/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.workspace;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.unicase.emfstore.esmodel.ProjectId;
import org.unicase.emfstore.esmodel.ProjectInfo;
import org.unicase.emfstore.esmodel.accesscontrol.OrgUnitProperty;
import org.unicase.emfstore.esmodel.notification.ESNotification;
import org.unicase.emfstore.esmodel.url.ModelElementUrlFragment;
import org.unicase.emfstore.esmodel.versioning.ChangePackage;
import org.unicase.emfstore.esmodel.versioning.LogMessage;
import org.unicase.emfstore.esmodel.versioning.PrimaryVersionSpec;
import org.unicase.emfstore.esmodel.versioning.TagVersionSpec;
import org.unicase.emfstore.esmodel.versioning.VersionSpec;
import org.unicase.emfstore.esmodel.versioning.events.Event;
import org.unicase.emfstore.esmodel.versioning.operations.AbstractOperation;
import org.unicase.emfstore.exceptions.BaseVersionOutdatedException;
import org.unicase.emfstore.exceptions.EmfStoreException;
import org.unicase.emfstore.exceptions.FileTransferException;
import org.unicase.emfstore.filetransfer.FileInformation;
import org.unicase.metamodel.IdentifiableElement;
import org.unicase.metamodel.Project;
import org.unicase.workspace.exceptions.ChangeConflictException;
import org.unicase.workspace.exceptions.MEUrlResolutionException;
import org.unicase.workspace.exceptions.PropertyNotFoundException;
import org.unicase.workspace.filetransfer.FileRequestHandler;
import org.unicase.workspace.observers.CommitObserver;
import org.unicase.workspace.observers.ConflictResolver;
import org.unicase.workspace.observers.OperationListener;
import org.unicase.workspace.observers.UpdateObserver;
import org.unicase.workspace.preferences.PropertyKey;

/**
 * <!-- begin-user-doc --> A representation of the model object ' <em><b>Project Container</b></em>'. <!-- end-user-doc
 * -->
 * <p>
 * The following features are supported:
 * <ul>
 * <li>{@link org.unicase.workspace.ProjectSpace#getProject <em>Project</em>}</li>
 * <li>{@link org.unicase.workspace.ProjectSpace#getProjectId <em>Project Id</em>}</li>
 * <li>{@link org.unicase.workspace.ProjectSpace#getProjectName <em>Project Name</em>}</li>
 * <li>{@link org.unicase.workspace.ProjectSpace#getProjectDescription <em>Project Description</em>}</li>
 * <li>{@link org.unicase.workspace.ProjectSpace#getOperations <em>Operations</em>}</li>
 * <li>{@link org.unicase.workspace.ProjectSpace#getEvents <em>Events</em>}</li>
 * <li>{@link org.unicase.workspace.ProjectSpace#getUsersession <em>Usersession</em>}</li>
 * <li>{@link org.unicase.workspace.ProjectSpace#getLastUpdated <em>Last Updated</em>}</li>
 * <li>{@link org.unicase.workspace.ProjectSpace#getBaseVersion <em>Base Version</em>}</li>
 * <li>{@link org.unicase.workspace.ProjectSpace#getResourceCount <em>Resource Count</em>}</li>
 * <li>{@link org.unicase.workspace.ProjectSpace#isDirty <em>Dirty</em>}</li>
 * <li>{@link org.unicase.workspace.ProjectSpace#getOldLogMessages <em>Old Log Messages</em>}</li>
 * </ul>
 * </p>
 * 
 * @see org.unicase.workspace.WorkspacePackage#getProjectSpace()
 * @model
 * @generated
 */
public interface ProjectSpace extends IdentifiableElement {
	/**
	 * Returns the value of the '<em><b>Project</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Project</em>' reference isn't clear, there really should be more of a description
	 * here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Project</em>' containment reference.
	 * @see #setProject(Project)
	 * @see org.unicase.workspace.WorkspacePackage#getProjectSpace_Project()
	 * @model containment="true" resolveProxies="true"
	 * @generated
	 */
	Project getProject();

	/**
	 * Sets the value of the '{@link org.unicase.workspace.ProjectSpace#getProject <em>Project</em>}' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Project</em>' containment reference.
	 * @see #getProject()
	 * @generated
	 */
	void setProject(Project value);

	/**
	 * Returns the value of the '<em><b>Project Id</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Project Id</em>' containment reference isn't clear, there really should be more of a
	 * description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Project Id</em>' containment reference.
	 * @see #setProjectId(ProjectId)
	 * @see org.unicase.workspace.WorkspacePackage#getProjectSpace_ProjectId()
	 * @model containment="true" resolveProxies="true" required="true"
	 * @generated
	 */
	ProjectId getProjectId();

	/**
	 * Sets the value of the '{@link org.unicase.workspace.ProjectSpace#getProjectId <em>Project Id</em>}' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Project Id</em>' containment reference.
	 * @see #getProjectId()
	 * @generated
	 */
	void setProjectId(ProjectId value);

	/**
	 * Returns the value of the '<em><b>Project Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Project Name</em>' attribute isn't clear, there really should be more of a description
	 * here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Project Name</em>' attribute.
	 * @see #setProjectName(String)
	 * @see org.unicase.workspace.WorkspacePackage#getProjectSpace_ProjectName()
	 * @model required="true"
	 * @generated
	 */
	String getProjectName();

	/**
	 * Sets the value of the '{@link org.unicase.workspace.ProjectSpace#getProjectName <em>Project Name</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Project Name</em>' attribute.
	 * @see #getProjectName()
	 * @generated
	 */
	void setProjectName(String value);

	/**
	 * Returns the value of the '<em><b>Project Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Project Description</em>' attribute isn't clear, there really should be more of a
	 * description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Project Description</em>' attribute.
	 * @see #setProjectDescription(String)
	 * @see org.unicase.workspace.WorkspacePackage#getProjectSpace_ProjectDescription()
	 * @model required="true"
	 * @generated
	 */
	String getProjectDescription();

	/**
	 * Sets the value of the '{@link org.unicase.workspace.ProjectSpace#getProjectDescription <em>Project Description</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Project Description</em>' attribute.
	 * @see #getProjectDescription()
	 * @generated
	 */
	void setProjectDescription(String value);

	/**
	 * Returns the value of the '<em><b>Events</b></em>' containment reference list.
	 * The list contents are of type {@link org.unicase.emfstore.esmodel.versioning.events.Event}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Events</em>' containment reference list isn't clear, there really should be more of a
	 * description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Events</em>' containment reference list.
	 * @see org.unicase.workspace.WorkspacePackage#getProjectSpace_Events()
	 * @model containment="true" resolveProxies="true"
	 * @generated
	 */
	EList<Event> getEvents();

	/**
	 * Returns the value of the '<em><b>Usersession</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Usersession</em>' reference isn't clear, there really should be more of a description
	 * here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Usersession</em>' reference.
	 * @see #setUsersession(Usersession)
	 * @see org.unicase.workspace.WorkspacePackage#getProjectSpace_Usersession()
	 * @model
	 * @generated
	 */
	Usersession getUsersession();

	/**
	 * Sets the value of the '{@link org.unicase.workspace.ProjectSpace#getUsersession <em>Usersession</em>}' reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Usersession</em>' reference.
	 * @see #getUsersession()
	 * @generated
	 */
	void setUsersession(Usersession value);

	/**
	 * Returns the value of the '<em><b>Last Updated</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Last Updated</em>' attribute isn't clear, there really should be more of a description
	 * here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Last Updated</em>' attribute.
	 * @see #setLastUpdated(Date)
	 * @see org.unicase.workspace.WorkspacePackage#getProjectSpace_LastUpdated()
	 * @model
	 * @generated
	 */
	Date getLastUpdated();

	/**
	 * Sets the value of the '{@link org.unicase.workspace.ProjectSpace#getLastUpdated <em>Last Updated</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Last Updated</em>' attribute.
	 * @see #getLastUpdated()
	 * @generated
	 */
	void setLastUpdated(Date value);

	/**
	 * Returns the value of the '<em><b>Base Version</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Base Version</em>' containment reference isn't clear, there really should be more of a
	 * description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Base Version</em>' containment reference.
	 * @see #setBaseVersion(PrimaryVersionSpec)
	 * @see org.unicase.workspace.WorkspacePackage#getProjectSpace_BaseVersion()
	 * @model containment="true" resolveProxies="true" required="true"
	 * @generated
	 */
	PrimaryVersionSpec getBaseVersion();

	/**
	 * Sets the value of the '{@link org.unicase.workspace.ProjectSpace#getBaseVersion <em>Base Version</em>}' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Base Version</em>' containment reference.
	 * @see #getBaseVersion()
	 * @generated
	 */
	void setBaseVersion(PrimaryVersionSpec value);

	/**
	 * Returns the value of the '<em><b>Resource Count</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Resource Count</em>' attribute isn't clear, there really should be more of a
	 * description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Resource Count</em>' attribute.
	 * @see #setResourceCount(int)
	 * @see org.unicase.workspace.WorkspacePackage#getProjectSpace_ResourceCount()
	 * @model
	 * @generated
	 */
	int getResourceCount();

	/**
	 * Sets the value of the '{@link org.unicase.workspace.ProjectSpace#getResourceCount <em>Resource Count</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Resource Count</em>' attribute.
	 * @see #getResourceCount()
	 * @generated
	 */
	void setResourceCount(int value);

	/**
	 * Returns the value of the '<em><b>Dirty</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Dirty</em>' attribute isn't clear, there really should be more of a description
	 * here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Dirty</em>' attribute.
	 * @see #setDirty(boolean)
	 * @see org.unicase.workspace.WorkspacePackage#getProjectSpace_Dirty()
	 * @model
	 * @generated
	 */
	boolean isDirty();

	/**
	 * Sets the value of the '{@link org.unicase.workspace.ProjectSpace#isDirty <em>Dirty</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value the new value of the '<em>Dirty</em>' attribute.
	 * @see #isDirty()
	 * @generated
	 */
	void setDirty(boolean value);

	/**
	 * Returns the value of the '<em><b>Old Log Messages</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.String}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Old Log Messages</em>' attribute list isn't clear, there really should be more of a
	 * description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Old Log Messages</em>' attribute list.
	 * @see org.unicase.workspace.WorkspacePackage#getProjectSpace_OldLogMessages()
	 * @model
	 * @generated
	 */
	EList<String> getOldLogMessages();

	/**
	 * Returns the value of the '<em><b>Local Operations</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Local Operations</em>' containment reference isn't clear, there really should be more
	 * of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Local Operations</em>' containment reference.
	 * @see #setLocalOperations(OperationComposite)
	 * @see org.unicase.workspace.WorkspacePackage#getProjectSpace_LocalOperations()
	 * @model containment="true" resolveProxies="true"
	 * @generated
	 */
	OperationComposite getLocalOperations();

	/**
	 * Sets the value of the '{@link org.unicase.workspace.ProjectSpace#getLocalOperations <em>Local Operations</em>}' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Local Operations</em>' containment reference.
	 * @see #getLocalOperations()
	 * @generated
	 */
	void setLocalOperations(OperationComposite value);

	/**
	 * Returns the value of the '<em><b>Notifications</b></em>' containment reference list.
	 * The list contents are of type {@link org.unicase.emfstore.esmodel.notification.ESNotification}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Notifications</em>' reference list isn't clear, there really should be more of a
	 * description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Notifications</em>' containment reference list.
	 * @see org.unicase.workspace.WorkspacePackage#getProjectSpace_Notifications()
	 * @model containment="true" resolveProxies="true"
	 * @generated
	 */
	EList<ESNotification> getNotifications();

	/**
	 * Returns the value of the '<em><b>Pending File Transfers</b></em>' containment reference list.
	 * The list contents are of type {@link org.unicase.workspace.PendingFileTransfer}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Pending File Transfers</em>' containment reference list isn't clear, there really
	 * should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Pending File Transfers</em>' containment reference list.
	 * @see org.unicase.workspace.WorkspacePackage#getProjectSpace_PendingFileTransfers()
	 * @model containment="true" resolveProxies="true"
	 * @generated
	 */
	EList<PendingFileTransfer> getPendingFileTransfers();

	/**
	 * Returns the value of the '<em><b>Event Composite</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Event Composite</em>' containment reference isn't clear, there really should be more
	 * of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Event Composite</em>' containment reference.
	 * @see #setEventComposite(EventComposite)
	 * @see org.unicase.workspace.WorkspacePackage#getProjectSpace_EventComposite()
	 * @model containment="true" resolveProxies="true"
	 * @generated
	 */
	EventComposite getEventComposite();

	/**
	 * Sets the value of the '{@link org.unicase.workspace.ProjectSpace#getEventComposite <em>Event Composite</em>}' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Event Composite</em>' containment reference.
	 * @see #getEventComposite()
	 * @generated
	 */
	void setEventComposite(EventComposite value);

	/**
	 * Returns the value of the '<em><b>Notification Composite</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Notification Composite</em>' containment reference isn't clear, there really should be
	 * more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Notification Composite</em>' containment reference.
	 * @see #setNotificationComposite(NotificationComposite)
	 * @see org.unicase.workspace.WorkspacePackage#getProjectSpace_NotificationComposite()
	 * @model containment="true" resolveProxies="true"
	 * @generated
	 */
	NotificationComposite getNotificationComposite();

	/**
	 * Sets the value of the '{@link org.unicase.workspace.ProjectSpace#getNotificationComposite <em>Notification Composite</em>}' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Notification Composite</em>' containment reference.
	 * @see #getNotificationComposite()
	 * @generated
	 */
	void setNotificationComposite(NotificationComposite value);

	/**
	 * <!-- begin-user-doc --> Commit the all pending changes of the project.
	 * 
	 * @return new base version
	 * @throws EmfStoreException if commit fails <!-- end-user-doc -->
	 * @model
	 * @param logMessage the {@link LogMessage} for this commit.
	 * @generated NOT
	 */
	PrimaryVersionSpec commit(LogMessage logMessage) throws EmfStoreException;

	/**
	 * <!-- begin-user-doc --> Commit the all pending changes of the project.
	 * 
	 * @return new base version
	 * @throws EmfStoreException if commit fails <!-- end-user-doc -->
	 * @model
	 * @generated NOT
	 */
	PrimaryVersionSpec commit() throws EmfStoreException;

	/**
	 * <!-- begin-user-doc --> Update the project to the head version.
	 * 
	 * @return the new base version
	 * @throws EmfStoreException if update fails <!-- end-user-doc -->
	 * @model
	 * @generated NOT
	 */
	PrimaryVersionSpec update() throws EmfStoreException;

	/**
	 * <!-- begin-user-doc --> Update the project to the given version.
	 * 
	 * @param version the version to update to
	 * @return the new base version
	 * @throws EmfStoreException if update fails <!-- end-user-doc -->
	 * @model
	 * @generated NOT
	 */
	PrimaryVersionSpec update(VersionSpec version) throws EmfStoreException;

	/**
	 * <!-- begin-user-doc --> Resolve a version spec to a primary version spec.
	 * 
	 * @param versionSpec the spec to resolve
	 * @return the primary version spec <!-- end-user-doc -->
	 * @throws EmfStoreException if resolving fails
	 * @model
	 * @generated NOT
	 */
	PrimaryVersionSpec resolveVersionSpec(VersionSpec versionSpec) throws EmfStoreException;

	/**
	 * Initialize the resources of the project space.
	 * 
	 * @param resourceSet the resource set the project space should use
	 */
	void initResources(ResourceSet resourceSet);

	/**
	 * Share the project of the project space with a given usersession.
	 * 
	 * @param usersession the usersession
	 * @throws EmfStoreException if sharing fails
	 */
	void shareProject(Usersession usersession) throws EmfStoreException;

	/**
	 * Export a project to a file with the given name.
	 * 
	 * @param fileName the file name
	 * @throws IOException if writing to the given file fails
	 */
	void exportProject(String fileName) throws IOException;

	/**
	 * Update the workspace to the given revision.
	 * 
	 * @param version the version to update to
	 * @param observer an observer that is notified of the changes performed by the update, maybe null
	 * @return the new base version
	 * @throws EmfStoreException if the update fails
	 * @throws ChangeConflictException if a conflict with local changes is detected
	 */
	PrimaryVersionSpec update(VersionSpec version, UpdateObserver observer) throws EmfStoreException,
		ChangeConflictException;

	/**
	 * Commit local changes to the server.
	 * 
	 * @param logMessage the log message
	 * @param commitObserver an observer that is notified about the changes being send to the server
	 * @return the new base version
	 * @throws EmfStoreException if the commit fails
	 * @throws BaseVersionOutdatedException if the project space is not up to date, that is its base version is lower
	 *             then the projects head revision
	 */
	PrimaryVersionSpec commit(LogMessage logMessage, CommitObserver commitObserver) throws EmfStoreException,
		BaseVersionOutdatedException;

	/**
	 * Export all local changes to a file with the given name.
	 * 
	 * @param fileName the file name
	 * @throws IOException if writing to the given file fails
	 */
	void exportLocalChanges(String fileName) throws IOException;

	/**
	 * Import changes from a file.
	 * 
	 * @param fileName the file name to import from
	 * @throws IOException if file access fails
	 */
	void importLocalChanges(String fileName) throws IOException;

	/**
	 * Undo the last operation of the projectSpace.
	 */
	void undoLastOperation();

	/**
	 * Add an event to the project space. Will be transfered to server on next commit.
	 * 
	 * @param event the event
	 */
	void addEvent(Event event);

	/**
	 * @return a list of the change packages between two PrimarySpecVersions.
	 * @param sourceVersion the source version spec
	 * @param targetVersion the target version spec
	 * @throws EmfStoreException if any error in the EmfStore occurs
	 * @generated NOT
	 */
	List<ChangePackage> getChanges(VersionSpec sourceVersion, VersionSpec targetVersion) throws EmfStoreException;

	/**
	 * Adds a tag to the specified version of this project.
	 * 
	 * @param versionSpec the versionSpec
	 * @param tag the tag
	 * @throws EmfStoreException if exception occurs on the server
	 */
	void addTag(PrimaryVersionSpec versionSpec, TagVersionSpec tag) throws EmfStoreException;

	/**
	 * Removes a tag to the specified version of this project.
	 * 
	 * @param versionSpec the versionSpec
	 * @param tag the tag
	 * @throws EmfStoreException if exception occurs on the server
	 */
	void removeTag(PrimaryVersionSpec versionSpec, TagVersionSpec tag) throws EmfStoreException;

	/**
	 * Return the list of operations that have already been performed on the project space.
	 * 
	 * @return a list of operations
	 * @generated NOT
	 */
	List<AbstractOperation> getOperations();

	/**
	 * Initialize the project space and its resources.
	 */
	void init();

	/**
	 * Revert all local changes in the project space. Returns the state of the project to that of the project space base
	 * version.
	 */
	void revert();

	/**
	 * Resolve the url to a model element.
	 * 
	 * @param modelElementUrlFragment the url
	 * @return the model element
	 * @throws MEUrlResolutionException if model element does not exist in project.
	 */
	EObject resolve(ModelElementUrlFragment modelElementUrlFragment) throws MEUrlResolutionException;

	/**
	 * Get a project info for the project space.
	 * 
	 * @return a project info
	 */
	ProjectInfo getProjectInfo();

	/**
	 * Will make the projectSpace transient, it will not make its content or changes persistent. Can only be called
	 * before the resources or the project space have been initialized.
	 */
	void makeTransient();

	/**
	 * Apply the merge result to the project space. Will revert all previous change and apply the given result.
	 * 
	 * @param mergeResult a list of operations resulting from a merge
	 * @param mergeTargetSpec the target spec to merge to
	 * @throws EmfStoreException if exception occurs on the server
	 */
	void applyMergeResult(List<AbstractOperation> mergeResult, VersionSpec mergeTargetSpec) throws EmfStoreException;

	/**
	 * Begin a composite operation on the projectSpace.
	 * 
	 * @return a handle to abort or complete the operation
	 */
	CompositeOperationHandle beginCompositeOperation();

	/**
	 * @param fileInformation file information data object
	 * @param selectedFile file to upload, null if there is no file to upload (in case of download)
	 * @param upload true if upload, false if download
	 * @param run true if transfer is to be started instantaneously
	 * @throws FileTransferException if any error occurs adding the file transfer
	 */
	void addFileTransfer(FileInformation fileInformation, File selectedFile, boolean upload, boolean run)
		throws FileTransferException;

	/**
	 * Add a commit observer to the project space.
	 * 
	 * @param observer a project commit observer
	 */
	void addCommitObserver(CommitObserver observer);

	/**
	 * Remove a commit observer from the project space.
	 * 
	 * @param observer a project commit observer
	 */
	void removeCommitObserver(CommitObserver observer);

	/**
	 * Gathers all local operations and canonizes them.
	 * 
	 * @param canonized true if the operations should be canonized
	 * @return the list of operations
	 */
	ChangePackage getLocalChangePackage(boolean canonized);

	/**
	 * @return modified model elements cache. This is class clients (e.g. dirty decorator) can ask to see if a model
	 *         element has been modified.
	 */
	ModifiedModelElementsCache getModifiedModelElementsCache();

	/**
	 * Adds an OperationListener to list of operation listeners. OperationListeners are informed when ever an operation
	 * is executed or undone.
	 * 
	 * @param operationListener operation listener
	 */
	void addOperationListener(OperationListener operationListener);

	/**
	 * @param name the name of the property
	 * @return the string value of the property or null if it doesn't exist
	 * @throws PropertyNotFoundException if no property exists for this key
	 * @generated NOT
	 */
	OrgUnitProperty getProperty(PropertyKey name) throws PropertyNotFoundException;

	/**
	 * Sets a new OrgUnitProperty for the current user.
	 * 
	 * @param property the new property
	 * @generated NOT
	 */
	void setProperty(OrgUnitProperty property);

	/**
	 * @return if the the property is set.
	 * @param key the property key.
	 */
	boolean hasProperty(PropertyKey key);

	/**
	 * Return all notifications that have been generated for this project space.
	 * 
	 * @return a list of notifications ordered by time
	 */
	List<ESNotification> getNotificationsFromComposite();

	/**
	 * Removes an operatoin listener.
	 * 
	 * @param operationListner operation listener
	 */
	void removeOperationListener(OperationListener operationListner);

	/**
	 * Removes a pending file transfer.
	 * 
	 * @param fileAttachmentId file attachment id
	 */
	void removePendingFileUpload(String fileAttachmentId);

	/**
	 * Transmit the OrgUnitproperties to the server.
	 * 
	 * @generated NOT
	 */
	void transmitProperties();

	/**
	 * Merge the changes from current base version to given target version with the local operations.
	 * 
	 * @param target target version
	 * @param conflictResolver a conflict resolver that will actually perform the conflict resolution
	 * @throws EmfStoreException if the conncection to the server fails
	 */
	void merge(PrimaryVersionSpec target, ConflictResolver conflictResolver) throws EmfStoreException;

	/**
	 * Shows whether projectSpace is transient.
	 * 
	 * @return true, if transient.
	 */
	boolean isTransient();

	/**
	 * @param fileInformation file info
	 * @param upload if true, download if false
	 * @return if transfer exists
	 */
	boolean hasFileTransfer(FileInformation fileInformation, boolean upload);

	/**
	 * @param file to be added to the projectspace
	 * @return file identifier to retrieve file with
	 * @throws FileTransferException if any error occurs
	 */
	String addFile(File file) throws FileTransferException;

	/**
	 * @param fileIdentifier file identifier string
	 * @return handler
	 * @throws FileTransferException if any error occurs retrieving the files
	 */
	FileRequestHandler getFile(String fileIdentifier) throws FileTransferException;

} // ProjectContainer
