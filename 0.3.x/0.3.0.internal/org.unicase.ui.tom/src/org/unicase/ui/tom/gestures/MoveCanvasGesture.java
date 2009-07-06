package org.unicase.ui.tom.gestures;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.draw2d.geometry.Point;
import org.eclipse.gef.EditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.DiagramEditPart;
import org.unicase.ui.tom.TouchDispatch;
import org.unicase.ui.tom.commands.MoveCanvasCommand;
import org.unicase.ui.tom.touches.Touch;

public class MoveCanvasGesture extends AbstractGesture {

	private List<Touch> candidateTouches;
	private Touch moveTouch;
	private MoveCanvasCommand moveCanvasCommand;

	public MoveCanvasGesture(TouchDispatch dispatch, DiagramEditPart diagramEditPart) {
		super(dispatch, diagramEditPart);

		setCandidateTouches(new ArrayList<Touch>()); 
		setMoveCanvasCommand(new MoveCanvasCommand(diagramEditPart));
	}

	@Override
	public void handleTouchAdded(Touch touch) {
		if (getAcceptsTouches()) {
			EditPart touchedEditPart = findTouchedEditPart(touch);
			EditPart primaryEditPart = getPrimaryEditPart(touchedEditPart);

			if (primaryEditPart != null
					&& primaryEditPart instanceof DiagramEditPart){
				getCandidateTouches().add(touch);
			}			
		}
	}

	@Override
	public void reset() {
		super.reset();

		candidateTouches.clear();
		moveTouch = null;
	}

	@Override
	public void handleTouchChanged(Touch touch) {
		if (!getAcceptsTouches()) {
			return;
		}

		if (getMoveTouch() == null) {
			if (getCandidateTouches().contains(touch)) {
				if (touch.getPath().getMidpoint().getDistance(touch.getPosition()) 
						> TOUCH_MOVEMENT_THRESHOLD) {
					if (getCandidateTouches().size() == 1) {
						setMoveTouch(getCandidateTouches().get(0));
						getCandidateTouches().clear();

						Point firstPoint = getMoveTouch().getPath().getFirstPoint();

						getMoveCanvasCommand().prepareMove(firstPoint);
					}else{
						setAcceptsTouches(false);
					}

				}
			}
		}else if (getMoveTouch() == touch) {
			getMoveCanvasCommand().updateMove(touch.getPosition());
		}
	}

	@Override
	public void handleTouchRemoved(Touch touch) {
		if (getAcceptsTouches()) {
			if (touch == getMoveTouch()) {
				setMoveTouch(null);
			}else{
				getCandidateTouches().remove(touch);
			}		
		}
	}



	public void setMoveTouch(Touch moveTouch) {
		this.moveTouch = moveTouch;
	}



	public Touch getMoveTouch() {
		return moveTouch;
	}

	public void setCandidateTouches(List<Touch> candidateTouches) {
		this.candidateTouches = candidateTouches;
	}

	public List<Touch> getCandidateTouches() {
		return candidateTouches;
	}

	public void setMoveCanvasCommand(MoveCanvasCommand moveCanvasCommand) {
		this.moveCanvasCommand = moveCanvasCommand;
	}

	public MoveCanvasCommand getMoveCanvasCommand() {
		return moveCanvasCommand;
	}

}
