package org.unicase.ui.tom;

import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.Viewport;
import org.eclipse.emf.transaction.RunnableWithResult;
import org.eclipse.gef.GraphicalEditPart;
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
					IWorkbenchWindow activeWorkbenchWindow = workbench.getActiveWorkbenchWindow();
					IWorkbenchPage activePage = activeWorkbenchWindow.getActivePage();
					IEditorPart activeEditor = activePage.getActiveEditor();
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
