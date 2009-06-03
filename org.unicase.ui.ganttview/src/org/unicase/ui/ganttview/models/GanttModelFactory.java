/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this distribution, and is available at http://www.eclipse.org/legal/epl-v10.html
 * </copyright>
 */

package org.unicase.ui.ganttview.models;

import java.util.Calendar;
import java.util.Set;

import org.unicase.model.ModelElement;
import org.unicase.ui.ganttview.models.impl.GanttItem;
import org.unicase.ui.ganttview.models.impl.GanttModel;
import org.unicase.ui.ganttview.util.GanttItemHelper;

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
	
//	public static IGanttModel createGanttModelTest() {

//		GanttModel result = new GanttModel();
//		
//		for(int i = 0; i < 4 ; i++) {
//			
//			Calendar startDate = Calendar.getInstance();
//			startDate.add(Calendar.DATE, i*5);
//			
//			GanttItem rootItem = new GanttItem();
//			rootItem.setName("Root Item " + i);
//						
//			result.getGanttItems().put(rootItem.getName(), rootItem);
//			result.getRootGanttItems().add(rootItem);
//			
//			for(int j = 0; j < 3; j++) {
//				
//				GanttItem childItem = new GanttItem();
//				childItem.setName("Child Item "+i+" " +j);									
//				childItem.setStartDate(startDate);
//				
//				Calendar endDate = (Calendar) startDate.clone();
//				endDate.add(Calendar.DATE, j+5);
//				childItem.setEndDate(endDate);
//				
//				rootItem.getChildGanttItems().add(childItem);
//				childItem.setParentGanttItem(rootItem);
//				
//				result.getGanttItems().put(childItem.getName(), childItem);
//			}
//			
//			GanttItemHelper.setParentGanttItemStartAndEndDate(rootItem);
//		}
//				
//		return result;
//	}

	
	private static GanttItem recurisveModelElementToGantItem(ModelElement me)
	{
		Calendar startDate = Calendar.getInstance();
		startDate.add(Calendar.DATE, 0);
		Calendar endDate = (Calendar) startDate.clone();
		endDate.add(Calendar.DATE, 5);
		
		GanttItem result = new GanttItem();
		result.setName(me.getName());
		result.setStartDate(startDate);
		result.setEndDate(endDate);
					
		Set<ModelElement> subModels = me.getContainedElements();
		for (ModelElement modelElement : subModels) {
			GanttItem childItem = recurisveModelElementToGantItem(modelElement);
			result.getChildGanttItems().add(childItem);
			childItem.setParentGanttItem(result);
//			result.getGanttItems().put(childItem.getName(), childItem);
		}
		GanttItemHelper.setParentGanttItemStartAndEndDate(result);
		
		return result;
	}

	public static IGanttModel createGanttModelFromSelectedWorkItems(ModelElement me) {
		GanttModel result = new GanttModel();
		GanttItem rootItem = recurisveModelElementToGantItem(me);

		result.getGanttItems().put(rootItem.getName(), rootItem);
		result.getRootGanttItems().add(rootItem);

//		GanttItemHelper.setParentGanttItemStartAndEndDate(rootItem);
		
		return result;
	}
}

