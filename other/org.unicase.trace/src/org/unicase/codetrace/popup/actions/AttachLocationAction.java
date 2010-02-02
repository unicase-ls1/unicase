package org.unicase.codetrace.popup.actions;

import java.util.HashMap;

import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.text.ITextSelection;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.ui.IActionDelegate;
import org.eclipse.ui.IEditorActionDelegate;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IViewPart;
import org.eclipse.ui.ide.ResourceUtil;
import org.eclipse.ui.texteditor.AbstractTextEditor;
import org.eclipse.ui.texteditor.MarkerUtilities;
import org.unicase.codetrace.AttachLocationCommand;
import org.unicase.codetrace.tracer.LocationFinder;
import org.unicase.codetrace.ui.AttachCodeLocation;
import org.unicase.metamodel.Project;
import org.unicase.model.UnicaseModelElement;
import org.unicase.model.trace.CodeLocation;
import org.unicase.workspace.CompositeOperationHandle;
import org.unicase.workspace.ProjectSpace;
import org.unicase.workspace.WorkspaceManager;
import org.unicase.workspace.exceptions.InvalidHandleException;
import org.unicase.workspace.util.WorkspaceUtil;

/**
 * This action is executed when the user presses create code location in the context menu.
 * It creates a code location at the specified line and file and opens a dialog
 * to choose a model element to attach the code location to.
 * @author kterzieva
 * @author snogina
 * @author jfinis
 * 
 *
 */
public class AttachLocationAction implements IEditorActionDelegate {

	private IEditorPart editorPart = null;

	public static CodeLocation TEST_LOCATION;

	/**
	 * @see IActionDelegate#run(IAction)
	 */
	public void run(IAction action) {

		IEditorInput editorInput = editorPart.getEditorInput();
		ISelection selection = ((AbstractTextEditor) editorPart)
				.getSelectionProvider().getSelection();

		IResource resource = ResourceUtil.getResource(editorInput);
		int lineNumber = ((ITextSelection) selection).getStartLine();

		//HashMap attributes = new HashMap();

		//MarkerUtilities.setLineNumber(attributes, lineNumber + 1);

		LocationFinder tf = LocationFinder.getInstance();

		
		UnicaseModelElement m = AttachCodeLocation.showUserDialog();
		
		CodeLocation tl = tf.createLocation(resource.getProject().getName(),
				resource.getProjectRelativePath().toString(), lineNumber + 1);
		
		new AttachLocationCommand(m,tl).run();
		/*try {
			WorkspaceManager.getInstance();
			final ProjectSpace projectSpace = WorkspaceManager
					.getProjectSpace(p);

			// Begin composite operation
			CompositeOperationHandle operationHandle = projectSpace
					.beginCompositeOperation();


			CodeLocation tl = tf.createLocation(resource.getProject().getName(),
					resource.getProjectRelativePath().toString(), lineNumber + 1);

			TEST_LOCATION = tl;

			p.addModelElement(tl);

			try {
				operationHandle.end("Created code location",
						"Created a code location.", tl.getModelElementId());
			} catch (InvalidHandleException e) {
				WorkspaceUtil.logException("Composite Operation failed!", e);
			}
			System.out.println("ADDE!");
			try {
				MarkerUtilities.createMarker(resource, attributes,
						"org.unicase.taskmarker");
			} catch (CoreException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} catch (Throwable t) {
			t.printStackTrace();
		}*/

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

		// ((TextEditor)targetEditor).getDocumentProvider().getDocument(null);
	}

}
