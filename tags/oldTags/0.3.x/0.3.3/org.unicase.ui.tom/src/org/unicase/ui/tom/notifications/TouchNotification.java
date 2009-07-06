package org.unicase.ui.tom.notifications;

import org.unicase.ui.tom.touches.Touch;

public interface TouchNotification {
	
	int touchAdded = 0;
	
	int touchRemoved = 1;
	
	int touchChanged = 2;
	
	int getEventType();
	
	Touch getTouch();
}
