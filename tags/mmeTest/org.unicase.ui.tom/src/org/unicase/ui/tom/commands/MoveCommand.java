package org.unicase.ui.tom.commands;

import org.eclipse.draw2d.geometry.Point;
import org.eclipse.gef.DragTracker;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.diagram.ui.editparts.DiagramEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart;

public class MoveCommand extends AbstractCommand{

	private DragTracker dragTracker;
	private GraphicalEditPart targetEditPart;

	MoveCommand(DiagramEditPart diagramEditPart) {
		super(diagramEditPart);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void execute() {	
		
	}

	public void prepareMove(Point position, GraphicalEditPart moveableEditPart){
		setTargetEditPart(moveableEditPart);
		setDragTracker(moveableEditPart.getDragTracker(null));
		
//		newDragTracker.setEditDomain(getDomain());
//		newDragTracker.activate();
//		newDragTracker.setViewer(getCurrentViewer());
		
		
	}
	
	public void updateMove(Point position) {
		
	}
	
	public Request createRequest() {
		// TODO Auto-generated method stub
		return null;
	}

	public Command getCommand() {
		// TODO Auto-generated method stub
		return null;
	}

	public void setDragTracker(DragTracker dragTracker) {
		this.dragTracker = dragTracker;
	}

	public DragTracker getDragTracker() {
		return dragTracker;
	}

	public void setTargetEditPart(GraphicalEditPart targetEditPart) {
		this.targetEditPart = targetEditPart;
	}

	public GraphicalEditPart getTargetEditPart() {
		return targetEditPart;
	}
	
}
