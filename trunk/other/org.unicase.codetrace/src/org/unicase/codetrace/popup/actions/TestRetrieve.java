package org.unicase.codetrace.popup.actions;

import java.util.HashMap;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.text.ITextSelection;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.ui.IEditorActionDelegate;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IViewActionDelegate;
import org.eclipse.ui.IViewPart;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.ide.ResourceUtil;
import org.eclipse.ui.texteditor.AbstractTextEditor;
import org.eclipse.ui.texteditor.MarkerUtilities;
import org.unicase.codetrace.tracer.TracerFactory;
import org.unicase.codetrace.tracer.TracerLocation;
import org.unicase.codetrace.ui.TaskLocationLoader;


public class TestRetrieve implements IEditorActionDelegate  {

	private IEditorPart editorPart = null; 

	/**
	 * @see IActionDelegate#run(IAction)
	 */
	public void run(IAction action) {
		TracerLocation tl = NewAction.TEST_LOCATION;

		
		if (tl == null){
			System.out.println("No location yet!");
			return;
		}
		IWorkbenchPage page = editorPart.getSite().getPage();
		System.out.println(tl.getProjectName() + ":" + tl.getPathInProject());
		IFile f = ResourcesPlugin.getWorkspace().getRoot().getProject(tl.getProjectName()).getFile(tl.getPathInProject());
		if(f == null){
			System.out.println("File not found");
			return;
		}
		TaskLocationLoader.openTaskLocation(f, tl.getLine(), page);
		System.out.println("RETRIEVE!");
		
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
		System.out.println("bla2");	
	}

	public void setActiveEditor(IAction action, IEditorPart targetEditor) {
		this.editorPart = targetEditor;
		
		// TODO Auto-generated method stub
		System.out.println("bla3");
	
		
		//((TextEditor)targetEditor).getDocumentProvider().getDocument(null);
	}

}
