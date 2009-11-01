/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.emfstore.connection.xmlrpc;

import java.io.IOException;

import org.apache.xmlrpc.XmlRpcException;
import org.apache.xmlrpc.server.PropertyHandlerMapping;
import org.apache.xmlrpc.server.XmlRpcServer;
import org.apache.xmlrpc.server.XmlRpcServerConfigImpl;
import org.apache.xmlrpc.webserver.WebServer;
import org.unicase.emfstore.connection.xmlrpc.util.EObjectTypeConverterFactory;
import org.unicase.emfstore.connection.xmlrpc.util.EObjectTypeFactory;
import org.unicase.emfstore.exceptions.FatalEmfStoreException;

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
		port = 8080;
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
			webServer = new WebServer(port);

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

	// TODO remove handler and stop server
}
