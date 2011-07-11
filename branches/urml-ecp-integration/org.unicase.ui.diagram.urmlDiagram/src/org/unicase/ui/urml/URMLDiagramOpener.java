package org.unicase.ui.urml;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecp.common.util.ModelElementOpener;
import org.unicase.model.urml.URMLDiagram;
import org.unicase.ui.unicasecommon.common.diagram.DiagramOpener;

public class URMLDiagramOpener extends DiagramOpener implements ModelElementOpener {

	public int canOpen(EObject modelElement) {
		if (modelElement instanceof URMLDiagram) {
			// MEDiagram diagram = (MEDiagram) me;
			// if (diagram.getType().equals(DiagramType.ACTIVITY_DIAGRAM)) {
			return 1;
			// }
		}
		return -1;
	}

	public void openModelElement(EObject modelElement) {
		if (modelElement instanceof URMLDiagram) {
			URMLDiagram diagram = (URMLDiagram) modelElement;
			super.openDiagram(diagram, "org.unicase.ui.diagram.urml.part.UrmlDiagramEditorID");
		} else {
			throw new IllegalArgumentException("Opener only applicable for URMLDiagrams");
		}

	}

}
