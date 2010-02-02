package org.unicase.backchannel.connection.rmi.client;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface RMIBackchannelCallback extends Remote {
	public boolean handleEvent(String event) throws RemoteException;
}
