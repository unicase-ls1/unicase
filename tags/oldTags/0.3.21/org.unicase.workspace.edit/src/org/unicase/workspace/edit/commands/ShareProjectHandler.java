/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.workspace.edit.commands;

import java.util.Collection;

import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.dialogs.ElementListSelectionDialog;
import org.unicase.emfstore.exceptions.EmfStoreException;
import org.unicase.ui.common.exceptions.DialogHandler;
import org.unicase.workspace.ProjectSpace;
import org.unicase.workspace.Usersession;
import org.unicase.workspace.Workspace;
import org.unicase.workspace.WorkspaceManager;
import org.unicase.workspace.edit.dialogs.LoginDialog;

/**
 * Share a project with the server.
 * 
 * @author koegel
 */
public class ShareProjectHandler extends ProjectActionHandler {

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.core.commands.AbstractHandler#execute(org.eclipse.core.commands.ExecutionEvent)
	 */
	public Object execute(ExecutionEvent event) throws ExecutionException {

		final ProjectSpace projectSpace = getProjectSpace(event);
		TransactionalEditingDomain domain = TransactionalEditingDomain.Registry.INSTANCE
			.getEditingDomain("org.unicase.EditingDomain");
		domain.getCommandStack().execute(new RecordingCommand(domain) {
			@Override
			protected void doExecute() {
				// TODO: handle exception
				try {
					createProject(projectSpace);
					// BEGIN SUPRESS CATCH EXCEPTION
				} catch (RuntimeException e) {
					DialogHandler.showExceptionDialog(e);
					throw e;
				}
				// END SUPRESS CATCH EXCEPTION
			}
		});
		return null;
	}

	/**
	 * @param projectSpace
	 */
	private void createProject(ProjectSpace projectSpace) {
		Shell shell = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell();
		ElementListSelectionDialog dlg = new ElementListSelectionDialog(shell, new AdapterFactoryLabelProvider(
			new ComposedAdapterFactory(ComposedAdapterFactory.Descriptor.Registry.INSTANCE)));
		Workspace currentWorkspace = WorkspaceManager.getInstance().getCurrentWorkspace();
		Collection<Usersession> allSessions = currentWorkspace.getUsersessions();
		dlg.setElements(allSessions.toArray());
		dlg.setTitle("Select Usersession");
		dlg.setBlockOnOpen(true);
		if (dlg.open() == Window.OK) {
			Object result = dlg.getFirstResult();
			if (result instanceof Usersession) {
				Usersession usersession = (Usersession) result;
				LoginDialog login;
				// initially setting the status as successful in case the user
				// is already logged in
				int loginStatus = LoginDialog.SUCCESSFUL;
				if (!usersession.isLoggedIn()) {
					login = new LoginDialog(shell, usersession, usersession.getServerInfo());
					loginStatus = login.open();
				}
				if (loginStatus == LoginDialog.SUCCESSFUL) {
					try {
						projectSpace.shareProject(usersession);
						MessageDialog.openInformation(shell, null, "Your project was successfully shared!");
					} catch (EmfStoreException e) {
						DialogHandler.showExceptionDialog(e);
					}
				}
			}
		}
	}

}
