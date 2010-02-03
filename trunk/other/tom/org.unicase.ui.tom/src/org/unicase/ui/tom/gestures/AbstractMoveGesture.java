/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.tom.gestures;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.gef.EditPart;
import org.unicase.ui.tom.TouchDispatch;
import org.unicase.ui.tom.touches.SingleTouch;

/**
 * @author schroech
 * 
 */

public abstract class AbstractMoveGesture extends AbstractContinuousGesture {

	private static AbstractMoveGesture executingMoveGesture;

	private SingleTouch moveTouch;
	private EditPart moveEditPart;
	private Map<SingleTouch, EditPart> candidateTouchEditPartMap = new HashMap<SingleTouch, EditPart>();

	/**
	 * Default constructor.
	 * 
	 * @param dispatch
	 *            The {@link TouchDispatch} at which the gesture will register
	 *            for touch events
	 */
	public AbstractMoveGesture(TouchDispatch dispatch) {
		super(dispatch);
	}

	/**
	 * @param moveTouch
	 *            The moving touch
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
	 * 
	 * @see org.unicase.ui.tom.gestures.AbstractMomentaryGesture#reset()
	 */
	@Override
	public void reset() {
		super.reset();

		setMoveTouch(null);
		getCandidateTouchEditPartMap().clear();
		setExecutingMoveGesture(null);
	}

	/**
	 * @param candidateTouches
	 *            The possible move touches
	 */

	/**
	 * @return The possible move touches
	 */

	/**
	 * @param executingMoveGesture The single executing move gesture
	 */
	public static void setExecutingMoveGesture(
			AbstractMoveGesture executingMoveGesture) {
		AbstractMoveGesture.executingMoveGesture = executingMoveGesture;
	}

	/**
	 * @return The single executing move gesture
	 */
	public static AbstractMoveGesture getExecutingMoveGesture() {
		return executingMoveGesture;
	}

	/**
	 * @param candidateTouchEditPartMap The map correlating touches possibly belonging to this 
	 * gesture with the editParts they initially touched at the touch down event
	 */
	public void setCandidateTouchEditPartMap(
			Map<SingleTouch, EditPart> candidateTouchEditPartMap) {
		this.candidateTouchEditPartMap = candidateTouchEditPartMap;
	}

	/**
	 * @return The map correlating touches possibly belonging to this 
	 * gesture with the editParts they initially touched at the touch down event
	 */
	public Map<SingleTouch, EditPart> getCandidateTouchEditPartMap() {
		return candidateTouchEditPartMap;
	}

	/**
	 * @param moveEditPart The {@link EditPart} to move
	 */
	public void setMoveEditPart(EditPart moveEditPart) {
		this.moveEditPart = moveEditPart;
	}

	/**
	 * @return The {@link EditPart} to move
	 */
	public EditPart getMoveEditPart() {
		return moveEditPart;
	}

}