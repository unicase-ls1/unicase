package org.unicase.kinectmssdkeclipse.game;

import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.RowData;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.part.ViewPart;

public class KinectGameTimer extends ViewPart {
	private Display display;
	private Runnable timer;
	private final int invocationTime=1000;
	private int startTime=0;
	
	public KinectGameTimer() {
		super();
	}

	@Override
	public void createPartControl(Composite parent) {
		display = PlatformUI.createDisplay();
	
	    Button startButton = new Button(parent, SWT.PUSH);
	    startButton.setText("Start Game");
	    startButton.setBackground(display.getSystemColor(SWT.COLOR_GREEN));
	    
	    Button stopButton = new Button(parent,SWT.PUSH);
	    stopButton.setText("Stop Game");
	    stopButton.setBackground(display.getSystemColor(SWT.COLOR_RED));
	    
	    final Label label = new Label(parent, SWT.BORDER);
	    label.setBackground(display.getSystemColor(SWT.COLOR_CYAN));
	   
	    timer = new Runnable() {
	       		public void run() {
	       			if (label.isDisposed())
	       				return;
	       			label.setText(" " + startTime);
	       			label.setAlignment(SWT.CENTER);
	       			label.setFont(new Font(display, "Arial", 40, SWT.BOLD));
	       			startTime++;
	       			display.timerExec(invocationTime, this);
	       		}
	    };
	    startButton.addListener(SWT.Selection, new Listener() {
		      public void handleEvent(Event event) {
		    	  KinectGame game = new KinectGame();
		    	  game.startGame();
		    	  KinectGameTimer.this.startTimer();
		      }
		    });
	    
	    stopButton.addListener(SWT.Selection,new Listener() {

			@Override
			public void handleEvent(Event event) {
				display.timerExec(-1, timer);
			}
	    	
	    });

	}

	@Override
	public void setFocus() {
		// TODO Auto-generated method stub

	}
	
	
	public void startTimer() {
		startTime=0;
		display.timerExec(invocationTime, timer);	
	}

}
