package org.unicase.ui.ganttview.views;
import java.util.Calendar;
import java.util.List;

import org.eclipse.nebula.widgets.ganttchart.GanttChart;
import org.eclipse.nebula.widgets.ganttchart.GanttEvent;
import org.eclipse.nebula.widgets.ganttchart.IGanttEventListener;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.graphics.GC;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Composite;
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
	
	
	private IGanttModel ganttModel;
	private GanttChart ganttChart;
	private Composite parent;
	
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
		ganttChart = new GanttChart(this.parent, SWT.NONE);
		ganttChart.addGanttEventListener(this);
		this.setInput(null); // Create GanttModel with all WorkItems
	}
	
	public void setInput(IGanttModel ganttModel) {
		
		if(ganttModel == null)
			return;
		
		this.ganttModel = ganttModel;
		this.ganttModel.addGanttModelListener(this);
		updateView();
	}
	
	

	private void updateView() {
		
		for(IGanttItem ganttItem : ganttModel.getRootGanttItems()) {
		
			GanttEvent rootEvent = new GanttEvent(ganttChart, ganttItem.getName());
			rootEvent.setData(ganttItem);
			CreateChildEvents(ganttItem, rootEvent);
			
		}
		
	}

	private void CreateChildEvents(IGanttItem ganttItem, GanttEvent rootEvent) {
		
		for(IGanttItem childItem : ganttItem.getChildGanttItems()) {
			
			GanttEvent childEvent = new GanttEvent(ganttChart, childItem.getName(), childItem.getStartDate(), childItem.getEndDate(), childItem.getCompletionStatus());
			childEvent.setData(childItem);
			rootEvent.addScopeEvent(childEvent);
			CreateChildEvents(childItem, childEvent);
		}
	}

	/**
	 * Passing the focus request to the viewer's control.
	 */
	@Override
	public void setFocus() {
		
	}

	
	public void ganttItemChanged(IGanttItem ganttItem) {
		System.out.println(ganttItem.getName());
		System.out.println(ganttItem.getStartDate().getTime().toString());
		System.out.println(ganttItem.getEndDate().getTime().toString());
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