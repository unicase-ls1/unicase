/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.tom.gestures;

import java.util.Collections;
import java.util.List;

import org.eclipse.gef.EditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.DiagramEditPart;
import org.unicase.ui.tom.TouchDispatch;
import org.unicase.ui.tom.commands.AbstractCommand;
import org.unicase.ui.tom.commands.CreateDefaultNodeCommand;
import org.unicase.ui.tom.commands.PromptAndCreateNodeCommand;
import org.unicase.ui.tom.touches.MultiTouch;
import org.unicase.ui.tom.touches.SingleTouch;
import org.unicase.ui.tom.touches.Touch;

/**
 * @author schroech
 *
 */
public class CreateNodeGesture extends CreateGesture implements Gesture {

	/**
	 * @param dispatcher The {@link TouchDispatch} at which the gesture will register for touch events
	 * @param diagramEditPart The {@link DiagramEditPart}
	 */
	public CreateNodeGesture(TouchDispatch dispatcher,
			DiagramEditPart diagramEditPart) {
		super(dispatcher,diagramEditPart);
	}

	/** 
	 * {@inheritDoc}
	 * @see org.unicase.ui.tom.gestures.AbstractGesture#execute()
	 */
	public void execute() {
		if (!canExecute()) {
			return;
		}
		
		AbstractCommand command;

		MultiTouch multiTouch = getCreationTouch().getMultiTouch();
		List<Touch> activeTouches = multiTouch.getActiveTouches();
		
		switch (activeTouches.size()) {
		case 0:
			return;
		case 1:
			command = new CreateDefaultNodeCommand(
					getDiagramEditPart(),
					multiTouch.getPosition());
			break;
		case 2:
			command = new PromptAndCreateNodeCommand(
					getDiagramEditPart(),
					multiTouch.getPosition());
			break;
		default:
			return;
		}

		command.execute();

		setCanExecute(false);

	}

	/** 
	 * {@inheritDoc}
	 * @see org.unicase.ui.tom.gestures.AbstractGesture#handleSingleTouchRemoved(org.unicase.ui.tom.touches.Touch)
	 */
	@Override
	public void handleSingleTouchRemoved(SingleTouch touch) {
		//Check containment first. The touch is removed from the stationary touches in super.
		boolean contains = getStationaryTouches().contains(touch);

		super.handleSingleTouchRemoved(touch);

		if (!(acceptsAdditionalTouches())) {
			return;
		}

		if(contains) {
			if (touch.getLifeSpan() < CREATION_TOUCH_LIFESPAN) {
				setCreationTouch(touch);
				setCanExecute(true);	
			}				
		}
	}

	/** 
	 * {@inheritDoc}
	 * @see org.unicase.ui.tom.gestures.AbstractGesture#handleSingleTouchAdded(org.unicase.ui.tom.touches.Touch)
	 */
	@Override
	public void handleSingleTouchAdded(SingleTouch touch) {
		super.handleSingleTouchAdded(touch);

		if (!acceptsAdditionalTouches()) {
			return;
		}

		EditPart foundEditPart = findTouchedEditPartExcludingDiagram(touch);
		if (foundEditPart == null) {
			getStationaryTouches().add(touch);
		}
	}

	/** 
	* {@inheritDoc}
	* @see org.unicase.ui.tom.gestures.Gesture#getMandatoryTouches()
	*/
	public List<MultiTouch> getMandatoryTouches() {
		if (getCreationTouch() == null) {
			return Collections.emptyList();
		}else{
			return Collections.singletonList(getCreationTouch().getMultiTouch());
		}
	}
}
