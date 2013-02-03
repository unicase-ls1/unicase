package org.unicase.uiModeling.diagram;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecp.common.util.ModelElementOpener;
import org.unicase.ui.unicasecommon.common.diagram.DiagramOpener;
import org.unicase.uiModeling.Panel;
import org.unicase.uiModeling.diagram.part.UiModelingDiagramEditor;

/**
 * Implementation of {@link ModelElementOpener} that will open UI Modeling diagrams when opening the corresponding
 * {@link Panel} element.
 * 
 * @author mharut
 */
public class UiModelingOpener extends DiagramOpener implements ModelElementOpener {

	public int canOpen(EObject modelElement) {
		if (modelElement instanceof Panel) {
			return 1;
		}
		return DONOTOPEN;
	}

	public void openModelElement(EObject modelElement) {
		if (modelElement instanceof Panel) {
			super.openDiagram((Panel) modelElement, UiModelingDiagramEditor.ID);
		}
	}

}
