package org.unicase.urml.ui.hypergraph;

import java.util.HashMap;
import java.util.LinkedList;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.zest.core.viewers.IGraphEntityContentProvider;
import org.unicase.metamodel.ModelElement;
import org.unicase.urml.ui.hypergraph.GraphEReferenceFilter.EdgeType;

public class UnicaseEntityContentProvider implements IGraphEntityContentProvider {
	private GraphEClassFilter nodeFilter;
	private GraphEReferenceFilter edgeFilter;
	private HashMap<EObject, GraphEObjectLayouted> elements;

	public UnicaseEntityContentProvider(GraphEClassFilter nodeFilter, GraphEReferenceFilter edgeFilter) {
		this.nodeFilter = nodeFilter;
		this.edgeFilter = edgeFilter;
	}

	public Object[] getConnectedTo(Object object) {
		LinkedList<GraphEObjectLayouted> result = new LinkedList<GraphEObjectLayouted>();
		EObject eObject = ((GraphEObjectLayouted) object).object;
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
			if(parent == null && eObject instanceof ModelElement) {
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
		if (elements == null) {
			elements = new HashMap<EObject, GraphEObjectLayouted>();
		} else {
			for (GraphEObjectLayouted element : elements.values()) {
				element.setComplete(false);
			}
		}
	}

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
		LinkedList<ToVisitEObject> toVisit = new LinkedList<ToVisitEObject>();
		toVisit.addFirst(new ToVisitEObject(0, (EObject) inputElement));
		ToVisitEObject thisToVisitObject;
		ToVisitEObject wrappedObject = new ToVisitEObject(0, null);
		GraphEObjectLayouted thisEObjectLayouted = null;
		int addOffset, elementsCount;
		while (!toVisit.isEmpty() && toVisit.peekFirst().depth < edgeFilter.getDepth()) {
			thisToVisitObject = toVisit.pollFirst();
			if (!elements.containsKey(thisToVisitObject.object)) {
				elements.put(thisToVisitObject.object, new GraphEObjectLayouted(thisToVisitObject.object));
			} else if (thisEObjectLayouted == null) {
				elements.get(thisToVisitObject.object).resetToCenterElement();
			}
			thisEObjectLayouted = elements.get(thisToVisitObject.object);
			addOffset = toVisit.size();
			elementsCount = 0;
			if (edgeFilter.isVisible(EdgeType.REFERENCE)) {
				for (EObject ref : thisToVisitObject.object.eCrossReferences()) {
					wrappedObject.object = ref;
					if (nodeFilter.isVisible(ref) && !toVisit.contains(wrappedObject)
						&& !(elements.containsKey(ref) && elements.get(ref).isComplete())) {
						toVisit.add(new ToVisitEObject(thisToVisitObject.depth + 1, ref));
						elementsCount++;
					}
				}
			}
			if (edgeFilter.isVisible(EdgeType.CHILD)) {
				for (EObject child : thisToVisitObject.object.eContents()) {
					wrappedObject.object = child;
					if (nodeFilter.isVisible(child) && !toVisit.contains(wrappedObject)
						&& !(elements.containsKey(child) && elements.get(child).isComplete())) {
						toVisit.add(new ToVisitEObject(thisToVisitObject.depth + 1, child));
						elementsCount++;
					}
				}
			}
			if (edgeFilter.isVisible(EdgeType.PARENT)) {
				EObject parent = thisToVisitObject.object.eContainer();
				if(parent == null && thisToVisitObject.object instanceof ModelElement) {
					parent = ((ModelElement) thisToVisitObject.object).getProject();
				}
				if (parent != null) {
					wrappedObject.object = parent;
					if (nodeFilter.isVisible(parent) && !toVisit.contains(wrappedObject)
						&& !(elements.containsKey(parent) && elements.get(parent).isComplete())) {
						toVisit.add(new ToVisitEObject(thisToVisitObject.depth + 1, parent));
						elementsCount++;
					}
				}
			}
			if (thisToVisitObject.depth + 1 < edgeFilter.getDepth()) {
				CirclePosition posCalc = new CirclePosition(elementsCount, thisEObjectLayouted.x,
					thisEObjectLayouted.y, 100, thisEObjectLayouted.startRadian, thisEObjectLayouted.endRadian);
				for (int i = addOffset; i < addOffset + elementsCount; i++) {
					double[] pos = posCalc.getNextPosition();
					double[] radian = posCalc.getNeighbourRadianOfCurrentPos();
					if (elements.containsKey(toVisit.get(i).object)) {
						elements.get(toVisit.get(i).object).setPositionData(pos[0], pos[1], radian[0], radian[1],
							thisToVisitObject.depth + 1);
					} else {
						elements.put(toVisit.get(i).object, new GraphEObjectLayouted(toVisit.get(i).object, pos[0],
							pos[1], radian[0], radian[1], thisToVisitObject.depth + 1));
					}
				}
			}
		}
		removeOldElements();
		return elements.values().toArray();
	}

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

	private class CirclePosition {
		private int currentElement;
		private double midX, midY, r;
		private double startRadian;
		private double radianShift;

		public CirclePosition(int elements, double midX, double midY, double r, double startRadian, double endRadian) {
			currentElement = 0;
			this.midX = midX;
			this.midY = midY;
			this.r = r;
			if ((endRadian - startRadian) == 2 * Math.PI) {
				radianShift = (endRadian - startRadian) / elements;
			} else if (elements == 1) {
				startRadian += (endRadian - startRadian) / 2;
				radianShift = 0;
			} else {
				radianShift = (endRadian - startRadian) / (elements + 1);
			}
			this.startRadian = startRadian;
		}

		public double[] getNextPosition() {
			double[] result = new double[2];
			currentElement++;
			double radian = startRadian + radianShift * currentElement;
			result[0] = midX + Math.cos(radian) * r;
			result[1] = midY + Math.sin(radian) * r;
			return result;
		}

		public double[] getNeighbourRadianOfCurrentPos() {
			double[] result = new double[2];
			result[0] = startRadian + radianShift * (currentElement - 1);
			result[1] = startRadian + radianShift * (currentElement + 1);
			if (Math.abs(result[1] - result[0]) >= Math.PI || (result[0] - result[1]) == 0) {
				double radian = startRadian + radianShift * currentElement;
				result[0] = radian - Math.PI / 2;
				result[1] = radian + Math.PI / 2;
			}
			return result;
		}
	}
}