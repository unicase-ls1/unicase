package org.unicase.ui.tom.gestures;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.eclipse.draw2d.PolylineConnection;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.PointList;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gef.EditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ConnectionEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.DiagramEditPart;
import org.unicase.ui.tom.TouchDispatch;
import org.unicase.ui.tom.commands.MoveConnectionBendpointCommand;
import org.unicase.ui.tom.touches.Touch;

public class MoveConnectionBendpointGesture extends AbstractGesture implements
Gesture {

	private ConnectionEditPart initialEditPart;
	private Touch moveTouch;
	private MoveConnectionBendpointCommand moveConnectionBendpointCommand;

	public MoveConnectionBendpointGesture(TouchDispatch dispatch,
			DiagramEditPart diagramEditPart) {
		super(dispatch, diagramEditPart);
		
		setMoveConnectionBendpointCommand(new MoveConnectionBendpointCommand(diagramEditPart));
	}


	@SuppressWarnings("unchecked")
	@Override
	public EditPart findTouchedEditPartExcluding(Touch touch, Collection exclusions) {
		EditPart touchedEditPart = super.findTouchedEditPartExcluding(
				touch, 
				exclusions);

		if (touchedEditPart != null) {
			return touchedEditPart;
		}

		List connections = getConnectionLayer().getChildren();
		for (Object connection : connections) {
			if (connection instanceof PolylineConnection) {
				if (connectionContainsPoint(
						(PolylineConnection) connection,
						touch.getPosition())) {
					EditPart editPart = findFigureEditPart((PolylineConnection) connection);
					return editPart;
				}
			}
		}

		return null;
	}

	public boolean connectionContainsPoint(PolylineConnection connection, Point point) {

		int calculatedTolerance = 30;

		Rectangle bounds = connection.getBounds();
		bounds.expand(calculatedTolerance, calculatedTolerance);

		if (!bounds.contains(point)) {
			return false;
		}

		PointList points = connection.getPoints();
		for (int i = 0; i < points.size() - 1; i++) {
			if (lineContainsPoint(
					points.getPoint(i),
					points.getPoint(i+1),
					point)){
				return true;
			}
		}

		return false;
	}

	public boolean lineContainsPoint(
			Point lineStartPoint,
			Point lineEndPoint,
			Point point) {

		//Subsidized from Polyline 

		Rectangle lineRect = new Rectangle();
		lineRect.setSize(0,0);
		lineRect.setLocation(lineStartPoint);
		lineRect.union(lineEndPoint);
		lineRect.expand(30,30);

		if (!lineRect.contains(point))
			return false;

		double v1x, v1y, v2x, v2y;
		double numerator, denominator;
		double result = 0;
		int x1, x2, y1, y2, px, py;

		x1 = lineStartPoint.x;
		y1 = lineStartPoint.y;

		x2 = lineEndPoint.x;
		y2 = lineEndPoint.y;

		px = point.x;
		py = point.y;

		if( x1 != x2 && y1 != y2 ) {
			v1x = (double)x2 - x1;
			v1y = (double)y2 - y1;
			v2x = (double)px - x1;
			v2y = (double)py - y1;

			numerator = v2x * v1y - v1x * v2y;

			denominator = v1x * v1x + v1y * v1y;

			result = numerator * numerator / denominator;
		}

		// if it is the same point, and it passes the bounding box test,
		// the result is always true.
		return result <= 30 * 30;
	}


	@SuppressWarnings("unchecked")
	@Override
	public void handleTouchAdded(Touch touch) {
		if (getAcceptsTouches()) {
			if (TouchDispatch.getInstance().getActiveTouches().size() > 1) {
				setAcceptsTouches(false);
				return;
			}
			
			List exclusions = new ArrayList();
			exclusions.add(getDiagramEditPart());
			exclusions.add(getDiagramEditPart().getParent());

			EditPart editPart = findTouchedEditPartExcluding(touch,
					exclusions);
			if (editPart == null
					|| !(editPart instanceof ConnectionEditPart)) {
				setAcceptsTouches(false);
			}else{
				setInitialEditPart((ConnectionEditPart)editPart);
			}
		}
	}

	@Override
	public void handleTouchChanged(Touch touch) {
		if (getAcceptsTouches()) {
			if (touch == getMoveTouch()) {
				getMoveConnectionBendpointCommand().updateMove(
						getMoveTouch().getPosition());
			}else if (touch.getPath().getMidpoint()
					.getDistance(touch.getPosition()) 
					> TOUCH_MOVEMENT_THRESHOLD) {
				
				setMoveTouch(touch);
				
				Point firstPoint = getMoveTouch().getPath().getFirstPoint();
				
				getMoveConnectionBendpointCommand().prepareMove(
						firstPoint,
						getInitialEditPart());
			}
		}
	}

	@Override
	public void handleTouchRemoved(Touch touch) {
		if (touch == getMoveTouch()) {
			getMoveConnectionBendpointCommand().execute();
			setCanExecute(false);
		}
	}

	public void setInitialEditPart(ConnectionEditPart initialEditPart) {
		this.initialEditPart = initialEditPart;
	}

	public ConnectionEditPart getInitialEditPart() {
		return initialEditPart;
	}

	public void setMoveTouch(Touch moveTouch) {
		this.moveTouch = moveTouch;
	}

	public Touch getMoveTouch() {
		return moveTouch;
	}

	public void setMoveConnectionBendpointCommand(
			MoveConnectionBendpointCommand moveConnectionBendpointCommand) {
		this.moveConnectionBendpointCommand = moveConnectionBendpointCommand;
	}

	public MoveConnectionBendpointCommand getMoveConnectionBendpointCommand() {
		return moveConnectionBendpointCommand;
	}

}
