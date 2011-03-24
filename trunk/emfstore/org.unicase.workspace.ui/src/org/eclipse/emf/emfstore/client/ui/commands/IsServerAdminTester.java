/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.eclipse.emf.emfstore.client.ui.commands;

import org.eclipse.core.expressions.PropertyTester;
import org.eclipse.emf.emfstore.client.model.ServerInfo;
import org.eclipse.emf.emfstore.client.model.Usersession;
import org.eclipse.emf.emfstore.client.model.accesscontrol.AccessControlHelper;
import org.eclipse.emf.emfstore.client.model.util.UnicaseCommandWithResult;
import org.eclipse.jface.viewers.TreeNode;
import org.unicase.emfstore.esmodel.ProjectInfo;
import org.unicase.emfstore.exceptions.AccessControlException;

/**
 * Checks if the user has admin access to the server.
 * 
 * @author Shterev
 */
public class IsServerAdminTester extends PropertyTester {

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.core.expressions.IPropertyTester#test(java.lang.Object,
	 *      java.lang.String, java.lang.Object[], java.lang.Object)
	 */
	public boolean test(Object receiver, String property, Object[] args,
			final Object expectedValue) {
		if (receiver instanceof TreeNode && expectedValue instanceof Boolean) {

			TreeNode treeNode = (TreeNode) receiver;
			ServerInfo serverInfo = null;

			if (treeNode.getValue() instanceof ServerInfo) {
				serverInfo = (ServerInfo) treeNode.getValue();
			} else if (treeNode.getValue() instanceof ProjectInfo) {
				serverInfo = (ServerInfo) treeNode.getParent().getValue();
			}

			final ServerInfo finalServerInfo = serverInfo;
			UnicaseCommandWithResult<Boolean> command = new UnicaseCommandWithResult<Boolean>() {
				@Override
				protected Boolean doRun() {
					Usersession usersession = finalServerInfo
							.getLastUsersession();
					boolean isAdmin = false;
					if (usersession != null && usersession.getACUser() != null) {
						AccessControlHelper accessControlHelper = new AccessControlHelper(
								usersession);
						try {
							accessControlHelper.checkServerAdminAccess();
							isAdmin = true;
						} catch (AccessControlException e) {
						}
					}

					return new Boolean(isAdmin).equals(expectedValue);
				}
			};
			Boolean result = command.run();
			return result;

		}
		return false;
	}
}
