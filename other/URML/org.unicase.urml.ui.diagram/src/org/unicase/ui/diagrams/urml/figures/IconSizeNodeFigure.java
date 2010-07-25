package org.unicase.ui.diagrams.urml.figures;

import org.eclipse.draw2d.geometry.PointList;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gmf.runtime.gef.ui.figures.DefaultSizeNodeFigure;

public class IconSizeNodeFigure extends DefaultSizeNodeFigure {
	private enum Mode {
		ICON, MIDDLE
	}

	private Mode selectedMode;

	public IconSizeNodeFigure(int width, int height) {
		super(width, height);
		selectedMode = Mode.ICON;
	}

	@Override
	public PointList getPolygonPoints() {
		if (selectedMode == Mode.ICON) {
			PointList points = new PointList(5);
			Rectangle anchRect = getHandleBounds();
			int mid = anchRect.x + anchRect.width / 2;
			points.addPoint(mid - 24, anchRect.y);
			points.addPoint(mid - 24, anchRect.y + 48);
			points.addPoint(mid + 24, anchRect.y + 48);
			points.addPoint(mid + 24, anchRect.y);
			points.addPoint(mid - 24, anchRect.y);
			return points;
		} else if (selectedMode == Mode.MIDDLE) {
			PointList points = new PointList(1);
			Rectangle anchRect = getHandleBounds();
			points.addPoint(anchRect.x + anchRect.width / 2, anchRect.y + 24);
			return points;
		}
		return super.getPolygonPoints();
	}
}