/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.tom.classDiagram.edit.policies;


import java.util.ArrayList;
import java.util.List;

import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.IFigure;
import org.eclipse.gef.GraphicalEditPart;
import org.eclipse.gef.handles.NonResizableHandleKit;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.ResizableShapeEditPolicy;

/**
 * @author schroech
 *
 */
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

	/**
	 * {@inheritDoc}
	 * @see org.eclipse.gef.editpolicies.ResizableEditPolicy#createSelectionHandles()
	 */
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
