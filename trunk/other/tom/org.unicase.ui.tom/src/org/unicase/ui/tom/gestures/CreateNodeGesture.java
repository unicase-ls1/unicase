/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.tom.gestures;

import java.util.Collections;
import java.util.List;

import org.eclipse.draw2d.geometry.Point;
import org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart;
import org.unicase.ui.tom.TouchDispatch;
import org.unicase.ui.tom.actions.SelectAction;
import org.unicase.ui.tom.commands.CreateDefaultNodeCommand;
import org.unicase.ui.tom.commands.CreateNodeCommand;
import org.unicase.ui.tom.commands.CreateSecondaryNodeCommand;
import org.unicase.ui.tom.commands.OrderBackCommand;
import org.unicase.ui.tom.touches.MultiTouch;
import org.unicase.ui.tom.touches.SingleTouch;

/**
 * @author schroech
 * 
 */
public class CreateNodeGesture extends CreateGesture implements Gesture {

	/**
	 * @param dispatcher
	 *            The {@link TouchDispatch} at which the gesture will register
	 *            for touch events
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
		CreateNodeCommand createNodeCommand = null;

		MultiTouch multiTouch = getCreationTouch().getMultiTouch();
		List<SingleTouch> allTouches = multiTouch.getAllTouches();

		Point position = multiTouch.getPosition().getCopy();
		TouchDispatch.getInstance().translateToEditor(position);

		switch (allTouches.size()) {
		case 2:
			createNodeCommand = new CreateDefaultNodeCommand(
					getDiagramEditPart(), getDiagramEditPart(), position);

			createNodeCommand.execute();

			break;
		case 3:
			createNodeCommand = new CreateSecondaryNodeCommand(
					getDiagramEditPart(), getDiagramEditPart(), position);

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
			setCanExecute(false);
			return;
		}

		GraphicalEditPart createdEditPart = (GraphicalEditPart) createNodeCommand
				.getCreatedEditPart();
		if (createdEditPart != null) {
			SelectAction selectAction = new SelectAction(getDiagramEditPart(),
					createdEditPart);
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
//		if (!(touch.getLifeSpan() < CREATION_TOUCH_LIFESPAN)) {
//			return;
//		}

		MultiTouch multiTouch = touch.getMultiTouch();

		int numberOfTouches = multiTouch.getAllTouches().size();
		if (numberOfTouches > 3 || numberOfTouches < 2) {
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
		//do nothing
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.unicase.ui.tom.gestures.AbstractGesture#handleSingleTouchAdded(org.unicase.ui.tom.touches.SingleTouch)
	 */
	public void handleSingleTouchAdded(SingleTouch touch) {
		//do nothing
	}
}
