/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this distribution, and is available at http://www.eclipse.org/legal/epl-v10.html
 * </copyright>
 *
 * $Id$
 */
package org.unicase.workspace.edit.dialogs;

import org.eclipse.emf.common.util.EList;
import org.eclipse.jface.dialogs.TitleAreaDialog;
import org.eclipse.jface.layout.GridLayoutFactory;
import org.eclipse.jface.layout.LayoutConstants;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.unicase.emfstore.accesscontrol.AccessControlException;
import org.unicase.emfstore.exceptions.EmfStoreException;
import org.unicase.ui.common.exceptions.ExceptionDialogHandler;
import org.unicase.workspace.Usersession;
import org.unicase.workspace.WorkspaceManager;

/**
 * Class for the login dialog.
 * 
 * @author shterev
 */
public class LoginDialog extends TitleAreaDialog implements SelectionListener {

	/**
	 * indicates that the login has been successful.
	 */
	public static final int SUCCESSFUL = 1;
	/**
	 * indicates that the login has failed.
	 */
	public static final int FAILED = 2;
	/**
	 * indicates that the login has been canceled.
	 */
	public static final int CANCELED = 3; 
	private Text username;
	private Text password;
	private Usersession session;
	private Combo savedSessionsCombo;
	private EList<Usersession> savedSessionsList;
	private Button savePassword;
	private boolean newSession;
	private int status;

	/**
	 * Default constructor.
	 * 
	 * @param parentShell
	 *            the parent shell
	 * @param session
	 *            the target usersession
	 */
	public LoginDialog(Shell parentShell, Usersession session) {
		super(parentShell);
		this.session = session;
	}

	/**
	 * Second constructor with parameter for new sessions.
	 * 
	 * @param parentShell
	 *            the parent shell
	 * @param session
	 *            the target usersession
	 * @param newSession
	 *            if the gui for new sessions should be displayed
	 */
	public LoginDialog(Shell parentShell, Usersession session, boolean newSession) {
		this(parentShell, session);
		this.newSession = newSession;
	}

	/**
	 * {@inheritDoc}
	 */
	protected Control createDialogArea(Composite parent) {
		Composite contents = new Composite(parent, SWT.NONE);
		contents.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));

		setTitle("Log in");
		setMessage("Please enter your username and password");

		// initialize the combo for the saved sessions
		Label savedSessionsLabel = new Label(contents, SWT.NULL);
		savedSessionsLabel.setText("Saved sessions:");
		savedSessionsCombo = new Combo(contents, SWT.READ_ONLY);
		savedSessionsCombo.add("<new session>");
		savedSessionsList = WorkspaceManager.getInstance().getCurrentWorkspace().getUsersessions();
		for (int i = 0; i < savedSessionsList.size(); i++) {
			savedSessionsCombo.add(savedSessionsList.get(i).getUsername());
		}
		savedSessionsCombo.addSelectionListener(this);

		// initialize the other widgets
		Label user = new Label(contents, SWT.NULL);
		user.setText("Username:");
		username = new Text(contents, SWT.SINGLE | SWT.BORDER);
		username.setSize(150, 20);

		Label pass = new Label(contents, SWT.NULL);
		pass.setText("Password:");
		password = new Text(contents, SWT.PASSWORD | SWT.BORDER);
		password.setSize(150, 20);

		Label savePasswordLabel = new Label(contents, SWT.NULL);
		savePasswordLabel.setText("Save password");
		savePassword = new Button(contents, SWT.CHECK);

		if (newSession) {
			// select entry for a new session
			savedSessionsCombo.select(0);
			username.setEnabled(true);
			password.setEnabled(true);
			savePassword.setEnabled(true);
		} else {
			// load the data from the last session if provided
			savedSessionsCombo.select(1 + savedSessionsList.indexOf(session));
			username.setText(session.getUsername());
			username.setEnabled(false);
			password.setEnabled(true);
			savePassword.setEnabled(true);
		}

		Point defaultMargins = LayoutConstants.getMargins();
		GridLayoutFactory.fillDefaults().numColumns(2).margins(defaultMargins.x, defaultMargins.y).generateLayout(contents);

		return contents;
	}

	/**
	 * {@inheritDoc}
	 */
	public void okPressed() {
		if (!newSession) {
			session = savedSessionsList.get(savedSessionsCombo.getSelectionIndex() - 1);
		}
		session.setUsername(username.getText());
		session.setPassword(password.getText());
		session.setSavePassword(savePassword.getSelection());
		if (newSession) {
			// add the newly created session
			WorkspaceManager.getInstance().getCurrentWorkspace().getUsersessions().add(session);
		}
		WorkspaceManager.getInstance().getCurrentWorkspace().save();
		try {
			session.logIn();
		} catch (AccessControlException e) {
			ExceptionDialogHandler.showExceptionDialog(e);
			this.status = FAILED;
		} catch (EmfStoreException e) {
			ExceptionDialogHandler.showExceptionDialog(e);
			this.status = FAILED;
		}
		this.status = SUCCESSFUL;
		close();
	}

	/**
	 * {@inheritDoc}
	 */
	public void cancelPressed() {
		session = null;
		this.status = CANCELED;
		close();
	}

	/**
	 * {@inheritDoc}
	 */
	public void widgetDefaultSelected(SelectionEvent e) {
		// nothing to do here.
	}

	/**
	 * {@inheritDoc}
	 */
	public void widgetSelected(SelectionEvent e) {
		password.setEnabled(true);
		savePassword.setEnabled(true);
		if (savedSessionsCombo.getSelectionIndex() == 0) {
			username.setEnabled(true);
			username.setText("");
			password.setText("");
		} else {
			Usersession loadSession = savedSessionsList.get(savedSessionsCombo.getSelectionIndex() - 1);
			username.setEnabled(false);
			username.setText(loadSession.getUsername());
			password.setText(loadSession.isSavePassword() ? loadSession.getPersistentPassword() + "" : "");
			savePassword.setSelection(loadSession.isSavePassword());
		}

	}

	/**
	 * Returns the status of the login.
	 * Possible return values are SUCCESSFUL, FAILED, CANCELED
	 * @return the integer value of the status
	 */
	public int getStatus(){
		return status;
	}
}
