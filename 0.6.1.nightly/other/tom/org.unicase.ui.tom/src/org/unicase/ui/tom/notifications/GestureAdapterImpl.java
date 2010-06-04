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
public abstract class GestureAdapterImpl {

	/**
	 * @param notification The {@link GestureNotification} indicating an gesture state change
	 */
	public void notifyChanged(GestureNotification notification) {
		switch (notification.getEventType()) {
		case GestureNotification.GESTURE_EXECUTION_CHANGE:
			handleExecutionChanged(notification.getGesture());
			break;
		case GestureNotification.GESTURE_ACCEPTANCE_CHANGE:
			handleAcceptanceChanged(notification.getGesture());
			break;
		default:
			break;
		}
	}
	
	/**
	 * @param gesture The {@link GestureNotification} indicating an gesture execution state change
	 */
	public abstract void handleExecutionChanged(Gesture gesture);

	/**
	 * @param gesture The {@link GestureNotification} indicating an gesture acceptance state change
	 */
	public abstract void handleAcceptanceChanged(Gesture gesture);
	
}
