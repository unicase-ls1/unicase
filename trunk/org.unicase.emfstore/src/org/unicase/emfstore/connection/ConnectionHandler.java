package org.unicase.emfstore.connection;

import org.unicase.emfstore.EmfStore;
import org.unicase.emfstore.accesscontrol.AccessControl;
import org.unicase.emfstore.exceptions.ConnectionException;

public interface ConnectionHandler {
	
	void init(EmfStore emfStore, AccessControl accessControl) throws ConnectionException;

}
