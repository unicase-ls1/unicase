package org.unicase.backchannel.server.connection.server;

import java.rmi.RemoteException;

import org.unicase.backchannel.server.connection.client.RMIBackchannelCallback;
import org.unicase.emfstore.connection.rmi.SerializationUtil;
import org.unicase.emfstore.esmodel.versioning.events.server.ServerEvent;
import org.unicase.emfstore.eventmanager.EMFStoreEventListener;
import org.unicase.emfstore.exceptions.EmfStoreException;

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
