package org.unicase.ui.tom.commands;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.IHandler;
import org.eclipse.emf.common.ui.URIEditorInput;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.WorkbenchException;
import org.eclipse.ui.handlers.HandlerUtil;
import org.unicase.model.diagram.MEDiagram;

public class NewTOMWindowHandler extends AbstractHandler implements IHandler{

    public Object execute(ExecutionEvent event) throws ExecutionException {
	
	ISelection selection = HandlerUtil.getCurrentSelection(event);
	if(selection != null && selection instanceof IStructuredSelection)
	{
		Object firstElement = ((IStructuredSelection) selection).getFirstElement();
		if(firstElement instanceof MEDiagram){
			MEDiagram meDiagram = (MEDiagram) firstElement;

			URI uri = EcoreUtil.getURI(meDiagram);
			uri.appendFragment(meDiagram.eResource().getURIFragment(meDiagram));

			URIEditorInput input = new URIEditorInput(uri);

			try {

				IWorkbenchWindow window = PlatformUI.getWorkbench().
				openWorkbenchWindow("org.unicase.ui.touchtable.perspectives.MultitouchPerspective", input);

				window.getActivePage().
				openEditor(input, "org.unicase.model.multiTouchClassDiagram.part.ModelDiagramEditorID", true);


			} catch (PartInitException e) {
				e.printStackTrace();
			} catch (WorkbenchException e) {
				e.printStackTrace();
			}
		}else {
			throw new ExecutionException("Invalid selection");
		}
	}
	return null;
    }

}
