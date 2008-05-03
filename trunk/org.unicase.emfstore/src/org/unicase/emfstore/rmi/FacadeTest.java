package org.unicase.emfstore.rmi;

import java.io.Serializable;
import java.rmi.Remote;
import java.rmi.RemoteException;

import org.unicase.model.ModelElement;

public interface FacadeTest extends Remote, Serializable {

	public void sendString(String str) throws RemoteException;

	public void sendME(ModelElement me) throws RemoteException;

}
