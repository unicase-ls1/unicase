package org.unicase.rap.updater;

import java.util.List;

import org.unicase.emfstore.esmodel.ProjectId;
import org.unicase.emfstore.esmodel.versioning.events.server.ServerEvent;
import org.unicase.emfstore.exceptions.EmfStoreException;
import org.unicase.emfstore.eventmanager.EMFStoreEventListener;
import org.unicase.emfstore.exceptions.RMISerializationException;
import org.unicase.emfstore.connection.rmi.SerializationUtil;
import org.unicase.backchannel.connection.rmi.client.BackchannelConnectionManager;

import org.unicase.proxyclient.ProxyClient;
import org.unicase.workspace.ServerInfo;
import org.unicase.workspace.ProjectSpace;
import org.unicase.workspace.WorkspaceFactory;
import org.unicase.workspace.connectionmanager.KeyStoreManager;
import org.unicase.rap.config.ActivatedProjectsCache;


/**
 * 
 * 
 * @author fxulusoy
 */
public class ProjectUpdater extends ProxyClient implements Runnable {

	private static ProjectUpdater instance;
	
	private EMFStoreEventListener listener;
	
	private ProjectUpdater() {
		listener = new MyEMFStoreEventListener();
	}
	
	public static ProjectUpdater getInstance() {
		if(instance == null)
			instance = new ProjectUpdater();
		
		return instance;
	}
	
	public void registerProject(ProjectId projectId) {
		try {
			loginServer("super", "super", "localhost", null, KeyStoreManager.DEFAULT_DEV_CERTIFICATE, 8080);

			BackchannelConnectionManager manager = new BackchannelConnectionManager();
			manager.initConnection(getBackChannelServerInfo(), getSessionId());
			
			try {
				manager.registerRemoteListener(getSessionId(), listener, projectId);
			} catch (EmfStoreException e) {
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void run() {
		try {
			List<ProjectSpace> projs = ActivatedProjectsCache.getInstance().getProjects();
			
			for (ProjectSpace projectSpace : projs) {
				registerProject(projectSpace.getProjectId());
			}
			
			while(!Thread.currentThread().isInterrupted()) {
				Thread.sleep(1000);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private ServerInfo getBackChannelServerInfo() {
		ServerInfo serverInfo = WorkspaceFactory.eINSTANCE.createServerInfo();
		serverInfo.setPort(2000);
		serverInfo.setUrl("localhost");
		return serverInfo;
	}
	
	private class MyEMFStoreEventListener implements EMFStoreEventListener {

		public boolean handleEvent(ServerEvent event) {
			try {
				List<ProjectSpace> projs = ActivatedProjectsCache.getInstance().getProjects();
				
				for (ProjectSpace projectSpace : projs) {
					Thread updaterThread = new Thread(new UpdateProjectHandler(projectSpace.getProjectName()));
					updaterThread.start();
				}
				
				System.out.println(SerializationUtil.eObjectToString(event));
			} catch (RMISerializationException e) {
				e.printStackTrace();
			}
			return true;
		}

	}
	
	
	
}


