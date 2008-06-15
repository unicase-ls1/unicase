/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Kšgel All rights reserved. This program and the accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this distribution, and is available at http://www.eclipse.org/legal/epl-v10.html
 * </copyright>
 *
 * $Id$
 */
package org.unicase.emfstore;

import java.util.List;

import org.unicase.emfstore.esmodel.ProjectId;
import org.unicase.emfstore.esmodel.ProjectInfo;
import org.unicase.emfstore.esmodel.SessionId;
import org.unicase.emfstore.esmodel.changemanagment.ChangePackage;
import org.unicase.emfstore.esmodel.changemanagment.HistoryInfo;
import org.unicase.emfstore.esmodel.changemanagment.LogMessage;
import org.unicase.emfstore.esmodel.changemanagment.PrimaryVersionSpec;
import org.unicase.emfstore.esmodel.changemanagment.VersionSpec;
import org.unicase.emfstore.exceptions.EmfStoreException;
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
/**
 * @author koegel
 *
 */
public interface EmfStore {

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
	 * Get a project in a certain revision from the server.
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
	 * @throws EmfStoreException
	 *             if any error in the EmfStore occurs
	 * 
	 * @generated NOT
	 */
	PrimaryVersionSpec createVersion(SessionId sessionId, ProjectId projectId,
			PrimaryVersionSpec baseVersionSpec, ChangePackage changePackage,
			LogMessage logMessage) throws EmfStoreException;

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
	 * the versions from source to target.
	 * 
	 * @param sessionId
	 *            the session id for authentication
	 * @param projectId
	 *            the project id
	 * @param source
	 *            the source version specifier
	 * @param target
	 *            the target version specifier
	 * @return a list of history information
	 * @throws EmfStoreException
	 *             if any error in the EmfStore occurs
	 * 
	 * @generated NOT
	 */
	List<HistoryInfo> getHistoryInfo(SessionId sessionId, ProjectId projectId,
			VersionSpec source, VersionSpec target) throws EmfStoreException;

	/**
	 * Create a new project on the server.
	 * 
	 * @param name
	 *            the name of the server
	 * @param description
	 *            the description
	 * @return a {@link ProjectInfo} for the new project
	 * @throws EmfStoreException
	 *             if any error in the EmfStore occurs
	 * 
	 * @generated NOT
	 */
	ProjectInfo createProject(SessionId sessionid, String name,
			String description, LogMessage logMessage) throws EmfStoreException;
}
