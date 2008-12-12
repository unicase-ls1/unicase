package org.unicase.ui.tom.gestures;

import org.eclipse.gmf.runtime.diagram.ui.editparts.DiagramEditPart;
import org.unicase.ui.tom.TouchDispatch;
import org.unicase.ui.tom.touches.Touch;

public class MoveNodeGesture extends AbstractGesture implements Gesture {

	public MoveNodeGesture(TouchDispatch dispatch, DiagramEditPart editor) {
		super(dispatch, editor);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean getCanExecute() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void handleTouchAdded(Touch touch) {
		// TODO Auto-generated method stub

	}

	@Override
	public void handleTouchChanged(Touch touch) {
		// TODO Auto-generated method stub

	}

	@Override
	public void handleTouchRemoved(Touch touch) {
		// TODO Auto-generated method stub

	}

	public void reset() {
		// TODO Auto-generated method stub

	}

}
