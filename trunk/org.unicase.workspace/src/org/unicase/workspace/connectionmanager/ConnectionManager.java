package org.unicase.workspace.connectionmanager;

import java.util.List;

import org.unicase.esmodel.ProjectInfo;
import org.unicase.esmodel.SessionId;
import org.unicase.esmodel.changemanagment.ChangePackage;
import org.unicase.esmodel.changemanagment.HistoryInfo;
import org.unicase.esmodel.changemanagment.LogMessage;
import org.unicase.esmodel.changemanagment.PrimaryVersionSpec;
import org.unicase.esmodel.changemanagment.VersionSpec;
import org.unicase.model.Project;
import org.unicase.model.ProjectId;
import org.unicase.workspace.ConnectionException;
import org.unicase.workspace.ServerInfo;

/**
 * The connection manager manages the connection to eh emf store. It will
 * initiate, reinitiate and terminate the connection as needed.
 * 
 * @author Maximilian Koegel
 * 
 * 
 * @generated NOT
 */
public interface ConnectionManager {

	/**
	 * Log into the server given by server info. The connection manager will
	 * also remember the serverInfo associated with the session id.
	 * 
	 * @param username
	 *            the user name
	 * @param password
	 *            the password
	 * @param severInfo
	 *            the server info for the server to log into
	 * @return a session id that can be used for later authentication
	 * @throws ConnectionException
	 *             if the connection can not be established
	 * 
	 * @generated NOT
	 */
	SessionId logIn(String username, String password, ServerInfo severInfo)
			throws ConnectionException;

	/**
	 * Get a list of projects the user of the session id can access. The server
	 * should is determined by the session id.
	 * 
	 * @param sessionId
	 *            the session id for authentication
	 * @return a list of project infos for the projects the user can access
	 * @throws ConnectionException
	 *             if the connection can not be established
	 * 
	 * @generated NOT
	 */
	List<ProjectInfo> getProjectList(SessionId sessionId)
			throws ConnectionException;

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
	 * @throws ConnectionException
	 *             if the connection can not be established
	 * 
	 * @generated NOT
	 */
	Project getProject(SessionId sessionId, ProjectId projectId,
			VersionSpec versionSpec) throws ConnectionException;

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
	 * @throws ConnectionException
	 *             if the connection can not be established
	 * 
	 * @generated NOT
	 */
	PrimaryVersionSpec createVersion(SessionId sessionId, ProjectId projectId,
			PrimaryVersionSpec baseVersionSpec, ChangePackage changePackage,
			LogMessage logMessage) throws ConnectionException;

	/**
	 * Resolve a version specified to a primary version specifier.
	 * 
	 * @param sessionId
	 *            the session id for authentication
	 * @param versionSpec
	 *            the version specifier to resolve
	 * @return a primary version specifier identifing the same version
	 * @throws ConnectionException
	 *             if the connection can not be established
	 * @generated NOT
	 */
	PrimaryVersionSpec resolveVersionSpec(SessionId sessionId,
			VersionSpec versionSpec) throws ConnectionException;

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
	 * @throws ConnectionException
	 *             if the connection can not be established
	 * 
	 * @generated NOT
	 */
	List<ChangePackage> getChanges(SessionId sessionId, ProjectId projectId,
			VersionSpec source, VersionSpec target) throws ConnectionException;

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
	 * @throws ConnectionException
	 *             if the connection can not be established
	 * 
	 * @generated NOT
	 */
	List<HistoryInfo> getHistoryInfo(SessionId sessionId, ProjectId projectId,
			VersionSpec source, VersionSpec target) throws ConnectionException;
}
