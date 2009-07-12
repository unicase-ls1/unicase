/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.tom.gestures;

import java.util.Collections;
import java.util.List;

import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.PointList;
import org.eclipse.gef.EditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.DiagramEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart;
import org.unicase.ui.common.diagram.util.EditPartUtility;
import org.unicase.ui.tom.TouchDispatch;
import org.unicase.ui.tom.actions.SelectAction;
import org.unicase.ui.tom.commands.CreateDefaultNodeCommand;
import org.unicase.ui.tom.commands.CreateNodeCommand;
import org.unicase.ui.tom.commands.CreateSecondaryNodeCommand;
import org.unicase.ui.tom.commands.OrderBackCommand;
import org.unicase.ui.tom.tools.TouchUtility;
import org.unicase.ui.tom.touches.MultiTouch;
import org.unicase.ui.tom.touches.SingleTouch;
import org.unicase.ui.tom.touches.Touch;

/**
 * @author schroech
 * 
 */
public class CreateNodeGesture extends CreateGesture implements Gesture {

	/**
	 * @param dispatcher
	 *            The {@link TouchDispatch} at which the gesture will register
	 *            for touch events
	 * @param diagramEditPart
	 *            The {@link DiagramEditPart}
	 */
	public CreateNodeGesture(TouchDispatch dispatcher) {
		super(dispatcher);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.unicase.ui.tom.gestures.AbstractGesture#execute()
	 */
	public void execute() {
		if (!canExecute()) {
			return;
		}

		CreateNodeCommand createNodeCommand;

		MultiTouch multiTouch = getCreationTouch().getMultiTouch();
		List<Touch> activeTouches = multiTouch.getActiveTouches();

		PointList currentPositions = TouchUtility
				.pointListOfCurrentPositions(multiTouch.getActiveTouches());

		EditPart nodeEditPart = findCardinalTouchedNodeEditPart(currentPositions);
		if (nodeEditPart == null) {
			nodeEditPart = getDiagramEditPart();
		}

		Point position = multiTouch.getPosition().getCopy();
		TouchDispatch.getInstance().translateToEditor(position);

		switch (activeTouches.size()) {
		case 0:
			return;
		case 1:
			try {
				createNodeCommand = new CreateDefaultNodeCommand(
						getDiagramEditPart(), (GraphicalEditPart) nodeEditPart,
						position);
			} catch (IllegalArgumentException e) {
				createNodeCommand = new CreateDefaultNodeCommand(
						getDiagramEditPart(), getDiagramEditPart(), position);
			}

			createNodeCommand.execute();

			break;
		case 2:
			try {

				createNodeCommand = new CreateSecondaryNodeCommand(
						getDiagramEditPart(), (GraphicalEditPart) nodeEditPart,
						position);
			} catch (IllegalArgumentException e) {
				createNodeCommand = new CreateSecondaryNodeCommand(
						getDiagramEditPart(), getDiagramEditPart(), position);
			}

			createNodeCommand.execute();

			GraphicalEditPart createdEditPart = (GraphicalEditPart) createNodeCommand
					.getCreatedEditPart();
			if (createdEditPart != null) {
				OrderBackCommand sendToBackCommand = new OrderBackCommand(
						getDiagramEditPart(), createdEditPart);

				sendToBackCommand.execute();
			}

			break;
		default:
			return;
		}
		
		GraphicalEditPart createdEditPart = (GraphicalEditPart) createNodeCommand.getCreatedEditPart();
		if (createdEditPart != null) {
			SelectAction selectAction = new SelectAction(getDiagramEditPart(), createdEditPart);
			selectAction.execute();
		}

		setCanExecute(false);

	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.unicase.ui.tom.gestures.AbstractGesture#handleSingleTouchRemoved(org.unicase.ui.tom.touches.Touch)
	 */
	@Override
	public void handleSingleTouchRemoved(SingleTouch touch) {
		if (!(touch.getLifeSpan() < CREATION_TOUCH_LIFESPAN)) {
			return;
		}

		MultiTouch multiTouch = touch.getMultiTouch();

		int numberOfTouches = multiTouch.getActiveTouches().size();
		if (numberOfTouches == 0) {
			return;
		}

		EditPart editPart = findCardinalTouchedEditPart(multiTouch
				.getActiveTouches());
		editPart = EditPartUtility.traverseToNodeEditPart(editPart);

		if (editPart != null) {
			return;
		}

		setCreationTouch(touch);
		setCanExecute(true);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.unicase.ui.tom.gestures.Gesture#getMandatoryTouches()
	 */
	public List<MultiTouch> getMandatoryTouches() {
		if (getCreationTouch() == null) {
			return Collections.emptyList();
		} else {
			return Collections
					.singletonList(getCreationTouch().getMultiTouch());
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.unicase.ui.tom.gestures.AbstractGesture#handleSingleTouchChanged(org.unicase.ui.tom.touches.SingleTouch)
	 */
	public void handleSingleTouchChanged(SingleTouch touch) {
		// Do nothing
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.unicase.ui.tom.gestures.AbstractGesture#handleSingleTouchAdded(org.unicase.ui.tom.touches.SingleTouch)
	 */
	public void handleSingleTouchAdded(SingleTouch touch) {
		// Do nothing
	}
}
