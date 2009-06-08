/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this distribution, and is available at http://www.eclipse.org/legal/epl-v10.html
 * </copyright>
 */

package org.unicase.ui.ganttview.models.impl;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.unicase.ui.ganttview.models.IGanttItem;

public class GanttItem implements IGanttItem {
	
	private List<IGanttItem> childGanttItems;
	private List<IGanttItem> successors;
	private List<IGanttItem> predecessors;
	private Calendar startDate;
	private Calendar endDate;
	private String name;
	private IGanttItem parentGanttItem;
	private int estimate;
	private int closedEstimate;
	
	
	public GanttItem() {
		childGanttItems = new ArrayList<IGanttItem>();
		successors = new ArrayList<IGanttItem>();
		predecessors = new ArrayList<IGanttItem>();
	}
	
	public void setStartDate(Calendar startDate) {
		this.startDate = startDate;
	}

	public void setEndDate(Calendar endDate) {
		this.endDate = endDate;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setParentGanttItem(IGanttItem parentGanttItem) {
		this.parentGanttItem = parentGanttItem;
	}

	public List<IGanttItem> getChildGanttItems() {
		return this.childGanttItems;
	}
	public int getCompletionStatus() {
		float fclosedEstimate = closedEstimate;
		float festimate = estimate;
		float fresult = (fclosedEstimate / festimate)*100;
				
		return (int)fresult;
	}
	public Calendar getEndDate() {
		return this.endDate;
	}
	public String getName() {
		return this.name;
	}
	public IGanttItem getParentGanttItem() {
		return this.parentGanttItem;
	}
	public Calendar getStartDate() {
		return this.startDate;
	}

	public void addSuccessor(GanttItem successor) {
		this.successors.add(successor);
	}

	public void setEstimate(int estimate) {
		this.estimate = estimate;
	}

	public void setClosedEstimate(int closedEstimate) {
		this.closedEstimate = closedEstimate;
	}
	
	public List<IGanttItem> getSuccessors() {
		return successors;
	}
}
