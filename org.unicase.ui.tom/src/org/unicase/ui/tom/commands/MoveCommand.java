package org.unicase.ui.tom.commands;

import org.eclipse.draw2d.geometry.Point;
import org.eclipse.gef.DragTracker;
import org.eclipse.gmf.runtime.diagram.ui.editparts.DiagramEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.swt.events.MouseEvent;

public abstract class MoveCommand extends AbstractCommand {

	private DragTracker dragTracker;
	private IGraphicalEditPart targetEditPart;
	private Point position;
	
	public MoveCommand(DiagramEditPart diagramEditPart) {
		super(diagramEditPart);
	}

	public void setTargetEditPart(IGraphicalEditPart targetEditPart) {
		this.targetEditPart = targetEditPart;
	}

	public IGraphicalEditPart getTargetEditPart() {
		return targetEditPart;
	}

	protected MouseEvent createMouseEventAtPosition(Point position) {
		org.eclipse.swt.widgets.Event event = new org.eclipse.swt.widgets.Event();
		event.x = position.x;
		event.y = position.y;
		event.button = 1;
		event.count = 1;
		event.widget = getDiagramEditPart().getViewer().getControl();
	
		MouseEvent mouseEvent = new MouseEvent(event);
		
		return mouseEvent;
	}

	public void setPosition(Point position) {
		this.position = position;
	}

	public Point getPosition() {
		return position;
	}
	
	public void setDragTracker(DragTracker newDragTracker) {
		if (newDragTracker != dragTracker) {
			if (dragTracker != null)
				dragTracker.deactivate();

			dragTracker = newDragTracker;

			if (newDragTracker != null) {
				newDragTracker.setEditDomain(getDiagramEditPart().getViewer().getEditDomain());
				newDragTracker.activate();
				newDragTracker.setViewer(getDiagramEditPart().getViewer());
			}
		}
	}

	public DragTracker getDragTracker() {
		return dragTracker;
	}

}