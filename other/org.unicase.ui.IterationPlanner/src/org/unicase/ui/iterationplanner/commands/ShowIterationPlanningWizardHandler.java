/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.iterationplanner.commands;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.unicase.ui.iterationplanner.WorkItemsToCSV;

/**
 * This handler shows iteration planning wizard.
 * 
 * @author hodaie
 */
public class ShowIterationPlanningWizardHandler extends AbstractHandler {

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.core.commands.AbstractHandler#execute(org.eclipse.core.commands.ExecutionEvent)
	 */
	public Object execute(ExecutionEvent event) throws ExecutionException {
		// try {
		// @SuppressWarnings("unused")
		// Project project =
		// WorkspaceManager.getInstance().getCurrentWorkspace().getActiveProjectSpace().getProject();
		// } catch (NullPointerException e) {
		// MessageDialog.openWarning(Display.getCurrent().getActiveShell(),
		// "No Project selected",
		// "Pleas select a project.");
		// return null;
		// }
		// IterationPlanningWizard wizard = new IterationPlanningWizard();
		// WizardDialog wizardDialog = new
		// WizardDialog(PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell(),
		// wizard);
		// wizardDialog.create();
		// wizardDialog.open();

		WorkItemsToCSV wiToCVS = new WorkItemsToCSV();
		wiToCVS.outputWorkItems();
		
		return null;
	}
}
