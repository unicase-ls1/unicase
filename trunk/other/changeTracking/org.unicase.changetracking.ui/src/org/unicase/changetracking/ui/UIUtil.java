package org.unicase.changetracking.ui;

import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.ui.PlatformUI;

public class UIUtil {

	public static void errorMessage(String message){
		MessageDialog.openError(
				PlatformUI.getWorkbench().
				getActiveWorkbenchWindow().getShell(),
				"Error",
				message);
	}
}
