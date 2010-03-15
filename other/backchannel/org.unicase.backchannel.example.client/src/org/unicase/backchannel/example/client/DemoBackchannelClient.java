package org.unicase.backchannel.example.client;

import org.unicase.backchannel.connection.rmi.client.BackchannelConnectionManager;
import org.unicase.emfstore.connection.rmi.SerializationUtil;
import org.unicase.emfstore.esmodel.ProjectInfo;
import org.unicase.emfstore.esmodel.versioning.events.server.ServerEvent;
import org.unicase.emfstore.eventmanager.EMFStoreEventListener;
import org.unicase.emfstore.exceptions.EmfStoreException;
import org.unicase.emfstore.exceptions.RMISerializationException;
import org.unicase.proxyclient.ProxyClient;
import org.unicase.workspace.ServerInfo;
import org.unicase.workspace.WorkspaceFactory;
import org.unicase.workspace.connectionmanager.KeyStoreManager;

public class DemoBackchannelClient extends ProxyClient {

	public void run() {
		try {
			loginServer("super", "super", "localhost", null, KeyStoreManager.DEFAULT_DEV_CERTIFICATE, 8443);

			BackchannelConnectionManager manager = new BackchannelConnectionManager();
			manager.initConnection(getBackChannelServerInfo(), getSessionId());

			EMFStoreEventListener listener = new EMFStoreEventListener() {
				public boolean handleEvent(ServerEvent event) {
					try {
						System.out.println(SerializationUtil
								.eObjectToString(event));
					} catch (RMISerializationException e) {
						e.printStackTrace();
					}
					return true;
				}
			};

			for (ProjectInfo info : getProjectList()) {
				try {
					manager.registerRemoteListener(getSessionId(), listener,
							info.getProjectId());
					System.out.println("registered listener at project: "+info.getName());
				} catch (EmfStoreException e) {
				}
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
}
