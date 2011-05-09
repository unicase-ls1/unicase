/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.tom.operations;

import org.eclipse.draw2d.geometry.Point;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ConnectionEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.DiagramEditPart;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.widgets.Display;

/**
 * @author schroech
 *
 */
public class MoveConnectionBendpointOperation extends MoveOperation{
	
	/**
	 * The {@link ConnectionEditPart} whose bendpoint this operation moves.
	 */
	private ConnectionEditPart targetEditPart;
	
	/**
	 * @param diagramEditPart The {@link DiagramEditPart} on which this operation operates
	 * @param targetEditPart The {@link ConnectionEditPart} to be moved
	 */
	public MoveConnectionBendpointOperation(DiagramEditPart diagramEditPart, ConnectionEditPart targetEditPart) {
		super(diagramEditPart);
		setTargetEditPart(targetEditPart);
	}

	/**
	 * @param targetEditPart The {@link ConnectionEditPart} to be moved
	 */
	public void setTargetEditPart(ConnectionEditPart targetEditPart) {
		this.targetEditPart = targetEditPart;
	}

	/**
	 * @return
	 * The {@link ConnectionEditPart} to be moved
	 */
	public ConnectionEditPart getTargetEditPart() {
		return targetEditPart;
	}
	
	/** 
	* {@inheritDoc}
	* @see org.unicase.ui.tom.operations.Operation#finish()
	*/
	@Override
	public void finish() {
		final MouseEvent mouseEvent = createMouseEventAtPosition(getPosition());
		
		Runnable runnable = new Runnable(){
			public void run(){
				getDragTracker().mouseUp(mouseEvent, getDiagramEditPart().getViewer());
			}
		};
		Display.getDefault().syncExec(runnable);

	}
	
	/** 
	* {@inheritDoc}
	* @see org.unicase.ui.tom.operations.MoveOperation#prepare(org.eclipse.draw2d.geometry.Point)
	*/
	@Override
	public void prepare(Point position) {
		setPosition(position);		

		final MouseEvent mouseEvent = createMouseEventAtPosition(position);

		//ConnectionBendpointTracker 
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
	* {@inheritDoc}
	* @see org.unicase.ui.tom.operations.MoveOperation#update(org.eclipse.draw2d.geometry.Point)
	*/
	@Override
	public void update(Point point) {
		setPosition(point);
		
		final MouseEvent mouseEvent = createMouseEventAtPosition(point);
		
		Runnable runnable = new Runnable(){
			public void run(){
				getDragTracker().mouseDrag(
						mouseEvent,
						getTargetEditPart().getViewer());
			}
		};
		Display.getDefault().syncExec(runnable);
	}
}
