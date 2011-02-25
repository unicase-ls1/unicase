package org.unicase.proxyclient.notifier.client;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.EList;
import org.unicase.backchannel.client.BackchannelConnectionManager;
import org.unicase.emfstore.esmodel.ProjectId;
import org.unicase.emfstore.esmodel.ProjectInfo;
import org.unicase.emfstore.eventmanager.EMFStoreEventListener;
import org.unicase.emfstore.exceptions.EmfStoreException;
import org.unicase.proxyclient.notifier.store.model.NotifierProxyClientStore;
import org.unicase.workspace.ProjectSpace;
import org.unicase.workspace.ServerInfo;
import org.unicase.workspace.Usersession;
import org.unicase.workspace.Workspace;
import org.unicase.workspace.WorkspaceManager;
import org.unicase.workspace.util.UnicaseCommand;
import org.unicase.workspace.util.UnicaseCommandWithResult;

/**
 * @author Adrian Staudt <staudta@in.tum.de>
 */
public class NotifierProxyClientRepository implements Runnable {

	private final NotifierProxyClientStore createNPCStore;
	private final Usersession usersession;
	private final ServerInfo backChannelServerInfo;

	private Map<ProjectId, ProjectInfo> projectInfoMap = new HashMap<ProjectId, ProjectInfo>();
	private Map<ProjectId, ProjectSpace> projectSpaceMap = new HashMap<ProjectId, ProjectSpace>();
	
	public NotifierProxyClientRepository(final NotifierProxyClientStore createNPCStore, final Usersession usersession, final ServerInfo backChannelServerInfo) {
		this.createNPCStore = createNPCStore;
		this.usersession = usersession;
		this.backChannelServerInfo = backChannelServerInfo;
		
		// build projectInfoMap and projectSpaceMap
		try {
			// get all remote projects
			List<ProjectInfo> remoteProjectInfoList = usersession.getRemoteProjectList();
			for (ProjectInfo projectInfo : remoteProjectInfoList) {
				ProjectId projectId = projectInfo.getProjectId();
				getProjectInfoMap().put(projectId, projectInfo);
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
					ProjectInfo projectInfo = getProjectInfoMap().get(projectId);
					projectSpace = checkout(workspace, usersession, projectInfo);
					getProjectSpaceMap().put(projectId, projectSpace);
				}
			}

		} catch (EmfStoreException e) {
			throw new NotificationProxyClientException( e.getMessage() );
		}
	}


	public Map<ProjectId, ProjectSpace> getProjectSpaceMap() {
		return projectSpaceMap;
	}


	public Map<ProjectId, ProjectInfo> getProjectInfoMap() {
		return projectInfoMap;
	}


	public void run() {
		// backchannel handling
		try {
			BackchannelConnectionManager manager = new BackchannelConnectionManager();
			manager.initConnection(backChannelServerInfo, usersession.getSessionId());

			// register backchannel listener
			EMFStoreEventListener listener = new EMFStoreEventNotifierListener(createNPCStore, getProjectInfoMap(),
				getProjectSpaceMap());

			// backchannel registration for all projects
			for (ProjectInfo info : getProjectInfoMap().values()) {
				try {
					manager.registerRemoteListener(usersession.getSessionId(), listener, info.getProjectId());
					System.out.println("registered listener at project: " + info.getName());
				} catch (EmfStoreException e) {
					System.out.println("Error while registring project: " + info.getName() + ", " + e.toString());
				}
			}

			while (!Thread.currentThread().isInterrupted()) {
				Thread.sleep(1000);
			}

		} catch (Exception e) {
			throw new NotificationProxyClientException(e.getMessage());
		}
	}
	
	private static ProjectSpace checkout(final Workspace workspace, final Usersession usersession,
		final ProjectInfo project) {
		UnicaseCommandWithResult<ProjectSpace> comand = new UnicaseCommandWithResult<ProjectSpace>() {

			@Override
			protected ProjectSpace doRun() {
				try {
					ProjectSpace space = workspace.checkout(usersession, project);
					return space;

				} catch (EmfStoreException e) {
					throw new NotificationProxyClientException(e.getMessage());
				}
			}
		};

		ProjectSpace space = comand.run();
		return space;
	}

}
