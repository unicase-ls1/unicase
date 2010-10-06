package org.unicase.backchannel.server.connection.server;

import java.rmi.Remote;
import java.rmi.RemoteException;

import org.unicase.backchannel.server.connection.client.RMIBackchannelCallback;
import org.unicase.emfstore.exceptions.EmfStoreException;

/**
 * RMI interface for the backchannel.
 * 
 * @author wesendon
 */
public interface RMIBackchannelInterface extends Remote {

	/**
	 * @see org.unicase.backchannel.server.BackchannelInterface#registerRemoteListener(org.unicase.emfstore.esmodel.SessionId,
	 *      org.unicase.emfstore.eventmanager.EMFStoreEventListener,
	 *      org.unicase.emfstore.esmodel.ProjectId)
	 * 
	 * @param sessionId
	 *            as string
	 * @param listener
	 *            rmi call back object
	 * @param projectId
	 *            as string
	 * @throws RemoteException
	 *             in case of connection failure
	 * @throws EmfStoreException
	 *             in case of failure
	 */
	void registerRemoteListener(String sessionId,
			RMIBackchannelCallback listener, String projectId)
			throws RemoteException, EmfStoreException;

	/**
	 * @see org.unicase.backchannel.server.BackchannelInterface#sendEvent(org.unicase.emfstore.esmodel.SessionId,
	 *      org.unicase.emfstore.esmodel.versioning.events.server.ServerEvent,
	 *      org.unicase.emfstore.esmodel.ProjectId)
	 * 
	 * @param sessionId
	 *            as string
	 * @param event
	 *            as string
	 * @param projectId
	 *            as string
	 * @throws RemoteException
	 *             in case of connection failure
	 * @throws EmfStoreException
	 *             in case of failure
	 */
	void sendEvent(String sessionId, String event, String projectId)
			throws RemoteException, EmfStoreException;

}
