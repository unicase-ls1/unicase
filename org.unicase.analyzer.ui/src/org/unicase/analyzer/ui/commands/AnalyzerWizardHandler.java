/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */

package org.unicase.analyzer.ui.commands;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.handlers.HandlerUtil;
import org.unicase.analyzer.ui.wizards.ProjectAnalyzerWizard;

/**
 * @author liya
 */
public class AnalyzerWizardHandler extends AbstractHandler {

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.core.commands.IHandler#execute(org.eclipse.core.commands.ExecutionEvent)
	 */
	public Object execute(final ExecutionEvent event) throws ExecutionException {
		//
		// ServerRequestCommandHandler handler = new ServerRequestCommandHandler() {
		//
		// @Override
		// protected Object run() throws EmfStoreException {
		ProjectAnalyzerWizard wizard = new ProjectAnalyzerWizard();
		ISelection selection = HandlerUtil.getCurrentSelection(event);
		IStructuredSelection ssel;
		if (selection != null && selection instanceof IStructuredSelection) {
			ssel = (IStructuredSelection) selection;
			wizard.init(HandlerUtil.getActiveWorkbenchWindow(event).getWorkbench(), ssel);
		}
		if (wizard.isLoggedIn()) {
			WizardDialog wizardDialog = new WizardDialog(PlatformUI.getWorkbench().getActiveWorkbenchWindow()
				.getShell(), wizard);
			wizardDialog.create();
			wizardDialog.open();
		}

		return null;
		// }

		// };
		// try {
		// handler.execute(new ExecutionEvent());
		// } catch (ExecutionException e) {
		// DialogHandler.showErrorDialog(e.getMessage());
		// }
		// return null;

	}

}
