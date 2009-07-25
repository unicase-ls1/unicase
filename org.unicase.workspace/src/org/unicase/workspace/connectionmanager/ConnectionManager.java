/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.workspace.connectionmanager;

import org.unicase.emfstore.EmfStore;
import org.unicase.emfstore.esmodel.ClientVersionInfo;
import org.unicase.emfstore.esmodel.SessionId;
import org.unicase.emfstore.exceptions.AccessControlException;
import org.unicase.emfstore.exceptions.ConnectionException;
import org.unicase.emfstore.exceptions.EmfStoreException;
import org.unicase.workspace.ServerInfo;

/**
 * The connection manager manages the connection to eh emf store. It will initiate, reinitiate and terminate the
 * connection as needed.
 * 
 * @author Maximilian Koegel
 * @generated NOT
 */
public interface ConnectionManager extends EmfStore {

	/**
	 * Log into the server given by server info. The connection manager will also remember the serverInfo associated
	 * with the session id.
	 * 
	 * @param username the user name
	 * @param password the password
	 * @param severInfo the server info for the server to log into
	 * @param clientVersionInfo the client's version
	 * @return a session id that can be used for later authentication
	 * @throws ConnectionException if the connection can not be established
	 * @throws AccessControlException if access is denied
	 * @generated NOT
	 */
	SessionId logIn(String username, String password, ServerInfo severInfo, ClientVersionInfo clientVersionInfo)
		throws ConnectionException, AccessControlException;

	/**
	 * Deletes a session on the server.
	 * 
	 * @param sessionId id to be deleted.
	 * @throws EmfStoreException in case of failure on server
	 */
	void logout(SessionId sessionId) throws EmfStoreException;
}
