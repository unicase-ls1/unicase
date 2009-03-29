/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.tom.operations;

import org.eclipse.draw2d.geometry.Point;
import org.eclipse.gmf.runtime.diagram.ui.editparts.DiagramEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.widgets.Display;

/**
 * @author schroech
 *
 */
public class MoveNodeOperation extends MoveOperation{

	/**
	 * @param diagramEditPart The {@link DiagramEditPart} on which this operation operates
	 * @param targetEditPart The {@link IGraphicalEditPart} to be moved
	 */
	public MoveNodeOperation(DiagramEditPart diagramEditPart, IGraphicalEditPart targetEditPart) {
		super(diagramEditPart, targetEditPart);
	}
	
	/** 
	* {@inheritDoc}
	* @see org.unicase.ui.tom.operations.Operation#finish()
	*/
	public void finish() {
		final MouseEvent mouseEvent = createMouseEventAtPosition(getPosition());
		
		Runnable runnable = new Runnable(){
			public void run(){
				getDragTracker().mouseUp(mouseEvent, getTargetEditPart().getViewer());
			}
		};
		Display.getDefault().syncExec(runnable);
	}

	/**
	 * @param initialOffset The point at which the dragging operation starts
	 */
	public void prepare(Point initialOffset){
		setPosition(initialOffset);

		final MouseEvent mouseEvent = createMouseEventAtPosition(initialOffset);
		
		Runnable runnable = new Runnable(){
			public void run(){
				setDragTracker(getTargetEditPart().getDragTracker(null));
				getDragTracker().mouseDown(mouseEvent, 
						getTargetEditPart().getViewer());
			}
		};
		Display.getDefault().syncExec(runnable);
	}

	/**
	 * @param position The current position of the dragging touch
	 */
	public void update(Point position) {
		setPosition(position);
		final MouseEvent mouseEvent = createMouseEventAtPosition(position);
		
		Runnable runnable = new Runnable(){
			public void run(){
				getDragTracker().mouseDrag(mouseEvent, getTargetEditPart().getViewer());
			}
		};
		Display.getDefault().syncExec(runnable);
	}
}
