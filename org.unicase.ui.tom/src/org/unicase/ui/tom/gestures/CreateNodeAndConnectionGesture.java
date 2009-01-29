package org.unicase.ui.tom.gestures;

import org.eclipse.draw2d.geometry.Point;
import org.eclipse.gef.EditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.DiagramEditPart;
import org.unicase.ui.tom.TouchDispatch;
import org.unicase.ui.tom.commands.Command;
import org.unicase.ui.tom.commands.CreateNodeAndConnectionCommand;
import org.unicase.ui.tom.touches.Touch;

public class CreateNodeAndConnectionGesture extends CreateGesture implements
Gesture {

	private Touch secondStationaryTouch = null;

	public CreateNodeAndConnectionGesture(TouchDispatch dispatch, DiagramEditPart editor) {
		super(dispatch, editor);
	}

	@Override
	public void execute() {
		if (getCanExecute()) {
			super.execute();

			Command command = null;
			Point sourcePoint;
			Point targetPoint;
			EditPart sourceEditPart = null;
			EditPart targetEditPart = null;

			EditPart firstTouchedEditPart = findTouchedEditPart(getStationaryTouch());
			firstTouchedEditPart = getPrimaryEditPart(firstTouchedEditPart);

			if (firstTouchedEditPart == null) {
				firstTouchedEditPart = getDiagramEditPart();
			}

			EditPart secondTouchedEditPart = findTouchedEditPart(getSecondStationaryTouch());
			secondTouchedEditPart = getPrimaryEditPart(secondTouchedEditPart);

			if (secondTouchedEditPart == null) {
				secondTouchedEditPart = getDiagramEditPart();
			}

			Touch closestNeighbor = getCreationTouch().findClosestNeighbor(
					getStationaryTouch(),
					getSecondStationaryTouch());

			if (closestNeighbor == getStationaryTouch()) {
				sourcePoint = getSecondStationaryTouch().getPosition();
				targetPoint = getStationaryTouch().getPosition();

				sourceEditPart = secondTouchedEditPart;
				targetEditPart = firstTouchedEditPart;
			}else{
				sourcePoint = getStationaryTouch().getPosition();
				targetPoint = getSecondStationaryTouch().getPosition();	

				sourceEditPart = firstTouchedEditPart;
				targetEditPart = secondTouchedEditPart;
			}

			if (firstTouchedEditPart instanceof DiagramEditPart
					&& secondTouchedEditPart instanceof DiagramEditPart) {

				command = new CreateNodeAndConnectionCommand(
						getDiagramEditPart(),
						sourcePoint,
						targetPoint);

			}else if (firstTouchedEditPart instanceof DiagramEditPart) {

				command = new CreateNodeAndConnectionCommand(
						getDiagramEditPart(), 
						sourcePoint,
						targetEditPart);

			}else if (secondTouchedEditPart instanceof DiagramEditPart) {

				command = new CreateNodeAndConnectionCommand(
						getDiagramEditPart(), 
						sourceEditPart,
						targetPoint);
			}else{

				command = new CreateNodeAndConnectionCommand(
						getDiagramEditPart(),
						sourceEditPart,
						targetEditPart);
			}

			command.execute();

			setCanExecute(false);

		}
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
				if (getCreationTouch().getLifeSpan() < CREATION_TOUCH_LIFESPAN) {
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
