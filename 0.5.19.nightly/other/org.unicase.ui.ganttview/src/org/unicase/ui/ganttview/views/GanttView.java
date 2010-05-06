/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.ganttview.views;

import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.jface.viewers.ColumnLabelProvider;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.TreeViewerColumn;
import org.eclipse.nebula.widgets.ganttchart.GanttChart;
import org.eclipse.nebula.widgets.ganttchart.GanttEvent;
import org.eclipse.nebula.widgets.ganttchart.IGanttEventListener;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.SashForm;
import org.eclipse.swt.custom.ScrolledComposite;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.graphics.GC;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.swt.widgets.TreeItem;
import org.eclipse.ui.part.ViewPart;
import org.unicase.metamodel.ModelElement;
import org.unicase.metamodel.Project;
import org.unicase.model.task.TaskPackage;
import org.unicase.model.task.WorkItem;
import org.unicase.model.task.WorkPackage;
import org.unicase.ui.common.EMFColumnLabelProvider;
import org.unicase.ui.ganttview.util.GanttViewHelper;
import org.unicase.workspace.ProjectSpace;
import org.unicase.workspace.WorkspaceManager;

/**
 * @author fabisiew, max
 */
public class GanttView extends ViewPart implements IGanttEventListener {

	/**
	 * ID for this view.
	 */
	public static final String ID = "org.unicase.ui.ganttview.views.GanttView";

	private static final int SPACER = 2;
	private static final int ONE_ROW_HEIGHT = 28;

	private GanttChart ganttChart;
	private Composite parent;
	private TreeViewer treeViewer;

	/**
	 * The constructor.
	 */
	public GanttView() {

	}

	/**
	 * This is a callback that will allow us to create the viewer and initialize it.
	 * 
	 * @param parent Composite this View is placed in
	 */
	@Override
	public void createPartControl(Composite parent) {
		this.parent = parent;
		this.parent.setLayout(new FillLayout());
		ScrolledComposite ganttContainer = new ScrolledComposite(this.parent, SWT.V_SCROLL);
		SashForm sashForm = new SashForm(ganttContainer, SWT.HORIZONTAL);

		createTree(sashForm);

		UnicaseSettings roSettings = new ReadOnlySettings();

		ganttChart = new GanttChart(sashForm, SWT.NONE, roSettings);
		ganttChart.addGanttEventListener(this);

		ganttChart.getGanttComposite().setDrawHorizontalLinesOverride(true);
		ganttChart.getGanttComposite().setDrawVerticalLinesOverride(false);
		ganttChart.getGanttComposite().setFixedRowHeightOverride(ONE_ROW_HEIGHT - SPACER);
		ganttChart.getGanttComposite().setEventSpacerOverride(SPACER);

		sashForm.setWeights(new int[] { 30, 70 });

		ganttContainer.setContent(sashForm);
		ganttContainer.setExpandHorizontal(true);
		ganttContainer.setExpandVertical(true);
		ganttContainer.setMinSize(999, 999);

		// setInput() from here is called before ShowGanttViewHandler calls it
		ProjectSpace projectSpace = WorkspaceManager.getInstance().getCurrentWorkspace().getActiveProjectSpace();
		if (projectSpace != null) {
			Project inputProject = projectSpace.getProject();
			if (inputProject != null) {
				this.setInput(inputProject);
			}
		}

	}

	private void createTree(Composite parent) {

		treeViewer = new TreeViewer(parent, SWT.BORDER | SWT.V_SCROLL | SWT.H_SCROLL | SWT.FULL_SELECTION);
		treeViewer.setContentProvider(new GanttTreeContentProvider());

		final Tree tree = treeViewer.getTree();

		tree.setHeaderVisible(true);
		tree.setLinesVisible(true);

		// normally a tree item height on XP is 16 pixels. This is rather tight for a GANTT chart as it leaves little
		// space for connecting lines etc.
		// As we want some air, we force each item height to be 24 pixels.
		tree.addListener(SWT.MeasureItem, new Listener() {
			public void handleEvent(Event event) {
				event.height = ONE_ROW_HEIGHT - 4;
			}
		});

		// when a root node is collapsed/expanded, we collapse the entire scope in a similar fashion
		Listener expandCollapseListener = new Listener() {
			public void handleEvent(Event event) {
				GanttEvent ge = (GanttEvent) event.item.getData();

				if (event.type == SWT.Collapse) {
					ge.hideAllChildren();
					ganttChart.redrawGanttChart();
				} else {
					ge.showAllChildren();
					ganttChart.redrawGanttChart();

				}
			}
		};

		tree.addListener(SWT.Collapse, expandCollapseListener);
		tree.addListener(SWT.Expand, expandCollapseListener);

		// when an item is selected in the tree, we highlight it by setting it selected in the chart as well
		tree.addSelectionListener(new SelectionListener() {

			public void widgetDefaultSelected(SelectionEvent e) {
			}

			public void widgetSelected(SelectionEvent e) {
				if (tree.getSelectionCount() == 0) {
					return;
				}

				// set the selection
				TreeItem sel = tree.getSelection()[0];
				GanttEvent ge = (GanttEvent) sel.getData();
				ganttChart.getGanttComposite().setSelection(ge);
			}

		});

		TreeViewerColumn tcvName = new TreeViewerColumn(treeViewer, SWT.NONE, 0);
		tcvName.getColumn().setText("Name");
		tcvName.getColumn().setWidth(150);
		tcvName.setLabelProvider(new EMFColumnLabelProvider());

		TreeViewerColumn tcvStart = new TreeViewerColumn(treeViewer, SWT.NONE, 1);
		tcvStart.getColumn().setText("Start");
		tcvStart.getColumn().setWidth(100);
		tcvStart.setLabelProvider(new ColumnLabelProvider() {
			@Override
			public String getText(Object element) {
				if (element instanceof WorkPackage) {

					WorkPackage wp = (WorkPackage) element;

					if (wp.getStartDate() == null) {
						return "";
					}

					Calendar startDate = Calendar.getInstance();
					startDate.setTime(wp.getStartDate());

					return GanttViewHelper.getFormattedDateString(startDate);
				}

				return super.getText(element);
			}
		});

		TreeViewerColumn tcvEnd = new TreeViewerColumn(treeViewer, SWT.NONE, 2);
		tcvEnd.getColumn().setText("End");
		tcvEnd.getColumn().setWidth(100);
		tcvEnd.setLabelProvider(new ColumnLabelProvider() {
			@Override
			public String getText(Object element) {
				if (element instanceof WorkPackage) {

					WorkPackage wp = (WorkPackage) element;

					if (wp.getDueDate() == null) {
						return "";
					}

					Calendar endDate = Calendar.getInstance();
					endDate.setTime(wp.getDueDate());

					return GanttViewHelper.getFormattedDateString(endDate);
				}

				return super.getText(element);
			}
		});

		TreeViewerColumn tcvCompleted = new TreeViewerColumn(treeViewer, SWT.NONE, 3);
		tcvCompleted.getColumn().setText("Completed");
		tcvCompleted.getColumn().setWidth(100);
		tcvCompleted.setLabelProvider(new ColumnLabelProvider() {
			@Override
			public String getText(Object element) {
				if (element instanceof WorkPackage) {

					WorkPackage wp = (WorkPackage) element;
					return calculateProgress(wp) + "%";
				}

				return super.getText(element);
			}
		});
	}

	/**
	 * Set model for this view.
	 * 
	 * @param workPackage single root-WorkPackge
	 */
	public void setInput(WorkPackage workPackage) {

		GanttViewHelper.clearGantt(ganttChart, treeViewer.getTree());

		Map<String, GanttEvent> mapWorkPackagesToGanttEvents = new HashMap<String, GanttEvent>();

		EList<WorkItem> workItems = workPackage.getContainedWorkItems();
		for (WorkItem workItem : workItems) {
			if (workItem instanceof WorkPackage) {

				recurisveWorkPackageToGanttEvent((WorkPackage) workItem, true, mapWorkPackagesToGanttEvents);
			}
		}
		connectSuccessors(mapWorkPackagesToGanttEvents);
		mapWorkPackagesToGanttEvents.clear();

		treeViewer.setInput(workPackage);
		treeViewer.expandAll();

	}

	/**
	 * Set model for this view.
	 * 
	 * @param project single Project
	 */
	public void setInput(Project project) {

		GanttViewHelper.clearGantt(ganttChart, treeViewer.getTree());

		EList<WorkPackage> flatWorkItemList = new BasicEList<WorkPackage>();
		project.getAllModelElementsbyClass(TaskPackage.eINSTANCE.getWorkPackage(), flatWorkItemList);

		for (WorkPackage workPackage : GanttViewHelper.getRootWorkPackages(flatWorkItemList)) {
			Map<String, GanttEvent> mapWorkPackagesToGanttEvents = new HashMap<String, GanttEvent>();
			recurisveWorkPackageToGanttEvent(workPackage, true, mapWorkPackagesToGanttEvents);
			connectSuccessors(mapWorkPackagesToGanttEvents);
			mapWorkPackagesToGanttEvents.clear();
		}

		treeViewer.setInput(project);
		treeViewer.expandAll();
	}

	private int calculateProgress(WorkPackage wp) {
		int result = 0;

		int closedEstimate = wp.getClosedAggregatedEstimate();
		int estimate = wp.getAggregatedEstimate();
		result = (estimate == 0) ? 0 : (closedEstimate * 100) / estimate; // (x/0)=0

		return result;
	}

	private GanttEvent workPackageToGanttEvent(WorkPackage wp, Map<String, GanttEvent> mapWorkPackagesToGanttEvents) {
		Calendar startDate = Calendar.getInstance();
		Calendar endDate = (Calendar) startDate.clone();

		String eventName = wp.getName();

		// Checking for unset start- or dueDate since the GanttWidget can't handle null values here
		Date dstart = wp.getStartDate();
		Date dend = wp.getDueDate();
		if (dstart != null) {
			startDate.setTime(wp.getStartDate());
		} else if (wp.getContainingWorkpackage() != null && wp.getContainingWorkpackage().getStartDate() != null) {
			startDate.setTime(wp.getContainingWorkpackage().getStartDate());
		}
		if (dend != null) {
			endDate.setTime(wp.getDueDate());
		} else if (wp.getContainingWorkpackage() != null && wp.getContainingWorkpackage().getDueDate() != null) {
			endDate.setTime(wp.getContainingWorkpackage().getDueDate());
		}

		GanttEvent result = new GanttEvent(ganttChart, eventName, startDate, endDate, calculateProgress(wp));
		result.setData(wp);

		// TODO delete entries of this map if WorkPackages are deleted in the model
		mapWorkPackagesToGanttEvents.put(wp.getIdentifier(), result);

		return result;
	}

	private GanttEvent recurisveWorkPackageToGanttEvent(WorkPackage wp, boolean isRootWorkPackage,
		Map<String, GanttEvent> mapWorkPackagesToGanttEvents) {
		GanttEvent result = workPackageToGanttEvent(wp, mapWorkPackagesToGanttEvents);

		Set<ModelElement> subModels = wp.getContainedElements();
		if (subModels != null && !subModels.isEmpty()) {
			for (ModelElement modelElement : subModels) {
				if (modelElement == null || !(modelElement instanceof WorkPackage)) {
					continue;
				}

				GanttEvent childItem = mapWorkPackagesToGanttEvents.get(modelElement.getIdentifier());
				if (childItem == null) {
					childItem = recurisveWorkPackageToGanttEvent((WorkPackage) modelElement, false,
						mapWorkPackagesToGanttEvents);
				}
				result.addScopeEvent(childItem);
				result.setScope(true);
			}
		}

		return result;
	}

	private void connectSuccessors(Map<String, GanttEvent> mapWorkPackagesToGanttEvents) {
		Collection<GanttEvent> ganttEvents = mapWorkPackagesToGanttEvents.values();
		for (GanttEvent ganttEvent : ganttEvents) {
			WorkPackage childWp = (WorkPackage) ganttEvent.getData();
			EList<WorkItem> successors = childWp.getSuccessors();
			if (successors != null && !successors.isEmpty()) {
				for (WorkItem successor : successors) {
					if (successor == null || !(successor instanceof WorkPackage)) {
						continue;
					}

					GanttEvent sourceGanttEvent = mapWorkPackagesToGanttEvents.get(childWp.getIdentifier());
					GanttEvent targetGanttEvent = mapWorkPackagesToGanttEvents.get(successor.getIdentifier());
					if (sourceGanttEvent != null && targetGanttEvent != null) {
						ganttChart.addConnection(sourceGanttEvent, targetGanttEvent);
					}

				}
			}
		}
	}

	/**
	 * Passing the focus request to the viewer's control.
	 */
	@Override
	public void setFocus() {

	}

	/**
	 * TODO .
	 * 
	 * @param arg0 a GanttEvent
	 * @param arg1 a MouseEvent
	 */
	public void eventDoubleClicked(GanttEvent arg0, MouseEvent arg1) {
	}

	/**
	 * TODO .
	 * 
	 * @param arg0 a Calendar
	 * @param arg1 a List
	 */
	@SuppressWarnings("unchecked")
	public void eventHeaderSelected(Calendar arg0, List arg1) {
	}

	/**
	 * TODO .
	 * 
	 * @param arg0 a List
	 */
	@SuppressWarnings("unchecked")
	public void eventPropertiesSelected(List arg0) {
	}

	/**
	 * TODO .
	 * 
	 * @param arg0 a GanttEvent
	 * @param arg1 a List
	 * @param arg2 a MouseEvent
	 */
	@SuppressWarnings("unchecked")
	public void eventSelected(GanttEvent arg0, List arg1, MouseEvent arg2) {
	}

	/**
	 * TODO .
	 * 
	 * @param arg0 a List
	 * @param arg1 a MouseEvent
	 */
	@SuppressWarnings("unchecked")
	public void eventsDeleteRequest(List arg0, MouseEvent arg1) {
	}

	/**
	 * TODO finish implementation. Called after moving a bar.
	 * 
	 * @param arg0 a List
	 * @param arg1 a MouseEvent
	 */
	@SuppressWarnings("unchecked")
	public void eventsMoveFinished(List arg0, MouseEvent arg1) {

		Object eventObject = arg0.get(0);

		if (!(eventObject instanceof GanttEvent)) {
			return;
		}

		// TODO: Modify WorkPackage
		// GanttEvent ganttEvent = (GanttEvent) eventObject;
		// WorkPackage wp = (WorkPackage) ganttEvent.getData();
	}

	/**
	 * TODO .
	 * 
	 * @param arg0 a List
	 * @param arg1 a MouseEvent
	 */
	@SuppressWarnings("unchecked")
	public void eventsMoved(List arg0, MouseEvent arg1) {
	}

	/**
	 * TODO finish implementation. Called after resizing a bar.
	 * 
	 * @param arg0 GanttEvent at index 0
	 * @param arg1 unused MouseEvent
	 */
	@SuppressWarnings("unchecked")
	public void eventsResizeFinished(List arg0, MouseEvent arg1) {
		Object eventObject = arg0.get(0);

		if (!(eventObject instanceof GanttEvent)) {
			return;
		}

		// GanttEvent ganttEvent = (GanttEvent) eventObject;

		// Calendar startDate = ganttEvent.getRevisedStart() == null ? ganttEvent.getStartDate() : ganttEvent
		// .getRevisedStart();
		// Calendar endDate = ganttEvent.getRevisedEnd() == null ? ganttEvent.getEndDate() : ganttEvent.getRevisedEnd();
		//
		// WorkPackage wp = (WorkPackage) ganttEvent.getData();
	}

	/**
	 * TODO .
	 * 
	 * @param arg0 a List
	 * @param arg1 a MouseEvent
	 */
	@SuppressWarnings("unchecked")
	public void eventsResized(List arg0, MouseEvent arg1) {
	}

	/**
	 * TODO .
	 * 
	 * @param arg0 a List
	 */
	public void lastDraw(GC arg0) {
	}

	/**
	 * TODO .
	 */
	public void zoomReset() {
	}

	/**
	 * TODO .
	 * 
	 * @param arg0 an integer
	 */
	public void zoomedIn(int arg0) {
	}

	/**
	 * TODO .
	 * 
	 * @param arg0 an integer
	 */
	public void zoomedOut(int arg0) {
	}
}