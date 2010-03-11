/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.rap.updater;

import java.util.Set;
import java.util.List;
import java.util.ArrayList;

import org.eclipse.emf.common.util.EList;

import org.unicase.rap.updater.handlers.CheckoutProjectHandler;
import org.unicase.rap.updater.handlers.ProjectInfoLoadingHandler;
import org.unicase.workspace.ServerInfo;
import org.unicase.workspace.Usersession;
import org.unicase.workspace.ProjectSpace;
import org.unicase.workspace.WorkspaceManager;
import org.unicase.workspace.util.WorkspaceUtil;
import org.unicase.emfstore.esmodel.ProjectInfo;
import org.unicase.emfstore.esmodel.url.ServerUrl;
import org.unicase.emfstore.exceptions.EmfStoreException;
import org.unicase.emfstore.esmodel.url.ProjectUrlFragment;
import org.unicase.workspace.exceptions.ServerUrlResolutionException;


/**
 * Utility class for retrieving a project independently of whether
 * it has been checked out or not.
 * 
 * @author emueller, svetlana nogina, fatih ulusoy
 */
public final class ProjectFacade {
	
	private static ProjectFacade projectProxy;
	
	/**
	 * Gets the instance.
	 * 
	 * @return an instance of the ProjectFacade
	 */
	public static ProjectFacade getInstance() {
		
		if (projectProxy == null) {
			projectProxy = new ProjectFacade();
		}
		
		return projectProxy;
	}
	
	private ProjectFacade() { 
		
	}

	
	/**
	 * Check out the project according to project and server URLs.
	 * 
	 * @param url the URL of a model element belonging to the project to be looked for.
	 * @return the ProjectSpace in which the project with the given URL is embedded.
	 */
	public ProjectSpace checkoutProjectFromServer(ServerUrl serverUrl,
			ProjectUrlFragment projectUrlFrag) {
		try {
			Set<ServerInfo> serverInfos = WorkspaceManager.getInstance()
				.getCurrentWorkspace().resolve(serverUrl);

			EList<ProjectInfo> projectInfos = null;

			for (ServerInfo server: serverInfos) {
				
				projectInfos =  server.getProjectInfos();
				Usersession currSession = getUsersessions(server);
				
				List<ProjectInfo> projectList  = null;

				if (projectInfos == null || projectInfos.size() == 0) {
					
					// if there are no saved projectInfos for server, load them
					final ProjectInfoLoadingHandler infoLoadHandler = new ProjectInfoLoadingHandler(
							currSession);
					try {
						infoLoadHandler.run();
					} catch (EmfStoreException e) {
						System.out.println("An error occured while loading the project info.");
						WorkspaceUtil.logException("ProjectInfo loading error", e);
					}
					
					projectList = infoLoadHandler.getProjectList();			
				} 
				else{
					projectList = new ArrayList<ProjectInfo>();
					for(ProjectInfo projectInfo : projectInfos){
						projectList.add(projectInfo);
					}
				}

				for (final ProjectInfo project: projectList) {
					
					// TODO: should compare proj ids???
					if(!project.getName().equals(projectUrlFrag.getName())) {
						continue;
					}					
//					if(!project.getProjectId().getId().
//							equals(projectUrlFrag.getProjectId().getId())) {
//						continue;
//					}

					final Usersession lastSession = currSession;
					final CheckoutProjectHandler handler = 
						new CheckoutProjectHandler(lastSession, project);

					try {
						handler.run();
					} catch (EmfStoreException e) {
						WorkspaceUtil.logException("Project checkout error", e);
					}

					return handler.getProjectSpace();
				}			
			}

		} catch (final ServerUrlResolutionException e) {
			System.out.println("Could not find the server you are looking for.");
			WorkspaceUtil.logException(e.getMessage(), e);
		}

		return null;
	}
	
	/**
	 * Gets a user session for the given server.
	 * 
	 * @param serverInfo the server we want to retrieve a user session for
	 * @return a user session for the given server, or null if none has been found
	 */
	private Usersession getUsersessions(ServerInfo serverInfo) {
		Usersession currSession = null;
		EList<Usersession> sessions = WorkspaceManager.getInstance()
			.getCurrentWorkspace().getUsersessions();
		
		for(Usersession session: sessions){
			if(session.getServerInfo().getUrl().equals(serverInfo.getUrl())){
				 currSession = session;
			}	
		}
		
		return currSession;
	}
	
}


