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
import org.unicase.ui.tom.TouchDispatch;
import org.unicase.ui.tom.notifications.GestureNotification;
import org.unicase.ui.tom.notifications.GestureNotificationImpl;
import org.unicase.ui.tom.notifications.GestureNotifierImpl;
import org.unicase.ui.tom.notifications.TouchAdapter;
import org.unicase.ui.tom.notifications.TouchNotification;
import org.unicase.ui.tom.touches.MultiTouch;
import org.unicase.ui.tom.touches.SingleTouch;
import org.unicase.ui.tom.touches.Touch;

/**
 * @author schroech
 *
 */
public abstract class AbstractGesture extends GestureNotifierImpl 
implements TouchAdapter, Gesture{
	
	private List<MultiTouch> optionalTouches;
	private List<Gesture> restrictingGestures;
	private int priority;
	private TouchDispatch dispatch;
	private boolean acceptsTouches;
	private DiagramEditPart diagramEditPart;

	private boolean canExecute;

	/**
	 * @param canExecute
	 * Specifies wether the gesture can execute
	 */
	public void setCanExecute(boolean canExecute) {
		if (canExecute != this.canExecute) {
			this.canExecute = canExecute;
			notifyAdapters(new GestureNotificationImpl(this,GestureNotification.gestureExecutionChange));
		}
	}

	/** 
	 * {@inheritDoc}
	 * @see org.unicase.ui.tom.gestures.Gesture#canExecute()
	 */
	public boolean canExecute() {
		return canExecute;
	}
	
	/**
	 * Default constructor.
	 * 
	 * @param dispatch The {@link TouchDispatch} at which the gesture will register for touch events
	 * @param diagramEditPart The {@link DiagramEditPart}
	 */
	public AbstractGesture(TouchDispatch dispatch, DiagramEditPart diagramEditPart) {
		setDispatch(dispatch);
		setDiagramEditPart(diagramEditPart);
		setRestrictingGestures(new ArrayList<Gesture>());
		setOptionalTouches(Collections.EMPTY_LIST);
		
		canExecute = false;
		acceptsTouches = true;
	}


	public EditPart findCardinalTouchedEditPart(Collection<Touch> touches){
		return findCardinalTouchedEditPartExcluding(touches, Collections.EMPTY_LIST);
	}

	public EditPart findTouchedEditPart(Touch touch){
		return findTouchedEditPartExcluding(touch, Collections.EMPTY_LIST);
	}

	public Set<EditPart> findTouchedEditParts(Collection<Touch> touches){
		return findTouchedEditPartsExcluding(touches, Collections.EMPTY_LIST);
	}

	/**
	 * @param touch
	 * @param exclusions
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public EditPart findTouchedEditPartExcluding(Touch touch, Collection exclusions){

		Point position = touch.getPosition().getCopy();
		getDiagramEditPart().getFigure().translateToRelative(position);

		return findTouchedEditPartExcluding(exclusions, position);
	}

	/**
	 * @param exclusions
	 * @param position
	 * @return
	 */
	public EditPart findTouchedEditPartExcluding(Collection exclusions,
			Point position) {
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

	/**
	 * @param touch
	 * @param exclusions
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public EditPart findCardinalTouchedEditPartExcluding(Collection<Touch> touches, Collection exclusions){

		Set<EditPart> directlyTouchedEditParts = findTouchedEditPartsExcluding(touches, exclusions);
		EditPart editPart = findEditPartAtCenterExcluding(touches, exclusions);	

		if (directlyTouchedEditParts.contains(editPart)) {
			return editPart;
		}

		List<Touch> chronologicallySortedTouches = new ArrayList<Touch>();
		chronologicallySortedTouches.addAll(touches);
		Comparator<Touch> comp = new Comparator<Touch>(){

			public int compare(Touch o1, Touch o2) {
				if (o1.getLifeSpan() < o2.getLifeSpan()) {
					return -1;
				}else if (o1.getLifeSpan() == o2.getLifeSpan()) {
					return 0;
				}else{
					return 1;	
				}
			}

		};

		for (Touch touch : chronologicallySortedTouches) {
			Point position = touch.getPosition();
			editPart = findTouchedEditPartExcluding(exclusions, position);

			if (!(exclusions.contains(editPart))) {
				return editPart;
			}
		}

		return null;
	}


	public Set<EditPart> findTouchedEditPartsExcluding(Collection<Touch> touches, Collection exclusions){
		Set<EditPart> editParts = new HashSet<EditPart>();

		for (Touch touch : touches) {
			Point position = touch.getPosition();
			EditPart editPart = findTouchedEditPartExcluding(exclusions, position);

			if (!(exclusions.contains(editPart))) {
				editParts.add(editPart);
			}
		}

		return editParts; 
	}

	public EditPart findEditPartAtCenterExcluding(Collection<Touch> touches, Collection exclusions) {
		PointList points = new PointList();

		for (Touch touch : touches) {
			points.addPoint(touch.getPosition());
		}

		Point center = points.getBounds().getCenter();
		getDiagramEditPart().getFigure().translateToRelative(center);

		EditPart editPart = findTouchedEditPartExcluding(exclusions, center);

		if (exclusions.contains(editPart)) {
			return null;
		}

		return editPart;
	}

	public EditPart findFigureEditPart(IFigure figure){
		EditPart part = (EditPart)getDiagramEditPart().getViewer().getVisualPartMap().get(figure);
		return part;
	}

	@SuppressWarnings("unchecked")
	public EditPart findTouchedEditPartExcludingDiagram(Touch touch){
		List exclusions = new ArrayList();
		exclusions.add(getDiagramEditPart());
		exclusions.add(getDiagramEditPart().getParent());

		return findTouchedEditPartExcluding(touch, exclusions);
	}

	@SuppressWarnings("unchecked")
	public Set<EditPart> findTouchedEditPartsExcludingDiagram(Collection<Touch> touches){
		List exclusions = new ArrayList();
		exclusions.add(getDiagramEditPart());
		exclusions.add(getDiagramEditPart().getParent());

		return findTouchedEditPartsExcluding(touches, exclusions);
	}

	@SuppressWarnings("unchecked")
	public EditPart findCardinalTouchedEditPartExcludingDiagram(Collection<Touch> touches){
		List exclusions = new ArrayList();
		exclusions.add(getDiagramEditPart());
		exclusions.add(getDiagramEditPart().getParent());

		return findCardinalTouchedEditPartExcluding(touches, exclusions);
	}

	/**
	 * Determines if the touch moved moved more than the specified threshold.  
	 *  
	 * @param touch The touch beeing investigated
	 * @param threshold The threshold being accepted
	 * @return true if the touch moved more than the threshold, false otherwise
	 */
	protected static boolean touchMoved(SingleTouch touch, int threshold) {
		PointList path = touch.getPath();
		Rectangle bounds = path.getBounds();
		Point point = touch.getPosition();
		double distance = point.getDistance(bounds.getCenter());

		boolean touchMoved = distance > threshold;

		return touchMoved;
	}

	/**
	 * @return
	 * The layer of the {@link DiagramEditPart} registered under the name PRIMARY_LAYER
	 */
	public FreeformLayer getNodeLayer() {
		IFigure layer = getDiagramEditPart().getLayer(LayerConstants.PRIMARY_LAYER);
		if (layer instanceof FreeformLayer) {
			return (FreeformLayer) layer;	
		}

		return null;
	}


	/**
	 * @return
	 * The layer of the {@link DiagramEditPart} registered under the name CONNECTION_LAYER
	 */
	public ConnectionLayer getConnectionLayer() {
		IFigure layer = getDiagramEditPart().getLayer(LayerConstants.CONNECTION_LAYER);
		if (layer instanceof ConnectionLayer) {
			return (ConnectionLayer) layer;	
		}

		return null;
	}

	/** 
	 * {@inheritDoc}
	 * @see org.unicase.ui.tom.notifications.TouchAdapter#notifyChanged(org.unicase.ui.tom.notifications.TouchNotification)
	 */
	public void notifyChanged(TouchNotification notification){
		int eventType = notification.getEventType();
		Touch touch = notification.getTouch();
		if (touch instanceof SingleTouch) {
			switch (eventType) {
			case TouchNotification.touchAdded:
				handleSingleTouchAdded((SingleTouch) touch);
				break;
			case TouchNotification.touchRemoved:
				handleSingleTouchRemoved((SingleTouch) touch);
				break;
			case TouchNotification.touchChanged:
				handleSingleTouchChanged((SingleTouch) touch);
				break;
			default:
				break;
			}			
		}


	}

	/**
	 * @param touch
	 * The touch added
	 */
	public abstract void handleSingleTouchAdded(SingleTouch touch);

	/**
	 * @param touch
	 * The touch removed
	 */
	public abstract void handleSingleTouchRemoved(SingleTouch touch);

	/**
	 * @param touch
	 * The touch changed
	 */
	public abstract void handleSingleTouchChanged(SingleTouch touch);

	/**
	 * @param dispatch
	 * The {@link TouchDispatch} at which the gesture will register for touch events
	 */
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

	/** 
	 * {@inheritDoc}
	 * @see org.unicase.ui.tom.gestures.Gesture#reset()
	 */
	public void reset(){
		setCanExecute(false);
		setAcceptsAdditionalTouches(true);
	}

	/**
	 * @return
	 * The {@link TouchDispatch} at which the gesture has registered for touch events
	 */
	public TouchDispatch getDispatch() {
		return dispatch;
	}

	/**
	 * @param acceptsTouches
	 * Specifies wether the gesture accepts any more touches
	 */
	public void setAcceptsAdditionalTouches(boolean acceptsTouches) {
		if (acceptsTouches != this.acceptsTouches) {
			this.acceptsTouches = acceptsTouches;
			notifyAdapters(new GestureNotificationImpl(this,GestureNotification.gestureAcceptanceChange));
		}
	}

	/** 
	 * {@inheritDoc}
	 * @see org.unicase.ui.tom.gestures.Gesture#acceptsAdditionalTouches()
	 */
	public boolean acceptsAdditionalTouches() {
		return acceptsTouches;
	}

	/** 
	 * {@inheritDoc}
	 * @see org.unicase.ui.tom.gestures.Gesture#getDiagramEditPart()
	 */
	public DiagramEditPart getDiagramEditPart() {
		return diagramEditPart;
	}

	/** 
	 * {@inheritDoc}
	 * @see org.unicase.ui.tom.gestures.Gesture#setDiagramEditPart(org.eclipse.gmf.runtime.diagram.ui.editparts.DiagramEditPart)
	 */
	public void setDiagramEditPart(DiagramEditPart editor) {
		this.diagramEditPart = editor;
	}

	/**
	 * 
	 * @param touchedEditPart The editPart being examined
	 * @return
	 * The next {@link ShapeNodeEditPart} or {@link DiagramEditPart} in the {@link EditPart} hierarchy or null, if such doesn't exist 
	 */
	public static GraphicalEditPart getPrimaryEditPart(EditPart touchedEditPart) {
		EditPart primaryEditPart = touchedEditPart;
		while (primaryEditPart  != null 
				&& !(primaryEditPart  instanceof ShapeNodeEditPart)
				&& !(primaryEditPart  instanceof DiagramEditPart)) {
			primaryEditPart = primaryEditPart.getParent();
		}
		return (GraphicalEditPart) primaryEditPart;
	}

	/**
	 * @param priority The new priority
	 */
	public void setPriority(int priority) {
		this.priority = priority;
	}

	/** 
	* {@inheritDoc}
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
