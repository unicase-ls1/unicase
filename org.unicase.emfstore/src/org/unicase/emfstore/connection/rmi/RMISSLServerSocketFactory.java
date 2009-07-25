/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.emfstore.connection.rmi;

import java.io.IOException;
import java.io.Serializable;
import java.net.ServerSocket;
import java.rmi.server.RMIServerSocketFactory;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;

import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLServerSocketFactory;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.unicase.emfstore.EmfStoreController;
import org.unicase.emfstore.connection.ServerKeyStoreManager;
import org.unicase.emfstore.exceptions.ServerKeyStoreException;
import org.unicase.emfstore.exceptions.FatalEmfStoreException;

/**
 * Custom SocketFactory for rmi with encryption.
 * 
 * @author Wesendonk
 */
@SuppressWarnings("serial")
public class RMISSLServerSocketFactory implements RMIServerSocketFactory, Serializable {

	private static Log logger;

	/**
	 * Default constructor.
	 */
	public RMISSLServerSocketFactory() {
		super();
		logger = LogFactory.getLog(RMISSLServerSocketFactory.class);
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
			logger.error("Couldn't initialize server socket.");
			EmfStoreController.getInstance().shutdown(new FatalEmfStoreException());
		} catch (KeyManagementException e) {
			logger.error("Couldn't initialize server socket.");
			EmfStoreController.getInstance().shutdown(new FatalEmfStoreException());
		} catch (ServerKeyStoreException e) {
			logger.error("Couldn't initialize server socket.");
			EmfStoreController.getInstance().shutdown(new FatalEmfStoreException());
		}

		return serverSocketFactory.createServerSocket(port);
	}
}