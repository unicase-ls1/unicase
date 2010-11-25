/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.workspace.ui.views.emfstorebrowser.dialogs.admin.acimport;

import java.util.Properties;

import javax.naming.Context;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.jface.dialogs.ProgressMonitorDialog;
import org.eclipse.jface.dialogs.TitleAreaDialog;
import org.eclipse.jface.layout.GridLayoutFactory;
import org.eclipse.jface.layout.LayoutConstants;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.PlatformUI;
import org.unicase.util.DialogHandler;
import org.unicase.workspace.ui.Activator;

/**
 * @author deser
 */
public class LdapSourceDialog extends TitleAreaDialog {

	private boolean isOkPressed;
	private Text serverName;
	private Text ldapBase;
	private final LdapImportSource ldapImport;
	private boolean isInitFinished;

	/**
	 * @param parentShell
	 *            the parent shell
	 * @param ldapImport
	 *            LDAP import
	 */
	public LdapSourceDialog(Shell parentShell, LdapImportSource ldapImport) {
		super(parentShell);
		this.ldapImport = ldapImport;
		this.setTitle("LDAP import");
		this.isInitFinished = false;
	}

	/**
	 * @param parent
	 *            parent composite
	 * @return Control
	 * @see org.eclipse.jface.dialogs.TitleAreaDialog#createDialogArea(org.eclipse.swt.widgets.Composite)
	 */
	@Override
	protected Control createDialogArea(Composite parent) {
		// Set the specific help for this Composite
		PlatformUI.getWorkbench().getHelpSystem().setHelp(parent,
				Activator.PLUGIN_ID + ".help_import_ldap");

		Composite contents = new Composite(parent, SWT.NONE);
		contents.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));

		setTitle("LDAP server data");
		setMessage("Enter data of server to connect to");

		Label name = new Label(contents, SWT.NULL);
		name.setText("Server name:");
		serverName = new Text(contents, SWT.SINGLE | SWT.BORDER);
		serverName.setSize(350, 20);

		Label desc = new Label(contents, SWT.NULL);
		desc.setText("Server base:");
		ldapBase = new Text(contents, SWT.SINGLE | SWT.BORDER);
		ldapBase.setSize(350, 20);

		Point defaultMargins = LayoutConstants.getMargins();
		GridLayoutFactory.fillDefaults().numColumns(2).margins(
				defaultMargins.x, defaultMargins.y).generateLayout(contents);

		return contents;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void okPressed() {
		ProgressMonitorDialog progressMonitorDialog = new ProgressMonitorDialog(
				getShell());
		progressMonitorDialog.open();
		progressMonitorDialog.getProgressMonitor().beginTask("connecting",
				IProgressMonitor.UNKNOWN);

		Properties serverProperties = new Properties();

		serverProperties.put(Context.PROVIDER_URL, serverName.getText());
		serverProperties.put(LdapImportSource.LDAP_BASE, ldapBase.getText());

		this.ldapImport.setProperties(serverProperties);
		try {
			this.ldapImport.connect();
			this.isInitFinished = true;
			progressMonitorDialog.close();
		} catch (CorruptedSourceException e) {
			progressMonitorDialog.close();
			this.isInitFinished = false;
			DialogHandler.showExceptionDialog("An exception occured", e);
		}

		this.isOkPressed = true;
		close();
	}

	/**
	 * @see org.eclipse.jface.dialogs.Dialog#cancelPressed()
	 */
	@Override
	protected void cancelPressed() {
		this.isOkPressed = false;
		close();
	}

	/**
	 * @return whether the initialization is completed (OK was pressed and a
	 *         connection to the given server has been established).
	 */
	public boolean getIsInitFinished() {
		return this.isOkPressed && this.isInitFinished;
	}

}
