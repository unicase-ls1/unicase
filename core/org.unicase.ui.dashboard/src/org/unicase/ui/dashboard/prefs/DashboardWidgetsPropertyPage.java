/**
 * <copyright> Copyright (c) 2009-2012 Chair of Applied Software Engineering, Technische Universität München (TUM).
* All rights reserved. This program and the accompanying materials are made available under the terms of
* the Eclipse Public License v1.0 which accompanies this distribution,
* and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.dashboard.prefs;

import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.dialogs.PropertyPage;
import org.unicase.ui.dashboard.Activator;

/**
 * A property page for the dashboard widgets.
 * 
 * @author Shterev
 */
public class DashboardWidgetsPropertyPage extends PropertyPage {

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected Control createContents(Composite parent) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * {@inheritDoc}
	 */
	public void init(IWorkbench workbench) {
		// Initialize the preference store we wish to use
		setPreferenceStore(Activator.getDefault().getPreferenceStore());
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void performDefaults() {
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean performOk() {
		return super.performOk();
	}

}
