/*******************************************************************************
 * Copyright (c) 2008-2011 Chair for Applied Software Engineering,
 * Technische Universitaet Muenchen.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 ******************************************************************************/
package org.eclipse.emf.emfstore.server;

import java.util.List;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.emfstore.common.model.EMFStoreProperty;
import org.eclipse.emf.emfstore.common.model.Project;
import org.eclipse.emf.emfstore.server.exceptions.EmfStoreException;
import org.eclipse.emf.emfstore.server.exceptions.InvalidVersionSpecException;
import org.eclipse.emf.emfstore.server.filetransfer.FileChunk;
import org.eclipse.emf.emfstore.server.filetransfer.FileTransferInformation;
import org.eclipse.emf.emfstore.server.model.ProjectHistory;
import org.eclipse.emf.emfstore.server.model.ProjectId;
import org.eclipse.emf.emfstore.server.model.ProjectInfo;
import org.eclipse.emf.emfstore.server.model.SessionId;
import org.eclipse.emf.emfstore.server.model.accesscontrol.ACOrgUnitId;
import org.eclipse.emf.emfstore.server.model.accesscontrol.ACUser;
import org.eclipse.emf.emfstore.server.model.accesscontrol.OrgUnitProperty;
import org.eclipse.emf.emfstore.server.model.versioning.ChangePackage;
import org.eclipse.emf.emfstore.server.model.versioning.HistoryInfo;
import org.eclipse.emf.emfstore.server.model.versioning.HistoryQuery;
import org.eclipse.emf.emfstore.server.model.versioning.LogMessage;
import org.eclipse.emf.emfstore.server.model.versioning.PrimaryVersionSpec;
import org.eclipse.emf.emfstore.server.model.versioning.TagVersionSpec;
import org.eclipse.emf.emfstore.server.model.versioning.VersionSpec;

/**
 * An EMF store is responsible for storing projects, change management on
 * projects and for persisting projects.
 * 
 * @author Maximilian Koegel
 * @generated NOT
 */
public interface EmfStore extends EmfStoreInterface {

	/**
	 * Virtual Uri for change package de-/serialization.
	 */
	URI CHANGEPACKAGE_URI = URI.createURI("emfstoreVirtualChangePackageUri");

	/**
	 * Virtual Uri for project de-/serialization.
	 */
	URI PROJECT_URI = URI.createURI("emfstoreVirtualProjectUri");

	/**
	 * Get a list of projects the user of the session id can access. The server
	 * should is determined by the session id.
	 * 
	 * @param sessionId
	 *            the session id for authentication
	 * @return a list of project infos for the projects the user can access
	 * @throws EmfStoreException
	 *             if any error in the EmfStore occurs
	 * @generated NOT
	 */
	List<ProjectInfo> getProjectList(SessionId sessionId)
			throws EmfStoreException;

	/**
	 * Gets a project in a certain revision from the server. Depending on your
	 * persistence properties, this method can become expensive because it has
	 * to recalculate the requested project state.
	 * 
	 * @see ServerConfiguration#PROJECTSTATE_VERSION_PERSISTENCE
	 * @param sessionId
	 *            the session id for authentication
	 * @param projectId
	 *            the project id of the project to get
	 * @param versionSpec
	 *            the version to get
	 * @return a project in the specified revision
	 * @throws EmfStoreException
	 *             if any error in the EmfStore occurs
	 * @generated NOT
	 */
	Project getProject(SessionId sessionId, ProjectId projectId,
			VersionSpec versionSpec) throws EmfStoreException;

	/**
	 * Create a new version on the server of the given project.
	 * 
	 * @param sessionId
	 *            the session id for authentication
	 * @param projectId
	 *            the project id
	 * @param baseVersionSpec
	 *            the version the project was last synched with the server
	 * @param changePackage
	 *            the changes performed on the project since last synch
	 * @param logMessage
	 *            the log message for the new version
	 * @return the version specifier of the version created on the server
	 * @throws InvalidVersionSpecException
	 *             if the base version is not equal to the current head
	 *             revision.
	 * @throws EmfStoreException
	 *             if any error in the EmfStore occurs
	 * @generated NOT
	 */
	PrimaryVersionSpec createVersion(SessionId sessionId, ProjectId projectId,
			PrimaryVersionSpec baseVersionSpec, ChangePackage changePackage,
			LogMessage logMessage) throws EmfStoreException,
			InvalidVersionSpecException;

	/**
	 * Resolve a version specified to a primary version specifier.
	 * 
	 * @param sessionId
	 *            the session id for authentication
	 * @param versionSpec
	 *            the version specifier to resolve
	 * @param projectId
	 *            the project id
	 * @return a primary version specifier identifing the same version
	 * @throws EmfStoreException
	 *             if any error in the EmfStore occurs
	 * @generated NOT
	 */
	PrimaryVersionSpec resolveVersionSpec(SessionId sessionId,
			ProjectId projectId, VersionSpec versionSpec)
			throws EmfStoreException;

	/**
	 * Get changes from the server.
	 * 
	 * @param sessionId
	 *            the session id for authentication
	 * @param projectId
	 *            the project id
	 * @param source
	 *            the source version specifier
	 * @param target
	 *            the target version specifier
	 * @return a list of change packages from source to target representing the
	 *         changes that happened between the two versions.
	 * @throws EmfStoreException
	 *             if any error in the EmfStore occurs
	 * @generated NOT
	 */
	List<ChangePackage> getChanges(SessionId sessionId, ProjectId projectId,
			VersionSpec source, VersionSpec target) throws EmfStoreException;

	/**
	 * Get history information from the server. The list returned will describe
	 * the versions as request through {@link HistoryQuery}.
	 * 
	 * @param sessionId
	 *            the session id
	 * @param projectId
	 *            the project id
	 * @param historyQuery
	 *            the historyQuery
	 * @return list of history information
	 * @throws EmfStoreException
	 *             if any error in the EmfStore occurs
	 * @generated NOT
	 */
	List<HistoryInfo> getHistoryInfo(SessionId sessionId, ProjectId projectId,
			HistoryQuery historyQuery) throws EmfStoreException;

	/**
	 * Adds a tag to a version of the specified project.
	 * 
	 * @param sessionId
	 *            the session id
	 * @param projectId
	 *            the project id
	 * @param versionSpec
	 *            the version versionSpec
	 * @param tag
	 *            the tag
	 * @throws EmfStoreException
	 *             if any error in the EmfStore occurs
	 */
	void addTag(SessionId sessionId, ProjectId projectId,
			PrimaryVersionSpec versionSpec, TagVersionSpec tag)
			throws EmfStoreException;

	/**
	 * Removes a tag to a version of the specified project.
	 * 
	 * @param sessionId
	 *            the session id
	 * @param projectId
	 *            the project id
	 * @param versionSpec
	 *            the version versionSpec
	 * @param tag
	 *            the tags
	 * @throws EmfStoreException
	 *             if any error in the EmfStore occurs
	 */
	void removeTag(SessionId sessionId, ProjectId projectId,
			PrimaryVersionSpec versionSpec, TagVersionSpec tag)
			throws EmfStoreException;

	/**
	 * Create a new project on the server.
	 * 
	 * @param sessionId
	 *            the session id for authentication
	 * @param name
	 *            the name of the server
	 * @param description
	 *            the description
	 * @param logMessage
	 *            the logMessage
	 * @return a {@link ProjectInfo} for the new project
	 * @throws EmfStoreException
	 *             if any error in the EmfStore occurs
	 * @generated NOT
	 */
	ProjectInfo createEmptyProject(SessionId sessionId, String name,
			String description, LogMessage logMessage) throws EmfStoreException;

	/**
	 * Create a new project on the server. This createProject method allows to
	 * create a project on the server with initial projectstate (share project).
	 * 
	 * @param sessionId
	 *            the session id for authentication
	 * @param name
	 *            the name of the server
	 * @param description
	 *            the description
	 * @param logMessage
	 *            the logMessage
	 * @param project
	 *            the initial project state
	 * @return a {@link ProjectInfo} for the new project
	 * @throws EmfStoreException
	 *             if any error in the EmfStore occurs
	 * @generated NOT
	 */
	ProjectInfo createProject(SessionId sessionId, String name,
			String description, LogMessage logMessage, Project project)
			throws EmfStoreException;

	/**
	 * Deletes a project on the server. It's possible to delete the project from
	 * the containment tree and if wanted to deleted the related files too.
	 * 
	 * @param sessionId
	 *            the session id
	 * @param projectId
	 *            the project id
	 * @param deleteFiles
	 *            if true, the project files will be deleted too
	 * @throws EmfStoreException
	 *             in case of failure
	 */
	void deleteProject(SessionId sessionId, ProjectId projectId,
			boolean deleteFiles) throws EmfStoreException;

	/**
	 * Resolves a user by id and returns an ACUser with all roles on the server.
	 * Also roles from groups are aggregated and added to the user. To resolve
	 * other user than the requesting user himself, the user has to have admin
	 * access rights. If id is null, the requesting user will be resolved.
	 * 
	 * @param sessionId
	 *            session id
	 * @param id
	 *            user id, can be null, then requesting user gets resolved
	 * @return ACuser with all roles on the server
	 * @throws EmfStoreException
	 *             if any error in the EmfStore occurs
	 */
	ACUser resolveUser(SessionId sessionId, ACOrgUnitId id)
			throws EmfStoreException;

	/**
	 * Imports a project history to the server. The project history elements
	 * such as version, projecstate etc will be devided in several files on the
	 * server file system. The server will try to use the specified project id,
	 * if it already exists a new id is generated.
	 * 
	 * @param sessionId
	 *            sessionid
	 * @param projectHistory
	 *            project history
	 * @return projectId
	 * @throws EmfStoreException
	 *             in case of failure
	 */
	ProjectId importProjectHistoryToServer(SessionId sessionId,
			ProjectHistory projectHistory) throws EmfStoreException;

	/**
	 * Exports a given project history from the server. Caution if you try to
	 * export big projects from the server.
	 * 
	 * @param sessionId
	 *            session id
	 * @param projectId
	 *            project id
	 * @return a projecthistory
	 * @throws EmfStoreException
	 *             in case of failure
	 */
	ProjectHistory exportProjectHistoryFromServer(SessionId sessionId,
			ProjectId projectId) throws EmfStoreException;

	/**
	 * Uploads a file chunk to the server.
	 * 
	 * @param sessionId
	 *            session id
	 * @param projectId
	 *            project id
	 * @param fileChunk
	 *            file chunk
	 * @return FileVersion denoting the current file version to be written to
	 * @throws EmfStoreException
	 *             if any error occurs in the EmfStore
	 */
	FileTransferInformation uploadFileChunk(SessionId sessionId,
			ProjectId projectId, FileChunk fileChunk) throws EmfStoreException;

	/**
	 * Downloads a file chunk from the server.
	 * 
	 * @param sessionId
	 *            session id
	 * @param projectId
	 *            project id
	 * @param fileInformation
	 *            file information
	 * @return FileChunk
	 * @throws EmfStoreException
	 *             if any error occurs in the EmfStore
	 */
	FileChunk downloadFileChunk(SessionId sessionId, ProjectId projectId,
			FileTransferInformation fileInformation) throws EmfStoreException;

	/**
	 * @param sessionId
	 *            session id
	 * @param changedProperty
	 *            the property that has been changed client-side
	 * @param tmpUser
	 *            the respective user
	 * @param projectId
	 *            the project id
	 * @throws EmfStoreException
	 *             if any error occurs in the EmfStore
	 */
	void transmitProperty(SessionId sessionId, OrgUnitProperty changedProperty,
			ACUser tmpUser, ProjectId projectId) throws EmfStoreException;

	/**
	 * Store EMFProperties on the server.
	 * 
	 * @param sessionId
	 *            sessionId
	 * @param property
	 *            property which shall be shared on the server.
	 * @param projectId
	 *            the project id
	 * @throws EmfStoreException
	 *             if any error occurs in the EmfStore
	 * */
	void transmitEMFProperties(SessionId sessionId, EMFStoreProperty property,
			ProjectId projectId) throws EmfStoreException;

	/**
	 * Get stored EMFStoreProperties from the server.
	 * 
	 * @param sessionId
	 *            sessionId
	 * @param projectId
	 *            the projct id
	 * 
	 * @return list of EMFStoreProperties
	 * 
	 * @throws EmfStoreException
	 *             if any error occurs in the EmfStore
	 * 
	 * **/
	List<EMFStoreProperty> getEMFProperties(SessionId sessionId,
			ProjectId projectId) throws EmfStoreException;

}
