/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright> $Id$
 */
package org.unicase.workspace.edit.commands;

import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.unicase.model.ModelElement;
import org.unicase.ui.common.commands.ActionHelper;
import org.unicase.ui.common.exceptions.DialogHandler;
import org.unicase.workspace.ProjectSpace;
import org.unicase.workspace.Usersession;
import org.unicase.workspace.WorkspaceManager;
import org.unicase.workspace.edit.dialogs.LoginDialog;
import org.unicase.workspace.edit.views.historybrowserview.HistoryBrowserView;

/**
 * Handler for viewing the history of the current project.
 * 
 * @author Shterev
 */
public class ShowHistoryHandler extends ProjectActionHandler {

	private Shell shell;

	/**
	 * {@inheritDoc}
	 */
	public Object execute(final ExecutionEvent event) throws ExecutionException {

		ProjectSpace projectSpace = getProjectSpace(event);
		if (projectSpace == null) {
			ProjectSpace activeProjectSpace = WorkspaceManager.getInstance().getCurrentWorkspace()
				.getActiveProjectSpace();
			if (activeProjectSpace == null) {
				MessageDialog.openInformation(shell, "Information", "You must select the Project");
				return null;
			}
			projectSpace = activeProjectSpace;
		}
		final ProjectSpace finalProjectSpace = projectSpace;
		TransactionalEditingDomain domain = TransactionalEditingDomain.Registry.INSTANCE
			.getEditingDomain("org.unicase.EditingDomain");
		domain.getCommandStack().execute(new RecordingCommand(domain) {
			@Override
			protected void doExecute() {
				int loginStatus = LoginDialog.SUCCESSFUL;
				Usersession usersession = finalProjectSpace.getUsersession();
				if (!usersession.isLoggedIn()) {
					loginStatus = (new LoginDialog(shell, usersession, usersession.getServerInfo())).open();
				}
				if (loginStatus == LoginDialog.SUCCESSFUL) {
					ModelElement modelElement = ActionHelper.getModelElement(event);
					IWorkbenchPage page = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
					HistoryBrowserView historyBrowserView = null;
					try {
						historyBrowserView = (HistoryBrowserView) page
							.showView("org.unicase.workspace.edit.views.historybrowserview.HistoryBrowserView");
					} catch (PartInitException e) {
						DialogHandler.showExceptionDialog(e);
					}
					if (historyBrowserView != null) {
						historyBrowserView.setInput(finalProjectSpace, modelElement);
					}
				}
			}
		});

		return null;
	}

}