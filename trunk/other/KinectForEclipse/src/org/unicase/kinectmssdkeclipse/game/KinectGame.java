package org.unicase.kinectmssdkeclipse.game;

import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.RowData;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.PlatformUI;
import org.unicase.kinectmssdkeclipse.Gesture;
import org.unicase.kinectmssdkeclipse.GestureRecognition;
import org.unicase.kinectmssdkeclipse.KinectConnection;
import org.unicase.kinectmssdkeclipse.SkeletalTracking;

public class KinectGame {
	private Display display;
	private Runnable timer;
	private final int invocationTime=1000;
	private final int stopTime=10;

	
	
	public void startGame() {
		//init();
		//startGestureRecoginition();
	}
	
	private void startGestureRecoginition() {
		SkeletalTracking skeletalTracking = KinectConnection.getInstance().startSkeletonTracking();
		if (skeletalTracking != null) {
			final GestureRecognition gestureRecognition = skeletalTracking.getGestureRecognition();
			
			Runnable gestureListener = new Runnable() {

				@Override
				public void run() {
					Gesture actualGesture = gestureRecognition.getActualRecognizedGesture();
					while (actualGesture.equals(gestureRecognition.getActualRecognizedGesture())) {
						KinectGame.this.display.timerExec(-1, KinectGame.this.timer);
					}
					
				}
				
			};
			
			gestureListener.run();
		}
		
	}

	private void startTimer() {
		display.timerExec(invocationTime, timer);	
	}

	private void init() {
		display = PlatformUI.createDisplay();
	    final Color red = display.getSystemColor(SWT.COLOR_CYAN);
	    Shell shell = new Shell(display);
	    shell.setLayout(new RowLayout());
	    shell.setMinimumSize(150, 75);
	    Button button = new Button(shell, SWT.PUSH);
	    button.setText("Stop Timer");
	    final Label label = new Label(shell, SWT.BORDER);
	    label.setBackground(red);
	   
	    timer = new Runnable() {
	    		int stopWatch = stopTime;
	       		public void run() {
	       			if (label.isDisposed())
	       				return;
	       			label.setText(" " + stopWatch);
	       			label.setAlignment(SWT.CENTER);
	       			label.setFont(new Font(display, "Arial", 40, SWT.BOLD));
	       			if (stopWatch > 0) {
	       				stopWatch-=1;
	       			} else {
	       				display.timerExec(-1,this);
	       			}
	       			display.timerExec(invocationTime, this);
	       		}
	    };
	    button.addListener(SWT.Selection, new Listener() {
		      public void handleEvent(Event event) {
		        display.timerExec(-1, timer);
		      }
		    });
	    
	    button.pack();
	    label.setLayoutData(new RowData(new Point(80, 75)));
	    shell.pack();
	    shell.open();
	    /*while (!shell.isDisposed()) {
	      if (!display.readAndDispatch())
	        display.sleep();
	    }
	    display.dispose();*/
	}

}
