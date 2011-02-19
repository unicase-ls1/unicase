/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.workspace.ui.views.emfstorebrowser.handlers;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;
import org.unicase.workspace.ui.views.emfstorebrowser.views.NewRepositoryWizard;

/**
 * Handler for creating a new repository.
 * 
 * @author Shterev
 */
public class AddServerHandler extends AbstractHandler {

	/**
	 * {@inheritDoc}
	 */
	public Object execute(ExecutionEvent event) throws ExecutionException {
		NewRepositoryWizard wizard = new NewRepositoryWizard();
		IWorkbenchWindow activeWorkbenchWindow = PlatformUI.getWorkbench()
				.getActiveWorkbenchWindow();
		wizard.init(activeWorkbenchWindow.getWorkbench(),
				(IStructuredSelection) activeWorkbenchWindow
						.getSelectionService().getSelection());
		WizardDialog dialog = new WizardDialog(
				activeWorkbenchWindow.getShell(), wizard);
		dialog.create();
		dialog.open();
		return null;
	}
}