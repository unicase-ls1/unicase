/*******************************************************************************
 * Copyright (c) 2008-2011 Chair for Applied Software Engineering, Technische Universitaet Muenchen.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 ******************************************************************************/
package org.eclipse.emf.emfstore.server.connection.xmlrpc;

import org.eclipse.emf.emfstore.server.EmfStore;
import org.eclipse.emf.emfstore.server.accesscontrol.AuthenticationControl;
import org.eclipse.emf.emfstore.server.connection.ConnectionHandler;
import org.eclipse.emf.emfstore.server.exceptions.FatalEmfStoreException;

/**
 * Connection Handler for XML RPC Emfstore interface.
 * 
 * @author wesendon
 */
public class XmlRpcConnectionHandler implements ConnectionHandler<EmfStore> {

	/**
	 * String interface identifier.
	 */
	public static final String EMFSTORE = "EmfStore";

	private static final String NAME = "XML RPC Connection Handler";

	private static EmfStore emfStore;

	private static AuthenticationControl accessControl;

	/**
	 * {@inheritDoc}
	 */
	public String getName() {
		return NAME;
	}

	/**
	 * {@inheritDoc}
	 */
	@SuppressWarnings("static-access")
	public void init(EmfStore emfStore, AuthenticationControl accessControl) throws FatalEmfStoreException {
		this.emfStore = emfStore;
		this.accessControl = accessControl;
		XmlRpcWebserverManager webServer = XmlRpcWebserverManager.getInstance();
		webServer.initServer();
		webServer.addHandler(EMFSTORE, XmlRpcEmfStoreImpl.class);
	}

	/**
	 * Returns Emfstore.
	 * 
	 * @return emfstore
	 */
	public static EmfStore getEmfStore() {
		return emfStore;
	}

	/**
	 * Returns AccessControl.
	 * 
	 * @return access control
	 */
	public static AuthenticationControl getAccessControl() {
		return accessControl;
	}

	/**
	 * {@inheritDoc}
	 */
	public void stop(boolean force) {
		XmlRpcWebserverManager webserverManager = XmlRpcWebserverManager.getInstance();
		if (!webserverManager.removeHandler(EMFSTORE)) {
			webserverManager.stopServer();
		}
	}

}
