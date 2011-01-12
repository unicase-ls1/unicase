package org.unicase.changetracking.ui;

import org.eclipse.core.resources.IResource;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.dialogs.IInputValidator;
import org.eclipse.jface.dialogs.InputDialog;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.window.Window;
import org.eclipse.jgit.lib.Repository;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.PlatformUI;
import org.unicase.changetracking.git.GitRepoFindUtil;
import org.unicase.changetracking.git.commands.GitCreateChangePackage;
import org.unicase.changetracking.ui.dialogs.AttacheeSelectionDialog;
import org.unicase.metamodel.Project;
import org.unicase.model.UnicaseModelElement;
import org.unicase.model.changetracking.git.GitRepository;
import org.unicase.model.task.WorkItem;

public class CreateChangePackageActionDelegate extends ResourceSelectionActionDelegate {


	@Override
	public void run(IAction action) {
	
		IResource[] resources = getSelectedResources();
		if(resources.length == 0){
			return;
		}
		
		//TODO Make this generic, so the dependency to the git plugin can be removed
		//Get the git repo the resource belongs to
		Repository repo = GitRepoFindUtil.findRepository(resources[0].getLocation().toFile());
		if(repo == null){
			errorMessage("The selected resource is not under git version control.");
			return;
		}
		
		//Let user choose a name for the change package
		InputDialog dlg = new InputDialog(Display.getCurrent().getActiveShell(),
             "Choose change package name", "Choose a name for the change package. The name should be unique for the git repository.", "", new InputValidator());
 		dlg.setBlockOnOpen(true);
 		dlg.open();
 		if(dlg.getReturnCode() != Window.OK){
 			return;
 		}
 		String name = dlg.getValue();
 		
		
		//Let user select a work item to attach the change package to
		AttacheeSelectionDialog attacheeDialog = new AttacheeSelectionDialog();
		attacheeDialog.setBlockOnOpen(true);
		attacheeDialog.open();
		if(attacheeDialog.getReturnCode() != Window.OK){
			return;
		}
		
		
		//Get project and check that there is a corresponding remote repository
		final Project p = attacheeDialog.getSelectedProjectSpace().getProject();

		GitRepository repoModel;
		if(!GitRepoFindUtil.hasProjectRemote(repo, p)){
			boolean wantCreate = MessageDialog.openConfirm(PlatformUI.getWorkbench().
					getActiveWorkbenchWindow().getShell(), "Create remote repository?", "The selected project does not contain any remote git repository matching your local repository. Do you want to create one?");

			if(wantCreate){
				//User wants to create the repo. Do that and then go on with this action
				repoModel = new CreateRepositoryActionDelegate().createRepository(repo, p);
			} else {
				//User does not want to create a repo. Abort this command.
				return;
			}
		} else {
			repoModel = GitRepoFindUtil.findRemoteInProject(repo, p);
		}
		
		//Retrieve or create selected model element from the dialog
		UnicaseModelElement attachTo = attacheeDialog.getOrCreateSelectedModelElement();
		
		
		new GitCreateChangePackage(resources[0], name, (WorkItem) attachTo,repoModel ).run(false);

		MessageDialog.openInformation(
				PlatformUI.getWorkbench().
				getActiveWorkbenchWindow().getShell(),
				"Success!",
				"Change package was created successfully.");
	}
			


	
	/**
	 * This class validates a String. It makes sure that the String is between 5 and 8
	 * characters
	 */
	class InputValidator implements IInputValidator {
	  /**
	   * Validates the String. Returns null for no error, or an error message
	   * 
	   * @param newText the String to validate
	   * @return String
	   */
	  public String isValid(String newText) {
	    int len = newText.length();

	    // Determine if input is too short or too long
	    if (len < 1) return "Enter a name";

	    // Input must be OK
	    return null;
	  }
	}


}
