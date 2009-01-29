package org.unicase.ui.tom.actions;

import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.RangeModel;
import org.eclipse.draw2d.Viewport;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.Request;
import org.eclipse.gef.editparts.AbstractGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.DiagramEditPart;
import org.eclipse.swt.widgets.Display;

public class MoveCanvasAction extends AbstractAction {

	private Viewport scrollableViewport;
	private Point lastPosition;

	public MoveCanvasAction(DiagramEditPart diagramEditPart) {
		super(diagramEditPart);

		EditPart parent = diagramEditPart.getParent();
		IFigure figure = ((AbstractGraphicalEditPart) parent).getFigure();

		if (figure instanceof  Viewport) {
			scrollableViewport = (Viewport) figure;	
		}
	}


	public void prepareMove(Point point){
		lastPosition = point;
	}

	public void execute() {
		// TODO Auto-generated method stub

	}

	public Request createRequest() {
		// TODO Auto-generated method stub
		return null;
	}

	public void updateMove(final Point position) {

		Runnable runnable = new Runnable(){
			public void run(){
				RangeModel horizontalRangeModel = scrollableViewport.getHorizontalRangeModel();
				if (horizontalRangeModel.getExtent() < (horizontalRangeModel.getMaximum() - horizontalRangeModel.getMinimum())) {

					int currentPos = horizontalRangeModel.getValue();
					int offset = position.x - lastPosition.x; 
					scrollableViewport.setHorizontalLocation(currentPos - offset);
				}


				RangeModel verticalRangeModel = scrollableViewport.getVerticalRangeModel();
				if (verticalRangeModel.getExtent() < (verticalRangeModel.getMaximum() - verticalRangeModel.getMinimum())) {

					int currentPos = verticalRangeModel.getValue();
					int offset = position.y - lastPosition.y; 
					scrollableViewport.setVerticalLocation(currentPos - offset);
				}
			}
		};
		
		Display.getDefault().syncExec(runnable);

		lastPosition = position;	
	}

}
