/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this distribution, and is available at http://www.eclipse.org/legal/epl-v10.html
 * </copyright>
 */

package org.unicase.ui.ganttview.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.eclipse.nebula.widgets.ganttchart.GanttChart;
import org.eclipse.nebula.widgets.ganttchart.GanttComposite;
import org.eclipse.nebula.widgets.ganttchart.GanttEvent;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.swt.widgets.TreeItem;
import org.unicase.ui.ganttview.models.IGanttItem;

public final class GanttViewHelper {

	private GanttViewHelper() {}

	public static void clearGantt(GanttChart ganttChart, Tree tree) {
		
		GanttComposite ganttComposite = ganttChart.getGanttComposite();
		
		ganttComposite.getEvents().clear();
		ganttComposite.getGanttConnections().clear();
		ganttComposite.getGanttSections().clear();
		ganttComposite.getGroups().clear();
				
		tree.removeAll();
			
	}
	
	public static void setTreeItemText(TreeItem treeItem, IGanttItem ganttItem) {
		treeItem.setText(new String[] { ganttItem.getName(), 
		getFormattedDateString(ganttItem.getStartDate()), 
		getFormattedDateString(ganttItem.getEndDate()),
		ganttItem.getCompletionStatus()+"" });
	}
	
	
	public static TreeItem createRootTreeItemWithGanttEvent(Tree tree, GanttChart ganttChart, IGanttItem ganttItem) {
		
		GanttEvent ganttEvent = new GanttEvent(ganttChart, ganttItem.getName());
		ganttEvent.setData(ganttItem);
		
		TreeItem treeItem = new TreeItem(tree, SWT.NONE);
		setTreeItemText(treeItem, ganttItem);		
		treeItem.setData(ganttEvent);
		
		return treeItem;
	}
	
	public static TreeItem createChildTreeItemWithGanttEvent(TreeItem rootTreeItem, GanttChart ganttChart, IGanttItem ganttItem) {
		
		GanttEvent ganttEvent = new GanttEvent(ganttChart, ganttItem.getName(),
				ganttItem.getStartDate(),
				ganttItem.getEndDate(),
				ganttItem.getCompletionStatus());
						
		ganttEvent.setData(ganttItem);
		((GanttEvent)rootTreeItem.getData()).addScopeEvent(ganttEvent);
		
		TreeItem treeItem = new TreeItem(rootTreeItem, SWT.NONE);
		setTreeItemText(treeItem, ganttItem);
		
		treeItem.setData(ganttEvent);
		
		return treeItem;
	}
	
	public static String getFormattedDateString(Calendar date) {
		SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
		
		return sdf.format(date.getTime());
	}
	
	public static TreeItem getTreeItemByGanttItem(Tree tree, IGanttItem ganttItem) {
		
		return getTreeItemByGanttItemInner(tree.getItems(), ganttItem);	
	}
	
	private static TreeItem getTreeItemByGanttItemInner(TreeItem[] treeItems, IGanttItem ganttItem) {
		
		TreeItem result = null;
		
		for(TreeItem item : treeItems) {
			
			GanttEvent ganttEvent = (GanttEvent)item.getData();
			IGanttItem ganttEventsData = (IGanttItem)ganttEvent.getData();
			
	        if(ganttEventsData.getName().equals(ganttItem.getName()))
	        	return item;
	        else {
	        	result = getTreeItemByGanttItemInner(item.getItems(), ganttItem);
	        	if(result != null)
	        		break;
	        }    	
		}
		
		return result;
	}
	
	public static GanttEvent getGanttEventByGanttItem(GanttChart ganttChart, IGanttItem ganttItem) {
		
		for(Object event : ganttChart.getGanttComposite().getEvents()){
			if(((IGanttItem)((GanttEvent)event).getData()).getName().equals(ganttItem.getName()))
				return (GanttEvent)event;
		}
		
		return null;
	}
	
	
	
}
