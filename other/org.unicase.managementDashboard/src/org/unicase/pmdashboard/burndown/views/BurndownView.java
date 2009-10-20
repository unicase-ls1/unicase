/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.pmdashboard.burndown.views;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.part.ViewPart;
import org.unicase.model.ModelElement;

/**
 * View for demonstration of the burndown chart, which will be integrated into a dashboard later.
 * @author andy
 *
 */
public class BurndownView extends ViewPart {
	public static final String ID = "org.unicase.managementDashboard.views.BurndownView";
	private BurndownChartControl burndownChartControl;
	private Composite parent;

	@Override
	public void createPartControl(Composite parent) {
		this.parent = parent;
		burndownChartControl = new BurndownChartControl();		
	}

	@Override
	public void setFocus() {
	
	}
	public void setInput(ModelElement newInput) {
		burndownChartControl.createControl(parent, SWT.FILL, newInput);		

	}


}
