package org.unicase.ui.tom.commands;

import org.eclipse.draw2d.geometry.Point;
import org.eclipse.gef.Request;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ConnectionEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.DiagramEditPart;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.widgets.Display;

public class MoveConnectionBendpointCommand extends MoveCommand implements
		Command {
	
	public MoveConnectionBendpointCommand(DiagramEditPart diagramEditPart) {
		super(diagramEditPart);
	}

	public void execute() {
		final MouseEvent mouseEvent = createMouseEventAtPosition(getPosition());
		
		Runnable runnable = new Runnable(){
			public void run(){
				getDragTracker().mouseUp(mouseEvent, getDiagramEditPart().getViewer());
			}
		};
		Display.getDefault().syncExec(runnable);

	}

	public void prepareMove(Point position, ConnectionEditPart targetEditPart) {
		setPosition(position);
		setTargetEditPart(targetEditPart);		

		final MouseEvent mouseEvent = createMouseEventAtPosition(position);

		//ConnectionBendpointTracker 
		Runnable runnable = new Runnable(){
			public void run(){
				setDragTracker(getTargetEditPart().getDragTracker(null));
				getDragTracker().mouseDown(mouseEvent, 
						getTargetEditPart().getViewer());
			}
		};
		
		Display.getDefault().syncExec(runnable);
	}
	
	public void updateMove(Point point) {
		setPosition(point);
		
		final MouseEvent mouseEvent = createMouseEventAtPosition(point);
		
		Runnable runnable = new Runnable(){
			public void run(){
				getDragTracker().mouseDrag(
						mouseEvent,
						getTargetEditPart().getViewer());
			}
		};
		Display.getDefault().syncExec(runnable);
	}
	
	public Request createRequest() {
		// TODO Auto-generated method stub
		return null;
	}
}
