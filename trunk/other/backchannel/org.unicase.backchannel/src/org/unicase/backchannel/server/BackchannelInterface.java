package org.unicase.backchannel.server;

import org.unicase.emfstore.EmfStoreInterface;
import org.unicase.emfstore.esmodel.ProjectId;
import org.unicase.emfstore.esmodel.SessionId;
import org.unicase.emfstore.esmodel.versioning.events.server.ServerEvent;
import org.unicase.emfstore.eventmanager.EMFStoreEventListener;
import org.unicase.emfstore.exceptions.EmfStoreException;

public interface BackchannelInterface extends EmfStoreInterface {

	void registerRemoteListener(SessionId sessionId, EMFStoreEventListener listener, ProjectId projectId) throws EmfStoreException;
	
	void sendEvent(SessionId sessinoId, ServerEvent event, ProjectId projectId) throws EmfStoreException;
	
}
