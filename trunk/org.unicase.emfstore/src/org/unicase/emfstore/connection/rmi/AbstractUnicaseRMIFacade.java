/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.emfstore.connection.rmi;

import java.rmi.RemoteException;
import java.rmi.server.RMIClientSocketFactory;
import java.rmi.server.RMIServerSocketFactory;
import java.rmi.server.RMISocketFactory;
import java.rmi.server.UnicastRemoteObject;

import org.unicase.emfstore.ServerConfiguration;
import org.unicase.emfstore.exceptions.FatalEmfStoreException;
import org.unicase.emfstore.exceptions.InvalidPropertyException;

/**
 * Abstract parent class for all rmi facades.
 * 
 * @author wesendonk
 */
public abstract class AbstractUnicaseRMIFacade extends UnicastRemoteObject {

	private static final long serialVersionUID = 2586931338749730039L;

	/**
	 * Default constructor.
	 * 
	 * @throws RemoteException rmi related exception
	 * @throws FatalEmfStoreException a fatal emfstore exception
	 */
	public AbstractUnicaseRMIFacade() throws RemoteException, FatalEmfStoreException {
		super(0, getClientFactory(), getServerFactory());
	}

	private static RMIServerSocketFactory getServerFactory() throws InvalidPropertyException {
		String property = ServerConfiguration.getProperties().getProperty(ServerConfiguration.RMI_ENCRYPTION,
			ServerConfiguration.RMI_ENCRYPTION_DEFAULT);
		if (property.equals(ServerConfiguration.TRUE)) {
			return new RMISSLServerSocketFactory();
		} else if (property.equals(ServerConfiguration.FALSE)) {
			return RMISocketFactory.getDefaultSocketFactory();
		} else {
			throw new InvalidPropertyException();
		}
	}

	private static RMIClientSocketFactory getClientFactory() throws InvalidPropertyException {
		String property = ServerConfiguration.getProperties().getProperty(ServerConfiguration.RMI_ENCRYPTION,
			ServerConfiguration.RMI_ENCRYPTION_DEFAULT);
		if (property.equals(ServerConfiguration.TRUE)) {
			return new RMISSLClientSocketFactory();
		} else if (property.equals(ServerConfiguration.FALSE)) {
			return RMISocketFactory.getDefaultSocketFactory();
		} else {
			throw new InvalidPropertyException();
		}
	}
}
