/**
 * <copyright> Copyright (c) 2009-2012 Chair of Applied Software Engineering, Technische Universität München (TUM).
 * All rights reserved. This program and the accompanying materials are made available under the terms of
 * the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.diagram.classDiagram.unicase;

import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.DelegatingLayout;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.PointList;

/**
 * @author schroech
 */
public class GeneralizationDecoration extends ComposablePolygonDecoration {

	/**
	 * Designated constructor.
	 */
	public GeneralizationDecoration() {
		super();

		setTemplate(CLOSED_ARROW.getCopy());
		setBoundPoint(new Point(-1, 0));
		setFill(true);
		setBackgroundColor(ColorConstants.white);

		setLayoutManager(new DelegatingLayout());
	}

	private static final PointList CLOSED_ARROW = new PointList(new int[] { -1, 2, 0, 0, -1, -2, -1, 0, -1, 2, });

}
