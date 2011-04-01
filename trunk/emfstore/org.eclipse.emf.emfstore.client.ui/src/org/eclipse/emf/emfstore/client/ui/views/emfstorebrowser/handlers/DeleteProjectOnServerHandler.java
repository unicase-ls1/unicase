/*******************************************************************************
 * Copyright (c) 2008-2011 Chair for Applied Software Engineering, Technische Universitaet Muenchen.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 ******************************************************************************/
package org.eclipse.emf.emfstore.client.ui.views.emfstorebrowser.handlers;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.emf.ecp.common.util.DialogHandler;
import org.eclipse.emf.emfstore.client.model.ServerInfo;
import org.eclipse.emf.emfstore.client.model.Usersession;
import org.eclipse.emf.emfstore.client.model.util.UnicaseCommand;
import org.eclipse.emf.emfstore.server.exceptions.EmfStoreException;
import org.eclipse.emf.emfstore.server.model.ProjectInfo;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.dialogs.MessageDialogWithToggle;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.TreeNode;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;

/**
 * Deletes a project on the server.
 * 
 * @author Shterev
 */
public class DeleteProjectOnServerHandler extends AbstractHandler {

	/**
	 * {@inheritDoc}
	 */
	public Object execute(ExecutionEvent event) throws ExecutionException {
		IWorkbenchWindow activeWorkbenchWindow = PlatformUI.getWorkbench().getActiveWorkbenchWindow();
		ISelection selection = activeWorkbenchWindow.getSelectionService().getSelection();
		Object obj = ((IStructuredSelection) selection).getFirstElement();

		if (!(obj instanceof TreeNode)) {
			return null;
		}
		TreeNode node = (TreeNode) obj;

		final ProjectInfo projectInfo = ((ProjectInfo) node.getValue());
		final MessageDialogWithToggle dialog = MessageDialogWithToggle.openOkCancelConfirm(PlatformUI.getWorkbench()
			.getDisplay().getActiveShell(), "Delete " + projectInfo.getName(), "Are you sure you want to delete \'"
			+ projectInfo.getName() + "\'", "Delete project contents (cannot be undone)", false, null, null);
		if (dialog.getReturnCode() == MessageDialog.OK) {
			ServerInfo serverInfo = (ServerInfo) node.getParent().getValue();
			final Usersession session = serverInfo.getLastUsersession();
			new UnicaseCommand() {
				@Override
				protected void doRun() {
					try {
						session.deleteProject(projectInfo.getProjectId(), dialog.getToggleState());
					} catch (EmfStoreException e) {
						DialogHandler.showExceptionDialog(e);
					}
				}
			}.run();
		}
		return null;
	}
}
