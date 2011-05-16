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
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.swt.custom.BusyIndicator;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.WorkbenchException;
import org.unicase.changetracking.commands.ChangeTrackingCommand;
import org.unicase.changetracking.commands.ChangeTrackingCommandResult;
import org.unicase.metamodel.util.ModelUtil;
import org.unicase.ui.unicasecommon.common.util.UnicaseActionHelper;
import org.unicase.workspace.util.WorkspaceUtil;

public class UIUtil {

	private static final String UNICASE_PERSPECTIVE_ID = "org.unicase.ui.unicasecommon.common.UnicasePerspective";



	public static Shell getActiveShell(){
		return PlatformUI.getWorkbench().
		getActiveWorkbenchWindow().getShell();
	}
	
	public static void errorMessage(String caption, String message){
		MessageDialog.openError(
				getActiveShell(),
				caption,
				message);
	}
	
	public static void warningMessage(String caption, String message){
		MessageDialog.openWarning(
				getActiveShell(),
				caption,
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
	
	public static ChangeTrackingCommandResult runCommand(ChangeTrackingCommand command){
		//Execute command (with progress monitor if desired, otherwise barely)
		ChangeTrackingCommandResult result = null;
		if(command.needsProgressMonitor()){
			ProgressMonitorDialog progressMonitor = new ProgressMonitorDialog(PlatformUI.getWorkbench().
					getActiveWorkbenchWindow().getShell());
			try{
				progressMonitor.run(true, true, command);
				result = command.getCTResult();	
			} catch (RuntimeException e){
				handleException(e);
			} catch (InvocationTargetException e) {
				handleException(e.getCause());
			} catch (InterruptedException e) {
				handleException(e);
			}
		} else {
			
			result = command.run();
		}
		
		//Show status message
		if(result.getMessage() != null){
		switch(result.getResultType()){
			case CANCELLED:
				break;
			case ERROR:
				handleException(result.getException()); break;
			case SUCCESS:
				openInformation(result.getCaption(),result.getMessage()); break;
			case MISUSE:
				errorMessage(result.getCaption(),result.getMessage()); break;
			case WARNING:
				warningMessage(result.getCaption(),result.getMessage()); break;
			}
		}
		return result;
	}

	public static void handleException(Throwable e) {
		handleException(e.getMessage(), e);
		
	}
	
	
	public static void handleException(String message, Throwable e1) {
		errorMessage(message);
		ModelUtil.logException(e1);
	}
	
	public static void openUnicaseAndModelElement(EObject element) {
		UnicaseActionHelper.openModelElement(element, "changetracking");
		try {
			PlatformUI.getWorkbench().showPerspective(UNICASE_PERSPECTIVE_ID, PlatformUI.getWorkbench().getActiveWorkbenchWindow());
		} catch (WorkbenchException e) {
		}
	}

	public static void errorMessage(String message) {
		errorMessage("Error",message);
	}

	public static enum ProgressKind{
		DIALOG,BUSYCURSOR;
	}
	
	/**
	 * Runs a runnable either with a progress monitor or a busy cursor.
	 * @param runnable the runnable to run
	 * @param progressKind with cursor or dialog?
	 */
	 public static void run(final IRunnableWithProgress runnable, ProgressKind progressKind) {
		final Exception[] exceptions = new Exception[] {null};
		switch (progressKind) {
			case BUSYCURSOR :
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
			default :
			case DIALOG :
				try {
					new ProgressMonitorDialog(getActiveShell()).run(true, true, runnable);
				} catch (InvocationTargetException e) {
					exceptions[0] = e;
				} catch (InterruptedException e) {
					exceptions[0] = null;
				}
				break;
		}
		if (exceptions[0] != null) {
			WorkspaceUtil.logException("An exception has occurred", exceptions[0]);
		}
	}


}
