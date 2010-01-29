package org.unicase.backchannel.connection.rmi.server;

import org.unicase.backchannel.BackchannelInterface;
import org.unicase.emfstore.accesscontrol.AuthenticationControl;
import org.unicase.emfstore.connection.ConnectionHandler;
import org.unicase.emfstore.exceptions.EmfStoreException;
import org.unicase.emfstore.exceptions.FatalEmfStoreException;

public class RMIBackchannelConnectionHandler implements ConnectionHandler<BackchannelInterface> {

	public String getName() {
		// TODO Auto-generated method stub
		return null;
	}

	public void init(BackchannelInterface emfStore,
			AuthenticationControl accessControl) throws FatalEmfStoreException,
			EmfStoreException {
		// TODO Auto-generated method stub
		
	}

	public void stop(boolean force) {
		// TODO Auto-generated method stub
		
	}

}
