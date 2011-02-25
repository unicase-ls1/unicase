/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.navigator.handler;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.IHandler;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.ui.handlers.HandlerUtil;
import org.unicase.ui.navigator.wizards.NewModelElementWizard;

/**
 * @author Hodaie This is the handler for "Add new model element" context menu command. The command is only shown on
 *         LeafSections. The handler initializes and shows the AddNewModelElementWizard
 */
public class NewModelElementWizardHandler extends AbstractHandler implements IHandler {

	private static final String WIZARD_TITLE = "Add new model element";
	/**
	 * String to pass the eclass which containments shall be shown in the new element wizard.
	 */
	public static final String COMMAND_ECLASS_PARAM = "org.unicase.ui.navigator.eClassParameter";

	/**
	 * . ({@inheritDoc})
	 */
	public Object execute(final ExecutionEvent event) throws ExecutionException {

		NewModelElementWizard wizard = new NewModelElementWizard();

		ISelection selection = HandlerUtil.getCurrentSelection(event);
		IStructuredSelection ssel;
		if (selection != null && selection instanceof IStructuredSelection) {
			ssel = (IStructuredSelection) selection;
			wizard.init(HandlerUtil.getActiveWorkbenchWindow(event).getWorkbench(), ssel);
		}

		WizardDialog dialog = new WizardDialog(HandlerUtil.getActiveShell(event), wizard);
		wizard.setWindowTitle(WIZARD_TITLE);
		dialog.create();
		dialog.open();

		return null;
	}

}
