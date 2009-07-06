/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.workspace.edit.dashboard.widgets;

import org.eclipse.swt.widgets.Composite;

/**
 * A dashboard widget displaying the upcoming events.
 * 
 * @author Shterev
 */
public class DashboardEventWidget extends AbstractDashboardWidget {

	/**
	 * Default constructor.
	 * 
	 * @param parent the parent
	 * @param style the style
	 */
	public DashboardEventWidget(Composite parent, int style) {
		super(parent, style);
		setTitle("Upcoming events");
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void createContent() {
	}

}
