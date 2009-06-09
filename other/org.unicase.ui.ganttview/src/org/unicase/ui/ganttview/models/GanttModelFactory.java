/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this distribution, and is available at http://www.eclipse.org/legal/epl-v10.html
 * </copyright>
 */

package org.unicase.ui.ganttview.models;

import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import org.eclipse.emf.common.util.EList;
import org.unicase.model.ModelElement;
import org.unicase.model.task.WorkItem;
import org.unicase.model.task.WorkPackage;
import org.unicase.model.task.util.MEState;
import org.unicase.model.task.util.TaxonomyAccess;
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

	
	private static GanttItem recurisveModelElementToGanttItem(WorkPackage wp)
	{
		Calendar startDate = Calendar.getInstance();
		Calendar endDate = (Calendar) startDate.clone();
		
		GanttItem result = new GanttItem();
		
//		WorkPackage wp = (WorkPackage) me;
		
		
		result.setName(wp.getName());
		
		Date dstart = wp.getStartDate();
		if (dstart != null) {
			startDate.setTime(dstart);
			result.setStartDate(startDate);
		}
		
		Date dend = wp.getDueDate();		
		if (dend != null) {
			endDate.setTime(dend);
			result.setEndDate(endDate);
		}
		
		Set<ModelElement> subModels = wp.getContainedElements();
		if (subModels != null) {
			for (ModelElement modelElement : subModels) {
				if ( !(modelElement instanceof WorkPackage) ) {
					continue;
				}
				GanttItem childItem = recurisveModelElementToGanttItem((WorkPackage)modelElement);
				result.getChildGanttItems().add(childItem);
				childItem.setParentGanttItem(result);
			}
			GanttItemHelper.setParentGanttItemStartAndEndDate(result);	
		}
		
		
		EList<WorkItem> successors = wp.getSuccessors();
		if (successors != null) {
			for (WorkItem workItem : successors) {
				if ( !(workItem instanceof WorkPackage) ) {
					continue;
				}
				result.addSuccessor(recurisveModelElementToGanttItem((WorkPackage)workItem));
			}	
		}
		
		
		result.setEstimate(getEstimate((ModelElement)wp, null, new HashSet<WorkItem>(wp.getAllContainedWorkItems())));
		
		result.setClosedEstimate(getClosedEstimate(new HashSet<WorkItem>(wp.getAllContainedWorkItems())));
			
		
		return result;
	}


	private static int getEstimate(ModelElement element, WorkPackage currentOpenME, Set<WorkItem> relativeWorkItems) {

		int estimate = TaxonomyAccess.getInstance().getOpeningLinkTaxonomy().getEstimate(relativeWorkItems);
		if (element instanceof WorkItem) {
			estimate += ((WorkItem) element).getEstimate();
		}
		return estimate;
	}

	private static int getClosedEstimate(ModelElement element, WorkPackage currentOpenME, Set<WorkItem> relativeWorkItems) {

		int closedEstimate = getClosedEstimate(relativeWorkItems);
		if (element instanceof WorkItem) {
			WorkItem workItem = (WorkItem) element;
			if (workItem.getState().equals(MEState.CLOSED)) {
				closedEstimate += workItem.getEstimate();
			}
		}

		return closedEstimate;
	}

	private static int getClosedEstimate(Set<WorkItem> relativeWorkItems) {
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
	
	public static IGanttModel createGanttModelFromSelectedWorkItems(ModelElement me) {
		GanttModel result = new GanttModel();
		
		if ( !(me instanceof WorkPackage) ) {
			return result;
		}
		
		WorkPackage wp = (WorkPackage) me;
		
		GanttItem rootItem = recurisveModelElementToGanttItem(wp);	
		result.getGanttItems().put(rootItem.getName(), rootItem);
//		result.put(me.getIdentifier(), rootItem);
//		result.getGanttItems().put(me.getIdentifier(), rootItem);
		result.getRootGanttItems().add(rootItem);

		
//		GanttItemHelper.setParentGanttItemStartAndEndDate(rootItem);
		
		return result;
	}
}

