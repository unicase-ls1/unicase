/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this distribution, and is available at http://www.eclipse.org/legal/epl-v10.html
 * </copyright>
 */
package org.unicase.workspace.edit.commands;

import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.dialogs.ProgressMonitorDialog;
import org.eclipse.ui.PlatformUI;
import org.unicase.ui.common.exceptions.DialogHandler;
import org.unicase.workspace.ProjectSpace;

//MK: document whats this exactly does
/**
 * 
 * @author helming
 * 
 */
public class RevertHandler extends ProjectActionHandler {

	/**
	 * {@inheritDoc}
	 */
	public Object execute(final ExecutionEvent event) throws ExecutionException {
		final ProjectSpace projectSpace;
		projectSpace = getProjectSpace(event);
		
		if (projectSpace==null) {
			DialogHandler.showErrorDialog("No Project selected.");
		}
		TransactionalEditingDomain domain = TransactionalEditingDomain.Registry.INSTANCE
				.getEditingDomain("org.unicase.EditingDomain");
		final ProgressMonitorDialog progressDialog = new ProgressMonitorDialog(PlatformUI.getWorkbench()
			       .getActiveWorkbenchWindow().getShell());
		domain.getCommandStack().execute(new RecordingCommand(domain) {
			@Override
			protected void doExecute() {
				
				MessageDialog dialog = new MessageDialog(null, "Confirmation",
						null, "Do you really want to revert all your changes on project" + projectSpace.getProjectName(),
						MessageDialog.QUESTION, new String[] { "Yes", "No" }, 0);
				int result = dialog.open();
				if (result == 0) {
					progressDialog.getProgressMonitor().done();
					progressDialog.close();
					projectSpace.revert();
					progressDialog.getProgressMonitor().done();
					progressDialog.close();
				}
			}
		});
		return null;
	}
}
