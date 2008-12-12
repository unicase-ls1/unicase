package org.unicase.ui.tom.gestures;

import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.PointList;
import org.eclipse.gmf.runtime.diagram.ui.editparts.DiagramEditPart;
import org.unicase.ui.tom.TouchDispatch;
import org.unicase.ui.tom.touches.Touch;

public abstract class CreateGesture extends AbstractGesture{

	private Touch stationaryTouch = null;
	private Touch creationTouch = null;

	public CreateGesture(TouchDispatch dispatch, DiagramEditPart editor) {
		super(dispatch, editor);
	}

	public void reset() {
		setAcceptsTouches(true);
		setCanExecute(false);
		
		setStationaryTouch(null);
		setCreationTouch(null);
	}

	@Override
	public void setAcceptsTouches(boolean acceptsTouches) {
		super.setAcceptsTouches(acceptsTouches);
		
		if (!acceptsTouches) {
			setStationaryTouch(null);
			setCreationTouch(null);			
		}
	}

	public void setStationaryTouch(Touch pointingTouch) {
		this.stationaryTouch = pointingTouch;
	}

	public Touch getStationaryTouch() {
		return stationaryTouch;
	}

	public void setCreationTouch(Touch creationTouch) {
		this.creationTouch = creationTouch;
	}

	public Touch getCreationTouch() {
		return creationTouch;
	}

	@Override
	public void handleTouchChanged(Touch touch) {
		if (getAcceptsTouches()) {
			PointList path = touch.getPath();
			Point center = path.getBounds().getCenter();
			Point position = touch.getPosition();
	
			if (position.getDistance(center) > 50) {
				System.out.println("Touch moved too much, not accepting any more touches");
				setAcceptsTouches(false);			
			}			
		}
	}
}
