package org.unicase.ui.diagrams.urml.figures;

import org.eclipse.draw2d.ConnectionAnchor;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.PointList;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gmf.runtime.gef.ui.figures.NodeFigure;
import org.eclipse.gmf.runtime.gef.ui.figures.SlidableAnchor;

public class IconSizeNodeFigure extends NodeFigure {
	public IconSizeNodeFigure() {
		super();
	}

	@Override
	public PointList getPolygonPoints() {
		PointList points = new PointList(1);
		Rectangle anchRect = getHandleBounds();
		points.addPoint(anchRect.x + anchRect.width / 2, anchRect.y + 24);
		return points;
	}

	@Override
	protected ConnectionAnchor createDefaultAnchor() {
		return new SlidableAnchor(this) {
			@Override
			public Point getLocation(Point reference) {
				return getPolygonPoints().getFirstPoint();
			}
		};
	}
}