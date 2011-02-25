package org.unicase.ui.tom.notifications;

import org.unicase.ui.tom.gestures.Gesture;

public abstract class GestureAdapterImpl {

	public void notifyChanged(GestureNotification notification) {
		switch (notification.getEventType()) {
		case GestureNotification.gestureExecutionChange:
			handleExecutionChanged(notification.getGesture());
			break;
		case GestureNotification.gestureAcceptanceChange:
			handleAcceptanceChanged(notification.getGesture());
			break;
		default:
			break;
		}
	}
	
	public abstract void handleExecutionChanged(Gesture gesture);

	public abstract void handleAcceptanceChanged(Gesture gesture);
	
}
