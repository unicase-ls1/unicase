package org.unicase.ui.tom.commands;

import org.eclipse.draw2d.geometry.Point;
import org.eclipse.gef.DragTracker;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.diagram.ui.editparts.DiagramEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.widgets.Display;

public class MoveNodeCommand extends MoveCommand{

	public MoveNodeCommand(DiagramEditPart diagramEditPart) {
		super(diagramEditPart);
	}

	@Override
	public void execute() {
		final MouseEvent mouseEvent = createMouseEventAtPosition(getPosition());
		
		Runnable runnable = new Runnable(){
			public void run(){
				getDragTracker().mouseUp(mouseEvent, getDiagramEditPart().getViewer());
			}
		};
		Display.getDefault().syncExec(runnable);
	}

	public void prepareMove(Point position, GraphicalEditPart moveableEditPart){
		setPosition(position);
		setTargetEditPart(moveableEditPart);

		final MouseEvent mouseEvent = createMouseEventAtPosition(position);
		
		Runnable runnable = new Runnable(){
			public void run(){
				setDragTracker(getTargetEditPart().getDragTracker(null));
				getDragTracker().mouseDown(mouseEvent, 
						getTargetEditPart().getViewer());
			}
		};
		Display.getDefault().syncExec(runnable);
	}

	public void updateMove(Point position) {
		setPosition(position);
		final MouseEvent mouseEvent = createMouseEventAtPosition(position);
		
		Runnable runnable = new Runnable(){
			public void run(){
				getDragTracker().mouseDrag(mouseEvent, getTargetEditPart().getViewer());
			}
		};
		Display.getDefault().syncExec(runnable);
	}
	
	public Request createRequest() {
		// TODO Auto-generated method stub
		return null;
	}

	public Command getCommand() {
		// TODO Auto-generated method stub
		return null;
	}
}
