package org.unicase.ui.tom.classDiagram.unicase;

import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.DelegatingLayout;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.PointList;

/**
 * @author schroech
 *
 */
public class DependencyDecoration extends ComposablePolygonDecoration{

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
