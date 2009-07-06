package org.unicase.ui.usecaseDiagram.unicase;

import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.geometry.Insets;
import org.eclipse.gmf.runtime.draw2d.ui.figures.OneLineBorder;
import org.eclipse.swt.SWT;


public class OneLineDashedBorder extends OneLineBorder {
	@Override
	public void paint(IFigure figure, Graphics graphics, Insets insets) {
		graphics.setLineStyle(SWT.LINE_DASH);
		super.paint(figure, graphics, insets);
	}
}
