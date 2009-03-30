package org.unicase.ui.tom.notifications;

import org.unicase.ui.tom.gestures.Gesture;

public interface GestureNotification {

	int gestureExecutionChange = 0;
	
	int gestureAcceptanceChange = 1;
	
	int getEventType();
	
	Gesture getGesture();
}
