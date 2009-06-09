/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.tom.gestures;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.gmf.runtime.diagram.ui.editparts.DiagramEditPart;
import org.unicase.ui.tom.TouchDispatch;
import org.unicase.ui.tom.touches.SingleTouch;
import org.unicase.ui.tom.touches.Touch;

/**
 * @author schroech
 *
 */
public abstract class CreateGesture extends AbstractGesture{

	/**
	 * The maximum time the creation touch is allowed to remain on 
	 * the table before it is no longer classified as the creation touch.
	 */
	protected static final long CREATION_TOUCH_LIFESPAN = 100;

	/**
	 * The maximum threshold a touch is allowed to move before is no longer classified as static. 
	 */
	protected static final int STATIONARY_TOUCH_MAXIMUM_MOVE = 50;

	private List<Touch> stationaryTouches;
	private Touch creationTouch;

	/**
	 * @param dispatch The {@link TouchDispatch} at which the gesture will register for touch events
	 * @param diagramEditPart The {@link DiagramEditPart}
	 */
	public CreateGesture(TouchDispatch dispatch, DiagramEditPart diagramEditPart) {
		super(dispatch, diagramEditPart);

		stationaryTouches = new ArrayList<Touch>();
	}

	/** 
	 * {@inheritDoc}
	 * @see org.unicase.ui.tom.gestures.AbstractGesture#reset()
	 */
	public void reset() {
		super.reset();

		getStationaryTouches().clear();
		setCreationTouch(null);
	}

	/**
	 * @param stationaryTouches All touches not moving and not beeing lifted before the CREATION_TOUCH_LIFESPAN
	 */
	public void setStationaryTouches(List<Touch> stationaryTouches) {
		this.stationaryTouches = stationaryTouches;
	}

	/**
	 * @return A list of touches  
	 */
	public List<Touch> getStationaryTouches() {
		return stationaryTouches;
	}

	/**
	 * @param creationTouch The creation touch  
	 */
	public void setCreationTouch(Touch creationTouch) {
		this.creationTouch = creationTouch;
	}


	/**
	 * @return The creation touch or null, if such does not exist.
	 */
	public Touch getCreationTouch() {
		return creationTouch;
	}

	/** 
	 * {@inheritDoc}
	 * @see org.unicase.ui.tom.gestures.AbstractGesture#handleSingleTouchRemoved(org.unicase.ui.tom.touches.Touch)
	 */
	@Override
	public void handleSingleTouchRemoved(SingleTouch touch) {
		getStationaryTouches().remove(touch);	
	}

	/** 
	 * {@inheritDoc}
	 * @see org.unicase.ui.tom.gestures.AbstractGesture#handleSingleTouchAdded(org.unicase.ui.tom.touches.Touch)
	 */
	public void handleSingleTouchAdded(SingleTouch touch) {
		if (!(acceptsAdditionalTouches())) {
			return;
		}

		getStationaryTouches().add(touch);
	}

	/** 
	 * {@inheritDoc}
	 * @see org.unicase.ui.tom.gestures.AbstractGesture#handleSingleTouchChanged(org.unicase.ui.tom.touches.Touch)
	 */
	public void handleSingleTouchChanged(SingleTouch touch) {
		if (!(touch instanceof SingleTouch)) {
			return;
		}

		if (touchMoved((SingleTouch) touch, STATIONARY_TOUCH_MAXIMUM_MOVE)) {
			getStationaryTouches().remove(touch);	
		}			
	}
}
