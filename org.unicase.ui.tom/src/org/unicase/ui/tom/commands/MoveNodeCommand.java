package org.unicase.ui.tom.commands;

import org.eclipse.draw2d.geometry.Point;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.diagram.ui.editparts.DiagramEditPart;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.widgets.Display;

public class MoveNodeCommand extends MoveCommand{

	public MoveNodeCommand(DiagramEditPart diagramEditPart) {
		super(diagramEditPart);
	}

	//From Figure
//	protected IFigure findDescendantAtExcluding(int x, int y, TreeSearch search) {
//		PRIVATE_POINT.setLocation(x, y);
//		translateFromParent(PRIVATE_POINT);
//		if (!getClientArea(Rectangle.SINGLETON).contains(PRIVATE_POINT))
//			return null;
//
//		x = PRIVATE_POINT.x;
//		y = PRIVATE_POINT.y;
//		IFigure fig;
//		for (int i = children.size(); i > 0;) {
//			i--;
//			fig = (IFigure)children.get(i);
//			if (fig.isVisible()) {
//				fig = fig.findFigureAt(x, y, search);
//				if (fig != null)
//					return fig;
//			}
//		}
//		//No descendants were found
//		return null;
//	}
	
	//From AbstractTool
//	public void setViewer(EditPartViewer viewer) {
//		if (viewer == currentViewer)
//			return;
//
//		setCursor(null);
//		currentViewer = viewer;
//		if (currentViewer != null) {
//			org.eclipse.swt.graphics.Point p = currentViewer.getControl().toControl(
//				Display.getCurrent().getCursorLocation());
//			getCurrentInput().setMouseLocation(p.x, p.y);
//		}
//		refreshCursor();
//	}
	
	//From DragEditPartsTracker
//	protected void repairStartLocation() {
//		if (sourceRelativeStartPoint == null)
//			return;
//		IFigure figure = ((GraphicalEditPart)getSourceEditPart()).getFigure();
//		PrecisionPoint newStart = (PrecisionPoint)sourceRelativeStartPoint.getCopy();
//		figure.translateToAbsolute(newStart);
//		Point delta = new Point(newStart.x - getStartLocation().x,
//		                        newStart.y - getStartLocation().y);
//		setStartLocation(newStart);
//		// sourceRectangle and compoundSrcRect need to be updated as well when auto-scrolling
//		if (sourceRectangle != null)
//			sourceRectangle.translate(delta);
//		if (compoundSrcRect != null)
//			compoundSrcRect.translate(delta);
//	}

	
	public void execute() {
		final MouseEvent mouseEvent = createMouseEventAtPosition(getPosition());
		
		Runnable runnable = new Runnable(){
			public void run(){
				getDragTracker().mouseUp(mouseEvent, getDiagramEditPart().getViewer());
			}
		};
		Display.getDefault().syncExec(runnable);
	}

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
	
	public Request createRequest() {
		// TODO Auto-generated method stub
		return null;
	}

	public Command getCommand() {
		// TODO Auto-generated method stub
		return null;
	}
}
