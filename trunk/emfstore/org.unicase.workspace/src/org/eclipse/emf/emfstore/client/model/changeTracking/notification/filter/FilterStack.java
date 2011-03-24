/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */

package org.eclipse.emf.emfstore.client.model.changeTracking.notification.filter;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.emf.emfstore.client.model.changeTracking.notification.NotificationInfo;

/**
 * This class filters a notification recording according to predefined stacks of filters. Available stacks are created
 * as static properties for easy reference.
 * 
 * @author chodnick
 */
public final class FilterStack implements NotificationFilter {

	private static final NotificationFilter[] DEFAULT_STACK = {
		//
		new TouchFilter(),
		//
		new TransientFilter(),
		//
		new EmptyRemovalsFilter(),
		//
		new IgnoreDatatypeFilter(), // ,

		new IgnoreOutsideProjectReferencesFilter() };

	/**
	 * The default filter stack.
	 */
	public static final NotificationFilter DEFAULT = new FilterStack(DEFAULT_STACK);

	private List<NotificationFilter> filterList;

	private FilterStack(NotificationFilter[] filters) {
		filterList = new LinkedList<NotificationFilter>();
		Collections.addAll(filterList, filters);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.emfstore.client.model.changeTracking.notification.filter.NotificationFilter#check(org.eclipse.emf.emfstore.client.model.changeTracking.notification.NotificationInfo)
	 */
	public boolean check(NotificationInfo notificationInfo) {
		for (NotificationFilter f : filterList) {
			if (f.check(notificationInfo)) {
				return true;
			}
		}
		return false;
	}

}
