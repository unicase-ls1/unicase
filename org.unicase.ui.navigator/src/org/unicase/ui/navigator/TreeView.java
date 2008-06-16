package org.unicase.ui.navigator;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.common.ui.URIEditorInput;
import org.eclipse.emf.common.util.URI;
import org.eclipse.jface.viewers.DoubleClickEvent;
import org.eclipse.jface.viewers.TreeSelection;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.navigator.CommonNavigator;
import org.unicase.model.ModelElement;
import org.unicase.model.diagram.MEDiagram;
import org.unicase.ui.meeditor.MEEditorInput;
import org.unicase.workspace.Workspace;
import org.unicase.workspace.WorkspaceManager;

public class TreeView extends CommonNavigator {

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
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} else {
				MEEditorInput input = new MEEditorInput((ModelElement) object);
				try {
					PlatformUI.getWorkbench().getActiveWorkbenchWindow()
							.getActivePage().openEditor(input,
									"org.unicase.ui.meeditor", true);
				} catch (PartInitException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

}
