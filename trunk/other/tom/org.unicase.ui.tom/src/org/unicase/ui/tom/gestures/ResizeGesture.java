/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.tom.gestures;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.gmf.runtime.diagram.ui.editparts.INodeEditPart;
import org.unicase.ui.tom.TouchDispatch;
import org.unicase.ui.tom.operations.ResizeOperation;
import org.unicase.ui.tom.tools.MapUtility;
import org.unicase.ui.tom.tools.TouchConstants;
import org.unicase.ui.tom.touches.MultiTouch;
import org.unicase.ui.tom.touches.SingleTouch;

/**
 * @author schroech
 *
 */
public class ResizeGesture extends AbstractContinuousGesture {

	private ResizeOperation operation;
	
	/**
	 * Default constructor.
	 * 
	 * @param dispatch The {@link TouchDispatch} at which the gesture will register for touch events
	 */
	public ResizeGesture(TouchDispatch dispatch) {
		super(dispatch);
	}

	private INodeEditPart targetEditPart;



	private final Map<INodeEditPart, Set<SingleTouch>> editPartTouchesMap = new HashMap<INodeEditPart, Set<SingleTouch>>();



	private SingleTouch firstTouch;



	private SingleTouch secondTouch;


	/** 
	* {@inheritDoc}
	* @see org.unicase.ui.tom.gestures.AbstractGesture#handleSingleTouchAdded(org.unicase.ui.tom.touches.SingleTouch)
	*/
	@Override
	public void handleSingleTouchAdded(SingleTouch touch) {
		INodeEditPart nodeEditPart = findTouchedNodeEditPart(touch
				.getPosition());
		if (nodeEditPart == null) {
			return;
		}

		Set<SingleTouch> set = editPartTouchesMap.get(nodeEditPart);
		if (set == null) {
			set = new HashSet<SingleTouch>();
			editPartTouchesMap.put(nodeEditPart, set);
		}
		set.add(touch);
	}

	/** 
	* {@inheritDoc}
	* @see org.unicase.ui.tom.gestures.AbstractGesture#handleSingleTouchChanged(org.unicase.ui.tom.touches.SingleTouch)
	*/
	@Override
	public void handleSingleTouchChanged(SingleTouch touch) {

		if (!isExecuting()) {

			boolean touchMoved = touchMoved(touch,
					TouchConstants.TOUCH_MOVEMENT_THRESHOLD);
			if (!touchMoved) {
				return;
			}

			Set<INodeEditPart> nodesForTouch = MapUtility.getKeysForObject(
					editPartTouchesMap, touch);
			if (nodesForTouch.size() != 1) {
				return;
			}

			INodeEditPart nodeEditPart = null;
			for (INodeEditPart currentEditPart : nodesForTouch) {
				nodeEditPart = currentEditPart;
			}

			Set<SingleTouch> set = editPartTouchesMap.get(nodeEditPart);
			if (set.size() != 2) {
				return;
			}

			Object[] array = set.toArray();
			firstTouch = (SingleTouch) array[0];
			secondTouch = (SingleTouch) array[1];

			setTargetEditPart(nodeEditPart);

			setCanExecute(true);

		} else {
			getOperation().update(firstTouch.getPosition(), secondTouch.getPosition());
		}
	}

	/** 
	* {@inheritDoc}
	* @see org.unicase.ui.tom.gestures.AbstractGesture#handleSingleTouchRemoved(org.unicase.ui.tom.touches.SingleTouch)
	*/
	@Override
	public void handleSingleTouchRemoved(SingleTouch touch) {

		if (touch == firstTouch || touch == secondTouch) {
			if (isExecuting()) {
				getOperation().finish();
				setExecuting(false);
			}
			setCanExecute(false);
		}
		
		Set<INodeEditPart> nodesForTouch = MapUtility.getKeysForObject(
				editPartTouchesMap, touch);
		if (nodesForTouch.size() != 1) {
			return;
		}

		INodeEditPart nodeEditPart = null;
		for (INodeEditPart currentEditPart : nodesForTouch) {
			nodeEditPart = currentEditPart;
		}

		if (nodeEditPart == null) {
			return;
		}

		Set<SingleTouch> set = editPartTouchesMap.get(nodeEditPart);
		if (set != null) {
			if (set.size() == 0) {
				editPartTouchesMap.remove(nodeEditPart);
			} else {
				set.remove(touch);
			}
		}
	}

	/** 
	* {@inheritDoc}
	* @see org.unicase.ui.tom.gestures.Gesture#getMandatoryTouches()
	*/
	public List<MultiTouch> getMandatoryTouches() {
		ArrayList<MultiTouch> mandatoryTouches = new ArrayList<MultiTouch>();
		mandatoryTouches.add(firstTouch.getMultiTouch());
		mandatoryTouches.add(secondTouch.getMultiTouch());

		return mandatoryTouches;
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
		
		getOperation().setTargetEditPart(getTargetEditPart());
		getOperation().prepare(firstTouch.getPath().getFirstPoint(),
				secondTouch.getPath().getFirstPoint());
		
		getOperation().update(firstTouch.getPosition(), secondTouch.getPosition());
		
		setCanExecute(false);
	}


	/**
	 * @return The operation triggered by this gesture
	 */
	public ResizeOperation getOperation() {
		if (operation == null) {
			operation = new ResizeOperation(getDiagramEditPart());
		}
		return operation;
	}

	/**
	 * @param targetEditPart The target edit part
	 */
	public void setTargetEditPart(INodeEditPart targetEditPart) {
		this.targetEditPart = targetEditPart;
	}

	/**
	 * @return The target edit part
	 */
	public INodeEditPart getTargetEditPart() {
		return targetEditPart;
	}

}
