/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.iterationplanner.ui.commands;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.swt.widgets.Display;
import org.unicase.iterationplanner.ui.wizard.input.IterationPlanningInputWizard;
import org.unicase.metamodel.Project;
import org.unicase.workspace.WorkspaceManager;

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
		Project project = getProject();
		if(project != null){
			IterationPlanningInputWizard wizard = new IterationPlanningInputWizard(project);
			WizardDialog dialog = new WizardDialog(Display.getCurrent().getActiveShell(), wizard);
			dialog.open();
		}
		return null;

	}

	private Project getProject() {
//		boolean unicase = true;
//		EList<ProjectSpace> projectSpaces = WorkspaceManager.getInstance().getCurrentWorkspace().getProjectSpaces();
//		if(unicase){
//			return projectSpaces.get(0).getProject();
//		}else{
//			return projectSpaces.get(1).getProject();
//		}
		Project project = WorkspaceManager.getInstance().getCurrentWorkspace().getActiveProjectSpace().getProject();
		if(project != null){
			return project;
		}
		MessageDialog.openInformation(Display.getCurrent().getActiveShell(), "No project selected", "You must select a project in navigator.");
		return null;
	}

}
