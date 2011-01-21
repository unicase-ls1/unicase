package org.unicase.changetracking.ui.createChangePackage;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IResource;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.dialogs.IInputValidator;
import org.eclipse.jface.dialogs.InputDialog;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.window.Window;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.jgit.lib.Repository;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.PlatformUI;
import org.unicase.changetracking.git.GitRepoFindUtil;
import org.unicase.changetracking.git.commands.GitCreateChangePackageCommand;
import org.unicase.changetracking.ui.CreateRepositoryActionDelegate;
import org.unicase.changetracking.ui.ResourceSelectionActionDelegate;
import org.unicase.changetracking.ui.dialogs.AttacheeSelectionDialog;
import org.unicase.changetracking.ui.releases.BuildReleaseWizard;
import org.unicase.metamodel.Project;
import org.unicase.metamodel.util.ModelUtil;
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
		String version = System.getProperty("java.version");
	    System.out.println("JDK version "+ version + " found");
		
		
		//TODO Make this generic, so the dependency to the git plugin can be removed
		//Get the git repo the resource belongs to
		Repository repo = GitRepoFindUtil.findRepository(resources[0].getLocation().toFile());
		if(repo == null){
			errorMessage("The selected resource is not under git version control.");
			return;
		}
		
		if(!repo.getRepositoryState().canCommit()){
			errorMessage("The repository is in a state which disallows committing");
			return;
		}
		
		try{
			WizardDialog dlg = new WizardDialog(PlatformUI.getWorkbench().
					getActiveWorkbenchWindow().getShell(), new CreateChangePackageWizard(repo));
		    dlg.open();
		} catch (Throwable t){
			ModelUtil.logException(t);
			return;
		}
		
	}
			


//	
//	/**
//	 * This class validates a String. It makes sure that the String is between 5 and 8
//	 * characters
//	 */
//	class InputValidator implements IInputValidator {
//	  /**
//	   * Validates the String. Returns null for no error, or an error message
//	   * 
//	   * @param newText the String to validate
//	   * @return String
//	   */
//	  public String isValid(String newText) {
//	    int len = newText.length();
//
//	    // Determine if input is too short or too long
//	    if (len < 1) return "Enter a name";
//
//	    // Input must be OK
//	    return null;
//	  }
//	}


}
