package org.unicase.changetracking.ui.releases;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IResource;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.dialogs.IInputValidator;
import org.eclipse.jface.dialogs.InputDialog;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.window.Window;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.jgit.lib.Repository;
import org.eclipse.jgit.lib.RepositoryState;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.PlatformUI;
import org.unicase.changetracking.git.GitRepoFindUtil;
import org.unicase.changetracking.git.commands.GitBuildReleaseCommand;
import org.unicase.changetracking.git.commands.GitCreateChangePackageCommand;
import org.unicase.changetracking.git.exceptions.UnexpectedGitException;
import org.unicase.changetracking.ui.CreateRepoLocationAction;
import org.unicase.changetracking.ui.ResourceSelectionActionDelegate;
import org.unicase.changetracking.ui.UIUtil;
import org.unicase.changetracking.ui.dialogs.AttacheeSelectionDialog;
import org.unicase.changetracking.ui.releases.BuildReleaseWizard;
import org.unicase.metamodel.Project;
import org.unicase.metamodel.util.ModelUtil;
import org.unicase.model.UnicaseModelElement;
import org.unicase.model.changetracking.git.GitRepository;
import org.unicase.model.task.WorkItem;

public class ContinueReleaseBuildActionDelegate extends ResourceSelectionActionDelegate {


	@Override
	public void run(IAction action) {
	
		//Save dirty editors
		if(!PlatformUI.getWorkbench().saveAllEditors(true)){
			return;
		}
		
		//Get the git repo the resource belongs to
		
		GitBuildReleaseCommand command = GitBuildReleaseCommand.getLastConflictingCommand();
		
		if(command == null){
			errorMessage("You are currently not building a release or you have restarted eclipse since your last build. Restart the build process.");
			return;
		}
		
		Repository localRepo = command.getLocalRepo();
		
		
		if(RepositoryState.MERGING_RESOLVED != localRepo.getRepositoryState()){
			if(RepositoryState.MERGING == localRepo.getRepositoryState()){
				errorMessage("Local repository still contains unresolved changes. Resolve these and add the conflicting files afterwards");
			} else {
				errorMessage("Local repository is in an invalid state. Have you commited the conflict merge by hand? If so, restart building the release.");
			}
			return;
		}
		
		new BuildReleaseOperation(command,true).run();
		
	}



}
