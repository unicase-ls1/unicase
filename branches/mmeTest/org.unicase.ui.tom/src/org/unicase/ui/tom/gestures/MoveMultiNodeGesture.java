package org.unicase.ui.tom.gestures;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.PointList;
import org.eclipse.gef.EditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.DiagramEditPart;
import org.unicase.model.classDiagram.edit.parts.ClassEditPart;
import org.unicase.ui.tom.TouchDispatch;
import org.unicase.ui.tom.notifications.TouchNotification;
import org.unicase.ui.tom.notifications.TouchNotifier;
import org.unicase.ui.tom.notifications.TouchNotifierImpl;
import org.unicase.ui.tom.touches.Touch;

public class MoveMultiNodeGesture extends AbstractGesture implements Gesture {

	private final int GESTURE_MOVE_THRESHOLD = 20;
	
	private List<Touch> unhandledTouches;
	private List<Touch> handledTouches;
	private List<MoveNodeGesture> moveGestures;
	private TouchNotifier touchNotifier;
	
	public MoveMultiNodeGesture(TouchDispatch dispatch, DiagramEditPart editor) {
		super(dispatch, editor);
		
		moveGestures = new ArrayList<MoveNodeGesture>();
		unhandledTouches = new ArrayList<Touch>();
		
		touchNotifier = new TouchNotifierImpl();
	}

	@Override
	public boolean getCanExecute() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void handleTouchAdded(Touch touch) {
		EditPart touchedEditPart = getTouchedEditPart(touch);
		if (touchedEditPart != null) {
			if (touchedEditPart instanceof ClassEditPart) {
				unhandledTouches.add(touch);
			}
		}
	}

	@Override
	public void handleTouchChanged(Touch touch) {
		if (unhandledTouches.contains(touch)) {
			if (acceptsTouches) {
				
			}
			PointList path = touch.getPath();
			Point lastPoint = path.getLastPoint();
			Point currentPoint = touch.getPosition();
			if (currentPoint.getDistance(lastPoint) > GESTURE_MOVE_THRESHOLD) {
				unhandledTouches.remove(touch);
				handledTouches.add(touch);
				
				
			}
		}
	}

	@Override
	public void handleTouchRemoved(Touch touch) {
		unhandledTouches.remove(touch);

	}

	private void handleThresholdPassed(Touch touch) {
		
	}
	
	public void reset() {
		// TODO Auto-generated method stub

	}

	public void setEditor(DiagramEditPart editor) {
	}

	public DiagramEditPart getEditor() {
		return null;
	}

	public void setMoveTouches(List<Touch> moveTouches) {
		this.unhandledTouches = moveTouches;
	}

	public List<Touch> getMoveTouches() {
		return unhandledTouches;
	}

}
