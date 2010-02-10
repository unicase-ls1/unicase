package org.unicase.backchannel.connection.rmi.server;

import java.rmi.RemoteException;

import org.unicase.backchannel.connection.rmi.client.RMIBackchannelCallback;
import org.unicase.emfstore.connection.rmi.SerializationUtil;
import org.unicase.emfstore.esmodel.versioning.events.server.ServerEvent;
import org.unicase.emfstore.eventmanager.EMFStoreEventListener;
import org.unicase.emfstore.exceptions.EmfStoreException;

public class RemoteEmfstoreListener implements EMFStoreEventListener {

	private RMIBackchannelCallback listener;

	public RemoteEmfstoreListener(RMIBackchannelCallback listener) {
		this.listener = listener;
	}

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
