package org.unicase.ui.tom.classDiagram.unicase;

import org.eclipse.draw2d.DelegatingLayout;

/**
 * @author schroech
 *
 */
public class CompositeDecoration extends ComposablePolygonDecoration{
	
	/**
	 * Default constructor.
	 */
	public CompositeDecoration() {
		setLayoutManager(new DelegatingLayout());
	}

}
