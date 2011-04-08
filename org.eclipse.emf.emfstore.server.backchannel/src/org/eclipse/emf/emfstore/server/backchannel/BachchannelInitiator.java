package org.eclipse.emf.emfstore.server.backchannel;

import java.util.Set;

import org.eclipse.emf.emfstore.common.model.util.ModelUtil;
import org.eclipse.emf.emfstore.server.EmfStoreInterface;
import org.eclipse.emf.emfstore.server.accesscontrol.AccessControlImpl;
import org.eclipse.emf.emfstore.server.backchannel.connection.server.RMIBackchannelConnectionHandler;
import org.eclipse.emf.emfstore.server.connection.ConnectionHandler;
import org.eclipse.emf.emfstore.server.exceptions.EmfStoreException;
import org.eclipse.emf.emfstore.server.exceptions.FatalEmfStoreException;
import org.eclipse.emf.emfstore.server.model.ServerSpace;
import org.eclipse.emf.emfstore.server.startup.PostStartupListener;

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
