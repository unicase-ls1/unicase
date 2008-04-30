package org.unicase.emfstore.rmi;

import java.rmi.RemoteException;

public class FacadeTestImpl implements FacadeTest {

	public void sendString(String str) throws RemoteException {
		System.out.println(str);
	}
}
