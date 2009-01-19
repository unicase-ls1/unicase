package org.unicase.ui.tom.gestures;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.eclipse.draw2d.Figure;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gef.EditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.DiagramEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.figures.BorderItemsAwareFreeFormLayer;
import org.eclipse.gmf.runtime.draw2d.ui.figures.IOvalAnchorableFigure;
import org.eclipse.gmf.runtime.draw2d.ui.figures.IPolygonAnchorableFigure;
import org.unicase.ui.tom.TouchDispatch;
import org.unicase.ui.tom.commands.MoveNodeCommand;
import org.unicase.ui.tom.touches.Touch;

public class MoveNodeGesture extends AbstractGesture {

	private Touch candidateTouch;
	private Touch moveTouch;
	private EditPart initialEditPart;
	private MoveNodeCommand moveCommand; 

	public MoveNodeGesture(TouchDispatch dispatch, DiagramEditPart diagramEditPart) {
		super(dispatch, diagramEditPart);

		setMoveCommand(new MoveNodeCommand(diagramEditPart));

	}
	
	@Override
	public void execute() {
		if (getCanExecute()) {
			super.execute();
			setMoveTouch(getCandidateTouch());
			setCandidateTouch(null);

			Point firstPoint = getMoveTouch().getPath().getFirstPoint();

			getMoveCommand().prepareMove(
					firstPoint,
					(GraphicalEditPart)getInitialEditPart());	
		}
		
		//don't call setCanExecute(false) here 
	}

	@SuppressWarnings("unchecked")
	@Override
	public EditPart findTouchedEditPartExcluding(Touch touch, Collection exclusions) {
		EditPart touchedEditPart = super.findTouchedEditPartExcluding(
				touch, 
				exclusions);

		if (touchedEditPart != null) {
			return touchedEditPart;
		}

		List children = getNodeLayer().getChildren();
		List nodes = null;
		for (Object child: children) {
			if (child instanceof BorderItemsAwareFreeFormLayer) {
				 nodes = ((BorderItemsAwareFreeFormLayer)child).getChildren();
			}
		}
		
		for (Object node : nodes) {
			if (node instanceof Figure) {
				if (shapeContainsPoint(
						(Figure) node,
						touch.getPosition())) {
					EditPart editPart = findFigureEditPart((Figure) node);
					return editPart;
				}
			}
		}

		return null;
	}
	
	private boolean shapeContainsPoint(IFigure figure, Point position) {
		
		boolean containsPoint = false;
		
		if (figure instanceof IOvalAnchorableFigure) {
			//If the figure is an oval we assume the 
			//oval's hit testing is good enough   
			containsPoint =  figure.containsPoint(position);	
		}else if (figure instanceof IPolygonAnchorableFigure) {
			Rectangle bounds = ((IPolygonAnchorableFigure) figure).getPolygonPoints().getBounds().getCopy();
			bounds.expand(TOUCH_DIAMETER/2, TOUCH_DIAMETER/2);
			containsPoint = bounds.contains(position);
		}else{
			Rectangle bounds = figure.getBounds().getCopy();
			bounds.expand(TOUCH_DIAMETER/2, TOUCH_DIAMETER/2);
			containsPoint = bounds.contains(position);
		}
		
		return containsPoint;
	}

	@SuppressWarnings("unchecked")
	@Override
	public void handleTouchAdded(Touch touch) {		
		if (getAcceptsTouches()) {
			if (getDispatch().getActiveTouches().size() > 1) {
				setAcceptsTouches(false);

				setCandidateTouch(null);
				setMoveTouch(null);

				return;
			}

			List exclusions = new ArrayList();
			exclusions.add(getDiagramEditPart());
			exclusions.add(getDiagramEditPart().getParent());
			
			EditPart touchedEditPart = findTouchedEditPartExcluding(touch, exclusions);
			touchedEditPart = getPrimaryEditPart(touchedEditPart);

			if (touchedEditPart != null) {
				setCandidateTouch(touch);
				setInitialEditPart(touchedEditPart);
			}else{
				setAcceptsTouches(false);

				setCandidateTouch(null);
				setMoveTouch(null);
				setInitialEditPart(null);
			}
		}
	}

	@Override
	public void handleTouchChanged(Touch touch) {
		if (touch == getCandidateTouch()) {
			if (getCandidateTouch().getPath().getMidpoint()
					.getDistance(getCandidateTouch().getPosition()) 
							> TOUCH_MOVEMENT_THRESHOLD) {
				setCanExecute(true);
			}
		}else if (touch == getMoveTouch()) {
			getMoveCommand().updateMove(touch.getPosition());
		}
	}

	@Override
	public void handleTouchRemoved(Touch touch) {
		if (touch == getMoveTouch()) {
			moveCommand.execute();
			setCanExecute(false);
		}
	}

	public void reset() {
		super.reset();

		//		setMoveTouch(null);
		setCandidateTouch(null);
	}

	public void setMoveTouch(Touch moveTouch) {
		this.moveTouch = moveTouch;
	}

	public Touch getMoveTouch() {
		return moveTouch;
	}

	public void setCandidateTouch(Touch candidateTouch) {
		this.candidateTouch = candidateTouch;
	}

	public Touch getCandidateTouch() {
		return candidateTouch;
	}

	protected void setMoveCommand(MoveNodeCommand moveCommand) {
		this.moveCommand = moveCommand;
	}

	protected MoveNodeCommand getMoveCommand() {
		return moveCommand;
	}

	public void setInitialEditPart(EditPart initialEditPart) {
		this.initialEditPart = initialEditPart;
	}

	public EditPart getInitialEditPart() {
		return initialEditPart;
	}

}
