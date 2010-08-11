package org.unicase.urml.ui.hypergraph;

import org.eclipse.zest.core.widgets.GraphNode;
import org.eclipse.zest.layouts.LayoutEntity;
import org.eclipse.zest.layouts.algorithms.AbstractLayoutAlgorithm;
import org.eclipse.zest.layouts.dataStructures.InternalNode;
import org.eclipse.zest.layouts.dataStructures.InternalRelationship;

public class UnicaseLayoutProvider extends AbstractLayoutAlgorithm {
	private int totalSteps = 0;
	private int currentStep = 0;

	public UnicaseLayoutProvider(int styles) {
		super(styles);
	}

	@Override
	protected void applyLayoutInternal(InternalNode[] entitiesToLayout, InternalRelationship[] relationshipsToConsider,
		double boundsX, double boundsY, double boundsWidth, double boundsHeight) {
		totalSteps = entitiesToLayout.length;
		fireProgressStarted(totalSteps);
		double x, y;
		for (currentStep = 0; currentStep < totalSteps; currentStep++) {
			LayoutEntity layoutEntity = entitiesToLayout[currentStep].getLayoutEntity();
			GraphEObjectLayouted element = (GraphEObjectLayouted) ((GraphNode) layoutEntity.getGraphData()).getData();
			x = element.x + boundsWidth / 2 - element.width / 2;
			y = element.y + boundsHeight / 2 - element.height / 2;
			layoutEntity.setLocationInLayout(x, y);
			layoutEntity.setSizeInLayout(element.width, element.height);
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
