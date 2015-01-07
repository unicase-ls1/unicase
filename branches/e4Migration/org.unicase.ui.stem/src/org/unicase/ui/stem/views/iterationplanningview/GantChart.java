/**
 * <copyright> Copyright (c) 2009-2012 Chair of Applied Software Engineering, Technische Universit�t M�nchen (TUM).
 * All rights reserved. This program and the accompanying materials are made available under the terms of
 * the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.stem.views.iterationplanningview;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.emfstore.internal.client.model.ESWorkspaceProviderImpl;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.TreeViewerColumn;
import org.eclipse.nebula.widgets.ganttchart.GanttChart;
import org.eclipse.nebula.widgets.ganttchart.GanttComposite;
import org.eclipse.nebula.widgets.ganttchart.GanttControlParent;
import org.eclipse.nebula.widgets.ganttchart.GanttEvent;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.SashForm;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.swt.widgets.TreeItem;
import org.unicase.model.task.WorkPackage;

/**
 * Implementation of a show case ganttchart.
 * 
 * @author helming
 */
public class GantChart {
	/**
	 * @return the chart
	 */
	public GanttChart getChart() {
		return chart;
	}

	/**
	 * Map of all workpackages displayed in the chart.
	 */
	private Map<WorkPackage, GanttEvent> map = new HashMap<WorkPackage, GanttEvent>();
	/**
	 * our GANTT chart, will end up on the right in the sash.
	 */
	private final GanttChart chart;

	// we will be using method calls straight onto the chart itself, so we set
	// it to a variable

	private final GanttComposite ganttComposite;
	private GanttEvent ge;

	/**
	 * Default constructor.
	 * 
	 * @param parent
	 *            The parent shell
	 */
	public GantChart(Composite parent) {

		// split the view horizontally (which makes the splitter vertical)
		SashForm sf = new SashForm(parent, SWT.HORIZONTAL);
		GanttControlParent left = new GanttControlParent(sf, SWT.NONE);

		chart = new GanttChart(sf, SWT.NONE);
		ganttComposite = chart.getGanttComposite();
		// values we will be using further down (see comments in related
		// sections)
		// row height
		final int oneRowHeight = 19;
		// spacer between each event, in this case 2 pixels as the horizontal
		// lines in the tree take up 2 pixels per section (1 top, 1 bottom)
		final int spacer = 2;

		// usually whether to draw certain things are fetched from the ISettings
		// implementing class, but there are a few overrides available for
		// setting
		// non-default values, two of those are the options to draw horizontal
		// and vertical lines. Here we flip the defaults to disable vertical
		// lines but to show horizontal lines.
		ganttComposite.setDrawHorizontalLinesOverride(true);
		ganttComposite.setDrawVerticalLinesOverride(true);

		// set each item height on the chart to be the same height as one item
		// in the tree. This call basically sets the fixed row height for each
		// event instead of
		// setting it programatically. It's just a convenience method.
		// we take off the spacer as we're setting the row height which doesn't
		// account for spacing, spacing is between rows, not in rows.
		ganttComposite.setFixedRowHeightOverride(oneRowHeight - spacer);

		// if you zoom in closely on the tree you'll see that the horizontal
		// lines (that we activated) take up 2 in space (one at top, one at
		// bottom)
		// so we space the events using that value
		ganttComposite.setEventSpacerOverride(spacer);

		// as we want the chart to be created on the right side, we created the
		// TreeControlParent without the chart as a parameter
		// but as that control needs the chart to operate, we set it here (this
		// is a must or you won't see a thing!)
		left.setGanttChart(chart);

		TreeViewer viewer = new TreeViewer(left, SWT.BORDER | SWT.V_SCROLL
				| SWT.H_SCROLL | SWT.FULL_SELECTION);
		Tree tree = viewer.getTree();
		tree.setHeaderVisible(true);
		tree.setLinesVisible(true);

		TreeViewerColumn tclmWorkItem = new TreeViewerColumn(viewer, SWT.NONE);
		tclmWorkItem.getColumn().setText("WorkItem");
		tclmWorkItem.getColumn().setWidth(400);
		WorkPackageColumnLabelProvider emfColumnLabelProvider = new WorkPackageColumnLabelProvider();
		tclmWorkItem.setLabelProvider(emfColumnLabelProvider);

		viewer.setContentProvider(new GantItemProvider());
		viewer.setInput(ESWorkspaceProviderImpl.getInstance().getWorkspace()
				.getLocalProject((EObject) parent));

		TreeItem[] items = tree.getItems();

		for (TreeItem item : items) {
			createItem(item);
		}

		ganttComposite.setShowPlannedDates(true);
		ganttComposite.setZoomLevel(10);

	}

	private void createItem(TreeItem item) {
		WorkPackage workPackage = (WorkPackage) item.getData();

		if (workPackage.getContainingWorkpackage() == null) {
			ge = createRootItem(workPackage);
		} else {
			ge = createChildItem(workPackage);
		}
		map.put(workPackage, ge);
		ge.setVerticalEventAlignment(SWT.CENTER);
		// TreeItem[] items = item.getItems();
		// for (TreeItem child : items) {
		// createItem(child);
		// }
	}

	private GanttEvent createRootItem(WorkPackage workPackage) {
		Date startDate = workPackage.getStartDate();
		Date endDate = workPackage.getEndDate();
		Calendar start = Calendar.getInstance();
		Calendar end = Calendar.getInstance();
		if (startDate == null | endDate == null) {
			start.add(Calendar.DATE, 0);
			end.add(Calendar.DATE, 0);
		} else {
			start.setTime(startDate);
			end.setTime(endDate);
		}

		GanttEvent ganttEvent = new GanttEvent(chart, workPackage.getName(),
				start, end, 0);
		if (ge != null) {
			ganttComposite.addDependency(ge, ganttEvent);
		}

		return ganttEvent;
	}

	private GanttEvent createChildItem(WorkPackage workPackage) {
		GanttEvent parent = map.get(workPackage.getContainingWorkpackage());
		Date startDate = workPackage.getStartDate();
		Date endDate = workPackage.getEndDate();
		Calendar start = Calendar.getInstance();
		Calendar end = Calendar.getInstance();
		if (startDate == null | endDate == null) {
			start.add(Calendar.DATE, 0);
			end.add(Calendar.DATE, 0);
		} else {
			start.setTime(startDate);
			end.setTime(endDate);
		}

		GanttEvent ganttEvent = new GanttEvent(chart, workPackage.getName(),
				start, end, 0);
		parent.addScopeEvent(ganttEvent);
		return ganttEvent;
	}

}
