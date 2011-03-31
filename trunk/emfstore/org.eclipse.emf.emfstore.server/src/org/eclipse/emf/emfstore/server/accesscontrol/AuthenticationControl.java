/*******************************************************************************
 * Copyright (c) 2008-2011 Chair for Applied Software Engineering, Technische Universitaet Muenchen.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 ******************************************************************************/
package org.eclipse.emf.emfstore.server.accesscontrol;

import org.eclipse.emf.emfstore.server.exceptions.AccessControlException;
import org.eclipse.emf.emfstore.server.model.ClientVersionInfo;
import org.eclipse.emf.emfstore.server.model.SessionId;

/**
 * Controler for the Authentication of users.
 * 
 * @author koegel
 */
public interface AuthenticationControl {

	/**
	 * Log into the server given by server info.
	 * 
	 * @param username the user name
	 * @param password the password
	 * @param clientVersionInfo the client's version
	 * @return a session id that can be used for later authentication
	 * @throws AccessControlException if any error in the EmfStore occurs
	 * @generated NOT
	 */
	SessionId logIn(String username, String password, ClientVersionInfo clientVersionInfo)
		throws AccessControlException;

	/**
	 * Deletes a session on the server.
	 * 
	 * @param sessionId id to be deleted.
	 * @throws AccessControlException in case of failure on server
	 */
	void logout(SessionId sessionId) throws AccessControlException;

}
