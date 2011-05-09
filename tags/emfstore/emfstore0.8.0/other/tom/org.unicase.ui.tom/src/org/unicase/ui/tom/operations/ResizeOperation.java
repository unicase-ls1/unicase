/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.tom.operations;

import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.requests.ChangeBoundsRequest;
import org.eclipse.gmf.runtime.diagram.ui.editparts.DiagramEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.INodeEditPart;
import org.eclipse.gmf.runtime.diagram.ui.requests.RequestConstants;

/**
 * @author schroech
 *
 */
public class ResizeOperation extends AbstractOperation {

	private INodeEditPart targetEditPart;

	private Point initialLowerLeftPosition;
	private Point initialUpperRightPosition;

	private int leftDelta;
	private int rightDelta;
	private int topDelta;
	private int bottomDelta;

	private ChangeBoundsRequest changeBoundsRequest;

	/**
	 * Default constructor.
	 * @param diagramEditPart The diagram edit part
	 */
	public ResizeOperation(DiagramEditPart diagramEditPart) {
		super(diagramEditPart);
	}

	/**
	 * @param firstPoint One point of the 'pinch' gesture
	 * @param secondPoint Another point of the 'pinch' gesture
	 */
	public void prepare(Point firstPoint, Point secondPoint) {
		updateInitialPositions(firstPoint, secondPoint);

		getChangeBoundsRequest().setMoveDelta(new Point(getLeftDelta(),
				getTopDelta()));
		getChangeBoundsRequest().setSizeDelta(new Dimension(getRightDelta()
				- getLeftDelta(), getBottomDelta() - getTopDelta()));

		showEditPartFeedback();
	}

	/**
	 * @param firstPoint One point of the 'pinch' gesture
	 * @param secondPoint Another point of the 'pinch' gesture
	 */
	public void update(Point firstPoint, Point secondPoint) {
		updateDeltas(firstPoint, secondPoint);
		getChangeBoundsRequest().setMoveDelta(new Point(getLeftDelta(),
				getTopDelta()));
		getChangeBoundsRequest().setSizeDelta(new Dimension(getRightDelta()
				- getLeftDelta(), getBottomDelta() - getTopDelta()));

		showEditPartFeedback();
	}

	/**
	 * Finishes the operation, executing the corresponding command.
	 */
	public void finish() {
		eraseEditPartFeedback();
		Command command = getTargetEditPart().getCommand(getChangeBoundsRequest());
		getDiagramEditPart().getDiagramEditDomain().getDiagramCommandStack()
				.execute(command);

	}

	private void updateInitialPositions(Point firstPoint, Point secondPoint) {
		initialLowerLeftPosition = new Point();
		initialUpperRightPosition = new Point();

		if (firstPoint.x < secondPoint.x) {
			initialLowerLeftPosition.x = firstPoint.x;
			initialUpperRightPosition.x = secondPoint.x;
		} else {
			initialUpperRightPosition.x = firstPoint.x;
			initialLowerLeftPosition.x = secondPoint.x;
		}

		if (firstPoint.y < secondPoint.y) {
			initialLowerLeftPosition.y = firstPoint.y;
			initialUpperRightPosition.y = secondPoint.y;
		} else {
			initialUpperRightPosition.y = firstPoint.y;
			initialLowerLeftPosition.y = secondPoint.y;
		}
	}

	private void updateDeltas(Point firstPoint, Point secondPoint) {
		if (firstPoint.x < secondPoint.x) {
			setLeftDelta(firstPoint.x - initialLowerLeftPosition.x);
			setRightDelta(secondPoint.x - initialUpperRightPosition.x);
		} else {
			setLeftDelta(secondPoint.x - initialLowerLeftPosition.x);
			setRightDelta(firstPoint.x - initialUpperRightPosition.x);
		}

		if (firstPoint.y < secondPoint.y) {
			setTopDelta(firstPoint.y - initialLowerLeftPosition.y);
			setBottomDelta(secondPoint.y - initialUpperRightPosition.y);
		} else {
			setTopDelta(secondPoint.y - initialLowerLeftPosition.y);
			setBottomDelta(firstPoint.y - initialUpperRightPosition.y);
		}
	}

	private ChangeBoundsRequest getChangeBoundsRequest() {
		if (changeBoundsRequest == null) {
			changeBoundsRequest = createChangeBoundsRequest();
		}
		return changeBoundsRequest;
	}

	private ChangeBoundsRequest createChangeBoundsRequest() {
		if (getTargetEditPart() == null) {
			return null;
		}

		ChangeBoundsRequest request = new ChangeBoundsRequest(
				RequestConstants.REQ_RESIZE);
		request.setEditParts(getTargetEditPart());
		request.getExtendedData().clear();

		request
				.setResizeDirection(org.eclipse.draw2d.PositionConstants.NORTH_EAST);
		request.setConstrainedResize(false);
		request.setCenteredResize(false);

		return request;
	}

	private void eraseEditPartFeedback() {
		getTargetEditPart().eraseSourceFeedback(getChangeBoundsRequest());
		getTargetEditPart().eraseTargetFeedback(getChangeBoundsRequest());
	}

	private void showEditPartFeedback() {
		getTargetEditPart().showSourceFeedback(getChangeBoundsRequest());
		getTargetEditPart().showTargetFeedback(getChangeBoundsRequest());
	}

	/**
	 * @param leftDelta The delta between the initial and the resized leftmost edge 
	 */
	public void setLeftDelta(int leftDelta) {
		this.leftDelta = leftDelta;
	}

	/**
	 * @return The delta between the initial and the resized left edge
	 */
	public int getLeftDelta() {
		return leftDelta;
	}

	/**
	 * @param rightDelta The delta between the initial and the resized left edge
	 */
	public void setRightDelta(int rightDelta) {
		this.rightDelta = rightDelta;
	}

	/**
	 * @return The delta between the initial and the resized top edge
	 */
	public int getRightDelta() {
		return rightDelta;
	}

	/**
	 * @param topDelta The delta between the initial and the resized top edge
	 */
	public void setTopDelta(int topDelta) {
		this.topDelta = topDelta;
	}

	/**
	 * @return The delta between the initial and the resized top edge
	 */
	public int getTopDelta() {
		return topDelta;
	}

	/**
	 * @param bottomDelta The delta between the initial and the resized bottom edge
	 */
	public void setBottomDelta(int bottomDelta) {
		this.bottomDelta = bottomDelta;
	}

	/**
	 * @return The delta between the initial and the resized bottom edge
	 */
	public int getBottomDelta() {
		return bottomDelta;
	}

	/**
	 * @param targetEditPart The target edit part
	 */
	public void setTargetEditPart(INodeEditPart targetEditPart) {
		this.targetEditPart = targetEditPart;
	}

	/**
	 * @return The target edit part
	 */
	public INodeEditPart getTargetEditPart() {
		return targetEditPart;
	}

}
