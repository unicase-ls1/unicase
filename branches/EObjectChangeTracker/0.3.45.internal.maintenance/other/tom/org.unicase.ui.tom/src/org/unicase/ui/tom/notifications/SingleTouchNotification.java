package org.unicase.ui.tom.notifications;

import org.unicase.ui.tom.touches.SingleTouch;

public interface SingleTouchNotification {
	
	int touchAdded = 0;
	
	int touchRemoved = 1;
	
	int touchChanged = 2;
	
	int touchPropagated = 3;
	
	int getEventType();
	
	SingleTouch getTouch();
}
