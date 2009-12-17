/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.diagram.usecaseDiagram.unicase;

import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.geometry.PointList;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.swt.graphics.Color;

/**
 * @author denglerm This class represents the Stickman figure
 */
public class StickMan extends ShadowShape {
	/**
	 * . The constructor
	 */
	public StickMan() {
		this(false, ColorConstants.white, ColorConstants.black);
	}

	/**
	 * . The constructor
	 * 
	 * @param is3D
	 *            true for 3D appearance
	 * @param backgroundColor
	 *            the background color
	 * @param foregroundColor
	 *            the foreground color
	 */
	public StickMan(boolean is3D, Color backgroundColor, Color foregroundColor) {
		super(is3D, backgroundColor, foregroundColor);
		setKeepingProportions(true);
		setW2HRatio(BASE_W / BASE_H);
	}

	/**
	 * @param graphics
	 *            The Graphics object
	 * @param bounds
	 *            The bounding rectangle
	 */
	@Override
	protected void outlineShape(Graphics graphics, Rectangle bounds) {
		PointList pl = setupPoints(bounds);
		graphics.drawPolygon(pl);
		int add = graphics.getLineWidth() / 2;
		graphics
				.drawOval(new Rectangle(ovalX, ovalY, ovalD + add, ovalD + add));
	}

	/**
	 * @param graphics
	 *            The Graphics object
	 * @param bounds
	 *            The bounding rectangle
	 */
	@Override
	protected void fillShape(Graphics graphics, Rectangle bounds) {
		PointList pl = setupPoints(bounds);
		graphics.fillPolygon(pl);
		int add = graphics.getLineWidth() / 2;
		graphics
				.fillOval(new Rectangle(ovalX, ovalY, ovalD + add, ovalD + add));
	}

	/**
	 * @param rect
	 *            The Rectangle
	 * @return the PointList for the Stickman
	 */
	protected PointList setupPoints(Rectangle rect) {
		int[] xPoints = new int[P_NUM];
		int[] yPoints = new int[P_NUM];

		PointList pl = new PointList(10);
		int w = (rect.width / 2) * 2;
		int h = rect.height;
		int x1 = w / 2;
		int y1 = (Math.round(h * FACTOR1) / 2) * 2;
		int y2 = Math.round(h * FACTOR2);
		int y3 = h - (x1 - 1);
		int step = Math.round(w / BASE_W);
		if (step < 1) {
			step = 1;
		}

		// set positive points. (0...9)
		xPoints[0] = step;
		yPoints[0] = y1;
		xPoints[1] = step;
		yPoints[1] = y2 - step;
		xPoints[2] = x1;
		yPoints[2] = y2 - step;
		xPoints[3] = x1;
		yPoints[3] = y2 + step;
		xPoints[4] = step;
		yPoints[4] = y2 + step;
		xPoints[5] = step;
		yPoints[5] = y3 - step;
		xPoints[6] = x1;
		yPoints[6] = h - step;
		xPoints[7] = x1;
		yPoints[7] = h;
		xPoints[8] = x1 - 2 * step;
		yPoints[8] = h;
		xPoints[9] = 0;
		yPoints[9] = y3 + step;

		// reflect points 0..8
		for (int i = 0; i <= 8; i++) {
			xPoints[18 - i] = -xPoints[i];
			yPoints[18 - i] = yPoints[i];
		}

		// close polyline.
		xPoints[19] = xPoints[0];
		yPoints[19] = yPoints[0];

		// shift all points and copy to integer.
		for (int i = 0; i < P_NUM; i++) {
			xPoints[i] += x1;

			xPoints[i] += rect.x;
			yPoints[i] += rect.y;
		}

		for (int i = 0; i < xPoints.length; i++) {
			pl.addPoint(xPoints[i], yPoints[i]);
		}

		// head-oval
		ovalD = y1;
		ovalX = x1 - ovalD / 2 + rect.x;
		ovalY = rect.y;

		return pl;
	}

	private static final float BASE_W = 31 - 1;
	private static final float BASE_H = 50 - 1;
	private static final float FACTOR1 = 16f / BASE_H;
	private static final float FACTOR2 = 22f / BASE_H;

	private static final int P_NUM = 20;

	private int ovalX;
	private int ovalY;
	private int ovalD;
}
