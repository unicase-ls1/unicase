/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.proxyclient.notifier.client;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.util.EList;
import org.unicase.backchannel.client.BackchannelConnectionManager;
import org.unicase.emfstore.esmodel.ProjectId;
import org.unicase.emfstore.esmodel.ProjectInfo;
import org.unicase.emfstore.eventmanager.EMFStoreEventListener;
import org.unicase.emfstore.exceptions.EmfStoreException;
import org.unicase.proxyclient.notifier.Activator;
import org.unicase.proxyclient.notifier.store.model.NotifierProxyClientStore;
import org.unicase.workspace.ProjectSpace;
import org.unicase.workspace.ServerInfo;
import org.unicase.workspace.Usersession;
import org.unicase.workspace.Workspace;
import org.unicase.workspace.WorkspaceManager;
import org.unicase.workspace.util.UnicaseCommand;
import org.unicase.workspace.util.UnicaseCommandWithResult;

/**
 * This class is responsible for a dedicated EMF store. Each of these repositories contains several projects.
 * Fore each project is a backchannel registrated.
 * 
 * @author staudta
 */
public class NotifierProxyClientRepository implements Runnable {

	private final NotifierProxyClientStore npcStore;
	private final Usersession usersession;
	private final ServerInfo backchannelServerInfo;

	private Map<ProjectId, ProjectInfo> projectInfoMap = new HashMap<ProjectId, ProjectInfo>();
	private Map<ProjectId, ProjectSpace> projectSpaceMap = new HashMap<ProjectId, ProjectSpace>();
	
	/**
	 * Constructor.
	 * 
	 * @param npcStore npc store
	 * @param usersession current user session
	 * @param backchannelServerInfo server info for the backchannel
	 * @throws NotificationProxyClientException 
	 */
	public NotifierProxyClientRepository(final NotifierProxyClientStore npcStore, final Usersession usersession, final ServerInfo backchannelServerInfo) throws NotificationProxyClientException {
		this.npcStore = npcStore;
		this.usersession = usersession;
		this.backchannelServerInfo = backchannelServerInfo;
		
		// build projectInfoMap and projectSpaceMap
		try {
			// get all remote projects
			List<ProjectInfo> remoteProjectInfoList = usersession.getRemoteProjectList();
			for (ProjectInfo projectInfo : remoteProjectInfoList) {
				ProjectId projectId = projectInfo.getProjectId();
				projectInfoMap.put(projectId, projectInfo);
				getProjectSpaceMap().put(projectId, null);
			}

			// get all checked out projects
			Workspace workspace = WorkspaceManager.getInstance().getCurrentWorkspace();
			EList<ProjectSpace> projectSpaces = workspace.getProjectSpaces();
			for (final ProjectSpace projectSpace : projectSpaces) {

				new UnicaseCommand() {
					@Override
					protected void doRun() {
						projectSpace.setUsersession(usersession);
					}
				}.run();

				ProjectId projectId = projectSpace.getProjectId();
				getProjectSpaceMap().put(projectId, projectSpace);
			}

			for (ProjectId projectId : getProjectSpaceMap().keySet()) {
				ProjectSpace projectSpace = getProjectSpaceMap().get(projectId);
				if (projectSpace == null) {
					// checkout is needed
					ProjectInfo projectInfo = projectInfoMap.get(projectId);
					projectSpace = checkout(workspace, usersession, projectInfo);
					getProjectSpaceMap().put(projectId, projectSpace);
				}
			}

		} catch (EmfStoreException e) {
			throw new NotificationProxyClientException("EMF Store Exception during getting project information.", e);
		}
	}

	/**
	 * Returns the current map of project space from the local workspace.
	 * 
	 * @return map of project spaces
	 */
	public Map<ProjectId, ProjectSpace> getProjectSpaceMap() {
		return projectSpaceMap;
	}

	/**
	 * Adds a backchannel to each project to be able to listen to server events.
	 */
	public void run() {
		// backchannel handling
		try {
			BackchannelConnectionManager manager = new BackchannelConnectionManager();
			manager.initConnection(backchannelServerInfo, usersession.getSessionId());

			// register backchannel listener
			EMFStoreEventListener listener = new BackchannelListener(npcStore, projectInfoMap,
				getProjectSpaceMap());

			// backchannel registration for all projects
			for (ProjectInfo info : projectInfoMap.values()) {
				manager.registerRemoteListener(usersession.getSessionId(), listener, info.getProjectId());
				Activator.log(Status.INFO, "Listener registered at project: " + info.getName());
			}

			while (!Thread.currentThread().isInterrupted()) {
				Thread.sleep(1000);
			}

		} catch (Exception e) {
			// Try to keep running. Throwing here an exception will terminate this thread.
			// Write this error to the log.
			Activator.logException(e);
		}
	}
	
	/**
	 * If a project exists on the server but not local, this project will be checked out.
	 * This can be done with this method.
	 * 
	 * @param workspace
	 * @param usersession
	 * @param project
	 * @return
	 * @throws NotificationProxyClientException 
	 */
	private static ProjectSpace checkout(final Workspace workspace, final Usersession usersession,
		final ProjectInfo project) throws NotificationProxyClientException {
		UnicaseCommandWithResult<ProjectSpace> comand = new UnicaseCommandWithResult<ProjectSpace>() {

			@Override
			protected ProjectSpace doRun() {
				try {
					ProjectSpace space = workspace.checkout(usersession, project);
					return space;

				} catch (EmfStoreException e) {
					Activator.logException(e);
				}
				return null;
			}
		};

		ProjectSpace space = comand.run();
		if( space == null ) {
			throw new NotificationProxyClientException( "EMF Store Exception during checkout." );
		}
		return space;
	}

}
