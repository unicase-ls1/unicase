/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.workspace.ui.commands;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.ui.PlatformUI;
import org.unicase.workspace.ProjectSpace;
import org.unicase.workspace.Usersession;
import org.unicase.workspace.ui.dialogs.LoginDialog;

/**
 * Resolves the ACOrgUnit, opens the login dialog and handles any login procedures.
 * 
 * @author Shterev
 */
public class LoginHandler extends AbstractHandler {

	private Usersession usersession;

	/**
	 * Default constructor.
	 * 
	 * @param usersession the usersession
	 */
	public LoginHandler(Usersession usersession) {
		this.usersession = usersession;
	}

	/**
	 * A constructor with a projectspace as an argument.
	 * 
	 * @param projectSpace the projectspace
	 */
	public LoginHandler(ProjectSpace projectSpace) {
		if (projectSpace.getUsersession() == null) {
			throw new IllegalArgumentException("The project space is not associated with a usersession");
		}
		usersession = projectSpace.getUsersession();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @return true if the login was successful, false if the login was canceled.
	 */
	public Object execute(ExecutionEvent event) throws ExecutionException {
		LoginDialog loginDialog = new LoginDialog(PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell(),
			usersession, usersession.getServerInfo());
		loginDialog.open();
		return loginDialog.getReturnCode();
	}

}