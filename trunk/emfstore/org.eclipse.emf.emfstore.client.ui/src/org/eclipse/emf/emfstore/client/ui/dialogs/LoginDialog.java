/*******************************************************************************
 * Copyright (c) 2008-2011 Chair for Applied Software Engineering, Technische Universitaet Muenchen.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 ******************************************************************************/
package org.eclipse.emf.emfstore.client.ui.dialogs;

import java.util.ArrayList;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.emfstore.client.model.ModelFactory;
import org.eclipse.emf.emfstore.client.model.ServerInfo;
import org.eclipse.emf.emfstore.client.model.Usersession;
import org.eclipse.emf.emfstore.client.model.WorkspaceManager;
import org.eclipse.emf.emfstore.server.exceptions.EmfStoreException;
import org.eclipse.jface.dialogs.TitleAreaDialog;
import org.eclipse.jface.layout.GridLayoutFactory;
import org.eclipse.jface.layout.LayoutConstants;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.FocusEvent;
import org.eclipse.swt.events.FocusListener;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.KeyListener;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
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
import org.sharemedia.ui.sat.SATRunner;
import org.sharemedia.ui.sat.movement.SinusVariation;

/**
 * Class for the login dialog.
 * 
 * @author shterev
 */
public class LoginDialog extends TitleAreaDialog implements SelectionListener {

	// FIXME: maybe another placeholder - e.g. unicase?
	// or no placeholder at all
	/**
	 * Constant placeholder for the password field.
	 */
	protected static final String PLACEHOLDER = "hamid";
	private Text txtUsername;
	private Text txtPassword;
	private Usersession session;
	private Combo sessionsCombo;
	private ArrayList<Usersession> sessionsList;
	private Button chkSavePassword;
	private Composite contents;
	private ServerInfo server;
	private String exception;
	private boolean canFinish;
	private boolean keyTest;

	/**
	 * Default constructor.
	 * 
	 * @param parentShell the parent shell
	 * @param session the target usersession
	 * @param server the target server
	 */
	public LoginDialog(Shell parentShell, Usersession session, ServerInfo server) {
		super(parentShell);
		this.session = session;
		this.server = server;
		setBlockOnOpen(true);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected Control createDialogArea(Composite parent) {
		contents = new Composite(parent, SWT.NONE);
		contents.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));

		setTitle("Log in");
		setMessage("Please enter your username and password");
		if (exception != null) {
			setErrorMessage(exception);
		}
		Label sessionsLabel = new Label(contents, SWT.NULL);
		sessionsLabel.setText("Saved sessions:");

		// initialize the list of appropriate usersessions
		sessionsList = new ArrayList<Usersession>();
		EList<Usersession> workspaceSessions = WorkspaceManager.getInstance().getCurrentWorkspace().getUsersessions();
		sessionsList.addAll(workspaceSessions);
		ArrayList<Usersession> sessionToRemove = new ArrayList<Usersession>();
		for (Usersession tempSession : sessionsList) {
			if (tempSession.getServerInfo() == null) {
				continue;
			}
			if (!tempSession.getServerInfo().equals(server)) {
				sessionToRemove.add(tempSession);
			}
		}
		sessionsList.removeAll(sessionToRemove);

		// initialize the combo for choosing an old session
		sessionsCombo = new Combo(contents, SWT.READ_ONLY);
		sessionsCombo.add("<new session>");
		for (Usersession tempSession : sessionsList) {
			sessionsCombo.add(tempSession.getUsername() + "@" + tempSession.getServerInfo().getName());
		}
		sessionsCombo.addSelectionListener(this);

		// initialize the other widgets
		Label user = new Label(contents, SWT.NULL);
		user.setText("Username:");
		txtUsername = new Text(contents, SWT.SINGLE | SWT.BORDER);
		txtUsername.setSize(150, 20);
		txtUsername.addModifyListener(new ModifyListener() {

			public void modifyText(ModifyEvent e) {
				// TODO AS: Add a proper input validation
				for (Usersession u : sessionsList) {
					if (txtUsername.getText().equals(u.getUsername()) && txtUsername.isEnabled()) {
						setErrorMessage("Duplicate username!");
						canFinish = false;
						return;
					}
				}
				setErrorMessage(null);
				canFinish = true;
			}

		});

		Label pass = new Label(contents, SWT.NULL);
		pass.setText("Password:");
		txtPassword = new Text(contents, SWT.PASSWORD | SWT.BORDER);
		txtPassword.setSize(150, 20);
		txtPassword.addFocusListener(new FocusListener() {
			public void focusLost(FocusEvent e) {
				keyTest = true;
			}

			public void focusGained(FocusEvent e) {
				keyTest = true;
			}
		});
		txtPassword.addKeyListener(new KeyListener() {

			public void keyPressed(KeyEvent e) {
				// set keyTest
				keyTest = true;
			}

			public void keyReleased(KeyEvent e) {
				// nothing to do
			}

		});

		Label savePasswordLabel = new Label(contents, SWT.NULL);
		savePasswordLabel.setText("Save password");
		chkSavePassword = new Button(contents, SWT.CHECK);
		chkSavePassword.addSelectionListener(new SelectionListener() {

			public void widgetDefaultSelected(SelectionEvent e) {
			}

			public void widgetSelected(SelectionEvent e) {
				if (session == null) {
					session = ModelFactory.eINSTANCE.createUsersession();
					session.setServerInfo(server);

				}
				session.setSavePassword(chkSavePassword.getSelection());

			}

		});

		// select entry for a new session
		if (session == null) {
			sessionsCombo.select(0);
			txtUsername.setEnabled(true);
		}
		// load the data from the last session
		else {
			sessionsCombo.select(1 + sessionsList.indexOf(session));
			loadData(session);
		}

		Point defaultMargins = LayoutConstants.getMargins();
		GridLayoutFactory.fillDefaults().numColumns(2).margins(defaultMargins.x, defaultMargins.y)
			.generateLayout(contents);

		return contents;
	}

	/**
	 * {@inheritDoc}
	 */
	// regards the SAT animation code.
	@SuppressWarnings("deprecation")
	@Override
	public void okPressed() {
		if (!canFinish) {
			return;
		}
		if (session == null) {
			session = ModelFactory.eINSTANCE.createUsersession();
			session.setServerInfo(server);

		}

		session.setUsername(txtUsername.getText());
		session.setSavePassword(chkSavePassword.getSelection());

		if ((keyTest || txtPassword.getText().equals(""))) {
			session.setPassword(txtPassword.getText());
		}

		try {
			session.logIn();
			server.setLastUsersession(session);
			if (txtUsername.getEnabled()) {
				// add the newly created session
				WorkspaceManager.getInstance().getCurrentWorkspace().getUsersessions().add(session);

			}
			WorkspaceManager.getInstance().getCurrentWorkspace().save();
			setReturnCode(OK);
			close();
		} catch (EmfStoreException e) {
			new SATRunner().shake(this.getShell(), 300, new SinusVariation(10, 1), null, null);

			setErrorMessage(getMessage(e));

			txtPassword.setText("");
			keyTest = false;

			chkSavePassword.setSelection(false);
		}
	}

	// preliminary fix. when new login dialog is used, we should think
	// of a messagehandler or similar.
	private String getMessage(Exception e) {
		if (e.getCause() != null && e.getCause().getCause() != null
			&& e.getCause().getCause().getMessage().contains("No trusted certificate found")) {
			return "No suited certificate found. You might have to import a new certificate or update your client.";
		} else {
			return e.getMessage();
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void cancelPressed() {
		setReturnCode(CANCEL);
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
		if (sessionsCombo.getSelectionIndex() == 0) {
			txtUsername.setEnabled(true);
			txtUsername.setText("");
			txtPassword.setText("");
			chkSavePassword.setSelection(false);
		} else {
			Usersession loadSession = sessionsList.get(sessionsCombo.getSelectionIndex() - 1);
			loadData(loadSession);
		}

	}

	private void loadData(Usersession session) {
		txtUsername.setEnabled(false);

		txtUsername.setText(session.getUsername());

		if (session.getPassword() != null) {

			if (session.isSavePassword() && !(session.getPersistentPassword() == null)) {

				txtPassword.setText(PLACEHOLDER);
			} else {
				txtPassword.setText("");
			}

		}

		chkSavePassword.setSelection(session.isSavePassword());
		this.session = session;
	}

	/**
	 * @return the new usersession.
	 */
	public Usersession getSession() {
		return session;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public int open() {
		if (session != null && session.getUsername() != null && session.getPassword() != null) {
			try {
				session.logIn();
				close();
				setReturnCode(OK);
				return OK;
			} catch (EmfStoreException e) {
				exception = e.getMessage();
			}
		}
		int ret = super.open();
		return ret;
	}

}
