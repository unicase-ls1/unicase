/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.eclipse.emf.emfstore.server.connection.rmi;

import java.io.IOException;
import java.io.Serializable;
import java.net.ServerSocket;
import java.rmi.server.RMIServerSocketFactory;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;

import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLServerSocketFactory;

import org.eclipse.emf.emfstore.common.model.util.ModelUtil;
import org.eclipse.emf.emfstore.server.EmfStoreController;
import org.eclipse.emf.emfstore.server.connection.ServerKeyStoreManager;
import org.eclipse.emf.emfstore.server.exceptions.FatalEmfStoreException;
import org.eclipse.emf.emfstore.server.exceptions.ServerKeyStoreException;

/**
 * Custom SocketFactory for rmi with encryption.
 * 
 * @author Wesendonk
 */
@SuppressWarnings("serial")
public class RMISSLServerSocketFactory implements RMIServerSocketFactory, Serializable {

	/**
	 * in development.
	 */
	private int id;

	/**
	 * Default constructor.
	 */
	public RMISSLServerSocketFactory() {
		super();
		id = 07701522;
	}

	/**
	 * {@inheritDoc}
	 */
	public ServerSocket createServerSocket(int port) throws IOException {
		SSLServerSocketFactory serverSocketFactory = null;
		SSLContext context;

		try {
			context = SSLContext.getInstance("TLS");
			context.init(ServerKeyStoreManager.getInstance().getKeyManagerFactory().getKeyManagers(), null, null);
			serverSocketFactory = context.getServerSocketFactory();
		} catch (NoSuchAlgorithmException e) {
			ModelUtil.logException("Couldn't initialize server socket.", e);
			EmfStoreController.getInstance().shutdown(new FatalEmfStoreException());
		} catch (KeyManagementException e) {
			ModelUtil.logException("Couldn't initialize server socket.", e);
			EmfStoreController.getInstance().shutdown(new FatalEmfStoreException());
		} catch (ServerKeyStoreException e) {
			ModelUtil.logException("Couldn't initialize server socket.", e);
			EmfStoreController.getInstance().shutdown(new FatalEmfStoreException());
		}

		return serverSocketFactory.createServerSocket(port);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		return getClass() == obj.getClass() && ((RMISSLServerSocketFactory) obj).id == this.id;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		return id;
	}
}