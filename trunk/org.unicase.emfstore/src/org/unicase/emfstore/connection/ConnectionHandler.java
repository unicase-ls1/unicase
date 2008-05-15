package org.unicase.emfstore.connection;

import org.unicase.emfstore.EmfStore;
import org.unicase.emfstore.accesscontrol.AccessControl;
import org.unicase.emfstore.exceptions.ConnectionException;

/**
 * The ConnectionHandler makes the network transport layer transparent for the server.
 * It requires {@link EmfStore} and {@link AccessControl} to delegate the messaeges.
 * 
 * @author Wesendonk
 */
public interface ConnectionHandler {
	
	/**
	 * This method initializes the ConnectionHandler.
	 * 
	 * @param emfStore an implementation of the {@link EmfStore}
	 * @param accessControl an implementation of the {@link AccessControl}
	 * @throws ConnectionException is thrown if the server can't initialize
	 */
	void init(EmfStore emfStore, AccessControl accessControl) throws ConnectionException;

}
