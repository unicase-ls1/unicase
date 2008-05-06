package org.unicase.workspace.connectionmanager;

import org.unicase.emfstore.EmfStore;
import org.unicase.emfstore.accesscontrol.AccessControlException;
import org.unicase.esmodel.SessionId;
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
public interface ConnectionManager extends EmfStore {

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
	 * @throws AccessControlException
	 *             if access is denied
	 * 
	 * @generated NOT
	 */
	SessionId logIn(String username, String password, ServerInfo severInfo)
			throws ConnectionException, AccessControlException;
}
