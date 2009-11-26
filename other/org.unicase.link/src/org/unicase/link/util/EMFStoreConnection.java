/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.link.util;

import java.util.Set;

import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.emf.common.util.EList;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.PlatformUI;
import org.unicase.emfstore.esmodel.ProjectInfo;
import org.unicase.workspace.ProjectSpace;
import org.unicase.workspace.ServerInfo;
import org.unicase.workspace.Usersession;
import org.unicase.workspace.WorkspaceManager;
import org.unicase.workspace.exceptions.ServerUrlResolutionException;
import org.unicase.workspace.util.WorkspaceUtil;
import org.unicase.emfstore.esmodel.url.ModelElementUrl;
import org.unicase.link.commands.CheckoutProjectHandler;
import org.unicase.workspace.ui.dialogs.LoginDialog;

/**
 * This class allows to connect to the EMFStore 
 * and check out project.
 * If the user is not logged in on the server, 
 * login dialog will be opened
 * 
 * @author svetlana 
 * @author emueller
 *
 */
public class EMFStoreConnection {

	/**
	 * Check out the project containing the model with the url.
	 * @param url - Unicase url of the searched model element, containing the project part 
	 */
	public ProjectSpace checkoutProjectFromServer(ModelElementUrl url){
		try {
			Set<ServerInfo> serverInfos = WorkspaceManager.getInstance()
			.getCurrentWorkspace().resolve(url.getServerUrl());

			EList<ProjectInfo> projectInfos = null;

			for (ServerInfo server: serverInfos) {
				projectInfos =  server.getProjectInfos();
				final Usersession lastSession = getLatestUsersession(server);

				if (projectInfos == null) {
					continue;
				} 

				for (final ProjectInfo project: projectInfos) {

					if(project.getProjectId().getId().
							equals(url.getProjectUrlFragment().getProjectId().getId())) {

						final CheckoutProjectHandler handler = 
							new CheckoutProjectHandler(lastSession, project);

						Display.getDefault().asyncExec(new Runnable() {
							public void run() {
								try {
									handler.execute(new ExecutionEvent());
								} catch (ExecutionException e) {
									MessageDialog.openError(
											PlatformUI.getWorkbench()
											.getActiveWorkbenchWindow().getShell(),
											"Error",
									"An error occured while checking out the project.");
									WorkspaceUtil.logException("Project checkout error", e);
								}
							}
						});
					}
				}			
			}

		} catch (ServerUrlResolutionException e) {
			WorkspaceUtil.logException(e.getMessage(), e);
		}

		return null;
	}
	
	/**
	 * Returns the latest user session with the given server.
	 * If no user session ever has been established, a login dialog will
	 * appear, such that a user session will be created.
	 *  
	 * @param serverInfo The server for which to retrieve a user session. 
	 * @return a user session
	 */
	private Usersession getLatestUsersession(final ServerInfo serverInfo) {
		final Usersession lastSession = serverInfo.getLastUsersession();
				
		if(lastSession == null || !lastSession.isLoggedIn()){		
			// TODO: dialog either does not disappear after clicking OK, 
			ShowLoginDialog dlg = new ShowLoginDialog();
			dlg.showLoginDialog(serverInfo);
		}
		
		return lastSession;
	}
	
	// TODO: This class should serve as a work-around for displaying
	//		 the login dialog; work in progress..
	class ShowLoginDialog {
		
		private LoginDialog loginDialog;
		private boolean loginSuccessfull;
		private Usersession userSession;
		
		public ShowLoginDialog() {
			
		}
		
		void showLoginDialog(final ServerInfo serverInfo) {
			Display.getDefault().syncExec(new Runnable() {
				public void run() {
					loginDialog = new LoginDialog(
							PlatformUI.getWorkbench().getDisplay().getActiveShell(),
							null,
							serverInfo);
					
					int ret = loginDialog.open();
					
					if (ret == LoginDialog.OK) {
						userSession = loginDialog.getSession();
					}
				}
			});
		}
		
		Usersession getUsersession() {
			if (loginSuccessfull) {
				return userSession;
			}
			
			return null;
		}
		
		LoginDialog getDialog() {
			return loginDialog;
		}
	}
}
