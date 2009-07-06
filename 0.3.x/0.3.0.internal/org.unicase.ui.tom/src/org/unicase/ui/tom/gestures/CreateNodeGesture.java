package org.unicase.ui.tom.gestures;

import org.eclipse.gmf.runtime.diagram.ui.editparts.DiagramEditPart;
import org.unicase.ui.tom.TouchDispatch;
import org.unicase.ui.tom.commands.AbstractCommand;
import org.unicase.ui.tom.commands.CreateClassCommand;
import org.unicase.ui.tom.touches.Touch;

public class CreateNodeGesture extends CreateGesture implements Gesture {


	public CreateNodeGesture(TouchDispatch dispatcher,
			DiagramEditPart diagramEditPart) {
		super(dispatcher,diagramEditPart);
	}

	@Override
	public void execute() {
		if (getCanExecute()) {

			super.execute();	

			AbstractCommand createClassCommand = new CreateClassCommand(
					getDiagramEditPart(),
					getStationaryTouch().getPosition());

			createClassCommand.execute();

			setCanExecute(false);
		}
	}

	@Override
	public void handleTouchRemoved(Touch touch) {
		if (getAcceptsTouches()) {
			if (getCreationTouch() == touch) {
				if (getCreationTouch().getLifeSpan() < CREATION_TOUCH_LIFESPAN) {
					setCanExecute(true);	
				}
				setCreationTouch(null);
			}else if (getStationaryTouch() == touch) {
				if (getCreationTouch() != null) {
					setAcceptsTouches(false);	
				}

				setCreationTouch(null);
				setStationaryTouch(null);
			}
		}

	}

	@Override
	public void handleTouchAdded(Touch touch) {
		if (getAcceptsTouches()) {
			if (getDispatch().getActiveTouches().size() == 1) {
				setStationaryTouch(getDispatch().getActiveTouches().get(0));
			}else if (getDispatch().getActiveTouches().size() == 2) {
				if (couldBeCreationTouch(touch)) {
					setCreationTouch(getDispatch().getActiveTouches().get(1));	
				}
			}else if (getDispatch().getActiveTouches().size() > 2) {
				setStationaryTouch(null);
				setCreationTouch(null);

				setAcceptsTouches(false);
			}
		}
	}

	private boolean couldBeCreationTouch(Touch touch) {

		if (getStationaryTouch() != null){
			if (getStationaryTouch().getPosition().getDistance(touch.getPosition()) < CREATION_TO_STATIONARY_TOUCH_THRESHOLD) {
				return true;
			}			
		}

		return false;
	}


}
