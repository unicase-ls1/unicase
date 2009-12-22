package org.unicase.codetrace.popup.actions;

import org.eclipse.jface.action.IAction;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IEditorActionDelegate;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IObjectActionDelegate;
import org.eclipse.ui.IViewActionDelegate;
import org.eclipse.ui.IViewPart;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.editors.text.TextEditor;

public class NewAction implements IEditorActionDelegate  {



	/**
	 * @see IActionDelegate#run(IAction)
	 */
	public void run(IAction action) {
		System.out.println("bla");
		
	}

	/**
	 * @see IActionDelegate#selectionChanged(IAction, ISelection)
	 */
	public void selectionChanged(IAction action, ISelection selection) {
	}

	public void init(IViewPart view) {
		// TODO Auto-generated method stub
		System.out.println("bla");
	}

	public void setActiveEditor(IAction action, IEditorPart targetEditor) {
		// TODO Auto-generated method stub
		System.out.println("bla");
		((TextEditor)targetEditor).getDocumentProvider().getDocument(null);
	}

}
