package org.unicase.ui.tom.gestures;

import java.util.ArrayList;
import java.util.List;

import org.unicase.ui.tom.TouchDispatch;
import org.unicase.ui.tom.Utility;
import org.unicase.ui.tom.notifications.GestureAdapter;
import org.unicase.ui.tom.notifications.GestureNotification;
import org.unicase.ui.tom.notifications.TouchAdapter;
import org.unicase.ui.tom.notifications.TouchNotification;
import org.unicase.ui.tom.notifications.TouchNotificationImpl;
import org.unicase.ui.tom.notifications.TouchNotifierImpl;
import org.unicase.ui.tom.touches.Touch;

public class GestureInterpreter extends TouchNotifierImpl 
implements TouchAdapter, GestureAdapter{

	private TouchDispatch dispatch;
	private List<Gesture> gestures;

	public GestureInterpreter(TouchDispatch dispatch) {
		setDispatch(dispatch);
		setGestures(new ArrayList<Gesture>());
	}

	public GestureInterpreter() {
		this(null);
	}

	public void addGesture(Gesture gesture) {
		getGestures().add(gesture);
		gesture.getAdapters().add(this);
	}


	public void notifyChanged(TouchNotification notification) {
		switch (notification.getEventType()) {
		case TouchNotification.touchAdded:
			handleTouchAdded(notification.getTouch());
			break;
		case TouchNotification.touchRemoved:
			handleTouchRemoved(notification.getTouch());
			break;
		case TouchNotification.touchChanged:
			handleTouchChanged(notification.getTouch());
			break;
		default:
			break;
		}
	}

	public void handleTouchAdded(Touch touch) {
		//don't do anything
	}


	public void handleTouchChanged(Touch touch) {
		//don't do anything		
	}

	public void handleTouchRemoved(Touch touch) {
		notifyAdapters(new TouchNotificationImpl(touch, TouchNotification.touchRemoved));

		if (getDispatch().getActiveTouches().size() == 0) {
			for (Gesture gesture : getGestures()) {
				gesture.reset();
			}
		}
	}

	public void notifyChanged(GestureNotification notification) {
		switch (notification.getEventType()) {
		case GestureNotification.gestureExecutionChange:
			handleGestureExecutionChanged(notification.getGesture());
			break;
		case GestureNotification.gestureAcceptanceChange:
			handleGestureAcceptanceChanged(notification.getGesture());
		default:
			break;
		}

	}

	private void handleGestureAcceptanceChanged(Gesture gesture) {
		if (!gesture.getAcceptsTouches()) {
			for (Gesture currentGesture : getGestures()) {
				if (currentGesture.getAcceptsTouches()) {
					return;
				}
			}
			System.out.println("There are no more gestures accepting touches");
			Utility.beep(1);
		}
	}

	public void handleGestureExecutionChanged(Gesture gesture){
		if (gesture.getCanExecute()) {
			gesture.execute();			
		}
	}

	public void setDispatch(TouchDispatch dispatch) {
		if (dispatch != this.dispatch) {
			if (this.dispatch != null) {
				this.dispatch.getAdapters().remove(this);	
			}
			this.dispatch = dispatch;
			if (this.dispatch!= null) {
				this.dispatch.getAdapters().add(this);	
			}			
		}
	}

	public TouchDispatch getDispatch() {
		return dispatch;
	}

	public void setGestures(List<Gesture> gestures) {
		this.gestures = gestures;
	}

	public List<Gesture> getGestures() {
		return gestures;
	}
}
