/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */

package org.unicase.changetracking.ui.handlers;

import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.ui.PlatformUI;
import org.unicase.changetracking.commands.BuildReleaseCommand;
import org.unicase.changetracking.ui.Activator;
import org.unicase.changetracking.ui.BuildReleaseOperation;

/**
 * Handler for the "continue release building" command.
 * 
 * @author jfinis
 * 
 */
public class ContinueReleaseBuildingHandler extends ChangeTrackingCommandHandler {


	@Override
	public void setEnabled(Object evaluationContext) {
		//Command is only enabled if there is a conflicting command
		setBaseEnabled(Activator.getLastConflictingCommand() != null);
	}
	
	/**
	 * Continues the building of a release after a conflict has been resolved.
	 * 
	 * {@inheritDoc}
	 */
	public void doExecute(ExecutionEvent event) {

		// Save dirty editors
		if (!PlatformUI.getWorkbench().saveAllEditors(true)) {
			return;
		}

		// Retrieve the last conflicting command
		BuildReleaseCommand command = Activator.getLastConflictingCommand();
		if (command == null) {
			abort("You are currently not building a release or you have restarted eclipse since your last build. Restart the build process.");
		}

		// continue the release building
		new BuildReleaseOperation(command, true).run();
	}

}
