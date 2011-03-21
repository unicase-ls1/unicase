package org.unicase.changetracking.git.ui;

import org.eclipse.jface.dialogs.IInputValidator;
import org.eclipse.jface.dialogs.InputDialog;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.widgets.Display;
import org.unicase.changetracking.exceptions.CancelledByUserException;


public class RemoteURLInput {
	//TODO: Decouple ui?
	public String show() throws CancelledByUserException{
		
			InputDialog dlg = new InputDialog(Display.getCurrent().getActiveShell(),
	             "Repository Remote URL", "Enter the URL of the remote repository which should be associated with this local repository.", "", new InputValidator());
	 		dlg.setBlockOnOpen(true);
	 		dlg.open();
	 		if(dlg.getReturnCode() != Window.OK){
	 			throw new CancelledByUserException();
	 		}
	 		String url = dlg.getValue();
	 		return url;
			
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
