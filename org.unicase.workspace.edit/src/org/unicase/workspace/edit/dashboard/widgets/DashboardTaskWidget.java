/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.workspace.edit.dashboard.widgets;

import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;

/**
 * A dashboard widget displaying an overview of all tasks.
 * 
 * @author Shterev
 */
public class DashboardTaskWidget extends AbstractDashboardWidget {

	/**
	 * Default constructor.
	 * 
	 * @param parent the parent
	 * @param style the style
	 */
	public DashboardTaskWidget(Composite parent, int style) {
		super(parent, style);
		setTitle("Tasks overview");
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void createContent() {
		Composite content = getContent();
		content = new Composite(this, SWT.NONE);
		GridDataFactory.fillDefaults().grab(true, true).hint(100, 200).applyTo(content);
	}

}
