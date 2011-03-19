/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.workspace.ui.views.historybrowserview;

import org.eclipse.core.expressions.PropertyTester;
import org.eclipse.emf.emfstore.client.ProjectSpace;
import org.unicase.workspace.ui.commands.IsAdminTester;
import org.unicase.workspace.ui.views.scm.SCMTreeNode;

/**
 * Tests if the user has admin permissions based on a HistoryInfo node.
 * 
 * @author shterev
 */
public class HistoryBrowserAdminTester extends PropertyTester {

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.core.expressions.IPropertyTester#test(java.lang.Object, java.lang.String, java.lang.Object[],
	 *      java.lang.Object)
	 */
	public boolean test(Object receiver, String property, Object[] args, final Object expectedValue) {
		if (receiver instanceof SCMTreeNode && expectedValue instanceof Boolean) {
			SCMTreeNode node = (SCMTreeNode) receiver;
			final ProjectSpace projectSpace = node.getProjectSpace();
			if (projectSpace == null) {
				return false;
			}
			IsAdminTester tester = new IsAdminTester();
			return tester.test(projectSpace, property, args, expectedValue);
		}
		return false;
	}

}
