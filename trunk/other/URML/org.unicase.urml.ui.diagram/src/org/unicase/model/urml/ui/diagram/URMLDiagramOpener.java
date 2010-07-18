package org.unicase.model.urml.ui.diagram;

import org.eclipse.emf.ecore.EObject;
import org.unicase.model.urml.URMLDiagram;
import org.unicase.ui.common.ModelElementOpener;
import org.unicase.ui.unicasecommon.common.diagram.DiagramOpener;

public class URMLDiagramOpener extends DiagramOpener implements ModelElementOpener {

	public int canOpen(EObject modelElement) {
		if (modelElement instanceof URMLDiagram) {
			// MEDiagram diagram = (MEDiagram) me;
			// if (diagram.getType().equals(DiagramType.ACTIVITY_DIAGRAM)) {
			return 1;
			// }
		}
		return 0;
	}

	public void openModelElement(EObject modelElement) {
		if (modelElement instanceof URMLDiagram) {
			URMLDiagram diagram = (URMLDiagram) modelElement;
			super.openDiagram(diagram, "org.unicase.model.urml.ui.diagram.part.UrmlDiagramEditorID");
		} else {
			throw new IllegalArgumentException("Opener only applicable for URMLDiagrams");
		}

	}

}
