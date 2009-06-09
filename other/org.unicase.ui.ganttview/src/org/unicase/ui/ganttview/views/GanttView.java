package org.unicase.ui.ganttview.views;
import java.util.Calendar;
import java.util.List;

import org.eclipse.nebula.widgets.ganttchart.GanttChart;
import org.eclipse.nebula.widgets.ganttchart.GanttControlParent;
import org.eclipse.nebula.widgets.ganttchart.GanttEvent;
import org.eclipse.nebula.widgets.ganttchart.IGanttEventListener;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.SashForm;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.graphics.GC;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.swt.widgets.TreeColumn;
import org.eclipse.swt.widgets.TreeItem;
import org.eclipse.ui.part.ViewPart;
import org.unicase.ui.ganttview.models.IGanttItem;
import org.unicase.ui.ganttview.models.IGanttModel;
import org.unicase.ui.ganttview.models.IGanttModelListener;
import org.unicase.ui.ganttview.util.GanttViewHelper;


public class GanttView extends ViewPart implements IGanttModelListener, IGanttEventListener {
	
	/**
	 * ID for this view.
	 */
	public static final String ID = "org.unicase.ui.ganttview.views.GanttView";
	
	private static final int SPACER = 2;
	private static final int ONE_ROW_HIGHT = 24;
	
	
	private IGanttModel ganttModel;
	private GanttChart ganttChart;
	private Composite parent;
	private Tree tree;
	
	/**
	 * The constructor.
	 */
	public GanttView() {
		
	}

	/**
	 * This is a callback that will allow us
	 * to create the viewer and initialize it.
	 */
	@Override
	public void createPartControl(Composite parent) {	
		this.parent = parent;	
		this.parent.setLayout(new FillLayout());
		SashForm sashForm = new SashForm(this.parent, SWT.HORIZONTAL);
		GanttControlParent ganttCpLeft = new GanttControlParent(sashForm, SWT.NONE);
		
		ganttChart = new GanttChart(sashForm, SWT.NONE);
		ganttChart.addGanttEventListener(this);
		
		
		ganttChart.getGanttComposite().setDrawHorizontalLinesOverride(true);
		ganttChart.getGanttComposite().setDrawVerticalLinesOverride(false);
		ganttChart.getGanttComposite().setFixedRowHeightOverride(ONE_ROW_HIGHT-SPACER);
		ganttChart.getGanttComposite().setEventSpacerOverride(SPACER);
		ganttCpLeft.setGanttChart(ganttChart);
		
		tree = new Tree(ganttCpLeft, SWT.BORDER | SWT.V_SCROLL | SWT.H_SCROLL | SWT.FULL_SELECTION);
		tree.setHeaderVisible(true);
		tree.setLinesVisible(true);

		// normally a tree item height on XP is 16 pixels. This is rather tight for a GANTT chart as it leaves little space for connecting lines etc.
		// As we want some air, we force each item height to be 24 pixels.
		tree.addListener(SWT.MeasureItem, new Listener() {
			public void handleEvent(Event event) {
				event.height = ONE_ROW_HIGHT;
			}
		});
		
		// when a root node is collapsed/expanded, we collapse the entire scope in a similar fashion
		Listener expandCollapseListener = new Listener() {
			public void handleEvent(Event event) {
				GanttEvent ge = (GanttEvent)event.item.getData();

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

		//tree.addListener(SWT.Collapse, expandCollapseListener);
		//tree.addListener(SWT.Expand, expandCollapseListener);


		TreeColumn tcName = new TreeColumn(tree, SWT.NONE);
		tcName.setText("Name");
		tcName.setWidth(150);
		
		TreeColumn tcStartDate = new TreeColumn(tree, SWT.NONE);
		tcStartDate.setText("Start");
		tcStartDate.setWidth(100);
		
		TreeColumn tcEndDateDate = new TreeColumn(tree, SWT.NONE);
		tcEndDateDate.setText("End");
		tcEndDateDate.setWidth(100);
		
		TreeColumn tcCompleted = new TreeColumn(tree, SWT.NONE);
		tcCompleted.setText("Completed");
		tcCompleted.setWidth(100);

		sashForm.setWeights(new int[] { 30, 70 });
		
//		this.setInput(GanttModelFactory.createGanttModelTest());		
		// TODO:this.setInput(GanttModelFactory.createGanttModelFromWorkItems());
	}
	
	public void setInput(IGanttModel ganttModel) {
		
		if(ganttModel == null)
			return;
		
		this.ganttModel = ganttModel;
		this.ganttModel.addGanttModelListener(this);
		recreateView();
	}
	
	

	private void recreateView() {
		
		GanttViewHelper.clearGantt(ganttChart, tree);
		
		for(IGanttItem ganttItem : ganttModel.getRootGanttItems()) {
												
			TreeItem rootTreeItem = GanttViewHelper.createRootTreeItemWithGanttEvent(tree, ganttChart, ganttItem);
			CreateChildEvents(ganttItem, rootTreeItem);
			rootTreeItem.setExpanded(true);
		}
		
		SetGanttConnections();
		
	}

	private void SetGanttConnections() {
		
		for(Object eventObject : ganttChart.getGanttComposite().getEvents()) {
			IGanttItem ganttItem = (IGanttItem)((GanttEvent)eventObject).getData();
			
			if(ganttItem.getSuccessors() != null) {
				for(IGanttItem successor : ganttItem.getSuccessors()) {
					ganttChart.addConnection((GanttEvent)eventObject, GanttViewHelper.getGanttEventByGanttItem(ganttChart, successor));
				}
			}
		}
	}

	private void CreateChildEvents(IGanttItem ganttItem, TreeItem rootTreeItem) {
		
		for(IGanttItem childItem : ganttItem.getChildGanttItems()) {
			
			TreeItem childTreeItem = GanttViewHelper.createChildTreeItemWithGanttEvent(rootTreeItem, ganttChart, childItem);
			CreateChildEvents(childItem, childTreeItem);
		}
	}

	/**
	 * Passing the focus request to the viewer's control.
	 */
	@Override
	public void setFocus() {
		
	}

	
	public void ganttItemChanged(IGanttItem ganttItem) {
		
		TreeItem treeItem = GanttViewHelper.getTreeItemByGanttItem(tree, ganttItem);
	
		if(treeItem == null)
			return;
		
		GanttViewHelper.setTreeItemText(treeItem, ganttItem);
		tree.redraw();
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
		
		if(!(eventObject instanceof GanttEvent))
			return;
		
		GanttEvent ganttEvent = (GanttEvent) eventObject;
		IGanttItem ganttItem = (IGanttItem)ganttEvent.getData();
		ganttModel.modifyGanttItem(ganttItem.getName(), ganttEvent.getRevisedStart(), ganttEvent.getRevisedEnd());
		
	}

	public void eventsMoved(List arg0, MouseEvent arg1) {
		// TODO Auto-generated method stub
	}

	public void eventsResizeFinished(List arg0, MouseEvent arg1) {
		Object eventObject = arg0.get(0);
		
		if(!(eventObject instanceof GanttEvent))
			return;
		
		GanttEvent ganttEvent = (GanttEvent) eventObject;
		IGanttItem ganttItem = (IGanttItem)ganttEvent.getData();
		
		Calendar startDate = ganttEvent.getRevisedStart() == null ? ganttItem.getStartDate() : ganttEvent.getRevisedStart();
		Calendar endDate = ganttEvent.getRevisedEnd() == null ? ganttItem.getEndDate() : ganttEvent.getRevisedEnd();
		
		ganttModel.modifyGanttItem(ganttItem.getName(), startDate, endDate);
		
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