/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.workspace.ui.views.emfstorebrowser.handlers;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.emf.emfstore.client.model.ServerInfo;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.TreeNode;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;
import org.unicase.workspace.ui.views.emfstorebrowser.views.NewRepositoryWizard;

/**
 * Handler to show the properties of a server.
 * 
 * @author Shterev
 */
public class ServerPropertiesHandler extends AbstractHandler {

	/**
	 * {@inheritDoc}
	 */
	public Object execute(ExecutionEvent event) throws ExecutionException {
		IWorkbenchWindow activeWorkbenchWindow = PlatformUI.getWorkbench()
				.getActiveWorkbenchWindow();
		ISelection selection = activeWorkbenchWindow.getSelectionService()
				.getSelection();
		Object obj = ((IStructuredSelection) selection).getFirstElement();
		TreeNode node = (TreeNode) obj;
		ServerInfo serverInfo = (ServerInfo) node.getValue();
		NewRepositoryWizard wizard = new NewRepositoryWizard();
		wizard.init(activeWorkbenchWindow.getWorkbench(),
				(IStructuredSelection) selection, serverInfo);
		WizardDialog dialog = new WizardDialog(
				activeWorkbenchWindow.getShell(), wizard);
		dialog.create();
		dialog.open();
		return null;
	}
}