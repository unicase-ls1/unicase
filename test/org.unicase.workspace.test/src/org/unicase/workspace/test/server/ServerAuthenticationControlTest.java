/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.workspace.test.server;

import org.junit.Assert;
import org.junit.Test;
import org.unicase.emfstore.esmodel.SessionId;
import org.unicase.emfstore.exceptions.AccessControlException;
import org.unicase.emfstore.exceptions.EmfStoreException;
import org.unicase.workspace.Configuration;
import org.unicase.workspace.ServerInfo;
import org.unicase.workspace.WorkspaceManager;
import org.unicase.workspace.connectionmanager.ConnectionManager;
import org.unicase.workspace.connectionmanager.KeyStoreManager;
import org.unicase.workspace.test.SetupHelper;

/**
 * Test for authentication components of server.
 * 
 * @author wesendon
 */
public class ServerAuthenticationControlTest {

	/**
	 * @throws EmfStoreException in case of failure.
	 */
	@Test
	public void testLoginAndLogout() throws EmfStoreException {
		SetupHelper.startSever();
		ConnectionManager connectionManager = WorkspaceManager.getInstance().getConnectionManager();
		ServerInfo serverInfo = SetupHelper.getServerInfo();
		SessionId sessionId = connectionManager.logIn("super", KeyStoreManager.getInstance().encrypt("super", serverInfo), serverInfo, Configuration.getClientVersion());
				
		Assert.assertTrue(connectionManager.resolveUser(sessionId, null)!=null);
		
		connectionManager.logout(sessionId);
		
		try {
			connectionManager.resolveUser(sessionId, null);
			//if no exception is thrown at this point, the test fails.
			Assert.assertTrue(false);
		} catch(AccessControlException e) {
			Assert.assertTrue(true);
		}
		SetupHelper.stopServer();
	}
}
