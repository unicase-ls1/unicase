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
		super.execute();	
	
		AbstractCommand createClassCommand = new CreateClassCommand(
				getEditor(),
				getStationaryTouch().getPosition());
		
		createClassCommand.execute();
	
		setCanExecute(false);
	}

	@Override
	public void handleTouchRemoved(Touch touch) {
		if (getAcceptsTouches()) {
			if (getCreationTouch() == touch) {
				if (getCreationTouch().getLifeSpan() < 200) {
					setCanExecute(true);	
				}
				setCreationTouch(null);
			}else if (getStationaryTouch() == touch) {
				if (getCreationTouch() != null) {
					System.out.println("Creation touch is not null, but pointingTouch removed, not accepting any more touches");
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
				setCreationTouch(getDispatch().getActiveTouches().get(1));
			}else if (getDispatch().getActiveTouches().size() > 2) {
				setStationaryTouch(null);
				setCreationTouch(null);
	
				System.out.println("Number of touches > 2, not accepting any more touches");
				setAcceptsTouches(false);
			}
		}
	}


}
