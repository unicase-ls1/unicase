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
import org.unicase.model.task.util.TaxonomyAccess;

/**
 * Label Provider for the estimate column. If the item is a workitem, it shows the estimate of the work item. If the
 * item is another modelelement, it aggregates the estimate of annotated workitems.
 * 
 * @author helming
 */
public class EstimateLabelProvider extends ColumnLabelProvider implements IColorProvider {

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Color getForeground(Object element) {
		// TODO Auto-generated method stub
		return super.getForeground(element);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String getText(Object element) {
		if (element instanceof WorkItem) {
			return ((WorkItem) element).getEstimate() + "";
		}
		if (element instanceof ModelElement) {
			return TaxonomyAccess.getInstance().getOpeningLinkTaxonomy().getEstimate((ModelElement) element) + "";
		} else {
			return super.getText(element);
		}
	}
}
