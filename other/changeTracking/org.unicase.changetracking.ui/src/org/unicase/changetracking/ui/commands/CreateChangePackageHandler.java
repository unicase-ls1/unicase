/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */

package org.unicase.changetracking.ui.commands;

import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.resources.IProject;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.ui.PlatformUI;
import org.unicase.changetracking.exceptions.VCSException;
import org.unicase.changetracking.ui.createChangePackage.CreateChangePackageWizard;
import org.unicase.changetracking.vcs.VCSAdapter;
import org.unicase.changetracking.vcs.VCSAdapterFactory;

/**
 * Handler for the "create change package" command.
 * 
 * @author jfinis
 * 
 */
public class CreateChangePackageHandler extends ResourceCommandHandler {

	/**
	 * Opens the "create change package" wizard after performing some
	 * pre-checks.
	 * 
	 * {@inheritDoc}
	 */
	public void doExecute(ExecutionEvent event) {
		

		// Retrieve selected project
		IProject[] projects = getSelectedProjects(event);
		if (projects.length == 0) {
			abort("No project selected.");
		}

		// Retrieve correspondent adapter
		VCSAdapter vcs;
		vcs = new VCSAdapterFactory().createFromProjects(projects);
	

		// Save dirty editors
		if (!PlatformUI.getWorkbench().saveAllEditors(true)) {
			return;
		}

		// Perform early checks (adapter dependent)
		String problem;
		try {
			problem = vcs.performEarlyCreateChangePackageChecks(projects);
			if (problem != null) {
				abort(problem);
			}
		} catch (VCSException e) {
			abortCausedByException(e);
		}

		// Open the create work item dialog
		WizardDialog dlg = new WizardDialog(PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell(), new CreateChangePackageWizard(vcs, projects));
		dlg.open();

	}

	

}
