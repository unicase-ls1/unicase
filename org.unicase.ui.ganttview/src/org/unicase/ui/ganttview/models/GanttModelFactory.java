/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this distribution, and is available at http://www.eclipse.org/legal/epl-v10.html
 * </copyright>
 */

package org.unicase.ui.ganttview.models;

import java.util.Calendar;
import java.util.Random;

import org.unicase.ui.ganttview.models.impl.GanttItem;
import org.unicase.ui.ganttview.models.impl.GanttModel;

public final class GanttModelFactory {
	
	public static IGanttModel createGanttModelFromSelectedWorkItems() {
		GanttModel result = null;
		//TODO: Build GanttModel from ContextMenu Selection
		return result;
	}
	
	public static IGanttModel createGanttModelFromWorkItems() {
		GanttModel result = null;
		//TODO: Build GanttModel from all WorkItems
		return result;
	}
	
	public static IGanttModel createGanttModelTest() {

		GanttModel result = new GanttModel();
		
		for(int i = 0; i < 4; i++) {
			
			Calendar startDate = Calendar.getInstance();
			startDate.add(Calendar.DATE, i*5);
			
			GanttItem rootItem = new GanttItem();
			rootItem.setName("Root Item " + i);
			// hack - should be computed with regard to child items
			rootItem.setStartDate(Calendar.getInstance());
			rootItem.setEndDate(Calendar.getInstance());
			
			result.getGanttItems().put(rootItem.getName(), rootItem);
			result.getRootGanttItems().add(rootItem);
			
			for(int j = 0; j < 3; j++) {
				
				GanttItem childItem = new GanttItem();
				childItem.setName("Child Item " +j);
			
				Calendar childStartDate = (Calendar) startDate.clone();
				childStartDate.add(Calendar.DATE, 0 + (new Random()).nextInt(3-0));
				childItem.setStartDate(childStartDate);
				
				Calendar endDate = (Calendar) startDate.clone();
				endDate.add(Calendar.DATE, 3 + (new Random()).nextInt(30-3));
				childItem.setEndDate(endDate);
				
				rootItem.getChildGanttItems().add(childItem);
				childItem.setParentGanttItem(rootItem);
				
				result.getGanttItems().put(childItem.getName(), childItem);
			}
		}
				
		return result;
	}
}

