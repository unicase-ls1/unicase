package org.unicase.backchannel.connection.rmi.server;

import java.rmi.Remote;
import java.rmi.RemoteException;

import org.unicase.backchannel.connection.rmi.client.RMIBackchannelCallback;
import org.unicase.emfstore.exceptions.EmfStoreException;

public interface RMIBackchannelInterface extends Remote {
	
	void registerRemoteListener(String sessionId,
			RMIBackchannelCallback listener, String projectId) throws RemoteException, EmfStoreException;

	void sendEvent(String sessionId, String event, String projectId) throws RemoteException, EmfStoreException;
	
}
