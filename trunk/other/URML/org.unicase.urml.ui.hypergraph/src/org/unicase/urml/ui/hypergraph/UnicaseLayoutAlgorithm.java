package org.unicase.urml.ui.hypergraph;

import java.util.LinkedList;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.zest.core.widgets.GraphNode;
import org.eclipse.zest.layouts.LayoutEntity;
import org.eclipse.zest.layouts.algorithms.AbstractLayoutAlgorithm;
import org.eclipse.zest.layouts.dataStructures.InternalNode;
import org.eclipse.zest.layouts.dataStructures.InternalRelationship;
import org.unicase.metamodel.ModelElement;
import org.unicase.workspace.ProjectSpace;

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

	private class GraphPosElement {
		private EObject element;
		private double[] pos;
		private double height;
		private LinkedList<GraphPosElement> childs;

		public GraphPosElement(EObject element, double[] pos) {
			this(element, pos, new double[] { 0, 2 * Math.PI }, 0, null);
		}

		private GraphPosElement(EObject element, double[] pos, double[] neighbourRadian, int depth, GraphPosElement from) {
			this.element = element;
			this.pos = pos;
			this.height = 20 - depth * 5;
			childs = new LinkedList<GraphPosElement>();
			if (depth < HypergraphView.MAX_DEPTH) {
				int elements = element.eContents().size();
				if (from == null) {
					elements++;
				}
				CirclePosition posCalc = new CirclePosition(elements, pos[0], pos[1], 100, neighbourRadian[0],
					neighbourRadian[1]);
				for (EObject child : element.eContents()) {
					if (from == null || !child.equals(from.element)) {
						childs.add(new GraphPosElement(child, posCalc.getNextPosition(), posCalc
							.getNeighbourRadianOfCurrentPos(), depth + 1, this));
					}
				}
				EObject parent = element.eContainer();
				if (parent == null && element instanceof ModelElement) {
					parent = ((ModelElement) element).getProject();
				}
				if (parent != null && !(parent instanceof ProjectSpace)
					&& (from == null || !from.element.equals(parent))) {
					childs.add(new GraphPosElement(parent, posCalc.getNextPosition(), posCalc
						.getNeighbourRadianOfCurrentPos(), depth + 1, this));
				}
			}
		}

		public double[] getPos() {
			return pos;
		}

		public double getHeight() {
			return height;
		}

		public GraphPosElement getRepresentingGraphPosElement(Object obj) {
			if (element.equals(obj)) {
				return this;
			}
			for (GraphPosElement child : childs) {
				GraphPosElement result;
				if ((result = child.getRepresentingGraphPosElement(obj)) != null) {
					return result;
				}
			}
			return null;
		}
	}

	@Override
	protected void applyLayoutInternal(InternalNode[] entitiesToLayout, InternalRelationship[] relationshipsToConsider,
		double boundsX, double boundsY, double boundsWidth, double boundsHeight) {
		totalSteps = entitiesToLayout.length;
		fireProgressStarted(totalSteps);
		GraphPosElement graphPosElement = new GraphPosElement(view.selectedItem, new double[] { boundsWidth / 2,
			boundsHeight / 2 });
		for (currentStep = totalSteps - 1; currentStep >= 0; currentStep--) {
			LayoutEntity layoutEntity = entitiesToLayout[currentStep].getLayoutEntity();
			Object element = ((GraphNode) layoutEntity.getGraphData()).getData();
			GraphPosElement current = graphPosElement.getRepresentingGraphPosElement(element);
			double[] pos = current.getPos();
			// double width = layoutEntity.getWidthInLayout() > 90 ? 90 : layoutEntity.getWidthInLayout();
			double width = 90;
			double height = current.getHeight();
			layoutEntity.setLocationInLayout(getCenterPos(pos[0], width), getCenterPos(pos[1], height));
			layoutEntity.setSizeInLayout(width, height);
			fireProgressEvent(totalSteps - currentStep, totalSteps);
		}
		fireProgressEnded(totalSteps);
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
