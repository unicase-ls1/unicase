/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.workspace.ui.views.emfstorebrowser.dialogs.admin;

import org.eclipse.draw2d.GridData;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.TabFolder;
import org.unicase.workspace.AdminBroker;

/**
 * @author gurcankarakoc
 */
public class ProjectTabContent extends TabContent {

	/**
	 * @param string
	 *            the name of tab.
	 * @param adminBroker
	 *            AdminBroker is needed to communicate with server.
	 * @param frm
	 *            used to set input to properties form and update its table
	 *            viewer upon. deletion of OrgUnits.
	 */
	public ProjectTabContent(String string, AdminBroker adminBroker,
			PropertiesForm frm) {
		super(string, adminBroker, frm);
		this.setTab(this);
	}

	/**
	 * @see org.unicase.ui.esbrowser.dialogs.admin.TabContent#createButtons(org.eclipse.swt.widgets.Composite)
	 * @param tabContents
	 *            doesn't need in this tab.
	 */
	@Override
	public void createButtons(Composite tabContents) {
		// TODO Auto-generated method stub

	}

	/**
	 * @see org.unicase.ui.esbrowser.dialogs.admin.TabContent#createContents(org.eclipse.swt.widgets.TabFolder)
	 * @param tabFolder
	 *            TabFolder.
	 * @return Composite.
	 */
	@Override
	protected Composite createContents(TabFolder tabFolder) {
		Composite tabContent = new Composite(tabFolder, SWT.NONE);
		tabContent.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
		tabContent.setLayout(new GridLayout(2, false));

		initList(tabContent);

		return tabContent;
	}

	/**
	 * @see org.unicase.ui.esbrowser.dialogs.admin.TabContent#newOrgUnit()
	 */
	@Override
	protected void newOrgUnit() {
		// TODO Auto-generated method stub

	}

	/**
	 * @see org.unicase.ui.esbrowser.dialogs.admin.TabContent#deleteOrgUnit()
	 */
	@Override
	protected void deleteOrgUnit() {
		// TODO Auto-generated method stub

	}

}
