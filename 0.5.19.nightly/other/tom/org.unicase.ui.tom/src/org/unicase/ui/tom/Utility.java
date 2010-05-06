/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.tom;

import org.eclipse.emf.transaction.RunnableWithResult;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;

/**
 * @author schroech
 *
 */
public final class Utility {

	private Utility(){
		super();
	}
	
	/**
	 * @param count Beep count.
	 */
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
	
	
	/**
	 * @return The active editor
	 */
	public static IEditorPart getActiveEditor(){
		IEditorPart editor = null; 

		RunnableWithResult<IEditorPart> runnableWithResult 
		= new RunnableWithResult.Impl<IEditorPart>(){
			public void run(){
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
