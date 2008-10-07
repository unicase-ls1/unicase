/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this distribution, and is available at http://www.eclipse.org/legal/epl-v10.html
 * </copyright>
 *
 * $Id$
 */
package org.unicase.emfstore;

import java.util.List;

import org.eclipse.emf.common.util.URI;
import org.unicase.emfstore.esmodel.ProjectId;
import org.unicase.emfstore.esmodel.ProjectInfo;
import org.unicase.emfstore.esmodel.SessionId;
import org.unicase.emfstore.esmodel.accesscontrol.ACOrgUnitId;
import org.unicase.emfstore.esmodel.accesscontrol.ACUser;
import org.unicase.emfstore.esmodel.versioning.ChangePackage;
import org.unicase.emfstore.esmodel.versioning.HistoryInfo;
import org.unicase.emfstore.esmodel.versioning.HistoryQuery;
import org.unicase.emfstore.esmodel.versioning.LogMessage;
import org.unicase.emfstore.esmodel.versioning.PrimaryVersionSpec;
import org.unicase.emfstore.esmodel.versioning.VersionSpec;
import org.unicase.emfstore.exceptions.EmfStoreException;
import org.unicase.emfstore.exceptions.InvalidVersionSpecException;
import org.unicase.model.Project;

/**
 * An EMF store is responsible for storing projects, change management on
 * projects and for persisting projects.
 * 
 * @author Maximilian Koegel
 * 
 * 
 * @generated NOT
 */
public interface EmfStore {

	/**
	 * Virtual Uri for change package de-/serialization.
	 */
	URI CHANGEPACKAGE_URI = URI.createURI("unicaseVirtualChangePackageUri");

	/**
	 * Virtual Uri for project de-/serialization.
	 */
	URI PROJECT_URI = URI.createURI("unicaseVirtualProjectUri");

	/**
	 * Get a list of projects the user of the session id can access. The server
	 * should is determined by the session id.
	 * 
	 * @param sessionId
	 *            the session id for authentication
	 * @return a list of project infos for the projects the user can access
	 * @throws EmfStoreException
	 *             if any error in the EmfStore occurs
	 * 
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
	 * 
	 * @param sessionId
	 *            the session id for authentication
	 * @param projectId
	 *            the project id of the project to get
	 * @param versionSpec
	 *            the version to get
	 * @return a project in the specified revision
	 * @throws EmfStoreException
	 *             if any error in the EmfStore occurs
	 * 
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
	 * 
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
	 * 
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
	 * 
	 * @generated NOT
	 */
	List<HistoryInfo> getHistoryInfo(SessionId sessionId, ProjectId projectId,
			HistoryQuery historyQuery) throws EmfStoreException;

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
	 * 
	 * @generated NOT
	 */
	ProjectInfo createProject(SessionId sessionId, String name,
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
	 * 
	 * @return a {@link ProjectInfo} for the new project
	 * @throws EmfStoreException
	 *             if any error in the EmfStore occurs
	 * 
	 * @generated NOT
	 */
	ProjectInfo createProject(SessionId sessionId, String name,
			String description, LogMessage logMessage, Project project)
			throws EmfStoreException;

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

}
