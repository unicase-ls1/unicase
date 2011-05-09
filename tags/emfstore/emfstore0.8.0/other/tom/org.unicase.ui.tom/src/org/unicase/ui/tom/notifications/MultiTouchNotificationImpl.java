/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.tom.notifications;

import org.unicase.ui.tom.touches.MultiTouch;

/**
 * @author schroech
 *
 */
public class MultiTouchNotificationImpl implements MultiTouchNotification {

	private int eventType;
	private MultiTouch touch;
	
	/**
	 * @param touch The touch object
	 * @param eventType The event type
	 */
	public MultiTouchNotificationImpl(MultiTouch touch, int eventType) {
		super();
		
		setTouch(touch);
		setEventType(eventType);
	}
	
	/*** {@inheritDoc}
	 * @see org.unicase.ui.tom.notifications.MultiTouchNotification#getEventType()
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
	public void setTouch(MultiTouch touch) {
		this.touch = touch;
	}

	/*** {@inheritDoc}
	 * @see org.unicase.ui.tom.notifications.MultiTouchNotification#getTouch()
	 */
	public MultiTouch getTouch() {
		return touch;
	}

}
