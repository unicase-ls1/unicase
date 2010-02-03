/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.tom.operations;

import org.eclipse.draw2d.geometry.Point;
import org.eclipse.gef.DragTracker;
import org.eclipse.gmf.runtime.diagram.ui.editparts.DiagramEditPart;
import org.eclipse.swt.events.MouseEvent;

/**
 * @author schroech
 *
 */
public abstract class MoveOperation extends AbstractOperation {

	private DragTracker dragTracker;
	private Point position;
	
	/**
	 * Finishes the dragging operation.
	 */
	public abstract void finish();
	
	/**
	 * @param point The current position of the move
	 */
	public abstract void update(Point point);
	
	/**
	 * @param point The point at which the dragging operation starts
	 */
	public abstract void prepare(Point point);
	
	/**
	 * @param diagramEditPart The {@link DiagramEditPart} on which this operation operates
	 */
	public MoveOperation(DiagramEditPart diagramEditPart) {
		super(diagramEditPart);
	}

	/**
	 * Creates a synthetic {@link MouseEvent} at the specified position.
	 * 
	 * @param position The position as a {@link Point} 
	 * @return
	 * The synthesized {@link MouseEvent}
	 */
	protected MouseEvent createMouseEventAtPosition(Point position) {
		
		org.eclipse.swt.widgets.Event event = new org.eclipse.swt.widgets.Event();
		event.x = position.x;
		event.y = position.y;
		event.button = 1;
		event.count = 1;
		event.widget = getDiagramEditPart().getViewer().getControl();
	
		MouseEvent mouseEvent = new MouseEvent(event);
	
		return mouseEvent;
	}

	/**
	 * @param position The initial position of the touch at the beginning of the move 
	 */
	public void setPosition(Point position) {
		this.position = position;
	}

	/**
	 * @return The initial position of the touch at the beginning of the move
	 */
	public Point getPosition() {
		return position;
	}
	
	/**
	 * @param newDragTracker The drag tracker which will be used throughout all dragging operations
	 */
	public void setDragTracker(DragTracker newDragTracker) {
		if (newDragTracker != dragTracker) {
			if (dragTracker != null) {
				dragTracker.deactivate();
			}

			dragTracker = newDragTracker;

			if (newDragTracker != null) {
				newDragTracker.setEditDomain(getDiagramEditPart().getViewer().getEditDomain());
				newDragTracker.activate();
				newDragTracker.setViewer(getDiagramEditPart().getViewer());
			}
		}
	}

	/**
	 * @return The drag tracker which will be used throughout all dragging operations
	 */
	public DragTracker getDragTracker() {
		return dragTracker;
	}

}