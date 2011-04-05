/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.backchannel.client;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import org.unicase.backchannel.server.BackchannelInterface;
import org.unicase.backchannel.server.connection.client.RMIBackchannelCallbackImpl;
import org.unicase.backchannel.server.connection.server.RMIBackchannelConnectionHandler;
import org.unicase.backchannel.server.connection.server.RMIBackchannelInterface;
import org.unicase.emfstore.connection.rmi.SerializationUtil;
import org.unicase.emfstore.esmodel.ProjectId;
import org.unicase.emfstore.esmodel.SessionId;
import org.unicase.emfstore.esmodel.versioning.events.server.ServerEvent;
import org.unicase.emfstore.eventmanager.EMFStoreEventListener;
import org.unicase.emfstore.exceptions.ConnectionException;
import org.unicase.emfstore.exceptions.EmfStoreException;
import org.unicase.workspace.ServerInfo;
import org.unicase.workspace.connectionmanager.AbstractConnectionManager;

/**
 * Clientside connection manager for the backchannel in order to register as listener on the server.
 * 
 * @author wesendon
 */
public class BackchannelConnectionManager extends
		AbstractConnectionManager<RMIBackchannelInterface> implements
		BackchannelInterface {

	/**
	 * Initiates the connection to the server.
	 * 
	 * @param serverInfo serverinfo 
	 * @param id sessionid
	 * @throws ConnectionException in case of failure
	 */
	public void initConnection(ServerInfo serverInfo, SessionId id)
			throws ConnectionException {
		Registry registry;
		RMIBackchannelInterface facade;
		try {
			registry = LocateRegistry.getRegistry(serverInfo.getUrl(),
					serverInfo.getPort());
			facade = (RMIBackchannelInterface) registry
					.lookup(RMIBackchannelConnectionHandler.RMI_NAME);
		} catch (RemoteException e) {
			throw new ConnectionException("Connection related problem.", e);
		} catch (NotBoundException e) {
			throw new ConnectionException("Registry not available.", e);
		}
		addConnectionProxy(id, facade);
	}

	/**
	 * {@inheritDoc}
	 */
	public void registerRemoteListener(SessionId sessionId,
			EMFStoreEventListener listener, ProjectId projectId)
			throws EmfStoreException {
		try {
			RMIBackchannelCallbackImpl callback = new RMIBackchannelCallbackImpl(
					listener);
			getConnectionProxy(sessionId).registerRemoteListener(
					SerializationUtil.eObjectToString(sessionId), callback,
					SerializationUtil.eObjectToString(projectId));
		} catch (RemoteException e) {
			throw new ConnectionException("Connection related problem.", e);
		}
	}

	/**
	 * {@inheritDoc}
	 */
	public void sendEvent(SessionId sessionId, ServerEvent event,
			ProjectId projectId) throws EmfStoreException {
		try {
			getConnectionProxy(sessionId).sendEvent(
					SerializationUtil.eObjectToString(sessionId),
					SerializationUtil.eObjectToString(event),
					SerializationUtil.eObjectToString(projectId));
		} catch (RemoteException e) {
			throw new ConnectionException("Connection related problem.", e);
		}
	}

}
