/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.workspace.edit.commands;

import org.eclipse.core.expressions.PropertyTester;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.unicase.emfstore.accesscontrol.AccessControlException;
import org.unicase.workspace.ProjectSpace;
import org.unicase.workspace.Usersession;
import org.unicase.workspace.accesscontrol.AccessControlHelper;
import org.unicase.workspace.util.RecordingCommandWithResult;

/**
 * This property tester checks if current user has administrative rights upon a project. If true, then some
 * corresponding commands can be shown.
 * 
 * @author Hodaie
 */
public class IsAdminTester extends PropertyTester {

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
					Usersession usersession = projectSpace.getUsersession();
					boolean isAdmin = false;
					if (usersession != null && usersession.getACUser() != null) {

						AccessControlHelper accessControlHelper = new AccessControlHelper(usersession);
						try {
							accessControlHelper.checkProjectAdminAccess(projectSpace.getProjectId());
							isAdmin = true;
						} catch (AccessControlException e) {
							isAdmin = false;
						}
					}

					this.setTypedResult((new Boolean(isAdmin)).equals(expectedValue));
				}
			};
			domain.getCommandStack().execute(command);
			return command.getTypedResult();
		}
		return false;
	}

}
