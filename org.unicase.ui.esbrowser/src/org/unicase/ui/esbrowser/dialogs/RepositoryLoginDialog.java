/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this distribution, and is available at http://www.eclipse.org/legal/epl-v10.html
 * </copyright>
 *
 * $Id$
 */
package org.unicase.ui.esbrowser.dialogs;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.jface.dialogs.Dialog;
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
import org.unicase.workspace.ServerInfo;
import org.unicase.workspace.Usersession;
import org.unicase.workspace.WorkspaceFactory;
import org.unicase.workspace.WorkspaceManager;

/**
 * Class for the login dialog.
 * 
 * @author shterev
 */
public class RepositoryLoginDialog extends TitleAreaDialog implements SelectionListener {

		private Text username;
		private Text password;
		private Usersession session;
		private Combo savedSessionsCombo;
		private EList<Usersession> savedSessionsList;
		private Button savePassword;
		private ServerInfo serverInfo;
		
		/**
		 * Default constructor.
		 * 
		 * @param parentShell
		 *            the parent shell
		 * @param session
		 *            the target usersession
		 * @param serverInfo
		 *            the serverinfo
		 */
		public RepositoryLoginDialog(Shell parentShell, Usersession session, ServerInfo serverInfo) {
			super(parentShell);
			this.session = session;
			this.serverInfo = serverInfo;
		}

		/**
		 * {@inheritDoc}
		 */
		protected Control createDialogArea(Composite parent) {
			Composite contents = new Composite(parent, SWT.NONE);
			contents.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));

			setTitle("Log in");
			setMessage("Please enter your username and password");
			Dialog.applyDialogFont(parent);
			
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

			Point defaultMargins = LayoutConstants.getMargins();
			GridLayoutFactory.fillDefaults().numColumns(2).margins(defaultMargins.x, defaultMargins.y).generateLayout(contents);
			
			return contents;
		}
		
	/**
	 * @return the new usersession for the selected project.
	 */
	public Usersession getUsersession() {
		return session;
	}

	/**
	 * {@inheritDoc}
	 */
	public void okPressed(){
		TransactionalEditingDomain domain = TransactionalEditingDomain.Registry.INSTANCE.getEditingDomain("org.unicase.EditingDomain");
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
				if(savePassword.getSelection()){
					session.setPassword(password.getText());
				}else{
					session.setPassword(null);
				}
				session.setSavePassword(savePassword.getSelection());
				session.setServerInfo(serverInfo);
				if (username.getEnabled()) {
					// add the newly created session
					WorkspaceManager.getInstance().getCurrentWorkspace().getUsersessions().add(session);
				}
				WorkspaceManager.getInstance().getCurrentWorkspace().save();
			}
		});
		close();
	}
	
	/**
	 * {@inheritDoc}
	 */
	public void cancelPressed(){
		session = null;
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
			password.setText(loadSession.isSavePassword()?loadSession.getPersistentPassword()+"":"");
			savePassword.setSelection(loadSession.isSavePassword());
		}

	}
}
