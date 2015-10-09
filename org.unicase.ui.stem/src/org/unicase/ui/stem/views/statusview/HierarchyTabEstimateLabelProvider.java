/**
 * <copyright> Copyright (c) 2015-2016 Chair of Applied Software Engineering, Technische Universität München (TUM).
 * All rights reserved. This program and the accompanying materials are made available under the terms of
 * the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.stem.views.statusview;

import java.util.Iterator;
import java.util.Set;

import org.eclipse.jface.viewers.ColumnLabelProvider;
import org.eclipse.jface.viewers.IColorProvider;
import org.eclipse.swt.graphics.Color;
import org.unicase.model.UnicaseModelElement;
import org.unicase.model.task.WorkItem;
import org.unicase.model.task.WorkPackage;
import org.unicase.model.task.util.EstimateHelper;
import org.unicase.model.task.util.MEState;
import org.unicase.model.task.util.TaxonomyAccess;

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
		int estimate = 0;
		int closedEstimate = 0;

		if (!(element instanceof UnicaseModelElement)) {
			return "";
		}

		if (element instanceof WorkItem && !hierarchyTabContentProvider.hasChildren(element)) {
			return ((WorkItem) element).getEstimate() + "";
		}

		UnicaseModelElement currentOpenME = hierarchyTabContentProvider.getRoot();
		if (!(currentOpenME instanceof WorkPackage)) {
			estimate = EstimateHelper.getAggregatedEstimate((UnicaseModelElement) element);
			closedEstimate = EstimateHelper.getClosedAggregatedEstimate((UnicaseModelElement) element);

			return closedEstimate + " / " + estimate;
		}

		Set<WorkItem> relativeWorkItems = TaxonomyAccess.getInstance().getOpeningLinkTaxonomy().getRelativeWorkItems(
			(WorkPackage) currentOpenME, (UnicaseModelElement) element);

		estimate = TaxonomyAccess.getInstance().getOpeningLinkTaxonomy().getEstimate(relativeWorkItems);

		Iterator<WorkItem> iterator = relativeWorkItems.iterator();
		while (iterator.hasNext()) {
			WorkItem workItem = iterator.next();
			if (workItem.getState().equals(MEState.CLOSED)) {
				closedEstimate += workItem.getEstimate();
			}
		}

		if (element instanceof WorkItem) {
			WorkItem workItem = (WorkItem) element;
			if (workItem.getState().equals(MEState.CLOSED)) {
				closedEstimate += workItem.getEstimate();
			}
			estimate += workItem.getEstimate();
		}

		return closedEstimate + " / " + estimate;
	}
}
