/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 * 
 */
package org.unicase.ui.tom.gestures;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.eclipse.draw2d.geometry.Point;
import org.eclipse.gef.EditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.DiagramEditPart;
import org.eclipse.gmf.runtime.emf.type.core.ElementTypeRegistry;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.unicase.ui.tom.TouchDispatch;
import org.unicase.ui.tom.commands.CreateDefaultConnectionCommand;
import org.unicase.ui.tom.commands.CreateDefaultNodeAndConnectionCommand;
import org.unicase.ui.tom.commands.CreateNodeAndConnectionCommand;
import org.unicase.ui.tom.commands.Executable;
import org.unicase.ui.tom.touches.MultiTouch;
import org.unicase.ui.tom.touches.SingleTouch;

/**
 * @author schroech
 *
 */
public class CreateNodeAndConnectionGesture extends CreateGesture {

	private List<MultiTouch> sourceMultiTouches;

	/**
	 * @param dispatch The {@link TouchDispatch} at which the gesture will register for touch events
	 * @param diagramEditPart The {@link DiagramEditPart}
	 */
	public CreateNodeAndConnectionGesture(TouchDispatch dispatch, DiagramEditPart diagramEditPart) {
		super(dispatch, diagramEditPart);
	}

	/** 
	 * {@inheritDoc}
	 * @see org.unicase.ui.tom.gestures.Gesture#execute()
	 */
	public void execute() {
		if (!canExecute()) {
			return;
		}

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
			Point targetPoint = null;
			Point sourcePoint = null;

			targetEditPart = findCardinalTouchedEditPartExcludingDiagram(targetMultiTouch.getActiveTouches());
			sourceEditPart = findCardinalTouchedEditPartExcludingDiagram(sourceMultiTouch.getActiveTouches());

			if (targetEditPart == null
					&& sourceEditPart == null) {
				throw new IllegalStateException();
			}
			
			if (targetEditPart == null) {
				targetEditPart = getDiagramEditPart();
				targetPoint = targetMultiTouch.getPosition();
			}

			if (sourceEditPart == null) {
				sourceEditPart = getDiagramEditPart();
				sourcePoint = sourceMultiTouch.getPosition();
			}
			
			if (sourcePoint != null
					&& targetPoint != null) {
				throw new IllegalStateException();
			}

			if (targetPoint != null) {
				command = new CreateDefaultNodeAndConnectionCommand(
						getDiagramEditPart(),
						sourceEditPart, 
						targetPoint);
			}else if (sourcePoint != null) {
				command = new CreateDefaultNodeAndConnectionCommand(
						getDiagramEditPart(),
						sourcePoint,
						targetEditPart);
			}

			if(targetMultiTouch.getActiveTouches().size() == 2) {
				IElementType type = ElementTypeRegistry.getInstance().getType("org.unicase.classDiagram.ClassSubClasses_4005");
				if (type != null) {
					((CreateNodeAndConnectionCommand)command).setConnectionElementType(type);
				}
			}

			command.execute();

		} finally {
			setCanExecute(false);			
		}
	}

	private List<MultiTouch> findPossibleSourceMultiTouches(MultiTouch targetMultiTouch, Collection<MultiTouch> multiTouches) {
		List<MultiTouch> possibleSourceMultiTouches = new ArrayList<MultiTouch>();

		if (multiTouches.size() > 1) {

			EditPart targetEditPart = findCardinalTouchedEditPart(targetMultiTouch.getActiveTouches());
			targetEditPart = getPrimaryEditPart(targetEditPart);

			if (targetEditPart == null) {
				return possibleSourceMultiTouches;
			}
			if(targetEditPart.equals(getDiagramEditPart())) {
				for (MultiTouch multiTouch : multiTouches) {

					if (multiTouch.equals(targetMultiTouch)) {
						continue;
					}

					EditPart editPart = findCardinalTouchedEditPart(multiTouch.getActiveTouches());
					editPart = getPrimaryEditPart(editPart);

					if (editPart != null
							&& !editPart.equals(getDiagramEditPart())) {
						possibleSourceMultiTouches.add(multiTouch);
					}
				}	
			}else{
				for (MultiTouch multiTouch : multiTouches) {

					if (multiTouch.equals(targetMultiTouch)) {
						continue;
					}

					EditPart editPart = findCardinalTouchedEditPart(multiTouch.getActiveTouches());
					editPart = getPrimaryEditPart(editPart);

					if (editPart != null
							&& editPart.equals(getDiagramEditPart())) {
						possibleSourceMultiTouches.add(multiTouch);
					}
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
	 * {@inheritDoc}
	 * @see org.unicase.ui.tom.gestures.AbstractGesture#handleTouchRemoved(org.unicase.ui.tom.touches.Touch)
	 */
	@SuppressWarnings("unchecked")
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

	/** 
	 * {@inheritDoc}
	 * @see org.unicase.ui.tom.gestures.AbstractGesture#getOptionalTouches()
	 */
	@Override
	public List<MultiTouch> getOptionalTouches() {
		return getSourceMultiTouches();
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

	public void setSourceMultiTouches(List<MultiTouch> sourceMultiTouches) {
		this.sourceMultiTouches = sourceMultiTouches;
	}



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
