package org.unicase.ui.urml.hypergraph.provider;

import java.util.HashMap;
import java.util.LinkedList;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.zest.core.viewers.GraphViewer;
import org.eclipse.zest.core.viewers.IGraphEntityContentProvider;
import org.unicase.metamodel.ModelElement;
import org.unicase.ui.urml.hypergraph.layout.GraphEClassFilter;
import org.unicase.ui.urml.hypergraph.layout.GraphEObjectLayouted;
import org.unicase.ui.urml.hypergraph.layout.GraphEReferenceFilter;
import org.unicase.ui.urml.hypergraph.layout.GraphEReferenceFilter.EdgeType;

/**
 * Calculate all references and positions for a single {@link EObject} given through the method setInput() in
 * {@link GraphViewer}. Selected element is in the middle. All reference up to the specified depth will ordered in
 * circles around their parents. Only return elements that are allowed in filters: {@link GraphEClassFilter} and
 * {@link GraphEReferenceFilter}.
 * 
 * @author Michael Haeger
 */
public class UnicaseEntityContentProvider implements IGraphEntityContentProvider {
	private GraphEClassFilter nodeFilter;
	private GraphEReferenceFilter edgeFilter;
	private HashMap<EObject, GraphEObjectLayouted> elements;

	public UnicaseEntityContentProvider(GraphEClassFilter nodeFilter, GraphEReferenceFilter edgeFilter) {
		this.nodeFilter = nodeFilter;
		this.edgeFilter = edgeFilter;
		elements = new HashMap<EObject, GraphEObjectLayouted>();
	}

	public Object[] getConnectedTo(Object object) {
		LinkedList<GraphEObjectLayouted> result = new LinkedList<GraphEObjectLayouted>();
		EObject eObject = ((GraphEObjectLayouted) object).object;
		// only add elements which are not filtered and respect to the depth of the graph
		if (edgeFilter.isVisible(EdgeType.CHILD)) {
			for (EObject child : eObject.eContents()) {
				if (this.elements.containsKey(child)) {
					result.add(elements.get(child));
				}
			}
		}
		if (edgeFilter.isVisible(EdgeType.REFERENCE)) {
			for (EObject ref : eObject.eCrossReferences()) {
				if (this.elements.containsKey(ref)) {
					result.add(elements.get(ref));
				}
			}
		}
		if (edgeFilter.isVisible(EdgeType.PARENT)) {
			EObject parent = eObject.eContainer();
			if (parent == null && eObject instanceof ModelElement) {
				// the highest composite sections have no parents - manually get the project as parent
				parent = ((ModelElement) eObject).getProject();
			}
			if (this.elements.containsKey(parent)) {
				result.add(elements.get(parent));
			}
		}
		return result.toArray();
	}

	public void dispose() {
	}

	public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
		// reset all already added elements but do not remove them (smooth new layout generation)
		for (GraphEObjectLayouted element : elements.values()) {
			element.setComplete(false);
		}
	}

	/**
	 * Removes all elements that are not used anymore. (filtered or not in depth range)
	 */
	private void removeOldElements() {
		LinkedList<EObject> deleteList = new LinkedList<EObject>();
		for (GraphEObjectLayouted element : elements.values()) {
			if (!element.isComplete()) {
				deleteList.add(element.object);
			}
		}
		for (EObject key : deleteList) {
			elements.remove(key);
		}
	}

	public Object[] getElements(Object inputElement) {
		// objects to visit
		LinkedList<ToVisitEObject> toVisit = new LinkedList<ToVisitEObject>();
		toVisit.addFirst(new ToVisitEObject(0, (EObject) inputElement));
		// current object to visit
		ToVisitEObject thisToVisitObject;
		// current final object
		GraphEObjectLayouted thisEObjectLayouted = null;
		int addOffset, elementsCount;
		while (!toVisit.isEmpty() && toVisit.peekFirst().depth < edgeFilter.getDepth()) {
			thisToVisitObject = toVisit.pollFirst();
			if (!elements.containsKey(thisToVisitObject.object)) {
				// object is new in layout
				elements.put(thisToVisitObject.object, new GraphEObjectLayouted(thisToVisitObject.object));
			} else if (thisEObjectLayouted == null) {
				// object already in layout (previous call of setInput() method) -center that element in new layout
				elements.get(thisToVisitObject.object).resetToCenterElement();
			}
			thisEObjectLayouted = elements.get(thisToVisitObject.object);
			addOffset = toVisit.size();
			elementsCount = 0;
			// handle all references off current object
			if (edgeFilter.isVisible(EdgeType.REFERENCE)) {
				for (EObject ref : thisToVisitObject.object.eCrossReferences()) {
					elementsCount += handleObject(ref, toVisit, thisToVisitObject.depth);
				}
			}
			if (edgeFilter.isVisible(EdgeType.CHILD)) {
				for (EObject child : thisToVisitObject.object.eContents()) {
					elementsCount += handleObject(child, toVisit, thisToVisitObject.depth);
				}
			}
			if (edgeFilter.isVisible(EdgeType.PARENT)) {
				EObject parent = thisToVisitObject.object.eContainer();
				if (parent == null && thisToVisitObject.object instanceof ModelElement) {
					parent = ((ModelElement) thisToVisitObject.object).getProject();
				}
				if (parent != null) {
					elementsCount += handleObject(parent, toVisit, thisToVisitObject.depth);
				}
			}
			// calculate the positions in the layout
			if (thisToVisitObject.depth + 1 < edgeFilter.getDepth()) {
				// create new position calculation with data of the parent object
				CirclePosition posCalc = new CirclePosition(elementsCount, thisEObjectLayouted.x,
					thisEObjectLayouted.y, 100, thisEObjectLayouted.startAngle, thisEObjectLayouted.endAngle);
				for (int i = addOffset; i < addOffset + elementsCount; i++) {
					double[] pos = posCalc.getNextPosition();
					double[] radian = posCalc.getNeighbourAngleOfCurrentPos();
					if (elements.containsKey(toVisit.get(i).object)) {
						// object already in layout (previous call of setInput() method) -only update data
						elements.get(toVisit.get(i).object).setPositionData(pos[0], pos[1], radian[0], radian[1],
							thisToVisitObject.depth + 1);
					} else {
						// object not in layout -create a new one at given position
						elements.put(toVisit.get(i).object, new GraphEObjectLayouted(toVisit.get(i).object, pos[0],
							pos[1], radian[0], radian[1], thisToVisitObject.depth + 1));
					}
				}
			}
		}
		removeOldElements();
		return elements.values().toArray();
	}

	/**
	 * @param obj object to add
	 * @param toVisit objects to visit
	 * @param depth current depth
	 * @return 1 if object was added - 0 if not
	 */
	private int handleObject(EObject obj, LinkedList<ToVisitEObject> toVisit, int depth) {
		// helper object for compare operations
		ToVisitEObject wrappedObject = new ToVisitEObject(0, obj);
		if (nodeFilter.isVisible(obj) && !toVisit.contains(wrappedObject)
			&& !(elements.containsKey(obj) && elements.get(obj).isComplete())) {
			toVisit.add(new ToVisitEObject(depth + 1, obj));
			return 1;
		}
		return 0;
	}

	/**
	 * Inner class that saves the depth of an object and compare only the objects on equals().
	 * 
	 * @author Michael Haeger
	 */
	private class ToVisitEObject {
		public int depth;
		public EObject object;

		public ToVisitEObject(int depth, EObject object) {
			this.depth = depth;
			this.object = object;
		}

		@Override
		public boolean equals(Object object) {
			return this.object.equals(object);
		}
	}

	/**
	 * Inner class for position calculation. Elements are ordered around a center point in a given angle range.
	 * 
	 * @author Michael Haeger
	 */
	private class CirclePosition {
		private int currentElement;
		private double midX, midY, r;
		private double startAngle;
		private double angleShift;

		public CirclePosition(int elements, double midX, double midY, double r, double startAngle, double endAngle) {
			currentElement = 0;
			this.midX = midX;
			this.midY = midY;
			this.r = r;
			if ((endAngle - startAngle) == 2 * Math.PI) {
				// only for absolute center
				angleShift = (endAngle - startAngle) / elements;
			} else if (elements == 1) {
				// only one element is placed in the same angle like his parent
				startAngle += (endAngle - startAngle) / 2;
				angleShift = 0;
			} else {
				// elements after center element have their outgoing connections plus one incoming
				angleShift = (endAngle - startAngle) / (elements + 1);
			}
			this.startAngle = startAngle;
		}

		public double[] getNextPosition() {
			double[] result = new double[2];
			currentElement++;
			double radian = startAngle + angleShift * currentElement;
			result[0] = midX + Math.cos(radian) * r;
			result[1] = midY + Math.sin(radian) * r;
			return result;
		}

		public double[] getNeighbourAngleOfCurrentPos() {
			double[] result = new double[2];
			result[0] = startAngle + angleShift * (currentElement - 1);
			result[1] = startAngle + angleShift * (currentElement + 1);
			// give maximal space of a quarter circle (would be more if we have only 1 to 3 items)
			if (Math.abs(result[1] - result[0]) >= Math.PI || (result[0] - result[1]) == 0) {
				double radian = startAngle + angleShift * currentElement;
				result[0] = radian - Math.PI / 2;
				result[1] = radian + Math.PI / 2;
			}
			return result;
		}
	}
}