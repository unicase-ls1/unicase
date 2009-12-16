package org.unicase.ui.tom.notifications;

import org.unicase.ui.tom.touches.MultiTouch;

public interface MultiTouchNotification {

	int touchClaimed = 0;
	
	int getEventType();
	
	MultiTouch getTouch();
	
}
