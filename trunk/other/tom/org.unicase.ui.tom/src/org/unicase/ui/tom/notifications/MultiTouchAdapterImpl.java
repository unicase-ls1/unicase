package org.unicase.ui.tom.notifications;

import org.unicase.ui.tom.touches.MultiTouch;

public abstract class MultiTouchAdapterImpl implements MultiTouchAdapter {
	
	public void notifyChanged(MultiTouchNotification notification) {
		switch (notification.getEventType()) {
		case MultiTouchNotification.touchClaimed:
			handleTouchClaimed(notification.getTouch());
			break;
		default:
			break;
		}
	}
	
	public abstract void handleTouchClaimed(MultiTouch touch);
}
