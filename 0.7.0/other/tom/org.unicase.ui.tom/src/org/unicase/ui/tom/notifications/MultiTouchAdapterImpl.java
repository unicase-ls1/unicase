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
public abstract class MultiTouchAdapterImpl implements MultiTouchAdapter {
	
	/*** {@inheritDoc}
	 * @see org.unicase.ui.tom.notifications.MultiTouchAdapter#notifyChanged(org.unicase.ui.tom.notifications.MultiTouchNotification)
	 */
	public void notifyChanged(MultiTouchNotification notification) {
		switch (notification.getEventType()) {
		case MultiTouchNotification.TOUCH_CLAIMED:
			handleTouchClaimed(notification.getTouch());
			break;
		default:
			break;
		}
	}
	
	/**
	 * @param touch The claimed touch
	 */
	public abstract void handleTouchClaimed(MultiTouch touch);
}
