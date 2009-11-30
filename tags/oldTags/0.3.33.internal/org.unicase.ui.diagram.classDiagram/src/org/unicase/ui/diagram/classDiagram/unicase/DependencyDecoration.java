/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.diagram.classDiagram.unicase;

import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.DelegatingLayout;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.PointList;

/**
 * @author schroech
 */
public class DependencyDecoration extends ComposablePolygonDecoration {

	/**
	 * Default constructor.
	 */
	public DependencyDecoration() {
		super();
		setTemplate(ARROW.getCopy());
		setBoundPoint(new Point(-1, 0));
		setFill(true);
		setBackgroundColor(ColorConstants.white);

		setLayoutManager(new DelegatingLayout());
	}

	private static final PointList ARROW = new PointList(new int[] { //
		//
			-1, 1, //
			0, 0, //
			-1, -1, //
			0, 0, //
			-1, 1, //
		});
}
