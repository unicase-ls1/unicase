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

/**
 * @author schroech
 *
 */
public abstract class AbstractMoveGesture extends AbstractContinuousGesture {

	private SingleTouch moveTouch;
	private List<SingleTouch> candidateTouches;

	/**
	 * Default constructor.
	 * 
	 * @param dispatch The {@link TouchDispatch} at which the gesture will register for touch events
	 * @param diagramEditPart The {@link DiagramEditPart}
	 */
	public AbstractMoveGesture(TouchDispatch dispatch) {
		super(dispatch);
		
		setCandidateTouches(new ArrayList<SingleTouch>());
	}

	/**
	 * @param moveTouch The moving touch
	 */
	public void setMoveTouch(SingleTouch moveTouch) {
		this.moveTouch = moveTouch;
	}

	/**
	 * @return The moving touch
	 */
	public SingleTouch getMoveTouch() {
		return moveTouch;
	}
	
	/** 
	* {@inheritDoc}
	* @see org.unicase.ui.tom.gestures.AbstractMomentaryGesture#reset()
	*/
	@Override
	public void reset() {
		super.reset();
		
		setMoveTouch(null);
		getCandidateTouches().clear();	
	}

	/**
	 * @param candidateTouches The possible move touches
	 */
	public void setCandidateTouches(List<SingleTouch> candidateTouches) {
		this.candidateTouches = candidateTouches;
	}

	/**
	 * @return The possible move touches
	 */
	public List<SingleTouch> getCandidateTouches() {
		return candidateTouches;
	}

}