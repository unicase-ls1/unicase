/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this distribution, and is available at http://www.eclipse.org/legal/epl-v10.html
 * </copyright>
 *
 * $Id$
 */
package org.unicase.emfstore.connection.rmi;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.Serializable;
import java.net.ServerSocket;
import java.rmi.server.RMIServerSocketFactory;
import java.security.KeyManagementException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.UnrecoverableKeyException;
import java.security.cert.CertificateException;

import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLServerSocketFactory;

import org.unicase.emfstore.ServerConfiguration;

/**
 * Custom SocketFactory for rmi with encryption.
 * 
 * @author Wesendonk
 */
public class RMISSLServerSocketFactory implements RMIServerSocketFactory,
		Serializable {

	/**
	 * {@inheritDoc}
	 */
	public ServerSocket createServerSocket(int port) throws IOException {
		SSLServerSocketFactory serverSocketFactory = null;
		SSLContext context;
		KeyManagerFactory keyManagerFactory;
		KeyStore keyStore;
		char[] passphrase = "av374tb$VBGGtrgwa7tosdfa".toCharArray();

		try {
			context = SSLContext.getInstance("TLS");
			keyManagerFactory = KeyManagerFactory.getInstance("SunX509");
			keyStore = KeyStore.getInstance("JKS");

			keyStore.load(new FileInputStream(ServerConfiguration.getServerHome()+"unicaseServer.keystore"), passphrase);
			keyManagerFactory.init(keyStore, passphrase);
			context.init(keyManagerFactory.getKeyManagers(), null, null);

			serverSocketFactory = context.getServerSocketFactory();
			
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (KeyStoreException e) {
			e.printStackTrace();
		} catch (CertificateException e) {
			e.printStackTrace();
		} catch (UnrecoverableKeyException e) {
			e.printStackTrace();
		} catch (KeyManagementException e) {
			e.printStackTrace();
		}

		return serverSocketFactory.createServerSocket(port);
	}
}