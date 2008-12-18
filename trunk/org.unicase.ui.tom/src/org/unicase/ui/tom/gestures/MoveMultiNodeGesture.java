package org.unicase.ui.tom.gestures;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.PointList;
import org.eclipse.gef.EditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.DiagramEditPart;
import org.unicase.model.classDiagram.edit.parts.ClassEditPart;
import org.unicase.ui.tom.TouchDispatch;
import org.unicase.ui.tom.commands.Command;
import org.unicase.ui.tom.commands.MoveNodeCommand;
import org.unicase.ui.tom.touches.Touch;

public class MoveMultiNodeGesture extends AbstractGesture{

	private final int GESTURE_MOVE_THRESHOLD = 20;

	private List<Touch> staticTouches;
	private Map<Touch, Command> touchCommandMap;

	public MoveMultiNodeGesture(TouchDispatch dispatch, DiagramEditPart editor) {
		super(dispatch, editor);

		touchCommandMap = new HashMap<Touch, Command>();
		staticTouches = new ArrayList<Touch>();

	}

	@Override
	public boolean getCanExecute() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void handleTouchAdded(Touch touch) {
		EditPart touchedEditPart = findTouchedEditPart(touch);
		if (touchedEditPart != null) {
			if (touchedEditPart instanceof ClassEditPart) {
				staticTouches.add(touch);
			}
		}
	}

	@Override
	public void handleTouchChanged(Touch touch) {
		if (getAcceptsTouches()) {
			if (staticTouches.contains(touch)) {

				PointList path = touch.getPath();
				Point midPoint = path.getMidpoint();
				Point currentPoint = touch.getPosition();

				if (currentPoint.getDistance(midPoint) > GESTURE_MOVE_THRESHOLD) {
					staticTouches.remove(touch);
					touchCommandMap.put(touch, 
							new MoveNodeCommand(getDiagramEditPart()));
				}
			}
		}
	}

	@Override
	public void handleTouchRemoved(Touch touch) {
		staticTouches.remove(touch);

	}


	public void reset() {
		// TODO Auto-generated method stub

	}

	public void setDiagramEditPart(DiagramEditPart editor) {
	}

	public DiagramEditPart getDiagramEditPart() {
		return null;
	}

	public void setMoveTouches(List<Touch> moveTouches) {
		this.staticTouches = moveTouches;
	}

	public List<Touch> getMoveTouches() {
		return staticTouches;
	}

}
