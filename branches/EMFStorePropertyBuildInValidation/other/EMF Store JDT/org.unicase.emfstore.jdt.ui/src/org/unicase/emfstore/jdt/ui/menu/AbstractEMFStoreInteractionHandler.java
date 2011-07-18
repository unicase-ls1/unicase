/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.emfstore.jdt.ui.menu;

import org.eclipse.jface.window.Window;
import org.eclipse.swt.widgets.Shell;
import org.unicase.emfstore.esmodel.ProjectInfo;
import org.unicase.emfstore.jdt.eclipseworkspace.emfstore.EMFStoreUtil;
import org.unicase.emfstore.jdt.exception.ProjectInfoNotFoundException;
import org.unicase.emfstore.jdt.exception.ProjectSpaceNotFoundException;
import org.unicase.emfstore.jdt.ui.dialog.SelectionDialog;
import org.unicase.emfstore.jdt.ui.exception.NoProjectSelectedException;
import org.unicase.workspace.ProjectSpace;
import org.unicase.workspace.ServerInfo;
import org.unicase.workspace.Usersession;

/**
 * Abstract class, that provides the functionality to select a project from an EMFStore. So the extending classes do not
 * have to re-implements this functionality.
 * 
 * @author Adrian Staudt
 */
public abstract class AbstractEMFStoreInteractionHandler extends AbstractCommanHandler {

	private ProjectInfo selectedProjectInfo;
	private ServerInfo selectedServerInfo;

	/**
	 * Opens a dialog where the user can select a project.
	 * 
	 * @param shell The parent shell.
	 * @return The corresponding ProjectSpace.
	 * @throws NoProjectSelectedException Will be thrown if no project has been selected.
	 * @throws ProjectSpaceNotFoundException Will be thrown if the project cannot be checked out.
	 */
	protected ProjectSpace selectProject(Shell shell) throws NoProjectSelectedException, ProjectSpaceNotFoundException {
		SelectionDialog dialog = new SelectionDialog(shell);
		dialog.create();
		if (dialog.open() == Window.OK) {
			selectedProjectInfo = dialog.getSelectedProjectInfo();
			selectedServerInfo = dialog.getSelectedServerInfo();

			return getProject(selectedProjectInfo, selectedServerInfo);
		}

		throw new NoProjectSelectedException();
	}

	/**
	 * Returns the from the selected project the corresponding project info.
	 * 
	 * @return The project info.
	 */
	protected ProjectInfo getSelectedProjectInfo() {
		return selectedProjectInfo;
	}

	/**
	 * Returns the from the selected project the corresponding server info.
	 * 
	 * @return The server info.
	 */
	protected ServerInfo getSelectedServerInfo() {
		return selectedServerInfo;
	}

	/**
	 * Returns for a project definition the corresponding ProjectSpace. If it is not locally available it will be
	 * checked out.
	 * 
	 * @param selectedProjectInfo The project info.
	 * @param selectedServerInfo The server info.
	 * @return The corresponding project Space.
	 * @throws ProjectSpaceNotFoundException Will be thrown if the project cannot be checked out.
	 */
	private ProjectSpace getProject(ProjectInfo selectedProjectInfo, ServerInfo selectedServerInfo)
		throws ProjectSpaceNotFoundException {

		ProjectSpace projectSpace;
		try {
			projectSpace = EMFStoreUtil.getProjectSpace(selectedServerInfo, selectedProjectInfo);

		} catch (ProjectSpaceNotFoundException e) {
			// project is locally not available - check it out
			try {
				Usersession usersession = selectedServerInfo.getLastUsersession();
				EMFStoreUtil.checkSanity(usersession);
				projectSpace = EMFStoreUtil.checkout(usersession, selectedProjectInfo);

			} catch (ProjectInfoNotFoundException ex) {
				throw new ProjectSpaceNotFoundException();
			}
		}

		return projectSpace;
	}
}
