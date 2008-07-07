/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this distribution, and is available at http://www.eclipse.org/legal/epl-v10.html
 * </copyright>
 *
 * $Id$
 */
package org.unicase.emfstore.connection.rmi;

import java.net.URL;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.RemoteServer;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.Path;
import org.unicase.emfstore.Activator;
import org.unicase.emfstore.EmfStore;
import org.unicase.emfstore.accesscontrol.AuthenticationControl;
import org.unicase.emfstore.connection.ConnectionHandler;
import org.unicase.emfstore.exceptions.FatalEmfStoreException;

/**
 * A connection handler implementation using RMI as trasnport layer.
 * 
 * @author koegel
 *
 */
public class RMIConnectionHandler implements ConnectionHandler {

	/**
	 * String constant for the handlers name.
	 */
	private static final String NAME = "RMI Connection Handler";

	/**
	 * String constant for the RMI Binding name.
	 */
	public static final String RMI_NAME = "RMIEmfStoreFacade";

	private int port;

	private RMIEmfStoreFacade stub;

	private static Log logger = LogFactory.getLog(ConnectionHandler.class);

	/**
	 * Default constructor.
	 */
	public RMIConnectionHandler() {
		port = Registry.REGISTRY_PORT;
	}

	/** 
	 * {@inheritDoc}
	 * @see org.unicase.emfstore.connection.ConnectionHandler#init(org.unicase.emfstore.EmfStore, org.unicase.emfstore.accesscontrol.AuthenticationControl)
	 */
	public void init(EmfStore emfStore, AuthenticationControl accessControl)
			throws FatalEmfStoreException {
		/**
		 * Little hack to solve classloading issues. Is there a better solution?
		 */

		try {
			URL url = FileLocator.find(Activator.getDefault().getBundle(),
					new Path("/bin/"), null);
			System
					.setProperty("java.rmi.server.codebase", url
							.toExternalForm());

			System.setSecurityManager(new UnicaseSecurityManager());
			LocateRegistry.createRegistry(port);

			RemoteServer.setLog(System.out);

			stub = new RMIEmfStoreFacadeImpl(emfStore, accessControl);

			Registry registry = LocateRegistry.getRegistry();
			registry.rebind(RMI_NAME, stub);

		} catch (RemoteException e) {
			String message = "RMI initialisation failed!";
			logger.fatal(message, e);
			throw new FatalEmfStoreException(message, e);
		}

		logger.debug("RMIConnectionHandler is running.");
	}

	/** 
	 * {@inheritDoc}
	 * @see org.unicase.emfstore.connection.ConnectionHandler#getName()
	 */
	public String getName() {
		return NAME;
	}

	/** 
	 * {@inheritDoc}
	 * @see org.unicase.emfstore.connection.ConnectionHandler#stop(boolean)
	 */
	public void stop(boolean force) {
		if (force) {
			return;
		}
		try {
			Registry registry = LocateRegistry.getRegistry();
			try {
				registry.unbind(RMI_NAME);
			} catch (NotBoundException e1) {
				logger.warn("Unbinding EmfStore failed!", e1);
			}
		} catch (RemoteException e2) {
			logger.warn("Locate registry failed!", e2);
			return;
		}

	}
}
