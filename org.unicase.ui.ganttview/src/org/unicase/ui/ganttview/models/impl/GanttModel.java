/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this distribution, and is available at http://www.eclipse.org/legal/epl-v10.html
 * </copyright>
 */

package org.unicase.ui.ganttview.models.impl;

import java.util.Calendar;
import java.util.Collection;
import java.util.Observable;

import org.unicase.ui.ganttview.models.IGanttItem;
import org.unicase.ui.ganttview.models.IGanttModel;

public class GanttModel extends Observable implements IGanttModel {
	
	public GanttModel() {
		
	}

	public Collection<IGanttItem> getRootGanttItems() {
		// TODO Auto-generated method stub
		return null;
	}

	public void modifyGanttItem(String name, Calendar newStartDate, Calendar newEndDate) {
		// TODO Auto-generated method stub
		this.notifyObservers();
	}

	
	//TODO: Create IGanttItem Structure from WorkPackages
	public void setInput() {
		// TODO Auto-generated method stub
		this.notifyObservers();
	}
		
}
