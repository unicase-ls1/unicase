/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this distribution, and is available at http://www.eclipse.org/legal/epl-v10.html
 * </copyright>
 *
 * $Id$
 */
package org.unicase.workspace.edit.commands;

import java.util.List;

import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.PlatformUI;
import org.unicase.emfstore.esmodel.versioning.ChangePackage;
import org.unicase.emfstore.esmodel.versioning.VersionSpec;
import org.unicase.emfstore.exceptions.EmfStoreException;
import org.unicase.ui.common.exceptions.DialogHandler;
import org.unicase.ui.stem.views.dialogs.MergeDialog;
import org.unicase.ui.stem.views.dialogs.UpdateDialog;
import org.unicase.workspace.ProjectSpace;
import org.unicase.workspace.Usersession;
import org.unicase.workspace.edit.dialogs.LoginDialog;
import org.unicase.workspace.exceptions.ChangeConflictException;
import org.unicase.workspace.util.RecordingCommandWithResult;
import org.unicase.workspace.util.UpdateObserver;

/**
 * 
 * @author Hodaie
 * @author Shterev
 * 
 *         This handlers handles UpdateWorkspace command. This command is shown
 *         in UC View context menu only for Projects
 * 
 */
public class UpdateProjectHandler extends ProjectActionHandler implements
		UpdateObserver {

	private Shell shell;

	/**
	 * {@inheritDoc}
	 */
	public Object execute(ExecutionEvent event) throws ExecutionException {

		final ProjectSpace projectSpace = (ProjectSpace) getProjectSpace(event);

		TransactionalEditingDomain domain = TransactionalEditingDomain.Registry.INSTANCE
				.getEditingDomain("org.unicase.EditingDomain");
		RecordingCommandWithResult<Integer> command = new RecordingCommandWithResult<Integer>(
				domain) {

			protected void doExecute() {
				Usersession usersession = projectSpace.getUsersession();
				shell = PlatformUI.getWorkbench().getActiveWorkbenchWindow()
						.getShell();
				LoginDialog login;
				// initially setting the status as successful in case the user
				// is already logged in
				int loginStatus = LoginDialog.SUCCESSFUL;
				try {
					if (!usersession.isLoggedIn()) {
						login = new LoginDialog(shell, usersession, usersession
								.getServerInfo());
						loginStatus = login.open();
					}
					this.setTypedResult(loginStatus);
				} catch (NullPointerException e3) {
					//FIXME AS why?
					// usersession was null -> fail silently
				}
			}
		};
		domain.getCommandStack().execute(command);

		if (command.getTypedResult() != null) {
			try {
				if (command.getTypedResult().intValue() == LoginDialog.SUCCESSFUL) {
					projectSpace.update(VersionSpec.HEAD_VERSION,
							UpdateProjectHandler.this);
				}
			} catch (ChangeConflictException e1) {
				List<ChangePackage> changePackages = e1.newPackages;
				MergeDialog mergeDialog = new MergeDialog(shell, changePackages);
				mergeDialog.open();
			} catch (EmfStoreException e2) {
				DialogHandler.showExceptionDialog(e2);
				e2.printStackTrace();
			}
		}

		return null;
	}

	/**
	 * {@inheritDoc}
	 */
	public boolean inspectChanges(List<ChangePackage> changePackages) {
		UpdateDialog updateDialog = new UpdateDialog(shell, changePackages);
		int returnCode = updateDialog.open();
		if (returnCode == Window.OK) {
			return true;
		}
		return false;
	}
}
