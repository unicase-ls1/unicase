/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.eclipse.emf.emfstore.server.backchannel;

import org.eclipse.emf.emfstore.server.accesscontrol.AuthorizationControl;
import org.eclipse.emf.emfstore.server.core.AbstractEmfstoreInterface;
import org.eclipse.emf.emfstore.server.eventmanager.EMFStoreEventListener;
import org.eclipse.emf.emfstore.server.eventmanager.EventManager;
import org.eclipse.emf.emfstore.server.exceptions.EmfStoreException;
import org.eclipse.emf.emfstore.server.exceptions.FatalEmfStoreException;
import org.eclipse.emf.emfstore.server.model.ProjectId;
import org.eclipse.emf.emfstore.server.model.ServerSpace;
import org.eclipse.emf.emfstore.server.model.SessionId;
import org.eclipse.emf.emfstore.server.model.versioning.events.server.ServerEvent;

/**
 * Basic implementation of the {@link BackchannelInterface}.
 * 
 * @author wesendon
 */
public class BackchannelImpl extends AbstractEmfstoreInterface implements BackchannelInterface {

	/**
	 * Default constructor.
	 * 
	 * @param serverSpace serverspace
	 * @param accessControl accesscontrol
	 * @throws FatalEmfStoreException in case of failure
	 */
	public BackchannelImpl(ServerSpace serverSpace, AuthorizationControl accessControl) throws FatalEmfStoreException {
		super(serverSpace, accessControl);

	}

	/**
	 * {@inheritDoc}
	 */
	public void registerRemoteListener(SessionId sessionId, EMFStoreEventListener listener, ProjectId projectId)
		throws EmfStoreException {
		sanityCheckObjects(sessionId, listener);
		// TODO better rights control
		if (projectId == null) {
			checkServerAdminAccess(sessionId);
			EventManager.getInstance().registerListener(listener, null, null);
		} else {
			checkReadAccess(sessionId, projectId, null);
			EventManager.getInstance().registerListener(listener, projectId, null);
		}
	}

	/**
	 * {@inheritDoc}
	 */
	public void sendEvent(SessionId sessinoId, ServerEvent event, ProjectId projectId) throws EmfStoreException {
		throw new EmfStoreException("Not implemented on server yet.");
	}

	/**
	 * {@inheritDoc}
	 */
	protected void initSubInterfaces() throws FatalEmfStoreException {
	}

}
