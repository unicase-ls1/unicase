/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.tom.gestures;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.draw2d.Connection;
import org.eclipse.draw2d.ConnectionLayer;
import org.eclipse.draw2d.FreeformLayer;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.Label;
import org.eclipse.draw2d.PolylineConnection;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.PointList;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.GraphicalEditPart;
import org.eclipse.gef.LayerConstants;
import org.eclipse.gef.NodeEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.CompartmentEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ConnectionEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.DiagramEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.INodeEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.LabelEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ListCompartmentEditPart;
import org.eclipse.gmf.runtime.draw2d.ui.figures.WrappingLabel;
import org.unicase.ui.tom.TouchDispatch;
import org.unicase.ui.tom.notifications.GestureNotification;
import org.unicase.ui.tom.notifications.GestureNotificationImpl;
import org.unicase.ui.tom.notifications.GestureNotifierImpl;
import org.unicase.ui.tom.notifications.SingleTouchNotification;
import org.unicase.ui.tom.notifications.TouchAdapter;
import org.unicase.ui.tom.tools.TouchConstants;
import org.unicase.ui.tom.touches.MultiTouch;
import org.unicase.ui.tom.touches.SingleTouch;
import org.unicase.ui.tom.touches.Touch;
import org.unicase.ui.unicasecommon.diagram.util.EditPartUtility;

/**
 * @author schroech
 * 
 */
public abstract class AbstractGesture extends GestureNotifierImpl implements
		TouchAdapter, Gesture {

	private List<MultiTouch> optionalTouches;
	private List<Gesture> restrictingGestures;
	private int priority;
	private TouchDispatch dispatch;
	private boolean acceptsTouches;
	private DiagramEditPart diagramEditPart;

	private boolean canExecute;

	/**
	 * @param canExecute
	 *            Specifies wether the gesture can execute
	 */
	public void setCanExecute(boolean canExecute) {
		if (canExecute != this.canExecute) {
			this.canExecute = canExecute;
			notifyAdapters(new GestureNotificationImpl(this,
					GestureNotification.gestureExecutionChange));
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.unicase.ui.tom.gestures.Gesture#canExecute()
	 */
	public boolean canExecute() {
		return canExecute;
	}

	/**
	 * Default constructor.
	 * 
	 * @param dispatch
	 *            The {@link TouchDispatch} at which the gesture will register
	 *            for touch events
	 * @param diagramEditPart
	 *            The {@link DiagramEditPart}
	 */
	public AbstractGesture(TouchDispatch dispatch) {
		setDispatch(dispatch);
		setRestrictingGestures(new ArrayList<Gesture>());
		setOptionalTouches(Collections.EMPTY_LIST);

		canExecute = false;
		acceptsTouches = true;
	}

	/**
	 * Finds the {@link EditPart} at a given position. If multiple
	 * {@link EditPart}s exist at the same position, they are traversed in the
	 * following order: 
	 * 1. {@link CompartmentEditPart} 
	 * 2. {@link NodeEditPart}
	 * 3. {@link LabelEditPart} 
	 * 4. {@link ConnectionEditPart} 
	 * 5. {@link DiagramEditPart}
	 * 
	 * This method will call the respective findTouchedXXXEditPart() methods, 
	 * and will therefore follow their matching criteria.
	 * 
	 * @param position The {@link Point} where to search for the {@link EditPart}
	 * @return The found {@link EditPart} 
	 */
	public GraphicalEditPart findTouchedEditPart(Point position) {
		GraphicalEditPart editPart;

		editPart = findTouchedLabelEditPart(position);
		if (editPart != null) {
			return editPart;
		}
		
		editPart = findTouchedConnectionEditPart(position);
		if (editPart != null) {
			return editPart;
		}
		
		editPart = findTouchedCompartmentEditPart(position);
		if (editPart != null) {
			return editPart;
		}

		editPart = findTouchedNodeEditPart(position);
		if (editPart != null) {
			return editPart;
		}

		editPart = getDiagramEditPart();
		return editPart;
	}

	
	@SuppressWarnings("unchecked")
	public LabelEditPart findTouchedLabelEditPart(Point position) {
		List connectionLayerChildren = getConnectionLayer().getChildren();
		for (Object connectionLayerChild : connectionLayerChildren) {
			if (connectionLayerChild instanceof Connection) {
				List connectionChildren = ((Connection) connectionLayerChild)
						.getChildren();
				for (Object connectionChild : connectionChildren) {

					if (connectionChild instanceof WrappingLabel
							|| connectionChild instanceof Label) {

						boolean labelContainsPoint = labelContainsPoint(
								(IFigure) connectionChild, position,
								TouchConstants.POLYLINE_TOLERANCE);

						if (labelContainsPoint) {
							EditPart editPart = getEditPartForFigure((IFigure) connectionChild);
							if (editPart instanceof LabelEditPart) {
								return (LabelEditPart) editPart;
							}
						}
					}

				}
			}
		}

		return null;
	}

	/** 
	 */
	@SuppressWarnings("unchecked")
	public ConnectionEditPart findTouchedConnectionEditPart(Point position) {

		List connections = getConnectionLayer().getChildren();
		for (Object connection : connections) {
			if (connection instanceof PolylineConnection) {

				boolean connectionContainsPoint = connectionContainsPoint(
						(PolylineConnection) connection, position,
						TouchConstants.POLYLINE_TOLERANCE);

				if (connectionContainsPoint) {
					EditPart editPart = getEditPartForFigure((PolylineConnection) connection);
					if (editPart instanceof ConnectionEditPart) {
						return (ConnectionEditPart) editPart;
					}
				}
			}
		}

		return null;
	}

	public INodeEditPart findTouchedNodeEditPart(Point point) {
		EditPart foundEditPart;
		foundEditPart = findTouchedEditPartAtAbsoluteCoordinates(point);
		if (foundEditPart != null) {
			foundEditPart = EditPartUtility
					.traverseToNodeEditPart(foundEditPart);
		}
		return (INodeEditPart) foundEditPart;
	}

	public CompartmentEditPart findTouchedCompartmentEditPart(final Point point) {
		EditPart foundEditPart;
		foundEditPart = findTouchedEditPartAtAbsoluteCoordinates(point);
		while (foundEditPart != null) {
			if (foundEditPart instanceof CompartmentEditPart
					&& !(foundEditPart instanceof ListCompartmentEditPart)
					&& foundEditPart.getParent() instanceof ListCompartmentEditPart) {
				break;
			}
			foundEditPart = foundEditPart.getParent();
		}
		return (CompartmentEditPart) foundEditPart;
	}

	/**
	 * @return
	 */
	public EditPart findTouchedEditPartAtAbsoluteCoordinates(Point point) {

		Point relativePoint = new Point(point);
		return findTouchedEditPartAtRelativeCoordinatesExcluding(Collections.emptyList(),
				relativePoint);
	}

	/**
	 * @param exclusions
	 * @param position
	 * @return
	 */
	public EditPart findTouchedEditPartAtRelativeCoordinatesExcluding(
			Collection exclusions, Point position) {
		IFigure figure = getDiagramEditPart().getFigure()
				.findFigureAt(position);

		EditPart part = null;
		while (part == null && figure != null) {
			part = getEditPartForFigure(figure);
			if (exclusions.contains(part)) {
				part = null;
			}
			figure = figure.getParent();
		}

		return part;
	}

	public INodeEditPart findCardinalTouchedNodeEditPart(PointList points) {
		List<INodeEditPart> touchedEditParts = new ArrayList<INodeEditPart>();
		for (int i = 0; i < points.size(); i++) {
 			Point point = points.getPoint(i);
			INodeEditPart nodeEditPart = findTouchedNodeEditPart(point);
			if (nodeEditPart != null) {
				touchedEditParts.add(nodeEditPart);
			}
		}
		
		if (touchedEditParts.size() == 0) {
			return null;
		}else if (touchedEditParts.size() == 1) {
			return touchedEditParts.get(0);
		}else{
			Point center = points.getBounds().getCenter();
			INodeEditPart centerNodeEditPart = findTouchedNodeEditPart(center);
			if (touchedEditParts.contains(centerNodeEditPart)) {
				return centerNodeEditPart;
			}
			return touchedEditParts.get(0);
		} 
	}
	
	public EditPart findCardinalTouchedEditPart(Collection<SingleTouch> touches) {
		return findCardinalTouchedEditPartExcluding(touches,
				Collections.EMPTY_LIST);
	}

	/**
	 * @param touch
	 * @param exclusions
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public EditPart findCardinalTouchedEditPartExcluding(
			Collection<? extends Touch> touches, Collection exclusions) {

		Set<EditPart> directlyTouchedEditParts = findTouchedEditPartsExcluding(
				touches, exclusions);
		EditPart editPart = findEditPartAtCenterExcluding(touches, exclusions);

		if (directlyTouchedEditParts.contains(editPart)) {
			return editPart;
		}

		List<Touch> chronologicallySortedTouches = new ArrayList<Touch>();
		chronologicallySortedTouches.addAll(touches);
		Comparator<Touch> comp = new Comparator<Touch>() {

			public int compare(Touch o1, Touch o2) {
				if (o1.getLifeSpan() < o2.getLifeSpan()) {
					return -1;
				} else if (o1.getLifeSpan() == o2.getLifeSpan()) {
					return 0;
				} else {
					return 1;
				}
			}

		};

		for (Touch touch : chronologicallySortedTouches) {
			Point position = touch.getPosition();
			editPart = findTouchedEditPartAtRelativeCoordinatesExcluding(
					exclusions, position);

			if (!(exclusions.contains(editPart))) {
				return editPart;
			}
		}

		return null;
	}

	@SuppressWarnings("unchecked")
	public EditPart findCardinalTouchedEditPartExcludingDiagram(
			Collection<Touch> touches) {
		List exclusions = new ArrayList();
		exclusions.add(getDiagramEditPart());
		exclusions.add(getDiagramEditPart().getParent());
	
		return findCardinalTouchedEditPartExcluding(touches, exclusions);
	}

	public Set<EditPart> findTouchedEditPartsExcluding(
			Collection<? extends Touch> touches, Collection exclusions) {
		Set<EditPart> editParts = new HashSet<EditPart>();

		for (Touch touch : touches) {
			Point position = touch.getPosition();
			EditPart editPart = findTouchedEditPartAtRelativeCoordinatesExcluding(
					exclusions, position);

			if (!(exclusions.contains(editPart))) {
				editParts.add(editPart);
			}
		}

		return editParts;
	}

	public EditPart findEditPartAtCenterExcluding(Collection<?extends Touch> touches,
			Collection exclusions) {
		PointList points = new PointList();

		for (Touch touch : touches) {
			points.addPoint(touch.getPosition());
		}

		Point center = points.getBounds().getCenter();
		getDiagramEditPart().getFigure().translateToRelative(center);

		EditPart editPart = findTouchedEditPartAtRelativeCoordinatesExcluding(
				exclusions, center);

		if (exclusions.contains(editPart)) {
			return null;
		}

		return editPart;
	}

	public EditPart getEditPartForFigure(IFigure figure) {
		EditPart part = (EditPart) getDiagramEditPart().getViewer()
				.getVisualPartMap().get(figure);
		return part;
	}

	/**
	 * Determines if the touch moved moved more than the specified threshold.
	 * 
	 * @param touch
	 *            The touch beeing investigated
	 * @param threshold
	 *            The threshold being accepted
	 * @return true if the touch moved more than the threshold, false otherwise
	 */
	protected static boolean touchMoved(SingleTouch touch, int threshold) {
		Point firstPoint = touch.getPath().getFirstPoint();
		Point lastPoint = touch.getPosition();
	
		double distance = firstPoint.getDistance(lastPoint);
//		PointList path = touch.getPath();
//		Rectangle bounds = path.getBounds();
//		Point point = touch.getPosition();
//		double distance = point.getDistance(bounds.getCenter());

		boolean touchMoved = distance > threshold;

		return touchMoved;
	}
	
	public boolean labelContainsPoint(IFigure figure, Point position,
			int tolerance) {

		Rectangle bounds = figure.getBounds().getCopy();
		bounds.expand(tolerance, tolerance);

		if (!bounds.contains(position)) {
			return false;
		}

		return true;
	}

	/**
	 * Determines if a polyline with a boundary box of width tolerance contains
	 * a point.
	 * 
	 * @param connection
	 *            The {@link PolylineConnection} being examined
	 * @param point
	 *            The {@link Point} of interest
	 * @param tolerance
	 *            The tolerance added to the line
	 * 
	 * @return true if the point is contained, false otherwise
	 */
	public boolean connectionContainsPoint(PolylineConnection connection,
			Point point, int tolerance) {

		Rectangle bounds = connection.getBounds();
		bounds.expand(tolerance, tolerance);

		if (!bounds.contains(point)) {
			return false;
		}

		PointList points = connection.getPoints();
		for (int i = 0; i < points.size() - 1; i++) {
			if (lineContainsPoint(points.getPoint(i), points.getPoint(i + 1),
					point)) {
				return true;
			}
		}

		return false;
	}

	/**
	 * @param lineStartPoint
	 *            The starting point of the line
	 * @param lineEndPoint
	 *            The end point of the line
	 * @param point
	 *            The point of interest
	 * @return true if the point is contained, false otherwise
	 */
	public boolean lineContainsPoint(Point lineStartPoint, Point lineEndPoint,
			Point point) {

		// Subsidized from Polyline

		Rectangle lineRect = new Rectangle();
		lineRect.setSize(0, 0);
		lineRect.setLocation(lineStartPoint);
		lineRect.union(lineEndPoint);
		lineRect.expand(30, 30);

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

		if (x1 != x2 && y1 != y2) {
			v1x = (double) x2 - x1;
			v1y = (double) y2 - y1;
			v2x = (double) px - x1;
			v2y = (double) py - y1;

			numerator = v2x * v1y - v1x * v2y;

			denominator = v1x * v1x + v1y * v1y;

			result = numerator * numerator / denominator;
		}

		// if it is the same point, and it passes the bounding box test,
		// the result is always true.
		return result <= 30 * 30;
	}

	/**
	 * @return The layer of the {@link DiagramEditPart} registered under the
	 *         name PRIMARY_LAYER
	 */
	public FreeformLayer getNodeLayer() {
		IFigure layer = getDiagramEditPart().getLayer(
				LayerConstants.PRIMARY_LAYER);
		if (layer instanceof FreeformLayer) {
			return (FreeformLayer) layer;
		}

		return null;
	}

	/**
	 * @return The layer of the {@link DiagramEditPart} registered under the
	 *         name CONNECTION_LAYER
	 */
	public ConnectionLayer getConnectionLayer() {
		IFigure layer = getDiagramEditPart().getLayer(
				LayerConstants.CONNECTION_LAYER);
		if (layer instanceof ConnectionLayer) {
			return (ConnectionLayer) layer;
		}

		return null;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.unicase.ui.tom.notifications.TouchAdapter#notifyChanged(org.unicase.ui.tom.notifications.SingleTouchNotification)
	 */
	public void notifyChanged(SingleTouchNotification notification) {
		int eventType = notification.getEventType();
		Touch touch = notification.getTouch();
		if (touch instanceof SingleTouch) {
			switch (eventType) {
			case SingleTouchNotification.touchAdded:
				handleSingleTouchAdded((SingleTouch) touch);
				break;
			case SingleTouchNotification.touchRemoved:
				handleSingleTouchRemoved((SingleTouch) touch);
				break;
			case SingleTouchNotification.touchChanged:
				handleSingleTouchChanged((SingleTouch) touch);
				break;
			default:
				break;
			}
		}

	}

	/**
	 * @param touch
	 *            The touch added
	 */
	public abstract void handleSingleTouchAdded(SingleTouch touch);

	/**
	 * @param touch
	 *            The touch removed
	 */
	public abstract void handleSingleTouchRemoved(SingleTouch touch);

	/**
	 * @param touch
	 *            The touch changed
	 */
	public abstract void handleSingleTouchChanged(SingleTouch touch);

	/**
	 * @param dispatch
	 *            The {@link TouchDispatch} at which the gesture will register
	 *            for touch events
	 */
	public void setDispatch(TouchDispatch dispatch) {
		if (dispatch != this.dispatch) {
			if (this.dispatch != null) {
				this.dispatch.getSingleTouchNotifier().getAdapters().remove(this);
			}
			this.dispatch = dispatch;
			if (this.dispatch != null) {
				this.dispatch.getSingleTouchNotifier().getAdapters().add(this);
			}
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.unicase.ui.tom.gestures.Gesture#reset()
	 */
	public void reset() {
		setCanExecute(false);
		setAcceptsAdditionalTouches(true);
	}

	/**
	 * @return The {@link TouchDispatch} at which the gesture has registered for
	 *         touch events
	 */
	public TouchDispatch getDispatch() {
		return dispatch;
	}

	/**
	 * @param acceptsTouches
	 *            Specifies wether the gesture accepts any more touches
	 */
	public void setAcceptsAdditionalTouches(boolean acceptsTouches) {
		if (acceptsTouches != this.acceptsTouches) {
			this.acceptsTouches = acceptsTouches;
			notifyAdapters(new GestureNotificationImpl(this,
					GestureNotification.gestureAcceptanceChange));
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.unicase.ui.tom.gestures.Gesture#acceptsAdditionalTouches()
	 */
	public boolean acceptsAdditionalTouches() {
		return acceptsTouches;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.unicase.ui.tom.gestures.Gesture#getDiagramEditPart()
	 */
	public DiagramEditPart getDiagramEditPart() {
		return diagramEditPart;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.unicase.ui.tom.gestures.Gesture#setDiagramEditPart(org.eclipse.gmf.runtime.diagram.ui.editparts.DiagramEditPart)
	 */
	public void setDiagramEditPart(DiagramEditPart editor) {
		this.diagramEditPart = editor;
	}

	/**
	 * @param priority
	 *            The new priority
	 */
	public void setPriority(int priority) {
		this.priority = priority;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.unicase.ui.tom.gestures.Gesture#getPriority()
	 */
	public int getPriority() {
		return priority;
	}

	public void setRestrictingGestures(List<Gesture> restrictingGestures) {
		this.restrictingGestures = restrictingGestures;
	}

	public List<Gesture> getRestrictingGestures() {
		return restrictingGestures;
	}

	public void setOptionalTouches(List<MultiTouch> optionalTouches) {
		this.optionalTouches = optionalTouches;
	}

	public List<MultiTouch> getOptionalTouches() {
		return optionalTouches;
	}
}
