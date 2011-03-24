/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */

package org.eclipse.emf.emfstore.client.model.changeTracking.notification.filter;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.emfstore.client.model.changeTracking.notification.NotificationInfo;
import org.unicase.metamodel.util.ModelUtil;

/**
 * Filters notifications which come from datatypes that should be ignored.
 * 
 * @author emueller
 */
public class IgnoreDatatypeFilter implements NotificationFilter {

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.emfstore.client.model.changeTracking.notification.filter.NotificationFilter#check(org.eclipse.emf.emfstore.client.model.changeTracking.notification.NotificationInfo)
	 */
	public boolean check(NotificationInfo notificationInfo) {

		Object newValue = notificationInfo.getNewValue();
		Object oldValue = notificationInfo.getOldValue();
		Object notifier = notificationInfo.getNotifier();
		boolean ignore = false;

		if (newValue != null && newValue instanceof EObject) {
			ignore = ModelUtil.isIgnoredDatatype((EObject) newValue);
		}

		if (oldValue != null && oldValue instanceof EObject) {
			ignore = ignore || ModelUtil.isIgnoredDatatype((EObject) oldValue);
		}

		if (notifier != null && notifier instanceof EObject) {
			ignore = ignore || ModelUtil.isIgnoredDatatype((EObject) notifier);
		}

		return ignore;
	}
}
