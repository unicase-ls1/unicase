/**
 * <copyright> Copyright (c) 2015-2016 Chair of Applied Software Engineering, Technische Universität München (TUM).
 * All rights reserved. This program and the accompanying materials are made available under the terms of
 * the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.unicasecommon.diagram.shapes;

import org.eclipse.draw2d.Shape;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Rectangle;

/**
 * @author denglerm This class is necessary for the StickMan figure
 */

public abstract class AbstractProportionalShape extends Shape {

	/**
	 * . The constructor
	 */
	public AbstractProportionalShape() {
	}

	/**
	 * . This method sets the Width to Height Ratio
	 * 
	 * @param w2hRatio
	 *            the ratio
	 */
	protected void setW2HRatio(float w2hRatio) {
		myW2HRatio = w2hRatio;
		myIsKeepingProportions = true;
	}

	/**
	 * . This method sets if the proportions should be kept
	 * 
	 * @param newValue
	 *            the boolean value
	 */
	protected void setKeepingProportions(boolean newValue) {
		myIsKeepingProportions = newValue;
	}

	/**
	 * .
	 * 
	 * @return true if proportions should be kept
	 */
	protected boolean isKeepingProportions() {
		return myIsKeepingProportions;
	}

	/**
	 * If keeping proportions, returns the maximum rectangle that is fully
	 * inside the bounds and has the specified proportions. Otherwise, returns
	 * the bounds.
	 * 
	 * @return the bounding {@link Rectangle}
	 */
	public Rectangle getProportionalBounds() {
		Rectangle area = getClientArea();
		if (!myIsKeepingProportions || myW2HRatio == 0.0f || area.height == 0) {
			return new Rectangle(area);
		}

		int newX = area.x;
		int newY = area.y;
		int newW = area.width;
		int newH = area.height;

		float currentRatio = ((float) newW) / ((float) newH);
		float discrepancy = currentRatio / myW2HRatio;

		if (discrepancy < 1) {
			// we are too high.
			newH = Math.round(newH * discrepancy);
			newY += (area.height - newH) / 2;
		} else {
			// we are too wide
			newW = Math.round(newW / discrepancy);
			newX += (area.width - newW) / 2;
		}
		return new Rectangle(newX, newY, newW, newH);
	}

	/**
	 * If keeping proportions, returns the dimension tweaked by the same factor
	 * as the proportional bounds relate to the original bounds. Otherwise,
	 * returns the original dimension.
	 * 
	 * @param d
	 *            the Dimension
	 * @return the original {@link Dimension}
	 */
	public Dimension adjustDimension(Dimension d) {
		Rectangle area = getClientArea();
		if (!myIsKeepingProportions || myW2HRatio == 0.0f || area.height == 0) {
			return new Dimension(d);
		}

		float currentRatio = ((float) area.width) / ((float) area.height);
		float discrepancy = currentRatio / myW2HRatio;

		if (discrepancy < 1) {
			return new Dimension(d.width, (int) (d.height * discrepancy));
		} else {
			return new Dimension((int) (d.width / discrepancy), d.height);
		}
	}

	private float myW2HRatio = 1.0f;
	private boolean myIsKeepingProportions;
}
