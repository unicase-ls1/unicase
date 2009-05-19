package org.unicase.ui.ganttview.views;
import java.util.Calendar;
import java.util.Observable;
import java.util.Observer;

import org.eclipse.nebula.widgets.ganttchart.ColorCache;
import org.eclipse.nebula.widgets.ganttchart.GanttChart;
import org.eclipse.nebula.widgets.ganttchart.GanttEvent;
import org.eclipse.nebula.widgets.ganttchart.GanttSection;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IPartListener;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.part.ViewPart;
import org.unicase.ui.ganttview.models.IGanttItem;
import org.unicase.ui.ganttview.models.impl.GanttModel;
import org.unicase.ui.ganttview.util.GanttViewHelper;


public class GanttView extends ViewPart  implements Observer {
	
	/**
	 * ID for this view.
	 */
	public static final String ID = "org.unicase.ui.ganttview.views.GanttView";
	
	
	private GanttModel ganttModel;
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
		this.setInput(new GanttModel()); // Create GanttModel with all WorkItems

	}
	
	public void setInput(GanttModel ganttModel ) {
		this.ganttModel = ganttModel;
		ganttModel.addObserver(this);
		updateView(ganttModel);
	}
	

	
	private void updateView(GanttModel ganttModel) {
		
		for(IGanttItem ganttItem : ganttModel.getRootGanttItems()) {
			
			GanttSection section = new GanttSection(ganttChart, ganttItem.getName());
			GanttEvent rootEvent = new GanttEvent(ganttChart, ganttItem.getName(), ganttItem.getStartDate(), ganttItem.getEndDate(), ganttItem.getCompletionStatus());
			section.addGanttEvent(rootEvent);
			
			CreateChildEvents(ganttChart, ganttItem, rootEvent);
				
		}
	}

	private void CreateChildEvents(GanttChart ganttChart, IGanttItem ganttItem, GanttEvent ganttEvent) {
		
		for(IGanttItem childItem : ganttItem.getChildren()) {
			GanttEvent childEvent = new GanttEvent(ganttChart, childItem.getName(), childItem.getStartDate(), childItem.getEndDate(), childItem.getCompletionStatus());
			ganttEvent.addScopeEvent(childEvent);
			CreateChildEvents(ganttChart, childItem, childEvent);
		}
	}

	/**
	 * Passing the focus request to the viewer's control.
	 */
	@Override
	public void setFocus() {
		
	}

	public void update(Observable observable, Object arg1) {
		// TODO Auto-generated method stub
		
	}
}