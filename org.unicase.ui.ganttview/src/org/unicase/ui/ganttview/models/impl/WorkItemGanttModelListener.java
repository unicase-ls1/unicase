/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this distribution, and is available at http://www.eclipse.org/legal/epl-v10.html
 * </copyright>
 */

package org.unicase.ui.ganttview.models.impl;

import org.unicase.ui.ganttview.models.IGanttItem;
import org.unicase.ui.ganttview.models.IGanttModelListener;

public class WorkItemGanttModelListener implements IGanttModelListener {

	public void ganttItemChanged(IGanttItem ganttItem) {
		// retrieve corresponding WorkItem by ganttItem.getName() and set new 
		// start and end date (ganttItem.getStartDate()...)
	}

}
