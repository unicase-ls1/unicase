/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.eclipse.emf.emfstore.client.backchannel;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import org.eclipse.emf.emfstore.client.model.ServerInfo;
import org.eclipse.emf.emfstore.client.model.connectionmanager.AbstractConnectionManager;
import org.eclipse.emf.emfstore.server.backchannel.BackchannelInterface;
import org.eclipse.emf.emfstore.server.backchannel.connection.client.RMIBackchannelCallbackImpl;
import org.eclipse.emf.emfstore.server.backchannel.connection.server.RMIBackchannelConnectionHandler;
import org.eclipse.emf.emfstore.server.backchannel.connection.server.RMIBackchannelInterface;
import org.eclipse.emf.emfstore.server.connection.rmi.SerializationUtil;
import org.eclipse.emf.emfstore.server.eventmanager.EMFStoreEventListener;
import org.eclipse.emf.emfstore.server.exceptions.ConnectionException;
import org.eclipse.emf.emfstore.server.exceptions.EmfStoreException;
import org.eclipse.emf.emfstore.server.model.ProjectId;
import org.eclipse.emf.emfstore.server.model.SessionId;
import org.eclipse.emf.emfstore.server.model.versioning.events.server.ServerEvent;

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
