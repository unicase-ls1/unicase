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
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.handlers.HandlerUtil;
import org.unicase.emfstore.exceptions.EmfStoreException;
import org.unicase.ui.common.exceptions.ExceptionDialogHandler;
import org.unicase.workspace.ProjectSpace;
import org.unicase.workspace.Usersession;
import org.unicase.workspace.edit.dialogs.LoginDialog;

/**
 * 
 * @author Hodaie This handlers handles UpdateWorkspace command. This command is
 *         shown in UC View context menu only for Projects
 * 
 */
public class UpdateProjectHandler extends ProjectActionHandler {

	/**
	 * . ({@inheritDoc})
	 * 
	 */
	public Object execute(ExecutionEvent event) throws ExecutionException {

		final IWorkbenchWindow window = HandlerUtil.getActiveWorkbenchWindowChecked(event);

		final ProjectSpace projectSpace = (ProjectSpace) getProjectSpace(event);

		TransactionalEditingDomain domain = TransactionalEditingDomain.Registry.INSTANCE.getEditingDomain("org.unicase.EditingDomain");
		domain.getCommandStack().execute(new RecordingCommand(domain) {
			protected void doExecute() {
				Usersession usersession = projectSpace.getUsersession();
				Shell shell = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell();
				LoginDialog login;
				// initially setting the status as successful in case the user
				// is already logged in
				int loginStatus = LoginDialog.SUCCESSFUL;
				if (usersession == null) {
					// TODO: 
				} else if (!usersession.isLoggedIn()) {
					login = new LoginDialog(shell, usersession);
					login.open();
					loginStatus = login.getStatus();
				}
				if (loginStatus == LoginDialog.SUCCESSFUL) {
					try {
						projectSpace.update();
						MessageDialog.openInformation(window.getShell(), null, "Update complete!");
					} catch (EmfStoreException e) {
						ExceptionDialogHandler.showExceptionDialog(e);
					}
				}

			}
		});
		return null;
	}
}
