package org.unicase.ui.tom.commands;

import org.eclipse.gef.Request;
import org.eclipse.gmf.runtime.diagram.ui.editparts.DiagramEditPart;

/**
 * @author schroech
 *
 */
public abstract class AbstractCommand implements Command{

	private DiagramEditPart diagramEditPart;
	private Request request;

	/**
	 * Default constructor.
	 * @param diagramEditPart 
	 * The model diagram edit part, usually the child of the RenderedRootDiagramEditPart  
	 */
	AbstractCommand(DiagramEditPart diagramEditPart){
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
