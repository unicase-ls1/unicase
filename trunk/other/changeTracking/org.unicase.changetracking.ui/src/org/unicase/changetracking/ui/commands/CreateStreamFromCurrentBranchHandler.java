/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */

package org.unicase.changetracking.ui.commands;

import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IProject;
import org.eclipse.ui.PlatformUI;
import org.unicase.changetracking.commands.ChangeTrackingCommandResult;
import org.unicase.changetracking.commands.ChangeTrackingCommandResult.Result;
import org.unicase.changetracking.commands.CreateStreamCommand;
import org.unicase.changetracking.ui.UIDecisionProvider;
import org.unicase.changetracking.ui.UIUtil;
import org.unicase.changetracking.vcs.VCSAdapter;
import org.unicase.changetracking.vcs.VCSAdapterFactory;

public class CreateStreamFromCurrentBranchHandler extends ResourceCommandHandler {
	

	/**
	 * . {@inheritDoc}
	 */
	public Object execute(ExecutionEvent event) throws ExecutionException {

		IProject[] projects = getSelectedProjects(event);
		if(projects.length == 0){
			UIUtil.errorMessage("Error","No project selected.");
			return null;
		}
	
		//Save dirty editors
		if(!PlatformUI.getWorkbench().saveAllEditors(true)){
			return null;
		}
		
		IProject project = projects[0];
		
		VCSAdapter vcs = new VCSAdapterFactory().createFromProject(project);
		
		CreateStreamCommand cmd = vcs.createStreamFromCurrentBranch(new UIDecisionProvider(), project);
		ChangeTrackingCommandResult result = UIUtil.runCommand(cmd);

		//Finally, open the stream in the unicase perspective
		if(result.getResult() == Result.SUCCESS){
			UIUtil.openUnicaseAndModelElement(cmd.getCreatedStream());
		}
		
		return null;
		
	}

	

}
