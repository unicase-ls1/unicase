/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.tom.gestures;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.eclipse.draw2d.geometry.Point;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.NodeEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.DiagramEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.INodeEditPart;
import org.unicase.ui.tom.TouchDispatch;
import org.unicase.ui.tom.operations.AltMoveNodeOperation;
import org.unicase.ui.tom.operations.MoveNodeOperation;
import org.unicase.ui.tom.tools.TouchConstants;
import org.unicase.ui.tom.touches.MultiTouch;
import org.unicase.ui.tom.touches.SingleTouch;

/**
 * @author schroech
 *
 */
/**
 * @author schroech
 * 
 */
public class MoveNodeGesture extends AbstractMoveGesture {

	private AltMoveNodeOperation moveNodeOperation;
	
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


		AltMoveNodeOperation moveNodeOperation = new AltMoveNodeOperation(
				getDiagramEditPart(), (INodeEditPart) getMoveEditPart());

		setMoveNodeOperation(moveNodeOperation);

		Point firstPoint = getMoveTouch().getPath().getFirstPoint().getCopy();
		
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
		
		NodeEditPart touchedEditPart = findTouchedNodeEditPart(touch.getPosition());
		if (touchedEditPart != null) {
			getCandidateTouchEditPartMap().put(touch, touchedEditPart);
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
				Point position = getMoveTouch().getPosition().getCopy();				
				getMoveNodeOperation().update(position);
			}
			return;
		}

		if (getExecutingMoveGesture() != null) {
			return;
		}

		if (!getCandidateTouchEditPartMap().containsKey(touch)) {
			return;
		}

		if (!touchMoved(touch, TouchConstants.TOUCH_MOVEMENT_THRESHOLD)) {
			return;
		}

		EditPart editPart = getCandidateTouchEditPartMap().get(touch);
		
		setMoveEditPart(editPart);
		setMoveTouch(touch);
		
		getCandidateTouchEditPartMap().remove(touch);
		
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
		
		getCandidateTouchEditPartMap().remove(touch);
	}

	/**
	 * @param moveCommand
	 *            The {@link MoveNodeOperation}
	 */
	protected void setMoveNodeOperation(AltMoveNodeOperation moveCommand) {
		this.moveNodeOperation = moveCommand;
	}

	/**
	 * @return The {@link MoveNodeOperation}
	 */
	protected AltMoveNodeOperation getMoveNodeOperation() {
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
