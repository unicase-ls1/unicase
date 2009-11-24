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

import org.unicase.emfstore.exceptions.EmfStoreException;
import org.unicase.workspace.ui.commands.ServerRequestCommandHandler;
import org.unicase.workspace.ui.dialogs.LoginDialog;

/**
 * This class allows to connect to the EMFStore 
 * and check out project.
 * If the user is not logged in on the server, 
 * login dialog will be opened
 * 
 * @author svetlana
 *
 */

public class EMFStoreConnection {
	/**
	 * TODO: javadoc.
	 * @param url -insert doc-
	 */
	public void checkout(final ModelElementUrl url){
	
	ServerRequestCommandHandler handler = new ServerRequestCommandHandler(){      
        @Override
        protected Object run() throws EmfStoreException {
            checkoutProject(url);
            return null;
         
        }
     };
     try {
 
      handler.execute(new ExecutionEvent());
   
     } catch (ExecutionException e) {
        DialogHandler.showErrorDialog(e.getMessage());   

}
    
}

	/**
	 * Check out the project containing the model with the url.
	 * @param url - Unicase url of the searched model element, containing the project part 
	 */
		
	public void checkoutProject(ModelElementUrl url){
		try {
			Set<ServerInfo> serverInfos = WorkspaceManager.getInstance()
			.getCurrentWorkspace().resolve(url.getServerUrl());
			
			EList<ProjectInfo> projectInfos = null;
			
			for(ServerInfo server: serverInfos){
				//get projects, stored on the server
				projectInfos = server.getProjectInfos();
				
				if(projectInfos != null){
					//search the project
				for(ProjectInfo project: projectInfos){
					if(project.getProjectId().getId().
							equals(url.getProjectUrlFragment().getProjectId().getId())){
												
						Usersession lastSession = server.getLastUsersession();		
						
						if(lastSession == null || !lastSession.isLoggedIn()){
							LoginDialog loginDialog = new LoginDialog(PlatformUI.getWorkbench()
									.getActiveWorkbenchWindow().getShell(), lastSession,
									server);
							loginDialog.open();

							lastSession = server.getLastUsersession();
						}
						ProjectSpace projectSpace = lastSession.checkout(project);
						
						WorkspaceUtil.logCheckout(projectSpace, projectSpace
						.getBaseVersion());
						
					}
				}
			}
		}

		} catch (ServerUrlResolutionException e) {
			WorkspaceUtil.logException(e.getMessage(), e);
		} catch (EmfStoreException e) {
			WorkspaceUtil.logException(e.getMessage(), e);
		}
		
	}
		
	
}
