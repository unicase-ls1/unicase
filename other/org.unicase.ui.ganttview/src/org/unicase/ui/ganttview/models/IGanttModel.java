/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this distribution, and is available at http://www.eclipse.org/legal/epl-v10.html
 * </copyright>
 */

package org.unicase.ui.ganttview.models;

import java.util.Calendar;
import java.util.List;

public interface IGanttModel {
	
	public void addGanttModelListener(IGanttModelListener ganttModelListener);
	public List<IGanttItem> getRootGanttItems();
	public void modifyGanttItem(String name, Calendar newStartDate, Calendar newEndDate);
}
