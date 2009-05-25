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

	public static void clearGanttChart(GanttChart ganttChart) {
		
		GanttComposite ganttComposite = ganttChart.getGanttComposite();
		
		for(Object ganttEvent : ganttComposite.getEvents()) {
			ganttComposite.removeEvent((GanttEvent)ganttEvent);
		}
	}
	
	
	public static TreeItem createRootTreeItemWithGanttEvent(Tree tree, GanttChart ganttChart, IGanttItem ganttItem) {
		
		GanttEvent ganttEvent = new GanttEvent(ganttChart, ganttItem.getName());
		ganttEvent.setData(ganttItem);
		
		TreeItem treeItem = new TreeItem(tree, SWT.NONE);
		treeItem.setText(new String[] { ganttItem.getName(), 
				getFormattedDateString(ganttItem.getStartDate()), 
				getFormattedDateString(ganttItem.getEndDate()),
				ganttItem.getCompletionStatus()+"" });
		
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
		treeItem.setText(new String[] { ganttItem.getName(), 
				getFormattedDateString(ganttItem.getStartDate()), 
				getFormattedDateString(ganttItem.getEndDate()),
				ganttItem.getCompletionStatus()+"" });
		
		treeItem.setData(ganttEvent);
		
		return treeItem;
	}
	
	public static String getFormattedDateString(Calendar date) {
		SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
		
		return sdf.format(date.getTime());
	}
	
	
	
}
