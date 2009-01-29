package org.unicase.ui.tom.gestures;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.gef.EditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.DiagramEditPart;
import org.unicase.ui.tom.TouchDispatch;
import org.unicase.ui.tom.touches.Touch;

public class SelectGesture extends AbstractGesture implements Gesture {

	private Touch selectionTouch;
	private EditPart touchedEditPart;
	
	public SelectGesture(TouchDispatch dispatch, DiagramEditPart editor) {
		super(dispatch, editor);
	}

	@SuppressWarnings("unchecked")
	@Override
	public void handleTouchAdded(Touch touch) {
		if (!(getAcceptsTouches())) {
			return;
		}

		setSelectionTouch(touch);
		
		List exclusions = new ArrayList();
		exclusions.add(getDiagramEditPart());
		exclusions.add(getDiagramEditPart().getParent());

		setTouchedEditPart(findTouchedEditPartExcluding(touch, exclusions));
		setTouchedEditPart(getPrimaryEditPart(getTouchedEditPart()));
		
		setAcceptsTouches(false);
		setCanExecute(true);
	}

	@Override
	public void handleTouchChanged(Touch touch) {
		//We don't care
	}

	@Override
	public void handleTouchRemoved(Touch touch) {
		//We return IF!! we accept touches because in this case there is nothing to do
		if (getAcceptsTouches()) {
			return;
		}
		
		if (getDispatch().getActiveTouches().size() == 0) {
			setSelectionTouch(null);
			setTouchedEditPart(null);
			
			setAcceptsTouches(true);
			setCanExecute(false);
		}
	}

	public void reset() {
		//Don't call super.reset() here
		//We do not want acceptsTouches to be reset
		
		setCanExecute(false);
	}

	public void setSelectionTouch(Touch selectionTouch) {
		this.selectionTouch = selectionTouch;
	}

	public Touch getSelectionTouch() {
		return selectionTouch;
	}

	public void setTouchedEditPart(EditPart touchedEditPart) {
		this.touchedEditPart = touchedEditPart;
	}

	public EditPart getTouchedEditPart() {
		return touchedEditPart;
	}

}
