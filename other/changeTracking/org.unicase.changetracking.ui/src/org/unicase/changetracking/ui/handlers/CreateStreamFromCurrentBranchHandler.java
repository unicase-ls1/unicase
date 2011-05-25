/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */

package org.unicase.changetracking.ui.handlers;

import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.resources.IProject;
import org.eclipse.ui.PlatformUI;
import org.unicase.changetracking.commands.ChangeTrackingCommandResult;
import org.unicase.changetracking.commands.CreateStreamCommand;
import org.unicase.changetracking.commands.ChangeTrackingCommandResult.ResultType;
import org.unicase.changetracking.ui.UIDecisionProvider;
import org.unicase.changetracking.ui.UIUtil;
import org.unicase.changetracking.vcs.IVCSAdapter;
import org.unicase.changetracking.vcs.VCSAdapterFactory;

/**
 * Handler for the "create stream from current branch" command.
 * 
 * @author jfinis
 * 
 */
public class CreateStreamFromCurrentBranchHandler extends ResourceCommandHandler {

	/**
	 * Creates the stream and opens it in the unicase perspective.
	 * 
	 * {@inheritDoc}
	 */
	public void doExecute(ExecutionEvent event) {

		// Get selected project
		IProject[] projects = getSelectedProjects(event);
		if (projects.length == 0) {
			abort("No project selected.");
		}

		// Save dirty editors
		if (!PlatformUI.getWorkbench().saveAllEditors(true)) {
			return;
		}

		// Retrieve correspondent adapter
		IVCSAdapter vcs = new VCSAdapterFactory().createFromProjects(projects);

		// Create the stream
		CreateStreamCommand cmd = vcs.createStreamFromCurrentBranch(new UIDecisionProvider(), projects[0]);
		ChangeTrackingCommandResult result = UIUtil.runCommand(cmd);

		// Finally, open the stream in the unicase perspective
		if (result.getResultType() == ResultType.SUCCESS) {
			UIUtil.openUnicaseAndModelElement(cmd.getCreatedStream());
		}


	}

}
