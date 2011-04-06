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
package org.eclipse.emf.emfstore.client.model.preferences;

/**
 * The keys for the dashboard preferences.
 * 
 * @author Shterev
 */
public enum DashboardKey implements PropertyKey {

	/**
	 * The max. number of notifications to be shown on the dashboard.
	 */
	DASHBOARD_SIZE,

	/**
	 * The list of subscribed model elements.
	 */
	SUBSCRIPTIONS,

	/**
	 * The maximum trace length.
	 */
	TASKTRACE_LENGTH,

	/**
	 * The classes for the trace provider.
	 */
	TASKTRACE_CLASSES,

	/**
	 * If new BugReports should be shown.
	 */
	SHOW_BR_TASKS,

	/**
	 * If new ActionItems should be shown.
	 */
	SHOW_AI_TASKS,

	/**
	 * If new Issues should be shown.
	 */
	SHOW_ISSUE_TASKS,

	/**
	 * If new WorkPackages should be shown.
	 */
	SHOW_WP_TASKS,

	/**
	 * If review tasks should be hidden if not ready for review yet.
	 */
	SHOW_ONLY_READYFORREVIEW,

	/**
	 * If nested indirect replies should be shown.
	 */
	SHOW_CONTAINMENT_REPLIES,

	/**
	 * If pushed commit comments should be highlighted.
	 */
	HIGHLIGHT_PUSHED_COMMENTS,

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

	/**
	 * the pushed notifications provider.
	 */
	PUSHED_PROVIDER,

	/**
	 * the update notifications provider.
	 */
	UPDATE_PROVIDER,
}
