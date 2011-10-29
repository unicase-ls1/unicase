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
package org.eclipse.emf.emfstore.client.model.changeTracking.notification.filter;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.emfstore.client.model.changeTracking.notification.NotificationInfo;
import org.eclipse.emf.emfstore.client.model.util.WorkspaceUtil;

/**
 * This class filters a notification recording according to predefined stacks of
 * filters. Available stacks are created as static properties for easy
 * reference.
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

		new IgnoreOutsideProjectReferencesFilter(),

		new IgnoreNullFeatureNotificationsFilter() };

	/**
	 * The default filter stack.
	 */
	public static final NotificationFilter DEFAULT = new FilterStack(DEFAULT_STACK);

	private List<NotificationFilter> filterList;

	public FilterStack(NotificationFilter[] filters) {
		filterList = new LinkedList<NotificationFilter>();
		Collections.addAll(filterList, filters);
		collectExtensionPoints();
	}

	private void collectExtensionPoints() {
		IConfigurationElement[] configElems = Platform.getExtensionRegistry().getConfigurationElementsFor(
			"org.eclipse.emf.emfstore.client.notificationFilter");
		for (IConfigurationElement elem : configElems) {
			try {
				NotificationFilter filter = (NotificationFilter) elem.createExecutableExtension("class");
				filterList.add(filter);
			} catch (CoreException e) {
				WorkspaceUtil.logException(e.getMessage(), e);
			}
		}
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
