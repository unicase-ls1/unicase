package org.eclipse.emf.emfstore.client.core;

import org.eclipse.emf.emfstore.client.connectionmanager.ConnectionManager;

public interface WorkspaceControllerInternal extends WorkspaceController {

	/**
	 * Set the workspace connection manager.
	 * 
	 * @param connectionManager
	 *            the connection manager
	 */
	void setConnectionManager(ConnectionManager connectionManager);

}
