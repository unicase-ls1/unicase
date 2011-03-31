/*******************************************************************************
 * Copyright (c) 2008-2011 Chair for Applied Software Engineering, Technische Universitaet Muenchen.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 ******************************************************************************/
package org.eclipse.emf.emfstore.client.model.util;

import org.eclipse.emf.emfstore.client.model.ModelFactory;
import org.eclipse.emf.emfstore.client.model.ServerInfo;
import org.eclipse.emf.emfstore.client.model.Usersession;
import org.eclipse.emf.emfstore.client.model.Workspace;
import org.eclipse.emf.emfstore.client.model.WorkspaceManager;
import org.eclipse.emf.emfstore.client.model.connectionmanager.KeyStoreManager;
import org.eclipse.emf.emfstore.server.exceptions.AccessControlException;
import org.eclipse.emf.emfstore.server.exceptions.EmfStoreException;

/**
 * Util class for EMFStore clients to ease connecting to the server.
 * 
 * @author koegel
 */
public final class EMFStoreClientUtil {

	private static final String LOCALHOST_GENERATED_ENTRY_NAME = "EMFStore (generated entry)";

	/**
	 * Private constructor for util class.
	 */
	private EMFStoreClientUtil() {
		// do nothing
	}

	/**
	 * Gives a server info for a given port and url. Searches first for already existing ones. If the search fails, it
	 * creates a new one and registers it for later lookup.
	 * 
	 * @param url the server url (e.g. IP address or DNS name)
	 * @param port the server port
	 * @return a server info
	 */
	private static ServerInfo giveServerInfo(String url, int port) {
		Workspace workspace = WorkspaceManager.getInstance().getCurrentWorkspace();
		for (ServerInfo existingServerInfo : workspace.getServerInfos()) {
			if (existingServerInfo.getName().equals(LOCALHOST_GENERATED_ENTRY_NAME)) {
				if (url.equals(existingServerInfo.getUrl()) && port == existingServerInfo.getPort()) {
					return existingServerInfo;
				}
			}
		}
		ServerInfo serverInfo = createServerInfo(url, port, null);
		workspace.getServerInfos().add(serverInfo);
		workspace.save();
		return serverInfo;
	}

	/**
	 * Create a server info for a given port and url.
	 * 
	 * @param url the server url (e.g. IP address or DNS name)
	 * @param port the server port
	 * @param certificateAlias the certificateAlias (defaults to 'unicase.org test test(!!!) certificate' if null)
	 * @return a server info
	 */
	private static ServerInfo createServerInfo(String url, int port, String certificateAlias) {
		ServerInfo serverInfo = ModelFactory.eINSTANCE.createServerInfo();
		serverInfo.setName(LOCALHOST_GENERATED_ENTRY_NAME);
		serverInfo.setUrl(url);
		serverInfo.setPort(port);
		if (certificateAlias == null) {
			serverInfo.setCertificateAlias("unicase.org test test(!!!) certificate");
		} else {
			serverInfo.setCertificateAlias(certificateAlias);
		}
		return serverInfo;
	}

	/**
	 * Create a default user session with the default super user and password and a server on localhost on the default
	 * port.
	 * 
	 * @return a usersession
	 */
	public static Usersession createUsersession() {
		return createUsersession("super", "super", "localhost", 8080);
	}

	/**
	 * Create a usersession for the given credentials and server info.
	 * 
	 * @param username the username
	 * @param password the password
	 * @param serverUrl server url
	 * @param serverPort server port
	 * @return a user session
	 */
	public static Usersession createUsersession(String username, String password, String serverUrl, int serverPort) {
		Workspace workspace = WorkspaceManager.getInstance().getCurrentWorkspace();
		for (Usersession usersession : workspace.getUsersessions()) {
			ServerInfo existingServerInfo = usersession.getServerInfo();
			if (existingServerInfo != null && existingServerInfo.getName().equals(LOCALHOST_GENERATED_ENTRY_NAME)
				&& existingServerInfo.getUrl().equals(serverUrl) && existingServerInfo.getPort() == serverPort) {
				String encPassword = KeyStoreManager.getInstance().encrypt(password, existingServerInfo);
				if (username.equals(usersession.getUsername()) && encPassword.equals(usersession.getPassword())) {
					return usersession;
				}
			}
		}
		Usersession usersession = ModelFactory.eINSTANCE.createUsersession();
		usersession.setServerInfo(giveServerInfo(serverUrl, serverPort));
		usersession.setUsername(username);
		usersession.setPassword(password);
		workspace.getUsersessions().add(usersession);
		workspace.save();
		return usersession;
	}

	/**
	 * Checks, if the given credentials can be authenticated at the given server.
	 * 
	 * @param username the username
	 * @param password the password
	 * @param serverUrl server url
	 * @param serverPort server port
	 * @param certificateAlias the certificateAlias (defaults to 'unicase.org test test(!!!) certificate' if null)
	 * @return true, if username & password are right
	 * @throws EmfStoreException Problem with the EMFStore Server
	 */
	public static boolean dryLogin(String username, String password, String serverUrl, int serverPort,
		String certificateAlias) throws EmfStoreException {
		Usersession usersession = ModelFactory.eINSTANCE.createUsersession();
		usersession.setServerInfo(createServerInfo(serverUrl, serverPort, certificateAlias));
		usersession.setUsername(username);
		usersession.setPassword(password);
		try {
			usersession.logIn();
		} catch (AccessControlException e) {
			return false;
		}
		return true;
	}
}
