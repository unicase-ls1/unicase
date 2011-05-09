package org.eclipse.emf.emfstore.server.backchannel.connection.server;

import java.rmi.RemoteException;

import org.eclipse.emf.emfstore.server.backchannel.connection.client.RMIBackchannelCallback;
import org.eclipse.emf.emfstore.server.connection.rmi.SerializationUtil;
import org.eclipse.emf.emfstore.server.eventmanager.EMFStoreEventListener;
import org.eclipse.emf.emfstore.server.exceptions.EmfStoreException;
import org.eclipse.emf.emfstore.server.model.versioning.events.server.ServerEvent;

/**
 * This is an event listener adapter for the rmi call back object.
 * 
 * @author wesendon
 */
public class RemoteEmfstoreListener implements EMFStoreEventListener {

	private RMIBackchannelCallback listener;

	/**
	 * Default constructor.
	 * @param listener rmi call back object
	 * 
	 */
	public RemoteEmfstoreListener(RMIBackchannelCallback listener) {
		this.listener = listener;
	}

	/**
	 * {@inheritDoc}
	 */
	public boolean handleEvent(ServerEvent event) {
		if (listener == null) {
			return false;
		}
		try {
			return listener.handleEvent(SerializationUtil
					.eObjectToString(event));
		} catch (RemoteException e) {
			listener = null;
			return false;
		} catch (EmfStoreException e) {
			listener = null;
			return false;
		}
	}
}
