/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.backchannel;

import java.util.Set;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.unicase.backchannel.connection.rmi.server.RMIBackchannelConnectionHandler;
import org.unicase.backchannel.server.BackchannelImpl;
import org.unicase.backchannel.server.BackchannelInterface;
import org.unicase.emfstore.EmfStoreInterface;
import org.unicase.emfstore.accesscontrol.AccessControlImpl;
import org.unicase.emfstore.connection.ConnectionHandler;
import org.unicase.emfstore.esmodel.ServerSpace;
import org.unicase.emfstore.exceptions.EmfStoreException;
import org.unicase.emfstore.exceptions.FatalEmfStoreException;
import org.unicase.emfstore.startup.PostStartupListener;

/**
 * Poststart plugin for emstore which initiates the backchannel component. This
 * allows clients to register to the server and get push events.
 * 
 * @author wesendon
 */
public class BachchannelInitiator implements PostStartupListener {

	private Log logger;

	/**
	 * Default constructor.
	 */
	public BachchannelInitiator() {
		logger = LogFactory.getLog(BachchannelInitiator.class);
	}

	/**
	 * {@inheritDoc}
	 */
	public void postStartUp(
			ServerSpace serverspace,
			AccessControlImpl accessControl,
			Set<ConnectionHandler<? extends EmfStoreInterface>> connectionHandlers) {

		try {
			BackchannelInterface backchannelImpl = new BackchannelImpl(
					serverspace, accessControl);
			RMIBackchannelConnectionHandler connectionHandler = new RMIBackchannelConnectionHandler();
			connectionHandler.init(backchannelImpl, accessControl);

			connectionHandlers.add(connectionHandler);

			logger.info("Backchannel initiated successfully.");

		} catch (FatalEmfStoreException e) {
			logger.error("Couldn't initiate bachchannel.", e);
		} catch (EmfStoreException e) {
			logger.error("Couldn't initiate bachchannel.", e);
		}
	}

}
