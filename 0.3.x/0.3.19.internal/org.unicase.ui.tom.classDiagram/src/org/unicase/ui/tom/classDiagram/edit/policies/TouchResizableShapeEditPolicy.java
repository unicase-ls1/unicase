package org.unicase.ui.tom.classDiagram.edit.policies;


import java.util.ArrayList;
import java.util.List;

import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.IFigure;
import org.eclipse.gef.GraphicalEditPart;
import org.eclipse.gef.handles.NonResizableHandleKit;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.ResizableShapeEditPolicy;

public class TouchResizableShapeEditPolicy extends ResizableShapeEditPolicy {

//	@Override
//	protected void showChangeBoundsFeedback(ChangeBoundsRequest request) {
//		
////		GC context = new GC
////		SWTGraphics graphics = new SWTGraphics();
//		EditPartViewer viewer = getHost().getViewer();
//		
//		
//		IFigure hostFigure = getHostFigure();
//		hostFigure.paint(graphics)
//		super.showChangeBoundsFeedback(request);
//
//		IFigure dragSourceFeedbackFigure = getDragSourceFeedbackFigure();
//		dragSourceFeedbackFigure.setBackgroundColor(ColorConstants.blue);
//		dragSourceFeedbackFigure.setForegroundColor(ColorConstants.red);
//	}

	@SuppressWarnings("unchecked")
	@Override
	protected List createSelectionHandles() {
		List list = new ArrayList();

		NonResizableHandleKit.addMoveHandle((GraphicalEditPart) getHost(), list);
		for (Object handle : list) {
			if(handle instanceof IFigure){
				((IFigure) handle).setForegroundColor(ColorConstants.red);
			}
		}

		return list;
	}
}
