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
import org.eclipse.emf.emfstore.client.model.ServerInfo;
import org.eclipse.emf.emfstore.client.model.Usersession;
import org.eclipse.emf.emfstore.server.exceptions.EmfStoreException;
import org.eclipse.emf.emfstore.server.model.ProjectInfo;
import org.eclipse.emf.emfstore.server.model.versioning.VersioningFactory;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.TreeNode;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;
import org.unicase.ui.util.DialogHandler;

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
		IWorkbenchWindow activeWorkbenchWindow = PlatformUI.getWorkbench().getActiveWorkbenchWindow();
		ISelection selection = activeWorkbenchWindow.getSelectionService().getSelection();
		TreeNode treeNode = (TreeNode) ((IStructuredSelection) selection).getFirstElement();
		ProjectInfo projectInfo = (ProjectInfo) treeNode.getValue();
		ServerInfo serverInfo = (ServerInfo) treeNode.getParent().getValue();
		Usersession session = serverInfo.getLastUsersession();
		int revision;
		try {
			revision = session.resolveVersionSpec(VersioningFactory.eINSTANCE.createHeadVersionSpec(),
				projectInfo.getProjectId()).getIdentifier();
			MessageDialog.openInformation(Display.getCurrent().getActiveShell(), "Project information",
				"Current revision: " + revision + "\nProjectId: " + projectInfo.getProjectId().getId());
		} catch (EmfStoreException e) {
			DialogHandler.showExceptionDialog(e);
		}
		return null;
	}
}
