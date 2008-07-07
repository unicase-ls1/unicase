/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this distribution, and is available at http://www.eclipse.org/legal/epl-v10.html
 * </copyright>
 *
 * $Id$
 */
package org.unicase.ui.navigator;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.common.ui.URIEditorInput;
import org.eclipse.emf.common.util.URI;
import org.eclipse.jface.dialogs.ErrorDialog;
import org.eclipse.jface.viewers.DoubleClickEvent;
import org.eclipse.jface.viewers.TreeSelection;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.navigator.CommonNavigator;
import org.unicase.model.ModelElement;
import org.unicase.model.diagram.MEDiagram;
import org.unicase.ui.meeditor.MEEditor;
import org.unicase.ui.meeditor.MEEditorInput;
import org.unicase.workspace.Workspace;
import org.unicase.workspace.WorkspaceManager;
/**
 * The standard navigator tree view.
 * @author helming
 *
 */
public class TreeView extends CommonNavigator {

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected IAdaptable getInitialInput() {
		Workspace workspace = WorkspaceManager.getInstance()
				.getCurrentWorkspace();
		return workspace;
		

	}



	/**
	 * . ({@inheritDoc}) On DoubleClick open the ModelElement in Editor
	 */
	@Override
	protected void handleDoubleClick(DoubleClickEvent anEvent) {
				TreeSelection selection = (TreeSelection) anEvent.getSelection();
		Object object = selection.getFirstElement();
		if (object instanceof ModelElement) {
			if (object instanceof MEDiagram) {
				ModelElement modelElement = (ModelElement) object;
				URIEditorInput input = new URIEditorInput(URI
						.createURI(modelElement.eResource().getURIFragment(
								modelElement)));
				try {
					PlatformUI
							.getWorkbench()
							.getActiveWorkbenchWindow()
							.getActivePage()
							.openEditor(
									input,
									"org.unicase.model.classDiagram.part.ModelDiagramEditorID",
									true);
				} catch (PartInitException e) {
					ErrorDialog.openError(PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell(), "Error", e.getMessage(), e.getStatus());
				}
			} else {
				MEEditorInput input = new MEEditorInput((ModelElement) object);
				try {
					PlatformUI.getWorkbench().getActiveWorkbenchWindow()
							.getActivePage().openEditor(input,MEEditor.ID,
									true);
				} catch (PartInitException e) {
					ErrorDialog.openError(PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell(), "Error", e.getMessage(), e.getStatus());
				}
			}
		}
	}



}
