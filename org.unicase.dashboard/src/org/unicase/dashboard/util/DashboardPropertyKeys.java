/**
 * <copyright> Copyright (c) 2009-2012 Chair of Applied Software Engineering, Technische Universität München (TUM).
 * All rights reserved. This program and the accompanying materials are made available under the terms of
 * the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.dashboard.util;

/**
 * Utility class that grants access to all the dashboard properties statically. These properties are the keys for the
 * corresponding EMFStoreProperties required for the Dashboard.
 * 
 * @author mharut
 */
public final class DashboardPropertyKeys {

	private DashboardPropertyKeys() {
		// all constants are accessed statically
	}

	/**
	 * Key for the subscription property.
	 */
	public static final String SUBSCRIPTIONS = "Subscriptions";

	/**
	 * Key for the dashboard-size property.
	 */
	public static final String DASHBOARD_SIZE = "Dashboard Size";

	/**
	 * Key for the task-provider property.
	 */
	public static final String TASK_PROVIDER = "Task Provider";

	/**
	 * Key for the task-change property.
	 */
	public static final String TASK_CHANGE_PROVIDER = "Task Change Provider";

	/**
	 * Key for the task-review property.
	 */
	public static final String TASK_REVIEW_PROVIDER = "Task Review Provider";

	/**
	 * Key for the task-trace property.
	 */
	public static final String TASK_TRACE_PROVIDER = "Task Trace Provider";

	/**
	 * Key for the subscription-provider property.
	 */
	public static final String SUBSCRIPTION_PROVIDER = "Subscription Provider";

	/**
	 * Key for the comments-provider property.
	 */
	public static final String COMMENTS_PROVIDER = "Comments Provider";

	/**
	 * Key for the highlight-pushed-comments property.
	 */
	public static final String HIGHLIGHT_PUSHED_COMMENTS = "Highlight Pushed Comments";

	/**
	 * Key for the show-containment-replies property.
	 */
	public static final String SHOW_CONTAINMENT_REPLIES = "Show Containment Replies";

	/**
	 * Key for the show-ai-tasks property.
	 */
	public static final String SHOW_AI_TASKS = "Show AI Tasks";

	/**
	 * Key for the show-br-tasks property.
	 */
	public static final String SHOW_BR_TASKS = "Show BR Tasks";

	/**
	 * Key for the show-issue-tasks property.
	 */
	public static final String SHOW_ISSUE_TASKS = "Show Issue Tasks";

	/**
	 * Key for the show-wp-tasks property.
	 */
	public static final String SHOW_WP_TASKS = "Show WP Tasks";

	/**
	 * Key for the show-only-ready-for-review property.
	 */
	public static final String SHOW_ONLY_READY_FOR_REVIEW = "Show Only Ready For Review";

	/**
	 * Key for the tasktrace-length property.
	 */
	public static final String TASKTRACE_LENGTH = "Tasktrace Length";

	/**
	 * Key for the tasktrace-classes property.
	 */
	public static final String TASKTRACE_CLASSES = "Tasktrace Classes";

	/**
	 * Key for the pushed-provider property.
	 */
	public static final String PUSHED_PROVIDER = "Pushed Provider";

	/**
	 * Key for the update-provider property.
	 */
	public static final String UPDATE_PROVIDER = "Update Provider";

	/**
	 * Key for the notification-composite property.
	 */
	public static final String NOTIFICATION_COMPOSITE = "Notification Composite";

}
