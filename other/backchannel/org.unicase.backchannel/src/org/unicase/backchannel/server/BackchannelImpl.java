package org.unicase.backchannel.server;

import org.unicase.emfstore.esmodel.ProjectId;
import org.unicase.emfstore.esmodel.SessionId;
import org.unicase.emfstore.esmodel.versioning.events.server.ServerEvent;
import org.unicase.emfstore.eventmanager.EMFStoreEventListener;
import org.unicase.emfstore.exceptions.EmfStoreException;
import org.unicase.emfstore.exceptions.FatalEmfStoreException;

//public class BackchannelImpl extends AbstractEmfstoreInterface implements BackchannelInterface {
public class BackchannelImpl implements BackchannelInterface {


//	public BackchannelImpl(ServerSpace serverSpace, AuthorizationControl accessControl) throws FatalEmfStoreException {
//		super(serverSpace, accessControl);
//		
//	}
	
	public void registerRemoteListener(SessionId sessionId,
			EMFStoreEventListener listener, ProjectId projectId)
			throws EmfStoreException {
//		sanityCheckObjects(sessionId, listener);
		System.out.println("====\n"+listener+"\n====");
		listener.handleEvent(null);
	}

	public void sendEvent(SessionId sessinoId, ServerEvent event,
			ProjectId projectId) throws EmfStoreException {
		throw new EmfStoreException("Not implemented on server yet.");
	}

	protected void initSubInterfaces() throws FatalEmfStoreException {
	}

}
