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
public interface MultiTouchNotification {

	/**
	 * Flag indicating the touch claimed state. 
	 */
	int TOUCH_CLAIMED = 0;
	
	/**
	 * @return The event type
	 */
	int getEventType();
	
	/**
	 * @return The touch
	 */
	MultiTouch getTouch();
	
}
