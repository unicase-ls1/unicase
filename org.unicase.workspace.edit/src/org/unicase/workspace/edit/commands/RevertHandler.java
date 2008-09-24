/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this distribution, and is available at http://www.eclipse.org/legal/epl-v10.html
 * </copyright>
 */
package org.unicase.workspace.edit.commands;

import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.jface.dialogs.MessageDialog;
import org.unicase.workspace.ProjectSpace;

//MK: document whats this exactly does
/**
 * 
 * @author helming
 * 
 */
public class RevertHandler extends ProjectActionHandler {

	/**
	 * {@inheritDoc}
	 */
	public Object execute(final ExecutionEvent event) throws ExecutionException {
		final ProjectSpace projectSpace;
		try {
			projectSpace = getProjectSpace(event);
		} catch (ExecutionException e) {
			//If there is no projectspace, return
			return null;
		}
		TransactionalEditingDomain domain = TransactionalEditingDomain.Registry.INSTANCE
				.getEditingDomain("org.unicase.EditingDomain");
		
		domain.getCommandStack().execute(new RecordingCommand(domain) {
			protected void doExecute() {
				
				MessageDialog dialog = new MessageDialog(null, "Confirmation",
						null, "Do you really want to revert " + projectSpace.getProjectName(),
						MessageDialog.QUESTION, new String[] { "Yes", "No" }, 0);
				int result = dialog.open();
				if (result == 0) {
					//MK: do what ever you like
				}

			}

		});
		return null;
	}
}
