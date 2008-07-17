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
		showExceptionDialog("Unexpected exception occured", e);
	}

	/**
	 * This method opens a standard error dialog displaying an exception to the
	 * user.
	 * 
	 * @param e
	 *            the exception to be shown.
	 */
	public static void showExceptionDialog(String message) {
		showExceptionDialog(message, null);
	}

	/**
	 * This method opens a standard error dialog displaying an exception to the
	 * user.
	 * 
	 * @param cause
	 *            the exception to be shown.
	 */
	public static void showExceptionDialog(String message, Exception cause) {
		Shell shell = PlatformUI.getWorkbench().getActiveWorkbenchWindow()
				.getShell();
		IStatus status = null;
		if (cause instanceof CoreException) {
			status = ((CoreException) cause).getStatus();
		}
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append(message);
		if (cause != null) {
			stringBuilder.append(": ");
			stringBuilder.append(cause.getMessage());
		}
		String string = stringBuilder.toString();
		ErrorDialog.openError(shell, "Error", string, status);
	}

}
