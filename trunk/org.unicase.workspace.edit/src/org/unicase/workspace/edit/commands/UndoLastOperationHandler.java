/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.workspace.edit.commands;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.unicase.ui.common.util.ActionHelper;
import org.unicase.workspace.ProjectSpace;

/**
 * UndoLastOperationHandler.
 * 
 * @author Hodaie
 */
public class UndoLastOperationHandler extends AbstractHandler {

	/**
	 * {@inheritDoc}
	 */
	public Object execute(ExecutionEvent event) throws ExecutionException {
		final ProjectSpace projectSpace = ActionHelper.getProjectSpace(event);
		TransactionalEditingDomain domain = TransactionalEditingDomain.Registry.INSTANCE
			.getEditingDomain("org.unicase.EditingDomain");
		domain.getCommandStack().execute(new RecordingCommand(domain) {
			@Override
			protected void doExecute() {
				projectSpace.undoLastOperation();

			}
		});
		return null;
	}
}
