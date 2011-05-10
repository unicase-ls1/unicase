package org.eclipse.emf.emfstore.server.backchannel.connection.server;

import java.net.URL;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.RemoteServer;

import org.eclipse.emf.emfstore.server.accesscontrol.AuthenticationControl;
import org.eclipse.emf.emfstore.server.backchannel.Activator;
import org.eclipse.emf.emfstore.server.backchannel.BackchannelConfiguration;
import org.eclipse.emf.emfstore.server.backchannel.BackchannelInterface;
import org.eclipse.emf.emfstore.server.connection.ConnectionHandler;
import org.eclipse.emf.emfstore.server.exceptions.EmfStoreException;
import org.eclipse.emf.emfstore.server.exceptions.FatalEmfStoreException;

/**
 * Connection handler for the backchannel. This handler initiates an own RMI registry.
 * 
 * @author wesendon
 */
public class RMIBackchannelConnectionHandler implements
		ConnectionHandler<BackchannelInterface> {

	/**
	 * Interface name.
	 */
	public static final String RMI_NAME = "RMIBackchannelInterface";

	private RMIBackchannelInterface stub;

	/**
	 * {@inheritDoc}
	 */
	public String getName() {
		return "Backchannel RMI ConnectionHandler";
	}

	/**
	 * {@inheritDoc}
	 */
	public void init(BackchannelInterface backchannel,
			AuthenticationControl accessControl) throws FatalEmfStoreException,
			EmfStoreException {
		try {
			stub = new RMIBackchannelImpl(backchannel);

			String property = "java.rmi.server.codebase";
			URL url = Activator.getDefault().getBundle().getEntry("/bin/");
			System.setProperty(property, System.getProperty(property) + " "
					+ url.toExternalForm());

			System.setSecurityManager(new EMFStoreSecurityManager());
			Registry registry = LocateRegistry
					.createRegistry(BackchannelConfiguration
							.getNumberProperty(
									BackchannelConfiguration.BACKCHANNEL_RMI_PORT,
									BackchannelConfiguration.BACKCHANNEL_RMI_PORT_DEFAULT));
			RemoteServer.setLog(System.out);

			registry.rebind(RMI_NAME, stub);
		} catch (RemoteException e) {
			String message = "RMI initialisation failed!";
			throw new FatalEmfStoreException(message, e);
		}

	}

	/**
	 * {@inheritDoc}
	 */
	public void stop(boolean force) {
		// OW: todo
	}

}
