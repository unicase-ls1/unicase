/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.tom.gestures;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.draw2d.geometry.Point;
import org.eclipse.gef.EditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ConnectionEditPart;
import org.unicase.ui.tom.TouchDispatch;
import org.unicase.ui.tom.operations.MoveConnectionBendpointOperation;
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
public class MoveConnectionBendpointGesture extends AbstractMoveGesture
		implements Gesture {

	private MoveConnectionBendpointOperation moveConnectionBendpointCommand;

	/**
	 * Default constructor.
	 * 
	 * @param dispatch
	 *            The {@link TouchDispatch} at which the gesture will register
	 *            for touch events
	 */
	public MoveConnectionBendpointGesture(TouchDispatch dispatch) {
		super(dispatch);
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

		Point position = touch.getPosition().getCopy();
		ConnectionEditPart editPart = findTouchedConnectionEditPart(position);

		if (editPart != null) {
			getCandidateTouchEditPartMap().put(touch, editPart);
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
				Point point = getMoveTouch().getPosition().getCopy();
				TouchDispatch.getInstance().translateToEditor(point);
				getMoveConnectionBendpointCommand().update(point);
			}
			return;
		}

		if (getExecutingMoveGesture() == null) {
			if (getCandidateTouchEditPartMap().containsKey(touch)) {
				if (touchMoved(touch, TouchConstants.TOUCH_MOVEMENT_THRESHOLD)) {
					EditPart editPart = getCandidateTouchEditPartMap().get(
							touch);
					setMoveTouch(touch);
					setMoveEditPart(editPart);
					getCandidateTouchEditPartMap().remove(touch);
					setCanExecute(true);
					return;
				}
			}
		}

	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.unicase.ui.tom.gestures.AbstractGesture#handleSingleTouchRemoved(org.unicase.ui.tom.touches.SingleTouch)
	 */
	@Override
	public void handleSingleTouchRemoved(SingleTouch touch) {
		if (!isExecuting()) {
			return;
		}

		if (touch != getMoveTouch()) {
			return;
		}

		getMoveConnectionBendpointCommand().finish();

		setExecuting(false);
		setMoveTouch(null);
		setCanExecute(false);
		setExecutingMoveGesture(null);
	}

	/**
	 * @param moveConnectionBendpointCommand
	 *            The {@link MoveConnectionBendpointOperation} used by this
	 *            gesture
	 */
	public void setMoveConnectionBendpointCommand(
			MoveConnectionBendpointOperation moveConnectionBendpointCommand) {
		this.moveConnectionBendpointCommand = moveConnectionBendpointCommand;
	}

	/**
	 * @return The {@link MoveConnectionBendpointOperation} used by this gesture
	 */
	public MoveConnectionBendpointOperation getMoveConnectionBendpointCommand() {
		return moveConnectionBendpointCommand;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.unicase.ui.tom.gestures.MomentaryGesture#finish()
	 */
	public void execute() {
		setMoveConnectionBendpointCommand(new MoveConnectionBendpointOperation(
				getDiagramEditPart(), (ConnectionEditPart) getMoveEditPart()));
		
		Point firstPoint = getMoveTouch().getPath().getFirstPoint().getCopy();
		TouchDispatch.getInstance().translateToEditor(firstPoint);
		getMoveConnectionBendpointCommand().prepare(firstPoint);

		setExecuting(true);
		setExecutingMoveGesture(this);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.unicase.ui.tom.gestures.Gesture#getMandatoryTouches()
	 */
	public List<MultiTouch> getMandatoryTouches() {
		List<MultiTouch> mandatoryTouches = new ArrayList<MultiTouch>();

		if (getMoveTouch() != null) {
			mandatoryTouches.add(getMoveTouch().getMultiTouch());
		}

		return mandatoryTouches;
	}

}
