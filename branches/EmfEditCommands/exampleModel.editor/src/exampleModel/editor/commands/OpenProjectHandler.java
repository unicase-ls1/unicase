package exampleModel.editor.commands;

import library.Library;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.emf.common.ui.URIEditorInput;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.handlers.HandlerUtil;
import org.eclipse.ui.part.EditorInputTransfer;
import org.unicase.metamodel.Project;
import org.unicase.workspace.ProjectSpace;


public class OpenProjectHandler extends AbstractHandler {



	public Object execute(ExecutionEvent event) throws ExecutionException {
		URI uri = null;
		EObject element = OpenProjectHandler.getSelection(event);
		if(element instanceof ProjectSpace){
			Project project = ((ProjectSpace) element).getProject();
			uri = EcoreUtil.getURI(element);
		
		 
		try {
			PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().openEditor(new EditorInput(uri,project),
				"library.presentation.LibraryEditorID", true);
		} catch (PartInitException e) {
			// JH Auto-generated catch block
			e.printStackTrace();
		}
		}
		return null;
	}

	public static EObject getSelection(ExecutionEvent event) {
		EObject result = null;
		ISelection sel = HandlerUtil.getCurrentSelection(event);
		if (!(sel instanceof IStructuredSelection)) {
			return null;
		}
		IStructuredSelection ssel = (IStructuredSelection) sel;
		if (ssel.isEmpty()) {
			return null;
		}

		Object obj = ssel.getFirstElement();
		if (obj instanceof EObject) {
			result = (EObject) obj;
		}

		return result;
	}


}
