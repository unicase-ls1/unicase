/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.workspace.observers;

import org.unicase.workspace.Usersession;

/**
 * Observer interface for logging in.
 * 
 * @author pfeifferc
 * @author shterev
 */
public interface LoginObserver {

	/**
	 * To be called when login is completed.
	 * 
	 * @param session the usersession which was logged in.
	 */
	void loginCompleted(Usersession session);

}
