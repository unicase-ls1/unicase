/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.tom.gestures;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.draw2d.geometry.Point;
import org.eclipse.gef.ConnectionEditPart;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.NodeEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.CompartmentEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.INodeEditPart;
import org.unicase.ui.tom.TouchDispatch;
import org.unicase.ui.tom.operations.AltMoveNodeOperation;
import org.unicase.ui.tom.tools.TouchConstants;
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
public class MoveNodeGesture extends AbstractMoveGesture {

	private Map<SingleTouch, AltMoveNodeOperation> touchOperationMap = new HashMap<SingleTouch, AltMoveNodeOperation>();

	/**
	 * Default constructor.
	 * 
	 * @param dispatch
	 *            The {@link TouchDispatch} at which the gesture will register
	 *            for touch events
	 */
	public MoveNodeGesture(TouchDispatch dispatch) {
		super(dispatch);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.unicase.ui.tom.gestures.Gesture#execute()
	 */
	@SuppressWarnings("unchecked")
	public void execute() {
		List<INodeEditPart> editPartsToMove;

		List selectedEditParts = getDiagramEditPart().getViewer()
				.getSelectedEditParts();
		
		List <INodeEditPart>selectedNodeEditParts = new ArrayList<INodeEditPart>();
		for (Object object : selectedEditParts) {
			INodeEditPart nodeEditPart = null;
			if (object instanceof ConnectionEditPart) {
				continue;
			}
		
			if (object instanceof CompartmentEditPart) {
				nodeEditPart = EditPartUtility.traverseToNodeEditPart((EditPart) object);
				if (nodeEditPart == null) {
					continue;
				}
			}
			
			selectedNodeEditParts.add(nodeEditPart);
		}
		
		if (selectedEditParts.contains(getMoveEditPart())) {
			editPartsToMove = new ArrayList<INodeEditPart>();
			for (Object object : selectedEditParts) {
				if (object instanceof INodeEditPart) {
					editPartsToMove.add((INodeEditPart) object);
				}
			}
		} else {
			editPartsToMove = Collections
					.singletonList((INodeEditPart) getMoveEditPart());
		}

		AltMoveNodeOperation moveNodeOperation = new AltMoveNodeOperation(
				getDiagramEditPart(), editPartsToMove);

		touchOperationMap.put(getMoveTouch(), moveNodeOperation);
		Point firstPoint = getMoveTouch().getPath().getFirstPoint().getCopy();
		moveNodeOperation.prepare(firstPoint);
		
		setMoveEditPart(null);
		setMoveTouch(null);
		setCanExecute(false);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.unicase.ui.tom.gestures.AbstractGesture#handleSingleTouchAdded(org.unicase.ui.tom.touches.SingleTouch)
	 */
	@Override
	public void handleSingleTouchAdded(SingleTouch touch) {
		NodeEditPart touchedEditPart = findTouchedNodeEditPart(touch
				.getPosition());

		if (touchedEditPart == null) {
			return;
		}

		Collection<AltMoveNodeOperation> operations = touchOperationMap
				.values();
		for (AltMoveNodeOperation altMoveNodeOperation : operations) {
			if (altMoveNodeOperation.getTargetEditParts().contains(
					touchedEditPart)) {
				return;
			}
		}

		getCandidateTouchEditPartMap().put(touch, touchedEditPart);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.unicase.ui.tom.gestures.AbstractGesture#handleSingleTouchChanged(org.unicase.ui.tom.touches.SingleTouch)
	 */
	@Override
	public void handleSingleTouchChanged(SingleTouch touch) {
		if (touchOperationMap.containsKey(touch)) {
			AltMoveNodeOperation operation = touchOperationMap.get(touch);
			Point position = touch.getPosition().getCopy();
			operation.update(position);
			return;
		}

		if (!getCandidateTouchEditPartMap().containsKey(touch)) {
			return;
		}

		if (!touchMoved(touch, TouchConstants.TOUCH_MOVEMENT_THRESHOLD)) {
			return;
		}

		EditPart editPart = getCandidateTouchEditPartMap().get(touch);

		setMoveEditPart(editPart);
		setMoveTouch(touch);

		getCandidateTouchEditPartMap().remove(touch);

		setCanExecute(true);
	}

	/*** {@inheritDoc}
	 * @see org.unicase.ui.tom.gestures.AbstractMoveGesture#reset()
	 */
	@Override
	public void reset() {
		super.reset();
		touchOperationMap.clear();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.unicase.ui.tom.gestures.AbstractGesture#handleSingleTouchRemoved(org.unicase.ui.tom.touches.SingleTouch)
	 */
	@Override
	public void handleSingleTouchRemoved(SingleTouch touch) {
		if (touchOperationMap.containsKey(touch)) {
			AltMoveNodeOperation moveNodeOperation = touchOperationMap
					.get(touch);
			moveNodeOperation.finish();
			touchOperationMap.remove(touch);
		}

		if (touch == getMoveTouch()) {
			setMoveTouch(null);
		}

		getCandidateTouchEditPartMap().remove(touch);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.unicase.ui.tom.gestures.Gesture#getMandatoryTouches()
	 */
	public List<MultiTouch> getMandatoryTouches() {

		List<MultiTouch> mandatoryTouches = new ArrayList<MultiTouch>();
		if (getMoveTouch() != null) {
			mandatoryTouches.add(getMoveTouch().getMultiTouch());
		}

//		for (SingleTouch touch : touchOperationMap.keySet()) {
//			mandatoryTouches.add(touch.getMultiTouch());
//		}

		return mandatoryTouches;
	}

}
