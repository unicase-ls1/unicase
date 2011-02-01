package org.unicase.changetracking.ui;

import java.lang.reflect.InvocationTargetException;

import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.dialogs.ProgressMonitorDialog;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.PlatformUI;
import org.unicase.metamodel.util.ModelUtil;

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
	
	public static void runProgressMonitorCommand(IRunnableWithProgress command, String successMessage){
		ProgressMonitorDialog progressMonitor = new ProgressMonitorDialog(PlatformUI.getWorkbench().
				getActiveWorkbenchWindow().getShell());
		try{
			progressMonitor.run(true, true, command);
			openInformation("Success!",
				successMessage);	
		} catch (RuntimeException e){
			handleException(e);
		} catch (InvocationTargetException e) {
			handleException(e.getCause());
		} catch (InterruptedException e) {
			handleException(e);
		}
	}

	private static void handleException(Throwable e) {
		errorMessage(e.getMessage());
		ModelUtil.logException(e);
	}
}
