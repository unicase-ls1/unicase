/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.emfstore.connection.rmi;

import java.io.IOException;
import java.io.Serializable;
import java.net.Socket;
import java.rmi.server.RMIClientSocketFactory;

import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;

/**
 * Custom SocketFactory for rmi with encryption.
 * 
 * @author Wesendonk
 */
public class RMISSLClientSocketFactory implements RMIClientSocketFactory, Serializable {

	private static final long serialVersionUID = -6166311189399323826L;

	/**
	 * {@inheritDoc}
	 */
	@SuppressWarnings("cast")
	public Socket createSocket(String host, int port) throws IOException {
		SSLSocketFactory factory = (SSLSocketFactory) SSLSocketFactory.getDefault();
		return (SSLSocket) factory.createSocket(host, port);
	}
}
