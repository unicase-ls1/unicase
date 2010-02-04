/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.link.util;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.emf.common.util.EList;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.PlatformUI;
import org.unicase.emfstore.esmodel.ProjectInfo;
import org.unicase.emfstore.esmodel.url.ModelElementUrl;
import org.unicase.link.handlers.CheckoutProjectHandler;
import org.unicase.link.handlers.ProjectInfoLoadingHandler;
import org.unicase.workspace.ProjectSpace;
import org.unicase.workspace.ServerInfo;
import org.unicase.workspace.Usersession;
import org.unicase.workspace.WorkspaceManager;
import org.unicase.workspace.exceptions.ProjectUrlResolutionException;
import org.unicase.workspace.exceptions.ServerUrlResolutionException;
import org.unicase.workspace.util.WorkspaceUtil;

/**
 * Utility class for retrieving a project independently of whether
 * it has been checked out or not.
 * 
 * @author emueller, svetlana nogina
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
	
	private ProjectFacade() { }

	/**
	 * Returns the latest project with the given URL.
	 * 
	 * @param url the URL of a model element belonging to the project to be looked for.
	 * @return the ProjectSpace in which the project with the given URL is embedded. 
	 */
	public ProjectSpace getLatestProjectSpace(ModelElementUrl url) {
				
		ProjectSpace currProjectSpace = null;
				
		try {
			Set<ProjectSpace> set = WorkspaceManager.getInstance()
				.getCurrentWorkspace().resolve(url.getProjectUrlFragment());
								
			if (!set.isEmpty()) {
				currProjectSpace = set.iterator().next();
						
				for (ProjectSpace space : set) {
					Date lastUpdated = space.getLastUpdated();
					Date currProjectDate = currProjectSpace.getLastUpdated();
							
					if (lastUpdated.after(currProjectDate)) {
						currProjectSpace = space;
					}
				}
			}	
		} catch (ProjectUrlResolutionException e) {
			currProjectSpace = checkoutProjectFromServer(url);					
		} 
				
		return currProjectSpace;
	}
	
	/**
	 * Check out the project containing the model with the url.
	 * @param url the URL of a model element belonging to the project to be looked for.
	 * @return the ProjectSpace in which the project with the given URL is embedded.
	 */
	public ProjectSpace checkoutProjectFromServer(ModelElementUrl url){
		try {
			Set<ServerInfo> serverInfos = WorkspaceManager.getInstance()
				.getCurrentWorkspace().resolve(url.getServerUrl());

			EList<ProjectInfo> projectInfos = null;

			for (ServerInfo server: serverInfos) {
				
				projectInfos =  server.getProjectInfos();
				Usersession currSession = getUsersessions(server);
				
				List<ProjectInfo> projectList  = null;

				if (projectInfos == null || projectInfos.size() == 0) {
					
					// if there are no saved projectInfos for server, load them 
					final ProjectInfoLoadingHandler infoLoadHandler = new ProjectInfoLoadingHandler(currSession);
					
					Display.getDefault().syncExec(new Runnable() {
						public void run() {
							try {
								infoLoadHandler.execute(new ExecutionEvent());
								
							} catch (ExecutionException e) {
								MessageDialog.openError(
										PlatformUI.getWorkbench()
										.getActiveWorkbenchWindow().getShell(),
										"Error",
								"An error occured while loading the project info.");
								WorkspaceUtil.logException("ProjectInfo loading error", e);
							}
						}
					});
					
					projectList = infoLoadHandler.getProjectList();
			
				} 
				else{
					projectList = new ArrayList<ProjectInfo>();
					for(ProjectInfo projectInfo : projectInfos){
						projectList.add(projectInfo);
					}
				}

				for (final ProjectInfo project: projectList) {

					if(!project.getProjectId().getId().
							equals(url.getProjectUrlFragment().getProjectId().getId())) {
						continue;
					}

					final Usersession lastSession = currSession;
					final CheckoutProjectHandler handler = 
						new CheckoutProjectHandler(lastSession, project);

					Display.getDefault().syncExec(new Runnable() {
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

					return handler.getProjectSpace();
				}			
			}

		} catch (final ServerUrlResolutionException e) {
			Display.getDefault().syncExec(new Runnable() {
				
				public void run() {
					MessageDialog.openError(Display.getDefault().getActiveShell(), 
							"Could not find server.", 
							"Could not find the server you are looking for."
						  + "Check the URL and the port."
						  + e.getMessage());
				}
			});
			WorkspaceUtil.logException(e.getMessage(), e);
		}

		return null;
	}
	
	/**
	 * Gets a Usersession for the given server.
	 * 
	 * @param serverInfo the server we want to retrieve a Usersession for
	 * @return a Usersession for the given server, or null if none has been found
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
