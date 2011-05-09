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
public abstract class SingleTouchAdapterImpl implements SingleTouchAdapter {

	/*** {@inheritDoc}
	 * @see org.unicase.ui.tom.notifications.SingleTouchAdapter#notifyChanged(org.unicase.ui.tom.notifications.SingleTouchNotification)
	 */
	public void notifyChanged(SingleTouchNotification notification) {
		switch (notification.getEventType()) {
		case SingleTouchNotification.TOUCH_ADDED:
			handleTouchAdded(notification.getTouch());
			break;
		case SingleTouchNotification.TOUCH_REMOVED:
			handleTouchRemoved(notification.getTouch());
			break;
		case SingleTouchNotification.TOUCH_CHANGED:
			handleTouchChanged(notification.getTouch());
			break;
		default:
			break;
		}
	}
	
	/**
	 * @param touch The affected touch
	 */
	public abstract void handleTouchAdded(SingleTouch touch);

	/**
	 * @param touch The affected touch
	 */
	public abstract void handleTouchRemoved(SingleTouch touch);
	
	/**
	 * @param touch The affected touch
	 */
	public abstract void handleTouchChanged(SingleTouch touch);
}
