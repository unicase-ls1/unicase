/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */

package org.unicase.workspace.ui.commands;

import org.eclipse.core.expressions.PropertyTester;
import org.unicase.workspace.ProjectSpace;
import org.unicase.workspace.util.UnicaseCommandWithResult;

/**
 * Property tester to test if a project space has local changes.
 * 
 * @author koegel
 */
public class ProjectHasLocalChangesTester extends PropertyTester {

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.core.expressions.IPropertyTester#test(java.lang.Object,
	 *      java.lang.String, java.lang.Object[], java.lang.Object)
	 */
	public boolean test(Object receiver, String property, Object[] args,
			final Object expectedValue) {
		if (receiver instanceof ProjectSpace
				&& expectedValue instanceof Boolean) {
			final ProjectSpace projectSpace = (ProjectSpace) receiver;

			UnicaseCommandWithResult<Boolean> command = new UnicaseCommandWithResult<Boolean>() {
				@Override
				protected Boolean doRun() {
					Boolean hasLocalChanges = new Boolean(projectSpace
							.isDirty());
					return hasLocalChanges.equals(expectedValue);
				}
			};

			return command.run();
		}
		return false;
	}

}
