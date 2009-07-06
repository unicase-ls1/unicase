package org.unicase.ui.tom.commands;

import org.eclipse.gef.Request;
import org.eclipse.gef.requests.SelectionRequest;
import org.eclipse.gmf.runtime.diagram.ui.editparts.DiagramEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart;

public class SelectCommand extends AbstractCommand {

	private final GraphicalEditPart targetEditPart;

	SelectCommand(DiagramEditPart diagramEditPart, GraphicalEditPart targetEditPart) {
		super(diagramEditPart);
		this.targetEditPart = targetEditPart;
	}

	public void execute() {
		getTargetEditPart().showTargetFeedback(getRequest());	
	}

	public Request createRequest() {
		SelectionRequest selectionRequest = new SelectionRequest();
		selectionRequest.setType(org.eclipse.gef.RequestConstants.REQ_SELECTION);
		
		return selectionRequest;
	}

	public GraphicalEditPart getTargetEditPart() {
		return targetEditPart;
	}
}
