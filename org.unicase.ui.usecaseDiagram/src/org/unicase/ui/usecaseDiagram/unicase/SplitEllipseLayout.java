package org.unicase.ui.usecaseDiagram.unicase;


import org.eclipse.draw2d.BorderLayout;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.MarginBorder;
import org.eclipse.draw2d.geometry.Rectangle;


public class SplitEllipseLayout extends BorderLayout {
	private int myXMargin;

	private int myYMargin;

	@Override
	public void layout(IFigure container) {
		Rectangle r = container.getBounds();
		double a = r.width / 2;
		double b = r.height / 2;
		double sin45 = Math.sqrt(2) / 2;
		double cos45 = sin45;
		double diagx = a * sin45;
		double diagy = b * cos45;
		int newxmargin = (int) (a - diagx);
		int newymargin = (int) (b - diagy);
		if (newxmargin != myXMargin || newymargin != myYMargin) {
			myXMargin = newxmargin;
			myYMargin = newymargin;
			container.setBorder(new MarginBorder(myYMargin, myXMargin, myYMargin, myXMargin));
		}
		super.layout(container);
	}

}
