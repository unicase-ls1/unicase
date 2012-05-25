/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */

package org.unicase.workspace.changeTracking.notification.filter;

import org.unicase.workspace.changeTracking.notification.NotificationInfo;

/**
 * Filters touch notifications, as these have no effect on the model state.
 * 
 * @author chodnick
 */
public class TouchFilter implements NotificationFilter {

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.unicase.workspace.changeTracking.notification.filter.NotificationFilter#check(org.unicase.workspace.changeTracking.notification.NotificationInfo)
	 */
	public boolean check(NotificationInfo notificationInfo) {

		return notificationInfo.isTouch();
	}

}
