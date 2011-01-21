package org.unicase.changetracking.ui;

import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.PlatformUI;

public class UIUtil {

	public static Shell getActiveShell(){
		return PlatformUI.getWorkbench().
		getActiveWorkbenchWindow().getShell();
	}
	
	public static void errorMessage(String message){
		MessageDialog.openError(
				getActiveShell(),
				"Error",
				message);
	}
	
	public static boolean openQuestion(String title, String question) {
		return MessageDialog.openQuestion(getActiveShell(), title, question);
	}
	
	public static void openInformation(String title,String message){
		MessageDialog.openInformation(
				getActiveShell(),
				title, message);
	}
	
	public static boolean askForRefreshing() {
		boolean wantPull = MessageDialog.openQuestion(getActiveShell(), "Refresh local repository?", "You should refresh your local repository (pull from remote) to ensure that all branches are up to date. Do you want to pull now?");
	
		//FIXME Implement pull
		
		return wantPull;
	}
}
