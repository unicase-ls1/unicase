package org.unicase.rap.updater.handlers;

import java.util.Set;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;

import org.unicase.emfstore.esmodel.url.ServerUrl;
import org.unicase.emfstore.esmodel.url.UrlFactory;
import org.unicase.emfstore.exceptions.AccessControlException;
import org.unicase.emfstore.exceptions.EmfStoreException;
import org.unicase.workspace.ServerInfo;
import org.unicase.workspace.Usersession;
import org.unicase.workspace.WorkspaceFactory;
import org.unicase.workspace.WorkspaceManager;
import org.unicase.workspace.util.WorkspaceUtil;
import org.unicase.workspace.exceptions.ServerUrlResolutionException;
import org.unicase.rap.config.EMFServerSettingsConfigEntity;



/**
 * Login handler. Web application login to EMF server via login handler.
 * 
 * @author Fatih Ulusoy
 */
public class LoginHandler {
	
	private String serverUrlStr;
	
	/**
	 * Constructor.
	 * 
	 * @param serverUrl
	 */
	public LoginHandler(String serverUrl) {
		this.serverUrlStr = serverUrl;
	}
	
	/**
	 * Logins to EMF server.
	 */
	public void run() {

		WorkspaceManager.getInstance();
		final EMFServerSettingsConfigEntity entity = new EMFServerSettingsConfigEntity();

		TransactionalEditingDomain domain = TransactionalEditingDomain.Registry.INSTANCE
				.getEditingDomain("org.unicase.EditingDomain");

		domain.getCommandStack().execute(new RecordingCommand(domain) {
			@Override
			protected void doExecute() {
				ServerInfo serverInfo = getServerInfo();
				Usersession session = serverInfo.getLastUsersession();
				
				if (session == null) {
					session = WorkspaceFactory.eINSTANCE.createUsersession();
					session.setServerInfo(serverInfo);
				}
				// TODO: password should get from encrypted file
				session.setUsername(entity.getEmfServerUserName());
				session.setPassword(entity.getEmfServerUserPassword());
				try {
					session.logIn();
					serverInfo.setLastUsersession(session);

					// add the newly created session
					// TODO : in what condition should I add
					if (getUsersession() == null)
						WorkspaceManager.getInstance().getCurrentWorkspace()
								.getUsersessions().add(session);

					WorkspaceManager.getInstance().getCurrentWorkspace().save();
				} catch (AccessControlException e) {
					WorkspaceUtil.logException("Login failed.", e);
				} catch (EmfStoreException e) {
					WorkspaceUtil.logException("", e);
				}
			}
		});
		
	}
	
	/**
	 * Gets server info.
	 * 
	 * @return server info
	 */
	private ServerInfo getServerInfo() {
		
		ServerInfo serverInfo = null;
		Set<ServerInfo> serverInfos = null;
		ServerUrl serverUrl = UrlFactory.eINSTANCE.createServerUrl();
		serverUrl.setHostName(serverUrlStr);
		EMFServerSettingsConfigEntity entity = new EMFServerSettingsConfigEntity();
	
		serverUrl.setPort(entity.getEmfServerPort());
		try {
			serverInfos = WorkspaceManager.getInstance()
					.getCurrentWorkspace().resolve(serverUrl);
		} catch (ServerUrlResolutionException e) {
			System.out.println("Could not find the server you are looking for.");
			WorkspaceUtil.logException(e.getMessage(), e);
		}

		for (ServerInfo server : serverInfos) {
			if(server.getUrl().equals(serverUrl.getHostName())) {
				serverInfo = server;
			}
		}
		return serverInfo;
	}
	
	/**
	 * Gets user session.
	 * 
	 * @return user session
	 */
	private Usersession getUsersession() {
		Usersession currSession = null;
		EList<Usersession> sessions = WorkspaceManager.getInstance()
				.getCurrentWorkspace().getUsersessions();

		for (Usersession session : sessions) {
			if (session.getServerInfo().getUrl().equals(serverUrlStr)) {
				currSession = session;
			}
		}

		return currSession;
	}

}


