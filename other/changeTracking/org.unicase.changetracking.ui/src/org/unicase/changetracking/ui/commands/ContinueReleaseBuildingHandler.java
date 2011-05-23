/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */

package org.unicase.changetracking.ui.commands;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.ui.PlatformUI;
import org.unicase.changetracking.commands.BuildReleaseCommand;
import org.unicase.changetracking.ui.Activator;
import org.unicase.changetracking.ui.UIUtil;
import org.unicase.changetracking.ui.releases.BuildReleaseOperation;

/**
 * Handler for the "continue release building" command.
 * 
 * @author jfinis
 * 
 */
public class ContinueReleaseBuildingHandler extends AbstractHandler {

	/**
	 * Continues the building of a release after a conflict has been resolved.
	 * 
	 * {@inheritDoc}
	 */
	public Object execute(ExecutionEvent event) throws ExecutionException {

		// Save dirty editors
		if (!PlatformUI.getWorkbench().saveAllEditors(true)) {
			return null;
		}

		// Retrieve the last conflicting command
		BuildReleaseCommand command = Activator.getLastConflictingCommand();
		if (command == null) {
			UIUtil.errorMessage("You are currently not building a release or you have restarted eclipse since your last build. Restart the build process.");
			return null;
		}

		// continue the release building
		new BuildReleaseOperation(command, true).run();
		return null;
	}

}
