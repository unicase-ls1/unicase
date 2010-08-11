package org.unicase.urml.ui.hypergraph;

import org.eclipse.emf.ecore.EObject;

public class GraphEObjectLayouted {
	public EObject object;
	public double x, y;
	public double width, height;
	public double startRadian, endRadian;
	private boolean complete;

	public GraphEObjectLayouted(EObject object) {
		this(object, 0, 0, 0, 2 * Math.PI, 0);
	}

	public GraphEObjectLayouted(EObject object, double x, double y, double startRadian, double endRadian, int depth) {
		this.object = object;
		setPositionData(x, y, startRadian, endRadian, depth);
	}

	public void resetToCenterElement() {
		setPositionData(0, 0, 0, 2 * Math.PI, 0);
	}

	public void setPositionData(double x, double y, double startRadian, double endRadian, int depth) {
		width = 90;
		this.x = x;
		this.y = y;
		width = 90;
		height = 20 - 5 * depth;
		this.startRadian = startRadian;
		this.endRadian = endRadian;
		complete = true;
	}

	public void setComplete(boolean complete) {
		this.complete = complete;
	}

	public boolean isComplete() {
		return complete;
	}
}
