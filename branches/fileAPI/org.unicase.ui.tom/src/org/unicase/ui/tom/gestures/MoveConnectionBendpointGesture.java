/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.tom.gestures;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.eclipse.draw2d.PolylineConnection;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.PointList;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gef.EditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ConnectionEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.DiagramEditPart;
import org.unicase.ui.tom.TouchDispatch;
import org.unicase.ui.tom.operations.MoveConnectionBendpointOperation;
import org.unicase.ui.tom.tools.TouchConstants;
import org.unicase.ui.tom.touches.MultiTouch;
import org.unicase.ui.tom.touches.SingleTouch;
import org.unicase.ui.tom.touches.Touch;

/**
 * @author schroech
 *
 */
/**
 * @author schroech
 *
 */
public class MoveConnectionBendpointGesture extends AbstractMoveGesture implements
Gesture {

	private MoveConnectionBendpointOperation moveConnectionBendpointCommand;

	/**
	 * Default constructor.
	 * 
	 * @param dispatch The {@link TouchDispatch} at which the gesture will register for touch events
	 * @param diagramEditPart The {@link DiagramEditPart}
	 */
	public MoveConnectionBendpointGesture(TouchDispatch dispatch,
			DiagramEditPart diagramEditPart) {
		super(dispatch, diagramEditPart);
	}


	/** 
	 * {@inheritDoc}
	 * @see org.unicase.ui.tom.gestures.AbstractGesture#findTouchedEditPartExcluding(org.unicase.ui.tom.touches.Touch, java.util.Collection)
	 */
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

				boolean connectionContainsPoint = connectionContainsPoint(
						(PolylineConnection) connection,
						touch.getPosition(),
						TouchConstants.POLYLINE_TOLERANCE);

				if (connectionContainsPoint) {
					EditPart editPart = findFigureEditPart((PolylineConnection) connection);
					return editPart;
				}
			}
		}

		return null;
	}

	/**
	 * Determines if a polyline with a boundary box of width tolerance contains a point. 
	 * 
	 * @param connection The {@link PolylineConnection} being examined
	 * @param point The {@link Point} of interest
	 * @param tolerance The tolerance added to the line
	 * 
	 * @return true if the point is contained, false otherwise
	 */
	public boolean connectionContainsPoint(PolylineConnection connection, Point point, int tolerance) {

		Rectangle bounds = connection.getBounds();
		bounds.expand(tolerance, tolerance);

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

	/**
	 * @param lineStartPoint The starting point of the line
	 * @param lineEndPoint The end point of the line
	 * @param point The point of interest
	 * @return true if the point is contained, false otherwise
	 */
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

		if (!lineRect.contains(point)) {
			return false;
		}

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


	/** 
	 * {@inheritDoc}
	 * @see org.unicase.ui.tom.gestures.AbstractGesture#handleSingleTouchAdded(org.unicase.ui.tom.touches.SingleTouch)
	 */
	@Override
	public void handleSingleTouchAdded(SingleTouch touch) {
		if (!(acceptsAdditionalTouches())) {
			return;
		}

		EditPart editPart = findTouchedEditPartExcludingDiagram(touch);

		if (editPart != null && editPart instanceof ConnectionEditPart) {
			getCandidateTouches().add(touch);
		}
	}

	/** 
	 * {@inheritDoc}
	 * @see org.unicase.ui.tom.gestures.AbstractGesture#handleSingleTouchChanged(org.unicase.ui.tom.touches.SingleTouch)
	 */
	@Override
	public void handleSingleTouchChanged(SingleTouch touch) {
		if (!acceptsAdditionalTouches()) {
			return;
		}

		if (isExecuting()) {
			if (touch == getMoveTouch()) {		
				getMoveConnectionBendpointCommand().update(
						getMoveTouch().getPosition());
			}
			return;
		}

		if (getCandidateTouches().contains(touch)) {
			if (touchMoved(touch, TouchConstants.TOUCH_MOVEMENT_THRESHOLD)) {
				setMoveTouch(touch);
				setCanExecute(true);
				return;
			}
		}
	}

	/** 
	 * {@inheritDoc}
	 * @see org.unicase.ui.tom.gestures.AbstractGesture#handleSingleTouchRemoved(org.unicase.ui.tom.touches.SingleTouch)
	 */
	@Override
	public void handleSingleTouchRemoved(SingleTouch touch) {
		if (touch == getMoveTouch()) {
			getMoveConnectionBendpointCommand().finish();

			setExecuting(false);
			setMoveTouch(null);
			setCanExecute(false);
		}
	}

	/**
	 * @param moveConnectionBendpointCommand The {@link MoveConnectionBendpointOperation} used by this gesture
	 */
	public void setMoveConnectionBendpointCommand(
			MoveConnectionBendpointOperation moveConnectionBendpointCommand) {
		this.moveConnectionBendpointCommand = moveConnectionBendpointCommand;
	}

	/**
	 * @return The {@link MoveConnectionBendpointOperation} used by this gesture
	 */
	public MoveConnectionBendpointOperation getMoveConnectionBendpointCommand() {
		return moveConnectionBendpointCommand;
	}


	/** 
	 * {@inheritDoc}
	 * @see org.unicase.ui.tom.gestures.MomentaryGesture#finish()
	 */
	public void execute() {
		setExecuting(true);

		Point firstPoint = getMoveTouch().getPath().getFirstPoint();

		EditPart editPart = findTouchedEditPartExcluding(Collections.EMPTY_LIST, firstPoint);

		if (editPart != null && editPart instanceof ConnectionEditPart) {

			setMoveConnectionBendpointCommand(new MoveConnectionBendpointOperation(getDiagramEditPart(), (ConnectionEditPart) editPart));			
			getMoveConnectionBendpointCommand().prepare(firstPoint);			
		}
	}


	/** 
	* {@inheritDoc}
	* @see org.unicase.ui.tom.gestures.Gesture#getMandatoryTouches()
	*/
	public List<MultiTouch> getMandatoryTouches() {
		List<MultiTouch> mandatoryTouches = new ArrayList<MultiTouch>();

		if (getMoveTouch() != null) {
			mandatoryTouches.add(getMoveTouch().getMultiTouch());
		}
		
		return mandatoryTouches;
	}

}
