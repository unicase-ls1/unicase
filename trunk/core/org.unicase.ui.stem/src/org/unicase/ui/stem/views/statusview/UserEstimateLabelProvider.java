/**
 * <copyright> Copyright (c) 2009-2012 Chair of Applied Software Engineering, Technische Universität München (TUM).
* All rights reserved. This program and the accompanying materials are made available under the terms of
* the Eclipse Public License v1.0 which accompanies this distribution,
* and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.stem.views.statusview;

import java.util.HashSet;
import java.util.Set;

import org.eclipse.jface.viewers.ColumnLabelProvider;
import org.eclipse.jface.viewers.IColorProvider;
import org.unicase.model.organization.OrgUnit;
import org.unicase.model.task.Checkable;
import org.unicase.model.task.WorkItem;
import org.unicase.model.task.util.MEState;
import org.unicase.model.task.util.TaxonomyAccess;

/**
 * Label provider to show the estimate per user.
 * 
 * @author helming
 */
public class UserEstimateLabelProvider extends ColumnLabelProvider implements IColorProvider {

	private final UserTabContentProvider contentProvider;

	/**
	 * Constructor.
	 * 
	 * @param contentProvider the contentProvider for the tree
	 */
	public UserEstimateLabelProvider(UserTabContentProvider contentProvider) {
		this.contentProvider = contentProvider;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String getText(Object element) {
		if (element instanceof WorkItem) {
			return ((WorkItem) element).getEstimate() + "";
		}
		int estimate = 0;

		Set<Checkable> workItems = new HashSet<Checkable>();
		if (element instanceof NotAssigned) {
			workItems = TaxonomyAccess.getInstance().getOpeningLinkTaxonomy().getUnassignedWorkItems(
				contentProvider.getRoot());

		}
		if (element instanceof OrgUnit) {
			workItems = TaxonomyAccess.getInstance().getOpeningLinkTaxonomy().getWorkItems(contentProvider.getRoot(),
				(OrgUnit) element);
		}
		for (Checkable check : workItems) {
			if (check instanceof WorkItem) {
				estimate = estimate + ((WorkItem) check).getEstimate();
			}
		}

		int closedEstimate = getClosedEstimate(workItems);

		return closedEstimate + " / " + estimate;
	}

	private int getClosedEstimate(Set<Checkable> workItems) {

		int closedEstimate = 0;
		for (Checkable workItem : workItems) {
			if (((WorkItem) workItem).getState().equals(MEState.CLOSED)) {
				closedEstimate += ((WorkItem) workItem).getEstimate();
			}
		}
		return closedEstimate;
	}
}
