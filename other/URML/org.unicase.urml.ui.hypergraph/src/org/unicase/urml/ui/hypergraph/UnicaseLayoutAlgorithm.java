package org.unicase.urml.ui.hypergraph;

import java.util.LinkedList;

import org.eclipse.zest.core.widgets.GraphNode;
import org.eclipse.zest.layouts.LayoutEntity;
import org.eclipse.zest.layouts.algorithms.AbstractLayoutAlgorithm;
import org.eclipse.zest.layouts.dataStructures.InternalNode;
import org.eclipse.zest.layouts.dataStructures.InternalRelationship;
import org.unicase.metamodel.ModelElement;

public class UnicaseLayoutAlgorithm extends AbstractLayoutAlgorithm {
	private int totalSteps = 0;
	private int currentStep = 0;
	private HypergraphView view;

	public UnicaseLayoutAlgorithm(HypergraphView view, int styles) {
		super(styles);
		this.view = view;
	}

	private double getCenterPos(double sizeContainer, double sizeElement) {
		return sizeContainer - sizeElement / 2;
	}

	private class CirclePosition {
		private int currentElement, elements;
		private double midX, midY, r;

		public CirclePosition(int elements, double midX, double midY, double r) {
			currentElement = 0;
			this.elements = elements;
			this.midX = midX;
			this.midY = midY;
			this.r = r;
		}

		public double[] getNextPosition() {
			double[] result = new double[2];
			double radian = 2 * Math.PI / elements;
			radian *= currentElement;
			result[0] = midX + Math.cos(radian) * r;
			result[1] = midY + Math.sin(radian) * r;
			currentElement++;
			return result;
		}
	}

	private class GraphPosElement {
		private ModelElement element;
		private double pos[];
		private double height;
		private LinkedList<GraphPosElement> childs;

		public GraphPosElement(ModelElement element, double pos[]) {
			this(element, pos, 0);
		}

		private GraphPosElement(ModelElement element, double pos[], int depth) {
			this.element = element;
			this.pos = pos;
			this.height = 20 - depth * 5;
			childs = new LinkedList<GraphPosElement>();
			if (depth < HypergraphView.MAX_DEPTH) {
				CirclePosition posCalc = new CirclePosition(element.getContainedElements().size(), pos[0], pos[1], 100);
				for (ModelElement child : element.getContainedElements()) {
					childs.add(new GraphPosElement(child, posCalc.getNextPosition(), depth + 1));
				}
			}
		}

		public double[] getPos() {
			return pos;
		}

		public double getHeight() {
			return height;
		}

		public boolean contains(Object obj) {
			if (element.equals(obj))
				return true;
			for (GraphPosElement child : childs) {
				if (child.contains(obj))
					return true;
			}
			return false;
		}

		public GraphPosElement getRepresentingGraphPosElement(Object obj) {
			if (element.equals(obj))
				return this;
			for (GraphPosElement child : childs) {
				GraphPosElement result;
				if ((result = child.getRepresentingGraphPosElement(obj)) != null)
					return result;
			}
			return null;
		}
	}

	@Override
	protected void applyLayoutInternal(InternalNode[] entitiesToLayout, InternalRelationship[] relationshipsToConsider,
		double boundsX, double boundsY, double boundsWidth, double boundsHeight) {
		if (view.selectedItem instanceof ModelElement) {
			totalSteps = entitiesToLayout.length;
			fireProgressStarted(totalSteps);
			GraphPosElement graphPosElement = new GraphPosElement((ModelElement) view.selectedItem, new double[] {
				boundsWidth / 2, boundsHeight / 2 });
			for (currentStep = totalSteps - 1; currentStep >= 0; currentStep--) {
				LayoutEntity layoutEntity = entitiesToLayout[currentStep].getLayoutEntity();
				Object element = ((GraphNode) layoutEntity.getGraphData()).getData();
				if (graphPosElement.contains(element)) {
					GraphPosElement current = graphPosElement.getRepresentingGraphPosElement(element);
					double[] pos = current.getPos();
					double width = layoutEntity.getWidthInLayout() > 100 ? 100 : layoutEntity.getWidthInLayout();
					double height = current.getHeight();
					layoutEntity.setLocationInLayout(getCenterPos(pos[0], width), getCenterPos(pos[1], height));
					layoutEntity.setSizeInLayout(width, height);
				}
				fireProgressEvent(totalSteps-currentStep, totalSteps);
			}
			fireProgressEnded(totalSteps);
		}
	}

	@Override
	protected int getCurrentLayoutStep() {
		return 0;
	}

	@Override
	protected int getTotalNumberOfLayoutSteps() {
		return totalSteps;
	}

	@Override
	protected boolean isValidConfiguration(boolean asynchronous, boolean continuous) {
		return true;
	}

	@Override
	protected void postLayoutAlgorithm(InternalNode[] entitiesToLayout, InternalRelationship[] relationshipsToConsider) {
	}

	@Override
	protected void preLayoutAlgorithm(InternalNode[] entitiesToLayout, InternalRelationship[] relationshipsToConsider,
		double x, double y, double width, double height) {
	}

	@Override
	public void setLayoutArea(double x, double y, double width, double height) {
	}
}
