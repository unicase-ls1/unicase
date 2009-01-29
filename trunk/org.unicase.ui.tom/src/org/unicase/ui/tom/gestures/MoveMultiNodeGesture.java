package org.unicase.ui.tom.gestures;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.gef.EditPart;
import org.eclipse.gef.NodeEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.DiagramEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart;
import org.unicase.ui.tom.TouchDispatch;
import org.unicase.ui.tom.commands.MoveNodeCommand;
import org.unicase.ui.tom.touches.Touch;

public class MoveMultiNodeGesture extends AbstractGesture{

	private Map<Touch, MoveNodeCommand> touchCommandMap;
	@SuppressWarnings("unchecked")
	private List diagramExclusions;

	@SuppressWarnings("unchecked")
	public MoveMultiNodeGesture(TouchDispatch dispatch, DiagramEditPart editor) {
		super(dispatch, editor);

		setTouchCommandMap(new HashMap<Touch, MoveNodeCommand>());
		
		diagramExclusions = new ArrayList();
		diagramExclusions.add(getDiagramEditPart());
		diagramExclusions.add(getDiagramEditPart().getParent());
	}

	@Override
	public boolean getCanExecute() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void handleTouchAdded(Touch touch) {
		EditPart touchedEditPart = findTouchedEditPartExcluding(touch, diagramExclusions);
		GraphicalEditPart primaryEditPart = getPrimaryEditPart(touchedEditPart);
		if (primaryEditPart != null) {
			if (primaryEditPart instanceof NodeEditPart) {
				
				MoveNodeCommand moveNodeCommand 
					= new MoveNodeCommand(getDiagramEditPart());
				
				getTouchCommandMap().put(touch, moveNodeCommand);				
			}
		}
	}

	@Override
	public void handleTouchChanged(Touch touch) {
		if (getAcceptsTouches()) {
			MoveNodeCommand moveNodeCommand = getTouchCommandMap().get(touch);
			if (moveNodeCommand != null) {
				if (touchMoved(touch, TOUCH_MOVEMENT_THRESHOLD)){
					
					moveNodeCommand.update(touch.getPosition());
					
					getTouchCommandMap().put(touch, 
							moveNodeCommand);
					
				}
				
				return;
			}
			
			MoveNodeCommand command = getTouchCommandMap().get(touch);
			command.update(touch.getPosition());
		}
	}



	@Override
	public void handleTouchRemoved(Touch touch) {
//		boolean remove = getStaticTouches().remove(touch);
//		if (remove) {
//			return;
//		}
	
		MoveNodeCommand moveNodeCommand = getTouchCommandMap().get(touch);
		if (moveNodeCommand != null) {
			moveNodeCommand.execute();
		}
		getTouchCommandMap().remove(touch);
	}


	public void reset() {
		touchCommandMap.clear();
	}

	public void setDiagramEditPart(DiagramEditPart editor) {
	}

	public DiagramEditPart getDiagramEditPart() {
		return null;
	}

	public void setTouchCommandMap(Map<Touch, MoveNodeCommand> touchCommandMap) {
		this.touchCommandMap = touchCommandMap;
	}

	public Map<Touch, MoveNodeCommand> getTouchCommandMap() {
		return touchCommandMap;
	}

}
