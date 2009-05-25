package org.unicase.ui.ganttview.views;
import java.util.Calendar;
import java.util.List;

import org.eclipse.nebula.widgets.ganttchart.GanttChart;
import org.eclipse.nebula.widgets.ganttchart.GanttEvent;
import org.eclipse.nebula.widgets.ganttchart.GanttGroup;
import org.eclipse.nebula.widgets.ganttchart.GanttSection;
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


public class GanttView extends ViewPart implements IGanttModelListener, IGanttEventListener {
	
	/**
	 * ID for this view.
	 */
	public static final String ID = "org.unicase.ui.ganttview.views.GanttView";
	
	
	private IGanttModel ganttModel;
	private GanttChart ganttChart;
	
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
			
		parent.setLayout(new FillLayout());
		ganttChart = new GanttChart(parent, SWT.NONE);
		ganttChart.addGanttEventListener(this);
		this.setInput(null); // Create GanttModel with all WorkItems

	}
	
	public void setInput(IGanttModel ganttModel ) {
		
		if(ganttModel == null)
			return;
		
		this.ganttModel = ganttModel;
		this.ganttModel.addGanttModelListener(this);
		updateView();
	}
	

	
	private void updateView() {
		
		for(IGanttItem ganttItem : ganttModel.getRootGanttItems()) {
			
			GanttEvent rootEvent = new GanttEvent(ganttChart, ganttItem.getName());
			CreateChildEvents(ganttItem, rootEvent);
		}
		
		ganttChart.redraw();
	}

	private void CreateChildEvents(IGanttItem ganttItem, GanttEvent rootEvent) {
		
		for(IGanttItem childItem : ganttItem.getChildGanttItems()) {
			
			GanttEvent childEvent = new GanttEvent(ganttChart, childItem.getName(), childItem.getStartDate(), childItem.getEndDate(), childItem.getCompletionStatus());
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

	
	public void ganttModelChanged(IGanttItem ganttItem) {
		updateView();
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
		// TODO Auto-generated method stub
		
	}

	public void eventsMoved(List arg0, MouseEvent arg1) {
		
	}

	public void eventsResizeFinished(List arg0, MouseEvent arg1) {
		// TODO Auto-generated method stub
		
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