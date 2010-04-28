/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.workspace.ui.views.emfstorebrowser.handlers;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.TreeNode;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;
import org.unicase.emfstore.exceptions.EmfStoreException;
import org.unicase.workspace.ServerInfo;
import org.unicase.workspace.WorkspaceManager;
import org.unicase.workspace.util.UnicaseCommand;
import org.unicase.workspace.util.WorkspaceUtil;

/**
 * Changes the user session.
 * 
 * @author Shterev
 */
public class ChangeSessionHandler extends AbstractHandler {

	/**
	 * {@inheritDoc}
	 */
	public Object execute(ExecutionEvent event) throws ExecutionException {
		IWorkbenchWindow activeWorkbenchWindow = PlatformUI.getWorkbench()
				.getActiveWorkbenchWindow();
		ISelection selection = activeWorkbenchWindow.getSelectionService()
				.getSelection();
		Object obj = ((IStructuredSelection) selection).getFirstElement();
		if (!(obj instanceof TreeNode)) {
			return null;
		}
		TreeNode node = (TreeNode) obj;
		final ServerInfo element = (ServerInfo) node.getValue();
		new UnicaseCommand() {
			@Override
			protected void doRun() {
				try {
					element.getLastUsersession().logout();
				} catch (EmfStoreException e) {
					WorkspaceUtil.logException(e.getMessage(), e);
				}
				element.getLastUsersession().setSessionId(null);
				// reset the password in the RAM cache
				if (!element.getLastUsersession().isSavePassword()) {
					element.getLastUsersession().setPassword(null);
				}
				element.setLastUsersession(null);
				WorkspaceManager.getInstance().getCurrentWorkspace().save();
			}
		}.run();
		return null;
	}
}