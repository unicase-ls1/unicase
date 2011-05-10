/*******************************************************************************
 * Copyright (c) 2008-2011 Chair for Applied Software Engineering,
 * Technische Universitaet Muenchen.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 ******************************************************************************/
package org.eclipse.emf.emfstore.client.ui.commands;

import org.eclipse.core.expressions.PropertyTester;
import org.eclipse.emf.emfstore.client.model.ServerInfo;
import org.eclipse.emf.emfstore.client.model.Usersession;
import org.eclipse.emf.emfstore.client.model.util.EMFStoreCommandWithResult;
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
	 * @see org.eclipse.core.expressions.IPropertyTester#test(java.lang.Object, java.lang.String, java.lang.Object[],
	 *      java.lang.Object)
	 */
	public boolean test(Object receiver, String property, Object[] args, final Object expectedValue) {
		if (receiver instanceof TreeNode && ((TreeNode) receiver).getValue() instanceof ServerInfo
			&& expectedValue instanceof Boolean) {
			final ServerInfo serverInfo = (ServerInfo) ((TreeNode) receiver).getValue();
			EMFStoreCommandWithResult<Boolean> command = new EMFStoreCommandWithResult<Boolean>() {
				@Override
				protected Boolean doRun() {
					Usersession usersession = serverInfo.getLastUsersession();
					Boolean ret = new Boolean(usersession != null && usersession.isLoggedIn());
					return ret.equals(expectedValue);
				}
			};
			Boolean result = command.run(false);
			return result;
		}
		return false;
	}

}
