/*******************************************************************************
 * Copyright (c) 2008-2011 Chair for Applied Software Engineering,
 * Technische Universitaet Muenchen.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 ******************************************************************************/
package org.eclipse.emf.emfstore.client.changeTracking.notification.filter;

import org.eclipse.emf.emfstore.client.changeTracking.notification.NotificationInfo;

/**
 * Filters touch notifications, as these have no effect on the model state.
 * 
 * @author chodnick
 */
public class TouchFilter implements NotificationFilter {

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.emfstore.client.changetracking.notification.filter.NotificationFilter#check(org.eclipse.emf.emfstore.client.changetracking.notification.NotificationInfo)
	 */
	public boolean check(NotificationInfo notificationInfo) {

		return notificationInfo.isTouch();
	}

}
