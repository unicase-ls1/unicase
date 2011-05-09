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
import org.unicase.changetracking.commands.ChangeTrackingCommandResult;
import org.unicase.changetracking.ui.Activator;
import org.unicase.changetracking.ui.UIUtil;
import org.unicase.changetracking.ui.releases.BuildReleaseOperation;

public class ContinueReleaseBuildingHandler extends AbstractHandler {
	

	/**
	 * . {@inheritDoc}
	 */
	public Object execute(ExecutionEvent event) throws ExecutionException {

		
		//Save dirty editors
		if(!PlatformUI.getWorkbench().saveAllEditors(true)){
			return null;
		}
		
		//Get the git repo the resource belongs to
		
		BuildReleaseCommand command = Activator.getLastConflictingCommand();
		
		if(command == null){
			UIUtil.errorMessage("You are currently not building a release or you have restarted eclipse since your last build. Restart the build process.");
			return null;
		}
		
		ChangeTrackingCommandResult result = new BuildReleaseOperation(command,true).run();
		return null;
	}

	

}
