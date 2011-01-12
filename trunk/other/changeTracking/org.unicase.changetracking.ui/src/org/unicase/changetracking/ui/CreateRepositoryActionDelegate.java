package org.unicase.changetracking.ui;

import org.eclipse.core.resources.IResource;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.dialogs.IInputValidator;
import org.eclipse.jface.dialogs.InputDialog;
import org.eclipse.jface.window.Window;
import org.eclipse.jgit.lib.Repository;
import org.eclipse.swt.widgets.Display;
import org.unicase.changetracking.git.GitUtil;
import org.unicase.metamodel.Project;
import org.unicase.model.changetracking.git.GitRepository;
import org.unicase.workspace.util.UnicaseCommand;

public class CreateRepositoryActionDelegate extends ResourceSelectionActionDelegate {


	public GitRepository createRepository(Repository repo, final Project project){
		
		InputDialog dlg = new InputDialog(Display.getCurrent().getActiveShell(),
             "Repository Remote URL", "Enter the URL of the remote repository which should be associated with this local repository.", "", new InputValidator());
 		dlg.setBlockOnOpen(true);
 		dlg.open();
 		if(dlg.getReturnCode() != Window.OK){
 			return null;
 		}
 		String url = dlg.getValue();
	 		
		
		final GitRepository gitRepoModel = GitUtil.initGitRepoModelFromRepo(repo);
		gitRepoModel.setUrl(url);
		gitRepoModel.setName(url);
		new UnicaseCommand() {
			@Override
			protected void doRun() {
				project.addModelElement(gitRepoModel);
			}
		}.run(false);
		
		return gitRepoModel;
	}
	
	@Override
	public void run(IAction action) {
		IResource[] resources = getSelectedResources();
		if(resources.length == 0){
			return;
		}
		
		errorMessage("not possible yet!");

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
	    if (len < 1) return "Enter a valid git url";

	    // Input must be OK
	    return null;
	  }
	}


}
