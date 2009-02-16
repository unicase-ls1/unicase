package org.unicase.ui.tom.commands;

import org.eclipse.gef.Request;
import org.eclipse.gmf.runtime.diagram.ui.editparts.DiagramEditPart;
import org.unicase.ui.tom.operations.AbstractOperation;

/**
 * @author schroech
 *
 */
public abstract class AbstractCommand extends AbstractOperation implements Command{

	private Request request;

	/**
	 * Default constructor.
	 * @param diagramEditPart 
	 * The model diagram edit part, usually the child of the RenderedRootDiagramEditPart  
	 */
	AbstractCommand(DiagramEditPart diagramEditPart){
		super(diagramEditPart);
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
	

	public abstract Request createRequest();
}
