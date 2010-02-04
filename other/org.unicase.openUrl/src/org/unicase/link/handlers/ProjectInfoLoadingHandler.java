/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.link.handlers;

import java.util.List;

import org.unicase.emfstore.esmodel.ProjectInfo;
import org.unicase.emfstore.esmodel.SessionId;
import org.unicase.emfstore.exceptions.EmfStoreException;
import org.unicase.workspace.Usersession;
import org.unicase.workspace.WorkspaceManager;
import org.unicase.workspace.ui.commands.ServerRequestCommandHandler;

/**
 * Handler for loading project informations from the server.
 * 
 * @author svetlana nogina
 */
public class ProjectInfoLoadingHandler extends ServerRequestCommandHandler{
	
	private List<ProjectInfo> projectList;

	/**
	 * Handler constructor.
	 * 
	 * @param session - user session, that describes user, password ,server etc
	 */
	public ProjectInfoLoadingHandler(Usersession session){
		super();
		this.projectList = null;
		setUsersession(session);	
	}
	
	/**
	 * {@inheritDoc}
	 * @see org.unicase.workspace.ui.commands.ServerRequestCommandHandler#execute(org.eclipse.core.commands.ExecutionEvent)
	 */
	 @Override
     protected Object run() throws EmfStoreException {
     
     	if(getUsersession() != null){
            SessionId id = getUsersession().getSessionId();
		    projectList  = WorkspaceManager.getInstance().getConnectionManager().getProjectList(id);
		
     	}
         return null;
     }
	 
	 /**
	 * Gets the list of informations to projects on the server.
	 * 
	 * @return projectList - the list of project infos or null if the handler hasn't been run yet
	 */
	 public List<ProjectInfo> getProjectList(){
		 return projectList;
	 }
	 
}
