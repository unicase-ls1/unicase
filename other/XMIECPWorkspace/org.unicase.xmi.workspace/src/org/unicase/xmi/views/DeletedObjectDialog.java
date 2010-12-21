package org.unicase.xmi.views;


import org.eclipse.jface.dialogs.MessageDialog;

public class DeletedObjectDialog {
	
	/**
	 * Determines whether the lost object was a file or folder.
	 */
	private boolean isFolder = false;

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
	 * @param isFolder True when the object is a folder, else false.
	 * @param failedPath The path where the file/folder used to be.
	 */
	public DeletedObjectDialog(boolean isFolder, String failedPath) {
		// set the title of the dialog
		String title = "WARNING - ";
		if(isFolder) title += "Folder ";
		else title += "File ";
		title += "not found!";

		// set the message of the dialog
		String message = "\"" + failedPath  + "\" not found. What would you like to do? Would you like to remove it from workspace, import it or create it?";
		
		dialog = new MessageDialog(null, title, null, message, MessageDialog.WARNING, createButtons(), 0);
		result = dialog.open();
	}

	/**
	 * Creates the buttons of the dialog.
	 */
	private String[] createButtons() {
		String[] buttons;
		/* add options for user
		 * - in case of file:
		 *    - remove project from workspace
		 *    - import file
		 *    - new project 
		 * - in case of folder:
		 *    - remove folder form workspace
		 *    - new folder or import if existent
		 */
		
		if(isFolder) {
			// case FOLDER
			buttons = new String[] {"Remove", "New/Import"};
		}
		else {
			// case FILE
			buttons = new String[] {"Remove", "Import", "New"};
		}
		
		return buttons;
	}
	
	/**
	 * Returns the <em>result of the message-call</em>.
	 * @return The integer that is returned stands for one of the following results:<br />
	 *  1 = remove object from workspace<br />
	 *  2 = import file<br />
	 *  3 = new/import folder<br />
	 *  4 = new file<br />
	 */
	public int getResult() {
		// mapping
		int res;
		
		if(isFolder) {
			switch(result) {
				case 1: res = 3; break;
				default: res = 1; break;
			}
		}
		else {
			switch(result) {
			case 1: res = 2; break;
			case 2: res = 4; break;
			default: res = 1; break;
			}
		}
		
		return res;
	}
}
