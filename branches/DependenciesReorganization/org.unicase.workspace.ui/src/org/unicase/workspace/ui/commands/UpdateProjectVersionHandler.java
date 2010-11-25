/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.workspace.ui.commands;

import java.util.List;

import org.eclipse.jface.dialogs.InputDialog;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.PlatformUI;
import org.unicase.emfstore.esmodel.versioning.ChangePackage;
import org.unicase.emfstore.esmodel.versioning.PrimaryVersionSpec;
import org.unicase.emfstore.esmodel.versioning.VersioningFactory;
import org.unicase.emfstore.exceptions.EmfStoreException;
import org.unicase.util.ActionHelper;
import org.unicase.workspace.ProjectSpace;
import org.unicase.workspace.Usersession;
import org.unicase.workspace.WorkspaceManager;
import org.unicase.workspace.exceptions.ChangeConflictException;
import org.unicase.workspace.exceptions.NoChangesOnServerException;
import org.unicase.workspace.observers.UpdateObserver;
import org.unicase.workspace.ui.dialogs.UpdateDialog;
import org.unicase.workspace.util.WorkspaceUtil;

/**
 * This handlers updates the Project to a user-defined version. It is only intended to be used by admins as no
 * validation checks are made on the version number.
 * 
 * @author Shterev
 */
public class UpdateProjectVersionHandler extends ServerRequestCommandHandler implements UpdateObserver {

	private Shell shell = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell();
	private Usersession usersession;

	/**
	 * Default constructor.
	 */
	public UpdateProjectVersionHandler() {
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
	 * Updates the project space.
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

		InputDialog inputDialog = new InputDialog(shell, "Update to version...", "Enter the new version:", "", null);
		if (inputDialog.open() != Window.OK) {
			return;
		}
		int version = 0;
		try {
			version = Integer.parseInt(inputDialog.getValue());
		} catch (NumberFormatException e) {
			MessageDialog.openError(shell, "Invalid input", "A numerical value was expected!");
			update(projectSpace);
		}

		PrimaryVersionSpec targetVersionSpec = VersioningFactory.eINSTANCE.createPrimaryVersionSpec();
		targetVersionSpec.setIdentifier(version);

		update(projectSpace, targetVersionSpec);
	}

	/**
	 * Updates the project space to a certain version.
	 * 
	 * @param projectSpace the target project space
	 * @param targetVersionSpec the target version of the project space
	 * @throws EmfStoreException if any.
	 */
	public void update(final ProjectSpace projectSpace, PrimaryVersionSpec targetVersionSpec) throws EmfStoreException {
		PrimaryVersionSpec baseVersion = projectSpace.getBaseVersion();

		try {
			PrimaryVersionSpec targetVersion = projectSpace.update(targetVersionSpec, UpdateProjectVersionHandler.this);
			WorkspaceUtil.logUpdate(projectSpace, baseVersion, targetVersion);

			// explicitly refresh the decorator since no simple attribute has
			// been changed
			// (as opposed to committing where the dirty property is being set)
			Display.getDefault().asyncExec(new Runnable() {
				public void run() {
					PlatformUI.getWorkbench().getDecoratorManager()
						.update("org.unicase.ui.common.decorators.VersionDecorator");
				}
			});
		} catch (ChangeConflictException e1) {
			handleChangeConflictException(e1);
		} catch (NoChangesOnServerException e) {
			MessageDialog.openInformation(shell, "No need to update",
				"Your project is up to date, you do not need to update.");
		}
	}

	private void handleChangeConflictException(ChangeConflictException e1) {
		MessageDialog.openError(Display.getCurrent().getActiveShell(), "Ooops!",
			"This feature is not implemented yet! We are sorry for the inconvenience.");
	}

	/**
	 * {@inheritDoc}
	 */
	public boolean inspectChanges(ProjectSpace projectSpace, List<ChangePackage> changePackages) {
		UpdateDialog updateDialog = new UpdateDialog(shell, projectSpace, changePackages);
		int returnCode = updateDialog.open();
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
	public void updateCompleted() {
		ActionHelper.openDashboard();
	}

}
