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
import org.eclipse.gmf.runtime.diagram.ui.figures.BorderItemsAwareFreeFormLayer;
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
	 * @param dispatch The {@link TouchDispatch} at which the gesture will register for touch events
	 * @param diagramEditPart The {@link DiagramEditPart}
	 */
	public MoveNodeGesture(TouchDispatch dispatch, DiagramEditPart diagramEditPart) {
		super(dispatch, diagramEditPart);
	}

	/** 
	 * {@inheritDoc}
	 * @see org.unicase.ui.tom.gestures.Gesture#execute()
	 */
	public void execute() {
		if (isExecuting()) {
			return;
		}
		
		setAcceptsAdditionalTouches(false);
		setExecuting(true);
		
		Point firstPoint = getMoveTouch().getPath().getFirstPoint();
		
		EditPart editPart = findTouchedEditPartExcluding(Collections.EMPTY_LIST, firstPoint);
		GraphicalEditPart primaryEditPart = getPrimaryEditPart(editPart);

		setMoveNodeOperation(new MoveNodeOperation(getDiagramEditPart(), primaryEditPart));
		
		getMoveNodeOperation().prepare(firstPoint);	 
	}

	/** 
	 * {@inheritDoc}
	 * @see org.unicase.ui.tom.gestures.AbstractGesture#findTouchedEditPartExcluding(org.unicase.ui.tom.touches.Touch, java.util.Collection)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public EditPart findTouchedEditPartExcluding(Touch touch, Collection exclusions) {
		EditPart touchedEditPart = super.findTouchedEditPartExcluding(
				touch, 
				exclusions);

		if (touchedEditPart != null) {
			return touchedEditPart;
		}

		List children = getNodeLayer().getChildren();
		List nodes = null;
		for (Object child: children) {
			if (child instanceof BorderItemsAwareFreeFormLayer) {
				nodes = ((BorderItemsAwareFreeFormLayer)child).getChildren();
			}
		}

		for (Object node : nodes) {
			if (node instanceof Figure) {
				if (TouchUtility.shapeContainsPoint(
						(Figure) node,
						touch.getPosition())) {
					EditPart editPart = findFigureEditPart((Figure) node);
					return editPart;
				}
			}
		}

		return null;
	}


	/** 
	 * {@inheritDoc}
	 * @see org.unicase.ui.tom.gestures.AbstractGesture#handleSingleTouchAdded(org.unicase.ui.tom.touches.SingleTouch)
	 */
	@Override
	public void handleSingleTouchAdded(SingleTouch touch) {		
		if (!(acceptsAdditionalTouches())) {
			return;
		}

		EditPart touchedEditPart = findTouchedEditPartExcludingDiagram(touch);
		touchedEditPart = getPrimaryEditPart(touchedEditPart);

		if (touchedEditPart != null) {
			getCandidateTouches().add(touch);
		}
	}

	/** 
	 * {@inheritDoc}
	 * @see org.unicase.ui.tom.gestures.AbstractGesture#handleSingleTouchChanged(org.unicase.ui.tom.touches.SingleTouch)
	 */
	@Override
	public void handleSingleTouchChanged(SingleTouch touch) {
		if (isExecuting()) {
			getMoveNodeOperation().update(touch.getPosition());
			return;
		}

		if (getCandidateTouches().contains(touch)) {
			if (touchMoved(touch, TouchConstants.TOUCH_MOVEMENT_THRESHOLD)) {
				setMoveTouch(touch);
				setCanExecute(true);
			}
		}
	}

	/** 
	 * {@inheritDoc}
	 * @see org.unicase.ui.tom.gestures.AbstractGesture#handleSingleTouchRemoved(org.unicase.ui.tom.touches.SingleTouch)
	 */
	@Override
	public void handleSingleTouchRemoved(SingleTouch touch) {
		if (touch == getMoveTouch()) {
			getMoveNodeOperation().finish();
			
			setCanExecute(false);
			setExecuting(false);
		}
	}

	/**
	 * @param moveCommand The {@link MoveNodeOperation}
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
	* @see org.unicase.ui.tom.gestures.Gesture#getMandatoryTouches()
	*/
	public List<MultiTouch> getMandatoryTouches() {
		List<MultiTouch> mandatoryTouches = new ArrayList<MultiTouch>();
		mandatoryTouches.add(getMoveTouch().getMultiTouch());
		return mandatoryTouches;
	}

}
