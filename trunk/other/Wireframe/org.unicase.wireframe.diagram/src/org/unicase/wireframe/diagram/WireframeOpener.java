package org.unicase.wireframe.diagram;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecp.common.util.ModelElementOpener;
import org.unicase.ui.unicasecommon.common.diagram.DiagramOpener;
import org.unicase.wireframe.Panel;
import org.unicase.wireframe.diagram.part.WireframeDiagramEditor;

/**
 * Implementation of {@link ModelElementOpener} that will open wireframe diagrams when opening the corresponding
 * {@link Panel} element.
 * 
 * @author mharut
 */
public class WireframeOpener extends DiagramOpener implements ModelElementOpener {

	public int canOpen(EObject modelElement) {
		if (modelElement instanceof Panel) {
			return 1;
		}
		return DONOTOPEN;
	}

	public void openModelElement(EObject modelElement) {
		if (modelElement instanceof Panel) {
			super.openDiagram((Panel) modelElement, WireframeDiagramEditor.ID);
		}
	}

}
