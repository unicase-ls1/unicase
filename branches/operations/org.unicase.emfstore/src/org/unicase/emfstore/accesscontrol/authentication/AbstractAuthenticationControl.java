/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this distribution, and is available at http://www.eclipse.org/legal/epl-v10.html
 * </copyright>
 *
 * $Id$
 */
package org.unicase.emfstore.accesscontrol.authentication;

import org.unicase.emfstore.ServerConfiguration;
import org.unicase.emfstore.accesscontrol.AccessControlException;
import org.unicase.emfstore.accesscontrol.AuthenticationControl;
import org.unicase.emfstore.esmodel.EsmodelFactory;
import org.unicase.emfstore.esmodel.SessionId;

/**
 * Abstract class for authentication.
 * 
 * @author wesendonk
 */
public abstract class AbstractAuthenticationControl implements
		AuthenticationControl {

	private String superuser;
	private String superuserpw;

	/**
	 * Default constructor.
	 */
	public AbstractAuthenticationControl() {
		superuser = ServerConfiguration.getProperties().getProperty(
				ServerConfiguration.SUPER_USER,
				ServerConfiguration.DEFAULT_SUPER_USER);
		superuserpw = ServerConfiguration.getProperties().getProperty(
				ServerConfiguration.SUPER_USER_PASSWORD,
				ServerConfiguration.SUPER_USER_PASSWORD_DEFAULT);
	}

	/**
	 * {@inheritDoc}
	 */
	public SessionId logIn(String username, String password)
			throws AccessControlException {
		if ((username.equals(superuser) && password.equals(superuserpw))
				|| verifyPassword(username, password)) {
			return EsmodelFactory.eINSTANCE.createSessionId();
		}
		throw new AccessControlException();
	}

	/**
	 * This method must be implemented by subclasses in order to verify a pair
	 * of username and password. When using authentication you should use
	 * {@link AuthenticationControl#logIn(String, String)} in order to
	 * gain a session id.
	 * 
	 * 
	 * @param username
	 *            the username
	 * @param password
	 *            the password
	 * @return boolean true if authentication was successful
	 * @throws AccessControlException
	 *             an exception
	 */
	protected abstract boolean verifyPassword(String username, String password)
			throws AccessControlException;

}
