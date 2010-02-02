package org.unicase.codetrace.popup.actions;

import org.eclipse.jface.action.IAction;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.ui.IActionDelegate;
import org.eclipse.ui.IEditorActionDelegate;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IViewPart;
import org.unicase.model.trace.CodeLocation;


public class TestRetrieve implements IEditorActionDelegate  {

	private IEditorPart editorPart = null; 

	/**
	 * @see IActionDelegate#run(IAction)
	 */
	public void run(IAction action) {
		CodeLocation tl = AttachLocationAction.TEST_LOCATION;
/*
		if (tl == null){
			System.out.println("No location yet!");
			return;
		}
		IWorkbenchPage page = editorPart.getSite().getPage();
		IFile f = ResourcesPlugin.getWorkspace().getRoot().getProject(tl.projectName).getFile(tl.getPathInProject());
		if(f == null){
			System.out.println("File not found");
			return;
		}
		TaskLocationLoader.openTaskLocation(f, tl., page);
		System.out.println("RETRIEVE!");
		*/
		/*
		editorInput = editorPart.getEditorInput();
		ISelection selection = ((AbstractTextEditor) editorPart).getSelectionProvider().getSelection();
		
		int lineNumber = ((ITextSelection) selection).getStartLine();
		
		IResource resource = ResourceUtil.getResource(editorInput);
		HashMap attributes = new HashMap();
		
		MarkerUtilities.setLineNumber(attributes, lineNumber + 1);
		
		TracerFactory tf = TracerFactory.getInstance();
		
		
		TracerLocation tl = tf.createLocation(resource.getProject().getName(), resource.getProjectRelativePath().toString(), lineNumber+1);
	
		try {
			MarkerUtilities.createMarker(resource, attributes, "org.unicase.taskmarker");
		} catch (CoreException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		*/
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
