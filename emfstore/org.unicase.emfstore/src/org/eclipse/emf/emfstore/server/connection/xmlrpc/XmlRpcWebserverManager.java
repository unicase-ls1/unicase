/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.eclipse.emf.emfstore.server.connection.xmlrpc;

import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;

import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLServerSocketFactory;

import org.apache.xmlrpc.XmlRpcException;
import org.apache.xmlrpc.server.PropertyHandlerMapping;
import org.apache.xmlrpc.server.XmlRpcServer;
import org.apache.xmlrpc.server.XmlRpcServerConfigImpl;
import org.apache.xmlrpc.webserver.WebServer;
import org.eclipse.emf.emfstore.common.model.util.ModelUtil;
import org.eclipse.emf.emfstore.server.EmfStoreController;
import org.eclipse.emf.emfstore.server.ServerConfiguration;
import org.eclipse.emf.emfstore.server.connection.ServerKeyStoreManager;
import org.eclipse.emf.emfstore.server.connection.xmlrpc.util.EObjectTypeConverterFactory;
import org.eclipse.emf.emfstore.server.connection.xmlrpc.util.EObjectTypeFactory;
import org.eclipse.emf.emfstore.server.exceptions.FatalEmfStoreException;
import org.eclipse.emf.emfstore.server.exceptions.ServerKeyStoreException;

/**
 * Manages the webserver for XML RPC connections.
 * 
 * @author wesendon
 */
public final class XmlRpcWebserverManager {

	private static XmlRpcWebserverManager instance;
	private WebServer webServer;
	private final int port;

	private XmlRpcWebserverManager() {
		int tmp = 8080;
		try {
			tmp = Integer.valueOf(ServerConfiguration.getProperties().getProperty(ServerConfiguration.XML_RPC_PORT));
		} catch (NumberFormatException e) {
			tmp = Integer.valueOf(ServerConfiguration.XML_RPC_PORT_DEFAULT);
		}
		port = tmp;
	}

	/**
	 * Returns instance of the webserver manager.
	 * 
	 * @return instance of websever manager.
	 */
	public static XmlRpcWebserverManager getInstance() {
		if (instance == null) {
			instance = new XmlRpcWebserverManager();
		}
		return instance;
	}

	/**
	 * Starts the server.
	 * 
	 * @throws FatalEmfStoreException in case of failure
	 */
	public void initServer() throws FatalEmfStoreException {
		if (webServer != null) {
			return;
		}
		try {
			webServer = new WebServer(port) {

				@Override
				protected ServerSocket createServerSocket(int pPort, int backlog, InetAddress addr) throws IOException {
					SSLServerSocketFactory serverSocketFactory = null;
					try {
						SSLContext context = SSLContext.getInstance("TLS");
						context.init(ServerKeyStoreManager.getInstance().getKeyManagerFactory().getKeyManagers(), null,
							null);
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
					return serverSocketFactory.createServerSocket(pPort, backlog, addr);
				}
			};

			ModelUtil.logInfo("Started XML RPC Webserver on port: " + port);

			XmlRpcServer xmlRpcServer = webServer.getXmlRpcServer();
			xmlRpcServer.setTypeFactory(new EObjectTypeFactory(xmlRpcServer));
			EObjectTypeConverterFactory pFactory = new EObjectTypeConverterFactory();
			xmlRpcServer.setTypeConverterFactory(pFactory);

			PropertyHandlerMapping phm = new PropertyHandlerMapping();

			phm.setVoidMethodEnabled(true);
			phm.setTypeConverterFactory(pFactory);

			xmlRpcServer.setHandlerMapping(phm);

			XmlRpcServerConfigImpl serverConfig = (XmlRpcServerConfigImpl) xmlRpcServer.getConfig();
			serverConfig.setEnabledForExtensions(true);
			serverConfig.setEnabledForExceptions(true);
			serverConfig.setContentLengthOptional(false);

			webServer.start();
		} catch (IOException e) {
			throw new FatalEmfStoreException("Couldn't start webserver", e);
		}
	}

	/**
	 * Adds a handler to the webserver.
	 * 
	 * @param handlerName handler name
	 * @param clazz class of server interface
	 * @throws FatalEmfStoreException in case of failure
	 */
	public void addHandler(String handlerName, Class<?> clazz) throws FatalEmfStoreException {
		try {
			PropertyHandlerMapping mapper = (PropertyHandlerMapping) webServer.getXmlRpcServer().getHandlerMapping();
			mapper.addHandler(handlerName, clazz);
		} catch (XmlRpcException e) {
			throw new FatalEmfStoreException("Couldn't add handler", e);
		}
	}

	/**
	 * Removes a handler from the Webserver.
	 * 
	 * @param handlerName the handler's name
	 * @return true, if other handler still available
	 */
	public boolean removeHandler(String handlerName) {
		PropertyHandlerMapping mapper = (PropertyHandlerMapping) webServer.getXmlRpcServer().getHandlerMapping();
		mapper.removeHandler(handlerName);
		try {
			return mapper.getListMethods().length > 0;
		} catch (XmlRpcException e) {
			return false;
		}
	}

	/**
	 * Stops the server.
	 */
	public void stopServer() {
		webServer.shutdown();
		webServer = null;
	}
}
