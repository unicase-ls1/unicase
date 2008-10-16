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
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.dialogs.ProgressMonitorDialog;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.PlatformUI;
import org.unicase.emfstore.esmodel.versioning.ChangePackage;
import org.unicase.emfstore.esmodel.versioning.VersionSpec;
import org.unicase.emfstore.exceptions.ConnectionException;
import org.unicase.emfstore.exceptions.EmfStoreException;
import org.unicase.ui.common.exceptions.DialogHandler;
import org.unicase.ui.stem.views.dialogs.MergeDialog;
import org.unicase.ui.stem.views.dialogs.UpdateDialog;
import org.unicase.workspace.ProjectSpace;
import org.unicase.workspace.Usersession;
import org.unicase.workspace.edit.dialogs.LoginDialog;
import org.unicase.workspace.exceptions.ChangeConflictException;
import org.unicase.workspace.exceptions.NoChangesOnServerException;
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
	private Usersession usersession;

	/**
	 * {@inheritDoc}
	 */
	public Object execute(ExecutionEvent event) throws ExecutionException {

		final ProjectSpace projectSpace = getProjectSpace(event);

		update(projectSpace);

		return null;
	}

	/**
	 * Updates the given projectSpace to the current head revision.
	 * 
	 * @param projectSpace
	 *            the project space
	 */
	public void update(final ProjectSpace projectSpace) {
		TransactionalEditingDomain domain = TransactionalEditingDomain.Registry.INSTANCE
				.getEditingDomain("org.unicase.EditingDomain");
		RecordingCommandWithResult<Integer> command = new RecordingCommandWithResult<Integer>(
				domain) {
			@Override
			protected void doExecute() {
				updateWithoutCommand(projectSpace);
			}
		};
		domain.getCommandStack().execute(command);
	}

	private void updateWithoutCommand(final ProjectSpace projectSpace) {
		usersession = projectSpace.getUsersession();
		shell = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell();
		ProgressMonitorDialog progressDialog = new ProgressMonitorDialog(
				PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell());
		LoginDialog login;
		// initially setting the status as successful in case the user
		// is already logged in
		int loginStatus = LoginDialog.SUCCESSFUL;
		try {
			update(projectSpace, progressDialog, loginStatus);
		} catch (ChangeConflictException e1) {
			handleChangeConflictException(e1);
		} catch (NoChangesOnServerException e) {
			MessageDialog
					.openInformation(shell, "No need to update",
							"Your project is update to date, you do not need to update.");
		} catch (ConnectionException e) {
			try {
				//try to reconnect once.
				usersession.logIn();
				update(projectSpace, progressDialog, loginStatus);
			} catch (ChangeConflictException e1) {
				handleChangeConflictException(e1);
			} catch (EmfStoreException e1) {
				DialogHandler.showExceptionDialog(e1);
			} // BEGIN SUPRESS CATCH EXCEPTION
			catch (Exception e1) {
				DialogHandler.showExceptionDialog(e1);
			}
			// END SUPRESS CATCH EXCEPTION
		} catch (EmfStoreException e2) {
			DialogHandler.showExceptionDialog(e2);
		}
		// BEGIN SUPRESS CATCH EXCEPTION
		catch (Exception e) {
			DialogHandler.showExceptionDialog(e);
		}
		// END SUPRESS CATCH EXCEPTION
		finally {
			progressDialog.getProgressMonitor().done();
			progressDialog.close();
		}
	}

	private void handleChangeConflictException(ChangeConflictException e1) {
		List<ChangePackage> changePackages = e1.getNewPackages();
		MergeDialog mergeDialog = new MergeDialog(shell, changePackages);
		mergeDialog.open();
	}

	private void update(final ProjectSpace projectSpace,
			ProgressMonitorDialog progressDialog, int loginStatus)
			throws EmfStoreException, ChangeConflictException {
		LoginDialog login;
		if (!usersession.isLoggedIn()) {
			login = new LoginDialog(shell, usersession, usersession
					.getServerInfo());
			loginStatus = login.open();
		}
		if (loginStatus == LoginDialog.SUCCESSFUL) {
			progressDialog.open();
			progressDialog.getProgressMonitor().beginTask("Update project...",
					100);
			progressDialog.getProgressMonitor().worked(10);
			projectSpace.update(VersionSpec.HEAD_VERSION,
					UpdateProjectHandler.this);
		}
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
