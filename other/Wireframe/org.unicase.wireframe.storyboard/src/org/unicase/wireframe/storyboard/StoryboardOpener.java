package org.unicase.wireframe.storyboard;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecp.common.util.ModelElementOpener;
import org.unicase.ui.unicasecommon.common.diagram.DiagramOpener;
import org.unicase.wireframe.Storyboard;
import org.unicase.wireframe.storyboard.part.StoryboardDiagramEditor;

/**
 * Implementation of {@link ModelElementOpener} that opens the corresponding storyboard diagram when trying to open a
 * {@link Storyboard} element.
 * 
 * @author mharut
 */
public class StoryboardOpener extends DiagramOpener implements ModelElementOpener {

	public int canOpen(EObject modelElement) {
		if (modelElement instanceof Storyboard) {
			return 1;
		}
		return DONOTOPEN;
	}

	public void openModelElement(EObject modelElement) {
		if (modelElement instanceof Storyboard) {
			super.openDiagram((Storyboard) modelElement, StoryboardDiagramEditor.ID);
		}
	}

}
