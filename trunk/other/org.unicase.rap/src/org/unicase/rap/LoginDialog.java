/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.rap;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.IDialogConstants;

/**
 * Login dialog for configuration settings view. They are only for admins. 
 * 
 * @author Edgar Müller, Fatih Ulusoy
 */
public class LoginDialog extends Dialog {

	private static final int LOGIN_ID = IDialogConstants.CLIENT_ID + 1;

	private Text userText;
	private Text passText;
	private Label mesgLabel;
	private String title;
	private String username;
	private String password;

	/**
	 * Constructor.
	 * 
	 * @param parent Parent.
	 * @param title Title of login dialog window.
	 */
	public LoginDialog(final Shell parent, final String title) {
		super(parent);
		this.title = title;
	}

	/**
	 * {@inheritDoc}
	 */
	protected void createButtonsForButtonBar(final Composite parent) {
		createButton(parent, IDialogConstants.CANCEL_ID, "Cancel", false);
		createButton(parent, LOGIN_ID, "Login", true);
	}

	/**
	 * {@inheritDoc}
	 */
	protected Control createDialogArea(final Composite parent) {
		// create composite
		Composite composite = (Composite) super.createDialogArea(parent);
		GridLayout gridLayout = new GridLayout();
		gridLayout.numColumns = 2;
		composite.setLayout(gridLayout);

		// message label
		mesgLabel = new Label(composite, SWT.NONE);
		GridData data = new GridData();
		data.horizontalAlignment = GridData.CENTER;
		data.verticalAlignment = GridData.CENTER;
		data.horizontalSpan = 2;
		mesgLabel.setLayoutData(data);
		mesgLabel.setText("Please sign in with your username and password:");

		// user label and input field
		Label userLabel = new Label(composite, SWT.NONE);
		userLabel.setText("Username:");
		data = new GridData();
		data.verticalAlignment = GridData.CENTER;
		userLabel.setLayoutData(data);
		userText = new Text(composite, SWT.BORDER);
		data = new GridData(GridData.FILL_HORIZONTAL);
		userText.setLayoutData(data);
		if (username != null) {
			userText.setText(username);
		}
		userText.setFocus();

		// password label and input field
		Label passLabel = new Label(composite, SWT.NONE);
		passLabel.setText("Password:");
		data = new GridData();
		data.verticalAlignment = GridData.CENTER;
		passText = new Text(composite, SWT.BORDER | SWT.PASSWORD);
		passLabel.setLayoutData(data);
		data = new GridData(GridData.FILL_HORIZONTAL);
		passText.setLayoutData(data);
		
		return composite;
	}

	/**
	 * {@inheritDoc}
	 */
	protected void configureShell(final Shell shell) {
		super.configureShell(shell);
		if (title != null) {
			shell.setText(title);
		}
	}

	/**
	 * {@inheritDoc}
	 */
	protected void buttonPressed(final int buttonId) {
		if (buttonId == LOGIN_ID) {
			username = userText.getText();
			password = passText.getText();
			setReturnCode(OK);
			close();
		} else {
			password = null;
		}
		super.buttonPressed(buttonId);
	}
	
	/**
	 * 
	 * @return username
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * 
	 * @return password 
	 */
	public String getPassword() {
		return password;
	}
	
}


