/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.tom.gestures;

import java.util.List;

import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.PointList;
import org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.INodeEditPart;
import org.unicase.ui.tom.TouchDispatch;
import org.unicase.ui.tom.actions.SelectAction;
import org.unicase.ui.tom.commands.CreateDefaultNodeCommand;
import org.unicase.ui.tom.commands.CreateNodeCommand;
import org.unicase.ui.tom.commands.CreateSecondaryNodeCommand;
import org.unicase.ui.tom.tools.TouchUtility;
import org.unicase.ui.tom.touches.MultiTouch;
import org.unicase.ui.tom.touches.SingleTouch;

/**
 * @author schroech
 *
 */
public class CreateCompartmentNodeGesture extends CreateNodeGesture {

	private GraphicalEditPart containingNodeEditPart;
	
	/**
	 * @param dispatch The {@link TouchDispatch} at which the gesture will register for touch events
	 */
	public CreateCompartmentNodeGesture(TouchDispatch dispatch) {
		super(dispatch);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.unicase.ui.tom.gestures.AbstractGesture#handleSingleTouchRemoved(org.unicase.ui.tom.touches.Touch)
	 */
	@Override
	public void handleSingleTouchRemoved(SingleTouch touch) {
		if (!(touch.getLifeSpan() < CREATION_TOUCH_LIFESPAN)) {
			setCreationTouch(null);
			setCanExecute(false);
			return;
		}

		MultiTouch multiTouch = touch.getMultiTouch();

		int numberOfTouches = multiTouch.getAllTouches().size();
		if (numberOfTouches > 3 || numberOfTouches < 2) {
			return;
		}

		PointList pointList = TouchUtility.pointListOfCurrentPositions(multiTouch.getAllTouches());
		INodeEditPart editPart = findCardinalTouchedNodeEditPart(pointList);
		if (editPart == null) {
			return;
		}

		setContainingNodeEditPart((GraphicalEditPart) editPart);
		setCreationTouch(touch);
		setCanExecute(true);
	}
	
	/**
	 * {@inheritDoc}
	 * 
	 * @see org.unicase.ui.tom.gestures.AbstractGesture#execute()
	 */
	@Override
	public void execute() {
		CreateNodeCommand createNodeCommand;

		MultiTouch multiTouch = getCreationTouch().getMultiTouch();
		List<SingleTouch> activeTouches = multiTouch.getAllTouches();

		Point position = multiTouch.getPosition().getCopy();
		TouchDispatch.getInstance().translateToEditor(position);

		switch (activeTouches.size()) {
		case 2:
			createNodeCommand = new CreateDefaultNodeCommand(
					getDiagramEditPart(), getContainingNodeEditPart(), position);

			createNodeCommand.execute();

			break;
		case 3:
			createNodeCommand = new CreateSecondaryNodeCommand(
					getDiagramEditPart(), getContainingNodeEditPart(), position);

			createNodeCommand.execute();
			
			break;
		default:
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
	 * @param containingNodeEditPart The {@link GraphicalEditPart} containing the result of this gesture 
	 */
	public void setContainingNodeEditPart(GraphicalEditPart containingNodeEditPart) {
		this.containingNodeEditPart = containingNodeEditPart;
	}

	/**
	 * @return  The {@link GraphicalEditPart} containing the result of this gesture
	 */
	public GraphicalEditPart getContainingNodeEditPart() {
		return containingNodeEditPart;
	}

}
