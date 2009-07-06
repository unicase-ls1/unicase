/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.workspace.edit.dashboard.widgets;

import org.unicase.workspace.edit.dashboard.DashboardPage;

/**
 * A dashboard widget displaying an overview of related tasks.
 * 
 * @author Shterev
 */
public class DashboardRelatedTasksWidget extends AbstractDashboardWidget {

	private static final String WIDGET_ID = "DashboardRelatedTaskWidget";

	/**
	 * Default constructor.
	 * 
	 * @param dashboard the dashboard
	 */
	public DashboardRelatedTasksWidget(DashboardPage dashboard) {
		super(dashboard);
		setTitle("Tasks that might be related to you");
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void createContentPanel() {
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected String getId() {
		return WIDGET_ID;
	}

}
