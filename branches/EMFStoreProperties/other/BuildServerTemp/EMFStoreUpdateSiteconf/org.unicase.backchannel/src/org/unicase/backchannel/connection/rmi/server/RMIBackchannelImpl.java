/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.backchannel.connection.rmi.server;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import org.unicase.backchannel.connection.rmi.client.RMIBackchannelCallback;
import org.unicase.backchannel.server.BackchannelConfiguration;
import org.unicase.backchannel.server.BackchannelInterface;
import org.unicase.emfstore.connection.rmi.SerializationUtil;
import org.unicase.emfstore.esmodel.ProjectId;
import org.unicase.emfstore.esmodel.SessionId;
import org.unicase.emfstore.esmodel.versioning.events.server.ServerEvent;
import org.unicase.emfstore.exceptions.EmfStoreException;

/**
 * Implementation of rmi interface.
 * 
 * @author wesendon
 */
public class RMIBackchannelImpl extends UnicastRemoteObject implements
		RMIBackchannelInterface {

	private final BackchannelInterface backchannel;

	/**
	 * Default constructor. 
	 * 
	 * @param backchannel backchannel interface
	 * @throws RemoteException in case of failure
	 */
	protected RMIBackchannelImpl(BackchannelInterface backchannel)
			throws RemoteException {
		super(BackchannelConfiguration
				.getNumberProperty(
						BackchannelConfiguration.BACKCHANNEL_RMI_PORT,
						BackchannelConfiguration.BACKCHANNEL_RMI_PORT_DEFAULT)+1);
		this.backchannel = backchannel;
	}

	private static final long serialVersionUID = 2220637232248810383L;

	/**
	 * {@inheritDoc}
	 */
	public void registerRemoteListener(String sessionId,
			RMIBackchannelCallback listener, String projectId)
			throws RemoteException, EmfStoreException {
		backchannel.registerRemoteListener((SessionId) SerializationUtil
				.stringToEObject(sessionId), new RemoteEmfstoreListener(
				listener), (ProjectId) SerializationUtil
				.stringToEObject(projectId));
	}

	/**
	 * {@inheritDoc}
	 */
	public void sendEvent(String sessionId, String event, String projectId)
			throws RemoteException, EmfStoreException {
		backchannel.sendEvent((SessionId) SerializationUtil
				.stringToEObject(sessionId), (ServerEvent) SerializationUtil
				.stringToEObject(event), (ProjectId) SerializationUtil
				.stringToEObject(projectId));
	}

}
