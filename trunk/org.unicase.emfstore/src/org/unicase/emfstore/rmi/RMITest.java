package org.unicase.emfstore.rmi;

import java.net.MalformedURLException;
import java.rmi.RMISecurityManager;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.RemoteServer;
import java.rmi.server.UnicastRemoteObject;

public class RMITest{

	public RMITest() throws RemoteException, MalformedURLException {
		System.setSecurityManager(new RMISecurityManager());
		LocateRegistry.createRegistry(Registry.REGISTRY_PORT);
		RemoteServer.setLog(System.out);

		FacadeTest stub = (FacadeTest) UnicastRemoteObject.exportObject(new FacadeTestImpl(), 0);

		Registry registry = LocateRegistry.getRegistry();
		registry.rebind("FacadeTest", stub);
	}
}
