package org.unicase.ui.tom.operations;

import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.requests.ChangeBoundsRequest;
import org.eclipse.gmf.runtime.diagram.ui.editparts.DiagramEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.INodeEditPart;
import org.eclipse.gmf.runtime.diagram.ui.requests.RequestConstants;

public class AltMoveNodeOperation extends MoveOperation {

	private ChangeBoundsRequest changeBoundsRequest;

	/**
	 * @param diagramEditPart
	 *            The {@link DiagramEditPart} on which this operation operates
	 * @param targetEditPart
	 *            The {@link IGraphicalEditPart} to be moved
	 */
	public AltMoveNodeOperation(DiagramEditPart diagramEditPart,
			INodeEditPart targetEditPart) {
		super(diagramEditPart, (IGraphicalEditPart) targetEditPart);
	}

	@Override
	public void finish() {
		eraseEditPartFeedback();

		Command command = getTargetEditPart().getCommand(
				getChangeBoundsRequest());
		getDiagramEditPart().getDiagramEditDomain().getDiagramCommandStack()
				.execute(command);
	}

	@Override
	public void prepare(Point point) {
		setPosition(point);
	}

	@Override
	public void update(Point point) {

		int horizontalDelta = point.x - getPosition().x;
		int verticalDelta = point.y - getPosition().y;

		getChangeBoundsRequest().setMoveDelta(new Point(horizontalDelta,
				verticalDelta));

		showEditPartFeedback();
	}

	private void eraseEditPartFeedback() {
		getTargetEditPart().eraseSourceFeedback(getChangeBoundsRequest());
		getTargetEditPart().eraseTargetFeedback(getChangeBoundsRequest());
	}

	private void showEditPartFeedback() {
		getTargetEditPart().showSourceFeedback(getChangeBoundsRequest());
		getTargetEditPart().showTargetFeedback(getChangeBoundsRequest());
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
				RequestConstants.REQ_MOVE);
		request.setEditParts(getTargetEditPart());
		request.getExtendedData().clear();
		request.setConstrainedMove(false);

		return request;
	}
}
