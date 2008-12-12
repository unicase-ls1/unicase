package org.unicase.ui.tom.gestures;

import org.eclipse.draw2d.geometry.Point;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gef.EditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.DiagramEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ShapeNodeEditPart;
import org.unicase.ui.tom.TouchDispatch;
import org.unicase.ui.tom.commands.Command;
import org.unicase.ui.tom.commands.CreateClassAndAssociationCommand;
import org.unicase.ui.tom.touches.Touch;

public class CreateNodeAndConnectionGesture extends CreateGesture implements
Gesture {

	private static final int CREATION_TO_STATIONARY_TOUCH_THRESHOLD = 80;

	private Touch secondStationaryTouch = null;

	public CreateNodeAndConnectionGesture(TouchDispatch dispatch, DiagramEditPart editor) {
		super(dispatch, editor);
	}

	@Override
	public void execute() {
		super.execute();

		Command command = null;
		Point sourcePoint;
		Point targetPoint;
		EObject sourceModel = null;
		EObject targetModel = null;

		EditPart firstTouchedEditPart = getTouchedEditPart(getStationaryTouch());
		firstTouchedEditPart = getPrimaryEditPart(firstTouchedEditPart);

		EditPart secondTouchedEditPart = getTouchedEditPart(getSecondStationaryTouch());
		secondTouchedEditPart = getPrimaryEditPart(secondTouchedEditPart);
		
		Touch closestNeighbor = getCreationTouch().findClosestNeighbor(
				getStationaryTouch(),
				getSecondStationaryTouch());

		if (closestNeighbor == getStationaryTouch()) {
			sourcePoint = getSecondStationaryTouch().getPosition();
			targetPoint = getStationaryTouch().getPosition();

			sourceModel = (EObject) secondTouchedEditPart.getModel();
			targetModel = (EObject) firstTouchedEditPart.getModel();
		}else{
			sourcePoint = getStationaryTouch().getPosition();
			targetPoint = getSecondStationaryTouch().getPosition();	
			
			sourceModel = (EObject) firstTouchedEditPart.getModel();
			targetModel = (EObject) secondTouchedEditPart.getModel();
		}

		if (firstTouchedEditPart instanceof DiagramEditPart
				&& secondTouchedEditPart instanceof DiagramEditPart) {

			command = new CreateClassAndAssociationCommand(
					getEditor(),
					sourcePoint,
					targetPoint);

		}else if (firstTouchedEditPart instanceof DiagramEditPart) {

			command = new CreateClassAndAssociationCommand(
					getEditor(), 
					sourcePoint,
					targetModel);

		}else if (secondTouchedEditPart instanceof DiagramEditPart) {

			command = new CreateClassAndAssociationCommand(
					getEditor(), 
					sourceModel,
					targetPoint);
		}else{

			command = new CreateClassAndAssociationCommand(
					getEditor(),
					sourceModel,
					targetModel);
		}

		command.execute();
	}

	private EditPart getPrimaryEditPart(EditPart touchedEditPart) {
		EditPart primaryEditPart = touchedEditPart;
		while (primaryEditPart  != null 
				&& !(primaryEditPart  instanceof ShapeNodeEditPart)
				&& !(primaryEditPart  instanceof DiagramEditPart)) {
			primaryEditPart = primaryEditPart.getParent();
		}
		return primaryEditPart;
	}

	private boolean couldBeCreationTouch(Touch touch){
		if (getCreationTouch() == null) {
			if ((getSecondStationaryTouch() != null
					&& getSecondStationaryTouch().getPosition().getDistance(touch.getPosition()) 
					< CREATION_TO_STATIONARY_TOUCH_THRESHOLD)){
				return true;
			}

			if((getStationaryTouch() != null
					&& getStationaryTouch().getPosition().getDistance(touch.getPosition()) 
					< CREATION_TO_STATIONARY_TOUCH_THRESHOLD)){
				return true;
			}
		}
		return false;
	}

	@Override
	public void handleTouchAdded(Touch touch) {
		if (getAcceptsTouches()) {
			if (getDispatch().getActiveTouches().size() > 3) {
				setAcceptsTouches(false);
				return;
			}

			if (getStationaryTouch() == null) {
				setStationaryTouch(touch);
			}else if (getSecondStationaryTouch() == null) {
				setSecondStationaryTouch(touch);
			}else if(couldBeCreationTouch(touch)){
				setCreationTouch(touch);
			}else{
				setAcceptsTouches(false);
			}
		}
	}

	@Override
	public void handleTouchRemoved(Touch touch) {
		if (getAcceptsTouches()) {
			if (touch == getCreationTouch()) {
				if (getCreationTouch().getLifeSpan() < 200) {
					setCanExecute(true);
				}
			}else if (getCreationTouch() != null) { 
				if (touch == getStationaryTouch()
						|| touch == getSecondStationaryTouch()) {
					setAcceptsTouches(false);
				}
			}else if (touch == getSecondStationaryTouch()) {
				setSecondStationaryTouch(null);
			}else if (touch == getStationaryTouch()) {
				setStationaryTouch(null);
			}
		}
	}

	public void reset() {
		super.reset();
		setSecondStationaryTouch(null);
	}

	@Override
	public void setAcceptsTouches(boolean acceptsTouches) {
		super.setAcceptsTouches(acceptsTouches);

		if (!acceptsTouches) {
			setSecondStationaryTouch(null);	
		}
	}

	public void setSecondStationaryTouch(Touch secondStationaryTouch) {
		this.secondStationaryTouch = secondStationaryTouch;
	}

	public Touch getSecondStationaryTouch() {
		return secondStationaryTouch;
	}

}
