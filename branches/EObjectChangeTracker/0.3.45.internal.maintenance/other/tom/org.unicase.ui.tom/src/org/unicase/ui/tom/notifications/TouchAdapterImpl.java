package org.unicase.ui.tom.notifications;

import org.unicase.ui.tom.touches.SingleTouch;

public abstract class TouchAdapterImpl implements TouchAdapter {

	public void notifyChanged(SingleTouchNotification notification) {
		switch (notification.getEventType()) {
		case SingleTouchNotification.touchAdded:
			handleTouchAdded(notification.getTouch());
			break;
		case SingleTouchNotification.touchRemoved:
			handleTouchRemoved(notification.getTouch());
			break;
		case SingleTouchNotification.touchChanged:
			handleTouchChanged(notification.getTouch());
			break;
		default:
			break;
		}
	}
	
	public abstract void handleTouchAdded(SingleTouch touch);

	public abstract void handleTouchRemoved(SingleTouch touch);
	
	public abstract void handleTouchChanged(SingleTouch touch);
}
