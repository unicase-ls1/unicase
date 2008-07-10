/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this distribution, and is available at http://www.eclipse.org/legal/epl-v10.html
 * </copyright>
 *
 * $Id$
 */
package org.unicase.workspace.edit.commands;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.handlers.HandlerUtil;
import org.unicase.emfstore.esmodel.EsmodelFactory;
import org.unicase.emfstore.esmodel.ProjectInfo;
import org.unicase.emfstore.esmodel.changemanagment.VersionSpec;
import org.unicase.emfstore.exceptions.EmfStoreException;
import org.unicase.workspace.ProjectSpace;
import org.unicase.workspace.Workspace;
import org.unicase.workspace.WorkspaceManager;

/**
 * 
 * @author Hodaie This handlers handles UpdateWorkspace command. This command is
 *         shown in UC View context menu only for Projects
 * 
 */
public class UpdateWorkspaceHandler extends AbstractHandler {

	/**
	 * . ({@inheritDoc})
	 * 
	 */
	public Object execute(ExecutionEvent event) throws ExecutionException {

		IWorkbenchWindow window = HandlerUtil
				.getActiveWorkbenchWindowChecked(event);

		MessageDialog.openInformation(window.getShell(), null,
				"UpdateWorkspace!");

		ISelection sel = HandlerUtil.getCurrentSelection(event);
		if (!(sel instanceof IStructuredSelection)) {
			return null;
		}

		IStructuredSelection ssel = (IStructuredSelection) sel;
		if (ssel.isEmpty()) {
			return null;
		}

		Object o = ssel.getFirstElement();
		if (!(o instanceof ProjectSpace)) {
			return null;
		}

		final ProjectSpace projectSpace = (ProjectSpace) o;

		// TODO: handle exception
		TransactionalEditingDomain domain = TransactionalEditingDomain.Registry.INSTANCE
				.getEditingDomain("org.unicase.EditingDomain");
		domain.getCommandStack().execute(new RecordingCommand(domain) {
			protected void doExecute() {
				try {
					projectSpace.getUsersession().logIn();
					Workspace workspace = WorkspaceManager.getInstance()
							.getCurrentWorkspace();
					workspace.getProjectSpaces().remove(projectSpace);
					ProjectInfo projectInfo = EsmodelFactory.eINSTANCE
							.createProjectInfo();
					projectInfo.setName(projectSpace.getProjectName());
					projectInfo.setDescription(projectInfo.getDescription());
					projectInfo.setProjectId(projectSpace.getProjectId());
					projectInfo.setVersion(projectSpace
							.resolveVersionSpec(VersionSpec.HEAD_VERSION));
					ProjectSpace projectSpace2 = workspace.checkout(
							projectSpace.getUsersession(), projectInfo);
					workspace.getProjectSpaces().add(projectSpace2);
					workspace.save();

				} catch (EmfStoreException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		return null;
	}
}
