/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this distribution, and is available at http://www.eclipse.org/legal/epl-v10.html
 * </copyright>
 */

package org.unicase.ui.ganttview.models;

import java.util.Calendar;

import org.unicase.ui.ganttview.models.impl.GanttItem;
import org.unicase.ui.ganttview.models.impl.GanttModel;

public final class GanttModelFactory {
	
	public static IGanttModel createGanttModelTest() {

		GanttModel result = new GanttModel();
		
		GanttItem rootItem1 = new GanttItem();
		rootItem1.setName("RootItem 1");
		rootItem1.setStartDate(Calendar.getInstance());
		Calendar endDate = Calendar.getInstance();
		endDate.add(Calendar.MONTH, 2);
		rootItem1.setEndDate(endDate);
		
		GanttItem childItem1 = new GanttItem();
		childItem1.setName("ChildItem 1");
		childItem1.setStartDate(Calendar.getInstance());
		childItem1.setEndDate(endDate);
		childItem1.setParentGanttItem(rootItem1);
		
		rootItem1.getChildGanttItems().add(childItem1);
		
		result.getRootGanttItems().add(rootItem1);
		result.getGanttItems().put("RootItem 1", rootItem1);
		result.getGanttItems().put("ChildItem 1", childItem1);
		
		return result;
	}
}
