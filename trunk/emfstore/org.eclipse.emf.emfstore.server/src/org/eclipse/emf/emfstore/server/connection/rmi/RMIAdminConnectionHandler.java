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

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.Registry;

import org.eclipse.emf.emfstore.common.model.util.ModelUtil;
import org.eclipse.emf.emfstore.server.AdminEmfStore;
import org.eclipse.emf.emfstore.server.accesscontrol.AuthenticationControl;
import org.eclipse.emf.emfstore.server.connection.ConnectionHandler;
import org.eclipse.emf.emfstore.server.exceptions.FatalEmfStoreException;

/**
 * ConnectionHandler for the AdminEmfStore interface using rmi.
 * 
 * @author Wesendonk
 */
public class RMIAdminConnectionHandler implements ConnectionHandler<AdminEmfStore> {

	/**
	 * String constant for the handlers name.
	 */
	private static final String NAME = "RMI Admin Connection Handler";

	/**
	 * String constant for the RMI Binding name.
	 */
	public static final String RMI_NAME = "RMIAdminEmfStoreFacade";

	private RMIAdminEmfStoreFacade stub;

	/**
	 * Default constructor.
	 */
	public RMIAdminConnectionHandler() {
	}

	/**
	 * This method initializes the ConnectionHandler.
	 * 
	 * @param adminEmfStore an implementation of the {@link AdminEmfStore}
	 * @param accessControl an implementation of the {@link AuthenticationControl}
	 * @throws FatalEmfStoreException is thrown if the server can't initialize
	 */
	public void init(AdminEmfStore adminEmfStore, AuthenticationControl accessControl) throws FatalEmfStoreException {
		try {
			stub = new RMIAdminEmfStoreFacadeImpl(adminEmfStore, accessControl);
			Registry registry = RMIRegistryManager.getInstance().getRegistry();
			registry.rebind(RMI_NAME, stub);
		} catch (RemoteException e) {
			String message = "RMI initialisation failed!";
			ModelUtil.logException(message, e);
			throw new FatalEmfStoreException(message, e);
		}
		System.out.println("RMIAdminConnectionHandler is running.");
	}

	/**
	 * Stops the connection handler.
	 * 
	 * @param force true if handler should be stopped forcefully
	 */
	public void stop(boolean force) {
		if (force) {
			return;
		}
		try {
			Registry registry = RMIRegistryManager.getInstance().getRegistry();
			try {
				registry.unbind(RMI_NAME);
			} catch (NotBoundException e1) {
				ModelUtil.logWarning("Unbinding AdminEmfStore failed!", e1);
			}
		} catch (RemoteException e2) {
			ModelUtil.logWarning("Locate registry failed!", e2);
			return;
		}

	}

	/**
	 * {@inheritDoc}
	 */
	public String getName() {
		return NAME;
	}
}
