/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.eclipse.emf.emfstore.client.model.connectionmanager;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.emfstore.server.exceptions.UnknownSessionException;
import org.eclipse.emf.emfstore.server.model.SessionId;

/**
 * Superclass for all connection manager which maps session ids to the relative connection simply by using a generic
 * map.
 * 
 * @param <T> type of connection client
 * @author wesendon
 */
public abstract class AbstractConnectionManager<T> {

	private Map<SessionId, T> map;

	/**
	 * Default constructor.
	 */
	public AbstractConnectionManager() {
		map = new HashMap<SessionId, T>();
	}

	/**
	 * Adds a connection proxy.
	 * 
	 * @param id session id as key
	 * @param connectionProxy connection proxy
	 */
	protected void addConnectionProxy(SessionId id, T connectionProxy) {
		map.put(id, connectionProxy);
	}

	/**
	 * Removes connection proxy.
	 * 
	 * @param id sessionid
	 */
	protected void removeConnectionProxy(SessionId id) {
		map.remove(id);
	}

	/**
	 * Returns the connection proxy attached to the session id.
	 * 
	 * @param id sesseion id
	 * @return connection proxy
	 * @throws UnknownSessionException if id has no conneciton proxy attached
	 */
	protected T getConnectionProxy(SessionId id) throws UnknownSessionException {
		T connectionProxy = map.get(id);
		if (connectionProxy == null) {
			throw new UnknownSessionException(ConnectionManager.LOGIN_FIRST);
		}
		return connectionProxy;
	}

	/**
	 * Returns the map.
	 * 
	 * @return the map
	 */
	protected Map<SessionId, T> getConnectionProxyMap() {
		return map;
	}
}
