/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this distribution, and is available at http://www.eclipse.org/legal/epl-v10.html
 * </copyright>
 */

package org.unicase.ui.ganttview.models;

import java.util.Calendar;
import java.util.List;

public interface IGanttItem {
	
	public Calendar getStartDate();
	public Calendar getEndDate();
	public String getName();
	public int getCompletionStatus();
	public List<IGanttItem> getChildGanttItems();
	public IGanttItem getParentGanttItem();
	public List<IGanttItem> getSuccessors();
	
}
