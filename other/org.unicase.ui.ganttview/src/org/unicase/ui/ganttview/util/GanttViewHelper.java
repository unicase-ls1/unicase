/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */

package org.unicase.ui.ganttview.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.nebula.widgets.ganttchart.GanttChart;
import org.eclipse.nebula.widgets.ganttchart.GanttComposite;
import org.eclipse.swt.widgets.Tree;
import org.unicase.model.task.WorkPackage;

public final class GanttViewHelper {

	private GanttViewHelper() {
	}

	public static void clearGantt(GanttChart ganttChart, Tree tree) {

		GanttComposite ganttComposite = ganttChart.getGanttComposite();

		ganttComposite.getEvents().clear();
		ganttComposite.getGanttConnections().clear();
		ganttComposite.getGanttSections().clear();
		ganttComposite.getGroups().clear();

		tree.removeAll();

	}

	public static String getFormattedDateString(Calendar date) {

		if (date == null)
			return "";

		SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");

		return sdf.format(date.getTime());
	}

	public static EList<WorkPackage> getRootWorkPackages(EList<WorkPackage> flatWorkPackageList) {
		EList<WorkPackage> result = new BasicEList<WorkPackage>();

		for (WorkPackage workPackage : flatWorkPackageList) {
			if (workPackage.getContainingWorkpackage() == null)
				result.add(workPackage);
		}

		return result;

	}

}
