package org.unicase.ui.diagram.urml.own.figures;

import org.eclipse.draw2d.ConnectionAnchor;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.PointList;
import org.eclipse.draw2d.geometry.PrecisionPoint;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gmf.runtime.gef.ui.figures.NodeFigure;
import org.eclipse.gmf.runtime.gef.ui.figures.SlidableAnchor;

/**
 * Figure to calculate the area where anchors should connect. Our implementation returns the center of the given icon.
 * 
 * @author Michael Haeger
 */
public class IconSizeNodeFigure extends NodeFigure {
	public IconSizeNodeFigure() {
		super();
	}

	@Override
	public PointList getPolygonPoints() {
		PointList points = new PointList(1);
		Rectangle anchRect = getHandleBounds();
		// TODO: change code to cover every icon height (at the moment 48px)
		points.addPoint(anchRect.x + anchRect.width / 2, anchRect.y + 24);
		return points;
	}

	// we only want to create our own anchor implementation
	@Override
	protected ConnectionAnchor createDefaultAnchor() {
		return new SlidableAnchor(this) {
			// if connection not intersects with the anchor area this function is called -so we return our calculated
			// point again (normally would return the center of the figure)
			@Override
			public Point getLocation(Point reference) {
				return getPolygonPoints().getFirstPoint();
			}
		};
	}

	// we only want to create our own anchor implementation
	@Override
	protected ConnectionAnchor createAnchor(PrecisionPoint p) {
		return createDefaultAnchor();
	}
}