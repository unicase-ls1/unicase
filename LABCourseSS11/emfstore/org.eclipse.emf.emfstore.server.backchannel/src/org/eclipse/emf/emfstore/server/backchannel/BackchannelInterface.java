/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.eclipse.emf.emfstore.server.backchannel;

import org.eclipse.emf.emfstore.server.EmfStoreInterface;
import org.eclipse.emf.emfstore.server.eventmanager.EMFStoreEventListener;
import org.eclipse.emf.emfstore.server.exceptions.EmfStoreException;
import org.eclipse.emf.emfstore.server.model.ProjectId;
import org.eclipse.emf.emfstore.server.model.SessionId;
import org.eclipse.emf.emfstore.server.model.versioning.events.server.ServerEvent;

/**
 * The BackchannelInterface is used to allow clients to register at the server
 * and listens to events. It's uses a remote observer pattern. Additionally this
 * interface also allows clients to actually send events to server as well.
 * 
 * @author wesendon
 */
public interface BackchannelInterface extends EmfStoreInterface {

	/**
	 * Register a Remote Listener.
	 * 
	 * @param sessionId sessionid
	 * @param listener event listener
	 * @param projectId id of project the listener wants to register. can be null if you are serveradmin.
	 * @throws EmfStoreException in case of a failure
	 */
	void registerRemoteListener(SessionId sessionId, EMFStoreEventListener listener, ProjectId projectId)
		throws EmfStoreException;

	/**
	 * Send an event to the server.
	 * 
	 * @param sessinoId session id
	 * @param event event
	 * @param projectId project id, can be null
	 * @throws EmfStoreException in case of failure
	 */
	void sendEvent(SessionId sessinoId, ServerEvent event, ProjectId projectId) throws EmfStoreException;

}
