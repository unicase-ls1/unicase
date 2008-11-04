package org.unicase.ui.componentDiagram.unicase;

import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gmf.runtime.diagram.ui.figures.BorderItemLocator;

public class ComponentBorderItemLocator extends BorderItemLocator {

	
	public ComponentBorderItemLocator(IFigure borderItem, IFigure parentFigure,
			Rectangle constraint) {
		super(borderItem, parentFigure, constraint);
		// TODO Auto-generated constructor stub
	}
	
	public ComponentBorderItemLocator(IFigure parentFigure) {
		super(parentFigure);
		// TODO Auto-generated constructor stub
	}
	

	public ComponentBorderItemLocator(IFigure parentFigure, int preferredSide) {
		super(parentFigure, preferredSide);
		// TODO Auto-generated constructor stub
	}

	public void relocate(IFigure borderItem) {
		
		Rectangle bounds = getParentBorder();	
		int parentFigureWidth = bounds.width;
		int parentFigureHeight = bounds.height;
		int parentFigureX = bounds.x;
		int parentFigureY = bounds.y;
		int x = parentFigureX;
		int y = parentFigureY;
		x += parentFigureWidth / 2;
		y = parentFigureY + parentFigureHeight;
		Dimension borderItemSize = getSize(borderItem);
		Point location = new Point(x - borderItemSize.width/2, y + getBorderItemOffset().height);
		borderItem.setBounds(new Rectangle(location, borderItemSize));
	}
}
