/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.workspace.edit.commands;

import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.unicase.ui.common.exceptions.DialogHandler;
import org.unicase.workspace.util.WorkspaceUtil;

/**
 * A super class to handle all requests made to the server that require a RecordingCommand.
 * 
 * @author Shterev
 */
public abstract class ServerRequestCommandHandler extends ServerRequestHandler {

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		this.setEvent(event);
		TransactionalEditingDomain domain = TransactionalEditingDomain.Registry.INSTANCE
			.getEditingDomain("org.unicase.EditingDomain");
		domain.getCommandStack().execute(new RecordingCommand(domain) {

			@Override
			protected void doExecute() {
				try {
					handleRun();
				} catch (ExecutionException e) {
					DialogHandler.showExceptionDialog(e);
					WorkspaceUtil.logException("Exception during login", e);
				}
			}
		});
		return null;
	}
}
