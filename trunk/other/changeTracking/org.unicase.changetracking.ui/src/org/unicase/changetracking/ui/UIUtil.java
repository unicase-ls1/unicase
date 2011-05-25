/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.changetracking.ui;

import java.lang.reflect.InvocationTargetException;

import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.dialogs.ProgressMonitorDialog;
import org.eclipse.swt.custom.BusyIndicator;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.WorkbenchException;
import org.unicase.changetracking.commands.ChangeTrackingCommand;
import org.unicase.changetracking.commands.ChangeTrackingCommandResult;
import org.unicase.changetracking.commands.IUserInterfaceRunnable;
import org.unicase.metamodel.util.ModelUtil;
import org.unicase.ui.unicasecommon.common.util.UnicaseActionHelper;

/**
 * Utility class for user interface utility methods.
 * 
 * @author jfinis
 * 
 */
public final class UIUtil {

	/**
	 * Id of the unicase perspective for opening it.
	 */
	private static final String UNICASE_PERSPECTIVE_ID = "org.unicase.ui.unicasecommon.common.UnicasePerspective";

	/**
	 * Utility class.
	 */
	private UIUtil() {}

	/**
	 * Retrieves the currently active shell.
	 * 
	 * @return active shell.
	 */
	public static Shell getActiveShell() {
		IWorkbenchWindow w = PlatformUI.getWorkbench().getActiveWorkbenchWindow();
		if(w == null){
			throw new RuntimeException("Calling getActiveShell from non-UI thread.");
		}
		return w.getShell();
	}

	/**
	 * Shows an error message in a message dialog box.
	 * 
	 * @param caption dialog box caption
	 * @param message error message
	 */
	public static void errorMessage(String caption, String message) {
		MessageDialog.openError(getActiveShell(), caption, message);
	}

	/**
	 * Shows a warning message in a message dialog box.
	 * 
	 * @param caption dialog box caption
	 * @param message warning message
	 */
	public static void warningMessage(String caption, String message) {
		MessageDialog.openWarning(getActiveShell(), caption, message);
	}

	/**
	 * Shows a YES/NO question in a dialog box and returns the user's decision.
	 * 
	 * @param title title of the dialog box
	 * @param question question
	 * @return true if user pressed YES, false if user pressed NO or cancelled
	 *         the dialog
	 */
	public static boolean openQuestion(String title, String question) {
		return MessageDialog.openQuestion(getActiveShell(), title, question);
	}

	/**
	 * Opens an information dialog.
	 * 
	 * @param title dialog title
	 * @param message dialog message
	 */
	public static void openInformation(String title, String message) {
		MessageDialog.openInformation(getActiveShell(), title, message);
	}

	/**
	 * Asks the user (using a dialog) whether the local repository should be
	 * refreshed.
	 * 
	 * @return true if user wants refreshing, otherwise false
	 */
	public static boolean askForRefreshing() {
		final boolean[] wantPull = new boolean[1];
		Display.getDefault().syncExec(new Runnable() {
			
			public void run() {
				wantPull[0] = MessageDialog.openQuestion(getActiveShell(), "Refresh local repository?", "You should refresh your local repository (pull from remote) to ensure that all branches are up to date. Do you want to pull now?");
				
			}
		});
		return wantPull[0];
	}

	/**
	 * Runs a change tracking command.
	 * 
	 * If the command states that it needs a progress monitor
	 * (command.needsProgressMonitor() == true), then the command will be run in
	 * a progess monitor. Othwerwise, the command is run barely.
	 * 
	 * After the execution, an action is executed, depending on the result: - If
	 * the result is ERROR, an error message dialog is shown and the error is
	 * added to the error log. - If the result is CANCEL, nothing is done - If
	 * the result is SUCCESS, a success message dialog is shown if the message
	 * in the command result is not null. If it is null, nothing is done. - If
	 * the result is MISUSE, an error message dialog is shown - If the result is
	 * WARNING, a warning dialog is shown
	 * 
	 * 
	 * @param command command to be executed
	 * @return result of the execution
	 */
	public static ChangeTrackingCommandResult runCommand(ChangeTrackingCommand command) {
		// Execute command and get result
		ChangeTrackingCommandResult result = null;
		run(command);
		result = command.getCTResult();

		// Show status message
		switch (result.getResultType()) {
		case CANCELLED:
			break;
		case ERROR:
			handleException(result.getException());
			break;
		case SUCCESS:
			if (result.getMessage() != null) {
				openInformation(result.getCaption(), result.getMessage());
			}
			break;
		case MISUSE:
			errorMessage(result.getCaption(), result.getMessage());
			break;
		case WARNING:
			warningMessage(result.getCaption(), result.getMessage());
			break;
		default:
			break;
		}
	
		return result;
	}

	/**
	 * Handles an exception. This means that an error message dialog with the
	 * exception's message is shown and the exception is added to the error log.
	 * 
	 * @param e exception to be handled.
	 */
	public static void handleException(Throwable e) {
		String message = e.getMessage();
		if(message == null || message.equals("")){
			message = e.getClass().getName();
		}
		handleException(message, e);
	}

	/**
	 * Handles an exception. This means that an error message dialog is shown
	 * and the exception is added to the error log.
	 * 
	 * @param e1 exception to be handled.
	 * @param message message to be shown in the error dialog
	 */
	public static void handleException(String message, Throwable e1) {
		errorMessage(message);
		ModelUtil.logException(e1);
	}

	/**
	 * Opens a unicase model element in the model element editor and switches to
	 * the Unicase perspective.
	 * 
	 * @param element model element to be opened
	 */
	public static void openUnicaseAndModelElement(EObject element) {
		UnicaseActionHelper.openModelElement(element, "changetracking");
		try {
			PlatformUI.getWorkbench().showPerspective(UNICASE_PERSPECTIVE_ID, PlatformUI.getWorkbench().getActiveWorkbenchWindow());
		} catch (WorkbenchException e) {}
	}

	/**
	 * Shows an error message dialog.
	 * 
	 * @param message error message to be displayed
	 */
	public static void errorMessage(String message) {
		errorMessage("Error", message);
	}

	/**
	 * Runs a runnable either with a progress display according to the
	 * runnable's preferred display king.
	 * 
	 * @param runnable the runnable to run
	 */
	public static void run(final IUserInterfaceRunnable runnable) {
		final Exception[] exceptions = new Exception[] { null };
		try{
		switch (runnable.getPreferredProgressDisplayKind()) {
		case BUSY_CURSOR:
			BusyIndicator.showWhile(Display.getCurrent(), new Runnable() {
				public void run() {
					try {
						runnable.run(new NullProgressMonitor());
					} catch (InvocationTargetException e) {
						exceptions[0] = e;
					} catch (InterruptedException e) {
						exceptions[0] = null;
					}
				}
			});
			break;
		case PROGRESS_MONITOR:
			try {
				new ProgressMonitorDialog(getActiveShell()).run(true, true, runnable);
			} catch (InvocationTargetException e) {
				exceptions[0] = e;
			} catch (InterruptedException e) {
				exceptions[0] = null;
			}
			break;
		case NONE:
			try {
				runnable.run(new NullProgressMonitor());
			} catch (InvocationTargetException e) {
				exceptions[0] = e;
			} catch (InterruptedException e) {
				exceptions[0] = null;
			}
			break;
		default:
			break;
		}
		} catch (RuntimeException e){
			exceptions[0] = e;
		}
		if (exceptions[0] != null) {
			handleException("An exception has occurred", exceptions[0]);
		}
	}

}
