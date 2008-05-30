package org.unicase.emfstore.accesscontrol;

import org.unicase.emfstore.esmodel.SessionId;
import org.unicase.emfstore.exceptions.EmfStoreException;

public interface AuthenticationControl {
	
	/**
	 * Log into the server given by server info. 
	 * 
	 * @param username
	 *            the user name
	 * @param password
	 *            the password
	 * @return a session id that can be used for later authentication
	 * @throws EmfStoreException
	 *             if any error in the EmfStore occurs
	 * 
	 * @generated NOT
	 */
	SessionId logIn(String username, String password) throws AccessControlException;

}
