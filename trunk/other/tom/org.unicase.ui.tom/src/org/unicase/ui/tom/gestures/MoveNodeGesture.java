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

import org.eclipse.draw2d.Figure;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.gef.EditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.DiagramEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.INodeEditPart;
import org.eclipse.gmf.runtime.diagram.ui.figures.BorderItemsAwareFreeFormLayer;
import org.unicase.ui.common.diagram.util.EditPartUtility;
import org.unicase.ui.tom.TouchDispatch;
import org.unicase.ui.tom.operations.MoveNodeOperation;
import org.unicase.ui.tom.tools.TouchConstants;
import org.unicase.ui.tom.tools.TouchUtility;
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
public class MoveNodeGesture extends AbstractMoveGesture {

	private MoveNodeOperation moveNodeOperation;

	/**
	 * Default constructor.
	 * 
	 * @param dispatch
	 *            The {@link TouchDispatch} at which the gesture will register
	 *            for touch events
	 * @param diagramEditPart
	 *            The {@link DiagramEditPart}
	 */
	public MoveNodeGesture(TouchDispatch dispatch) {
		super(dispatch);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.unicase.ui.tom.gestures.Gesture#execute()
	 */
	public void execute() {
		if (isExecuting()) {
			return;
		}
		setAcceptsAdditionalTouches(false);
		setExecuting(true);
		setExecutingMoveGesture(this);

		Point firstPoint = getMoveTouch().getPath().getFirstPoint();

		INodeEditPart primaryEditPart = findTouchedNodeEditPart(firstPoint);
		if (primaryEditPart == null) {
			return;
			// throw new IllegalStateException();
		}

		MoveNodeOperation moveNodeOperation = new MoveNodeOperation(
				getDiagramEditPart(), primaryEditPart);

		setMoveNodeOperation(moveNodeOperation);

		getMoveNodeOperation().prepare(firstPoint);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.unicase.ui.tom.gestures.AbstractGesture#handleSingleTouchAdded(org.unicase.ui.tom.touches.SingleTouch)
	 */
	@Override
	public void handleSingleTouchAdded(SingleTouch touch) {
		if (!(acceptsAdditionalTouches())) {
			return;
		}

		if (!(touch.getPosition().equals(touch.getPath().getFirstPoint()))) {
			throw new IllegalStateException();
		}
		
		EditPart touchedEditPart = findTouchedNodeEditPart(touch.getPosition());
		if (touchedEditPart != null) {
			getCandidateTouches().add(touch);
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.unicase.ui.tom.gestures.AbstractGesture#handleSingleTouchChanged(org.unicase.ui.tom.touches.SingleTouch)
	 */
	@Override
	public void handleSingleTouchChanged(SingleTouch touch) {
		if (isExecuting()) {
			if (touch == getMoveTouch()) {
				getMoveNodeOperation().update(touch.getPosition());
			}
			return;
		}

		if (getExecutingMoveGesture() != null) {
			return;
		}

		if (!getCandidateTouches().contains(touch)) {
			return;
		}

		if (!touchMoved(touch, TouchConstants.TOUCH_MOVEMENT_THRESHOLD)) {
			return;
		}

		setMoveTouch(touch);
		getCandidateTouches().remove(touch);
		setCanExecute(true);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.unicase.ui.tom.gestures.AbstractGesture#handleSingleTouchRemoved(org.unicase.ui.tom.touches.SingleTouch)
	 */
	@Override
	public void handleSingleTouchRemoved(SingleTouch touch) {
		if (touch == getMoveTouch()) {
			if (isExecuting()) {
				getMoveNodeOperation().finish();

				setExecuting(false);
				setExecutingMoveGesture(null);
				setAcceptsAdditionalTouches(true);
			}

			setCanExecute(false);
			setMoveTouch(null);

		}
		
		getCandidateTouches().remove(touch);
	}

	/**
	 * @param moveCommand
	 *            The {@link MoveNodeOperation}
	 */
	protected void setMoveNodeOperation(MoveNodeOperation moveCommand) {
		this.moveNodeOperation = moveCommand;
	}

	/**
	 * @return The {@link MoveNodeOperation}
	 */
	protected MoveNodeOperation getMoveNodeOperation() {
		return moveNodeOperation;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.unicase.ui.tom.gestures.Gesture#getMandatoryTouches()
	 */
	public List<MultiTouch> getMandatoryTouches() {
		if (getMoveTouch() == null) {
			return Collections.emptyList();
		}
		List<MultiTouch> mandatoryTouches = new ArrayList<MultiTouch>();
		mandatoryTouches.add(getMoveTouch().getMultiTouch());
		return mandatoryTouches;

	}

}
