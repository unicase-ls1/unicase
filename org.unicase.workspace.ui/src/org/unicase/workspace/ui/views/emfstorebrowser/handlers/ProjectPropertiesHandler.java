/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.workspace.ui.views.emfstorebrowser.handlers;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.TreeNode;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;
import org.unicase.emfstore.esmodel.ProjectInfo;
import org.unicase.emfstore.esmodel.versioning.VersioningFactory;
import org.unicase.emfstore.exceptions.EmfStoreException;
import org.unicase.util.DialogHandler;
import org.unicase.workspace.ServerInfo;
import org.unicase.workspace.Usersession;

/**
 * Handler to show the properties of a project.
 * 
 * @author Shterev
 */
public class ProjectPropertiesHandler extends AbstractHandler {

	/**
	 * {@inheritDoc}
	 */
	public Object execute(ExecutionEvent event) throws ExecutionException {
		IWorkbenchWindow activeWorkbenchWindow = PlatformUI.getWorkbench()
				.getActiveWorkbenchWindow();
		ISelection selection = activeWorkbenchWindow.getSelectionService()
				.getSelection();
		TreeNode treeNode = (TreeNode) ((IStructuredSelection) selection)
				.getFirstElement();
		ProjectInfo projectInfo = (ProjectInfo) treeNode.getValue();
		ServerInfo serverInfo = (ServerInfo) treeNode.getParent().getValue();
		Usersession session = serverInfo.getLastUsersession();
		int revision;
		try {
			revision = session.resolveVersionSpec(
					VersioningFactory.eINSTANCE.createHeadVersionSpec(),
					projectInfo.getProjectId()).getIdentifier();
			MessageDialog.openInformation(
					Display.getCurrent().getActiveShell(),
					"Project information", "Current revision: " + revision
							+ "\nProjectId: "
							+ projectInfo.getProjectId().getId());
		} catch (EmfStoreException e) {
			DialogHandler.showExceptionDialog(e);
		}
		return null;
	}
}