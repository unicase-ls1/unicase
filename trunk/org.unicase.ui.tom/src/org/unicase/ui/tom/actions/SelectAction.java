package org.unicase.ui.tom.actions;

import org.eclipse.gef.Request;
import org.eclipse.gef.requests.SelectionRequest;
import org.eclipse.gmf.runtime.diagram.ui.editparts.DiagramEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart;

public class SelectAction extends AbstractAction{

	private GraphicalEditPart targetEditPart;

	SelectAction(DiagramEditPart diagramEditPart, GraphicalEditPart targetEditPart) {
		super(diagramEditPart);
		this.setTargetEditPart(targetEditPart);
	}

	public void execute() {
		getTargetEditPart().showTargetFeedback(createRequest());	
	}

	public Request createRequest() {
		SelectionRequest selectionRequest = new SelectionRequest();
		selectionRequest.setType(org.eclipse.gef.RequestConstants.REQ_SELECTION);
		
		return selectionRequest;
	}

	public GraphicalEditPart getTargetEditPart() {
		return targetEditPart;
	}

	public void setTargetEditPart(GraphicalEditPart targetEditPart) {
		this.targetEditPart = targetEditPart;
	}
}
