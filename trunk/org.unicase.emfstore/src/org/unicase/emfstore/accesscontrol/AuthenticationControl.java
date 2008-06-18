/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Kšgel. All rights reserved. This program and the accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this distribution, and is available at http://www.eclipse.org/legal/epl-v10.html
 * </copyright>
 *
 * $Id$
 */
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
	SessionId logIn(String username, String password)
			throws AccessControlException;

}
