/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */

package org.unicase.workspace.ui.commands;

import org.eclipse.core.expressions.PropertyTester;
import org.eclipse.emf.emfstore.client.ServerInfo;
import org.eclipse.emf.emfstore.client.Usersession;
import org.eclipse.emf.emfstore.client.util.UnicaseCommandWithResult;
import org.eclipse.jface.viewers.TreeNode;

/**
 * Property tester to test if the server info has been logged in.
 * 
 * @author shterev
 */
public class ServerInfoIsLoggedInTester extends PropertyTester {

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.core.expressions.IPropertyTester#test(java.lang.Object,
	 *      java.lang.String, java.lang.Object[], java.lang.Object)
	 */
	public boolean test(Object receiver, String property, Object[] args,
			final Object expectedValue) {
		if (receiver instanceof TreeNode
				&& ((TreeNode) receiver).getValue() instanceof ServerInfo
				&& expectedValue instanceof Boolean) {
			final ServerInfo serverInfo = (ServerInfo) ((TreeNode) receiver)
					.getValue();
			UnicaseCommandWithResult<Boolean> command = new UnicaseCommandWithResult<Boolean>() {
				@Override
				protected Boolean doRun() {
					Usersession usersession = serverInfo.getLastUsersession();
					Boolean ret = new Boolean(usersession != null
							&& usersession.isLoggedIn());
					return ret.equals(expectedValue);
				}
			};
			Boolean result = command.run();
			return result;
		}
		return false;
	}

}
