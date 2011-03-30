/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.eclipse.emf.emfstore.server.connection.rmi;

import java.rmi.RemoteException;
import java.rmi.server.RMIClientSocketFactory;
import java.rmi.server.RMIServerSocketFactory;
import java.rmi.server.RMISocketFactory;
import java.rmi.server.UnicastRemoteObject;

import org.eclipse.emf.emfstore.server.ServerConfiguration;
import org.eclipse.emf.emfstore.server.exceptions.FatalEmfStoreException;
import org.eclipse.emf.emfstore.server.exceptions.InvalidPropertyException;

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
	 * @param port port to which the remote object will be exported
	 * @throws RemoteException rmi related exception
	 * @throws FatalEmfStoreException a fatal emfstore exception
	 */
	public AbstractUnicaseRMIFacade(int port) throws RemoteException, FatalEmfStoreException {
		super(port, getClientFactory(), getServerFactory());
	}

	private static RMIServerSocketFactory getServerFactory() throws InvalidPropertyException {
		String property = ServerConfiguration.getProperties().getProperty(ServerConfiguration.RMI_ENCRYPTION,
			ServerConfiguration.RMI_ENCRYPTION_DEFAULT);
		if (property.equals(ServerConfiguration.TRUE)) {
			return new RMISSLServerSocketFactory();
		} else if (property.equals(ServerConfiguration.FALSE)) {
			return RMISocketFactory.getSocketFactory();
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
			return RMISocketFactory.getSocketFactory();
		} else {
			throw new InvalidPropertyException();
		}
	}
}
