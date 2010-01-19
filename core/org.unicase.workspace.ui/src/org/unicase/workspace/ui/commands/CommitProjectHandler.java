/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.workspace.ui.commands;

import java.util.Date;

import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.PlatformUI;
import org.unicase.emfstore.esmodel.versioning.ChangePackage;
import org.unicase.emfstore.esmodel.versioning.LogMessage;
import org.unicase.emfstore.esmodel.versioning.PrimaryVersionSpec;
import org.unicase.emfstore.esmodel.versioning.VersioningFactory;
import org.unicase.emfstore.exceptions.BaseVersionOutdatedException;
import org.unicase.emfstore.exceptions.EmfStoreException;
import org.unicase.workspace.ProjectSpace;
import org.unicase.workspace.Usersession;
import org.unicase.workspace.WorkspaceManager;
import org.unicase.workspace.exceptions.NoLocalChangesException;
import org.unicase.workspace.observers.CommitObserver;
import org.unicase.workspace.ui.dialogs.CommitDialog;

/**
 * @author Hodaie
 * @author Shterev This handler handles CommitWorkspace command. This command is
 *         shown in UC View context menu only for Projects
 */
public class CommitProjectHandler extends ServerRequestCommandHandler implements
		CommitObserver {

	private Shell shell;
	private Usersession usersession;
	private LogMessage logMessage;

	/**
	 * Default constructor.
	 */
	public CommitProjectHandler() {
		super();
		setTaskTitle("Commit project...");
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.unicase.workspace.ui.commands.ServerRequestHandler#run()
	 */
	@Override
	protected Object run() throws EmfStoreException {
		ProjectSpace projectSpace = getProjectSpace();
		if (projectSpace == null) {
			ProjectSpace activeProjectSpace = WorkspaceManager.getInstance()
					.getCurrentWorkspace().getActiveProjectSpace();
			if (activeProjectSpace == null) {
				MessageDialog.openInformation(shell, "Information",
						"You must select the Project");
				return null;
			}
			projectSpace = activeProjectSpace;
		}

		usersession = projectSpace.getUsersession();
		if (usersession == null) {
			MessageDialog
					.openInformation(shell, null,
							"This project is not yet shared with a server, you cannot commit.");
			return null;
		}
		shell = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell();
		try {
			commit(projectSpace);
		} catch (BaseVersionOutdatedException e) {
			handleBaseVersionException(projectSpace);
		} catch (NoLocalChangesException e) {
			MessageDialog.openInformation(shell, null,
					"No local changes in your project. No need to commit.");
		}
		return null;
	}

	private void handleBaseVersionException(final ProjectSpace projectSpace)
			throws EmfStoreException {
		MessageDialog dialog = new MessageDialog(
				null,
				"Confirmation",
				null,
				"Your project is outdated, you need to update before commit. Do you want to update now?",
				MessageDialog.QUESTION, new String[] { "Yes", "No" }, 0);
		int result = dialog.open();
		if (result == 0) {
			new UpdateProjectHandler().update(projectSpace);
			commit(projectSpace);
		}
	}

	private void commit(final ProjectSpace projectSpace)
			throws EmfStoreException, BaseVersionOutdatedException {
		logMessage = VersioningFactory.eINSTANCE.createLogMessage();
		PrimaryVersionSpec oldVersion = projectSpace.getBaseVersion();
		PrimaryVersionSpec newVersion = projectSpace.commit(logMessage,
				CommitProjectHandler.this);
		if (!oldVersion.equals(newVersion)) {
			MessageDialog.openInformation(shell, null, "Commit completed.");
		}
	}

	/**
	 * {@inheritDoc}
	 */
	public boolean inspectChanges(ProjectSpace projectSpace,
			ChangePackage changePackage) {
		if (changePackage.getOperations().isEmpty()) {
			MessageDialog
					.openInformation(
							shell,
							"No local changes",
							"Your local changes were mutually exclusive.\nThe are no changes pending for commit.");
			return false;
		}
		CommitDialog commitDialog = new CommitDialog(shell, changePackage);
		int returnCode = commitDialog.open();
		if (returnCode == Window.OK) {
			logMessage.setAuthor(usersession.getUsername());
			logMessage.setClientDate(new Date());
			logMessage.setMessage(commitDialog.getLogText());
			return true;
		}
		return false;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.unicase.workspace.observers.CommitObserver#commitCompleted()
	 */
	public void commitCompleted(ProjectSpace projectSpace,
			PrimaryVersionSpec versionSpec) {
	}

}