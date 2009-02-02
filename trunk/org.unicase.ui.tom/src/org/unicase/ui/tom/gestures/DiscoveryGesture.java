package org.unicase.ui.tom.gestures;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.eclipse.gef.EditPart;
import org.eclipse.gmf.runtime.common.ui.dialogs.ExpansionType;
import org.eclipse.gmf.runtime.diagram.ui.editparts.DiagramEditPart;
import org.eclipse.gmf.runtime.diagram.ui.requests.ShowRelatedElementsRequest;
import org.eclipse.gmf.runtime.emf.type.core.ElementTypeRegistry;
import org.unicase.model.classes.ClassesPackage;
import org.unicase.ui.tom.TouchDispatch;
import org.unicase.ui.tom.touches.Touch;

public class DiscoveryGesture extends AbstractGesture {

	private List<Touch> activationTouches;
	private EditPart touchedEditPart;

	public DiscoveryGesture(TouchDispatch dispatch,
			DiagramEditPart diagramEditPart) {
		super(dispatch, diagramEditPart);
		activationTouches = new ArrayList<Touch>();
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

		if (currentlyTouchedEditPart == null) {
			setAcceptsTouches(false);
			return;
		}

		if (touchedEditPart == null) {
			touchedEditPart = currentlyTouchedEditPart;
			activationTouches.add(touch);
		}else{
			if (currentlyTouchedEditPart == touchedEditPart) {
				activationTouches.add(touch);
				if (activationTouches.size() == 3) {

				}
			}
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
}
