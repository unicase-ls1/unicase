/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.emfstore.accesscontrol.authentication;

import org.eclipse.emf.emfstore.common.model.util.ModelUtil;
import org.eclipse.emf.emfstore.server.model.ClientVersionInfo;
import org.eclipse.emf.emfstore.server.model.ModelFactory;
import org.eclipse.emf.emfstore.server.model.SessionId;
import org.unicase.emfstore.ServerConfiguration;
import org.unicase.emfstore.accesscontrol.AuthenticationControl;
import org.unicase.emfstore.connection.ServerKeyStoreManager;
import org.unicase.emfstore.exceptions.AccessControlException;
import org.unicase.emfstore.exceptions.ClientVersionOutOfDateException;
import org.unicase.emfstore.exceptions.ServerKeyStoreException;

/**
 * Abstract class for authentication.
 * 
 * @author wesendonk
 */
public abstract class AbstractAuthenticationControl implements AuthenticationControl {

	private String superuser;
	private String superuserpw;

	/**
	 * Default constructor.
	 */
	public AbstractAuthenticationControl() {
		superuser = ServerConfiguration.getProperties().getProperty(ServerConfiguration.SUPER_USER,
			ServerConfiguration.SUPER_USER_DEFAULT);
		superuserpw = ServerConfiguration.getProperties().getProperty(ServerConfiguration.SUPER_USER_PASSWORD,
			ServerConfiguration.SUPER_USER_PASSWORD_DEFAULT);
	}

	/**
	 * {@inheritDoc}
	 */
	public SessionId logIn(String username, String password, ClientVersionInfo clientVersionInfo)
		throws AccessControlException {
		checkClientVersion(clientVersionInfo);
		password = preparePassword(password);
		if (verifySuperUser(username, password) || verifyPassword(username, password)) {
			return ModelFactory.eINSTANCE.createSessionId();
		}
		throw new AccessControlException();
	}

	/**
	 * Prepares password before it is used for authentication. Normally this includes decrypting the password
	 * 
	 * @param password password
	 * @return prepared password
	 * @throws ServerKeyStoreException in case of an exception
	 */
	protected String preparePassword(String password) throws ServerKeyStoreException {
		return ServerKeyStoreManager.getInstance().decrypt(password);
	}

	/**
	 * Check username and password against superuser.
	 * 
	 * @param username username
	 * @param password password
	 * @return true if super user
	 */
	protected boolean verifySuperUser(String username, String password) {
		return (username.equals(superuser) && password.equals(superuserpw));
	}

	/**
	 * {@inheritDoc}
	 */
	public void logout(SessionId sessionId) throws AccessControlException {
	}

	/**
	 * This method must be implemented by subclasses in order to verify a pair of username and password. When using
	 * authentication you should use {@link AuthenticationControl#logIn(String, String)} in order to gain a session id.
	 * 
	 * @param username the username
	 * @param password the password
	 * @return boolean true if authentication was successful, false if not
	 * @throws AccessControlException an exception
	 */
	protected abstract boolean verifyPassword(String username, String password) throws AccessControlException;

	// TODO include client name in verification
	private void checkClientVersion(ClientVersionInfo clientVersionInfo) throws ClientVersionOutOfDateException {
		if (clientVersionInfo == null) {
			throw new ClientVersionOutOfDateException("No client version recieved.");
		}
		String[] versions = ServerConfiguration.getSplittedProperty(ServerConfiguration.ACCEPTED_VERSIONS);

		if (versions == null) {
			String msg = "No server versions supplied";
			ModelUtil.logWarning(msg, new ClientVersionOutOfDateException(msg));
			return;
		}
		for (String str : versions) {
			if (str.equals(clientVersionInfo.getVersion()) || str.equals(ServerConfiguration.ACCEPTED_VERSIONS_ANY)) {
				return;
			}
		}
		StringBuffer version = new StringBuffer();
		for (String str : versions) {
			if (versions.length == 1) {
				version.append(str + ". ");
			} else {
				version.append(str + ", ");
			}
		}
		version.replace(version.length() - 2, version.length(), ".");
		throw new ClientVersionOutOfDateException("Client version: " + clientVersionInfo.getVersion()
			+ " - Accepted versions: " + version);
	}
}
