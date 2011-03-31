/*******************************************************************************
 * Copyright (c) 2008-2011 Chair for Applied Software Engineering, Technische Universitaet Muenchen.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 ******************************************************************************/
package org.eclipse.emf.emfstore.server.connection.rmi;

import java.net.URL;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.RemoteServer;

import org.eclipse.emf.emfstore.server.Activator;

/**
 * The RMIRegistryManager holds the rmi registry, it is implemented as singleton. All RMI facades should use this
 * registry.
 * 
 * @author wesendonk
 */
public final class RMIRegistryManager {

	private static RMIRegistryManager instance;

	private int port;

	private RMIRegistryManager() throws RemoteException {
		port = Registry.REGISTRY_PORT;
		/**
		 * Little hack to solve classloading issues. Is there a better solution?
		 */
		URL url = Activator.getDefault().getBundle().getEntry("/bin/");
		System.setProperty("java.rmi.server.codebase", url.toExternalForm());
		System.setSecurityManager(new UnicaseSecurityManager());
		LocateRegistry.createRegistry(port);
		RemoteServer.setLog(System.out);
	}

	/**
	 * Returns the current RMI registry.
	 * 
	 * @return the registry
	 * @throws RemoteException RMI related exception
	 */
	public Registry getRegistry() throws RemoteException {
		return LocateRegistry.getRegistry();
	}

	/**
	 * Returns the instance of the {@link RMIRegistryManager}.
	 * 
	 * @return {@link RMIRegistryManager}
	 * @throws RemoteException RMI related exception
	 */
	public static RMIRegistryManager getInstance() throws RemoteException {
		if (instance == null) {
			instance = new RMIRegistryManager();
		}
		return instance;
	}
}
