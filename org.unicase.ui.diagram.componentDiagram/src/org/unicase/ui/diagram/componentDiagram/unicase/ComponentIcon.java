/**
 * <copyright> Copyright (c) 2009-2012 Chair of Applied Software Engineering, Technische Universität München (TUM).
 * All rights reserved. This program and the accompanying materials are made available under the terms of
 * the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.diagram.componentDiagram.unicase;

import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.Shape;
import org.eclipse.draw2d.geometry.PointList;
import org.eclipse.draw2d.geometry.Rectangle;

/**
 * This shape is used to draw the component icon that is displayed in the right hand corner of a component. This is a
 * classifier rectangle with two smaller rectangles protruding from its left hand side.
 */
public class ComponentIcon extends Shape {
	/**
	 * Constructor.
	 */
	public ComponentIcon() {
		// Do nothing
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw2d.Shape#fillShape(org.eclipse.draw2d.Graphics)
	 */
	@Override
	protected void fillShape(Graphics graphics) {
		// No fill needed
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw2d.Shape#outlineShape(org.eclipse.draw2d.Graphics)
	 */
	@Override
	protected void outlineShape(Graphics graphics) {
		Rectangle r = new Rectangle();
		r.setBounds(getBounds());
		r.crop(getInsets());
		r.resize(-1, -1);

		PointList classifierRectangle = new PointList();
		Rectangle firstSmallRectangle = new Rectangle();
		Rectangle secondSmallRectangle = new Rectangle();

		// Classifier Rectangle
		classifierRectangle.addPoint(r.getTopLeft().translate(r.width / 4, (r.height * 17) / 100));
		classifierRectangle.addPoint(r.getTopLeft().translate(r.width / 4, 0));
		classifierRectangle.addPoint(r.getTopRight());
		classifierRectangle.addPoint(r.getBottomRight());
		classifierRectangle.addPoint(r.getBottomLeft().translate(r.width / 4, 0));
		classifierRectangle.addPoint(r.getTopLeft().translate(r.width / 4, (r.height * 83) / 100));

		// First Small Rectangle
		firstSmallRectangle.x = r.x;
		firstSmallRectangle.y = r.y + (r.height * 17) / 100;
		firstSmallRectangle.width = r.width / 2;
		firstSmallRectangle.height = r.height / 4;

		// Second Small Rectangle
		secondSmallRectangle.x = r.x;
		secondSmallRectangle.y = r.y + (r.height * 58) / 100;
		secondSmallRectangle.width = r.width / 2;
		secondSmallRectangle.height = r.height / 4;

		graphics.drawPolyline(classifierRectangle);
		graphics.drawRectangle(firstSmallRectangle);
		graphics.drawRectangle(secondSmallRectangle);
		graphics.drawLine(r.getTopLeft().translate(r.width / 4, r.height * 42 / 100), r.getTopLeft().translate(
			r.width / 4, r.height * 58 / 100));
	}

}
