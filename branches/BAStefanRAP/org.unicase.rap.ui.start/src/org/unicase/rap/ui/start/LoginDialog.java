/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.rap.ui.start;

import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.unicase.rap.sessionmanagement.UserSessionInfo;

/**
 * @author stefan
 */
public class LoginDialog extends Dialog {
	private String username;
	private String password;

	private Label usernameLabel;
	private Text usernameText;
	private Label passwordLabel;
	private Text passwordText;

	/**
	 * @param parentShell parentShell
	 */
	protected LoginDialog(Shell parentShell) {
		super(parentShell);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.jface.window.Window#configureShell(org.eclipse.swt.widgets.Shell)
	 */
	@Override
	protected void configureShell(Shell newShell) {
		super.configureShell(newShell);
		newShell.setText("Login Dialog");
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.jface.dialogs.Dialog#createDialogArea(org.eclipse.swt.widgets.Composite)
	 */
	@Override
	protected Control createDialogArea(Composite parent) {
		Composite composite = (Composite) super.createDialogArea(parent);

		composite.setLayout(new GridLayout(2, true));

		usernameLabel = new Label(composite, SWT.FLAT);
		GridData ugdl = new GridData();
		ugdl.grabExcessHorizontalSpace = true;
		usernameLabel.setLayoutData(ugdl);
		usernameLabel.setText("Username:");

		usernameText = new Text(composite, SWT.FLAT | SWT.BORDER);
		GridData ugdt = new GridData();
		ugdt.grabExcessHorizontalSpace = true;
		usernameText.setLayoutData(ugdt);

		passwordLabel = new Label(composite, SWT.FLAT);
		GridData pgdl = new GridData();
		pgdl.grabExcessHorizontalSpace = true;
		passwordLabel.setLayoutData(pgdl);
		passwordLabel.setText("Password:");

		passwordText = new Text(composite, SWT.FLAT | SWT.BORDER | SWT.PASSWORD);
		GridData pgdt = new GridData();
		pgdt.grabExcessHorizontalSpace = true;
		passwordText.setLayoutData(pgdt);

		return composite;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.jface.dialogs.Dialog#okPressed()
	 */
	@Override
	protected void okPressed() {
		username = usernameText.getText();
		UserSessionInfo.getInstance().setUsername(username);
		password = passwordText.getText();
		super.okPressed();
	}

	/**
	 * @return username
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * @return password
	 */
	public String getPassword() {
		return password;
	}

}
