/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Kšgel. All rights reserved. This program and the accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this distribution, and is available at http://www.eclipse.org/legal/epl-v10.html
 * </copyright>
 *
 * $Id$
 */
package org.unicase.emfstore.connection.rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import org.unicase.emfstore.accesscontrol.AccessControlException;
import org.unicase.emfstore.exceptions.EmfStoreException;

/**
 * Facade for the RMIConnectionManager. Part of the RMI transport layer.
 * @author wesendonk
 *
 */
public interface RMIEmfStoreFacade extends Remote {

	/**
	 * String typed implementation of method in {@link EmfStore}.
	 * @see org.unicase.emfstore.EmfStore#getProjectList(org.unicase.emfstore.esmodel.SessionId)
	 * @param sessionId session id
	 * @return list of projects
	 * @throws RemoteException if RMI remote invocation fails
	 * @throws EmfStoreException if a problem in the element store occurs
	 */
	List<String> getProjectList(String sessionId)
			throws RemoteException, EmfStoreException;

	/**
	 * String typed implementation of method in {@link EmfStore}.
	 * @see org.unicase.emfstore.EmfStore#getProject(org.unicase.emfstore.esmodel.SessionId, org.unicase.emfstore.esmodel.ProjectId, org.unicase.emfstore.esmodel.changemanagment.VersionSpec).
	 * @param sessionId the session id
	 * @param projectId the project id
	 * @param versionSpec the version spec
	 * @return the project
	 * @throws RemoteException if RMI remote invocation fails
	 * @throws EmfStoreException if a problem in the element store occurs
	 */
	String getProject(String sessionId, String projectId,
			String versionSpec) throws RemoteException, EmfStoreException;

	/**
	 * String typed implementation of method in {@link EmfStore}.
	 * @see org.unicase.emfstore.EmfStore#createVersion(org.unicase.emfstore.esmodel.SessionId, org.unicase.emfstore.esmodel.ProjectId, org.unicase.emfstore.esmodel.changemanagment.PrimaryVersionSpec, org.unicase.emfstore.esmodel.changemanagment.ChangePackage, org.unicase.emfstore.esmodel.changemanagment.LogMessage)
	 * @param sessionId the session id
	 * @param projectId the project id
	 * @param baseVersionSpec the base version
	 * @param changePackage the change package
	 * @param logMessage the log message
	 * @return the new primary version spec
	 * @throws RemoteException if RMI remote invocation fails
	 * @throws EmfStoreException if a problem in the element store occurs
	 */
	 String createVersion(String sessionId, String projectId,
			String baseVersionSpec, String changePackage, String logMessage)
			throws RemoteException, EmfStoreException;

	/**
	 * String typed implementation of method in {@link EmfStore}.
	 * @see org.unicase.emfstore.EmfStore#resolveVersionSpec(org.unicase.emfstore.esmodel.SessionId, org.unicase.emfstore.esmodel.ProjectId, org.unicase.emfstore.esmodel.changemanagment.VersionSpec))
	 * @param sessionId the session id
	 * @param projectId the project id
	 * @param versionSpec the version spec
	 * @return the primary spec
	 * @throws RemoteException if RMI remote invocation fails
	 * @throws EmfStoreException if a problem in the element store occurs
	 */
	 String resolveVersionSpec(String sessionId, String projectId,
			String versionSpec) throws RemoteException, EmfStoreException;
	
	/**
	 * String typed implementation of method in {@link EmfStore}.
	 * @see org.unicase.emfstore.EmfStore#getChanges(org.unicase.emfstore.esmodel.SessionId, org.unicase.emfstore.esmodel.ProjectId, org.unicase.emfstore.esmodel.changemanagment.VersionSpec, org.unicase.emfstore.esmodel.changemanagment.VersionSpec)
	 * @param sessionId the session
	 * @param projectId the project id
	 * @param source the source version
	 * @param target the target version
	 * @return a list of change packages
	 * @throws RemoteException if RMI remote invocation fails
	 * @throws EmfStoreException if a problem in the element store occurs
	 */
	 List<String> getChanges(String sessionId, String projectId,
			String source, String target) throws RemoteException,
			EmfStoreException;

	/**
	 * String typed implementation of method in {@link EmfStore}.
	 * @see org.unicase.emfstore.EmfStore#getHistoryInfo(org.unicase.emfstore.esmodel.SessionId, org.unicase.emfstore.esmodel.ProjectId, org.unicase.emfstore.esmodel.changemanagment.VersionSpec, org.unicase.emfstore.esmodel.changemanagment.VersionSpec)
	 * @param sessionId the session id
	 * @param projectId the project id
	 * @param source the source version
	 * @param target the target version
	 * @return a list of history infos
	 * @throws RemoteException if RMI remote invocation fails
	 * @throws EmfStoreException if a problem in the element store occurs
	 */
	 List<String> getHistoryInfo(String sessionId, String projectId,
			String source, String target) throws RemoteException,
			EmfStoreException;

	/**
	 * String typed implementation of method in {@link EmfStore}.
	 * @see org.unicase.emfstore.EmfStore#createProject(org.unicase.emfstore.esmodel.SessionId, String, String, org.unicase.emfstore.esmodel.changemanagment.LogMessage)
	 * @param sessionId the session id 
	 * @param name the name
	 * @param description the description
	 * @param logMessage the log message
	 * @return the project id
	 * @throws RemoteException if RMI remote invocation fails
	 * @throws EmfStoreException if a problem in the element store occurs
	 */
	 String createProject(String sessionId, String name,
			String description, String logMessage) throws RemoteException,
			EmfStoreException;

	/**
	 * String typed implementation of method in {@link EmfStore}.
	 * @see org.unicase.emfstore.accesscontrol.AuthenticationControl#logIn(String, String)
	 * @param username the user name
	 * @param password the password
	 * @param serverInfo the server info
	 * @return the session id
	 * @throws RemoteException if RMI remote invocation fails
	 * @throws AccessControlException if access was denied
	 */
	 String login(String username, String password, String serverInfo)
			throws RemoteException, AccessControlException;

	//FIXME: can we remove this?
	 void sendString(String str) throws RemoteException;

}
