/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this distribution, and is available at http://www.eclipse.org/legal/epl-v10.html
 * </copyright>
 *
 * $Id$
 */
package org.unicase.workspace.connectionmanager;

import org.unicase.emfstore.AdminEmfStore;
import org.unicase.emfstore.esmodel.SessionId;
import org.unicase.emfstore.exceptions.ConnectionException;
import org.unicase.workspace.ServerInfo;

public interface AdminConnectionManager extends AdminEmfStore {
	
	void initConnection(ServerInfo serverInfo, SessionId id) throws ConnectionException; 
	
}
