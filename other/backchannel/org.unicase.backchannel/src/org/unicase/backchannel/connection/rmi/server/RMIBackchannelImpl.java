package org.unicase.backchannel.connection.rmi.server;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import org.unicase.backchannel.connection.rmi.client.RMIBackchannelCallback;
import org.unicase.backchannel.server.BackchannelInterface;
import org.unicase.emfstore.connection.rmi.SerializationUtil;
import org.unicase.emfstore.esmodel.ProjectId;
import org.unicase.emfstore.esmodel.SessionId;
import org.unicase.emfstore.esmodel.versioning.events.server.ServerEvent;
import org.unicase.emfstore.eventmanager.EMFStoreEventListener;
import org.unicase.emfstore.exceptions.EmfStoreException;

public class RMIBackchannelImpl extends UnicastRemoteObject implements
		RMIBackchannelInterface {

	private final BackchannelInterface backchannel;

	protected RMIBackchannelImpl(BackchannelInterface backchannel)
			throws RemoteException {
		super();
		this.backchannel = backchannel;
	}

	private static final long serialVersionUID = 2220637232248810383L;

	public void registerRemoteListener(String sessionId,
			RMIBackchannelCallback listener, String projectId)
			throws RemoteException, EmfStoreException {
		backchannel.registerRemoteListener((SessionId) SerializationUtil
				.stringToEObject(sessionId), new RemoteEmfstoreListener(listener),
				(ProjectId) SerializationUtil.stringToEObject(projectId));
	}

	public void sendEvent(String sessionId, String event, String projectId)
			throws RemoteException, EmfStoreException {
		backchannel.sendEvent((SessionId) SerializationUtil
				.stringToEObject(sessionId), (ServerEvent) SerializationUtil
				.stringToEObject(event), (ProjectId) SerializationUtil
				.stringToEObject(projectId));
	}

}
