package org.unicase.ui.tom.handler;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.emf.common.ui.URIEditorInput;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.jface.dialogs.ErrorDialog;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.handlers.HandlerUtil;
import org.unicase.model.diagram.DiagramType;
import org.unicase.model.diagram.MEDiagram;

public class OpenDiagramEditorHandler extends AbstractHandler{

	public Object execute(ExecutionEvent event) throws ExecutionException {
		ISelection selection = HandlerUtil.getCurrentSelection(event);
		if(selection != null && selection instanceof IStructuredSelection)
		{
			Object firstElement = ((IStructuredSelection) selection).getFirstElement();
			if(firstElement instanceof MEDiagram){
				MEDiagram diagram = (MEDiagram) firstElement;

				String id = null;
				if (diagram.getType().equals(DiagramType.CLASS_DIAGRAM)) {
					id = "org.unicase.ui.tom.classDiagram.part.ModelDiagramEditorID";
				}

				if (id == null) {
					throw new RuntimeException("Unsupported diagram type");
				}
				URI uri = EcoreUtil.getURI(diagram);
				uri.appendFragment(diagram.eResource().getURIFragment(diagram));
				URIEditorInput input = new URIEditorInput(uri, diagram.getName());

				try {
					PlatformUI.getWorkbench().getActiveWorkbenchWindow()
					.getActivePage().openEditor(input, id, true);
				} catch (PartInitException e) {
					ErrorDialog.openError(PlatformUI.getWorkbench()
							.getActiveWorkbenchWindow().getShell(), "Error", e
							.getMessage(), e.getStatus());
				}
			}
		}

		return null;
	}


}
