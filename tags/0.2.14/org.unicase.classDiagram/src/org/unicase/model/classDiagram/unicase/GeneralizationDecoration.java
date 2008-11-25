package org.unicase.model.classDiagram.unicase;

import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.DelegatingLayout;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.PointList;

/**
 * @author schroech
 *
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


	private static final PointList CLOSED_ARROW = new PointList(new int[] {
					-1, 2,
					0, 0,
					-1, -2,
					-1, 0,
					-1, 2,
			});

}
