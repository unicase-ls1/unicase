/**
 * <copyright> Copyright (c) 2009-2012 Chair of Applied Software Engineering, Technische Universität München (TUM).
 * All rights reserved. This program and the accompanying materials are made available under the terms of
 * the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.workpackagetransfer.navigator.commands;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.IHandler;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.ui.handlers.HandlerUtil;
import org.unicase.workpackagetransfer.navigator.wizards.WorkpackageTransferWizard;

/**
 * This is the handler for the "Assign to group" context menu command. The command is only shown on
 *         WorkPackages. The handler initializes and shows the WorkpackageTransferWizard.
 * @author mkagel 
 */
public class WorkpackageTransferWizardHandler extends AbstractHandler implements IHandler {

	private static final String TITLE = "Move modelelement to workpackage";
	
	/***
	 * . ({@inheritDoc})
	 */
	public Object execute(ExecutionEvent event) throws ExecutionException {
		WorkpackageTransferWizard wizard = new WorkpackageTransferWizard();
		
		ISelection selection = HandlerUtil.getCurrentSelection(event);
		IStructuredSelection strucSel;
		
		if(selection != null && selection instanceof IStructuredSelection) {
			strucSel = (IStructuredSelection)selection;
			wizard.init(HandlerUtil.getActiveWorkbenchWindow(event).getWorkbench(), strucSel);
		}
		
		WizardDialog dialog = new WizardDialog(HandlerUtil.getActiveShell(event), wizard);
		wizard.setWindowTitle(TITLE);
		dialog.create();
		dialog.open();
	
		return null;
	}

}
