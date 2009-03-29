/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.stem.views.statusview;

import org.eclipse.jface.viewers.ColumnLabelProvider;
import org.eclipse.jface.viewers.IColorProvider;
import org.unicase.model.requirement.FunctionalRequirement;
import org.unicase.model.task.WorkItem;

/**
 * This Label provider shows the priority of an modelelement if it has one.
 * 
 * @author helming
 */
public class PriorityLabelProvider extends ColumnLabelProvider implements IColorProvider {

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String getText(Object element) {
		if (element instanceof WorkItem) {
			return ((WorkItem) element).getPriority() + "";
		}
		if (element instanceof FunctionalRequirement) {
			return ((FunctionalRequirement) element).getPriority() + "";
		}
		return null;
	}

}
