package org.unicase.ui.tom.touches;

import java.awt.Dimension;
import java.util.List;

import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.PointList;
import org.unicase.ui.tom.TouchDispatch;
import org.unicase.ui.tum.tuio.TuioCursor;
import org.unicase.ui.tum.tuio.TuioPoint;

public class TUIOTouch extends SingleTouch implements Touch {

	private TuioCursor cursor;
	private Dimension screenSize;
	private final PointList path = new PointList();
	private final PointList absolutePath = new PointList();

	public TUIOTouch(TuioCursor cursor, Dimension screenSize) {
		super();
		this.cursor = cursor;
		this.screenSize = screenSize;
	}

	public Point getPosition() {
		Point position = new Point(getX(), getY());
		return position;
	}

	public int getX() {
		int xPos = (int) (cursor.getX() * screenSize.getWidth()
				- TouchDispatch.getInstance().getEditorBounds().x 
				+ TouchDispatch.getInstance().getViewportOffset().x);
		return xPos;
	}

	public int getY() {
		int yPos = (int) (cursor.getY() * screenSize.getHeight()
				- TouchDispatch.getInstance().getEditorBounds().y 
				+ TouchDispatch.getInstance().getViewportOffset().y);
		return yPos;
	}

	public void update() {

	}

	public PointList getAbsolutePath() {
		List<TuioPoint> tuioPath = cursor.getPath();

		int tuioPathCount = tuioPath.size();
		int pathCount = absolutePath.size();

		for (int i = (tuioPathCount - pathCount) - 1; i >= 0
				&& i < tuioPathCount; i++) {
			absolutePath
					.addPoint(
							(int) (tuioPath.get(i).getX()
									* screenSize.getWidth()),
							(int) (tuioPath.get(i).getY()
									* screenSize.getHeight()));
		}

		return absolutePath;
	}
	
	public PointList getPath() {
		List<TuioPoint> tuioPath = cursor.getPath();

		int tuioPathCount = tuioPath.size();
		int pathCount = path.size();

		for (int i = (tuioPathCount - pathCount) - 1; i >= 0
				&& i < tuioPathCount; i++) {
			path
					.addPoint(
							(int) (tuioPath.get(i).getX()
									* screenSize.getWidth()
									- TouchDispatch.getInstance().getEditorBounds().x 
									+ TouchDispatch.getInstance().getViewportOffset().x),
							(int) (tuioPath.get(i).getY()
									* screenSize.getHeight()
									- TouchDispatch.getInstance()
											.getEditorBounds().y + TouchDispatch
									.getInstance().getViewportOffset().y));
		}

		return path;
	}

	public Point getAbsolutePosition() {
		Point position = new Point(getAbsoluteX(), getAbsoluteY());
		return position;
	}

	public int getAbsoluteX() {
		int xPos = (int) (cursor.getX() * screenSize.getWidth());
		return xPos;
	}

	public int getAbsoluteY() {
		int yPos = (int) (cursor.getY() * screenSize.getHeight());
		return yPos;
	}
	
}
