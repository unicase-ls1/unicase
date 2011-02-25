/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.tom.gestures;

import java.util.Collections;
import java.util.List;

import org.eclipse.draw2d.geometry.Point;
import org.eclipse.gef.EditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.DiagramEditPart;
import org.unicase.ui.tom.TouchDispatch;
import org.unicase.ui.tom.actions.MoveCanvasAction;
import org.unicase.ui.tom.tools.TouchConstants;
import org.unicase.ui.tom.touches.MultiTouch;
import org.unicase.ui.tom.touches.SingleTouch;

/**
 * @author schroech
 *
 */
public class MoveCanvasGesture extends AbstractMoveGesture {

	private MoveCanvasAction moveCanvasAction;

	/**
	 * Default constructor.
	 * 
	 * @param dispatch The {@link TouchDispatch} at which the gesture will register for touch events
	 * @param diagramEditPart The {@link DiagramEditPart}
	 */
	public MoveCanvasGesture(TouchDispatch dispatch, DiagramEditPart diagramEditPart) {
		super(dispatch, diagramEditPart); 
		setMoveCanvasAction(new MoveCanvasAction(diagramEditPart));
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

		EditPart touchedEditPart = findTouchedEditPart(touch);
		EditPart primaryEditPart = getPrimaryEditPart(touchedEditPart);

		if (primaryEditPart != null
				&& primaryEditPart instanceof DiagramEditPart){
			getCandidateTouches().add(touch);	
		}			
	}

	/** 
	 * {@inheritDoc}
	 * @see org.unicase.ui.tom.gestures.AbstractGesture#handleSingleTouchChanged(org.unicase.ui.tom.touches.SingleTouch)
	 */
	@Override
	public void handleSingleTouchChanged(SingleTouch touch) {

		//BEGIN SANITY CHECKS
		if (!(touch instanceof SingleTouch)) {
			return;
		}
		//END SANITY CHECKS

		if (!(getCandidateTouches().contains(touch))) {
			return;
		}

		if (getMoveTouch() == null) { 
			MultiTouch multiTouch = touch.getMultiTouch();
			if (multiTouch.getActiveTouches().size() > 1) {
				return;
			}

			if (touchMoved((SingleTouch) touch, TouchConstants.TOUCH_MOVEMENT_THRESHOLD)) {
				setMoveTouch(touch);
				setCanExecute(true);
				return;
			}
		}

		if (isExecuting()) {	
			getMoveCanvasAction().updateMove(touch.getPosition());
		}
	}

	/** 
	 * {@inheritDoc}
	 * @see org.unicase.ui.tom.gestures.AbstractGesture#handleSingleTouchRemoved(org.unicase.ui.tom.touches.SingleTouch)
	 */
	@Override
	public void handleSingleTouchRemoved(SingleTouch touch) {
		if (touch == getMoveTouch()) {
			setMoveTouch(null);
		}
		getCandidateTouches().remove(touch);		
		
		setExecuting(false);
		setCanExecute(false);
	}

	/**
	 * @param moveCanvasAction The {@link MoveCanvasAction} used by this gesture
	 */
	public void setMoveCanvasAction(MoveCanvasAction moveCanvasAction) {
		this.moveCanvasAction = moveCanvasAction;
	}

	/**
	 * @return The {@link MoveCanvasAction} used by this gesture
	 */
	public MoveCanvasAction getMoveCanvasAction() {
		return moveCanvasAction;
	}

	/** 
	 * {@inheritDoc}
	 * @see org.unicase.ui.tom.gestures.AbstractGesture#reset()
	 */
	@Override
	public void reset() {
		super.reset();
	}

	/** 
	 * {@inheritDoc}
	 * @see org.unicase.ui.tom.gestures.MomentaryGesture#finish()
	 */
	public void execute() {
		if (!(canExecute())) {
			return;
		}

		setExecuting(true);

		Point firstPoint = ((SingleTouch) getMoveTouch()).getPath().getFirstPoint();
		getMoveCanvasAction().prepareMove(firstPoint);
	}

	/** 
	* {@inheritDoc}
	* @see org.unicase.ui.tom.gestures.Gesture#getMandatoryTouches()
	*/
	public List<MultiTouch> getMandatoryTouches() {
		if (getMoveTouch() == null) {
			return Collections.emptyList();
		}else{
			return Collections.singletonList(getMoveTouch().getMultiTouch());
		}
	}
}
