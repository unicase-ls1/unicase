/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.workspace.edit.commands;

import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.unicase.workspace.ProjectSpace;
import org.unicase.workspace.WorkspaceManager;
import org.unicase.workspace.edit.dashboard.DashboardEditorInput;
import org.unicase.workspace.util.WorkspaceUtil;

/**
 * Handler for viewing the dashboard of the current project.
 * 
 * @author Shterev
 */
public class ShowDashboardHandler extends ProjectActionHandler {

	/**
	 * {@inheritDoc}
	 */
	public Object execute(final ExecutionEvent event) throws ExecutionException {

		ProjectSpace activeProjectSpace = WorkspaceManager.getInstance().getCurrentWorkspace().getActiveProjectSpace();
		DashboardEditorInput input = new DashboardEditorInput(activeProjectSpace);
		try {
			PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().openEditor(input,
				"org.unicase.workspace.edit.dashboard", true);
		} catch (PartInitException e) {
			WorkspaceUtil.logException(e.getMessage(), e);
		}

		return null;
	}

}