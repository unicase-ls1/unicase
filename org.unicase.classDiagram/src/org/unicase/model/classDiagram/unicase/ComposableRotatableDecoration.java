package org.unicase.model.classDiagram.unicase;

import org.eclipse.draw2d.RotatableDecoration;
import org.eclipse.draw2d.geometry.Point;


public interface ComposableRotatableDecoration extends RotatableDecoration {
	Point getBoundPoint();
}
