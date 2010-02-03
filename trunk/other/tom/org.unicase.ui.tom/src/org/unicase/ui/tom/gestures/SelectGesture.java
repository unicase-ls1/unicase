/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.tom.gestures;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.gef.EditPart;
import org.unicase.ui.tom.TouchDispatch;
import org.unicase.ui.tom.actions.Action;
import org.unicase.ui.tom.actions.AppendSelectionAction;
import org.unicase.ui.tom.actions.CompoundAction;
import org.unicase.ui.tom.actions.DeselectAction;
import org.unicase.ui.tom.actions.DeselectAllAction;
import org.unicase.ui.tom.actions.SelectAction;
import org.unicase.ui.tom.touches.MultiTouch;
import org.unicase.ui.tom.touches.SingleTouch;
import org.unicase.ui.tom.touches.Touch;

/**
 * @author schroech
 * 
 */
public class SelectGesture extends AbstractGesture implements Gesture {

	private Action selectionAction;
	private MultiTouch selectionTouch;

	/**
	 * Default constructor.
	 * 
	 * @param dispatch
	 *            The {@link TouchDispatch} at which the gesture will register
	 *            for touch events
	 */
	public SelectGesture(TouchDispatch dispatch) {
		super(dispatch);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.unicase.ui.tom.gestures.MomentaryGesture#finish()
	 */
	public void execute() {
		selectionAction.execute();
		setCanExecute(false);
	}

//	/**
//	 * {@inheritDoc}
//	 * 
//	 * @see org.unicase.ui.tom.gestures.AbstractGesture#findTouchedEditPartExcluding(org.unicase.ui.tom.touches.Touch,
//	 *      java.util.Collection)
//	 */
//	@SuppressWarnings("unchecked")
//	@Override
//	public GraphicalEditPart findTouchedEditPart(Point position) {
//		List children = getNodeLayer().getChildren();
//		List nodes = null;
//		for (Object child : children) {
//			if (child instanceof BorderItemsAwareFreeFormLayer) {
//				nodes = ((BorderItemsAwareFreeFormLayer) child).getChildren();
//			}
//		}
//
//		for (Object node : nodes) {
//			if (node instanceof Figure) {
//				if (TouchUtility.shapeContainsPoint((Figure) node, position)) {
//					EditPart editPart = getEditPartForFigure((Figure) node);
//					if (editPart instanceof GraphicalEditPart) {
//						return (GraphicalEditPart) editPart;	
//					}
//					
//				}
//			}
//		}
//		
//		EditPart touchedEditPart;
//		touchedEditPart = super.findTouchedEditPart(position);
//		if (touchedEditPart  instanceof GraphicalEditPart) {
//			return (GraphicalEditPart) touchedEditPart;	
//		}
//		
//		return null;
//	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.unicase.ui.tom.gestures.AbstractGesture#handleSingleTouchAdded(org.unicase.ui.tom.touches.SingleTouch)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void handleSingleTouchAdded(SingleTouch touch) {
		if (touch.getMultiTouch().getActiveTouches().size() > 1) {
			return;
		}

		org.eclipse.gef.GraphicalEditPart selectableEditPart;

		selectableEditPart = findTouchedEditPart(touch.getPosition());

		List selectedEditParts = getDiagramEditPart().getViewer()
				.getSelectedEditParts();

		List<SingleTouch> activeTouches = getDispatch()
				.getActiveSingleTouches();
		int numberOfActiveTouches = activeTouches.size();

		if (numberOfActiveTouches == 1) {
			if (selectableEditPart != null
					&& selectedEditParts.contains(selectableEditPart)) {
				return;
			}

			CompoundAction compoundAction = new CompoundAction();
//			compoundAction.add(new DeselectAllAction(getDiagramEditPart()));

			if (selectableEditPart != null) {
				compoundAction.add(new SelectAction(getDiagramEditPart(),
						selectableEditPart));
			}

			setSelectionTouch(touch.getMultiTouch());
			setSelectionAction(compoundAction);
			setCanExecute(true);
			return;
		} else {
			int numberOfSelectedEditPartTouches = 0;
			for (Touch activeTouch : activeTouches) {
				EditPart activeTouchEditPart = findTouchedNodeEditPart(activeTouch
						.getPosition());

				if (selectedEditParts.contains(activeTouchEditPart)) {
					numberOfSelectedEditPartTouches++;
				}
			}

			if (numberOfSelectedEditPartTouches > 0) {
				if (selectableEditPart == null) {
					return;
				}
				if (selectedEditParts.contains(selectableEditPart)) {
					setSelectionAction(new DeselectAction(getDiagramEditPart(),
							selectableEditPart));
				} else {
					setSelectionAction(new AppendSelectionAction(
							getDiagramEditPart(), selectableEditPart));
				}

				setSelectionTouch(touch.getMultiTouch());
				setCanExecute(true);
			} else {
				DeselectAllAction deselectAllAction = new DeselectAllAction(
						getDiagramEditPart());
				deselectAllAction.execute();

				if (selectableEditPart != null) {
					setSelectionAction(new SelectAction(getDiagramEditPart(),
							selectableEditPart));
					setSelectionTouch(touch.getMultiTouch());
					setCanExecute(true);
				}
			}
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.unicase.ui.tom.gestures.AbstractGesture#handleSingleTouchChanged(org.unicase.ui.tom.touches.SingleTouch)
	 */
	@Override
	public void handleSingleTouchChanged(SingleTouch touch) {
		// We don't care
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.unicase.ui.tom.gestures.AbstractGesture#handleSingleTouchRemoved(org.unicase.ui.tom.touches.SingleTouch)
	 */
	@Override
	public void handleSingleTouchRemoved(SingleTouch touch) {
		// We don't care
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.unicase.ui.tom.gestures.AbstractMomentaryGesture#reset()
	 */
	@Override
	public void reset() {
		setSelectionAction(null);
	}

	/**
	 * @param selectionAction
	 *            The selection action
	 */
	public void setSelectionAction(Action selectionAction) {
		this.selectionAction = selectionAction;
	}

	/**
	 * @return The selection action
	 */
	public Action getSelectionAction() {
		return selectionAction;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.unicase.ui.tom.gestures.Gesture#getMandatoryTouches()
	 */
	public List<MultiTouch> getMandatoryTouches() {
		List<MultiTouch> mandatoryTouches = new ArrayList<MultiTouch>();
		mandatoryTouches.add(getSelectionTouch());
		return mandatoryTouches;
	}

	/**
	 * @param selectionTouch The touch triggering this gesture
	 */
	public void setSelectionTouch(MultiTouch selectionTouch) {
		this.selectionTouch = selectionTouch;
	}

	/**
	 * @return The touch triggering this gesture
	 */
	public MultiTouch getSelectionTouch() {
		return selectionTouch;
	}

}
