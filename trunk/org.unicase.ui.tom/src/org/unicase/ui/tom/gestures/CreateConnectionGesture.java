package org.unicase.ui.tom.gestures;

import org.eclipse.gmf.runtime.diagram.ui.editparts.DiagramEditPart;
import org.unicase.ui.tom.TouchDispatch;
import org.unicase.ui.tom.touches.Touch;

public class CreateConnectionGesture extends AbstractGesture implements Gesture {



	public CreateConnectionGesture(TouchDispatch dispatch,
			DiagramEditPart editor) {
		super(dispatch, editor);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void execute() {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean getAcceptsTouches() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean getCanExecute() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void handleTouchAdded(Touch touch) {
		

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

	public void setEditor(DiagramEditPart editor) {
	}

	public DiagramEditPart getEditor() {
		return null;
	}

}
