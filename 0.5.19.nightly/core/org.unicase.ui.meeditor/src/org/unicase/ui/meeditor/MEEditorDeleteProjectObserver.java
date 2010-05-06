/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.meeditor;

import org.eclipse.ui.IEditorReference;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.unicase.workspace.ProjectSpace;
import org.unicase.workspace.util.DeleteProjectSpaceObserver;

/**
 * Performs a cleanup before a project is deleted.
 * 
 * @author Shterev
 */
public class MEEditorDeleteProjectObserver implements DeleteProjectSpaceObserver {

	/**
	 * {@inheritDoc}
	 */
	public void projectDeleted(ProjectSpace projectSpace) {
		// close all open editors before deleting
		IWorkbenchPage wbpage = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
		IEditorReference[] editors = wbpage.getEditorReferences();
		for (IEditorReference editorReference : editors) {
			try {
				if (editorReference.getEditorInput() instanceof MEEditorInput) {
					MEEditorInput editorInput = (MEEditorInput) editorReference.getEditorInput();
					if (projectSpace.getProject().equals(editorInput.getModelElement().getProject())) {
						// don't ask for saving, because we delete the
						// project anyways
						wbpage.closeEditor(editorReference.getEditor(false), false);
					}
				}
			} catch (PartInitException e) {
				// Just print the stacktrace
				e.printStackTrace();
			}
		}

	}
}
