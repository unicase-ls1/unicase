/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.dashboard;

import org.eclipse.ui.IEditorReference;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.unicase.ui.dashboard.view.DashboardEditorInput;
import org.unicase.workspace.ProjectSpace;
import org.unicase.workspace.util.DeleteProjectSpaceObserver;

/**
 * Performs a cleanup before a project is deleted.
 * 
 * @author Shterev
 */
public class DashboardDeleteProjectObserver implements
		DeleteProjectSpaceObserver {

	/**
	 * {@inheritDoc}
	 */
	public void projectDeleted(ProjectSpace projectSpace) {
		// close all open editors before deleting
		IWorkbenchPage wbpage = PlatformUI.getWorkbench()
				.getActiveWorkbenchWindow().getActivePage();
		IEditorReference[] editors = wbpage.getEditorReferences();
		for (IEditorReference editorReference : editors) {
			try {
				if (editorReference.getEditorInput() instanceof DashboardEditorInput) {
					DashboardEditorInput editorInput = (DashboardEditorInput) editorReference
							.getEditorInput();
					if (projectSpace.equals(editorInput.getProjectSpace())) {
						wbpage.closeEditor(editorReference.getEditor(false),
								false);
					}
				}
			} catch (PartInitException e) {
				// Just print the stacktrace
				e.printStackTrace();
			}
		}

	}
}
