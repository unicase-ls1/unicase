package org.eclipse.emf.emfstore.server.backchannel.connection.server;

import java.rmi.Remote;
import java.rmi.RemoteException;

import org.eclipse.emf.emfstore.server.backchannel.connection.client.RMIBackchannelCallback;
import org.eclipse.emf.emfstore.server.exceptions.EmfStoreException;

/**
 * RMI interface for the backchannel.
 * 
 * @author wesendon
 */
public interface RMIBackchannelInterface extends Remote {

	/**
	 * @see org.unicase.backchannel.server.BackchannelInterface#registerRemoteListener(org.eclipse.emf.emfstore.server.model.SessionId,
	 *      org.unicase.emfstore.eventmanager.EMFStoreEventListener, org.eclipse.emf.emfstore.server.model.ProjectId)
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
	void registerRemoteListener(String sessionId, RMIBackchannelCallback listener, String projectId)
		throws RemoteException, EmfStoreException;

	/**
	 * @see org.unicase.backchannel.server.BackchannelInterface#sendEvent(org.eclipse.emf.emfstore.server.model.SessionId,
	 *      org.eclipse.emf.emfstore.server.model.versioning.events.server.ServerEvent,
	 *      org.eclipse.emf.emfstore.server.model.ProjectId)
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
	void sendEvent(String sessionId, String event, String projectId) throws RemoteException, EmfStoreException;

}
