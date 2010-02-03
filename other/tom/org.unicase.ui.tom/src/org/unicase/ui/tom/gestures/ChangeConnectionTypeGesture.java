/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.tom.gestures;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.draw2d.Connection;
import org.eclipse.draw2d.ConnectionAnchor;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.command.SetCommand;
import org.eclipse.gef.NodeEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ConnectionEditPart;
import org.unicase.model.classes.Association;
import org.unicase.model.classes.AssociationType;
import org.unicase.ui.tom.TouchDispatch;
import org.unicase.ui.tom.commands.SwitchConnectionEndsCommand;
import org.unicase.ui.tom.touches.MultiTouch;
import org.unicase.ui.tom.touches.SingleTouch;
import org.unicase.ui.unicasecommon.diagram.util.EditPartUtility;

/**
 * @author schroech
 *
 */
public class ChangeConnectionTypeGesture extends AbstractContinuousGesture {

	private Map<SingleTouch, Association> candidateTouchObjectMap;
	private SingleTouch changeConnectionTouch;
	private Association associationToChange;
	private int originalAssociationTypeValue = -1;
	private int currentAssociationTypeValue = -1;
	private Point changeConnectionTouchFirstPoint;
	private boolean hasFlipped;

	/**
	 * @param dispatch The dispatch
	 */
	public ChangeConnectionTypeGesture(TouchDispatch dispatch) {
		super(dispatch);
		setCandidateTouchObjectMap(new HashMap<SingleTouch, Association>());
	}

	/*** {@inheritDoc}
	 * @see org.unicase.ui.tom.gestures.AbstractGesture#handleSingleTouchAdded(org.unicase.ui.tom.touches.SingleTouch)
	 */
	@Override
	public void handleSingleTouchAdded(SingleTouch touch) {
		if (!(acceptsAdditionalTouches())) {
			return;
		}

		ConnectionEditPart touchedEditPart = findTouchedConnectionEditPart(touch
				.getPosition());
		if (touchedEditPart == null) {
			return;
		}

		EObject element = EditPartUtility.getElement(touchedEditPart);
		if (!(element instanceof Association)) {
			return;
		}

		getCandidateTouchObjectMap().put(touch, (Association) element);
	}

	/** {@inheritDoc}
	 * @see org.unicase.ui.tom.gestures.AbstractGesture#handleSingleTouchChanged(org.unicase.ui.tom.touches.SingleTouch)
	 */
	@Override
	public void handleSingleTouchChanged(SingleTouch touch) {
		if (isExecuting()) {
			changedDuringExecution(touch);
		} else {
			changedAsideExecution(touch);
		}
	}

	private void changedAsideExecution(SingleTouch touch) {
		Association association = getCandidateTouchObjectMap().get(touch);
		if (association == null) {
			return;
		}

		List<SingleTouch> activeTouches = touch.getMultiTouch()
				.getActiveTouches();
		if (activeTouches.size() != 2) {
			return;
		}

		setChangeConnectionTouch(touch);
		setAssociationToChange(association);

		setCanExecute(true);
	}

	private void changedDuringExecution(SingleTouch touch) {
		if (touch != getChangeConnectionTouch()) {
			return;
		}
		
		NodeEditPart sourceEditPart = (NodeEditPart) getDiagramEditPart()
				.findEditPart(null, getAssociationToChange().getSource());
		Set<ConnectionEditPart> connectionEditParts = EditPartUtility
				.findConnectionEditParts(sourceEditPart, Collections
						.singleton((EObject) getAssociationToChange()));

		if (connectionEditParts.size() != 1) {
			return;
		}

		ConnectionEditPart associationEditPart = null;
		for (ConnectionEditPart connectionEditPart : connectionEditParts) {
			associationEditPart = connectionEditPart;
		}

		if (!hasFlipped()) {
			Object model = associationEditPart.getFigure();
			if (model instanceof Connection) {
				ConnectionAnchor targetAnchor = ((Connection) model)
						.getTargetAnchor();
				Point targetReferencePoint = targetAnchor
						.getReferencePoint();

				ConnectionAnchor sourceAnchor = ((Connection) model)
						.getSourceAnchor();
				Point sourceReferencePoint = sourceAnchor
						.getReferencePoint();

				Point firstPoint = getChangeConnectionTouch().getPath()
						.getFirstPoint();

				if (targetReferencePoint.getDistance(firstPoint) < sourceReferencePoint
						.getDistance(firstPoint)) {
					SwitchConnectionEndsCommand switchCommand = new SwitchConnectionEndsCommand(
							getDiagramEditPart(), associationEditPart);
					switchCommand.execute();
					setHasFlipped(true);
				}
			}
		}

		if (originalAssociationTypeValue == -1) {
			originalAssociationTypeValue = getAssociationToChange()
					.getType().getValue();
			changeConnectionTouchFirstPoint = touch.getPath()
					.getFirstPoint();
			currentAssociationTypeValue = getAssociationToChange()
					.getType().getValue();
		}

		Point lastPoint = touch.getPosition();

		double singleDragDistance = 30;
		double distance = changeConnectionTouchFirstPoint
				.getDistance(lastPoint);
		distance = distance / singleDragDistance;
		distance = Math.floor(distance);

		int multiples = (int) distance;

		int newAssociationTypeValue = (originalAssociationTypeValue + multiples) % 4;

		if (currentAssociationTypeValue == newAssociationTypeValue) {
			return;
		}

		AssociationType associationType = AssociationType
				.get(newAssociationTypeValue);

		EStructuralFeature structuralFeature = getAssociationToChange()
				.eClass().getEStructuralFeature("type");
		SetCommand command = new SetCommand(getDiagramEditPart()
				.getEditingDomain(), associationToChange,
				structuralFeature, associationType);
		getDiagramEditPart().getEditingDomain().getCommandStack().execute(
				command);

		currentAssociationTypeValue = newAssociationTypeValue;
	}

	/*** {@inheritDoc}
	 * @see org.unicase.ui.tom.gestures.AbstractGesture#handleSingleTouchRemoved(org.unicase.ui.tom.touches.SingleTouch)
	 */
	@Override
	public void handleSingleTouchRemoved(SingleTouch touch) {
		if (isExecuting()) {
			if (touch == getChangeConnectionTouch()) {
				setChangeConnectionTouch(null);
				setAssociationToChange(null);
				originalAssociationTypeValue = -1;

				setExecuting(false);
				setHasFlipped(false);
				setCanExecute(false);
			}
		}

	}

	/*** {@inheritDoc}
	 * @see org.unicase.ui.tom.gestures.Gesture#execute()
	 */
	public void execute() {
		setExecuting(true);
	}

	/*** {@inheritDoc}
	 * @see org.unicase.ui.tom.gestures.Gesture#getMandatoryTouches()
	 */
	public List<MultiTouch> getMandatoryTouches() {
		List<MultiTouch> mandatoryTouches = new ArrayList<MultiTouch>();
		if (getChangeConnectionTouch() != null) {
			mandatoryTouches.add(getChangeConnectionTouch().getMultiTouch());
		}
		return mandatoryTouches;
	}

	/*** {@inheritDoc}
	 * @see org.unicase.ui.tom.gestures.AbstractGesture#getOptionalTouches()
	 */
	public List<MultiTouch> getOptionalTouches() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * @param touch The touch triggering the gesture
	 */
	public void setChangeConnectionTouch(SingleTouch touch) {
		this.changeConnectionTouch = touch;
	}

	/**
	 * @return The touch triggering the gesture
	 */
	public SingleTouch getChangeConnectionTouch() {
		return changeConnectionTouch;
	}

	/**
	 * @param candidateTouchObjectMap The map correlating touches possibly belonging to this 
	 * gesture with the editParts they initially touched at the touch down event
	 */
	public void setCandidateTouchObjectMap(
			Map<SingleTouch, Association> candidateTouchObjectMap) {
		this.candidateTouchObjectMap = candidateTouchObjectMap;
	}

	/**
	 * @return The map correlating touches possibly belonging to this 
	 * gesture with the editParts they initially touched at the touch down event
	 */
	public Map<SingleTouch, Association> getCandidateTouchObjectMap() {
		return candidateTouchObjectMap;
	}

	/**
	 * @param associationToChange The association to change
	 */
	public void setAssociationToChange(Association associationToChange) {
		this.associationToChange = associationToChange;
	}

	/**
	 * @return The association to change
	 */
	public Association getAssociationToChange() {
		return associationToChange;
	}

	/**
	 * @param hasFlipped Wether the connection orientation has changed due to the performane of the gesture
	 */
	public void setHasFlipped(boolean hasFlipped) {
		this.hasFlipped = hasFlipped;
	}

	/**
	 * @return Wether the connection orientation has changed due to the performane of the gesture
	 */
	public boolean hasFlipped() {
		return hasFlipped;
	}

}
