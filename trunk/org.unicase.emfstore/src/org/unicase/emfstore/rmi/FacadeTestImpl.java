package org.unicase.emfstore.rmi;

import java.rmi.RemoteException;

import org.unicase.model.ModelElement;

public class FacadeTestImpl implements FacadeTest {

	public void sendString(String str) throws RemoteException {
		System.out.println(str);
	}

	public void sendME(ModelElement me) {
		System.out.println(me.getName());
	}
}
