package org.unicase.ui.tom.notifications;

import org.unicase.ui.tom.touches.SingleTouch;

public class SingleTouchNotificationImpl implements SingleTouchNotification {

	private int eventType;
	private SingleTouch touch;
	
	public SingleTouchNotificationImpl(SingleTouch touch, int eventType) {
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

	public void setTouch(SingleTouch touch) {
		this.touch = touch;
	}

	public SingleTouch getTouch() {
		return touch;
	}

}
