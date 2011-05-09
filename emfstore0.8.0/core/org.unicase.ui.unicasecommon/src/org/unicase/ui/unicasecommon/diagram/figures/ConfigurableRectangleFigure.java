/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.unicasecommon.diagram.figures;

import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.Shape;
import org.eclipse.draw2d.geometry.Rectangle;

// dengler: reuse from other diagram, clarify copyright.
/**
 * A Rectangle Figure whose borders are drawn depending on the borders attribute.
 * 
 * @author schroech
 */
public class ConfigurableRectangleFigure extends Shape {

	private String borders;
	private boolean north;
	private boolean south;
	private boolean east;
	private boolean west;

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw2d.StackLayout#layout(org.eclipse.draw2d.IFigure)
	 */
	@Override
	protected void fillShape(Graphics graphics) {
		graphics.fillRectangle(getBounds());
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw2d.StackLayout#layout(org.eclipse.draw2d.IFigure)
	 */
	@Override
	protected void outlineShape(Graphics graphics) {

		Rectangle r = getBounds();

		if (north) {
			int x1 = r.x + lineWidth / 2;
			int x2 = (r.x + lineWidth / 2) + (r.width - Math.max(1, lineWidth));

			int y1 = r.y + lineWidth / 2;
			int y2 = y1;

			graphics.drawLine(x1, y1, x2, y2);
		}
		if (south) {
			int x1 = r.x + lineWidth / 2;
			int x2 = (r.x + lineWidth / 2) + (r.width - Math.max(1, lineWidth));

			int y1 = (r.y + lineWidth / 2) + (r.height - Math.max(1, lineWidth));
			int y2 = y1;

			graphics.drawLine(x1, y1, x2, y2);
		}
		if (east) {
			int x1 = (r.x + lineWidth / 2) + (r.width - Math.max(1, lineWidth));
			int x2 = x1;

			int y1 = r.y + lineWidth / 2;
			int y2 = (r.y + lineWidth / 2) + (r.height - Math.max(1, lineWidth));

			graphics.drawLine(x1, y1, x2, y2);
		}
		if (west) {
			int x1 = r.x + lineWidth / 2;
			int x2 = x1;

			int y1 = r.y + lineWidth / 2;
			int y2 = (r.y + lineWidth / 2) + (r.height - Math.max(1, lineWidth));

			graphics.drawLine(x1, y1, x2, y2);
		}
	}

	/**
	 * Sets the borders of the rectangle The input string is parsed for occurences of the letters 'N','S','E' and 'W',
	 * which denote the four orientations.
	 * 
	 * @param borders The input string.
	 */
	public void setBorders(String borders) {
		this.borders = borders;

		if (borders.contains("N")) {
			north = true;
		}
		if (borders.contains("S")) {
			south = true;
		}
		if (borders.contains("E")) {
			east = true;
		}
		if (borders.contains("W")) {
			west = true;
		}
	}

	/**
	 * @return Returns a string denoting the border orientations which are drawn
	 */
	public String getBorders() {
		return borders;
	}

}
