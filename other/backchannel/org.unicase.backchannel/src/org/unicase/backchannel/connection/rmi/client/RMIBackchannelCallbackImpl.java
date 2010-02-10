package org.unicase.backchannel.connection.rmi.client;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import org.unicase.emfstore.connection.rmi.SerializationUtil;
import org.unicase.emfstore.esmodel.versioning.events.server.ServerEvent;
import org.unicase.emfstore.eventmanager.EMFStoreEventListener;
import org.unicase.emfstore.exceptions.EmfStoreException;

public class RMIBackchannelCallbackImpl extends UnicastRemoteObject implements
		RMIBackchannelCallback {

	private static final long serialVersionUID = 6877646068571055517L;

	private transient EMFStoreEventListener listener;

	protected RMIBackchannelCallbackImpl(EMFStoreEventListener listener)
			throws RemoteException {
		super();
		this.listener = listener;
	}

	public boolean handleEvent(String event) throws RemoteException, EmfStoreException {
		return listener.handleEvent((ServerEvent) SerializationUtil
				.stringToEObject(event));
	}

}
