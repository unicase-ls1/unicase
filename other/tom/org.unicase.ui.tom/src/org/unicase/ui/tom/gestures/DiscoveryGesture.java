/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.tom.gestures;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.draw2d.geometry.PointList;
import org.eclipse.gef.EditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.INodeEditPart;
import org.unicase.ui.tom.TouchDispatch;
import org.unicase.ui.tom.commands.DiscoveryModeActivationCommand;
import org.unicase.ui.tom.commands.DiscoveryModeDeactivationCommand;
import org.unicase.ui.tom.tools.TouchUtility;
import org.unicase.ui.tom.touches.MultiTouch;
import org.unicase.ui.tom.touches.SingleTouch;

/**
 * @author schroech
 * 
 */
public class DiscoveryGesture extends AbstractContinuousGesture {

	private MultiTouch activationTouch;
	private EditPart touchedEditPart;

	/**
	 * Default constructor.
	 * 
	 * @param dispatch
	 *            The {@link TouchDispatch} at which the gesture will register
	 *            for touch events
	 */
	public DiscoveryGesture(TouchDispatch dispatch) {
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

		List<SingleTouch> activeTouches = touch.getMultiTouch().getActiveTouches();
		if (activeTouches.size() < 4) {
			return;
		}

		PointList pointList = TouchUtility
				.pointListOfCurrentPositions(activeTouches);

		INodeEditPart currentlyTouchedEditPart = findCardinalTouchedNodeEditPart(pointList);
		if (currentlyTouchedEditPart == null) {
			return;
		}

		setActivationTouch(touch.getMultiTouch());
		setTouchedEditPart(currentlyTouchedEditPart);
		setCanExecute(true);
		return;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.unicase.ui.tom.gestures.AbstractGesture#handleSingleTouchChanged(org.unicase.ui.tom.touches.SingleTouch)
	 */
	@Override
	public void handleSingleTouchChanged(SingleTouch touch) {

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

		if (touch.getMultiTouch() != getActivationTouch()) {
			return;
		}

		if (!(touch.getMultiTouch().getActiveTouches().size() < 4)) {
			return;
		}

		DiscoveryModeDeactivationCommand command = new DiscoveryModeDeactivationCommand(
				getDiagramEditPart(), (GraphicalEditPart) getTouchedEditPart());
		command.execute();

		setExecuting(false);
		setCanExecute(false);

		setTouchedEditPart(null);
		setActivationTouch(null);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.unicase.ui.tom.gestures.Gesture#execute()
	 */
	public void execute() {
		setExecuting(true);

		DiscoveryModeActivationCommand command = new DiscoveryModeActivationCommand(
				getDiagramEditPart(), (GraphicalEditPart) getTouchedEditPart());
		command.execute();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.unicase.ui.tom.gestures.Gesture#getMandatoryTouches()
	 */
	public List<MultiTouch> getMandatoryTouches() {
		List<MultiTouch> mandatoryTouches = new ArrayList<MultiTouch>();

		mandatoryTouches.add(getActivationTouch());

		return mandatoryTouches;
	}

	/**
	 * @param activationTouch The multitouch activating the multitouch mode. 
	 */
	public void setActivationTouch(MultiTouch activationTouch) {
		this.activationTouch = activationTouch;
	}

	/**
	 * @return The multitouch activating the multitouch mode. 
	 */
	public MultiTouch getActivationTouch() {
		return activationTouch;
	}

	/**
	 * @param touchedEditPart The EditPart being touched
	 */
	public void setTouchedEditPart(EditPart touchedEditPart) {
		this.touchedEditPart = touchedEditPart;
	}

	/**
	 * @return EditPart The EditPart being touched
	 */
	public EditPart getTouchedEditPart() {
		return touchedEditPart;
	}
}
