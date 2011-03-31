/*******************************************************************************
 * Copyright (c) 2008-2011 Chair for Applied Software Engineering, Technische Universitaet Muenchen.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 ******************************************************************************/
package org.eclipse.emf.emfstore.client.ui.views.emfstorebrowser.dialogs.admin;

import org.eclipse.emf.emfstore.client.model.AdminBroker;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Shell;

/**
 * This is a dialog to manage users and groups (OrgUnits) and their access
 * rights for different projects.
 * 
 * @author Hodaie
 */
public class ManageOrgUnitsDialog extends Dialog {

	private AdminBroker adminBroker;

	/**
	 * Constructor.
	 * 
	 * @param parentShell
	 *            Shell
	 * @param adminBroker
	 *            AdminBroker class responsible for interaction with server
	 *            side.
	 */
	public ManageOrgUnitsDialog(Shell parentShell, AdminBroker adminBroker) {

		super(parentShell);

		this.setShellStyle(this.getShellStyle() | SWT.RESIZE);
		this.adminBroker = adminBroker;

	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public int open() {
		this.getButton(OK).setVisible(false);
		this.getButton(CANCEL).setText("Close");
		return super.open();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected Control createDialogArea(Composite parent) {
		Composite composite = (Composite) super.createDialogArea(parent);
		new OrgUnitManagementGUI(composite, adminBroker);
		return composite;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void cancelPressed() {

		super.cancelPressed();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void okPressed() {

		super.okPressed();
	}

}
