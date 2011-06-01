package org.eclipse.emf.emfstore.server.backchannel.connection.server;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import org.eclipse.emf.emfstore.common.model.util.ModelUtil;
import org.eclipse.emf.emfstore.common.model.util.SerializationException;
import org.eclipse.emf.emfstore.server.backchannel.BackchannelConfiguration;
import org.eclipse.emf.emfstore.server.backchannel.BackchannelInterface;
import org.eclipse.emf.emfstore.server.backchannel.connection.client.RMIBackchannelCallback;
import org.eclipse.emf.emfstore.server.exceptions.EmfStoreException;
import org.eclipse.emf.emfstore.server.model.ProjectId;
import org.eclipse.emf.emfstore.server.model.SessionId;
import org.eclipse.emf.emfstore.server.model.versioning.events.server.ServerEvent;

/**
 * Implementation of rmi interface.
 * 
 * @author wesendon
 */
public class RMIBackchannelImpl extends UnicastRemoteObject implements RMIBackchannelInterface {

	private final BackchannelInterface backchannel;

	/**
	 * Default constructor.
	 * 
	 * @param backchannel backchannel interface
	 * @throws RemoteException in case of failure
	 */
	protected RMIBackchannelImpl(BackchannelInterface backchannel) throws RemoteException {
		super(BackchannelConfiguration.getNumberProperty(BackchannelConfiguration.BACKCHANNEL_RMI_PORT,
			BackchannelConfiguration.BACKCHANNEL_RMI_PORT_DEFAULT) + 1);
		this.backchannel = backchannel;
	}

	private static final long serialVersionUID = 2220637232248810383L;

	/**
	 * {@inheritDoc}
	 */
	public void registerRemoteListener(String sessionId, RMIBackchannelCallback listener, String projectId)
		throws RemoteException, EmfStoreException {
		try {
			backchannel.registerRemoteListener((SessionId) ModelUtil.stringToEObject(sessionId),
				new RemoteEmfstoreListener(listener), (ProjectId) ModelUtil.stringToEObject(projectId));
		} catch (SerializationException e) {
			throw new EmfStoreException(e);
		}
	}

	/**
	 * {@inheritDoc}
	 */
	public void sendEvent(String sessionId, String event, String projectId) throws RemoteException, EmfStoreException {
		try {
			backchannel.sendEvent((SessionId) ModelUtil.stringToEObject(sessionId),
				(ServerEvent) ModelUtil.stringToEObject(event), (ProjectId) ModelUtil.stringToEObject(projectId));
		} catch (SerializationException e) {
			throw new EmfStoreException(e);
		}
	}

}
