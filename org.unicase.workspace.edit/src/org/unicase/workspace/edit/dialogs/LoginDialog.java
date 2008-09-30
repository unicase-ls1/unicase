/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this distribution, and is available at http://www.eclipse.org/legal/epl-v10.html
 * </copyright>
 *
 * $Id$
 */
package org.unicase.workspace.edit.dialogs;

import java.util.ArrayList;

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
import org.unicase.emfstore.exceptions.EmfStoreException;
import org.unicase.workspace.ServerInfo;
import org.unicase.workspace.Usersession;
import org.unicase.workspace.WorkspaceFactory;
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
	private Combo sessionsCombo;
	private EList<Usersession> sessionsList;
	private Button savePassword;
	private Composite contents;
	private ServerInfo server;

	/**
	 * Default constructor.
	 * 
	 * @param parentShell
	 *            the parent shell
	 * @param session
	 *            the target usersession
	 * @param server
	 *            the target server
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
	protected Control createDialogArea(Composite parent) {
		contents = new Composite(parent, SWT.NONE);
		contents.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));

		setTitle("Log in");
		setMessage("Please enter your username and password");

		Label sessionsLabel = new Label(contents, SWT.NULL);
		sessionsLabel.setText("Saved sessions:");

		//initialize the list of appropriate usersessions
		sessionsList = WorkspaceManager.getInstance().getCurrentWorkspace().getUsersessions();
		ArrayList<Usersession> sessionToRemove = new ArrayList<Usersession>();
		for (Usersession tempSession : sessionsList) {			
			if(!tempSession.getServerInfo().equals(server)){
				sessionToRemove.add(tempSession);
			}
		}
		sessionsList.removeAll(sessionToRemove);

		// initialize the combo for choosing an old session
		sessionsCombo = new Combo(contents, SWT.READ_ONLY);
		sessionsCombo.add("<new session>");
		for (Usersession tempSession : sessionsList) {
			sessionsCombo.add(tempSession.getUsername());
		}
		sessionsCombo.addSelectionListener(this);

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

		// select entry for a new session
		if (session == null) {
			sessionsCombo.select(0);
			username.setEnabled(true);
		}
		// load the data from the last session
		else {
			sessionsCombo.select(1 + sessionsList.indexOf(session));
			loadData(session);
		}

		Point defaultMargins = LayoutConstants.getMargins();
		GridLayoutFactory.fillDefaults().numColumns(2).margins(defaultMargins.x, defaultMargins.y).generateLayout(contents);

		return contents;
	}

	/**
	 * {@inheritDoc}
	 */
	public void okPressed() {
		if (session==null) {
			session = WorkspaceFactory.eINSTANCE.createUsersession();
			session.setServerInfo(server);
		}
		session.setUsername(username.getText());
		session.setPassword(password.getText());
		session.setSavePassword(savePassword.getSelection());
		setReturnCode(FAILED);
		try {
			session.logIn();
			server.setLastUsersession(session);
			if(username.getEnabled()){
				// add the newly created session
				WorkspaceManager.getInstance().getCurrentWorkspace().getUsersessions().add(session);
			}
			WorkspaceManager.getInstance().getCurrentWorkspace().save();
			setReturnCode(SUCCESSFUL);
			close();
		} catch (EmfStoreException e) {
			e.printStackTrace();
			setErrorMessage(e.getMessage());
			password.selectAll();
			setReturnCode(FAILED);
		}
	}

	/**
	 * {@inheritDoc}
	 */
	public void cancelPressed() {
		// session = null;
		setReturnCode(CANCELED);
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
			username.setEnabled(true);
			username.setText("");
			password.setText("");
			savePassword.setSelection(false);
		} else {
			Usersession loadSession = sessionsList.get(sessionsCombo.getSelectionIndex() - 1);
			loadData(loadSession);
		}

	}

	private void loadData(Usersession session) {
		username.setEnabled(false);

		username.setText(session.getUsername());
		if (session.getPassword() != null) {
			password.setText(session.getPassword());
		}
		savePassword.setSelection(session.isSavePassword());
		this.session = session; 
	}
	
	/**
	 * @return the new usersession.
	 */
	public Usersession getSession(){
		return session;
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public int open(){
		if(session!=null && session.getUsername()!=null && session.getPassword()!=null){
			try {
				session.logIn();
				close();
				return SUCCESSFUL;
			} catch (EmfStoreException e) {
				setErrorMessage(e.getMessage());
			}
		}
		return super.open();
	}

}
