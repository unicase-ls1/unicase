package org.unicase.ui.ganttview.views;
import java.util.Observable;
import java.util.Observer;

import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.part.*;
import org.eclipse.jface.viewers.*;
import org.eclipse.swt.graphics.Image;
import org.eclipse.jface.action.*;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.ui.*;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.SWT;
import org.unicase.ui.ganttview.models.impl.GanttModel;


public class GanttView extends ViewPart  implements Observer {
	
	 
	private GanttModel ganttModel;
	
	
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
		this.ganttModel = new GanttModel();			
		ganttModel.addObserver(this);			
		ganttModel.setInput();
		
		//Create GanttWidget and set Data from ganttModel.getRootGanttItems
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