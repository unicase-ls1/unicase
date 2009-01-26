package org.unicase.model.classDiagram.unicase;

import org.eclipse.draw2d.RotatableDecoration;
import org.eclipse.draw2d.geometry.Point;

/**
 * @author schroech
 */
public interface ComposableRotatableDecoration extends RotatableDecoration {
	/**
	 * @return The decorations center
	 */
	Point getBoundPoint();
}
