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

import org.eclipse.draw2d.geometry.PointList;
import org.eclipse.gef.EditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.DiagramEditPart;
import org.unicase.ui.tom.TouchDispatch;
import org.unicase.ui.tom.Utility;
import org.unicase.ui.tom.commands.CreateDefaultConnectionCommand;
import org.unicase.ui.tom.commands.CreateSecondaryConnectionCommand;
import org.unicase.ui.tom.commands.Executable;
import org.unicase.ui.tom.tools.TouchUtility;
import org.unicase.ui.tom.touches.MultiTouch;
import org.unicase.ui.tom.touches.SingleTouch;
import org.unicase.ui.unicasecommon.diagram.util.EditPartUtility;

/**
 * @author schroech
 *
 */
/**
 * @author schroech
 *
 */
public class CreateConnectionGesture extends CreateGesture {

	/**
	 * @param dispatch The {@link TouchDispatch} at which the gesture will register for touch events
	 * @param diagramEditPart The {@link DiagramEditPart}
	 */
	public CreateConnectionGesture(TouchDispatch dispatch) {
		super(dispatch);
	}

	private List<MultiTouch> sourceMultiTouches;

	/** 
	 * {@inheritDoc}
	 * @see org.unicase.ui.tom.gestures.Gesture#execute()
	 */
	public void execute() {

		try {
			Executable command = null;

			MultiTouch targetMultiTouch = getCreationTouch().getMultiTouch();
			if (targetMultiTouch == null) {
				throw new NullPointerException();
			}

			MultiTouch sourceMultiTouch = findSourceMultiTouch();
			if (sourceMultiTouch == null) {
				throw new NullPointerException();
			}

			if(targetMultiTouch == sourceMultiTouch) {
				throw new IllegalStateException();
			}

			EditPart targetEditPart = null;
			EditPart sourceEditPart = null;

			
			PointList targetPointList = TouchUtility.pointListOfCurrentPositions(targetMultiTouch.getActiveTouches());
			targetEditPart = findCardinalTouchedNodeEditPart(targetPointList);
			
			PointList sourcePointList = TouchUtility.pointListOfCurrentPositions(sourceMultiTouch.getActiveTouches());
			sourceEditPart = findCardinalTouchedNodeEditPart(sourcePointList);
			
			if (targetEditPart == null
					&& sourceEditPart == null) {
				throw new IllegalStateException();
			}

			if (targetMultiTouch.getActiveTouches().size() == 1) {
				command = new CreateDefaultConnectionCommand(
						getDiagramEditPart(),
						sourceEditPart, 
						targetEditPart);	
			}else if (targetMultiTouch.getActiveTouches().size() == 2) {
				command = new CreateSecondaryConnectionCommand(
						getDiagramEditPart(),
						sourceEditPart, 
						targetEditPart);
			}
						
			command.execute();

		} finally {
			setCanExecute(false);			
		}
		
		Utility.beep(1);
	}

	/** 
	 * {@inheritDoc}
	 * @see org.unicase.ui.tom.gestures.Gesture#getMandatoryTouches()
	 */
	public List<MultiTouch> getMandatoryTouches() {
		List<MultiTouch> mandatoryTouches = new ArrayList<MultiTouch>();

		mandatoryTouches.add(getCreationTouch().getMultiTouch());
		if (getSourceMultiTouches().size() < 2) {
			mandatoryTouches.addAll(getSourceMultiTouches());
		}

		return mandatoryTouches; 
	}

	/** 
	 * {@inheritDoc}
	 * @see org.unicase.ui.tom.gestures.AbstractGesture#handleTouchRemoved(org.unicase.ui.tom.touches.Touch)
	 */
	@SuppressWarnings("unchecked")
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

		PointList targetPointList = TouchUtility.pointListOfCurrentPositions(multiTouch.getActiveTouches());
		EditPart targetEditPart = findCardinalTouchedNodeEditPart(targetPointList);
		
		targetEditPart = EditPartUtility.traverseToNodeEditPart(targetEditPart);
		if (targetEditPart == null) {
			return;
		}

		List<MultiTouch> activeMultiTouches = TouchDispatch.getInstance().getActiveMultiTouches();
		if (activeMultiTouches.size() < 2) {
			return;
		}

		List<MultiTouch> possibleSourceMultiTouches = findPossibleSourceMultiTouches(touch.getMultiTouch(), activeMultiTouches);
		if (possibleSourceMultiTouches.size() == 0) {
			return;
		}

		setSourceMultiTouches(possibleSourceMultiTouches);

		if (possibleSourceMultiTouches.size() < 2) {
			setOptionalTouches(Collections.EMPTY_LIST);
		}else{
			setOptionalTouches(possibleSourceMultiTouches);
		}


		setCreationTouch(touch);
		setCanExecute(true);
	}

	@SuppressWarnings("unchecked")
	private List<MultiTouch> findPossibleSourceMultiTouches(MultiTouch targetMultiTouch, Collection<MultiTouch> multiTouches) {
		List<MultiTouch> possibleSourceMultiTouches = new ArrayList<MultiTouch>();

		if (multiTouches.size() > 1) {
			
			PointList targetPointList = TouchUtility.pointListOfCurrentPositions(targetMultiTouch.getActiveTouches());
			EditPart targetEditPart = findCardinalTouchedNodeEditPart(targetPointList);

			if (targetEditPart == null) {
				return Collections.EMPTY_LIST;
			}

			for (MultiTouch multiTouch : multiTouches) {

				if (multiTouch.equals(targetMultiTouch)) {
					continue;
				}

				PointList pointList = TouchUtility.pointListOfCurrentPositions(multiTouch.getActiveTouches());
				EditPart editPart = findCardinalTouchedNodeEditPart(targetPointList);

				if (editPart != null) {
					possibleSourceMultiTouches.add(multiTouch);
				}
			}	
		}

		return possibleSourceMultiTouches;
	}

	private MultiTouch findSourceMultiTouch() {
		MultiTouch sourceMultiTouch = null;

		if (getSourceMultiTouches().size() == 0) {
			return null;	
		}else {
			sourceMultiTouch = getSourceMultiTouches().get(0);	

			for (MultiTouch possibleSourceMultiTouch : getSourceMultiTouches()) {
				if (possibleSourceMultiTouch.getTouchDownDate()
						.compareTo(sourceMultiTouch.getTouchDownDate()) < 1) {
					sourceMultiTouch = possibleSourceMultiTouch;	
				}
			}
		}

		return sourceMultiTouch;
	}

	/**
	 * @param sourceMultiTouches
	 */
	public void setSourceMultiTouches(List<MultiTouch> sourceMultiTouches) {
		this.sourceMultiTouches = sourceMultiTouches;
	}

	/**
	 * @return
	 */
	public List<MultiTouch> getSourceMultiTouches() {
		return sourceMultiTouches;
	}

	/** 
	* {@inheritDoc}
	* @see org.unicase.ui.tom.gestures.AbstractGesture#handleSingleTouchAdded(org.unicase.ui.tom.touches.SingleTouch)
	*/
	public void handleSingleTouchAdded(SingleTouch touch) {
		// Do nothing
	}

	/** 
	* {@inheritDoc}
	* @see org.unicase.ui.tom.gestures.AbstractGesture#handleSingleTouchChanged(org.unicase.ui.tom.touches.SingleTouch)
	*/
	public void handleSingleTouchChanged(SingleTouch touch) {
		// Do nothing
	} 

}
