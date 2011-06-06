/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.workspace.ui.commands;

import java.util.Date;

import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.window.Window;
import org.unicase.emfstore.esmodel.versioning.ChangePackage;
import org.unicase.emfstore.esmodel.versioning.LogMessage;
import org.unicase.emfstore.esmodel.versioning.PrimaryVersionSpec;
import org.unicase.emfstore.esmodel.versioning.VersioningFactory;
import org.unicase.emfstore.exceptions.BaseVersionOutdatedException;
import org.unicase.emfstore.exceptions.EmfStoreException;
import org.unicase.workspace.ProjectSpace;
import org.unicase.workspace.Usersession;
import org.unicase.workspace.WorkspaceManager;
import org.unicase.workspace.exceptions.CommitCanceledException;
import org.unicase.workspace.exceptions.NoLocalChangesException;
import org.unicase.workspace.observers.CommitObserver;
import org.unicase.workspace.ui.dialogs.CommitDialog;

/**
 * @author Hodaie
 * @author Shterev This handler handles CommitWorkspace command. This command is shown in UC View context menu only for
 *         Projects
 */
public class CommitProjectHandler extends ServerRequestCommandHandler implements CommitObserver {

	private Usersession usersession;
	private LogMessage logMessage;
	private String predefinedCommitMessage;

	/**
	 * Default constructor.
	 */
	public CommitProjectHandler() {
		super();
		setTaskTitle("Commit project...");
		logMessage = VersioningFactory.eINSTANCE.createLogMessage();
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
				MessageDialog.openInformation(getShell(), "Information", "You must select the Project");
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
	 * @throws EmfStoreException if commit fails.
	 */
	public void handleCommit(ProjectSpace projectSpace) throws EmfStoreException {
		try {
			ChangePackage changePackage = handlePrepareCommit(projectSpace);
			handleFinalizeCommit(projectSpace, changePackage);

		} catch (CommitCanceledException e) {
			// nothing to do. can be ignored
		}
	}

	/**
	 * Shows the user the current dirty changes in the project space that should be committed. If there are some
	 * conflicts a conflict merger will be shown. At the end a merged change package will be returned.
	 * 
	 * @param projectSpace the project space that should be committed
	 * @return a change package
	 * @throws EmfStoreException if the preparation fails
	 * @throws CommitCanceledException if the user cancels the commit
	 */
	public ChangePackage handlePrepareCommit(ProjectSpace projectSpace) throws EmfStoreException,
		CommitCanceledException {
		usersession = projectSpace.getUsersession();

		if (usersession == null) {
			MessageDialog.openInformation(getShell(), null,
				"This project is not yet shared with a server, you cannot commit.");
		}

		try {
			return projectSpace.prepareCommit(CommitProjectHandler.this);

		} catch (BaseVersionOutdatedException e) {
			return handleBaseVersionException(projectSpace);

		} catch (NoLocalChangesException e) {
			MessageDialog.openInformation(getShell(), null, "No local changes in your project. No need to commit.");
			throw new CommitCanceledException("No local changes in project space.");
		}
	}

	/**
	 * A change package that has been returned by the handlePrepareCommit method will be now committed and a new
	 * revision will be created on the server.
	 * 
	 * @param projectSpace a project space
	 * @param changePackage a change package
	 * @throws EmfStoreException if any error in the EmfStore occurs
	 */
	public void handleFinalizeCommit(ProjectSpace projectSpace, ChangePackage changePackage) throws EmfStoreException {
		projectSpace.finalizeCommit(changePackage, logMessage, CommitProjectHandler.this);
	}

	/**
	 * Sets a predefined message to the CommitDialog.
	 * 
	 * @param predefinedCommitMessage The message that will appear in the CommitDialog.
	 */
	public void setPredefinedCommitMessage(String predefinedCommitMessage) {
		this.predefinedCommitMessage = predefinedCommitMessage;
	}

	private ChangePackage handleBaseVersionException(final ProjectSpace projectSpace) throws CommitCanceledException,
		EmfStoreException {
		MessageDialog dialog = new MessageDialog(null, "Confirmation", null,
			"Your project is outdated, you need to update before commit. Do you want to update now?",
			MessageDialog.QUESTION, new String[] { "Yes", "No" }, 0);
		int result = dialog.open();
		if (result == 0) {
			new UpdateProjectHandler().update(projectSpace);
			return projectSpace.prepareCommit(CommitProjectHandler.this);
		}
		throw new CommitCanceledException("Changes have been canceled by the user.");
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.unicase.workspace.observers.CommitObserver#inspectChanges(org.unicase.workspace.ProjectSpace,
	 *      org.unicase.emfstore.esmodel.versioning.ChangePackage)
	 */
	public boolean inspectChanges(ProjectSpace projectSpace, ChangePackage changePackage) {
		if (changePackage.getOperations().isEmpty()) {
			MessageDialog.openInformation(getShell(), "No local changes",
				"Your local changes were mutually exclusive.\nThey are no changes pending for commit.");
			return false;
		}
		CommitDialog commitDialog = new CommitDialog(getShell(), changePackage, projectSpace);
		if (predefinedCommitMessage != null) {
			if (changePackage.getLogMessage() == null) {
				changePackage.setLogMessage(logMessage);
			}

			changePackage.getLogMessage().setMessage(predefinedCommitMessage);
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