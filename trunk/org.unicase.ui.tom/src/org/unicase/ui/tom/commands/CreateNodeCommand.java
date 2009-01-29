package org.unicase.ui.tom.commands;

import org.eclipse.draw2d.geometry.Point;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.diagram.core.edithelpers.CreateElementRequestAdapter;
import org.eclipse.gmf.runtime.diagram.ui.editparts.DiagramEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewAndElementRequest;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewAndElementRequest.ViewAndElementDescriptor;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.emf.type.core.IHintedType;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;

public class CreateNodeCommand extends AbstractCommand{
	
	private IElementType elementType;
	private Point point;
	
	public CreateNodeCommand(DiagramEditPart diagramEditPart, Point point) {
		this(diagramEditPart, point, null);
	}
	
	public CreateNodeCommand(DiagramEditPart diagramEditPart, Point point, IElementType elementType) {
		super(diagramEditPart);
		
		this.elementType = elementType;
		setPoint(point);
	}
	
	public Request createRequest() {
		
		CreateElementRequest createElementRequest = new CreateElementRequest(getElementType());
		CreateElementRequestAdapter createElementRequestAdapter = new CreateElementRequestAdapter(createElementRequest);

		ViewAndElementDescriptor descriptor = new ViewAndElementDescriptor(createElementRequestAdapter,
				org.eclipse.gmf.runtime.notation.Node.class, 
				((IHintedType)getElementType()).getSemanticHint(), 
				((IGraphicalEditPart)getDiagramEditPart()).getDiagramPreferencesHint());
		
		CreateViewAndElementRequest request = new CreateViewAndElementRequest(descriptor);

		request.setSize(null);
		request.setLocation(getPoint());
		
		return request;
	}
	
	public Command getCommand() {		
		Command command = getDiagramEditPart().getCommand(getRequest());
		return command;
	}
	
	public void execute() {
		Command command = getCommand();
		getDiagramEditPart().getDiagramEditDomain().getDiagramCommandStack().execute(command);
	}


	public void setElementType(IElementType elementType) {
		this.elementType = elementType;
	}


	public IElementType getElementType() {
		return elementType;
	}

	public Point getPoint() {
		return point;
	}

	public void setPoint(Point point) {
		this.point = point;
	}

}
