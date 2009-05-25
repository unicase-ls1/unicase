/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this distribution, and is available at http://www.eclipse.org/legal/epl-v10.html
 * </copyright>
 */

package org.unicase.ui.ganttview.util;

import org.eclipse.nebula.widgets.ganttchart.GanttChart;
import org.eclipse.nebula.widgets.ganttchart.GanttComposite;
import org.eclipse.nebula.widgets.ganttchart.GanttEvent;

public final class GanttViewHelper {

	private GanttViewHelper() {}

	public static void clearGanttChart(GanttChart ganttChart) {
		
		GanttComposite ganttComposite = ganttChart.getGanttComposite();
		
		for(Object ganttEvent : ganttComposite.getEvents()) {
			ganttComposite.removeEvent((GanttEvent)ganttEvent);
		}
	}
	
}
