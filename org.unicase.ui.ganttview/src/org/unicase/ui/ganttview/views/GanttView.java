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
import org.unicase.ui.ganttview.models.impl.GanttModel;


public class GanttView extends ViewPart  implements Observer {
	
	/**
	 * ID for this view.
	 */
	public static final String ID = "org.unicase.ui.ganttview.views.GanttView";
	
	
	private GanttModel ganttModel;
	
	
	/**
	 * The constructor.
	 */
	public GanttView() {
		this.ganttModel = new GanttModel(); // TODO:Create GanttModel with all WorkItems
		ganttModel.addObserver(this);
	}

	/**
	 * This is a callback that will allow us
	 * to create the viewer and initialize it.
	 */
	@Override
	public void createPartControl(Composite parent) {	
		
		
		parent.setLayout(new FillLayout());

		// create chart
		GanttChart ganttChart = new GanttChart(parent, SWT.NONE);

		// create scope
		GanttEvent scopeEvent = new GanttEvent(ganttChart, "Scope");

		// create some dates for our events
		Calendar sdEventOne = Calendar.getInstance();
		Calendar edEventOne = Calendar.getInstance();
		edEventOne.add(Calendar.DATE, 10);

		Calendar rsEventOne = Calendar.getInstance();
		Calendar reEventOne = Calendar.getInstance();
		rsEventOne.add(Calendar.DATE, -5);
		reEventOne.add(Calendar.DATE, 5);

		// create event 1 with custom colors
		GanttEvent eventOne = new GanttEvent(ganttChart, "Event 1", sdEventOne, edEventOne, rsEventOne, reEventOne, 35);
		eventOne.setStatusColor(ColorCache.getColor(70, 132, 96));
		eventOne.setGradientStatusColor(ColorCache.getColor(160, 210, 181));

		Calendar sdEventTwo = Calendar.getInstance();
		Calendar edEventTwo = Calendar.getInstance();
		sdEventTwo.add(Calendar.DATE, 11);
		edEventTwo.add(Calendar.DATE, 15);
		// create event 2 with custom colors
		GanttEvent eventTwo = new GanttEvent(ganttChart, "Event 2", sdEventTwo, edEventTwo, 10);
		eventTwo.setStatusColor(ColorCache.getColor(81, 104, 145));
		eventTwo.setGradientStatusColor(ColorCache.getColor(168, 185, 216));

		Calendar chkStartAndEnd = Calendar.getInstance();
		chkStartAndEnd.add(Calendar.DATE, 16);
		GanttEvent eventCheckpoint = new GanttEvent(ganttChart, "Checkpoint", chkStartAndEnd, chkStartAndEnd, 75);
		eventCheckpoint.setCheckpoint(true);

		// create a custom menu item on the checkpoint
		MenuItem testItem = new MenuItem(eventCheckpoint.getMenu(), SWT.PUSH);
		testItem.setText("I am a custom event menu item!");
		testItem.addListener(SWT.Selection, new Listener() {
			public void handleEvent(Event event) {
				System.out.println("You clicked the custom event");
			}
		});

		// create sections, each one with a different color
		GanttSection gs = new GanttSection(ganttChart, "Section One");
		// tell this section what events belong to it
		gs.addGanttEvent(scopeEvent);
		gs.addGanttEvent(eventOne);
		gs.addGanttEvent(eventTwo);

		GanttSection gs2 = new GanttSection(ganttChart, "Section Two");
		// change the color to make it stand out, the bottom gradient will be pulled from settings (as will all other colors unless they are set)
		gs2.setWeekdayBackgroundColorTop(ColorCache.getColor(242, 231, 215));
		gs2.addGanttEvent(eventCheckpoint);

		GanttSection gs3 = new GanttSection(ganttChart, "Section Three");
		gs3.setWeekdayBackgroundColorTop(ColorCache.getColor(242, 215, 235));

		GanttSection gs4 = new GanttSection(ganttChart, "Section Four");
		gs4.setWeekdayBackgroundColorTop(ColorCache.getColor(215, 242, 222));

		// add loads of connections from everything to everything (pretty much) that even cross over sections and are reverse in dependencies as well.
		ganttChart.addConnection(eventOne, eventTwo);
		ganttChart.addConnection(eventTwo, eventOne);
		ganttChart.addConnection(eventOne, eventCheckpoint);
		ganttChart.addConnection(eventTwo, eventCheckpoint);

		ganttChart.addConnection(scopeEvent, eventOne);
		ganttChart.addConnection(scopeEvent, eventTwo);
		ganttChart.addConnection(scopeEvent, eventCheckpoint);

		ganttChart.addConnection(eventCheckpoint, scopeEvent);
		ganttChart.addConnection(eventCheckpoint, eventTwo);
		ganttChart.addConnection(eventCheckpoint, eventOne);

		// tell the scope what events belong to us. Note again that we add a cross-section event to the scope, which is possible but most likely illogical.
		scopeEvent.addScopeEvent(eventOne);
		scopeEvent.addScopeEvent(eventTwo);
		scopeEvent.addScopeEvent(eventCheckpoint);

		
		//Create GanttWidget and set Data from ganttModel.getRootGanttItems
	}
	
	public void setInput(GanttModel ganttModel ) {
		this.ganttModel = ganttModel;
		ganttModel.addObserver(this);
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