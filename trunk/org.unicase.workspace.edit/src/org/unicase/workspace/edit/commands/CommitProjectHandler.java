/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this distribution, and is available at http://www.eclipse.org/legal/epl-v10.html
 * </copyright>
 *
 * $Id$
 */
package org.unicase.workspace.edit.commands;

import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.handlers.HandlerUtil;
import org.unicase.emfstore.exceptions.EmfStoreException;
import org.unicase.ui.common.exceptions.ExceptionDialogHandler;
import org.unicase.workspace.ProjectSpace;

/**
 * 
 * @author Hodaie This handlers handles CommitWorkspace command. This command is
 *         shown in UC View context menu only for Projects
 * 
 */
public class CommitProjectHandler extends ProjectActionHandler {

	/**
	 * . ({@inheritDoc})
	 * 
	 */
	public Object execute(ExecutionEvent event) throws ExecutionException {

		IWorkbenchWindow window = HandlerUtil
		.getActiveWorkbenchWindowChecked(event);




		final ProjectSpace projectSpace = getProjectSpace(event);

		TransactionalEditingDomain domain = TransactionalEditingDomain.Registry.INSTANCE
				.getEditingDomain("org.unicase.EditingDomain");
		domain.getCommandStack().execute(new RecordingCommand(domain) {
			protected void doExecute() {
				try {
					projectSpace.commit();
				} catch (EmfStoreException e) {
					ExceptionDialogHandler.showExceptionDialog(e);
				}
			}
		});

		MessageDialog.openInformation(window.getShell(), null,
		"Commit completed.");
		
		return null;
	}

}
