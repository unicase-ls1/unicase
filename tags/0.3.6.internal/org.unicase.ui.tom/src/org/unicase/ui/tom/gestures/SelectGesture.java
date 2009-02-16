package org.unicase.ui.tom.gestures;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.gef.EditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.DiagramEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart;
import org.unicase.ui.tom.TouchDispatch;
import org.unicase.ui.tom.actions.AppendSelectionAction;
import org.unicase.ui.tom.actions.DeselectAction;
import org.unicase.ui.tom.actions.DeselectAllAction;
import org.unicase.ui.tom.actions.SelectAction;
import org.unicase.ui.tom.touches.Touch;

public class SelectGesture extends AbstractGesture implements Gesture {

	//	private EditPart touchedEditPart;

	public SelectGesture(TouchDispatch dispatch, DiagramEditPart diagramEditPart) {
		super(dispatch, diagramEditPart);
	}

	@Override
	public void execute() {
		//		super.execute();
		//
		//		SelectAction selectAction = new SelectAction(getDiagramEditPart(), (GraphicalEditPart) getTouchedEditPart());
		//		selectAction.execute();
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

		EditPart foundEditPart = findTouchedEditPartExcluding(touch, exclusions);
		GraphicalEditPart primaryEditPart = getPrimaryEditPart(foundEditPart);

		List selectedEditParts = getDiagramEditPart().getViewer().getSelectedEditParts();

		List<Touch> activeTouches = getDispatch().getActiveTouches();
		int numberOfActiveTouches = activeTouches.size();

		if (numberOfActiveTouches == 1) {
			if (primaryEditPart != null
				&& selectedEditParts.contains(primaryEditPart)) {
				return;
			}
			
			DeselectAllAction deselectAllAction = new DeselectAllAction(getDiagramEditPart());
			deselectAllAction.execute();
			
			if (primaryEditPart != null) {
				
				SelectAction selectAction = new SelectAction(getDiagramEditPart(), primaryEditPart);
				selectAction.execute();
			}
		}else{
			int numberOfSelectedEditPartTouches = 0;
			for (Touch activeTouch : activeTouches) {
				EditPart activeTouchEditPart = findTouchedEditPartExcluding(activeTouch, exclusions);
				activeTouchEditPart = getPrimaryEditPart(activeTouchEditPart);

				if (selectedEditParts.contains(activeTouchEditPart)) {
					numberOfSelectedEditPartTouches++;
				}
			}

			if (numberOfSelectedEditPartTouches > 0) {
				if (primaryEditPart == null) {
					return;
				}
				if (selectedEditParts.contains(primaryEditPart)) {
					DeselectAction deselectAction = new DeselectAction(getDiagramEditPart(), primaryEditPart);
					deselectAction.execute();
				}else{
					AppendSelectionAction appendSelectionAction = new AppendSelectionAction(getDiagramEditPart(), primaryEditPart);
					appendSelectionAction.execute();
				}
			}else{
				DeselectAllAction deselectAllAction = new DeselectAllAction(getDiagramEditPart());
				deselectAllAction.execute();

				if (primaryEditPart != null) {
					SelectAction selectAction = new SelectAction(getDiagramEditPart(), primaryEditPart);
					selectAction.execute();					
				}
			}
		}


		//		if (primaryEditPart != null) {
		//			setTouchedEditPart(primaryEditPart);
		//
		//			setAcceptsTouches(false);
		//			setCanExecute(true);
		//		}
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

		//		if (getDispatch().getActiveTouches().size() == 0) {
		//			//			setTouchedEditPart(null);
		//
		//			setAcceptsTouches(true);
		//			setCanExecute(false);
		//		}
	}

	public void reset() {
		//Don't call super.reset() here
		//We do not want acceptsTouches to be reset

		setCanExecute(false);
	}
	//
	//	public void setTouchedEditPart(EditPart touchedEditPart) {
	//		this.touchedEditPart = touchedEditPart;
	//	}
	//
	//	public EditPart getTouchedEditPart() {
	//		return touchedEditPart;
	//	}

}
