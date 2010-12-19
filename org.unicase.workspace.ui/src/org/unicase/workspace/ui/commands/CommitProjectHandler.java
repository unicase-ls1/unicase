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
 * @author Shterev This handler handles CommitWorkspace command. This command is shown in UC View context menu only for
 *         Projects
 */
// TODO RAP (Instantiation of the shell)
public class CommitProjectHandler extends ServerRequestCommandHandler implements CommitObserver {

	private Shell shell;
	private Usersession usersession;
	private LogMessage logMessage;
	private String predefinedCommitMessage;

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
			ProjectSpace activeProjectSpace = WorkspaceManager.getInstance().getCurrentWorkspace()
				.getActiveProjectSpace();
			if (activeProjectSpace == null) {
				MessageDialog.openInformation(shell, "Information", "You must select the Project");
				return null;
			}
			projectSpace = activeProjectSpace;
		}

		handleCommit(projectSpace);
		return null;
	}

	/**
	 * Shows the CommitDialog and handles error situations.
	 * 
	 * @param projectSpace ProjectSpace that will be committed.
	 * @throws EmfStoreException if commit goes wrong.
	 */
	public void handleCommit(ProjectSpace projectSpace) throws EmfStoreException {
		usersession = projectSpace.getUsersession();
		if (usersession == null) {
			MessageDialog.openInformation(shell, null,
				"This project is not yet shared with a server, you cannot commit.");
		}
		shell = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell();
		try {
			commit(projectSpace);
		} catch (BaseVersionOutdatedException e) {
			handleBaseVersionException(projectSpace);
		} catch (NoLocalChangesException e) {
			MessageDialog.openInformation(shell, null, "No local changes in your project. No need to commit.");
		}
	}

	/**
	 * Sets a predefined messagte to the CommitDialog.
	 * 
	 * @param predefinedCommitMessage The message that will appear in the CommitDialog.
	 */
	public void setPredefinedCommitMessage(String predefinedCommitMessage) {
		this.predefinedCommitMessage = predefinedCommitMessage;
	}

	private void handleBaseVersionException(final ProjectSpace projectSpace) throws EmfStoreException {
		MessageDialog dialog = new MessageDialog(null, "Confirmation", null,
			"Your project is outdated, you need to update before commit. Do you want to update now?",
			MessageDialog.QUESTION, new String[] { "Yes", "No" }, 0);
		int result = dialog.open();
		if (result == 0) {
			new UpdateProjectHandler().update(projectSpace);
			commit(projectSpace);
		}
	}

	private void commit(final ProjectSpace projectSpace) throws EmfStoreException, BaseVersionOutdatedException {
		logMessage = VersioningFactory.eINSTANCE.createLogMessage();
		projectSpace.commit(logMessage, CommitProjectHandler.this);
	}

	/**
	 * {@inheritDoc}
	 */
	public boolean inspectChanges(ProjectSpace projectSpace, ChangePackage changePackage) {
		if (changePackage.getOperations().isEmpty()) {
			MessageDialog.openInformation(shell, "No local changes",
				"Your local changes were mutually exclusive.\nThe are no changes pending for commit.");
			return false;
		}
		CommitDialog commitDialog = new CommitDialog(shell, changePackage, projectSpace);
		if (predefinedCommitMessage != null) {
			LogMessage logMessage = VersioningFactory.eINSTANCE.createLogMessage();
			logMessage.setMessage(predefinedCommitMessage);
			changePackage.setLogMessage(logMessage);
		}
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
	public void commitCompleted(ProjectSpace projectSpace, PrimaryVersionSpec versionSpec) {
	}

}