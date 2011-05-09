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
public interface SingleTouchNotification {
	
	/**
	 * Flag indicating the touch added event.
	 */
	int TOUCH_ADDED = 0;
	
	/**
	 * Flag indicating the touch removed event.
	 */
	int TOUCH_REMOVED = 1;
	
	/**
	 * Flag indicating the touch changed event.
	 */
	int TOUCH_CHANGED = 2;
	
	/**
	 * Flag indicating the touch propagated event.
	 */
	int TOUCH_PROPAGATED = 3;
	
	/**
	 * @return The event type
	 */
	int getEventType();
	
	/**
	 * @return The affected touch
	 */
	SingleTouch getTouch();
}
