/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.emfstore.connection.rmi;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.Registry;

import org.unicase.emfstore.EmfStore;
import org.unicase.emfstore.accesscontrol.AuthenticationControl;
import org.unicase.emfstore.connection.ConnectionHandler;
import org.unicase.emfstore.exceptions.FatalEmfStoreException;
import org.unicase.metamodel.util.ModelUtil;

/**
 * A connection handler implementation using RMI as transport layer.
 * 
 * @author koegel
 * @author Wesendonk
 */
public class RMIConnectionHandler implements ConnectionHandler<EmfStore> {

	/**
	 * String constant for the handlers name.
	 */
	private static final String NAME = "RMI Connection Handler";

	/**
	 * String constant for the RMI Binding name.
	 */
	public static final String RMI_NAME = "RMIEmfStoreFacade";

	private RMIEmfStoreFacade stub;

	/**
	 * Default constructor.
	 */
	public RMIConnectionHandler() {
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see {@link org.unicase.emfstore.connection.ConnectionHandler#init(Object, AuthenticationControl)}
	 */
	public void init(EmfStore emfStore, AuthenticationControl accessControl) throws FatalEmfStoreException {
		try {
			stub = new RMIEmfStoreFacadeImpl(emfStore, accessControl);
			Registry registry = RMIRegistryManager.getInstance().getRegistry();
			registry.rebind(RMI_NAME, stub);
		} catch (RemoteException e) {
			String message = "RMI initialisation failed!";
			ModelUtil.logException(message, e);
			throw new FatalEmfStoreException(message, e);
		}
		System.out.println("RMIConnectionHandler is running.");
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.unicase.emfstore.connection.ConnectionHandler#getName()
	 */
	public String getName() {
		return NAME;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.unicase.emfstore.connection.ConnectionHandler#stop(boolean)
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
				ModelUtil.logWarning("Unbinding EmfStore failed!", e1);
			}
		} catch (RemoteException e2) {
			ModelUtil.logWarning("Locate registry failed!", e2);
			return;
		}

	}
}
