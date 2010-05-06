/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.rap.updater.handlers;

import java.util.Set;

import org.eclipse.emf.common.util.EList;

import org.unicase.workspace.ServerInfo;
import org.unicase.workspace.Usersession;
import org.unicase.workspace.Workspace;
import org.unicase.workspace.WorkspaceManager;
import org.unicase.workspace.WorkspaceFactory;
import org.unicase.workspace.util.WorkspaceUtil;
import org.unicase.workspace.util.UnicaseCommand;
import org.unicase.emfstore.esmodel.url.ServerUrl;
import org.unicase.emfstore.esmodel.url.UrlFactory;
import org.unicase.emfstore.exceptions.EmfStoreException;
import org.unicase.emfstore.exceptions.AccessControlException;
import org.unicase.workspace.exceptions.ServerUrlResolutionException;
import org.unicase.rap.config.ConfigEntityStore;
import org.unicase.rap.config.EMFServerSettingsConfigEntity;

import config.ConfigEntity;

/**
 * Login handler. Web application login to EMF server.
 * 
 * @author Fatih Ulusoy
 */
public class LoginHandler {
	
	private int emfServerPort;
	private String emfServerUrl;
	private ServerInfo serverInfo;
	private Usersession userSession;
	private String emfServerUserName;
	private String emfServerUserPassword;;
	
	/**
	 * The constructor.
	 */
	public LoginHandler() {
		
		EMFServerSettingsConfigEntity configEntity = new EMFServerSettingsConfigEntity();
		ConfigEntity entity = ConfigEntityStore.loadConigEntity(configEntity, configEntity.eClass());
		
		emfServerUrl = (String) entity.getProperties().get(
			EMFServerSettingsConfigEntity.Keys.EMF_SERVER_URL);		
		emfServerPort = (Integer) entity.getProperties().get(
			EMFServerSettingsConfigEntity.Keys.EMF_SERVER_PORT);
		emfServerUserName = (String) entity.getProperties().get(
			EMFServerSettingsConfigEntity.Keys.EMF_SERVER_USER_NAME);
		emfServerUserPassword = (String) entity.getProperties().get(
			EMFServerSettingsConfigEntity.Keys.EMF_SERVER_USER_PASSWORD);
	}
	
	/**
	 * Logins to EMF server.
	 */
	public void run() {

		final Workspace wokspace = WorkspaceManager.getInstance().getCurrentWorkspace();
		final ServerInfo serverInfo = createServerInfo();
		
		new UnicaseCommand() {
			@Override
			protected void doRun() {
				userSession = serverInfo.getLastUsersession();
				if (userSession == null) {
					userSession = WorkspaceFactory.eINSTANCE.createUsersession();
					userSession.setServerInfo(serverInfo);
				}
				userSession.setUsername(emfServerUserName);
				userSession.setPassword(emfServerUserPassword);
				try {
					userSession.logIn();
					serverInfo.setLastUsersession(userSession);
					// TODO : in what condition should I add
					if (getSession() == null) {
						wokspace.getUsersessions().add(userSession);
					}
					wokspace.save();
				} catch (AccessControlException e) {
					WorkspaceUtil.logException("Login failed.", e);
				} catch (EmfStoreException e) {
					WorkspaceUtil.logException("", e);
				}
			}
		}.run();
		
	}
	
	/**
	 * 
	 * @return server info
	 */
	public ServerInfo getServerInfo() {
		return serverInfo;
	}
	
	/**
	 * 
	 * @return user session
	 */
	public Usersession getUserSession() {
		return userSession;
	}
	
	/**
	 * Creates server info.
	 * 
	 * @return server info
	 */
	private ServerInfo createServerInfo() {
		
		Set<ServerInfo> serverInfos = null;
		ServerUrl serverUrl = UrlFactory.eINSTANCE.createServerUrl();
		serverUrl.setHostName(emfServerUrl);
		serverUrl.setPort(emfServerPort);
		try {
			serverInfos = WorkspaceManager.getInstance()
					.getCurrentWorkspace().resolve(serverUrl);
		} catch (ServerUrlResolutionException e) {
			System.out.println("Could not find the server you are looking for.");
			WorkspaceUtil.logException(e.getMessage(), e);
			addNewServerInfo();
			try {
				serverInfos = WorkspaceManager.getInstance()
						.getCurrentWorkspace().resolve(serverUrl);
			} catch (ServerUrlResolutionException e2) {
				System.out.println("Could not find the server you are looking for.");
				WorkspaceUtil.logException(e2.getMessage(), e2);
			}
		}

		for (ServerInfo server : serverInfos) {
			if(server.getUrl().equals(serverUrl.getHostName())) {
				serverInfo = server;
			}
		}
		return serverInfo;
	}
	
	private void addNewServerInfo() {
		final ServerInfo serverInfo = WorkspaceFactory.eINSTANCE.createServerInfo();
		serverInfo.setName("EMFServer for RAP");
		serverInfo.setUrl(emfServerUrl);
		serverInfo.setPort(emfServerPort);
		serverInfo.setCertificateAlias("unicase.org test test(!!!) certificate for RAP");
		new UnicaseCommand() {
			@Override
			protected void doRun() {
				// save serverInfo to workspace
				Workspace workspace = WorkspaceManager.getInstance().getCurrentWorkspace();
				workspace.getServerInfos().add(serverInfo);
				workspace.save();
			}
		}.run();
	}
	
	/**
	 * Gets user session.
	 * 
	 * @return user session
	 */
	private Usersession getSession() {
		Usersession currSession = null;
		EList<Usersession> sessions = WorkspaceManager.getInstance()
				.getCurrentWorkspace().getUsersessions();

		for (Usersession session : sessions) {
			if (session.getServerInfo().getUrl().equals(emfServerUrl)) {
				currSession = session;
			}
		}

		return currSession;
	}

}


