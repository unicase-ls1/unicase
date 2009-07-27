/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.pmdashboard.burndown.views;

import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.part.ViewPart;
import org.unicase.model.task.WorkPackage;

/**
 * View for demonstration of the burndown chart, which will be integrated into a dashboard later.
 * @author andy
 *
 */
public class BurndownView extends ViewPart {
	/**
	 * ID for this view, so that commands can find it .
	 */
	public static final String ID = "org.unicase.managementDashboard.views.BurndownView";
	
	private Composite burndownChart;
	private Composite parent;
	
	/**
	 * 
	 * {@inheritDoc}
	 * @see org.eclipse.ui.part.WorkbenchPart#createPartControl(org.eclipse.swt.widgets.Composite)
	 */
	@Override
	public void createPartControl(Composite parent) {
		this.parent = parent;
	}
	
	/**
	 * Interface for the command to set the input.
	 * @param sprint the chart should be generated for
	 */
	public void setInput(WorkPackage sprint) {
		 new BurndownChartComposite(sprint, this.parent);
	}

	/**
	 * 
	 * {@inheritDoc}
	 * @see org.eclipse.ui.part.WorkbenchPart#setFocus()
	 */
	@Override
	public void setFocus() {
		this.burndownChart.setFocus();
	}

}
