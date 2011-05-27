/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */

package org.unicase.ui.linkrecommendation.commands;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.IWizard;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.handlers.HandlerUtil;
import org.unicase.metamodel.ModelElement;
import org.unicase.ui.common.util.ActionHelper;
import org.unicase.ui.linkrecommendation.wizards.RecoveryWizard;

/**
 * @author liya
 */
public class RecoveryWizardHandler extends AbstractHandler {

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.core.commands.IHandler#execute(org.eclipse.core.commands.ExecutionEvent)
	 */
	public Object execute(final ExecutionEvent event) throws ExecutionException {
		ISelection selection = HandlerUtil.getCurrentSelection(event);
		IStructuredSelection ssel;

		// determine if wiard is called inside a model element or from the navigator
		ModelElement me = ActionHelper.getModelElement(event);

		final RecoveryWizard wizard;
		if (me != null) {
			wizard = new RecoveryWizard(me);
		} else {
			wizard = new RecoveryWizard();
			if (selection != null && selection instanceof IStructuredSelection) {
				ssel = (IStructuredSelection) selection;
				wizard.init(HandlerUtil.getActiveWorkbenchWindow(event).getWorkbench(), ssel);
			}
		}

		WizardDialog wizardDialog = new ModalWizardDialog(PlatformUI.getWorkbench().getActiveWorkbenchWindow()
			.getShell(), wizard);
		wizardDialog.create();
		wizardDialog.open();

		return null;
	}

	/**
	 * This is a dialog that does not block the program.
	 * 
	 * @author Henning Femmer
	 */
	private class ModalWizardDialog extends WizardDialog {

		public ModalWizardDialog(Shell parentShell, IWizard newWizard) {
			super(parentShell, newWizard);
			setShellStyle(SWT.CLOSE | SWT.MAX | SWT.TITLE | SWT.BORDER | SWT.RESIZE | getDefaultOrientation());
		}

	}
}
