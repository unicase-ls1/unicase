package org.unicase.ui.tom.operations;

import org.eclipse.gmf.runtime.diagram.ui.editparts.DiagramEditPart;

public abstract class AbstractOperation implements Operation {

	protected DiagramEditPart diagramEditPart;

	public AbstractOperation(DiagramEditPart diagramEditPart) {
		this.diagramEditPart = diagramEditPart;
	}
	/**
	 * @param diagramEditPart
	 * The model diagram edit part
	 */
	public void setDiagramEditPart(DiagramEditPart diagramEditPart) {
		this.diagramEditPart = diagramEditPart;
	}

	/**
	 * @return The model diagram edit part
	 */
	public DiagramEditPart getDiagramEditPart() {
		return diagramEditPart;
	}

}
