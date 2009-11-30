/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.stem.views.statusview;

import org.eclipse.jface.viewers.ColumnLabelProvider;
import org.eclipse.jface.viewers.IColorProvider;
import org.eclipse.swt.graphics.Color;
import org.unicase.model.ModelElement;
import org.unicase.model.task.WorkItem;
import org.unicase.model.task.WorkPackage;
import org.unicase.model.task.util.MEState;
import org.unicase.model.task.util.TaxonomyAccess;

import java.util.Iterator;
import java.util.Set;

/**
 * Label Provider for the estimate column. If the item is a workitem, it shows the estimate of the work item. If the
 * item is another modelelement, it aggregates the estimate of annotated workitems.
 * 
 * @author helming
 */
public class HierarchyTabEstimateLabelProvider extends ColumnLabelProvider implements IColorProvider {

	private final HierarchyTabContentProvider hierarchyTabContentProvider;

	/**
	 * Constructor.
	 * 
	 * @param contentProvider Model element currently open in status view
	 */
	public HierarchyTabEstimateLabelProvider(HierarchyTabContentProvider contentProvider) {
		this.hierarchyTabContentProvider = contentProvider;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Color getForeground(Object element) {
		return super.getForeground(element);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String getText(Object element) {
		if (!(element instanceof ModelElement)) {
			return "";
		}

		if (element instanceof WorkItem && !hierarchyTabContentProvider.hasChildren(element)) {

			return ((WorkItem) element).getEstimate() + "";

		}

		ModelElement currentOpenME = hierarchyTabContentProvider.getRoot();
		if (currentOpenME instanceof WorkPackage) {

			Set<WorkItem> relativeWorkItems = TaxonomyAccess.getInstance().getOpeningLinkTaxonomy()
				.getRelativeWorkItems((WorkPackage) currentOpenME, (ModelElement) element);
			return getClosedEstimate((ModelElement) element, (WorkPackage) currentOpenME, relativeWorkItems) + " / "
				+ getEstimate((ModelElement) element, (WorkPackage) currentOpenME, relativeWorkItems);

		} else {
			int estimate = TaxonomyAccess.getInstance().getOpeningLinkTaxonomy().getEstimate((ModelElement) element);
			int closedEstimate = TaxonomyAccess.getInstance().getOpeningLinkTaxonomy().getClosedEstimate(
				(ModelElement) element);
			return closedEstimate + " / " + estimate;
		}

	}

	private int getEstimate(ModelElement element, WorkPackage currentOpenME, Set<WorkItem> relativeWorkItems) {

		int estimate = TaxonomyAccess.getInstance().getOpeningLinkTaxonomy().getEstimate(relativeWorkItems);
		if (element instanceof WorkItem) {
			estimate += ((WorkItem) element).getEstimate();
		}
		return estimate;
	}

	private int getClosedEstimate(ModelElement element, WorkPackage currentOpenME, Set<WorkItem> relativeWorkItems) {

		int closedEstimate = getClosedEstimate(relativeWorkItems);
		if (element instanceof WorkItem) {
			WorkItem workItem = (WorkItem) element;
			if (workItem.getState().equals(MEState.CLOSED)) {
				closedEstimate += workItem.getEstimate();
			}
		}

		return closedEstimate;
	}

	private int getClosedEstimate(Set<WorkItem> relativeWorkItems) {
		int closedEstimate = 0;
		Iterator<WorkItem> iterator = relativeWorkItems.iterator();
		while (iterator.hasNext()) {
			WorkItem workItem = iterator.next();
			if (workItem.getState().equals(MEState.CLOSED)) {
				closedEstimate += workItem.getEstimate();
			}
		}
		return closedEstimate;
	}
}
