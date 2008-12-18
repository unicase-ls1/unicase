package org.unicase.ui.tom.commands;

import org.eclipse.gef.Request;
import org.eclipse.gmf.runtime.diagram.ui.editparts.DiagramEditPart;

public abstract class AbstractCommand implements Command{

	private DiagramEditPart diagramEditPart;
	private Request request;

	AbstractCommand(DiagramEditPart diagramEditPart){
		this.diagramEditPart = diagramEditPart;	
	}
	
	public abstract void execute();

	public void setDiagramEditPart(DiagramEditPart diagramEditPart) {
		this.diagramEditPart = diagramEditPart;
	}

	public DiagramEditPart getDiagramEditPart() {
		return diagramEditPart;
	}

	public void setRequest(Request request) {
		this.request = request;
	}

	public Request getRequest() {
		if (request == null) {
			request = createRequest();
		}
		return request;
	}
}
