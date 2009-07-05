package org.unicase.ui.diagram.componentDiagram.unicase;

import java.util.List;

import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.StackLayout;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Rectangle;

public class CenterLayoutParent extends StackLayout {

	@Override
	public void layout(IFigure figure) {

		IFigure parent = figure.getParent();
		Rectangle r = parent.getClientArea();
		List children = figure.getChildren();
		IFigure child;
		Dimension d;
		for (int i = 0; i < children.size(); i++) {
			child = (IFigure) children.get(i);
			d = child.getPreferredSize(r.width, r.height);
			d.width = Math.min(d.width, r.width);
			d.height = Math.min(d.height, r.height);
			Rectangle childRect = new Rectangle(r.x + (r.width - d.width) / 2, r.y + (r.height - d.height) / 2,
				d.width, d.height);
			child.setBounds(childRect);
		}
	}
}