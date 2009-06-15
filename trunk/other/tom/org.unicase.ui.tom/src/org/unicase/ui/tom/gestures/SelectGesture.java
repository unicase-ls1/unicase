/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.tom.gestures;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.gef.EditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.DiagramEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart;
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
	 * @param dispatch The {@link TouchDispatch} at which the gesture will register for touch events
	 * @param diagramEditPart The {@link DiagramEditPart}
	 */
	public SelectGesture(TouchDispatch dispatch) {
		super(dispatch);
	}

	/** 
	 * {@inheritDoc}
	 * @see org.unicase.ui.tom.gestures.MomentaryGesture#finish()
	 */
	public void execute() {
		selectionAction.execute();
		setCanExecute(false);
	}


	/** 
	 * {@inheritDoc}
	 * @see org.unicase.ui.tom.gestures.AbstractGesture#handleSingleTouchAdded(org.unicase.ui.tom.touches.SingleTouch)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void handleSingleTouchAdded(SingleTouch touch) {
		if (!(acceptsAdditionalTouches())) {
			return;
		}

		EditPart foundEditPart = findTouchedEditPartExcludingDiagram(touch);
		GraphicalEditPart primaryEditPart = getPrimaryEditPart(foundEditPart);

		List selectedEditParts = getDiagramEditPart().getViewer().getSelectedEditParts();

		List<SingleTouch> activeTouches = getDispatch().getActiveSingleTouches();
		int numberOfActiveTouches = activeTouches.size();

		if (numberOfActiveTouches == 1) {
			if (primaryEditPart != null
					&& selectedEditParts.contains(primaryEditPart)) {
				return;
			}

			CompoundAction compoundAction = new CompoundAction();
			compoundAction.add(new DeselectAllAction(getDiagramEditPart()));

			if (primaryEditPart != null) {
				compoundAction.add(new SelectAction(getDiagramEditPart(), primaryEditPart));
			}

			setSelectionTouch(touch.getMultiTouch());
			setSelectionAction(compoundAction);
			setCanExecute(true);
			return;
		}else{
			int numberOfSelectedEditPartTouches = 0;
			for (Touch activeTouch : activeTouches) {
				EditPart activeTouchEditPart = findTouchedEditPartExcludingDiagram(activeTouch);
				activeTouchEditPart = getPrimaryEditPart(activeTouchEditPart);

				if (selectedEditParts.contains(activeTouchEditPart)) {
					numberOfSelectedEditPartTouches++;
				}
			}

			if (numberOfSelectedEditPartTouches > 0) {
				if (primaryEditPart == null) {
					return;
				}
				if (selectedEditParts.contains(primaryEditPart)) {
					setSelectionAction(new DeselectAction(getDiagramEditPart(), primaryEditPart));
				}else{
					setSelectionAction(new AppendSelectionAction(getDiagramEditPart(), primaryEditPart));
				}

				setSelectionTouch(touch.getMultiTouch());
				setCanExecute(true);
			}else{
				DeselectAllAction deselectAllAction = new DeselectAllAction(getDiagramEditPart());
				deselectAllAction.execute();

				if (primaryEditPart != null) {
					setSelectionAction(new SelectAction(getDiagramEditPart(), primaryEditPart));
					setSelectionTouch(touch.getMultiTouch());
					setCanExecute(true);					
				}
			}
		}
	}

	/** 
	 * {@inheritDoc}
	 * @see org.unicase.ui.tom.gestures.AbstractGesture#handleSingleTouchChanged(org.unicase.ui.tom.touches.SingleTouch)
	 */
	@Override
	public void handleSingleTouchChanged(SingleTouch touch) {
		//We don't care
	}

	/** 
	 * {@inheritDoc}
	 * @see org.unicase.ui.tom.gestures.AbstractGesture#handleSingleTouchRemoved(org.unicase.ui.tom.touches.SingleTouch)
	 */
	@Override
	public void handleSingleTouchRemoved(SingleTouch touch) {
		//We don't care
	}

	/** 
	 * {@inheritDoc}
	 * @see org.unicase.ui.tom.gestures.AbstractMomentaryGesture#reset()
	 */
	@Override
	public void reset() {
		setSelectionAction(null);
	}

	/**
	 * @param selectionAction The selection action
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
	* @see org.unicase.ui.tom.gestures.Gesture#getMandatoryTouches()
	*/
	public List<MultiTouch> getMandatoryTouches() {
		List<MultiTouch> mandatoryTouches = new ArrayList<MultiTouch>();
		mandatoryTouches.add(getSelectionTouch());
		return mandatoryTouches;
	}

	public void setSelectionTouch(MultiTouch selectionTouch) {
		this.selectionTouch = selectionTouch;
	}

	public MultiTouch getSelectionTouch() {
		return selectionTouch;
	}

}
