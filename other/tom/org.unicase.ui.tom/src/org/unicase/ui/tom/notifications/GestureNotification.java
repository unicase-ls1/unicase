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
public interface GestureNotification {

	/**
	 * Flag for indicating an execution change.  
	 */
	int GESTURE_EXECUTION_CHANGE = 0;
	
	
	/**
	 * Flag for indicating an acceptance change.
	 */
	int GESTURE_ACCEPTANCE_CHANGE = 1;
	
	/**
	 * @return The event type
	 */
	int getEventType();
	
	/**
	 * @return The triggering gesture
	 */
	Gesture getGesture();
}
