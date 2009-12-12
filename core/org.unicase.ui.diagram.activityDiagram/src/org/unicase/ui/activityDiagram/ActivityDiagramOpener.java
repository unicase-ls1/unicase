package org.unicase.ui.activityDiagram;

import org.unicase.metamodel.ModelElement;
import org.unicase.model.diagram.DiagramType;
import org.unicase.model.diagram.MEDiagram;
import org.unicase.ui.common.ModelElementOpener;
import org.unicase.ui.unicasecommon.common.diagram.DiagramOpener;

public class ActivityDiagramOpener extends DiagramOpener implements ModelElementOpener {

	public int canOpen(ModelElement me) {
		if (me instanceof MEDiagram) {
			MEDiagram diagram = (MEDiagram) me;
			if (diagram.getType().equals(DiagramType.ACTIVITY_DIAGRAM)) {
				return 1;
			}
		}
		return 0;
	}

	public void openModelElement(ModelElement modelElement) {
		if (modelElement instanceof MEDiagram) {
			MEDiagram diagram = (MEDiagram) modelElement;
			super.openDiagram(diagram, "org.unicase.ui.diagram.activityDiagram.part.ModelDiagramEditorID");
		} else
			throw new IllegalArgumentException("Opener only applicable for MEDiagrams");

	}

}
