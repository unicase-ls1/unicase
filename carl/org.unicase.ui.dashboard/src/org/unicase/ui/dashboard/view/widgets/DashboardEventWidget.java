/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.dashboard.view.widgets;


/**
 * A dashboard widget displaying the upcoming events.
 * 
 * @author Shterev
 */
public class DashboardEventWidget extends AbstractDashboardWidget {

	private static final String WIDGET_ID = "DashboardRefactoringWidget";

	/**
	 * Default constructor.
	 */
	public DashboardEventWidget() {
		super();
		setTitle("Please refactor");
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void createContentPanel() {
		super.createContentPanel();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected String getId() {
		return WIDGET_ID;
	}
}
