/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.tom.notifications;

import org.unicase.ui.tom.gestures.Gesture;

/**
 * @author schroech
 *
 */
public class GestureNotificationImpl implements GestureNotification{

	private int eventType;

	private Gesture gesture;

	/**
	 * @param gesture The triggering gesture
	 * @param eventType The event type
	 */
	public GestureNotificationImpl(Gesture gesture, int eventType) {
		super();
		
		setGesture(gesture);
		setEventType(eventType);
	}

	/**
	 * @param eventType The event type
	 */
	public void setEventType(int eventType) {
		this.eventType = eventType;
	}

	/*** {@inheritDoc}
	 * @see org.unicase.ui.tom.notifications.GestureNotification#getEventType()
	 */
	public int getEventType() {
		return eventType;
	}

	/**
	 * @param gesture The triggering gesture
	 */
	public void setGesture(Gesture gesture) {
		this.gesture = gesture;
	}

	/*** {@inheritDoc}
	 * @see org.unicase.ui.tom.notifications.GestureNotification#getGesture()
	 */
	public Gesture getGesture() {
		return gesture;
	}


}
