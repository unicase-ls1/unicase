package org.unicase.ui.tom.gestures;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.gef.EditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ConnectionEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.DiagramEditPart;
import org.unicase.ui.tom.TouchDispatch;
import org.unicase.ui.tom.touches.MultiTouch;
import org.unicase.ui.tom.touches.SingleTouch;
import org.unicase.ui.tom.touches.Touch;

public class ChangeConnectionTypeGesture extends AbstractGesture {

	private Set<SingleTouch> candidateTouches;
	
	public ChangeConnectionTypeGesture(TouchDispatch dispatch) {
		super(dispatch);
		setCandidateTouches(new HashSet<SingleTouch>());
	}

	@Override
	public void handleSingleTouchAdded(SingleTouch touch) {
		if (!(acceptsAdditionalTouches())) {
			return;
		}

		EditPart touchedEditPart = findTouchedEditPartExcludingDiagram(touch);
		touchedEditPart = getPrimaryEditPart(touchedEditPart);

		if (touchedEditPart instanceof ConnectionEditPart) {
			getCandidateTouches().add(touch);
		}
	}

	@Override
	public void handleSingleTouchChanged(SingleTouch touch) {
		List<Touch> activeTouches = touch.getMultiTouch().getActiveTouches();
		if (activeTouches.size() > 2) {
			return;
		}
		
		for (Touch currentTouch : activeTouches) {
			
		}

	}

	@Override
	public void handleSingleTouchRemoved(SingleTouch touch) {
		// TODO Auto-generated method stub

	}

	public void execute() {
		// TODO Auto-generated method stub

	}

	public List<MultiTouch> getMandatoryTouches() {
		// TODO Auto-generated method stub
		return null;
	}

	public List<MultiTouch> getOptionalTouches() {
		// TODO Auto-generated method stub
		return null;
	}

	public void setCandidateTouches(Set<SingleTouch> candidateTouches) {
		this.candidateTouches = candidateTouches;
	}

	public Set<SingleTouch> getCandidateTouches() {
		return candidateTouches;
	}

}
