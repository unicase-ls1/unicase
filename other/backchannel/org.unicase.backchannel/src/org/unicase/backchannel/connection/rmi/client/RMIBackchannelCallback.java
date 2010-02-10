package org.unicase.backchannel.connection.rmi.client;

import java.rmi.Remote;
import java.rmi.RemoteException;

import org.unicase.emfstore.exceptions.EmfStoreException;

public interface RMIBackchannelCallback extends Remote {
	
	public boolean handleEvent(String event) throws RemoteException, EmfStoreException;

}
