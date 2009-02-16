package org.unicase.ui.tom.gestures;

import java.util.Collection;
import java.util.Collections;

import org.eclipse.draw2d.ConnectionLayer;
import org.eclipse.draw2d.FreeformLayer;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.PointList;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.LayerConstants;
import org.eclipse.gmf.runtime.diagram.ui.editparts.DiagramEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ShapeNodeEditPart;
import org.eclipse.gmf.runtime.draw2d.ui.figures.IOvalAnchorableFigure;
import org.eclipse.gmf.runtime.draw2d.ui.figures.IPolygonAnchorableFigure;
import org.unicase.ui.tom.TouchDispatch;
import org.unicase.ui.tom.notifications.GestureNotification;
import org.unicase.ui.tom.notifications.GestureNotificationImpl;
import org.unicase.ui.tom.notifications.GestureNotifierImpl;
import org.unicase.ui.tom.notifications.TouchAdapter;
import org.unicase.ui.tom.notifications.TouchNotification;
import org.unicase.ui.tom.touches.Touch;

public abstract class AbstractGesture extends GestureNotifierImpl 
implements TouchAdapter, Gesture{

	protected static final int TOUCH_DIAMETER = 30;
	protected static final int TOUCH_MOVEMENT_THRESHOLD = 10;
	protected static final int TOUCH_DISTANCE_THRESHOLD = 30;
	
	private TouchDispatch dispatch;
	private boolean acceptsTouches;
	private DiagramEditPart diagramEditPart;
	private boolean canExecute;

	public AbstractGesture(TouchDispatch dispatch, DiagramEditPart diagramEditPart) {
		setDispatch(dispatch);
		setDiagramEditPart(diagramEditPart);
		acceptsTouches = true;
		canExecute = false;
	}

	public void execute(){
		//do nothing
	}

	protected static boolean touchMoved(Touch touch, int touchMovementThreshold) {
		PointList path = touch.getPath();
		Point midPoint = path.getMidpoint();
		Point point = touch.getPosition();
		double distance = point.getDistance(midPoint);
		
		boolean touchMoved = distance > TOUCH_MOVEMENT_THRESHOLD;
		
		return touchMoved;
	}
	
	protected boolean shapeContainsPoint(IFigure figure, Point position) {
		
		boolean containsPoint = false;
		
		if (figure instanceof IOvalAnchorableFigure) {
			//If the figure is an oval we assume the 
			//oval's hit testing is good enough   
			containsPoint =  figure.containsPoint(position);	
		}else if (figure instanceof IPolygonAnchorableFigure) {
			Rectangle bounds = ((IPolygonAnchorableFigure) figure).getPolygonPoints().getBounds().getCopy();
			bounds.expand(TOUCH_DIAMETER/2, TOUCH_DIAMETER/2);
			containsPoint = bounds.contains(position);
		}else{
			Rectangle bounds = figure.getBounds().getCopy();
			bounds.expand(TOUCH_DIAMETER/2, TOUCH_DIAMETER/2);
			containsPoint = bounds.contains(position);
		}
		
		return containsPoint;
	}
	
	public FreeformLayer getNodeLayer() {
		IFigure layer = getDiagramEditPart().getLayer(LayerConstants.PRIMARY_LAYER);
		if (layer instanceof FreeformLayer) {
			return (FreeformLayer) layer;	
		}

		return null;
	}
	
	public ConnectionLayer getConnectionLayer() {
		IFigure layer = getDiagramEditPart().getLayer(LayerConstants.CONNECTION_LAYER);
		if (layer instanceof ConnectionLayer) {
			return (ConnectionLayer) layer;	
		}

		return null;
	}
	
	public void notifyChanged(TouchNotification notification){
		int eventType = notification.getEventType();
		switch (eventType) {
		case TouchNotification.touchAdded:
			handleTouchAdded(notification.getTouch());
			break;
		case TouchNotification.touchRemoved:
			handleTouchRemoved(notification.getTouch());
			break;
		case TouchNotification.touchChanged:
			handleTouchChanged(notification.getTouch());
			break;
		default:
			break;
		}		
	}

	public abstract void handleTouchAdded(Touch touch);

	public abstract void handleTouchRemoved(Touch touch);

	public abstract void handleTouchChanged(Touch touch);

	public void setDispatch(TouchDispatch dispatch) {
		if (dispatch != this.dispatch) {
			if (this.dispatch != null) {
				this.dispatch.getAdapters().remove(this);	
			}
			this.dispatch = dispatch;
			if (this.dispatch!= null) {
				this.dispatch.getAdapters().add(this);	
			}
		}
	}

	
	public EditPart findTouchedEditPart(Touch touch){
		return findTouchedEditPartExcluding(touch, Collections.EMPTY_LIST);
	}
	
	public EditPart findFigureEditPart(IFigure figure){
		EditPart part = (EditPart)getDiagramEditPart().getViewer().getVisualPartMap().get(figure);
		return part;
	}
	
	@SuppressWarnings("unchecked")
	public EditPart findTouchedEditPartExcluding(Touch touch, Collection exclusions){
		
		Point position = touch.getPosition().getCopy();
		getDiagramEditPart().getFigure().translateToRelative(position);
		
		IFigure figure = getDiagramEditPart().getFigure().findFigureAt(position);
		
		EditPart part = null;
		while (part == null && figure != null) {
			part = findFigureEditPart(figure);
			if (exclusions.contains(part)) {
				part = null;
			}
			figure = figure.getParent();
		}

		return part;
	}
	
	public boolean pointsInDistance(Touch firstTouch, Touch secondTouch, float distance){
		return (firstTouch.getPosition().getDistance(secondTouch.getPosition()) < distance);
	}
	
	public void reset(){
		acceptsTouches = true;
		canExecute = false;
	}
	
	public TouchDispatch getDispatch() {
		return dispatch;
	}
	
	public void setAcceptsTouches(boolean acceptsTouches) {
		if (acceptsTouches != this.acceptsTouches) {
			this.acceptsTouches = acceptsTouches;
			notifyAdapters(new GestureNotificationImpl(this,GestureNotification.gestureAcceptanceChange));
		}
	}

	public boolean getAcceptsTouches() {
		return acceptsTouches;
	}

	public void setCanExecute(boolean canExecute) {
		if (canExecute != this.canExecute) {
			this.canExecute = canExecute;
			notifyAdapters(new GestureNotificationImpl(this,GestureNotification.gestureExecutionChange));
		}
	}

	public boolean getCanExecute() {
		return canExecute;
	}
	
	public DiagramEditPart getDiagramEditPart() {
		return diagramEditPart;
	}

	public void setDiagramEditPart(DiagramEditPart editor) {
		this.diagramEditPart = editor;
	}

	protected GraphicalEditPart getPrimaryEditPart(EditPart touchedEditPart) {
		EditPart primaryEditPart = touchedEditPart;
		while (primaryEditPart  != null 
				&& !(primaryEditPart  instanceof ShapeNodeEditPart)
				&& !(primaryEditPart  instanceof DiagramEditPart)) {
			primaryEditPart = primaryEditPart.getParent();
		}
		return (GraphicalEditPart) primaryEditPart;
	}
}
