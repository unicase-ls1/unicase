package org.unicase.rap.view;

import org.eclipse.jface.dialogs.TitleAreaDialog;
import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.*;
import org.unicase.rap.login.UserCredential;


public class LoginDialog extends TitleAreaDialog {

	private Text serverText;
	private Text userNameText;
	private Text passwordText;
	private UserCredential userCredential;

	public LoginDialog(Shell parentShell) {
		super(parentShell);
	}

	protected Control createContents(Composite parent) {
		return super.createContents(parent);
	}

	protected Control createDialogArea(Composite parent) {
		setTitle("Enter your identity info!");
		// setMessage("Enter all fields ");

		Composite composite = new Composite(parent, SWT.None);
		composite.setLayout(new GridLayout(2, false));

		// create the ui components
		Label serverLabel = new Label(composite, SWT.None);
		serverLabel.setText("Server:");
		serverText = new Text(composite, SWT.SINGLE | SWT.BORDER);
		GridDataFactory.swtDefaults().hint(150, SWT.DEFAULT).applyTo(serverText);

		Label userNameLabel = new Label(composite, SWT.None);
		userNameLabel.setText("UserName:");
		userNameText = new Text(composite, SWT.SINGLE | SWT.BORDER);
		GridDataFactory.swtDefaults().hint(150, SWT.DEFAULT).applyTo(userNameText);

		Label passwordLabel = new Label(composite, SWT.None);
		passwordLabel.setText("Password:");
		passwordText = new Text(composite, SWT.SINGLE | SWT.BORDER);
		// passwordText.setEchoChar('*');
		GridDataFactory.swtDefaults().hint(150, SWT.DEFAULT).applyTo(passwordText);

		return composite;
	}

	protected void okPressed() {
		userCredential = new UserCredential(serverText.getText().trim(), userNameText.getText().trim(), passwordText.getText());
		super.okPressed();
	}

	public UserCredential getUserCredential() {
		return userCredential;
	}

}
