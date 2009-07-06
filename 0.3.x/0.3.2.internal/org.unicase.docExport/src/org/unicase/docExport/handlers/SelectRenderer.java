package org.unicase.docExport.handlers;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.IHandler;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.handlers.HandlerUtil;
import org.unicase.docExport.exportModel.Template;
import org.unicase.docExport.exportModel.renderers.ModelElementRenderer;
import org.unicase.docExport.exportModel.renderers.ModelElementRendererMapping;
import org.unicase.docExport.views.TemplatesView;

/**
 * 
 * @author Sebastian Höcht
 *
 */
public class SelectRenderer extends AbstractHandler implements IHandler {

	/**
	 * {@inheritDoc}
	 */
	public Object execute(ExecutionEvent event) throws ExecutionException {
		

		IWorkbenchWindow window = HandlerUtil.getActiveWorkbenchWindow(event);
		IWorkbenchPage page = window.getActivePage();
		
		TemplatesView view = (TemplatesView) page.findView(TemplatesView.ID);

		ISelection sel = view.getSite().getSelectionProvider().getSelection();
		if (!(sel instanceof IStructuredSelection)) {
			return null;
		}

		IStructuredSelection ssel = (IStructuredSelection) sel;
		if (ssel.isEmpty()) {
			return null;
		}

		Object o = ssel.getFirstElement();
		if (!(o instanceof ModelElementRendererMapping)) {
			return null;
		}		
		
		ModelElementRenderer renderer = ((ModelElementRendererMapping) o).getRenderer();
		Template template = ((Template)renderer.eContainer().eContainer());
		
		SelectRendererDialog dialog = new SelectRendererDialog(page.getActivePart().getSite().getShell(), template);
		dialog.setPropertyEClass(((ModelElementRendererMapping) o).getEClassName());
		dialog.open();
		
		
		return null;
	}
	

}
