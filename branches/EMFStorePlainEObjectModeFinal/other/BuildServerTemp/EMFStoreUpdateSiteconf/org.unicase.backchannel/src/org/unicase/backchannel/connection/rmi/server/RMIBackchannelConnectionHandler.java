/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.backchannel.connection.rmi.server;

import java.net.URL;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.RemoteServer;

import org.unicase.backchannel.Activator;
import org.unicase.backchannel.server.BackchannelConfiguration;
import org.unicase.backchannel.server.BackchannelInterface;
import org.unicase.emfstore.accesscontrol.AuthenticationControl;
import org.unicase.emfstore.connection.ConnectionHandler;
import org.unicase.emfstore.connection.rmi.UnicaseSecurityManager;
import org.unicase.emfstore.exceptions.EmfStoreException;
import org.unicase.emfstore.exceptions.FatalEmfStoreException;

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

			System.setSecurityManager(new UnicaseSecurityManager());
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
