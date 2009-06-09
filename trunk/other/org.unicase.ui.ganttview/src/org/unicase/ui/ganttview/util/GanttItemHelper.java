/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this distribution, and is available at http://www.eclipse.org/legal/epl-v10.html
 * </copyright>
 */

package org.unicase.ui.ganttview.util;

import java.util.Calendar;
import java.util.List;

import org.unicase.ui.ganttview.models.IGanttItem;
import org.unicase.ui.ganttview.models.impl.GanttItem;

public final class GanttItemHelper {
	
	private GanttItemHelper () {}
	
	public static void setParentGanttItemStartAndEndDate(GanttItem parent) {
		
		List<IGanttItem> childItems = parent.getChildGanttItems();
		
		if(childItems == null || childItems.isEmpty())
			return;
		
		long minStartDate = -1;
		long maxEndDate = -1;
		
		for(IGanttItem item : childItems) {
										
			minStartDate = (minStartDate == -1) ? item.getStartDate().getTimeInMillis() : (Math.min(minStartDate, item.getStartDate().getTimeInMillis()));
			maxEndDate = (maxEndDate == -1) ? item.getEndDate().getTimeInMillis() : (Math.max(maxEndDate, item.getEndDate().getTimeInMillis()));			 	
		}
				
		
		Calendar parentStartDate = Calendar.getInstance();
		parentStartDate.setTimeInMillis(minStartDate);
		
		Calendar parentEndDate = Calendar.getInstance();
		parentEndDate.setTimeInMillis(maxEndDate);
				
		parent.setStartDate(parentStartDate);
		parent.setEndDate(parentEndDate);
		
	}

}
