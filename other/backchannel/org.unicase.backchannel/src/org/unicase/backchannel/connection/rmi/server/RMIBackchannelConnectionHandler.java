package org.unicase.backchannel.connection.rmi.server;

import java.net.URL;
import java.rmi.RemoteException;
import java.rmi.registry.Registry;

import org.unicase.backchannel.Activator;
import org.unicase.backchannel.server.BackchannelInterface;
import org.unicase.emfstore.accesscontrol.AuthenticationControl;
import org.unicase.emfstore.connection.ConnectionHandler;
import org.unicase.emfstore.connection.rmi.RMIRegistryManager;
import org.unicase.emfstore.exceptions.EmfStoreException;
import org.unicase.emfstore.exceptions.FatalEmfStoreException;

public class RMIBackchannelConnectionHandler implements ConnectionHandler<BackchannelInterface> {

	public static final String RMI_NAME = "RMIBackchannelInterface";
	
	private RMIBackchannelInterface stub;

	public String getName() {
		// TODO Auto-generated method stub
		return null;
	}

	public void init(BackchannelInterface backchannel,
			AuthenticationControl accessControl) throws FatalEmfStoreException,
			EmfStoreException {
		try {
			stub = new RMIBackchannelImpl(backchannel);
			Registry registry = RMIRegistryManager.getInstance().getRegistry();
			
			URL url = Activator.getDefault().getBundle().getEntry("/bin/");
			String property = "java.rmi.server.codebase";
			System.setProperty(property, System.getProperty(property) + " " + url.toExternalForm());
			
			registry.rebind(RMI_NAME, stub);
		} catch (RemoteException e) {
			String message = "RMI initialisation failed!";
			throw new FatalEmfStoreException(message, e);
		}
		
	}

	public void stop(boolean force) {
		// TODO Auto-generated method stub
		
	}

}
