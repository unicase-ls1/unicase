/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.tom.notifications;

import org.unicase.ui.tom.touches.SingleTouch;

/**
 * @author schroech
 *
 */
public class SingleTouchNotificationImpl implements SingleTouchNotification {

	private int eventType;
	private SingleTouch touch;
	
	/**
	 * @param touch The touch object
	 * @param eventType The event type
	 */
	public SingleTouchNotificationImpl(SingleTouch touch, int eventType) {
		super();
		
		setTouch(touch);
		setEventType(eventType);
	}
	
	/*** {@inheritDoc}
	 * @see org.unicase.ui.tom.notifications.SingleTouchNotification#getEventType()
	 */
	public int getEventType() {
		return eventType;
	}

	/**
	 * @param eventType The event type
	 */
	public void setEventType(int eventType) {
		this.eventType = eventType;
	}

	/**
	 * @param touch The touch object
	 */
	public void setTouch(SingleTouch touch) {
		this.touch = touch;
	}

	/*** {@inheritDoc}
	 * @see org.unicase.ui.tom.notifications.SingleTouchNotification#getTouch()
	 */
	public SingleTouch getTouch() {
		return touch;
	}

}
