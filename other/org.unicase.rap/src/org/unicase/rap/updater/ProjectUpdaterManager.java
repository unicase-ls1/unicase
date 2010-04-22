/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.rap.updater;

import java.util.List;
import java.util.HashMap;
import java.util.LinkedList;

import org.unicase.emfstore.esmodel.ProjectId;
import org.unicase.emfstore.esmodel.ProjectInfo;
import org.unicase.emfstore.exceptions.EmfStoreException;
import org.unicase.emfstore.eventmanager.EMFStoreEventListener;
import org.unicase.backchannel.server.BackchannelConfiguration;
import org.unicase.emfstore.esmodel.versioning.events.server.ServerEvent;
import org.unicase.backchannel.connection.rmi.client.BackchannelConnectionManager;

import org.unicase.workspace.ServerInfo;
import org.unicase.workspace.Usersession;
import org.unicase.workspace.ProjectSpace;
import org.unicase.workspace.WorkspaceManager;
import org.unicase.workspace.WorkspaceFactory;
import org.unicase.workspace.util.UnicaseCommand;
import org.unicase.workspace.util.WorkspaceUtil;
import org.unicase.rap.config.ActivatedProjectsCache;
import org.unicase.rap.updater.handlers.LoginHandler;
import org.unicase.rap.updater.handlers.CheckoutProjectHandler;
import org.unicase.rap.updater.handlers.ProjectInfoLoadingHandler;


/**
 * Project Updater Manager. Registers an updater for every activated project.
 * 
 * 
 * @author Edgar Müller, Fatih Ulusoy
 */
public final class ProjectUpdaterManager implements Runnable {

	private ServerInfo serverInfo;
	
	private Usersession userSession;
	
	private static boolean isRunning;
	
	private static ProjectUpdaterManager instance;
	
	private HashMap<ProjectId, Object> registeredProject;
	
	/**
	 * 
	 * @return instance of project updater manager.
	 */
	public static ProjectUpdaterManager getInstance() {
		if(instance == null) {
			instance = new ProjectUpdaterManager();
		}
		return instance;
	}
	
	private ProjectUpdaterManager() {
		LoginHandler loginHandler = new LoginHandler();
		loginHandler.run();
		isRunning = false;
		serverInfo = loginHandler.getServerInfo();
		userSession = loginHandler.getUserSession();
		registeredProject = new HashMap<ProjectId, Object>();
	}
	
	/**
	 * 
	 */
	public void run() {

		start();
		ActivatedProjectsCache.getInstance().getProjects();
		List<ProjectSpace> projs = ActivatedProjectsCache.getInstance().getProjects();

		for (ProjectSpace projectSpace : projs) {
			registerProject(projectSpace.getProjectId());
		}

		try {
			while (!Thread.currentThread().isInterrupted() && isRunning()) {
				Thread.sleep(100000);
				updateProjectLists();
				sychronizeProjectLists();
			}

		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 
	 * @param projectId Project ID.
	 */
	public void registerProject(ProjectId projectId) {
		if(registeredProject.get(projectId) == null) {
			try {
				BackchannelConnectionManager manager = new BackchannelConnectionManager();
				manager.initConnection(getBackChannelServerInfo(), userSession.getSessionId());
				MyEMFStoreEventListener listener = new MyEMFStoreEventListener(projectId);
				
				manager.registerRemoteListener(userSession.getSessionId(), listener, projectId);
				registeredProject.put(projectId, new Object());
			} catch (EmfStoreException e) {
				e.printStackTrace();
			}
		} else {
			System.out.print("Project with an ID " + projectId 
				+ " was already registered to update manger!");
		}
	}
	
	/**
	 * 
	 * @param projectId Project ID.
	 */
	public void deregisterProject(ProjectId projectId) {
		if(registeredProject.get(projectId) != null) {
			registeredProject.put(projectId, null);
		}
	}

	/**
	 * 
	 */
	public static synchronized void start() {
		isRunning = true;
	}
	
	/**
	 * 
	 */
	public static synchronized void stop() {
		isRunning = false;
		instance = null;
	}
	
	/**
	 * 
	 * @return true if updater is running. Otherwise, false.
	 */
	public static synchronized boolean isRunning() {
		return isRunning;
	}
	
	/**
	 * 
	 */
	public void sychronizeProjectLists() {
		
		List<ProjectInfo> projectsInEmfStore = getProjectListFromEmfStore();
		List<ProjectInfo> newProjects = getNewProjects(projectsInEmfStore);
		
		for (final ProjectInfo projInfo : newProjects) {
			new UnicaseCommand() {
				@Override
				protected void doRun() {
					final CheckoutProjectHandler handler = new CheckoutProjectHandler(userSession, projInfo);
					try {
						handler.run();
					} catch (EmfStoreException e) {
						WorkspaceUtil.logException("Project checkout error", e);
					}
				}
			}.run();
		}
		
	}
	
	/**
	 * 
	 * 
	 * @param projectsInEmfStore
	 * @return
	 */
	private List<ProjectInfo> getNewProjects(List<ProjectInfo> projectsInEmfStore) {
		
		List<ProjectInfo> newProjects = new LinkedList<ProjectInfo>();
		
		for(ProjectInfo projInfo : projectsInEmfStore) {
			boolean isCheckedOut = false;
			for (ProjectSpace projSpace : WorkspaceManager.getInstance().getCurrentWorkspace().getProjectSpaces()) {
			
				if(projInfo.getProjectId().toString().equals(projSpace.getProjectId().toString())) {
					isCheckedOut = true;
				}
			}
			if(!isCheckedOut) {
				newProjects.add(projInfo);
			}
		}
		
		return newProjects;
	}
	
	/**
	 * 
	 * 	
	 * @return
	 */
	private List<ProjectInfo> getProjectListFromEmfStore() {

		List<ProjectInfo> projectsInEmfStore = null;
		final ProjectInfoLoadingHandler projectInfoLoader = new ProjectInfoLoadingHandler(userSession);

		new UnicaseCommand() {
			@Override
			protected void doRun() {
				try {
					projectInfoLoader.run();
				} catch (EmfStoreException e) {
					System.out.println("An error occured while loading the project info.");
					WorkspaceUtil.logException("ProjectInfo loading error", e);
				}
			}
		}.run();

		projectsInEmfStore = projectInfoLoader.getProjectList();

		return projectsInEmfStore;
	}
	
	/**
	 * 
	 */
	private void updateProjectLists() {
		//ActivatedProjectsCache.getInstance().reloadActivatedProjects();
		List<ProjectSpace> projSpaces = ActivatedProjectsCache.getInstance().getProjects();
		
		// registers new projects to be able to update
		for (ProjectSpace projectSpace : projSpaces) {
			if(registeredProject.get(projectSpace.getProjectId()) == null) {
				registerProject(projectSpace.getProjectId());
			}
		}
		
		// collect project ids from project spaces
		List<ProjectId> projectIds = getProjectIds(projSpaces);
		
		// collects deactivated project ids.
		List<ProjectId> deactivatedProjectIds = new LinkedList<ProjectId>();
		for(ProjectId projId : registeredProject.keySet()) {
			if(!projectIds.contains(projId)) {
				deactivatedProjectIds.add(projId);
			}
		}
		
		// deregisters deactivated projects.
		for(ProjectId projId : deactivatedProjectIds) {
			deregisterProject(projId);
		}
	}
	
	private List<ProjectId> getProjectIds(List<ProjectSpace> projs) {
		
		List<ProjectId> projectIds = new LinkedList<ProjectId>();
		
		for(ProjectSpace projSpace : projs) {
			projectIds.add(projSpace.getProjectId());
		}
		return projectIds;
	}
	
	/**
	 * 
	 * @return
	 */
	private ServerInfo getBackChannelServerInfo() {
		ServerInfo serverInfo = WorkspaceFactory.eINSTANCE.createServerInfo();
		
		serverInfo.setUrl(this.serverInfo.getUrl());
		int port = Integer.parseInt(BackchannelConfiguration.BACKCHANNEL_RMI_PORT_DEFAULT);
		serverInfo.setPort(port);
		
		return serverInfo;
	}
	
	/**
	 * Gets a user session for the given server.
	 * 
	 * @return a user session for the emf server
	 */
	public Usersession getUserSession() {
		return userSession;
	}
	
	
	/**
	 * 
	 * @author Fatih Ulusoy
	 */
	private class MyEMFStoreEventListener implements EMFStoreEventListener {

		private ProjectId projectId;
		
		public MyEMFStoreEventListener(ProjectId projectId) {
			this.projectId = projectId;
		}
		
		public boolean handleEvent(ServerEvent event) {
			
			List<ProjectSpace> projs = ActivatedProjectsCache.getInstance().getProjects();

			for (ProjectSpace projectSpace : projs) {
				if (projectSpace.getProjectId().toString().equals(projectId.toString()) &&
					registeredProject.get(projectId) != null) {
					
					Thread updaterThread = new Thread(new ProjectUpdater(projectSpace.getProjectName()));
					updaterThread.start();
				}
			}
			return true;
		}

	}
	
	
}


