package org.unicase.ui.tom;

import org.eclipse.emf.transaction.RunnableWithResult;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;

public class Utility {

	public static void beep(int count) {
		for (int i = 0; i < count; i++) {
			final Display current = Display.getDefault();
			if (current != null) {
				current.syncExec(new Runnable(){
					public void run() {
						current.beep();						
					}
				});
			}
		}
	}
	
	
	public static IEditorPart getActiveEditor(){
		IEditorPart editor = null; 

		RunnableWithResult<IEditorPart> runnableWithResult 
		= new RunnableWithResult.Impl<IEditorPart>(){
			public void run(){
				try {
					IWorkbench workbench = PlatformUI.getWorkbench();
					if (workbench == null) {
						return;
					}
					IWorkbenchWindow activeWorkbenchWindow = workbench.getActiveWorkbenchWindow();
					if (activeWorkbenchWindow == null) {
						return;
					}
					IWorkbenchPage activePage = activeWorkbenchWindow.getActivePage();
					if (activePage == null) {
						return;
					}
					IEditorPart activeEditor = activePage.getActiveEditor();
					if (activeEditor == null) {
						return;
					}
					setResult(activeEditor);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		};

		final Display current = Display.getDefault();
		if (current != null) {
			current.syncExec(runnableWithResult);
		}

		editor = runnableWithResult.getResult();

		return editor;
	}


}
