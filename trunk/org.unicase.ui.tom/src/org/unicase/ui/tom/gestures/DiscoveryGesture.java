package org.unicase.ui.tom.gestures;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.gef.EditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.DiagramEditPart;
import org.unicase.ui.tom.TouchDispatch;
import org.unicase.ui.tom.touches.Touch;

public class DiscoveryGesture extends AbstractGesture {

	private List<Touch> activationTouches;
	private EditPart touchedEditPart;
	private int state;
	
	private static final int INITIAL = 0;
	private static final int IDENTIFIED_EDITPART = 1;
	private static final int DISCOVERY_MODE = 2;
	private static final int INVALID = 3;
	
	public DiscoveryGesture(TouchDispatch dispatch,
			DiagramEditPart diagramEditPart) {
		super(dispatch, diagramEditPart);
		activationTouches = new ArrayList<Touch>();
	}

	public boolean stateTransition(int newState) {
		switch (getState()) {
		case INITIAL:
			if (newState == INITIAL) {
				return true;
			}else if (newState == IDENTIFIED_EDITPART) {
				return true;
			}else{
				return false;
			}
		default:
			return false;
		}
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public void handleTouchAdded(Touch touch) {
		if (!(getAcceptsTouches())) {
			return;
		}
		
		List exclusions = new ArrayList();
		exclusions.add(getDiagramEditPart());
		exclusions.add(getDiagramEditPart().getParent());
		
		EditPart currentlyTouchedEditPart = findTouchedEditPartExcluding(touch, exclusions);
		currentlyTouchedEditPart = getPrimaryEditPart(touchedEditPart);
		
		switch (getState()) {
		case INITIAL:
			touchedEditPart = currentlyTouchedEditPart;
			break;
		case IDENTIFIED_EDITPART:
			boolean pointInDistance = false;
			for (Touch activationTouch : activationTouches) {
				if(pointsInDistance(activationTouch, touch, TOUCH_DIAMETER)) {
					pointInDistance = true;
					break;
				}
			}
			
			if (pointInDistance) {
				activationTouches.add(touch);
			}else{
				setState(INVALID);
			}
		default:
			break;
		}
	
		

		



	}

	@Override
	public void handleTouchChanged(Touch touch) {
		// TODO Auto-generated method stub

	}

	@Override
	public void handleTouchRemoved(Touch touch) {
		// TODO Auto-generated method stub

	}

	public void setState(int state) {
		this.state = state;
	}

	public int getState() {
		return state;
	}

}
