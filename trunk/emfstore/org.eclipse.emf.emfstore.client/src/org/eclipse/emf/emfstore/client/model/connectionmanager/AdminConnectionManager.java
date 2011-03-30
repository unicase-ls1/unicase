/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.eclipse.emf.emfstore.client.model.connectionmanager;

import org.eclipse.emf.emfstore.client.model.ServerInfo;
import org.eclipse.emf.emfstore.server.AdminEmfStore;
import org.eclipse.emf.emfstore.server.exceptions.ConnectionException;
import org.eclipse.emf.emfstore.server.model.SessionId;

/**
 * An admin connection manager connects to the server for administrative services.
 * 
 * @author koegel
 */
public interface AdminConnectionManager extends AdminEmfStore {

	/**
	 * Initialize the connection to the server.
	 * 
	 * @param serverInfo the server info
	 * @param id the session id
	 * @throws ConnectionException if the connection fails
	 */
	void initConnection(ServerInfo serverInfo, SessionId id) throws ConnectionException;

}
