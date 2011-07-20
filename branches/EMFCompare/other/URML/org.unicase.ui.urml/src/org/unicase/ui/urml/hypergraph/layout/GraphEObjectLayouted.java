package org.unicase.ui.urml.hypergraph.layout;

import java.util.HashSet;

import org.eclipse.emf.ecore.EObject;
import org.unicase.model.diagram.MEDiagram;

/**
 * Container class for the hypergraph layout. Stores position, size, angle of neighbors and the object.
 * 
 * @author Michael Haeger
 */
public class GraphEObjectLayouted {
	public EObject object;
	public double x, y;
	public double width, height;
	public double startAngle, endAngle;
	private boolean complete;
	public HashSet<MEDiagram> diagrams;

	public GraphEObjectLayouted(EObject object) {
		this(object, 0, 0, 0, 2 * Math.PI, 0);
	}

	public GraphEObjectLayouted(EObject object, double x, double y, double startAngle, double endAngle, int depth) {
		this.object = object;
		diagrams = new HashSet<MEDiagram>();
		setPositionData(x, y, startAngle, endAngle, depth);
	}

	public void resetToCenterElement() {
		setPositionData(0, 0, 0, 2 * Math.PI, 0);
	}

	public void setPositionData(double x, double y, double startAngle, double endAngle, int depth) {
		width = 90;
		this.x = x;
		this.y = y;
		width = 90;
		height = 20 - 5 * depth;
		this.startAngle = startAngle;
		this.endAngle = endAngle;
		complete = true;
	}

	public void setComplete(boolean complete) {
		this.complete = complete;
	}

	public boolean isComplete() {
		return complete;
	}
}
