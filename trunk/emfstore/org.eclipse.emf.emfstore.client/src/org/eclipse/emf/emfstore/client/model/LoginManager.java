/*******************************************************************************
 * Copyright (c) 2008-2011 Chair for Applied Software Engineering, Technische Universitaet Muenchen.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 ******************************************************************************/
package org.eclipse.emf.emfstore.client.model;

import org.eclipse.emf.emfstore.client.model.connectionmanager.KeyStoreManager;
import org.eclipse.emf.emfstore.client.model.impl.UsersessionImpl;
import org.eclipse.emf.emfstore.server.exceptions.AccessControlException;
import org.eclipse.emf.emfstore.server.exceptions.EmfStoreException;

/**
 * Controller class to carry out the session procedures.
 * 
 * @author Shterev
 */
public final class LoginManager {

	private LoginManager() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * Login using the given session.
	 * 
	 * @throws AccessControlException if login fails.
	 * @throws EmfStoreException if anything else fails.
	 * @param session the usersession
	 */
	public static void login(Usersession session) throws AccessControlException, EmfStoreException {
		session.logIn();
	}

	/**
	 * Sends a logout call to the server.
	 * 
	 * @param session the usersession.
	 * @throws EmfStoreException forwards any exception.
	 */
	public static void logout(Usersession session) throws EmfStoreException {
		session.logout();
	}

	/**
	 * Sets a new password for the given session.
	 * 
	 * @param session the usersession.
	 * @param newPassword the new password
	 */
	public static void setPassword(Usersession session, String newPassword) {
		if (newPassword != null) {
			((UsersessionImpl) session).setPasswordGen(KeyStoreManager.getInstance().encrypt(newPassword,
				session.getServerInfo()));
		} else {
			((UsersessionImpl) session).setPasswordGen(null);
		}
		if (session.isSavePassword()) {
			if (!(newPassword.equals(session.getPersistentPassword()))) {
				session.setPersistentPassword(KeyStoreManager.getInstance().encrypt(newPassword,
					session.getServerInfo()));
			}
		}
	}

	/**
	 * Updates the project info cache.
	 * 
	 * @see Usersession#updateProjectInfos()
	 * @param session the usersession
	 */
	public static void updateProjectInfos(Usersession session) {
		session.updateProjectInfos();
	}

	/**
	 * @see Usersession#updateACUser()
	 * @param session the usersession
	 * @throws EmfStoreException if thrown
	 */
	public static void updateACUser(Usersession session) throws EmfStoreException {
		session.updateACUser();
	}

}
