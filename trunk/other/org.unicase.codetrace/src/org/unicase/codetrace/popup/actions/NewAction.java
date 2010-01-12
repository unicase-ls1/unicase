package org.unicase.codetrace.popup.actions;

import java.util.HashMap;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.text.ITextSelection;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.ui.IEditorActionDelegate;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IViewPart;
import org.eclipse.ui.ide.ResourceUtil;
import org.eclipse.ui.texteditor.AbstractTextEditor;
import org.eclipse.ui.texteditor.MarkerUtilities;


public class NewAction implements IEditorActionDelegate  {

	private IEditorPart editorPart = null; 

	/**
	 * @see IActionDelegate#run(IAction)
	 */
	public void run(IAction action) {
		
		IEditorInput editorInput = editorPart.getEditorInput();
		ISelection selection = ((AbstractTextEditor) editorPart).getSelectionProvider().getSelection();
		
		int lineNumber = ((ITextSelection) selection).getStartLine();
		
		IResource resource = ResourceUtil.getResource(editorInput);
		HashMap attributes = new HashMap();
		
		MarkerUtilities.setLineNumber(attributes, lineNumber + 1);
	
		try {
			MarkerUtilities.createMarker(resource, attributes, "org.unicase.taskmarker");
		} catch (CoreException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
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
		this.editorPart = targetEditor;
		
		// TODO Auto-generated method stub
		System.out.println("bla");
	
		
		//((TextEditor)targetEditor).getDocumentProvider().getDocument(null);
	}

}
