/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.rap.updater.handlers;

import java.util.List;

import org.unicase.workspace.Usersession;
import org.unicase.workspace.WorkspaceManager;
import org.unicase.emfstore.esmodel.SessionId;
import org.unicase.emfstore.esmodel.ProjectInfo;
import org.unicase.emfstore.exceptions.EmfStoreException;

/**
 * Handler for loading project informations from the server.
 * 
 * @author Svetlana nogina, Fatih Ulusoy
 */
public class ProjectInfoLoadingHandler {
	
	private Usersession session;
	
	private List<ProjectInfo> projectList;

	/**
	 * Handler constructor.
	 * 
	 * @param session - user session, that describes user, password ,server etc
	 */
	public ProjectInfoLoadingHandler(Usersession session){
		this.projectList = null;
		this.session = session;	
	}
	
	/**
	 * 
	 * @throws EmfStoreException if any error in the EmfStore occurs
	 */
    public void run() throws EmfStoreException {
     	if(session != null){
            SessionId id = session.getSessionId();
		    projectList  = WorkspaceManager.getInstance().getConnectionManager().getProjectList(id);
     	}
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

