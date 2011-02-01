package org.unicase.xmi.views;

import org.eclipse.jface.dialogs.MessageDialog;
import org.unicase.xmi.workspace.XmiUtil.PROJECT_STATUS;

/**
 * This dialog shows up if the user clicks on "Resolve" when the project's status is "failed" or "duplicated".
 * @author matti, markus
 *
 */
public class DeletedObjectDialog {
	/**
	 * The dialog that's being displayed.
	 */
	private MessageDialog dialog;

	/**
	 * Saves the result of the dialog.
	 */
	private int result;
	
	/**
	 * Creates a Dialog where the user is asked what to do if the path or folder at the given location does not exist.
	 * @param status The current status of the project.
	 * @param failedPath The path where the file/folder used to be.
	 */
	public DeletedObjectDialog(PROJECT_STATUS status, String failedPath) {
		
		// set the title and the message of the dialog
		String title, message;
		
		if(status == PROJECT_STATUS.FAILED) {
			// set the title and message in case the file underneath the project cannot be found.
			title = "WARNING - ";
			title += "File ";
			title += "not found!";
	
			message = "\"" + failedPath  + "\" not found.";
			message += "What would you like to do? ";
			message += "Would you like to remove it from the workspace, import or create it?";
		}
		else {
			// set the title and message in case the project is duplicated
			title = "WARNING - Projectfile already in use!";
			message = "What would you like to do? ";
			message += "Would you like to remove it from the workspace, import another file or create a new file?";
		}
		
		dialog = new MessageDialog(null, title, null, message, MessageDialog.WARNING, createButtons(), 0);
		result = dialog.open();
	}

	/**
	 * Creates the buttons of the dialog.
	 */
	private String[] createButtons() {
		/* add options for user
		 *    - remove project from workspace
		 *    - import file from filesystem/workspace
		 *    - new project 
		 */
		String[] buttons = new String[] {
				"Remove", "Import from Filesystem", "Import from Workspace", "New"
			};
		
		return buttons;
	}
	
	/**
	 * Returns the <em>result of the message-call</em>.
	 * @return The integer that is returned stands for one of the following results:<br />
	 *  1 = remove object from workspace<br />
	 *  2 = import file from filesystem<br />
	 *  4 = new file<br />
	 *  5 = import file from workspace<br />
	 */
	public int getResult() {		
		int res;
		
		/*
		 * The reason why number 3 was left out is because the folder was
		 * completely removed from the workspace structure model.
		 */
		
		// mapping
		switch(result) {
			case 0: res = 1; break;
			case 1: res = 2; break;
			case 2: res = 5; break;
			case 3: res = 4; break;
			default: res = 0; break;
		}
		
		return res;
	}
}
