package org.unicase.emfstore.rmi;

import java.net.MalformedURLException;
import java.net.URL;
import java.rmi.RMISecurityManager;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.RemoteServer;
import java.rmi.server.UnicastRemoteObject;

import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.Path;
import org.unicase.emfstore.Activator;

public class RMITest{

	public RMITest() throws RemoteException, MalformedURLException {
		/**
		 * Little hack to solve classloading issues. Is there a better solution?
		 */
		URL url = FileLocator.find(Activator.getDefault().getBundle(),new Path("/bin/"),null);
		System.setProperty("java.rmi.server.codebase", url.toExternalForm());
		
		System.setSecurityManager(new RMISecurityManager());
		LocateRegistry.createRegistry(Registry.REGISTRY_PORT);
		RemoteServer.setLog(System.out);

		FacadeTest stub = (FacadeTest) UnicastRemoteObject.exportObject(new FacadeTestImpl(), 0);

		Registry registry = LocateRegistry.getRegistry();
		registry.rebind("FacadeTest", stub);
		System.out.println("RMI LÄUFT!");
	}
}
