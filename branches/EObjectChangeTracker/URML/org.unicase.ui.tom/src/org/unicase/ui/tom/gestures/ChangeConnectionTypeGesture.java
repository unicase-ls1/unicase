package org.unicase.ui.tom.gestures;

import java.util.List;

import org.eclipse.gmf.runtime.diagram.ui.editparts.DiagramEditPart;
import org.unicase.ui.tom.TouchDispatch;
import org.unicase.ui.tom.touches.MultiTouch;
import org.unicase.ui.tom.touches.SingleTouch;

public class ChangeConnectionTypeGesture extends AbstractGesture {

	public ChangeConnectionTypeGesture(TouchDispatch dispatch,
			DiagramEditPart diagramEditPart) {
		super(dispatch, diagramEditPart);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void handleSingleTouchAdded(SingleTouch touch) {
		// TODO Auto-generated method stub

	}

	@Override
	public void handleSingleTouchChanged(SingleTouch touch) {
		// TODO Auto-generated method stub

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

}
