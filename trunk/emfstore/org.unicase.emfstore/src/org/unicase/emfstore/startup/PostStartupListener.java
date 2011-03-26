/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.emfstore.startup;

import java.util.Set;

import org.eclipse.emf.emfstore.server.model.ServerSpace;
import org.unicase.emfstore.EmfStoreInterface;
import org.unicase.emfstore.accesscontrol.AccessControlImpl;
import org.unicase.emfstore.connection.ConnectionHandler;

/**
 * Interface for post startup listener. Can be used for server plugins.
 * 
 * @author Otto
 */
public interface PostStartupListener {

	/**
	 * Is called post startup.
	 * 
	 * @param serverspace serverspace
	 * @param accessControl accesscontrol
	 * @param connectionHandlers set of connection handler
	 */
	void postStartUp(ServerSpace serverspace, AccessControlImpl accessControl,
		Set<ConnectionHandler<? extends EmfStoreInterface>> connectionHandlers);

}
