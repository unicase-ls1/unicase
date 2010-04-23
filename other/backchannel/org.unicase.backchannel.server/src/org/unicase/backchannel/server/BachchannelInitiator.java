package org.unicase.backchannel.server;

import java.util.Set;

import org.unicase.backchannel.server.connection.server.RMIBackchannelConnectionHandler;
import org.unicase.emfstore.EmfStoreInterface;
import org.unicase.emfstore.accesscontrol.AccessControlImpl;
import org.unicase.emfstore.connection.ConnectionHandler;
import org.unicase.emfstore.esmodel.ServerSpace;
import org.unicase.emfstore.exceptions.EmfStoreException;
import org.unicase.emfstore.exceptions.FatalEmfStoreException;
import org.unicase.emfstore.startup.PostStartupListener;
import org.unicase.metamodel.util.ModelUtil;

/**
 * Poststart plugin for emstore which initiates the backchannel component. This
 * allows clients to register to the server and get push events.
 * 
 * @author wesendon
 */
public class BachchannelInitiator implements PostStartupListener {

	/**
	 * Default constructor.
	 */
	public BachchannelInitiator() {
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

			ModelUtil.logInfo("Backchannel initiated successfully.");

		} catch (FatalEmfStoreException e) {
			ModelUtil.logException("Couldn't initiate bachchannel.", e);
		} catch (EmfStoreException e) {
			ModelUtil.logException("Couldn't initiate bachchannel.", e);
		}
	}

}
