/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */

package org.unicase.workspace.edit.commands;

import org.eclipse.core.expressions.PropertyTester;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.unicase.emfstore.esmodel.versioning.operations.AbstractOperation;
import org.unicase.workspace.ProjectSpace;
import org.unicase.workspace.util.RecordingCommandWithResult;

/**
 * Property tester to test if a project space has local changes.
 * 
 * @author koegel
 */
public class ProjectHasLocalChangesTester extends PropertyTester {

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.core.expressions.IPropertyTester#test(java.lang.Object, java.lang.String, java.lang.Object[],
	 *      java.lang.Object)
	 */
	public boolean test(Object receiver, String property, Object[] args, final Object expectedValue) {
		if (receiver instanceof ProjectSpace && expectedValue instanceof Boolean) {
			final ProjectSpace projectSpace = (ProjectSpace) receiver;
			TransactionalEditingDomain domain = TransactionalEditingDomain.Registry.INSTANCE
				.getEditingDomain("org.unicase.EditingDomain");
			RecordingCommandWithResult<Boolean> command = new RecordingCommandWithResult<Boolean>(domain) {
				@Override
				protected void doExecute() {
					EList<AbstractOperation> operations = projectSpace.getLocalOperations().getOperations();
					Boolean hasLocalChanges = new Boolean(!operations.isEmpty());
					this.setTypedResult(hasLocalChanges.equals(expectedValue));
				}
			};
			domain.getCommandStack().execute(command);
			return command.getTypedResult();
		}
		return false;
	}

}
