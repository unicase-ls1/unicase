package org.unicase.ui.common.exceptions;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.jface.dialogs.ErrorDialog;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.PlatformUI;

/**
 * This abstract calls is to show exceptions to the user in a unified way.
 * 
 * @author helming
 * 
 */
public abstract class ExceptionDialogHandler {
	/**
	 * This method opens a standard error dialog displaying an exception to the
	 * user.
	 * 
	 * @param e
	 *            the exception to be shown.
	 */
	public static void showExceptionDialog(Exception e) {
		Shell shell = PlatformUI.getWorkbench().getActiveWorkbenchWindow()
				.getShell();
		IStatus status = null;
		if (e instanceof CoreException) {
			status = ((CoreException) e).getStatus();
		}
		ErrorDialog.openError(shell, "Error", e.getMessage(), status);
	}
}
