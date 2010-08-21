package org.unicase.ui.diagram.urml.own.figures;

import org.eclipse.draw2d.PolylineDecoration;
import org.eclipse.draw2d.RotatableDecoration;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.PointList;
import org.eclipse.gmf.runtime.draw2d.ui.figures.PolylineConnectionEx;

/**
 * Normal polyline with shortened end points. IMPORTANT: do not use with a layout! (this results in endless repaints
 * caused by layout validation)
 * 
 * @author Michael Haeger
 */
public class ShortenedPolylineConnection extends PolylineConnectionEx {
	// space between given anchor point of the figure and the new calculated point
	private int spaceToMid;

	public ShortenedPolylineConnection() {
		this.setLineWidth(1);
		// TODO: make space depends on the icon size
		spaceToMid = 30;
		setTargetDecoration(createTargetDecoration());
	}

	private RotatableDecoration createTargetDecoration() {
		PolylineDecoration df = new PolylineDecoration();
		df.setLineWidth(1);
		return df;
	}

	// every time a point changes calculate the anchor again
	@Override
	public void addPoint(Point pt) {
		PointList points = getPoints();
		erase();
		points.addPoint(pt);
		calcNewEndPoints(points);
		repaint();
	}

	// every time a point changes calculate the anchor again
	@Override
	public void setPoint(Point pt, int index) {
		PointList points = getPoints();
		erase();
		points.setPoint(pt, index);
		calcNewEndPoints(points);
		repaint();
	}

	// every time a point changes calculate the anchor again
	@Override
	public void setPoints(PointList points) {
		calcNewEndPoints(points);
		super.setPoints(points);
	}

	// every time a point changes calculate the anchor again
	@Override
	public void removePoint(int index) {
		PointList points = getPoints();
		erase();
		points.removePoint(index);
		calcNewEndPoints(points);
		repaint();
	}

	private void calcNewEndPoints(PointList points) {
		int size = points.size();
		if (size > 1) {
			Point end = points.getLastPoint();
			Point nextToEnd = points.getPoint(size - 2);
			int dx = end.x - nextToEnd.x;
			int dy = end.y - nextToEnd.y;
			double radian = Math.atan((double) dy / dx);
			int mult = 1;
			if (dx >= 0) {
				mult = -1;
			}
			end.x += (int) (Math.cos(radian) * spaceToMid) * mult;
			end.y += (int) (Math.sin(radian) * spaceToMid) * mult;
			points.setPoint(end, size - 1);

			Point first = points.getFirstPoint();
			Point nextToFirst = points.getPoint(1);
			dx = first.x - nextToFirst.x;
			dy = first.y - nextToFirst.y;
			radian = Math.atan((double) dy / dx);
			mult = 1;
			if (dx >= 0) {
				mult = -1;
			}
			first.x += (int) (Math.cos(radian) * spaceToMid) * mult;
			first.y += (int) (Math.sin(radian) * spaceToMid) * mult;
			points.setPoint(first, 0);
		}
	}
}
