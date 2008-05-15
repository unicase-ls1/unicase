package org.unicase.emfstore.connection.rmi;

import java.net.URL;
import java.rmi.AccessException;
import java.rmi.RMISecurityManager;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.RemoteServer;
import java.rmi.server.UnicastRemoteObject;

import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.Path;
import org.unicase.emfstore.Activator;
import org.unicase.emfstore.EmfStore;
import org.unicase.emfstore.accesscontrol.AccessControl;
import org.unicase.emfstore.connection.ConnectionHandler;

public class RMIConnectionHandler implements ConnectionHandler {

	private int port;
	
	private RMIEmfStoreFacade stub;
	
	public RMIConnectionHandler() {
		port = Registry.REGISTRY_PORT;
	}

	public void init(EmfStore emfStore, AccessControl accessControl) {
		/**
		 * Little hack to solve classloading issues. Is there a better solution?
		 */

		try {
			URL url = FileLocator.find(Activator.getDefault().getBundle(),
					new Path("/bin/"), null);
			System
					.setProperty("java.rmi.server.codebase", url
							.toExternalForm());

			System.setSecurityManager(new RMISecurityManager());
			LocateRegistry.createRegistry(port);

			RemoteServer.setLog(System.out);

			stub = new RMIEmfStoreFacadeImpl(emfStore,accessControl);

			Registry registry = LocateRegistry.getRegistry();
			registry.rebind("RMIEmfStoreFacade", stub);

		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println("RMIConnectionHandler is running.");
	}
}
