package org.unicase.codetrace.popup.actions;

import java.util.HashMap;

import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.ui.IEditorActionDelegate;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorPart;

import org.eclipse.ui.IViewPart;

import org.eclipse.ui.ide.ResourceUtil;
import org.eclipse.ui.texteditor.MarkerUtilities;


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
		IEditorInput editorInput = targetEditor.getEditorInput();
		IResource resource = ResourceUtil.getResource(editorInput);
		HashMap attributes = new HashMap();
		int lineNumber = 2;
		//TODO how to get the line number from the action?
		MarkerUtilities.setLineNumber(attributes, lineNumber);
	
		try {
			MarkerUtilities.createMarker(resource, attributes, "org.unicase.taskmarker");
		} catch (CoreException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//((TextEditor)targetEditor).getDocumentProvider().getDocument(null);
	}

}
