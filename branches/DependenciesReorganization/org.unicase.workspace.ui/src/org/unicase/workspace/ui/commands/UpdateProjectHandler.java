/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.workspace.ui.commands;

import java.util.List;

import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.PlatformUI;
import org.unicase.emfstore.esmodel.versioning.ChangePackage;
import org.unicase.emfstore.esmodel.versioning.PrimaryVersionSpec;
import org.unicase.emfstore.esmodel.versioning.VersionSpec;
import org.unicase.emfstore.exceptions.EmfStoreException;
import org.unicase.workspace.ProjectSpace;
import org.unicase.workspace.Usersession;
import org.unicase.workspace.WorkspaceManager;
import org.unicase.workspace.exceptions.ChangeConflictException;
import org.unicase.workspace.exceptions.NoChangesOnServerException;
import org.unicase.workspace.observers.UpdateObserver;
import org.unicase.workspace.ui.dialogs.UpdateDialog;
import org.unicase.workspace.util.WorkspaceUtil;

/**
 * This handlers handles UpdateWorkspace command. This command is shown in UC View context menu only for Projects
 * 
 * @author Hodaie
 * @author Shterev
 */
public class UpdateProjectHandler extends ServerRequestCommandHandler implements UpdateObserver {

	private Shell shell = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell();
	private Usersession usersession;

	/**
	 * Default constructor.
	 */
	public UpdateProjectHandler() {
		setTaskTitle("Update project...");
	}

	/**
	 * {@inheritDoc}
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

		update(projectSpace);

		return null;
	}

	/**
	 * Updates the projectspace.
	 * 
	 * @param projectSpace the target project space
	 * @throws EmfStoreException if any.
	 */
	public void update(final ProjectSpace projectSpace) throws EmfStoreException {
		usersession = projectSpace.getUsersession();
		if (usersession == null) {
			MessageDialog.openInformation(shell, null,
				"This project is not yet shared with a server, you cannot update.");
			return;
		}

		try {
			PrimaryVersionSpec baseVersion = projectSpace.getBaseVersion();
			PrimaryVersionSpec targetVersion = projectSpace.update(VersionSpec.HEAD_VERSION, UpdateProjectHandler.this);
			WorkspaceUtil.logUpdate(projectSpace, baseVersion, targetVersion);

			// explicitly refresh the decorator since no simple attribute has
			// been changed
			// (as opposed to committing where the dirty property is being set)
			Display.getDefault().asyncExec(new Runnable() {
				public void run() {
					PlatformUI.getWorkbench().getDecoratorManager().update(
						"org.unicase.ui.common.decorators.VersionDecorator");
				}
			});
		} catch (ChangeConflictException e1) {
			handleChangeConflictException(e1);
		} catch (NoChangesOnServerException e) {
			MessageDialog.openInformation(shell, "No need to update",
				"Your project is up to date, you do not need to update.");
		}
	}

	private void handleChangeConflictException(ChangeConflictException conflictException) {
		ProjectSpace projectSpace = conflictException.getProjectSpace();
		try {
			PrimaryVersionSpec targetVersion = projectSpace.resolveVersionSpec(VersionSpec.HEAD_VERSION);
			projectSpace.merge(targetVersion, new MergeProjectHandler(conflictException));
		} catch (EmfStoreException e) {
			WorkspaceUtil.logException("Exception when merging the project!", e);
		}
	}

	/**
	 * {@inheritDoc}
	 */
	public boolean inspectChanges(ProjectSpace projectSpace, List<ChangePackage> changePackages) {
		UpdateDialog updateDialog = new UpdateDialog(shell, projectSpace, changePackages);
		int returnCode = updateDialog.open();

		// IWorkbenchPage page =
		// PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
		// String viewId = "org.unicase.workspace.ui.views.CompareView";
		// CompareView compareView = null;
		// try {
		// compareView = (CompareView) page.showView(viewId);
		// } catch (PartInitException e) {
		// DialogHandler.showExceptionDialog(e);
		// }
		// if (compareView != null) {
		// compareView.setInput(getProjectSpace().getProject(),
		// changePackages.get(0));
		// }

		if (returnCode == Window.OK) {
			return true;
		}
		return false;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.unicase.workspace.observers.UpdateObserver#updateCompleted()
	 */
	public void updateCompleted(ProjectSpace projectSpace) {
		// TODO: ChainSaw
		// ActionHelper.openDashboard();
	}

}
