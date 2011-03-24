/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.eclipse.emf.emfstore.client.ui.views.emfstorebrowser.handlers;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.emf.emfstore.client.model.AdminBroker;
import org.eclipse.emf.emfstore.client.model.ServerInfo;
import org.eclipse.emf.emfstore.client.model.Usersession;
import org.eclipse.emf.emfstore.client.ui.views.emfstorebrowser.dialogs.admin.ManageOrgUnitsDialog;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.TreeNode;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;
import org.unicase.emfstore.exceptions.EmfStoreException;
import org.unicase.ui.util.DialogHandler;

/**
 * Handler for the user management dialog.
 * 
 * @author Shterev
 */
public class ManageOrgUnitsHandler extends AbstractHandler {

	/**
	 * {@inheritDoc}
	 */
	public Object execute(ExecutionEvent event) throws ExecutionException {
		ManageOrgUnitsDialog dialog;
		try {
			IWorkbenchWindow activeWorkbenchWindow = PlatformUI.getWorkbench()
					.getActiveWorkbenchWindow();
			ISelection selection = activeWorkbenchWindow.getSelectionService()
					.getSelection();
			Object obj = ((IStructuredSelection) selection).getFirstElement();
			if (!(obj instanceof TreeNode)) {
				return null;
			}

			TreeNode node = (TreeNode) obj;
			ServerInfo serverInfo = (ServerInfo) node.getValue();
			Usersession session = serverInfo.getLastUsersession();
			AdminBroker adminBroker = session.getAdminBroker();
			dialog = new ManageOrgUnitsDialog(PlatformUI.getWorkbench()
					.getDisplay().getActiveShell(), adminBroker);
			dialog.create();
			dialog.open();
		} catch (EmfStoreException e) {
			DialogHandler.showExceptionDialog(e);
		}
		return null;
	}
}