/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Kögel. All rights reserved. This program and the accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this distribution, and is available at http://www.eclipse.org/legal/epl-v10.html
 * </copyright>
 *
 * $Id$
 */
package org.unicase.ui.esbrowser.dialogs;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Dialog;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.unicase.workspace.ServerInfo;
import org.unicase.workspace.Usersession;
import org.unicase.workspace.WorkspaceFactory;
import org.unicase.workspace.WorkspaceManager;

/**
 * Class for the login dialog.
 * 
 * @author shterev
 */
public class RepositoryLoginDialog extends Dialog implements Listener, SelectionListener {

	private Text username;
	private Text password;
	private Usersession session;
	private Shell shell;
	private Combo savedSessionsCombo;
	private EList<Usersession> savedSessionsList;
	private Button savePassword;
	private Button buttonOK;
	private Button buttonCancel;
	private ServerInfo serverInfo;

	/**
	 * Default constructor.
	 * 
	 * @param parent
	 *            the parent shell
	 * @param session
	 *            the target usersession
	 * @param serverInfo
	 *            the serverinfo
	 */
	public RepositoryLoginDialog(Shell parent, Usersession session, ServerInfo serverInfo) {
		super(parent);
		this.session = session;
		this.serverInfo = serverInfo;
	}

	/**
	 * @return the new usersession for the selected project.
	 */
	public Usersession open() {
		Shell parent = getParent();
		shell = new Shell(parent, SWT.TITLE | SWT.BORDER | SWT.APPLICATION_MODAL);
		shell.setText("Login");
		shell.setLayout(new GridLayout(2, true));

		// initialize the combo for the saved sessions
		Label savedSessionsLabel = new Label(shell, SWT.NULL);
		savedSessionsLabel.setText("Saved sessions:");
		savedSessionsCombo = new Combo(shell, SWT.READ_ONLY);
		savedSessionsCombo.add("<new session>");
		savedSessionsList = WorkspaceManager.getInstance().getCurrentWorkspace().getUsersessions();
		for (int i = 0; i < savedSessionsList.size(); i++) {
			savedSessionsCombo.add(savedSessionsList.get(i).getUsername());
		}
		savedSessionsCombo.addSelectionListener(this);

		// initialize the other widgets
		Label user = new Label(shell, SWT.NULL);
		user.setText("Username:");
		username = new Text(shell, SWT.SINGLE | SWT.BORDER);
		username.setSize(150, 20);

		Label pass = new Label(shell, SWT.NULL);
		pass.setText("Password:");
		password = new Text(shell, SWT.PASSWORD | SWT.BORDER);
		password.setSize(150, 20);

		Label savePasswordLabel = new Label(shell, SWT.NULL);
		savePasswordLabel.setText("Save password");
		savePassword = new Button(shell, SWT.CHECK);

		buttonOK = new Button(shell, SWT.PUSH);
		buttonOK.setText("OK");
		buttonOK.setLayoutData(new GridData(GridData.HORIZONTAL_ALIGN_END));
		buttonCancel = new Button(shell, SWT.PUSH);
		buttonCancel.setText("Cancel");

		buttonOK.addListener(SWT.Selection, this);
		shell.setDefaultButton(buttonOK);
		buttonCancel.addListener(SWT.Selection, this);

		// load the data from the last session if provided
		if (session != null) {
			savedSessionsCombo.select(1 + savedSessionsList.indexOf(session));
			username.setText(session.getUsername());
			username.setEnabled(false);
			password.setEnabled(true);
			savePassword.setEnabled(true);
		} else {
			// otherwise select entry for a new session
			savedSessionsCombo.select(0);
			username.setEnabled(true);
			password.setEnabled(true);
			savePassword.setEnabled(true);
		}

		shell.addListener(SWT.Traverse, this);
		shell.pack();
		shell.open();

		// show in the middle of the screen
		Rectangle shellBounds = parent.getBounds();
		Point dialogSize = shell.getSize();
		shell.setLocation(shellBounds.x + (shellBounds.width - dialogSize.x) / 2, shellBounds.y + (shellBounds.height - dialogSize.y) / 2);

		Display display = parent.getDisplay();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
		return session;

	}

	/**
	 * {@inheritDoc}
	 */
	public void handleEvent(Event event) {
		TransactionalEditingDomain domain = TransactionalEditingDomain.Registry.INSTANCE.getEditingDomain("org.unicase.EditingDomain");
		if (event.type == SWT.Selection) {
			if (event.widget.equals(buttonOK)) {
				if (username.getEnabled()) {
					// no selected session -> create a new one
					session = WorkspaceFactory.eINSTANCE.createUsersession();
					session.setUsername(username.getText());
					session.setServerInfo(serverInfo);
				} else {
					session = savedSessionsList.get(savedSessionsCombo.getSelectionIndex() - 1);
				}
				domain.getCommandStack().execute(new RecordingCommand(domain) {
					@Override
					protected void doExecute() {
						session.setPassword(password.getText());
						session.setSavePassword(savePassword.getSelection());
						session.setServerInfo(serverInfo);
						if (username.getEnabled()) {
							// add the newly created session
							WorkspaceManager.getInstance().getCurrentWorkspace().getUsersessions().add(session);
						}
						WorkspaceManager.getInstance().getCurrentWorkspace().save();
					}
				});

			} else {
				//return a null object if canceled
				session = null;
			}
			shell.dispose();
		}
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
			password.setText(loadSession.getPassword() + "");
			savePassword.setSelection(loadSession.isSavePassword());
		}

	}
}
