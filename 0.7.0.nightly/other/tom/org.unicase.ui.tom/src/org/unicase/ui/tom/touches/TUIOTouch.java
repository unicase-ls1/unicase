/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.tom.touches;

import java.awt.Dimension;
import java.util.List;

import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.PointList;
import org.unicase.ui.tom.TouchDispatch;
import org.unicase.ui.tum.tuio.TuioCursor;
import org.unicase.ui.tum.tuio.TuioPoint;

/**
 * @author schroech
 *
 */
public class TUIOTouch extends SingleTouch implements Touch {

	private TuioCursor cursor;
	private Dimension screenSize;
	private final PointList path = new PointList();
	private final PointList absolutePath = new PointList();

	/**
	 * @param cursor The {@link TuioCursor} corresponding to this touch
	 * @param screenSize The screen size, required to map the {@link TuioCursor} relative coordinates to absolute corrdinates 
	 */
	public TUIOTouch(TuioCursor cursor, Dimension screenSize) {
		super();
		this.cursor = cursor;
		this.screenSize = screenSize;
	}

	/*** {@inheritDoc}
	 * @see org.unicase.ui.tom.touches.Touch#getPosition()
	 */
	public Point getPosition() {
		Point position = new Point(getX(), getY());
		return position;
	}

	/*** {@inheritDoc}
	 * @see org.unicase.ui.tom.touches.Touch#getX()
	 */
	public int getX() {
		int xPos = (int) (cursor.getX() * screenSize.getWidth()
				- TouchDispatch.getInstance().getEditorBounds().x 
				+ TouchDispatch.getInstance().getViewportOffset().x);
		return xPos;
	}

	/*** {@inheritDoc}
	 * @see org.unicase.ui.tom.touches.Touch#getY()
	 */
	public int getY() {
		int yPos = (int) (cursor.getY() * screenSize.getHeight()
				- TouchDispatch.getInstance().getEditorBounds().y 
				+ TouchDispatch.getInstance().getViewportOffset().y);
		return yPos;
	}

	/*** {@inheritDoc}
	 * @see org.unicase.ui.tom.touches.SingleTouch#update()
	 */
	@Override
	public void update() {

	}

	/*** {@inheritDoc}
	 * @see org.unicase.ui.tom.touches.SingleTouch#getAbsolutePath()
	 */
	@Override
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
	
	/*** {@inheritDoc}
	 * @see org.unicase.ui.tom.touches.SingleTouch#getPath()
	 */
	@Override
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

	/*** {@inheritDoc}
	 * @see org.unicase.ui.tom.touches.Touch#getAbsolutePosition()
	 */
	public Point getAbsolutePosition() {
		Point position = new Point(getAbsoluteX(), getAbsoluteY());
		return position;
	}

	/*** {@inheritDoc}
	 * @see org.unicase.ui.tom.touches.Touch#getAbsoluteX()
	 */
	public int getAbsoluteX() {
		int xPos = (int) (cursor.getX() * screenSize.getWidth());
		return xPos;
	}

	/*** {@inheritDoc}
	 * @see org.unicase.ui.tom.touches.Touch#getAbsoluteY()
	 */
	public int getAbsoluteY() {
		int yPos = (int) (cursor.getY() * screenSize.getHeight());
		return yPos;
	}
	
}
