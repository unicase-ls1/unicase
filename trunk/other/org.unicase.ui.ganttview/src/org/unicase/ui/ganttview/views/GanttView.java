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
import org.unicase.model.ModelElement;
import org.unicase.model.Project;
import org.unicase.model.task.TaskPackage;
import org.unicase.model.task.WorkItem;
import org.unicase.model.task.WorkPackage;
import org.unicase.model.task.util.EstimateHelper;
import org.unicase.ui.ganttview.util.GanttViewHelper;
import org.unicase.ui.stem.views.iterationplanningview.EMFColumnLabelProvider;
import org.unicase.workspace.ProjectSpace;
import org.unicase.workspace.WorkspaceManager;

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
	 */
	@Override
	public void createPartControl(Composite parent) {
		this.parent = parent;
		this.parent.setLayout(new FillLayout());
		ScrolledComposite ganttContainer = new ScrolledComposite(this.parent, SWT.V_SCROLL);
		SashForm sashForm = new SashForm(ganttContainer, SWT.HORIZONTAL);

		// GanttControlParent ganttCpLeft = new GanttControlParent(sashForm, SWT.NONE);

		// createTree(ganttCpLeft);
		createTree(sashForm);

		UnicaseSettings roSettings = new ReadOnlySettings();

		// roSettings.setEventHeight(treeViewer.getTree().getItemHeight() + treeViewer.getTree().getGridLineWidth());
		// treeViewer.getTree().getItem(0).getBounds().height
		// roSettings.setEventHeight(treeViewer.getTree().getItem(0).getBounds().height);
		// roSettings.setHeaderHeight(treeViewer.getTree().getHeaderHeight());
		ganttChart = new GanttChart(sashForm, SWT.NONE, roSettings);

		// System.out.println("treeViewer.getTree().getItemHeight(): " + treeViewer.getTree().getItemHeight());
		// System.out.println("treeViewer.getTree().getGridLineWidth(): " + treeViewer.getTree().getGridLineWidth());
		// System.out.println("treeViewer.getTree().computeSize(999, 999): " + treeViewer.getTree().computeSize(999,
		// 999));
		//
		// System.out.println("roSettings.getEventHeight(): " + roSettings.getEventHeight());
		// System.out.println("roSettings.getEventSpacer(): " + roSettings.getEventSpacer());
		// System.out.println("roSettings.getEventsTopSpacer(): " + roSettings.getEventsTopSpacer());
		// System.out.println("roSettings.getEventsBottomSpacer(): " + roSettings.getEventsBottomSpacer());

		ganttChart.addGanttEventListener(this);

		ganttChart.getGanttComposite().setDrawHorizontalLinesOverride(true);
		ganttChart.getGanttComposite().setDrawVerticalLinesOverride(false);
		// ganttChart.getGanttComposite().setFixedRowHeightOverride(ONE_ROW_HEIGHT - SPACER);
		// ganttChart.getGanttComposite().setEventSpacerOverride(SPACER);
		// ganttCpLeft.setGanttChart(ganttChart);

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
		treeViewer.setLabelProvider(new GanttTreeLabelProvider());

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
				if (tree.getSelectionCount() == 0)
					return;

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

					if (wp.getStartDate() == null)
						return "";

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

					if (wp.getDueDate() == null)
						return "";

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
		// TODO rm
		// System.out.println("treeViewer.getTree().getItemHeight() 2: " + treeViewer.getTree().getItemHeight());
		// System.out.println("treeViewer.getTree().getGridLineWidth() 2: " + treeViewer.getTree().getGridLineWidth());
	}

	private int calculateProgress(WorkPackage wp) {
		int result = 0;

		int closedEstimate = wp.getClosedAggregatedEstimate();
		int estimate = EstimateHelper.getAggregatedEstimate(wp);
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

	public void eventDoubleClicked(GanttEvent arg0, MouseEvent arg1) {
		// TODO Auto-generated method stub

	}

	public void eventHeaderSelected(Calendar arg0, List arg1) {
		// TODO Auto-generated method stub

	}

	public void eventPropertiesSelected(List arg0) {
		// TODO Auto-generated method stub

	}

	public void eventSelected(GanttEvent arg0, List arg1, MouseEvent arg2) {
		// TODO Auto-generated method stub

	}

	public void eventsDeleteRequest(List arg0, MouseEvent arg1) {
		// TODO Auto-generated method stub

	}

	public void eventsMoveFinished(List arg0, MouseEvent arg1) {

		Object eventObject = arg0.get(0);

		if (!(eventObject instanceof GanttEvent)) {
			return;
		}

		GanttEvent ganttEvent = (GanttEvent) eventObject;
		WorkPackage wp = (WorkPackage) ganttEvent.getData();
		// TODO: Modify WorkPackage

	}

	public void eventsMoved(List arg0, MouseEvent arg1) {
		// TODO Auto-generated method stub
	}

	public void eventsResizeFinished(List arg0, MouseEvent arg1) {
		Object eventObject = arg0.get(0);

		if (!(eventObject instanceof GanttEvent)) {
			return;
		}

		GanttEvent ganttEvent = (GanttEvent) eventObject;

		Calendar startDate = ganttEvent.getRevisedStart() == null ? ganttEvent.getStartDate() : ganttEvent
			.getRevisedStart();
		Calendar endDate = ganttEvent.getRevisedEnd() == null ? ganttEvent.getEndDate() : ganttEvent.getRevisedEnd();

		WorkPackage wp = (WorkPackage) ganttEvent.getData();

		// wp.setStartDate(startDate.getTime());
		// wp.setDueDate(endDate.getTime());
		// TODO: Modify WorkPackage

	}

	public void eventsResized(List arg0, MouseEvent arg1) {
		// TODO Auto-generated method stub
	}

	public void lastDraw(GC arg0) {
		// TODO Auto-generated method stub

	}

	public void zoomReset() {
		// TODO Auto-generated method stub

	}

	public void zoomedIn(int arg0) {
		// TODO Auto-generated method stub

	}

	public void zoomedOut(int arg0) {
		// TODO Auto-generated method stub

	}
}