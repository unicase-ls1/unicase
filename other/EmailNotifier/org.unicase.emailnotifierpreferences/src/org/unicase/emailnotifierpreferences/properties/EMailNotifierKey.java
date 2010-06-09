/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.emailnotifierpreferences.properties;


import org.unicase.workspace.preferences.PropertyKey;

public enum EMailNotifierKey implements PropertyKey {

	/**
	 * The list of notification groups created by the user.
	 */
	NOTIFICATIONGROUPS,
	
	/**
	 * Whether the EMail Notification is turned on or not.
	 */
	ACTIVATED,

	/**
	 * the task provider.
	 */
	TASK_PROVIDER,

	/**
	 * the task change provider.
	 */
	TASK_CHANGE_PROVIDER,

	/**
	 * the task trace provider.
	 */
	TASK_TRACE_PROVIDER,

	/**
	 * the task review provider.
	 */
	TASK_REVIEW_PROVIDER,

	/**
	 * the subscription provider.
	 */
	SUBSCRIPTION_PROVIDER,

	/**
	 * the comments provider.
	 */
	COMMENTS_PROVIDER,


}