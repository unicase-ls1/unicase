package org.unicase.ui.tom.notifications;

import org.unicase.ui.tom.touches.MultiTouch;

public class MultiTouchNotificationImpl implements MultiTouchNotification {

	private int eventType;
	private MultiTouch touch;
	
	public MultiTouchNotificationImpl(MultiTouch touch, int eventType) {
		super();
		
		setTouch(touch);
		setEventType(eventType);
	}
	
	public int getEventType() {
		return eventType;
	}

	public void setEventType(int eventType) {
		this.eventType = eventType;
	}

	public void setTouch(MultiTouch touch) {
		this.touch = touch;
	}

	public MultiTouch getTouch() {
		return touch;
	}

}
