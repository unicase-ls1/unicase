/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.tom.operations;

import java.util.List;

import org.eclipse.draw2d.geometry.Point;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.requests.ChangeBoundsRequest;
import org.eclipse.gmf.runtime.diagram.ui.editparts.DiagramEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.INodeEditPart;
import org.eclipse.gmf.runtime.diagram.ui.requests.RequestConstants;

/**
 * A {@link MoveOperation} moving {@link INodeEditPart}s.
 * Allows the simultaneous movement of multiple {@link INodeEditPart}s.
 *  
 * @author schroech
 *
 */
public class AltMoveNodeOperation extends MoveOperation {

	private List<INodeEditPart> targetEditParts;
	private ChangeBoundsRequest changeBoundsRequest;

	/**
	 * @param diagramEditPart
	 *            The {@link DiagramEditPart} on which this operation operates
	 * @param targetEditParts
	 *            The {@link IGraphicalEditPart}s to be moved
	 */
	public AltMoveNodeOperation(DiagramEditPart diagramEditPart,
			List<INodeEditPart> targetEditParts) {
		super(diagramEditPart);
		setTargetEditParts(targetEditParts);
	}

	/** 
	* {@inheritDoc}
	* @see org.unicase.ui.tom.operations.MoveOperation#finish()
	*/
	@Override
	public void finish() {
		eraseEditPartFeedback();

		for (INodeEditPart targetEditPart : getTargetEditParts()) {
			Command command = targetEditPart
					.getCommand(getChangeBoundsRequest());
			getDiagramEditPart().getDiagramEditDomain()
					.getDiagramCommandStack().execute(command);
		}

	}

	/** 
	* {@inheritDoc}
	* @see org.unicase.ui.tom.operations.MoveOperation#prepare(org.eclipse.draw2d.geometry.Point)
	*/
	@Override
	public void prepare(Point point) {
		setPosition(point);
	}

	/** 
	* {@inheritDoc}
	* @see org.unicase.ui.tom.operations.MoveOperation#update(org.eclipse.draw2d.geometry.Point)
	*/
	@Override
	public void update(Point point) {

		int horizontalDelta = point.x - getPosition().x;
		int verticalDelta = point.y - getPosition().y;

		getChangeBoundsRequest().setMoveDelta(
				new Point(horizontalDelta, verticalDelta));

		showEditPartFeedback();
	}

	private void eraseEditPartFeedback() {
		for (INodeEditPart targetEditPart : getTargetEditParts()) {
			targetEditPart.eraseSourceFeedback(getChangeBoundsRequest());
			targetEditPart.eraseTargetFeedback(getChangeBoundsRequest());
		}

	}

	private void showEditPartFeedback() {
		for (INodeEditPart targetEditPart : getTargetEditParts()) {
			targetEditPart.showSourceFeedback(getChangeBoundsRequest());
			targetEditPart.showTargetFeedback(getChangeBoundsRequest());
		}
	}

	private ChangeBoundsRequest getChangeBoundsRequest() {
		if (changeBoundsRequest == null) {
			changeBoundsRequest = createChangeBoundsRequest();
		}
		return changeBoundsRequest;
	}

	private ChangeBoundsRequest createChangeBoundsRequest() {
		if (getTargetEditParts() == null || getTargetEditParts().size() == 0) {
			return null;
		}

		ChangeBoundsRequest request = new ChangeBoundsRequest(
				RequestConstants.REQ_MOVE);
		request.setEditParts(getTargetEditParts());
		request.getExtendedData().clear();
		request.setConstrainedMove(false);

		return request;
	}

	private void setTargetEditParts(List<INodeEditPart> targetEditParts) {
		this.targetEditParts = targetEditParts;
	}

	/**
	 * @return The {@link INodeEditPart}s this {@link Operation} is moving
	 */
	public List<INodeEditPart> getTargetEditParts() {
		return targetEditParts;
	}
}
