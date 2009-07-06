package org.unicase.ui.tom.notifications;

import org.unicase.ui.tom.touches.Touch;

public abstract class TouchAdapterImpl implements TouchAdapter {

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
	
	public abstract void handleTouchAdded(Touch touch);

	public abstract void handleTouchRemoved(Touch touch);
	
	public abstract void handleTouchChanged(Touch touch);
}
