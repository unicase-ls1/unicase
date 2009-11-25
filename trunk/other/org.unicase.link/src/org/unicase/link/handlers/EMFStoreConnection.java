/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.link.handlers;

import java.util.Set;

import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.emf.common.util.EList;
import org.eclipse.ui.PlatformUI;
import org.unicase.emfstore.esmodel.ProjectInfo;
import org.unicase.ui.common.exceptions.DialogHandler;
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
 * @author svetlana, emueller
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
			
			for(ServerInfo server: serverInfos){
				// TODO: make sure we've logged in ourselves
				projectInfos =  server.getProjectInfos();
				
				if (projectInfos == null) {
					continue;
				}

				// look for the project					
				for (ProjectInfo project: projectInfos){
					if(project.getProjectId().getId().
						equals(url.getProjectUrlFragment().getProjectId().getId())) {
											
					Usersession lastSession = getLatestUsersession(server);
					
					CheckoutProjectHandler checkoutHandler = 
						new CheckoutProjectHandler(lastSession, project);
					
					try {
						// TODO: p always null..
						ProjectSpace p = (ProjectSpace) checkoutHandler
							.execute(new ExecutionEvent());
						
						return p;
					} catch (ExecutionException e) {
						DialogHandler.showErrorDialog(e.getMessage());   
					}
				}
			}			
		}

		} catch (ServerUrlResolutionException e) {
			WorkspaceUtil.logException(e.getMessage(), e);
		} 
		
		return null;
	}
	
	private Usersession getLatestUsersession(ServerInfo serverInfo) {
		Usersession lastSession = serverInfo.getLastUsersession();		
		
		if(lastSession == null || !lastSession.isLoggedIn()){
			LoginDialog loginDialog = new LoginDialog(PlatformUI.getWorkbench()
					.getActiveWorkbenchWindow().getShell(), lastSession,
					serverInfo);
			loginDialog.open();

			lastSession = serverInfo.getLastUsersession();
		}
		
		return lastSession;
	}
}
