package org.unicase.backchannel.example.client;

import org.eclipse.emf.emfstore.client.backchannel.BackchannelConnectionManager;
import org.eclipse.emf.emfstore.client.model.ModelFactory;
import org.eclipse.emf.emfstore.client.model.ServerInfo;
import org.eclipse.emf.emfstore.client.model.connectionmanager.KeyStoreManager;
import org.eclipse.emf.emfstore.client.proxy.ProxyClient;
import org.eclipse.emf.emfstore.common.model.util.ModelUtil;
import org.eclipse.emf.emfstore.common.model.util.SerializationException;
import org.eclipse.emf.emfstore.server.eventmanager.EMFStoreEventListener;
import org.eclipse.emf.emfstore.server.exceptions.EmfStoreException;
import org.eclipse.emf.emfstore.server.model.ProjectInfo;
import org.eclipse.emf.emfstore.server.model.versioning.events.server.ServerEvent;

public class DemoBackchannelClient extends ProxyClient {

	public void run() {
		try {
			loginServer("super", "super", "localhost", null, KeyStoreManager.DEFAULT_CERTIFICATE, 8080);

			BackchannelConnectionManager manager = new BackchannelConnectionManager();
			manager.initConnection(getBackChannelServerInfo(), getSessionId());

			EMFStoreEventListener listener = new EMFStoreEventListener() {
				public boolean handleEvent(ServerEvent event) {
					try {
						System.out.println(ModelUtil.eObjectToString(event));
					} catch (SerializationException e) {
						e.printStackTrace();
					}
					return true;
				}
			};

			for (ProjectInfo info : getProjectList()) {
				try {
					manager.registerRemoteListener(getSessionId(), listener, info.getProjectId());
					System.out.println("registered listener at project: " + info.getName());
				} catch (EmfStoreException e) {
					System.out.println("Error while registring project: " + info.getName() + ", " + e.toString());
				}
			}

			while (!Thread.currentThread().isInterrupted()) {
				Thread.sleep(1000);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private ServerInfo getBackChannelServerInfo() {
		ServerInfo serverInfo = ModelFactory.eINSTANCE.createServerInfo();
		serverInfo.setPort(3000);
		serverInfo.setUrl("localhost");
		return serverInfo;
	}
}
