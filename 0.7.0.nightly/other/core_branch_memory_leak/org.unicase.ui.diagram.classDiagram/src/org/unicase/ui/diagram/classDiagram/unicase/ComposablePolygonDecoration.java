/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.diagram.classDiagram.unicase;

import org.eclipse.draw2d.PolygonDecoration;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.Transform;

/**
 * @author schroech
 */
public class ComposablePolygonDecoration extends PolygonDecoration implements ComposableRotatableDecoration {

	// duplicates PolylineDecoration#transform field
	// created to calculate EndPoint
	private Transform endPointTransform = new Transform();

	private Point myBoundPoint;

	/**
	 * Default constructor.
	 */
	public ComposablePolygonDecoration() {
		setScaleEx(7, 3);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.unicase.ui.diagram.classDiagram.unicase.ComposableRotatableDecoration#getBoundPoint()
	 */
	public Point getBoundPoint() {
		return endPointTransform.getTransformed(myBoundPoint);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw2d.PolygonDecoration#setLocation(org.eclipse.draw2d.geometry.Point)
	 */
	@Override
	public void setLocation(Point p) {
		super.setLocation(p);
		endPointTransform.setTranslation(p.x, p.y);
	}

	/**
	 * @param point The center point
	 */
	public void setBoundPoint(Point point) {
		myBoundPoint = point;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw2d.PolygonDecoration#setScale(double, double)
	 */
	@Override
	public void setScale(double x, double y) {
		super.setScale(x, y);
		setScaleEx(x, y);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw2d.PolygonDecoration#setRotation(double)
	 */
	@Override
	public void setRotation(double angle) {
		super.setRotation(angle);
		setRotationEx(angle);
	}

	/**
	 * @param angle The angle by which the decoration should be rotated
	 */
	public void setRotationEx(double angle) {
		endPointTransform.setRotation(angle);
	}

	/**
	 * @param x The value by which the decoration in x dimension
	 * @param y The value by which the decoration in y dimension
	 */
	public void setScaleEx(double x, double y) {
		if (endPointTransform == null) {
			endPointTransform = new Transform();
		}
		endPointTransform.setScale(x, y);
	}

}
