/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this distribution, and is available at http://www.eclipse.org/legal/epl-v10.html
 * </copyright>
 */

package org.unicase.ui.ganttview.models.impl;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Hashtable;
import java.util.List;

import org.unicase.ui.ganttview.models.IGanttItem;
import org.unicase.ui.ganttview.models.IGanttModel;
import org.unicase.ui.ganttview.models.IGanttModelListener;
import org.unicase.ui.ganttview.util.GanttItemHelper;

public class GanttModel implements IGanttModel {
	
	private List<IGanttModelListener> ganttModelListeners;
	private Hashtable<String, IGanttItem> ganttItems;
	private List<IGanttItem> rootGanttItems;
	
	
	public GanttModel() {
		this.ganttModelListeners = new ArrayList<IGanttModelListener>();
		this.ganttItems = new Hashtable<String, IGanttItem>();
		this.rootGanttItems = new ArrayList<IGanttItem>();
		addGanttModelListener(new WorkItemGanttModelListener());
	}

	public List<IGanttItem> getRootGanttItems() {
		return rootGanttItems;
	}

	public void modifyGanttItem(String name, Calendar newStartDate, Calendar newEndDate) {
		GanttItem modifiedGanttItem = (GanttItem) ganttItems.get(name);
		
		modifiedGanttItem.setStartDate(newStartDate);
		modifiedGanttItem.setEndDate(newEndDate);
		
		notifyAllListeners(modifiedGanttItem);
		
		modifyParentGanttItem(modifiedGanttItem);
				
	}
	
	private void modifyParentGanttItem(GanttItem ganttItem) {
		
		if(ganttItem.getParentGanttItem() == null)
			return;
		
		GanttItem parent = (GanttItem) ganttItem.getParentGanttItem();		
		GanttItemHelper.setParentGanttItemStartAndEndDate(parent);
		
		notifyAllListeners(parent);
		
		modifyParentGanttItem(parent);
		
	}

	public Hashtable<String, IGanttItem> getGanttItems() {
		return ganttItems;
	}

	
	public void addGanttModelListener(IGanttModelListener ganttModelListener) {
		this.ganttModelListeners.add(ganttModelListener);
	}
	
	private void notifyAllListeners(IGanttItem modifiedGanttItem) {
		
		for(IGanttModelListener listener : this.ganttModelListeners) {
			listener.ganttItemChanged(modifiedGanttItem);
		}
	}
		
}
