/**
 * <copyright> Copyright (c) 2015-2016 Chair of Applied Software Engineering, Technische Universität München (TUM).
 * All rights reserved. This program and the accompanying materials are made available under the terms of
 * the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.diagram.componentDiagram.unicase;

import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.PolylineDecoration;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.PointList;
import org.eclipse.draw2d.geometry.Rectangle;

/**
 * Decoration for required interfaces.
 * 
 * @author koegel
 */
public class RequiredInterfaceDecoration extends PolylineDecoration {
	private static final Point TEMP_POINT = new Point();
	private static final Rectangle TEMP_RECTANGLE = new Rectangle();

	private static final int GAP = 3;
	private int myRadius;
	private int myAngle;

	/**
	 * Constructor.
	 */
	public RequiredInterfaceDecoration() {
		setRadius(1);
		setScale(1, 1);
	}

	/**
	 * Set the radius.
	 * 
	 * @param radius the radius
	 */
	public void setRadius(int radius) {
		myRadius = radius;
		setTemplate(new PointList(new int[] { radius - GAP, 0 }));
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw2d.Polyline#getBounds()
	 */
	@Override
	public Rectangle getBounds() {
		if (bounds == null) {
			// implicitly sets bounds
			super.getBounds();
			computeArcBounds(TEMP_RECTANGLE);
			TEMP_RECTANGLE.expand(1, 1);
			bounds.union(TEMP_RECTANGLE);
		}
		return bounds;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw2d.PolylineDecoration#setRotation(double)
	 */
	@Override
	public void setRotation(double angle) {
		super.setRotation(angle);
		myAngle = (int) (angle * 180 / Math.PI);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw2d.Polyline#fillShape(org.eclipse.draw2d.Graphics)
	 */
	@Override
	protected void fillShape(Graphics g) {
		// do nothing
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw2d.Polyline#outlineShape(org.eclipse.draw2d.Graphics)
	 */
	@Override
	protected void outlineShape(Graphics g) {
		computeArcBounds(TEMP_RECTANGLE);
		g.drawArc(TEMP_RECTANGLE, -myAngle + 90, 180);
	}

	private void computeArcBounds(Rectangle output) {
		if (getPoints().size() == 0) {
			output.setSize(0, 0);
			return;
		}
		getPoints().getPoint(TEMP_POINT, 0);
		output.setLocation(TEMP_POINT.x - myRadius, TEMP_POINT.y - myRadius);
		output.setSize(2 * myRadius, 2 * myRadius);
	}
}
