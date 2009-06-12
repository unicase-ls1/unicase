package org.unicase.ui.tom.gestures;

import java.util.List;

import org.eclipse.gmf.runtime.diagram.ui.editparts.DiagramEditPart;
import org.unicase.ui.tom.TouchDispatch;
import org.unicase.ui.tom.touches.MultiTouch;
import org.unicase.ui.tom.touches.SingleTouch;

/**
 * @author schroech
 *
 */
public class CreateCompartmentNodeGesture extends CreateGesture {

	/**
	 * @param dispatch The {@link TouchDispatch} at which the gesture will register for touch events
	 * @param diagramEditPart The {@link DiagramEditPart}
	 */
	public CreateCompartmentNodeGesture(TouchDispatch dispatch,
			DiagramEditPart diagramEditPart) {
		super(dispatch, diagramEditPart);
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

}
