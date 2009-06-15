/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.tom.gestures;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.gef.EditPart;
import org.eclipse.gef.NodeEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.DiagramEditPart;
import org.unicase.ui.tom.TouchDispatch;
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
public class MoveMultiNodeGesture extends AbstractMoveGesture{

	private Map<SingleTouch, MoveNodeGesture> touchGestureMap;

	/**
	 * Default constructor.
	 * 
	 * @param dispatch The {@link TouchDispatch} at which the gesture will register for touch events
	 * @param diagramEditPart The {@link DiagramEditPart}
	 */
	public MoveMultiNodeGesture(TouchDispatch dispatch) {
		super(dispatch);

		setTouchGestureMap(new HashMap<SingleTouch, MoveNodeGesture>());	
	}

	/** 
	 * {@inheritDoc}
	 * @see org.unicase.ui.tom.gestures.AbstractGesture#handleSingleTouchAdded(org.unicase.ui.tom.touches.SingleTouch)
	 */
	@Override
	public void handleSingleTouchAdded(SingleTouch touch) {
		List<Touch> activeTouches = touch.getMultiTouch().getActiveTouches();
		if (activeTouches.size() > 1) {
			for (Touch activeTouch : activeTouches) {
				getCandidateTouches().remove(activeTouch);
			}
		}

		EditPart touchedEditPart = findTouchedEditPartExcludingDiagram(touch);
		touchedEditPart = getPrimaryEditPart(touchedEditPart);

		if (touchedEditPart instanceof NodeEditPart) {
			getCandidateTouches().add(touch);
		}
	}

	/** 
	 * {@inheritDoc}
	 * @see org.unicase.ui.tom.gestures.AbstractGesture#handleSingleTouchChanged(org.unicase.ui.tom.touches.SingleTouch)
	 */
	@Override
	public void handleSingleTouchChanged(SingleTouch touch) {
		if (!(acceptsAdditionalTouches())) {
			return;
		}

		MoveNodeGesture moveNodeGesture = getTouchGestureMap().get(touch);
		if (moveNodeGesture != null) {
			return;
		}

		if (getCandidateTouches().contains(touch)) {
			if (touchMoved(touch, TouchConstants.TOUCH_MOVEMENT_THRESHOLD)){
				setMoveTouch(touch);
				getCandidateTouches().remove(touch);
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
		getCandidateTouches().remove(touch);
		if (getMoveTouch() == touch) {
			setMoveTouch(null);
			setCanExecute(false);
		}
	}


	/** 
	* {@inheritDoc}
	* @see org.unicase.ui.tom.gestures.AbstractMoveGesture#reset()
	*/
	public void reset() {
		super.reset();

		Collection<MoveNodeGesture> values = touchGestureMap.values();
		for (Gesture gesture : values) {
			getDispatch().getAdapters().remove(gesture);
		}
		getTouchGestureMap().clear();
	}

	/** 
	* {@inheritDoc}
	* @see org.unicase.ui.tom.gestures.Gesture#execute()
	*/
	public void execute() {
		if (!(canExecute())) {
			return;
		}

		if (getMoveTouch() == null) {
			return;	
		}

		MoveNodeGesture moveNodeGesture = new MoveNodeGesture(getDispatch());
		moveNodeGesture.setMoveTouch(getMoveTouch());
		moveNodeGesture.execute();

		getDispatch().getAdapters().add(moveNodeGesture);

		getTouchGestureMap().put(getMoveTouch(), moveNodeGesture);

		setMoveTouch(null);
		setCanExecute(false);
	}

	private void setTouchGestureMap(Map<SingleTouch, MoveNodeGesture> touchGestureMap) {
		this.touchGestureMap = touchGestureMap;
	}

	private Map<SingleTouch, MoveNodeGesture> getTouchGestureMap() {
		return touchGestureMap;
	}

	/** 
	* {@inheritDoc}
	* @see org.unicase.ui.tom.gestures.Gesture#getMandatoryTouches()
	*/
	@SuppressWarnings("unchecked")
	public List<MultiTouch> getMandatoryTouches() {
		return Collections.EMPTY_LIST;
	}

}
