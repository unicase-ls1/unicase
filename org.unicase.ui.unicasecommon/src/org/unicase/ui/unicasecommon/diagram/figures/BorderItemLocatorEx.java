/**
 * <copyright> Copyright (c) 2015-2016 Chair of Applied Software Engineering, Technische Universität München (TUM).
 * All rights reserved. This program and the accompanying materials are made available under the terms of
 * the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.unicasecommon.diagram.figures;

import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.PositionConstants;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gmf.runtime.diagram.ui.figures.BorderItemLocator;

// dengler: delete unused methods
/**
 * @author denglerm This class is used to locate diagram labels centered and below a diagram node
 */
public class BorderItemLocatorEx extends BorderItemLocator {

	/**
	 * @param parentFigure the parent figure
	 */
	public BorderItemLocatorEx(IFigure parentFigure) {
		super(parentFigure);
	}

	/**
	 * @param parentFigure the parent figure
	 * @param preferredSide the preferred side of the parent figure on which to place this border item as defined in
	 *            {@link PositionConstants}
	 */
	public BorderItemLocatorEx(IFigure parentFigure, int preferredSide) {
		super(parentFigure, preferredSide);
	}

	/**
	 * @param borderItem the border item to be placed at the parent figure
	 * @param parentFigure the parent figure
	 * @param constraint the constraint
	 */
	public BorderItemLocatorEx(IFigure borderItem, IFigure parentFigure, Rectangle constraint) {
		super(borderItem, parentFigure, constraint);
	}

	/**
	 * Determines the position (South-Centered) of the borderItem.
	 * 
	 * @param borderItem The figure to relocate
	 */
	@Override
	public void relocate(IFigure borderItem) {

		Rectangle bounds = getParentBorder();
		int parentFigureWidth = bounds.width;
		int parentFigureHeight = bounds.height;
		int parentFigureX = bounds.x;
		int parentFigureY = bounds.y;
		int x = parentFigureX;
		int y = parentFigureY;
		x += parentFigureWidth / 2;
		y = parentFigureY + parentFigureHeight;
		Dimension borderItemSize = getSize(borderItem);
		Point location = new Point(x - borderItemSize.width / 2, y + getBorderItemOffset().height);
		borderItem.setBounds(new Rectangle(location, borderItemSize));
	}
}
